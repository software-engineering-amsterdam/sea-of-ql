package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.*;

public abstract class Type implements ASTNode {

	public abstract boolean isCompatibleWith(Type t);
	
	public boolean isCompatibleWithInt()     { return false; }
	public boolean isCompatibleWithMoney()   { return false; }
	public boolean isCompatibleWithNumeric() { return false; }
	public boolean isCompatibleWithStr()     { return false; }
	public boolean isCompatibleWithBool()    { return false; }
	
	public abstract <T> T accept(TypeVisitor<T> visitor);
	
}
