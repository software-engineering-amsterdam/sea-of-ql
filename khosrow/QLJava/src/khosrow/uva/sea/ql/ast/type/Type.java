package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.resources.ITypeCompatible;
import khosrow.uva.sea.ql.values.Value;

public abstract class Type extends ASTNode implements ITypeCompatible {
	public abstract boolean isCompatibleTo(Type t);
	public abstract Value initialize();
	
	public boolean isCompatibleToInt() { return false;}
	public boolean isCompatibleToBool() { return false;}
	public boolean isCompatibleToMoney() { return false;}
	public boolean isCompatibleToNumeric() { return false;}
	public boolean isCompatibleToStr() { return false;}
	public boolean isError() { return false; }

}
