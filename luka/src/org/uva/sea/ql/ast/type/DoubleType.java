package org.uva.sea.ql.ast.type;

import java.text.DecimalFormat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Doub;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class DoubleType extends NumericType {

	@Override
	public Value getNumberOfType(Number number) {
		DecimalFormat f = new DecimalFormat("#.#####");
		return new Doub(Double.valueOf(f.format(number)));
	}

	// Double dispatch
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToDoule();
	}

	@Override
	public AbstractVisibleControl accept(TypeVisitor visitor, Ident ident) {
		return visitor.visit(this, ident);
	}

	@Override
	public String toString() {
		return "DoubleType";
	}
	@Override
	public Value getValueForString(String s) {
		return new Doub(Double.valueOf(s));
	}
}
