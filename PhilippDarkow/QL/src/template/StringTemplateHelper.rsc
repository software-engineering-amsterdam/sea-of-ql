module template::StringTemplateHelper

import syntax::AbstractSyntax;
import Prelude;
import template::StringTemplate;

/** Method to 
*/
public list[tuple[str ,Type]] getExpressionTypeGenerate(exp:id(str id),list[Body] body){
	list[tuple[str qId,Type tp]] types = [];
	for(b <- body){
		visit(b){
			case Question q : {				
				if(toString(getChildren(q)[0]) == id){	//matching
					types += [<id,getTypeFromQuestion(q)>];
				}
			}
		}		
	}
	return types;
}

/** Method to 
*/
public list[tuple[str id,Type tp]] getExpressionTypeGenerate(Expression exp,list[Body] body){
	list[tuple[str id,Type tp]] idAndTypes = [];
	list[str] ids = [];
	visit(exp){
		case Expression e : {
			if(getName(e) == "id"){
				ids += toString(getChildren(e)[0]);	
			}else if(getName(e) == "boolCon"){
				idAndTypes += [<"", boolean()>];
			}
		}
	}
	println("ids is  : <ids>");		// maybe making a second method
	
	for(b <- body){
		visit(b){
			case Question q : {	
				for(n <- ids){		
				if(toString(getChildren(q)[0]) == n){	//matching			
					idAndTypes += [<getIdFromQuestion(q),getTypeFromQuestion(q)>];		
				}
				}	
			}
		}		
	}
	return idAndTypes;
}

Type getTypeFromQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)) = tp;
	
Type getTypeFromQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)) = tp;

str getIdFromQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)) = id;

str getIdFromQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)) = id;

/** Method to get the else part as a string and the childrens of the else part
* @param formId the name of the questionaire
* @param thenPart the then part as a list 
* @param body the complete body of the questionaire
* @author Philipp
*/
public tuple[list[str] ,list[str] ] getThenPartIfElse(str formId, list[Body] thenPart, list[Body] body){
			list[str] thenPartString = [];		// create empty list 
			list[str] children = [];			// create empty list for the childrens
			for(s <- thenPart){					// run through the then part
				thenPartString += generateBody(formId, s, body);
				visit (s) {			
					case Question q : { children += q.id; }
				}		
			}
			return <thenPartString,children>;
}

/** Method to get the else part as a string and the childrens of the else part
* @param formId the name of the questionaire
* @param elsePart the else part as a list 
* @param body the complete body of the questionaire
* @author Philipp
*/
public tuple[list[str] ,list[str]] getElsePartIfElse(str formId, list[Body] elsePart, list[Body] body){
			list[str] elsePartString = [];		// create empty list 
			list[str] childrenElse = [];		// create empty list for the childrens
			for(j <- elsePart){					// run through the else part
				elsePartString += generateBody(formId, j, body);	
					visit (j) {			
						case Question q : { childrenElse += q.id; }
					}		
			}
			return <elsePartString,childrenElse>;
}

public str getQLFormString(str formId){
	return "\<!DOCTYPE html\>
		'\<html\>
		'	\<head\>
		'	\<script src=\"<formId>.js\"\> \</script\>
		'	\<link href=\"<formId>.css\" rel=\"stylesheet\" type=\"text/css\"\>
		'	\</head\>
		'	\<body\>
		'	\<script\>
			'	createForm();
		'	\</script\>
		'	\</body\>
		'\</html\>";
}