module lang::ql::tests::questions::Questions

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;

public test bool testQuestion1() = parseQuestion("\"A question?\" boolean myFieldName") is question;
public test bool testQuestion1() = parseQuestion("\"A question 2?\" money myFieldName2 = myFieldName + 100") is question;
