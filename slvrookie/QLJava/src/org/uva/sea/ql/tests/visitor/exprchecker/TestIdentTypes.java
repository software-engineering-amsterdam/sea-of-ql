package org.uva.sea.ql.tests.visitor.exprchecker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.typechecking.ExprChecker;
import org.uva.sea.ql.visitors.utils.Errors;
import org.uva.sea.ql.visitors.utils.State;

public class TestIdentTypes {
	
	private final State state = new State();
	private final Errors errors = new Errors();
	private final IParse parser = new ANTLRParser();
	
	@Test
	public void testSuccesfullIdents() throws ParseError {
		state.setType(new Ident("takiChan").getStringName(), new MoneyType());
		state.setType(new Ident("phaeroSan").getStringName(), new IntType());
		state.setType(new Ident("xarmanis").getStringName(), new BoolType());
		ExprChecker.check(parser.parseExpr("3.00 + takiChan"), state, errors);
		ExprChecker.check(parser.parseExpr("phaeroSan + 5"), state, errors);
		ExprChecker.check(parser.parseExpr("(3.00>5.00) && xarmanis"), state, errors);
		ExprChecker.check(parser.parseExpr("takiChan > 3.00 || phaeroSan < 3"), state, errors);	
		assertEquals(0 , errors.returnErrors().size());
	}
	
	@Test
	public void testFailedIdents() throws ParseError {
		state.setType(new Ident("patavoukas").getStringName(), new MoneyType());
		state.setType(new Ident("koronios").getStringName(), new IntType());
		state.setType(new Ident("mpakatsias").getStringName(), new BoolType());
		ExprChecker.check(parser.parseExpr("patavoukas + koronios"), state, errors);
		ExprChecker.check(parser.parseExpr("phaeroSan + 5"), state, errors);
		ExprChecker.check(parser.parseExpr("(3.00>5.00) + mpakatsias"), state, errors);
		ExprChecker.check(parser.parseExpr("koronios > 3.00 || koronios < 3"), state, errors);
		assertEquals(5 , errors.returnErrors().size());
	}

}
