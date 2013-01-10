module lang::ql::ide::Outline

import List;
import Node;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;
import lang::ql::util::LocationSpan;
import util::IDE;

import IO;

public void main() {
	x = parse(readFile(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|), |file:///-|);
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

private node outlineBranch(str name, str label, list[FormItem] items) {
	return 	"<name>"([outline(i) | i <- items])
			[@label="<label>"]
			[@\loc=getLocationSpan(items)];
}

private node outline(FormItem item) {
	str name = "ERROR";
	str label = "ERROR";
	clist = [];
	
	switch(item) {
		case question(Question question): return outline(question);
		
		case ifCondition(Expr condition, list[FormItem] ifPart, [], []): {
			name = "ifCondition";
			label = "If (<condition>)";
			clist += [outlineBranch("ifPart", "ifPart", ifPart)];
		}
		
		case ifCondition(Expr condition, list[FormItem] ifPart, [], list[FormItem] elsePart): {
			name = "ifElseCondition";
			label = "If (<condition>) else";
			clist += [	outlineBranch("ifPart", "ifPart", ifPart),
						outlineBranch("elsePart", "elsePart", elsePart)];
		}
		
		case ifCondition(Expr condition, list[FormItem] ifPart,  list[ElseIf] elseIfs, []): {
			name = "ifElseIfCondition";
			label = "if (<condition>) elseif...";
			clist += [outlineBranch("ifPart", "ifPart", ifPart)];
			clist += [outlineBranch("elseIf", "<branch.condition>", branch.body) | branch <- elseIfs];
		}
		
		case ifCondition(Expr condition, list[FormItem] ifPart,  list[ElseIf] elseIfs, list[FormItem] elsePart): {
			name = "ifElseIfElseCondition";
			label = "if (<condition>) elseif... else";
			clist += [outlineBranch("ifPart", "ifPart", ifPart)];
			clist += [outlineBranch("elseIf", "<branch.condition>", branch.body) | branch <- elseIfs];
			clist += outlineBranch("elsePart", "elsePart", elsePart);
		}
	}
	return setAnnotations(makeNode(name, clist), ("label": label, "loc": item@location));
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