@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJavaScript

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::ExtractDependencies;
import lang::ql::compiler::GenerateJSUpdate;
import lang::ql::compiler::GenerateJSTrigger;
import lang::ql::compiler::GenerateJSOnLoad;

public str generateJavaScipt(list[FormBodyItem] bodyItems){
	str code="";
	dep=getDependenciesMap(bodyItems);
	
	code+=generateOnLoadFunction(bodyItems);
	code+=generateJSTriggerFunctions(dep);
	code+=generateJSUpdateFunctions(bodyItems);
	return code;
}
