package org.uva.sea.ql.driver;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.LineStatement;

public class ConditionalPanel {
	private Expr trueExpr;
	private boolean visible = false;

	private JPanel jThenPanel;
	private JPanel jElsePanel;
	private JPanel jPanelContainer;

	public ConditionalPanel(ConditionalStatement statement) {

		trueExpr = statement.getExpression();
		jPanelContainer = new JPanel();
		jPanelContainer.setLayout(new MigLayout("", "[]", "[][]"));
		jThenPanel = new JPanel();
		if (statement.getFalseCompound() != null) {
			jElsePanel = new JPanel();
		}
	}
}
