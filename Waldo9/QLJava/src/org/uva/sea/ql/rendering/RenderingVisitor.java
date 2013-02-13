package org.uva.sea.ql.rendering;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.expressions.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.StatementVisitor;

public class RenderingVisitor implements StatementVisitor<Object> {
	
	private final JPanel contentPane;
	
	public RenderingVisitor() {
		contentPane = new JPanel(new GridLayout(0,2));
	}
	
	public void testRender() {
		JFrame frame = new JFrame("QL demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(new JLabel("test label 1: "));
		contentPane.add(new JTextField());
		contentPane.add(new JLabel("test label 2:zzzzzz "));		
		contentPane.add(new JCheckBox());
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public Object visit(Question question) {
		addLabel(question.getLabel());
		return null;
	}	
	
	@Override
	public Object visit(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(IfThenElse ifThenElse) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public Object visit(ComputedQuestion computedQuestion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addLabel(StringLiteral label) {
		contentPane.add(new JLabel(label.getValue()));		
	}

}
