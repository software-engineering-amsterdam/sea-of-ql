package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.typechecking.SymbolTable;

public final class Bool extends Datatype<Boolean> {

	private final boolean value;
	private final Type returningType;

	public Bool(boolean value, SourceCodeInformation sourceInfo) {
        super(sourceInfo);
		this.value = value;
        this.returningType = new BooleanType();
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitBool(this);
    }
}
