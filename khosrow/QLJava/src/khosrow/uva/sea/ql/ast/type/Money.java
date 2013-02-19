package khosrow.uva.sea.ql.ast.type;

import khosrow.uva.sea.ql.values.MoneyVal;
import khosrow.uva.sea.ql.values.Value;
import khosrow.uva.sea.ql.visitor.ITypeVisitor;

public class Money extends Numeric{
	
	@Override
	public Value initialize() {
		return new MoneyVal(0);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
	
	@Override
	public <T> T accept(ITypeVisitor<T> visitor){
		return visitor.visit(this);
	}
}
