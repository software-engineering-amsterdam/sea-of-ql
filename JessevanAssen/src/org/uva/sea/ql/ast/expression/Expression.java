package org.uva.sea.ql.ast.expression;

public interface Expression {
    public <ReturnType, ParameterType> ReturnType accept(ExpressionVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
