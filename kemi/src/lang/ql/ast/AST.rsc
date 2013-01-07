module lang::ql::ast::AST

data Expr
  = ident(str name)
  | \int(int ivalue)
  | mul(Expr a, Expr b)
  ;