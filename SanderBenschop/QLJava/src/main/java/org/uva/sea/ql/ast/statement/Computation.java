package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Str;

public class Computation extends Statement {

    private final Ident identifier;
    private final Str label;
    private final Expression expression;

    public Computation(Ident identifier, Str label, Expression expression) {
        this.identifier = identifier;
        this.label = label;
        this.expression = expression;
    }

    public Ident getIdentifier() {
        return identifier;
    }

    public Str getLabel() {
        return label;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitComputation(this);
    }
}
