module lang::ql::tests::forms::Grammar

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testForm1() = parseForm("form Hello { \"Income?\" money myIncome }") is form;
public test bool testForm1() = parseForm("form Hello { \"Tax?\" money myTax = myIncome * 0.40 }") is form;

public test bool testBasicForm() = parseForm(|project://QL-R-kemi/forms/basic.q|) is form;
public test bool testCommentForm() = parseForm(|project://QL-R-kemi/forms/comment.q|) is form;
public test bool testMultiparseleQuestions() = parseForm(|project://QL-R-kemi/forms/multipleQuestions.q|) is form;
public test bool testIfCondition() = parseForm(|project://QL-R-kemi/forms/ifCondition.q|) is form;
public test bool testIfElseCondition() = parseForm(|project://QL-R-kemi/forms/ifElseCondition.q|) is form;
public test bool testIfElseIfCondition() = parseForm(|project://QL-R-kemi/forms/ifElseIfCondition.q|) is form;
public test bool testIfElseIfElseCondition() = parseForm(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|) is form;
public test bool testNestedIfElseIfElseCondition() = parseForm(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|) is form;
public test bool testCalculatedField() = parseForm(|project://QL-R-kemi/forms/calculatedField.q|) is form;
public test bool testUglyFormattedForm() = parseForm(|project://QL-R-kemi/forms/uglyFormatted.q|) is form;
