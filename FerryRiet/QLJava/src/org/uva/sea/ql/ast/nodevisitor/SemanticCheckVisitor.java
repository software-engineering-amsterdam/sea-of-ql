package org.uva.sea.ql.ast.nodevisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;
import org.uva.sea.ql.ast.types.TypeDescription;

public class SemanticCheckVisitor implements Visitor {

	final List<String> errorList = new ArrayList<String>();

	private HashMap<String, Statement> symbolMap = new HashMap<String, Statement>();

	public SemanticCheckVisitor() {
	}

	@Override
	public VisitorResult visit(Ident id) {
		LineStatement lineStatement;

		lineStatement = (LineStatement) symbolMap.get(id.getName());
		if (lineStatement == null) {
			/***
			 * Ident is not previous defined
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
		if (symbolMap.get(lineStatement.getLineId().getName()) == null) {
			// New symbol in map
			symbolMap.put(lineStatement.getLineId().getName(), lineStatement);
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

	private boolean lhsRhsCompatible(BinExpr expr, String operator) {
		expr.getExprLeftHand().accept(this);
		expr.getExprRightHand().accept(this);

		if (!(expr.getExprLeftHand().typeOf(symbolMap).isCompatibleTo(expr
				.getExprRightHand().typeOf(symbolMap)))) {
			/***
			 * Due to empty AST expression node no availble line
			 * numbers/positions. Annotation of AST?
			 */
			errorList
					.add("Line(nan,nan) Expression: incompatible types on operator: "
							+ operator + ".");
			return false;
		}
		return true;
	}

	private boolean rhsCompatible(Expr opExpr, Expr rhs, String operator) {
		if (!opExpr.typeOf(symbolMap).isCompatibleTo(rhs.typeOf(symbolMap))) {
			errorList
					.add("Line(nan,nan) Expression: incompatible operands on operator:"
							+ operator + ".");
			return false;
		}
		return true;
	}

	@Override
	public VisitorResult visit(Add expr) {
		if (lhsRhsCompatible(expr, "+")) {
			rhsCompatible(expr, expr.getExprRightHand(), "+");
		}
		return null;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		if (lhsRhsCompatible(expr, "*")) {
			rhsCompatible(expr, expr.getExprRightHand(), "*");
		}
		return null;
	}

	@Override
	public VisitorResult visit(Div expr) {
		if (lhsRhsCompatible(expr, "/")) {
			rhsCompatible(expr, expr.getExprRightHand(), "/");
		}
		return null;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		if (lhsRhsCompatible(expr, "-")) {
			rhsCompatible(expr, expr.getExprRightHand(), "-");
		}
		return null;
	}

	@Override
	public VisitorResult visit(And expr) {
		if (lhsRhsCompatible(expr, "&&")) {
			rhsCompatible(expr, expr.getExprRightHand(), "&&");
		}
		return null;
	}

	@Override
	public VisitorResult visit(Or expr) {
		if (lhsRhsCompatible(expr, "||")) {
			rhsCompatible(expr, expr.getExprRightHand(), "||");
		}
		return null;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		lhsRhsCompatible(expr, "==");
		return null;
	}

	@Override
	public VisitorResult visit(GT expr) {
		if (lhsRhsCompatible(expr, ">")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(
					expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList
						.add("Line(nan,nan) Expression: operator < on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public VisitorResult visit(LT expr) {
		if (lhsRhsCompatible(expr, "<")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(
					expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList
						.add("Line(nan,nan) Expression: operator < on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		if (lhsRhsCompatible(expr, "<=")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(
					expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList
						.add("Line(nan,nan) Expression: operator < on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public VisitorResult visit(GEq expr) {
		if (lhsRhsCompatible(expr, ">=")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(
					expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList
						.add("Line(nan,nan) Expression: operator > on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		lhsRhsCompatible(expr, "!=");
		return null;
	}

	public VisitorResult visit(Not expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "!");
		return null;
	}

	@Override
	public VisitorResult visit(Neg expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "-");
		return null;
	}

	@Override
	public VisitorResult visit(Pos expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "+");
		return null;
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {
		return null;
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		return null;
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Expr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		return null;
	}

	public List<String> getErrorList() {
		return errorList;
	}
}
