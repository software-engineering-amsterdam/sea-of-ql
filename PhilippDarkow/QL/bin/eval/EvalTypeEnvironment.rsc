module eval::EvalTypeEnvironment


/** Module to declare a data type for Questions and to create the VENV
*/

// First we introduce a data type QuestionValue that wraps all possible values that can occur at run-time.
public data QuestionValue = boolVal(bool b) | strVal(str s) | moneyVal (real m) | intVal(int i) | errorval(loc l, str msg);  

public alias VENV = map[str , QuestionValue]; 

// VENV addInstance(env, id , labelQuestion, tp);