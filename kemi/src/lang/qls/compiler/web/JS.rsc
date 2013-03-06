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

public void js(Stylesheet sheet, loc dest) =
  writeFile(dest + getStylingJSName(), js(sheet));

public str js(Stylesheet s) =
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

private str blockIdent(Definition d) =
  "<d.ident.name><getBlockSuffix()>"
    when d is questionDefinition;

private str layoutJS(Stylesheet s) =
  "<for(Definition d <- s.definitions, defaultDefinition(_, _) !:= d) {>
  '<layoutJS(d, getUniqueID(s))>
  '<}>";

private str layoutJS(Definition d: pageDefinition(ident, rules), str parentID) =
  "addPage(\"<getUniqueID(d)>\", \"<unquote(ident)>\", \"<parentID>\");
  '
  '<for(def <- getChildSectionsQuestions(d)) {>
  '<layoutJS(def, getUniqueID(d))>
  '<}>
  '";

private str layoutJS(Definition d: sectionDefinition(ident, rules),
    str parentID) =
  "addSection(\"<getUniqueID(d)>\", \"<unquote(ident)>\", \"<parentID>\");
  '
  '<for(def <- getChildSectionsQuestions(d)) {>
  '<layoutJS(def, getUniqueID(d))>
  '<}>
  '";

private str layoutJS(Definition d, str parentID) =
  "addQuestion(\"<blockIdent(d)>\", \"<parentID>\");"
    when d is questionDefinition;
    
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
  "addText(\"<ident>\");";

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
  "addNumber(\"<ident>\", <min>, <max>, <step>);";

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
  "addSlider(\"<ident>\", <min>, <max>, <step>);";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, radio(name))) =
  "addRadio(\"<ident>\");";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, checkbox(name))) =
  "addCheckbox(\"<ident>\");";

private str styleJS(str ident, StyleRule r: 
    widgetStyleRule(attr, select(name))) =
  // Select is the default type, no need for replacement
  "";

private str getUniqueID(Stylesheet s) =
  s.ident.name;

private str getUniqueID(Definition d: pageDefinition(ident, _)) =
  "page_<split(" ", unquote(ident))[0]>_" +
  "<d@location.begin.line>_<d@location.begin.column>";

private str getUniqueID(Definition d: sectionDefinition(ident, _)) =
  "section_<split(" ", unquote(ident))[0]>_" +
  "<d@location.begin.line>_<d@location.begin.column>";
