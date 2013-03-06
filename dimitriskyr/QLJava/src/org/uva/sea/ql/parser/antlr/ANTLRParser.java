package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;

public class ANTLRParser implements IParse {

	public QLParser parse(String src) throws ParseError {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parser;
	}

	@Override
	public Expr parseExpression(String src) throws ParseError {
		try {
			return parse(src).orExpr();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Type parseType(String src) throws ParseError {
		try {
			return parse(src).type();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Form parseForm(String src) throws ParseError {
		try {
			return parse(src).form();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseStatement(String src) throws ParseError {
		try {
			return parse(src).body();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseIfThen(String src) throws ParseError {
		try {
			return parse(src).ifthen();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseIfThenElse(String src) throws ParseError {
		try {
			return parse(src).ifthenelse();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseSimpleQuestion(String src) throws ParseError {
		try {
			return parse(src).simplequestion();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseComQuestion(String src) throws ParseError {
		try {
			return parse(src).comquestion();
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}
}
