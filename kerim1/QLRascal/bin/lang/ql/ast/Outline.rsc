module lang::ql::ast::Outline

import ParseTree;
import lang::ql::ast::AST;

public default node outline(Form form) = "form"([outline(i) | i <- form.body]);

node outline(question(q)) = outline(q);

node outline(ifThenElse(condition, thenPart, elseIfs, elsePart)) {
	list[node] nodes = [];
	
	nodes += "if"([outline(i) | i <- thenPart])[@label="If"];
	nodes += [outline(i) | i <- elseIfs];
	nodes += "else"([outline(i) | i <- elsePart])[@label="Else"];
	
	return "ifThenElse"(nodes);
}

node outline(ifThen(condition, thenPart, elseIfs)) {
	list[node] nodes = [];
	
	nodes += "if"([outline(i) | i <- thenPart])[@label="If"];
	nodes += [outline(i) | i <- elseIfs];
	
	return "ifThen"(nodes);
}

node outline(elseIf(condition, thenPart)) = "elseIf"([outline(i) | i <- thenPart])[@label="ElseIf"];

node outline(computed(identifier, label, tp, expression)) = "computed"()[@label="<identifier>"];

node outline(noncomputed(identifier, label, tp)) = "noncomputed"()[@label="<identifier>"];
