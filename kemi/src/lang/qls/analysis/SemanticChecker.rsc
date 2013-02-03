module lang::qls::analysis::SemanticChecker

import Set;
import String;
import util::IDE;

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;


public set[Message] semanticChecker(Stylesheet s) = {};/*
  undefinedClassWarnings(s) +
  unusedClassWarnings(s);*/

public set[Message] undefinedClassWarnings(Stylesheet s) {
  warnings = {};
  visit(s) {
    case d:styleDefinition(StyleIdent: classStyleIdent(ident), _):
      // Class definitions' identifiers start without a dot
      if(!isDefinedClass(substring(ident, 1, size(ident)), s))
        warnings += warning("Undefined class <ident>", d@location);
  }
  return warnings;
}

public set[Message] unusedClassWarnings(Stylesheet s) {
  warnings = {};
  visit(s) {
    case d:classDefinition(str ident, _):
      // Class style definitions' identifiers start with a dot
      if(!isUsedClass(".<ident>", s))
        warnings += warning("Unused class <ident>", d@location);
  }
  return warnings;
}

private bool isDefinedClass(str ident, Stylesheet s) {
  visit(s) {
    case classDefinition(ident, _):
      return true;
  }
  return false;
}

private bool isUsedClass(str ident, Stylesheet s) {
  visit(s) {
    case styleDefinition(StyleIdent: classStyleIdent(ident), _):
      return true;
  }
  return false;
}
