package org.uva.sea.ql.visitor.evaluation;

import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.GT;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.visitor.BaseVisitor;

public class EvaluatorVisitor extends BaseVisitor{
	
	
	
	@Override
	public void visit(Add expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Div expression) {
		super.visit(expression);
	}

	@Override
	public void visit(Mul expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Sub expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(And expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Eq expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(GEq expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(LEq expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(GT expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(LT expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(NEq expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Or expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Neg expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Pos expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

	@Override
	public void visit(Not expression) {
		// TODO Auto-generated method stub
		super.visit(expression);
	}

}
