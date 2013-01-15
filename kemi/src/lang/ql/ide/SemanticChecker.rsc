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
  - Check cyclic dependencies,
  - Check for duplicate questions with different types,
  - Check for computed and answerable questions that bind the same variable.
  - Check for undefined variables used in expressions.
  - Provide warnings for duplicate labels.
  */
  

public void main() {
  x = implode(parse(readFile(|project://QL-R-kemi/forms/duplicateLabels.q|), |file:///-|));
  println("Parsing done: <x>");
  duplicateLabels(x);
}

public set[Message] semanticChecker(node input) { 
  return duplicateLabels(input);
}





private Message duplicateIdentifierMessage(name, \type, \loc) 
  = error("Duplicate identifier: <name>::<\type>", \loc);

public set[Message] duplicateLabels(Form form) {
  labelMap labelMap = ();

  // Needed, see issue 32: https://github.com/cwi-swat/rascal/issues/32
  list[identInfo] init = [];
  
  top-down visit(form) {
    case q:question(_, \type, ident): labelMap[ident]?init += [<q@location, \type>];
    case q:question(_, \type, ident, _): labelMap[ident]?init += [<q@location, \type>];
  }

  labelMap = (key : labelMap[key] | key <- labelMap, size(labelMap[key]) > 1);
  
  labelMapRel = { < x, d> | d <- labelMap, x <- labelMap[d] };
  
  errors = {duplicateIdentifierMessage(name, \type, \loc) | <<\loc, \type>, name> <- labelMapRel};
  
  return errors;
}
