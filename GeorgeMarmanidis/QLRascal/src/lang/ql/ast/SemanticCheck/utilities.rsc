@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::SemanticCheck::utilities

import IO;
import lang::ql::ast::AST;
import util::IDE;

//Stores info about declared variables, semantic errors and warnings. 
alias TENV = tuple[ rel[str variableName,str variableLabel, Type variableType,bool isComputed,loc queLocation] symbols, list[tuple[loc l, str msg]] errors,list[tuple[loc l, str msg]] warnings];

public TENV addSymbol(TENV env, str ident, str label,Type idType,bool isComputed,loc queLocation) = env[symbols = env.symbols + <ident, label,idType,isComputed,queLocation>];
public TENV addError(TENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];
public TENV addWarning(TENV env, loc l, str msg) = env[warnings = env.warnings + <l, msg>];

public set[Message] getErrors(TENV env){
	set[Message] messageSet={};
	
	for(x<-env.errors){
		messageSet=messageSet+error(x.msg,x.l);
	}
	
	for(x<-env.warnings){
		messageSet=messageSet+warning(x.msg,x.l);
	}
	
	return messageSet;
}