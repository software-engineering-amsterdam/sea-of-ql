package org.uva.sea.ql.visitor.impl;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
import org.uva.sea.ql.ast.statement.BlockNode;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.impl.AssignmentNode;
import org.uva.sea.ql.ast.statement.impl.ComputedNode;
import org.uva.sea.ql.ast.statement.impl.IfNode;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.StatementVisitor;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatementCheckVisitor implements StatementVisitor
{
    private final Collection<Message> errors;
    private final Set<IdentifierNode> declaredVariables;

    public StatementCheckVisitor(Collection<Message> errors)
    {
        this.errors = errors;
        this.declaredVariables = new HashSet<>();
    }

    @Override
    public void visit(AssignmentNode assignmentNode)
    {
        validateVariableName(assignmentNode.getIdentifierNode());
    }

    @Override
    public void visit(ComputedNode computedNode)
    {
        IdentifierNode identifierNode = computedNode.getIdentifierNode();
        validateVariableName(identifierNode);

        final ExprNode exprNode = computedNode.getExprNode();
        exprNode.validate(errors);
        Type computedNodeType = computedNode.getType();
        Type exprNodeType = exprNode.getType();
        boolean compatible = exprNodeType.isCompatibleTo(computedNodeType);
        if(!compatible)
        {
            this.errors.add(new Message("Mismatch computed type for " + identifierNode + ": "+ computedNodeType +" and "+ exprNodeType + ": ", exprNode));
        }
    }

    @Override
    public void visit(IfNode ifNode)
    {
        List<IfNode.Branch> branches = ifNode.getBranches();
        for(final IfNode.Branch branch : branches)
        {
            // validate expression
            final ExprNode exprNode = branch.getExprNode();
            exprNode.validate(errors);

            validateBlock(branch);
        }
    }

    private void validateBlock(IfNode.Branch branch)
    {
        final BlockNode block = branch.getBlock();
        final Collection<Statement> statements = block.getStatements();
        for(Statement statement : statements)
        {
            statement.accept(this);
        }
    }

    private void validateVariableName(IdentifierNode identifierNode)
    {
        if(this.declaredVariables.contains(identifierNode))
        {
            errors.add(new Message("Variable is already defined: ", identifierNode));
        }
        else
        {
            this.declaredVariables.add(identifierNode);
        }
    }
}
