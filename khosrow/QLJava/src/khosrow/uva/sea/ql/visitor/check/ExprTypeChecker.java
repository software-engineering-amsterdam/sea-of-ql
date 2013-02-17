package khosrow.uva.sea.ql.visitor.check;

import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.*;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.resources.QlTypeError;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class ExprTypeChecker implements IExprVisitor<Boolean> {
	private final Env env;
	private List<QlTypeError> messages;
	
	private ExprTypeChecker(Env env, List<QlTypeError> messages) {
		this.env =  env;
		this.messages = messages;
	}
	
	public static boolean Check(Expr expr, Env env, List<QlTypeError> messages) {
		ExprTypeChecker checker = new ExprTypeChecker(env, messages);
		return expr.accept(checker);
	}
	
	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator + can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToBool()
				&& rhsType.isCompatibleToBool())) {
			addToErrorList(ast, "the operator && can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(Div ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator / can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(Eq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!lhsType.isCompatibleTo(rhsType)) {
			addToErrorList(ast, "the operator == can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(NEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!lhsType.isCompatibleTo(rhsType)) {
			addToErrorList(ast, "the operator != can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}
	
	@Override
	public Boolean visit(GEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleTo(rhsType) 
			  && lhsType.isCompatibleToNumeric()
			  && rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator >= can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}		
		return true;
	}

	@Override
	public Boolean visit(GT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleTo(rhsType) 
				  && lhsType.isCompatibleToNumeric()
				  && rhsType.isCompatibleToNumeric())) {
				addToErrorList(ast, "the operator > can not be applied to instances of type " 
						+ lhsType.getClass() + " and type " + rhsType.getClass());
				return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Ident ast) {
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleTo(rhsType) 
				  && lhsType.isCompatibleToNumeric()
				  && rhsType.isCompatibleToNumeric())) {
				addToErrorList(ast, "the operator <= can not be applied to instances of type " 
						+ lhsType.getClass() + " and type " + rhsType.getClass());
				return false;
			}
		return true;
	}

	@Override
	public Boolean visit(LT ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleTo(rhsType) 
				  && lhsType.isCompatibleToNumeric()
				  && rhsType.isCompatibleToNumeric())) {
				addToErrorList(ast, "the operator < can not be applied to instances of type " 
						+ lhsType.getClass() + " and type " + rhsType.getClass());
				return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Mod ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator % can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(Mul ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator * can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(Neg ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg)
			return false;
		
		Type argType = ast.getArg().typeOf(env);
		
		if (!argType.isCompatibleToNumeric()) {
			addToErrorList(ast, "the unary operator - can not be applied to instances of type " 
					+ argType.getClass());
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Pos ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg)
			return false;
		
		Type argType = ast.getArg().typeOf(env);
		
		if (!argType.isCompatibleToNumeric()) {
			addToErrorList(ast, "the unary operator + can not be applied to instances of type " 
					+ argType.getClass());
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean visit(Not ast) {
		boolean checkArg = ast.getArg().accept(this);
		
		if (!checkArg)
			return false;
		
		Type argType = ast.getArg().typeOf(env);
		
		if (!argType.isCompatibleToBool()) {
			addToErrorList(ast, "the unary operator ! can not be applied to instances of type " 
					+ argType.getClass());
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(Or ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToBool()
				&& rhsType.isCompatibleToBool())) {
			addToErrorList(ast, "the operator || can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(Sub ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.getLhs().typeOf(env);
		Type rhsType = ast.getRhs().typeOf(env);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "the operator - can not be applied to instances of type " 
					+ lhsType.getClass() + " and type " + rhsType.getClass());
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(IntLiteral ast) {
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral ast) {		
		return true;
	}

	@Override
	public Boolean visit(MoneyLiteral ast) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		return true;
	}
	
	private void addToErrorList(ASTNode ast, String message) {
		messages.add(new QlTypeError("Type error at node " + ast.getClass() + ". Message: " + message));		
	}

	public Env getTypeEnv() {
		return env;
	}

	public List<QlTypeError> getMessages() {
		return messages;
	}	

}
