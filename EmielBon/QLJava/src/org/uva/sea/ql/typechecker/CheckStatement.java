package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

public class CheckStatement implements StatementVisitor<Boolean> {

	private final TypeEnvironment typeEnv;
	private final List<Message> messages;
	
	private CheckStatement(TypeEnvironment typeEnv, List<Message> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Statement stat, TypeEnvironment typeEnv, List<Message> errs) {
		CheckStatement check = new CheckStatement(typeEnv, errs);
		return stat.accept(check);
	}
	
	public boolean checkExpression(Expression expr) {
		return CheckExpression.check(expr, typeEnv, messages);
	}
	
	public Boolean visit(ComputedQuestion stat) {
		
		Identifier id     = stat.getIdentifier();
		Type declaredType = stat.getType();
		Expression expr   = stat.getExpression();
		Type exprType     = expr.typeOf(typeEnv);
				
		if (typeEnv.isDeclared(id)) {
			return false;
		}
		
		if (!checkExpression(expr)) {
			return false;
		}

		if (!exprType.isCompatibleWith(declaredType)) {
			return false;
		}
		
		typeEnv.declare(id, declaredType);
		return true;
	}

	public Boolean visit(Question stat) {
		
		Identifier id = stat.getIdentifier();
		
		if (typeEnv.isDeclared(id)) {
			return false;
		}
		
		typeEnv.declare(id, stat.getType());
		return true;
	}
	
	public Boolean visit(IfBlock stat) {
		
		Expression condition = stat.getCondition();
		Type conditionType = condition.typeOf(typeEnv);
		
		if (!checkExpression(condition)) {
			return false;
		}
		
		if (!conditionType.isCompatibleWithBool()) {
			return false;
		}
		
		return visit(stat.getBody());
	}
	
	public Boolean visit(Form stat) {
		return visit(stat.getBody());
	}
	
	public Boolean visit(Statements stat) {
		boolean correct = true;
		for(Statement s : stat.getStatements()) {
			correct = correct && s.accept(this);
		}
		return correct;
	}
	
}
