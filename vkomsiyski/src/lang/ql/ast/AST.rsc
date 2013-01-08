module lang::ql::ast::AST
 
import List;
 
 
data Form = form(str name, list[Question] questions);
 
 
data Question 
  = question(str name, str label, str questionType, Expr expr)
  | conditional(IfStatement ifStatement);
 
  
data IfStatement 
  = ifStatementSingle(Expr condition, Question question, ElseStatement elseStatement)
  | ifStatementMultiple(Expr condition, list[Question] questions, ElseStatement elseStatement);
 
  
data ElseStatement
  = elseIfStatement(IfStatement ifStatement)
  | elseStatementSingle(Question question)
  | elseStatementMultiple(list[Question] questions); 
    

data Expr
  = ident(str name)
  | \int(int ivalue)
  
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
  
  
anno loc Form@location;
  
  