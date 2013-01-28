module lang::ql::ast::AST


data Form = form(str name, list[Statement] statements); 

data Statement
  = regular(Type \type, str name, str label)
  | computed(Type \type, str name, str label, Expr expr)
  | conditional(If \if, list[If] elseIfs, list[Statement] \else);
 
data Type
  = \bool(str name)
  | \int(str name)
  | string(str name)
  | float(str name)
  | date(str name);
   
data Expr
  = ident(str name)
  | intConst(int intValue)
  | boolConst(bool boolValue)
  | stringConst(str stringValue)
  | floatConst(real floatValue)
  | dateConst(str dateValue)
  
  | pos(Expr expr)
  | neg(Expr expr)
  | not(Expr expr)
    
  | mul(Expr left, Expr right)    
  | div(Expr left, Expr right) 
  | add(Expr left, Expr right)    
  | sub(Expr left, Expr right)  
  
  | lt(Expr left, Expr right)  
  | leq(Expr left, Expr right)  
  | gt(Expr left, Expr right) 
  | geq(Expr left, Expr right)   
  | eq(Expr left, Expr right)    
  | neq(Expr left, Expr right)   
  
  | and(Expr left, Expr right)    
  | or(Expr left, Expr right);
   
  
alias If = tuple[Expr condition, list[Statement] body]; 

anno loc Form@location;
anno loc Statement@location;
anno loc Expr@location;

  
  