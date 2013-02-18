package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.semanticanalysis.SymbolTable;

public class Not extends UnaryOperation {

    private final Type returningType;

	public Not(QLExpression expression, SourceCodeInformation sourceInfo) {
		super(expression, sourceInfo);
        this.returningType = new BooleanType();
	}

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}