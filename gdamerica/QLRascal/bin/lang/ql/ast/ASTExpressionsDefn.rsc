module lang::ql::ast::ASTExpressionsDefn

/**
 * This module define the user-defined Expr DataType 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
data Expr
  = ident(str name)
  | \int(int iValue)
  | boolean(bool bValue)
  | money(real mnValue)
  | string(str strValue)
  | date(str dtValue)
  | decimal(real decValue)
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  | mul(Expr mulLftValue, Expr mulRgtValue)
  | div(Expr divLftValue, Expr divRgtValue)
  | add(Expr addLftValue, Expr addRgtValue)
  | sub(Expr subLftValue, Expr subRgtValue)
  | lt(Expr ltLftValue, Expr ltRgtValue)
  | leq(Expr legLftValue, Expr legRgtValue)
  | gt(Expr gtLftValue, Expr gtRgtValue)
  | geq(Expr geqLftValue, Expr geqRgtValue)
  | eq(Expr eqLftValue, Expr eqRgtValue)
  | neq(Expr neqLftValue, Expr neqRgtValue)
  | and(Expr andLftValue, Expr andRgtValue)
  | or(Expr orLftValue, Expr orRgtValue)
  ;
  
  