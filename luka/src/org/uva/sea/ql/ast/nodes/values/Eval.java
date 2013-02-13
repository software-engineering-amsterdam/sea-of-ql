package org.uva.sea.ql.ast.nodes.values;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class Eval implements ExpressionVisitor<Value>{
	private final Map<Ident,Value> typeEnv;
	
	public Eval(Map<Ident,Value> typeEnv){
		this.typeEnv = Collections.unmodifiableMap(typeEnv);
	}
	
	@Override
	public Value visit(Ident ast) {
		if(this.typeEnv.containsKey(ast)){
		return this.typeEnv.get(ast);
		}
		return null;
	}

	
	//TODO RIGHT HERE !??!?!?! NOO??
	@Override
	public Value visit(Add ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Div ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Value visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Bool bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Str bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Money bool) {
		// TODO Auto-generated method stub
		return null;
	}

}
