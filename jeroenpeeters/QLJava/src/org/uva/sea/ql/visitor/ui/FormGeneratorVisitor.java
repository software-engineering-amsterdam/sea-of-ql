package org.uva.sea.ql.visitor.ui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.visitor.BaseVisitor;
import org.uva.sea.ql.visitor.ui.widgets.BaseWidget;
import org.uva.sea.ql.visitor.ui.widgets.WidgetFactory;

public class FormGeneratorVisitor extends BaseVisitor{

	private JPanel panel;
	
	public FormGeneratorVisitor(){
		panel = new JPanel(new GridLayout(0, 1));
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	private void addWidget(final BaseWidget widget){
		panel.add(widget);
	}
	
	@Override
	public void visit(Form form) {
		panel.setBorder(BorderFactory.createTitledBorder(form.getIdentity().getName()));
		
		super.visit(form);
	}

	@Override
	public void visit(Question question) {
		super.visit(question);
		
		final BaseWidget widget = WidgetFactory.createWidget(question.getDataType(), question.getLabel().getValue());
		this.addWidget(widget);
	}

}
