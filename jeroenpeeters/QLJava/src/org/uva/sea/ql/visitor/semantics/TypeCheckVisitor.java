package org.uva.sea.ql.visitor.semantics;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.uva.sea.ql.ast.statement.Label;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.ast.type.AnyType;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefType;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TypeCheckVisitor implements ExpressionVisitor<Type>, StatementVisitor<Void> {

	private final Map<Identifier, Type> typeEnv;

	private final List<TypeCheckError> errorList = Lists.newArrayList();
	
	public TypeCheckVisitor(){
		typeEnv = Maps.newHashMap();
	}
	
	public TypeCheckVisitor(final Map<Identifier, Type> typeEnv){
		this.typeEnv = typeEnv;
	}

	public boolean hasTypeCheckErrors() {
		return !errorList.isEmpty();
	}

	public Iterator<TypeCheckError> getTypeCheckErrorIterator() {
		return this.errorList.iterator();
	}

	@Override
	public Type visit(Identifier identifier) {
		Type type = identifier.typeOf(typeEnv);
		if(new UndefType().equals(type)){
			newTypeCheckError("Identifier '"+identifier.getName()+"' is undefined.");
		}
		return type;
	}

	@Override
	public Type visit(BooleanLiteral literal) {
		return literal.typeOf(typeEnv);
	}

	@Override
	public Type visit(IntLiteral literal) {
		return literal.typeOf(typeEnv);
	}

	@Override
	public Type visit(TextLiteral literal) {
		return literal.typeOf(typeEnv);
	}

	@Override
	public Type visit(Add expression) {
		return visitBinaryExpression(expression, "Addition", new NumericType());
	}

	@Override
	public Type visit(Div expression) {
		return visitBinaryExpression(expression, "Division", new NumericType());
	}

	@Override
	public Type visit(Mul expression) {
		return visitBinaryExpression(expression, "Multiplication", new NumericType());
	}

	@Override
	public Type visit(Sub expression) {
		return visitBinaryExpression(expression, "Subtraction", new NumericType());
	}

	@Override
	public Type visit(And expression) {
		return visitBinaryExpression(expression, "And", new BooleanType());
	}

	@Override
	public Type visit(Eq expression) {
		return visitBinaryExpression(expression, "Equals", new AnyType());
	}

	@Override
	public Type visit(GEq expression) {
		return visitBinaryExpression(expression, "GreaterEquals", new NumericType());
	}

	@Override
	public Type visit(LEq expression) {
		return visitBinaryExpression(expression, "LesserEquals", new NumericType());
	}

	@Override
	public Type visit(GT expression) {
		return visitBinaryExpression(expression, "GreaterThan", new NumericType());
	}

	@Override
	public Type visit(LT expression) {
		return visitBinaryExpression(expression, "LesserThan", new NumericType());
	}

	@Override
	public Type visit(NEq expression) {
		return visitBinaryExpression(expression, "NotEquals", new AnyType());
	}

	@Override
	public Type visit(Or expression) {
		return visitBinaryExpression(expression, "Or", new BooleanType());
	}

	@Override
	public Type visit(Neg expression) {
		return visitUnaryExpression(expression, "Negative", new NumericType());
	}

	@Override
	public Type visit(Pos expression) {
		return visitUnaryExpression(expression, "Positive", new NumericType());
	}

	@Override
	public Type visit(Not expression) {
		return visitUnaryExpression(expression, "Not", new BooleanType());
	}
	
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
		typeEnv.put(question.getIdent(), question.getType());
		return null;
	}

	@Override
	public Void visit(Label label) {
		final Iterator<Expression> expressionIterator = label.getExpressions();
		while(expressionIterator.hasNext()){
			expressionIterator.next().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		final Type type = statement.getExpression().accept(this);

		if (type.isCompatibleTo(new BooleanType()) == false) {
			newTypeCheckError("Expression in if-statement is not compatible to boolean.");
		}
		
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
	
	private void newTypeCheckError(String errorMessage) {
		errorList.add(new TypeCheckError(errorMessage));
	}
	
	
	private Type visitBinaryExpression(final BinaryExpression expression, final String expressionName, final Type supportedOperandType) {
		final Type lhsType = expression.getLhs().accept(this);
		final Type rhsType = expression.getRhs().accept(this);
		
		if(lhsType.isCompatibleTo(rhsType) == false){
			newTypeCheckError("Left-hand-side expression of " + expressionName + " is not compatible to right-hand-side expression");
		}

		if (lhsType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Left-hand-side expression of " + expressionName + " is not compatible to " + supportedOperandType);
		}
		if (rhsType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Right-hand-side expression of " + expressionName + " is not compatible to " + supportedOperandType);
		}

		return expression.typeOf(typeEnv);
	}
	
	private Type visitUnaryExpression(final UnaryExpression expression, final String expressionName, final Type supportedOperandType) {
		final Type exprType = expression.getExpr().accept(this);
		
		if (exprType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Operand expression of " + expressionName + " is not compatible to " + supportedOperandType);
		}
		
		return  expression.typeOf(typeEnv);
	}

}