package org.uva.sea.ql.visitor.eval;

import java.awt.GridLayout;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.IType;
import org.uva.sea.ql.visitor.eval.observer.Computed;
import org.uva.sea.ql.visitor.eval.observer.Conditional;
import org.uva.sea.ql.visitor.eval.observer.Dependency;
import org.uva.sea.ql.visitor.eval.observer.DependencySet;
import org.uva.sea.ql.visitor.eval.ui.Panel;
import org.uva.sea.ql.visitor.eval.ui.QuestionPanel;
import org.uva.sea.ql.visitor.eval.ui.Widget;

public class Statement implements IStatement<Panel> {

	private final Environment environment;

	public Statement(Environment context) {
		this.environment = context;
	}

	@Override
	public Panel visit(Block block) {
		Panel panel = new Panel(new GridLayout(0, 1), this.environment);

		Environment innerEnvironment = this.environment.getChildEnvironment();
		IStatement<Panel> statementVisitor = new Statement(innerEnvironment);
		for (AbstractStatement statement : block.getStatements()) {
			Panel inner = statement.accept(statementVisitor);
			panel.add(inner);
		}

		return panel;
	}

	@Override
	public Panel visit(ComputedQuestion computedQuestion) {
		Question question = computedQuestion.getQuestion();
		Panel panel = question.accept(this);

		// The question is computed. Therefore make it read only.
		panel.setEnabled(false);

		// Observe dependent questions
		AbstractExpr computation = computedQuestion.getComputation();
		Ident ident = question.getIdent();
		Computed observer = new Computed(computation, ident, this.environment);
		this.observeDependencies(computation, observer);

		return panel;
	}

	@Override
	public Panel visit(If ifStatement) {
		Environment innerEnvironment = this.environment.getChildEnvironment();
		IStatement<Panel> statementVisitor = new Statement(innerEnvironment);

		AbstractStatement trueStatement = ifStatement.getTruePath();
		Panel truePanel = trueStatement.accept(statementVisitor);

		// Observe condition
		AbstractExpr condition = ifStatement.getCondition();
		Conditional observer = new Conditional(condition, this.environment,
				truePanel);
		this.observeDependencies(condition, observer);

		return truePanel;
	}

	@Override
	public Panel visit(Question question) {
		String questionLabel = question.getQuestion();

		AbstractType type = question.getType();
		IType<Widget> typeVisitor = new Type();
		Widget widget = type.accept(typeVisitor);

		Panel panel = new QuestionPanel(new GridLayout(0, 2), this.environment,
				questionLabel.getValue(), widget);

		Ident id = question.getIdent();
		this.environment.declare(id, widget);

		return panel;
	}

	private void observeDependencies(AbstractExpr expr, Observer observer) {
		IExpression<DependencySet> dependencyVisitor = new Dependency();
		DependencySet dependencies = expr.accept(dependencyVisitor);

		for (Ident ident : dependencies.getDependencies()) {
			this.environment.addObserver(ident, observer);
		}
	}

}
