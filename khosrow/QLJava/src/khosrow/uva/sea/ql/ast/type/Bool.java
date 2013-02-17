package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.BoolVal;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.ITypeVisitor;


public class Bool extends Type {

	@Override
	public Value initialize() {
		return new BoolVal(false);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
