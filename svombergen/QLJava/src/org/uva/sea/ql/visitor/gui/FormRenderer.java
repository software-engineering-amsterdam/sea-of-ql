package org.uva.sea.ql.visitor.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComponent;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.ast.primaryexpr.*;
import org.uva.sea.ql.visitor.IFormVisitor;

public class FormRenderer implements IFormVisitor {
	private FormFrame frame;
	private JPanel panel;
	private Map<Ident,JComponent> identMap;
	
	public FormRenderer() {
		identMap = new HashMap<Ident,JComponent>();
		frame = new FormFrame();
		panel = new JPanel(new MigLayout());
	}

	@Override
	public void visit(Form f) {
		for(Statement s : f.getStatements())
			s.accept(this);

		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void visit(ComputableQuestion q) {
		panel.add(new JLabel(q.getQuestionString().toString()));
		panel.add(new JTextField("calc_value"), "wrap");
	}

	@Override
	public void visit(AnswerableQuestion q) {
		panel.add(new JLabel(q.getQuestionString().toString()));
		if (q.getType().toString() == new BoolType().toString())
			panel.add(new JCheckBox(),"wrap");
		else
			panel.add(new JTextField("<input>"), "wrap");
	}

	@Override
	public void visit(IfStatement ifStat) {
		// TODO Auto-generated method stub
		
	}

	public void visit(StrType strType) {
		// TODO Auto-generated method stub
		
	}

	public void visit(BoolType boolType) {
		// TODO Auto-generated method stub
		
	}

	public void visit(IntType intType) {
		// TODO Auto-generated method stub
		
	}

}
