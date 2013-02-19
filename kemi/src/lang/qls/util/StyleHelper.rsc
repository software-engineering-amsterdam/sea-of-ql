@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::util::StyleHelper

import IO;
import lang::ql::analysis::SemanticChecker;
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import lang::ql::util::ParseHelper;
import lang::qls::\ast::AST;
import lang::qls::util::ParseHelper;
import util::StringHelper;
import List;
import Map;
import String;

private str formExt = ".q";

public TypeMap getTypeMap(Form f) =
  semanticAnalysisState(f).definitions;

public Form getAccompanyingForm(Stylesheet s) =
  parseForm(getAccompanyingFormLocation(s))
    when isFile(getAccompanyingFormLocation(s));

// Return a stub when no accompanying form is found.
public default Form getAccompanyingForm(Stylesheet s) =
  form(identDefinition(""), []);

public loc getAccompanyingFormLocation(Stylesheet s) =
  s@location.parent + "<s.ident.name><formExt>";

public list[StyleRule] getStyleRules(str questionIdent, Form f, Stylesheet s) {
  TypeMap typeMap = getTypeMap(f);
  Type \type = typeMap[identDefinition(questionIdent)];
  list[Definition] defs = getDefinitions(questionIdent, s);

  list[StyleRule] rules =
    getStyleRules(\type, s.definitions) + 
    [
      *getStyleRules(\type, toDefinitionList(d.layoutRules)) |
      Definition d <- defs,
      d is pageDefinition || d is sectionDefinition
    ] +
    [*r | Definition d: questionDefinition(_, r) <- defs]; 
  
  return deDupeStyleRules(rules);
}

private list[StyleRule] getStyleRules(Type \type, list[Definition] defs) =
  [*d.styleRules | Definition d: defaultDefinition(\type, _) <- defs];

private list[Definition] getDefinitions(str questionIdent, Stylesheet s) =
  getDefinitions(questionIdent, s.definitions);

private list[Definition] getDefinitions(str qid, list[Definition] definitions) {
  for(d <- definitions) {
    if(d is pageDefinition || d is sectionDefinition) {
      defs = getDefinitions(qid, toDefinitionList(d.layoutRules));
      if(size(defs) > 0)
        return d + defs;
    } else if(d is questionDefinition && d.ident.name == qid) {
      return [d];
    }
  }
  
  // Question not found at all
  return [];
}

/*
 * The later an element occurs in the list, the higher its importance (e.g. 
 * more specific binding).
 */ 
public list[StyleRule] deDupeStyleRules(list[StyleRule] styleRules) {
  map[StyleAttr, StyleRule] rules = (r.attr : r | r <- styleRules);
  return [rules[key] | key <- rules];
}

public list[Definition] toDefinitionList(list[LayoutRule] rules) =
  [r.definition | r <- rules];

public list[Definition] getPageDefinitions(Stylesheet s) =
  [d | Definition d <- s.definitions, d is pageDefinition];

public list[Definition] getSectionDefinitions(Stylesheet s) =
  [d | /Definition d <- s, d is sectionDefinition];

public list[Definition] getChildSectionDefinitions(Stylesheet s) =
  [d | Definition d <- s.definitions, d is sectionDefinition];

public list[Definition] getChildSectionDefinitions(Definition d) =
  [s | Definition s <- toDefinitionList(d.layoutRules), s is sectionDefinition]
    when d is pageDefinition || d is sectionDefinition;

public list[Definition] getQuestionDefinitions(Stylesheet s) =
  [d | /Definition d <- s, d is questionDefinition];

public list[Definition] getChildQuestionDefinitions(Stylesheet s) =
  [d | Definition d <- s.definitions, d is questionDefinition];

public list[Definition] getChildQuestionDefinitions(Definition d) =
  [q | Definition q <- toDefinitionList(d.layoutRules), q is questionDefinition]
    when d is pageDefinition || d is sectionDefinition;

public list[Definition] getChildSectionsQuestions(Definition d) =
  [
    q |
    Definition q <- toDefinitionList(d.layoutRules),
    q is sectionDefinition || q is questionDefinition
  ]; 

public list[Definition] getDefaultDefinitions(Stylesheet s) =
  [d | /Definition d <- s, d is defaultDefinition];

public rel[Type, Definition] getDefaultsPerType(list[Definition] defaults) =
  {<d.\type, d> | d <- defaults};

public list[StyleRule] getStyleRules(Stylesheet s) =
  [r | /StyleRule r <- s];
