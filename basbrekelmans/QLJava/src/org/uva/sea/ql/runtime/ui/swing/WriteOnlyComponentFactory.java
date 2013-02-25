package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;
import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;

public class WriteOnlyComponentFactory implements
		IParametrizedTypeVisitor<Variable, JComponent> {

	@Override
	public JComponent visit(final BooleanType element, final Variable variable) {
		final SwingBooleanControl result = new SwingBooleanControl(variable);
		return result.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final IntegerType element, final Variable variable) {
		return new SwingIntegerControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final MoneyType element, final Variable variable) {
		return new SwingMoneyControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final StringType element, final Variable variable) {
		return new SwingStringControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final UnknownType element, final Variable variable) {
		throw new UnsupportedOperationException();
	}

}
