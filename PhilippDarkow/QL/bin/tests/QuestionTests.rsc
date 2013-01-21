module tests::QuestionTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Question p(str src) = implodeQuestion(parseQuestion(src, |file:///testQuestion.q|));

// Tests for Questions
//public test bool testQuestion1() = p("soldHouse : \"Did you sold a house?\" boolean") is easyQuestion;
//public test bool testQuestion2() = parseQuestion("hasAge : \"Age?\" boolean (a+b)") is computedQuestion;

