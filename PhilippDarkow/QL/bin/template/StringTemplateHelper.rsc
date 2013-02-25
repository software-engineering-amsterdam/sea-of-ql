module template::StringTemplateHelper

import syntax::AbstractSyntax;
import Prelude;

public list[Type] getExpressionTypeGenerate(exp:id(str id),list[Body] body){
	println("Body is <body>");
	list[Type] types = [];
	for(b <- body){
		visit(b){
			case Question q : {				
				if(toString(getChildren(q)[0]) == id){	//matching
					println("WE HAVE A MATCH");
					types += getTypeFromQuestion(q);
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
	list[str] ids = [];
	visit(exp){
		case Expression e : {
			println("ID is : <e>");
			if(getName(e) == "id"){
				ids += toString(getChildren(e)[0]);	
			}
		}
	}
	println("ids is  : <ids>");		// maybe making a second method
	list[tuple[str id,Type tp]] idAndTypes = [];
	for(b <- body){
		visit(b){
			case Question q : {	
				println("QQQ : <q>");
				println("getChildren(q)[0] : <getChildren(q)[0]>");			
				if(toString(getChildren(q)[0]) == ids[0]){	//matching
					println("WE HAVE A MATCH");					
					idAndTypes += [<getIdFromQuestion(q),getTypeFromQuestion(q)>];		//getTypeFromQuestion(q);
				}
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