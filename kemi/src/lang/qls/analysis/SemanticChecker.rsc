module lang::qls::analysis::SemanticChecker

import Set;
import String;
import util::IDE;

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;


public set[Message] semanticChecker(Stylesheet s) =
  undefinedClassErrors(s) +
  classRuleTypeErrors(s);

public set[Message] undefinedClassErrors(Stylesheet s) {
  errors = {};
  visit(s) {
    case d:classStyleDefinition(str ident, _):
      if(!isDefinedClass(substring(ident, 1, size(ident)), s))
        errors += error("Undefined class <ident>", d@location);
  }
  return errors;
}

public set[Message] classRuleTypeErrors(Stylesheet s) {
  return {};
}

private bool isDefinedClass(str ident, Stylesheet s) {
  visit(s) {
    case classDefinition(str className, _):
      if(className == ident)
        return true;
  }
  return false;
}
