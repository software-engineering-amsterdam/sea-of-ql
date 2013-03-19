module lang::ql::Generator::jQueryGenerator

import lang::ql::ast::AST;
import lang::ql::syntax::Syntax;
import lang::ql::ast::load;
import lang::ql::util::prettyPrint;

import Prelude;

public str generateJQuery(FORM ast){
	str jQuery = 	"\<script\>
					'$(document).ready(function() {";
					
	top-down visit(ast){
		case STATEMENT s:statement(QUESTION q):{
			jQuery += generateJQueryQuestion(q);
		}
		case STATEMENT s:conditional1(IF i, list[ELSEIF] ei, ELSE e):{
			jQuery += generateJQueryConditional1(i, ei, e);
		}
		case STATEMENT s:conditional2(IF i, list[ELSEIF] ei):{
			jQuery += generateJQueryConditional2(i, ei);
		}
	}
	bottom-up visit(ast){
		case STATEMENT s:statement(QUESTION q):{
			jQuery += "}).keyup();\n";
//			if(q.qtype == boolean()) jQuery += "});\n";
//			else jQuery += "}).keyup();\n";
		}
	}
	return (jQuery + "});\</script\>");
}

public str generateJQueryConditional1(IF i, list[ELSEIF] elseIfStat, ELSE e){
	str jQuery = "if(<idGenerator(i.expression)>){\n";
	jQuery += ("" | it + jQueryStatements(s) | STATEMENT s <- i.statement);
	jQuery += jQueryPrepareHide(e.statement);
	jQuery += ("" | it + jQueryPrepareHide(ei.statement) | ELSEIF ei <- elseIfStat);
	jQuery += "}\n";
	
	for(ELSEIF ei <- elseIfStat){
		jQuery += "else if(<idGenerator(ei.expression)>){\n";
		jQuery += ("" | it + jQueryStatements(s) | STATEMENT s <- ei.statement);
		jQuery += jQueryPrepareHide(i.statement + e.statement);
		jQuery += "}\n";
	}
	
	jQuery += "else { \n";
	jQuery += ("" | it + jQueryStatements(s) | STATEMENT s <- e.statement);
	jQuery += jQueryPrepareHide(i.statement);;
	jQuery += ("" | it + jQueryPrepareHide(ei.statement) | ELSEIF ei <- elseIfStat);
	jQuery += "}\n";
	
	return jQuery;
}
public str generateJQueryConditional2(IF i, list[ELSEIF] elseIfStat){
	str jQuery = "if(<idGenerator(i.expression)>){\n";
	jQuery += ("" | it + jQueryStatements(s) | STATEMENT s <- i.statement);
	jQuery += ("" | it + jQueryPrepareHide(ei.statement) | ELSEIF ei <- elseIfStat);
	jQuery += "}\n";
	
	for(ELSEIF ei <- elseIfStat){
		jQuery += "else if(<idGenerator(elseIfStat.expression)>){\n";
		jQuery += ("" | it + jQueryStatements(s) | STATEMENT s <- elseIfStat.statement);
		jQuery += jQueryPrepareHide(i.statement);
		jQuery += "}\n";
	}
	
	return jQuery;
}

public str jQueryPrepareHide(list[STATEMENT] statement){
	return ("" | it + jQueryHide(s) | STATEMENT s <- statement);	
}

public str jQueryHide(STATEMENT s:statement(QUESTION q)){
	return jQuery = "\t $(\'#<q.identifier>-div\').hide(\"normal\");\n";
}
public str jQueryHide(STATEMENT s){
	return "";
}

public str jQueryStatements(STATEMENT s:statement(QUESTION q)){
	return jQuery = "\t $(\'#<q.identifier>-div\').show(\"normal\");\n";
}

public str jQueryStatements(STATEMENT s){
	return generateJQueryConditional(s);
}

public default str generateJQueryQuestion(QUESTION q:question(str name, _, TYPE qtype)){
	switch(qtype) {
		case boolean():	
			return "$($(\"input[name=\'<name>\']\")).click( function() {\n \t var <name> = ($(this).val() == \"true\");\n";
		case string():	
			return "$(\'#<name>\').keyup(function () {\n \t var <name> = $(this).val()\n";
		case natural():	
			return "$(\'#<name>\').keyup(function () {\n \t var <name> = $(this).val()\n";
	}
}

public str generateJQueryQuestion(QUESTION q:exprQuestion(str name, _, TYPE qtype, EXPR expr)){
	switch(qtype) {
		case boolean():	
			return "$($(\"input[name=\'<name>\']\")).change( function() {
					'	var <name> = (<idGenerator(expr)> == \"true\");
					'	$(\"input[name=\'<name>\']\")).text(<name>)\n";
		case string():	
			return "$(\'#<name>\').keyup(function () {
					'	var <name> = <idGenerator(expr)>
					'	$(\'#<name>\').val(<name>)\n";
		case natural():	
			return "$(\'#<name>\').keyup(function () {
					'	var <name> = <idGenerator(expr)>
					'	$(\'#<name>\').val(<name>)\n";
	}
}
