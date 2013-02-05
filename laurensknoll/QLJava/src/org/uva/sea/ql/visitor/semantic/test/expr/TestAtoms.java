package org.uva.sea.ql.visitor.semantic.test.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;

public class TestAtoms {

	private Expression visitor;

	public TestAtoms() {
		// Create an environment with registered identifiers.
		Environment env = new Environment();
		env.declare(new Ident("bool"), new org.uva.sea.ql.ast.type.Bool());
		env.declare(new Ident("int"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("money"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("string"), new org.uva.sea.ql.ast.type.String());

		this.visitor = new Expression(env);
	}

	@Test
	public void testBools() {
		assertEquals(true, visitor.visit(new Bool(false)));
		assertEquals(true, visitor.visit(new Bool(true)));
	}

	@Test
	public void testIdents() {
		assertEquals(true, visitor.visit(new Ident("bool")));
		assertEquals(false, visitor.visit(new Ident("undefined")));
	}

	@Test
	public void testInts() {
		assertEquals(true, visitor.visit(new Int(-10)));
		assertEquals(true, visitor.visit(new Int(123)));
	}

	@Test
	public void testMoneys() {
		assertEquals(true, visitor.visit(new Money(-1.0f)));
		assertEquals(true, visitor.visit(new Money(20.0f)));
	}

	@Test
	public void testStrings() {
		assertEquals(true, visitor.visit(new String("test")));
	}

}
