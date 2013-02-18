//Still working on this

module TypeChecker::QuestionChecker

import Prelude;
import syntax::abstractSyntax;
import TypeChecker::ExpressionChecker;
import load::Load;

//alias TENV = tuple[ map[QuestionId, Type] question, list[tuple[loc l, str msg]] errors]; 

alias FORMTENV = tuple[ map[QuestionId id, Type] question, list[tuple[loc l, str msg]] errors]; 

FORMTENV addError(FORMTENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];  

// check a statement

/*FORMTENV checkStatement(statement:asgStat(QuestionireId Id, EXP Exp), FORMTENV env) 
{                        
	if(!env.question[Id]?)
    return addError(env, statement@location, "Undeclared variable <Id>");
  	tpid = env.question[Id];
  	return checkExp(Exp, tpid, env);
}*/
	
FORMTENV checkStat(stat:ifElseStat(EXP Exp,                                             
                              list[Statement] Stats1,//If part
                              list[Statement] Stats2),//else part
               	FORMTENV env)
               	{
    				env0 = checkExp(Exp, natural(), env);
    				env1 = checkStats(Stats1, env0);
    				env2 = checkStats(Stats2, env1);
    				return env2;
				}

// check a list of statements
FORMTENV checkStatement(list[Statement] Stats1, FORMTENV env) 
{                                 
	for(S <- Stats1)
	{
    	env = checkStat(S, env);
  	}
  	return env;
}

// check a QL program
public FORMTENV checkProgram(Program P)
{                                                
	if(program(str id, list[Statement] Stats) := P)
	{
    	FORMTENV env = <{},[],()>;    	
    	return checkStatement(Statement, env);
  	} 
  	else
    throw "Cannot happen";
}
                                                                                    
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;