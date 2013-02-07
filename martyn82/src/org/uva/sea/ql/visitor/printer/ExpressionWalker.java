package org.uva.sea.ql.visitor.printer;

import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.arithmetic.Add;
import org.uva.sea.ql.ast.expression.arithmetic.Div;
import org.uva.sea.ql.ast.expression.arithmetic.Mul;
import org.uva.sea.ql.ast.expression.arithmetic.Sub;
import org.uva.sea.ql.ast.expression.comparison.Eq;
import org.uva.sea.ql.ast.expression.comparison.GEq;
import org.uva.sea.ql.ast.expression.comparison.GT;
import org.uva.sea.ql.ast.expression.comparison.LEq;
import org.uva.sea.ql.ast.expression.comparison.LT;
import org.uva.sea.ql.ast.expression.comparison.NEq;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.expression.logical.And;
import org.uva.sea.ql.ast.expression.logical.Or;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * Represents a pretty printer for expression nodes.
 */
public class ExpressionWalker implements ExpressionVisitor<String> {
	private static final String TPL_BINARY = "( %s %s %s )";
	private static final String TPL_UNARY = "( %s %s )";
	private static final String TPL_ATOMIC = "%s(\"%s\")";

	/**
	 * Visit binary expression.
	 *
	 * @param node
	 * @param operator
	 */
	private String visitBinary( BinaryExpression node, String operator ) {
		String left = node.getLhs().accept( this );
		String right = node.getRhs().accept( this );
		return String.format( TPL_BINARY, left, operator, right );
	}

	/**
	 * Visit unary expression.
	 *
	 * @param node
	 * @param operator
	 */
	private String visitUnary( UnaryExpression node, String operator ) {
		String operand = node.getExpression().accept( this );
		return String.format( TPL_UNARY, operator, operand );
	}

	/**
	 * Visit atomic identifier node.
	 *
	 * @param node
	 */
	private String visitIdent( Ident node ) {
		return String.format( TPL_ATOMIC, "IDENT", node.getName() );
	}

	/**
	 * Retrieves the name of a literal node.
	 *
	 * @param node
	 *
	 * @return The name of the node.
	 */
	private String getName( Literal node ) {
		return node.getClass().getSimpleName().toUpperCase();
	}

	@Override
	public String visit( Str node ) {
		return String.format( "%s(%s)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( Money node ) {
		return String.format( "%s(%.2f)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( Int node ) {
		return String.format( "%s(%d)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( Bool node ) {
		return String.format( "%s(%b)", this.getName( node ), node.getValue() );
	}

	@Override
	public String visit( Ident node ) {
		return this.visitIdent( node );
	}

	@Override
	public String visit( Add node ) {
		return this.visitBinary( node, "+" );
	}

	@Override
	public String visit( Sub node ) {
		return this.visitBinary( node, "-" );
	}

	@Override
	public String visit( Div node ) {
		return this.visitBinary( node, "/" );
	}

	@Override
	public String visit( Mul node ) {
		return this.visitBinary( node, "*" );
	}

	@Override
	public String visit( And node ) {
		return this.visitBinary( node, "&&" );
	}

	@Override
	public String visit( Or node ) {
		return this.visitBinary( node, "||" );
	}

	@Override
	public String visit( Eq node ) {
		return this.visitBinary( node, "==" );
	}

	@Override
	public String visit( GEq node ) {
		return this.visitBinary( node, ">=" );
	}

	@Override
	public String visit( GT node ) {
		return this.visitBinary( node, ">" );
	}

	@Override
	public String visit( LEq node ) {
		return this.visitBinary( node, "<=" );
	}

	@Override
	public String visit( LT node ) {
		return this.visitBinary( node, "<" );
	}

	@Override
	public String visit( NEq node ) {
		return this.visitBinary( node, "!=" );
	}

	@Override
	public String visit( Not node ) {
		return this.visitUnary( node, "!" );
	}

	@Override
	public String visit( Pos node ) {
		return this.visitUnary( node, "+" );
	}

	@Override
	public String visit( Neg node ) {
		return this.visitUnary( node, "-" );
	}
}
