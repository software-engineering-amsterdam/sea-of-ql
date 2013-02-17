package org.uva.sea.ql.visitors;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.controls.KeyAdapterIntOnly;
import org.uva.sea.ql.visitors.controls.KeyAdapterMoneyOnly;
import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public class TypeToWidget implements ITypeVisitor<JComponent> {

	private final Value val;

	private TypeToWidget(Value val) {
		this.val = val;
	}

	public static JComponent CreateWidget(Type type, Value val, boolean enabled) {
		TypeToWidget typewidget = new TypeToWidget(val);
		JComponent component = type.accept(typewidget);
		component.setEnabled(enabled);
		return component;
	}

	@Override
	public JComponent visit(BoolType node) {
		JCheckBox input = new JCheckBox();
		input.setSelected(((BoolLiteral) val).getValue());
		return input;
	}

	@Override
	public JComponent visit(IntType node) {
		JTextField input = new JTextField(5);
		input.addKeyListener(new KeyAdapterIntOnly());
		input.setText(String.valueOf(((IntLiteral) val).getValue()));
		return input;
	}

	@Override
	public JComponent visit(MoneyType node) {
		JTextField input = new JTextField(5);
		input.addKeyListener(new KeyAdapterMoneyOnly());
		input.setText(String.valueOf(((MoneyLiteral) val).getValue()));
		return input;
	}

	@Override
	public JComponent visit(StringType node) {
		JTextField input = new JTextField(5);
		input.setText(((StringLiteral) val).getValue());
		return input;
	}

}
