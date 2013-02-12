package org.uva.sea.ql.ast.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public class TypeCheck implements Visitor<Void> {

	private final List<String> errorList = new ArrayList<String>();

	private final HashMap<String, Statement> symbolMap = new HashMap<String, Statement>();

	public int getErrorCount() {
		return errorList.size() ;
	}
	
	@Override
	public Void visit(final Ident id) {
		LineStatement lineStatement;

		lineStatement = (LineStatement) symbolMap.get(id.getName());
		if (lineStatement == null) {
			/***
			 * Ident is not previous defined
			 */
			errorList.add("Line(" + id.getLine() + "," + id.getCharPositionInLine() + ") Field :" + id.getName()
					+ " is not defined.");
		}
		return null;
	}

	@Override
	public Void visit(final UnExpr expr) {
		expr.getExprRightHand().accept(this);
		return null;
	}

	@Override
	public Void visit(final QLProgram qlProgram) {
		symbolMap.clear();
		errorList.clear();

		qlProgram.getCompound().accept(this);

		return null;
	}

	@Override
	public Void visit(final CompoundStatement compoundBlock) {
		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);
		return null;
	}

	@Override
	public Void visit(final LineStatement lineStatement) {
		// Add symbols to the symbolmap so the visitor of the
		// expression can test their existence.
		if (symbolMap.get(lineStatement.getLineId().getName()) == null) {
			// New symbol in map .get returned null
			symbolMap.put(lineStatement.getLineId().getName(), lineStatement);
		} else {
			// Error Symbol already exists.
			errorList.add("Line(" + lineStatement.getLine() + "," + lineStatement.getCharPositionInLine() + ") Field :"
					+ lineStatement.getLineName() + " has multiple definitions.");
		}
		lineStatement.getTypeDescription().accept(this);

		if (lineStatement.getInitalizerExpr() != null) {
			lineStatement.getInitalizerExpr().accept(this);
			// The double dispatch reverses the check order
			// the check order is important because we allow coercion from Integer to Money
			if ( ! lineStatement.getInitalizerExpr().typeOf(symbolMap).isCompatibleTo(lineStatement.getTypeDescription())) {
				errorList.add("Line(" + lineStatement.getLine() + "," + lineStatement.getCharPositionInLine() + ") Field :"
						+ lineStatement.getLineName() + " has incompatible initializer");				
			}
		}

		return null;
	}

	@Override
	public Void visit(final ConditionalStatement conditionalStatement) {
		conditionalStatement.getExpression().accept(this);

		if (!conditionalStatement.getExpressionType(symbolMap).isCompatibleTo(new BooleanType())) {
			// If expression not of type boolean
			errorList.add("Line(nan,nan) If (Expression) : not of type boolean.");
		}
		conditionalStatement.getTrueCompound().accept(this);
		if (conditionalStatement.getFalseCompound() != null) {
			conditionalStatement.getFalseCompound().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(final Type typeDescription) {
		return null;
	}

	private boolean lhsRhsCompatible(BinExpr expr, String operator) {
		expr.getExprLeftHand().accept(this);
		expr.getExprRightHand().accept(this);

		// Do two checks on compatibility because Money is compatible to Integer
		// but not the other way around. The order in the expression is reversed 
		// by the double dispatch.
		//
		if ((expr.getExprLeftHand().typeOf(symbolMap).isCompatibleTo(expr.getExprRightHand().typeOf(symbolMap)))) {
			return true;
		}
		if ((expr.getExprRightHand().typeOf(symbolMap).isCompatibleTo(expr.getExprLeftHand().typeOf(symbolMap)))) {
			return true;
		}
		
		/***
		 * Due to empty AST expression nodes not available the line
		 * numbers/positions. (Annotation of AST would be nice?)
		 */
		errorList.add("Line(nan,nan) Expression: incompatible types on operator: " + operator);
		return false;
	}

	private boolean rhsCompatible(final Expr opExpr, final Expr rhs, final String operator) {
		if (!opExpr.typeOf(symbolMap).isCompatibleTo(rhs.typeOf(symbolMap))) {
			errorList.add("Line(nan,nan) Expression: incompatible operands on operator:" + operator + ".");
			return false;
		}
		return true;
	}

	@Override
	public Void visit(final Add expr) {
		if (lhsRhsCompatible(expr, "+")) {
			rhsCompatible(expr, expr.getExprRightHand(), "+");
		}
		return null;
	}

	@Override
	public Void visit(final Mul expr) {
		if (lhsRhsCompatible(expr, "*")) {
			rhsCompatible(expr, expr.getExprRightHand(), "*");
		}
		return null;
	}

	@Override
	public Void visit(final Div expr) {
		if (lhsRhsCompatible(expr, "/")) {
			rhsCompatible(expr, expr.getExprRightHand(), "/");
		}
		return null;
	}

	@Override
	public Void visit(final Sub expr) {
		if (lhsRhsCompatible(expr, "-")) {
			rhsCompatible(expr, expr.getExprRightHand(), "-");
		}
		return null;
	}

	@Override
	public Void visit(final And expr) {
		if (lhsRhsCompatible(expr, "&&")) {
			rhsCompatible(expr, expr.getExprRightHand(), "&&");
		}
		return null;
	}

	@Override
	public Void visit(final Or expr) {
		if (lhsRhsCompatible(expr, "||")) {
			rhsCompatible(expr, expr.getExprRightHand(), "||");
		}
		return null;
	}

	@Override
	public Void visit(final Eq expr) {
		lhsRhsCompatible(expr, "==");
		return null;
	}

	@Override
	public Void visit(final GT expr) {
		if (lhsRhsCompatible(expr, ">")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList.add("Line(nan,nan) Expression: operator > on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public Void visit(final LT expr) {
		if (lhsRhsCompatible(expr, "<")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList.add("Line(nan,nan) Expression: operator < on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public Void visit(final LEq expr) {
		if (lhsRhsCompatible(expr, "<=")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList.add("Line(nan,nan) Expression: operator <= on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public Void visit(final GEq expr) {
		if (lhsRhsCompatible(expr, ">=")) {
			if (expr.typeOf(symbolMap).isCompatibleTo(expr.getExprLeftHand().typeOf(symbolMap))) {
				errorList.add("Line(nan,nan) Expression: operator >= on boolean operands.");
			}
		}
		return null;
	}

	@Override
	public Void visit(final NEq expr) {
		lhsRhsCompatible(expr, "!=");
		return null;
	}

	public Void visit(final Not expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "!");
		return null;
	}

	@Override
	public Void visit(final Neg expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "-");
		return null;
	}

	@Override
	public Void visit(final Pos expr) {
		rhsCompatible(expr, expr.getExprRightHand(), "+");
		return null;
	}

	@Override
	public Void visit(final IntegerLiteral expr) {
		return null;
	}

	@Override
	public Void visit(final StringLiteral expr) {
		return null;
	}

	@Override
	public Void visit(final BooleanLiteral expr) {
		return null;
	}

	@Override
	public Void visit(final Expr expr) {
		return null;
	}

	@Override
	public Void visit(final BinExpr expr) {
		return null;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	@Override
	public Void visit(MoneyLiteral expr) {
		return null;
	}
}
