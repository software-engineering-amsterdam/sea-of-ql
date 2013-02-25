package org.uva.sea.ql.visitor.eval;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.IType;
import org.uva.sea.ql.visitor.eval.ui.Computed;
import org.uva.sea.ql.visitor.eval.ui.Conditional;
import org.uva.sea.ql.visitor.eval.ui.Panel;
import org.uva.sea.ql.visitor.eval.ui.Widget;

public class Statement implements IStatement<Panel> {

	private final Environment environment;

	public Statement(Environment context) {
		this.environment = context;
	}

	@Override
	public Panel visit(Block block) {
		Panel panel = new Panel(this.environment);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Environment innerEnvironment = this.environment.getChildEnvironment();
		IStatement<Panel> statementVisitor = new Statement(innerEnvironment);
		for (AbstractStatement statement : block.getStatements()) {
			Panel inner = statement.accept(statementVisitor);
			panel.add(inner);
		}

		return panel;
	}

	@Override
	public Panel visit(ComputedQuestion computed) {
		Question question = computed.getQuestion();
		Panel questionPanel = question.accept(this);

		AbstractExpr computation = computed.getComputation();
		Ident ident = question.getIdent();
		Panel panel = new Computed(this.environment, ident, computation,
				questionPanel);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		return panel;
	}

	@Override
	public Panel visit(If ifStatement) {
		Environment innerEnvironment = this.environment.getChildEnvironment();
		IStatement<Panel> statementVisitor = new Statement(innerEnvironment);

		AbstractStatement trueStatement = ifStatement.getTruePath();
		Panel truePanel = trueStatement.accept(statementVisitor);

		AbstractExpr condition = ifStatement.getCondition();
		Panel panel = new Conditional(this.environment, condition, truePanel);

		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		return panel;
	}

	@Override
	public Panel visit(Question question) {
		String questionLabel = question.getQuestion();

		AbstractType type = question.getType();
		IType<Widget> typeVisitor = new Type();
		Widget widget = type.accept(typeVisitor);

		Panel panel = new org.uva.sea.ql.visitor.eval.ui.Question(
				this.environment, questionLabel.getValue(), widget);
		panel.setLayout(new GridLayout(1, 2));

		Ident id = question.getIdent();
		this.environment.declare(id, widget);

		return panel;
	}

}
