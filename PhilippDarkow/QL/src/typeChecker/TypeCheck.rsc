module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::ExpressionTypeChecker;
import typeChecker::TypeEnvironment;

/** Method to check if statement 
* @param statement the if statement
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkStatement(statement:ifStat(Expression exp, list[Body] body), QLTENV env){
    println("EXP : <exp>"); 
    env0 = checkExp(exp, boolean(), env);
    println();
    if(size(env0.errors) != 0)
    	return addError(env0, env0.errors[0].l, env0.errors[0].msg);   // check standart libary Message !!!
    return env;
}

// check if else statement
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart), QLTENV env){
    println("EXP : <Exp>"); 
    env0 = checkExp(Exp, boolean(), env);
    if(size(env0.errors) != 0)
    	return addError(env0, env0.errors[0].l, env0.errors[0].msg);    // check standart libary Message !!!
    env1 = checkQuestionStats(Stats1, env0);
    return env;
}

/** Method to check easy question and save it in the environment
* @param question the easy question
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkQuestion(question:easyQuestion(str id, str labelQuestion, Type tp) , QLTENV env){
	return addInstance(env, id , labelQuestion, tp );	
}

/** Method to check computed question and save it in the environment
* @param question the computed question
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp) , QLTENV env){
	println("check computed question");
	env = <{< id , labelQuestion, tp >} , []>;
	println("ENV : <env>");
	return env;
}

/** Method to check for double Identifiers
* @param env the QL Type environment
* @return true if no double Idenfiers
* @author Philipp
*/
bool checkIdentifiers(QLTENV env){
	if(size(env.question) == size(env.question.id)){
		return true;
	}else{
		println("in add error");
		return false;
	}
}

/** Method to check the body of the QL program
* @param Body the body of the QL program
* @param env the QL Type enviroment
* @return QLTENV the enviroment
* @author Philipp
*/
QLTENV checkBody(list[Body] Body, QLTENV env){
	for(s <- Body){
	visit(Body){
     	case Question q : {
    			env = checkQuestion(q,env);   // I can put the check in the checkQuestion !!!!
    			if(checkIdentifiers(env) == false) return addError(env, q@location, "Identifier double declared");
    	    }
        case Statement s: {
        		env = checkStatement(s,env);
        	}
      };
	}
	return env;
}

// check a QL program
public QLTENV checkProgram(Program P){                                                
  if(program(str id, list[Body] Body) := P){	 
     QLTENV env = <{},[]>; 
     env = checkBody(Body, env);
     println("ENV : <env>"); 
	 return env;
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
