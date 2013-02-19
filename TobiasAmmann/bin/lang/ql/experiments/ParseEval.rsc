module lang::ql::experiments::ParseEval

import String;
import ParseTree;       
    
lexical IntegerLiteral = [0-9]+;    

       

start syntax Exp            
  = IntegerLiteral          
  | bracket "(" Exp ")"     
  > left Exp "*" Exp        
  > left Exp "+" Exp        
  ;                                          

public int eval(str txt) = eval(parse(#Exp, txt));                

public int eval((Exp)`<IntegerLiteral l>`) = toInt("<l>");        
public int eval((Exp)`<Exp e1>*<Exp e2>`) = eval(e1) * eval(e2);  
public int eval((Exp)`<Exp e1>+<Exp e2>`) = eval(e1) + eval(e2);  
public int eval((Exp)`(<Exp e>)`) = eval(e);

                      