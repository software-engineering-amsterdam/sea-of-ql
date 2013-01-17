package org.uva.sea.ql.astnodevisitor;

import java.util.HashMap;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.MoneyType;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.TypeDescription;
import org.uva.sea.ql.ast.UnExpr;

public class SemanticCheckVisitor implements Visitor {
	private String errorReport = new String();
	private HashMap<String, Statement> symbolMap = new HashMap<String, Statement>();

	public SemanticCheckVisitor() {

	}

	@Override
	public void visit(Expr expr) {
		if (expr.getClass() == Ident.class) {
			Ident id = (Ident) expr;
			if (symbolMap.get(id.getName()) == null) {
				errorReport = errorReport.concat("\nLine(" + id.getLine() + ","
						+ id.getCharPositionInLine() + ") Field :"
						+ id.getName() + " is not defined.");
			}
		}
	}

	@Override
	public void visit(BinExpr expr) {
		expr.getExprLeftHand().accept(this);
		expr.getExprRightHand().accept(this);
	}

	@Override
	public void visit(UnExpr expr) {
		expr.getExprRightHand().accept(this);
	}

	@Override
	public void visit(QLProgram qlProgram) {
		qlProgram.getCompound().accept(this);
		System.out.println(errorReport);
	}

	@Override
	public void visit(CompoundStatement compoundBlock) {
		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);
	}

	@Override
	public void visit(LineStatement lineStatement) {
		// Add symbols to the symbolmap so the
		// visitor of the expression can test their existance
		// it also tests for duplicate symbols.
		if (symbolMap.get(lineStatement.getLineName()) == null) {
			// New symbol in map
			symbolMap.put(lineStatement.getLineName(), lineStatement);
		} else {
			errorReport = errorReport.concat("\nLine("
					+ lineStatement.getLine() + ","
					+ lineStatement.getCharPositionInLine() + ") Field :"
					+ lineStatement.getLineName()
					+ " has multiple definitions.");
		}
		lineStatement.getTypeDescription().accept(this);
	}

	@Override
	public void visit(ConditionalStatement conditionalStatement) {
		conditionalStatement.getExpression().accept(this);
		conditionalStatement.getTrueCompound().accept(this);
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalStatement.getFalseCompound().accept(this);
		}
	}

	@Override
	public void visit(TypeDescription typeDescription) {
		if (typeDescription.getClass() == MoneyType.class) {
			MoneyType moneyType = (MoneyType) typeDescription;
			if (moneyType.getExpr() != null) {
				moneyType.getExpr().accept(this);
			}
		}
	}

	public String getErrorReport() {
		return errorReport;
	}
}
