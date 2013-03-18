package org.uva.sea.ql.visitor;

import java.util.Set;

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
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;

import com.google.common.collect.Sets;

public class DependencyVisitor implements ExpressionVisitor<Set<Identifier>>{

	@Override
	public Set<Identifier> visit(Identifier identifier) {
		Set<Identifier> set = Sets.newHashSet();
		set.add(identifier);
		return set;
	}

	@Override
	public Set<Identifier> visit(BooleanLiteral literal) {
		return emptySet();
	}

	@Override
	public Set<Identifier> visit(IntLiteral literal) {
		return emptySet();
	}

	@Override
	public Set<Identifier> visit(TextLiteral literal) {
		return emptySet();
	}

	@Override
	public Set<Identifier> visit(Add expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Div expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Mul expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Sub expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(And expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Eq expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(GEq expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(LEq expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(GT expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(LT expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(NEq expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Or expression) {
		return visitBinaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Neg expression) {
		return visitUnaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Pos expression) {
		return visitUnaryExpression(expression);
	}

	@Override
	public Set<Identifier> visit(Not expression) {
		return visitUnaryExpression(expression);
	}
	
	private Set<Identifier> visitUnaryExpression(UnaryExpression expression){
		return expression.getExpr().accept(this);
	}
	
	private Set<Identifier> visitBinaryExpression(BinaryExpression expression){
		Set<Identifier> set1 = expression.getLhs().accept(this);
		Set<Identifier> set2 = expression.getRhs().accept(this);
		
		set1.addAll(set2);
		return set1;
	}

	private Set<Identifier> emptySet(){
		Set<Identifier> set = Sets.newHashSet();
		return set;
	}

}
