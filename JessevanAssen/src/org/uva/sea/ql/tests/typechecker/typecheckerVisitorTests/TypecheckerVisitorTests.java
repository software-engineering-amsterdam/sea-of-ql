package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.uva.sea.ql.typechecker.TypecheckerVisitor;

public abstract class TypecheckerVisitorTests {

	protected final TypecheckerVisitor visitor;
	protected final TypecheckerVisitor.Context context;
	
	public TypecheckerVisitorTests() {
		visitor = new TypecheckerVisitor();
		context = new TypecheckerVisitor.Context();
	}
	
}
