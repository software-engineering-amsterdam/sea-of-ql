@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::\syntax::QL

extend lang::ql::\syntax::Boolean;
extend lang::ql::\syntax::Comment;
extend lang::ql::\syntax::\Date;
extend lang::ql::\syntax::Int;
extend lang::ql::\syntax::Keyword;
extend lang::ql::\syntax::Layout;
extend lang::ql::\syntax::Money;
extend lang::ql::\syntax::String;
extend lang::ql::\syntax::Type;

start syntax Form = 
  @Foldable form: "form" IdentDefinition formName "{" Statement+ formElements "}";

syntax Statement 
  = question: Question question
  | ifCondition: IfPart ifPart ElsIfPart* elseIfs ElsePart? elsePart
  ;

syntax Conditional 
  = conditional: Expr condition "{" Statement+ body "}"
  ;

syntax IfPart = 
  @Foldable "if" Conditional ifPart;

syntax ElsIfPart = 
  @Foldable "else" "if" Conditional elsePart;

syntax ElsePart = 
  @Foldable elsePart: "else" "{" Statement+ body "}";

// What the ...?! Colons don't work, but equals signs do...
start syntax Question 
  = question: QuestionText questionText Type answerDataType IdentDefinition answerIdentifier
  | question: QuestionText questionText Type answerDataType IdentDefinition answerIdentifier "=" Expr calculatedField
  ;

syntax Expr
  = ident: Ident name
  |  \int: Int number
  | money: Money monetaryValue
  | boolean: Boolean truthValue
  | date: Date date
  | string: String text
  | bracket "(" Expr expression ")"
  | pos: "+" Expr pos
  | neg: "-" Expr neg
  | not: "!" Expr not
  > left (
      mul: Expr multiplicand "*" Expr multiplier
    | div: Expr numerator "/" Expr denominator
  )
  > left (
      add: Expr leftAddend "+" Expr rightAddend
    | sub: Expr minuend "-" Expr subtrahend
  )
  > non-assoc (
      lt: Expr left "\<" Expr right
    | leq: Expr left "\<=" Expr right
    | gt: Expr left "\>" Expr right
    | geq: Expr left "\>=" Expr right
    | eq: Expr left "==" Expr right
    | neq: Expr left "!=" Expr right
  )
  > left and: Expr left "&&" Expr right
  > left or: Expr left "||" Expr right
  ;

lexical IdentDefinition
  = identDefinition: Ident ident
  ;

lexical QuestionText
  = @category="Identifier" questionText: String questionText
  ;

syntax Ident
  = @category="Variable" IdentLexical \ Keywords
  | @category="Variable" ("\\" IdentLexical)
  ;

lexical IdentLexical
  = [a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]
  ;
