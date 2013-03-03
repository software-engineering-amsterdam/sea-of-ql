package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.ast.value.Value;

public interface ExpressionVisitor {

	Value visit(Add add);

	Value visit(And and);

	Value visit(Divide divide);

	Value visit(Equals equals);

	Value visit(GreaterOrEquals greaterOrEquals);

	Value visit(GreaterThan greaterThan);

	Value visit(Multiply multiply);

	Value visit(Negative negative);

	Value visit(Not not);

	Value visit(NotEquals notEquals);

	Value visit(Or or);

	Value visit(Positive positive);

	Value visit(SmallerOrEquals smallerOrEquals);

	Value visit(SmallerThan smallerThan);

	Value visit(Substitute substitute);

	Value visit(BooleanValue booleanValue);

	Value visit(NumericValue integerValue);

	Value visit(StringValue stringValue);

	/**
	 * 
	 * @param identifier
	 * @return
	 * @throws UnmodifiedException
	 *             if the value is not known yet
	 */
	Value visit(Identifier identifier) throws UnmodifiedException;

}
