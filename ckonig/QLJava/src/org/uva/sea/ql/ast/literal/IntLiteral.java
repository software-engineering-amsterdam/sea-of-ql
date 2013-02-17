package org.uva.sea.ql.ast.literal;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.TreeNode;
import org.uva.sea.ql.common.Evaluatable;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.TreeVisitor;
import org.uva.sea.ql.common.VisitorException;

public class IntLiteral extends Expr implements Evaluatable, TreeNode {

    private final int value;

    public IntLiteral(int n) {
        this.value = n;
    }

    public final int getValue() {
        return this.value;
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
