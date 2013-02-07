package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.exp.Expression.Nature;
import org.uva.sea.ql.visitor.NaturalVisitor;

/**
 * Describes the specefic nature of the node.
 * 
 */
public interface Natural {

	Nature getNature();

	<T> T accept(NaturalVisitor<T> visitor);
}
