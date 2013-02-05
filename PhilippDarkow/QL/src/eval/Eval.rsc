module eval::Eval

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import typeChecker::TypeCheck;
import eval::EvalTypeEnvironment;

// First we introduce a data type QuestionValue that wraps all possible values that can occur at run-time.
//data QuestionValue = boolVal(bool b) | strVal(str s) | moneyVal (real m) | intVal(int i) | errorval(loc l, str msg);  

//alias VENV = map[str , QuestionValue];                                       

// Evaluate Expressions.
QuestionValue evalExp(exp:moneyCon(int M), VENV env) = moneyVal(N);

//QuestionValue evalExp(exp:string(str S), VENV env) = strVal(S);

QuestionValue evalExp(exp:id(QuestionId Id), VENV env)  = 
    env[Id]?  ? env[Id] : errorval(exp@location, "Uninitialized variable <Id>");

QuestionValue evalExp(exp:add(EXP E1, EXP E2), VENV env) = 
   (natval(n1) := evalExp(E1, env) && 
    natval(n2) := evalExp(E2, env)) ? moneyVal(n1 + n2)
                                    : errorval(exp@location, "+ requires money arguments");
  
QuestionValue evalExp(exp:sub(EXP E1, EXP E2), VENV env) = 
   (natval(n1) := evalExp(E1, env) && 
    natval(n2) := evalExp(E2, env)) ? moneyVal(n1 - n2)
                                    : errorval(exp@location, "- requires money arguments");
                                                                     
QuestionValue evalExp(exp:or(EXP E1, EXP E2), VENV env) = 
   (strval(s1) := evalExp(E1, env) && 
    strval(s2) := evalExp(E2, env)) ? strVal(s1 + s2)
                                    : errorval(exp@location, "or requires string arguments");

QuestionValue evalExp(exp:and(EXP E1, EXP E2), VENV env) = 
   (strval(s1) := evalExp(E1, env) && 
    strval(s2) := evalExp(E2, env)) ? strVal(s1 + s2)
                                    : errorval(exp@location, "and requires string arguments");

// Evaluate a statement

//VENV evalStat(stat:asgStat(str Id, EXP Exp), VENV env) {
//  env[Id] = evalExp(Exp, env);
//  return env;
//}
	
VENV evalStat(stat:ifElseStat(EXP Exp, 
                              list[STATEMENT] Stats1,
                              list[STATEMENT] Stats2),
              VENV env) =
  evalStats(evalExp(Exp, env) != moneyVal(0) ? Stats1 : Stats2, env);

// Evaluate a list of statements
VENV evalStats(list[Statement] Stats1, VENV env) {
  for(S <- Stats1){
      env = evalStat(S, env);
  }
  return env;
}
  
// Eval declarations

VENV evalDecls (list[Question] results) =   
   ( Id : ( tp == money() ? moneyVal(0) : strVal("")) | result(QuestionId Id, TYPE tp) <- results); // | results(QuestionId Id, TYPE tp) <- results); 
 // (results.tp == money() ? moneyVal(0) : strVal(""))
 
VENV evalStatement(statement:ifStat(), VENV env){
	println("in eval Statement");
	
}
    
VENV evalQuestion(question:easyQuestion(str id, str labelQuestion, Type tp) , VENV env){
	println("in eval Question");
	return addInstance(env, id , (tp == money() ? moneyVal(0) : intVal(0)));
}

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