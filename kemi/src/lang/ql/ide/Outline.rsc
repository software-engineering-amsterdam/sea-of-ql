module lang::ql::ide::Outline

import List;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::util::LocationSpan;
import util::IDE;

import IO;

public void main() {
	x = parse(readFile(|project://QL-R-kemi/forms/ifElseCondition.q|), |file:///-|);
	println("Parsing done: <x>");
	i = implode(x);
	println("Imploding done: <i>");
	t = outlineForm(i);
	println("Outline done: <t>");
	iprintln(t);
}

public node outlineForm(Form form) {
	return 	"outline"(outline(form))
			[@label="Form"];
}

private node outline(Form form) {
	return 	"form"([outline(e) | e <- form.formElements])
			[@label="Form <form.formName> (<size(form.formElements)>)"]
			[@\loc=form@location];
}

private node outline(FormItem item) {
	switch(item) {
		case question(Question question): return outline(question);
		
		case ifCondition(Expr condition, list[FormItem] ifPart, [], []): {
			return 	"ifCondition"(
						"ifPart"([outline(e) | e <- ifPart])
						[@label="ifPart"]
						[@\loc=getLocationSpan(ifPart)]) 
					[@label="If (<condition>) else"]
					[@\loc=item@location];
		}
		
		case ifCondition(Expr condition, list[FormItem] ifPart, [], list[FormItem] elsePart): {
			return "ifElseCondition"(
						"ifPart"([outline(e) | e <- ifPart])
						[@label="ifPart"]
						[@\loc=getLocationSpan(ifPart)], 
						"elsePart"([outline(e) | e <- elsePart])
						[@label="elsePart"]
						[@\loc=getLocationSpan(elsePart)])
					[@label="If (<condition>) else"]
					[@\loc=item@location];
		}
	}
	return "error"()[@label="ERR:<item>"];
}

private node outline(Question q) {
	switch(q) {
		case question(questionText, answerDataType, answerIdentifier): {
			return 	"Question"()
					[@label="Q: <answerDataType>:<questionText>"]
					[@\loc=q@location];		
		}
		case question(questionText, answerDataType, answerIdentifier, calculatedField): {
			return 	"ChoiceQuestion"()
					[@label="CQ: <answerDataType>:<questionText>(<calculatedField>)"]
					[@\loc=q@location];		
		}
	}
	return "error"()[@label="ERR:<q>"];
}