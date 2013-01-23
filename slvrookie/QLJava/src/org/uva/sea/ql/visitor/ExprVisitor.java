package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
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
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;
import org.uva.sea.ql.ast.types.Type;

public class ExprVisitor implements IVisitor<Boolean> {
	
	private Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();
	private final List<String> messages = new ArrayList<String>();

	
	public void addError(String error) {
		this.messages.add(error);
	}
	
	public List<String> getErrorList() {
		return messages;
	}

	@Override
	public Boolean visit(Add node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for +" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(And node) {

		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBoolType()&& rhsType.isCompatibleToBoolType())) {
			addError("invalid type for &&" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Div node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for /" + node);
		return false;
		}
		
		return true;
	}
	

	@Override
	public Boolean visit(Eq node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBoolType()&& rhsType.isCompatibleToBoolType()) && !(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for ==" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GEq node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for >=" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(GT node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for >" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Ident node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(LEq node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for <=" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(LT node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for <" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Mul node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for *" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Neg node) {
		
		boolean checkArg = node.getArg().accept(this);
		
		if (!(checkArg)) {
			return false;
		}
		
		Type argType = node.getArg().typeOf(typeEnv);
		
		if (!(argType.isCompatibleToNumeric())) {
			addError("invalid type for unary -");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(NEq node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBoolType()&& rhsType.isCompatibleToBoolType()) && !(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for != " + node);
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Not node) {
		
		boolean checkArg = node.getArg().accept(this);
		
		if (!(checkArg)) {
			return false;
		}
		
		Type argType = node.getArg().typeOf(typeEnv);
		
		if (!(argType.isCompatibleToBoolType())) {
			addError("invalid type for unary !");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Or node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToBoolType()&& rhsType.isCompatibleToBoolType())) {
			addError("invalid type for ||" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Pos node) {
		
		boolean checkArg = node.getArg().accept(this);
		
		if (!(checkArg)) {
			return false;
		}
		
		Type argType = node.getArg().typeOf(typeEnv);
		
		if (!(argType.isCompatibleToNumeric())) {
			addError("invalid type for unary +");
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(Sub node) {
		
		boolean checkLhs = node.getLhs().accept(this);
		boolean checkRhs = node.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = node.getLhs().typeOf(typeEnv);
		Type rhsType = node.getRhs().typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()&& rhsType.isCompatibleToNumeric())) {
			addError("invalid type for -" + node);
		return false;
		}
		
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(MoneyLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}

}
