@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::semanticcheck::CyclicCheck

import lang::ql::ast::AST;
import lang::ql::ast::semanticcheck::TypeEnvUtils;
import IO;

public TENV checkCyclicDepen(list[FormBodyItem] formBodyItems,TENV env) =
  ( env | checkCyclicIdent(name, X@location, it) | /X:ident(str name) := formBodyItems );

//9. should start with false, because if env.symbols is empty, then it says that is cycclic ;)
TENV checkCyclicIdent(str identName, loc exprLocation,TENV env){
	bool isCyclic=false;
	bool foundNotCyclic=false;
	
	for(x<-env.symbols){
		if(identName==x.variableName){
			if(x.queLocation.begin.line < exprLocation.begin.line){
				foundNotCyclic=true;
			 }
			 
			 if(x.queLocation.begin.line > exprLocation.begin.line && !foundNotCyclic){
				isCyclic=true;
			 }
			 
		}
	}
	
	if(isCyclic) env=addError(env,exprLocation,"Cyclic problem identified.");
	return env;
}