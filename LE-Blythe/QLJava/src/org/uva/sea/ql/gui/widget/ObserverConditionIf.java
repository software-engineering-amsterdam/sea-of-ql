package org.uva.sea.ql.gui.widget;

import java.awt.Component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.visitor.VisitorEvalExpr;
import org.uva.sea.ql.util.Environment;

public class ObserverConditionIf extends WidgetObserver {
	
	protected Expr expression;
	protected Component ifPanel;
	protected Environment environment;
	
	public ObserverConditionIf(Expr expression, Component ifPanel, Environment environment){
		this.expression = expression;
		this.ifPanel = ifPanel;
		this.environment = environment;
	}
	
	
	protected boolean evaluateCondition(){
		Primitive result = expression.accept(new VisitorEvalExpr(environment));

		return result.isDefined() && ((Bool)result).getValue();
	}
	
	
	public void evaluate(){
		ifPanel.setVisible(evaluateCondition());
	}
	
}
