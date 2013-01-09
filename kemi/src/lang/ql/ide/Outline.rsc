module lang::ql::ide::Outline

import List;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::util::Parse;
import util::IDE;

import IO;

public Contribution getOutliner() = outliner(node(Tree input) {
	writeFile(|tmp:///KUT/1|, input);
	writeFile(|tmp:///KUT/2|, implode(input));
	t = outlineForm(implode(input));
	writeFile(|tmp:///KUT/3|, t);
	return t;
});

public void main() {
	x = parse(readFile(|tmp:///KUT/1|), |file:///-|);
	println("Parsing done: <x>");
	i = implode(x);
	println("Imploding done: <i>");
	t = outlineForm(i);
	println("Outline done: <t>");
}

public node outlineForm(Form form) = "outline"([outline(form)])[@label="Form"];

//node outline(Form form) = "outline"([outline(form.formElements)])[@label="Form <form.formName>"][@\loc=form@location];
node outline(Form form) = "form"([outline(form[1])])[@label="Form <form[0]>"][@\loc=form@location];
 
node outline(list[FormItem] formElements) = "FormItems"()[@label="Questions (<formElements>)"];
