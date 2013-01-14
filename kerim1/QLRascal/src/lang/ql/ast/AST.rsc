module lang::ql::ast::AST

public data Form
  = form(str name, list[Statement] body);

public data Statement 
  = question(Question question)
  | ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart)
  | ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs);
  
public data ElseIf
  = elseIf(Expr condition, list[Statement] thenPart);

public data Question 
  = computed(str identifier, str label, Type tp, Expr expression)
  | noncomputed(str identifier, str label, Type tp);

public data Type = intType() | boolType() | stringType();

public data Expr
  = ident(str name)
  | \int(int integer)
  | \bool(bool boolean)
  | string(str string)
  | pos(Expr val)
  | neg(Expr val)
  | not(Expr val)
  | mul(Expr lhs, Expr rhs)
  | div(Expr lhs, Expr rhs)
  | add(Expr lhs, Expr rhs)
  | sub(Expr lhs, Expr rhs)
  | lt(Expr lhs, Expr rhs)
  | leq(Expr lhs, Expr rhs)
  | gt(Expr lhs, Expr rhs)
  | geq(Expr lhs, Expr rhs)
  | eq(Expr lhs, Expr rhs)
  | neq(Expr lhs, Expr rhs)
  | and(Expr lhs, Expr rhs)
  | or(Expr lhs, Expr rhs);
  
anno loc Form@location;                   
anno loc Statement@location;
anno loc ElseIf@location;
anno loc Question@location;
anno loc Type@location;
anno loc Expr@location;
  