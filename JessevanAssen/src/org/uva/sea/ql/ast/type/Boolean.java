package org.uva.sea.ql.ast.type;

public class Boolean implements Type {
    @Override
    public <ReturnType, ParameterType> ReturnType accept(TypeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }
    
    @Override
    public boolean equals(Object obj) {
    	return obj != null && obj.getClass() == Boolean.class;
    }

    @Override
    public int hashCode() {
        return Boolean.class.hashCode();
    }

    @Override
    public java.lang.String toString() {
        return "boolean";
    }
}
