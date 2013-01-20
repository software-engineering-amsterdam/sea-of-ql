package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Div;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.Sub;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;

public class ASTNodeVisitor implements Visitor {

	@Override
	public void visit(Binary expr) {
		
		if(expr.getClass()==Add.class) System.out.print(" + ");
		else if(expr.getClass()==Sub.class) System.out.print(" - ");
		else if(expr.getClass()==Mul.class) System.out.print(" * ");
		else if(expr.getClass()==Div.class) System.out.print(" / ");
		if(expr.getLeftExpr().getClass()==(Int.class) || expr.getLeftExpr().getClass()==Binary.class){
		expr.getLeftExpr().accept(this);
		expr.getRightExpr().accept(this);
		}
		else System.out.print("opa ");
		
	}

	public void visit(Expr value) {
		if(value.getClass()== Int.class) System.out.print(value);
		
	}

}
