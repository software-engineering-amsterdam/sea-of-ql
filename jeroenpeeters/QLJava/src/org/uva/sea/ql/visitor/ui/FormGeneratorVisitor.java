package org.uva.sea.ql.visitor.ui;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.valuesystem.BooleanValue;
import org.uva.sea.ql.valuesystem.Value;
import org.uva.sea.ql.visitor.ui.widgets.Widget;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;
import org.uva.sea.ql.visitor.ui.widgets.WidgetObserver;

public class FormGeneratorVisitor implements StatementVisitor<JPanel>, WidgetObserver{
	
	private final ExpressionVisitor<Value> expressionVisitor;
	
	
	public FormGeneratorVisitor(final ExpressionVisitor<Value> expressionVisitor){
		this.expressionVisitor = expressionVisitor;
	}
	
	@Override
	public JPanel visit(Form form) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createTitledBorder(form.getIdentity().getName()));
		
		final JPanel compoundPanel = form.getCompoundStatement().accept(this);
		panel.add(compoundPanel);
		
		return panel;
	}

	@Override
	public JPanel visit(CompoundStatement statement) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		
		final Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			final JPanel statementPanel = statementIterator.next().accept(this);
			panel.add(statementPanel);
		}
		
		return panel;
	}
	
	@Override
	public JPanel visit(IfStatement statement) {
		final JPanel panel = statement.getStatement().accept(this);
		
		BooleanValue v = (BooleanValue)statement.getExpression().accept(expressionVisitor);
		
		System.out.println(v);
		
		panel.setVisible(false);
		
		return panel;
	}

	@Override
	public JPanel visit(IfElseStatement statement) {
		JPanel ifPanel = this.visit((IfStatement)statement);
		
		final JPanel elsePanel = statement.getElseStatement().accept(this);
		elsePanel.setVisible(false);
		ifPanel.add(elsePanel);
		
		return ifPanel;
	}

	@Override
	public JPanel visit(Question question) {
		final Widget widget = WidgetFactory.createWidget(question.getDataType(), question.getLabel().getValue(), this);
		return widget;
	}

	@Override
	public void widgetUpdate(Widget widget) {
		System.out.println("Widget updated -> " + widget + ", value:" + widget.getValue());
		
	}

}
