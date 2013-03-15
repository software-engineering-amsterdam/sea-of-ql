package org.uva.sea.ql.ast.expression;

public abstract class Variable implements Expression {
	private final Identifier id;
	
	public Identifier getID() {
		return id;
	}
	
	public Variable(Identifier id) {
		this.id = id;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Variable guest = (Variable) obj;
        return id == guest.id;
    }
	
	protected abstract boolean setPrimitive(Primitive p);
	
	public void bind(Primitive bound_primitive) {
		if ( ! setPrimitive(bound_primitive) ) {
			throw new RuntimeTypeError();
		}
	}
	
	@Override
    public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		
		return result;
	}
	
}
