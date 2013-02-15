package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.value.Value;

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

    // TODO move this code to GUI interpreter
//    public Value evaluate()
//    {
//        for(final Branch branch : branches)
//        {
//            final Value value = branch.evaluateExpression();
//            if(!value.isCompatibleToBoolean())
//            {
//                throw new RuntimeException("illegal boolean expression inside if-block: " + branch.exprNode.toTreeString(" "));
//            }
//
//            if(value.asBooleanValue().getValue())
//            {
//                return branch.block.evaluate();
//                return null;
//            }
//        }
//
//        return null;
//    }

//    @Override
//    public String toTreeString(final String indent)
//    {
//        final StringBuilder stringBuilder = new StringBuilder();
//        for(final Branch branch : branches)
//        {
//            stringBuilder.append(branch.exprNode.toTreeString(indent + "  "))
//                    .append(branch.block.toTreeString(indent + "  "));
//        }
//        return stringBuilder.toString();
//    }

    private class Branch
    {
        private final ExprNode exprNode;
        private final Node block;

        private Branch(final ExprNode exprNode, final Node block)
        {
            this.exprNode = exprNode;
            this.block = block;
        }

        private Value evaluateExpression()
        {
            return exprNode.evaluate();
        }
    }
}
