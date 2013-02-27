package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.StringType;

public interface TypeVisitor {

	void visit(BooleanType booleanDeclaration);
	void visit(IntegerType intDeclaration);
	void visit(StringType stringDeclaration);
}
