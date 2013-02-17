package ast.visitor;

import java.util.List;
import java.util.Map;

import ast.Expression;
import ast.Form;
import ast.Type;
import ast.expression.Binary;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.Bool;
import ast.expression.value.Str;
import ast.statement.*;
import ast.type.*;

public class CheckExpr implements Visitor<Boolean> {
	private final Map<Ident, Type> typeEnv;
	@SuppressWarnings("unused")
	private final List<Message> messages;
	private List<Undefined<?>> errors;

	private CheckExpr(Map<Ident, Type> tenv, List<Message> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expression expr, Map<Ident, Type> typeEnv,
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<Add>(ast, "invalid type for +"));
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
			addError(new Undefined<And>(ast, "invalid type for &&"));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<Div>(ast, "invalid type for /"));
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
				&& !(lhsType.isCompatibleToInt() && rhsType
						.isCompatibleToInt())) {
			addError(new Undefined<Eq>(ast, "invalid type for ="));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<GEq>(ast, "invalid type for >="));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<GT>(ast, "invalid type for >"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		if (!checkBinary(ast))
			return false;
		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<LEq>(ast, "invalid type for <="));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<LT>(ast, "invalid type for <"));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<Mul>(ast, "invalid type for *"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		Type exprType = ast.getExpression().typeOf(typeEnv);
		if (!exprType.isCompatibleToInt()) {
			addError(new Undefined<Neg>(ast, "invalid type for (-)"));
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
			addError(new Undefined<NEq>(ast, "invalid type for !="));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Not ast) {
		Type exprType = ast.getExpression().typeOf(typeEnv);
		if (!exprType.isCompatibleToBool()) {
			addError(new Undefined<Not>(ast, "invalid type for (-)"));
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
			addError(new Undefined<Or>(ast, "invalid type for ||"));
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Pos ast) {
		Type exprType = ast.getExpression().typeOf(typeEnv);
		if (!exprType.isCompatibleToInt()) {
			addError(new Undefined<Pos>(ast, "invalid type for (-)"));
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
		if (!(lhsType.isCompatibleToInt() && rhsType
				.isCompatibleToInt())) {
			addError(new Undefined<Sub>(ast, "invalid type for -"));
			return false;
		}
		return true;
	}

	public List<Undefined<?>> getErrors() {
		return errors;
	}

	public void addError(Undefined<?> err) {
		this.errors.add(err);
	}

	@Override
	public Boolean visit(Bool ast) {
		return ast.typeOf(typeEnv).isCompatibleToBool();
	}

	@Override
	public Boolean visit(Str ast) {
		return ast.typeOf(typeEnv).isCompatibleToStr();
	}

	@Override
	public Boolean visit(ast.expression.value.Int ast) {
		return ast.typeOf(typeEnv).isCompatibleToInt();
	}

	@Override
	public Boolean visit(ast.expression.value.Ident ast) {
		return ast instanceof ast.expression.value.Ident;
	}

	@Override
	public Boolean visit(Assignment ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Else ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Form ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(If ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Var ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ast.type.Bool ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ast.type.Str ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Message ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Block ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(QuestionVar ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(QuestionComputed ast) {
		// TODO Auto-generated method stub
		return null;
	}
}