package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sound.sampled.Line;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.visitor.QLFormCreator;

public class QLForm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String formName;
	private HashMap<String, Result> identifiers = new HashMap<String, Result>();
	private HashMap<String, Result> symbols;
	private JPanel contentPane;
	private CompoundPanel cPanel;
	QLFormCreator symCreator = new QLFormCreator();

	public QLForm(QLProgram qlprogram) {
		int panelCount = 0;

		cPanel = (CompoundPanel) qlprogram.accept(symCreator);

		symbols = symCreator.getSymbols();

		formName = symCreator.getFormName();

		setBounds(700, 100, 480, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][]"));

		cPanel.registerAt(contentPane, 0);
		cPanel.registerActionListener(this) ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action performed");
		
		LinePanel linePanel = (LinePanel) cPanel.isActionSource(e) ;
		
		if ( linePanel != null) {
			symbols.put(linePanel.getFieldName(),linePanel.getFieldValue()) ;
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
			Result erExpressionResult = (Result) pairs
					.getValue();
			System.out.print(pairs.getKey());
			System.out.println(" = " + erExpressionResult.getStringValue());
		}
	}
}
