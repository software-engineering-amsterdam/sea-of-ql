package org.uva.sea.ql.evaluation;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.IExprVisitor;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.BoolLiteral;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.IntLiteral;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.StringLiteral;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.evaluation.values.Bool;
import org.uva.sea.ql.evaluation.values.Int;
import org.uva.sea.ql.evaluation.values.Str;
import org.uva.sea.ql.evaluation.values.Value;

public class Evaluator implements IExprVisitor<Value> {
	
	private Map<String, Value> env;
	
	
	public Evaluator (Map<String, Value> env) {
		
		this.env = Collections.unmodifiableMap(env);
	}
	
	public static Value eval(Expr expr, Map<String, Value> environment) {
		
		Evaluator evaluator = new Evaluator(environment);
		
		return expr.accept(evaluator);
	}

	@Override
	public Value visit(Add node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.add(r); 
	}

	@Override
	public Value visit(And node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.and(r);
	}

	@Override
	public Value visit(Div node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.div(r);
	}

	@Override
	public Value visit(Eq node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.eq(r);
	}

	@Override
	public Value visit(GEq node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.greaterOrEq(r);
	}

	@Override
	public Value visit(GT node) {
	
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.greater(r);
	}

	@Override
	public Value visit(LEq node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.lessOrEq(r);
	}

	@Override
	public Value visit(LT node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.less(r);
	}

	@Override
	public Value visit(Mul node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.mul(r);
	}

	@Override
	public Value visit(Neg node) {
		
		Value v = node.getArg().accept(this);
		
		return v.neg();
	}

	@Override
	public Value visit(NEq node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.notEq(r);
	}

	@Override
	public Value visit(Not node) {
		
		Value v = node.getArg().accept(this);
		
		return v.not();
	}

	@Override
	public Value visit(Or node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.or(r);
	}

	@Override
	public Value visit(Pos node) {
	
		Value v = node.getArg().accept(this);
		
		return v.pos();
	}

	@Override
	public Value visit(Sub node) {
		
		Value l = node.getLeft().accept(this);
		Value r = node.getRight().accept(this);
		
		return l.sub(r);
	}
	
	@Override
	public Value visit(Ident node) {
		
		return env.get(node.getName());

	}

	@Override
	public Value visit(IntLiteral node) {
		
		return new Int(node.getValue());
	}

	@Override
	public Value visit(BoolLiteral node) {
		
		return new Bool(Boolean.parseBoolean(node.getValue()));
	}


	@Override
	public Value visit(StringLiteral node) {
		
		return new Str(node.getValue());
	}

}
