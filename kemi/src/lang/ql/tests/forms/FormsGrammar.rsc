module lang::ql::tests::forms::FormsGrammar

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import IO;
import Exception;

private Form p(str src) = implode(parse(src, |file:///-|));
private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public test bool testForm1() = p("form Hello { \"Income?\", money, myIncome }") is form;

public test bool testBasicForm() = p(|project://QL-R-kemi/forms/basic.q|) is form;
public test bool testCommentForm() = p(|project://QL-R-kemi/forms/comment.q|) is form;
public test bool testMultipleQuestions() = p(|project://QL-R-kemi/forms/multipleQuestions.q|) is form;
public test bool testIfCondition() = p(|project://QL-R-kemi/forms/ifCondition.q|) is form;
public test bool testIfElseCondition() = p(|project://QL-R-kemi/forms/ifElseCondition.q|) is form;
public test bool testIfElseIfCondition() = p(|project://QL-R-kemi/forms/ifElseIfCondition.q|) is form;
public test bool testIfElseIfElseCondition() = p(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|) is form;
public test bool testCalculatedField() = p(|project://QL-R-kemi/forms/calculatedField.q|) is form;

public void main() {
	try x = p(|project://QL-R-kemi/forms/basic.q|);
	catch IllegalArgument( y, z ): println("Error: <z> (@<y>)");
	println("Correct: \n<x>");
}