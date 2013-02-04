package org.uva.sea.ql.ast;

public interface Statement {
    public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
