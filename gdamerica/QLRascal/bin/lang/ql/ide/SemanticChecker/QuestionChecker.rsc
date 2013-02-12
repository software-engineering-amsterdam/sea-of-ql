/**
 * This module contains the Question checker (hooked up to the IDE)  
 * @author  Gerson Delgado
 * @version 1.0, 12/02/2013
 */
module lang::ql::ide::SemanticChecker::QuestionChecker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::Environment;

/**
* Check function for duplicate labels in a question
* This function add warnings to the env in case of duplicate labels in questions  
*/
public ENV checkQstnDuplicates(list[Element] elem, ENV env){
	top-down visit(elem){
		case qstn:computableQuestion(_,_,_,_) : env = checkCompQstnDuplicates(qstn, env);
		case qstn:singleQuestion(_,_,_) : env = checkSingQstnDuplicates(qstn, env);
	}
	return env;	
}

/**
* Help Check function for computable questions
* This function check duplicated id's if so it add errors 
* This function add questions to the environment  
*/
private ENV checkCompQstnDuplicates(question:computableQuestion(str id, str qLabel, DataType qstnDataType,  Expr qstnExpr), ENV env){
	for(var<-env.elements){
		if(id == var.id)
			if(qstnDataType != var.varDataType)
				return env = addError(env, question@location, required("Duplicated identifier declared with differents Datatypes"));
	        else
				return env = addError(env, question@location, required("Question binds the same variable in computable question expression"));
				
		 else if(qLabel == var.label)
				if(qstnDataType != var.varDataType)
					return env = addError(env, question@location, required("Duplicate question declared with different Datatypes"));				
	}
	env = addElement(env, id, qLabel, qstnDataType, question@location);
	return env;
}

/**
* Help Check function for simple questions
* This function check duplicated id's if so it add errors 
* This function add questions to the environment  
*/
private ENV checkSingQstnDuplicates(question:singleQuestion(str id, str qLabel, DataType qstnDataType), ENV env){
	for(var<-env.elements){
		if(id == var.id)
			if(qstnDataType != var.elemDataType)
				return env = addError(env, question@location, required("Same identifier declared with differents Datatypes"));
	         else
				return env = addError(env, question@location, required("Question binds the same variable in answerable question"));
				
		else if(qLabel == var.label)
			if(qstnDataType != var.elemDataType)
				return env = addError(env, question@location, required("Duplicate question declared with different Datatypes"));	
	}
	env = addElement(env, id, qLabel, qstnDataType, question@location);
	return env;
}

