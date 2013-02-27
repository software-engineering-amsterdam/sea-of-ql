@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSUpdate

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
		case ConditionalStatement cs : code+=generateCondStatUpdate(cs,bodyItems);
	}
	
	return code;
}

str generateCompQuestionsUpdate(computedQuestion(str questionId,_,_, Expr questionComputation),list[FormBodyItem] bodyItems){
	str code="";
	tuple[str dependsSet,str dependsCloseBrackets] deps=generateIsValuesSet(questionComputation,bodyItems);

	code+="function <questionId>Update(){
		  '<deps.dependsSet>
		  '     <generateGetElementbyIdValue(questionId,getVariableType(questionId,bodyItems))>=<generateJavaScriptExpr(questionComputation,bodyItems)>;
		  '<deps.dependsCloseBrackets>}\n\n";

	return code;
}

str generateCondStatUpdate(q:ifCond(Expr ifCondition,_,_),list[FormBodyItem] bodyItems){
	str code="";
	tuple[str dependsSet,str dependsCloseBrackets] deps=generateIsValuesSet(ifCondition,bodyItems);
	
	code+="function Cond<q@ref>Update(){
	'<deps.dependsSet>
	'   <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'   <generateObjAssignbyId("obj2","elseStats<q@ref>")>
	'   if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
	'     <generateObjShow("obj1")>
	'     <generateObjHide("obj2")>
	'   }
	'   else{
	'     <generateObjShow("obj2")>
	'     <generateObjHide("obj1")>
	'   }
	'<deps.dependsCloseBrackets>
	'}
	";
	
	return code;
}

str generateCondStatUpdate(q:simpleIfCond(Expr ifCondition,_),list[FormBodyItem] bodyItems){
	str code="";
	tuple[str dependsSet,str dependsCloseBrackets] deps=generateIsValuesSet(ifCondition,bodyItems);
	
	code+="function Cond<q@ref>Update(){
	'  <deps.dependsSet>
	'   <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'    if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
	'       <generateObjShow("obj1")>
	'    }
	'    else{
	'       <generateObjHide("obj1")>
	'    }
	'  <deps.dependsCloseBrackets>
	'}
	";
	
	return code;
}

str generateCondStatUpdate(q:ifElseIfCond(Expr ifCondition,_,list[ElseIf] elseifBranch,_),list[FormBodyItem] bodyItems){
	str code="";
	tuple[str dependsSet,str dependsCloseBrackets] deps=generateIsValuesSet(ifCondition,bodyItems);
	
	code+="function Cond<q@ref>Update(){
	'   <deps.dependsSet>
	'   <generateObjAssignbyId("obj1","ifStats<q@ref>")>
	'   <generateObjAssignbyId("obj2","elseStats<q@ref>")>
	<for(elif<-elseifBranch){> 
	'   <generateObjAssignbyId("obj<indexOf(elseifBranch,elif)+3>","elseIfStats<elif@ref>")><}>
	'   if(<generateJavaScriptExpr(ifCondition,bodyItems)>){
	'      <generateObjShow("obj1")>
	'      <generateObjHide("obj2")>
	<for(elif<-elseifBranch){ >	 obj<indexOf(elseifBranch,elif)+3>.style.display=\'none\';
	<}>
	'     }
	'<generateElseIfStat(elseifBranch,bodyItems)>
	'   else{
	'     <generateObjShow("obj2")>
	'     <generateObjHide("obj1")>
	<for(elif<-elseifBranch){ ><generateObjHide("obj<indexOf(elseifBranch,elif)+3>")>	 
	<}>
	'   }
	'<deps.dependsCloseBrackets>
	'}
	";
	
	return code;
}

str generateElseIfStat(list[ElseIf] elseifBranch,list[FormBodyItem] bodyItems){
	str code="";
	Expr currentExp=ident("");
	
	for(elseifCurrent<-elseifBranch){
		if(elseif(Expr ifExpression,_) := elseifCurrent) currentExp=ifExpression;
		int index=indexOf(elseifBranch,elseifCurrent);
		
		code+="   else if(<generateJavaScriptExpr(currentExp,bodyItems)>){
		'      <generateObjShow("obj<index+3>")>
		'      <generateObjHide("obj2")>
		'      <generateObjHide("obj1")>
		<for(elseif<-elseifBranch) {><generateElseIfStatObjects(index,indexOf(elseifBranch,elseif))><}>
		}
		"
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

tuple[str,str] generateIsValuesSet(Expr expr,list[FormBodyItem] bodyItems){
	
	tuple[str dependsSet,str dependsCloseBrackets] deps=<"","">;
	list[str] dependencies=getVariableDependencies(expr);
	
	for(depVar<-dependencies) {
		if(getVariableType(depVar,bodyItems)!=boolean()){
			deps.dependsSet+="   if(document.getElementById(\"<depVar>\").value){\n";
			deps.dependsCloseBrackets+="\t}\n";
		}
	}

	return deps;
}
