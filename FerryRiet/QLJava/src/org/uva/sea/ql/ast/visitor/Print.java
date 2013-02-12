package org.uva.sea.ql.ast.visitor;

import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.IntegerLiteral;
import org.uva.sea.ql.ast.literals.MoneyLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
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

public class Print implements Visitor<PrintResult> {

	@Override
	public PrintResult visit(QLProgram qlProgram) {
		PrintResult pres;

		pres = new PrintResult("form " + qlProgram.getProgramName());

		pres.appendResult(qlProgram.getCompound().accept(this));

		return pres;
	}

	@Override
	public PrintResult visit(CompoundStatement compoundBlock) {
		PrintResult pres;

		pres = new PrintResult(" { ");
		for (Statement statement : compoundBlock.getStatementList())
			pres.appendResult(statement.accept(this));

		pres.appendResult(" } ");
		return pres;
	}

	@Override
	public PrintResult visit(LineStatement lineStatement) {
		PrintResult pres;

		pres = new PrintResult(lineStatement.getLineName() + ": "
				+ "\"" + lineStatement.getDisplayText() + "\"");

		pres.appendResult(" " + lineStatement.getTypeDescription().accept(this) + " ");

		if (lineStatement.getInitalizerExpr() != null) {
			pres.appendResult(" ( ");
			pres.appendResult(lineStatement.getInitalizerExpr().accept(this));
			pres.appendResult(" ) ");
		}

		return pres;
	}

	@Override
	public PrintResult visit(ConditionalStatement conditionalStatement) {
		PrintResult result = new PrintResult(" if ( ");

		result.appendResult(conditionalStatement.getExpression().accept(this));

		result.appendResult(" ) ");

		result.appendResult(conditionalStatement.getTrueCompound().accept(this));

		if (conditionalStatement.getFalseCompound() != null) {
			result.appendResult(" else ");
			result.appendResult(conditionalStatement.getFalseCompound().accept(
					this));
		}
		return result;
	}

	@Override
	public PrintResult visit(Type typeDescription) {
	    return new PrintResult(typeDescription.getTypeName());
	}

	@Override
	public PrintResult visit(BinExpr expr) {
		return null;
	}

	@Override
	public PrintResult visit(UnExpr expr) {
		PrintResult result = null;

		if (expr.getClass() == Not.class)
			result = new PrintResult(" ! ");
		else if (expr.getClass() == Pos.class)
			result = new PrintResult(" + ");
		else if (expr.getClass() == Neg.class)
			result = new PrintResult(" - ");

		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Expr expr) {
		return null;
	}

	@Override
	public PrintResult visit(Add expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" + ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Mul expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" * ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Div expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" / ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Sub expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" - ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(And expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" && ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Or expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" || ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Eq expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" == ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(GT expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" > ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(LT expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" < ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(LEq expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" <= ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(NEq expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" != ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(GEq expr) {
		PrintResult result = null;

		result = expr.getExprLeftHand().accept(this);
		result.appendResult(" >= ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public PrintResult visit(Not expr) {
		PrintResult result = new PrintResult(" ! ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public PrintResult visit(Neg expr) {
		PrintResult result = new PrintResult(" - ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public PrintResult visit(Pos expr) {
		PrintResult result = new PrintResult(" + ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public PrintResult visit(Ident expr) {
		return new PrintResult(expr.getName());
	}

	@Override
	public PrintResult visit(IntegerLiteral expr) {
		return new PrintResult(Integer.toString(expr.getValue()));
	}

	@Override
	public PrintResult visit(StringLiteral expr) {
		return new PrintResult(expr.getValue());
	}

	@Override
	public PrintResult visit(BooleanLiteral expr) {
		return new PrintResult(expr.getValue());
	}
	@Override
	public PrintResult visit(MoneyLiteral expr) {
		return new PrintResult(expr.getValue().toString());
	}
}
