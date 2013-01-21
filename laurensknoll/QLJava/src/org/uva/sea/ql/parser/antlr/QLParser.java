// $ANTLR 3.5 C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g 2013-01-21 14:30:46

package org.uva.sea.ql.parser.antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.form.QuestionForm;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.type.AbstractType;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COMMENT", "IDENT", "INT",
			"MONEY", "STRING", "WS", "'!'", "'!='", "'&&'", "'('", "')'",
			"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'",
			"'>='", "'boolean'", "'form'", "'if'", "'integer'", "'money'",
			"'string'", "'{'", "'||'", "'}'" };
	public static final int EOF = -1;
	public static final int T__11 = 11;
	public static final int T__12 = 12;
	public static final int T__13 = 13;
	public static final int T__14 = 14;
	public static final int T__15 = 15;
	public static final int T__16 = 16;
	public static final int T__17 = 17;
	public static final int T__18 = 18;
	public static final int T__19 = 19;
	public static final int T__20 = 20;
	public static final int T__21 = 21;
	public static final int T__22 = 22;
	public static final int T__23 = 23;
	public static final int T__24 = 24;
	public static final int T__25 = 25;
	public static final int T__26 = 26;
	public static final int T__27 = 27;
	public static final int T__28 = 28;
	public static final int T__29 = 29;
	public static final int T__30 = 30;
	public static final int T__31 = 31;
	public static final int T__32 = 32;
	public static final int T__33 = 33;
	public static final int T__34 = 34;
	public static final int BOOLEAN = 4;
	public static final int COMMENT = 5;
	public static final int IDENT = 6;
	public static final int INT = 7;
	public static final int MONEY = 8;
	public static final int STRING = 9;
	public static final int WS = 10;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	public QLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public QLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[44 + 1];

	}

	@Override
	public String[] getTokenNames() {
		return QLParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g";
	}

	// $ANTLR start "identExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:1:
	// identExpr returns [org.uva.sea.ql.ast.expr.atom.Ident result] : IDENT ;
	public final org.uva.sea.ql.ast.expr.atom.Ident identExpr()
			throws RecognitionException {
		org.uva.sea.ql.ast.expr.atom.Ident result = null;

		int identExpr_StartIndex = input.index();

		Token IDENT1 = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 1)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:25:2:
			// ( IDENT )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:25:4:
			// IDENT
			{
				IDENT1 = (Token) match(input, IDENT,
						FOLLOW_IDENT_in_identExpr46);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.expr.atom.Ident(
							(IDENT1 != null ? IDENT1.getText() : null));
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 1, identExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "identExpr"

	// $ANTLR start "primary"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:28:1:
	// primary returns [AbstractExpr result] : ( INT | BOOLEAN | MONEY |x=
	// identExpr |x= stringExpr |x= expr );
	public final AbstractExpr primary() throws RecognitionException {
		AbstractExpr result = null;

		int primary_StartIndex = input.index();

		Token INT2 = null;
		Token BOOLEAN3 = null;
		Token MONEY4 = null;
		AbstractExpr x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 2)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:2:
			// ( INT | BOOLEAN | MONEY |x= identExpr |x= stringExpr |x= expr )
			int alt1 = 6;
			switch (input.LA(1)) {
			case INT: {
				alt1 = 1;
			}
				break;
			case BOOLEAN: {
				alt1 = 2;
			}
				break;
			case MONEY: {
				alt1 = 3;
			}
				break;
			case IDENT: {
				alt1 = 4;
			}
				break;
			case STRING: {
				alt1 = 5;
			}
				break;
			case 14: {
				alt1 = 6;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return result;
				}
				NoViableAltException nvae = new NoViableAltException("", 1, 0,
						input);
				throw nvae;
			}
			switch (alt1) {
			case 1:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:4:
			// INT
			{
				INT2 = (Token) match(input, INT, FOLLOW_INT_in_primary63);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.expr.atom.Int(
							Integer.parseInt((INT2 != null ? INT2.getText()
									: null)));
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:30:4:
			// BOOLEAN
			{
				BOOLEAN3 = (Token) match(input, BOOLEAN,
						FOLLOW_BOOLEAN_in_primary71);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.expr.atom.Bool(
							Boolean.parseBoolean((BOOLEAN3 != null ? BOOLEAN3
									.getText() : null)));
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:31:4:
			// MONEY
			{
				MONEY4 = (Token) match(input, MONEY, FOLLOW_MONEY_in_primary79);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.expr.atom.Money(
							Float.parseFloat((MONEY4 != null ? MONEY4.getText()
									: null)));
				}
			}
				break;
			case 4:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:32:4:
			// x= identExpr
			{
				pushFollow(FOLLOW_identExpr_in_primary89);
				x = identExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;
			case 5:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:33:4:
			// x= stringExpr
			{
				pushFollow(FOLLOW_stringExpr_in_primary98);
				x = stringExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;
			case 6:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:34:4:
			// x= expr
			{
				pushFollow(FOLLOW_expr_in_primary107);
				x = expr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 2, primary_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "primary"

	// $ANTLR start "stringExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:37:1:
	// stringExpr returns [org.uva.sea.ql.ast.expr.atom.String result] : STRING
	// ;
	public final org.uva.sea.ql.ast.expr.atom.String stringExpr()
			throws RecognitionException {
		org.uva.sea.ql.ast.expr.atom.String result = null;

		int stringExpr_StartIndex = input.index();

		Token STRING5 = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 3)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:38:2:
			// ( STRING )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:38:4:
			// STRING
			{
				STRING5 = (Token) match(input, STRING,
						FOLLOW_STRING_in_stringExpr124);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.expr.atom.String(
							(STRING5 != null ? STRING5.getText() : null));
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 3, stringExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "stringExpr"

	// $ANTLR start "expr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:41:1: expr
	// returns [AbstractExpr result] : '(' x= orExpr ')' ;
	public final AbstractExpr expr() throws RecognitionException {
		AbstractExpr result = null;

		int expr_StartIndex = input.index();

		AbstractExpr x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 4)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:42:2:
			// ( '(' x= orExpr ')' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:42:4:
			// '(' x= orExpr ')'
			{
				match(input, 14, FOLLOW_14_in_expr141);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_orExpr_in_expr145);
				x = orExpr();
				state._fsp--;
				if (state.failed)
					return result;
				match(input, 15, FOLLOW_15_in_expr147);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 4, expr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "expr"

	// $ANTLR start "unExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:45:1:
	// unExpr returns [AbstractExpr result] : ( '+' x= unExpr | '-' x= unExpr |
	// '!' x= unExpr |x= primary );
	public final AbstractExpr unExpr() throws RecognitionException {
		AbstractExpr result = null;

		int unExpr_StartIndex = input.index();

		AbstractExpr x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 5)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:46:2:
			// ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2 = 4;
			switch (input.LA(1)) {
			case 17: {
				alt2 = 1;
			}
				break;
			case 18: {
				alt2 = 2;
			}
				break;
			case 11: {
				alt2 = 3;
			}
				break;
			case BOOLEAN:
			case IDENT:
			case INT:
			case MONEY:
			case STRING:
			case 14: {
				alt2 = 4;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return result;
				}
				NoViableAltException nvae = new NoViableAltException("", 2, 0,
						input);
				throw nvae;
			}
			switch (alt2) {
			case 1:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:46:4:
			// '+' x= unExpr
			{
				match(input, 17, FOLLOW_17_in_unExpr164);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr168);
				x = unExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new Pos(x);
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:47:4:
			// '-' x= unExpr
			{
				match(input, 18, FOLLOW_18_in_unExpr175);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr179);
				x = unExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new Neg(x);
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:4:
			// '!' x= unExpr
			{
				match(input, 11, FOLLOW_11_in_unExpr186);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr190);
				x = unExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new Not(x);
				}
			}
				break;
			case 4:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:49:4:
			// x= primary
			{
				pushFollow(FOLLOW_primary_in_unExpr199);
				x = primary();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 5, unExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "unExpr"

	// $ANTLR start "mulExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:52:1:
	// mulExpr returns [AbstractExpr result] : lhs= unExpr (op= ( '*' | '/' )
	// rhs= unExpr )* ;
	public final AbstractExpr mulExpr() throws RecognitionException {
		AbstractExpr result = null;

		int mulExpr_StartIndex = input.index();

		Token op = null;
		AbstractExpr lhs = null;
		AbstractExpr rhs = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 6)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:53:5:
			// (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:53:9:
			// lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
				pushFollow(FOLLOW_unExpr_in_mulExpr231);
				lhs = unExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:53:45:
				// (op= ( '*' | '/' ) rhs= unExpr )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == 16 || LA3_0 == 19)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:53:47:
					// op= ( '*' | '/' ) rhs= unExpr
					{
						op = input.LT(1);
						if (input.LA(1) == 16 || input.LA(1) == 19) {
							input.consume();
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return result;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_unExpr_in_mulExpr251);
						rhs = unExpr();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							if ((op != null ? op.getText() : null).equals("*")) {
								result = new Mul(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals("/")) {
								result = new Div(result, rhs);
							}
						}
					}
						break;

					default:
						break loop3;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 6, mulExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "mulExpr"

	// $ANTLR start "addExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:65:1:
	// addExpr returns [AbstractExpr result] : lhs= mulExpr (op= ( '+' | '-' )
	// rhs= mulExpr )* ;
	public final AbstractExpr addExpr() throws RecognitionException {
		AbstractExpr result = null;

		int addExpr_StartIndex = input.index();

		Token op = null;
		AbstractExpr lhs = null;
		AbstractExpr rhs = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 7)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:66:5:
			// (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:66:9:
			// lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
				pushFollow(FOLLOW_mulExpr_in_addExpr292);
				lhs = mulExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:66:46:
				// (op= ( '+' | '-' ) rhs= mulExpr )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if (((LA4_0 >= 17 && LA4_0 <= 18))) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:66:48:
					// op= ( '+' | '-' ) rhs= mulExpr
					{
						op = input.LT(1);
						if ((input.LA(1) >= 17 && input.LA(1) <= 18)) {
							input.consume();
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return result;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_mulExpr_in_addExpr310);
						rhs = mulExpr();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							if ((op != null ? op.getText() : null).equals("+")) {
								result = new Add(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals("-")) {
								result = new Sub(result, rhs);
							}
						}
					}
						break;

					default:
						break loop4;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 7, addExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "addExpr"

	// $ANTLR start "relExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:77:1:
	// relExpr returns [AbstractExpr result] : lhs= addExpr (op= ( '<' | '<=' |
	// '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final AbstractExpr relExpr() throws RecognitionException {
		AbstractExpr result = null;

		int relExpr_StartIndex = input.index();

		Token op = null;
		AbstractExpr lhs = null;
		AbstractExpr rhs = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 8)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:78:5:
			// (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs=
			// addExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:78:9:
			// lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs=
			// addExpr )*
			{
				pushFollow(FOLLOW_addExpr_in_relExpr345);
				lhs = addExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:78:46:
				// (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
				// )*
				loop5: while (true) {
					int alt5 = 2;
					int LA5_0 = input.LA(1);
					if ((LA5_0 == 12 || (LA5_0 >= 21 && LA5_0 <= 25))) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:78:48:
					// op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs=
					// addExpr
					{
						op = input.LT(1);
						if (input.LA(1) == 12
								|| (input.LA(1) >= 21 && input.LA(1) <= 25)) {
							input.consume();
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return result;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_addExpr_in_relExpr369);
						rhs = addExpr();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							if ((op != null ? op.getText() : null).equals("<")) {
								result = new LT(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals("<=")) {
								result = new LEq(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals(">")) {
								result = new GT(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals(">=")) {
								result = new GEq(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals("==")) {
								result = new Eq(result, rhs);
							}
							if ((op != null ? op.getText() : null).equals("!=")) {
								result = new NEq(result, rhs);
							}
						}
					}
						break;

					default:
						break loop5;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 8, relExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "relExpr"

	// $ANTLR start "andExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:101:1:
	// andExpr returns [AbstractExpr result] : lhs= relExpr ( '&&' rhs= relExpr
	// )* ;
	public final AbstractExpr andExpr() throws RecognitionException {
		AbstractExpr result = null;

		int andExpr_StartIndex = input.index();

		AbstractExpr lhs = null;
		AbstractExpr rhs = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 9)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:102:5:
			// (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:102:9:
			// lhs= relExpr ( '&&' rhs= relExpr )*
			{
				pushFollow(FOLLOW_relExpr_in_andExpr407);
				lhs = relExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:102:46:
				// ( '&&' rhs= relExpr )*
				loop6: while (true) {
					int alt6 = 2;
					int LA6_0 = input.LA(1);
					if ((LA6_0 == 13)) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:102:48:
					// '&&' rhs= relExpr
					{
						match(input, 13, FOLLOW_13_in_andExpr413);
						if (state.failed)
							return result;
						pushFollow(FOLLOW_relExpr_in_andExpr417);
						rhs = relExpr();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							result = new And(result, rhs);
						}
					}
						break;

					default:
						break loop6;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 9, andExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "andExpr"

	// $ANTLR start "orExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:106:1:
	// orExpr returns [AbstractExpr result] : lhs= andExpr ( '||' rhs= andExpr
	// )* ;
	public final AbstractExpr orExpr() throws RecognitionException {
		AbstractExpr result = null;

		int orExpr_StartIndex = input.index();

		AbstractExpr lhs = null;
		AbstractExpr rhs = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 10)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:107:5:
			// (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:107:9:
			// lhs= andExpr ( '||' rhs= andExpr )*
			{
				pushFollow(FOLLOW_andExpr_in_orExpr452);
				lhs = andExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:107:48:
				// ( '||' rhs= andExpr )*
				loop7: while (true) {
					int alt7 = 2;
					int LA7_0 = input.LA(1);
					if ((LA7_0 == 33)) {
						alt7 = 1;
					}

					switch (alt7) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:107:50:
					// '||' rhs= andExpr
					{
						match(input, 33, FOLLOW_33_in_orExpr458);
						if (state.failed)
							return result;
						pushFollow(FOLLOW_andExpr_in_orExpr462);
						rhs = andExpr();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							result = new Or(result, rhs);
						}
					}
						break;

					default:
						break loop7;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 10, orExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "orExpr"

	// $ANTLR start "form"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:110:1:
	// form returns [QuestionForm result] : 'form' id= identExpr s=
	// blockStatement ;
	public final QuestionForm form() throws RecognitionException {
		QuestionForm result = null;

		int form_StartIndex = input.index();

		org.uva.sea.ql.ast.expr.atom.Ident id = null;
		Block s = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 11)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:111:2:
			// ( 'form' id= identExpr s= blockStatement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:111:4:
			// 'form' id= identExpr s= blockStatement
			{
				match(input, 27, FOLLOW_27_in_form485);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_identExpr_in_form489);
				id = identExpr();
				state._fsp--;
				if (state.failed)
					return result;
				pushFollow(FOLLOW_blockStatement_in_form493);
				s = blockStatement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new QuestionForm(id, s);
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 11, form_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "form"

	// $ANTLR start "statement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:115:1:
	// statement returns [AbstractStatement result] : (x= blockStatement |x=
	// ifStatement |x= declStatement );
	public final AbstractStatement statement() throws RecognitionException {
		AbstractStatement result = null;

		int statement_StartIndex = input.index();

		AbstractStatement x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 12)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:116:6:
			// (x= blockStatement |x= ifStatement |x= declStatement )
			int alt8 = 3;
			switch (input.LA(1)) {
			case 32: {
				alt8 = 1;
			}
				break;
			case 28: {
				alt8 = 2;
			}
				break;
			case IDENT: {
				alt8 = 3;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return result;
				}
				NoViableAltException nvae = new NoViableAltException("", 8, 0,
						input);
				throw nvae;
			}
			switch (alt8) {
			case 1:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:116:8:
			// x= blockStatement
			{
				pushFollow(FOLLOW_blockStatement_in_statement518);
				x = blockStatement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:117:8:
			// x= ifStatement
			{
				pushFollow(FOLLOW_ifStatement_in_statement531);
				x = ifStatement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:118:8:
			// x= declStatement
			{
				pushFollow(FOLLOW_declStatement_in_statement544);
				x = declStatement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = x;
				}
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 12, statement_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "statement"

	// $ANTLR start "blockStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:121:1:
	// blockStatement returns [Block result] : '{' (s= statement )* '}' ;
	public final Block blockStatement() throws RecognitionException {
		Block result = null;

		int blockStatement_StartIndex = input.index();

		AbstractStatement s = null;

		List<AbstractStatement> list = new ArrayList<AbstractStatement>();

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 13)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:2:
			// ( '{' (s= statement )* '}' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:4:
			// '{' (s= statement )* '}'
			{
				match(input, 32, FOLLOW_32_in_blockStatement579);
				if (state.failed)
					return result;
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:8:
				// (s= statement )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == IDENT || LA9_0 == 28 || LA9_0 == 32)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:9:
					// s= statement
					{
						pushFollow(FOLLOW_statement_in_blockStatement584);
						s = statement();
						state._fsp--;
						if (state.failed)
							return result;
						if (state.backtracking == 0) {
							list.add(s);
						}
					}
						break;

					default:
						break loop9;
					}
				}

				match(input, 34, FOLLOW_34_in_blockStatement590);
				if (state.failed)
					return result;
			}

			if (state.backtracking == 0) {
				result = new Block(list);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 13, blockStatement_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "blockStatement"

	// $ANTLR start "ifStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:133:1:
	// ifStatement returns [IfStatement result] : 'if' condition= expr truePath=
	// statement ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		AbstractExpr condition = null;
		AbstractStatement truePath = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 14)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:134:6:
			// ( 'if' condition= expr truePath= statement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:134:8:
			// 'if' condition= expr truePath= statement
			{
				match(input, 28, FOLLOW_28_in_ifStatement609);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_expr_in_ifStatement613);
				condition = expr();
				state._fsp--;
				if (state.failed)
					return result;
				pushFollow(FOLLOW_statement_in_ifStatement617);
				truePath = statement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new IfStatement(condition, truePath);
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 14, ifStatement_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "ifStatement"

	// $ANTLR start "declStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:138:1:
	// declStatement returns [AbstractStatement result] : q= questionStatement ;
	public final AbstractStatement declStatement() throws RecognitionException {
		AbstractStatement result = null;

		int declStatement_StartIndex = input.index();

		AbstractStatement q = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 15)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:139:2:
			// (q= questionStatement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:139:4:
			// q= questionStatement
			{
				pushFollow(FOLLOW_questionStatement_in_declStatement642);
				q = questionStatement();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = q;
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 15, declStatement_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "declStatement"

	// $ANTLR start "questionStatement"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:142:1:
	// questionStatement returns [AbstractStatement result] : id= identExpr ':'
	// descr= stringExpr at= answerTypedef (ex= expr )? ;
	public final AbstractStatement questionStatement()
			throws RecognitionException {
		AbstractStatement result = null;

		int questionStatement_StartIndex = input.index();

		org.uva.sea.ql.ast.expr.atom.Ident id = null;
		org.uva.sea.ql.ast.expr.atom.String descr = null;
		AbstractType at = null;
		AbstractExpr ex = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 16)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:143:2:
			// (id= identExpr ':' descr= stringExpr at= answerTypedef (ex= expr
			// )? )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:143:4:
			// id= identExpr ':' descr= stringExpr at= answerTypedef (ex= expr
			// )?
			{
				pushFollow(FOLLOW_identExpr_in_questionStatement661);
				id = identExpr();
				state._fsp--;
				if (state.failed)
					return result;
				match(input, 20, FOLLOW_20_in_questionStatement663);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_stringExpr_in_questionStatement667);
				descr = stringExpr();
				state._fsp--;
				if (state.failed)
					return result;
				pushFollow(FOLLOW_answerTypedef_in_questionStatement671);
				at = answerTypedef();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new Question(id, descr, at);
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:147:3:
				// (ex= expr )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == 14)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:147:4:
				// ex= expr
				{
					pushFollow(FOLLOW_expr_in_questionStatement682);
					ex = expr();
					state._fsp--;
					if (state.failed)
						return result;
					if (state.backtracking == 0) {
						result = new ComputedQuestion((Question) result, ex);
					}
				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 16, questionStatement_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "questionStatement"

	// $ANTLR start "answerTypedef"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:153:1:
	// answerTypedef returns [AbstractType result] : ( 'boolean' | 'integer' |
	// 'money' | 'string' );
	public final AbstractType answerTypedef() throws RecognitionException {
		AbstractType result = null;

		int answerTypedef_StartIndex = input.index();

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 17)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:154:2:
			// ( 'boolean' | 'integer' | 'money' | 'string' )
			int alt11 = 4;
			switch (input.LA(1)) {
			case 26: {
				alt11 = 1;
			}
				break;
			case 29: {
				alt11 = 2;
			}
				break;
			case 30: {
				alt11 = 3;
			}
				break;
			case 31: {
				alt11 = 4;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return result;
				}
				NoViableAltException nvae = new NoViableAltException("", 11, 0,
						input);
				throw nvae;
			}
			switch (alt11) {
			case 1:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:154:4:
			// 'boolean'
			{
				match(input, 26, FOLLOW_26_in_answerTypedef703);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.type.Bool();
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:155:4:
			// 'integer'
			{
				match(input, 29, FOLLOW_29_in_answerTypedef710);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.type.Int();
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:156:4:
			// 'money'
			{
				match(input, 30, FOLLOW_30_in_answerTypedef717);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.type.Money();
				}
			}
				break;
			case 4:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:157:4:
			// 'string'
			{
				match(input, 31, FOLLOW_31_in_answerTypedef725);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new org.uva.sea.ql.ast.type.String();
				}
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 17, answerTypedef_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "answerTypedef"

	// Delegated rules

	public static final BitSet FOLLOW_IDENT_in_identExpr46 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INT_in_primary63 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_BOOLEAN_in_primary71 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MONEY_in_primary79 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identExpr_in_primary89 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_stringExpr_in_primary98 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expr_in_primary107 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_STRING_in_stringExpr124 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_14_in_expr141 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_orExpr_in_expr145 = new BitSet(
			new long[] { 0x0000000000008000L });
	public static final BitSet FOLLOW_15_in_expr147 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_17_in_unExpr164 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr168 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_18_in_unExpr175 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr179 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_11_in_unExpr186 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr190 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_primary_in_unExpr199 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unExpr_in_mulExpr231 = new BitSet(
			new long[] { 0x0000000000090002L });
	public static final BitSet FOLLOW_set_in_mulExpr239 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_mulExpr251 = new BitSet(
			new long[] { 0x0000000000090002L });
	public static final BitSet FOLLOW_mulExpr_in_addExpr292 = new BitSet(
			new long[] { 0x0000000000060002L });
	public static final BitSet FOLLOW_set_in_addExpr300 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_mulExpr_in_addExpr310 = new BitSet(
			new long[] { 0x0000000000060002L });
	public static final BitSet FOLLOW_addExpr_in_relExpr345 = new BitSet(
			new long[] { 0x0000000003E01002L });
	public static final BitSet FOLLOW_set_in_relExpr353 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_addExpr_in_relExpr369 = new BitSet(
			new long[] { 0x0000000003E01002L });
	public static final BitSet FOLLOW_relExpr_in_andExpr407 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_13_in_andExpr413 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_relExpr_in_andExpr417 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_andExpr_in_orExpr452 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_33_in_orExpr458 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_andExpr_in_orExpr462 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_27_in_form485 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_identExpr_in_form489 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_blockStatement_in_form493 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_blockStatement_in_statement518 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ifStatement_in_statement531 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_declStatement_in_statement544 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_32_in_blockStatement579 = new BitSet(
			new long[] { 0x0000000510000040L });
	public static final BitSet FOLLOW_statement_in_blockStatement584 = new BitSet(
			new long[] { 0x0000000510000040L });
	public static final BitSet FOLLOW_34_in_blockStatement590 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_28_in_ifStatement609 = new BitSet(
			new long[] { 0x0000000000004000L });
	public static final BitSet FOLLOW_expr_in_ifStatement613 = new BitSet(
			new long[] { 0x0000000110000040L });
	public static final BitSet FOLLOW_statement_in_ifStatement617 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_questionStatement_in_declStatement642 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identExpr_in_questionStatement661 = new BitSet(
			new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_20_in_questionStatement663 = new BitSet(
			new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_stringExpr_in_questionStatement667 = new BitSet(
			new long[] { 0x00000000E4000000L });
	public static final BitSet FOLLOW_answerTypedef_in_questionStatement671 = new BitSet(
			new long[] { 0x0000000000004002L });
	public static final BitSet FOLLOW_expr_in_questionStatement682 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_26_in_answerTypedef703 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_answerTypedef710 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_answerTypedef717 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_31_in_answerTypedef725 = new BitSet(
			new long[] { 0x0000000000000002L });
}
