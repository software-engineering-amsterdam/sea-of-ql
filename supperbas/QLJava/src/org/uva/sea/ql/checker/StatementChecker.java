package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.*;


public class StatementChecker implements org.uva.sea.ql.ast.statement.Visitor<Void> {

	private Environment environment;

	public StatementChecker(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Void visit(Form ast) {
		ast.getContent().accept(new StatementChecker(environment));
		return null;
	}

	@Override
	public Void visit(If ast) {
		Expression condition = ast.getCondition();
		condition.accept(new ExpressionChecker(environment));
		Type conditionType = condition.typeOf(environment.getTypeEnv());
		if(!new org.uva.sea.ql.ast.type.Bool().isCompatibleTo(conditionType))
			environment.addError("Condition is not of type boolean");			
		ast.getTrueBlock().accept(this);
		ast.getFalseBlock().accept(this);
		return null;
	}

	@Override
	public Void visit(QuestionVar ast) {
		checkIdent(ast.getIdent(), ast.getType());
		return null;
	}

	@Override
	public Void visit(QuestionComputed ast) {
		ast.getExpression().accept(new ExpressionChecker(environment));
		Type type = ast.getExpression().typeOf(environment.getTypeEnv());
		checkIdent(ast.getIdent(), type);
		return null;
		
	}

	@Override
	public Void visit(Var ast) {
		ast.getIdent().accept(new ExpressionChecker(environment));
		return null;
	}

	@Override
	public Void visit(Block ast) {
		for(Statement stat : ast.getStatements())
			stat.accept(this);

		return null;
	}
	
	private void checkIdent(Ident i, Type t){
		if (!environment.getTypeEnv().containsKey(i))
			environment.getTypeEnv().put(i, t);
		else
			environment.addError("Ident already defined (" + i.getValue() + ")");
	}

}
