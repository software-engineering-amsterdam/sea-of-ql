package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.ASTNode;

public interface Expr extends ASTNode {
    public <ReturnType, ParameterType> ReturnType accept(ExprVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
