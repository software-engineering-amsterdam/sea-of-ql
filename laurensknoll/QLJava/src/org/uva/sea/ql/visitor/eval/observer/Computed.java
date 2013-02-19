package org.uva.sea.ql.visitor.eval.observer;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.Expression;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Computed implements Observer {

	private final AbstractExpr computation;
	private final Ident ident;
	private final Environment environment;

	public Computed(AbstractExpr computation, Ident ident,
			Environment environment) {
		this.computation = computation;
		this.ident = ident;
		this.environment = environment;
	}

	public void update() {
		Expression evaluator = new Expression(this.environment);
		AbstractValue result = this.computation.accept(evaluator);
		this.environment.setValue(this.ident, result);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.update();
	}

}
