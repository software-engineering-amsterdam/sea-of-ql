package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.Evaluatable;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.TreeVisitor;
import org.uva.sea.ql.common.VisitorException;

public class Ident extends Expr implements Evaluatable, TreeNode {

    private final String name;

    public Ident(String id) {
        this.name = id;
    }

    public final String getName() {
        return this.name;
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }

    @Override
    public void accept(TreeVisitor v) {
        v.visit(this);
    }

}
