@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::ExtractDependencies

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::CompileExpressions;

public list[str] getVariableDependencies(Expr exp)
  = [ n | /ident(str n) := exp ];


//7. use set instead of list..i don't want order, and i don't care for duplicates
public map[str,list[str]] getDependenciesMap(list[FormBodyItem] bodyItems){
	map[str,list[str]] dependenciesMap=();
	
	visit(bodyItems){
		case q:computedQuestion(str questionId,_,_, Expr exp) : dependenciesMap+=resolveVariableDependencies(exp,questionId,dependenciesMap);
		case c:ifCond(Expr exp,_,_) : dependenciesMap+=resolveVariableDependencies(exp,"Cond"+c@ref,dependenciesMap);
		case c:simpleIfCond(Expr exp,_) : dependenciesMap+=resolveVariableDependencies(exp,"Cond"+c@ref,dependenciesMap);
		case c:ifElseIfCond(Expr exp,_,_,_) : dependenciesMap+=resolveVariableDependencies(exp,"Cond"+c@ref,dependenciesMap);
		case c:elseif(Expr exp,_) : dependenciesMap+=resolveVariableDependencies(exp,"Cond"+c@ref,dependenciesMap);
	}
	
	return dependenciesMap;
}

map[str,list[str]] resolveVariableDependencies(Expr exp,str depended,map[str var,list[str] dependVars] dependenciesMap){
	vars=getVariableDependencies(exp);
	//14 tijs code has problem? ha
	for(x<-vars){
	 dependenciesMap[x]? ["a"] += [depended];
	}
	
	return dependenciesMap;
}
//8. Tijs provided better way..apply it..needs just return
public Type getVariableType(str variableName,list[FormBodyItem] bodyItems){

		visit(bodyItems){
			case simpleQuestion(variableName,_,Type qtype) : return qtype;
			case computedQuestion(variableName,_,Type qtype,_) : return qtype;
		}

}
