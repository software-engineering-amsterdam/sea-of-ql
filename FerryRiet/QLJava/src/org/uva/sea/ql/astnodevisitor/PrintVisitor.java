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

/*	@Override
	public VisitorResult visit(BinExpr expr) {
		PrintVisitorResult result = null;

		result = (PrintVisitorResult) expr.getExprLeftHand().accept(this);

		if (expr.getClass() == Add.class)
			result.appendResult(" + ");
		else if (expr.getClass() == Sub.class)
			result.appendResult(" - ");
		else if (expr.getClass() == Div.class)
			result.appendResult(" / ");
		else if (expr.getClass() == Mul.class)
			result.appendResult(" * ");
		else if (expr.getClass() == And.class)
			result.appendResult(" && ");
		else if (expr.getClass() == Or.class)
			result.appendResult(" || ");
		else if (expr.getClass() == Eq.class)
			result.appendResult(" == ");
		else if (expr.getClass() == NEq.class)
			result.appendResult(" != ");
		else if (expr.getClass() == GT.class)
			result.appendResult(" > ");
		else if (expr.getClass() == LT.class)
			result.appendResult(" < ");

		result.appendResult(expr.getExprRightHand().accept(this));

		return result;
	}
*/
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

	/*
	 * @Override public VisitorResult visit(Expr expr) { PrintVisitorResult
	 * result = null; if (expr.getClass() == IntLiteral.class) { IntLiteral
	 * intLit = (IntLiteral) expr; result = new
	 * PrintVisitorResult(Integer.toString(intLit.getValue())); } if
	 * (expr.getClass() == BooleanLiteral.class) { BooleanLiteral boolLit =
	 * (BooleanLiteral) expr; result = new
	 * PrintVisitorResult(boolLit.getValue()); } if (expr.getClass() ==
	 * StringLiteral.class) { StringLiteral stringLit = (StringLiteral) expr;
	 * result = new PrintVisitorResult(stringLit.getValue()); } if
	 * (expr.getClass() == Ident.class) { Ident id = (Ident) expr; result = new
	 * PrintVisitorResult(id.getName()); } return result; }
	 */
	@Override
	public VisitorResult visit(Add expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Div expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(And expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Or expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(GT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(LT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Not expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Neg expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Pos expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Ident expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Expr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}
}
