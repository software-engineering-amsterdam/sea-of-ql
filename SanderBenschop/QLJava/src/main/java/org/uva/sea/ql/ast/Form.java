package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

import java.util.List;

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
