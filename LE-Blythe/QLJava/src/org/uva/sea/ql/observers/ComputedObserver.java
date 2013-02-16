package org.uva.sea.ql.observers;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.QuestionComputed;
import org.uva.sea.ql.util.Environment;

public class ComputedObserver implements Observer {

	private QuestionComputed statement;
	private Environment environment;
	
	public ComputedObserver(QuestionComputed statement, Environment environment){
		this.statement = statement;
		this.environment = environment;
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		throw new Error("computed question update triggered");
	}

	
}
