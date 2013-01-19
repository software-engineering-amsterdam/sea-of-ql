module typeChecker::TypeCheck

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import typeChecker::QuestionTypeChecker;

// We will use TENV (type environment) as an alias for a tuple that contains all relevant type information:
// symbols: a map from Pico identifiers to their declared type.
// errors: a list of error messages. An error message is represented by its location and a textual message.
alias TENV = tuple[ map[QuestionId, QUE] symbols, list[tuple[loc l, str msg]] errors];  // list[DECL] Decls

TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>]; 

alias QTENV = tuple[ map[QuestionString, TYPE] symbols, list[tuple[loc l, str msg]] errors]; 

QTENV addError(QTENV qEnv, loc l, str msg) = env[errors = qEnv.errors + <l, msg>];

// compile Expressions.
TENV checkExp(exp:boolCon(bool B), TYPE req, TENV env) =                              
  req == boolean() ? env : addError(env, exp@location, required(req, "boolean"));

TENV checkExp(exp:strCon(str S), TYPE req, TENV env) =
 req == string() ? env : addError(env, exp@location, required(req, "string"));
 
TENV checkExp(exp:moneyCon(int I), TYPE req, TENV env) =
 req == money() ? env : addError(env, exp@location, required(req, "money"));
 
TENV checkExp(exp:id(QuestionId Id), TYPE req, TENV env) {                              
  if(!env.symbols[Id]?)
     return addError(env, exp@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return req == tpid ? env : addError(env, exp@location, required(req, tpid));
}

TENV checkExp(exp:add(EXP E1, EXP E2), TYPE req, TENV env) =                        
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));
  
TENV checkExp(exp:sub(EXP E1, EXP E2), TYPE req, TENV env) =                      
  req == money() ? checkExp(E1, money(), checkExp(E2, money(), env))
                   : addError(env, exp@location, required(req, "money"));

TENV checkExp(exp:or(EXP E1, EXP E2), TYPE req, TENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));
                   
TENV checkExp(exp:and(EXP E1, EXP E2), TYPE req, TENV env) =                    
  req == string() ? checkExp(E1, string(), checkExp(E2, string(), env))
                   : addError(env, exp@location, required(req, "string"));


// check a statement
TENV checkStat(stat:asgStat(QuestionId Id, EXP Exp), TENV env) {                        
  if(!env.symbols[Id]?)
     return addError(env, stat@location, "Undeclared variable <Id>");
  tpid = env.symbols[Id];
  return checkExp(Exp, tpid, env);
}

// check a list of statements
TENV checkStats(list[STATEMENT] Stats1, TENV env) {                                 
  println("CHECK STATES : <Stats1>");
  for(S <- Stats1){
  		println("S : <S>");
      env = checkStat(S, env);
  }
  return env;
}
	
// TENV checkStat(stat:ifElseStat(EXP Exp,                                             
//                              list[STATEMENT] Stats1,
//                              list[STATEMENT] Stats2),
//               TENV env){
//    env0 = checkExp(Exp, natural(), env);
//    env1 = checkStats(Stats1, env0);
//    env2 = checkStats(Stats2, env1);
//    return env;
//}

// check declarations
TENV checkDecls(list[DECL] Decls) =                                                 
    <( Id : question | decl(QuestionId Id, QUE question)  <- Decls), []>;    // decl(QuestionId Id, QuestionString qName)

QTENV checkQuestion(list[QUE] qNames) =   
   <(questionString : tp | qName(QuestionString questionString, TYPE tp) <- qNames),[]>;

list[QuestionId] getQuestionIds(list[tuple[QuestionId QId, QUE ques]] questionList){
	list[QuestionId] idList = [];
    for(int n <- [0 .. size(questionList)-1]){
    	idList += questionList[n].QId;
    }
    return idList;
}

list[TYPE] getQuestionTypes(list [tuple[QuestionString qString, TYPE tp]] tList){
	list[TYPE] typeList = [];
	for(int n <- [0 .. size(tList)-1]){
		typeList += tList[n].tp;
	}
	return typeList;
}

list[TYPE] getQuestionTypes(list[tuple[QuestionId QId, QUE ques]] questionList){
	list[QUE] questionDeclarations = [];
	for(int n <- [0 .. size(questionList) -1]){
    	questionDeclarations += questionList[n].ques;
    }
    println("QUE from List : <questionDeclarations>");
    QTENV qEnv = checkQuestion(questionDeclarations);    
    println("QENV : <qEnv>");
    
    list [tuple[QuestionString qString, TYPE tp]] j = toList(qEnv.symbols);
    return getQuestionTypes(j);
}

public map[QuestionId , TYPE] mapQuestionIdToType(map[QuestionId QId, QUE ques] q){
    list[tuple[QuestionId QId, QUE ques]] questionList = toList(q);
    list[QuestionId] ids = getQuestionIds(questionList);
    list[TYPE] tps = getQuestionTypes(questionList);
   println("CHECK SIZE TPS : <size(tps)>  CHECK SIZE IDS : <size(ids)>");
   map[QuestionId, TYPE] result = (ids[0] : tps[0]);
   for(int n <- [0 .. size(ids) -1]){
    	result += (ids[n] : tps[n]);
    }   
    println("MAP result : <result>");
    return result;
}

QTENV checkQuestionType(map[QuestionId, TYPE] results) =   
   <results,[]>;

// check a QL program
public TENV checkProgram(PROGRAM P){                                                
  if(program(EXP exp, list[DECL] Decls, list[STATEMENT] Series) := P){
     println("Decls : <Decls>");	 
     TENV env = checkDecls(Decls);
     println("ENV : <env.symbols>");  // gives the map 
     map[QuestionId, TYPE] results = mapQuestionIdToType(env.symbols);
	QTENV qEnv = checkQuestionType(results);
	
	println("QENV SYMBOLS : <qEnv>");
	checkQuestionStats(Series, qEnv);
     println("Series : <Series>");
     return checkStats(Series, env);
  } else
    throw "Cannot happen";
}
                                                                                 
public list[tuple[loc l, str msg]] checkProgram(str txt) = checkProgram(load(txt)).errors;
