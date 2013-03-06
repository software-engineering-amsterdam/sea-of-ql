package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;

public class TypeDefaultValueVisitor implements TypeVisitor<QLValue>{

	@Override
	public QLValue visit(BooleanType booleanDeclaration) {
		return new BooleanLiteral(false);
	}

	@Override
	public QLValue visit(IntegerType intDeclaration) {
		return new IntLiteral(0);
	}

	@Override
	public QLValue visit(StringType stringDeclaration) {
		return new StringLiteral("");
	}

}
