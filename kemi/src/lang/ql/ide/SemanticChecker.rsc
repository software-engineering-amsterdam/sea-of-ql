module lang::ql::ide::SemanticChecker

import List;
import Map;
import Node;
import ParseTree;
import Set;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::IdentifierUsesDefinitions;
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
  //f = |project://QL-R-kemi/forms/ifCondition.q|;
  //f = |project://QL-R-kemi/forms/duplicateLabels.q|;
  //f = |project://QL-R-kemi/forms/undefinedVariable.q|;
  f = |project://QL-R-kemi/forms/undefinedVariable.q|;

  x = implode(parse(readFile(f), |file:///-|));
  println("Parsing done: <x>");
  sx = semanticChecker(x);
  iprintln(sx);
}


public set[Message] semanticChecker(node form) {
  set[Message] ret = {};
  us = identifierUses(form);
  def = identifierDefinitions(form);
  ret += duplicateIdentifierMessages(def);
  ret += duplicateQuestionMessages(form);
  ret += useBeforeDeclarationMessages(us, def);
  return ret;
}

// TODO: This does not take control flow into account!
private set[Message] useBeforeDeclarationMessages(set[Occurrence] us, set[Occurrence] defs) {
  ids = sort(toList(us + defs), sortOccurrences);
  set[Message] ret = {};
  
  set[str] declared = {};
  
  for(x <- ids, <\loc, \type, ident(name)> := x) {
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

private set[Message] duplicateIdentifierMessages(set[Occurrence] defs) {
  map[Expr id, set[Occurence] occurences] ids;
  
  ids = toMap( { <key, \value> | \value <- defs, <_, _, key> := \value } );
  ids = (key : ids[key] | key <- ids, size(ids[key]) > 1);
  
  idsRel = { < x, d> | d <- ids, x <- ids[d] };
  return 
    {duplicateIdentifierMessage(name, \type, \loc) | <<\loc, \type, _>, ident(name)> <- idsRel};
}

private set[Message] duplicateQuestionMessages(Form form) { 
  map[str text, list[loc] \loc] textMap = ();

  // Needed, see issue 32: https://github.com/cwi-swat/rascal/issues/32
  list[loc] qinit = [];
  
  top-down visit(form) {
    case q:question(text, \type, ident): textMap[text]?qinit += [q@location];
    case q:question(text, \type, ident, calculated): textMap[text]?qinit += [q@location];
  }
  
  textMap = (key : textMap[key] | key <- textMap, size(textMap[key]) > 1);
  textMapRel = { < x, d> | d <- textMap, x <- textMap[d] };
  return {duplicateQuestionMessage(text, \loc) | <\loc, text> <- textMapRel};  
}

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: \"<text>\"", \loc);
  
private Message useBeforeDeclaration(name, \loc) 
  = error("Undeclared: \"<name>\" is used before a declaration", \loc);
  
private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: \"<\type> <name>\"", \loc);

private bool sortOccurrences(
  tuple[loc loca, str \type, Expr ident] a, 
  tuple[loc locb, str \type, Expr ident] b) {
    return a.loca.begin.line <= b.locb.begin.line;
}
