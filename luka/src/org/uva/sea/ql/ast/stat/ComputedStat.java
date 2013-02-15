package org.uva.sea.ql.ast.stat;

import java.util.Observer;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public abstract class ComputedStat extends TypedStat{

	private Value value;
	private Expr expression;
	
	public ComputedStat(Ident ident, String label, Type type,Expr computableExpr) {
		super(ident, label,type);
		this.expression = computableExpr;
	}

	public Expr getExpr() {
		return this.expression;
	}
	
	private Value computeValue(){
		return value;
	}
	
	public Value getValue(){
		return computeValue();
	}

	

}
