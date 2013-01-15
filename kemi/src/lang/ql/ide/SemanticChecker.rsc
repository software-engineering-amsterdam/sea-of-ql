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
  x = implode(parse(readFile(|project://QL-R-kemi/forms/duplicateQuestions.q|), |file:///-|));
  println("Parsing done: <x>");
  text(duplicateElements(x));
}

public set[Message] semanticChecker(node input) { 
  set[Message] ret = {};
  ret += duplicateElements(input);
  return ret;
}

private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: <name>::<\type>", \loc);

private Message duplicateQuestionMessage(text, \loc) 
  = error("Duplicate question: <text>", \loc);
  
alias identInfo = tuple[loc \loc, str \type];
alias labelMap = map[str ident, list[identInfo] identInfo];

public set[Message] duplicateElements(Form form) {
  labelMap labelMap = ();
  map[str text, list[loc] \loc] textMap = ();

  // Needed, see issue 32: https://github.com/cwi-swat/rascal/issues/32
  list[identInfo] iinit = [];
  list[loc] qinit = [];
  
  top-down visit(form) {
    case q:question(text, \type, ident): {
      labelMap[ident]?iinit += [<q@location, \type>];
      textMap[text]?qinit += [q@location];
    }
    case q:question(text, \type, ident, _): {
      labelMap[ident]?iinit += [<q@location, \type>];
      textMap[text]?qinit += [q@location];
    }
  }

  labelMap = (key : labelMap[key] | key <- labelMap, size(labelMap[key]) > 1);
  
  labelMapRel = { < x, d> | d <- labelMap, x <- labelMap[d] };
  
  textMap = (key : textMap[key] | key <- textMap, size(textMap[key]) > 1);
  
  textMapRel = { < x, d> | d <- textMap, x <- textMap[d] };
  
  return 
    {duplicateIdentifierMessage(name, \type, \loc) | <<\loc, \type>, name> <- labelMapRel} +
    {duplicateQuestionMessage(text, \loc) | <\loc, text> <- textMapRel};
}
