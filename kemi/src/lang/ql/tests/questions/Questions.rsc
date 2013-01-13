module lang::ql::tests::questions::Questions

import lang::ql::ast::AST;
import lang::ql::tests::questions::ParseHelper;

public test bool testQuestion1() = parse("\"A question?\" boolean myFieldName") is question;
public test bool testQuestion1() = parse("\"A question 2?\" money myFieldName2 = myFieldName + 100") is question;
