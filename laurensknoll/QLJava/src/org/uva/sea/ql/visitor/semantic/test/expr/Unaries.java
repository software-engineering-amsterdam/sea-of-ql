package org.uva.sea.ql.visitor.semantic.test.expr;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;
import org.uva.sea.ql.visitor.semantic.ValidationResult;

public class Unaries {

	private IExpression<ValidationResult> visitor;

	public Unaries() {
		// Create an environment with registered identifiers.
		Environment env = new Environment();
		env.declare(new Ident("bool"), new org.uva.sea.ql.ast.type.Bool());
		env.declare(new Ident("int"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("money"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("string"), new org.uva.sea.ql.ast.type.String());

		this.visitor = new Expression(env);
	}

	@Test
	public void testNegatives() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Neg(i)).isValid());
		assertEquals(true, visitor.visit(new Neg(m)).isValid());
		assertEquals(true, visitor.visit(new Neg(intIdent)).isValid());
		assertEquals(true, visitor.visit(new Neg(moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Neg(new Add(i, i))).isValid());
		assertEquals(false, visitor.visit(new Neg(new Eq(b, b))).isValid());

		assertEquals(false, visitor.visit(new Neg(b)).isValid());
		assertEquals(false, visitor.visit(new Neg(boolIdent)).isValid());
		assertEquals(false, visitor.visit(new Neg(stringIdent)).isValid());
	}

	@Test
	public void testPositives() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Pos(i)).isValid());
		assertEquals(true, visitor.visit(new Pos(m)).isValid());
		assertEquals(true, visitor.visit(new Pos(intIdent)).isValid());
		assertEquals(true, visitor.visit(new Pos(moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Pos(new Add(i, i))).isValid());
		assertEquals(false, visitor.visit(new Pos(new Eq(b, b))).isValid());

		assertEquals(false, visitor.visit(new Pos(b)).isValid());
		assertEquals(false, visitor.visit(new Pos(boolIdent)).isValid());
		assertEquals(false, visitor.visit(new Pos(stringIdent)).isValid());
	}

	@Test
	public void testNots() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Not(b)).isValid());
		assertEquals(true, visitor.visit(new Not(boolIdent)).isValid());

		assertEquals(true, visitor.visit(new Not(new Eq(b, b))).isValid());
		assertEquals(false, visitor.visit(new Not(new Add(i, i))).isValid());

		assertEquals(false, visitor.visit(new Not(i)).isValid());
		assertEquals(false, visitor.visit(new Not(m)).isValid());
		assertEquals(false, visitor.visit(new Not(intIdent)).isValid());
		assertEquals(false, visitor.visit(new Not(moneyIdent)).isValid());
		assertEquals(false, visitor.visit(new Not(stringIdent)).isValid());
	}

}
