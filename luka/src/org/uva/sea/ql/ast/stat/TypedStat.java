package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class TypedStat extends Stat{
	protected Ident identifier;
	protected String label;
	protected Type type;
	
	public TypedStat(Ident ident, String label, Type type){
		this.identifier = ident;
		this.label = label;
		this.type =type;
	}
	
	public Type getType(){
		return type;
	}
	
}
