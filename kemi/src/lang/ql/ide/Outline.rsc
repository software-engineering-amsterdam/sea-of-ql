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

import Exception;

public Contribution getOutliner() = outliner(node(Tree input) {
	writeFile(|tmp:///KUT/1|, input);
	// Can't implode input for some strange reason... 
	writeFile(|tmp:///KUT/2|, implode(input));
	t = outlineForm(implode(input));
	writeFile(|tmp:///KUT/3|, t);
	return t;
});

public void main() {
	x = parse(readFile(|project://QL-R-kemi/forms/ifElseCondition.q|), |file:///-|);
	println("Parsing done: <x>");
	i = implode(x);
	println("Imploding done: <i>");
	t = outlineForm(i);
	println("Outline done: <t>");
	iprintln(t);
}

public node outlineForm(Form form) = "outline"([outline(form)])[@label="Form"];

node outline(Form form) = "form"([outline(form.formElements)])[@label="Form <form.formName>"][@\loc=form@location];
 
node outline(list[FormItem] formElements) = "FormItem"([outline(e) | e <- formElements])[@label="Form Items (<size(formElements)>)"];

node outline(FormItem item) {
	switch(item) {
		case question(Question question): return outline(question);
		case ifCondition(Expr condition, list[FormItem] ifPart, [], list[FormItem] elsePart): {
			return "ifElseCondition"(
						"ifPart"([outline(e) | e <- ifPart])[@label="ifPart"][@\loc=getLocationSpan(ifPart)], 
						"elsePart"([outline(e) | e <- elsePart])[@label="elsePart"][@\loc=getLocationSpan(elsePart)]
					)[@label="If (<condition>) else"][@\loc=item@location];
		}
	}
	return "error"()[@label="ERR:<item>"];
}

node outline(Question q) {
	switch(q) {
		case question(questionText, answerDataType, answerIdentifier): {
			return "Question"()[@label="Q: <answerDataType>:<questionText>"][@\loc=q@location];		
		}
		case question(questionText, answerDataType, answerIdentifier, calculatedField): {
			return "ChoiceQuestion"()[@label="CQ: <answerDataType>:<questionText>(<calculatedField>)"][@\loc=q@location];		
		}
	}
	return "error"()[@label="ERR:<q>"];
}