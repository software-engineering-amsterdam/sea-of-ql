package eu.karuza.ql.ast.type;

import eu.karuza.ql.ast.value.Value;

public class ErrorType extends Type {

	@Override
	public Value getMatchingNode(int lineNumber) {
		return null;
	}

	@Override
	public boolean isCompatibleTo(Type type) {
		return false;
	}

	@Override
	public Type leastUpperBound(Type otherType) {
		return this;
	}
	
	@Override
	public boolean isError() {
		return true;
	}

}
