module typeChecker::ExpressionTypeChecker

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::TypeEnvironment;

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
public QLTENV checkExp(exp:boolCon(bool B), Type req, QLTENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
public QLTENV checkExp(exp:moneyCon(int I), Type req, QLTENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
public QLTENV checkExp(exp:id(str id), Type req, QLTENV env) {
  if(env.question[id] == {}){
  	return addError(env, exp@location, "Undeclared variable <id>");
  }else{
  tpid = range(env.question[id]);
  println("TPID : <getOneFrom(tpid)>");
  return req == getOneFrom(tpid) ? env : addError(env, exp@location, required(req, getOneFrom(tpid)));
  } 
  
}

public QLTENV checkExp(exp:add(EXP E1, EXP E2), Type req, QLTENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
public QLTENV checkExp(exp:sub(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:mul(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:div(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:lt(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:leq(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:gt(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

public QLTENV checkExp(exp:geq(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:eq(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public QLTENV checkExp(exp:or(EXP E1, EXP E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
public QLTENV checkExp(exp:and(EXP E1, EXP E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
