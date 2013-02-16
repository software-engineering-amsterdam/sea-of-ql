module lang::ql::compiler::GenerateJavaScript

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::CompileExpressions;
import lang::ql::compiler::ExtractDependencies;
import List;

import IO;

anno str ConditionalStatement@ref;
anno str ElseIf@ref;
anno str FormBodyItem@ref;

public str generateJavaScipt(list[FormBodyItem] bodyItems){
	str code="";
	
	code+=generateCompQuestionStat(bodyItems);
	dep=getDependenciesMap(bodyItems);
	code+=generateTriggerFunctions(dep);
	code+=generateConditionalStat(bodyItems);
	return code;
}

str generateCompQuestionStat(list[FormBodyItem] bodyItems){
	str code="";
	visit(bodyItems){
		case q:computedQuestion(_, str questionLabel,_,_) : code+=generateCompQuestionStat(q);
	}
	
	return code;
}

str generateCompQuestionStat(computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation)){
	str code="";

	list[str] dependancies=getVariableDependacies(questionComputation);
	
	str dependsSet="";
	str dependsClose="";
	
	for(depVar<-dependancies) {
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsClose+="}";
	}
	
	code+="function <questionId>Update(){
		  '<dependsSet>
		  '\t\tdocument.getElementById(\"<questionId>\").value=<generateJavaScriptExpr(questionComputation)>;
		  '}<dependsClose>
	";

	return code;

}

str generateTriggerFunctions(map[str var,list[str] dependVars] dependanciesMap){
	str code="";
	
	for(variable<-dependanciesMap){
		code+="function <variable>Trigger(){
			<for(depended<-dependanciesMap[variable]){>
			'\t<depended>Update();<}> \n}";
	}
	
	return code;
}


str generateConditionalStat(list[FormBodyItem] bodyItems){
	str code="";
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : code+=generateConditionalStat(q);
		case q:simpleIfCond(_,_) : code+=generateConditionalStat(q);
		case q:ifElseIfCond(_,_,_,_) : code+=generateConditionalStat(q);
		case q:elseif(Expr ifExpression,list[FormBodyItem] elseQuestions):print("ok");
	}
	
	return code;
}

str generateConditionalStat(q:ifCond(Expr ifCondition,_,_)){
	str code="";
	
	code+="function Cond<q@ref>Update(){
	'\t obj1=document.getElementById(\"ifStats<q@ref>\");
	'\t obj2=document.getElementById(\"elseStats<q@ref>\");
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t obj1.style.display = \'\';
	'\t\t obj2.style.display = \'none\';
	'\t\t}
	'\t else{
	'\t\t obj2.style.display = \'\';
	'\t\t obj1.style.display = \'none\';
	'\t}\n}\n";
	
	return code;
}

str generateConditionalStat(q:simpleIfCond(Expr ifCondition,_)){
	str code="";
	
	code+="function Cond<q@ref>Update(){
	'\t obj1=document.getElementById(\"ifStats<q@ref>\");
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t obj1.style.display = \'\';
	'\t\t}
	'\t else{
	'\t\t obj1.style.display = \'none\';
	'\t}\n}\n";
	
	return code;
}

str generateConditionalStat(q:ifElseIfCond(Expr ifCondition,_,list[ElseIf] elseifBranch,_)){
	str code="";

	code+="function Cond<q@ref>Update(){
	'\t obj1=document.getElementById(\"ifStats<q@ref>\");
	'\t obj2=document.getElementById(\"elseStats<q@ref>\");
	<for(elif<-elseifBranch){> 
	'\t obj<indexOf(elseifBranch,elif)+3>=document.getElementById(\"elseIfStats<elif@ref>\");<}>
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t obj1.style.display = \'\';
	'\t\t obj2.style.display = \'none\';
	<for(elif<-elseifBranch){ >	 obj<indexOf(elseifBranch,elif)+3>.style.display=\'none\';
	<}>
	'\t\t}
	'<generateElseIfStat(elseifBranch)>
	'\t else{
	'\t\t obj2.style.display = \'\';
	'\t\t obj1.style.display = \'none\';
	<for(elif<-elseifBranch){ >	 obj<indexOf(elseifBranch,elif)+3>.style.display=\'none\';
	<}>
	'\t}\n}\n";
	
	return code;
}

str generateElseIfStat(list[ElseIf] elseifBranch){
	str code="";
	for(elseif<-elseifBranch){
		code+="\telse if(){
		'\t\t obj<indexOf(elseifBranch,elseif)+3>.style.display=\'\';
		'\t\t obj1.style.display =  \'none\';
		'\t\t obj2.style.display = \'none\';
		'}
		"
		;
	}
	
	return code;
}