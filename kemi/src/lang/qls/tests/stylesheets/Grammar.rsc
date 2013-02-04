@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::Grammar

import lang::qls::ast::AST;
import lang::qls::tests::ParseHelper;


public test bool testStyles1() = parseStylesheet("stylesheet S1 { page \"P1\" { section \"Sec1\" { }  question Q1 { } default string { width 200 } } }") is stylesheet;

public test bool testStyles2() = parseStylesheet("stylesheet S1 { section \"Sec1\" { section \"Sec2\" { question Q1 { } } default money { type radio } } }") is stylesheet;

public test bool testStyles3() = parseStylesheet("stylesheet S1 { question Q1 { type checkbox } }") is stylesheet;

public test bool testStyles4() = parseStylesheet("stylesheet S1 { default boolean { width 10 } }") is stylesheet;

public test bool testStyles5() =
  parseStylesheet(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|) is stylesheet;
