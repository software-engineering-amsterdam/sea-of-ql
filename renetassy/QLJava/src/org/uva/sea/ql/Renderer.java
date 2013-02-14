package org.uva.sea.ql;

import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;
import org.uva.sea.ql.ast.stmnt.Statement;
import net.miginfocom.swing.MigLayout;

public class Renderer extends StatementVisitor {
	
	private JPanel panel;
	
	final int TEXTFIELD_SIZE = 20;
	
	public static JComponent render(Form form) {
		
		Renderer r = new Renderer();
		
		form.accept(r);
		
		return r.getPanel();
	}
	
	public Renderer() {
		this.panel = new JPanel(new MigLayout());
	}
	
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public boolean visit(Question question) {
		
		JComponent widget = typeToWidget(question);
		JLabel label = new JLabel(question.getLabel().getValue());
		panel.add(label);
		panel.add(widget,"wrap");
		//System.out.println("oeo");
		return false;
	}

	@Override
	public boolean visit(ComputedQuestion computedQuestion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Body body) {
		
		List<Statement> statements = body.getStatements();
		
		for (Statement statement : statements) {
			statement.accept(this);
		}
		
		return true;
	}

	@Override
	public boolean visit(Form form) {
		form.getBody().accept(this);
		return true;
	}
	
	private JComponent typeToWidget(Question q) {
		
		JComponent widget;
		
		if(q.getType().isCompatibleToBool()) {
			widget = new JCheckBox();
			return widget;
		}
		
		if(q.getType().isCompatibleToInt()) {
			widget = new JTextField(TEXTFIELD_SIZE);
			return widget;
		}
		
		if(q.getType().isCompatibleToString()) {
			widget = new JTextField(TEXTFIELD_SIZE);
			return widget;
		}
		
		return null;
		
	}

}
