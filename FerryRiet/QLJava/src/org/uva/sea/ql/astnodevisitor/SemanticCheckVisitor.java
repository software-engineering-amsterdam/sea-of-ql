package org.uva.sea.ql.astnodevisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Div;
import org.uva.sea.ql.ast.Eq;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.NEq;
import org.uva.sea.ql.ast.Neg;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.Or;
import org.uva.sea.ql.ast.Pos;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.Sub;
import org.uva.sea.ql.ast.TypeDescription;
import org.uva.sea.ql.ast.UnExpr;

public class SemanticCheckVisitor implements Visitor {

	final List<String> errorList = new ArrayList<String>();

	private HashMap<Ident, Statement> symbolMap = new HashMap<Ident, Statement>();

	public SemanticCheckVisitor() {
	}

	@Override
	public VisitorResult visit(Ident id) {
		LineStatement lineStatement;

		lineStatement = (LineStatement) symbolMap.get(id);
		if (lineStatement == null) {
			/***
			 * Ident not previous defined
			 */
			errorList.add("Line(" + id.getLine() + ","
					+ id.getCharPositionInLine() + ") Field :" + id.getName()
					+ " is not defined.");
		}
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		expr.getExprRightHand().accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		symbolMap.clear();
		errorList.clear();

		qlProgram.getCompound().accept(this);
		for (String errorSting : errorList) {
			System.out.println(errorSting);
		}
		return null;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		// Add symbols to the symbolmap so the visitor of the
		// expression can test their existance/missing.
		if (symbolMap.get(lineStatement.getLineId()) == null) {
			// New symbol in map
			symbolMap.put(lineStatement.getLineId(), lineStatement);
		} else {
			errorList.add("Line(" + lineStatement.getLine() + ","
					+ lineStatement.getCharPositionInLine() + ") Field :"
					+ lineStatement.getLineName()
					+ " has multiple definitions.");
		}
		lineStatement.getTypeDescription().accept(this);

		if (lineStatement.getInitalizerExpr() != null) {
			lineStatement.getInitalizerExpr().accept(this);
		}

		return null;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		conditionalStatement.getExpression().accept(this);
		conditionalStatement.getTrueCompound().accept(this);
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalStatement.getFalseCompound().accept(this);
		}
		return null;
	}

	@Override
	public VisitorResult visit(TypeDescription typeDescription) {
		return null;
	}

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
		if (expr.getExprLeftHand().typeOf(symbolMap)
				.isCompatibleTo(expr.getExprRightHand().typeOf(symbolMap))) {

		} else {
			errorList.add("Type mismatch");
		}
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
