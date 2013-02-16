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

public class ConditionalPanel extends Panel {

	private CompoundPanel falsePanel;
	private CompoundPanel truePanel;
	private JPanel panel;
	private Expr trueExpr;

	public ConditionalPanel(ConditionalStatement statement) {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setLayout(new MigLayout("", "0[]0", "0[]0[]0"));

		trueExpr = statement.getExpression();
	}

	private void activateTFPanel(Result tResult) {
		if (tResult.getBooleanValue()) {
			if (falsePanel != null)
				falsePanel.removeFrom(panel);
			truePanel.registerAt(panel, 0);
			truePanel.setVisible(tResult.getBooleanValue());
			if (falsePanel != null)
				falsePanel.setVisible(!tResult.getBooleanValue());
		} else {
			truePanel.removeFrom(panel);
			if (falsePanel != null)
				falsePanel.registerAt(panel, 0);
			truePanel.setVisible(tResult.getBooleanValue());
			if (falsePanel != null)
				falsePanel.setVisible(!tResult.getBooleanValue());
		}
		panel.repaint();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		truePanel.addObserver(o);
		if (falsePanel != null)
			falsePanel.addObserver(o);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {

		String result = String.format("cell 0 %d ,growx", location);

		parentPanel.add(panel, result);

		Result tResult = new BooleanResult(false);

		activateTFPanel(tResult);
	}

	public void setcElsePanel(CompoundPanel cElsePanel) {
		this.falsePanel = cElsePanel;
	}

	public void setcThenPanel(CompoundPanel cThenPanel) {
		this.truePanel = cThenPanel;
	}

	@Override
	public void updatecalculatedField(Map<String, Result> symbols) {
		truePanel.updatecalculatedField(symbols);

		if (falsePanel != null)
			falsePanel.updatecalculatedField(symbols);

		Result tResult = trueExpr.eval(symbols);

		activateTFPanel(tResult);
	}
}
