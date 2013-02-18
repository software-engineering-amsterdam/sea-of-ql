package org.uva.sea.ql.ast.expr.value;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public Value eval(Env env) {
		if(env.containsValue(this)){
			return env.getValue(this);
		}
		return env.getType(this).getDefaultValue();
	}

	@Override
	public Type typeOf(Env env) {
		if(env.containsType(this)){
			return env.getType(this);
		}
		return new UndefinedType();
	}

	@Override
	public List<Message> checkType(Env env) {
		List<Message> errors = new ArrayList<Message>(); 
		if(!(env.containsType(this))){
			errors.add(new Error("Identity for : " + name + " has not been initialized."));
		}			
		return errors; 
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Ident)obj).getName().equals(name);
	}
	
	@Override
	public int hashCode() { 
		return this.name.hashCode();
	}
	
}
