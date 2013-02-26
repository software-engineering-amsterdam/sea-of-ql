package org.uva.sea.ql.gui.widget;

import org.uva.sea.ql.ast.eval.VisitorEvalExpr;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.util.Environment;

public class WidgetObserverComputed extends WidgetObserver{

	private QuestionComputed statement;
	private WidgetComputed widget;
	private Environment environment;
	
	public WidgetObserverComputed(QuestionComputed statement, WidgetComputed widget, Environment environment){
		super();
		
		this.statement = statement;
		this.widget = widget;
		this.environment = environment;
	}
	
	@Override
	public void evaluate(){
		Primitive value = statement.getValue().accept(new VisitorEvalExpr(environment));
		
		widget.setValue(value);
		
		//only show the value if it is defined
		widget.getControl().setVisible(value.isDefined());
	}
	
}
