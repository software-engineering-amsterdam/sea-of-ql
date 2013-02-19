package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Arr;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class SelectableStat extends TypedStat {

	private final Arr arr;

	public SelectableStat(Ident ident, String label, Type type, Arr arr) {
		super(ident, label, type);
		this.arr = arr;
	}
	
	public Arr getArr(){
		return this.arr;
	}

	@Override
	public void accept(StatementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "SelectableStat Ident(" + this.ident.getName() + ") Type("
				+ this.type.toString() + ") Label(" + this.getLabel()
				+ ") ArrSize(" + this.arr.getValues().size()+ ")";
	}
}
