package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.*;

/**
 * Interface: Visitor
 * @author Danny
 *
 */
public interface Visitor {
	public void visit(Expr expr);
}
