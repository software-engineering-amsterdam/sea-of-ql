package org.uva.sea.ql.ast.expression;

public class Identifier implements Expression {

	private final String name;

	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

    @Override
    public String toString() {
        return name;
    }

    @Override
	public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Identifier))
			return false;
		Identifier identifier = (Identifier) obj;
		
		return this.getName().equals(identifier.getName());
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
