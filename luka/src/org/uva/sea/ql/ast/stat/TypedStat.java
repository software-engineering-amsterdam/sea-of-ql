package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.nodes.values.Value;

public abstract class TypedStat extends Stat{
	protected Ident identifier;
	protected String label;
	protected Value value;
	
	public TypedStat(Ident ident, String label, Value value){
		this.identifier = ident;
		this.label = label;
		this.value =value;
	}
	
}
