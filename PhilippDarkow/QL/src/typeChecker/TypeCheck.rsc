module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import syntax::ConcreteSyntax;
import util::Load;
import typeChecker::Mapping;

alias QTENV = tuple[ map[str, Type] symbols, list[tuple[loc l, str msg]] errors]; 

QTENV addError(QTENV qEnv, loc l, str msg) = qEnv[errors = qEnv.errors + <l, msg>];

str required(Type t, str got) = "Required <getName(t)>, got <got>";                 
str required(Type t1, Type t2) = required(t1, getName(t2));

// compile Expressions.
QTENV checkExp(exp:boolCon(bool B), Type req, QTENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));
 
QTENV checkExp(exp:moneyCon(int I), Type req, QTENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
QTENV checkExp(exp:id(QuestionId Id), Type req, QTENV env) {                              
  if(!env.symbols[Id]?)
     return addError(env, exp@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}

QTENV checkExp(exp:add(EXP E1, EXP E2), Type req, QTENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
QTENV checkExp(exp:sub(EXP E1, EXP E2), Type req, QTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

QTENV checkExp(exp:or(EXP E1, EXP E2), Type req, QTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
QTENV checkExp(exp:and(EXP E1, EXP E2), Type req, QTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));

// check a statement
//QTENV checkStat(stat:asgStat(str id, Type tp), QTENV qEnv) {                    
//  if(!qEnv.symbols[id]?)
//     return addError(qEnv, stat@location, "Undeclared variable <id>");
//  tpid = qEnv.symbols[id];
//  return checkExp(Exp, tpid, qEnv);
//}

// check statements for Questions 
QTENV checkQuestionStats(list[Statement] Stats1, QTENV qEnv) {                                 
  println("CHECK Question STATES : <Stats1>");
  for(S <- Stats1){
  	  println("S in LIST STATEMENT : <S>");
      qEnv = checkStat(S, qEnv);
  }
  return qEnv;
}

QTENV checkQuestionStats(list[Body] Stats1, QTENV qEnv) {                                 
  println("CHECK Question STATES : <Stats1>");
  for(S <- Stats1){
  	  TENV ff = checkDecls([S]);
  	  if(size(ff.symbols) != 0){
  	  	QTENV qEnv = mapQuestionIdToType2(ff.symbols);
  	  	println("IN QENV : <qEnv>");
  	  	//return checkExp(qEnv, money(), );
  	  	return qEnv;    // I need to call a new method then with decls one parameter
  	  }
      qEnv = checkStat(S, qEnv);
  }
  return qEnv;
}

 QTENV checkStat(stat:ifStat(EXP Exp,                                             
                              list[DECL] Stats1),
               QTENV env){
               println("EXP : <Exp>"); 
    env0 = checkExp(Exp, boolean(), env);
    if(size(env0.errors) != 0)
    	return addError(env0, env0.errors[0].l, env0.errors[0].msg);
    env1 = checkQuestionStats(Stats1, env0);
    return env;
}


// check declarations
QTENV checkBody(list[Body] Body) =                                                 
    <( Id : question | question(QuestionId Id, Question question)  <- Body), []>
    ;

// check question
QTENV checkQuestionType(map[str, Type] results) =   
   <results,[]>;

/* 
*/
void checkQuestion(Question q){

}

QTENV visitQuestions(Question q, env){   //, QTENV env
	println("Q : <q>");
	env = checkQuestion(q, env);  // , env
	return env;
}

QTENV checkQuestion(question:easyQuestion(str id, str qLabel, Type tp) , QTENV env){ // , QTENV env
	println("check easy question");
	env = (<( id : tp ), [] >);
	println("ENV : <env>");
	//print(id);
	return env;	
}

QTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	println("check computed question");
	QTENV env = (<( id : tp ), [] >);
	println("ENV : <env>");
}

//FTENV checkBody()

// check a QL program
public QTENV checkProgram(Program P){                                                
  if(program(Expression exp, list[Body] Body) := P){	 
     println("EXP : <exp>");
     println("Body : <Body>");  
     QTENV env = (<( ), [] >);  // empty Question Type map
   //  FTENV fEnv = checkBody(list[Body] Body)
     println("ENV : <env>");
     visit(Body){
     	case Question q : { 
     			env = visitQuestions(q,env);   // , env
     	    }
        case Statement s: println("Statement is : <S>");
     };
     println("ENV : <env>"); 
     QTENV qEnv = mapQuestionIdToType2(env.symbols);  // Mapping.rsc is doing that
     println("QTENV : <qEnv>"); 
	 return checkQuestionStats(Series, qEnv);
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
