@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::ExtractDependencies
//import IO;

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::CompileExpressions;

public list[str] getVariableDependecies(Expr exp){
	list[str] variables=[];
	
	visit(exp){
		case ident(str name) :variables=variables+name; 
	}
	
	return variables;
}

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
	vars=getVariableDependecies(exp);
	
	for(x<-vars){
		if(x in dependenciesMap){
			dependenciesMap[x]+=[depended];
		}else
		{
			dependenciesMap+=("<x>":[depended]);
		}
	}
	
	return dependenciesMap;
}

public Type getVariableType(str variableName,list[FormBodyItem] bodyItems){
	Type variableType=boolean();
		visit(bodyItems){
			case q:simpleQuestion(str ident,_,Type qtype) : if(ident==variableName) variableType= qtype;
			case q:computedQuestion(str ident,_,Type qtype,_) :if(ident==variableName) variableType= qtype;
		}
		return variableType;
}
