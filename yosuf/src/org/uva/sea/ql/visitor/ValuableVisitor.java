package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.exp.Add;
import org.uva.sea.ql.ast.exp.And;
import org.uva.sea.ql.ast.exp.Divide;
import org.uva.sea.ql.ast.exp.Equals;
import org.uva.sea.ql.ast.exp.Expression;
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
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public interface ValuableVisitor {

	IntegerValue visit(Add add);

	BooleanValue visit(And and);

	IntegerValue visit(Divide divide);

	BooleanValue visit(Equals equals);

	BooleanValue visit(GreaterOrEquals greaterOrEquals);

	BooleanValue visit(GreaterThan greaterThan);

	Expression<?> visit(Identifier identifier);

	IntegerValue visit(Multiply multiply);

	IntegerValue visit(Negative negative);

	BooleanValue visit(Not not);

	BooleanValue visit(NotEquals notEquals);

	BooleanValue visit(Or or);

	IntegerValue visit(Positive positive);

	BooleanValue visit(SmallerOrEquals smallerOrEquals);

	BooleanValue visit(SmallerThan smallerThan);

	IntegerValue visit(Substitute substitute);

	BooleanValue visit(BooleanValue booleanValue);

	IntegerValue visit(IntegerValue integerValue);

	StringValue visit(StringValue stringValue);

}
