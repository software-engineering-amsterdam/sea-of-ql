package org.uva.sea.ql.test.common;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.math.MathOperand;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.parser.ParseError;

public class TestQuestion {

	Class<?> typeAsClass;
	private String typeAsString;
	private String content;
	private String ident;

	public TestQuestion(String ident, String content, String type) {
		this.content = content;
		this.ident = ident;
		this.typeAsString = type;
		switch (type) {
		case "boolean": {
			this.typeAsClass = Bool.class;
		}
			break;
		case "money": {
			this.typeAsClass = Money.class;
		}
			break;
		default: {
			if (type.startsWith("money")) {
				this.typeAsClass = Money.class;
			} else {
				throw new RuntimeException("unexpected type " + type);
			}
		}
		}
	}

	public void testAssignment() throws ParseError {
		Expr ex = CurrentTest.parse(this.getExpression());
		assertEquals(Question.class, ex.getClass());
		Question b = (Question) ex;
		assertEquals(content, b.getContent());
		assertEquals(this.ident, b.getIdent());
	}

	public void testAssignmentValue(float expected) throws ParseError {
		if (typeAsString.startsWith("money")) {
			Expr e = CurrentTest.parse(typeAsString);
			assertEquals(Money.class, e.getClass());
			Money m = (Money) e;
			Expr ex = m.getExpr();
			Assert.assertTrue(ex instanceof MathOperand);
		} else {
			throw new RuntimeException("must be called with money(y*z)");
		}
	}

	private String getExpression() {
		return ident + ": " + "\"" + content + "\" " + typeAsString;
	}
}
