@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::syntax::QL

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

syntax WhitespaceOrComment 
  = whitespace: Whitespace whitespace
  | comment: Comment comment
  ;   

lexical IdentDefinition
  = identDefinition: Ident ident
  ;

lexical Ident
  = @category="Variable" ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical QuestionText
  = @category="Identifier" questionText: String questionText
  ;

lexical Type
  = @category="Type" booleanType: "boolean"
  | @category="Type" integerType: "integer"
  | @category="Type" moneyType: "money"
  | @category="Type" dateType: "date"
  | @category="Type" stringType: "string"
  ;

lexical String
  = @category="Constant" "\"" TextChar* "\"";

lexical TextChar
  = [\\] << [\"]
  | ![\"]
  ;

lexical Int =
  @category="Constant" [0-9]+ !>> [0-9]
  ;

lexical Boolean
  = "true"
  | "false"
  ;

syntax Money = 
  @category="Constant" LMoney;

lexical LMoney
  = [0-9]+ "."
  | [0-9]+ "." [0-9]
  | [0-9]+ "." [0-9][0-9]
  ;

lexical Date = 
  @category="Constant" "$" Year "-" Month "-" Day;

// Note: We assume that dates are valid in domain [1000 to 2999]
lexical Year =  
  [1-2][0-9][0-9][0-9];

lexical Month
  = [0][0-9]
  | [1][0-2]
  ;

lexical Day
  = [0-2][0-9]
  | [3][0-1]
  ;
  
lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n]* $
  ;

lexical CommentChar
  = ![*]
  | [*] !>> [/]
  ;

lexical Whitespace = 
  [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000];

layout Standard = 
  WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";

keyword Keywords 
  = boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | date: "date"
  | string: "string"
  | \true: "true"
  | \false: "false"
  | form: "form"
  ;

