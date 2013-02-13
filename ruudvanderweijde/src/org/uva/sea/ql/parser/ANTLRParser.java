package org.uva.sea.ql.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;

public class ANTLRParser implements IParse {
	private List<Message> errors = new ArrayList<Message>();

	@Override
	public Expr parseExpression(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Expr expr = parser.orExpr();
			setErrors(parser.getErrors());
			return expr;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public Form parseForm(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Form form = parser.form();
			setErrors(parser.getErrors());
			return form;
		} catch (RecognitionException e) {
			throw new ParseError(e.getMessage());
		}
	}

	public Statement parseStatement(String src) throws ParseError {
		QLParser parser = getQLParser(src);
		try {
			Statement stmt = parser.statement();
			setErrors(parser.getErrors());
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

	private void setErrors(List<Message> errors) {
		this.errors = errors;
	}

	public boolean hasErrors() {
		return !(errors.isEmpty());
	}

	public List<Message> getErrors() {
		return errors;
	}

}
