module IDE::Outline

import syntax::Abstract;
import TypeCheck::QuestionChecker;
import Prelude;
import Node;
import IO;

public node outline(form(id,Body))
{
	list[node] outlineList = [];
	outlineList = outlineBody(Body, outlineList);
	node outlineNode = "form"(outlineList);
	return outlineNode;	
}

list[node] outlineBody(list[Body] body, list[node] outlineList)
{
	for(k <- body)
	{
		visit(k)
		{ 
			case Question Q : outlineList += outline(Q, outlineList);
			case Statement S : outlineList += outline(S, outlineList);
		}
	}
	return outlineList;
}

node outline(statement:ifStat(Expression exp, list[Body] body), list[node] outlineList) = statement;	

node outline(statement:ifElseStat(Expression exp, list[Body] body, list[Body] body), list[node] outlineList) = statement;

node outline(question:uncomputedQuestion(str id, str labelQuestion, Type tp), list[node] outlineList) = question;

node outline(question:computedQuestion(str id, str labelQuestion, Type tp,Expression exp ), list[node] outlineList) = question;              


