package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.Statement;

import java.util.List;

public class Form implements Node {

    private final String formName;
    private final List<Statement> statements;

    public Form(String formName, List<Statement> statements) {
        this.formName = formName;
        this.statements = statements;
    }

    public String getName() {
        return formName;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitForm(this);
    }
}
