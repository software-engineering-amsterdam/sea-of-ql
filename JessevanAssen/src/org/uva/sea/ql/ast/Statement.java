package org.uva.sea.ql.ast;

public interface Statement extends ASTNode {
    public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
