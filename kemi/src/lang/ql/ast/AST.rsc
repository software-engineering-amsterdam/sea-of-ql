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

  
data Form
  = form(str name, list[FormItem] item)
    ;

data FormItem
  = question(Question question)
  | conditional(Expr)//, list[FormItem])//, list[FormItem])
  ;

data Type
  = \type(str name)
  ;

data Question
  = question(str, str, str, list[Expr])
  | question(Expr question, Type \type, Expr identifier, Maybe[Expr] aa) //TODO: Do we want this?
  ;