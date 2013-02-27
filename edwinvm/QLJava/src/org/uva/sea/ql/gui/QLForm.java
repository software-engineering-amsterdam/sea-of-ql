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
	
	public static void main(String[] args) { new QLForm(); }
	
	public QLForm() {
		renderQLForm();
	}
	
	private void renderQLForm() {
		initializeForm();
		renderQLStatements(getFormBody());
		setFormLayout();
	}
	
	private StatementBody getFormBody() {
		Form qlForm = QLHandler.getFormAST();
		return qlForm.getBody();
	}
	
	private void renderQLStatements(StatementBody body) {
		for (FormStatement statement: body.getStatements()) {
			_qlFrame.add(GUIRenderer.render(statement, new State()));
		}
	}
	
	private void initializeForm() {
		_qlFrame = new JFrame("QL Form");
	}
	
	private void setFormLayout() {
		_qlFrame.setSize(850,550);
		_qlFrame.setLayout(new FlowLayout());
		_qlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_qlFrame.setVisible(true);
	}
	
}