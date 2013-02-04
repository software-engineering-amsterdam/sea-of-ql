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
extend lang::ql::syntax::Layout;
extend lang::ql::syntax::String;
extend lang::ql::syntax::Types;

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
  = typeStyleRule: TypeStyleAttr TypeStyleValue
  | widthStyleRule: WidthStyleAttr Int
  ;

lexical TypeStyleValue
  = radio: "radio"
  | checkbox: "checkbox"
  ;

lexical TypeStyleAttr
  = @category="Constant" "type"
  ;

lexical WidthStyleAttr
  = @category="Constant" "width"
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;

keyword Keywords 
  = stylesheet: "stylesheet"
  | page: "page"
  | section: "section"
  | question: "question"
  | \default: "default"
  | boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | date: "date"
  | string: "string"
  | \type: "type"
  | width: "width"
  | radio: "radio"
  | checkbox: "checkbox"
  ;
