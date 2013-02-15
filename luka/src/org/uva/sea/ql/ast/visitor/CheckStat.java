package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedStat;
import org.uva.sea.ql.ast.stat.ConditionalStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.TypedStat;
import org.uva.sea.ql.ast.type.Type;

public class CheckStat implements StatementVisitor {

	private final Map<Ident, Type> typeEnv;
	private List<ErrorMessage> errorList;

	private CheckStat(Map<Ident, Type> typeEnv, List<ErrorMessage> errorList) {
		this.typeEnv = typeEnv;
		this.errorList = errorList;
	}

	public static void checkStatBlock(Block block, Map<Ident, Type> typeEnv,
		List<ErrorMessage> errorList) {
		CheckStat statChecker = new CheckStat(typeEnv, errorList);
		block.accept(statChecker);
	}

	@Override
	public void visit(Block stat) {
		for (Stat s : stat.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(ComputedStat stat) {
		checkStatType(stat, stat.getExpr().typeOf(typeEnv));
		checkExpr(stat.getExpr());
	}

	@Override
	public void visit(AnswerableStat stat) {
		checkLabel(stat);
		checkStatType(stat, stat.getIdent().typeOf(typeEnv));//getType());
	}

	@Override
	public void visit(IfThenStat stat) {
		checkCondition(stat);
		stat.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStat stat) {
		checkCondition(stat);
		stat.getBody().accept(this);
		stat.getElseBody().accept(this);
	}

	private void addError(Stat stat, String message) {
		this.errorList.add(new ErrorMessage(stat, message));
	}

	private void checkCondition(ConditionalStat stat) {
		checkExpr(stat.getCondition());
		if (stat.getBody().getStatements().isEmpty()) {
			addError(stat, "Invalid if block size, must not be empty");
		}
	}

	private boolean checkExpr(Expr expr) {
		return CheckExpr.check(expr, typeEnv, errorList);
	}

	private void checkStatType(TypedStat stat, Type typeOf) {
		//if (!stat.getType().isCompatibleTo(typeOf)) {
		if (!stat.getIdent().typeOf(typeEnv).isCompatibleTo(typeOf)) {
			addError(stat, "Given type:" + typeOf.toString()
					+ " and computed type:" + stat.getIdent().typeOf(typeEnv)//getType().toString()
					+ "do not match");
		}
	}

	private void checkLabel(AnswerableStat stat) {
		if (stat.getLabel() == null || stat.getLabel().isEmpty()) {
			addError(stat, "Empty label for user question");
		}

	}

}
