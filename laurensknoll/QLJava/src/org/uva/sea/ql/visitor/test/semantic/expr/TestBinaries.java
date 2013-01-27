package org.uva.sea.ql.visitor.test.semantic.expr;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
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
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;

@RunWith(Parameterized.class)
public class TestBinaries {

	private Expression visitor;

	@Parameters
	public static List<Object[]> theVisitors() {
		List<Object[]> visitorList = new ArrayList<Object[]>();

		// Create an environment with some registered identifiers.
		Environment env = new Environment();
		env.declare(new Ident("bool"), new org.uva.sea.ql.ast.type.Bool());
		env.declare(new Ident("int"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("money"), new org.uva.sea.ql.ast.type.Numeric());
		env.declare(new Ident("string"), new org.uva.sea.ql.ast.type.String());

		visitorList.add(new Object[] { new Expression(env) });
		return visitorList;
	}

	public TestBinaries(Expression visitor) {
		this.visitor = visitor;
	}

	@Test
	public void testAdds() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Add(i, i)));
		assertEquals(true, visitor.visit(new Add(m, i)));
		assertEquals(true, visitor.visit(new Add(i, intIdent)));
		assertEquals(true, visitor.visit(new Add(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Add(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new Add(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new Add(b, i)));
		assertEquals(false, visitor.visit(new Add(i, b)));
		assertEquals(false, visitor.visit(new Add(boolIdent, i)));
		assertEquals(false, visitor.visit(new Add(stringIdent, i)));

		assertEquals(false, visitor.visit(new Add(b, m)));
		assertEquals(false, visitor.visit(new Add(m, b)));
	}

	@Test
	public void testAnds() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new And(b, b)));
		assertEquals(true, visitor.visit(new And(boolIdent, b)));
		assertEquals(false, visitor.visit(new And(stringIdent, b)));

		assertEquals(true, visitor.visit(new And(new Eq(b, b), b)));
		assertEquals(false, visitor.visit(new And(new Sub(i, i), b)));

		assertEquals(false, visitor.visit(new And(i, i)));
		assertEquals(false, visitor.visit(new And(m, i)));
		assertEquals(false, visitor.visit(new And(i, intIdent)));
		assertEquals(false, visitor.visit(new And(m, moneyIdent)));
	}

	@Test
	public void testDivs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Div(i, i)));
		assertEquals(true, visitor.visit(new Div(m, i)));
		assertEquals(true, visitor.visit(new Div(i, intIdent)));
		assertEquals(true, visitor.visit(new Div(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Div(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new Div(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new Div(b, i)));
		assertEquals(false, visitor.visit(new Div(i, b)));
		assertEquals(false, visitor.visit(new Div(boolIdent, i)));
		assertEquals(false, visitor.visit(new Div(stringIdent, i)));

		assertEquals(false, visitor.visit(new Div(b, m)));
		assertEquals(false, visitor.visit(new Div(m, b)));
	}

	@Test
	public void testEqs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Eq(b, b)));
		assertEquals(true, visitor.visit(new Eq(i, i)));

		assertEquals(true, visitor.visit(new Eq(boolIdent, b)));
		assertEquals(true, visitor.visit(new Eq(i, intIdent)));
		assertEquals(true, visitor.visit(new Eq(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Eq(m, i)));
		assertEquals(false, visitor.visit(new Eq(stringIdent, b)));

		assertEquals(true, visitor.visit(new Eq(new NEq(b, b), b)));
		assertEquals(true, visitor.visit(new Eq(new Sub(i, i), i)));
		assertEquals(true, visitor.visit(new Eq(m, new Sub(i, i))));

		assertEquals(false, visitor.visit(new Eq(new Sub(i, i), b)));
	}

	@Test
	public void testGEqs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new GEq(i, i)));
		assertEquals(true, visitor.visit(new GEq(m, i)));
		assertEquals(true, visitor.visit(new GEq(i, intIdent)));
		assertEquals(true, visitor.visit(new GEq(m, moneyIdent)));

		assertEquals(true, visitor.visit(new GEq(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new GEq(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new GEq(b, i)));
		assertEquals(false, visitor.visit(new GEq(i, b)));
		assertEquals(false, visitor.visit(new GEq(boolIdent, i)));
		assertEquals(false, visitor.visit(new GEq(stringIdent, i)));

		assertEquals(false, visitor.visit(new GEq(b, m)));
		assertEquals(false, visitor.visit(new GEq(m, b)));
	}

	@Test
	public void testGTs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new GT(i, i)));
		assertEquals(true, visitor.visit(new GT(m, i)));
		assertEquals(true, visitor.visit(new GT(i, intIdent)));
		assertEquals(true, visitor.visit(new GT(m, moneyIdent)));

		assertEquals(true, visitor.visit(new GT(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new GT(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new GT(b, i)));
		assertEquals(false, visitor.visit(new GT(i, b)));
		assertEquals(false, visitor.visit(new GT(boolIdent, i)));
		assertEquals(false, visitor.visit(new GT(stringIdent, i)));

		assertEquals(false, visitor.visit(new GT(b, m)));
		assertEquals(false, visitor.visit(new GT(m, b)));
	}

	@Test
	public void testLEqs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new LEq(i, i)));
		assertEquals(true, visitor.visit(new LEq(m, i)));
		assertEquals(true, visitor.visit(new LEq(i, intIdent)));
		assertEquals(true, visitor.visit(new LEq(m, moneyIdent)));

		assertEquals(true, visitor.visit(new LEq(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new LEq(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new LEq(b, i)));
		assertEquals(false, visitor.visit(new LEq(i, b)));
		assertEquals(false, visitor.visit(new LEq(boolIdent, i)));
		assertEquals(false, visitor.visit(new LEq(stringIdent, i)));

		assertEquals(false, visitor.visit(new LEq(b, m)));
		assertEquals(false, visitor.visit(new LEq(m, b)));
	}

	@Test
	public void testLTs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Sub(i, i)));
		assertEquals(true, visitor.visit(new Sub(m, i)));
		assertEquals(true, visitor.visit(new Sub(i, intIdent)));
		assertEquals(true, visitor.visit(new Sub(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Sub(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new Sub(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new Sub(b, i)));
		assertEquals(false, visitor.visit(new Sub(i, b)));
		assertEquals(false, visitor.visit(new Sub(boolIdent, i)));
		assertEquals(false, visitor.visit(new Sub(stringIdent, i)));

		assertEquals(false, visitor.visit(new Sub(b, m)));
		assertEquals(false, visitor.visit(new Sub(m, b)));
	}

	@Test
	public void testMuls() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Mul(i, i)));
		assertEquals(true, visitor.visit(new Mul(m, i)));
		assertEquals(true, visitor.visit(new Mul(i, intIdent)));
		assertEquals(true, visitor.visit(new Mul(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Mul(new Sub(i, i), m)));
		assertEquals(false, visitor.visit(new Mul(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new Mul(b, i)));
		assertEquals(false, visitor.visit(new Mul(i, b)));
		assertEquals(false, visitor.visit(new Mul(boolIdent, i)));
		assertEquals(false, visitor.visit(new Mul(stringIdent, i)));

		assertEquals(false, visitor.visit(new Mul(b, m)));
		assertEquals(false, visitor.visit(new Mul(m, b)));
	}

	@Test
	public void testNEqs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new NEq(b, b)));
		assertEquals(true, visitor.visit(new NEq(i, i)));

		assertEquals(true, visitor.visit(new NEq(boolIdent, b)));
		assertEquals(true, visitor.visit(new NEq(i, intIdent)));
		assertEquals(true, visitor.visit(new NEq(m, moneyIdent)));

		assertEquals(true, visitor.visit(new NEq(m, i)));
		assertEquals(false, visitor.visit(new NEq(stringIdent, b)));

		assertEquals(true, visitor.visit(new NEq(new Eq(b, b), b)));
		assertEquals(true, visitor.visit(new NEq(new Sub(i, i), i)));
		assertEquals(true, visitor.visit(new NEq(m, new Sub(i, i))));

		assertEquals(false, visitor.visit(new NEq(new Sub(i, i), b)));
	}

	@Test
	public void testOrs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Or(b, b)));
		assertEquals(true, visitor.visit(new Or(boolIdent, b)));
		assertEquals(false, visitor.visit(new Or(stringIdent, b)));

		assertEquals(true, visitor.visit(new Or(new Eq(b, b), b)));
		assertEquals(false, visitor.visit(new Or(new Sub(i, i), b)));

		assertEquals(false, visitor.visit(new Or(i, i)));
		assertEquals(false, visitor.visit(new Or(m, i)));
		assertEquals(false, visitor.visit(new Or(i, intIdent)));
		assertEquals(false, visitor.visit(new Or(m, moneyIdent)));
	}

	@Test
	public void testSubs() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Sub(i, i)));
		assertEquals(true, visitor.visit(new Sub(m, i)));
		assertEquals(true, visitor.visit(new Sub(i, intIdent)));
		assertEquals(true, visitor.visit(new Sub(m, moneyIdent)));

		assertEquals(true, visitor.visit(new Sub(new Add(i, i), m)));
		assertEquals(false, visitor.visit(new Sub(new Eq(b, b), i)));

		assertEquals(false, visitor.visit(new Sub(b, i)));
		assertEquals(false, visitor.visit(new Sub(i, b)));
		assertEquals(false, visitor.visit(new Sub(boolIdent, i)));
		assertEquals(false, visitor.visit(new Sub(stringIdent, i)));

		assertEquals(false, visitor.visit(new Sub(b, m)));
		assertEquals(false, visitor.visit(new Sub(m, b)));
	}

}
