package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public class Subtract extends BinaryOperation {

    public Subtract(QLExpression leftHandSide, QLExpression rightHandSide, SourceCodeInformation sourceCodeInformation) {
        super(leftHandSide, rightHandSide, sourceCodeInformation);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitSubtract(this);
    }
}
