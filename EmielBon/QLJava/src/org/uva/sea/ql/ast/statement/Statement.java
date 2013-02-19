package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;

public abstract class Statement extends Node {

	public abstract <T> T accept(StatementVisitor<T> visitor);
	
}
