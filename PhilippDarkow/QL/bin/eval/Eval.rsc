module eval::Eval

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import eval::EvalTypeEnvironment;

// Evaluate a statement	
VENV evalStatement(statement:ifStat(Expression exp, list[Body] body), VENV env){
	println("in eval Statement <exp>");
	evalExp(exp,env);	
}


VENV evalStat(stat:ifElseStat(EXP Exp, 
                              list[STATEMENT] Stats1,
                              list[STATEMENT] Stats2),
              VENV env) =
  evalStats(evalExp(Exp, env) != moneyVal(0) ? Stats1 : Stats2, env); 
 


/** Method to evaluate simple questions
* @param question the simple question
* @param env the type environment
* @return env a instance added to the VENV
* @author Philipp
*/    
VENV evalQuestion(question:easyQuestion(str id, str labelQuestion, Type tp) , VENV env){
	println("in eval simple Question <tp>");
	visit(tp){
		case money() : return addInstance(env, id , moneyVal(0.0));
		case integer() : return addInstance(env, id , intVal(0));
		case string() : return addInstance(env, id , strVal(""));
		case boolean() : return addInstance(env, id , boolVal(false));
	}
}


VENV evalQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp), VENV env){
	println("in eval computed question");
	
}

/** Method to eval the Body of the QL language
* @param Body the Body of the QL
* @param env the VENV 
* @return env the evaluated VENV
* @author Philipp
*/
VENV evalBody(list[Body] Body, VENV env){
	println("In EVAL Body");
	visit(Body){
		case Question q : {
			println("In Q : <q>");
			env = evalQuestion(q, env);
		}
		case Statement s : {
			println("in S : <s>");
			env = evalStatement(s,env);
		}
	}
	return env;
}

// Evaluate a QL program
public VENV evalProgram(Program P){
  if(program(str questionnaireName,list[Body] Body) := P){
     println("EVAL Body : <Body>"); 
     VENV env = ();      
     env = evalBody(Body, env); 
     println(env);
     return env;
  } else
    throw "Cannot happen";
}

public VENV evalProgram(str txt) = evalProgram(load(txt));