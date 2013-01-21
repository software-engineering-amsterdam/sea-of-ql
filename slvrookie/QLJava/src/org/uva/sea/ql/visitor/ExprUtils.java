package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expr.binary.BinaryExpr;
import org.uva.sea.ql.ast.expr.unary.UnaryExpr;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.MoneyLiteral;

public class ExprUtils {
	
	public static boolean areNodesEqualType(BinaryExpr node){
		return (areNodesArithmetic(node) || areNodesBoolean(node));
	}
	
	public static boolean areNodesArithmetic(BinaryExpr node) {
		return ((node.getLhs() instanceof IntLiteral && node.getRhs() instanceof IntLiteral) ||
				(node.getLhs() instanceof MoneyLiteral && node.getRhs() instanceof MoneyLiteral));
	}
	
	public static boolean areNodesBoolean(BinaryExpr node) {
		return (node.getLhs() instanceof BoolLiteral && node.getRhs() instanceof BoolLiteral);
	}

	public static boolean isArgumentBoolean(UnaryExpr node) {
		return (node.getArg() instanceof BoolLiteral) ;	
	}
	
	public static boolean isArgumentArithmetic(UnaryExpr node){
		return ((node.getArg() instanceof IntLiteral) || (node.getArg() instanceof MoneyLiteral));
	}
	
}
