module lang::ql::tests::forms::Grammar

import lang::ql::ast::AST;
import lang::ql::tests::forms::ParseHelper;

public test bool testForm1() = parse("form Hello { \"Income?\" money myIncome }") is form;
public test bool testForm1() = parse("form Hello { \"Tax?\" money myTax = myIncome * 0.40 }") is form;

public test bool testBasicForm() = parse(|project://QL-R-kemi/forms/basic.q|) is form;
public test bool testCommentForm() = parse(|project://QL-R-kemi/forms/comment.q|) is form;
public test bool testMultiparseleQuestions() = parse(|project://QL-R-kemi/forms/multipleQuestions.q|) is form;
public test bool testIfCondition() = parse(|project://QL-R-kemi/forms/ifCondition.q|) is form;
public test bool testIfElseCondition() = parse(|project://QL-R-kemi/forms/ifElseCondition.q|) is form;
public test bool testIfElseIfCondition() = parse(|project://QL-R-kemi/forms/ifElseIfCondition.q|) is form;
public test bool testIfElseIfElseCondition() = parse(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|) is form;
public test bool testCalculatedField() = parse(|project://QL-R-kemi/forms/calculatedField.q|) is form;
public test bool testUglyFormattedForm() = parse(|project://QL-R-kemi/forms/uglyFormatted.q|) is form;
