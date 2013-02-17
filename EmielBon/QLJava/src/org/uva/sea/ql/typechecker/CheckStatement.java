package org.uva.sea.ql.typechecker;

import java.util.List;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.visitor.*;

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
		
		if (typeEnv.isDeclared(stat.getIdentifier())) {
			return false;
		}
		
		if (!checkExpression(stat.getExpression())) {
			return false;
		}

		if (!stat.getExpression().typeOf(typeEnv).isCompatibleWith(stat.getType())) {
			return false;
		}
		
		typeEnv.declare(stat.getIdentifier(), stat.getType());
		return true;
	}

	public Boolean visit(Question stat) {
		
		if (typeEnv.isDeclared(stat.getIdentifier())) {
			return false;
		}
		
		typeEnv.declare(stat.getIdentifier(), stat.getType());
		return true;
	}
	
	public Boolean visit(IfBlock stat) {
		
		if (!checkExpression(stat.getCondition())) {
			return false;
		}
		
		if (!stat.getCondition().typeOf(typeEnv).isCompatibleWithBool()) {
			System.out.println(stat.getCondition().typeOf(typeEnv));
			System.out.println(typeEnv);
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
