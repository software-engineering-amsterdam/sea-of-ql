module lang::ql::ast::Outline

import ParseTree;
import lang::ql::ast::AST;
import lang::ql::generator::Pretty;

public default node outline(Form form) = 
	"form"([outline(i) | i <- form.body]);

node outline(question(q)) = outline(q);

node outline(Statement s:ifThenElse(condition, thenPart, elseIfs, elsePart)) {
	list[node] nodes = [];
	
	nodes += "if"([outline(i) | i <- thenPart])[@label="if <pretty(condition)>"];
	nodes += [outline(i) | i <- elseIfs];
	nodes += "else"([outline(i) | i <- elsePart])[@label="else"];
	
	return "ifElse"(nodes)[@label="if else"][@\loc=s@location];
}

node outline(Statement s:ifThen(condition, thenPart, elseIfs)) {
	list[node] nodes = [];
	
	nodes += "if"([outline(i) | i <- thenPart])[@label="if <pretty(condition)>"];
	nodes += [outline(i) | i <- elseIfs];
	
	return "if"(nodes)[@\loc=s@location];
}

node outline(ElseIf s:elseIf(condition, thenPart)) = 
	"elseIf"([outline(i) | i <- thenPart])[@label="else if <pretty(condition)>"];

node outline(Question q:computed(identifier, label, tp, expression)) = 
	"computed"()[@label="<identifier> <pretty(tp)> <pretty(expression)>"][@\loc=q@location];

node outline(Question q:noncomputed(identifier, label, tp)) = "noncomputed"()[@label="<identifier> <pretty(tp)>"][@\loc=q@location];
