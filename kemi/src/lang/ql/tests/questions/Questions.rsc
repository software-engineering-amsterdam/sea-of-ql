module lang::ql::tests::questions::Questions

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::Random;

public test bool testQuestion1() = parseQuestion("\"A question?\" boolean myFieldName") is question;

public test bool testRandomQuestion() = parseQuestion(randomQuestion()) is question;
