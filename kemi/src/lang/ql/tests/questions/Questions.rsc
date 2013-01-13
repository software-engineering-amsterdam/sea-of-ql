module lang::ql::tests::questions::Questions

import ParseTree;

import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::ql::util::Parse;

private start[Question] parse(str src, loc l) = parse(#start[Question], src, l);

private Question implode(Tree t) = implode(#Question, t);
private Question p(str src) = implode(parse(src, |file:///-|));

public test bool testQuestion1() = p("\"A question?\" boolean myFieldName") is question;
public test bool testQuestion1() = p("\"A question 2?\" money myFieldName2 = myFieldName + 100") is question;
