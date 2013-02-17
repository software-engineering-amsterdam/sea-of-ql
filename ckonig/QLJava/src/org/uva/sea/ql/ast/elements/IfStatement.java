package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.VisitorException;

public class IfStatement extends BlockElement {
    private Expr condition;
    private Block content;

    public IfStatement(Expr cond, Block block) {
        this.condition = cond;
        this.content = block;
    }

    public final Expr getCondition() {
        return this.condition;
    }

    public final Block getContent() {
        return this.content;
    }

    @Override
    public final void accept(ElementVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }
}
