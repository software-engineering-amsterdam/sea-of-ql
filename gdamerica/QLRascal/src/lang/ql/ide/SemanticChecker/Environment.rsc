/**
 * This module contains all IDE environment functions and Data structures
 * @author  Gerson Delgado
 * @version 1.0, 29/01/2013
 */
module lang::ql::ide::SemanticChecker::Environment

import lang::ql::ast::AST;
import util::IDE;

/**
* ENV (environment) alias to store relevant data about elemiables Datatypes, questions, errors and warnings 
*/
alias ENV = tuple[ 
	rel[str id, str label, DataType elemDataType, loc elemLoc] elements, 
	list[tuple[loc l, str msg]] errors,
	list[tuple[loc l, str msg]] warnings
	];

/**
* Hulp functions construct warning or error messages
*/
public str required(str feedBackMsg, DataType req, DataType got) = "<feedBackMsg> requires <req> but got <got>";

public str required(str feedBackMsg, DataType req) = "<feedBackMsg> requires <req>";

public str required(str feedBackMsg) = "<feedBackMsg>";


public ENV addElement(ENV env, str id, str label, DataType elemTypeName, loc elemLoc) = env[elements = env.elements + <id, label, elemTypeName, elemLoc>];//add element to the ENV

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
private set[Message] getErrors(ENV env){

	return aux = {error(v.msg,v.l) | tuple[loc l,str msg] v <-env.errors};

}

private set[Message] getWarnings(ENV env){

	return aux = {warning(v.msg,v.l) | tuple[loc l,str msg] v <-env.warnings};

}
