package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.visitor.TypeVisitor;
import org.uva.sea.ql.questionnaire.ui.swing.control.visible.AbstractVisibleControl;

public class StringType extends Type {

	@Override
	public Value getNumberOfType(Number number) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "StringType";
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public AbstractVisibleControl accept(TypeVisitor visitor, Ident ident) {
		return visitor.visit(this, ident);
	}
	
	@Override
	public Value getValueForString(String s) {
		return new Str(s);
	}
}
