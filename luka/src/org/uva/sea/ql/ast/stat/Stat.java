package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.visitor.StatementVisitor;


public abstract class Stat  {

	 public abstract void accept(StatementVisitor visitor);
}
