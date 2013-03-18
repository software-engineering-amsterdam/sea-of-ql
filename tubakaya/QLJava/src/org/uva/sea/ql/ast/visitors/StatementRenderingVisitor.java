package org.uva.sea.ql.ast.visitors;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.ast.statements.ComputedValue;
import org.uva.sea.ql.ast.statements.Form;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gui.FormPanel;

public class StatementRenderingVisitor implements StatementVisitor {

	private FormPanel formPanel;
	private ArrayList<JPanel> renderList;
	private ExpressionTypeFindingVisitor expressionTypeFindingVisitor;
	private Map<Identifier, QLValue> identifierValueMap;

	public StatementRenderingVisitor(FormPanel formPanel,
			Map<Identifier, Type> identifierTypeMap,
			Map<Identifier, QLValue> identifierValueMap) {
		this.formPanel = formPanel;
		this.renderList = new ArrayList<JPanel>();
		this.expressionTypeFindingVisitor = new ExpressionTypeFindingVisitor(
				identifierTypeMap);
		this.identifierValueMap = identifierValueMap;
	}

	public ArrayList<JPanel> getRenderList() {
		return this.renderList;
	}
	
	@Override
	public void visit(Form form) {
		for (Statement statement : form.getStatements()) {
			statement.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		QLValue exprValue = this.evaluateExpression(question.getIdentifier());
		addPanelForStatement(question.getText().value,
				question.getIdentifier(), exprValue, true);
	}

	@Override
	public void visit(ComputedValue computedValue) {
		QLValue exprValue = this.evaluateExpression(computedValue
				.getExpression());
		addPanelForStatement(computedValue.getText().value,
				computedValue.getIdentifier(), exprValue, false);
	}

	@Override
	public void visit(IfStatement ifStatement) {

		QLValue value = this.evaluateExpression(ifStatement.getExpression());
		Boolean isExprTrue = value.getBooleanValue();
		if (isExprTrue) {
			for (Statement statement : ifStatement.getStatements()) {
				statement.accept(this);
			}
		}
	}

	private void addPanelForStatement(String label, Identifier identifier,
			QLValue value, boolean enabled) {
		JPanel panel = getNewPanelWithLabel(label);
		Type type = identifier.accept(expressionTypeFindingVisitor);

		TypeRenderingVisitor typeRenderingVisitor = new TypeRenderingVisitor(
				formPanel, identifierValueMap, identifier, value, enabled);
		panel.add(type.accept(typeRenderingVisitor),"wrap");

		this.renderList.add(panel);
	}

	private JPanel getNewPanelWithLabel(String label) {
		JPanel panel = new JPanel(new MigLayout());
		JLabel jLabel = new JLabel(label);
		panel.add(jLabel, "w 400!, grow");
		return panel;
	}

	private QLValue evaluateExpression(Expression expression) {
		ExpressionEvaluatingVisitor exprEvaluator = new ExpressionEvaluatingVisitor(
				identifierValueMap);
		return expression.accept(exprEvaluator);
	}
}
