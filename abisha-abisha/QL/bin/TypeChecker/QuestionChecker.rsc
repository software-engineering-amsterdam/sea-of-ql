//Still working on this

module TypeChecker::QuestionChecker

import Prelude;
import syntax::abstractSyntax;
import load::Load;
import Message;
import TypeChecker::ExpressionChecker;

//public alias QLTENV = tuple[ map[str,Type] uncomputedQuestionTypes,map[str,Type]computedQuestionTypes, set[str]labels, set[Message] errors];
public alias QLTENV = tuple[ rel[str id, str questionLabel, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors];

public QLTENV addError(QLTENV qlTenv, loc l, str msg) = qlTenv[errors = qlTenv.errors + <l, msg>];

public QLTENV addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp, bool isComputed) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp,isComputed>}]; 


QLTENV checkStatement(statement:ifStat(Expression exp, list[Statement] body), QLTENV env)
{
    QLTENV env0 = <{},[],()>;
    if(size(getChildren(exp)) == 1) return checkExp(exp,boolean() ,env);
    else
    {
    	list[Type] tp = getExpressionType(exp,env);
    	if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    	else
    	{
    		set[Type] s = toSet(tp);
    		if(size(s) == 1)
    		{  	
    			return checkExp(exp,tp[0],env);
    		}
    		else  // To compare Expr types
    		{				
    			return checkExp(exp,tp[0],env);
    		}
    	}
    }
}

//check if statement
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Statement] thenpart, list[Statement] elsepart), QLTENV env)
{
    list[Type] tp = getExpressionType(exp,env);
    if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    else
    {
    	env0 = checkExp(exp, tp[0], env);    
    	env1 = checkStatements(thenpart, env0);
    	env2 = checkStatements(elsepart, env1);
    	return env2;
	}
}

//check the uncomputedQuestion
QLTENV checkQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp) , QLTENV env)
{
	if(checkIdentifiers(question, env) == false) 
	return addError(env, question@location, "Identifier <id> error");
	else return addInstance(env, id , labelQuestion, tp, false );	
}

// check the computed question and save it in the environment

QLTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp) , QLTENV env)
{  
	if(checkIdentifiers(question,env) == false) 
	return addError(env, question@location, "Identifier <id> error");
	if(tp == integer())
	{
		env = checkIntExp(exp, tp, env);
	 	return addInstance(env, id, labelQuestion, tp, true);
	}
	 env = checkExp(exp, tp, env);
	 return addInstance(env, id, labelQuestion, tp, true);
}

QLTENV checkStatements(list[Statement] Body, QLTENV env)
{
	visit(Statement)
	{
        case Statement s: env = checkStatement(s,env);
    };
	return env;
}

// check the QL program
public QLTENV checkProgram(Program P)
{                                                
	if(program(str id, list[Statement] Body) := P)
  	{	 
    	QLTENV env = <{},[]>; 
     	env = checkStatement(Statement, env);
	 	return env;
  	}
  	else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;