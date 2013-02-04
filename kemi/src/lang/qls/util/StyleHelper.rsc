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
import lang::ql::tests::ParseHelper;

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;

public void main() {
  Form f = parseForm(|project://QL-R-kemi/forms/taxOfficeExample.q|);
  Stylesheet s = parseStylesheet(|project://QL-R-kemi/stylesheets/taxOfficeExample.qs|);

  typeMap = getTypeMap(f);
  //iprintln(typeMap);
  
  for(k <- typeMap){
    iprintln(<k.ident, getStyleRules(k.ident, f, s)>);
  }
  
  //Stylesheet s = parseStylesheet("stylesheet S1 { section \"S1\" { section \"SS\" {question Q1 { type checkbox }} } section \"P1\" {  } }");
  //Stylesheet s = parseStylesheet("stylesheet S1 { question Q1 { type checkbox width 100 } default boolean { type radio } default string { width 104 }}");
}

private TypeMap typeMap = ();

public TypeMap getTypeMap(Form f) {
  if(size(typeMap) < 1) {
    typeMap = semanticAnalysisState(f).definitions;
  }
  return typeMap;
}

public Form accompanyingForm(Stylesheet s) =
  parseForm(accompanyingFormLocation(s));

public loc accompanyingFormLocation(Stylesheet s) =
  |project://QL-R-kemi/forms/| + "<s.ident>.q";

public list[StyleRule] getStyleRules(str questionIdent, Form f, Stylesheet s) {
  typeMap = getTypeMap(f);
  str \type = typeMap[identDefinition(questionIdent)].name;
  list[StyleRule] rules = getStyleRules(\type, s.definitions);
  for(d <- getDefinitions(questionIdent, s)) {
    switch(d) {
      case PageDefinition d: rules += getStyleRules(\type, d.pageRules);
      case SectionDefinition d: rules += getStyleRules(\type, d.sectionRules);
      case QuestionDefinition:questionDefinition(_, r): rules += r;
    }
  }
  return deDupeStyleRules(rules);
}

private list[StyleRule] getStyleRules(str \type, list[&T] definitions) =
  [
    * d.defaultDefinition.styleRules |
    d <- definitions,
    d.defaultDefinition?,
    d.defaultDefinition.ident == \type
  ];

public list[StyleRule] deDupeStyleRules(list[StyleRule] styleRules) {
  list[str] attrs = [];
  list[StyleRule] uniques = [];
  for(r <- reverse(styleRules)) {
    if(indexOf(attrs, r.attr) < 0) {
      attrs += r.attr;
      uniques += r;
    }
  }
  return uniques;
}

public list[node] getDefinitions(str questionIdent, Stylesheet s) =
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