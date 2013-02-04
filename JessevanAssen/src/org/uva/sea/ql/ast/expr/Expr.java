package org.uva.sea.ql.ast.expr;

public interface Expr {
    public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
