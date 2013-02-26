package visitor.evaluator;

import java.util.Iterator;

import visitor.Environment;
import ast.Form;
import ast.Statement;
import ast.expression.Value;
import ast.statement.*;
import ast.type.Undefined;

public class StatementEvaluator implements Visitor<Boolean> {

	private Environment environment;

	public StatementEvaluator(Environment environment) {
		this.environment = environment;
	}

	public boolean check(Statement stat, Environment environment) {
		StatementEvaluator check = new StatementEvaluator(environment);
		return stat.accept(check);
	}

	@Override
	public Boolean visit(Assignment ast) {
		environment.setVal(ast.getIdent(), (Value) ast.getExpression().accept(new ExpressionEvaluator(environment)));
		return true;
	}

	@Override
	public Boolean visit(Form ast) {
		if (ast.getContent() == null)
			return true;
		return ast.getContent().accept(new StatementEvaluator(environment));
	}

	@Override
	public Boolean visit(If ast) {
		ast.getCondition().accept(new ExpressionEvaluator(environment));
		if (!ast.getTrueBlock().accept(this))
			return false;
		return ast.getFalseBlock().accept(this);
	}

	@Override
	public Boolean visit(QuestionVar ast) {
		if (!environment.getTypeEnv().containsKey(ast.getIdent()))
			environment.getTypeEnv().put(ast.getIdent(), ast.getType());
		environment.setVar(ast.getVar());

		ast.getIdent().accept(new ExpressionEvaluator(environment));
		return true;
	}

	@Override
	public Boolean visit(QuestionComputed ast) {
		if (!environment.hasIdent(ast.getIdent()))
			environment.setVar(new Var(ast.getIdent(), new Undefined()));

		Bindable bind = environment.getIdent(ast.getIdent());
		Assignment assingment = ast.getAssignment();
		assingment.accept(new StatementEvaluator(environment));
		ast.getIdent().accept(new ExpressionEvaluator(environment));
		bind.setType(assingment.getExpression().typeOf(environment.getTypeEnv()));
		return true;
	}

	@Override
	public Boolean visit(Var ast) {
		if (!environment.hasIdent(ast.getIdent()))
			environment.setVar(ast);
		ast.getIdent().accept(new ExpressionEvaluator(environment));
		return true;
	}

	@Override
	public Boolean visit(Block ast) {
		for (Iterator<Statement> i = ast.iterator(); i.hasNext();)
			if (!i.next().accept(this))
				return false;

		return true;
	}

}
