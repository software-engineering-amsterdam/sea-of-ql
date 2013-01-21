package org.uva.sea.ql.ast.nodetypes.primary;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public final class Ident implements ASTNode {

    private final String name;

    public Ident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ASTNodeVisitor visitor) {
        visitor.visitIdent(this);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Ident)) {
            return false;
        } else {
            Ident otherIdent = (Ident) other;
            return hashCode() == otherIdent.hashCode();
        }
    }
}
