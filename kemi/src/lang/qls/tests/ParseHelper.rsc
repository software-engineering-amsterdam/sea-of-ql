@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::tests::ParseHelper

import IO;
import ParseTree;
import lang::qls::ast::AST;
import lang::qls::syntax::QLS;

public Stylesheet parseStylesheet(str src) = 
  implode(#lang::qls::ast::AST::Stylesheet, parse(#start[Stylesheet], src, |file:///-|));

public Stylesheet parseStylesheet(loc f) = 
  parseStylesheet(readFile(f));
