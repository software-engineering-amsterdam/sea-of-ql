package khosrow.uva.sea.ql.env;

import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.values.Value;

public class TypeValuePair {
	private Type type;
	private Value value;
	
	public TypeValuePair(Type type, Value value){
		this.type = type;
		this.setValue(value);
	}

	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}
