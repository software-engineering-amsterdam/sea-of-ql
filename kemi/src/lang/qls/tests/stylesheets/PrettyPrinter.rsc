@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::PrettyPrinter

import lang::qls::ast::AST;
import lang::qls::compiler::PrettyPrinter;
import lang::qls::tests::ParseHelper;

private bool prettyPrintAndCompare(loc f) = 
  parseStylesheet(f) == parseStylesheet(prettyPrint(parseStylesheet(f)));

private bool prettyPrintAndCompare(str s) = 
  parseStylesheet(s) == parseStylesheet(prettyPrint(parseStylesheet(s)));

public test bool testProposedSyntax() = 
  prettyPrintAndCompare(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|);
