module lang::qls::util::StyleHelpers

import IO;
import List;
import String;

import lang::ql::analysis::SemanticChecker;
import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;

public void main() {
  Form f = parseForm(|project://QL-R-kemi/forms/basic.q|);
  Stylesheet s = parseStylesheet(|project://QL-R-kemi/stylesheets/basic.qs|);
  iprintln(getStyleRules("numberQuestion", f, s));
  
  //Stylesheet s = parseStylesheet("stylesheet S1 { section \"S1\" { section \"SS\" {question Q1 { type checkbox }} } section \"P1\" {  } }");
  //Stylesheet s = parseStylesheet("stylesheet S1 { question Q1 { type checkbox width 100 } default boolean { type radio } default string { width 104 }}");
}

public list[StyleRule] getStyleRules(str questionIdent, Form f, Stylesheet s) {
  typeMap = semanticAnalysisState(f).definitions;
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
  [r | d <- definitions, d.defaultDefinition?, d.defaultDefinition.ident == \type, r <- d.defaultDefinition.styleRules];

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