@contributor{George Marmanidis -geo.marmani@gmail.com}
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
	
	code+=generateOnLoadFunction(bodyItems);
	code+=generateCompQuestionsUpdate(bodyItems);
	code+=generateTriggerVariableFunctions(dep);
	code+=generateCondStatUpdate(bodyItems);
	return code;
}

str generateCompQuestionsUpdate(list[FormBodyItem] bodyItems){
	str code="";
	visit(bodyItems){
		case q:computedQuestion(_,_,_,_) : code+=generateCompQuestionsUpdate(q);
	}
	
	return code;
}

str generateCompQuestionsUpdate(computedQuestion(str questionId,_,_, Expr questionComputation)){
	str code="";

	list[str] dependancies=getVariableDependacies(questionComputation);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependancies) {
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
	}
	
	code+="function <questionId>Update(){
		  '<dependsSet>
		  '\t\tdocument.getElementById(\"<questionId>\").value=<generateJavaScriptExpr(questionComputation)>;
		  '<dependsCloseBrackets>}\n\n";

	return code;

}

str generateTriggerVariableFunctions(map[str var,list[str] dependVars] dependanciesMap){
	str code="";
	
	for(variable<-dependanciesMap){
		code+="function <variable>Trigger(){
			<for(depended<-dependanciesMap[variable]){><generateUpdateFunction(depended)><generateTriggerFunction(depended,dependanciesMap)><}> 			
			'}\n\n";
	}
	
	return code;
}

str generateUpdateFunction(str variable){
	return startsWith(variable,"Cond") 
			? !contains(variable,"e")
				?"\n\t<variable>Update();"
				:"\n\t<substring(variable,0,findFirst(variable,"e"))>Update(); " 
			: "\n\t<variable>Update();";
}

str generateTriggerFunction(str variable,map[str,list[str]] dependanciesMap){
	return startsWith(variable,"Cond")? 
			" " 
			: variable in dependanciesMap?"\n\t<variable>Trigger();":" ";
}

str generateCondStatUpdate(list[FormBodyItem] bodyItems){
	str code="";
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : code+=generateCondStatUpdate(q);
		case q:simpleIfCond(_,_) : code+=generateCondStatUpdate(q);
		case q:ifElseIfCond(_,_,_,_) : code+=generateCondStatUpdate(q);
	}
	
	return code;
}

str generateObjHide(str objId)="<objId>.style.display = \'none\';";
str generateObjShow(str objId)="<objId>.style.display = \'\';";
str generateGetElement(str objName,str objId)="<objName>=document.getElementById(\"<objId>\");";

str generateCondStatUpdate(q:ifCond(Expr ifCondition,_,_)){
	str code="";
	
	list[str] dependancies=getVariableDependacies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependancies) {
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
	}
	
	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateGetElement("obj1","ifStats<q@ref>")>
	'\t <generateGetElement("obj2","elseStats<q@ref>")>
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t <generateObjShow("obj1")>
	'\t\t <generateObjHide("obj2")>
	'\t\t}
	'\t else{
	'\t\t <generateObjShow("obj2")>
	'\t\t <generateObjHide("obj1")>
	'\t}\n<dependsCloseBrackets>
	'}\n";
	
	return code;
}



str generateCondStatUpdate(q:simpleIfCond(Expr ifCondition,_)){
	str code="";
	
	list[str] dependancies=getVariableDependacies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependancies) {
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
	}
	
	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateGetElement("obj1","ifStats<q@ref>")>
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t <generateObjShow("obj1")>
	'\t\t}
	'\t else{
	'\t\t <generateObjHide("obj1")>
	'\t}\n<dependsCloseBrackets>
	'}\n";
	
	return code;
}

str generateCondStatUpdate(q:ifElseIfCond(Expr ifCondition,_,list[ElseIf] elseifBranch,_)){
	str code="";
	
	list[str] dependancies=getVariableDependacies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependancies) {
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
	}

	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateGetElement("obj1","ifStats<q@ref>")>
	'\t <generateGetElement("obj2","elseStats<q@ref>")>
	<for(elif<-elseifBranch){> 
	'\t <generateGetElement("obj<indexOf(elseifBranch,elif)+3>","elseIfStats<elif@ref>")><}>
	'\t if(<generateJavaScriptExpr(ifCondition)>){
	'\t\t <generateObjShow("obj1")>
	'\t\t <generateObjHide("obj2")>
	<for(elif<-elseifBranch){ >	 obj<indexOf(elseifBranch,elif)+3>.style.display=\'none\';
	<}>
	'\t\t}
	'<generateElseIfStat(elseifBranch)>
	'\t else{
	'\t\t <generateObjShow("obj2")>
	'\t\t <generateObjHide("obj1")>
	<for(elif<-elseifBranch){ ><generateObjHide("obj<indexOf(elseifBranch,elif)+3>")>	 
	<}>
	'\t}\n<dependsCloseBrackets>
	'}\n";
	
	return code;
}

str generateElseIfStat(list[ElseIf] elseifBranch){
	str code="";
	Expr currentExp=ident("");
	
	for(elseifCurrent<-elseifBranch){
		if(elseif(Expr ifExpression,_) := elseifCurrent) currentExp=ifExpression;
		int index=indexOf(elseifBranch,elseifCurrent);
		
		code+="\telse if(<generateJavaScriptExpr(currentExp)>){
		'\t\t <generateObjShow("obj<index+3>")>
		'\t\t <generateObjHide("obj2")>
		'\t\t <generateObjHide("obj1")>
		<for(elseif<-elseifBranch) {><generateElseIfStatObjects(index,indexOf(elseifBranch,elseif))><}>
		}\n"
		;
	}
	
	return code;
}

str generateElseIfStatObjects(int indexCurrent,int indexObj){
	return indexCurrent!=indexObj?"<generateObjHide("obj<indexObj+3>")>":"";
}

str generateOnLoadFunction(list[FormBodyItem] bodyItems){
	str code="function onLoad(){
	'obj1=document.getElementById(\"stats0\");
	'obj1.style.display=\'\';";
	int objCounter=2;
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : 
			{
				code+=generateOnLoadHiddenObjects("ifStats"+q@ref,objCounter); 
				objCounter+=1;
				code+=generateOnLoadHiddenObjects("elseStats"+q@ref,objCounter);
				objCounter+=1;
			}
		case q:simpleIfCond(_,_) : 
			{
				code+=generateOnLoadHiddenObjects("ifStats"+q@ref,objCounter); 
				objCounter+=1;
			}
		case q:ifElseIfCond(_,_,list[ElseIf] elseIfs,_) : 
			{
				code+=generateOnLoadHiddenObjects("ifStats"+q@ref,objCounter);
				objCounter+=1;
				for(elseif<-elseIfs){
					code+=generateOnLoadHiddenObjects("elseIfStats"+q@ref+"e<indexOf(elseIfs,elseif)+1>",objCounter);
					objCounter+=1;
				}
				code+=generateOnLoadHiddenObjects("elseStats"+q@ref,objCounter);
				objCounter+=1;
			}
	}
	code+="}\n\n";
	return code;
}

str generateOnLoadHiddenObjects(str refId,int objCounter)=
	"\n<generateGetElement("obj<objCounter>","<refId>")>
	'<generateObjHide("obj<objCounter>")>";