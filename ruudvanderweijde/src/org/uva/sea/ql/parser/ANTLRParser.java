package org.uva.sea.ql.parser;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.error.ParseError;

public class ANTLRParser implements IParse {

	@Override
	public Expr parseExpression(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Expr expr = parser.orExpr();
			if (parser.hasErrors()) {
				String err = getErrorString(parser.getErrors());
				throw new ParseError(err);
			}
			return expr;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Form parseForm(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Form form = parser.form();
			if (parser.hasErrors()) {
				String err = getErrorString(parser.getErrors());
				throw new ParseError(err);
			}
			return form;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	@Override
	public Statement parseStatement(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Statement stmt = parser.statement();
			if (parser.hasErrors()) {
				String err = getErrorString(parser.getErrors());
				throw new ParseError(err);
			}
			return stmt;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	private QLParser getQLParser(String src) {
		ANTLRStringStream stream = new ANTLRStringStream(src);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(new QLLexer(stream));
		QLParser parser = new QLParser(tokens);
		return parser;
	}

	private String getErrorString(List<Message> errors) {
		StringBuilder errorString = new StringBuilder();
		for(Message error : errors) {
			errorString.append(error.getMessage());
		}
		return errorString.toString();
	}
}