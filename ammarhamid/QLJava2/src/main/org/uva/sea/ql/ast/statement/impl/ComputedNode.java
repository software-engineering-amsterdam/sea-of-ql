package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

public class ComputedNode extends ObservableStatement
{
    private final String question;
    private final IdentifierNode identifierNode;
    private final ExprNode exprNode;

    public ComputedNode(String question, IdentifierNode identifierNode, ExprNode exprNode)
    {
        this.question = question;
        this.identifierNode = identifierNode;
        this.exprNode = exprNode;
    }

    @Override
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

    public ExprNode getExprNode()
    {
        return exprNode;
    }
}
