package org.uva.sea.ql.ast.elements;

import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.common.ElementVisitor;
import org.uva.sea.ql.common.QLException;

public class Question extends BlockElement {
    private StringLiteral content;
    private Type type;
    private Ident ident;

    public Question(Ident i, StringLiteral s, Type t) {
        this.ident = i;
        this.content = s;
        this.type = t;
    }

    public final StringLiteral getContent() {
        return this.content;
    }

    public final Ident getIdent() {
        return this.ident;
    }

    public final String getIdentName() {
        return this.ident.getName();
    }

    public final Type getType() {
        return this.type;
    }

    @Override
    public final void accept(ElementVisitor visitor) throws QLException {
        visitor.visit(this);
    }

}
