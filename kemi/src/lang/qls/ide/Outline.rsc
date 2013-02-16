@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::ide::Outline

import lang::qls::ast::AST;
import List;
import Node;
import ParseTree;
import util::IDE;

// The root note of the stylesheet
public node outlineStylesheet(Stylesheet sh) = 
  "outline"(outline(sh))
  [@label="Stylesheet"]
  [@\loc=sh@location];

// Helper function to create nodes with appropriate annotations and members.
private node createNode(str name, str label, loc location,
    list[node] children) =
  setAnnotations(makeNode(name, children), ("label": label, "loc": location));

// Below are functions to rewrite the Tree to a tree of Nodes for the outliner
private node outline(Stylesheet s) =
  createNode(
    "Stylesheet",
    "stylesheet <s.ident>",
    s@location,
    [outline(st) | st <- s.definitions]
  );

private node outline(Definition d: pageDefinition(ident, rules)) =
  createNode(
    "PageDefinition",
    "page <ident> (<size(rules)>)",
    d@location,
    [outline(r) | r <- rules]
  );

private node outline(Definition d: sectionDefinition(ident, rules)) =
  createNode(
    "SectionDefinition",
    "section <ident> (<size(rules)>)",
    d@location,
    [outline(r) | r <- rules]
  );

private node outline(Definition d: questionDefinition(ident)) =
  createNode(
    "QuestionDefinition",
    "question <ident>",
    d@location,
    []
  );

private node outline(Definition d: questionDefinition(ident, rules)) = 
  createNode(
    "QuestionDefinition",
    "question <ident> (<size(rules)>)",
    d@location,
    [outline(r) | r <- rules]
  );

private node outline(Definition d: defaultDefinition(\type, rules)) =
  createNode(
    "DefaultDefinition",
    "default <\type.name> (<size(rules)>)",
    d@location,
    [outline(r) | r <- rules]
  );

private node outline(LayoutRule r: layoutRule(definition)) =
  outline(definition);

private node outline(StyleRule r: widgetStyleRule(attr, \value)) =
  createNode(
    "WidgetStyleRule",
    "<attr.name> <\value.name>",
    r@location,
    []
  );

private node outline(StyleRule r: intStyleRule(attr, \value)) =
  createNode(
    "IntStyleRule",
    "<attr.name> <\value>",
    r@location,
    []
  );

private node outline(StyleRule r: stringStyleRule(attr, \value)) =
  createNode(
    "StringStyleRule",
    "<attr.name> <\value>",
    r@location,
    []
  );

private node outline(StyleRule r: colorStyleRule(attr, \value)) =
  createNode(
    "ColorStyleRule",
    "<attr.name> <\value>",
    r@location,
    []
  );
