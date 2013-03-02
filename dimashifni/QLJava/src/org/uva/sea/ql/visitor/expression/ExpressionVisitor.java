package org.uva.sea.ql.visitor.expression;

import org.uva.sea.ql.ast.expression.*;

/**
 * Created with IntelliJ IDEA.
 * User: dimashifni
 * Date: 2/27/13
 * Time: 11:52 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ExpressionVisitor<T> {
    T visit(Add node);
    T visit(And node);
    T visit(Div node);
    T visit(Eq node);
    T visit(GEq node);
    T visit(GT node);
    T visit(Ident node);
    T visit(Int node);
    T visit(Bool node);
    T visit(StringLiteral node);
    T visit(Money node);
    T visit(LEq node);
    T visit(LT node);
    T visit(Mul node);
    T visit(Neg node);
    T visit(NEq node);
    T visit(Not node);
    T visit(Or node);
    T visit(Pos node);
    T visit(Sub node);
}
