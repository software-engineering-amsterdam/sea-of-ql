package org.uva.sea.ql.semanticCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.expressions.AExpr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.statements.BlockOfStatements;
import org.uva.sea.ql.ast.statements.ComputedQuestion;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.statements.AStatement;
import org.uva.sea.ql.ast.statements.ifElseStatement;
import org.uva.sea.ql.ast.statements.ifStatement;
import org.uva.sea.ql.ast.types.AType;

public class FormStmtChecker implements FormStmtVisitor<Boolean> {
	private final Map<Ident, AType> typeEnv;
	private final List<String> labels;
	private final List<String> errMsgs;
	private final ExprChecker exprChecker;
	
	public FormStmtChecker(Map<Ident, AType> typeEnv, List<String> errMsgs) {
		this.typeEnv = typeEnv;
		this.labels = new ArrayList<String>();
		this.errMsgs = errMsgs;
		this.exprChecker = new ExprChecker(typeEnv, errMsgs);
	}
	
	public boolean check(Form frm, Map<Ident, AType> typeEnv, List<String> errMsgs) {
		return frm.accept(this);
	}
	

	@Override
	public Boolean visit(Question stmt) {
		checkLabel(stmt);
		
		return checkName(stmt);		
	}

	@Override
	public Boolean visit(ComputedQuestion stmt) {
		checkLabel(stmt);
		
		boolean isValid = checkName(stmt);
		
		if (!checkExpr(stmt.getExpr())) {
			isValid = false;
		}
		
		return isValid;
	}

	@Override
	public Boolean visit(ifStatement stmt) {
		boolean isValid = checkCondition(stmt);
		
		if (!stmt.getIfStmts().accept(this)) {
			isValid = false;
		}
		
		return isValid;
	}

	@Override
	public Boolean visit(ifElseStatement stmt) {
		boolean isValid = checkCondition(stmt);
		
		if (!stmt.getIfStmts().accept(this)) {
			isValid = false;
		}
		if (!stmt.getElseStmts().accept(this)) {
			isValid = false;
		}
		
		return isValid;
	}

	@Override
	public Boolean visit(BlockOfStatements stmt) {
		boolean isValid = true;
		
		for (AStatement s: stmt.getBlStmt()) {
			isValid = isValid && s.accept(this);
		}
		
		return isValid;
	}
	
	@Override
	public Boolean visit(Form frm) {
		boolean isValid = visit(frm.getBlStmts());
		
		printErrMsgs();
		
		return isValid;
	}
	
	private boolean checkName(Question stmt) {
		Ident ident = stmt.getIdent();
		
		for (Ident id : typeEnv.keySet()) {
			if (id.getName().equals(ident.getName())) {
				errMsgs.add("Identifier \"" + ident.getName() + "\" has already been declared.");
				return false;
			}
		}
		
		typeEnv.put(ident, stmt.getType());
		return true;
	}
	
	private boolean checkExpr(AExpr expr) {
		return exprChecker.check(expr, typeEnv, errMsgs);
	}
		
	private boolean checkCondition(ifStatement stmt) {
		boolean isValid = checkExpr(stmt.getCondition());
		
		AExpr condition = stmt.getCondition();
		if (!condition.typeOf(typeEnv).isCompatibleToBool()) {
			errMsgs.add("The condition should be of type boolean.");
			isValid = false;
		}
		
		return isValid;
	}
	
	private void checkLabel(Question stmt) {
		if (labels.contains(stmt.getLabel()))
			errMsgs.add("Warning - Duplicate question label: " + stmt.getLabel());
		else
			labels.add(stmt.getLabel());
	}
	
	private void printErrMsgs() {
		for (String s : errMsgs) {
			System.out.println(s);
		}
	}
}