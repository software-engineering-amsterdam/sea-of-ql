@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::compiler::PrettyPrinter

import lang::qls::\ast::AST;
import lang::qls::\ast::Keyword;

public str prettyPrint(Stylesheet s) =
  "stylesheet <prettyPrint(s.ident)> {<for(st <- s.definitions) {>
  '  <prettyPrint(st)><}>
  '}
  '";

public str prettyPrint(Definition d: pageDefinition(ident, rules)) =
  "page <ident> {<for(r <- rules) {>
  '  <prettyPrint(r)><}>
  '}
  '";

public str prettyPrint(Definition d: sectionDefinition(ident, rules)) =
  "section <ident> {<for(r <- rules) {>
  '  <prettyPrint(r)><}>
  '}
  '";

public str prettyPrint(Definition d: questionDefinition(ident)) =
  "question <prettyPrint(ident)>";

public str prettyPrint(Definition d: questionDefinition(ident, rules)) =
  "question <prettyPrint(ident)> {<for(r <- rules) {>
  '  <prettyPrint(r)><}>
  '}
  '";

public str prettyPrint(Definition d: defaultDefinition(\type, rules)) =
  "default <\type.name> {<for(r <- rules) {>
  '  <prettyPrint(r)><}>
  '}
  '";

public str prettyPrint(LayoutRule r: layoutRule(definition)) =
  prettyPrint(definition);

public str prettyPrint(StyleRule r: 
    widgetStyleRule(StyleAttr attr, WidgetStyleValue \value)) =
  "<attr.name> <\value.name>[<\value.min>, <\value.max>, <\value.step>]"
    when \value.step?;

public str prettyPrint(StyleRule r: 
    widgetStyleRule(StyleAttr attr, WidgetStyleValue \value)) =
  "<attr.name> <\value.name>[<\value.min>, <\value.max>]"
    when \value.min?;

public default str prettyPrint(StyleRule r: 
    widgetStyleRule(StyleAttr attr, WidgetStyleValue \value)) =
  "<attr.name> <\value.name>";

public str prettyPrint(StyleRule r: 
    intStyleRule(StyleAttr attr, int \value)) =
  "<attr.name> <\value>";

public str prettyPrint(StyleRule r: 
    stringStyleRule(StyleAttr attr, str \value)) =
  "<attr.name> <\value>";

public str prettyPrint(StyleRule r: 
    colorStyleRule(StyleAttr attr, str \value)) =
  "<attr.name> <\value>";

public default str prettyPrint(Ident ident) =
  ident.name;

public str prettyPrint(Ident ident) =
  "\\<ident.name>"
    when ident.name in keywords;
