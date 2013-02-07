@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::ParenthesizeExpressions

import Grammar; 
import Node;
import lang::ql::ast::AST;
import lang::ql::syntax::QL;
import lang::rascal::grammar::definition::Priorities;

public Expr parenExpr(p:pos(val)) = 
  pos(parenExpr(p, val));
  
public Expr parenExpr(p:neg(val)) = 
  neg(parenExpr(p, val));

public Expr parenExpr(p:not(val)) = 
  not(parenExpr(p, val));

public Expr parenExpr(p:mul(lhs, rhs)) = 
  mul(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:div(lhs, rhs)) = 
  div(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:add(lhs, rhs)) = 
  add(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:sub(lhs, rhs)) = 
  sub(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:lt(lhs, rhs)) = 
  lt(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:leq(lhs, rhs)) = 
  leq(parenExpr(p, lhs), parenExpr(p, rhs));  

public Expr parenExpr(p:gt(lhs, rhs)) = 
  gt(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:geq(lhs, rhs)) = 
  geq(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:eq(lhs, rhs)) = 
  eq(parenExpr(p, lhs), parenExpr(p, rhs));  

public Expr parenExpr(p:neq(lhs, rhs)) = 
  neq(parenExpr(p, lhs), parenExpr(p, rhs));
  
public Expr parenExpr(p:and(lhs, rhs)) = 
  and(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(p:or(lhs, rhs)) = 
  or(parenExpr(p, lhs), parenExpr(p, rhs));

public Expr parenExpr(Expr e) = e;

// Private stuff

private Expr parenExpr(Expr parent, Expr kid) =
  parens(parent, kid, parenExpr(kid), parenizer);

private Expr parenizer(Expr e) {
  return e@parentheses = true;
}

// From: Oberon0 :: TODO cleanup

//private DoNotNest getQLPrios() = doNotNest(grammar({}, #lang::ql::syntax::QL::Form.definitions));
//private DoNotNest PRIOS = getQLPrios();
private DoNotNest PRIOS = 
  doNotNest(grammar({}, #lang::ql::syntax::QL::Form.definitions));

public &T parens(node parent, node kid, &T x,  &T(&T x) parenizer) = parens(PRIOS, parent, kid, x, parenizer);

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
