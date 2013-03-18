package org.uva.sea.ql.visitor.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.TextAction;

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
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.ui.widgets.DefaultWidgetFactoryFactory;
import org.uva.sea.ql.visitor.ui.widgets.Widget;
import org.uva.sea.ql.visitor.ui.widgets.WidgetObserver;

import com.google.common.collect.Maps;

public class FormGeneratorVisitor implements StatementVisitor<Container>, WidgetObserver {

	private final ExpressionVisitor<Value> expressionVisitor;

	private final Map<Widget, Identifier> widgetIdentMap = Maps.newHashMap();

	private final Map<Identifier, Value> symbolMap;

	private final Map<IfStatement, Container> ifStatementPanelMap = Maps.newHashMap();

	private final Map<IfElseStatement, Container> ifElseStatementPanelMap = Maps.newHashMap();

	private final Map<Label, JLabel> labelMap = Maps.newHashMap();

	public FormGeneratorVisitor(final ExpressionVisitor<Value> expressionVisitor, final Map<Identifier, Value> symbolMap) {
		this.expressionVisitor = expressionVisitor;
		this.symbolMap = symbolMap;
	}

	@Override
	public JFrame visit(Form form) {
		JPanel panel = new JPanel(new BorderLayout());

		final Container compoundPanel = form.getCompoundStatement().accept(this);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.add(compoundPanel);

		final JFrame jframe = new JFrame(form.getIdentity().getName());
		this.createMenuBar(jframe);

		final JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jframe.setContentPane(scrollPane);

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setMinimumSize(new Dimension(750, 250));

		return jframe;
	}

	@Override
	public JPanel visit(CompoundStatement statement) {
		final JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		int y = 0;
		final Iterator<Statement> statementIterator = statement.getStatementIterator();
		while (statementIterator.hasNext()) {
			final Container statementPanel = statementIterator.next().accept(this);

			c.gridx = 0;
			c.gridy = y++;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			panel.add(statementPanel, c);
		}

		c.gridy = y++;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		panel.add(new JPanel(), c);

		return panel;
	}

	@Override
	public Container visit(IfStatement statement) {
		final Container panel = statement.getStatement().accept(this);
		ifStatementPanelMap.put(statement, panel);

		this.update(statement, panel);

		return panel;
	}

	@Override
	public Container visit(IfElseStatement statement) {
		final JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Container ifPanel = this.visit((IfStatement) statement);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		panel.add(ifPanel, c);

		final Container elsePanel = statement.getElseStatement().accept(this);
		c.gridy = 1;
		panel.add(elsePanel, c);
		ifElseStatementPanelMap.put(statement, elsePanel);

		c.gridy = 2;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		panel.add(new JPanel(), c);

		this.update(statement, elsePanel);

		return panel;
	}

	@Override
	public JPanel visit(Question question) {
		final Widget widget = question.getType().getWidgetFactory(new DefaultWidgetFactoryFactory()).createWidget(question.getLabel().getValue(), this);
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

		for (final Entry<IfStatement, Container> entry : ifStatementPanelMap.entrySet()) {
			this.update(entry.getKey(), entry.getValue());
		}
		for (final Entry<IfElseStatement, Container> entry : ifElseStatementPanelMap.entrySet()) {
			this.update(entry.getKey(), entry.getValue());
		}
		for (final Entry<Label, JLabel> entry : labelMap.entrySet()) {
			this.update(entry.getKey(), entry.getValue());
		}
	}

	private void update(final IfStatement ifStatement, final Container panel) {
		BooleanValue v = (BooleanValue) ifStatement.getExpression().accept(expressionVisitor);
		panel.setVisible(v.getValue());
	}

	private void update(final IfElseStatement ifElseStatement, final Container elsePanel) {
		BooleanValue v = (BooleanValue) ifElseStatement.getExpression().accept(expressionVisitor);
		elsePanel.setVisible(!v.getValue());
	}

	private void update(final Label label, final JLabel jLabel) {
		String labelText = label.getLabel().getValue();

		final Iterator<Expression> expressions = label.getExpressions();
		int i = 0;
		while (expressions.hasNext()) {
			final Value v = expressions.next().accept(expressionVisitor);
			labelText = labelText.replace("{" + i + "}", v.toString());
			i++;
		}

		jLabel.setText(labelText);
	}

	private void createMenuBar(final JFrame jframe) {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		fileMenu.add(new TextAction("Save Questionaire") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		fileMenu.add(new TextAction("Exit") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setVisible(false);
				jframe.dispose();
			}
		});

		jframe.setJMenuBar(menuBar);
	}

}
