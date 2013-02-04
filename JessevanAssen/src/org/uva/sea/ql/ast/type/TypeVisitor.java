package org.uva.sea.ql.ast.type;

public interface TypeVisitor<ReturnType, ParameterType> {
    public ReturnType visit(Boolean type, ParameterType param);
    public ReturnType visit(Integer type, ParameterType param);
    public ReturnType visit(String type, ParameterType param);
    public ReturnType visit(Unknown type, ParameterType param);
}
