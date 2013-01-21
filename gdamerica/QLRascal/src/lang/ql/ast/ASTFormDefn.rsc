module lang::ql::ast::ASTFormDefn

/**
 * This module define the user-defined Form DataType 
 * and all corresponding constructors for each alternative  
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
data Form
  = form(str fIdent, list[Element] fElements )
  ;

data Element
  = question(Question qstn)
  | condition(Condition cond)
  ;