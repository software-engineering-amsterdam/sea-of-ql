module lang::ql::compiler::Simplifier

import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::util::Implode;
import lang::ql::util::Parse;

import IO;
import util::ValueUI;

private Form p(loc f) =implode(parse(readFile(f), |file:///-|));

// On second thought: this isn't needed... 

public void main() {
	f = p(|project://QL-R-kemi/forms/complexForm.q|);

	println("Begin simplifying");
	pf = simplify(f);
	println("Done simplifying");
	
	text(pf);
	writeFile(|tmp:///out|, prettyPrint(pf));
	
	f2 = p(|tmp:///out|);
}

// The root note of the form
public Form simplify(Form f) = form(f.formName, [simplify(e) | e <- f.formElements]);

public FormItem simplify(FormItem item: 
	ifCondition(Expr condition, list[FormItem] ifPart, [], [])) {
	return ifCondition(simplify(condition), [simplify(i) | i <- ifPart], [], []);
}

public FormItem simplify(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, [], list[FormItem] elsePart)) {
	return ifCondition(simplify(condition), [simplify(i) | i <- ifPart], [], [simplify(i) | i <- elsePart]);
}

private node simplify(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, [])) {
	return ifCondition(simplify(condition), [simplify(i) | i <- ifPart], [simplify(ei) | ei <- elseIfs], []);
}

public FormItem simplify(FormItem item: 
	ifCondition(Expr condition,	list[FormItem] ifPart, list[ElseIf] elseIfs, list[FormItem] elsePart)) {
	return ifCondition(simplify(condition), [simplify(i) | i <- ifPart], [simplify(ei) | ei <- elseIfs], [simplify(i) | i <- elsePart]);
}

public ElseIf simplify(ElseIf elseif) {
	return <simplify(elseif.condition), simplify(elseif.body)>;
}

public FormItem simplify(FormItem item: question(Question q)) {
	return question(simplify(q));
}

public Question simplify(Question q: 
	question(questionText, answerDataType, answerIdentifier)) {
	return question(questionText, answerDataType, answerIdentifier);
}

public Question simplify(Question q: 
	question(questionText, answerDataType, answerIdentifier, calculatedField)) {
	return question(questionText, answerDataType, answerIdentifier, calculatedField);
}

// Start the actual simplifying of expressions:

public Expr simplify(Expr e) {
	println("EXR: <e>");
	return e;
}