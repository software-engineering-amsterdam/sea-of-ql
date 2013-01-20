package org.uva.sea.ql.ast.nodetypes.formelement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

import java.util.List;

public class Form implements ASTNode {

	private final Ident identifierName;
	private final List<QLStatement> statements;

	public Form(Ident identifierName, List<QLStatement> statements) {
		this.identifierName = identifierName;
		this.statements = statements;
	}

	public Ident getIdentifier() {
		return identifierName;
	}

	public List<QLStatement> getStatements() {
		return statements;
	}

    @Override
    public void accept(ASTNodeVisitor visitor) {
        identifierName.accept(visitor);
        for (QLStatement statement : statements) {
            statement.accept(visitor);
        }
    }
}
