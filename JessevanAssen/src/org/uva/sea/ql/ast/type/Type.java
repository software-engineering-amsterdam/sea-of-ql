package org.uva.sea.ql.ast.type;

public interface Type {
    public <ReturnType, ParameterType> ReturnType accept(TypeVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
