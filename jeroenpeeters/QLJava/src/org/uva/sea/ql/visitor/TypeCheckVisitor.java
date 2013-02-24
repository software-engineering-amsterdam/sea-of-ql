package org.uva.sea.ql.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfElseStatement;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.BinaryExpr;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.GT;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;
import org.uva.sea.ql.ast.expression.unary.UnaryExpr;
import org.uva.sea.ql.typesystem.QLTypeSystem;

import com.google.common.base.Joiner;

public class TypeCheckVisitor implements ASTVisitor {
	
	private final QLTypeSystem typeSystem;
	
	private List<TypeCheckError> errorList;
	
	public TypeCheckVisitor(QLTypeSystem typeSystem){
		this.typeSystem = typeSystem;
		errorList = new ArrayList<>();
	}
	
	public Iterator<TypeCheckError> getTypeCheckErrorIterator(){
		return this.errorList.iterator();	
	}
	
	/**private DataType checkTypeCompatibility(final Expression expr1, final Expression expr2){
		final DataType castedType = this.cast(
				typeSystem.resolve(expr1), typeSystem.resolve(expr2));
		
		if(castedType == DataType.UNDEF){
			errorList.add(new TypeCheckError(expr1 + " is not type compatible with " + expr2));
		}
		return castedType;
	}*/
	
	private DataType checkCast(final Expression expr, final DataType... dataTypes){
		final DataType expressionType = typeSystem.resolve(expr);
		DataType castedType = DataType.UNDEF;
		for(final DataType dt : dataTypes){
			castedType =  this.cast(expressionType, dt);
			if(castedType != DataType.UNDEF){
				// break from loop if we've found compatible type
				break;
			}
		}
		if(castedType == DataType.UNDEF){
			errorList.add(new TypeCheckError("Expression " + expr + " is of incomaptible type. Should be one of " + Joiner.on(',').join(dataTypes)));
		}
		return castedType;
	}
	
	private DataType cast(DataType dt1, DataType dt2){
		return typeSystem.cast(dt1, dt2);
	}

	@Override
	public void visit(Form form) {
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		typeSystem.register(question.getIdent(), question.getDataType());
	}

	@Override
	public void visit(IfStatement statement) {
		statement.getExpression().accept(this);
		
		checkCast(statement.getExpression(), DataType.BOOLEAN);
		
		statement.getStatement().accept(this);
	}
	
	@Override
	public void visit(IfElseStatement statement) {
		// first visit as it was a normal ifstatement
		this.visit((IfStatement)statement);
		// now only visit the else statement
		statement.getElseStatement().accept(this);
	}

	@Override
	public void visit(final Identifier ident) {
		//if(this.typeSystem.resolve(ident) == null){
		//	throw new SemanticException("Undeclared referenced identity '" + ident.getName() + "'");
		//}
	}

	@Override
	public void visit(final Literal literal) {
		typeSystem.register(literal, literal.getDataType());
	}
	
	// Binary from here

	@Override
	public void visit(Add expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT);
	}

	@Override
	public void visit(Div expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(Mul expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(Sub expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(Or expression) {
		this.visitBooleanBinary(expression, DataType.BOOLEAN);
	}
	
	@Override
	public void visit(And expression) {
		this.visitBooleanBinary(expression, DataType.BOOLEAN);
	}

	@Override
	public void visit(Eq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT, DataType.BOOLEAN);
	}

	@Override
	public void visit(GEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(LEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(LT expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
	}
	
	@Override
	public void visit(GT expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);		
	}

	@Override
	public void visit(NEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT, DataType.BOOLEAN);
	}
	
	// Unary from here

	@Override
	public void visit(Neg expression) {
		this.visitUnary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(Pos expression) {
		this.visitUnary(expression, DataType.INTEGER, DataType.MONEY);
	}

	@Override
	public void visit(Not expression) {
		this.visitBooleanUnary(expression, DataType.BOOLEAN);
	}
	
	//TODO refactor visitUnary / binary etc
	
	private void visitUnary(final UnaryExpr expression, final DataType... acceptedTypes) {
		expression.getExpr().accept(this);
		
		final DataType castedType = this.checkCast(expression.getExpr(), acceptedTypes);
		typeSystem.register(expression, castedType);
	}
	
	private void visitBooleanUnary(final UnaryExpr expression, final DataType... acceptedTypes) {
		expression.getExpr().accept(this);
		
		this.checkCast(expression.getExpr(), acceptedTypes);
		typeSystem.register(expression, DataType.BOOLEAN);
	}
	
	private void visitBinary(BinaryExpr expression, DataType... acceptedTypes){
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		final DataType lhsCastedType = this.checkCast(expression.getLhs(), acceptedTypes);
		final DataType rhsCastedType = this.checkCast(expression.getRhs(), acceptedTypes);
		
		final DataType castedType = this.cast(lhsCastedType, rhsCastedType);
		
		typeSystem.register(expression, castedType);
	}
	
	private void visitBooleanBinary(final BinaryExpr expression, final DataType... acceptedTypes){
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		final DataType lhsCastedType = this.checkCast(expression.getLhs(), acceptedTypes);
		final DataType rhsCastedType = this.checkCast(expression.getRhs(), acceptedTypes);
				
		typeSystem.register(expression, DataType.BOOLEAN);
	}
	
}