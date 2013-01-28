@contributor{George Marmanidis -geo.marmani@gmail.com}
module lang::ql::ide::Outline

import lang::ql::ast::AST;
import Node;
import List;

alias OND = tuple[ list[node] questions, list[node] conditionals];

public OND addQuestion(OND nds, str qIdent,str qLabel,Type qType,bool isComputed,loc qloc) = nds[questions = nds.questions + setAnnotations("<qIdent>"(qLabel,qType,isComputed), ("label":"<qIdent>", "loc":qloc))];
public OND addCondition(OND nds, str CondType,Expr CondExpr,loc qloc) = nds[conditionals = nds.conditionals + setAnnotations("Conditionals"(CondExpr), ("label":"<CondType>", "loc":qloc))];

public node outline(form(str ident,list[FormBodyItem] formItem)) {
	OND nds=<[],[]>; 
	nds=outline(formItem,nds);
	
	node Questions=makeNode("Questions (<size(nds.questions)>)",nds.questions);
	node Conditionals=makeNode("Conditionals (<size(nds.conditionals)>)",nds.conditionals); 
 	node n="form"(Questions,Conditionals);
 	
 	return n;
 }
 
OND outline(list[FormBodyItem] formItem,OND nds){
	for(x<-formItem){
		nds=outline(x,nds);
	}
	
	return(nds);	
} 

OND outline(question(q),OND nds) {
	
	return outline(q,nds);
}

OND outline(conditionalStatement(ConditionalStatement itemCondStatement),OND nds){
	return outline(itemCondStatement,nds);;
}

OND outline(s:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outline(ifQuestion,nds);
	nds=outline(elseQuestion,nds);
	nds=addCondition(nds,"If Else",ifCondition,s@location);
	return nds;
}

OND outline(s:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion),OND nds) {
	nds=outline(ifQuestion,nds);
	nds=addCondition(nds,"If",ifCondition,s@location);
	return nds;
}

OND outline(s:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outline(ifQuestion,nds);
	nds=outline(elseQuestion,nds);
	nds=outline(elseifBranch,nds);
	nds=addCondition(nds,"If Else If",ifCondition,s@location);
	return nds;
}

OND outline(list[ElseIf] elseifBranch,OND nds) {
	for(x<-elseifBranch){
		nds=outline(x,nds);
	}
	return nds;
}

OND outline(s:elseif(Expr ifExpression,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outline(elseQuestion,nds);
	nds=addCondition(nds,"Else If",ifExpression,s@location);
	return nds;
}


OND outline(q:simpleQuestion(str questionId,str questionLabel,Type questionType),OND nds) {
	nds=addQuestion(nds,questionId,questionLabel,questionType,false,q@location);
	return nds;
}

OND outline(Question q:computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),OND nds) {
 	nds=addQuestion(nds,questionId,questionLabel,questionType,true,q@location);
 	return nds;
 }