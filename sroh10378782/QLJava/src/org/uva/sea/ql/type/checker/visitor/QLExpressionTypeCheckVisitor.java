package org.uva.sea.ql.type.checker.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.visitor.Visitor;
import org.uva.sea.ql.ast.nodes.expressions.Add;
import org.uva.sea.ql.ast.nodes.expressions.And;
import org.uva.sea.ql.ast.nodes.expressions.Bool;
import org.uva.sea.ql.ast.nodes.expressions.CompBool;
import org.uva.sea.ql.ast.nodes.expressions.CompInt;
import org.uva.sea.ql.ast.nodes.expressions.CompMoney;
import org.uva.sea.ql.ast.nodes.expressions.Div;
import org.uva.sea.ql.ast.nodes.expressions.Eq;
import org.uva.sea.ql.ast.nodes.expressions.Expr;
import org.uva.sea.ql.ast.nodes.expressions.GEq;
import org.uva.sea.ql.ast.nodes.expressions.GT;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.expressions.Int;
import org.uva.sea.ql.ast.nodes.expressions.LEq;
import org.uva.sea.ql.ast.nodes.expressions.LT;
import org.uva.sea.ql.ast.nodes.expressions.Money;
import org.uva.sea.ql.ast.nodes.expressions.Mul;
import org.uva.sea.ql.ast.nodes.expressions.NEq;
import org.uva.sea.ql.ast.nodes.expressions.Neg;
import org.uva.sea.ql.ast.nodes.expressions.Not;
import org.uva.sea.ql.ast.nodes.expressions.Or;
import org.uva.sea.ql.ast.nodes.expressions.Pos;
import org.uva.sea.ql.ast.nodes.expressions.Str;
import org.uva.sea.ql.ast.nodes.expressions.Sub;
import org.uva.sea.ql.type.checker.QLErrorMessage;
import org.uva.sea.ql.types.Type;

public class QLExpressionTypeCheckVisitor implements Visitor<Boolean> {
	
	private final Map<Ident, Type> typeEnv;
	private final List<QLErrorMessage> messages;
	
	private QLExpressionTypeCheckVisitor(Map<Ident, Type> typeEnv, List<QLErrorMessage> messages) {
		this.typeEnv  = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<QLErrorMessage> errs) {
		QLExpressionTypeCheckVisitor check = new QLExpressionTypeCheckVisitor(typeEnv, errs);
		boolean retVal = expr.accept(check);
		return retVal;
	}
	
	private void addError(QLErrorMessage error){
		this.messages.add(error);
	}
	
