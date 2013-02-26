module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import typeChecker::ExpressionTypeChecker;
import typeChecker::TypeEnvironment;
import typeChecker::TypeHelper;
import util::IDE;

/** Method to check if statement 
* @param statement the if statement
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkStatement(statement:ifStat(Expression exp, list[Body] body), QLTENV env){
    QLTENV env0 = <{},[]>;
    if(size(getChildren(exp)) == 1) return checkExp(exp,boolean() ,env);
    else{
    	list[Type] tp = getExpressionType(exp,env);
    	println("TYPE LIST IS : <tp>");
    	if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    	else{
    		set[Type] s = toSet(tp);
    		if(size(s) == 1){  	// To compare expression when they have equal tp
    			return checkExp(exp,tp[0],env);
    		}else {				// // To compare expression or and and when the types are for example boolean || money < money
    			println("Set is : <s>");
    			println("Need to be implemented");
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
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart), QLTENV env){
    list[Type] tp = getExpressionType(exp,env);
    if(tp[0] == integer()) return checkIntExp(exp,tp[0],env);
    else{
    	env0 = checkExp(exp, tp[0], env);    // check standart libary Message !!!
    	env1 = checkBodyJustStatements(thenpart, env0);
    	env2 = checkBodyJustStatements(elsepart, env1);
    	return env2;
	}
}

/** Method to check easy question and save it in the environment
* @param question the easy question
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkQuestion(question:easyQuestion(str id, str labelQuestion, Type tp) , QLTENV env){
	if(checkIdentifiers(question, env) == false) return addError(env, question@location, "Identifier <id> is declared two times");
	else return addInstance(env, id , labelQuestion, tp, false );	
}

/** Method to check computed question and save it in the environment
* @param question the computed question
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp) , QLTENV env){  
	if(checkIdentifiers(question,env) == false) return addError(env, question@location, "Identifier <id> is declared two times");
	if(tp == integer()){
		env = checkIntExp(exp, tp, env);
	 	return addInstance(env, id, labelQuestion, tp, true);
	}
	 env = checkExp(exp, tp, env);
	 return addInstance(env, id, labelQuestion, tp, true);
}

QLTENV checkBodyJustStatements(list[Body] Body, QLTENV env){
	visit(Body){
        case Statement s: env = checkStatement(s,env);
      };
	return env;
}

/** Method to check the body of the QL program
* @param Body the body of the QL program
* @param env the QL Type enviroment
* @return QLTENV the enviroment
* @author Philipp
*/
QLTENV checkBody(list[Body] Body, QLTENV env){
	visit(Body){
     	case Question q : env = checkQuestion(q,env);
        case Statement s: env = checkStatement(s,env);
      };
	return env;
}

// check a QL program
public QLTENV checkProgram(Program P){                                                
  if(program(str id, list[Body] Body) := P){	 
     QLTENV env = <{},[]>; 
     env = checkBody(Body, env);
	 return env;
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;

public set[Message] checkingQL(Program p) = getErrors(checkProgram(p));
