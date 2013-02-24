package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.StringDeclaration;

public interface TypeVisitor {

	void visit(BooleanDeclaration booleanDeclaration);
	void visit(IntDeclaration intDeclaration);
	void visit(StringDeclaration stringDeclaration);
}
