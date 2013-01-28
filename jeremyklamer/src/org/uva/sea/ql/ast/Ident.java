package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public class Ident extends Expr {

	private final String value;//TODO change to name

	public Ident(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public Value interpret() {
		return new StringVal(getValue());
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if(typeEnv.containsKey(this)){
			return typeEnv.get(this);
		}
		else{
			//TODO return error
			return null;
		}
		
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		return new ArrayList<Message>();
	}
	
	@Override
	public void fillIdents(Map<Ident, Type> input) {
		// TODO Auto-generated method stub
		super.fillIdents(input);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Ident)obj).getValue().equals(this.value);
	}
	
	@Override
	public int hashCode() { //TODO WIKI hashtables en hoe dit werkt. 
		// TODO Auto-generated method stub
		return value.hashCode();
	}
	
}
