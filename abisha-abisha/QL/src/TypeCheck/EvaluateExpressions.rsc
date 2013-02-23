module TypeCheck::EvaluateExpressions


import Prelude;
import syntax::Abstract;
import load::Load;
import TypeCheck::CheckExpression;
import TypeCheck::QuestionChecker;

//alias QuestinireId=str;


data FormValue = natval(int n) |boolVal(bool B) | strVal(str s) | moneyVal(int M)|intVal(int i)|errorVal(loc l, str msg);
//data FormValue = natval(int n) | strval(str s) | errorval(loc l, str msg); 

alias VENV = map[str, FormValue];   

// Evaluate Expressions.

FormValue evalExp(exp:moneyCon(int M), VENV env) = moneyVal(M); 

FormValue evalExp(exp:boolCon(bool B), VENV env) = boolVal(B);

FormValue evalExp(exp:id(QuestionId Id), VENV env)  = env[Id]?  ? env[Id] : errorval(exp@location, "Uninitialized variable <Id>");

//evaluate strings
FormValue evalExp(exp:add(EXP E1, EXP E2), VENV env) =  (natval(n1) := evalExp(E1, env) && 
														natval(n2) := evalExp(E2, env)) ? strval(n1 + n2)
                                    					: errorval(exp@location, "+ requires string arguments");

FormValue evalExp(exp:sub(EXP E1, EXP E2), VENV env) = (natval(n1) := evalExp(E1, env) && 
    													natval(n2) := evalExp(E2, env)) ? strval(n1 - n2)
                                    					: errorval(exp@location, "- requires string arguments");

FormValue evalExp(exp:eq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 == n2)
                                    					: errorval(exp@location, "eq requires string arguments");
FormValue evalExp(exp:lt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 < n2)
                                    					: errorval(exp@location, "lt requires string arguments"); 
FormValue evalExp(exp:leq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 <= n2)
                                    					: errorval(exp@location, "leq requires string arguments");                                    					                                   					                                    					                                    					

FormValue evalExp(exp:gt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 > n2)
                                    					: errorval(exp@location, "gt requires string arguments");
FormValue evalExp(exp:geq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 >= n2)
                                    					: errorval(exp@location, "geq requires string arguments");      
FormValue evalExp(exp:neq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 != n2)
                                    					: errorval(exp@location, "== requires integer arguments"); 

//evaluate integers
FormValue evalExp(exp:add(EXP E1, EXP E2), VENV env) =  (natval(n1) := evalExp(E1, env) && 
														natval(n2) := evalExp(E2, env)) ? natval(n1 + n2)
                                    					: errorval(exp@location, "+ requires integer arguments");

FormValue evalExp(exp:sub(EXP E1, EXP E2), VENV env) = (natval(n1) := evalExp(E1, env) && 
    													natval(n2) := evalExp(E2, env)) ? natval(n1 - n2)
                                    					: errorval(exp@location, "- requires integer arguments");
FormValue evalExp(exp:mul(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 * n2)
                                    					: errorval(exp@location, "mul requires integer arguments");
                                    					
FormValue evalExp(exp:div(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 / n2)
                                    					: errorval(exp@location, "div requires integer arguments");
                                    					
FormValue evalExp(exp:eq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 == n2)
                                    					: errorval(exp@location, "eq requires integer arguments");
                                    					
FormValue evalExp(exp:lt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 < n2)
                                    					: errorval(exp@location, "lt requires integer arguments"); 
                                    					
FormValue evalExp(exp:leq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 <= n2)
                                    					: errorval(exp@location, "leq requires integer arguments");                        					                                   					                                    					                                    					

FormValue evalExp(exp:gt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 > n2)
                                    					: errorval(exp@location, "gt requires integer arguments");
                                    					
FormValue evalExp(exp:geq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 >= n2)
                                    					: errorval(exp@location, "geq requires integer arguments");  
                                    					    
FormValue evalExp(exp:neq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? natval(n1 != n2)
                                    					: errorval(exp@location, "== requires integer arguments");   

//eveluate money

FormValue evalExp(exp:add(EXP E1, EXP E2), VENV env) =  (natval(n1) := evalExp(E1, env) && 
														natval(n2) := evalExp(E2, env)) ? moneyVal(n1 + n2)
                                    					: errorval(exp@location, "+ requires money arguments");

FormValue evalExp(exp:sub(EXP E1, EXP E2), VENV env) = (natval(n1) := evalExp(E1, env) && 
    													natval(n2) := evalExp(E2, env)) ? moneyVal(n1 - n2)
                                    					: errorval(exp@location, "- requires money arguments");
FormValue evalExp(exp:mul(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 * n2)
                                    					: errorval(exp@location, "mul requires money arguments");
                                    					
FormValue evalExp(exp:div(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 / n2)
                                    					: errorval(exp@location, "div requires money arguments");
                                    					
FormValue evalExp(exp:eq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 == n2)
                                    					: errorval(exp@location, "eq requires money arguments");
                                    					
FormValue evalExp(exp:lt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 < n2)
                                    					: errorval(exp@location, "lt requires money arguments"); 
                                    					
FormValue evalExp(exp:leq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 <= n2)
                                    					: errorval(exp@location, "leq requires money arguments");                        					                                   					                                    					                                    					

FormValue evalExp(exp:gt(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 > n2)
                                    					: errorval(exp@location, "gt requires money arguments");
                                    					
FormValue evalExp(exp:geq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 >= n2)
                                    					: errorval(exp@location, "geq requires money arguments");  
                                    					    
FormValue evalExp(exp:neq(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? moneyVal(n1 != n2)
                                    					: errorval(exp@location, "== requires money arguments"); 

//evaluate boolean

FormValue evalExp(exp:or(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? boolVal(n1 || n2)
                                    					: errorval(exp@location, "or requires boolean arguments");                                                                     

FormValue evalExp(exp:and(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? boolVal(n1 && n2)
                                    					: errorval(exp@location, "and requires boolean arguments");
VENV evalStatement(Statement:ifStat(EXP Exp,
								list[STATEMENT] Stats),
								VENV env) = evalStats(evalExp(Exp, env) != natval(0) ? Stats, env);                                    					
                                    					
VENV evalStat(stat:ifElseStat(EXP Exp,
								list[STATEMENT] Stats1,
								list[STATEMENT] Stats2),
								VENV env) = evalStats(evalExp(Exp, env) != natval(0) ? Stats1 : Stats2, env);

VENV evalQuestion(question:uncomputedQuestion(str id,str labelQuestion,Type tp),VENV env)
{
	return addInstance(env, id, labelQuestion, tp);
}

VENV evalQuestion(question:computedQuestion(str id,str labelQuestion,Type tp),VENV env)
{
	return addInstance(env, id, labelQuestion, tp);
}

VENV evalStatement(list[Statement]Stat, VENV env)
{
	return evalStatement(s,env);
}

// Evaluate a list of statements
VENV evalStats(list[Statement] Stats1, VENV env) 
{
  	for(S <- Stats1)
  	{
    	env = evalStat(S, env);
  	}
  	return env;
}

// Evaluate the form
public VENV evalForm(Form P)
{
	println("ok in eval");
  	if(form(Expression exp, list[Statement]Stats) := P)
  	{
  		VENV env= <{},[]>;
		env = evalStatement(Stats, env);
		return  env;
	} 
  	else
  	  	throw "Cannot happen";
}

public VENV evalForm(str txt) = evalForm(load(txt));