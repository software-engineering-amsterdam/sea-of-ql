module tests::QuestionTests

import util::Parse;
import util::Implode;
import syntax::AbstractSyntax;
import Prelude;

private Question p(str src) = implodeQuestion(parseQuestion(src, |file:///testQuestion.q|));

// Tests for easy Questions
public test bool testQuestion1() = p("soldHouse : \"Did you sold a house?\" boolean") is easyQuestion;
public test bool testQuestion2() = p("howMuch : \"For how much you sold it?\" money") is easyQuestion;
// Tests for computed Questions
public test bool testQuestionAdd() = p("value : \"The value is : \" money(a+b)") is computedQuestion;
public test bool testQuestionSub() = p("value : \"The value is : \" money(a-b)") is computedQuestion;
public test bool testQuestionMul() = p("value : \"The value is : \" money(a*b)") is computedQuestion;
public test bool testQuestionDiv() = p("value : \"The value is : \" money(a/b)") is computedQuestion;
public test bool testQuestionInt() = p("value : \"The value is : \" money(a)") is computedQuestion;