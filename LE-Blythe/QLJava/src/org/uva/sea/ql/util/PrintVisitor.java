package org.uva.sea.ql.util;

import java.util.List;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.OperatorBinary;
import org.uva.sea.ql.ast.OperatorUnary;
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
import org.uva.sea.ql.ast.operative.Or;
import org.uva.sea.ql.ast.operative.Pos;
import org.uva.sea.ql.ast.operative.Sub;
import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Int;
import org.uva.sea.ql.ast.primitive.Str;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.Branch;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.errors.Error;
import org.uva.sea.ql.interfaces.IVisitor;

public class PrintVisitor implements IVisitor<String>{

	private static final String UNDEFINED = "undefined";
	
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
	public String visit(Form form) {
		return null;
	}

	@Override
	public String visit(Block block) {
		return null;
	}

	@Override
	public String visit(Branch branch) {
		return null;
	}

	@Override
	public String visit(Question question) {
		return null;
	}

	@Override
	public String visit(Int ast) {
		
		if(ast.isDefined())
			return Integer.toString(ast.getValue());
		
		return UNDEFINED;
	}

	@Override
	public String visit(Bool ast) {
		
		if(ast.isDefined())
			return Boolean.toString(ast.getValue());
		
		return UNDEFINED;
	}

	@Override
	public String visit(Str ast) {
		
		if(ast.isDefined())
			return ast.getValue();
		
		return UNDEFINED;
	}
	
}
