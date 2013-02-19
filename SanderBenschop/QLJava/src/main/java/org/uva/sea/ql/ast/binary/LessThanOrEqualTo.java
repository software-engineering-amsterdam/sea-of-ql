package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.ASTNodeVisitor;
import org.uva.sea.ql.semanticanalysis.SymbolTable;

public class LessThanOrEqualTo extends BinaryOperation {

    private final Type returningType;

    public LessThanOrEqualTo(QLExpression leftHandSide, QLExpression rightHandSide, SourceCodeInformation sourceInfo) {
        super(leftHandSide, rightHandSide, sourceInfo);
        this.returningType = new BooleanType();
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitLessThanOrEqualTo(this);
    }
}
