/** Module to declare a data type for Questions and to create the VENV
*/
module eval::EvalTypeEnvironment

import syntax::AbstractSyntax;
import Prelude;

// First we introduce a data type QuestionValue that wraps all possible values that can occur at run-time.
public data QuestionValue = boolVal(bool b) | strVal(str s) | moneyVal (real m) | intVal(int i) | errorval(loc l, str msg);  

public alias VENV = map[str , QuestionValue]; 

public VENV addInstance(VENV venv,str id, QuestionValue qValue){
 println("IN ADDINSTANCE : <id> and <qValue>");
 venv += (id : qValue );
 println("VEN : <venv>");
  return venv;
}