module lang::ql::ast::ASTCondition

/**
 * This module define the user-defined Question DataType 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
data Condition
  = singleIfCondition(Expr ifEval, list[Question] ifQstns)
  | ifElseCondition(Expr ifEval, list[Question] ifQstns, list[Question] elseQstns)
  | ifElseIfCondition(Expr ifEval, list[Question] ifQstns, list[ElseIf] elseifs, list[Question] elseQstns)
  ;
  
data ElseIf
  = elseifCondition(Expr elseifEval, list[Question] elseifQstns)
  ; 
