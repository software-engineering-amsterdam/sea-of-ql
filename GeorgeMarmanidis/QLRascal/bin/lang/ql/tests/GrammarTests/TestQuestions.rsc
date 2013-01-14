module lang::ql::tests::GrammarTests::TestQuestions

import lang::ql::syntax::QL;
import ParseTree;

//public start[Expr] parse(str src, loc l) = parse(#start[Expr], src, l);

public start[Question] parseQuestion(str src) = parse(#start[Question], src, |file:///-|);

public test bool testQuestion1() = parseQuestion("hasAge: \"Age?\" boolean") is simpleQuestion;
public test bool testQuestion2() = parseQuestion("hasAge: \"Age?\" boolean (a+b)") is computedQuestion;