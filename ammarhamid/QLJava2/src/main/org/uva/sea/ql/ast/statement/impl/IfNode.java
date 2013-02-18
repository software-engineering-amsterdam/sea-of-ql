package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class IfNode implements Statement
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
    public void accept(StatementVisitor statementVisitor)
    {
        statementVisitor.visit(this);
    }

    public List<Branch> getBranches()
    {
        return branches;
    }

    public class Branch
    {
        private final ExprNode exprNode;
        private final Node block;

        private Branch(final ExprNode exprNode, final Node block)
        {
            this.exprNode = exprNode;
            this.block = block;
        }

        public Value evaluateExpression()
        {
            return exprNode.evaluate();
        }

        public ExprNode getExprNode()
        {
            return exprNode;
        }

        public Node getBlock()
        {
            return block;
        }
    }
}
