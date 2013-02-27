package org.uva.sea.ql.semanticchecker;

import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.Type;

public class ExpressionTypeValidatorUtil {
	
	private ExpressionTypeValidatorUtil() {
		
	}
	
	public static boolean checkExprIsOfType(Expr expr, Type type, SemanticVisitor visitor, final ValidationReport errors) {
		Type exprType = (Type) expr.accept(visitor);
		if (!exprType.equals(type)) {
			errors.addError("The type of the expression " + expr + " must be " + type);
			return false;
		}
		return true;
	}
	
	public static boolean checkConditionalExpr(Expr cond, SemanticVisitor visitor, final ValidationReport errors) {
		Type exprType = (Type) cond.accept(visitor);
		if (!exprType.equals(ReturnTypeHolder.getBoolType())) {
			errors.addError("The type of the expression " + cond + " in a conditional structure must be boolean");
			return false;
		}
		return true;
	}
	
	public static boolean checkBinaryExprMembersAreInt(Binary binary, SemanticVisitor visitor, final ValidationReport errors) {

		return checkBinaryExprMembersShareGivenType(new IntegerType(), binary, visitor, errors);
	}

	public static boolean checkBinaryExprMembersAreBoolean(Binary binary, SemanticVisitor visitor, final ValidationReport errors) {

		return checkBinaryExprMembersShareGivenType(ReturnTypeHolder.getBoolType(), binary, visitor, errors);
	}

	public static boolean checkBinaryExprMembersShareSameType(Binary binary, SemanticVisitor visitor, final ValidationReport errors) {

		Type leftExprType = (Type) binary.getLeftExpr().accept(visitor);
		Type rightExprType = (Type) binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(rightExprType)) {
			errors.addError("Both members of the expression " + binary + " must share the same type.");
			return false;
		}
		return true;
	}

	public static boolean checkBinaryExprMembersShareSameNumericType(Binary binary, SemanticVisitor visitor, final ValidationReport errors) {

		Type leftExprType = (Type) binary.getLeftExpr().accept(visitor);
		Type rightExprType = (Type) binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(rightExprType) ||  !(leftExprType.equals(ReturnTypeHolder.getIntType()))) {
			errors.addError("Both members of the expression " + binary + " must share the same numeric type.");
			return false;
		}
		return true;
	}

	public static boolean checkBinaryExprMembersShareGivenType(Type type, Binary binary, SemanticVisitor visitor, final ValidationReport errors) {

		Type leftExprType = (Type) binary.getLeftExpr().accept(visitor);
		Type rightExprType = (Type) binary.getRightExpr().accept(visitor);
		if (!leftExprType.equals(type) || !rightExprType.equals(type)) {
			errors.addError("Both members of the expression " + binary + " must be of type " + type.toString() + ". Instead, left is " + leftExprType + " and right is " + rightExprType);
			return false;
		}
		return true;
	}


}
