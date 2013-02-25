package org.uva.sea.ql.visitor.dependency;

import org.uva.sea.ql.ast.expression.BinaryNode;
import org.uva.sea.ql.ast.expression.ExprNode;
import org.uva.sea.ql.ast.expression.UnaryNode;
import org.uva.sea.ql.ast.expression.impl.*;
import org.uva.sea.ql.ast.statement.ObservableStatement;
import org.uva.sea.ql.variable.VariableState;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionDependencyVisitor implements ExpressionVisitor<Void>
{
    private final VariableState variableState;
    private final ObservableStatement observableStatement;

    private ExpressionDependencyVisitor(final ObservableStatement observableStatement, final VariableState variableState)
    {
        this.observableStatement = observableStatement;
        this.variableState = variableState;
    }

    public static void find(final ExprNode exprNode, final ObservableStatement observableStatement, final VariableState variableState)
    {
        final ExpressionDependencyVisitor expressionDependencyVisitor = new ExpressionDependencyVisitor(observableStatement, variableState);
        exprNode.accept(expressionDependencyVisitor);
    }

    @Override
    public Void visit(final AddNode addNode)
    {
        visitBinaryNode(addNode);
        return null;
    }

    @Override
    public Void visit(AndNode andNode)
    {
        visitBinaryNode(andNode);
        return null;
    }

    @Override
    public Void visit(OrNode orNode)
    {
        visitBinaryNode(orNode);
        return null;
    }

    @Override
    public Void visit(DivideNode divideNode)
    {
        visitBinaryNode(divideNode);
        return null;
    }

    @Override
    public Void visit(EqualNode equalNode)
    {
        visitBinaryNode(equalNode);
        return null;
    }

    @Override
    public Void visit(GreaterEqualNode greaterEqualNode)
    {
        visitBinaryNode(greaterEqualNode);
        return null;
    }

    @Override
    public Void visit(GreaterThanNode greaterThanNode)
    {
        visitBinaryNode(greaterThanNode);
        return null;
    }

    @Override
    public Void visit(IdentifierNode identifierNode)
    {
        this.variableState.putObservable(identifierNode, this.observableStatement);
        return null;
    }

    @Override
    public Void visit(LessEqualNode lessEqualNode)
    {
        visitBinaryNode(lessEqualNode);
        return null;
    }

    @Override
    public Void visit(LessThanNode lessThanNode)
    {
        visitBinaryNode(lessThanNode);
        return null;
    }

    @Override
    public Void visit(MultiplyNode multiplyNode)
    {
        visitBinaryNode(multiplyNode);
        return null;
    }

    @Override
    public Void visit(NegateNode negateNode)
    {
        visitUnaryNode(negateNode);
        return null;
    }

    @Override
    public Void visit(NotEqualNode notEqualNode)
    {
        visitBinaryNode(notEqualNode);
        return null;
    }

    @Override
    public Void visit(NotNode notNode)
    {
        visitUnaryNode(notNode);
        return null;
    }

    @Override
    public Void visit(SubtractNode subtractNode)
    {
        visitBinaryNode(subtractNode);
        return null;
    }

    @Override
    public Void visit(ValueNode valueNode)
    {
        return null;
    }

    private void visitBinaryNode(BinaryNode binaryNode)
    {
        ExprNode lhs = binaryNode.getLhs();
        ExprNode rhs = binaryNode.getRhs();
        lhs.accept(this);
        rhs.accept(this);
    }

    private void visitUnaryNode(UnaryNode unaryNode)
    {
        ExprNode exprNode = unaryNode.getExprNode();
        exprNode.accept(this);
    }
}
                                                                                                   