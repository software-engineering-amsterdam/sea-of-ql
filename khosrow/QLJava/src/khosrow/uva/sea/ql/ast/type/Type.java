package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.ast.ASTNode;

public abstract class Type extends ASTNode {
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToInt() { return false;}
	public boolean isCompatibleToBool() { return false;}
	public boolean isCompatibleToMoney() { return false;}
	public boolean isCompatibleToNumeric() { return false;}
	public boolean isCompatibleToStr() { return false;}

}
