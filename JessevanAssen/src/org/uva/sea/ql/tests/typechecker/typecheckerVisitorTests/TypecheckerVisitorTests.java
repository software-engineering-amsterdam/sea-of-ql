package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.uva.sea.ql.typechecker.TypecheckerVisitor;

public abstract class TypecheckerVisitorTests {

	protected final TypecheckerVisitor visitor;
	
	public TypecheckerVisitorTests() {
		visitor = new TypecheckerVisitor();
	}
	
}
