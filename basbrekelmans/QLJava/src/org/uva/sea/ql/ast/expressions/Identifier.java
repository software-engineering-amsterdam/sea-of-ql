package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ICodeLocationInformation;
import org.uva.sea.ql.ast.IExpressionVisitor;

public class Identifier extends Simple {

	private final String name;
	
	public Identifier(ICodeLocationInformation codeLocation, String name) {
		super(codeLocation);
		this.name = name;
	}
	
	public Identifier(ICodeLocationInformation codeLocation, StringLiteral name) {
		super(codeLocation);
		this.name = name.getValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Identifier) {
			Identifier identifier = (Identifier)obj;
			return name.equals(identifier.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public String getName() {
		return name;
	}
	
	public <T> T accept(IExpressionVisitor<T> visitor)
	{
		return visitor.visit(this);
	}
}
