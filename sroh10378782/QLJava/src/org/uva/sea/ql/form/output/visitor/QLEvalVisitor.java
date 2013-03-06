package org.uva.sea.ql.form.output.visitor;

import java.util.Collections;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.Add;
import org.uva.sea.ql.ast.nodes.expressions.And;
import org.uva.sea.ql.ast.nodes.expressions.Bool;
import org.uva.sea.ql.ast.nodes.expressions.CompBool;
import org.uva.sea.ql.ast.nodes.expressions.CompInt;
import org.uva.sea.ql.ast.nodes.expressions.CompMoney;
import org.uva.sea.ql.ast.nodes.expressions.Div;
import org.uva.sea.ql.ast.nodes.expressions.Eq;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.GEq;
import org.uva.sea.ql.ast.nodes.expressions.GT;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.expressions.Int;
import org.uva.sea.ql.ast.nodes.expressions.LEq;
import org.uva.sea.ql.ast.nodes.expressions.LT;
import org.uva.sea.ql.ast.nodes.expressions.Money;
import org.uva.sea.ql.ast.nodes.expressions.Mul;
import org.uva.sea.ql.ast.nodes.expressions.NEq;
import org.uva.sea.ql.ast.nodes.expressions.Neg;
import org.uva.sea.ql.ast.nodes.expressions.Not;
import org.uva.sea.ql.ast.nodes.expressions.Or;
import org.uva.sea.ql.ast.nodes.expressions.Pos;
import org.uva.sea.ql.ast.nodes.expressions.Str;
import org.uva.sea.ql.ast.nodes.expressions.Sub;
import org.uva.sea.ql.values.VBool;
import org.uva.sea.ql.values.VError;
import org.uva.sea.ql.values.VInt;
import org.uva.sea.ql.values.VMoney;
import org.uva.sea.ql.values.Value;
import org.uva.sea.ql.values.ValueKeywords;

/**
 * Evaluation Visitor, for checking the expressions, and returns its Value.
 * @author Sven Rohde
 */
public class QLEvalVisitor implements Visitor<Value> {
	
	private final Map<Ident, Value> valueEnvironment;
	
	public QLEvalVisitor(Map<Ident, Value> valueEnvironment){
		this.valueEnvironment = Collections.unmodifiableMap(valueEnvironment);
	}
	
	public Value eval(Expr expr) {
		Value retVal = expr.accept(this);
		return retVal;
	}
	
	@Override
	public Value visit(Add add) {
		Value vlhs = add.getLhs().accept(this);
		Value vrhs = add.getRhs().accept(this);
		return vlhs.add(vrhs);
	}

	@Override
	public Value visit(And and) {
		Value vlhs = and.getLhs().accept(this);
		Value vrhs = and.getRhs().accept(this);
		return vlhs.and(vrhs);
	}

	@Override
	public Value visit(Div div) {
		Value vlhs = div.getLhs().accept(this);
		Value vrhs = div.getRhs().accept(this);
		return vlhs.div(vrhs);
	}

	@Override
	public Value visit(Eq eq) {
		Value vlhs = eq.getLhs().accept(this);
		Value vrhs = eq.getRhs().accept(this);
		return vlhs.eq(vrhs);
	}

	@Override
	public Value visit(GEq geq) {
		Value vlhs = geq.getLhs().accept(this);
		Value vrhs = geq.getRhs().accept(this);
		return vlhs.geq(vrhs);
	}

	@Override
	public Value visit(GT gt) {
		Value vlhs = gt.getLhs().accept(this);
		Value vrhs = gt.getRhs().accept(this);
		return vlhs.gt(vrhs);
	}

	@Override
	public Value visit(LEq leq) {
		Value vlhs = leq.getLhs().accept(this);
		Value vrhs = leq.getRhs().accept(this);
		return vlhs.leq(vrhs);
	}

	@Override
	public Value visit(LT lt) {
		Value vlhs = lt.getLhs().accept(this);
		Value vrhs = lt.getRhs().accept(this);
		return vlhs.lt(vrhs);
	}

	@Override
	public Value visit(Mul mul) {
		Value vlhs = mul.getLhs().accept(this);
		Value vrhs = mul.getRhs().accept(this);
		return vlhs.mul(vrhs);
	}

	@Override
	public Value visit(Neg neg) {
		Value vx = neg.getExpr().accept(this);
		return vx.lt(vx);
	}

	@Override
	public Value visit(NEq neq) {
		Value vlhs = neq.getLhs().accept(this);
		Value vrhs = neq.getRhs().accept(this);
		return vlhs.neq(vrhs);
	}

	@Override
	public Value visit(Not not) {
		Value vx = not.getExpr().accept(this);
		return vx.lt(vx);
	}

	@Override
	public Value visit(Or or) {
		Value vlhs = or.getLhs().accept(this);
		Value vrhs = or.getRhs().accept(this);
		return vlhs.or(vrhs);
	}

	@Override
	public Value visit(Pos pos) {
		Value vx = pos.getExpr().accept(this);
		return vx.pos(vx);
	}

	@Override
	public Value visit(Sub sub) {
		Value vlhs = sub.getLhs().accept(this);
		Value vrhs = sub.getRhs().accept(this);
		return vlhs.sub(vrhs);
	}
	
	@Override
	public Value visit(Bool boolexpression) {
		if(boolexpression.getValue().equals(ValueKeywords.BOOLEAN)){
			return new VBool(false);
		}
		try{
			Boolean val = Boolean.parseBoolean(boolexpression.getValue());
			return new VBool(val);
		} catch(NumberFormatException ex) {
			return new VError(ex.getMessage());
		}
	}

	@Override
	public Value visit(Int intexpression) {
		if(intexpression.getValue().equals(ValueKeywords.INTEGER)){
			return new VInt(0);
		}
		try{
			int val = Integer.parseInt(intexpression.getValue());
			return new VInt(val);
		} catch(NumberFormatException ex) {
			return new VError(ex.getMessage());
		}
	}

	@Override
	public Value visit(Str strexpression) {
		return null;
	}

	@Override
	public Value visit(Money moneyexpression) {
		if(moneyexpression.getValue().equals(ValueKeywords.MONEY)){
			return new VMoney(0.0);
		}
		try{
			Double val = Double.parseDouble(moneyexpression.getValue());
			return new VMoney(val);
		} catch(NumberFormatException ex) {
			return new VError(ex.getMessage());
		}
	}

	@Override
	public Value visit(Ident identexpression) {
		if(this.valueEnvironment.containsKey(identexpression)) {
			return this.valueEnvironment.get(identexpression);
		}
		return new VError("Undefined Ident: " + identexpression);
	}

	@Override
	public Value visit(CompBool strexpression) {
		Value vx = strexpression.getExpr().accept(this);
		return vx;
	}

	@Override
	public Value visit(CompMoney moneyexpression) {
		Value vx = moneyexpression.getExpr().accept(this);
		return vx;
	}

	@Override
	public Value visit(CompInt intexpression) {
		Value vx = intexpression.getExpr().accept(this);
		return vx;
	}
}
