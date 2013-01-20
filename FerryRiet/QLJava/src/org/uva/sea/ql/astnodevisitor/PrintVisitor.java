package org.uva.sea.ql.astnodevisitor;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.BooleanType;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.MoneyType;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StringType;
import org.uva.sea.ql.ast.TypeDescription;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.Pos;
import org.uva.sea.ql.ast.Neg;
import org.uva.sea.ql.ast.*;

public class PrintVisitor implements Visitor {

	private String report = new String();;

	@Override
	public VisitorResult visit(Expr expr) {
		if (expr.getClass() == IntLiteral.class) {
			report = report.concat(Integer
					.toString(((IntLiteral) expr).getValue()));
		}
		if (expr.getClass() == Ident.class) {
			report = report.concat(((Ident) expr).getName());
		}
		return null; 
	}

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		report = report.concat("form "
				+ qlProgram.getProgramName());
		qlProgram.getCompound().accept(this);
		System.out.println(report);
		return null;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		report = report.concat(" { \n");

		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);

		report = report.concat(" } \n");
		return null;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		report = report.concat(lineStatement.getLineName()
				+ ": " + lineStatement.getDisplayText());
		lineStatement.getTypeDescription().accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		report = report.concat("\nif ( ");
		conditionalStatement.getExpression().accept(this);
		report = report.concat(" ) ");
		conditionalStatement.getTrueCompound().accept(this);
		if ( conditionalStatement.getFalseCompound() != null ) {
			report = report.concat("\nelse ");
			conditionalStatement.getFalseCompound().accept(this) ;
		}
		return null;
	}

	@Override
	public VisitorResult visit(TypeDescription typeDescription) {
		if (typeDescription.getClass() == BooleanType.class) {
			report = report.concat(" boolean ");
		}
		if (typeDescription.getClass() == StringType.class) {
			report = report.concat(" string ");
		}
		if (typeDescription.getClass() == MoneyType.class) {
			report = report.concat(" money ");
			if (((MoneyType) typeDescription).getExpr() != null) {
				report = report.concat(" ( ");
				((MoneyType) typeDescription).getExpr().accept(this);
				report = report.concat(" ) ");
			}
		}
		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		expr.getExprLeftHand().accept(this);
		if (expr.getClass() == Add.class)
			report = report.concat(" + ");
		else if (expr.getClass() == Sub.class)
			report = report.concat(" - ");
		else if (expr.getClass() == Div.class)
			report = report.concat(" / ");
		else if (expr.getClass() == Mul.class)
			report = report.concat(" * ");
		else if (expr.getClass() == And.class)
			report = report.concat(" && ");
		else if (expr.getClass() == Or.class)
			report = report.concat(" || ");
		else if (expr.getClass() == Eq.class)
			report = report.concat(" == ");
		else if (expr.getClass() == NEq.class)
			report = report.concat(" != ");
		else if (expr.getClass() == GT.class)
			report = report.concat(" > ");
		else if (expr.getClass() == LT.class)
			report = report.concat(" < ");
		expr.getExprRightHand().accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		if (expr.getClass() == Not.class)
			report = report.concat(" ! ");
		else if (expr.getClass() == Pos.class)
			report = report.concat(" + ");
		else if (expr.getClass() == Neg.class)
			report = report.concat(" - ");
		expr.getExprRightHand().accept(this);
		return null;
	}
}
