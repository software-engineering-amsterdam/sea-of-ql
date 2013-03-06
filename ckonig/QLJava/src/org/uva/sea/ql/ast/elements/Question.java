package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.AbstractType;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;

public class Question extends AbstractBlockElement {
    private StringLiteral content;
    private AbstractType type;
    private Ident ident;
    private Expr condition;

    public Question(Ident i, StringLiteral s, AbstractType t) {
        this.ident = i;
        this.content = s;
        this.type = t;
    }

    public Question(Ident i, StringLiteral s, AbstractType t, Expr e) {
        this(i, s, t);
        this.condition = e;
    }

    public final StringLiteral getContent() {
        return this.content;
    }

    public final StringLiteral getIdentName() {
        return this.ident.getName();
    }

    public final AbstractType getType() {
        return this.type;
    }

    public final Expr getCondition() {
        return this.condition;
    }

    public final boolean hasAutoValue() {
        return this.condition != null;
    }

    @Override
    public final void accept(ElementVisitor visitor) throws QLException {
        visitor.visit(this);
    }

}
