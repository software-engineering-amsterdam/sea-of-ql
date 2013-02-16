module lang::ql::compiler::GenerateJavaScript

import ParseTree;
import lang::ql::ast::AST;

import IO;

public str generateJavaScipt(list[FormBodyItem] bodyItems){
	str code="";
	
	code+=generateCondQuestionStat(bodyItems);
	
	return code;
}

str generateCondQuestionStat(list[FormBodyItem] bodyItems){
	str code="";
	visit(bodyItems){
		case computedQuestion(_, str questionLabel,_,_) : print("<questionLabel>\n");
	}
	
	return code;
}