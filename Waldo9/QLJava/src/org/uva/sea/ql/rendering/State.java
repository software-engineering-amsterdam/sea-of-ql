package org.uva.sea.ql.rendering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.evaluation.values.Value;
import org.uva.sea.ql.saving.QuestionnaireResultWriter;

public class State implements ActionListener {

	private final Map<Ident, Value> identifierEnvironment;
	private final Map<Ident, Observable> observables;
	
	public State() {
		identifierEnvironment = new HashMap<Ident, Value>();
		observables = new HashMap<Ident, Observable>();
	}

	public Map<Ident, Value> getIdentifierEnvironment() {
		return identifierEnvironment;
	}
	
	public Map<Ident, Observable> getObservables() {
		return observables;
	}
	
	public void putValue(Ident identifier, Value value) {
		identifierEnvironment.put(identifier, value);
	}
	
	public void addObserver(Ident identifier, Observer observer) {
		observables.get(identifier).addObserver(observer);
	}
	
	public void putObservable(Ident identifier, Observable observable) {
		observables.put(identifier, observable);
	}

	public void notify(Ident identifier) {
		observables.get(identifier).notifyObservers();		
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		QuestionnaireResultWriter questionnaireResultWriter = new QuestionnaireResultWriter();
		questionnaireResultWriter.saveResult(identifierEnvironment);
	}

}
