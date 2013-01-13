module lang::ql::ide::Outline

import List;
import Node;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::LocationSpan;
import lang::ql::util::Parse;
import util::IDE;

import IO;

public void main() {
	x = parse(readFile(|project://QL-R-kemi/forms/ifElseCondition.q|), |file:///-|);
	println("Parsing done: <x>");
	i = implode(x);
	println("Imploding done: <i>");
	t = outlineForm(i);
	t = outlineForm(i);
	println("Outline done: <t>");
	iprintln(t);
}

// The root note of the form
public node outlineForm(Form form) {
	return 	"outline"(outline(form))
			[@label="Form"]
			[@\loc=form@location];
}

// Helper function to create nodes with appropriate annotations and members. 
private node con(str name, str label, loc location, list[node] childs) 
	= setAnnotations(makeNode(name, childs), ("label": label, "loc": location));

// Helper to create a node for a branch of an if/ifelse/... statemnt	
private node outlineBranch(str name, str label, list[FormItem] items) {
	return 	"<name>"([outline(i) | i <- items])
			[@label="<label>"]
			[@\loc=getLocationSpan(items)];
}

// Below this are functions to rewrite the Tree to a tree of Nodes for the outliner

private node outline(Form form) {
	return 	"form"([outline(e) | e <- form.formElements])
			[@label="Form <form.formName> (<size(form.formElements)>)"]
			[@\loc=form@location];
}

private node outlineBranch(str name, str label, list[FormItem] items) {
	return 	"<name>"([outline(i) | i <- items])
			[@label="<label>"]
			[@\loc=getLocationSpan(items)];
}

private node outline(FormItem item: 
	ifCondition(Expr condition, list[FormItem] ifPart, [], [])) {
	
	str name = "ifCondition";
	str label = "If (<prettyPrint(condition)>)";
	childs = [outlineBranch("ifPart", "<prettyPrint(condition)>", ifPart)];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, [], list[FormItem] elsePart)) {
	
	str name = "ifElseCondition";
	str label = "If (<prettyPrint(condition)>) else";
	childs = [	outlineBranch("ifPart", "<prettyPrint(condition)>", ifPart),
				outlineBranch("elsePart", "else", elsePart)];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, [])) {
	
	str name = "ifElseIfCondition";
	str label = "If (<prettyPrint(condition)>) elseif...";
	childs = [outlineBranch("ifPart", "<prettyPrint(condition)>", ifPart)];
	childs += [outlineBranch("elseIf", "<prettyPrint(branch.condition)>", branch.body) | branch <- elseIfs];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, list[FormItem] elsePart)) {
	
	str name = "ifElseIfElseCondition";
	str label = "If (<prettyPrint(condition)>) elseif... else";
	childs = [outlineBranch("ifPart", "<prettyPrint(condition)>", ifPart)];
	childs += [outlineBranch("elseIf", "<prettyPrint(branch.condition)>", branch.body) | branch <- elseIfs];
	childs += outlineBranch("elsePart", "else", elsePart);
		
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: question(Question question)) = outline(question);

private node outline(Question q: 
	question(questionText, answerDataType, answerIdentifier)) {
	str name = "Question";
	str label = "Q: <answerDataType>:<questionText>";

	return con(name, label, q@location, []);	
}

private node outline(Question q: 
	question(questionText, answerDataType, answerIdentifier, calculatedField)) {
	str name = "CalculatedQuestion";
	str label = "CQ: <answerDataType>:<questionText>(<calculatedField>)";

	return con(name, label, q@location, []);	
}
