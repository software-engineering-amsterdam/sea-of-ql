module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import typeChecker::Load;

alias TENV = tuple[ map[QuestionId, TYPE] symbols, list[tuple[loc l, str msg]] errors]; 
alias QTENV = tuple[ map[QuestionString, TYPE] symbols, list[tuple[loc l, str msg]] errors]; 

TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>]; 
QTENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];     

str required(TYPE t, str got) = "Required <getName(t)>, got <got>";                 
str required(TYPE t1, TYPE t2) = required(t1, getName(t2));

// compile Expressions.

TENV checkExp(exp:boolCon(bool B), TYPE req, TENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));

TENV checkExp(exp:strCon(str S), TYPE req, TENV env) =
 req == string() ? env : addError(env, exp@location, required(req, "string"));
 
TENV checkExp(exp:moneyCon(int I), TYPE req, TENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));

QTENV checkExp(exp:strQue(string N), TYPE req, QTENV env) =                              
  req == string() ? env : addError(env, exp@location, required(req, "string"));
 
 //TENV checkExp(exp:natCon(int I), QuestionString name, TYPE req, TENV env) =
 //req == natCon() ? env : addError(env, exp@location, required(req, "natural"));

TENV checkExp(exp:id(QuestionId Id), TYPE req, TENV env) {                              
  if(!env.symbols[Id]?)
     return addError(env, exp@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}

QTENV checkExp(exp:id(QuestionString qName), TYPE req, QTENV env) {                              
  if(!env.symbols[qName]?)
     return addError(env, exp@location, "Undeclared variable <qName>");
  tpid = env.symbols[qName];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}


TENV checkExp(exp:add(EXP E1, EXP E2), TYPE req, TENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
TENV checkExp(exp:sub(EXP E1, EXP E2), TYPE req, TENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

//TENV checkExp(exp:conc(EXP E1, EXP E2), TYPE req, TENV env) =                    
//  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
//                   : addError(env, exp@location, required(req, "string"));


// check a statement

TENV checkStat(stat:asgStat(QuestionId Id, EXP Exp), TENV env) {                        
  if(!env.symbols[Id]?)
     return addError(env, stat@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return checkExp(Exp, tpid, env);
}

QTENV checkStat(stat:asgStat(QuestionIString qName, EXP Exp), QTENV env) {                        
  if(!env.symbols[qName]?)
     return addError(env, stat@location, "Undeclared variable <qName>");
  tpid = env.symbols[qName];
  return checkExp(Exp, tpid, env);
}
	
//TENV checkStat(stat:ifElseStat(EXP Exp,                                             
//                              list[STATEMENT] Stats1,
//                              list[STATEMENT] Stats2),
//               TENV env){
//    env0 = checkExp(Exp, natural(), env);
//    env1 = checkStats(Stats1, env0);
//    env2 = checkStats(Stats2, env1);
//    return env2;
//}

// check a list of statements
TENV checkStats(list[STATEMENT] Stats1, TENV env) {                                 
  for(S <- Stats1){
      env = checkStat(S, env);
  }
  return env;
}
  
// check declarations

TENV checkDecls(list[DECL] Decls) =                                                 
    <( Id : tp  | decl(QuestionId Id, QuestionString qName, TYPE tp) <- Decls), []>;

// check a QL program

//public TENV checkProgram(PROGRAM P){                                                
//  if(program(EXP exp, list[DECL] Decls, list[STATEMENT] Series) := P){
//     TENV env = checkDecls(Decls);
//     return checkStats(Series, env);
//  } else
//    throw "Cannot happen";
//}

public TENV checkProgram(PROGRAM P){                                                
  if(program(EXP exp, list[DECL] Decls, list[STATEMENT] Series) := P){
     println(Decls);
     TENV env = checkDecls(Decls);
     return checkStats(Series, env);
  } else
    throw "Cannot happen";
}
                                                                                    
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
