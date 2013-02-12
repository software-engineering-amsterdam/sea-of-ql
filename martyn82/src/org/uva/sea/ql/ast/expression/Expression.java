package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.ExpressionVisitor;

abstract public class Expression extends Node {
	abstract public <T> T accept( ExpressionVisitor<T> visitor );
}
