module lang::ql::ast::AST
 
import List;

data Form = form(str name, list[Statement] statements); 

data Statement
  = regular(str \type, str name, str label)
  | computed(str \type, str name, str label, Expr expr)
  | conditional(If \if, list[If] elseIfs, list[Statement] \else);
   
data Expr
  = ident(str name)
  | \int(int ivalue)
  | \bool(bool bvalue)
  | string(str svalue)
  | float (real fvalue)
  | date(str dvalue)
  
  | pos(Expr expr)
  | neg(Expr expr)
  | not(Expr expr)
    
  | mul(Expr expr1, Expr expr2)    
  | div(Expr expr1, Expr expr2)    
  | add(Expr expr1, Expr expr2)    
  | sub(Expr expr1, Expr expr2)    
  
  | lt(Expr expr1, Expr expr2)    
  | leq(Expr expr1, Expr expr2)    
  | gt(Expr expr1, Expr expr2)    
  | geq(Expr expr1, Expr expr2)    
  | eq(Expr expr1, Expr expr2)    
  | neq(Expr expr1, Expr expr2)    
  
  | and(Expr expr1, Expr expr2)    
  | or(Expr expr1, Expr expr2);
 
 
alias If = tuple[Expr condition, list[Statement] body]; 

alias SeparatedStatements 
  = tuple[list[Statement] regularQuestions, 
		   list[Statement] computedQuestions, 
		   list[Statement] conditionals];

anno loc Form@location;
anno loc Statement@location;
anno loc Expr@location;

  
  