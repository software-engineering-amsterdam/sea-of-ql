package org.uva.sea.ql.visitor.semantics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.typesystem.QLTypeSystem;

import com.google.common.base.Joiner;

public class TypeCheckVisitor implements ExpressionVisitor<Void>, StatementVisitor<Void> {
	
	private final QLTypeSystem typeSystem;
	
	private List<TypeCheckError> errorList;
	
	public TypeCheckVisitor(QLTypeSystem typeSystem){
		this.typeSystem = typeSystem;
		errorList = new ArrayList<>();
	}
	
	public boolean hasTypeCheckErrors(){
		return !errorList.isEmpty();
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
			castedType = typeSystem.cast(expressionType, dt);
			if(castedType != DataType.UNDEF){
				// break from loop if we've found compatible type
				break;
			}
		}
		if(castedType == DataType.UNDEF){
			errorList.add(new TypeCheckError("Expression " + expr + " is of incomaptible type (" + expressionType + "). Should be one of " + Joiner.on(',').join(dataTypes)));
			return expressionType;
		}
		return castedType;
	}
	
	private DataType cast(DataType dt1, DataType dt2){
		DataType castedType = typeSystem.cast(dt1, dt2);
		//if(castedType == DataType.UNDEF){
		//	errorList.add(new TypeCheckError(dt1 + " is not compatible with " + dt2));
		//}
		return castedType;
	}

	@Override
	public Void visit(final Identifier ident) {
		//if(this.typeSystem.resolve(ident) == null){
		//	throw new SemanticException("Undeclared referenced identity '" + ident.getName() + "'");
		//}
		return null;
	}
	
	@Override
	public Void visit(BooleanLiteral literal) {
		typeSystem.register(literal, literal.getDataType());
		return null;
		
	}

	@Override
	public Void visit(IntLiteral literal) {
		typeSystem.register(literal, literal.getDataType());
		return null;
		
	}

	@Override
	public Void visit(TextLiteral literal) {
		typeSystem.register(literal, literal.getDataType());
		return null;
		
	}
	
	// Binary from here

	@Override
	public Void visit(Add expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT);
		return null;
	}

	@Override
	public Void visit(Div expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(Mul expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(Sub expression) {
		this.visitBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(Or expression) {
		this.visitBooleanBinary(expression, DataType.BOOLEAN);
		return null;
	}
	
	@Override
	public Void visit(And expression) {
		this.visitBooleanBinary(expression, DataType.BOOLEAN);
		return null;
	}

	@Override
	public Void visit(Eq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT, DataType.BOOLEAN);
		return null;
	}

	@Override
	public Void visit(GEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(LEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(LT expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}
	
	@Override
	public Void visit(GT expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(NEq expression) {
		this.visitBooleanBinary(expression, DataType.INTEGER, DataType.MONEY, DataType.TEXT, DataType.BOOLEAN);
		return null;
	}
	
	// Unary from here

	@Override
	public Void visit(Neg expression) {
		this.visitUnary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(Pos expression) {
		this.visitUnary(expression, DataType.INTEGER, DataType.MONEY);
		return null;
	}

	@Override
	public Void visit(Not expression) {
		this.visitBooleanUnary(expression, DataType.BOOLEAN);
		return null;
	}
	
	//TODO refactor visitUnary / binary etc
	
	private void visitUnary(final UnaryExpression expression, final DataType... acceptedTypes) {
		expression.getExpr().accept(this);
		
		final DataType castedType = this.checkCast(expression.getExpr(), acceptedTypes);
		typeSystem.register(expression, castedType);
	}
	
	private void visitBooleanUnary(final UnaryExpression expression, final DataType... acceptedTypes) {
		expression.getExpr().accept(this);
		
		this.checkCast(expression.getExpr(), acceptedTypes);
		typeSystem.register(expression, DataType.BOOLEAN);
	}
	
	private void visitBinary(BinaryExpression expression, DataType... acceptedTypes){
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		final DataType lhsCastedType = this.checkCast(expression.getLhs(), acceptedTypes);
		final DataType rhsCastedType = this.checkCast(expression.getRhs(), acceptedTypes);
		
		final DataType castedType = this.cast(lhsCastedType, rhsCastedType);
		
		typeSystem.register(expression, castedType);
	}
	
	private void visitBooleanBinary(final BinaryExpression expression, final DataType... acceptedTypes){
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		final DataType lhsCastedType = this.checkCast(expression.getLhs(), acceptedTypes);
		final DataType rhsCastedType = this.checkCast(expression.getRhs(), acceptedTypes);
				
		typeSystem.register(expression, DataType.BOOLEAN);
	}
	
	// Statements
	
	@Override
	public Void visit(Form form) {
		form.getCompoundStatement().accept(this);
		return null;
	}

	@Override
	public Void visit(CompoundStatement statement) {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(Question question) {
		typeSystem.register(question.getIdent(), question.getDataType());
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		statement.getExpression().accept(this);
		
		checkCast(statement.getExpression(), DataType.BOOLEAN);
		
		statement.getStatement().accept(this);
		return null;
	}
	
	@Override
	public Void visit(IfElseStatement statement) {
		// first visit as it was a normal ifstatement
		this.visit((IfStatement)statement);
		// now only visit the else statement
		statement.getElseStatement().accept(this);
		return null;
	}
	
}