@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::util::ParenthesizeExpressions

import Grammar; 
import Node;
import lang::ql::\ast::AST;
import lang::ql::\syntax::QL;
import lang::rascal::grammar::definition::Priorities;
import util::Priorities;

/*
 * Each expression that needs parentheses around it will receive an annotation.
 * This way, the PrettyPrinter knows when to print parentheses. 
 */

private Expr parenizer(Expr e) =
  setAnnotations(e, ("parentheses" : true));

private Expr parenizeExpr(Expr parent, Expr kid) =
  parens(parent, kid, parenizeExpr(kid), parenizer);

private DoNotNest PRIOS = 
  doNotNest(grammar({}, #lang::ql::\syntax::QL::Form.definitions));

private &T parens(node parent, node kid, &T x,  &T(&T x) parenizer) = 
  parens(PRIOS, parent, kid, x, parenizer);
  
public Expr parenizeExpr(p:pos(val)) = 
  pos(parenizeExpr(p, val));
  
public Expr parenizeExpr(p:neg(val)) = 
  neg(parenizeExpr(p, val));

public Expr parenizeExpr(p:not(val)) = 
  not(parenizeExpr(p, val));

public Expr parenizeExpr(p:mul(lhs, rhs)) = 
  mul(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:div(lhs, rhs)) = 
  div(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:add(lhs, rhs)) = 
  add(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:sub(lhs, rhs)) = 
  sub(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:lt(lhs, rhs)) = 
  lt(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:leq(lhs, rhs)) = 
  leq(parenizeExpr(p, lhs), parenizeExpr(p, rhs));  

public Expr parenizeExpr(p:gt(lhs, rhs)) = 
  gt(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:geq(lhs, rhs)) = 
  geq(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:eq(lhs, rhs)) = 
  eq(parenizeExpr(p, lhs), parenizeExpr(p, rhs));  

public Expr parenizeExpr(p:neq(lhs, rhs)) = 
  neq(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(p:and(lhs, rhs)) = 
  and(parenizeExpr(p, lhs), parenizeExpr(p, rhs));

public Expr parenizeExpr(Expr e) = e;
