module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import typeChecker::Mapping;

// We will use TENV (type environment) as an alias for a tuple that contains all relevant type information:
alias TENV = tuple[ map[QuestionId, QUE] symbols, list[tuple[loc l, str msg]] errors];
alias QTENV = tuple[ map[QuestionId, TYPE] symbols, list[tuple[loc l, str msg]] errors]; 
alias QSTRING = tuple[ map[QuestionString, TYPE] symbols, list[tuple[loc l, str msg]] errors];

TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>]; 
QTENV addError(QTENV qEnv, loc l, str msg) = qEnv[errors = qEnv.errors + <l, msg>];
QSTRING addError(QSTRING qString, loc l, str msg) = qString[errors = qString.errors + <l, msg>];

str required(TYPE t, str got) = "Required <getName(t)>, got <got>";                 
str required(TYPE t1, TYPE t2) = required(t1, getName(t2));

// compile Expressions.
QTENV checkExp(exp:boolCon(bool B), TYPE req, QTENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));

QTENV checkExp(exp:strCon(str S), TYPE req, QTENV env) =
 req == string() ? env : addError(env, exp@location, required(req, "string"));
 
QTENV checkExp(exp:moneyCon(int I), TYPE req, QTENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
QTENV checkExp(exp:id(QuestionId Id), TYPE req, QTENV env) {                              
  if(!env.symbols[Id]?)
     return addError(env, exp@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}

QTENV checkExp(exp:add(EXP E1, EXP E2), TYPE req, QTENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
QTENV checkExp(exp:sub(EXP E1, EXP E2), TYPE req, QTENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

QTENV checkExp(exp:or(EXP E1, EXP E2), TYPE req, QTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
QTENV checkExp(exp:and(EXP E1, EXP E2), TYPE req, QTENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));

QSTRING checkExp(exp:strQue(str S), TYPE req, QSTRING qString) =
 req == string() ? qString : addError(qString, exp@location, required(req, "string"));

// check a statement
QTENV checkStat(stat:asgStat(QuestionId id, Type tp), QTENV qEnv) {                    
  if(!qEnv.symbols[id]?)
     return addError(qEnv, stat@location, "Undeclared variable <id>");
  tpid = qEnv.symbols[id];
  return checkExp(Exp, tpid, qEnv);
}

// check statements for Questions 
QTENV checkQuestionStats(list[STATEMENT] Stats1, QTENV qEnv) {                                 
  println("CHECK Question STATES : <Stats1>");
  for(S <- Stats1){
  	  println("S in LIST STATEMENT : <S>");
      qEnv = checkStat(S, qEnv);
  }
  return qEnv;
}

QTENV checkQuestionStats(list[DECL] Stats1, QTENV qEnv) {                                 
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
TENV checkDecls(list[DECL] Decls) =                                                 
    <( Id : question | decl(QuestionId Id, QUE question)  <- Decls), []>;

// check question
QTENV checkQuestionType(map[QuestionId, TYPE] results) =   
   <results,[]>;

// check a QL program
public QTENV checkProgram(PROGRAM P){                                                
  if(program(EXP exp, list[DECL] Decls, list[STATEMENT] Series) := P){	 
     println("DECL : <Decls>");
     println("EXP : <exp>");
     TENV env = checkDecls(Decls);
     //println("ENV : <env.symbols>"); 
     QTENV qEnv = mapQuestionIdToType2(env.symbols);  // Mapping.rsc is doing that
     println("QTENV : <qEnv>");
     QSTRING qString = checkQuestionString(env.symbols); 
	 return checkQuestionStats(Series, qEnv);
  } else
     throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
