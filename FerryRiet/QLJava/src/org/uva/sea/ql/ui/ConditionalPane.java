package org.uva.sea.ql.ui;

import java.util.Map;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.operatorresults.BooleanResult;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.statements.ConditionalStatement;

public class ConditionalPane extends Pane {

	private CompoundPane falsePane;
	private CompoundPane truePane;
	private JPanel panel;
	private Expr trueExpr;

	public ConditionalPane(ConditionalStatement statement) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(new MigLayout("", "0[]0", "0[]0[]0"));

		trueExpr = statement.getExpression();
	}

	private void activateTFPanel(Result tResult) {
		if (tResult.getBooleanValue()) {
			if (falsePane != null)
				falsePane.removeFrom(panel);
			truePane.registerAt(panel, 0);
			truePane.setVisible(tResult.getBooleanValue());
			if (falsePane != null)
				falsePane.setVisible(!tResult.getBooleanValue());
		} else {
			truePane.removeFrom(panel);
			if (falsePane != null)
				falsePane.registerAt(panel, 0);
			truePane.setVisible(tResult.getBooleanValue());
			if (falsePane != null)
				falsePane.setVisible(!tResult.getBooleanValue());
		}
		panel.repaint();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		truePane.addObserver(o);
		if (falsePane != null)
			falsePane.addObserver(o);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {
		String result = String.format("cell 0 %d ,growx", location);
		parentPanel.add(panel, result);

		activateTFPanel(new BooleanResult(false));
	}

	public void setcElsePanel(CompoundPane cElsePanel) {
		this.falsePane = cElsePanel;
	}

	public void setcThenPanel(CompoundPane cThenPanel) {
		this.truePane = cThenPanel;
	}

	@Override
	public void updatecalculatedField(Map<String, Result> symbols) {
		truePane.updatecalculatedField(symbols);

		if (falsePane != null)
			falsePane.updatecalculatedField(symbols);

		Result tResult = trueExpr.eval(symbols);

		activateTFPanel(tResult);
	}
}
