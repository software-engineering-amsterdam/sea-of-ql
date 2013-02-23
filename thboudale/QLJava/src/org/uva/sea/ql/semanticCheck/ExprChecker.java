package org.uva.sea.ql.semanticCheck;

import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.expressions.values.Bool;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.values.Int;
import org.uva.sea.ql.ast.expressions.values.Str;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Add;
import org.uva.sea.ql.ast.expressions.binaryExpressions.And;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Div;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Eq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.GEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.GT;
import org.uva.sea.ql.ast.expressions.binaryExpressions.LEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.LT;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Mul;
import org.uva.sea.ql.ast.expressions.binaryExpressions.NEq;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Or;
import org.uva.sea.ql.ast.expressions.binaryExpressions.Sub;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Neg;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Not;
import org.uva.sea.ql.ast.expressions.unaryExpressions.Pos;
import org.uva.sea.ql.ast.types.AType;

public class ExprChecker implements ExprVisitor<Boolean> {
	private final Map<Ident, AType> typeEnv;
	private final List<String> errMsgs;
	
	public ExprChecker(Map<Ident, AType> typeEnv, List<String> errMsgs) {
		this.typeEnv = typeEnv;
		this.errMsgs = errMsgs;
	}
	
	public boolean check(AExpr expr, Map<Ident, AType> typeEnv, List<String> errMsgs) {
		return expr.accept(this);
	}
	
	@Override
	public Boolean visit(Bool ast) {
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		for (Ident id : typeEnv.keySet()) {
			if (id.getName().equals(ast.getName())) {
				return true;
			}
		}
		
		errMsgs.add("Identifier " + ast.getName() + " has not been declared.");
		return false;
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType lhsType = ast.getLhs().typeOf(typeEnv);
		AType rhsType = ast.getRhs().typeOf(typeEnv);
		
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
		
		AType unExprType = ast.getUnExpr().typeOf(typeEnv);
		
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
		
		AType unExprType = ast.getUnExpr().typeOf(typeEnv);
		
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
		
		AType unExprType = ast.getUnExpr().typeOf(typeEnv);
		
		if (!(unExprType.isCompatibleToInt())) {
			errMsgs.add("Invalid type for \'+\'. Operand must be Integer.");
			return false;
		}
		
		return true;
	}
}