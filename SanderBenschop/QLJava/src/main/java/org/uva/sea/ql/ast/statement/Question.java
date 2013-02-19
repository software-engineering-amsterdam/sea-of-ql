package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.type.Type;

public class Question extends QLStatement {

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
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitQuestion(this);
    }
}
