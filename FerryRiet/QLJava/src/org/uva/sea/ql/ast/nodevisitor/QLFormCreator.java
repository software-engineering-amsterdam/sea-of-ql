package org.uva.sea.ql.ast.nodevisitor;

import java.util.HashMap;

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
import org.uva.sea.ql.ast.operators.ExpressionResult;
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
import org.uva.sea.ql.driver.QLForm;

public class QLFormCreator implements Visitor {
	private QLForm qlform = new QLForm();
	private HashMap<String, ExpressionResult> symbols = new HashMap<String, ExpressionResult>();

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		qlform.setFormName(qlProgram.getProgramName());
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
		
		return null;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		// TODO Auto-generated method stub
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
	public VisitorResult visit(GEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
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
	public VisitorResult visit(TypeDescription typeDescription) {
		// TODO Auto-generated method stub
		return null;
	}
}
