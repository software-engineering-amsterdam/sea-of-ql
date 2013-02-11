package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.StatementVisitor;

abstract public class Statement extends Node {
	abstract public <T> T accept( StatementVisitor<T> visitor );
}
