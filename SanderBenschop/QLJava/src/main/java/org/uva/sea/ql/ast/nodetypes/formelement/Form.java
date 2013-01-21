package org.uva.sea.ql.ast.nodetypes.formelement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;

import java.util.List;

public class Form implements ASTNode {

    private final String formName;
    private final List<QLStatement> statements;

    public Form(String formName, List<QLStatement> statements) {
        this.formName = formName;
        this.statements = statements;
    }

    public List<QLStatement> getStatements() {
        return statements;
    }

    @Override
    public void accept(ASTNodeVisitor visitor) {
        for (QLStatement statement : statements) {
            statement.accept(visitor);
        }
    }
}
