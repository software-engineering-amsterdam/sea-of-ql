package org.uva.sea.ql.ast.type;

public interface TypeVisitor<ReturnType, ParameterType> {
    public ReturnType visit(Bool    type, ParameterType param);
    public ReturnType visit(Int     type, ParameterType param);
    public ReturnType visit(Str     type, ParameterType param);
    public ReturnType visit(Unknown type, ParameterType param);
    public ReturnType visit(Void    type, ParameterType param);
}
