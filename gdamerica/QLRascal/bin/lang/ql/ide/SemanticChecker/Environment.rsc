/**
 * This module contains all IDE environment functions and Data structures
 * @author  Gerson Delgado
 * @version 1.0, 29/01/2013
 */
module lang::ql::ide::SemanticChecker::Environment

import IO;
import lang::ql::ast::AST;
import util::IDE;

/**
* ENV (environment) alias to store relevant data about variables Datatypes, questions, errors and warnings 
*/
alias ENV = tuple[ 
	rel[str id, str descr, DataType varDataType] variables, 
	list[tuple[loc l, str msg]] errors,
	list[tuple[loc l, str msg]] warnings
	];


public ENV addElement(ENV env, str id, str descr, DataType varTypeName) = env[Variables = env.variables + <id, descr, varTypeName>];//add element to the ENV

public ENV addError(ENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];//add errors (if any) to ENV tuple and return a new ENV 

public ENV addWarning(ENV env, loc l, str msg) = env[warnings = env.warnings + <l, msg>];//add warnings (if any) to ENV tuple and return a new ENV

/**
* construct a set of messages(errors or warnings)
*/
public set[Message] getMessages(ENV env){
	
	return getErrors(env) + getWarnings(env);
}

/**
* Help functions to get set of errors and warnings
*/
public set[Message] getErrors(ENV env){

	return aux = {v.l,v.msg | tuple[loc,str] v <-env.errors};

}

public set[Message] getWarnings(ENV env){

	return aux = {v.l,v.msg | tuple[loc,str] v <-env.warnings};

}

/**
* Hulp functions construct warning and error messages
*/
str required(str feedBackMsg, DataType req, DataType got) = "<feedBackMsg> requires <req> but got <got>";
str required(str feedBackMsg, DataType req) = "<feedBackMsg> requires <req>";
