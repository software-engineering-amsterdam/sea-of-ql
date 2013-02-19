package visitor.evaluator;

import java.util.Observable;

import ast.Type;
import ast.expression.Value;


public class Bindable extends Observable {

	private Type type;
	private Value value;
	private boolean defined = false;
	private boolean changed = false; // used for updating

	public Bindable( Type type) {
		this.type = type;
		this.value = type.accept(new TypeEvaluator());
	}

	public void setValue( Value value ) {
		this.value = value;
		this.changed = true;
		this.defined = true;
	}

	public Type getType() {
		return this.type;
	}

	public Value getValue() {
		return this.value;
	}

	public boolean isDefined() {
		return defined;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setType(Type type) {
		this.type = type;
		this.changed = true;		
	}
}
