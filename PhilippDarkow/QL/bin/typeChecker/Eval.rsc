module typeChecker::Eval

import Prelude;
import syntax::AbstractSyntax;
import util::Load;
import typeChecker::TypeCheck;

// First we introduce a data type QuestionValue that wraps all possible values that can occur at run-time.
data QuestionValue = boolVal(bool b) | strVal(str s) | moneyVal (Money m) | errorval(loc l, str msg);  
data QuestionName = strVal(str s) | errorval(loc l, str msg);

alias VENV = map[QuestionId, QuestionValue];   // QuestionName,                                      

// Evaluate Expressions.

QuestionValue evalExp(exp:moneyCon(int M), VENV env) = moneyVal(N);

QuestionValue evalExp(exp:strCon(str S), VENV env) = strVal(S);

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

VENV evalStat(stat:asgStat(QuestionId Id, EXP Exp), VENV env) {
  env[Id] = evalExp(Exp, env);
  return env;
}
	
VENV evalStat(stat:ifElseStat(EXP Exp, 
                              list[STATEMENT] Stats1,
                              list[STATEMENT] Stats2),
              VENV env) =
  evalStats(evalExp(Exp, env) != natval(0) ? Stats1 : Stats2, env);

// Evaluate a list of statements
VENV evalStats(list[STATEMENT] Stats1, VENV env) {
  for(S <- Stats1){
      env = evalStat(S, env);
  }
  return env;
}
  
// Eval declarations

VENV evalDecls (map[QuestionId Id, TYPE tp] results) =   
   ( results.Id : (results.tp == money() ? moneyVal(0) : strVal("")) ); // | results(QuestionId Id, TYPE tp) <- results); 
 // (results.tp == money() ? moneyVal(0) : strVal(""))
 
VENV evalDecls (list[tuple [QuestionId qId, TYPE tp]] results) =   
   ( result.qId : (results.tp == money() ? moneyVal(0) : strVal("")) | result(QuestionId Id, TYPE tp) <- results);
    
TENV checkDecls(list[DECL] Decls) =                                                 
    <( Id : question | decl(QuestionId Id, QUE question)  <- Decls), []>;
// Evaluate a Pico program

public VENV evalProgram(PROGRAM P){
  if(program(EXP exp,list[DECL] Decls, list[STATEMENT] Series) := P){
     println("EVAL DECLS : <Decls>");
     
     TENV tenv = checkDecls(Decls);
     println("TENV : <tenv>");  
     //VENV env = checkDecls(Decls);
     map[QuestionId qId, TYPE tp] results = mapQuestionIdToType(tenv.symbols);
     println("MAP RESULTS IN EVAL : <toList(results)>");
     list[tuple [QuestionId qId, TYPE tp]] gg = toList(results);
     println("gg : <gg>");
     VENV env = evalDecls(gg);
     
     println(env);
     return evalStats(Series, env);
  } else
    throw "Cannot happen";
}

public VENV evalProgram(str txt) = evalProgram(load(txt));