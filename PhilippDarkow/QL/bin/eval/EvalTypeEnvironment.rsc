/** Module to declare a data type for Questions and to create the VENV
*/
module eval::EvalTypeEnvironment

import syntax::AbstractSyntax;
import Prelude;

// First we introduce a data type QuestionValue that wraps all possible values that can occur at run-time.
public data QuestionValue = boolVal(bool b) | strVal(str s) | moneyVal (real m) | intVal(int i) | errorval(loc l, str msg);  

public alias VENV = map[str , QuestionValue]; 

public VENV addInstance(VENV venv,str id, QuestionValue qValue){
 // = env(id : value);
 println("IN ADDINSTANCE : <id> and <qValue>");
 VENV ven = (id : (qValue ==  money() ? moneyVal(0) : intVal(0)));
 //return venv(id, (qValue ==  money() ? moneyVal(0) : intVal(0)));
 println("VEN : <ven>");
  return ven;
 
}