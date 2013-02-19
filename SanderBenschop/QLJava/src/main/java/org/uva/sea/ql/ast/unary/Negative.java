package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public class Negative extends UnaryOperation {

    public Negative(QLExpression expression, SourceCodeInformation sourceCodeInformation) {
        super(expression, sourceCodeInformation);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitNegative(this);
    }
}
