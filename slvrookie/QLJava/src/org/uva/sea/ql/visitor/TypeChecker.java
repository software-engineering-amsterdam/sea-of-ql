package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.*;
import org.uva.sea.ql.ast.expr.unary.*;
import org.uva.sea.ql.ast.expr.value.*;

public class TypeChecker implements Visitor {

	@Override
	public void visit(Form node, Context context) {
		for (FormElement element : node.getFormBody()) {
			if (element != null) {
				element.accept(this, context);
			}
		}
	}

	@Override
	public void visit(IfBody node, Context context) {
		node.getExpression().accept(this, context);
		for (FormElement element : node.getIfElements()) {
			if (element != null) {
				element.accept(this, context);
			}
		}
	}

	@Override
	public void visit(Question node, Context context) {
		if (context.isDeclared(node.getQuestionID().getName())) {
			context.addError("\n Duplicate ID:" + node.getQuestionID().getName());
			System.out.println("\n Duplicate ID:" + node.getQuestionID().getName());
		} else {
			context.setIdent(node.getQuestionID().getName(), node.getQuestionType());
		}
	}

	@Override
	public void visit(CompQuestion node, Context context) {
		if (context.isDeclared(node.getQuestionID().getName())) {
			context.addError("\n Duplicate ID:" + node.getQuestionID().getName());
			System.out.println("\n Duplicate ID:" + node.getQuestionID().getName());
		} else {
			context.setIdent(node.getQuestionID().getName(), node.getQuestionType());
		}
		node.getQuestionExpr().accept(this, context);
	}

	@Override
	public void visit(UnaryExpr node, Context context) {
		node.getArg().accept(this, context);
	}

	@Override
	public void visit(BinaryExpr node, Context context) {
		if (ExprUtils.areNodesEqualType(node)) {
			node.getLhs().accept(this, context);
			node.getRhs().accept(this, context);
		} else {
			System.out.println("\n Nodes must have same type");
		}
	}

	@Override
	public void visit(Ident node, Context context) {
		if (context.isDeclared(node.getName())) {
			context.getSymbols().get(node.getName());
		}
	} 
	
	/** TODO: Must change visitor implementation from void to type
		because i have to pass values from the leafs to the inner nodes.
	*/
	
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

	@Override
	public void visit(Add node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(And node, Context context) {
		if (!ExprUtils.areNodesBoolean(node)) {
			System.out.println("\n Nodes must be boolean");
		}
	}

	@Override
	public void visit(Div node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(Eq node, Context context) {
		if (!ExprUtils.areNodesEqualType(node)) {
			System.out.println("\n Nodes must be of same type");
		}
	}

	@Override
	public void visit(GEq node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(GT node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(LEq node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(LT node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(Mul node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(NEq node, Context context) {
		if (!ExprUtils.areNodesEqualType(node)) {
			System.out.println("\n Nodes must be of same type");
		}
	}

	@Override
	public void visit(Or node, Context context) {
		if (!ExprUtils.areNodesBoolean(node)) {
			System.out.println("\n Nodes must be boolean");
		}
	}

	@Override
	public void visit(Sub node, Context context) {
		if (!ExprUtils.areNodesArithmetic(node)) {
			System.out.println("\n Nodes must be numerical");
		}
	}

	@Override
	public void visit(Neg node, Context context) {
		if (!ExprUtils.isArgumentArithmetic(node)) {
			System.out.println("\n Node must be numerical");
		}
	}

	@Override
	public void visit(Not node, Context context) {
		if (!ExprUtils.isArgumentBoolean(node)) {
			System.out.println("\n Node must be boolean");
		}
	}

	@Override
	public void visit(Pos node, Context context) {
		if (!ExprUtils.isArgumentArithmetic(node)) {
			System.out.println("\n Node must be numerical");
		}
	}

}