module lang::ql::tests::TestRunner

extend lang::ql::tests::expressions::Addition;
extend lang::ql::tests::expressions::And;
extend lang::ql::tests::expressions::Boolean;
extend lang::ql::tests::expressions::Date;
extend lang::ql::tests::expressions::Division;
extend lang::ql::tests::expressions::Equality;
extend lang::ql::tests::expressions::GreaterThen;
extend lang::ql::tests::expressions::GreaterThenOrEqual;
extend lang::ql::tests::expressions::Ident;
extend lang::ql::tests::expressions::InEquality;
extend lang::ql::tests::expressions::Int;
extend lang::ql::tests::expressions::LessThen;
extend lang::ql::tests::expressions::LessThenOrEqual;
extend lang::ql::tests::expressions::Money;
extend lang::ql::tests::expressions::Multiplication;
extend lang::ql::tests::expressions::Negation;
extend lang::ql::tests::expressions::Negative;
extend lang::ql::tests::expressions::Or;
extend lang::ql::tests::expressions::Positive;
extend lang::ql::tests::expressions::String;
extend lang::ql::tests::expressions::Subtraction;

extend lang::ql::tests::questions::Questions;
extend lang::ql::tests::questions::CalculatedQuestions;

extend lang::ql::tests::forms::Grammar;
extend lang::ql::tests::forms::Outline;
extend lang::ql::tests::forms::PrettyPrinter;

import IO;

public void main() {
  println("1) Load this module to extend all modules that contain tests");
  println("2) When every module is loaded, all unit tests can be run with a simple :test");
  println("3) Wait for the tests to finish, and be done with it");
}
