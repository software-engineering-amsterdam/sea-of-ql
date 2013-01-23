package org.uva.sea.ql.ast.expressions;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.messages.Message;
import org.uva.sea.ql.messages.Error;

public class Ident extends Expr {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident))
			return false;
		return name.equals(((Ident)obj).name);
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type typeOf(Env environment) {
		return environment.typeOf(this);
	}
	
	@Override
	public List<Message> checkType(Env environment) {
		List<Message> errors = new ArrayList<Message>();
		
		if (environment.typeOf(this) == null) {
			errors.add(new Error("Ident " + name + " does not exist in current environment!"));
		}
		
		return errors;
	}

}
