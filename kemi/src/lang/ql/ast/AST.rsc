module lang::ql::ast::AST

import DateTime;
import util::Maybe;

data Expr
  = ident(str name)
  | \int(int ivalue)
  | money(real mvalue)
  | boolean(bool bvalue)
  | date(str dvalue)
  | string(str tvalue)
  | pos(Expr a)
  | neg(Expr a)
  | not(Expr a)
  | mul(Expr a, Expr b)
  | div(Expr a, Expr b)
  | add(Expr a, Expr b)
  | sub(Expr a, Expr b)
  | lt(Expr a, Expr b)
  | leq(Expr a, Expr b)
  | gt(Expr a, Expr b)
  | geq(Expr a, Expr b)
  | eq(Expr a, Expr b)
  | neq(Expr a, Expr b)
  | and(Expr a, Expr b)
  | or(Expr a, Expr b)
  ;

  
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