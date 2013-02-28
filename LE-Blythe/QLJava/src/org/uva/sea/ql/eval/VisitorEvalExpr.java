package org.uva.sea.ql.eval;

import org.uva.sea.ql.ast.IVisitorExpr;
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
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.eval.value.BoolVal;
import org.uva.sea.ql.eval.value.IntVal;
import org.uva.sea.ql.eval.value.StrVal;
import org.uva.sea.ql.eval.value.UndefinedVal;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.util.Environment;

public class VisitorEvalExpr implements IVisitorExpr<Value> {

	private Environment<Ident, Value> environment;
	
	public VisitorEvalExpr(Environment<Ident, Value> environment) {
		this.environment = environment;
	}

	
	@Override
	public Value visit(Int ast) {
		return new IntVal(ast.getValue());
	}

	@Override
	public Value visit(Bool ast) {
		return new BoolVal(ast.getValue());
	}

	@Override
	public Value visit(Str ast) {
		return new StrVal(ast.getValue());
	}

	@Override
	public Value visit(Undefined ast) {
		return new UndefinedVal();
	}

	@Override
	public Value visit(Ident ast) {
		
		if(environment.contains(ast)){
			return environment.get(ast);
		}
		
		return new UndefinedVal();
	}

	@Override
	public Value visit(Add ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.add(right);
	}

	@Override
	public Value visit(And ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.and(right);
	}

	@Override
	public Value visit(Div ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.div(right);
	}

	@Override
	public Value visit(Eq ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.eq(right);
	}

	@Override
	public Value visit(GEq ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.gEq(right);
	}

	@Override
	public Value visit(GT ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.gt(right);
	}

	@Override
	public Value visit(LEq ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.lEq(right);
	}

	@Override
	public Value visit(LT ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.lt(right);
	}

	@Override
	public Value visit(Mul ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.mul(right);
	}

	@Override
	public Value visit(Neg ast) {
		Value op = ast.getOperand().accept(this);
		
		return op.neg();
	}

	@Override
	public Value visit(NEq ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.nEq(right);
	}

	@Override
	public Value visit(Not ast) {
		Value op = ast.getOperand().accept(this);
		
		return op.not();
	}

	@Override
	public Value visit(Or ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.or(right);
	}

	@Override
	public Value visit(Pos ast) {
		Value op = ast.getOperand().accept(this);
		
		return op.pos();
	}

	@Override
	public Value visit(Sub ast) {
		Value left = ast.getLeftHandOperand().accept(this);
		Value right = ast.getRightHandOperand().accept(this);
		
		return left.sub(right);
	}

}
