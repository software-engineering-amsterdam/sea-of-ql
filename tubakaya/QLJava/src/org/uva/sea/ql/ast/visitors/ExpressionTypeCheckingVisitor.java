package org.uva.sea.ql.ast.visitors;

import java.util.Map;

import org.uva.sea.ql.ast.ExpressionTypeVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.ArithmeticOperator;
import org.uva.sea.ql.ast.operators.ConditionalOperator;
import org.uva.sea.ql.ast.operators.RelationalOperator;
import org.uva.sea.ql.ast.operators.UnaryArithmeticOperator;
import org.uva.sea.ql.ast.operators.UnaryLogicalOperator;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.conditional.And;
import org.uva.sea.ql.ast.operators.conditional.Or;
import org.uva.sea.ql.ast.operators.relational.Eq;
import org.uva.sea.ql.ast.operators.relational.GEq;
import org.uva.sea.ql.ast.operators.relational.GT;
import org.uva.sea.ql.ast.operators.relational.LEq;
import org.uva.sea.ql.ast.operators.relational.LT;
import org.uva.sea.ql.ast.operators.relational.NEq;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.NonDeclaredType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.literals.BooleanLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

public class ExpressionTypeCheckingVisitor implements ExpressionTypeVisitor {

	private Map<Identifier, Type> identifierTypeMap;

	public ExpressionTypeCheckingVisitor(Map<Identifier, Type> identifierTypeMap) {
		this.identifierTypeMap = identifierTypeMap;
	}

	@Override
	public Type visit(BooleanLiteral booleanLiteral) {
		return new BooleanType();
	}

	@Override
	public Type visit(Identifier identifier) {
		if (identifierTypeMap.containsKey(identifier)) {
			return identifierTypeMap.get(identifier);
		}

		return new NonDeclaredType();
	}

	@Override
	public Type visit(IntLiteral integerLiteral) {
		return new IntegerType();
	}

	@Override
	public Type visit(StringLiteral stringLiteral) {
		return new StringType();
	}

	@Override
	public Type visit(Add add) {
		return visitBase(add);
	}

	@Override
	public Type visit(Div div) {
		return visitBase(div);
	}

	@Override
	public Type visit(Sub sub) {
		return visitBase(sub);
	}

	@Override
	public Type visit(Mul mul) {
		return visitBase(mul);
	}

	@Override
	public Type visit(And and) {
		return visitBase(and);
	}

	@Override
	public Type visit(Or or) {
		return visitBase(or);
	}

	@Override
	public Type visit(Eq eq) {
		return visitBase(eq);
	}

	@Override
	public Type visit(GEq gEq) {
		return visitBase(gEq);
	}

	@Override
	public Type visit(GT gT) {
		return visitBase(gT);
	}

	@Override
	public Type visit(LEq lEq) {
		return visitBase(lEq);
	}

	@Override
	public Type visit(LT lT) {
		return visitBase(lT);
	}

	@Override
	public Type visit(NEq nEq) {
		return visitBase(nEq);
	}

	@Override
	public Type visit(Neg neg) {
		return visitBase(neg);
	}

	@Override
	public Type visit(Not not) {
		return visitBase(not);
	}

	@Override
	public Type visit(Pos pos) {
		return visitBase(pos);
	}

	private Type visitBase(ArithmeticOperator arithmeticOperator) {
		return new IntegerType();
	}

	private Type visitBase(ConditionalOperator conditionalOperator) {
		return new BooleanType();
	}

	private Type visitBase(RelationalOperator conditionalOperator) {
		return new BooleanType();
	}

	private Type visitBase(UnaryArithmeticOperator conditionalOperator) {
		return new IntegerType();
	}

	private Type visitBase(UnaryLogicalOperator conditionalOperator) {
		return new BooleanType();
	}
}
