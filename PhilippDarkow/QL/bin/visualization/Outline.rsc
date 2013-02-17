module visualization::Outline

import syntax::AbstractSyntax;
import Prelude;

public alias Outline = tuple[list[node] questions,list[node] statements] ;

//addInstance(Outline out, str id, str questionLabel, Type tp, bool isComputed) = out[questions = out.questions + id];

//addInstance(QLTENV qlTenv, str id, str questionLabel, Type tp, bool isComputed) = qlTenv[question = qlTenv.question + {<id,questionLabel,tp,isComputed>}];

public node outline(program(id,Body)){
	println("in outline <Body>");
	Outline outlineList = [];
	list[node] b = [];
	outlineBody(Body, b);
	if(id == ""){
		println("OUTLINE THAT");
		return id;
	}
	
}

Outline outlineBody(list[Body] body, Outline outlineList){
	println("In outline BODY <body>");
	for(k <- body){
	println("S : <k>");
		top-down visit(s) {
			case Question q : {
				outlineList += outline(q, outlineList);
			}
			case Statement s : {
				outlineList += outline(s, outlineList);
			}
		}
	}
}

node outline(question:easyQuestion(str id, str labelQuestion, Type tp), Outline outlineList){
	println("In outline easy : <question>");
	return question;
}

Outline outline(question:computedQuestion(str id, str labelQuestion, Type tp,Expression exp ), Outline outlineList){
	println("In outline computed : <question>");
}

Outline outline(statement:ifStat(Expression exp, list[Body] body), Outline outlineList){
	println("In outline ifStat : <question>");
	return statement;	
}

Outline outline(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart), Outline outlineList){
	println("In outline ifElseStat : <question>");	
}