package khosrow.uva.sea.ql.visitor.check;

import java.util.List;

import khosrow.uva.sea.ql.ast.ASTNode;
import khosrow.uva.sea.ql.ast.expr.*;
import khosrow.uva.sea.ql.ast.type.QlError;
import khosrow.uva.sea.ql.ast.type.Type;
import khosrow.uva.sea.ql.env.Env;
import khosrow.uva.sea.ql.visitor.IExprVisitor;

public class ExprTypeChecker implements IExprVisitor<Boolean> {
	private final Env typeEnv;
	private List<QlError> messages;
	
	public ExprTypeChecker(Env typeEnv, List<QlError> messages) {
		this.typeEnv = typeEnv;
		this.setMessages(messages);
	}
	
	public static boolean Check(Expr expr, Env typeEnv, List<QlError> messages) {
		ExprTypeChecker checker = new ExprTypeChecker(typeEnv, messages);
		return expr.accept(checker);
	}
	
	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs))
			return false;
		Type lhsType = ast.typeOf(typeEnv);
		Type rhsType = ast.typeOf(typeEnv);
		
		if (!(lhsType.isCompatibleToNumeric()
				&& rhsType.isCompatibleToNumeric())) {
			addToErrorList(ast, "invalid type for +");
			return false;
		}			 
		return true;
	}

	@Override
	public Boolean visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Div ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Ident ast) {		
		return true;
	}

	@Override
	public Boolean visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Mod ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Unary ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(IntLiteral ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(BoolLiteral ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(MoneyLiteral ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(StringLiteral ast) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addToErrorList(ASTNode ast, String message) {
		messages.add(new QlError("Type error at node " + ast.getClass() + ". Message: " + message));		
	}

	public Env getTypeEnv() {
		return typeEnv;
	}

	public List<QlError> getMessages() {
		return messages;
	}

	public void setMessages(List<QlError> messages) {
		this.messages = messages;
	}

}
