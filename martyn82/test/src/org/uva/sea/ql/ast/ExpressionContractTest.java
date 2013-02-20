package org.uva.sea.ql.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;

public class ExpressionContractTest {
	@Test( expected = AssertionError.class )
	public void testIdentifierExpression_EmptyString() {
		new IdentifierExpression( "" );
	}

	@Test( expected = AssertionError.class )
	public void testIdentifierExpression_NullString() {
		new IdentifierExpression( null );
	}

	@Test( expected = AssertionError.class )
	public void testUnaryExpression() {
		new NegativeExpression( null );
	}

	@Test( expected = AssertionError.class )
	public void testBinaryExpression_NoRhs() {
		new AddExpression( new IntegerLiteral( 0 ), null );
	}

	@Test( expected = AssertionError.class )
	public void testBinaryExpression_NoLhs() {
		new AddExpression( null, new IntegerLiteral( 0 ) );
	}
}
