package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Ident extends Leaf {
	private final String name;

	public Ident(String name, Location location) {
		super(location);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal;
		
		if (obj instanceof Ident) {
			equal = equals((Ident) obj);
		} else {
			equal = super.equals(obj);
		}
		
		return equal;
	}
	
	public boolean equals(Ident ident) {
		return getName().equals(ident.getName());
	}

}