	@Override
	public Boolean visit(Add add) {
		boolean checkLhs = add.getLhs().accept(this);
		boolean checkRhs = add.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = add.getLhs().typeOf(typeEnv);
		Type rhsType = add.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Add invalid type for + operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {
		boolean checkLhs = and.getLhs().accept(this);
		boolean checkRhs = and.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = and.getLhs().typeOf(typeEnv);
		Type rhsType = and.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			this.addError(new QLErrorMessage("And invalid type for && operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		boolean checkLhs = div.getLhs().accept(this);
		boolean checkRhs = div.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = div.getLhs().typeOf(typeEnv);
		Type rhsType = div.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Div invalid type for / operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		boolean checkLhs = eq.getLhs().accept(this);
		boolean checkRhs = eq.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = eq.getLhs().typeOf(typeEnv);
		Type rhsType = eq.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			this.addError(new QLErrorMessage("Eq invalid type for == operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		boolean checkLhs = geq.getLhs().accept(this);
		boolean checkRhs = geq.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = geq.getLhs().typeOf(typeEnv);
		Type rhsType = geq.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Geq invalid type for >= operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		boolean checkLhs = gt.getLhs().accept(this);
		boolean checkRhs = gt.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = gt.getLhs().typeOf(typeEnv);
		Type rhsType = gt.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Geq invalid type for >= operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		boolean checkLhs = leq.getLhs().accept(this);
		boolean checkRhs = leq.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = leq.getLhs().typeOf(typeEnv);
		Type rhsType = leq.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Geq invalid type for <= operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		boolean checkLhs = lt.getLhs().accept(this);
		boolean checkRhs = lt.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = lt.getLhs().typeOf(typeEnv);
		Type rhsType = lt.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Lt invalid type for < operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		boolean checkLhs = mul.getLhs().accept(this);
		boolean checkRhs = mul.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = mul.getLhs().typeOf(typeEnv);
		Type rhsType = mul.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Mul invalid type for * operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		boolean check = neg.getExpr().accept(this);
		
		if(!check) {
			return false;
		}
		
		Type negType = neg.getExpr().typeOf(typeEnv);
		
		if(!(negType.isCompatibleTo(negType))) {
			this.addError(new QLErrorMessage("Not invalid type for ! operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		boolean checkLhs = neq.getLhs().accept(this);
		boolean checkRhs = neq.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = neq.getLhs().typeOf(typeEnv);
		Type rhsType = neq.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Neq invalid type for != operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		boolean check = not.getExpr().accept(this);
		
		if(!check) {
			return false;
		}
		
		Type notType = not.getExpr().typeOf(typeEnv);
		
		if(!(notType.isCompatibleTo(notType))) {
			this.addError(new QLErrorMessage("Not invalid type for ! operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or or) {
		boolean checkLhs = or.getLhs().accept(this);
		boolean checkRhs = or.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = or.getLhs().typeOf(typeEnv);
		Type rhsType = or.getRhs().typeOf(typeEnv);
		
		if(!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			this.addError(new QLErrorMessage("Or invalid type for || operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		boolean check = pos.getExpr().accept(this);
		
		if(!check) {
			return false;
		}
		
		Type posType = pos.getExpr().typeOf(typeEnv);
		
		if(!(posType.isCompatibleTo(posType))) {
			this.addError(new QLErrorMessage("Pos invalid type for + operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		boolean checkLhs = sub.getLhs().accept(this);
		boolean checkRhs = sub.getRhs().accept(this);
		
		if(!(checkLhs && checkRhs)) {
			return false;
		}
		
		Type lhsType = sub.getLhs().typeOf(this.typeEnv);
		Type rhsType = sub.getRhs().typeOf(this.typeEnv);
		
		if(!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			this.addError(new QLErrorMessage("Sub invalid type for - operation"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Bool boolexpression) {
		return true;
	}

	@Override
	public Boolean visit(Int intexpression) {
		return true;
	}

	@Override
	public Boolean visit(Str strexpression) {
		return true;
	}

	@Override
	public Boolean visit(Money moneyexpression) {
		return true;
	}

	@Override
	public Boolean visit(Ident identexpression) {
		return true;
	}

	@Override
	public Boolean visit(CompBool boolexpression) {
		boolean check = boolexpression.getExpr().accept(this);
		
		if(!check) {
			return false;
		}
		
		Type boolType = boolexpression.getExpr().typeOf(typeEnv);
		
		if(!(boolType.isCompatibleTo(boolType))) {
			this.addError(new QLErrorMessage("compBool Type invalid type"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(CompMoney moneyexpression) {
		boolean check = moneyexpression.getExpr().accept(this);
		if(!check) {
			return false;
		}
		
		Type monType = moneyexpression.getExpr().typeOf(typeEnv);
		
		if(!(monType.isCompatibleTo(monType))) {
			this.addError(new QLErrorMessage("compMoneyType invalid type"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(CompInt identexpression) {
		boolean check = identexpression.getExpr().accept(this);
		
		if(!check) {
			return false;
		}
		
		Type intType = identexpression.getExpr().typeOf(typeEnv);
		
		if(!(intType.isCompatibleTo(intType))) {
			this.addError(new QLErrorMessage("compIntType invalid type"));
			return false;
		}
		return true;
	}
}
