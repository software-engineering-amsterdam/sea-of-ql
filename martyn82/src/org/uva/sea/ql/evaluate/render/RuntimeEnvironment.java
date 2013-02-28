package org.uva.sea.ql.evaluate.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.evaluate.Environment;
import org.uva.sea.ql.value.Value;

public class RuntimeEnvironment extends Environment<Value> {
	private final Map<IdentifierExpression, Variable> bindings;

	public RuntimeEnvironment() {
		super();
		this.bindings = new HashMap<IdentifierExpression, Variable>();
	}

	@Override
	public Value lookup( IdentifierExpression identifier ) {
		if ( this.bindings.containsKey( identifier ) ) {
			return this.bindings.get( identifier ).getValue();
		}

		throw new RuntimeException( "Undefined variable: " + identifier.getName() );
	}

	@Override
	public void declare( IdentifierExpression identifier, Value value ) {
		if ( !this.isDeclared( identifier ) ) {
			this.bindings.put( identifier, new Variable( value ) );
			return;
		}

		this.bindings.get( identifier ).setValue( value );
	}

	@Override
	public boolean isDeclared( IdentifierExpression identifier ) {
		return this.bindings.containsKey( identifier );
	}

	public RuntimeValueMap getValueMap() {
		RuntimeValueMap values = new RuntimeValueMap();
		Variable variable;

		for ( Map.Entry<IdentifierExpression, Variable> each : this.bindings.entrySet() ) {
			variable = each.getValue();
			values.add( each.getKey().getName(), variable.getValue() );
		}

		return values;
	}

	public void registerObserver( IdentifierExpression identifier, Observer observer ) {
		this.bindings.get( identifier ).addObserver( observer );
	}

	public void notifyObservers( IdentifierExpression identifier ) {
		this.bindings.get( identifier ).notifyObservers();
	}
}
