package visitor.checker;

import java.util.Iterator;

import visitor.Environment;
import ast.Form;
import ast.Statement;
import ast.statement.Assignment;
import ast.statement.Block;
import ast.statement.Else;
import ast.statement.If;
import ast.statement.QuestionComputed;
import ast.statement.QuestionVar;
import ast.statement.Var;

public class StatementChecker implements ast.statement.Visitor<Boolean> {

	private Environment environment;

	public StatementChecker(Environment environment) {
		this.environment = environment;
	}

	public boolean check(Statement stat, Environment environment) {
		StatementChecker check = new StatementChecker(environment);
		return stat.accept(check);
	}

	@Override
	public Boolean visit(Assignment ast) {
		if(!environment.getTypeEnv().containsKey(ast.getIdent()))
			environment.addError("undefined identifier ("+ast.getIdent().getValue()+")");
		return true;
	}

	@Override
	public Boolean visit(Else ast) {
		return ast.getBlock().accept(this);
	}

	@Override
	public Boolean visit(Form ast) {
		if (ast.getContent() == null)
			return true;
		return ast.getContent().accept(new StatementChecker(environment));
	}

	@Override
	public Boolean visit(If ast) {
		if (!ast.getCondition().accept(new ExpressionChecker(environment)))
			return false;
		return ast.getBlock().accept(this);
	}

	@Override
	public Boolean visit(QuestionVar ast) {
		if (!environment.getTypeEnv().containsKey(ast.getIdent()))
			environment.getTypeEnv().put(ast.getIdent(), ast.getType());
		
		ast.getIdent().accept(new ExpressionChecker(environment));
		return true;
	}

	@Override
	public Boolean visit(QuestionComputed ast) {
		if (!environment.getTypeEnv().containsKey(ast.getIdent()))
			environment.getTypeEnv().put(ast.getIdent(),
					ast.getLabel().typeOf(environment.getTypeEnv()));
		ast.getIdent().accept(new ExpressionChecker(environment));
		return true;
	}

	@Override
	public Boolean visit(Var ast) {
		environment.getTypeEnv().put(ast.getIdent(), ast.getType());
		ast.getIdent().accept(new ExpressionChecker(environment));
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
