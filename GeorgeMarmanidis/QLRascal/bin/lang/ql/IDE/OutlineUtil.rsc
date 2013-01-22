module lang::ql::IDE::OutlineUtil

import lang::ql::ast::AST;
import Node;

alias OND = tuple[ list[node] questions, list[node] conditionals];

public OND addQuestion(OND nds, str qIdent,str qLabel,Type qType,bool isComputed,loc qloc) = nds[questions = nds.questions + makeNode("<qIdent>",[qLabel,qType,isComputed,qloc])];
public OND addCondition(OND nds, str qIdent,str qLabel,Type qType,bool isComputed,loc qloc) = nds[questions = nds.questions + makeNode("<qIdent>",[qLabel,qType,isComputed,qloc])];

public OND outlineUtil(form(str ident,list[FormBodyItem] formItem)) {
	OND nds=<[],[]>; 
	nds=outlined(formItem,nds); 
 	//node n="form"(outlined(formItem,nds));
 	//return n;
 	return nds;
 }
 
OND outlined(list[FormBodyItem] formItem,OND nds){
	for(x<-formItem){
		nds=outlined(x,nds);
	}
	
	return(nds);
	
} 

OND outlined(question(q),OND nds) {
	
	return outlined(q,nds);
}

OND outlined(conditionalStatement(ConditionalStatement itemCondStatement),OND nds){
	return outlined(itemCondStatement,nds);;
}

OND outlined(s:ifCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outlined(ifQuestion,nds);
	nds=outlined(elseQuestion,nds);
	//add if statement to nds
	return nds;
}

OND outlined(s:simpleIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion),OND nds) {
	nds=outlined(ifQuestion,nds);
	//add if to nds
	return nds;
}

OND outlined(s:ifElseIfCond(Expr ifCondition,list[FormBodyItem] ifQuestion,list[ElseIf] elseifBranch,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outlined(ifQuestion,nds);
	//add all
	return nds;
}

OND outlined(s:elseif(Expr ifExpression,list[FormBodyItem] elseQuestion),OND nds) {
	nds=outlined(elseQuestion,nds);
	return nds;
}


OND outlined(q:simpleQuestion(str questionId,str questionLabel,Type questionType),OND nds) {
	nds=addQuestion(nds,questionId,questionLabel,questionType,false,q@location);
	return nds;
}

OND outlined(Question q:computedQuestion(str questionId, str questionLabel, Type questionType, Expr questionComputation),OND nds) {
 	nds=addQuestion(nds,questionId,questionLabel,questionType,true,q@location);
 	return nds;
 }