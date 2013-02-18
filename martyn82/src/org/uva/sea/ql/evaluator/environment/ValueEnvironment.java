package org.uva.sea.ql.evaluator.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.Environment;

public class ValueEnvironment extends Environment {
	private final Map<IdentifierExpression, Bindable> bindings;

	public ValueEnvironment() {
		super();

		this.bindings = new HashMap<IdentifierExpression, Bindable>();
	}

	public Value lookup( IdentifierExpression identifier ) {
		if ( this.bindings.containsKey( identifier ) ) {
			return this.bindings.get( identifier ).getValue();
		}

		throw new RuntimeException( "Undefined variable: " + identifier.getName() );
	}

	public void assign( IdentifierExpression identifier, Value value ) {
		if ( !this.bindings.containsKey( identifier ) ) {
			this.bindings.put( identifier, new Bindable( value ) );
			return;
		}

		this.bindings.get( identifier ).setValue( value );
	}

	public Map<IdentifierExpression, Bindable> getBindings() {
		return this.bindings;
	}

	public void registerObserver( IdentifierExpression identifier, Observer observer ) {
		this.bindings.get( identifier ).addObserver( observer );
	}

	public void notifyObservers( IdentifierExpression identifier ) {
		this.bindings.get( identifier ).notifyObservers();
	}
}
