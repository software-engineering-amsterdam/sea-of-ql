package org.uva.sea.ql.gui.widget;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.gui.control.Control;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverConditionIfElse extends WidgetObserverConditionIf {
	
	private Control elsePanel;
	
	public WidgetObserverConditionIfElse(Expr expression, Control ifPanel, Control elsePanel, Environment environment){
		super(expression, ifPanel, environment);
		
		this.elsePanel = elsePanel;
	}
	
	@Override
	public void evaluate(){
		Primitive result = evalCondition();		
		ifPanel.setVisible(isDefined(result) && toBool(result));
		elsePanel.setVisible(isDefined(result) && !toBool(result));
	}
	
}
