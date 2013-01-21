module lang::ql::tests::questions::CalculatedQuestions

import lang::ql::ast::AST;
import lang::ql::tests::ParseHelper;
import lang::ql::util::FormGenerator;
import lang::ql::util::Random;

public test bool testCalculatedQuestion1() = 
  parseQuestion("\"A calculated question?\" money myFieldName2 = myFieldName + 100") is question;

public test bool testRandomCalculatedQuestion() = 
  parseQuestion(randomCalculatedQuestion()) is question;
