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
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.ast.value.StringValue;

public interface NaturalVisitor<T> {

	T visit(Add add);

	T visit(IntegerValue integerValue);

	T visit(And and);

	T visit(Divide divide);

	T visit(Equals equals);

	T visit(GreaterOrEquals greaterOrEquals);

	T visit(BooleanValue booleanValue);

	T visit(StringValue stringValue);

	T visit(GreaterThan greaterThan);

	T visit(Identifier identifier);

	T visit(Multiply multiply);

	T visit(Negative negative);

	T visit(Not not);

	T visit(NotEquals notEquals);

	T visit(Or or);

	T visit(Positive positive);

	T visit(SmallerOrEquals smallerOrEquals);

	T visit(SmallerThan smallerThan);

	T visit(Substitute substitute);

	T visit(BooleanType booleanType);

	T visit(IntegerType integerType);

	T visit(MoneyType moneyType);

	T visit(StringType stringType);

}
