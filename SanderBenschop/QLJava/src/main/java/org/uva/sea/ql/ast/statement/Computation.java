package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Computation implements QLStatement {

	private final Ident identifier;
    private final Str label;
	private final ASTNode expression;

	public Computation(Ident identifier, Str label, ASTNode expression) {
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

	public ASTNode getExpression() {
		return expression;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        identifier.accept(visitor);
        expression.accept(visitor);
        visitor.visitComputation(this);
    }
}
