package org.uva.sea.ql.visitor.ui;

import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.apache.commons.lang3.Validate;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.visitor.BaseVisitor;
import org.uva.sea.ql.visitor.ui.widgets.BaseWidget;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;

import com.google.common.collect.Maps;

public class FormGeneratorVisitor extends BaseVisitor{

	private JPanel rootPanel;
	private JPanel currentPanel;
	
	private final Map<CompoundStatement, JPanel> panelMap = Maps.newHashMap();
	
	public FormGeneratorVisitor(){
		rootPanel = new JPanel(new GridLayout(0, 1));
		currentPanel = rootPanel;
	}

	public JPanel getPanel(){
		return rootPanel;
	}
	
	private void addPanel(final JPanel panel){
		currentPanel.add(panel);
	}
	
	private void addWidget(final BaseWidget widget){
		currentPanel.add(widget);
	}
	
	@Override
	public void visit(Form form) {
		rootPanel.setBorder(BorderFactory.createTitledBorder(form.getIdentity().getName()));
		
		super.visit(form);
	}

	@Override
	public void visit(CompoundStatement statement) {
		final JPanel panel = new JPanel(new GridLayout(0, 1));
		addPanel(panel);
		currentPanel = panel;
		panelMap.put(statement, currentPanel);
		
		super.visit(statement);
	}
	
	

	@Override
	public void visit(IfStatement statement) {
		super.visit(statement);
		
		final JPanel panel = panelMap.get(statement.getStatement());
		Validate.notNull(panel);
		
		panel.setVisible(false);
	}

	@Override
	public void visit(IfElseStatement statement) {
		super.visit(statement);
		
		final JPanel panel = panelMap.get(statement.getStatement());
		Validate.notNull(panel);
		panel.setVisible(false);
		
		final JPanel elsePanel = panelMap.get(statement.getElseStatement());
		Validate.notNull(elsePanel);
		elsePanel.setVisible(false);
	}

	@Override
	public void visit(Question question) {
		super.visit(question);
		
		final BaseWidget widget = WidgetFactory.createWidget(question.getDataType(), question.getLabel().getValue());
		this.addWidget(widget);
	}

}
