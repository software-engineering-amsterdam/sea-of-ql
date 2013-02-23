module TypeCheck::CheckExpression

import Prelude;
import syntax::Abstract;
import TypeCheck::QuestionChecker;

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
public FORMTENV checkExp(exp:boolCon(bool B), Type req, FORMTENV env) =
  	req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
public FORMTENV checkExp(exp:moneyCon(real M), Type req, FORMTENV env) =
 	req == money() ? env : addError(env, exp@location, required(req, "money"));
 
public FORMTENV checkExp(exp:integer(int I), Type req, FORMTENV env) =
  	req == integer() ? env : addError(env, exp@location, required(req, "integer"));
 
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
public FORMTENV checkBoolExp(exp:and(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =
	req == boolean() ? checkExp(Exp1, boolean(), checkExp(Exp2, boolean(), env))
    	        	 : addError(env, exp@location, required(req, "boolean"));
  
public FORMTENV checkBoolExp(exp:or(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(Exp1, req, checkExp(Exp2, req, env))
                   : addError(env, exp@location, required(req, "boolean")); 

public FORMTENV checkBoolExp(exp:not(Expression Exp1), Type req, FORMTENV env) =                      
 	req == boolean() ? checkExp(Exp1, boolean(), env)
                   : addError(env, exp@location, required(req, "boolean")); 
                   
public FORMTENV checkBoolExp(exp:lt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =  
  	 req == boolean() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkBoolExp(exp:leq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkBoolExp(exp:gt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

public FORMTENV checkBoolExp(exp:geq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkBoolExp(exp:eq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean()||req == integer()||req == String() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "must be same type"));
                   
public FORMTENV checkBoolExp(exp:neq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean()||req == integer()||req == String()? checkExp(Exp1, req, checkExp(Exp2, req), env)
                   : addError(env, exp@location, required(req, "must be same type"));
                   
                  
// CHECK INTEGER EXPRESSIONS                 

public FORMTENV checkIntExp(exp:add(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                        
  	req == integer()||req == String() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
  
public FORMTENV checkIntExp(exp:sub(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:mul(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:div(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                                 
public FORMTENV checkIntExp(exp:lt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =  
  	 req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer test"));
                   
public FORMTENV checkIntExp(exp:leq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:gt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

public FORMTENV checkIntExp(exp:geq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));
                   
public FORMTENV checkIntExp(exp:eq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == integer()||req == string() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "must be same type"));

// CHECK MONEY EXPRESSIONS
public FORMTENV checkMonExp(exp:add(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                        
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
public FORMTENV checkMonExp(exp:sub(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:mul(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:div(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:lt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =
 	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:leq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:gt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                   
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

public FORMTENV checkMonExp(exp:geq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkMonExp(exp:eq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));    