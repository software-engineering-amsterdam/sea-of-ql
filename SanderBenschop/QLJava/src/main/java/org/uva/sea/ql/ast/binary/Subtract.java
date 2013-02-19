package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.semanticanalysis.SymbolTable;

public class Subtract extends BinaryOperation {

    private final Type returningType;

    public Subtract(QLExpression leftHandSide, QLExpression rightHandSide, SourceCodeInformation sourceInfo) {
        super(leftHandSide, rightHandSide, sourceInfo);
        this.returningType = new IntegerType();
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitSubtract(this);
    }
}
