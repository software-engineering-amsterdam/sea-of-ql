package org.uva.sea.ql;

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
import org.uva.sea.ql.ast.expr.values.BoolLiteral;
import org.uva.sea.ql.ast.expr.values.Int;
import org.uva.sea.ql.ast.expr.values.StringLiteral;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.types.Type;

public class Evaluator implements IExprVisitor<Value> {
	
	private Map<String, Type> typeEnvironment;
	
	
	public Evaluator (Map<String, Type> typeEnvironment) {
		
		this.typeEnvironment = Collections.unmodifiableMap(typeEnvironment);
	}


	@Override
	public Value visit(Add node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(And node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Div node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Eq node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(GEq node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(GT node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Ident node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Int node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(LEq node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(LT node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Mul node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Neg node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(NEq node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Not node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Or node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Pos node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(Sub node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(BoolLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Value visit(StringLiteral node) {
		// TODO Auto-generated method stub
		return null;
	}

}
