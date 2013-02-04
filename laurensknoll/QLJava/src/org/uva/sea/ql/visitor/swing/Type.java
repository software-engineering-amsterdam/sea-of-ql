package org.uva.sea.ql.visitor.swing;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Money;
import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.String;
import org.uva.sea.ql.visitor.IType;

public class Type implements IType<Component> {

	@Override
	public Component visit(Bool bool) {
		return new JCheckBox();
	}

	@Override
	public Component visit(Int intType) {
		return new JTextField(10);
	}

	@Override
	public Component visit(Money money) {
		return new JTextField(10);
	}

	@Override
	public Component visit(String string) {
		return new JTextField(30);
	}

	@Override
	public Component visit(org.uva.sea.ql.ast.type.Form form) {
		// TODO: Remove this visitor method.
		return null;
	}

	@Override
	public Component visit(Numeric numeric) {
		return new JTextField(10);
	}

}
