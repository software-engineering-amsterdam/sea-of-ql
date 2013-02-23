package eu.karuza.ql.ast.type;

import eu.karuza.ql.ast.value.Text;
import eu.karuza.ql.ast.value.Value;

public class TextType extends Type {

	@Override
	public Value getMatchingNode(int lineNumber) {
		return new Text(lineNumber);
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToTextString();
	}

	@Override
	public boolean isCompatibleToTextString() {
		return true;
	}

	@Override
	public Type leastUpperBound(Type otherType) {
		return otherType.leastUpperBoundFromText(this);
	}
	
	@Override
	public Type leastUpperBoundFromInt(IntType type) {
		return this;
	}
	
	@Override
	public Type leastUpperBoundFromMoney(MoneyType type) {
		return this;
	}
	
	@Override
	public Type leastUpperBoundFromBool(BoolType type) {
		return this;
	}
	
	@Override
	public Type leastUpperBoundFromText(TextType type) {
		return this;
	}
	
	@Override
	public boolean isCompatibleWithAdd() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithEq() {
		return true;
	}
	
	@Override
	public boolean isCompatibleWithNEq() {
		return true;
	}

}
