package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.nodevisitor.QLFormSymbolsCreator;
import org.uva.sea.ql.ast.operators.ExpressionResult;

public class QLForm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private String formName;

	private HashMap<String, ExpressionResult> identifiers = new HashMap<String, ExpressionResult>();

	private List<QLFormLine> qLFormLines = new ArrayList<QLFormLine>();

	private HashMap<String, ExpressionResult> symbols;

	public QLForm(QLProgram qlprogram) {
		QLFormSymbolsCreator symCreator = new QLFormSymbolsCreator();

		qlprogram.accept(symCreator);
		symbols = symCreator.getSymbols();
	
		for (String key : symbols.keySet()) {
			System.out.println(key);
		}
		
		setFormName(symCreator.getFormName());
		setBounds(700, 100, 480, 600);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1: find source of action
		// 2: update variable
		// 3: find dependent panels
	}

	public void addIdentifier(String name, ExpressionResult expressionResult) {
		identifiers.put(name, expressionResult);
	}

	public String getFormName() {
		return formName;
	}

	public List<QLFormLine> getqLFormLines() {
		return qLFormLines;
	}

	public void setFormName(String formName) {
		this.formName = formName;
		this.setTitle(formName);
	}

	public void setIdentifiers(HashMap<String, ExpressionResult> identifiers) {
		this.identifiers = identifiers;
	}

	public void setqLFormLines(List<QLFormLine> qLFormLines) {
		this.qLFormLines = qLFormLines;
	}
}
