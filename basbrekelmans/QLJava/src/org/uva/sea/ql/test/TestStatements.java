package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.If;
import org.uva.sea.ql.ast.statements.IfElse;
import org.uva.sea.ql.ast.statements.InputQuestion;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.statements.Statements;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.typechecking.ITypeChecker;
import org.uva.sea.ql.typechecking.ITypeResolver;
import org.uva.sea.ql.typechecking.TypeChecker;
import org.uva.sea.ql.typechecking.TypeContext;
import org.uva.sea.ql.typechecking.TypeResolver;

public class TestStatements {

	/**
	 * Helper method for statement testing
	 * 
	 * @return First child of block statement, or itself if it's not a block
	 *         statement.
	 */
	private static Statement firstChild(final Node input) {
		if (input instanceof Statements) {
			final Statements statements = (Statements) input;
			return statements.iterator().next();
		} else {
			return (Statement) input;
		}
	}

	private final IParser parser;

	public TestStatements() {
		this.parser = new JACCParser();
	}

	@Test
	public void testForm() {
		assertEquals(
				Form.class,
				this.parser.parse(
						"form \"Test 123\" { \"Test 123\" myVar : money }")
						.getClass());
		assertEquals(
				Form.class,
				this.parser.parse(
						"form \"Hanky Panky\" { \"Test 123\" myVar : money }")
						.getClass());
	}

	@Test
	public void testIfs() {
		assertEquals(
				If.class,
				firstChild(
						this.parser
								.parse("if (1 * 3) { \"Test 123\" myVar = 1 * 2 }"))
						.getClass());
		assertEquals(
				IfElse.class,
				firstChild(
						this.parser
								.parse("if (1 * 3) { \"Test 123\" myVar = 1 * 2 } else { \"ABC 123\" myVar : bool }"))
						.getClass());
		assertEquals(
				If.class,
				firstChild(
						this.parser
								.parse("if (a * b) { if (c * d) { if (a * d) { \"Test 123\" myVar : bool } } }"))
						.getClass());
		assertEquals(
				If.class,
				firstChild(
						this.parser
								.parse("if (1 < 3) { \"Test 123\" myVar = 1 * 2 }"))
						.getClass());
		assertEquals(
				If.class,
				firstChild(
						this.parser
								.parse("if (1 != b) { \"Test 123\" myVar = 1 * 2 }"))
						.getClass());
		assertEquals(
				If.class,
				firstChild(
						this.parser
								.parse("if (a ^ c) { \"Test 123\" myVar = 1 * 2 }"))
						.getClass());
	}

	@Test
	public void testQuestions() {
		assertEquals(InputQuestion.class,
				firstChild(this.parser.parse("\"Test 123\" myVar : bool"))
						.getClass());
		assertEquals(InputQuestion.class,
				firstChild(this.parser.parse("\"Test 123\" myVar : string"))
						.getClass());
		assertEquals(InputQuestion.class,
				firstChild(this.parser.parse("\"Test 123\" myVar : int"))
						.getClass());
		assertEquals(InputQuestion.class,
				firstChild(this.parser.parse("\"Test 123\" myVar : money"))
						.getClass());
		assertEquals(ComputedQuestion.class,
				firstChild(this.parser.parse("\"Test 123\" myVar = 1 * 2"))
						.getClass());
		assertEquals(
				ComputedQuestion.class,
				firstChild(
						this.parser
								.parse("\"Test 123\" myVar = (1 + 2) * 5 - a"))
						.getClass());
	}

	@Test
	public void testTypeChecker() {
		ITypeChecker checker = new TypeChecker();

		final String ifStatement1Code = "if (a == b) { \"Question 1?\" myVar : bool }";
		final String ifStatement2Code = "\"Q1?\" a : money "
				+ "\"Q2?\" b : money " + "if (a > b) { "
				+ "\"Q3?\" myVar : money " + "}";
		final If ifStatement1 = (If) firstChild(this.parser
				.parse(ifStatement1Code));
		final Statements ifStatement2 = (Statements) this.parser
				.parse(ifStatement2Code);

		checker.checkTypes(ifStatement1);
		assertEquals(2, checker.getErrors().size());
		checker = new TypeChecker();
		checker.checkTypes(ifStatement2);
		assertEquals(false, checker.hasErrors());
	}

	@Test
	public void testTypeResolving() {
		final String integerExpression1 = "3 + 5";
		final String floatExpression1 = "3.0 + 5.0";
		final String floatExpression2 = "3.0 + 5";
		final String stringComparison1 = "\"Hanky\" == \"Panky\"";
		final String stringLiteral1 = "\"Hanky\"";
		final TypeContext context = new TypeContext();
		final ITypeResolver resolver = new TypeResolver(context);

		assertEquals(Type.INTEGER, resolver.getType((Expression) this.parser
				.parse(integerExpression1)));
		assertEquals(Type.MONEY, resolver.getType((Expression) this.parser
				.parse(floatExpression1)));
		assertEquals(Type.MONEY, resolver.getType((Expression) this.parser
				.parse(floatExpression2)));
		assertEquals(Type.STRING, resolver.getType((Expression) this.parser
				.parse(stringLiteral1)));
		assertEquals(Type.BOOLEAN, resolver.getType((Expression) this.parser
				.parse(stringComparison1)));
	}
}
