package org.uva.sea.ql.ast.type;

import java.text.DecimalFormat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class MoneyType extends NumericType {

	@Override
	public Value getNumberOfType(Number number) {
		DecimalFormat f = new DecimalFormat("#.##");
		return new Money(Double.valueOf(f.format(number)));
	}

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
