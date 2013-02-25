package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.identfinder.RecursiveIdentVisitor;

public class Ident extends Expr implements TreeNode {

    private final StringLiteral name;

    public Ident(StringLiteral id) {
        this.name = id;
    }

    public final StringLiteral getName() {
        return this.name;
    }

    @Override
    public final void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }

    @Override
    public final void accept(RecursiveIdentVisitor v) {
        v.visit(this);
    }

    @Override
    public final String toString() {
        return this.name.getValue();
    }

}
