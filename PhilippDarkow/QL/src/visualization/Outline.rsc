module visualization::Outline

import syntax::AbstractSyntax;
import Prelude;

public node outline(program(id,Body)){
	list[node] outlineList = [];
	outlineList = outlineBody(Body, outlineList);
	if(id == ""){
		return id;
	}
	node outlineNode = "form"(outlineList);
	return outlineNode;	
}

list[node] outlineBody(list[Body] body, list[node] outlineList){
	for(k <- body){
		top-down visit(k) {
			case Question q : outlineList += outline(q, outlineList);
			case Statement s : outlineList += outline(s, outlineList);
		}
	}
	return outlineList;
}

node outline(question:easyQuestion(str id, str labelQuestion, Type tp), list[node] outlineList) = question;

node outline(question:computedQuestion(str id, str labelQuestion, Type tp,Expression exp ), list[node] outlineList) =
   question;

node outline(statement:ifStat(Expression exp, list[Body] body), list[node] outlineList) = statement;	

node outline(statement:ifElseStat(Expression exp, list[Body] body, list[Body] body), list[node] outlineList) = statement;