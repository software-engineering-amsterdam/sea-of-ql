package org.uva.sea.ql.ast.visitors;

import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.operators.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.parsers.exceptions.ExpressionNotValidException;
import org.uva.sea.ql.parsers.exceptions.IdentifierNotDefinedException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class ExpressionCheckingVisitor implements ExpressionVisitor<Boolean> {

	private Map<Identifier, Type> identifierTypeMap;
	private List<QLException> exceptions;
	private ExpressionTypeFindingVisitor expressionTypeCheckingVisitor;

	public ExpressionCheckingVisitor(Map<Identifier, Type> identifierTypeMap,
			List<QLException> exceptions) {
		this.identifierTypeMap = identifierTypeMap;
		this.exceptions = exceptions;
		this.expressionTypeCheckingVisitor = new ExpressionTypeFindingVisitor(
				identifierTypeMap);
	}

	@Override
	public Boolean visit(Identifier identifier) {
		if (!identifierTypeMap.containsKey(identifier)) {
			addExceptionInExceptionsList(identifier);
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(BooleanLiteral booleanLiteral) {
		return true;
	}

	@Override
	public Boolean visit(IntLiteral integerLiteral) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		return true;
	}

	@Override
	public Boolean visit(Add add) {
		return visitBase(add);
	}

	@Override
	public Boolean visit(Div div) {
		return visitBase(div);
	}

	@Override
	public Boolean visit(Sub sub) {
		return visitBase(sub);
	}

	@Override
	public Boolean visit(Mul mul) {
		return visitBase(mul);
	}

	@Override
	public Boolean visit(And and) {
		return visitBase(and);
	}

	@Override
	public Boolean visit(Or or) {
		return visitBase(or);
	}

	@Override
	public Boolean visit(Eq eq) {
		return visitBase(eq);
	}

	@Override
	public Boolean visit(GEq gEq) {
		return visitBase(gEq);
	}

	@Override
	public Boolean visit(GT gT) {
		return visitBase(gT);
	}

	@Override
	public Boolean visit(LEq lEq) {
		return visitBase(lEq);
	}

	@Override
	public Boolean visit(LT lT) {
		return visitBase(lT);
	}

	@Override
	public Boolean visit(NEq nEq) {
		return visitBase(nEq);
	}

	@Override
	public Boolean visit(Neg neg) {
		return visitBase(neg);
	}

	@Override
	public Boolean visit(Not not) {
		return visitBase(not);
	}

	@Override
	public Boolean visit(Pos pos) {
		return visitBase(pos);
	}

	private void addExceptionInExceptionsList(Identifier identifier) {
		this.exceptions.add(new IdentifierNotDefinedException(identifier));
	}

	private void addExceptionInExceptionsList(Expression expression) {
		this.exceptions.add(new ExpressionNotValidException(expression));
	}

	private Boolean visitBase(ArithmeticOperator arithmeticOperator) {

		Expression lhs = arithmeticOperator.getLhs();
		Expression rhs = arithmeticOperator.getRhs();

		lhs.accept(this);
		rhs.accept(this);

		Type compatibleType = new IntegerType();
		checkExpressionTypeCompatibility(lhs, compatibleType);
		checkExpressionTypeCompatibility(rhs, compatibleType);
		
		return true;
	}

	private Boolean checkExpressionTypeCompatibility(Expression lhs,
			Type compatibleType) {
		
		Type typeLhs = lhs.accept(expressionTypeCheckingVisitor);

		if (!typeLhs.isCompatibleTo(compatibleType)) {
			addExceptionInExceptionsList(lhs);
		}
		return true;
	}

	private Boolean visitBase(ConditionalOperator conditionalOperator) {

		Expression lhs = conditionalOperator.getLhs();
		Expression rhs = conditionalOperator.getRhs();

		lhs.accept(this);
		rhs.accept(this);

		Type compatibleType = new BooleanType();
		checkExpressionTypeCompatibility(lhs, compatibleType);
		checkExpressionTypeCompatibility(rhs, compatibleType);
		return true;
	}

	private Boolean visitBase(RelationalOperator relationalOperator) {

		Expression lhs = relationalOperator.getLhs();
		Expression rhs = relationalOperator.getRhs();

		lhs.accept(this);
		rhs.accept(this);

		Type typeLhs = lhs.accept(expressionTypeCheckingVisitor);
		Type typeRhs = rhs.accept(expressionTypeCheckingVisitor);

		if (!(typeLhs.isCompatibleToInteger() && typeRhs
				.isCompatibleToInteger())) {
			if (!(typeLhs.isCompatibleToBoolean() && typeRhs
					.isCompatibleToBoolean())) {
				addExceptionInExceptionsList(relationalOperator.getLhs());
				addExceptionInExceptionsList(relationalOperator.getRhs());
			}
		}
		
		return true;
	}

	private Boolean visitBase(UnaryArithmeticOperator unaryArithmeticOperator) {
		return visitBase(unaryArithmeticOperator, new IntegerType());
	}

	private Boolean visitBase(UnaryLogicalOperator unaryLogicalOperator) {
		return visitBase(unaryLogicalOperator, new BooleanType());
	}

	private Boolean visitBase(UnaryOperator unaryLogicalOperator,
			Type compatibleType) {
		Expression expression = unaryLogicalOperator.getExpression();
		expression.accept(this);

		Type type = expression.accept(expressionTypeCheckingVisitor);

		if (!type.isCompatibleTo(compatibleType)) {
			addExceptionInExceptionsList(expression);
			return false;
		}
		return true;
	}
}
