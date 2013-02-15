package org.uva.sea.ql.visitor.evaluator;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.expressions.binary.Add;
import org.uva.sea.ql.ast.expressions.binary.And;
import org.uva.sea.ql.ast.expressions.binary.BinExpr;
import org.uva.sea.ql.ast.expressions.binary.Div;
import org.uva.sea.ql.ast.expressions.binary.Eq;
import org.uva.sea.ql.ast.expressions.binary.GEq;
import org.uva.sea.ql.ast.expressions.binary.GT;
import org.uva.sea.ql.ast.expressions.binary.LEq;
import org.uva.sea.ql.ast.expressions.binary.LT;
import org.uva.sea.ql.ast.expressions.binary.Mul;
import org.uva.sea.ql.ast.expressions.binary.NEq;
import org.uva.sea.ql.ast.expressions.binary.Or;
import org.uva.sea.ql.ast.expressions.binary.Sub;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpr;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Condition;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.evaluator.values.NullValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;
/**
 * Class: EvaluationVisitor
 * @author Danny
 *
 */
public class EvaluationVisitor implements Visitor<Value> {
	
	private final Map<Ident, Value> environment;
	
	/**
	 * Constructor 
	 * @param env 
	 */
	public EvaluationVisitor(Map<Ident, Value> env){
		this.environment = Collections.unmodifiableMap(env);
	}
	
	@Override
	public Value visit(Ident i) {
		if(!environment.containsKey(i)){
			return new NullValue();
		}
		return environment.get(i);
	}

	@Override
	public Value visit(Add a) {
		Value l = a.getLeft().accept(this);
		Value r = a.getRight().accept(this);
		return l.add(r);
	}

	@Override
	public Value visit(And a) {
		Value l = a.getLeft().accept(this);
		Value r = a.getRight().accept(this);		
		return l.and(r);
	}

	@Override
	public Value visit(Div d) {
		Value l = d.getLeft().accept(this);
		Value r = d.getRight().accept(this);
		return l.div(r);
	}

	@Override
	public Value visit(Mul m) {
		Value l = m.getLeft().accept(this);
		Value r = m.getRight().accept(this);
		return l.mul(r);
	}

	@Override
	public Value visit(Or o) {
		Value l = o.getLeft().accept(this);
		Value r = o.getRight().accept(this);
		return l.or(r);
	}

	@Override
	public Value visit(Sub s) {
		Value l = s.getLeft().accept(this);
		Value r = s.getRight().accept(this);
		return l.sub(r);
	}

	@Override
	public Value visit(Eq e) {
		Value l = e.getLeft().accept(this);
		Value r = e.getRight().accept(this);
		return l.eq(r);
	}

	@Override
	public Value visit(GEq g) {
		Value l = g.getLeft().accept(this);
		Value r = g.getRight().accept(this);
		return l.gEq(r);
	}

	@Override
	public Value visit(GT g) {
		Value l = g.getLeft().accept(this);
		Value r = g.getRight().accept(this);
		return l.gt(r);
	}

	@Override
	public Value visit(LEq le) {
		Value l = le.getLeft().accept(this);
		Value r = le.getRight().accept(this);
		return l.lEq(r);
	}

	@Override
	public Value visit(LT lt) {
		Value l = lt.getLeft().accept(this);
		Value r = lt.getRight().accept(this);
		return l.lt(r);
	}

	@Override
	public Value visit(NEq n) {
		Value l = n.getLeft().accept(this);
		Value r = n.getRight().accept(this);
		return l.nEq(r);
	}

	@Override
	public Value visit(Neg n) {
		Value v = n.getArgument().accept(this);
		return v.neg(v);
	}

	@Override
	public Value visit(Not n) {
		Value v = n.getArgument().accept(this);
		return v.not(v);
	}

	@Override
	public Value visit(Pos p) {
		Value v = p.getArgument().accept(this);
		return v.pos(v);
	}
	
	/**
	 * Methods below are not required for eval of values
	 */
	
	@Override
	public Value visit(Form f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(FormElement fe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Computation c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Condition c) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Value visit(BinExpr b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(UnaryExpr u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Expr e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value visit(Type t) {
		// TODO Auto-generated method stub
		return null;
	}
}

