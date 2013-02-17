package org.uva.sea.ql.visitor;

import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.expressions.Bool;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.Str;
import org.uva.sea.ql.ast.expressions.binaryExpr.Add;
import org.uva.sea.ql.ast.expressions.binaryExpr.And;
import org.uva.sea.ql.ast.expressions.binaryExpr.Div;
import org.uva.sea.ql.ast.expressions.binaryExpr.Eq;
import org.uva.sea.ql.ast.expressions.binaryExpr.GEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.GT;
import org.uva.sea.ql.ast.expressions.binaryExpr.LEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.LT;
import org.uva.sea.ql.ast.expressions.binaryExpr.Mul;
import org.uva.sea.ql.ast.expressions.binaryExpr.NEq;
import org.uva.sea.ql.ast.expressions.binaryExpr.Or;
import org.uva.sea.ql.ast.expressions.binaryExpr.Sub;
import org.uva.sea.ql.ast.expressions.unaryExpr.Neg;
import org.uva.sea.ql.ast.expressions.unaryExpr.Not;
import org.uva.sea.ql.ast.expressions.unaryExpr.Pos;
import org.uva.sea.ql.ast.types.Type;

public class ExprChecker implements ExprVisitor<Boolean> {
	private final Map<Ident, Type> typeEnv;
	private final List<String> errMsgs;
	
	private ExprChecker(Map<Ident, Type> typeEnv, List<String> errMsgs) {
		this.typeEnv = typeEnv;
		this.errMsgs = errMsgs;
	}
	
	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<String> errMsgs) {
		ExprChecker check = new ExprChecker(typeEnv, errMsgs);
		return expr.accept(check);
	}
	
	@Override
	public Boolean visit(Bool ast) {
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		return true;
	}

	@Override
	public Boolean visit(Str ast) {
		return true;
	}

	@Override
	public Boolean visit(Add ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'+\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToBool())) {
			errMsgs.add("Invalid type for \'&&\'. Both operands must be Booleans.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'/\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleTo(rhsType))) {
			errMsgs.add("Invalid type for \'==\'. Operands must be of the same type.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'>=\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'>\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'<=\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'<\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'*\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleTo(rhsType))) {
			errMsgs.add("Invalid type for \'!=\'. Operands must be of the same type.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Or ast) {

		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			errMsgs.add("Invalid type for \'||\'. Both operands must be Booleans.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToInt() && rhsType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'-\'. Both operands must be Integers.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		
		boolean checkUnExpr = ast.getUnExpr().accept(this);
		
		if (!(checkUnExpr)) {
			return false;
		}
		
		Type unExprType = ast.getUnExpr().typeOf(typeEnv);
		
		if (!(unExprType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'-\'. Operand must be Integer.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		
		boolean checkUnExpr = ast.getUnExpr().accept(this);
		
		if (!(checkUnExpr)) {
			return false;
		}
		
		Type unExprType = ast.getUnExpr().typeOf(typeEnv);
		
		if (!(unExprType.isCompatibleToBool())) {
			errMsgs.add("Invalid type for \'!\'. Operand must be Boolean.");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {

		boolean checkUnExpr = ast.getUnExpr().accept(this);
		
		if (!(checkUnExpr)) {
			return false;
		}
		
		Type unExprType = ast.getUnExpr().typeOf(typeEnv);
		
		if (!(unExprType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'+\'. Operand must be Integer.");
			return false;
		}
		
		return true;
	}
}