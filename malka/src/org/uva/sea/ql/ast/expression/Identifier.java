package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

// TODO should this really be expression??
public class Identifier implements Expression {
	private static final int HASHCODE_CONSTANT = 1;	
	private final String name;
	
	public Identifier(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}
	
	@Override
    public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        return getName().equals(((Identifier)obj).getName());
	}
	
	public int hashCode() {
		return HASHCODE_CONSTANT;
	}

	@Override
	public int compareTo(Expression o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
