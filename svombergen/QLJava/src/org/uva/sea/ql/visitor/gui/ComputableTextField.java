package org.uva.sea.ql.visitor.gui;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.Expr;

@SuppressWarnings("serial")
public class ComputableTextField extends JTextField {
	private Expr expression;
	
	public ComputableTextField(Expr exp) {
		expression = exp;
	}
	
	public void updateValue() {
		this.setText(expression.calculateValue());
	}
}
