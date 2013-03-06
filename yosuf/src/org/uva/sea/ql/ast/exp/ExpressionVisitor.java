package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.StringValue;

public interface ExpressionVisitor<T> {

	T visit(Add add);

	T visit(And and);

	T visit(Divide divide);

	T visit(Equals equals);

	T visit(GreaterOrEquals greaterOrEquals);

	T visit(GreaterThan greaterThan);

	T visit(Multiply multiply);

	T visit(Negative negative);

	T visit(Not not);

	T visit(NotEquals notEquals);

	T visit(Or or);

	T visit(Positive positive);

	T visit(SmallerOrEquals smallerOrEquals);

	T visit(SmallerThan smallerThan);

	T visit(Substitute substitute);

	T visit(BooleanValue booleanValue);

	T visit(NumericValue integerValue);

	T visit(StringValue stringValue);

	/**
	 * 
	 * @param identifier
	 * @return
	 * @throws UnmodifiedException
	 *             if the T is not known yet
	 */
	T visit(Identifier identifier) throws UnmodifiedException;

}
