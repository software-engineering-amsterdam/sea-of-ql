module lang::ql::IDE::Outline

import lang::ql::ast::AST;
import IO;
import ParseTree;
import util::IDE;
import Node;
import List;
import String;

public node outline(form(str ident,list[FormBodyItem] formItem)) { 
 	node n="form"(outline(formItem));
 	return n;
 }
 
list[node] outline(list[FormBodyItem] formItem){
	node Questions="Questions"([outline(x) | x<-formItem, question(_) := x ]);
	node Conditions="Conditions"([outline(x) | x<-formItem, conditionalStatement(_) := x ]);
	
	return([Questions,Conditions]);
	
} 

node outline(question(q)) {
	node n="Questions"(outline(q));
	return outline(q);
}

node outline(conditionalStatement(ConditionalStatement itemCondStatement)){
	node n=outline(itemCondStatement);
	return n;
}

node outline(s:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion)) {
	return "ifelse"(outline(ifQuestion))[@label="ifelse <ifCond>"][@\loc=s@location];
}

node outline(s:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion)) {
	return "if"(outline(ifQuestion))[@label="if"][@\loc=s@location];
}

node outline(s:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion)) {
	return "ifelseif"()[@label="ifelseif"][@\loc=s@location];
}

node outline(s:elseif(Expr ifExpression,list[FormBodyItem] elseQuestion)) {
	return "else"()[@label="else"][@\loc=s@location];
}


node outline(q:simpleQuestion(str questionId,str questionLabel,Type questionType)) {
node n="simple"([questionLabel,questionType,"Answerable"])[@label="<questionId>"][@\loc=q@location];
return n;
}

node outline(Question q:computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation)) {
 node n="computed"([questionLabel,questionType,"Computed"])[@label="<questionId>"][@\loc=q@location];
 return n;
 }