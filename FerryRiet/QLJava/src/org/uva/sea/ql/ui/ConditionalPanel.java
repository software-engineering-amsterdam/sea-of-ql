package org.uva.sea.ql.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.literals.Result;
import org.uva.sea.ql.ast.operators.Expr;

public class ConditionalPanel extends Panel {
	private JPanel panel;
	private CompoundPanel cElsePanel;

	private CompoundPanel cThenPanel;

	private Expr trueExpr;

	private boolean visible = false;

	public ConditionalPanel(ConditionalStatement statement) {
		panel = new JPanel();
		panel.setLayout(new MigLayout("", "[]", "[][]"));

		trueExpr = statement.getExpression();
		panel.setBackground(Color.BLUE) ;
	}

	@Override
	public void updatecalculatedField(HashMap<String, Result> symbols) {
		cThenPanel.updatecalculatedField(symbols) ;
		if ( cElsePanel != null)
			cElsePanel.updatecalculatedField(symbols) ;
	}

	@Override
	public Panel isActionSource(ActionEvent ev) {
		Panel actionPanel = cThenPanel.isActionSource(ev) ;
		if ( actionPanel != null) return actionPanel ;
		if ( cElsePanel != null) return cElsePanel.isActionSource(ev) ;
		return null ;
	}

	@Override
	public void registerActionListener(ActionListener actionHandler) {
		cThenPanel.registerActionListener(actionHandler);
		if ( cElsePanel != null ) cElsePanel.registerActionListener(actionHandler);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {
		StringBuilder stringBuilder = new StringBuilder("cell 0 ");

		stringBuilder.append(location);
		stringBuilder.append(" ,growx");
		parentPanel.add(panel, stringBuilder.toString() );
		cThenPanel.registerAt(panel, 0) ;
		if ( cElsePanel != null ) cElsePanel.registerAt(panel, 1) ;
	}

	public void setcElsePanel(CompoundPanel cElsePanel) {
		this.cElsePanel = cElsePanel;
	}

	public void setcThenPanel(CompoundPanel cThenPanel) {
		this.cThenPanel = cThenPanel;
	}
}
