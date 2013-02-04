@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::stylesheets::Outline

import lang::qls::ast::AST;
import lang::qls::ide::Outline;
import lang::qls::tests::ParseHelper;
import IO;

private node outline(loc f) = 
  outlineStylesheet(parseStylesheet(f));

private node outline(str s) =
  outlineStylesheet(parseStylesheet(s));

public test bool testOutline1() =
  outline(|project://QL-R-kemi/stylesheets/proposedSyntax.qs|) > "outline"();

public test bool testStyles1() = outline("class A { #el1 #el2 }") > "outline"();
public test bool testStyles2() = outline("boolean { type radio }") > "outline"();
public test bool testStyles3() = outline(".A { type checkbox }") > "outline"();
public test bool testStyles4() = outline("#B { width 100 }") > "outline"();
  