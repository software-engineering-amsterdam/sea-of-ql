module lang::ql::ast::ASTDataType

/**
 * This module define the user-defined DataType DataType 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
data DataType
  = \int()
  | boolean()
  | money()
  | string()
  | date()
  | decimal()
  ;