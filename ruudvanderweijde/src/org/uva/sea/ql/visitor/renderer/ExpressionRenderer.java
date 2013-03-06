package org.uva.sea.ql.visitor.renderer;

import java.util.LinkedList;
import java.util.List;

import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public class ExpressionRenderer implements IExpressionVisitor<String> {
	private String strExpression;
	private List<Ident> idents;
	
	public ExpressionRenderer() {
		this.idents = new LinkedList<Ident>();
		this.strExpression = new String();
	}
	
	@Override
	public String visit(Add ast) {
		return binaryToString(ast);
	}
	
	@Override
	public String visit(And ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Div ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Eq ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(GEq ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(GT ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(LEq ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(LT ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Mul ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(NEq ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Or ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Sub ast) {
		return binaryToString(ast);
	}

	@Override
	public String visit(Neg ast) {
		return unaryToString(ast); 
	} 
	
	@Override
	public String visit(Not ast) {
		return unaryToString(ast); 
	}

	@Override
	public String visit(Pos ast) {
		return unaryToString(ast); 
	}

	@Override
	public String visit(Bool ast) {
		return ast.getValue() ? "true" : "false";
	}

	@Override
	public String visit(Int ast) {
		return ast.getValue().toString();
	}

	@Override
	public String visit(StringLiteral ast) {
		return ast.getValue();
	}

	@Override
	public String visit(Ident ast) {
		idents.add(ast);
		return "getValueOf('"+ast.getName()+"')"; 
	}

	private String binaryToString(Binary ast) {
		strExpression += ast.getLhs().accept(this);
		strExpression += ast.toString();
		strExpression += ast.getRhs().accept(this);
		return strExpression;
	}
	
	private String unaryToString(Unary ast) {
		strExpression += ast.toString();
		strExpression += ast.getArg().accept(this);
		return strExpression;
	}

	public List<Ident> getIdents() {
		return idents;
	}
}
