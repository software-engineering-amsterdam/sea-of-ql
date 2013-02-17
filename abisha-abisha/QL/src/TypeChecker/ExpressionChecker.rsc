module TypeChecker::ExpressionChecker

import Prelude;
import syntax::abstractSyntax;
import TypeChecker::QuestionChecker;

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
public FORMTENV checkExp(exp:and(Expression Exp1, Expression Exp2), Type req, FORMTENV env) 
{                        
	return req == boolean() ? checkExp(Exp1, boolean(), checkExp(Exp2, boolean(), env))
    	         : addError(env, exp@location, required(req, "boolean"));
}
  
public FORMTENV checkExp(exp:or(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == boolean() ? checkExp(Exp1, boolean(), checkExp(Exp2, boolean(), env))
                   : addError(env, exp@location, required(req, "boolean")); 

public FORMTENV checkExp(exp:not(Expression Exp1), Type req, FORMTENV env) =                      
 	req == boolean() ? checkExp(Exp1, boolean(), env)
                   : addError(env, exp@location, required(req, "boolean")); 
                   
// CHECK STRING EXPRESSIONS                    
public FORMTENV checkExp(exp:or(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                    
  	req == string() ? checkExp(Exp1, string(), checkExp(Exp2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
public FORMTENV checkExp(exp:and(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                    
  	req == string() ? checkExp(Exp1, string(), checkExp(Exp2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
// CHECK INTEGER EXPRESSIONS                 
public FORMTENV checkIntExp(exp:add(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                        
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
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
                   
public FORMTENV checkIntExp(exp:lt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) 
{
  	return req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer test"));
}
                   
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
  	req == integer() ? checkExp(Exp1, integer(), checkExp(Exp2, integer(), env))
                   : addError(env, exp@location, required(req, "integer"));

// CHECK MONEY EXPRESSIONS
public FORMTENV checkExp(exp:add(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                        
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
public FORMTENV checkExp(exp:sub(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:mul(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:div(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:lt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =
 	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:leq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:gt(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                   
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

public FORMTENV checkExp(exp:geq(Expression Exp1, Expression Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
                   
public FORMTENV checkExp(exp:eq(EXP Exp1, EXP Exp2), Type req, FORMTENV env) =                      
  	req == money() ? checkExp(Exp1, money(), checkExp(Exp2, money(), env))
                   : addError(env, exp@location, required(req, "money"));    