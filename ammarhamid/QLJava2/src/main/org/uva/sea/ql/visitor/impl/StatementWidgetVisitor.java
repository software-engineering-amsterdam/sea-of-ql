package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.ast.statement.AssignmentNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.IfNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

import javax.swing.*;
import java.util.Collection;

public class StatementWidgetVisitor implements StatementVisitor
{
    private final JPanel panel;

    public StatementWidgetVisitor(final JPanel panel)
    {
        this.panel = panel;
    }

    @Override
    public void visit(final AssignmentNode assignmentNode)
    {
        final String question = assignmentNode.getQuestion();
        final Type type = assignmentNode.getType();
        this.panel.add(new JLabel(question), "right");
        type.accept(new TypeWidgetVisitor(this.panel));
    }

    @Override
    public void visit(final BlockNode blockNode)
    {
        Collection<Statement> statements = blockNode.getStatements();
        for(Statement statement : statements)
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfNode ifNode)
    {
        // TODO
    }

    public JPanel getPanel()
    {
        return panel;
    }
}
