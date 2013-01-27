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
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.visitor.semantic.Environment;
import org.uva.sea.ql.visitor.semantic.Expression;

@RunWith(Parameterized.class)
public class TestUnaries {

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

	public TestUnaries(Expression visitor) {
		this.visitor = visitor;
	}

	@Test
	public void testNegatives() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Neg(i)));
		assertEquals(true, visitor.visit(new Neg(m)));
		assertEquals(true, visitor.visit(new Neg(intIdent)));
		assertEquals(true, visitor.visit(new Neg(moneyIdent)));

		assertEquals(true, visitor.visit(new Neg(new Add(i, i))));
		assertEquals(false, visitor.visit(new Neg(new Eq(b, b))));

		assertEquals(false, visitor.visit(new Neg(b)));
		assertEquals(false, visitor.visit(new Neg(boolIdent)));
		assertEquals(false, visitor.visit(new Neg(stringIdent)));
	}

	@Test
	public void testPositives() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Pos(i)));
		assertEquals(true, visitor.visit(new Pos(m)));
		assertEquals(true, visitor.visit(new Pos(intIdent)));
		assertEquals(true, visitor.visit(new Pos(moneyIdent)));

		assertEquals(true, visitor.visit(new Pos(new Add(i, i))));
		assertEquals(false, visitor.visit(new Pos(new Eq(b, b))));

		assertEquals(false, visitor.visit(new Pos(b)));
		assertEquals(false, visitor.visit(new Pos(boolIdent)));
		assertEquals(false, visitor.visit(new Pos(stringIdent)));
	}

	@Test
	public void testNots() {
		Int i = new Int(10);
		Money m = new Money(10.0f);
		Bool b = new Bool(true);
		Ident intIdent = new Ident("int");
		Ident moneyIdent = new Ident("money");
		Ident boolIdent = new Ident("bool");
		Ident stringIdent = new Ident("string");

		assertEquals(true, visitor.visit(new Not(b)));
		assertEquals(true, visitor.visit(new Not(boolIdent)));

		assertEquals(true, visitor.visit(new Not(new Eq(b, b))));
		assertEquals(false, visitor.visit(new Not(new Add(i, i))));

		assertEquals(false, visitor.visit(new Not(i)));
		assertEquals(false, visitor.visit(new Not(m)));
		assertEquals(false, visitor.visit(new Not(intIdent)));
		assertEquals(false, visitor.visit(new Not(moneyIdent)));
		assertEquals(false, visitor.visit(new Not(stringIdent)));
	}

}
