module lang::ql::syntax::QLSyntax

/**
 * This module contains all the QL syntax definitions   
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
start syntax Expr
  = ident: Ident name
  | \int: Int
  | boolean: Boolean
  > money: Money
  | string: String
  | date: Date
  | decimal: Decimal
  | bracket "(" Expr arg ")"
  | pos: "+" Expr
  | neg: "-" Expr
  | not: "!" Expr
  > left (
      mul: Expr "*" Expr
    | div: Expr "/" Expr
  )
  > left (
      add: Expr "+" Expr
    | sub: Expr "-" Expr
  )
  > non-assoc (
      lt: Expr "\<" Expr
    | leq: Expr "\<=" Expr
    | gt: Expr "\>" Expr
    | geq: Expr "\>=" Expr
    | eq: Expr "==" Expr
    | neq: Expr "!=" Expr
  )
  > left and: Expr "&&" Expr
  > left or: Expr "||" Expr
  ;
  
start syntax DataType
  = \int: "int"
  | boolean: "boolean"
  | money: "money"
  | string: "string"
  | date: "date"
  | decimal: "decimal" 
  ;  
        
start syntax Form
  = form: "form" Ident identification "{" Element+ formElement "}" 
  ;

start syntax Element
  = question: Question question
  | condition: Condition condition
  ;
    
start syntax Question
  = singleQuestion: Ident identification ":" String description DataType datatype 
  | computableQuestion: Ident identification ":" String description DataType datatype Expr computableExpression 
  ;
   
start syntax Condition
  = singleIfCondition: "if" Expr evaluation "{" Question+ questions "}" 
  | ifElseCondition: "if" Expr evaluation "{" Question+ questions "}" "else" "{" Question+ questions "}"
  | ifElseIfCondition: "if" Expr evaluation "{" Question+ questions "}" ElseIf+ elseif "else" "{" Question+ questions "}"   
  ;
      
start syntax ElseIf
  = elseifCondition: "else if" Expr evaluation "{" Question+ questions "}" 
  ; 
  
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   
   