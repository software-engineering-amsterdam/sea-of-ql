@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

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
extend lang::ql::tests::forms::SemanticChecker;

import IO;

public void main() {
  println("1) Load this module to extend all modules that contain tests");
  println("2) When every module is loaded, all unit tests can be run with a simple :test");
  println("3) Wait for the tests to finish, and be done with it");
}
