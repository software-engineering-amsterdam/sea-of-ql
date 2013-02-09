package org.uva.sea.ql.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observer;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.literals.BooleanResult;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.operators.Expr;

public class ConditionalPanel extends Panel {

	private CompoundPanel cElsePanel;
	private CompoundPanel cThenPanel;
	private JPanel panel;
	private Expr trueExpr;

	public ConditionalPanel(ConditionalStatement statement) {
		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[]", "[][]"));

		trueExpr = statement.getExpression();
		//panel.setBackground(Color.BLUE);
	}

	@Override
	public synchronized void addObserver(Observer o) {
		cThenPanel.addObserver(o);
		if (cElsePanel != null)
			cElsePanel.addObserver(o);
	}

	@Override
	public Panel isActionSource(ActionEvent ev) {
		Panel actionPanel = cThenPanel.isActionSource(ev);
		if (actionPanel != null)
			return actionPanel;
		if (cElsePanel != null)
			return cElsePanel.isActionSource(ev);
		return null;
	}

	@Override
	public void registerActionListener(ActionListener actionHandler) {
		cThenPanel.registerActionListener(actionHandler);
		if (cElsePanel != null)
			cElsePanel.registerActionListener(actionHandler);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {
		StringBuilder stringBuilder = new StringBuilder("cell 0 ");
		stringBuilder.append(location);
		stringBuilder.append(" ,growx");

		parentPanel.add(panel, stringBuilder.toString());

		Result tResult = new BooleanResult(false);

		if (tResult.getBooleanValue()) {
			if ( cElsePanel != null ) cElsePanel.removeFrom(panel);
			cThenPanel.registerAt(panel, 0);
			cThenPanel.setVisible(tResult.getBooleanValue()) ;
			if ( cElsePanel != null ) cElsePanel.setVisible(!tResult.getBooleanValue()) ;
		} else {
			cThenPanel.removeFrom(panel);
			if ( cElsePanel != null ) cElsePanel.registerAt(panel, 0);
			cThenPanel.setVisible(tResult.getBooleanValue()) ;
			if ( cElsePanel != null ) cElsePanel.setVisible(!tResult.getBooleanValue()) ;
		}
		panel.repaint() ;
	}

	public void setcElsePanel(CompoundPanel cElsePanel) {
		this.cElsePanel = cElsePanel;
	}

	public void setcThenPanel(CompoundPanel cThenPanel) {
		this.cThenPanel = cThenPanel;
	}

	@Override
	public void updatecalculatedField(HashMap<String, Result> symbols) {
		cThenPanel.updatecalculatedField(symbols);
		
		if (cElsePanel != null)
			cElsePanel.updatecalculatedField(symbols);

		Result tResult = trueExpr.eval(symbols);

		if (tResult.getBooleanValue()) {
			if ( cElsePanel != null ) cElsePanel.removeFrom(panel);
			cThenPanel.registerAt(panel, 0);
			cThenPanel.setVisible(tResult.getBooleanValue()) ;
			if ( cElsePanel != null ) cElsePanel.setVisible(!tResult.getBooleanValue()) ;
		} else {
			cThenPanel.removeFrom(panel);
			if ( cElsePanel != null ) cElsePanel.registerAt(panel, 0);
			cThenPanel.setVisible(tResult.getBooleanValue()) ;
			if ( cElsePanel != null ) cElsePanel.setVisible(!tResult.getBooleanValue()) ;
		}
		panel.repaint() ;
	}
}
