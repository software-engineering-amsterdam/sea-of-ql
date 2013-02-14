package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;

public class StringType extends Type {

	// Double dispatch
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public Value getDefaultValue() {
		return new Str("");
	}
	
	@Override
	public void accept(TypeVisitor visitor) {
		visitor.visit(this);
	}
}
