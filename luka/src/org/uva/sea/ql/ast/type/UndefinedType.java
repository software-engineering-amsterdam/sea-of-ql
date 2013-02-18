package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.UndefinedValue;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class UndefinedType extends Type {

	@Override
	public Value getNumberOfType(Number number) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public Value getDefaultValue() {
		return new UndefinedValue();
	}

	@Override
	public AbstractVisibleControl accept(TypeVisitor visitor, Ident ident) {
		return visitor.visit(this,ident);
	}
}