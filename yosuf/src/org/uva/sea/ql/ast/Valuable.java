package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ValuableVisitor;

public interface Valuable {

	<T> T accept(ValuableVisitor<T> visitor);
}
