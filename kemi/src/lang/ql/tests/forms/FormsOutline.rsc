module lang::ql::tests::forms::FormsOutline

import lang::ql::ast::AST;
import lang::ql::ide::Outline;
import lang::ql::util::Implode;
import lang::ql::util::Parse;

import IO;
import Exception;

private Form p(str src) = implode(parse(src, |file:///-|));
private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

private node ol(loc f) = outlineForm(p(f));

public test bool testBasicForm() = ol(|project://QL-R-kemi/forms/basic.q|) > "outline"();
public test bool testCommentForm() = ol(|project://QL-R-kemi/forms/comment.q|) > "outline"();
public test bool testMultipleQuestions() = ol(|project://QL-R-kemi/forms/multipleQuestions.q|) > "outline"();
public test bool testIfCondition() = ol(|project://QL-R-kemi/forms/ifCondition.q|) > "outline"();
public test bool testIfElseCondition() = ol(|project://QL-R-kemi/forms/ifElseCondition.q|) > "outline"();
public test bool testIfElseIfCondition() = ol(|project://QL-R-kemi/forms/ifElseIfCondition.q|) > "outline"();
public test bool testIfElseIfElseCondition() = ol(|project://QL-R-kemi/forms/ifElseIfElseCondition.q|) > "outline"();
public test bool testCalculatedField() = ol(|project://QL-R-kemi/forms/calculatedField.q|) > "outline"();
