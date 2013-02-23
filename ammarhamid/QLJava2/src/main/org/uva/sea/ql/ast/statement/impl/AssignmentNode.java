package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class AssignmentNode implements Statement
{
    private final String question;
    private final IdentifierNode identifierNode;

    public AssignmentNode(final String question, final IdentifierNode identifierNode)
    {
        this.question = question;
        this.identifierNode = identifierNode;
    }

    public void accept(final StatementVisitor statementVisitor)
    {
        statementVisitor.visit(this);
    }

    public String getQuestion()
    {
        return question;
    }

    public IdentifierNode getIdentifierNode()
    {
        return identifierNode;
    }

    public Type getType()
    {
        return this.identifierNode.getType();
    }

}
