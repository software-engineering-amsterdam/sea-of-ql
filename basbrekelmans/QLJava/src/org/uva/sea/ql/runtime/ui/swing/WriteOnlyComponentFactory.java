package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.UnknownType;
import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;

public class WriteOnlyComponentFactory implements
		IParametrizedTypeVisitor<RuntimeValue, JComponent> {

	@Override
	public JComponent visit(final BooleanType element, final RuntimeValue variable) {
		final SwingBooleanControl result = new SwingBooleanControl(variable);
		return result.getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final IntegerType element, final RuntimeValue variable) {
		return new SwingIntegerControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final MoneyType element, final RuntimeValue variable) {
		return new SwingMoneyControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final StringType element, final RuntimeValue variable) {
		return new SwingStringControl(variable).getUnderlyingComponent();
	}

	@Override
	public JComponent visit(final UnknownType element, final RuntimeValue variable) {
		throw new UnsupportedOperationException();
	}

}
