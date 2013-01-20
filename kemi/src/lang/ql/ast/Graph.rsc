module lang::ql::ast::Graph

import lang::ql::ast::AST;

data GraphNode                                                                
  = root(Form form, loc location)
  | statement(Statement stmt, loc location)
  | conditional(Conditional cond, loc location)
  | question(Question q, loc location)
  | expr(Expr expr, loc location)
  ;

public alias CG = tuple[GraphNode parent, GraphNode child];
