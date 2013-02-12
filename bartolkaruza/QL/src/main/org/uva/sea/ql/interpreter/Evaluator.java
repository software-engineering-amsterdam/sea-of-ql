package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Money;
import org.uva.sea.ql.ast.expr.value.Text;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Evaluator implements ExpressionVisitor<Value> {

	@Override
	public Value visit(Ident node) {

		return null;
	}

	@Override
	public Value visit(Add node) {

		return null;
	}

	@Override
	public Value visit(And node) {

		return null;
	}

	@Override
	public Value visit(Div node) {

		return null;
	}

	@Override
	public Value visit(Eq node) {

		return null;
	}

	@Override
	public Value visit(GEq node) {

		return null;
	}

	@Override
	public Value visit(GT node) {

		return null;
	}

	@Override
	public Value visit(LEq node) {

		return null;
	}

	@Override
	public Value visit(LT node) {

		return null;
	}

	@Override
	public Value visit(Mul node) {

		return null;
	}

	@Override
	public Value visit(Neg node) {

		return null;
	}

	@Override
	public Value visit(NEq node) {

		return null;
	}

	@Override
	public Value visit(Not node) {

		return null;
	}

	@Override
	public Value visit(Or node) {

		return null;
	}

	@Override
	public Value visit(Pos node) {

		return null;
	}

	@Override
	public Value visit(Sub node) {

		return null;
	}

	@Override
	public Value visit(Bool node) {

		return null;
	}

	@Override
	public Value visit(Int node) {

		return null;
	}

	@Override
	public Value visit(Money node) {

		return null;
	}

	@Override
	public Value visit(Text node) {

		return null;
	}

}
