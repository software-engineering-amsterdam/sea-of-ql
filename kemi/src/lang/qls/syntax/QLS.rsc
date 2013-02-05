@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::syntax::QLS

extend lang::ql::syntax::Comment;
extend lang::ql::syntax::Int;
extend lang::ql::syntax::Layout;
extend lang::ql::syntax::String;
extend lang::ql::syntax::Type;
extend lang::qls::syntax::Keyword;

start syntax Stylesheet
  = stylesheet: "stylesheet" Ident "{" Definition* definitions "}"
  ;


syntax Ident
  = IdentIdent \ Keywords
  | ("\\" IdentIdent) \ Keywords
  ;

lexical IdentIdent
  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]
  ;


syntax Definition
  = @Foldable definition: PageDefinition
  | @Foldable definition: SectionDefinition
  | @Foldable definition: QuestionDefinition
  | @Foldable definition: DefaultDefinition
  ;


syntax PageDefinition
  = pageDefinition: "page" String "{" PageRule* "}"
  ;


syntax PageRule
  = @Foldable pageRule: SectionDefinition
  | @Foldable pageRule: QuestionDefinition
  | @Foldable pageRule: DefaultDefinition
  ;

syntax SectionDefinition
  = sectionDefinition: "section" String "{" SectionRule* "}"
  ;

syntax SectionRule
  = @Foldable sectionRule: SectionDefinition
  | @Foldable sectionRule: QuestionDefinition
  | @Foldable sectionRule: DefaultDefinition
  ;

syntax QuestionDefinition
  = questionDefinition: "question" Ident
  | questionDefinition: "question" Ident "{" StyleRule* "}"
  ;

syntax DefaultDefinition
  = defaultDefinition: "default" Type "{" StyleRule* "}"
  ;

syntax StyleRule
  = widgetStyleRule: WidgetStyleAttr WidgetStyleValue
  | widthStyleRule: WidthStyleAttr Int
  ;

lexical WidgetStyleValue
  = text: "text"
  | number: "number"
  | datepicker: "datepicker"
  | slider: "slider"
  | radio: "radio"
  | checkbox: "checkbox"
  | select: "select"
  ;

lexical WidgetStyleAttr
  = @category="Constant" "widget"
  ;

lexical WidthStyleAttr
  = @category="Constant" "width"
  ;
