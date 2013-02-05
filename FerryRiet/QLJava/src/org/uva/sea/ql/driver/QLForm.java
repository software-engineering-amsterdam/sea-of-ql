package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.nodevisitor.QLFormSymbolsCreator;
import org.uva.sea.ql.ast.operators.ExpressionResult;

public class QLForm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private String formName;

	private HashMap<String, ExpressionResult> identifiers = new HashMap<String, ExpressionResult>();

	private HashMap<String, ExpressionResult> symbols;

	private JPanel contentPane;
	QLFormSymbolsCreator symCreator = new QLFormSymbolsCreator();

	
	public QLForm(QLProgram qlprogram) {
		int panelCount = 0 ;

		qlprogram.accept(symCreator);
		symbols = symCreator.getSymbols();

		setFormName(symCreator.getFormName());
		setBounds(700, 100, 480, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));

		for (Panel panel : symCreator.getPanels()) {
			panel.registerAt(contentPane,panelCount++);
			panel.registerActionListener(this) ;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
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

	public void setFormName(String formName) {
		this.formName = formName;
		this.setTitle(formName);
	}

	public void setIdentifiers(HashMap<String, ExpressionResult> identifiers) {
		this.identifiers = identifiers;
	}
}
