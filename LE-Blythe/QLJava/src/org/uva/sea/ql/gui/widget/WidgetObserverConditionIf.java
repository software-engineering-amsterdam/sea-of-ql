package org.uva.sea.ql.gui.widget;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.eval.VisitorEvalExpr;
import org.uva.sea.ql.eval.value.BoolVal;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverConditionIf extends WidgetObserver {
	
	protected Expr expression;
	protected JComponent ifPanel;
	protected Environment<Ident, Value> environment;
	
	public WidgetObserverConditionIf(Expr expression, JComponent ifPanel, Environment<Ident, Value> environment){
		super();
		
		this.expression = expression;
		this.ifPanel = ifPanel;
		this.environment = environment;
	}
	
	
	protected Value evalCondition(){
		return expression.accept(new VisitorEvalExpr(environment));
	}
	
	
	protected boolean toBool(Value result){
		return ((BoolVal)result).getValue();
	}
	
	
	protected boolean isDefined(Value result){
		return result.isDefined();
	}
	
	@Override
	public void evaluate(){
		Value result = evalCondition();
		ifPanel.setVisible(isDefined(result) && toBool(result) );
	}
	
}
