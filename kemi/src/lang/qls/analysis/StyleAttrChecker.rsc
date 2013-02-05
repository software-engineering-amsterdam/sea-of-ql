module lang::qls::analysis::StyleAttrChecker

import util::IDE;

import lang::ql::ast::AST;
import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

private map[Type, list[str]] allowedAttrs = (
  booleanType("boolean"):
    ["type"],
  integerType("integer"):
    ["type", "width"],
  moneyType("money"):
    ["type", "width"],
  dateType("date"):
    ["width"],
  stringType("string"):
    ["type", "width"]
);

private bool isAllowedAttr(Type \type, str attr) =
  attr in allowedAttrs[\type];

public set[Message] unallowedAttrErrors(Stylesheet s) =
  unallowedDefaultAttrErrors(s) +
  unallowedQuestionAttrErrors(s);

private set[Message] unallowedDefaultAttrErrors(Stylesheet s) {
  errors = {};
  for(d <- getDefaultDefinitions(s)) {
    for(r <- d.styleRules) {
      if(!isAllowedAttr(d.ident, r.attr))
        errors += error(
          "Attr <r.attr> not allowed for type <d.ident.name>",
          r@location
        );
    }
  }
  return errors;
}

private set[Message] unallowedQuestionAttrErrors(Stylesheet s) {
  errors = {};
  typeMap = getTypeMap(accompanyingForm(s));
  for(d <- getQuestionDefinitions(s)) {
    if(!d.styleRules?)
      continue;

    \type = typeMap[identDefinition(d.ident)];
    for(r <- d.styleRules) {
      if(!isAllowedAttr(\type, r.attr))
        errors += error(
          "Attr <r.attr> not allowed for type <\type.name>",
          r@location
        );
    }
  }
  return errors;
}
