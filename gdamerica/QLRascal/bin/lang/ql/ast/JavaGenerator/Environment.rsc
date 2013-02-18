/**
 * This module contains code revelant to the IDE Javafile generator option  
 * @author  Gerson Delgado
 * @version 1.0, 18/02/2013
 */
 
module lang::ql::ast::JavaGenerator::Environment

import lang::ql::ast::AST;



alias JENV = tuple[ 
	list[str] javaStr
	];

public JENV addJVar(JENV jStr, str id, str qstnLabel, str qstnDataType) 
	= jStr[javaStr = jStr.javaStr + getJavaVar(id, qstnLabel, qstnDataType)];
	
public JENV addJCond(JENV jStr, str id, str expr) 
	= jStr[javaStr = jStr.javaStr + getJavaCond(id, expr)];
	
public JENV addStr(JENV jStr, str label) 
	= jStr[javaStr = jStr.javaStr + label];	
	
private str getJavaVar(str id , str varValue, str varDataType){
	
	return "<varDataType> <id> = <varValue>;\n"; 	
}

private str getJavaCond(str id, str expr){

	return "<id> <expr>\n"; 	
}