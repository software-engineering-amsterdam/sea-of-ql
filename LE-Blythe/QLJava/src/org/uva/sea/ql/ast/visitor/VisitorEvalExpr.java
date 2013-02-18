package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.operative.Add;
import org.uva.sea.ql.ast.operative.And;
import org.uva.sea.ql.ast.operative.Div;
import org.uva.sea.ql.ast.operative.Eq;
import org.uva.sea.ql.ast.operative.GEq;
import org.uva.sea.ql.ast.operative.GT;
import org.uva.sea.ql.ast.operative.LEq;
import org.uva.sea.ql.ast.operative.LT;
import org.uva.sea.ql.ast.operative.Mul;
import org.uva.sea.ql.ast.operative.NEq;
import org.uva.sea.ql.ast.operative.Neg;
import org.uva.sea.ql.ast.operative.Not;
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Pos;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.util.Environment;

public class VisitorEvalExpr implements IVisitorExpr<Primitive> {

	private Environment environment;
	
	public VisitorEvalExpr(Environment environment) {
		this.environment = environment;
	}

	
	@Override
	public Primitive visit(Int ast) {
		return ast;
	}

	@Override
	public Primitive visit(Bool ast) {
		return ast;
	}

	@Override
	public Primitive visit(Str ast) {
		return ast;
	}

	@Override
	public Primitive visit(Undefined ast) {
		return ast;
	}

	@Override
	public Primitive visit(Ident ast) {
		
		if(environment.containsValue(ast)){
			return environment.getValue(ast).accept(this);
		}
		
		return new Undefined();
	}

	@Override
	public Primitive visit(Add ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.add(right);
	}

	@Override
	public Primitive visit(And ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.and(right);
	}

	@Override
	public Primitive visit(Div ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.div(right);
	}

	@Override
	public Primitive visit(Eq ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.eq(right);
	}

	@Override
	public Primitive visit(GEq ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.gEq(right);
	}

	@Override
	public Primitive visit(GT ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.gt(right);
	}

	@Override
	public Primitive visit(LEq ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.lEq(right);
	}

	@Override
	public Primitive visit(LT ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.lt(right);
	}

	@Override
	public Primitive visit(Mul ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.mul(right);
	}

	@Override
	public Primitive visit(Neg ast) {
		Primitive op = ast.getOperand().accept(this);
		
		return op.neg();
	}

	@Override
	public Primitive visit(NEq ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.nEq(right);
	}

	@Override
	public Primitive visit(Not ast) {
		Primitive op = ast.getOperand().accept(this);
		
		return op.not();
	}

	@Override
	public Primitive visit(Or ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.or(right);
	}

	@Override
	public Primitive visit(Pos ast) {
		Primitive op = ast.getOperand().accept(this);
		
		return op.pos();
	}

	@Override
	public Primitive visit(Sub ast) {
		Primitive left = ast.getLeftHandOperand().accept(this);
		Primitive right = ast.getRightHandOperand().accept(this);
		
		return left.sub(right);
	}

}
