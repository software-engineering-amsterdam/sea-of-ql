package org.uva.sea.ql.gui.widget;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverConditionIfElse extends WidgetObserverConditionIf {
	
	private JComponent elsePanel;
	
	public WidgetObserverConditionIfElse(Expr expression, JComponent ifPanel, JComponent elsePanel, Environment<Ident, Value> environment){
		super(expression, ifPanel, environment);
		
		this.elsePanel = elsePanel;
	}
	
	@Override
	public void evaluate(){
		Value result = evalCondition();		
		ifPanel.setVisible(isDefined(result) && toBool(result));
		elsePanel.setVisible(isDefined(result) && !toBool(result));
	}
	
}
