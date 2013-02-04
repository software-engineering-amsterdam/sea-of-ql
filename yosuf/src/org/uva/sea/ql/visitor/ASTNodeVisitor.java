package org.uva.sea.ql.visitor;

import org.jpatterns.gof.VisitorPattern;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
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

@VisitorPattern
public interface ASTNodeVisitor {

	void visit(Question question);

	void visit(Add add);

	void visit(And and);

	void visit(Divide divide);

	void visit(Equals equals);

	void visit(GreaterOrEquals greaterOrEquals);

	void visit(GreaterThan greaterThan);

	void visit(Multiply multiply);

	void visit(Negative negative);

	void visit(Not not);

	void visit(NotEquals notEquals);

	void visit(Or or);

	void visit(Positive positive);

	void visit(SmallerOrEquals smallerOrEquals);

	void visit(SmallerThan smallerThan);

	void visit(Substitute substitute);

	void visit(Identifier identifier);

	void visit(Computed computed);

	void visit(StringValue stringValue);

	void visit(IntegerValue integerValue);

	void visit(StringType stringType);

	void visit(MoneyType moneyType);

	void visit(IntegerType integerType);

	void visit(BooleanType booleanType);

	void visit(CompoundStatement compoundStatement);

	void visit(IfStatement ifStatement);

	void visit(Form form);

	void visit(BooleanValue booleanValue);

}
