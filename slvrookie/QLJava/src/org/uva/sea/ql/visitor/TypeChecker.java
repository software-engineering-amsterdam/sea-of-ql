package org.uva.sea.ql.visitor;


import org.uva.sea.ql.ast.CompQuestion;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.IfBody;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expr.BinaryExpr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.UnaryExpr;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;
import org.uva.sea.ql.ast.expr.value.StringLiteral;


public class TypeChecker implements Visitor {
	
	
	@Override
	public void visit(Form node, Context con) {
		for (FormElement element : node.getFormBody()) {
			if (element != null) {
				element.accept(this, con);
			}	
		}
	}
	
	@Override
	public void visit(IfBody node, Context con) {
		node.getExpression().accept(this, con);
		for (FormElement element : node.getIfElements()) {
			if (element != null) {
				element.accept(this, con);
			}	
		}
	}
	
	@Override
	public void visit(Question node, Context con) {
		if (con.isDeclared(node.getQuestionID().getName())){
			con.addError("\n Duplicate ID:"+ node.getQuestionID().getName());
			System.out.println("\n Duplicate ID:"+ node.getQuestionID().getName());
			System.out.println(con.getErrors());
		}
		else {
			con.setIdent(node.getQuestionID().getName(), node.getQuestionType());
		}
	}
	
	@Override
	public void visit(CompQuestion node, Context con) {
		if (con.isDeclared(node.getQuestionID().getName())){
			con.addError("\n Duplicate ID:"+ node.getQuestionID().getName());
			System.out.println("\n Duplicate ID:"+ node.getQuestionID().getName());
		}
		else {
			con.setIdent(node.getQuestionID().getName(), node.getQuestionType());
		}
		node.getQuestionExpr().accept(this, con);
	}
	
	@Override
	public void visit(UnaryExpr node, Context con) {
		node.getArg().accept(this, con);

	}
	
	@Override
	public void visit(BinaryExpr node, Context con) {
		node.getLhs().accept(this, con);
		node.getRhs().accept(this, con);
	}
	
	@Override
	public void visit(Ident node, Context con) {
		if(con.isDeclared(node.getName())){
			con.getSymbols().get(node.getName());
		}	
	}

	@Override
	public void visit(BoolLiteral node, Context context) {
	}

	@Override
	public void visit(IntLiteral node, Context context) {
	}

	@Override
	public void visit(MoneyLiteral node, Context context) {
	}

	@Override
	public void visit(StringLiteral node, Context context) {
	}

}