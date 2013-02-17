package org.uva.sea.ql.visitor.eval.observer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.Expression;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Computed implements Observer {

	private final AbstractExpr compute;
	private final Ident ident;
	private final Environment environment;

	public Computed(AbstractExpr computeExpression, Ident ident,
			Environment context) {
		this.compute = computeExpression;
		this.ident = ident;
		this.environment = context;
	}

	@Override
	public void update(Observable o, Object arg) {
		// Evaluate expression again
		// TODO: Reuse existing code?
		Expression exprVisitor = new org.uva.sea.ql.visitor.eval.Expression(
				this.environment);
		AbstractValue result = this.compute.accept(exprVisitor);
		this.environment.setValue(this.ident, result);
	}

}
