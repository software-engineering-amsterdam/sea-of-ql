package org.uva.sea.ql.driver;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public class ConditionalPanel extends Panel {
	private Expr trueExpr;
	private boolean visible = false;

	private CompoundPanel cThenPanel;
	private CompoundPanel cElsePanel;

	public ConditionalPanel(ConditionalStatement statement) {
		trueExpr = statement.getExpression();
	}

	public void addTrueCompound(VisitorResult accept) {
		setcThenPanel((CompoundPanel) accept) ;
	}

	public void setcThenPanel(CompoundPanel cThenPanel) {
		this.cThenPanel = cThenPanel;
	}

	public void setcElsePanel(CompoundPanel cElsePanel) {
		this.cElsePanel = cElsePanel;
	}
}
