package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Computation extends QLStatement {

    private final Ident identifier;
    private final Str label;
    private final QLExpression expression;

    public Computation(Ident identifier, Str label, QLExpression expression) {
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

    public QLExpression getExpression() {
        return expression;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitComputation(this);
    }
}
