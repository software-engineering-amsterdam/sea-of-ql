package org.uva.sea.ql.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.ast.expressions.Ident;

public class State {
	private final Map<Ident, AValue> valEnv;
	private final Map<Ident, Observable> observables;
	
	public State() {
		this.valEnv = new HashMap<Ident, AValue>();
		this.observables = new HashMap<Ident, Observable>();
	}
}