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

import lang::qls::\ast::AST;
import lang::qls::util::StyleHelper;
import List;
import Node;
import ParseTree;
import Set;
import util::IDE;

// Helper function to create nodes with appropriate annotations and members.
private node createNode(str name, str label, loc location,
    list[node] children) =
  setAnnotations(makeNode(name, children), ("label": label, "loc": location));

// Return location of the first definition or a default value
private loc getFirstLocOrDefault(list[&T] definitions, loc \default) =
  definitions[0]? ? definitions[0]@location : \default;

// The root note of the stylesheet
public node outlineStylesheet(Stylesheet s) = 
  createNode(
    "outline",
    "Stylesheet",
    s@location,
    [
      outlinePages(getPageDefinitions(s), s@location),
      outlineSections(getSectionDefinitions(s), s@location),
      outlineQuestions(getQuestionDefinitions(s), s@location),
      outlineDefaults(getDefaultDefinitions(s), s@location),
      outlineStyleRules(getStyleRules(s), s@location)
    ]
  );

private node outlinePages(list[Definition] pages, loc rootLoc) =
  createNode(
    "Pages",
    "Pages (<size(pages)>)",
    getFirstLocOrDefault(pages, rootLoc),
    [outline(p) | p <- pages]
  );

private node outlineSections(list[Definition] sections, loc rootLoc) =
  createNode(
    "Sections",
    "Sections (<size(sections)>)",
    getFirstLocOrDefault(sections, rootLoc),
    [outline(s) | s <- sections]
  );

private node outlineQuestions(list[Definition] questions, loc rootLoc) =
  createNode(
    "Questions",
    "Questions (<size(questions)>)",
    getFirstLocOrDefault(questions, rootLoc),
    [outline(q) | q <- questions]
  );

private node outlineDefaults(list[Definition] defaults, loc rootLoc) =
  createNode(
    "Defaults",
    "Defaults (<size(defaults)>)",
    getFirstLocOrDefault(defaults, rootLoc),
    [
      outline(k, types[k]) |
      types := getDefaultsPerType(defaults),
      k <- toMap(types)
    ]
  );

private node outline(Type \type, set[Definition] definitions) =
  createNode(
    "<\type.name>",
    "<\type.name> (<size(definitions)>)",
    getOneFrom(definitions)@location,
    [outline(d) | d <- definitions]
  );

private node outlineStyleRules(list[StyleRule] styleRules, loc rootLoc) =
  createNode(
    "StyleRules",
    "StyleRules (<size(styleRules)>)",
    getFirstLocOrDefault(styleRules, rootLoc),
    [outline(r) | r <- styleRules]
  );

private node outline(Definition d: pageDefinition(ident, rules)) =
  createNode(
    "PageDefinition",
    "page <ident> (<size(rules)>)",
    d@location,
    []
  );

private node outline(Definition d: sectionDefinition(ident, rules)) =
  createNode(
    "SectionDefinition",
    "section <ident> (<size(rules)>)",
    d@location,
    []
  );

private node outline(Definition d: questionDefinition(ident)) =
  createNode(
    "QuestionDefinition",
    "question <ident.name>",
    d@location,
    []
  );

private node outline(Definition d: questionDefinition(ident, rules)) = 
  createNode(
    "QuestionDefinition",
    "question <ident.name>",
    d@location,
    []
  );

private node outline(Definition d: defaultDefinition(\type, rules)) =
  createNode(
    "DefaultDefinition",
    "default <\type.name>",
    d@location,
    []
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
