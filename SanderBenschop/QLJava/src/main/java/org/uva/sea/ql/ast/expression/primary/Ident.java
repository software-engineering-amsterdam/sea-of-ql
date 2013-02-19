package org.uva.sea.ql.ast.expression.primary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public final class Ident extends Expression {

    private final String name;

    public Ident(String name) {
        this(name, null);
    }

    public Ident(String name, SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        if (symbolTable.containsIdentifier(this)) {
            return symbolTable.getIdentifier(this);
        }
        return new UndefinedType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitIdent(this);
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
