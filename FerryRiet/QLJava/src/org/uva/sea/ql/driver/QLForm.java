package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.operators.*;

public class QLForm implements ActionListener {

	private String formName;
	private HashMap<String, ExpressionResult> identifiers = new HashMap<String, ExpressionResult>();
	private List<QLFormLine> qLFormLines = new ArrayList<QLFormLine>();

	public void setIdentifiers(HashMap<String, ExpressionResult> identifiers) {
		this.identifiers = identifiers;
	}

	public List<QLFormLine> getqLFormLines() {
		return qLFormLines;
	}

	public void setqLFormLines(List<QLFormLine> qLFormLines) {
		this.qLFormLines = qLFormLines;
	}

	public void addIdentifier(String name, ExpressionResult expressionResult) {
		identifiers.put(name, expressionResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}
}
