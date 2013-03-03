package org.uva.sea.ql.ast.visitors;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.conditional.And;
import org.uva.sea.ql.ast.operators.conditional.Or;
import org.uva.sea.ql.ast.operators.relational.Eq;
import org.uva.sea.ql.ast.operators.relational.GEq;
import org.uva.sea.ql.ast.operators.relational.GT;
import org.uva.sea.ql.ast.operators.relational.LEq;
import org.uva.sea.ql.ast.operators.relational.LT;
import org.uva.sea.ql.ast.operators.relational.NEq;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.types.literals.BooleanLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.QLValue;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

public class ExpressionEvaluatingVisitor implements ExpressionVisitor<QLValue>{

	@Override
	public QLValue visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Identifier identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(IntLiteral integerLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Add add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Div div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Sub sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Mul mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Eq eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(GEq gEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(GT gT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(LEq lEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(LT lT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(NEq nEq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QLValue visit(Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}


}
