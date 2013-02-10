package org.uva.sea.ql.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.visitor.QLFormCreator;

public class QLForm extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Result> qlSymbols;
	private JPanel contentPane;
	private CompoundPanel cPanel;
	QLFormCreator symCreator = new QLFormCreator();

	public QLForm(QLProgram qlprogram) {

		cPanel = (CompoundPanel) qlprogram.accept(symCreator);

		qlSymbols = symCreator.getSymbols();

		String formName = symCreator.getFormName();

		setBounds(700, 100, 480, 600);

		setTitle(formName);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new MigLayout("", "[grow]", "[]"));

		setContentPane(contentPane);

		cPanel.registerAt(contentPane, 0);

		cPanel.addObserver(this);
	}

	private void printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			Result erExpressionResult = (Result) pairs.getValue();
			System.out.print(pairs.getKey());
			System.out.println(" = " + erExpressionResult.getStringValue());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		LinePanel linePanel = (LinePanel) o;

		if (linePanel != null) {
			qlSymbols.put(linePanel.getFieldName(), linePanel.getFieldValue());
		}

		cPanel.updatecalculatedField(qlSymbols);
		printMap(qlSymbols);
	}
}
