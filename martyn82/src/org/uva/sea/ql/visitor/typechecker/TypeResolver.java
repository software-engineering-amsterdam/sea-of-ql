package org.uva.sea.ql.visitor.typechecker;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.ast.expression.literal.Bool;
import org.uva.sea.ql.ast.expression.literal.Int;
import org.uva.sea.ql.ast.expression.literal.Money;
import org.uva.sea.ql.ast.expression.literal.Str;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class TypeResolver implements IExpressionVisitor<Type> {
	@Override
	public Type visit( ArithmeticExpression node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( LogicalExpression node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( ComparisonExpression node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( UnaryExpression node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( UnaryNumericExpression node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( Int node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( Bool node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( Money node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( Str node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visit( Ident node ) {
		// TODO Auto-generated method stub
		return null;
	}
}
