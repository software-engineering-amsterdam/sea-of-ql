module lang::qls::compiler::web::JS

import IO;
import util::StringHelper;
import lang::ql::ast::AST;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

import lang::qls::util::ParseHelper;

public void main() {
  s = parseStylesheet(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);
  println(JS(s));
}


public void JS(Stylesheet sheet, loc dest) {
  dest += "styling.js";
  
  writeFile(dest, JS(sheet));
}

public str JS(Stylesheet s) =
  "function styling() {
  '  <layoutJS(s)>
  '
  '  <styleJS(s)>
  '}
  '";

private str pageName(PageDefinition p) =
  "$(\"\<span/\>\").text(\"<trimQuotes(p.ident)>\")";

private str sectionName(SectionDefinition s) =
  "$(\"\<legend/\>\").text(\"<trimQuotes(s.ident)>\")";

private str blockIdent(QuestionDefinition q) =
  "<q.ident>Block";

private str layoutJS(Stylesheet s) {
  str ret = "";
  
  for(d <- s.definitions) {
    switch(d) {
      case definition(PageDefinition p):
        ret += "<layoutJS(p, s)>";
      
      case definition(SectionDefinition sd):
        ret += "<layoutJS(sd, s)>";
      
      case definition(QuestionDefinition q):
        ret += "<layoutJS(q, s)>";
    }
  }
  
  return ret;
}

private str layoutJS(PageDefinition p, &T parent) {
  str ret =
    "$(\"\<div /\>\")
    '  .attr({
    '    id: \"<uniqueId(p)>\",
    '    class: \"page\"
    '  })
    '  .append(<pageName(p)>)
    '  .appendTo($(\"#<uniqueId(parent)>\"));
    '
    '";
  
  for(d <- p.pageRules) {
    switch(d) {
      case pageRule(SectionDefinition s):
        ret += "<layoutJS(s, p)>";
      
      case pageRule(QuestionDefinition q):
        ret += "<layoutJS(q, p)>";
    }
  }
  
  return ret;
}

private str layoutJS(SectionDefinition s, &T parent) {
  str ret =
    "$(\"\<fieldset /\>\")
    '  .attr({
    '    id: \"<uniqueId(s)>\",
    '    class: \"section\"
    '  })
    '  .append(<sectionName(s)>)
    '  .appendTo($(\"#<uniqueId(parent)>\"));
    '
    '";
  
  for(d <- s.sectionRules) {
    switch(d) {
      case sectionRule(SectionDefinition sd):
        ret += "<layoutJS(sd, s)>";
      
      case sectionRule(QuestionDefinition q):
        ret += "<layoutJS(q, s)>";
    }
  }
  
  return ret;
}

private str layoutJS(QuestionDefinition q, &T parent) =
  "$(\"#<blockIdent(q)>\")
  '  .appendTo($(\"#<uniqueId(parent)>\"));
  '
  '";

private str styleJS(Stylesheet s) {
  ret = "/********** STILL TODO\n";

  for(q <- getQuestionDefinitions(s)) {
    if(!q.styleRules?)
      continue;

    ret += styleJS(q);
  }

  return ret + "**********/";
}

private str styleJS(QuestionDefinition q) =
  "Question <blockIdent(q)>:<for(r <- q.styleRules) {>
  '  <styleJS(r)><}>
  '
  '";

private str styleJS(StyleRule r: 
    widgetStyleRule(attr, \value)) =
  "<attr> <\value.name>";

public str styleJS(StyleRule r: 
    widthStyleRule(str attr, int \value)) =
  "<attr> <\value>";
