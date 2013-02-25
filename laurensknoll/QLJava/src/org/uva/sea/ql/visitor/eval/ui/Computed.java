package org.uva.sea.ql.visitor.eval.ui;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.eval.Environment;
import org.uva.sea.ql.visitor.eval.Expression;
import org.uva.sea.ql.visitor.eval.observer.Dependency;
import org.uva.sea.ql.visitor.eval.observer.DependencySet;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Computed extends Panel implements Observer {

	private static final long serialVersionUID = 3905995959535678149L;
	private final Ident ident;
	private final AbstractExpr expression;

	public Computed(Environment environment, Ident id, AbstractExpr expr,
			Panel panel) {
		super(environment);
		this.add(panel);

		this.ident = id;
		this.expression = expr;

		// A computed question is read-only.
		panel.setEnabled(false);

		// Observe identifiers in expression
		this.observeDependencies();
	}

	@Override
	public void update(Observable o, Object arg) {
		Environment env = this.getEnvironment();
		IExpression<AbstractValue> evaluator = new Expression(env);
		AbstractValue result = this.expression.accept(evaluator);
		env.setValue(this.ident, result);
	}

	private void observeDependencies() {
		IExpression<DependencySet> dependencyVisitor = new Dependency();
		DependencySet dependencies = this.expression.accept(dependencyVisitor);

		for (Ident ident : dependencies.getDependencies()) {
			this.getEnvironment().addObserver(ident, this);
		}
	}

}
