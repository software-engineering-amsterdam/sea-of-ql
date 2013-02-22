@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::compiler::GenerateJSOnLoad

import ParseTree;
import lang::ql::ast::AST;
import List;

str generateObjHide(str objId)="<objId>.style.display = \'none\';";
str generateObjShow(str objId)="<objId>.style.display = \'\';";
str generateObjAssignbyId(str objName,str objId)="<objName>=document.getElementById(\"<objId>\");";


public str generateOnLoadFunction(list[FormBodyItem] bodyItems){
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
	"\n<generateObjAssignbyId("obj<objCounter>","<refId>")>
	'<generateObjHide("obj<objCounter>")>";

