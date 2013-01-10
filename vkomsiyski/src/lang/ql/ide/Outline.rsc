module lang::ql::ide::Outline

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import util::IDE;
import ParseTree;
import List;


public Contribution getOutliner() = outliner(node(Tree input) {
	return outlineForm(implode(input));
});


node outlineForm(Form form) = outline(form);

node outline(Form form) = "outline"([outline(form.questions)])[@label="Form"][@\loc=form@location];
 
node outline(list[Question] qs) = "questions"([outline(q) | q <- qs])[@label="Questions (<size(qs)>)"];

node outline(Question q:regular(t, n, l)) = "regular"()[@label="<n>"][@\loc=q@location];

node outline(Question q:computed(t, n, e, l)) = "computed"()[@label="<n> = "][@\loc=q@location];

node outline(Question q:conditional(c, qs)) = "conditional"([outline(qu) | qu <- qs])[@label="Conditional ()"][@\loc=q@location];


