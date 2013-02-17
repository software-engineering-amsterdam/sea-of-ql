package khosrow.uva.sea.ql.env;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.values.Value;

public class Env implements Iterable<TypeValuePair> {
	private final Map<Ident, TypeValuePair> typeAndValues;
	
	public Env() {
		this.typeAndValues = new HashMap<Ident, TypeValuePair>();
	}
	
	public boolean lookUpIdent(Ident name) {
		if (typeAndValues.containsKey(name)) 
			return true;		
		return false;
	}
	
	public boolean lookUpValue(Ident name) {
		if (typeAndValues.containsKey(name)) 
			return true;		
		return false;
	}
	
	public Type typeOf(Ident name) {
		return typeAndValues.get(name).getType();
	}
	
	public Value valueOf(Ident name) {
		return typeAndValues.get(name).getValue();
	}
	
	public void declareType(Ident name, Type type) {
		typeAndValues.put(name, new TypeValuePair(type, type.initialize()));
	}
		
	public void assignValue(Ident name, Value value) {
		typeAndValues.get(name).setValue(value);
	}
	
	public Map<Ident, TypeValuePair> getTypeAndValues(){
		return typeAndValues;
	}

	@Override
	public Iterator<TypeValuePair> iterator() {		
		return typeAndValues.values().iterator();
	}
}
