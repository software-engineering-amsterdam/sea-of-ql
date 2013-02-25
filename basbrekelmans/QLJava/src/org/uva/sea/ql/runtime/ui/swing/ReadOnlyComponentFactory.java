package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;
import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;

class ReadOnlyComponentFactory implements
		IParametrizedTypeVisitor<Variable, JComponent> {

	private JComponent createBoundLabel(final Variable variable) {
		return new BoundJLabel(variable);
	}

	@Override
	public JComponent visit(final BooleanType element, final Variable variable) {
		final SwingBooleanControl component = new SwingBooleanControl(variable);
		component.setEnabled(false);
		return component.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final IntegerType element, final Variable variable) {
		final SwingNumericControl control = new SwingIntegerControl(variable);
		control.setEnabled(false);
		return control.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final MoneyType element, final Variable variable) {
		final SwingNumericControl control = new SwingMoneyControl(variable);
		control.setEnabled(false);
		return control.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final StringType element, final Variable variable) {
		return this.createBoundLabel(variable);
	}

	@Override
	public JComponent visit(final UnknownType element, final Variable variable) {
		throw new UnsupportedOperationException();
	}

}
