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
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
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
import org.uva.sea.ql.ast.statements.CompoundStatement;
import org.uva.sea.ql.ast.statements.ConditionalStatement;
import org.uva.sea.ql.ast.statements.LineStatement;
import org.uva.sea.ql.ast.statements.QLProgram;
import org.uva.sea.ql.ast.statements.Statement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ui.CompoundPane;
import org.uva.sea.ql.ui.ConditionalPane;
import org.uva.sea.ql.ui.LinePane;
import org.uva.sea.ql.ui.Pane;

public class QLFormCreator implements Visitor<Pane> {
	private String formName;
	private Map<String, Result> symbols = new HashMap<String, Result>();

	public String getFormName() {
		return formName;
	}

	public Map<String, Result> getSymbols() {
		return symbols;
	}

	@Override
	public Pane visit(QLProgram qlProgram) {
		formName = qlProgram.getProgramName();
		return qlProgram.getCompound().accept(this);
	}

	@Override
	public Pane visit(CompoundStatement compoundBlock) {
		CompoundPane cPanel = new CompoundPane();

		for (Statement statement : compoundBlock.getStatementList()) {
			Pane newPanel = (Pane) statement.accept(this);
			cPanel.addPanel(newPanel);
		}
		return cPanel;
	}

	@Override
	public Pane visit(LineStatement lineStatement) {
		LinePane newPanel;
		symbols.put(lineStatement.getLineName(), lineStatement.getTypeContainer());

		newPanel = new LinePane(lineStatement);

		return newPanel;
	}

	@Override
	public Pane visit(ConditionalStatement conditionalStatement) {
		ConditionalPane conditionalPanel = new ConditionalPane(conditionalStatement);

		conditionalPanel.setcThenPanel((CompoundPane) conditionalStatement.getTrueCompound()
				.accept(this));
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalPanel.setcElsePanel((CompoundPane) conditionalStatement.getFalseCompound()
					.accept(this));
		}
		return conditionalPanel;
	}

	@Override
	public Pane visit(IntegerLiteral expr) {
		return null;
	}

	@Override
	public Pane visit(StringLiteral expr) {
		return null;
	}

	@Override
	public Pane visit(BooleanLiteral expr) {
		return null;
	}

	@Override
	public Pane visit(Add expr) {
		return null;
	}

	@Override
	public Pane visit(Mul expr) {
		return null;
	}

	@Override
	public Pane visit(Div expr) {
		return null;
	}

	@Override
	public Pane visit(Sub expr) {
		return null;
	}

	@Override
	public Pane visit(And expr) {
		return null;
	}

	@Override
	public Pane visit(Or expr) {
		return null;
	}

	@Override
	public Pane visit(Eq expr) {
		return null;
	}

	@Override
	public Pane visit(GT expr) {
		return null;
	}

	@Override
	public Pane visit(LT expr) {
		return null;
	}

	@Override
	public Pane visit(LEq expr) {
		return null;
	}

	@Override
	public Pane visit(NEq expr) {
		return null;
	}

	@Override
	public Pane visit(GEq expr) {
		return null;
	}

	@Override
	public Pane visit(Not expr) {
		return null;
	}

	@Override
	public Pane visit(Neg expr) {
		return null;
	}

	@Override
	public Pane visit(Pos expr) {
		return null;
	}

	@Override
	public Pane visit(Type typeDescription) {
		return null;
	}

	@Override
	public Pane visit(MoneyLiteral expr) {
		return null;
	}

	@Override
	public Pane visit(Ident expr) {
		return null;
	}
}
