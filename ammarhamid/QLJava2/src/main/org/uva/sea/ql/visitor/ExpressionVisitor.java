package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.impl.*;

public interface ExpressionVisitor<T>
{
    T visit(AddNode addNode);
    T visit(AndNode andNode);
    T visit(DivideNode divideNode);
    T visit(EqualNode equalNode);
    T visit(GreaterEqualNode greaterEqualNode);
    T visit(GreaterThanNode greaterThanNode);
    T visit(IdentifierNode identifierNode);
    T visit(LessEqualNode lessEqualNode);
    T visit(LessThanNode lessThanNode);
    T visit(MultiplyNode multiplyNode);
    T visit(NegateNode negateNode);
    T visit(NotEqualNode notEqualNode);
    T visit(NotNode notNode);
    T visit(OrNode orNode);
    T visit(SubtractNode subtractNode);
    T visit(ValueNode valueNode);
}
