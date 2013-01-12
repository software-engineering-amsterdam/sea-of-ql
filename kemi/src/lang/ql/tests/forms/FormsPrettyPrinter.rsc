module lang::ql::tests::forms::FormsPrettyPrinter

import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;

import IO;

private Form p(str src) = implode(parse(src, |file:///-|));
private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

private bool prettyPrintAndCompare(loc f) {
	fp = p(f);
	pp = prettyPrint(fp);
	return p(pp) == fp;
}

public test bool testBasicForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/basic.q|);
public test bool testCommentForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/comment.q|);
public test bool testMultipleQuestions() = prettyPrintAndCompare(|project://QL-R-kemi/forms/multipleQuestions.q|);
public test bool testIfCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifCondition.q|);
public test bool testIfElseCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseCondition.q|);
public test bool testIfElseIfCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfCondition.q|);
public test bool testIfElseIfElseCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|);
public test bool testCalculatedField() = prettyPrintAndCompare(|project://QL-R-kemi/forms/calculatedField.q|);
public test bool testUglyFormattedForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/uglyFormatted.q|);
