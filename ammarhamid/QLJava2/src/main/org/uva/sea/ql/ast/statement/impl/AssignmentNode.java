package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class AssignmentNode implements Statement
{
    private final String question;
    private final IdentifierNode identifierNode;
    private final Type type;

    public AssignmentNode(final String question, final String identifier, final Type type)
    {
        this.question = question;
        this.identifierNode = new IdentifierNode(identifier);
        this.identifierNode.setType(type);
        this.type = type;
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
        return type;
    }

}
