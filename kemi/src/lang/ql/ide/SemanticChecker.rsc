module lang::ql::ide::SemanticChecker

import List;
import Map;
import Node;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import util::IDE;

import IO;
import util::ValueUI;

alias identInfo = tuple[loc \loc, str \type];
alias labelMap = map[str ident, list[identInfo] identInfo];


/*
  - Basic type checking for integer, string and boolean expressions. 
    -> dingen als integer + string expressions mogen niet.
  
  - Check cyclic dependencies, 
    -> niet een variabele referencen in een expression voordat die is gedeclareerd.
  

  - Check for undefined variables used in expressions.  
    -> declrataion voor expression usage.

  - Check for duplicate questions with different types, 
    -> Een duplicate question is een copy van de string? En dan is dus  "A" boolean aBool en "A" integer anInt een duplicate
 
  - Provide warnings for duplicate labels. 
  - Check for computed and answerable questions that bind the same variable. 
    -> laat een variable declaration maar een keer toe. [1]
  */
  

public void main() {
  x = implode(parse(readFile(|project://QL-R-kemi/forms/calculatedField.q|), |file:///-|));
  println("Parsing done: <x>");
  text(semanticChecker(x));
}

public set[Message] semanticChecker(node form) { 
  set[Message] ret = {};
  
  labelMap identifierMapDuplicates = ();
  labelMap identifierMap = ();
  map[str text, list[loc] \loc] textMap = ();

  // Needed, see issue 32: https://github.com/cwi-swat/rascal/issues/32
  list[identInfo] init = [];
  list[loc] qinit = [];
  
  top-down visit(form) {
    case q:question(text, \type, ident): {
      identifierMapDuplicates[ident]?init += [<q@location, \type>];
      identifierMap[ident]?init += [<q@location, \type>];
      textMap[text]?qinit += [q@location];
    }
    
    case q:question(text, \type, ident, calculated): {
      identifierMapDuplicates[ident]?init += [<q@location, \type>];
      identifierMap[ident]?init += [<q@location, \type>];
      textMap[text]?qinit += [q@location];

      for(/ident(name) <- calculated)
        identifierMap[name]?init += [<calculated@location, "">];
    }

    case e:conditional(Expr condition, _): {
      for(/ident(name) <- condition)
        identifierMap[name]?init += [<condition@location, "">];
    }
  }
  
  identifierMapDuplicates = (key : identifierMapDuplicates[key] | key <- identifierMapDuplicates, size(identifierMapDuplicates[key]) > 1);
  identifierMapDuplicatesRel = { < x, d> | d <- identifierMapDuplicates, x <- identifierMapDuplicates[d] };
  ret += {duplicateIdentifierMessage(name, \type, \loc) | <<\loc, \type>, name> <- identifierMapDuplicatesRel};
    
  textMap = (key : textMap[key] | key <- textMap, size(textMap[key]) > 1);
  textMapRel = { < x, d> | d <- textMap, x <- textMap[d] };
  ret += {duplicateQuestionMessage(text, \loc) | <\loc, text> <- textMapRel};  

  ids = [ <\loc, name, \type> | name <- identifierMap, ii <- identifierMap[name], <\loc, \type> := ii];
  ids = sort(ids, sortTypeTuple); 
                     
  set[str] declared = {};
  
  for(x <- ids, <\loc, name, \type> := x) {
    if(\type == "") {
      if(name notin declared) {
        ret += useBeforeDeclaration(name, \loc);
      }
    } else {
      declared += {name};
    }
  }
  
  return ret;
}

private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);

/*
 * This is a comparator for sort() so a list of given tuples is sorted on line number 
 */
private bool sortTypeTuple(
  tuple[loc loca, str namea, str typea] a, 
  tuple[loc locb, str nameb, str typeb] b) {
    return a.loca.begin.line <= b.locb.begin.line;
}