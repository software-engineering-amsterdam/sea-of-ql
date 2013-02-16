package org.uva.sea.ql.observers;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.statement.IfThen;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.util.Environment;

public class ConditionObserver implements Observer {
	
	private IfThen statement;
	private Environment environment;
	
	public ConditionObserver(IfThen statement, Environment environment){
		this.statement = statement;
		this.environment = environment;
	}

	
	public ConditionObserver(IfThenElse statement, Environment environment){
		this.statement = statement;
		this.environment = environment;
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		throw new Error("condition observer update triggered");
	}
	
	
	
}
