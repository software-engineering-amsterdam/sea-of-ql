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
extend lang::ql::syntax::Money;
extend lang::ql::syntax::String;
extend lang::ql::syntax::Type;
extend lang::qls::syntax::Color;
extend lang::qls::syntax::Keyword;

start syntax Stylesheet
  = stylesheet: "stylesheet" Ident "{" Definition* definitions "}"
  ;

syntax Definition
  = @Foldable definition: PageDefinition
  | @Foldable definition: SectionDefinition
  | @Foldable definition: QuestionDefinition
  | @Foldable definition: DefaultDefinition
  ;

syntax PageDefinition
  = pageDefinition: "page" String "{" LayoutRule* "}"
  ;

syntax SectionDefinition
  = sectionDefinition: "section" String "{" LayoutRule* "}"
  ;

syntax LayoutRule
  = @Foldable layoutRule: SectionDefinition
  | @Foldable layoutRule: QuestionDefinition
  | @Foldable layoutRule: DefaultDefinition
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
  | intStyleRule: IntStyleAttr Int
  | stringStyleRule: StringStyleAttr String
  | colorStyleRule: ColorStyleAttr Color
  ;

syntax WidgetStyleValue
  = text: TextWidgetValue
  | number: NumberWidgetValue
  | number: NumberWidgetValue "[" Number "," Number "]"
  | number: NumberWidgetValue "[" Number "," Number "," Number "]"
  | datepicker: DatepickerWidgetValue
  | slider: SliderWidgetValue
  | slider: SliderWidgetValue "[" Number "," Number "]"
  | slider: SliderWidgetValue "[" Number "," Number "," Number "]"
  | radio: RadioWidgetValue
  | checkbox: CheckboxWidgetValue
  | select: SelectWidgetValue
  ;

lexical Number
  = Int
  | Money
  ;

lexical TextWidgetValue
  = "text"
  ;

lexical NumberWidgetValue
  = "number"
  ;

lexical DatepickerWidgetValue
  = "datepicker"
  ;

lexical SliderWidgetValue
  = "slider"
  ;

lexical RadioWidgetValue
  = "radio"
  ;

lexical CheckboxWidgetValue
  = "checkbox"
  ;

lexical SelectWidgetValue
  = "select"
  ;

lexical WidgetStyleAttr
  = @category="Identifier" widget: "widget"
  ;

lexical IntStyleAttr
  = @category="Identifier" width: "width"
  | @category="Identifier" fontsize: "fontsize"
  | @category="Identifier" labelFontsize: "label-fontsize"
  ;

lexical StringStyleAttr
  = @category="Identifier" font: "font"
  | @category="Identifier" labelFont: "label-font"
  ;

lexical ColorStyleAttr
  = @category="Identifier" color: "color"
  | @category="Identifier" labelColor: "label-color"
  ;

syntax Ident
  = @category="Variable" IdentLexical \ Keywords
  | @category="Variable" ("\\" IdentLexical) \ Keywords
  ;

lexical IdentLexical
  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]
  ;
