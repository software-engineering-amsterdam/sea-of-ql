package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.Control;

public class IntType extends NumericType {

	// Double dispatch
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
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
