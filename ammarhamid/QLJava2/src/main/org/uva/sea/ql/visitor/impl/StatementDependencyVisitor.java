package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.ComputedNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.StatementVisitor;

public class StatementDependencyVisitor implements StatementVisitor
{
    private final VariableState variableState;

    public StatementDependencyVisitor(final VariableState variableState)
    {
        this.variableState = variableState;
    }

    @Override
    public void visit(final AssignmentNode assignmentNode)
    {
        // do nothing
    }

    @Override
    public void visit(final ComputedNode computedNode)
    {
        ExpressionDependencyVisitor.find(computedNode.getExprNode(), computedNode, this.variableState);
    }

    @Override
    public void visit(final IfNode ifNode)
    {
        for(final IfNode.Branch branch : ifNode.getBranches())
        {
            ExpressionDependencyVisitor.find(branch.getExprNode(), ifNode, this.variableState);

            final BlockNode block = branch.getBlock();
            for(final Statement statement : block.getStatements())
            {
                statement.accept(this);
            }
        }
    }

}
