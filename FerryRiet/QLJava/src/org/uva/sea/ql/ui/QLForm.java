package org.uva.sea.ql.ui;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.statements.QLProgram;
import org.uva.sea.ql.ast.visitor.QLFormCreator;

public class QLForm extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private Map<String, Result> qlSymbols;
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
		
		contentPane.setLayout(new MigLayout("gap 5px 5px", "0[]0", "0[]0"));
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));


		setContentPane(contentPane);

		cPanel.registerAt(contentPane, 0);

		cPanel.addObserver(this);

		cPanel.updatecalculatedField(qlSymbols);
	}

	@Override
	public void update(Observable o, Object arg) {
		LinePanel linePanel = (LinePanel) o;

		if (linePanel != null) {
			qlSymbols.put(linePanel.getFieldName(), linePanel.getFieldValue());
		}

		cPanel.updatecalculatedField(qlSymbols);
	}
}
