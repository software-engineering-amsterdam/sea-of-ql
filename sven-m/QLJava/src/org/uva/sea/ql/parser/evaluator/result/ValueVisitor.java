package org.uva.sea.ql.parser.evaluator.result;

public interface ValueVisitor<T> {
	
	T visit(BoolValue value);
	T visit(IntValue value);
	T visit(StrValue value);
	T visit(UndefinedValue value);
	
}
