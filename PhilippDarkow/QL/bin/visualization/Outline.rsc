module visualization::Outline

import syntax::AbstractSyntax;
import Prelude;

public node outline(program(id,Body)){
	println("in outline <Body>");
	outlineBody(Body);
	if(id == ""){
		println("OUTLINE THAT");
		return id;
	}
	
}

node outlineBody(list[Body] body){
	println("In outline BODY <body>");
	for(s <- body){
		visit(s) {
			case Question q : {
				println();
			}
		}
	}
}

node outline(question:easyQuestion(str id, str labelQuestion, Type tp)){

}

node outline(question:computedQuestion(str id, str labelQuestion, Type tp,Expression exp )){

}

node outline(statement:ifStat(Expression exp, list[Body] body)){

}

node outline(statement:ifElseStat(Expression exp, list[Body] thenpart, list[Body] elsepart)){

}