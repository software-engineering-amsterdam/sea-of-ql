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
	private JPanel contentPanel;
	private CompoundPane cPane;
	QLFormCreator qlFormCreator = new QLFormCreator();

	public QLForm(QLProgram qlprogram) {

		cPane = (CompoundPane) qlprogram.accept(qlFormCreator);

		qlSymbols = qlFormCreator.getSymbols();

		setBounds(700, 100, 480, 600);
		setTitle(qlFormCreator.getFormName());

		contentPanel = new JPanel();
		contentPanel.setLayout(new MigLayout("gap 5px 5px", "0[]0", "0[]0"));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPanel);

		cPane.registerAt(contentPanel, 0);
		cPane.addObserver(this);
		cPane.updatecalculatedField(qlSymbols);
	}

	@Override
	public void update(Observable o, Object arg) {
		LinePane linePanel = (LinePane) o;

		if (linePanel != null) {
			qlSymbols.put(linePanel.getFieldName(), linePanel.getFieldValue());
		}
		cPane.updatecalculatedField(qlSymbols);
	}
}
