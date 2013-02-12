package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.UndefinedValue;
import org.uva.sea.ql.value.Value;

public class ExpressionValueVisitor implements IExpressionVisitor<Value> {
	private final ValueMapper valueMapper;
	private final List<Message> errors;

	public ExpressionValueVisitor(ValueMapper valueMapper, List<Message> errors) {
		this.valueMapper = valueMapper;
		this.errors = new ArrayList<Message>();
	}

	public Value visit(Add expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.add(right);
	}

	@Override
	public Value visit(And expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.and(right);
	}

	@Override
	public Value visit(Div expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.div(right);
	}

	@Override
	public Value visit(Eq expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.eq(right);
	}

	@Override
	public Value visit(GEq expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.geq(right);
	}

	@Override
	public Value visit(GT expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.gt(right);
	}

	@Override
	public Value visit(LEq expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.leq(right);
	}

	@Override
	public Value visit(LT expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.lt(right);
	}

	@Override
	public Value visit(Mul expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.mul(right);
	}

	@Override
	public Value visit(NEq expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.neq(right);
	}

	@Override
	public Value visit(Or expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.or(right);
	}

	@Override
	public Value visit(Sub expr) {
		Value left = expr.getLhs().accept(this);
		Value right = expr.getRhs().accept(this);
		return left.sub(right);
	}

	@Override
	public Value visit(Neg expr) {
//		Value left = expr.getLhs().accept(this);
//		Value right = expr.getRhs().accept(this);
//		return left.neg(right);
		return null;
	}

	@Override
	public Value visit(Not expr) {
//		Value left = expr.getLhs().accept(this);
//		Value right = expr.getRhs().accept(this);
//		return left.not(right);
		return null;
	}

	@Override
	public Value visit(Pos expr) {
//		Value left = expr.getLhs().accept(this);
//		Value right = expr.getRhs().accept(this);
//		return left.pos(right);
		return null;
	}

	@Override
	public Value visit(Bool expr) {
		return new BooleanValue(expr.getValue());
	}

	@Override
	public Value visit(Ident expr) {
		if (valueMapper.hasValueKey(expr)) {
			return valueMapper.getValue(expr);
		}
		return new UndefinedValue();
	}
	
	@Override
	public Value visit(Int expr) {
		return new IntegerValue(expr.getValue());
	}

	@Override
	public Value visit(StringLiteral expr) {
		return new StringValue(expr.getValue());
	}

	public List<Message> getErrors() {
		return errors;
	}
}
