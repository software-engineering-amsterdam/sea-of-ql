package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;

public class TypeDefaultValueVisitor implements TypeVisitor{

	@Override
	public void visit(BooleanType booleanDeclaration) {
		
	}

	@Override
	public void visit(IntegerType intDeclaration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringType stringDeclaration) {
		// TODO Auto-generated method stub
		
	}

}
