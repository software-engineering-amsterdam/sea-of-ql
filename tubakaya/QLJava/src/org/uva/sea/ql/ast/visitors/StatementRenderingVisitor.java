package org.uva.sea.ql.ast.visitors;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.QLValue;

public class StatementRenderingVisitor implements StatementVisitor {

	private JPanel parentPanel;
	private ExpressionTypeFindingVisitor expressionTypeCheckingVisitor;

	public StatementRenderingVisitor(JPanel parentPanel,
			Map<Identifier, Type> identifierTypeMap) {
		this.parentPanel = parentPanel;
		this.expressionTypeCheckingVisitor = new ExpressionTypeFindingVisitor(
				identifierTypeMap);
	}

	@Override
	public void visit(Form form) {
		for (Statement statement : form.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		addPanelForStatement(question.getText().value,
				question.getIdentifier(), question.getText(), true);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		addPanelForStatement(computedValue.getText().value,
				computedValue.getIdentifier(), new IntLiteral(1), false);
	}

	@Override
	public void visit(IfStatement ifStatement) {
		for (Statement statement : ifStatement.getStatements()) {
			statement.accept(this);
		}
	}

	private void addPanelForStatement(String label, Identifier identifier,
			QLValue value, boolean enabled) {
		JPanel panel = getNewPanelWithLabel(label);
		Type type = identifier.accept(expressionTypeCheckingVisitor);

		TypeRenderingVisitor typeRenderingVisitor = new TypeRenderingVisitor(
				panel, value, enabled);
		type.accept(typeRenderingVisitor);

		this.parentPanel.add(panel);
	}

	private JPanel getNewPanelWithLabel(String label) {
		JPanel panel = new JPanel(new MigLayout());
		JLabel jLabel = new JLabel(label);
		panel.add(jLabel, "w 280!, grow");
		return panel;
	}
}
