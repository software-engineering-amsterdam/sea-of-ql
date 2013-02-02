package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.ast.ASTNode;

public abstract class Type extends ASTNode {
	public abstract boolean IsCompatibleTo(Type t);
	
	public boolean IsCompatibleToInt() { return false;}
	public boolean IsCompatibleToBool() { return false;}
	public boolean IsCompatibleToMoney() { return false;}
	public boolean IsCompatibleToNumeric() { return false;}
	public boolean IsCompatibleToStr() { return false;}

}
