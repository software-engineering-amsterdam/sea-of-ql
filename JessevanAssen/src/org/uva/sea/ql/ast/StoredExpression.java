package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;

public class StoredExpression implements Statement {

    private final Identifier identifier;
    private final Expression expression;

    public StoredExpression(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Expression getExpression() { return expression; }
    public Identifier getIdentifier() { return identifier; }


    @Override
    public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
        return visitor.visit(this, param);
    }
}
