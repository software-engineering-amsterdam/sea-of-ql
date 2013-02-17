/**
 * This module contains the Form checker (hooked up to the IDE)  
 * @author  Gerson Delgado
 * @version 1.0, 11/02/2013
 */
 
module lang::ql::ide::SemanticChecker::FormChecker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::DataTypeChecker;
import lang::ql::ide::SemanticChecker::QuestionChecker;
import lang::ql::ide::SemanticChecker::Environment;
import lang::ql::util::Implode;
import Message;

/**
* Check function QL forms
* This function implement all the checks for a Form
*/
public ENV checkForm(Form f){                                                
 	if(form(str id, list[Element] fElem ) := f){	 
		ENV env = <{},[],[]>; 
     	env0 = checkQstnDuplicates(fElem, env);
     	env1 = checkListElements(fElem, env0);
     	env2 = checkDuplicateLabels(env1);
     	env3 = checkCyclic(fElem, env2);
	 	return env3;
  } else
     	throw "Syntax Error";
}

/**
* Function defines how to check the source code of a given Form 
*/                                                                        
public ENV checkForm(loc l) = checkForm(load(l));
public set[Message] checkQl(Form f) = getMessages(checkForm(f));

