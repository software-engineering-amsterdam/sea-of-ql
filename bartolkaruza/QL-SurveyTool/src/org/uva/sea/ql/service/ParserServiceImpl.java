package org.uva.sea.ql.service;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.error.QLError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.semantic.StatementSemanticChecker;

public class ParserServiceImpl implements ParserService {
	
	private final IParse parser = new ANTLRParser();

	@Override
	public ParserContext parseNewForm(String form) {
		ParserContext context = new ParserContext();
		Form formHolder;
		try {
			formHolder = (Form) parser.parseNode(form);
		} catch (ParseError e) {
			context.addError(new QLError(e.getLocalizedMessage()));
			return context; // Parse exception occurred, abort further checking
		}
		StatementSemanticChecker statementChecker = new StatementSemanticChecker(context);
		formHolder.accept(statementChecker);
		context.setForm(formHolder);
		return context;
	}

}
