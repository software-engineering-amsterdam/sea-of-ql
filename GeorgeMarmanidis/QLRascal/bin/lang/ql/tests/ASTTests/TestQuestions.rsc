module lang::ql::tests::ASTTests::TestQuestions

import lang::ql::util::Parse;
import lang::ql::util::Implode;
import lang::ql::ast::AST;

private Question p(str src) = implode(parse(src, |file:///-|));

public test bool testQuestion1() = p("kostas: \"has name?\" boolean") is simpleQuestion;
public test bool testQuestion2() = p("kostas: \"has name?\" money") is simpleQuestion;
public test bool testQuestion3() = p("kostas: \"hasname?\" boolean kostas+   b*(a+2)") is computedQuestion;