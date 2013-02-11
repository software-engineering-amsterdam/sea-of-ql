module typeChecker::TypeHelper

import syntax::AbstractSyntax;
import typeChecker::TypeEnvironment;
import Prelude;

/** Method to get the type of an expression. Takes the first child of the exp node (id) and compared that with the QL
* environment ids.  
* @param exp the expression
* @param env the QLTENV
* @param return tp the Type of the expression
* @author Philipp
*/
Type findExpressionType(Expression exp, QLTENV env){
	println("arity of exp : <arity(exp)>");
	str s = "";
	if(arity(exp) > 1){
		println("MORE IDS");
		list [value id] k = getChildren(exp);
		//s = toString(getChildren(k[0]));
		println("K : <k[0]>");
		println("S : <s>");
	}else{
		s = toString(getChildren(exp)[0]);
	}
	println("find expression exp : <exp>");
	println("S is : <s>");
	println("ENV is : <env>");
	for(b <- env.question){
		println("B.id is <b.id>");
		if(b.id == s) return b.tp;
	}
}

public list[Type] getExpressionType(Expression exp, QLTENV env){
	// Making a set to check the two types
	list[Type] types = [];
	for(s <- getChildren(exp)){
		Type tp = findExpressionType(s, env);
		if(tp notin types) types += tp;
	}
	return types;
}


/** Method to check for double Identifiers in easy questions
* @param question the easy question to check
* @param env the QL Type environment
* @return true if no double Idenfiers
* @author Philipp
*/
public bool checkIdentifiers(question:easyQuestion(str id, str labelQuestion, Type tp) ,QLTENV env){
	if(question.id in env.question.id) return false;
	else return true;
}

/** Method to check for double Identifiers in computed questions
* @param question the computed question to check
* @param env the QL Type environment
* @return true if no double Idenfiers
* @author Philipp
*/
public bool checkIdentifiers(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp) , QLTENV env){
	if(question.id in env.question.id) return false;
	else return true;
}