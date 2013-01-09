module lang::ql::tests::TestRunner

import lang::ql::tests::expressions::Addition;
import lang::ql::tests::expressions::And;
import lang::ql::tests::expressions::Boolean;
import lang::ql::tests::expressions::Date;
import lang::ql::tests::expressions::Division;
import lang::ql::tests::expressions::Equality;
import lang::ql::tests::expressions::GreaterThen;
import lang::ql::tests::expressions::GreaterThenOrEqual;
import lang::ql::tests::expressions::Ident;
import lang::ql::tests::expressions::InEquality;
import lang::ql::tests::expressions::Int;
import lang::ql::tests::expressions::LessThen;
import lang::ql::tests::expressions::LessThenOrEqual;
import lang::ql::tests::expressions::Money;
import lang::ql::tests::expressions::Multiplication;
import lang::ql::tests::expressions::Negation;
import lang::ql::tests::expressions::Negative;
import lang::ql::tests::expressions::Or;
import lang::ql::tests::expressions::Positive;
import lang::ql::tests::expressions::String;
import lang::ql::tests::expressions::Subtraction;

import lang::ql::tests::questions::Questions;

import lang::ql::tests::forms::Forms;

import IO;

public void main() {
	println("1) Load this module to import all modules that contain tests");
	println("2) When every module is loaded, all unit tests can be run with a simple :test");
	println("3) Wait for the tests to finish, and be done with it");
}