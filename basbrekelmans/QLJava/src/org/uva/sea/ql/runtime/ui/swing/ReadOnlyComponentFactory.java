package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;
import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;

class ReadOnlyComponentFactory implements
		IParametrizedTypeVisitor<RuntimeValue, JComponent> {

	private JComponent createBoundLabel(final RuntimeValue variable) {
		return new BoundJLabel(variable);
	}

	@Override
	public JComponent visit(final BooleanType element, final RuntimeValue variable) {
		final SwingBooleanControl component = new SwingBooleanControl(variable);
		component.setEnabled(false);
		return component.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final IntegerType element, final RuntimeValue variable) {
		final SwingNumericControl control = new SwingIntegerControl(variable);
		control.setEnabled(false);
		return control.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final MoneyType element, final RuntimeValue variable) {
		final SwingNumericControl control = new SwingMoneyControl(variable);
		control.setEnabled(false);
		return control.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final StringType element, final RuntimeValue variable) {
		return this.createBoundLabel(variable);
	}

	@Override
	public JComponent visit(final UnknownType element, final RuntimeValue variable) {
		throw new UnsupportedOperationException();
	}

}
