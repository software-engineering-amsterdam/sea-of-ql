module TypeChecker::Evaluate

import Prelude;
import syntax::abstractSyntax;
import load::Load;
import TypeChecker::ExpressionChecker;
import TypeChecker::QuestionChecker;

alias QuestinireId=str;


data FormValue = boolVal(bool B) | strVal(str s) | moneyVAl(int M)|intVal(int i)|errorVal(loc l, str msg);
data FormValue = natval(int n) | strval(str s) | errorval(loc l, str msg); 

alias VENV = map[str, FormValue];                                       

// Evaluate Expressions.

FormValue evalExp(exp:moneyCon(int M), VENV env) = moneyVal(M); 

FormValue evalExp(exp:boolCon(bool B), VENV env) = boolVal(B);

FormValue evalExp(exp:id(QuestionireId Id), VENV env)  = env[Id]?  ? env[Id] : errorval(exp@location, "Uninitialized variable <Id>");

FormValue evalExp(exp:add(EXP E1, EXP E2), VENV env) =  (natval(n1) := evalExp(E1, env) && 
														natval(n2) := evalExp(E2, env)) ? natval(n1 + n2)
                                    					: errorval(exp@location, "+ requires natural arguments");
  
FormValue evalExp(exp:sub(EXP E1, EXP E2), VENV env) = (natval(n1) := evalExp(E1, env) && 
    													natval(n2) := evalExp(E2, env)) ? natval(n1 - n2)
                                    					: errorval(exp@location, "- requires natural arguments");

FormValue evalExp(exp:or(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 + n2)
                                    					: errorval(exp@location, "or requires string arguments");                                                                     

FormValue evalExp(exp:and(EXP E1, EXP E2), VENV env) = (strval(n1) := evalExp(E1, env) && 
    													strval(n2) := evalExp(E2, env)) ? strval(n1 + n2)
                                    					: errorval(exp@location, "andrequires string arguments");

	
VENV evalStat(stat:ifElseStat(EXP Exp,list[STATEMENT] Stats1,list[STATEMENT] Stats2),
              
VENV env) = evalStats(evalExp(Exp, env) != natval(0) ? Stats1 : Stats2, env);

// Evaluate a list of statements
VENV evalStats(list[Statement] Stats1, VENV env) 
{
  	for(S <- Stats1)
  	{
    	env = evalStat(S, env);
  	}
  	return env;
}
  
// Eval declarations
VENV evalDecls(list[Question] results) =( Id : (tp == natural() ? natval(0) : strval(""))  | result(QuestionireId Id, TYPE tp) <- results);

VENV evalQuestion(question:uncomputedQuestion(str id,str labelQuestion,Type tp),VENV env)
{
	return addInstance(env, id, labelQuestion, tp);
}

VENV evalStatement(list[Statement]Stat, VENV env)
{
	visit(Statement)
	{
		case Question q:
		{
			evalQuestion(q,env);
		}
		case Statement s:
		{
			println("in s:<s>");
		}
	}
}
// Evaluate the form

public VENV evalProgram(Program P)
{
  if(program(Expression exp, list[Statement]body) := P)
  {
  	VENV env= <{},[]>;
    VENV env = evalStatement(Statement,env);
    return evalStats(Series, env);
  } 
  else
    throw "Cannot happen";
}

public VENV evalForm(str txt) = evalForm(load(txt));