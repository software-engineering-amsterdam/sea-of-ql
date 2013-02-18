package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.statement.Statement;
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

}
