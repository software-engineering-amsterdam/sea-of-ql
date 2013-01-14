module lang::ql::tests::forms::Outline

import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::tests::forms::ParseHelper;

private node outline(loc f) = outlineForm(parse(f));

public test bool testBasicForm() = outline(|project://QL-R-kemi/forms/basic.q|) > "outline"();
public test bool testCommentForm() = outline(|project://QL-R-kemi/forms/comment.q|) > "outline"();
public test bool testMultipleQuestions() = outline(|project://QL-R-kemi/forms/multipleQuestions.q|) > "outline"();
public test bool testIfCondition() = outline(|project://QL-R-kemi/forms/ifCondition.q|) > "outline"();
public test bool testIfElseCondition() = outline(|project://QL-R-kemi/forms/ifElseCondition.q|) > "outline"();
public test bool testIfElseIfCondition() = outline(|project://QL-R-kemi/forms/ifElseIfCondition.q|) > "outline"();
public test bool testIfElseIfElseCondition() = outline(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|) > "outline"();
public test bool testNestedIfElseIfElseCondition() = outline(|project://QL-R-kemi/forms/nestedIfElseIfElseCondition.q|) > "outline"();
public test bool testCalculatedField() = outline(|project://QL-R-kemi/forms/calculatedField.q|) > "outline"();
public test bool testUglyFormattedForm() = outline(|project://QL-R-kemi/forms/uglyFormatted.q|) > "outline"();
public test bool testStyleClass() = outline(|project://QL-R-kemi/forms/styleClass.q|) > "outline"();
