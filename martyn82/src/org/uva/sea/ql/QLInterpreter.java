package org.uva.sea.ql;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.evaluator.ExpressionEvaluator;
import org.uva.sea.ql.evaluator.QLEvaluator;
import org.uva.sea.ql.evaluator.StatementEvaluator;
import org.uva.sea.ql.evaluator.TypeEvaluator;
import org.uva.sea.ql.evaluator.typechecker.ExpressionChecker;
import org.uva.sea.ql.evaluator.typechecker.QLTypeChecker;
import org.uva.sea.ql.evaluator.typechecker.StatementChecker;
import org.uva.sea.ql.evaluator.value.Value;
import org.uva.sea.ql.evaluator.value.form.Form;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;

public class QLInterpreter {
	private final Environment environment;
	private final QLParser parser;
	private final QLTypeChecker typeChecker;
	private final QLEvaluator evaluator;

	private Value result;
	private Statement ast;

	public QLInterpreter() {
		this.parser = new QLParser();
		this.environment = new Environment();
		this.typeChecker = new QLTypeChecker( this.environment );
		this.evaluator = new QLEvaluator( this.environment );
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public Value evaluate( Expression node, Environment environment ) {
		if ( !node.accept( new ExpressionChecker( environment ) ) ) {
			this.dumpErrors( environment );
			return null;
		}

		return node.accept( new ExpressionEvaluator( environment ) );
	}

	public Value evaluate( Statement node, Environment environment ) {
		StatementChecker checker = new StatementChecker( environment, new ExpressionChecker( environment ) );

		if ( !node.accept( checker ) ) {
			this.dumpErrors( environment );
			return null;
		}

		StatementEvaluator evaluator = new StatementEvaluator( environment, new ExpressionEvaluator( environment ), new TypeEvaluator() );
		return node.accept( evaluator );
	}

	public boolean evaluate( String source ) {
		try {
			this.ast = this.parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		if ( !this.ast.accept( this.typeChecker ) ) {
			this.dumpErrors( this.environment );
			return false;
		}

		this.result = this.ast.accept( this.evaluator );
		return true;
	}

	public Statement getAST() {
		return this.ast;
	}

	private void dumpErrors( Environment environment ) {
		for ( Error error : environment.getErrors() ) {
			System.err.println( error.toString() );
		}
	}

	public Form getResult() {
		return (Form) this.result;
	}
}
