@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::analysis::WidgetTypeChecker

import IO;
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import lang::qls::analysis::Messages;
import lang::qls::\ast::AST;
import lang::qls::util::StyleHelper;
import util::IDE;
import util::Math;

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
  unallowedQuestionWidgetErrors(s) +
  unallowedDefaultIntegerRangeErrors(s) +
  unallowedQuestionIntegerRangeErrors(s);

private set[Message] unallowedDefaultWidgetErrors(Stylesheet s) = 
  {
    typeWithInvalidWidget(widget.name, d.\type.name, r@location) |
    d <- getDefaultDefinitions(s),
    r:widgetStyleRule(_, widget) <- d.styleRules,
    !isAllowedWidget(d.\type, widget.name)
  };

private set[Message] unallowedQuestionWidgetErrors(Stylesheet s) {
  TypeMap typeMap = getTypeMap(getAccompanyingForm(s));
  return 
    { 
      typeWithInvalidWidget(widget.name, \type.name, r@location) |
      d <- getQuestionDefinitions(s),
      d.styleRules?,
      identDefinition(d.ident) in typeMap,
      \type := typeMap[identDefinition(d.ident)],
      r:widgetStyleRule(_, widget) <- d.styleRules,
      !isAllowedWidget(\type, widget.name)
    };
}

private str INTEGER_IDENT_NAME = "integer";

private bool isInteger(num number) =
  round(number) == number;

private bool hasIntegerRange(WidgetStyleValue widget) =
  isInteger(widget.min) && isInteger(widget.max) && isInteger(widget.step)
    when widget.step?;

private default bool hasIntegerRange(WidgetStyleValue widget) =
  isInteger(widget.min) && isInteger(widget.max);

private set[Message] unallowedDefaultIntegerRangeErrors(Stylesheet s) = 
  {
    invalidRangeType(d.\type.name, r@location) |
    d <- getDefaultDefinitions(s),
    d.\type.name == INTEGER_IDENT_NAME,
    r:widgetStyleRule(_, widget) <- d.styleRules,
    widget.min?,
    !hasIntegerRange(widget)
  };

private set[Message] unallowedQuestionIntegerRangeErrors(Stylesheet s) {
  TypeMap typeMap = getTypeMap(getAccompanyingForm(s));
  return 
    { 
      invalidRangeType(\type.name, r@location) |
      d <- getQuestionDefinitions(s),
      d.styleRules?,
      identDefinition(d.ident) in typeMap,
      \type := typeMap[identDefinition(d.ident)],
      \type.name == INTEGER_IDENT_NAME,
      r:widgetStyleRule(_, widget) <- d.styleRules,
      widget.min?,
      !hasIntegerRange(widget)
    };
}
