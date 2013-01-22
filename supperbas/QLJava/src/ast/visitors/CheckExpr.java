package ast.visitors;

import java.util.List;
import java.util.Map;

import ast.Expr;
import ast.exprs.Binary;
import ast.exprs.binary.*;
import ast.exprs.unary.*;
import ast.exprs.value.Money;
import ast.exprs.value.Str;
import ast.types.*;
import ast.types.Error;

public class CheckExpr implements Visitor<Boolean> {
	@SuppressWarnings("unused")
	private final Map<Ident, Type> typeEnv;
	@SuppressWarnings("unused")
	private final List<Message> messages;
	private List<Error<?>> errors;

	private CheckExpr(Map<Ident, Type> tenv, List<Message> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<Message> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<Add>(ast, "invalid type for +"));
			return false;
		}
		return true;
	}

	private <T> boolean checkBinary(Binary ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		if (!(checkLhs && checkRhs)) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			addError(new Error<And>(ast, "invalid type for &&"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<Div>(ast, "invalid type for /"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())
				&& !(lhsType.isCompatibleToStr() && rhsType.isCompatibleToStr())
				&& !(lhsType.isCompatibleToNumeric() && rhsType
						.isCompatibleToNumeric())) {
			addError(new Error<Eq>(ast, "invalid type for ="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GEq ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<GEq>(ast, "invalid type for >="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<GT>(ast, "invalid type for >"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		if(ast.isCompatibleToNumeric())
			return true;
		return false;
	}

	@Override
	public Boolean visit(LEq ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<LEq>(ast, "invalid type for <="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<LT>(ast, "invalid type for <"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<Mul>(ast, "invalid type for *"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		Type exprType = ast.getExpr().typeOf(typeEnv);
		if (!exprType.isCompatibleToNumeric()) {
			addError(new Error<Neg>(ast, "invalid type for (-)"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			addError(new Error<NEq>(ast, "invalid type for !="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		Type exprType = ast.getExpr().typeOf(typeEnv);
		if (!exprType.isCompatibleToBool()) {
			addError(new Error<Not>(ast, "invalid type for (-)"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			addError(new Error<Or>(ast, "invalid type for ||"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		Type exprType = ast.getExpr().typeOf(typeEnv);
		if (!exprType.isCompatibleToNumeric()) {
			addError(new Error<Pos>(ast, "invalid type for (-)"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToNumeric() && rhsType
				.isCompatibleToNumeric())) {
			addError(new Error<Sub>(ast, "invalid type for -"));
			return false;
		}
		return true;
	}

	public List<Error<?>> getErrors() {
		return errors;
	}

	public void addError(Error<?> err) {
		this.errors.add(err);
	}
}