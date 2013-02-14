module TypeChecker::QuestionChecker

//module typeChecker::TypeCheck

import Prelude;
import syntax::abstractSyntax;
import load::Load;
//import typeChecker::ExpressionTypeChecker;
//import typeChecker::TypeEnvironment;
//import typeChecker::TypeHelper;

public alias QLTENV = tuple[ rel[str id, str questionLabel, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors];

public QLTENV addError(QLTENV qlTenv, loc l, str msg) = qlTenv[errors = qlTenv.errors + <l, msg>];
// to add an instance of a qltenv item
public QLTENV addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp, bool isComputed) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp,isComputed>}]; //= qlTenv.errors + <l, msg> 


QLTENV checkStatement(statement:ifStat(Expression exp, list[Statement] body), QLTENV env)
{
    QLTENV env0 = <{},[]>;
    if(size(getChildren(exp)) == 1) return checkExp(exp,boolean() ,env);
    else
    {
    	list[Type] tp = getExpressionType(exp,env);
    	if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    	else
    	{
    		set[Type] s = toSet(tp);
    		if(size(s) == 1)// To compare expression when they have equal tp
    		{  	
    			return checkExp(exp,tp[0],env);
    		}
    		else  // To compare expression or and and when the types are for example boolean || money < money
    		{				
    			println("Set is : <s>");
    			println("Not implemented");
    			return checkExp(exp,tp[0],env);
    		}
    	}
    }
}

/** Method to check an if else statement
* @param statement the if else statement
* @param thenpart thenpart of the statement
* @param elsepart elsepart of the statement
* @return env2 a QL type environment with the checked statement
*/
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Statement] thenpart, list[Statement] elsepart), QLTENV env)
{
    list[Type] tp = getExpressionType(exp,env);
    if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    else
    {
    	env0 = checkExp(exp, tp[0], env);    // check standart libary Message !!!
    	env1 = checkStatements(thenpart, env0);
    	env2 = checkStatements(elsepart, env1);
    	return env2;
	}
}

/** Method to check easy question and save it in the environment
* @param question the easy question
* @param env the QL Type environment
* @return env the enviroment
*/
QLTENV checkQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp) , QLTENV env)
{
	if(checkIdentifiers(question, env) == false) 
	return addError(env, question@location, "Identifier <id> error");
	else return addInstance(env, id , labelQuestion, tp, false );	
}

/** Method to check computed question and save it in the environment
* @param question the computed question
* @param env the QL Type environment
* @return env the enviroment
*/

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

QLTENV checkStatements(list[Statement] Body, QLTENV env){
	visit(Statement){
        case Statement s: env = checkStatement(s,env);
      };
	return env;
}

/** Method to check the body of the QL program
* @param Body the body of the QL program
* @param env the QL Type enviroment
* @return QLTENV the enviroment
*/
/*QLTENV checkStatement(list[Statement] Body, QLTENV env){
	visit(Statement){
     	case Question q : env = checkQuestion(q,env);
        case Statement s: env = checkStatement(s,env);
      };
	return env;
}
*/
// check the QL program
public QLTENV checkProgram(Program P){                                                
  if(program(str id, list[Statement] Body) := P){	 
     QLTENV env = <{},[]>; 
     env = checkStatement(Statement, env);
	 return env;
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;