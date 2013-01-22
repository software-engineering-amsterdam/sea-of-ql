package org.uva.sea.ql.astnodevisitor;

import org.uva.sea.ql.ast.*;

public class PrintVisitor implements Visitor {

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		PrintVisitorResult pres;

		pres = new PrintVisitorResult("form " + qlProgram.getProgramName());

		pres.appendResult(qlProgram.getCompound().accept(this));

		return pres;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		PrintVisitorResult pres;

		pres = new PrintVisitorResult(" { ");
		for (Statement statement : compoundBlock.getStatementList())
			pres.appendResult(statement.accept(this));

		pres.appendResult(" } ");
		return pres;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		PrintVisitorResult pres;

		pres = new PrintVisitorResult(lineStatement.getLineName() + ": "
				+ lineStatement.getDisplayText());

		pres.appendResult(lineStatement.getTypeDescription().accept(this));

		if (lineStatement.getInitalizerExpr() != null) {
			pres.appendResult(" ( ");
			pres.appendResult(lineStatement.getInitalizerExpr().accept(this));
			pres.appendResult(" ) ");
		}

		return pres;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		PrintVisitorResult result = new PrintVisitorResult(" if ( ");

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
	public VisitorResult visit(TypeDescription typeDescription) {
		PrintVisitorResult pres = null;

		if (typeDescription.getClass() == BooleanType.class) {
			pres = new PrintVisitorResult(" boolean ");
		}
		if (typeDescription.getClass() == StringType.class) {
			pres = new PrintVisitorResult(" string ");
		}
		if (typeDescription.getClass() == MoneyType.class) {
			pres = new PrintVisitorResult(" money ");

		}
		return pres;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		PrintVisitorResult result = null;

		if (expr.getClass() == Not.class)
			result = new PrintVisitorResult(" ! ");
		else if (expr.getClass() == Pos.class)
			result = new PrintVisitorResult(" + ");
		else if (expr.getClass() == Neg.class)
			result = new PrintVisitorResult(" - ");

		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Expr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Add expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" + ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" * ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Div expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" / ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" - ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(And expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" && ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Or expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" || ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" == ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(GT expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" > ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(LT expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" < ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" <= ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" != ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(GEq expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);
		result.appendResult(" >= ");
		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}

	@Override
	public VisitorResult visit(Not expr) {
		PrintVisitorResult result = new PrintVisitorResult(" ! ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public VisitorResult visit(Neg expr) {
		PrintVisitorResult result = new PrintVisitorResult(" - ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public VisitorResult visit(Pos expr) {
		PrintVisitorResult result = new PrintVisitorResult(" + ");
		return result.appendResult(expr.getExprRightHand().accept(this));
	}

	@Override
	public VisitorResult visit(Ident expr) {
		return new PrintVisitorResult(expr.getName());
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {
		return new PrintVisitorResult(Integer.toString(expr.getValue()));
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		return new PrintVisitorResult(expr.getValue());
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		return new PrintVisitorResult(expr.getValue());
	}

}
