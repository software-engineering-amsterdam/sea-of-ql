package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;

public abstract class Expr implements ASTNode {

  public abstract Value evaluate();
}
