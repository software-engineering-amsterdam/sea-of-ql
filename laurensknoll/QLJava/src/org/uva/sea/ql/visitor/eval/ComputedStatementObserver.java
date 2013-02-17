package org.uva.sea.ql.visitor.eval;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class ComputedStatementObserver implements Observer {

	private final AbstractExpr compute;
	private final Widget widget;
	private final Environment environment;

	public ComputedStatementObserver(AbstractExpr computeExpression,
			Widget widget, Environment context) {
		this.compute = computeExpression;
		this.widget = widget;
		this.environment = context;
	}

	@Override
	public void update(Observable o, Object arg) {
		// Evaluate expression again
		// TODO: Reuse existing code?
		Expression exprVisitor = new org.uva.sea.ql.visitor.eval.Expression(
				this.environment);
		AbstractValue result = this.compute.accept(exprVisitor);
		this.widget.setValue(result);
	}

}
