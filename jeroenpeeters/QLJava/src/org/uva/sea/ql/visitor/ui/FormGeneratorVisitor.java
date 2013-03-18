package org.uva.sea.ql.visitor.ui;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Label;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.valuesystem.BooleanValue;
import org.uva.sea.ql.valuesystem.MoneyValue;
import org.uva.sea.ql.valuesystem.Value;
import org.uva.sea.ql.visitor.ui.widgets.Widget;
import org.uva.sea.ql.visitor.ui.widgets.DefaultWidgetFactoryFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactoryFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetObserver;

import com.google.common.collect.Maps;

public class FormGeneratorVisitor implements StatementVisitor<JComponent>, WidgetObserver{
	
	private final ExpressionVisitor<Value> expressionVisitor;
	
	private final Map<Widget, Identifier> widgetIdentMap = Maps.newHashMap();
	
	private final Map<Identifier, Value> symbolMap;
	
	private final Map<IfStatement, JComponent> ifStatementPanelMap = Maps.newHashMap();
	
	private final Map<IfElseStatement, JComponent> ifElseStatementPanelMap = Maps.newHashMap();
	
	private final Map<Label, JLabel> labelMap = Maps.newHashMap();
	
	public FormGeneratorVisitor(final ExpressionVisitor<Value> expressionVisitor, final Map<Identifier, Value> symbolMap){
		this.expressionVisitor = expressionVisitor;
		this.symbolMap = symbolMap;
	}
	
	@Override
	public JPanel visit(Form form) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createTitledBorder(form.getIdentity().getName()));
		
		final JComponent compoundPanel = form.getCompoundStatement().accept(this);
		panel.add(compoundPanel);
		
		return panel;
	}

	@Override
	public JPanel visit(CompoundStatement statement) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		
		final Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			final JComponent statementPanel = statementIterator.next().accept(this);
			panel.add(statementPanel);
		}
		
		return panel;
	}
	
	@Override
	public JComponent visit(IfStatement statement) {
		final JComponent panel = statement.getStatement().accept(this);
		ifStatementPanelMap.put(statement, panel);
		
		this.update(statement, panel);
		
		return panel;
	}

	@Override
	public JPanel visit(IfElseStatement statement) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JComponent ifPanel = this.visit((IfStatement)statement);
		panel.add(ifPanel);
		
		final JComponent elsePanel = statement.getElseStatement().accept(this);
		panel.add(elsePanel);
		ifElseStatementPanelMap.put(statement, panel);
		
		this.update(statement, elsePanel);
		
		return panel;
	}

	@Override
	public JPanel visit(Question question) {
		final Widget widget = question.getType().getWidgetFactory(new DefaultWidgetFactoryFactory()).createWidget(question.getLabel().toString(), this);
		symbolMap.put(question.getIdent(), widget.getValue());
		widgetIdentMap.put(widget, question.getIdent());
		return widget;
	}

	@Override
	public JLabel visit(Label label) {
		
		final JLabel jLabel = new JLabel();
		labelMap.put(label, jLabel);
		this.update(label, jLabel);
		
		return jLabel;
	}

	@Override
	public void widgetUpdate(Widget widget) {
		System.out.println("Widget updated -> " + widget + ", value:" + widget.getValue());
		final Identifier identifier = widgetIdentMap.get(widget);
		symbolMap.put(identifier, widget.getValue());
		
		for(final Entry<IfStatement, JComponent> entry : ifStatementPanelMap.entrySet()){
			this.update(entry.getKey(), entry.getValue());
		}
		for(final Entry<IfElseStatement, JComponent> entry : ifElseStatementPanelMap.entrySet()){
			this.update(entry.getKey(), entry.getValue());
		}
		for(final Entry<Label, JLabel> entry : labelMap.entrySet()){
			this.update(entry.getKey(), entry.getValue());
		}
	}
	
	private void update(final IfStatement ifStatement, final JComponent panel){
		BooleanValue v = (BooleanValue)ifStatement.getExpression().accept(expressionVisitor);
		panel.setVisible(v.getValue());
	}
	
	private void update(final IfElseStatement ifElseStatement, final JComponent elsePanel){
		BooleanValue v = (BooleanValue)ifElseStatement.getExpression().accept(expressionVisitor);
		elsePanel.setVisible(!v.getValue());
	}
	
	private void update(final Label label, final JLabel jLabel){
		String labelText = label.getLabel().getValue();
		
		final Iterator<Expression> expressions = label.getExpressions();
		int i = 0;
		while(expressions.hasNext()){
			final Value v = expressions.next().accept(expressionVisitor);
			labelText = labelText.replace("{"+i+"}", v.toString());
			i++;
		}
		
		jLabel.setText(labelText);
	}

}
