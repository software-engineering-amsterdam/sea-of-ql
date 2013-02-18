package org.uva.sea.ql.gui.widget;

import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.interpreter.VisitorEvalExpr;
import org.uva.sea.ql.util.Environment;

public class ObserverComputed extends WidgetObserver{

	private QuestionComputed statement;
	private WidgetComputed widget;
	private Environment environment;
	
	public ObserverComputed(QuestionComputed statement, WidgetComputed widget, Environment environment){
		super();
		
		this.statement = statement;
		this.widget = widget;
		this.environment = environment;
	}
	
	@Override
	public void evaluate(){
		Primitive value = statement.getValue().accept(new VisitorEvalExpr(environment));
		environment.putValue(statement.getIdentifier(), value);
		
		widget.setValue(value);
	}
	
}
