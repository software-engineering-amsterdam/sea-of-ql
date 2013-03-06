/**
 * This module contains all IDE environment functions and Data structures
 * contains functions in order to add new elemnts to the ENV 
 * @author  Gerson Delgado
 * @version 1.0, 29/01/2013
 */
module lang::ql::ide::SemanticChecker::Environment

import lang::ql::ast::AST;
import util::IDE;


alias ENV = tuple[ 
	rel[str id, str label, DataType elemDataType, loc elemLoc] elements, 
	list[tuple[loc l, str msg]] errors,
	list[tuple[loc l, str msg]] warnings
	];

public str required(str feedBackMsg, DataType req, DataType got) 
	= "<feedBackMsg> requires <req> but got <got>";

public str required(str feedBackMsg, DataType req) 
	= "<feedBackMsg> requires <req>";

public str required(str feedBackMsg) 
	= "<feedBackMsg>";

public ENV addElement(ENV env, str id, str label, DataType elemTypeName, loc elemLoc) 
	= env[elements = env.elements + <id, label, elemTypeName, elemLoc>];

public ENV addError(ENV env, loc l, str msg) 
	= env[errors = env.errors + <l, msg>];

public ENV addWarning(ENV env, loc l, str msg) 
	= env[warnings = env.warnings + <l, msg>];

public set[Message] getMessages(ENV env){
	
	return getErrors(env) + getWarnings(env);
}

private set[Message] getErrors(ENV env){

	return aux = {error(v.msg,v.l) | tuple[loc l,str msg] v <-env.errors};

}

private set[Message] getWarnings(ENV env){

	return aux = {warning(v.msg,v.l) | tuple[loc l,str msg] v <-env.warnings};

}
