/**
 * This module contains code revelant to the IDE Javafile generator option
 * contains functions in order to match the current QL syntax and generate a java syntax  
 * @author  Gerson Delgado
 * @version 1.0, 18/02/2013
 */
module lang::ql::ide::JavaGenerator::Generator

import lang::ql::ast::AST;
import lang::ql::ide::JavaGenerator::Environment;

/**
* Hulp list to construct java layout files
*/
list[str] jLayout = [
"/**
* Generated Java class
* @author:
* @version:
* @since version:
*/\n\n",
"/**
* Generated Java code
* This is the imports section
* Here imports should be defined
*/\n\n",
"/**
* Generated Java code
* This is the global variables section
* Here globals variables should be defined
*/\n\n",
"/**
* Generated Java code
* This is the Java constructor section
* Here constructor(s) should be defined
*/\n\n",
"/**
* Generated Java code
* Generated Java Methods section
* Here constructor(s) should be defined
*/\n\n",
"\n}"
];

/**
* Generator function that will construct a coherent Java class from a Form
*/ 
public list[str] genJavaFile(form(str id, list[Element] fElems)){
	JENV tempJava = <[]>;
	str jClass = getJavaClass(id);
	str jMethod = getJavaMethod(id);
	str jCons = getJavaConstructor(id); 
	output = getJavaFile(fElems, tempJava);
 	return 	jLayout[1]
 			+ jLayout[0]
 			+ jClass 
 			+ jLayout[2] 
 			+ jLayout[3] 
 		    + jCons 
 		    + jLayout[4]
 			+ jMethod 
 			+ output.javaStr 
 			+ jLayout[5]
 			+ jLayout[5];
} 

 
private JENV getJavaFile(list[Element] fElems, JENV jStr){
	top-down visit(fElems){
		case qstn:computableQuestion(_,_,_,_) 
			: jStr = getJavaFile(qstn, jStr);
		case qstn:singleQuestion(_,_,_) 
			: jStr = getJavaFile(qstn, jStr);
		case cond:singleIfCondition(_,_) 
			: jStr = getJavaFile(cond, jStr);
		case cond:ifElseCondition(_,_,_) 
			: jStr = getJavaFile(cond, jStr);
	}
	return jStr;	
} 


private str getStrDataType(DataType dt){
	str output = "";
	top-down visit (dt){
		case integer() 
			: output = "int";
		case boolean()
			: output = "string";
		case string()
			: output = "boolean";
		case money()
			: output = "money";
		case date()
			: output = "date";
		case decimal()
			: output = "decimal";
	}
	return output;	
}

 
private str getStrIdent(Expr expr){
	str output = "";
	top-down visit (expr){
		case ident(str name)
			: output = "<name>";
		case \int(int iValue)
			: output = "<iValue>";
		case money(real mnValue)
			: output = "<mnValue>";
		case strCon(str strValue)
			: output = "<strValue>";
		case decimal(real decValue)
			: output = "<decValue>";																				
	}
	return output;	
}
	
private str getStrExpr(Expr expr){
	str output = "";
	top-down visit (expr){
		case eq(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> == <getStrIdent(rhs)>)";
		case neq(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> != <getStrIdent(rhs)>)";
		case geq(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> \>= <getStrIdent(rhs)>)";
		case gt(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> \> <getStrIdent(rhs)>)";	
		case leq(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> \<= <getStrIdent(rhs)>)";
		case lt(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> \< <getStrIdent(rhs)>)";	
		case sub(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> - <getStrIdent(rhs)>)";
		case add(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> + <getStrIdent(rhs)>)";
		case div(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> / <getStrIdent(rhs)>)";
		case mul(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> * <getStrIdent(rhs)>)";
		case and(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> && <getStrIdent(rhs)>)";	
		case or(lhs, rhs) 
			: output = "(<getStrIdent(lhs)> || <getStrIdent(rhs)>)";
		case not(val) 
			: output = "!(<getStrIdent(val)>)";	
		case neg(val) 
			: output = "(-<getStrIdent(val)>)";
		case pos(val) 
			: output = "(+<getStrIdent(val)>)";																		
	}
	return output;	
}
	   
private JENV getJavaFile(question(Question qstn), JENV jStr) 
	= getJavaFile(qstn, jStr, inCond);
	
private JENV getJavaFile(singleQuestion(str qstnIdent, str qstnLabel, DataType qstnDataType), JENV jStr)
	= addJVar(jStr, qstnIdent, qstnLabel, getStrDataType(qstnDataType));
	

private JENV getJavaFile(computableQuestion(str cqstnIdent, str cqstnLabel, DataType cqstnDataType, Expr cqstnExpr), JENV jStr)
 	= addJVar(jStr, cqstnIdent, cqstnLabel, getStrDataType(cqstnDataType));

private JENV getJavaFile(condition(Condition cond), JENV jStr, bool inCond)
	= getJavaFile(cond, jStr, inCond);
	 	
private JENV getJavaFile(singleIfCondition(Expr ifEval, list[Element] ifQstns), JENV jStr) {
	jStr0 = addJCond(jStr, "if", getStrExpr(ifEval));
	return jStr0;
}

private JENV getJavaFile(ifElseCondition(Expr ifEval, list[Element] ifQstns, list[Element] elseQstns), JENV jStr) {
	jStr0 = addJCond(jStr, "if", getStrExpr(ifEval));
	jStr1 = getJavaFile(elseQstns, jStr0);
	jStr2 = addStr(jStr1, "else\n");
	return jStr2;
}

private str getJavaClass(str classId){
	
	return "public class <classId>{\n\n"; 	
}

private str getJavaMethod(str methodId){
	
	return "public void gen<methodId>(void){\n"; 	
}

private str getJavaConstructor(str consId){
	
	return "public <consId>(){\n}\n\n"; 	
}

