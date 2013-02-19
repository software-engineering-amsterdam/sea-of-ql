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

import Configuration;
import IO;
import String;
import lang::ql::analysis::State;
import lang::ql::\ast::AST;
import lang::ql::util::FormHelper;
import lang::qls::\ast::AST;
import lang::qls::util::StyleHelper;
import util::StringHelper;

public void JS(Stylesheet sheet, loc dest) =
  writeFile(dest + getStylingJSName(), JS(sheet));

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
  "<d.ident><getBlockSuffix()>"
    when d is questionDefinition;

private str layoutJS(Stylesheet s) =
  "<for(d <- s.definitions) {><layoutJS(d, getUniqueID(s))><}>";

private str layoutJS(Definition d: pageDefinition(_, rules), str parentID) =
  "$(\"\<div /\>\")
  '  .attr({
  '    id: \"<getUniqueID(d)>\",
  '    class: \"page\"
  '  })
  '  .append(<pageName(d)>)
  '  .appendTo($(\"#<parentID>\"));
  '
  '<for(def <- getChildSectionsQuestions(d)) {>
  '<layoutJS(def, getUniqueID(d))>
  '<}>";

private str layoutJS(Definition d: sectionDefinition(_, rules), str parentID) =
  "$(\"\<fieldset /\>\")
  '  .attr({
  '    id: \"<getUniqueID(d)>\",
  '    class: \"section\"
  '  })
  '  .append(<sectionName(d)>)
  '  .appendTo($(\"#<parentID>\"));
  '
  '<for(def <- getChildSectionsQuestions(d)) {>
  '<layoutJS(def, getUniqueID(d))>
  '<}>";

private str layoutJS(Definition d, str parentID) =
  "$(\"#<blockIdent(d)>\")
  '  .appendTo($(\"#<parentID>\"));
  '
  '"
    when d is questionDefinition;
    
private str layoutJS(Definition d, str parentID) =
  "/*
  'Why is the defaultDefinition not matched?
  'Definition d: 
  '<d>
  '
  'str parentID: 
  '<parentID>
  '*/"
    when d is defaultDefinition;
    
private str styleJS(Stylesheet s) {
  Form f = getAccompanyingForm(s);
  TypeMap typeMap = getTypeMap(f);

  return
    "<for(IdentDefinition i <- typeMap) {>
    '// Question <i.ident>
    '<for(r:widgetStyleRule(_, _) <- getStyleRules(i.ident, f, s)) {>
    '<styleJS(i.ident, r)>
    '<}>
    '<}>
    '";
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
  '          .text(\"<getLabelTextTrue()>\")
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
  '          .text(\"<getLabelTextFalse()>\")
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
  '          .text(\"<getLabelTextTrue()>\")
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
