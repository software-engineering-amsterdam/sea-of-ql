package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.NodeVisitor;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.general.symboltable.SymbolTable;

public final class Add extends BinaryOperation {

    public Add(Expression leftHandSide, Expression rightHandSide, SourceCodeInformation sourceCodeInformation) {
        super(leftHandSide, rightHandSide, sourceCodeInformation);
    }

    @Override
    public Type getType(SymbolTable symbolTable) {
        return new IntegerType();
    }

    @Override
    public <T> T accept(NodeVisitor<T> visitor) {
        return visitor.visitAdd(this);
    }
}
