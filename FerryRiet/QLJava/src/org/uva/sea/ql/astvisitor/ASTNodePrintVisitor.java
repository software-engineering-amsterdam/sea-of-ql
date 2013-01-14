package org.uva.sea.ql.astvisitor;

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

public class ASTNodePrintVisitor implements ASTNodeVisitor {
	
	private String prettyQLProgram = new String() ; ;

	@Override
	public void visit(Expr expr) {
		if (expr.getClass() == IntLiteral.class) {
			prettyQLProgram = prettyQLProgram.concat(Integer.toString(((IntLiteral) expr).getValue()));
		}
		if (expr.getClass() == Ident.class) {
			prettyQLProgram = prettyQLProgram.concat(((Ident) expr).getName());
		}
	}

	@Override
	public void visit(QLProgram qlProgram) {
		prettyQLProgram = prettyQLProgram.concat("form " + qlProgram.getProgramName()) ;
		qlProgram.getCompound().accept(this);
		System.out.println("hello there\n");
		System.out.println(prettyQLProgram);
	}

	@Override
	public void visit(CompoundStatement compoundBlock) {
		prettyQLProgram = prettyQLProgram.concat(" { \n") ;

		for (Statement statement : compoundBlock.getStatementList())
			statement.accept(this);
		
		prettyQLProgram = prettyQLProgram.concat(" } \n") ;
	}

	@Override
	public void visit(LineStatement lineStatement) {
		prettyQLProgram = prettyQLProgram.concat(lineStatement.getLineName() + ": " + lineStatement.getDisplayText());
		lineStatement.getTypeDescription().accept(this);
	}

	@Override
	public void visit(ConditionalStatement conditionalStatement) {
		prettyQLProgram = prettyQLProgram.concat("\nif ( ") ;
		conditionalStatement.getExpression().accept(this);
		prettyQLProgram = prettyQLProgram.concat(" ) ") ;
		conditionalStatement.getCompound().accept(this);
	}

	@Override
	public void visit(TypeDescription typeDescription) {
		if (typeDescription.getClass() == BooleanType.class) {
			prettyQLProgram = prettyQLProgram.concat(" boolean ");
		}
		if (typeDescription.getClass() == StringType.class) {
			prettyQLProgram = prettyQLProgram.concat(" string ");
		}
		if (typeDescription.getClass() == MoneyType.class) {
			prettyQLProgram = prettyQLProgram.concat(" money ");
			if (((MoneyType) typeDescription).getExpr() != null) {
				prettyQLProgram = prettyQLProgram.concat(" ( ");
				((MoneyType) typeDescription).getExpr().accept(this);
				prettyQLProgram = prettyQLProgram.concat(" ) ");
			}
		}
	}

	@Override
	public void visit(BinExpr expr) {
		expr.getExprLeftHand().accept(this);
		if (expr.getClass() == Add.class) prettyQLProgram = prettyQLProgram.concat(" + ");
		else if (expr.getClass() == Sub.class) prettyQLProgram = prettyQLProgram.concat(" - ");
		else if (expr.getClass() == Div.class) prettyQLProgram = prettyQLProgram.concat(" / ");
		else if (expr.getClass() == Mul.class) prettyQLProgram = prettyQLProgram.concat(" * ");
		else if (expr.getClass() == And.class) prettyQLProgram = prettyQLProgram.concat(" && ");
		else if (expr.getClass() == Or.class) prettyQLProgram = prettyQLProgram.concat(" || ");
		else if (expr.getClass() == Eq.class) prettyQLProgram = prettyQLProgram.concat(" == ");
		else if (expr.getClass() == NEq.class) prettyQLProgram = prettyQLProgram.concat(" != ");
		else if (expr.getClass() == GT.class) prettyQLProgram = prettyQLProgram.concat(" > ");
		else if (expr.getClass() == LT.class) prettyQLProgram = prettyQLProgram.concat(" < ");
		expr.getExprRightHand().accept(this);
	}

	@Override
	public void visit(UnExpr expr) {
		if (expr.getClass() == Not.class) prettyQLProgram = prettyQLProgram.concat(" ! ");
		else if (expr.getClass() == Pos.class) prettyQLProgram = prettyQLProgram.concat(" + ");
		else if (expr.getClass() == Neg.class) prettyQLProgram = prettyQLProgram.concat(" - ");
		expr.getExprRightHand().accept(this) ;
	}
}
