module template::StringTemplateHelper

import syntax::AbstractSyntax;
import Prelude;
import template::StringTemplate;

public list[tuple[str ,Type]] getExpressionTypeGenerate(exp:id(str id),list[Body] body){
	println("Body is <body>");
	list[tuple[str qId,Type tp]] types = [];
	for(b <- body){
		visit(b){
			case Question q : {				
				if(toString(getChildren(q)[0]) == id){	//matching
					println("WE HAVE A MATCH");
					types += [<id,getTypeFromQuestion(q)>];
				}
			}
		}		
	}
	println("TYPESSS : <types>");
	return types;
}

public list[tuple[str id,Type tp]] getExpressionTypeGenerate(Expression exp,list[Body] body){
	println("Body is <body>");
	println("EXP is <exp>");
	list[tuple[str id,Type tp]] idAndTypes = [];
	list[str] ids = [];
	visit(exp){
		case Expression e : {
			println("ID is : <getName(e)>");
			if(getName(e) == "id"){
				ids += toString(getChildren(e)[0]);	
			}else if(getName(e) == "boolCon"){
				println("BUUUU");
				idAndTypes += [<"", boolean()>];
			}
		}
	}
	println("ids is  : <ids>");		// maybe making a second method
	
	for(b <- body){
		visit(b){
			case Question q : {	
				println("QQQ : <q>");
				println("getChildren(q)[0] : <getChildren(q)[0]>");	
				for(n <- ids){		
				if(toString(getChildren(q)[0]) == n){	//matching
					println("WE HAVE A MATCH");				
					idAndTypes += [<getIdFromQuestion(q),getTypeFromQuestion(q)>];		//getTypeFromQuestion(q);
				}
				}
				//n = n + 1;	
			}
		}		
	}
	println("TYPESSS : <idAndTypes>");
	return idAndTypes;
}

Type getTypeFromQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	return tp;
}

Type getTypeFromQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	return tp;
}

str getIdFromQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	return id;
}

str getIdFromQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	return id;
}

public tuple[list[str] ,list[str] ] getThenPartIfElse(str formId, list[Body] thenPart, list[Body] body){
			list[str] thenPartString = [];
			list[str] children = [];
			for(s <- thenPart){
				thenPartString += generateBody(formId, s, body);
				visit (s) {			// visiting s to get the childrens id of the then part
					case Question q : { children += q.id; }
				}		
			}
			return <thenPartString,children>;
}

public tuple[list[str] ,list[str]] getElsePartIfElse(str formId, list[Body] elsePart, list[Body] body){
			list[str] elsePartString = [];
			list[str] childrenElse = [];
			for(j <- elsePart){
				elsePartString += generateBody(formId, j, body);
					visit (j) {			// visiting s to get the childrens id of the then part
						case Question q : { childrenElse += q.id; }
					}		
			}
			return <elsePartString,childrenElse>;
}