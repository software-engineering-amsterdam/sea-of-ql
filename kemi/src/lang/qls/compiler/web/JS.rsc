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


private str LABEL_CHOOSE = "Choose an answer";
private str LABEL_TRUE = "Yes";
private str LABEL_FALSE = "No";

public void JS(Stylesheet sheet, loc dest) {
  dest += "styling.js";
  
  writeFile(dest, JS(sheet));
}

public str JS(Stylesheet s) =
  "function styling() {
  '  <layoutJS(s)>
  '
  '  <styleJS(s)>
  '
  '  $(\"fieldset\").trigger(\"check\");
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
  f = accompanyingForm(s);
  typeMap = getTypeMap(f);

  ret = "";

  for(k <- typeMap) {
    rules = getStyleRules(k.ident, f, s);
    ret += "//Question <k.ident>\n";
    for(r <- rules) {
      ret += "<styleJS(k.ident, r)>\n";
    }
  }

  return ret;
}

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, text(name))) =
  "//<attr> <name>
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, number(name))) =
  "//<attr> <name>
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, datepicker(name))) =
  "//<attr> <name>
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, slider(name))) =
  "//<attr> <name>
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, radio(name))) =
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<span /\>\")
  '      .append(
  '        $(\"\<input /\>\")
  '          .attr({
  '            id: \"<ident>\",
  '            name: \"<ident>\",
  '            value: \"true\",
  '            type: \"radio\"
  '          })
  '      )
  '      .append(
  '        $(\"\<label /\>\")
  '          .attr({
  '            for: \"<ident>\"
  '          })
  '          .text(\"<LABEL_TRUE>\")
  '      )
  '      .append(
  '        $(\"\<input /\>\")
  '          .attr({
  '            id: \"<ident>False\",
  '            name: \"<ident>\",
  '            value: \"false\",
  '            type: \"radio\"
  '          })
  '      )
  '      .append(
  '        $(\"\<label /\>\")
  '          .attr({
  '            for: \"<ident>False\"
  '          })
  '          .text(\"<LABEL_FALSE>\")
  '      )
  '  );
  '
  '$(\"#<ident>\")
  '  .rules(\"remove\");
  '
  '$(\"#<ident>\")
  '  .rules(\"add\", \"required\");
  '
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, checkbox(name))) =
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<span /\>\")
  '      .append(
  '        $(\"\<input /\>\")
  '          .attr({
  '            id: \"<ident>\",
  '            name: \"<ident>\",
  '            value: \"true\",
  '            type: \"checkbox\"
  '          })
  '      )
  '      .append(
  '        $(\"\<label /\>\")
  '          .attr({
  '            for: \"<ident>\"
  '          })
  '          .text(\"<LABEL_TRUE>\")
  '      )
  '  );
  '
  '$(\"#<ident>\")
  '  .rules(\"remove\");
  '
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, select(name))) =
  // Select is the default type, no need for replacement
  "";

public str styleJS(str ident, StyleRule r: 
    widthStyleRule(str attr, int \value)) =
  "//<attr> <\value>
  '";
