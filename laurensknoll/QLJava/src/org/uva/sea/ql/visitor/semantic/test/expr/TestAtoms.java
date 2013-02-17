package org.uva.sea.ql.visitor.semantic.test.expr;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.atom.String;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;
import org.uva.sea.ql.visitor.semantic.ValidationResult;

public class TestAtoms {

	private IExpression<ValidationResult> visitor;

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
		assertEquals(true, visitor.visit(new Bool(false)).isValid());
		assertEquals(true, visitor.visit(new Bool(true)).isValid());
	}

	@Test
	public void testIdents() {
		assertEquals(true, visitor.visit(new Ident("bool")).isValid());
		assertEquals(false, visitor.visit(new Ident("undefined")).isValid());
	}

	@Test
	public void testInts() {
		assertEquals(true, visitor.visit(new Int(-10)).isValid());
		assertEquals(true, visitor.visit(new Int(123)).isValid());
	}

	@Test
	public void testMoneys() {
		assertEquals(true, visitor.visit(new Money(new BigDecimal("-1.00")))
				.isValid());
		assertEquals(true, visitor.visit(new Money(new BigDecimal("20.00")))
				.isValid());
	}

	@Test
	public void testStrings() {
		assertEquals(true, visitor.visit(new String("test")).isValid());
	}

}
