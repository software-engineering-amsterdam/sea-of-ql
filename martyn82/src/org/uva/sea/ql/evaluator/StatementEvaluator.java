package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.statement.Assignment;
import org.uva.sea.ql.ast.statement.Else;
import org.uva.sea.ql.ast.statement.ElseIf;
import org.uva.sea.ql.ast.statement.ElseIfs;
import org.uva.sea.ql.ast.statement.FormDeclaration;
import org.uva.sea.ql.ast.statement.IfThenElse;
import org.uva.sea.ql.ast.statement.QuestionDeclaration;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.Statements;
import org.uva.sea.ql.ast.statement.VarDeclaration;
import org.uva.sea.ql.evaluator.value.Boolean;
import org.uva.sea.ql.evaluator.value.Undefined;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.evaluator.value.form.Form;
import org.uva.sea.ql.evaluator.value.form.Question;
import org.uva.sea.ql.evaluator.value.form.Questions;
import org.uva.sea.ql.visitor.IStatementVisitor;

/**
 * Evaluator for statement nodes.
 */
public class StatementEvaluator implements IStatementVisitor<Value> {
	/**
	 * Holds the environment.
	 */
	private final Environment environment;

	/**
	 * Holds the expression evaluator.
	 */
	private final ExpressionEvaluator expressionEvaluator;

	/**
	 * Holds the type evaluator.
	 */
	private final TypeEvaluator typeEvaluator;

	/**
	 * Constructs a new statement evaluator instance.
	 *
	 * @param environment
	 * @param expressionEvaluator
	 * @param typeEvaluator
	 */
	public StatementEvaluator(
		Environment environment, ExpressionEvaluator expressionEvaluator, TypeEvaluator typeEvaluator
	) {
		this.expressionEvaluator = expressionEvaluator;
		this.typeEvaluator = typeEvaluator;
		this.environment = environment;
	}

	@Override
	public Value visit( ElseIf node ) {
		throw new RuntimeException();
	}

	@Override
	public Value visit( ElseIfs node ) {
		throw new RuntimeException();
	}

	@Override
	public Value visit( Else node ) {
		return node.getBody().accept( this );
	}

	@Override
	public Value visit( IfThenElse node ) {
		Boolean value = (Boolean) node.getCondition().accept( this.expressionEvaluator );

		if ( value.getValue() ) {
			if ( node.hasIfBody() ) {
				return node.getIfBody().accept( this );
			}
		}

		for ( ElseIf elseIf : node.getElseIfs() ) {
			if ( ( (Boolean) elseIf.getCondition().accept( this.expressionEvaluator ) ).getValue() ) {
				return elseIf.getBody().accept( this );
			}
		}

		if ( node.hasElse() ) {
			return node.getElse().accept( this );
		}

		return new Undefined();
	}

	@Override
	public Value visit( VarDeclaration node ) {
		Value value = node.getType().accept( this.typeEvaluator );
		this.environment.declareVariable( node.getIdent(), value );

		return value;
	}

	@Override
	public Value visit( Assignment node ) {
		Value value = node.getExpression().accept( this.expressionEvaluator );
		this.environment.declareVariable( node.getIdent(), value );

		return value;
	}

	@Override
	public Value visit( FormDeclaration node ) {
		Value value;
		Questions questions = new Questions();

		for ( Statement statement : node.getStatements() ) {
			value = statement.accept( this );

			if ( value instanceof Question ) {
				questions.add( (Question) value );
			}
		}

		return new Form( node.getIdent(), questions );
	}

	@Override
	public Value visit( QuestionDeclaration node ) {
		Value value;

		if ( node.getDeclaration() instanceof VarDeclaration ) {
			value = node.getDeclaration().accept( this );
		}
		else if ( node.getDeclaration() instanceof Assignment ) {
			if ( !this.environment.isDeclared( node.getIdent() ) || !this.environment.isBound( node.getIdent() ) ) {
				value = node.getDeclaration().accept( this );
			}
			else {
				value = node.getIdent().accept( this.expressionEvaluator );
			}
		}
		else {
			value = new Undefined();
		}

		return new Question( node.getName().getValue(), node.getIdent(), value );
	}

	@Override
	public Value visit( Statements node ) {
		for ( Statement statement : node ) {
			statement.accept( this );
		}

		return new Undefined();
	}
}
