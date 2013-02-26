package org.uva.sea.ql.gui;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.IVisitorExpr;
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

/** @description Return a List of identifiers encountered in a given expression
 */
public class VisitorExpressionIdentifiers implements IVisitorExpr<List<Ident>>{

	private <T> List<T> emptyList(){
		return new ArrayList<T>();
	}
	
	
	private <T> List<T> join(List<T> a, List<T> b){
		List<T> result = emptyList();
		
		result.addAll(a);
		result.addAll(b);
		
		return result;
	}
	
	
	private List<Ident> getIdentifiersInBinaryOperator(OperatorBinary ast){
		List<Ident> lhs = ast.getLeftHandOperand().accept(this);
		List<Ident> rhs = ast.getRightHandOperand().accept(this);
		return join(lhs, rhs);
	}
	
	
	private List<Ident> getIdentifiersInUnaryOperator(OperatorUnary ast){
		return ast.getOperand().accept(this);
	}
	
	@Override
	public List<Ident> visit(Int ast) {
		return emptyList();
	}

	@Override
	public List<Ident> visit(Bool ast) {
		return emptyList();
	}

	@Override
	public List<Ident> visit(Str ast) {
		return emptyList();
	}

	@Override
	public List<Ident> visit(Undefined ast) {
		return emptyList();
	}

	@Override
	public List<Ident> visit(Ident ast) {
		
		List<Ident> list = emptyList();
		list.add(ast);
		
		return list;
	}

	@Override
	public List<Ident> visit(Add ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(And ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Div ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Eq ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(GEq ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(GT ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(LEq ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(LT ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Mul ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(NEq ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Not ast) {
		return getIdentifiersInUnaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Or ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Sub ast) {
		return getIdentifiersInBinaryOperator(ast);
	}

	@Override
	public List<Ident> visit(Pos ast) {
		return getIdentifiersInUnaryOperator(ast);
	}
	
	@Override
	public List<Ident> visit(Neg ast) {
		return getIdentifiersInUnaryOperator(ast);
	}
}
