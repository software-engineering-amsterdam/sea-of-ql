package org.uva.sea.ql.ast.type;

public class Int implements Type{
	
	@Override
    public <ReturnType, ParameterType> 
		ReturnType accept(TypeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }
    
    @Override
    public boolean equals(Object obj) {
     return obj != null && obj.getClass() == Int.class;
    }

    @Override
    public int hashCode() {
        return Int.class.hashCode();
    }
}
