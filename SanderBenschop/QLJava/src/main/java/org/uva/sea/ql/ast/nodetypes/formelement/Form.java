package org.uva.sea.ql.ast.nodetypes.formelement;

import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class Form implements ASTNode {

    private final String formName;
    private final List<QLStatement> statements;

    public Form(String formName, List<QLStatement> statements) {
        this.formName = formName;
        this.statements = statements;
    }

    public String getName() {
        return formName;
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
