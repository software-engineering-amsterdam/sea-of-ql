package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;

public class Ident extends Expr {

	private final String name;//TODO change to name

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Value interpret() {
		return new StringVal(this.name);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if(typeEnv.containsKey(this)){
			return typeEnv.get(this);
		}
		else{
			return new UndefinedType();
		}
		
	}

	@Override
	public List<Message> checkType(Map<Ident, Type> typeEnv) {
		List<Message> errors = new ArrayList<Message>(); 
		
			if(typeEnv.containsKey(this.name)){
				
			}
		
		return errors; 
	}
	
	@Override
	public void fillIdents(Map<Ident, Type> input) {
		super.fillIdents(input);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Ident)obj).getName().equals(this.name);
	}
	
	@Override
	public int hashCode() { 
		return name.hashCode();
	}
	
}
