@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::compiler::web::JS

import IO;
import String;
import util::StringHelper;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import lang::qls::ast::AST;
import lang::qls::util::StyleHelper;

import lang::qls::util::ParseHelper;

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
  '  paginate();
  '
  '  $(\"fieldset\").trigger(\"check\");
  '}
  '";

private str pageName(Definition d: pageDefinition(ident, _)) =
  "$(\"\<h1/\>\").text(\"<trimQuotes(ident)>\")";

private str sectionName(Definition d: sectionDefinition(ident, _)) =
  "$(\"\<legend/\>\").text(\"<trimQuotes(ident)>\")";

private str blockIdent(Definition d) =
  "<d.ident>Block"
    when d is questionDefinition;

private str layoutJS(Stylesheet s) {
  str ret = "";
  
  for(d <- s.definitions) {
    ret += "<layoutJS(d, getUniqueID(s))>";
  }
  
  return ret;
}

private str layoutJS(Definition d: pageDefinition(_, rules), str parentID) {
  str ret =
    "$(\"\<div /\>\")
    '  .attr({
    '    id: \"<getUniqueID(d)>\",
    '    class: \"page\"
    '  })
    '  .append(<pageName(d)>)
    '  .appendTo($(\"#<parentID>\"));
    '
    '";
  
  for(Definition def <- getChildSectionDefinitions(d) + getChildQuestionDefinitions(d)) {
    ret += "<layoutJS(def, getUniqueID(d))>";
  }
  
  return ret;
}

private str layoutJS(Definition d: sectionDefinition(_, rules), str parentID) {
  str ret =
    "$(\"\<fieldset /\>\")
    '  .attr({
    '    id: \"<getUniqueID(d)>\",
    '    class: \"section\"
    '  })
    '  .append(<sectionName(d)>)
    '  .appendTo($(\"#<parentID>\"));
    '
    '";
  
  for(Definition def <- getChildSectionDefinitions(d) + getChildQuestionDefinitions(d)) {
    ret += "<layoutJS(def, getUniqueID(d))>";
  }
  
  return ret;
}

private str layoutJS(Definition d, str parentID) =
  "$(\"#<blockIdent(d)>\")
  '  .appendTo($(\"#<parentID>\"));
  '
  '"
    when d is questionDefinition;

private str styleJS(Stylesheet s) {
  Form f = getAccompanyingForm(s);
  TypeMap typeMap = getTypeMap(f);

  ret = "";

  for(k <- typeMap) {
    rules = getStyleRules(k.ident, f, s);
    ret += "//Question <k.ident>\n";
    for(r:widgetStyleRule(_, _) <- rules) {
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
  numberJS(ident, -1, -1, -1);

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, number(name, min, max))) =
  numberJS(ident, min, max, -1);

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, number(name, min, max, step))) =
  numberJS(ident, min, max, step);

private str numberJS(str ident, num min, num max, num step) =
  "$(\"#<ident>\")
  '  .replaceWith(
  '    $(\"\<input /\>\")
  '      .attr({
  '        id: \"<ident>\",
  '        name: \"<ident>\",
  '        type: \"number\",
  '        <if(min >= 0) {> min: <min>, <}>
  '        <if(max >= 0) {> max: <max>, <}>
  '        <if(step >= 0) {>
  '        step: <step>,
  '        <} else {>
  '        step: $(\"#<ident>\").attr(\"type\") === \"money\" ?
  '          \"0.01\" : \"1\",
  '        <}>
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
  sliderJS(ident, 0, 100, -1);

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, slider(name, min, max))) =
  sliderJS(ident, min, max, -1);

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, slider(name, min, max, step))) =
  sliderJS(ident, min, max, step);

private str sliderJS(str ident, num min, num max, num step) =
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
  '            min: <min>,
  '            max: <max>,
  '            <if(step < 0) {>
  '            step: $(\"#<ident>\").attr(\"type\") === \"money\" ?
  '              \"0.01\" : \"1\",
  '            <} else {>
  '            step: <step>,
  '            <}>
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

private str getUniqueID(Stylesheet s) =
  s.ident;

private str getUniqueID(Definition d: pageDefinition(ident, _)) =
  "page_<split(" ", trimQuotes(ident))[0]>_" +
    "<d@location.begin.line>_<d@location.begin.column>";

private str getUniqueID(Definition d: sectionDefinition(ident, _)) =
  "section_<split(" ", trimQuotes(ident))[0]>_" +
    "<d@location.begin.line>_<d@location.begin.column>";
