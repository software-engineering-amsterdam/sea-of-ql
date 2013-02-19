package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Nature;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class BooleanType extends DataType {

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Bools();
	}

}
