/**
 * This module define the user-defined DataTypes 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 20/01/2013
 */
 
module lang::ql::ast::AST

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
  
data Form
  = form(str fIdent, list[Element] fElements )
  ;

data Element
  = question(Question qstn)
  | condition(Condition cond)
  ;
  
data Question
  = singleQuestion(str qstnIdent, str qstnDescr, DataType qstnDataType)
  | computableQuestion(str cqstnIdent, str cqstnDescr, DataType cqstnDataType, Expr cqstnExpr)
  ;

data Condition
  = singleIfCondition(Expr ifEval, list[Element] ifQstns)
  | ifElseCondition(Expr ifEval, list[Element] ifQstns, list[Element] elseQstns)
  | ifElseIfCondition(Expr ifEval, list[Element] ifQstns, list[ElseIf] elseifs, list[Element] elseQstns)
  ;
  
data ElseIf
  = elseifCondition(Expr elseifEval, list[Element] elseifQstns)
  ; 

data DataType
  = integer()
  | boolean()
  | money()
  | string()
  | date()
  | decimal()
  ;
  
/**
* location annotations to be used in implosion
*/
anno loc Question@location;
anno loc Condition@location;
anno loc ElseIf@location;
anno loc DataType@location;
anno loc Expr@location;
anno loc Form@location;
anno loc Element@location; 
  
    
  
  