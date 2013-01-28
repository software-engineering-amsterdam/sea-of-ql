package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.value.ValueNode;

import java.util.ArrayList;
import java.util.List;

public class IfNode implements Node
{
    private final List<Branch> branches;

    public IfNode()
    {
        this.branches = new ArrayList<>();
    }

    public void addBranch(final ExprNode exprNode, final Node block)
    {
        this.branches.add(new Branch(exprNode, block));
    }

    @Override
    public ValueNode evaluate()
    {
        for(final Branch branch : branches)
        {
            ValueNode valueNode = branch.exprNode.evaluate();
            if(!valueNode.isBooleanNode())
            {
                throw new RuntimeException("illegal boolean expression inside if-block: " + branch.exprNode.toTreeString(" "));
            }

            if(valueNode.asBooleanNode().getValue())
            {
                return branch.block.evaluate();
            }
        }

        return ValueNode.VOID;
    }

    @Override
    public String toTreeString(String indent)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        for(final Branch branch : branches)
        {
            stringBuilder.append(branch.exprNode.toTreeString(indent + "  "))
                    .append(branch.block.toTreeString(indent + "  "));
        }
        return stringBuilder.toString();
    }

    private class Branch
    {
        private final ExprNode exprNode;
        private final Node block;

        private Branch(final ExprNode exprNode, final Node block)
        {
            this.exprNode = exprNode;
            this.block = block;
        }
    }
}
