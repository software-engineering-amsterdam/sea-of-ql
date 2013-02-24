package org.uva.sea.ql.ast.form;

import org.uva.sea.ql.ast.expression.Expr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.ast.misc.Location;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class Computed extends Question {
	private final Expr expression;
	private final Location endLocation;
	
	public Computed(Ident name, String label, Type type,
			Expr expression, Location endLocation)
	{
		super(name, label, type);
		this.expression = expression;
		this.endLocation = endLocation;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public <T> T accept(FormVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public Location getLocation() {
		return new Location(super.getLocation(), endLocation);
	}
	
}
