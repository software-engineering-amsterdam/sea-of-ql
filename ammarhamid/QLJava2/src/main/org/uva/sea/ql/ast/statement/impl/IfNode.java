package org.uva.sea.ql.ast.statement.impl;

import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class IfNode extends ObservableStatement
{
    private final List<Branch> branches;

    public IfNode()
    {
        this.branches = new ArrayList<>();
    }

    @Override
    public void notifyObs()
    {
        setChanged();
        this.notifyObservers();
    }

    public void addBranch(final ExprNode exprNode, final BlockNode block)
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
        private final BlockNode block;

        private Branch(final ExprNode exprNode, final BlockNode block)
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

        public BlockNode getBlock()
        {
            return block;
        }
    }
}
