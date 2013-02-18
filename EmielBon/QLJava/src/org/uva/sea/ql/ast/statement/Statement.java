package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.typechecker.StatementVisitor;

public abstract class Statement extends Node {

	public abstract <T> T accept(StatementVisitor<T> visitor);
	
}
