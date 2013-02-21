package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.interpretation.TreeVisitor;

public class Ident extends Expr implements Evaluatable, TreeNode {

    private final String name;

    public Ident(String id) {
        this.name = id;
    }

    public final String getName() {
        return this.name;
    }

    @Override
    public void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }

    @Override
    public void accept(TreeVisitor v) {
        v.visit(this);
    }

}
