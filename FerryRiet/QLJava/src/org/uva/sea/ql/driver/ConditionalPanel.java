package org.uva.sea.ql.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.ConditionalStatement;
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
	}

	@Override
	public Panel isActionSource(ActionEvent ev) {
		// TODO Auto-generated method stub
		return super.isActionSource(ev);
	}

	@Override
	public void registerActionListener(ActionListener actionHandler) {
		// TODO Auto-generated method stub
		super.registerActionListener(actionHandler);
	}

	@Override
	public void registerAt(JPanel parentPanel, int location) {
		parentPanel.add(panel, "cell 0 0 , growx" );
	}

	public void setcElsePanel(CompoundPanel cElsePanel) {
		this.cElsePanel = cElsePanel;
	}

	public void setcThenPanel(CompoundPanel cThenPanel) {
		this.cThenPanel = cThenPanel;
	}
}
