package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.ast.types.declarations.IntDeclaration;
import org.uva.sea.ql.ast.types.declarations.StringDeclaration;

public interface TypeVisitor {

	void visit(BooleanDeclaration booleanDeclaration);
	void visit(IntDeclaration intDeclaration);
	void visit(StringDeclaration stringDeclaration);
}
