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
    '    id: \"<getUniqueID(p)>\",
    '    class: \"page\"
    '  })
    '  .append(<pageName(p)>)
    '  .appendTo($(\"#<getUniqueID(parent)>\"));
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
    '    id: \"<getUniqueID(s)>\",
    '    class: \"section\"
    '  })
    '  .append(<sectionName(s)>)
    '  .appendTo($(\"#<getUniqueID(parent)>\"));
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
  '  .appendTo($(\"#<getUniqueID(parent)>\"));
  '
  '";

private str styleJS(Stylesheet s) {
  f = getAccompanyingForm(s);
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
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<input /\>\")
  '      .attr({
  '        id: \"<ident>\",
  '        name: \"<ident>\",
  '        type: \"text\",
  '        disabled: $(\"#<ident>\").is(\":disabled\")
  '      })
  '  );
  '
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, number(name))) =
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<input /\>\")
  '      .attr({
  '        id: \"<ident>\",
  '        name: \"<ident>\",
  '        type: \"number\",
  '        step: $(\"#<ident>\").attr(\"type\") === \"money\" ? \"0.01\" : \"1\",
  '        disabled: $(\"#<ident>\").is(\":disabled\")
  '      })
  '  );
  '
  '";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, datepicker(name))) =
  // Datepicker is the default type, so no need for replacement
  "";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, slider(name))) =
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<span /\>\")
  '      .append(
  '        $(\"\<input /\>\")
  '          .attr({
  '            id: \"<ident>\",
  '            name: \"<ident>\",
  '            type: \"range\",
  '            value: \"0\",
  '            min: \"0\",
  '            max: \"100\",
  '            step: $(\"#<ident>\").attr(\"type\") === \"money\" ?
  '              \"0.01\" : \"1\",
  '            disabled: $(\"#<ident>\").is(\":disabled\")
  '          })
  '          .change(function() {
  '            $(\"#<ident>Display\").text($(this).val());
  '          })
  '      )
  '      .append(
  '        $(\"\<span /\>\")
  '          .attr({
  '            id: \"<ident>Display\"
  '          })
  '          .text(0)
  '      )
  '  );
  '
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
  '            type: \"radio\",
  '            disabled: $(\"#<ident>\").is(\":disabled\")
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
  '            type: \"radio\",
  '            disabled: $(\"#<ident>\").is(\":disabled\")
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
  '            type: \"checkbox\",
  '            disabled: $(\"#<ident>\").is(\":disabled\")
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

private str getUniqueID(Stylesheet s) =
  s.ident;

private str getUniqueID(PageDefinition p) =
  "page_<split(" ", stripQuotes(p.ident))[0]>_" +
    "<p@location.begin.line>_<p@location.begin.column>";

private str getUniqueID(SectionDefinition s) =
  "section_<split(" ", stripQuotes(s.ident))[0]>_" +
    "<s@location.begin.line>_<s@location.begin.column>";
