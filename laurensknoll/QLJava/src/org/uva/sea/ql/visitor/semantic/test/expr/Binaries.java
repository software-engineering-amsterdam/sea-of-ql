package org.uva.sea.ql.visitor.semantic.test.expr;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;
import org.uva.sea.ql.visitor.semantic.ValidationResult;

public class Binaries {

	private IExpression<ValidationResult> visitor;

	public Binaries() {
		// Create an environment with registered identifiers.
		Environment env = new Environment();
		env.declare(new Ident("bool"), new org.uva.sea.ql.ast.type.Bool());
		env.declare(new Ident("int"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("money"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("string"), new org.uva.sea.ql.ast.type.String());

		this.visitor = new Expression(env);
	}

	@Test
	public void testAdds() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Add(i, i)).isValid());
		assertEquals(true, visitor.visit(new Add(m, i)).isValid());
		assertEquals(true, visitor.visit(new Add(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Add(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Add(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new Add(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new Add(b, i)).isValid());
		assertEquals(false, visitor.visit(new Add(i, b)).isValid());
		assertEquals(false, visitor.visit(new Add(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new Add(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new Add(b, m)).isValid());
		assertEquals(false, visitor.visit(new Add(m, b)).isValid());
	}

	@Test
	public void testAnds() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new And(b, b)).isValid());
		assertEquals(true, visitor.visit(new And(boolIdent, b)).isValid());
		assertEquals(false, visitor.visit(new And(stringIdent, b)).isValid());

		assertEquals(true, visitor.visit(new And(new Eq(b, b), b)).isValid());
		assertEquals(false, visitor.visit(new And(new Sub(i, i), b)).isValid());

		assertEquals(false, visitor.visit(new And(i, i)).isValid());
		assertEquals(false, visitor.visit(new And(m, i)).isValid());
		assertEquals(false, visitor.visit(new And(i, intIdent)).isValid());
		assertEquals(false, visitor.visit(new And(m, moneyIdent)).isValid());
	}

	@Test
	public void testDivs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Div(i, i)).isValid());
		assertEquals(true, visitor.visit(new Div(m, i)).isValid());
		assertEquals(true, visitor.visit(new Div(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Div(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Div(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new Div(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new Div(b, i)).isValid());
		assertEquals(false, visitor.visit(new Div(i, b)).isValid());
		assertEquals(false, visitor.visit(new Div(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new Div(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new Div(b, m)).isValid());
		assertEquals(false, visitor.visit(new Div(m, b)).isValid());
	}

	@Test
	public void testEqs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Eq(b, b)).isValid());
		assertEquals(true, visitor.visit(new Eq(i, i)).isValid());

		assertEquals(true, visitor.visit(new Eq(boolIdent, b)).isValid());
		assertEquals(true, visitor.visit(new Eq(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Eq(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Eq(m, i)).isValid());
		assertEquals(false, visitor.visit(new Eq(stringIdent, b)).isValid());

		assertEquals(true, visitor.visit(new Eq(new NEq(b, b), b)).isValid());
		assertEquals(true, visitor.visit(new Eq(new Sub(i, i), i)).isValid());
		assertEquals(true, visitor.visit(new Eq(m, new Sub(i, i))).isValid());

		assertEquals(false, visitor.visit(new Eq(new Sub(i, i), b)).isValid());
	}

	@Test
	public void testGEqs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new GEq(i, i)).isValid());
		assertEquals(true, visitor.visit(new GEq(m, i)).isValid());
		assertEquals(true, visitor.visit(new GEq(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new GEq(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new GEq(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new GEq(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new GEq(b, i)).isValid());
		assertEquals(false, visitor.visit(new GEq(i, b)).isValid());
		assertEquals(false, visitor.visit(new GEq(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new GEq(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new GEq(b, m)).isValid());
		assertEquals(false, visitor.visit(new GEq(m, b)).isValid());
	}

	@Test
	public void testGTs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new GT(i, i)).isValid());
		assertEquals(true, visitor.visit(new GT(m, i)).isValid());
		assertEquals(true, visitor.visit(new GT(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new GT(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new GT(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new GT(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new GT(b, i)).isValid());
		assertEquals(false, visitor.visit(new GT(i, b)).isValid());
		assertEquals(false, visitor.visit(new GT(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new GT(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new GT(b, m)).isValid());
		assertEquals(false, visitor.visit(new GT(m, b)).isValid());
	}

	@Test
	public void testLEqs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new LEq(i, i)).isValid());
		assertEquals(true, visitor.visit(new LEq(m, i)).isValid());
		assertEquals(true, visitor.visit(new LEq(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new LEq(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new LEq(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new LEq(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new LEq(b, i)).isValid());
		assertEquals(false, visitor.visit(new LEq(i, b)).isValid());
		assertEquals(false, visitor.visit(new LEq(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new LEq(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new LEq(b, m)).isValid());
		assertEquals(false, visitor.visit(new LEq(m, b)).isValid());
	}

	@Test
	public void testLTs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Sub(i, i)).isValid());
		assertEquals(true, visitor.visit(new Sub(m, i)).isValid());
		assertEquals(true, visitor.visit(new Sub(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Sub(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Sub(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new Sub(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new Sub(b, i)).isValid());
		assertEquals(false, visitor.visit(new Sub(i, b)).isValid());
		assertEquals(false, visitor.visit(new Sub(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new Sub(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new Sub(b, m)).isValid());
		assertEquals(false, visitor.visit(new Sub(m, b)).isValid());
	}

	@Test
	public void testMuls() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Mul(i, i)).isValid());
		assertEquals(true, visitor.visit(new Mul(m, i)).isValid());
		assertEquals(true, visitor.visit(new Mul(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Mul(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Mul(new Sub(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new Mul(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new Mul(b, i)).isValid());
		assertEquals(false, visitor.visit(new Mul(i, b)).isValid());
		assertEquals(false, visitor.visit(new Mul(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new Mul(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new Mul(b, m)).isValid());
		assertEquals(false, visitor.visit(new Mul(m, b)).isValid());
	}

	@Test
	public void testNEqs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new NEq(b, b)).isValid());
		assertEquals(true, visitor.visit(new NEq(i, i)).isValid());

		assertEquals(true, visitor.visit(new NEq(boolIdent, b)).isValid());
		assertEquals(true, visitor.visit(new NEq(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new NEq(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new NEq(m, i)).isValid());
		assertEquals(false, visitor.visit(new NEq(stringIdent, b)).isValid());

		assertEquals(true, visitor.visit(new NEq(new Eq(b, b), b)).isValid());
		assertEquals(true, visitor.visit(new NEq(new Sub(i, i), i)).isValid());
		assertEquals(true, visitor.visit(new NEq(m, new Sub(i, i))).isValid());

		assertEquals(false, visitor.visit(new NEq(new Sub(i, i), b)).isValid());
	}

	@Test
	public void testOrs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Or(b, b)).isValid());
		assertEquals(true, visitor.visit(new Or(boolIdent, b)).isValid());
		assertEquals(false, visitor.visit(new Or(stringIdent, b)).isValid());

		assertEquals(true, visitor.visit(new Or(new Eq(b, b), b)).isValid());
		assertEquals(false, visitor.visit(new Or(new Sub(i, i), b)).isValid());

		assertEquals(false, visitor.visit(new Or(i, i)).isValid());
		assertEquals(false, visitor.visit(new Or(m, i)).isValid());
		assertEquals(false, visitor.visit(new Or(i, intIdent)).isValid());
		assertEquals(false, visitor.visit(new Or(m, moneyIdent)).isValid());
	}

	@Test
	public void testSubs() {
		Int i = new Int(10);
		Money m = new Money(new BigDecimal("10.00"));
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Sub(i, i)).isValid());
		assertEquals(true, visitor.visit(new Sub(m, i)).isValid());
		assertEquals(true, visitor.visit(new Sub(i, intIdent)).isValid());
		assertEquals(true, visitor.visit(new Sub(m, moneyIdent)).isValid());

		assertEquals(true, visitor.visit(new Sub(new Add(i, i), m)).isValid());
		assertEquals(false, visitor.visit(new Sub(new Eq(b, b), i)).isValid());

		assertEquals(false, visitor.visit(new Sub(b, i)).isValid());
		assertEquals(false, visitor.visit(new Sub(i, b)).isValid());
		assertEquals(false, visitor.visit(new Sub(boolIdent, i)).isValid());
		assertEquals(false, visitor.visit(new Sub(stringIdent, i)).isValid());

		assertEquals(false, visitor.visit(new Sub(b, m)).isValid());
		assertEquals(false, visitor.visit(new Sub(m, b)).isValid());
	}

}
