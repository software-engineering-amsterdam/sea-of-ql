package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.StatementVisitor;

public abstract class Statement extends Node {

	public abstract <T> T accept(StatementVisitor<T> visitor);
	
}
