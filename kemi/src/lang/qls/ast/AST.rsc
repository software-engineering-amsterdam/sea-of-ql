@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::ast::AST

data Stylesheet
  = stylesheet(str ident, list[Definition] definitions)
  ;

data Definition
  = definition(PageDefinition pageDefinition)
  | definition(SectionDefinition sectionDefinition)
  | definition(QuestionDefinition questionDefinition)
  | definition(DefaultDefinition defaultDefinition)
  ;

data PageDefinition
  = pageDefinition(str ident, list[PageRule] pageRules)
  ;

data PageRule
  = pageRule(SectionDefinition sectionDefinition)
  | pageRule(QuestionDefinition questionDefinition)
  | pageRule(DefaultDefinition defaultDefinition)
  ;

data SectionDefinition
  = sectionDefinition(str ident, list[SectionRule] sectionRules)
  ;

data SectionRule
  = sectionRule(SectionDefinition sectionDefinition)
  | sectionRule(QuestionDefinition questionDefinition)
  | sectionRule(DefaultDefinition defaultDefinition)
  ;

data QuestionDefinition
  = questionDefinition(str ident)
  | questionDefinition(str ident, list[StyleRule] styleRules)
  ;

data DefaultDefinition
  = defaultDefinition(Type ident, list[StyleRule] styleRules)
  ;

data Type
  = booleanType(str name)
  | integerType(str name)
  | moneyType(str name)
  | dateType(str name)
  | stringType(str name)
  ;

data StyleRule
  = widgetStyleRule(StyleAttr attr, WidgetStyleValue widgetValue)
  | intStyleRule(StyleAttr attr, int intValue)
  | stringStyleRule(StyleAttr attr, str stringValue)
  | colorStyleRule(StyleAttr attr, str colorValue)
  ;

data StyleAttr
  = widget(str name)
  | width(str name)
  | fontsize(str name)
  | labelFontsize(str name)
  | font(str name)
  | labelFont(str name)
  | color(str name)
  | labelColor(str name)
  ;

data WidgetStyleValue
  = text(str name)
  | number(str name)
  | number(str name, real min, real max)
  | number(str name, real min, real max, real step)
  | datepicker(str name)
  | slider(str name)
  | slider(str name, real min, real max)
  | slider(str name, real min, real max, real step)
  | radio(str name)
  | checkbox(str name)
  | select(str name)
  ;

anno loc Stylesheet@location;
anno loc Definition@location;
anno loc PageDefinition@location;
anno loc PageRule@location;
anno loc SectionDefinition@location;
anno loc SectionRule@location;
anno loc QuestionDefinition@location;
anno loc DefaultDefinition@location;
anno loc Type@location;
anno loc StyleRule@location;
anno loc StyleAttr@location;
anno loc WidgetStyleValue@location;
