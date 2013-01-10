module lang::ql::ast::AST
 
import List;

data Form = form(str name, list[Statement] statements); 

data Statement
  = regular(str \type, str name, str label)
  | computed(str \type, str name, str label, Expr expr)
  | conditional(IfStatement ifStatement, list[IfStatement] elseIfs, list[Statement] elsePart);
  
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
 
 
alias IfStatement = tuple[Expr condition, list[Statement] body]; 

alias SeparatedStatements = tuple[list[Statement] regs, list[Statement] comps, list[Statement] conds];

// return a list of all top level statements contained in a conditional
public list[Statement] flatten(Statement s:conditional(i,[],e)) = s.ifStatement.body + e;  
public list[Statement] flatten(Statement s:conditional(i,ei,e)) = s.ifStatement.body + flatten(conditional(head(ei), tail(ei), e));  

// return a tuple with groups of different kinds of statements
public SeparatedStatements separate(list[Statement] s) = 
  <[r | r:regular(_,_,_) <- s], [c | c:computed(_,_,_,_) <- s], [c | c:conditional(_,_,_) <- s]>;


anno loc Form@location;
anno loc Statement@location;
  
  