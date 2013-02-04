package org.uva.sea.ql.ast.type;

public class String implements Type {
    @Override
    public <ReturnType, ParameterType> ReturnType accept(TypeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }
    
    @Override
    public boolean equals(Object obj) {
    	return obj != null && obj.getClass() == String.class;
    }

    @Override
    public int hashCode() {
        return String.class.hashCode();
    }

    @Override
    public java.lang.String toString() {
        return "string";
    }
}
