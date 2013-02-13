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
import List;
import Map;
import String;
import lang::ql::analysis::SemanticChecker;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import lang::ql::util::ParseHelper;
import lang::qls::ast::AST;
import lang::qls::util::ParseHelper;
import util::StringHelper;

import util::ValueUI;

private loc FORM_LOC = |project://QL-R-kemi/forms/|;
private str FORM_EXT = ".q";

/* 
alias CachedTypeMap = tuple[Form form, TypeMap typeMap];
private CachedTypeMap cachedTypeMap = <form(identDefinition(""), []), ()>;

public TypeMap getTypeMap(Form f) {
  if(f != cachedTypeMap.form) {
    cachedTypeMap = <f, semanticAnalysisState(f).definitions>;
  }
  return cachedTypeMap.typeMap;
}
I still want to disable this caching cruft. Just leave it up to rascal.
This is way cleaner.
*/
public TypeMap getTypeMap(Form f) = semanticAnalysisState(f).definitions;

// Return a stub when no accompanying form is found.
public default Form getAccompanyingForm(Stylesheet s) =
  form(identDefinition(""), []);

public Form getAccompanyingForm(Stylesheet s) =
  parseForm(getAccompanyingFormLocation(s))
    when isFile(getAccompanyingFormLocation(s));

public loc getAccompanyingFormLocation(Stylesheet s) =
  FORM_LOC + "<s.ident><FORM_EXT>";

/* Note: getDefinitions() is problematic, see below */  
public list[StyleRule] getStyleRules(str questionIdent, Form f, Stylesheet s) {
  typeMap = getTypeMap(f);
  Type \type = typeMap[identDefinition(questionIdent)];
  defs = getDefinitions(questionIdent, s);

  list[StyleRule] rules = getStyleRules(\type, s.definitions) + 
  [*getStyleRules(\type, d.pageRules) | PageDefinition d <- defs] +
  [*getStyleRules(\type, d.sectionRules) | SectionDefinition d <- defs] +
  [*r | d <- defs, questionDefinition(_, r) := d]; 
  
  return deDupeStyleRules(rules);
}

/** Note: Problematic: list[node]. **/
/** Note:list[&T] can't be node, because member access is unsupported. **/
private list[StyleRule] getStyleRules(Type \type, list[&T] definitions) =
  [
    * d.defaultDefinition.styleRules |
    d <- definitions,
    d.defaultDefinition?,
    d.defaultDefinition.ident == \type
  ];

/** Note: Problematic: getDefinitions. **/
private list[node] getDefinitions(str questionIdent, Stylesheet s) =
  getDefinitions(questionIdent, s.definitions, [s]);

private list[node] getDefinitions(str qid, list[Definition] definitions, list[node] stack) {
  for(s <- definitions) {
    switch(s) {
      case definition(PageDefinition d): {
        defs = getDefinitions(qid, d.pageRules, stack + d);
        if(size(defs) > 0) return defs;
      }
      case definition(SectionDefinition d): {
        defs = getDefinitions(qid, d.sectionRules, stack + d);
        if(size(defs) > 0) return defs;
      }
      case definition(QuestionDefinition d:questionDefinition(qid)): return stack + d;
      case definition(QuestionDefinition d:questionDefinition(qid, _)): return stack + d;
    }
  }
  return [];
}

private list[node] getDefinitions(str qid, list[PageRule] pageRules, list[node] stack) {
  for(r <- pageRules) {
    switch(r) {
      case pageRule(SectionDefinition d): {
        defs = getDefinitions(qid, d.sectionRules, stack + d);
        if(size(defs) > 0) return defs;
      }
      case pageRule(QuestionDefinition d:questionDefinition(qid)): return stack + d;
      case pageRule(QuestionDefinition d:questionDefinition(qid, _)): return stack + d;
    }
  }
  return [];
}

private list[node] getDefinitions(str qid, list[SectionRule] sectionRules, list[node] stack) {
  for(r <- sectionRules) {
    switch(r) {
      case sectionRule(SectionDefinition d): {
        defs = getDefinitions(qid, d.sectionRules, stack + d);
        if(size(defs) > 0) return defs;
      }
      case sectionRule(QuestionDefinition d:questionDefinition(qid)): return stack + d;
      case sectionRule(QuestionDefinition d:questionDefinition(qid, _)): return stack + d;
    }
  }
  return [];
}
/** Todo: End of problematic getDefinitions stuff. **/

/*
 * The later an element occurs in the list, the higher it's 
 * importance (e.g. more specific binding).
 */ 
public list[StyleRule] deDupeStyleRules(list[StyleRule] styleRules) {
  map[str, StyleRule] rules = (r.attr : r | r <- styleRules);
  return [rules[key] | key <- rules];
}

public list[PageDefinition] getPageDefinitions(Stylesheet s) =
  [d | /PageDefinition d <- s];

public list[SectionDefinition] getSectionDefinitions(Stylesheet s) =
  [d | /SectionDefinition d <- s];

public list[SectionDefinition] getChildSectionDefinitions(Stylesheet s) =
  [r.sectionDefinition | r <- s.definitions, r.sectionDefinition?];

public list[SectionDefinition] getChildSectionDefinitions(PageDefinition p) =
  [r.sectionDefinition | r <- p.pageRules, r.sectionDefinition?];

public list[SectionDefinition] getChildSectionDefinitions(SectionDefinition s) =
  [r.sectionDefinition | r <- s.sectionRules, r.sectionDefinition?];

public list[QuestionDefinition] getQuestionDefinitions(Stylesheet s) =
  [d | /QuestionDefinition d <- s];

public list[PageDefinition] getPageDefinitions(Stylesheet s) =
  [d | /PageDefinition d <- s];

public list[SectionDefinition] getSectionDefinitions(Stylesheet s) =
  [d | /SectionDefinition d <- s];

public list[QuestionDefinition] getChildQuestionDefinitions(Stylesheet s) =
  [d.questionDefinition | d <- s.definitions, d.questionDefinition?];

public list[QuestionDefinition] getChildQuestionDefinitions(PageDefinition p) =
  [d.questionDefinition | d <- p.pageRules, d.questionDefinition?];

public list[QuestionDefinition] getChildQuestionDefinitions(SectionDefinition s) =
  [d.questionDefinition | d <- s.sectionRules, d.questionDefinition?];

public list[DefaultDefinition] getDefaultDefinitions(Stylesheet s) =
  [d | /DefaultDefinition d <- s];
