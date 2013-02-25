package org.uva.sea.ql.evaluate.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.evaluate.Environment;
import org.uva.sea.ql.value.Value;

public class BindingEnvironment extends Environment<Value> {
	private final Map<IdentifierExpression, Binding> bindings;

	public BindingEnvironment() {
		super();
		this.bindings = new HashMap<IdentifierExpression, Binding>();
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
			this.bindings.put( identifier, new Binding( value ) );
			return;
		}

		this.bindings.get( identifier ).setValue( value );
	}

	@Override
	public boolean isDeclared( IdentifierExpression identifier ) {
		return this.bindings.containsKey( identifier );
	}

	public ValueMap getValueMap() {
		ValueMap values = new ValueMap();
		Binding binding;

		for ( Map.Entry<IdentifierExpression, Binding> each : this.bindings.entrySet() ) {
			binding = each.getValue();
			values.add( each.getKey().getName(), binding.getValue() );
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
