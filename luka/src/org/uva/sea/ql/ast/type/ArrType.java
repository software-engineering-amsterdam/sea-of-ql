package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class ArrType extends Type {
	private final Type type;

	public ArrType(Type type) {
		this.type = type;
	}

	@Override
	public Value getValueForString(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value getNumberOfType(Number number) {
		return this.type.getNumberOfType(number);
	}

	@Override
	public AbstractVisibleControl accept(TypeVisitor visitor, Ident ident) {
		return null;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return this.type.isCompatibleTo(t);
	}

	@Override
	public boolean isCompatibleToInt() {
		return this.type.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return this.type.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToStr() {
		return this.type.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToBool() {
		return this.type.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToMoney() {
		return this.type.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToDoule() {
		return this.type.isCompatibleToDoule();
	}

}
