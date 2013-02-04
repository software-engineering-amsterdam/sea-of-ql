package org.uva.sea.ql.ast.expr;

public class Ident implements Expr {

	private final String name;

	public Ident(String name) {
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
	public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return visitor.visit(this, param);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Ident)) 
			return false;
		Ident ident = (Ident) obj;
		
		return this.getName().equals(ident.getName());
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
