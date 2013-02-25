package org.uva.sea.ql.parser.evaluator.result.visitor;

import org.uva.sea.ql.parser.evaluator.result.BoolValue;
import org.uva.sea.ql.parser.evaluator.result.IntValue;
import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.UndefinedValue;

public interface ValueVisitor<T> {

	T visit(BoolValue value);
	T visit(IntValue value);
	T visit(StrValue value);
	T visit(UndefinedValue value);

}
