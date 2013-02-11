package org.uva.sea.ql.ast.expressions;

import java.util.List;
import java.util.Set;

import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.messages.*;

public abstract class Expr implements ASTNode {
	
	public abstract Value eval(Env environment);
	
	public abstract Type typeOf(Env environment);
	public abstract Set<Type> allowedArgumentTypes();
	
	public abstract List<Message> checkType(Env environment);
	
	protected String getPrintableAllowedTypes() {
		int i = 0;
		String printableString = "";
		for (Type t : allowedArgumentTypes()) {
			if (i > 0)
				printableString += ", ";
			printableString += t;
			i++;
		}
		return printableString;
	}
	
	public String getName() {
		return getClass().toString();
	}
}
