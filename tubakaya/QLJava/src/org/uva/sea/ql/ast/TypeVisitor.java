package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;

public interface TypeVisitor {

	void visit(BooleanType booleanDeclaration);
	void visit(IntType intDeclaration);
	void visit(StringType stringDeclaration);
}
