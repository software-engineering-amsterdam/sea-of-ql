package org.uva.sea.ql.util;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.operative.Add;
import org.uva.sea.ql.ast.operative.And;
import org.uva.sea.ql.ast.operative.Div;
import org.uva.sea.ql.ast.operative.Eq;
import org.uva.sea.ql.ast.operative.GEq;
import org.uva.sea.ql.ast.operative.GT;
import org.uva.sea.ql.ast.operative.LEq;
import org.uva.sea.ql.ast.operative.LT;
import org.uva.sea.ql.ast.operative.Mul;
import org.uva.sea.ql.ast.operative.NEq;
import org.uva.sea.ql.ast.operative.Neg;
import org.uva.sea.ql.ast.operative.Not;
import org.uva.sea.ql.ast.operative.OperatorBinary;
import org.uva.sea.ql.ast.operative.OperatorUnary;
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Pos;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;

public class VisitorExprPrint implements IVisitorExpr<String>{
	
	private String printOperatorBinary(OperatorBinary op, String symbol){
		return 	"(" + op.getLeftHandOperand().accept(this) + symbol + 
				op.getRightHandOperand().accept(this) + ")";
	}
	
	
	private String printOperatorUnary(OperatorUnary op, String symbol){
		return symbol + op.getOperand();
	}
	
	
	@Override
	public String visit(Ident ast) {
		return ast.getName();
	}

	@Override
	public String visit(Add ast) {
		return printOperatorBinary(ast, "+");
	}

	@Override
	public String visit(And ast) {
		return printOperatorBinary(ast, "&&");
	}

	@Override
	public String visit(Div ast) {
		return printOperatorBinary(ast, "/");
	}

	@Override
	public String visit(Eq ast) {
		return printOperatorBinary(ast, "==");
	}

	@Override
	public String visit(GEq ast) {
		return printOperatorBinary(ast, ">=");
	}

	@Override
	public String visit(GT ast) {
		return printOperatorBinary(ast, ">");
	}

	@Override
	public String visit(LEq ast) {
		return printOperatorBinary(ast, "<=");
	}

	@Override
	public String visit(LT ast) {
		return printOperatorBinary(ast, "<");
	}

	@Override
	public String visit(Mul ast) {
		return printOperatorBinary(ast, "*");
	}

	@Override
	public String visit(Neg ast) {
		return printOperatorUnary(ast, "-");
	}

	@Override
	public String visit(NEq ast) {
		return printOperatorBinary(ast, "!=");
	}

	@Override
	public String visit(Not ast) {
		return printOperatorUnary(ast, "!");
	}

	@Override
	public String visit(Or ast) {
		return printOperatorBinary(ast, "||");
	}

	@Override
	public String visit(Pos ast) {
		return printOperatorUnary(ast, "+");
	}

	@Override
	public String visit(Sub ast) {
		return printOperatorBinary(ast, "-");
	}
	
	@Override
	public String visit(Int ast) {
		return ast.toString();
	}

	@Override
	public String visit(Bool ast) {
		return ast.toString();
	}

	@Override
	public String visit(Str ast) {
		return ast.toString();
	}


	@Override
	public String visit(Undefined ast) {
		return ast.toString();
	}


	
	
}
