package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;

public class StoredExpression implements Statement {

    private final Ident identifier;
    private final Expr expression;

    public StoredExpression(Ident identifier, Expr expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Expr getExpression() { return expression; }
    public Ident getIdentifier() { return identifier; }


    @Override
    public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }
}
