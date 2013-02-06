module typeChecker::ExpressionTypeChecker

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::TypeEnvironment;
import typeChecker::TypeCheck;

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
public QLTENV checkExp(exp:boolCon(bool B), Type req, QLTENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
public QLTENV checkExp(exp:moneyCon(real M), Type req, QLTENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
public QLTENV checkExp(exp:integer(int I), Type req, QLTENV env) { 
println("IN CHECK INT : <req>");
 return req == integer() ? env : addError(env, exp@location, required(req, "integer"));
 }
 
public QLTENV checkExp(exp:id(str id), Type req, QLTENV env) {
  if(env.question[id] == {}){
  	return addError(env, exp@location, "Undeclared variable <id>");
  }else{
  rel[Type tp, bool result] tpid = range(env.question[id]);
  println("TPID : <toList(tpid.tp)> req : <req> ");
  list[Type] result = toList(tpid.tp); 
  return req == result[0] ? env : addError(env, exp@location, required(req, result[0]));
  }  
}

// CHECK BOOLEAN EXPRESSIONS
public QLTENV checkExp(exp:and(Expression E1, Expression E2), Type req, QLTENV env) =                        
  req == boolean() ? checkExp(E1, boolean(), checkExp(E2, boolean(), env))
                   : addError(env, exp@location, required(req, "boolean"));
  
public QLTENV checkExp(exp:or(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == boolean() ? checkExp(E1, boolean(), checkExp(E2, boolean(), env))
                   : addError(env, exp@location, required(req, "boolean")); 

// CHECK MONEY EXPRESSIONS
public QLTENV checkExp(exp:add(Expression E1, Expression E2), Type req, QLTENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
public QLTENV checkExp(exp:sub(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:mul(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:div(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:lt(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:leq(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:gt(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

public QLTENV checkExp(exp:geq(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:eq(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

// CHECK STRING EXPRESSIONS                    
public QLTENV checkExp(exp:or(Expression E1, Expression E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
public QLTENV checkExp(exp:and(Expression E1, Expression E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
// CHECK INTEGER EXPRESSIONS                 
public QLTENV checkExp(exp:add(Expression E1, Expression E2), Type req, QLTENV env) =                        
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
  
public QLTENV checkExp(exp:sub(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:mul(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:div(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:lt(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:leq(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:gt(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

public QLTENV checkExp(exp:geq(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public QLTENV checkExp(exp:eq(Expression E1, Expression E2), Type req, QLTENV env) =                      
  req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
