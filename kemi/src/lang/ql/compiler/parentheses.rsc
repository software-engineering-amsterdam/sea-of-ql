@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::parentheses

import Grammar; 
import lang::ql::syntax::QL;
import lang::ql::ast::AST;
import lang::rascal::grammar::definition::Priorities;

import Set;
import util::ValueUI;
import IO;
import lang::ql::tests::ParseHelper;
import Node;

//public alias DoNotNest = rel[Production father, int position, Production child];

anno bool Expr @ paren;


public void main() {
  //r = doNotNest(grammar({}, #lang::ql::syntax::QL::Form.definitions));
  
  // (5 + 2) * 3
  Expr e = mul( add(\int(5), \int(2)),\int(3));
  
  //x = {x | x <- r, <prod(label("mul", _), _, _), _, prod(label("add", _), _, _)> := x};
  //text(x);
  
  iprintln(exp2box(e));  
}

/* SIMPLIFICATION REWRITE RULES */

public Expr exp2box(p:mul(lhs, rhs)) = mul(exp2box(p, lhs), exp2box(p, rhs));
public Expr exp2box(p:add(lhs, rhs)) = add(exp2box(p, lhs), exp2box(p, rhs));
public Expr exp2box(Expr e) = e;

public Expr exp2box(Expr parent, Expr kid) =
  parens(parent, kid, exp2box(kid), parenizer);

private Expr parenizer(Expr e) {
  return e@paren = true;
}

/* END */

/* Setup for grammar */

public DoNotNest getQLPrios() = doNotNest(grammar({}, #lang::ql::syntax::QL::Form.definitions));

private DoNotNest PRIOS = getQLPrios();

public &T parens(node parent, node kid, &T x,  &T(&T x) parenizer) = parens(PRIOS, parent, kid, x, parenizer);
//public &T parens(node parent, node kid, &T x,  &T(&T x) parenizer) = parens(PRIOS, parent, kid, x, parenizer);

/* Generic library stuff */

//public &T parens(DoNotNest prios, node parent, node kid, &T x,  &T(&T x) parenizer) = parenizer(x)
public &T parens(DoNotNest prios, node parent, node kid, &T x,  &T(&T x) parenizer) = parenizer(x)
  when 
     <pprod, pos, kprod> <- prios,
     pprod.def has name,
     kprod.def has name, 
     pprod.def.name == getName(parent), 
     kprod.def.name == getName(kid),
     parent[astPosition(pos, pprod)] == kid;

private int astPosition(int pos, Production p)
  = ( -1 | it + 1 | i <- [0,1..pos], isASTsymbol(p.symbols[i]) );

public bool isASTsymbol(\layouts(_)) = false; 
public bool isASTsymbol(\keywords(str name)) = false;
public bool isASTsymbol(\lit(str string)) = false;
public bool isASTsymbol(\cilit(str string)) = false;
// This does not work, but is also not in doNotNest result...  
// public bool isASTsymbol(\conditional(_, _)) = false;
public bool isASTsymbol(\empty()) = false;
public default bool isASTsymbol(Symbol _) = true;

public default &T parens(DoNotNest prios, node parent, node kid, &T x,  &T(&T x) parenizer) = x;

