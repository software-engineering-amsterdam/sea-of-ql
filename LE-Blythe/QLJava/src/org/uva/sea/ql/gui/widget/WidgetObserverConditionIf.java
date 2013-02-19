package org.uva.sea.ql.gui.widget;

import java.awt.Component;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.eval.VisitorEvalExpr;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverConditionIf extends WidgetObserver {
	
	protected Expr expression;
	protected Component ifPanel;
	protected Environment environment;
	
	public WidgetObserverConditionIf(Expr expression, Component ifPanel, Environment environment){
		super();
		
		this.expression = expression;
		this.ifPanel = ifPanel;
		this.environment = environment;
	}
	
	
	protected Primitive evalCondition(){
		return expression.accept(new VisitorEvalExpr(environment));
	}
	
	
	protected boolean toBool(Primitive result){
		return ((Bool)result).getValue();
	}
	
	
	protected boolean isDefined(Primitive result){
		return result.isDefined();
	}
	
	
	@Override
	public void evaluate(){
		Primitive result = evalCondition();
		ifPanel.setVisible(isDefined(result) && toBool(result) );
	}
	
}
