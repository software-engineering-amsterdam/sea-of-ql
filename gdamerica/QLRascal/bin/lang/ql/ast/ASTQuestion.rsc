module lang::ql::ast::ASTQuestion

/**
 * This module define the user-defined Question DataType 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
data Question
  = singleQuestion(str qstnIdent, str qstnDescr, DataType qstnDataType)
  | computableQuestion(str cqstnIdent, str cqstnDescr, DataType cqstnDataType, Expr cqstnExpr)
  ;