package org.uva.sea.ql.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.TextValue;
import org.uva.sea.ql.value.Value;

public class EvaluatorVisitor implements ExpressionVisitor<Value>{
	
	private final Map<Identifier, Value> symbolMap;
	
	public EvaluatorVisitor(final Map<Identifier, Value> symbolMap){
		this.symbolMap = symbolMap;
	}
	
	@Override
	public Value visit(Identifier identifier) {
		return symbolMap.get(identifier);
	}

	private Value visitLhs(final BinaryExpression expression){
		return expression.getLhs().accept(this);
	}
	
	private Value visitRhs(final BinaryExpression expression){
		return expression.getRhs().accept(this);
	}
	
	@Override
	public Value visit(BooleanLiteral literal) {
		return new BooleanValue(literal.getValue());
	}

	@Override
	public Value visit(IntLiteral literal) {
		return new IntegerValue(literal.getValue());
	}

	@Override
	public Value visit(TextLiteral literal) {
		return new TextValue(literal.getValue());
	}

	@Override
	public Value visit(Add expression) {
		return visitLhs(expression).add(visitRhs(expression));
	}

	@Override
	public Value visit(Div expression) {
		return visitLhs(expression).div(visitRhs(expression));
	}

	@Override
	public Value visit(Mul expression) {
		return visitLhs(expression).mul(visitRhs(expression));
	}

	@Override
	public Value visit(Sub expression) {
		return visitLhs(expression).sub(visitRhs(expression));
	}

	@Override
	public Value visit(And expression) {
		return visitLhs(expression).and(visitRhs(expression));
	}

	@Override
	public Value visit(Eq expression) {
		return visitLhs(expression).eq(visitRhs(expression));
	}

	@Override
	public Value visit(GEq expression) {
		return visitLhs(expression).geq(visitRhs(expression));
	}

	@Override
	public Value visit(LEq expression) {
		return visitLhs(expression).leq(visitRhs(expression));
	}

	@Override
	public Value visit(GT expression) {
		return visitLhs(expression).gt(visitRhs(expression));
	}

	@Override
	public Value visit(LT expression) {
		return visitLhs(expression).lt(visitRhs(expression));
	}

	@Override
	public Value visit(NEq expression) {
		return visitLhs(expression).neq(visitRhs(expression));
	}

	@Override
	public Value visit(Or expression) {
		return visitLhs(expression).or(visitRhs(expression));
	}

	@Override
	public Value visit(Neg expression) {
		return expression.getExpr().accept(this).neg();
	}

	@Override
	public Value visit(Pos expression) {
		return expression.getExpr().accept(this).pos();
	}

	@Override
	public Value visit(Not expression) {
		return expression.getExpr().accept(this).not();
	}

}