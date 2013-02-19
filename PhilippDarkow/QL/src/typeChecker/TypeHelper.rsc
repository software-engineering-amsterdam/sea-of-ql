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
	str s = "";
	if(arity(exp) > 1){	
		list [value id] k = getChildren(exp);	
		list[Type] t = getExpressionType(exp, env);
		s = toString(t[0]);
		return t[0];
	}else s = toString(getChildren(exp)[0]);
	for(b <- env.question){		//matching
		if(b.id == s) return b.tp;
	}
}

/** Method to get a list of question Types
* @param exp the Expression
* @param env the QL type environment
* @return types a List of types
* @author Philipp
*/
public list[Type] getExpressionType(Expression exp, QLTENV env){
	list[Type] types = [];
	for(s <- getChildren(exp)){
		Type tp = findExpressionType(s, env);
		//if(tp notin types) types += tp;
		types += tp;
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