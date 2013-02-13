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

/**
* Check function QL forms
* This function implement all the checks for a Form
*/
public ENV checkForm(Form f){                                                
 	if(form(str id, list[Element] fElem ) := f){	 
		ENV env = <{},[],[]>; 
     	env0 = checkListElements(fElem, env);
     	env1 = checkDuplicateLabels(env0);
     	env2 = checkQstnDuplicates(fElem, env1);
	 	return env2;
  } else
     	throw "Syntax Error";
}

/**
* Function defines how to check the source code of a given Form 
*/                                                                        
public ENV checkForm(loc l) = checkForm(load(l));
