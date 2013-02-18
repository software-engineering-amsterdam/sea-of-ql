package org.uva.sea.ql.visitor.typeCheck;

import java.util.List;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionTypeVisitor implements IExpressionVisitor<Boolean> {
	private final TypeMapper typeMapper;
	private final List<Message> errors;

	public ExpressionTypeVisitor(TypeMapper typeMapper, List<Message> errors) {
		this.typeMapper = typeMapper;
		this.errors = errors;
	}

	public static boolean check(Expr expr, TypeMapper typeMapper,
			List<Message> errs) {
		ExpressionTypeVisitor check = new ExpressionTypeVisitor(typeMapper, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}
		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(And expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreBoolean(expr);
	}

	@Override
	public Boolean visit(Div expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(Eq expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreBooleanOrNumeric(expr);
	}

	@Override
	public Boolean visit(GEq expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(GT expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(LEq expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(LT expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(Mul expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(NEq expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreBooleanOrNumeric(expr);
	}

	@Override
	public Boolean visit(Or expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreBoolean(expr);
	}

	@Override
	public Boolean visit(Sub expr) {
		if (!checkBinaryNode(expr)) {
			return false;
		}

		return bothSidesAreNumeric(expr);
	}

	@Override
	public Boolean visit(Neg expr) {
		if (!expr.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToNumeric(expr);
	}

	@Override
	public Boolean visit(Not expr) {
		if (!expr.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToBoolean(expr);
	}

	@Override
	public Boolean visit(Pos expr) {
		if (!expr.getArg().accept(this)) {
			return false;
		}

		return isCompatibleToNumeric(expr);
	}

	@Override
	public Boolean visit(Bool expr) {
		Type exprType = expr.typeOf(typeMapper);
		if (!exprType.isCompatibleToBooleanType()) {
			addError(String.format("%s is not a valid Boolean.", expr.toString()));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident expr) {
		return true;
	}

	@Override
	public Boolean visit(Int expr) {
		Type exprType = expr.typeOf(typeMapper);
		if (!exprType.isCompatibleToNumericType()) {
			addError(String.format("%s is not a valid Int.", expr.toString()));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(StringLiteral expr) {
		Type exprType = expr.typeOf(typeMapper);
		if (!exprType.isCompatibleToStringType()) {
			addError(String.format("%s is not a valid String.", expr.toString()));
			return false;
		}
		return true;
	}

	private boolean checkBinaryNode(Binary expr) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}
		return true;
	}

	private boolean bothSidesAreNumeric(Binary expr) {
		Type lhsType = expr.getLhs().typeOf(typeMapper);
		Type rhsType = expr.getRhs().typeOf(typeMapper);

		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			addError(String.format("Invalid Numeric types (%s '%s' %s).",
					lhsType.toString(), expr.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}

	private boolean bothSidesAreBoolean(Binary expr) {
		Type lhsType = expr.getLhs().typeOf(typeMapper);
		Type rhsType = expr.getRhs().typeOf(typeMapper);

		if (!(lhsType.isCompatibleToBooleanType() && rhsType
				.isCompatibleToBooleanType())) {

			addError(String.format("Invalid Boolean types (%s '%s' %s).",
					lhsType.toString(), expr.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}
	
	private boolean bothSidesAreBooleanOrNumeric(Binary expr) {
		Type lhsType = expr.getLhs().typeOf(typeMapper);
		Type rhsType = expr.getRhs().typeOf(typeMapper);
		if (!(lhsType.isCompatibleToBooleanType() && rhsType.isCompatibleToBooleanType()) 
				&& !(lhsType.isCompatibleToNumericType() && rhsType.isCompatibleToNumericType())) {

			addError(String.format("Invalid Boolean/Numeric types (%s '%s' %s).",
					lhsType.toString(), expr.toString(), rhsType.toString()));
			return false;
		}
		return true;
	}
	
	private boolean isCompatibleToNumeric(Unary expr) {
		Type argType = expr.getArg().typeOf(typeMapper);
		if (!argType.isCompatibleToNumericType()) {
			addError(String.format("Invalid Numeric type for %s.", 
					expr.toString()));
			return false;
		}
		return true;
	}
	
	private boolean isCompatibleToBoolean(Unary expr) {
		Type argType = expr.getArg().typeOf(typeMapper);
		if (!argType.isCompatibleToBooleanType()) {
			addError(String.format("Invalid Boolean type for %s.", 
					expr.toString()));
			return false;
		}
		return true;
	}

	public void addError(String message) {
		Message msg = new Error(message);
		errors.add(msg);
	}

	public List<Message> getErrors() {
		return errors;
	}
}