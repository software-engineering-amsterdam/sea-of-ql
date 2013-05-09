module TypeCheck::CheckExpression

import Prelude;
import syntax::Abstract;
import TypeCheck::QuestionChecker;

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

public alias FORMTENV = tuple[ rel[str id,str label, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors];

public FORMTENV checkExp(exp:boolCon(bool B), Type req, FORMTENV env) =	
	req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
public FORMTENV checkExp(exp:moneyCon(real M), Type req, FORMTENV env) = 
	req == money() ? env : addError(env, exp@location, required(req, "money"));
 
public FORMTENV checkExp(exp:integer(int I), Type req, FORMTENV env) = 
	req == integer() ? env : addError(env, exp@location, required(req, "integer"));
    
public FORMTENV checkExp(ext:strCon(str s), Type req, FORMTENV env) = 
	req == strCon() ? env : addError(env, exp@location, required(req, "string"));
 
public FORMTENV checkExp(exp:id(str id), Type req, FORMTENV env) 
{
  	if(env.question[id] == {})
  		return addError(env, exp@location, "Undeclared variable <id>");
  	else
  	{
  		rel[Type tp, bool result] tpid = range(env.question[id]);
  		list[Type] result = toList(tpid.tp);
  		return req == result[0] ? env : addError(env, exp@location, required(req, result[0]));
  	}  
}

// CHECK BOOLEAN EXPRESSIONS
public FORMTENV checkExp(exp:and(Expression E1, Expression E2), Type req, FORMTENV env) = 
	req == boolean() ? checkExp(E1, boolean(), checkExp(E2, boolean(), env))
                   : addError(env, exp@location, required(req, "boolean"));
                    
public FORMTENV checkExp(exp:or(Expression E1, Expression E2), Type req, FORMTENV env) =                      
 	req == boolean() ? checkExp(E1, boolean(), checkExp(E2, boolean(), env))
                   : addError(env, exp@location, required(req, "boolean")); 

public FORMTENV checkExp(exp:not(Expression E1), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(E1, boolean(), env)
                   : addError(env, exp@location, required(req, "boolean")); 
                   
// CHECK STRING EXPRESSIONS                    
public FORMTENV checkExp(exp:or(Expression E1, Expression E2), Type req, FORMTENV env) =                    
  	req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
public FORMTENV checkExp(exp:and(Expression E1, Expression E2), Type req, FORMTENV env) =                    
  	req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                 
public FORMTENV checkExp(exp:eq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
// CHECK INTEGER EXPRESSIONS                 
public FORMTENV checkIntExp(exp:add(Expression E1, Expression E2), Type req, FORMTENV env) =                        
	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
  
public FORMTENV checkIntExp(exp:sub(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:mul(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:div(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:lt(Expression E1, Expression E2), Type req, FORMTENV env) =
	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer test"));
                            
public FORMTENV checkIntExp(exp:leq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:gt(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

public FORMTENV checkIntExp(exp:geq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:eq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(E1, integer(), checkExp(E2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

// CHECK MONEY EXPRESSIONS
public FORMTENV checkExp(exp:add(Expression E1, Expression E2), Type req, FORMTENV env) =                        
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
public FORMTENV checkExp(exp:sub(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:mul(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:div(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:lt(Expression E1, Expression E2), Type req, FORMTENV env) =
 	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:leq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:gt(Expression E1, Expression E2), Type req, FORMTENV env) =                   
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

public FORMTENV checkExp(exp:geq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:eq(Expression E1, Expression E2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
                   