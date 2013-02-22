package org.uva.sea.ql.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

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
		new UnaryExpression( null ) {
			@Override
			public <T> T accept( ExpressionVisitor<T> visitor ) {
				return null;
			}
		};
	}

	@Test( expected = AssertionError.class )
	public void testBinaryExpression_NoRhs() {
		new BinaryExpression( new IntegerLiteral( 0 ), null ) {
			@Override
			public <T> T accept( ExpressionVisitor<T> visitor ) {
				return null;
			}
		};
	}

	@Test( expected = AssertionError.class )
	public void testBinaryExpression_NoLhs() {
		new BinaryExpression( null, new IntegerLiteral( 0 ) ) {
			@Override
			public <T> T accept( ExpressionVisitor<T> visitor ) {
				return null;
			}
		};
	}
}
