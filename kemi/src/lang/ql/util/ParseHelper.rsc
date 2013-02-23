@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::\util::\ParseHelper

import IO;
import \ParseTree;
import lang::ql::\ast::AST;
import lang::ql::\syntax::Boolean;
import lang::ql::\syntax::Comment;
import lang::ql::\syntax::Date;
import lang::ql::\syntax::Int;
import lang::ql::\syntax::Keyword;
import lang::ql::\syntax::Layout;
import lang::ql::\syntax::Money;
import lang::ql::\syntax::QL;
import lang::ql::\syntax::String;
import lang::ql::\syntax::Type;

public Form implode(Tree t) = 
  implode(#Form, t);

public start[Form] parse(str src, loc l) = 
  parse(#start[Form], src, l);

public Expr parseExpr(str src) = 
  implode(#lang::ql::\ast::AST::Expr, parse(#lang::ql::\syntax::QL::Expr, src, 
    |file:///-|));

public Question parseQuestion(str src) = 
  implode(#lang::ql::\ast::AST::Question, parse(#lang::ql::\syntax::QL::Question, 
    src, |file:///-|));
  
public Form parseForm(str src) = 
  implode(#lang::ql::\ast::AST::Form, parse(#start[Form], src, |file:///-|));
  
public Form parseForm(loc f) = 
  implode(#lang::ql::\ast::AST::Form, parse(#start[Form], f));
