package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public final class Str extends QLExpression {

    private final String value;

    public Str(String value, SourceCodeInformation sourceCodeInformation) {
        super(sourceCodeInformation);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new StringType();
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitStr(this);
    }
}
