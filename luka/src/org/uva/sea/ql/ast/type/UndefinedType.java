package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.UndefinedValue;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.Control;

public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public Value getDefaultValue() {
		return new UndefinedValue();
	}

	@Override
	public Control accept(TypeVisitor visitor) {
		return visitor.visit(this);
	}
}