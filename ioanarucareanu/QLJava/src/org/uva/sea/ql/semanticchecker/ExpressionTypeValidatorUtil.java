package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.TypeFactory;

public class ExpressionTypeValidatorUtil {
	
	private ExpressionTypeValidatorUtil() {
		
	}
	
	public static boolean checkBinaryExprMembersAreInt(Binary binary, ExpressionSemanticVisitor visitor, final ValidationErrors errors) {

		return checkBinaryExprMembersShareGivenType(new IntegerType(), binary, visitor, errors);
	}

	public static boolean checkBinaryExprMembersAreBoolean(Binary binary, ExpressionSemanticVisitor visitor, final ValidationErrors errors) {

		return checkBinaryExprMembersShareGivenType(TypeFactory.getBoolType(), binary, visitor, errors);
	}

	public static boolean checkBinaryExprMembersShareSameType(Binary binary, ExpressionSemanticVisitor visitor, final ValidationErrors errors) {

		Type leftExprType = binary.getLeftExpr().accept(visitor);
		Type rightExprType = binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(rightExprType)) {
			errors.addError("Both members of the expression " + binary.getOperator() + " must share the same type.");
			return false;
		}
		return true;
	}

	public static boolean checkBinaryExprMembersShareSameNumericType(Binary binary, ExpressionSemanticVisitor visitor, final ValidationErrors errors) {

		Type leftExprType = binary.getLeftExpr().accept(visitor);
		Type rightExprType = binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(rightExprType) || !leftExprType.equals(TypeFactory.getDecType())) {
			errors.addError("Both members of the expression " + binary.getOperator() + " must share the same numeric type.");
			return false;
		}
		return true;
	}

	public static boolean checkBinaryExprMembersShareGivenType(Type type, Binary binary, ExpressionSemanticVisitor visitor, final ValidationErrors errors) {

		Type leftExprType = binary.getLeftExpr().accept(visitor);
		Type rightExprType = binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(type) || !rightExprType.equals(type)) {
			errors.addError("Both members of the expression " + binary.getOperator() + " must be of type " + type.getHumanReadableType());
			return false;
		}
		return true;
	}


}
