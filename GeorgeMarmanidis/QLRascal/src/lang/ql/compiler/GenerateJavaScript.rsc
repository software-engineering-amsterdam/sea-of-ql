module lang::ql::compiler::GenerateJavaScript

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::CompileExpressions;
import lang::ql::compiler::ExtractDependencies;
import List;
import String;

import IO;

anno str ConditionalStatement@ref;
anno str ElseIf@ref;
anno str FormBodyItem@ref;

public str generateJavaScipt(list[FormBodyItem] bodyItems){
	str code="";
	dep=getDependenciesMap(bodyItems);
	
	code+=generateOnLoadStat(bodyItems);
	code+=generateCompQuestionStat(bodyItems);
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
			'\t<depended>Update();<generateTriggerFunctions(depended,dependanciesMap)><}> 			
			'
			'}";
	}
	
	return code;
}

str generateTriggerFunctions(str variable,map[str,list[str]] dependanciesMap){
	return startsWith(variable,"Cond")? 
			" " 
			: variable in dependanciesMap?"\n\t<variable>Trigger();":" ";
}

str generateConditionalStat(list[FormBodyItem] bodyItems){
	str code="";
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : code+=generateConditionalStat(q);
		case q:simpleIfCond(_,_) : code+=generateConditionalStat(q);
		case q:ifElseIfCond(_,_,_,_) : code+=generateConditionalStat(q);
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
	Expr currentExp=ident("");
	for(elseifCurrent<-elseifBranch){
		if(elseif(Expr ifExpression,_) := elseifCurrent) currentExp=ifExpression;
		int index=indexOf(elseifBranch,elseifCurrent);
		code+="\telse if(<generateJavaScriptExpr(currentExp)>){
		'\t\t obj<index+3>.style.display=\'\';
		'\t\t obj1.style.display =  \'none\';
		'\t\t obj2.style.display = \'none\';
		<for(elseif<-elseifBranch) {><generateElseIfStatObjects(index,indexOf(elseifBranch,elseif))><}>
		}
		"
		;
	}
	
	return code;
}

str generateElseIfStatObjects(int indexCurrent,int indexObj){
	return indexCurrent!=indexObj?"\t\t obj<indexObj+3>.style.display=\'none\';":" ";
}

str generateOnLoadStat(list[FormBodyItem] bodyItems){
	str code="function onLoad(){
	'obj1=document.getElementById(\"stats0\");
	'obj1.style.display=\'\';";
	int objCounter=2;
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : 
			{
				code+=generateOnLoadStat("ifStats"+q@ref,objCounter); 
				objCounter+=1;
				code+=generateOnLoadStat("elseStats"+q@ref,objCounter);
				objCounter+=1;
			}
		case q:simpleIfCond(_,_) : 
			{
				code+=generateOnLoadStat("ifStats"+q@ref,objCounter); 
				objCounterr+=1;
			}
		case q:ifElseIfCond(_,_,list[ElseIf] elseIfs,_) : 
			{
				code+=generateOnLoadStat("ifStats"+q@ref,objCounter);
				objCounter+=1;
				for(elseif<-elseIfs){
					code+=generateOnLoadStat("elseIfStats"+q@ref+"e<indexOf(elseIfs,elseif)+1>",objCounter);
					objCounter+=1;
				}
				code+=generateOnLoadStat("elseStats"+q@ref,objCounter);
				objCounter+=1;
			}
	}
	code+="}\n";
	return code;
}

str generateOnLoadStat(str refId,int objCounter){
	return "\nobj<objCounter>=document.getElementById(\"<refId>\");
	'obj<objCounter>.style.display=\'none\';";
}