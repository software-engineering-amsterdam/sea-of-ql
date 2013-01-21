package org.uva.sea.ql.visitor;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;

public class ASTNodeVisitor implements Visitor {
    private ArrayList<Ident> list=new ArrayList<Ident>();
	@Override
	public void visit(Binary expr) {
		
		
		if(expr.getLeftExpr().getClass()!=Value.class || expr.getLeftExpr().getClass()!=Binary.class){
			System.out.print("Invalid '+' left operand ");
		}
		if(expr.getRightExpr().getClass()!=Value.class || expr.getRightExpr().getClass()!=Binary.class){
			System.out.print("Invalid '+' Right operand ");
		}
		expr.getLeftExpr().accept(this);
		expr.getRightExpr().accept(this);
		
	}

	public void visit(Value value) {
		if(value.getClass()== Int.class){
			Int val=(Int) value;
			System.out.println(val.getValue());
		}
		
	}

	@Override
	public void visit(Form form) {
		System.out.println("eee"+form);
		
		
	}

	@Override
	public void visit(Body body) {
		//for (Statement statement : compoundBlock.getStatementList())
			//statement.accept(this);	
			
		
		
	}

	@Override
	public void visit(Question question) {
		Ident id=question.getId();
		list.add(id);
		question.getType().accept(this);
		
		
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) {
		Ident id=computedQuestion.getId();
		list.add(id);
		computedQuestion.getType().accept(this);
		
	}

	
}
