package org.uva.sea.ql.ast.visitor.renderexample;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;

public class Renderer2 implements IStatementVisitor {
	
private final JPanel panel;
	
	public Renderer2(){
		panel=new JPanel();
	}
	
	public void show(){
		JFrame frame = new JFrame("QL try");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(new JLabel("form Box1HouseOwning"));
		panel.add(new JTextField());
		panel.add(new JLabel("hasSoldHouse: \"Did you sell a house in 2010?\" boolean"));	
		panel.add(new JCheckBox());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void visit(Form form) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(ComQuestion comquestions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IfThen ifthen) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(SimpleQuestion simpleQuestion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(QuestionElement questionElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(Block block) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(StatementElement statementElement) {
		// TODO Auto-generated method stub

	}

}
