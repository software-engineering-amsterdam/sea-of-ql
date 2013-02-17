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
		Ident ident = question.getIdent();
		this.environment.setReadOnly(ident, true);

		// Observe dependent questions
		AbstractExpr computeExpression = computedQuestion
				.getComputeExpression();
		Computed observer = new Computed(computeExpression, ident,
				this.environment);
		this.observeDependencies(computeExpression, observer);

		// Set initial value.
		observer.update();

		return panel;
	}

	@Override
	public JPanel visit(If ifStatement) {
		JPanel conditionalPanel = ifStatement.getTruePath().accept(this);

		// Observe condition
		AbstractExpr condition = ifStatement.getCondition();
		Conditional observer = new Conditional(condition, conditionalPanel,
				this.environment);
		this.observeDependencies(condition, observer);

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

	private void observeDependencies(AbstractExpr expr, Observer observer) {
		Dependency dependencyVisitor = new Dependency();
		DependencySet dependencies = expr.accept(dependencyVisitor);

		for (Ident ident : dependencies.getDependencies()) {
			this.environment.addObserver(ident, observer);
		}
	}

}
