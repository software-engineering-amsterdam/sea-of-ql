package visitor.checker;

import visitor.Environment;
import ast.Expression;
import ast.Type;
import ast.expression.*;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.Bool;
import ast.expression.value.Int;
import ast.expression.value.Str;

public class ExpressionChecker implements ast.expression.Visitor<Boolean> {

	private Environment environment;

	public ExpressionChecker(Environment environment) {
		this.environment = environment;
	}

	private boolean check(Expression ast, Type type) {
		if (ast instanceof Binary) {
			if (type.isCompatibleTo(((Binary) ast).getLhs().typeOf(
					environment.getTypeEnv()))
					&& type.isCompatibleTo(((Binary) ast).getRhs().typeOf(
							environment.getTypeEnv())))
				return true;
			addError(ast.typeStr() + " Incompatible types (required: " + type
					+ "; got: "
					+ ((Binary) ast).getLhs().typeOf(environment.getTypeEnv())
					+ " and "
					+ ((Binary) ast).getRhs().typeOf(environment.getTypeEnv())
					+ ")");
			return false;

		} else if (ast instanceof Unary) {
			if (type.isCompatibleTo(((Unary) ast).getExpression().typeOf(
					environment.getTypeEnv())))
				return true;
			addError(ast.typeStr()
					+ " Incompatible type (required: "
					+ type
					+ "; got: "
					+ ((Unary) ast).getExpression().typeOf(
							environment.getTypeEnv()) + ")");
			return false;

		}
		// we should never get here
		assert false: "Missed an expression case"; 
		return false;
	}

	private boolean checkInt(Binary ast) {
		return check(ast, new ast.type.Int());
	}
	private boolean checkInt(Unary ast) {
		return check(ast, new ast.type.Int());
	}

	private boolean checkBool(Expression ast) {
		return check(ast, new ast.type.Bool());
	}

	private boolean checkEqual(Binary ast) {
		Type tLhs = ast.getLhs().typeOf(environment.getTypeEnv());
		Type tRhs = ast.getLhs().typeOf(environment.getTypeEnv());
		if (!tLhs.isCompatibleTo(tRhs)) {
			addError(ast.typeStr() + " Incompatible types");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Add ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(And ast) {
		return checkBool(ast);
	}

	@Override
	public Boolean visit(Div ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(Eq ast) {
		return checkEqual(ast);
	}

	@Override
	public Boolean visit(GEq ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(GT ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(LEq ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(LT ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(Mul ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(Neg ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(NEq ast) {
		return checkEqual(ast);
	}

	@Override
	public Boolean visit(Not ast) {
		return checkBool(ast);
	}

	@Override
	public Boolean visit(Or ast) {
		return checkBool(ast);
	}

	@Override
	public Boolean visit(Pos ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(Sub ast) {
		return checkInt(ast);
	}

	@Override
	public Boolean visit(Bool ast) {
		System.out.println("X");
		System.out.println(ast.getValue());
		return true;
	}

	@Override
	public Boolean visit(Str ast) {
		return true;
	}

	@Override
	public Boolean visit(Int ast) {
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		if (!environment.getTypeEnv().containsKey(ast)) {
			addError("undefined identifier ("+ast.getValue()+")");
			return false;
		}
		return true;
	}

	private void addError(String message) {
		environment.addError(message);
	}

}
