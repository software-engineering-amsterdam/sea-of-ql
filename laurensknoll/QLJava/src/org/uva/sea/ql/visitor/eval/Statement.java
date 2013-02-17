package org.uva.sea.ql.visitor.eval;

import java.awt.GridLayout;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.eval.observer.Computed;
import org.uva.sea.ql.visitor.eval.observer.Conditional;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Statement implements IStatement<JPanel> {

	private final Environment environment;

	public Statement(Environment context) {
		this.environment = context;
	}

	@Override
	public JPanel visit(Block block) {
		JPanel panel = new JPanel(new GridLayout(0, 1));

		Environment newBlockContext = new Environment(this.environment);
		Statement statementVisitor = new Statement(newBlockContext);
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
		this.environment.setReadOnly(question.getIdent(), true);

		// Observe dependent questions
		AbstractExpr computeExpression = computedQuestion
				.getComputeExpression();

		Observer observer = new Computed(computeExpression,
				question.getIdent(), this.environment);

		Dependency dependencyVisitor = new Dependency();
		DependencySet dependencies = computeExpression
				.accept(dependencyVisitor);

		for (Ident ident : dependencies.getDependencies()) {
			this.environment.addObserver(ident, observer);
		}

		// Set the value.
		Expression expressionVisitor = new Expression(this.environment);
		AbstractValue value = computeExpression.accept(expressionVisitor);
		this.environment.setValue(question.getIdent(), value);

		return panel;
	}

	@Override
	public JPanel visit(If ifStatement) {
		JPanel conditionalPanel = ifStatement.getTruePath().accept(this);

		AbstractExpr condition = ifStatement.getCondition();

		// Observe condition
		Conditional observer = new Conditional(condition, conditionalPanel,
				this.environment);

		Dependency dependencyVisitor = new Dependency();
		DependencySet dependencies = condition.accept(dependencyVisitor);

		for (Ident ident : dependencies.getDependencies()) {
			this.environment.addObserver(ident, observer);
		}

		// Set initial value.
		observer.update();

		return conditionalPanel;
	}

	@Override
	public JPanel visit(Question question) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JLabel description = new JLabel(question.getQuestion().getValue());
		panel.add(description);

		AbstractType type = question.getType();
		Type typeVisitor = new Type();
		Widget inputField = type.accept(typeVisitor);
		panel.add(inputField.getComponent());

		Ident id = question.getIdent();
		this.environment.declare(id, inputField);

		return panel;
	}

}
