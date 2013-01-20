package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Iterator;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.BooleanExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;
import org.uva.sea.ql.ast.expression.literals.BooleanLiteral;

public class SemanticVisitor implements ASTVisitor {
	
	private final HashMap<Ident, Question> identQuestionMap = new HashMap<>();
	private final HashMap<Expression, DataType> expressionTypeMap = new HashMap<>();

	@Override
	public void visit(Form form) throws SemanticException {
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) throws SemanticException {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(Question question) throws SemanticException {
		identQuestionMap.put(question.getIdent(), question);
	}

	@Override
	public void visit(IfStatement statement) throws SemanticException {
		statement.getExpr().accept(this);
		
		if(expressionTypeMap.get(statement.getExpr()) != DataType.BOOLEAN){
			throw new SemanticException("Expression does not evaluate to boolean type");
		}
		
		statement.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(BinaryExpr expression) throws SemanticException {
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		if(expressionTypeMap.get(expression.getLhs()) != expressionTypeMap.get(expression.getRhs())){
			throw new SemanticException("LHS and RHS not of same type");
		}
		expressionTypeMap.put(expression, expression instanceof BooleanExpression ? DataType.BOOLEAN : expressionTypeMap.get(expression.getLhs()));
	}

	@Override
	public void visit(final UnaryExpr expression) throws SemanticException {
		expression.getExpr().accept(this);
		
		if(expression instanceof BooleanExpression){
			if(expressionTypeMap.get(expression.getExpr()) != DataType.BOOLEAN){
				throw new SemanticException("Expression does not evaluate to boolean type");
			}
		}
		expressionTypeMap.put(expression, expressionTypeMap.get(expression.getExpr()));
	}

	@Override
	public void visit(final Ident ident) throws SemanticException {
		if(!this.identQuestionMap.containsKey(ident)){
			throw new SemanticException("Undeclared referenced identity '" + ident.getName() + "'");
		}
		
		expressionTypeMap.put(ident, identQuestionMap.get(ident).getDataType());
	}

	@Override
	public void visit(final Literal literal) throws SemanticException {
		expressionTypeMap.put(literal, literal.getDataType());
	}
	
}