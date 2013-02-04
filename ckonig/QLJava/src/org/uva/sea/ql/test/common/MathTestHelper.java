package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.parser.ParseError;

public class MathTestHelper extends TestHelper<MathTestHelper> {
	boolean processFirst;

	public MathTestHelper(TestParser parser) {
		super(parser);		
	}
	
	public MathTestHelper setClass(Class<?> c){
		setClassAndString(c);
		switch (this.asString) {
		case "+":
			this.processFirst = false;
			break;
		case "-":
			this.processFirst = false;
			break;
		case "*":
			this.processFirst = true;
			break;
		case "/":
			this.processFirst = true;
			break;
		case "&&":
			this.processFirst = true;
			break;
		case "||":
			this.processFirst = false;
			break;
		}
		return this;
	}

	public void testMathOperations(MathTestHelper opposite) throws ParseError {
		testBinary(this.asClass, "a " + this.asString + " b", Ident.class,
				Ident.class);
		testBinary(this.asClass, "a " + this.asString + " (b " + this.asString
				+ " c)", Ident.class, this.asClass);
		testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
				+ " c", this.asClass, Ident.class);
		testBinary(this.asClass, "(a " + this.asString + " b)", Ident.class,
				Ident.class);
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " c", opposite.asClass, Ident.class);
		testBinary(opposite.asClass, "a " + opposite.asString + " (b "
				+ this.asString + " c)", Ident.class, this.asClass);
		testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
				+ " ( c " + this.asString + " d)", this.asClass, this.asClass);
		testBinary(this.asClass, "(a " + this.asString + " b) " + this.asString
				+ " ( c " + opposite.asString + " d)", this.asClass,
				opposite.asClass);
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " ( c " + this.asString + " d)",
				opposite.asClass, this.asClass);
		testBinary(this.asClass, "(a " + opposite.asString + " b) "
				+ this.asString + " ( c " + opposite.asString + " d)",
				opposite.asClass, opposite.asClass);

		if (this.processFirst && !opposite.processFirst) {
			assertEquals(
					opposite.asClass,
					parser.parse(
							"a " + this.asString + " b " + opposite.asString
									+ " c").getClass());
			assertEquals(
					opposite.asClass,
					parser.parse(
							"a " + this.asString + " b " + opposite.asString
									+ " c").getClass());
			assertEquals(
					opposite.asClass,
					parser.parse(
							"a " + this.asString + " b " + opposite.asString
									+ " c " + opposite.asString + " d")
							.getClass());
			assertEquals(
					opposite.asClass,
					parser.parse(
							"a " + opposite.asString + " d " + this.asString
									+ " b " + opposite.asString + " c")
							.getClass());
			assertEquals(
					opposite.asClass,
					parser.parse(
							"a " + opposite.asString + " b "
									+ opposite.asString + " c " + this.asString
									+ " e").getClass());
		}
		if (opposite.processFirst && !this.processFirst) {
			assertEquals(
					this.asClass,
					parser.parse(
							"a " + this.asString + " b " + opposite.asString
									+ " c").getClass());
			assertEquals(
					this.asClass,
					parser.parse(
							"a " + this.asString + " b " + opposite.asString
									+ " c").getClass());
		}
	}

}