module eval::ExpressionEval

import eval::EvalTypeEnvironment;
import syntax::AbstractSyntax;
import Prelude;

public QuestionValue evalExp(exp:moneyCon(real M), VENV env) = moneyVal(M);

//QuestionValue evalExp(exp:string(str S), VENV env) = strVal(S);

public QuestionValue evalExp(exp:id(str Id), VENV env)  = 
    env[Id]?  ? env[Id] : errorval(exp@location, "Uninitialized variable <Id>");
                                                                     
public QuestionValue evalExp(exp:or(Expression E1, Expression E2), VENV env) = 
   (strval(s1) := evalExp(E1, env) && 
    strval(s2) := evalExp(E2, env)) ? strVal(s1 + s2)
                                    : errorval(exp@location, "or requires string arguments");

public QuestionValue evalExp(exp:and(Expression E1, Expression E2), VENV env) = 
   (strval(s1) := evalExp(E1, env) && 
    strval(s2) := evalExp(E2, env)) ? strVal(s1 + s2)
                                    : errorval(exp@location, "and requires string arguments");
  
// EVALUATE INTEGER EXPRESSIONS                                  
public QuestionValue evalExp(exp:add(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 + n2)
                                    : errorval(exp@location, "+ requires integer arguments");
  
public QuestionValue evalExp(exp:sub(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 - n2)
                                    : errorval(exp@location, "- requires integer arguments");
                                    
public QuestionValue evalExp(exp:mul(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 * n2)
                                    : errorval(exp@location, "+ requires integer arguments");
  
public QuestionValue evalExp(exp:div(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 / n2)
                                    : errorval(exp@location, "- requires integer arguments");
                                                                        
public QuestionValue evalExp(exp:lt(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 < n2)
                                    : errorval(exp@location, "+ requires integer arguments");
  
public QuestionValue evalExp(exp:leq(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 <= n2)
                                    : errorval(exp@location, "- requires integer arguments");  
                                    
public QuestionValue evalExp(exp:gt(Expression E1, Expression E2), VENV env) { 
   println("in eval gt E1 : <E1> E2 : <E2>");
   println("in eval gt ENV : <env>");
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 > n2)
                                    : errorval(exp@location, "+ requires integer arguments");
                                    }
  
public QuestionValue evalExp(exp:geq(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 >= n2)
                                    : errorval(exp@location, "- requires integer arguments");      

public QuestionValue evalExp(exp:eq(Expression E1, Expression E2), VENV env) = 
   (intVal(n1) := evalExp(E1, env) && 
    intVal(n2) := evalExp(E2, env)) ? intVal(n1 == n2)
                                    : errorval(exp@location, "- requires integer arguments");  
                                    

// EVALUATE MONEY EXPRESSIONS                                  
public QuestionValue evalExp(exp:add(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 + n2)
                                    : errorval(exp@location, "+ requires money arguments");
  
public QuestionValue evalExp(exp:sub(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 - n2)
                                    : errorval(exp@location, "- requires money arguments");
                                    
public QuestionValue evalExp(exp:mul(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 * n2)
                                    : errorval(exp@location, "+ requires money arguments");
  
public QuestionValue evalExp(exp:div(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 / n2)
                                    : errorval(exp@location, "- requires money arguments");
                                                                        
public QuestionValue evalExp(exp:lt(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 < n2)
                                    : errorval(exp@location, "+ requires money arguments");
  
public QuestionValue evalExp(exp:leq(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 <= n2)
                                    : errorval(exp@location, "- requires money arguments");  
                                    
public QuestionValue evalExp(exp:gt(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 > n2)
                                    : errorval(exp@location, "+ requires money arguments");
  
public QuestionValue evalExp(exp:geq(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 >= n2)
                                    : errorval(exp@location, "- requires money arguments");      

public QuestionValue evalExp(exp:eq(Expression E1, Expression E2), VENV env) = 
   (moneyVal(n1) := evalExp(E1, env) && 
    moneyVal(n2) := evalExp(E2, env)) ? moneyVal(n1 == n2)
                                    : errorval(exp@location, "- requires money arguments"); 
                                   
// EVALUATE BOOLEAN EXPRESSIONS
public QuestionValue evalExp(exp:and(Expression E1, Expression E2), VENV env) = 
   (boolVal(n1) := evalExp(E1, env) && 
    boolVal(n2) := evalExp(E2, env)) ? boolVal(n1 && n2)
                                    : errorval(exp@location, "- requires boolean arguments");      

public QuestionValue evalExp(exp:or(Expression E1, Expression E2), VENV env) = 
   (boolVal(n1) := evalExp(E1, env) && 
    boolVal(n2) := evalExp(E2, env)) ? boolVal(n1 || n2)
                                    : errorval(exp@location, "- requires boolean arguments");                  