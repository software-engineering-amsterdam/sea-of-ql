package org.uva.sea.ql.gui.widget;

import java.awt.Component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.util.Environment;

public class ObserverConditionIfElse extends ObserverConditionIf {
	
	private Component elsePanel;
	
	public ObserverConditionIfElse(Expr expression, Component ifPanel, Component elsePanel, Environment environment){
		super(expression, ifPanel, environment);
		
		this.elsePanel = elsePanel;
	}
	
	@Override
	public void evaluate(){
		boolean result = evaluateCondition();
		ifPanel.setVisible(result);
		elsePanel.setVisible(!result);
	}
	
}
