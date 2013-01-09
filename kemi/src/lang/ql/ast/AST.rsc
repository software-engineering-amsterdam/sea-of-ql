module lang::ql::ast::AST

import util::Maybe;

data Form = form(str formName, list[FormItem] formElements);

data FormItem
  = question(Question question)
  | conditional(Expr booleanExpression, list[FormItem] thenStatement)
  | conditional(Expr booleanExpression, list[FormItem] thenStatement, list[FormItem] elseStatement)
  ;

data Type
  = \type(str name)
  ;

data Question
  = question(str, str, str)
  | question(str, str, str, str)
  | question(Expr questionText, Type answerDataType, Expr answerIdentifier) //TODO: Do we want this?
  | question(Expr questionText, Type answerDataType, Expr answerIdentifier, Expr aa) //TODO: Do we want this?
  //| question(Expr questionText, Type answerDataType, Expr answerIdentifier, Maybe[Expr] aa) //TODO: Do we want this?
  ;

data Expr
  = ident(str name)
  | \int(int intValue)
  | money(real moneyValue)
  | boolean(bool booleanValue)
  | date(str dateValue)
  | string(str text)
  
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  
  | mul(Expr multiplicand, Expr multiplier)
  | div(Expr numerator, Expr denominator)
  | add(Expr leftAddend, Expr rightAddend)
  | sub(Expr minuend, Expr subtrahend)
  
  | lt(Expr left, Expr right)
  | leq(Expr left, Expr right)
  | gt(Expr left, Expr right)
  | geq(Expr left, Expr rigt)
  | eq(Expr left, Expr right)
  | neq(Expr left, Expr right)
  
  | and(Expr left, Expr right)
  | or(Expr left, Expr right)
  ;