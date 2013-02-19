package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.primary.typeClasses.UndefinedType;
import org.uva.sea.ql.ast.sourcecodeinformation.NullSourceCodeInformation;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.semanticanalysis.SymbolTable;

public final class Ident extends QLExpression {

    private final String name;

    public Ident(String name) {
        this(name, new NullSourceCodeInformation());
    }

    public Ident(String name, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public Type getType(SymbolTable symbolTable) {
        if (symbolTable.containsIdentifier(this)) {
            return symbolTable.getIdentifier(this);
        }
        return new UndefinedType();
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitIdent(this);
    }
}
