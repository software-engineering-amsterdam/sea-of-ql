package org.uva.sea.ql.eval;

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
import org.uva.sea.ql.eval.value.Boolean;
import org.uva.sea.ql.eval.value.Undefined;
import org.uva.sea.ql.eval.value.Value;
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
	 */
	public StatementEvaluator( Environment environment, ExpressionEvaluator expressionEvaluator ) {
		this.expressionEvaluator = expressionEvaluator;
		this.typeEvaluator = new TypeEvaluator();
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
		node.getBody().accept( this );

		return new Undefined();
	}

	@Override
	public Value visit( IfThenElse node ) {
		Boolean value = (Boolean) node.getCondition().accept( this.expressionEvaluator );

		if ( value.getValue() ) {
			if ( node.hasIfBody() ) {
				node.getIfBody().accept( this );
				return new Undefined();
			}
		}

		for ( ElseIf elseIf : node.getElseIfs() ) {
			if ( ( (Boolean) elseIf.getCondition().accept( this.expressionEvaluator ) ).getValue() ) {
				elseIf.getBody().accept( this );
				return new Undefined();
			}
		}

		if ( node.hasElse() ) {
			node.getElse().accept( this );
			return new Undefined();
		}

		return new Undefined();
	}

	@Override
	public Value visit( VarDeclaration node ) {
		Value value = node.getType().accept( this.typeEvaluator );
		this.environment.declareVariable( node.getIdent(), value );

		return new Undefined();
	}

	@Override
	public Value visit( Assignment node ) {
		Value value = node.getExpression().accept( this.expressionEvaluator );
		this.environment.declareVariable( node.getIdent(), value );

		return new Undefined();
	}

	@Override
	public Value visit( FormDeclaration node ) {
		node.getStatements().accept( this );

		return new Undefined();
	}

	@Override
	public Value visit( QuestionDeclaration node ) {
		node.getDeclaration().accept( this );

		return new Undefined();
	}

	@Override
	public Value visit( Statements node ) {
		for ( Statement statement : node ) {
			statement.accept( this );
		}

		return new Undefined();
	}
}
