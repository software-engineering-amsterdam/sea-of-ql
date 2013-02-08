module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::ExpressionTypeChecker;
import typeChecker::TypeEnvironment;

Type findExpressionType(Expression exp, QLTENV env){
	//println("In find exp : <toString(getChildren(exp))>");
	//println("ENV : <env>");
	str s = toString(getChildren(exp)[0]);
	//println("S : <s>");
	for(b <- env.question){
		//println("B : <b>");
		if(b.id == s){
			println("match");
			return b.tp;
		}
	}
}

list[Type] getExpressionType(Expression exp, QLTENV env){
	println("in get EXpression Type : <exp>");
	println("Type is : <env.question>");
	// Making a set to check the two types
	list[Type] types = [];
	println("SHOW CHILDREN : <getChildren(exp)>");
	for(s <- getChildren(exp)){
		println("S is : <s>");
		Type tp = findExpressionType(s, env);
		println("Tp is : <tp>");
		if(tp in types){
			println("dont add");
		}else{
			types += tp;
		}
	}
	return types;
}


/** Method to check if statement 
* @param statement the if statement
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkStatement(statement:ifStat(Expression exp, list[Body] body), QLTENV env){
    println("EXP : <exp>"); 
    println("ENV : <env>");
    // I need to get the type of the exp if it is an id
    QLTENV env0 = <{},[]>;
    if(size(getChildren(exp)) == 1){  // if the node is currently just a boolean
    	b = checkExp(exp,boolean() ,env);
    	println("b : <b>");
    	return b;
    }else{
    	// Get the type of the exp
    	list[Type] tp = getExpressionType(exp,env);
    	println("LIST IS : <tp> SIZE : <size(tp)>");
    	if(size(tp) == 1){
    		if(tp[0] == integer()){
    		b = checkIntExp(exp,tp[0],env);
    		return b;
    		}else{
    		b = checkExp(exp,tp[0],env);
    		return b;
    		}
    		println("b : <b>");
    		return b;
    	}else{
    		//Error Handling
    		println("tp is  : <tp>");
    		if(tp[0] == integer()){
    			b = checkIntExp(exp,tp[0],env);
    			println("b2 : <b>");
    			return b;	
    		}else{
    		b = checkExp(exp,tp[0],env);
    		println("b2 : <b>");
    		return b;
    		}
    	}
    }

   // if(size(env0.errors) != 0)
   // 	return addError(env0, env0.errors[0].l, env0.errors[0].msg);   // check standart libary Message !!!
   // return env;
}

// check if else statement
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart), QLTENV env){
    println("EXP : <Exp>");
    visit(Exp){
    	case _ : 
    		println("Integer case");

    }
    println(env0); 
   // env0 = checkExp(Exp, boolean(), env);
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
	if(checkIdentifiers(env) == false) return addError(env, question@location, "Identifier <id> is declared two times");
	else return addInstance(env, id , labelQuestion, tp, false );	
}

/** Method to check computed question and save it in the environment   --> need now to check the all expression of the question
* @param question the computed question
* @param env the QL Type environment
* @return env the enviroment
* @author Philipp
*/
QLTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp) , QLTENV env){  //, Expression exp
	println("check computed question");
	if(checkIdentifiers(env) == false) return addError(env, question@location, "Identifier <id> is declared two times");
	// need to check the expression
	else {
	println("EXP : <exp>");
	 env = checkExp(exp, tp, env);
	 return addInstance(env, id, labelQuestion, tp, true);
	 } 
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
		println("Error in check Identifiers");
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
	//for(s <- Body){
	visit(Body){
     	case Question q : {
     			//println("IN small q <q>");
    			//println("ENV : <env>");
    			env = checkQuestion(q,env);
    	    }
        case Statement s: {
        		println("IN small s <s>");
        		//println("ENV : <env>");
        		env = checkStatement(s,env);
        		//println("ENV2 : <env>");
        	}
      };
	//}
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
