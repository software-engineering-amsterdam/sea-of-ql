package org.uva.sea.ql.typechecker;

import java.util.List;
import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.Type;

public class StatementChecker implements StatementVisitor {

	private final TypeEnvironment typeEnv;
	private final List<Error> errors;
	
	private StatementChecker(TypeEnvironment typeEnv, List<Error> messages) {
		this.typeEnv = typeEnv;
		this.errors = messages;
	}
	
	public static void check(Statement stat, TypeEnvironment typeEnv, List<Error> errs) {
		StatementChecker check = new StatementChecker(typeEnv, errs);
		stat.accept(check);
	}
	
	public boolean checkExpression(Expression expr) {
		return ExpressionChecker.check(expr, typeEnv, errors);
	}
	
	public Type typeOf(Expression expr) {
		return expr.typeOf(typeEnv);
	}
	
	private void addError(Expression expr, String message) {
		errors.add(new Error(expr, message));
	}
	
	public void visit(ComputedQuestion stat) {
		
		Identifier id     = stat.getIdentifier();
		Type declaredType = stat.getType();
		Expression expr   = stat.getExpression();
			
		if (typeEnv.isDeclared(id)) {
			addError(id, "redeclaration of variable " + id.getRepresentation());
		}
		
		checkExpression(expr);

		if (!typeOf(expr).isCompatibleWith(declaredType)) {
			addError(expr, "type of expression (" + typeOf(expr) + ") is incompatible with declared type " + declaredType);
		}
		
		typeEnv.declare(id, declaredType);
	}

	public void visit(Question stat) {
		
		Identifier id = stat.getIdentifier();
		
		if (typeEnv.isDeclared(id)) {
			addError(id, "redeclaration of variable " + id.getRepresentation());
		}
		
		typeEnv.declare(id, stat.getType());
	}
	
	public void visit(IfThen stat) {
		
		Expression condition = stat.getCondition();
		
		checkExpression(condition);
			
		if (!typeOf(condition).isCompatibleWithBool()) {
			addError(condition, "not a conditional statement");
		}
		
		visit(stat.getBody());
	}
	
	public void visit(IfThenElse stat) {
		
		Expression condition = stat.getCondition();
		
		checkExpression(condition);
		
		if (!typeOf(condition).isCompatibleWithBool()) {
			addError(condition, "not a conditional statement");
		}
		
		visit(stat.getBody());
		visit(stat.getElseBody());
	}
	
	public void visit(Form stat) {
		visit(stat.getBody());
	}
	
	public void visit(Block stat) {
		for(Statement s : stat.getBody()) {
			s.accept(this);
		}
	}
	
}
