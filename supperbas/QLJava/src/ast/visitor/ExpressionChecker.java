package ast.visitor;

import java.util.List;
import java.util.Map;

import ast.Expression;
import ast.Type;
import ast.expression.*;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.Bool;
import ast.expression.value.Ident;
import ast.expression.value.Int;
import ast.expression.value.Str;
import ast.type.Message;

public class ExpressionChecker implements ast.expression.Visitor<Boolean> {

	private final Map<Ident, Type> typeEnv;
	private final List<Message> messages;

	private ExpressionChecker(Map<Ident, Type> typeEnv, List<Message> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}

	public boolean check(Expression expr, Map<Ident, Type> typeEnv,
			List<Message> errs) {
		ExpressionChecker check = new ExpressionChecker(typeEnv, errs);
		return expr.accept(check);
	}

	private boolean check(Expression ast, Type type) {
		if (ast instanceof Binary) {
			if (type.isCompatibleTo(((Binary) ast).getLhs().typeOf(typeEnv))
					&& type.isCompatibleTo(((Binary) ast).getRhs().typeOf(
							typeEnv)))
				return true;
			addError(ast.typeStr() + " Incompatible types (required: " + type
					+ "; got: " + ((Binary) ast).getLhs().typeOf(typeEnv)
					+ " and " + ((Binary) ast).getRhs().typeOf(typeEnv) + ")");
			return false;

		} else if (ast instanceof Unary) {
			if (type.isCompatibleTo(((Unary) ast).getExpression().typeOf(
					typeEnv)))
				return true;
			addError(ast.typeStr() + " Incompatible type (required: " + type
					+ "; got: " + ((Unary) ast).getExpression().typeOf(typeEnv)
					+ ")");
			return false;

		}
		// we should never get here
		return false;
	}

	private boolean checkInt(Expression ast) {
		return check(ast, new ast.type.Int());
	}

	private boolean checkBool(Expression ast) {
		return check(ast, new ast.type.Bool());
	}

	private boolean checkEqual(Binary ast) {
		Type tLhs = ast.getLhs().typeOf(typeEnv);
		Type tRhs = ast.getLhs().typeOf(typeEnv);
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
		if (!typeEnv.containsKey(ast)) {
			addError("undefined identifier");
			return false;
		}
		return true;
	}

	private void addError(String message) {
		messages.add(new Message(message));
	}

}
