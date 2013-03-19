module lang::ql::Generator::htmlGenerator

import lang::ql::ast::AST;
import lang::ql::syntax::Syntax;
import lang::ql::ast::load;
import lang::ql::util::prettyPrint;

import Prelude;

public str htmlGenerator(FORM f){
	return "\<!DOCTYPE html\>
	           '\<html\>
	           '\<head\>
	           '\<title\><f.formName>\</title\>
	           '\<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.1.min.js\"\>
	           '\</script\>
	           '\</head\>
	           '\<body\>
	           '\<form\>
	           '<("" | it + statementGenerator(s) | STATEMENT s <- f.statement)>
	           '\</form\>
			   '\</body\>\n\n";
}

public str statementGenerator(statement(QUESTION question)){
	return htmlQuestionGenerator(question);
}

public str statementGenerator(STATEMENT s){
	str html = "";
	visit(s){
		case QUESTION q: {
			html += generateDiv(q.identifier);
			html += htmlQuestionGenerator(q);
			html += "\</div\>\n";
		}
	}
	return html;
}

public str generateDiv(str id){
	return "\<div id=\"<id>-div\" style=\"display: none\"\>\n";
}

public str htmlQuestionGenerator(QUESTION q){
	switch(q.qtype) {
		case boolean():	
			return htmlRadioInput(q.identifier, q.label);
		case string():	
			return htmlInput(q.identifier, q.label);
		case natural():	
			return htmlInput(q.identifier, q.label);
	}
}

public str htmlInput(str id, str label){
	return "<label>: \n\t\<div\> \<input type=\"text\" id=\"<id>\"/\>\</div\>\n";
}
public str htmlRadioInput(str id, str label){
	return "<label>: \n\t\<div\>\<input type=\"radio\" name=\"<id>\" value=\"true\"/\>True\</div\>
	\<div\>\<input type=\"radio\" name=\"<id>\" value=\"false\"/\>False\</div\>\n";
}

public void writeHTMLfile(str html){
	loc location = |file:///Users/TJ_Ammann/Development/SoftwareConstruction/sea-of-ql/TobiasAmmann/src/lang/ql/Generator/test4.html|;
	writeFile(location, html);
	}
	
	
	