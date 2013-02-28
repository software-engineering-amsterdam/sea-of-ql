package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.exp.Nature;
import org.uva.sea.ql.visitor.NaturalVisitor;

/**
 * Describes the specefic nature of an expression or data type.
 * 
 */
public interface Natural {

	Nature getNature();

	<T> T accept(NaturalVisitor<T> visitor);
}
