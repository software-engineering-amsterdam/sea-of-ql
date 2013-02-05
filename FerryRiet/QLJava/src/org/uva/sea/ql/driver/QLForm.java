package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
		int panelCount = 0;

		qlprogram.accept(symCreator);

		symbols = symCreator.getSymbols();

		formName = symCreator.getFormName();

		setBounds(700, 100, 480, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));

		for (Panel panel : symCreator.getPanels()) {
			panel.registerAt(contentPane, panelCount++);
			panel.registerActionListener(this);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");

		for (Panel panel : symCreator.getPanels()) {
			if (panel.actionSource(e)) {
				System.out.println("foundid");
				symbols.put(panel.getFieldName(), panel.getFieldValue());
				break;
			}
		}

		for (Panel panel : symCreator.getPanels()) {
			panel.updatecalculatedField(symbols) ;
		}

		printMap(symbols);

		// 1: find source of action
		// 2: update variable
		// 3: find dependent panels
	}

	private void printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			ExpressionResult erExpressionResult = (ExpressionResult) pairs
					.getValue();
			System.out.print(pairs.getKey());
			System.out.println(" = " + erExpressionResult.getStringValue());
		}
	}
}
