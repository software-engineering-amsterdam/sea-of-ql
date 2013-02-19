package org.uva.sea.ql.ast.expression.primary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.SymbolTableImpl;

public final class Str extends Expression {

    private final String value;

    public Str(String value, SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getType(SymbolTableImpl symbolTable) {
        return new StringType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitStr(this);
    }
}
