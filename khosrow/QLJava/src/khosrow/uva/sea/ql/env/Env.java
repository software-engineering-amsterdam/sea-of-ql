package khosrow.uva.sea.ql.env;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.values.Value;

public class Env implements Iterable<Ident> {
	private final Map<Ident, TypeValuePair> symbolTable;
	
	public Env() {
		this.symbolTable = new HashMap<Ident, TypeValuePair>();
	}
	
	public boolean lookUpIdent(Ident name) {
		if (symbolTable.containsKey(name)) 
			return true;		
		return false;
	}
	
	public boolean lookUpValue(Ident name) {
		if (symbolTable.containsKey(name)) 
			return true;		
		return false;
	}
	
	public Type typeOf(Ident name) {
		return symbolTable.get(name).getType();
	}
	
	public Value valueOf(Ident name) {
		return symbolTable.get(name).getValue();
	}
	
	public void declareType(Ident name, Type type) {
		symbolTable.put(name, new TypeValuePair(type, type.initialize()));
	}
		
	public void assignValue(Ident name, Value value) {
		symbolTable.get(name).setValue(value);
	}
	
	public Map<Ident, TypeValuePair> getSymbolTable(){
		return symbolTable;
	}

	@Override
	public Iterator<Ident> iterator() {		
		return symbolTable.keySet().iterator();
	}
}
