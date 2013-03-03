package org.uva.sea.ql.ast.visitors;

import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.*;
import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.conditional.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.types.literals.*;
import org.uva.sea.ql.parsers.exceptions.ExpressionNotValidException;
import org.uva.sea.ql.parsers.exceptions.IdentifierNotDefinedException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class ExpressionCheckingVisitor implements ExpressionVisitor {

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
	public void visit(Identifier identifier) {
		if (!identifierTypeMap.containsKey(identifier)) {
			addExceptionInExceptionsList(identifier);
		}
	}

	@Override
	public void visit(BooleanLiteral booleanLiteral) {
	}

	@Override
	public void visit(IntLiteral integerLiteral) {
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
	}

	@Override
	public void visit(Add add) {
		visitBase(add);
	}

	@Override
	public void visit(Div div) {
		visitBase(div);
	}

	@Override
	public void visit(Sub sub) {
		visitBase(sub);
	}

	@Override
	public void visit(Mul mul) {
		visitBase(mul);
	}

	@Override
	public void visit(And and) {
		visitBase(and);
	}

	@Override
	public void visit(Or or) {
		visitBase(or);
	}

	@Override
	public void visit(Eq eq) {
		visitBase(eq);
	}

	@Override
	public void visit(GEq gEq) {
		visitBase(gEq);
	}

	@Override
	public void visit(GT gT) {
		visitBase(gT);
	}

	@Override
	public void visit(LEq lEq) {
		visitBase(lEq);
	}

	@Override
	public void visit(LT lT) {
		visitBase(lT);
	}

	@Override
	public void visit(NEq nEq) {
		visitBase(nEq);
	}

	@Override
	public void visit(Neg neg) {
		visitBase(neg);
	}

	@Override
	public void visit(Not not) {
		visitBase(not);
	}

	@Override
	public void visit(Pos pos) {
		visitBase(pos);
	}

	private void addExceptionInExceptionsList(Identifier identifier) {
		this.exceptions.add(new IdentifierNotDefinedException(identifier));
	}

	private void addExceptionInExceptionsList(Expression expression) {
		this.exceptions.add(new ExpressionNotValidException(expression));
	}

	private void visitBase(ArithmeticOperator arithmeticOperator) {

		Expression lhs = arithmeticOperator.getLhs();
		Expression rhs = arithmeticOperator.getRhs();

		lhs.accept(this);
		rhs.accept(this);

		Type compatibleType = new IntegerType();
		checkExpressionTypeCompatibility(lhs, compatibleType);
		checkExpressionTypeCompatibility(rhs, compatibleType);
	}

	private void checkExpressionTypeCompatibility(Expression lhs,
			Type compatibleType) {
		
		Type typeLhs = lhs.accept(expressionTypeCheckingVisitor);

		if (!typeLhs.isCompatibleTo(compatibleType)) {
			addExceptionInExceptionsList(lhs);
		}
	}

	private void visitBase(ConditionalOperator conditionalOperator) {

		Expression lhs = conditionalOperator.getLhs();
		Expression rhs = conditionalOperator.getRhs();

		lhs.accept(this);
		rhs.accept(this);

		Type compatibleType = new BooleanType();
		checkExpressionTypeCompatibility(lhs, compatibleType);
		checkExpressionTypeCompatibility(rhs, compatibleType);
	}

	private void visitBase(RelationalOperator relationalOperator) {

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
	}

	private void visitBase(UnaryArithmeticOperator unaryArithmeticOperator) {
		visitBase(unaryArithmeticOperator, new IntegerType());
	}

	private void visitBase(UnaryLogicalOperator unaryLogicalOperator) {
		visitBase(unaryLogicalOperator, new BooleanType());
	}

	private void visitBase(UnaryOperator unaryLogicalOperator,
			Type compatibleType) {
		Expression expression = unaryLogicalOperator.getExpression();
		expression.accept(this);

		Type type = expression.accept(expressionTypeCheckingVisitor);

		if (!type.isCompatibleTo(compatibleType)) {
			addExceptionInExceptionsList(expression);
		}
	}
}
