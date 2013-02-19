@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ast::semanticcheck::DuplicateLabelsCheck

import lang::ql::ast::semanticcheck::TypeEnvUtils;
		
//For each symbol in Type Enviroment (env)
//we check if the labels are the same. In this case, if the ident is also the same
//we add a warning to the env
public TENV duplicateLabelsCheck(TENV env){
	for(sym1<-env.symbols){
		for(sym2<-env.symbols){
			if(sym1.variableLabel==sym2.variableLabel && sym1.variableName!=sym2.variableName) {
				env=addWarning(env,sym1.queLocation,"Duplicate labels <sym1.variableLabel>");
			}
		}
	}
	return env;
}
		
