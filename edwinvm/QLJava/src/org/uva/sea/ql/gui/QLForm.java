package org.uva.sea.ql.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.statements.FormStatement;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.gui.render.GUIRenderer;
import org.uva.sea.ql.gui.render.State;

public class QLForm {

	private JFrame _qlFrame;
	
	public QLForm() {
		initializeFormLayout();
		
		Form qlForm = QLHandler.getFormAST();
		StatementBody qlBody = qlForm.getBody();
		
		for (FormStatement statement: qlBody.getStatements()) {
			_qlFrame.add(GUIRenderer.render(statement, new State()));
		}
	}
	
	public static void main(String[] args) {
		new QLForm();
	}
	
	private void initializeFormLayout() {
		_qlFrame = new JFrame("QL Form");
		_qlFrame.setSize(850,550);
		_qlFrame.setLayout(new FlowLayout());
		_qlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_qlFrame.setVisible(true);
	}
	
}