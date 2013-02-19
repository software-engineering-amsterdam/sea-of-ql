package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {

    private final Ident identifier;
    private final Str label;
    private final Type datatype;

    public Question(Ident identifier, Str label, Type datatype) {
        this.identifier = identifier;
        this.label = label;
        this.datatype = datatype;
    }

    public Ident getIdentifier() {
        return identifier;
    }

    public Str getLabel() {
        return label;
    }

    public Type getDatatype() {
        return datatype;
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitQuestion(this);
    }
}
