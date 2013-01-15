module lang::ql::tests::ASTTests::TestQuestions

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Question p(str src) = implode(parse(src, |file:///-|));

public test bool testQuestion1() = p("kostas: \"has name?\" boolean") is simpleQuestion;
public test bool testQuestion2() = p("\"has name?\"") is testQ;