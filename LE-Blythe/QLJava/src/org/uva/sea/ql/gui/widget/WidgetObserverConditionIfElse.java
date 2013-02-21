package org.uva.sea.ql.gui.widget;

import java.awt.Component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverConditionIfElse extends WidgetObserverConditionIf {
	
	private Component elsePanel;
	
	public WidgetObserverConditionIfElse(Expr expression, Component ifPanel, Component elsePanel, Environment environment){
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
