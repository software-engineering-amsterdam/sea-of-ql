package org.uva.sea.ql.questionnaire.check;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.AnswerableStat;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ConditionalStat;
import org.uva.sea.ql.ast.stat.HiddenComputedStat;
import org.uva.sea.ql.ast.stat.IfThenElseStat;
import org.uva.sea.ql.ast.stat.IfThenStat;
import org.uva.sea.ql.ast.stat.SelectableStat;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.TypedStat;
import org.uva.sea.ql.ast.stat.VisibleComputetStat;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.StatementVisitor;

public class CheckStat implements StatementVisitor {

	private final Map<Ident, Type> typeEnv;
	private final List<ErrorMessage> errorList;

	private CheckStat(Map<Ident, Type> typeEnv, List<ErrorMessage> errorList) {
		this.typeEnv = typeEnv;
		this.errorList = errorList;
	}
	//check if given block is valid, loops through all statements in this block and if error occurs, add error to error list
	public static void checkStatBlock(Block block, Map<Ident, Type> typeEnv,
			List<ErrorMessage> errorList) {
		CheckStat statChecker = new CheckStat(typeEnv, errorList);
		block.accept(statChecker);
	}

	private void mapIdentToType(TypedStat stat) {
		if (this.typeEnv.containsKey(stat.getIdent())) {
			addError(stat, "Already declared:" + stat.getIdent().toString()
					+ " , please do not declare same Ident more than once!");
			return;
		}
		this.typeEnv.put(stat.getIdent(), stat.getType());

	}

	@Override
	public void visit(Block stat) {
		for (Stat s : stat.getStatements()) {
			s.accept(this);
		}
	}

	@Override
	public void visit(VisibleComputetStat stat) {
		mapIdentToType(stat);
		checkStatType(stat, stat.getExpr().typeOf(this.typeEnv));
		checkExpr(stat.getExpr());
	}

	@Override
	public void visit(HiddenComputedStat stat) {
		mapIdentToType(stat);
		checkStatType(stat, stat.getExpr().typeOf(this.typeEnv));
		checkExpr(stat.getExpr());
	}

	@Override
	public void visit(AnswerableStat stat) {
		mapIdentToType(stat);
		checkLabel(stat);
		checkStatType(stat, stat.getIdent().typeOf(this.typeEnv));
	}

	@Override
	public void visit(IfThenStat stat) {
		checkCondition(stat);
		if (stat.getBody() == null || stat.getBody().getStatements().isEmpty()) {
			addError(stat, "Empty body in <if> not allowed!");
		}
		stat.getBody().accept(this);
	}

	@Override
	public void visit(IfThenElseStat stat) {
		checkCondition(stat);
		if (stat.getBody() == null || stat.getBody().getStatements().isEmpty()) {
			addError(stat, "Empty body in <if> not allowed!");
		}
		if (stat.getElseBody() == null
				|| stat.getElseBody().getStatements().isEmpty()) {
			addError(stat, "Empty body in <else> not allowed!");
		}
		stat.getBody().accept(this);
		stat.getElseBody().accept(this);
	}

	private void addError(Stat stat, String message) {
		this.errorList.add(new ErrorMessage(stat, message));
	}

	private void checkCondition(ConditionalStat stat) {
		if (!checkExpr(stat.getCondition())) {
			addError(stat, "Something wrong with conditional statement !");
		}
		if (stat.getCondition() == null
				|| stat.getCondition().typeOf(this.typeEnv).getClass() != BoolType.class) {
			addError(stat,
					"Conditional statemant  must be of type <boolean> but is :"
							+ stat.getCondition().typeOf(typeEnv).toString());
		}
	}

	private void checkStatType(TypedStat stat, Type typeOf) {
		if (!stat.getIdent().typeOf(this.typeEnv).isCompatibleTo(typeOf)) {
			addError(stat,
					"Type:" + typeOf.toString() + " not compatible with type:"
							+ stat.getIdent().typeOf(this.typeEnv)
							+ ", please also check the order of declaration");
			return;
		}
	}

	@Override
	public void visit(SelectableStat stat) {
		mapIdentToType(stat);
		checkLabel(stat);
		checkStatType(stat, stat.getIdent().typeOf(this.typeEnv));

	}

	private boolean checkExpr(Expr expr) {
		return CheckExpr.check(expr, this.typeEnv, this.errorList);
	}

	private void checkLabel(TypedStat stat) {
		if (stat.getLabel() == null || stat.getLabel().isEmpty()) {
			addError(stat, "Empty label for user question");
		}

	}

}
