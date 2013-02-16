package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.control.Control;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}

	@Override
	public boolean isCompatibleToDoule() {
		return true;
	}

	@Override
	public Value getDefaultValue() {
		return new Int(0);
	}

	@Override
	public Control accept(TypeVisitor visitor) {
		return visitor.visit(this);
	}

}
