module lang::qls::analysis::WidgetTypeChecker

import IO;
import util::IDE;

import lang::ql::ast::AST;
import lang::qls::analysis::SemanticChecker;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

import lang::qls::util::ParseHelper;

private map[Type, list[str]] allowedWidgets = (
  booleanType("boolean"):
    ["radio", "checkbox", "select"],
  integerType("integer"):
    ["text", "number", "slider"],
  moneyType("money"):
    ["text", "number", "slider"],
  dateType("date"):
    ["text", "datepicker"],
  stringType("string"):
    ["text"]
);

private bool isAllowedWidget(Type \type, str widget) =
  widget in allowedWidgets[\type];

public set[Message] unallowedWidgetErrors(Stylesheet s) =
  unallowedDefaultWidgetErrors(s) +
  unallowedQuestionWidgetErrors(s);

private set[Message] unallowedDefaultWidgetErrors(Stylesheet s) {
  errors = {};
  for(d <- getDefaultDefinitions(s)) {
    for(r:widgetStyleRule(_, widget) <- d.styleRules) {
      if(!isAllowedWidget(d.ident, widget.name))
        errors += error(
          "Widget <widget.name> not allowed for type <d.ident.name>",
          r@location
        );
    }
  }
  return errors;
}

private set[Message] unallowedQuestionWidgetErrors(Stylesheet s) {
  errors = {};
  typeMap = getTypeMap(getAccompanyingForm(s));
  for(d <- getQuestionDefinitions(s)) {
    if(!d.styleRules? || identDefinition(d.ident) notin typeMap)
      continue;

    \type = typeMap[identDefinition(d.ident)];
    for(r:widgetStyleRule(_, widget) <- d.styleRules) {
      if(!isAllowedWidget(\type, widget.name))
        errors += error(
          "Widget <widget.name> not allowed for type <\type.name>",
          r@location
        );
    }
  }
  return errors;
}
