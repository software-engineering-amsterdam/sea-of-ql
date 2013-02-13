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

import List;
import Node;
import ParseTree;
import util::IDE;

import lang::qls::ast::AST;

// The root note of the stylesheet
public node outlineStylesheet(Stylesheet sh) = 
  "outline"(outline(sh))
  [@label="Stylesheet"]
  [@\loc=sh@location];

// Helper function to create nodes with appropriate annotations and members.
private node createNode(str name, str label, loc location, list[node] children) =
  setAnnotations(makeNode(name, children), ("label": label, "loc": location));


// Below this are functions to rewrite the Tree to a tree of Nodes for the outliner

private node outline(Stylesheet s) =
  createNode(
    "Stylesheet",
    "stylesheet <s.ident>",
    s@location,
    [outline(st) | st <- s.definitions]
  );

private node outline(Definition s:
  definition(definition)) =
    outline(definition);

private node outline(PageDefinition d) =
    createNode(
      "PageDefinition",
      "page <d.ident> (<size(d.pageRules)>)",
      d@location,
      [outline(r) | r <- d.pageRules]
    );

private node outline(SectionDefinition d) = 
  createNode(
    "SectionDefinition",
    "section <d.ident> (<size(d.sectionRules)>)",
    d@location,
    [outline(r) | r <- d.sectionRules]
  );

private node outline(QuestionDefinition d:
  questionDefinition(ident)) =
    createNode(
      "QuestionDefinition",
      "question <ident>",
      d@location,
      []
    );

private node outline(QuestionDefinition d:
  questionDefinition(ident, styleRules)) = 
    createNode(
      "QuestionDefinition",
      "question <ident> (<size(styleRules)>)",
      d@location,
      [outline(r) | r <- styleRules]
    );

private node outline(DefaultDefinition d) =
    createNode(
      "DefaultDefinition",
      "default <d.ident.name> (<size(d.styleRules)>)",
      d@location,
      [outline(r) | r <- d.styleRules]
    );

private node outline(PageRule r:
  pageRule(definition)) =
    outline(definition);

private node outline(SectionRule r:
  sectionRule(definition)) =
    outline(definition);

private node outline(StyleRule r: 
  widgetStyleRule(attr, \value)) =
    createNode(
      "StyleRule",
      "<attr.name> <\value.name>",
      r@location,
      []
    );

private node outline(StyleRule r: 
  widthStyleRule(attr, \value)) =
    createNode(
      "StyleRule",
      "<attr.name> <\value>",
      r@location,
      []
    );
