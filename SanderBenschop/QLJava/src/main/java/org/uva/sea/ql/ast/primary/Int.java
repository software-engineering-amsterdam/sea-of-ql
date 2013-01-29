package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.typechecking.SymbolTable;

public final class Int extends Datatype<Integer> {

	private final int value;
    private final Type returningType;

	public Int(int value) {
		this.value = value;
        this.returningType = new IntegerType();
	}

	@Override
	public Integer getValue() {
		return value;
	}

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitInt(this);
    }
}
