package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class Block implements Statement {
    private final List<Statement> statements;

    public Block() {
        this.statements = new ArrayList<Statement>();
    }

    public void addStatement(Statement statement){
        this.statements.add(statement);
    }

    public List<Statement> getStatements(){
        return this.statements;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
