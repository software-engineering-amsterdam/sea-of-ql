@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSUpdate
//need to change the indside dependencies..create a function witch returns the dependIfs

import lang::ql::ast::AST;
import lang::ql::compiler::CompileExpressions;
import lang::ql::compiler::ExtractDependencies;
import List;
import String;

public str generateJSUpdateFunctions(list[FormBodyItem] bodyItems){
	return generateCompQuestionsUpdate(bodyItems) + generateCondStatUpdate(bodyItems);
}

str generateCompQuestionsUpdate(list[FormBodyItem] bodyItems){
	str code="";
	visit(bodyItems){
		case q:computedQuestion(_,_,_,_) : code+=generateCompQuestionsUpdate(q,bodyItems);
	}
	
	return code;
}

str generateCondStatUpdate(list[FormBodyItem] bodyItems){
	str code="";
	
	visit(bodyItems){
		case q:ifCond(_,_,_) : code+=generateCondStatUpdate(q,bodyItems);
		case q:simpleIfCond(_,_) : code+=generateCondStatUpdate(q,bodyItems);
		case q:ifElseIfCond(_,_,_,_) : code+=generateCondStatUpdate(q,bodyItems);
	}
	
	return code;
}

str generateCompQuestionsUpdate(computedQuestion(str questionId,_,_, Expr questionComputation),list[FormBodyItem] bodyItems){
	str code="";
	
	list[str] dependencies=getVariableDependecies(questionComputation);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependencies) {
		if(getVariableType(depVar,bodyItems)!=boolean()){
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
		}
	}
	
	code+="function <questionId>Update(){
		  '<dependsSet>
		  '\t\t<generateGetElementbyIdValue(questionId,getVariableType(questionId,bodyItems))>=<generateJavaScriptExpr(questionComputation,bodyItems)>;
		  '<dependsCloseBrackets>}\n\n";

	return code;

}

str generateCondStatUpdate(q:ifCond(Expr ifCondition,_,_),list[FormBodyItem] bodyItems){
	str code="";
	
	list[str] dependencies=getVariableDependecies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependencies) {
		if(getVariableType(depVar,bodyItems)!=boolean()){
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
		}
	}
	
	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'\t <generateObjAssignbyId("obj2","elseStats<q@ref>")>
	'\t if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
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

str generateCondStatUpdate(q:simpleIfCond(Expr ifCondition,_),list[FormBodyItem] bodyItems){
	str code="";
	
	list[str] dependencies=getVariableDependecies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependencies) {
		if(getVariableType(depVar,bodyItems)!=boolean()){
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
		}
	}
	
	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'\t if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
	'\t\t <generateObjShow("obj1")>
	'\t\t}
	'\t else{
	'\t\t <generateObjHide("obj1")>
	'\t}\n<dependsCloseBrackets>
	'}\n";
	
	return code;
}

str generateCondStatUpdate(q:ifElseIfCond(Expr ifCondition,_,list[ElseIf] elseifBranch,_),list[FormBodyItem] bodyItems){
	str code="";
	
	list[str] dependencies=getVariableDependecies(ifCondition);
	
	str dependsSet="";
	str dependsCloseBrackets="";
	
	for(depVar<-dependencies) {
		if(getVariableType(depVar,bodyItems)!=boolean()){
		dependsSet+="\tif(document.getElementById(\"<depVar>\").value){\n";
		dependsCloseBrackets+="\t}\n";
		}
	}

	code+="function Cond<q@ref>Update(){
	'<dependsSet>
	'\t <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'\t <generateObjAssignbyId("obj2","elseStats<q@ref>")>
	<for(elif<-elseifBranch){> 
	'\t <generateObjAssignbyId("obj<indexOf(elseifBranch,elif)+3>","elseIfStats<elif@ref>")><}>
	'\t if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
	'\t\t <generateObjShow("obj1")>
	'\t\t <generateObjHide("obj2")>
	<for(elif<-elseifBranch){ >	 obj<indexOf(elseifBranch,elif)+3>.style.display=\'none\';
	<}>
	'\t\t}
	'<generateElseIfStat(elseifBranch,bodyItems)>
	'\t else{
	'\t\t <generateObjShow("obj2")>
	'\t\t <generateObjHide("obj1")>
	<for(elif<-elseifBranch){ ><generateObjHide("obj<indexOf(elseifBranch,elif)+3>")>	 
	<}>
	'\t}\n<dependsCloseBrackets>
	'}\n";
	
	return code;
}

str generateElseIfStat(list[ElseIf] elseifBranch,list[FormBodyItem] bodyItems){
	str code="";
	Expr currentExp=ident("");
	
	for(elseifCurrent<-elseifBranch){
		if(elseif(Expr ifExpression,_) := elseifCurrent) currentExp=ifExpression;
		int index=indexOf(elseifBranch,elseifCurrent);
		
		code+="\telse if(<generateJavaScriptExpr(currentExp,bodyItems)>){
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

str generateObjHide(str objId)="<objId>.style.display = \'none\';";
str generateObjShow(str objId)="<objId>.style.display = \'\';";
str generateObjAssignbyId(str objName,str objId)="<objName>=document.getElementById(\"<objId>\");";
str generateGetElementbyIdValue(str varId,Type varType)=
	varType==boolean()?"document.getElementById(\"<varId>\").checked":"document.getElementById(\"<varId>\").value";
	


