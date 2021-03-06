package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.BinaryExpression;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.arithmetic.BinaryArithmeticalExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.arithmetic.NegativeExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.PositiveExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.logical.BinaryLogicalExpression;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentOrNotExpression;
import org.uva.sea.ql.ast.expressions.logical.NegationalExpression;
import org.uva.sea.ql.ast.expressions.relational.BinaryRelationalExpression;
import org.uva.sea.ql.ast.expressions.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.NotEqualToExpression;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.NullValue;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;
import org.uva.sea.ql.parser.errors.ErrorMessages;

public class TypeChecker extends ExpressionChecker implements Visitor<Boolean> {
	
	private TypeChecker(TypeEnvironment typeEnvironment, ErrorMessages messages) {
		super(typeEnvironment, messages);
	}
	
	public static boolean check(Expression expression, TypeEnvironment typeEnvironment, ErrorMessages errors) {
		TypeChecker expressionChecker = new TypeChecker(typeEnvironment, errors);
		return expression.accept(expressionChecker);
	}
	
	@Override
	public Boolean visit(Addition astNode)                         { return checkArithmeticExpression(astNode, "+"); }
	@Override
	public Boolean visit(Division astNode)                         { return checkArithmeticExpression(astNode, "/"); }
	@Override
	public Boolean visit(Subtraction astNode)                      { return checkArithmeticExpression(astNode, "-"); }
	@Override
	public Boolean visit(Multiplication astNode)                   { return checkArithmeticExpression(astNode, "*"); }

	@Override
	public Boolean visit(EqualToExpression astNode)                { return checkRelationalExpression(astNode, "=="); }
	@Override
	public Boolean visit(GreaterThanOrEqualToExpression astNode)   { return checkRelationalExpression(astNode, ">="); }
	@Override
	public Boolean visit(GreaterThanExpression astNode)            { return checkRelationalExpression(astNode, ">");  }
	@Override
	public Boolean visit(LessThanOrEqualToExpression astNode)      { return checkRelationalExpression(astNode, "<="); }
	@Override
	public Boolean visit(LessThanExpression astNode)               { return checkRelationalExpression(astNode, "<");  }
	@Override
	public Boolean visit(NotEqualToExpression astNode)             { return checkRelationalExpression(astNode, "!="); }
	
	@Override
	public Boolean visit(LogicallyEquivalentExpression astNode)    { return checkLogicalExpression(astNode, "&&"); }
	@Override
	public Boolean visit(LogicallyEquivalentOrNotExpression astNode) { return checkLogicalExpression(astNode, "||"); }

	@Override
	public Boolean visit(NegativeExpression astNode)               { return checkUnaryArithmeticExpression(astNode, "--"); }
	@Override
	public Boolean visit(PositiveExpression astNode)               { return checkUnaryArithmeticExpression(astNode, "++"); }
	@Override
	public Boolean visit(NegationalExpression astNode)             { return checkUnaryLogicalExpression(astNode, "!");  }

	@Override
	public Boolean visit(Bool astNode)                             { return checkLiteralExpression(astNode, astNode.getValue().toString()); }
	@Override
	public Boolean visit(Identifier astNode)                       { return checkLiteralExpression(astNode, "identifier name ''" + astNode.getValue() + "''"); }
	@Override
	public Boolean visit(Int astNode)                              { return checkLiteralExpression(astNode, astNode.getValue().toString()); }
	@Override
	public Boolean visit(Money astNode)                            { return checkLiteralExpression(astNode, astNode.getValue().toString()); }
	@Override
	public Boolean visit(Str astNode)                              { return checkLiteralExpression(astNode, astNode.getValue()); }
	@Override
	public Boolean visit(NullValue astNode) 					   { return false; }
	
	private Boolean checkArithmeticExpression(BinaryArithmeticalExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleToNumeric(expression, binarySymbol);
	}
	
	private Boolean checkRelationalExpression(BinaryRelationalExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleTo(expression, binarySymbol); 
	}
	
	private Boolean checkLogicalExpression(BinaryLogicalExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleToBool(expression, binarySymbol);
	}
	
	private boolean isAValidExpression(BinaryExpression expression) {
		Expression leftHandSide  = getLeftHandSide(expression);
		Expression rightHandSide = getRightHandSide(expression);
		
		boolean checkLeftHandSide  = leftHandSide.accept(this);
		boolean checkRightHandSide = rightHandSide.accept(this);
		
		return checkLeftHandSide && checkRightHandSide;
	}
	
}