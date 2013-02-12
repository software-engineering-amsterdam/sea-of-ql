package org.uva.sea.ql.ast.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.IntegerLiteral;
import org.uva.sea.ql.ast.literals.MoneyLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.operatorresults.Result;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.BinExpr;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.Expr;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.Ident;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;
import org.uva.sea.ql.ast.operators.UnExpr;
import org.uva.sea.ql.ast.statements.CompoundStatement;
import org.uva.sea.ql.ast.statements.ConditionalStatement;
import org.uva.sea.ql.ast.statements.LineStatement;
import org.uva.sea.ql.ast.statements.QLProgram;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ui.CompoundPanel;
import org.uva.sea.ql.ui.ConditionalPanel;
import org.uva.sea.ql.ui.LinePanel;
import org.uva.sea.ql.ui.Panel;

public class QLFormCreator implements Visitor<Panel> {
	private String formName;
	private Map<String, Result> symbols = new HashMap<String, Result>();

	public String getFormName() {
		return formName;
	}

	public Map<String, Result> getSymbols() {
		return symbols;
	}

	@Override
	public Panel visit(QLProgram qlProgram) {
		formName = qlProgram.getProgramName();
		return qlProgram.getCompound().accept(this);
	}

	@Override
	public Panel visit(CompoundStatement compoundBlock) {
		CompoundPanel cPanel = new CompoundPanel();

		for (Statement statement : compoundBlock.getStatementList()) {
			Panel newPanel = (Panel) statement.accept(this);
			cPanel.addPanel(newPanel);
		}
		return cPanel;
	}

	@Override
	public Panel visit(LineStatement lineStatement) {
		LinePanel newPanel;
		symbols.put(lineStatement.getLineName(), lineStatement.getTypeContainer());

		newPanel = new LinePanel(lineStatement);

		return newPanel;
	}

	@Override
	public Panel visit(ConditionalStatement conditionalStatement) {
		ConditionalPanel conditionalPanel = new ConditionalPanel(conditionalStatement);

		conditionalPanel.setcThenPanel((CompoundPanel) conditionalStatement.getTrueCompound()
				.accept(this));
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalPanel.setcElsePanel((CompoundPanel) conditionalStatement.getFalseCompound()
					.accept(this));
		}
		return conditionalPanel;
	}

	@Override
	public Panel visit(Expr expr) {
		return null;
	}

	@Override
	public Panel visit(BinExpr expr) {
		return null;
	}

	@Override
	public Panel visit(Ident expr) {
		return null;
	}

	@Override
	public Panel visit(IntegerLiteral expr) {
		return null;
	}

	@Override
	public Panel visit(StringLiteral expr) {
		return null;
	}

	@Override
	public Panel visit(BooleanLiteral expr) {
		return null;
	}

	@Override
	public Panel visit(Add expr) {
		return null;
	}

	@Override
	public Panel visit(Mul expr) {
		return null;
	}

	@Override
	public Panel visit(Div expr) {
		return null;
	}

	@Override
	public Panel visit(Sub expr) {
		return null;
	}

	@Override
	public Panel visit(And expr) {
		return null;
	}

	@Override
	public Panel visit(Or expr) {
		return null;
	}

	@Override
	public Panel visit(Eq expr) {
		return null;
	}

	@Override
	public Panel visit(GT expr) {
		return null;
	}

	@Override
	public Panel visit(LT expr) {
		return null;
	}

	@Override
	public Panel visit(LEq expr) {
		return null;
	}

	@Override
	public Panel visit(NEq expr) {
		return null;
	}

	@Override
	public Panel visit(GEq expr) {
		return null;
	}

	@Override
	public Panel visit(UnExpr expr) {
		return null;
	}

	@Override
	public Panel visit(Not expr) {
		return null;
	}

	@Override
	public Panel visit(Neg expr) {
		return null;
	}

	@Override
	public Panel visit(Pos expr) {
		return null;
	}

	@Override
	public Panel visit(Type typeDescription) {
		return null;
	}

	@Override
	public Panel visit(MoneyLiteral expr) {
		return null;
	}
}
