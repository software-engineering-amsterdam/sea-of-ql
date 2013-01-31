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

public void main() {
  r = doNotNest(grammar({}, #lang::ql::syntax::QL::Form.definitions));
  
  // (5 + 2) * 3
  Expr e = mul( add(\int(5), \int(2)),\int(3));
  
  x = {x | x <- r, <prod(label("mul", _), _, _), _, prod(label("add", _), _, _)> := x};
  text(x);
}
