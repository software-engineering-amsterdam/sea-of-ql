package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.GreaterOrEquals;
import org.uva.sea.ql.ast.exp.GreaterThan;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.exp.Multiply;
import org.uva.sea.ql.ast.exp.Negative;
import org.uva.sea.ql.ast.exp.Not;
import org.uva.sea.ql.ast.exp.NotEquals;
import org.uva.sea.ql.ast.exp.Or;
import org.uva.sea.ql.ast.exp.Positive;
import org.uva.sea.ql.ast.exp.SmallerOrEquals;
import org.uva.sea.ql.ast.exp.SmallerThan;
import org.uva.sea.ql.ast.exp.Substitute;
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

	/**
	 * 
	 * @param identifier
	 * @return
	 * @throws UnmodifiedException
	 *             if the value is not known yet
	 */
	Value visit(Identifier identifier) throws UnmodifiedException;

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

}
