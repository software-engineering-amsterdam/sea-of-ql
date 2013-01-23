module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::Mapping;

alias QLTENV = tuple[ rel[str id, str questionLabel, Type tp] question, list[tuple[loc l, str msg]] errors];

QLTENV addError(QLTENV qlTenv, loc l, str msg) = qlTenv[errors = qlTenv.errors + <l, msg>];
// to add an instance of a qltenv item
QLTENV addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp>}]; //= qlTenv.errors + <l, msg> 

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
QLTENV checkExp(exp:boolCon(bool B), Type req, QLTENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
QLTENV checkExp(exp:moneyCon(int I), Type req, QLTENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
QLTENV checkExp(exp:id(QuestionId Id), Type req, QLTENV env) {                              
  if(!env.symbols[Id]?)
     return addError(env, exp@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}

QLTENV checkExp(exp:add(EXP E1, EXP E2), Type req, QLTENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
QLTENV checkExp(exp:sub(EXP E1, EXP E2), Type req, QLTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

QLTENV checkExp(exp:or(EXP E1, EXP E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
QLTENV checkExp(exp:and(EXP E1, EXP E2), Type req, QLTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));


// check statements for Questions 
QLTENV checkQuestionStats(list[Statement] Stats1, QLTENV qEnv) {                                 
  println("CHECK Question STATES : <Stats1>");
  for(S <- Stats1){
  	  println("S in LIST STATEMENT : <S>");
      qEnv = checkStat(S, qEnv);
  }
  return qEnv;
}

// Check if statement
QLTENV checkStatement(statement:ifStat(Expression exp, list[Body] body), QLTENV env){
    println("EXP : <Exp>"); 
    env0 = checkExp(Exp, boolean(), env);
    if(size(env0.errors) != 0)
    	return addError(env0, env0.errors[0].l, env0.errors[0].msg);
    env1 = checkQuestionStats(Stats1, env0);
    return env;
}

// check if else statement
QLTENV checkStatement(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart), QLTENV env){
    println("EXP : <Exp>"); 
    env0 = checkExp(Exp, boolean(), env);
    if(size(env0.errors) != 0)
    	return addError(env0, env0.errors[0].l, env0.errors[0].msg);
    env1 = checkQuestionStats(Stats1, env0);
    return env;
}

// check easy question and save it in the environment
QLTENV checkQuestion(question:easyQuestion(str id, str labelQuestion, Type tp) , QLTENV env){
	return addInstance(env, id , labelQuestion, tp );	
}

// check computed question and save it in the environment
QLTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp , QLTENV env)){
	println("check computed question");
	env = <{< id , labelQuestion, tp >} , []>;
	println("ENV : <env>");
	return env;
}

// check the body of the QL program
QLTENV checkBody(list[Body] Body, QLTENV env){
	for(s <- Body){
	visit(Body){
     	case Question q : {
    			env = checkQuestion(q,env);
    	    }
        case Statement s: println("Statement is : <S>");
      };
	}
	return env;
}

// check a QL program
public QLTENV checkProgram(Program P){                                                
  if(program(Expression id, list[Body] Body) := P){	 
     QLTENV env = <{},[]>; 
     env = checkBody(Body, env);
     println("ENV : <env>"); 
    // QTENV qEnv = mapQuestionIdToType2(env.symbols);  // Mapping.rsc is doing that 
	 return checkQuestionStats(Series, qEnv);
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
