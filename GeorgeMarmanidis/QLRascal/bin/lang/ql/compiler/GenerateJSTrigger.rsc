@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSTrigger

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;
import List;
import String;

public str generateJSTriggerFunctions(map[str var,list[str] dependVars] dependenciesMap){
	str code="";
	
	for(variable<-dependenciesMap){
		code+="function <variable>Trigger(){
			  '<for(depended<-dependenciesMap[variable]){>
			  '   <generateUpdateFunction(depended)>
			  '   <generateTriggerFunction(depended,dependenciesMap)><}> 			
			  '}
			  '
";
	}
	
	return code;
}

str generateUpdateFunction(str variable){
	return startsWith(variable,"Cond") 
			? !contains(variable,"e")
				?"<variable>Update();"
				:"<substring(variable,0,findFirst(variable,"e"))>Update(); " 
			: "<variable>Update();";
}

str generateTriggerFunction(str variable,map[str,list[str]] dependenciesMap){
	return startsWith(variable,"Cond")? 
			" " 
			: variable in dependenciesMap?"<variable>Trigger();":" ";
}