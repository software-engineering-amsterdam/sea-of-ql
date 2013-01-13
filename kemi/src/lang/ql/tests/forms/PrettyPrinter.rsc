module lang::ql::tests::forms::PrettyPrinter

import lang::ql::ast::AST;
import lang::ql::compiler::PrettyPrinter;
import lang::ql::tests::forms::ParseHelper;

private bool prettyPrintAndCompare(loc f) = parse(f) == parse(prettyPrint(parse(f)));

public test bool testBasicForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/basic.q|);
public test bool testCommentForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/comment.q|);
public test bool testMultipleQuestions() = prettyPrintAndCompare(|project://QL-R-kemi/forms/multipleQuestions.q|);
public test bool testIfCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifCondition.q|);
public test bool testIfElseCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseCondition.q|);
public test bool testIfElseIfCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfCondition.q|);
public test bool testIfElseIfElseCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|);
public test bool testNestedIfElseIfElseCondition() = prettyPrintAndCompare(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|);
public test bool testCalculatedField() = prettyPrintAndCompare(|project://QL-R-kemi/forms/calculatedField.q|);
public test bool testUglyFormattedForm() = prettyPrintAndCompare(|project://QL-R-kemi/forms/uglyFormatted.q|);
