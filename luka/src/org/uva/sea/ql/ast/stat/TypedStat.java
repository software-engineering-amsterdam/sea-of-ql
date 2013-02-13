package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;

public abstract class TypedStat extends Stat{
	protected final Ident ident;
	protected final String label;
	protected final Type type;
	
	public TypedStat(Ident ident, String label, Type type){
		this.ident = ident;
		this.label = label;
		this.type =type;
	}
	
	public Ident getIdent(){
		return this.ident;
	}
	public String getLabel(){
		return this.label;
	}
	public Type getType(){
		return this.type;
	}
	
}
