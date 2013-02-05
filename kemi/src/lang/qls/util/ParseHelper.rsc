@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::qls::util::ParseHelper

import ParseTree;

import lang::ql::syntax::Comment;
import lang::ql::syntax::Int;
import lang::ql::syntax::Layout;
import lang::ql::syntax::String;
import lang::ql::syntax::Type;
import lang::qls::ast::AST;
import lang::qls::syntax::Keyword;
import lang::qls::syntax::QLS;

public start[Stylesheet] parse(str src, loc l) = 
  parse(#start[Stylesheet], src, l);

public Stylesheet implode(Tree t) =
  implode(#lang::qls::ast::AST::Stylesheet, t);

public Stylesheet parseStylesheet(str src) =
  implode(parse(#start[Stylesheet], src, |file:///-|));

public Stylesheet parseStylesheet(loc f) =
  implode(parse(#start[Stylesheet], f));
