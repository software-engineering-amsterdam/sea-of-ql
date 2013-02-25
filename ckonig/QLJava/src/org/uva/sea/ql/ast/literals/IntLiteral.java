package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Expression;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.identfinder.RecursiveIdentVisitor;

public class IntLiteral extends Expr implements Expression, TreeNode {

    private final int value;

    public IntLiteral(int n) {
        this.value = n;
    }

    public final int getValue() {
        return this.value;
    }

    @Override
    public final void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }

    @Override
    public final void accept(RecursiveIdentVisitor v) {
        v.visit(this);
    }
}
