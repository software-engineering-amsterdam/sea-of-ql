package org.uva.sea.ql.typechecker;

import java.util.List;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

public class StatementChecker implements StatementVisitor<Boolean> {

	private final TypeEnvironment typeEnv;
	private final List<Error> messages;
	
	private StatementChecker(TypeEnvironment typeEnv, List<Error> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Statement stat, TypeEnvironment typeEnv, List<Error> errs) {
		StatementChecker check = new StatementChecker(typeEnv, errs);
		return stat.accept(check);
	}
	
	public boolean checkExpression(Expression expr) {
		return ExpressionChecker.check(expr, typeEnv, messages);
	}
	
	public Type typeOf(Expression expr) {
		return expr.typeOf(typeEnv);
	}
	
	public Boolean visit(ComputedQuestion stat) {
		
		Identifier id     = stat.getIdentifier();
		Type declaredType = stat.getType();
		Expression expr   = stat.getExpression();
				
		if (typeEnv.isDeclared(id)) {
			return false;
		}
		
		if (!checkExpression(expr)) {
			return false;
		}

		if (!typeOf(expr).isCompatibleWith(declaredType)) {
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
	
	public Boolean visit(IfThen stat) {
		
		Expression condition = stat.getCondition();
		
		if (!checkExpression(condition)) {
			return false;
		}
		
		if (!typeOf(condition).isCompatibleWithBool()) {
			return false;
		}
		
		return visit(stat.getBody());
	}
	
	public Boolean visit(IfThenElse stat) {
		
		Expression condition = stat.getCondition();
		
		if (!checkExpression(condition)) {
			return false;
		}
		
		if (!typeOf(condition).isCompatibleWithBool()) {
			return false;
		}
		
		return visit(stat.getBody()) && visit(stat.getElseBody());
	}
	
	public Boolean visit(Form stat) {
		return visit(stat.getBody());
	}
	
	public Boolean visit(Block stat) {
		
		boolean correct = true;
		
		for(Statement s : stat.getBody()) {
			correct = correct && s.accept(this);
		}
		
		return correct;
	}
	
}
