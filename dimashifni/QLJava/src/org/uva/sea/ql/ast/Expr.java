package org.uva.sea.ql.ast;

import org.uva.sea.ql.value.Value;
import java.util.Map;

public abstract class Expr implements ASTNode {

  public abstract Value evaluate(Map<Ident, Value> variables);
}
