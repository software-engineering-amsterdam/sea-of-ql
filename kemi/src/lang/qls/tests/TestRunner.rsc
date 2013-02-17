@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::TestRunner

extend lang::qls::tests::stylesheets::Grammar;
extend lang::qls::tests::stylesheets::Outline;
extend lang::qls::tests::stylesheets::PrettyPrinter;
extend lang::qls::tests::stylesheets::SemanticChecker;

import IO;

public void main() {
  println("1) Load this module to extend all modules that contain tests");
  println("2) When every module is loaded, all unit tests can be run with a simple :test");
  println("3) Wait for the tests to finish, and be done with it");
}
