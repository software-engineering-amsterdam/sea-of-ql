package org.uva.sea.ql.core.dom.visitors.tests.Stubs;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.operators.arithmetic.Add;
import org.uva.sea.ql.core.dom.operators.arithmetic.Div;
import org.uva.sea.ql.core.dom.operators.arithmetic.Mul;
import org.uva.sea.ql.core.dom.operators.arithmetic.Sub;
import org.uva.sea.ql.core.dom.operators.conditional.And;
import org.uva.sea.ql.core.dom.operators.conditional.Or;
import org.uva.sea.ql.core.dom.operators.relational.Eq;
import org.uva.sea.ql.core.dom.operators.relational.GEq;
import org.uva.sea.ql.core.dom.operators.relational.GT;
import org.uva.sea.ql.core.dom.operators.relational.LEq;
import org.uva.sea.ql.core.dom.operators.relational.LT;
import org.uva.sea.ql.core.dom.operators.relational.NEq;
import org.uva.sea.ql.core.dom.operators.unary.Neg;
import org.uva.sea.ql.core.dom.operators.unary.Not;
import org.uva.sea.ql.core.dom.operators.unary.Pos;
import org.uva.sea.ql.core.dom.types.primitive.BooleanLiteral;
import org.uva.sea.ql.core.dom.types.primitive.IntLiteral;
import org.uva.sea.ql.core.dom.types.primitive.MoneyLiteral;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public class FakeExpressionVisitor implements ExpressionVisitor{

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Identifier identifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IntLiteral integerLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MoneyLiteral moneyLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Add add) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Div div) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Sub sub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mul mul) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(And and) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Or or) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Eq eq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GEq gEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(GT gT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LEq lEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LT lT) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NEq nEq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Neg neg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Not not) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Pos pos) {
		// TODO Auto-generated method stub
		
	}

}
