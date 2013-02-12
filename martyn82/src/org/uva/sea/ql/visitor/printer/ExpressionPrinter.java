package org.uva.sea.ql.visitor.printer;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.IdentifierExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.arithmetic.AddExpression;
import org.uva.sea.ql.ast.expression.arithmetic.DivideExpression;
import org.uva.sea.ql.ast.expression.arithmetic.MultiplyExpression;
import org.uva.sea.ql.ast.expression.arithmetic.SubtractExpression;
import org.uva.sea.ql.ast.expression.comparison.EqualExpression;
import org.uva.sea.ql.ast.expression.comparison.GreaterThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.comparison.GreaterThanExpression;
import org.uva.sea.ql.ast.expression.comparison.LesserThanOrEqualExpression;
import org.uva.sea.ql.ast.expression.comparison.LesserThanExpression;
import org.uva.sea.ql.ast.expression.comparison.NotEqualExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntegerLiteral;
import org.uva.sea.ql.ast.expression.literal.LiteralExpression;
import org.uva.sea.ql.ast.expression.literal.MoneyLiteral;
import org.uva.sea.ql.ast.expression.literal.StringLiteral;
import org.uva.sea.ql.ast.expression.logical.AndExpression;
import org.uva.sea.ql.ast.expression.logical.OrExpression;
import org.uva.sea.ql.ast.expression.unary.NegativeExpression;
import org.uva.sea.ql.ast.expression.unary.NotExpression;
import org.uva.sea.ql.ast.expression.unary.PositiveExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionPrinter implements ExpressionVisitor<String> {
	private static final String TPL_BINARY = "( %s %s %s )";
	private static final String TPL_UNARY = "( %s %s )";

	private String visitBinary( BinaryExpression node, String operator ) {
		String left = node.getLhs().accept( this );
		String right = node.getRhs().accept( this );
		return String.format( TPL_BINARY, left, operator, right );
	}

	private String visitUnary( UnaryExpression node, String operator ) {
		String operand = node.getExpression().accept( this );
		return String.format( TPL_UNARY, operator, operand );
	}

	private String getName( LiteralExpression node ) {
		return node.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public String visit( StringLiteral node ) {
		return String.format( "%s(%s)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( MoneyLiteral node ) {
		return String.format( "%s(%.2f)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( IntegerLiteral node ) {
		return String.format( "%s(%d)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( BooleanLiteral node ) {
		return String.format( "%s(%b)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( IdentifierExpression node ) {
		return String.format( "%s(%s)", "IDENT", node.getName() );
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
