package org.uva.sea.ql.visitor.eval;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IStatement;
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
		JPanel panel = new JPanel();

		Question question = computedQuestion.getQuestion();
		JPanel questionPanel = question.accept(this);
		panel.add(questionPanel);

		// Get Widget of an ident; Set value.
		/*
		 * TODO: How to evaluate expression and show initial value in question
		 * Expression expressionVisitor = new Expression(this.environment);
		 * AbstractValue value = computedQuestion.getComputeExpression().accept(
		 * expressionVisitor);
		 */
		return panel;
	}

	@Override
	public JPanel visit(If ifStatement) {
		JPanel panel = new JPanel();

		/*
		 * TODO: Add enable condition to panel. Expression expressionVisitor =
		 * new Expression(this.environment); Boolean isConditionValid =
		 * ifStatement.getCondition().accept(expressionVisitor);
		 */
		JPanel truePanel = ifStatement.getTruePath().accept(this);
		panel.add(truePanel);

		return panel;
	}

	@Override
	public JPanel visit(Question question) {
		JPanel panel = new JPanel(new GridLayout(1, 2));

		Ident id = question.getIdent();
		this.environment.declare(id, null);

		/*
		 * TODO: Create visitor that creates labels. Expression
		 * expressionVisitor = new Expression(this.environment);
		 */
		JLabel description = new JLabel(question.getQuestion().getValue());
		panel.add(description);

		AbstractType type = question.getType();
		Type typeVisitor = new Type();
		Widget inputField = type.accept(typeVisitor);
		panel.add(inputField.getComponent());

		return panel;
	}

}
