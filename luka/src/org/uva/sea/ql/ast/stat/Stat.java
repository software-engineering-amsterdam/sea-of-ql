package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.visitor.StatementVisitor;


public abstract class Stat  {
//TODO visitor for rendering, ...or what else ?!
	// wrong here ?! public abstract <T> T accept(StatementVisitor<T> visitor);
	 public abstract <T> T accept(StatementVisitor<T> visitor);
}
