package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.typechecker.TypecheckerVisitor;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.expr.Ident;

public abstract class TypecheckerVisitorTests {

	protected final TypecheckerVisitor visitor;
	protected final Map<Ident, Type> symbolTable;
	
	public TypecheckerVisitorTests() {
		visitor = new TypecheckerVisitor();
		symbolTable = new HashMap<Ident, Type>();
	}
	
}
