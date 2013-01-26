package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.eval.value.Boolean;
import org.uva.sea.ql.eval.value.Integer;
import org.uva.sea.ql.eval.value.Money;
import org.uva.sea.ql.eval.value.String;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionEvaluator implements IExpressionVisitor<Value> {

	@Override
	public Value visit( Add node ) {
		// TODO money has precedence!
		Integer left = (Integer) node.getLhs().accept( this );
		Integer right = (Integer) node.getRhs().accept( this );
		return new Integer( left.getValue() + right.getValue() );
	}

	@Override
	public Value visit( Sub node ) {
		// TODO money has precedence!
		Integer left = (Integer) node.getLhs().accept( this );
		Integer right = (Integer) node.getRhs().accept( this );
		return new Integer( left.getValue() - right.getValue() );
	}

	@Override
	public Value visit( Div node ) {
		// TODO money has precedence!
		Integer left = (Integer) node.getLhs().accept( this );
		Integer right = (Integer) node.getRhs().accept( this );
		return new Integer( left.getValue() / right.getValue() );
	}

	@Override
	public Value visit( Mul node ) {
		// TODO money has precedence!
		Integer left = (Integer) node.getLhs().accept( this );
		Integer right = (Integer) node.getRhs().accept( this );
		return new Integer( left.getValue() * right.getValue() );
	}

	@Override
	public Value visit( And node ) {
		Boolean left = (Boolean) node.getLhs().accept( this );
		Boolean right = (Boolean) node.getRhs().accept( this );
		return new Boolean( left.getValue() && right.getValue() );
	}

	@Override
	public Value visit( Or node ) {
		Boolean left = (Boolean) node.getLhs().accept( this );
		Boolean right = (Boolean) node.getRhs().accept( this );
		return new Boolean( left.getValue() || right.getValue() );
	}

	@Override
	public Value visit( Eq node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( GEq node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( GT node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( LEq node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( LT node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( NEq node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( Not node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( Pos node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( Neg node ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Int node ) {
		return new Integer( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Bool node ) {
		return new Boolean( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Money node ) {
		return new Money( node.getValue() );
	}

	@Override
	public Value visit( org.uva.sea.ql.ast.expression.literal.Str node ) {
		return new String( node.getValue() );
	}

	@Override
	public Value visit( Ident node ) {
		// TODO Auto-generated method stub
		return null;
	}
}
