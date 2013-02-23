package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.StringDeclaration;

public interface TypeVisitor {

	boolean visit(BooleanDeclaration booleanDeclaration);
	boolean visit(IntDeclaration intDeclaration);
	boolean visit(StringDeclaration stringDeclaration);
}
