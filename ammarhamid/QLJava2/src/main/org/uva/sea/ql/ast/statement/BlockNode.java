package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.visitor.StatementVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BlockNode implements Statement
{
    private final Collection<Statement> statements;

    public BlockNode()
    {
        this.statements = new ArrayList<>();
    }

    public void addStatement(final Statement statement)
    {
        this.statements.add(statement);
    }

    public Collection<Statement> getStatements()
    {
        return Collections.unmodifiableCollection(statements);
    }

    @Override
    public void accept(StatementVisitor statementVisitor)
    {
        statementVisitor.visit(this);
    }

    // TODO move this code to GUI interpreter
//    public Value evaluate()
//    {
//        for(final Node statement : statements)
//        {
//            statement.evaluate();
//        }
//        return null;
//    }

//    @Override
//    public String toTreeString(String indent)
//    {
//        final StringBuilder stringBuilder = new StringBuilder();
//        for(final Node statement : statements)
//        {
//            stringBuilder.append(statement.toTreeString(" ")).append("\n");
//        }
//        return stringBuilder.toString();
//    }
}
