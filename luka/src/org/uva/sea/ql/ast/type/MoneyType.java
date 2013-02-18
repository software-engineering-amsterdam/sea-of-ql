package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class MoneyType extends NumericType {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}

	@Override
	public String toString() {
		return "MoneyType";
	}

	@Override
	public Value getDefaultValue() {
		return new Money(0);
	}

	@Override
	public AbstractVisibleControl accept(TypeVisitor visitor, Ident ident) {
		return visitor.visit(this,ident);
	}

}
