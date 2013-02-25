module template::EvaluateExpression

import Prelude;
import syntax::AbstractSyntax;

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
public str evaluateExp(exp:boolCon(bool B), Type req) {
  return req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
  }
 
public str evaluateExp(exp:moneyCon(real M), Type req) {
 return req == money() ? env : addError(env, exp@location, required(req, "money"));
 }
 
public str evaluateExp(exp:integer(int I), Type req) {
  return req == integer() ? env : addError(env, exp@location, required(req, "integer"));
 }
//public QLTENV checkExp(ext:string(str s), Type req, QLTENV env) =
//  req == string() ? env : addError(env, exp@location, required(req, "string"));
 
public str evaluateExp(exp:id(str id), Type req) {
	return id;  
}

// CHECK BOOLEAN EXPRESSIONS
public str evaluateExp(exp:and(Expression E1, Expression E2), Type req) {                        
  str e1 = evaluateExp(E1, req);
  str e2 = evaluateExp(E2, req);
  return "eval(<e1>.checked && <e2>.checked)"; 
}
  
public str evaluateExp(exp:or(Expression E1, Expression E2), Type req) {                     
  str e1 = evaluateExp(E1, req);
  str e2 = evaluateExp(E2, req);
  return "eval(<e1>.checked || <e2>.checked)"; 
}

public str evaluateExp(exp:not(Expression E1), Type req) =                      
  req == boolean() ? evaluateExp(E1, boolean(), env)
                   : addError(env, exp@location, required(req, "boolean")); 
                   
// CHECK STRING EXPRESSIONS                    
public str evaluateExp(exp:or(Expression E1, Expression E2), Type req) =                    
  req == string() ? evaluateExp(E1, string(), evaluateExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
public str evaluateExp(exp:and(Expression E1, Expression E2), Type req) =                    
  req == string() ? evaluateExp(E1, string(), evaluateExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
// CHECK MONEY EXPRESSIONS
public str evaluateExp(exp:add(Expression E1, Expression E2), Type req) {                       
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value + +<e2>.value)";   // Fix but just for positive numbers
                   }
  
public str evaluateExp(exp:sub(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(<e1>.value - <e2>.value)";
                   }
                   
public str evaluateExp(exp:mul(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value * +<e2>.value)";
                   }
                   
public str evaluateExp(exp:div(Expression E1, Expression E2), Type req){
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value / +<e2>.value)";
                   }
                   
public str evaluateExp(exp:lt(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value \< +<e2>.value)";
                   }
                   
public str evaluateExp(exp:leq(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value \<= +<e2>.value)";
                   }
                   
public str evaluateExp(exp:gt(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value \> +<e2>.value)";
                   }

public str evaluateExp(exp:geq(Expression E1, Expression E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value \>= +<e2>.value)";
                   }
                   
public str evaluateExp(exp:eq(EXP E1, EXP E2), Type req) {
  str e1 = evaluateExp(E1, money());
  str e2 = evaluateExp(E2, money());
  return "eval(+<e1>.value == +<e2>.value)";
                   }