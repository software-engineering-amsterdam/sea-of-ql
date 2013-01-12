package org.uva.sea.ql.astvisitor;

import java.util.Iterator;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanType;
import org.uva.sea.ql.ast.CompoundBlock;
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
import org.uva.sea.ql.ast.UnExpr;

public class ASTNodePrintVisitor implements ASTNodeVisitor {

	@Override
	public void visit(Expr expr) {
		if (expr.getClass() == IntLiteral.class) {
			System.out.print(((IntLiteral) expr).value);
		}
		if (expr.getClass() == Ident.class) {
			System.out.print(((Ident) expr).getName());
		}
	}

	@Override
	public void visit(QLProgram qlProgram) {
		System.out.print("form " + qlProgram.programName);
		qlProgram.compound.accept(this);
	}

	@Override
	public void visit(CompoundBlock compoundBlock) {
		System.out.print(" { \n");
		for (Statement statement : compoundBlock.statementList)
			statement.accept(this);
		System.out.println(" } ");
	}

	@Override
	public void visit(LineStatement lineStatement) {
		System.out.print(lineStatement.lineName + ": ");
		System.out.print(lineStatement.displayText);
		lineStatement.typeDescription.accept(this);
		System.out.println();
	}

	@Override
	public void visit(ConditionalStatement conditionalStatement) {
		System.out.print("if (");
		conditionalStatement.expression.accept(this);
		System.out.print(") ");
		conditionalStatement.compound.accept(this);
	}

	@Override
	public void visit(TypeDescription typeDescription) {
		if (typeDescription.getClass() == BooleanType.class) {
			System.out.println("boolean");
		}
		if (typeDescription.getClass() == StringType.class) {
			System.out.println("string");
		}
		if (typeDescription.getClass() == MoneyType.class) {
			System.out.println("money");
			if (((MoneyType) typeDescription).expression != null) {
				((MoneyType) typeDescription).expression.accept(this);
			}
		}
	}

	@Override
	public void visit(BinExpr expr) {
		expr.exLeftHand.accept(this);
		System.out.print(" BinOp ");
		expr.exRightHand.accept(this);
	}

	@Override
	public void visit(UnExpr expr) {
		System.out.print(" UnOp ");
		expr.exRightHand.accept(this);
	}
}
