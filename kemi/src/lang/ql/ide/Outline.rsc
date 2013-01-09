module lang::ql::ide::Outline

import List;
import ParseTree;
import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::util::Parse;
import util::IDE;

public node outlineForm(Form form) = outline(form);

public Contribution getOutliner() = outliner(node(Tree input) {
	return outlineForm(implode(input));
});

private node outline(Form form) = "outline"([outline(form.formElements)])[@label="Form"][@\loc=form@location];

private node outline(list[FormItem] items) = "questions"([outline(i) | i <- items])[@label="Questions (<size(items)>)"];

private node outline(FormItem question:question(q)) = "regular"()[@label="<q[0]>"][@\loc=q@location];
private node outline(FormItem cond:ifCondition(a, b, c, d)) = "regular"()[@label="MyLabelCond"][@\loc=cond@location];
