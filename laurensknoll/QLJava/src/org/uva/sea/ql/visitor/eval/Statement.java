package org.uva.sea.ql.visitor.eval;

import java.awt.GridLayout;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
import org.uva.sea.ql.visitor.eval.ui.Widget;

public class Statement implements IStatement<JPanel> {

	private final Environment environment;

	public Statement(Environment context) {
		this.environment = context;
	}

	@Override
	public JPanel visit(Block block) {
		JPanel panel = new JPanel(new GridLayout(0, 1));

		Environment innerEnvironment = this.environment.getChildEnvironment();
		IStatement<JPanel> statementVisitor = new Statement(innerEnvironment);
		for (AbstractStatement statement : block.getStatements()) {
			JPanel inner = statement.accept(statementVisitor);
			panel.add(inner);
		}

		return panel;
	}

	@Override
	public JPanel visit(ComputedQuestion computedQuestion) {
		Question question = computedQuestion.getQuestion();
		JPanel panel = question.accept(this);

		// The question is computed. Therefore make it read only.
		Ident ident = question.getIdent();
		this.environment.setReadOnly(ident, true);

		// Observe dependent questions
		AbstractExpr computation = computedQuestion.getComputation();
		Computed observer = new Computed(computation, ident, this.environment);
		this.observeDependencies(computation, observer);

		return panel;
	}

	@Override
	public JPanel visit(If ifStatement) {
		AbstractStatement trueStatement = ifStatement.getTruePath();
		JPanel truePanel = trueStatement.accept(this);

		// Observe condition
		AbstractExpr condition = ifStatement.getCondition();
		Conditional observer = new Conditional(condition, truePanel,
				this.environment);
		this.observeDependencies(condition, observer);

		return truePanel;
	}

	@Override
	public JPanel visit(Question question) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		String questionLabel = question.getQuestion();
		JLabel label = new JLabel(questionLabel.getValue());
		panel.add(label);

		AbstractType type = question.getType();
		IType<Widget> typeVisitor = new Type();
		Widget widget = type.accept(typeVisitor);
		panel.add(widget.getComponent());

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
