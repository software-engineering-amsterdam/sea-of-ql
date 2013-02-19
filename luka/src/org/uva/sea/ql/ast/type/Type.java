package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public abstract class Type {

	@Override
	public String toString() {
		return "abstract Type";
	}

	public abstract Value getNumberOfType(Number number);

	public abstract Value getValueForString(String s);

	public abstract AbstractVisibleControl accept(TypeVisitor visitor,
			Ident ident);

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToInt() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStr() {
		return false;
	}

	public boolean isCompatibleToBool() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}

	public boolean isCompatibleToDoule() {
		return false;
	}

}
