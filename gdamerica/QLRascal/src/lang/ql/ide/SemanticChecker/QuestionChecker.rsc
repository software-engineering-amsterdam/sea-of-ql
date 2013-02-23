/**
 * This module contains all functions for Question checker (hooked up to the IDE)  
 * visit pattern and pattern matching is used in order to check a a QL question for errors
 * @author  Gerson Delgado
 * @version 1.0, 12/02/2013
 */
module lang::ql::ide::SemanticChecker::QuestionChecker

import lang::ql::ast::AST;
import lang::ql::ide::SemanticChecker::Environment;

/**
* Check function that will visit all questions types 
* and consequently check them
*/ 
public ENV checkQstnDuplicates(list[Element] elem, ENV env){
	top-down visit(elem){
		case qstn:computableQuestion(_,_,_,_) 
			: env = checkCompQstnDuplicates(qstn, env);
		case qstn:singleQuestion(_,_,_) 
			: env = checkSingQstnDuplicates(qstn, env);
	}
	return env;	
}
  
public ENV checkCyclic(list[Element] elem, ENV env){
	top-down visit(elem){
		case id:ident(str name) 
			: env = cyclicDependecy(name, id@location, env);
	}
	return env;	
}

private ENV cyclicDependecy(str id, loc exprLoc, ENV env){
	for(var1<-env.elements){
			if(var1.id == id)
				if(!(var1.elemLoc.begin.line < exprLoc.begin.line))
					env = addError(env, exprLoc, required("Cyclic Dependency found on Var <id>"));
		}
	return env;
}

private ENV checkCompQstnDuplicates(question:computableQuestion(str id, str qLabel, DataType qstnDataType,  Expr qstnExpr), ENV env){
	for(var<-env.elements){
		if(id == var.id)
			if(qstnDataType != var.elemDataType)
				return env = addError(env, question@location, required("Duplicated identifier declared with differents Datatypes"));
	        else
				return env = addError(env, question@location, required("Question binds the same variable in computable question expression"));
				
		 else if(qLabel == var.label)
				if(qstnDataType != var.elemDataType)
					return env = addError(env, question@location, required("Duplicate question declared with different Datatypes"));				
	}
	
	return env = addElement(env, id, qLabel, qstnDataType, question@location);
}

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
	return env = addElement(env, id, qLabel, qstnDataType, question@location);
}

public ENV checkDuplicateLabels(ENV env){
	for(var1<-env.elements){
		for(var2<-env.elements){
			if(var1.label == var2.label)
				if(var1.id != var2.id) 
					env = addWarning(env, var1.elemLoc, required("Duplicate label <var1.label>"));
		}
	}
	return env;
}

