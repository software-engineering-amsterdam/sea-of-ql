package org.uva.sea.ql.evaluate.print;

import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.binary.BinaryExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.binary.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.binary.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.binary.logical.AndExpression;
import org.uva.sea.ql.ast.expression.binary.logical.OrExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.unary.UnaryExpression;
import org.uva.sea.ql.ast.expression.unary.logical.NotExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.numeric.PositiveExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

class ExpressionToString implements ExpressionVisitor<String> {
	private static final String TPL_BINARY = "(%s %s %s)";
	private static final String TPL_UNARY = "(%s %s)";

	private String visitBinary( BinaryExpression node, String operator ) {
		String left = node.getLhs().accept( this );
		String right = node.getRhs().accept( this );
		return String.format( TPL_BINARY, left, operator, right );
	}

	private String visitUnary( UnaryExpression node, String operator ) {
		String operand = node.getExpression().accept( this );
		return String.format( TPL_UNARY, operator, operand );
	}

	@Override
	public String visit( StringLiteral node ) {
		return String.format( "(%s)", node.getValue() );
	}

	@Override
	public String visit( MoneyLiteral node ) {
		return String.format( "%.2f", node.getValue() );
	}

	@Override
	public String visit( IntegerLiteral node ) {
		return String.format( "%d", node.getValue() );
	}

	@Override
	public String visit( BooleanLiteral node ) {
		return String.format( "%b", node.getValue() );
	}

	@Override
	public String visit( IdentifierExpression node ) {
		return String.format( "%s", node.getName() );
	}

	@Override
	public String visit( AddExpression node ) {
		return this.visitBinary( node, "+" );
	}

	@Override
	public String visit( SubtractExpression node ) {
		return this.visitBinary( node, "-" );
	}

	@Override
	public String visit( DivideExpression node ) {
		return this.visitBinary( node, "/" );
	}

	@Override
	public String visit( MultiplyExpression node ) {
		return this.visitBinary( node, "*" );
	}

	@Override
	public String visit( AndExpression node ) {
		return this.visitBinary( node, "&&" );
	}

	@Override
	public String visit( OrExpression node ) {
		return this.visitBinary( node, "||" );
	}

	@Override
	public String visit( EqualExpression node ) {
		return this.visitBinary( node, "==" );
	}

	@Override
	public String visit( GreaterThanOrEqualExpression node ) {
		return this.visitBinary( node, ">=" );
	}

	@Override
	public String visit( GreaterThanExpression node ) {
		return this.visitBinary( node, ">" );
	}

	@Override
	public String visit( LesserThanOrEqualExpression node ) {
		return this.visitBinary( node, "<=" );
	}

	@Override
	public String visit( LesserThanExpression node ) {
		return this.visitBinary( node, "<" );
	}

	@Override
	public String visit( NotEqualExpression node ) {
		return this.visitBinary( node, "!=" );
	}

	@Override
	public String visit( NotExpression node ) {
		return this.visitUnary( node, "!" );
	}

	@Override
	public String visit( PositiveExpression node ) {
		return this.visitUnary( node, "+" );
	}

	@Override
	public String visit( NegativeExpression node ) {
		return this.visitUnary( node, "-" );
	}
}
