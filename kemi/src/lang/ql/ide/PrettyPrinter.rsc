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
