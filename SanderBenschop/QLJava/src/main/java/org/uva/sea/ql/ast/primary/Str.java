package org.uva.sea.ql.ast.primary;

import org.uva.sea.ql.ast.primary.typeClasses.StringType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.typechecking.SymbolTable;

public final class Str extends Datatype<String> {

	private final String value;
	private final Type returningType;

	public Str(String value) {
		this.value = value;
        this.returningType = new StringType();
	}
	
	@Override
	public String getValue() {
		return value;
	}

    @Override
    public Type getType(SymbolTable symbolTable) {
        return returningType;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visitStr(this);
    }
}
