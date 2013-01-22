package org.uva.sea.ql.ast.nodes;

import org.uva.sea.ql.ast.Expr;

public interface IBinaryNode {
	public Expr getLhs();
	public Expr getRhs();
}
