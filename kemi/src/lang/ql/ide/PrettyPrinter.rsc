module lang::ql::ide::PrettyPrinter

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import IO;
import util::ValueUI;

private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public void main() {
	f = p(|project://QL-R-kemi/forms/uglyFormatted.q|);
	println("Form: <f>");
	pf = prettyPrint(f);
	println("Pretty: ");
	iprintln(pf);
	writeFile(|tmp:///out|, pf);
}

// The root note of the form
public str prettyPrint(Form form) {
	return 
    "form <form.formName> { <for (e <- form.formElements) {>
    '	<prettyPrint(e)><}>
    '}
    '";
}

public str prettyPrint(FormItem item: question(Question question)) = prettyPrint(question);

public str prettyPrint(Question q: 
	question(questionText, answerDataType, answerIdentifier)) {
	return
	"<questionText>, <answerDataType>, <answerIdentifier>";
}

public str prettyPrint(Question q: 
	question(questionText, answerDataType, answerIdentifier, calculatedField)) {
	return
	"<questionText>, <answerDataType>, <answerIdentifier>: <prettyPrint(calculatedField)>";
}

public str prettyPrint(FormItem item: 
	ifCondition(Expr condition, list[FormItem] ifPart, [], [])) {
	return 
    "if ( <prettyPrint(condition)> ) { <for (e <- ifPart) {>
    '	<prettyPrint(e)><}>
    '}";
}

public str prettyPrint(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, [], list[FormItem] elsePart)) {
	return 
    "if ( <prettyPrint(condition)> ) { <for (e <- ifPart) {>
    '	<prettyPrint(e)><}>
    '} else { <for (e <- elsePart) {>
    '	<prettyPrint(e)><}>
    '}";
}

public str prettyPrint(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, [])) {
	return
    "if ( <prettyPrint(condition)> ) { <for (e <- ifPart) {>
    '	<prettyPrint(e)><}> <for (ec <- elseIfs) {>
    '} else if ( <prettyPrint(ec.condition)> ) { <for (eb <- ec.body) {>
    '	<prettyPrint(eb)><}><}>
    '}";
}

public str prettyPrint(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, list[FormItem] elsePart)) {
	return 
    "if ( <prettyPrint(condition)> ) { <for (e <- ifPart) {>
    '	<prettyPrint(e)><}> <for (ec <- elseIfs) {>
    '} else if ( <prettyPrint(ec.condition)> ) { <for (eb <- ec.body) {>
    '	<prettyPrint(eb)><}><}>
    '} else { <for (e <- elsePart) {>
    '	<prettyPrint(e)><}>
    '}";
}

public str prettyPrint(Expr e) {
	return "EXPR";
}























// Helper to create a node for a branch of an if/ifelse/... statemnt	
private node outlineBranch(str name, str label, list[FormItem] items) {
	return 	"<name>"([outline(i) | i <- items])
			[@label="<label>"]
			[@\loc=getLocationSpan(items)];
}

// Below this are functions to rewrite the Tree to a tree of Nodes for the outliner


private node outlineBranch(str name, str label, list[FormItem] items) {
	return 	"<name>"([outline(i) | i <- items])
			[@label="<label>"]
			[@\loc=getLocationSpan(items)];
}

private node outline(FormItem item: 
	ifCondition(Expr condition, list[FormItem] ifPart, [], [])) {
	
	str name = "ifCondition";
	str label = "If (<condition>)";
	childs = [outlineBranch("ifPart", "ifPart", ifPart)];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, [], list[FormItem] elsePart)) {
	
	str name = "ifElseCondition";
	str label = "If (<condition>) else";
	childs = [	outlineBranch("ifPart", "ifPart", ifPart),
				outlineBranch("elsePart", "elsePart", elsePart)];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, [])) {
	
	str name = "ifElseIfCondition";
	str label = "If (<condition>) elseif...";
	childs = [outlineBranch("ifPart", "ifPart", ifPart)];
	childs += [outlineBranch("elseIf", "<branch.condition>", branch.body) | branch <- elseIfs];
	
	return con(name, label, item@location, childs);
}

private node outline(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, list[FormItem] elsePart)) {
	
	str name = "ifElseIfElseCondition";
	str label = "If (<condition>) elseif... else";
	childs = [outlineBranch("ifPart", "ifPart", ifPart)];
	childs += [outlineBranch("elseIf", "<branch.condition>", branch.body) | branch <- elseIfs];
	childs += outlineBranch("elsePart", "elsePart", elsePart);
		
	return con(name, label, item@location, childs);
}

