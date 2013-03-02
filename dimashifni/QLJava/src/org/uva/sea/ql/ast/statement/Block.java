package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.statement.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
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
