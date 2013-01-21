// $ANTLR 3.5 C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g 2013-01-20 16:29:00

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
import org.uva.sea.ql.ast.answertype.AbstractAnswerType;
import org.uva.sea.ql.ast.answertype.BoolAnswerType;
import org.uva.sea.ql.ast.answertype.IntAnswerType;
import org.uva.sea.ql.ast.answertype.MoneyAnswerType;
import org.uva.sea.ql.ast.answertype.StringAnswerType;
import org.uva.sea.ql.ast.expr.AbstractExpr;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;
import org.uva.sea.ql.ast.form.QuestionForm;
import org.uva.sea.ql.ast.statement.AbstractStatement;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;

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

	// $ANTLR start "primary"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:20:1:
	// primary returns [AbstractExpr result] : ( INT | BOOLEAN | MONEY |x=
	// identExpr |x= stringExpr |x= expr );
	public final AbstractExpr primary() throws RecognitionException {
		AbstractExpr result = null;

		int primary_StartIndex = input.index();

		Token INT1 = null;
		Token BOOLEAN2 = null;
		Token MONEY3 = null;
		AbstractExpr x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 1)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:2:
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:4:
			// INT
			{
				INT1 = (Token) match(input, INT, FOLLOW_INT_in_primary45);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new IntExprType(
							Integer.parseInt((INT1 != null ? INT1.getText()
									: null)));
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:22:4:
			// BOOLEAN
			{
				BOOLEAN2 = (Token) match(input, BOOLEAN,
						FOLLOW_BOOLEAN_in_primary53);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new BoolExprType(
							Boolean.parseBoolean((BOOLEAN2 != null ? BOOLEAN2
									.getText() : null)));
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:4:
			// MONEY
			{
				MONEY3 = (Token) match(input, MONEY, FOLLOW_MONEY_in_primary61);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new MoneyExprType(
							Float.parseFloat((MONEY3 != null ? MONEY3.getText()
									: null)));
				}
			}
				break;
			case 4:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:4:
			// x= identExpr
			{
				pushFollow(FOLLOW_identExpr_in_primary71);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:25:4:
			// x= stringExpr
			{
				pushFollow(FOLLOW_stringExpr_in_primary80);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:26:4:
			// x= expr
			{
				pushFollow(FOLLOW_expr_in_primary89);
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
				memoize(input, 1, primary_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "primary"

	// $ANTLR start "identExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:1:
	// identExpr returns [IdentExprType result] : IDENT ;
	public final IdentExprType identExpr() throws RecognitionException {
		IdentExprType result = null;

		int identExpr_StartIndex = input.index();

		Token IDENT4 = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 2)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:30:2:
			// ( IDENT )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:30:4:
			// IDENT
			{
				IDENT4 = (Token) match(input, IDENT,
						FOLLOW_IDENT_in_identExpr106);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new IdentExprType(
							(IDENT4 != null ? IDENT4.getText() : null));
				}
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
			if (state.backtracking > 0) {
				memoize(input, 2, identExpr_StartIndex);
			}

		}
		return result;
	}

	// $ANTLR end "identExpr"

	// $ANTLR start "stringExpr"
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:33:1:
	// stringExpr returns [StringExprType result] : STRING ;
	public final StringExprType stringExpr() throws RecognitionException {
		StringExprType result = null;

		int stringExpr_StartIndex = input.index();

		Token STRING5 = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 3)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:34:2:
			// ( STRING )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:34:4:
			// STRING
			{
				STRING5 = (Token) match(input, STRING,
						FOLLOW_STRING_in_stringExpr123);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new StringExprType(
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:37:1: expr
	// returns [AbstractExpr result] : '(' x= orExpr ')' ;
	public final AbstractExpr expr() throws RecognitionException {
		AbstractExpr result = null;

		int expr_StartIndex = input.index();

		AbstractExpr x = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 4)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:38:2:
			// ( '(' x= orExpr ')' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:38:4:
			// '(' x= orExpr ')'
			{
				match(input, 14, FOLLOW_14_in_expr140);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_orExpr_in_expr144);
				x = orExpr();
				state._fsp--;
				if (state.failed)
					return result;
				match(input, 15, FOLLOW_15_in_expr146);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:41:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:42:2:
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:42:4:
			// '+' x= unExpr
			{
				match(input, 17, FOLLOW_17_in_unExpr163);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr167);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:43:4:
			// '-' x= unExpr
			{
				match(input, 18, FOLLOW_18_in_unExpr174);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr178);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:44:4:
			// '!' x= unExpr
			{
				match(input, 11, FOLLOW_11_in_unExpr185);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_unExpr_in_unExpr189);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:45:4:
			// x= primary
			{
				pushFollow(FOLLOW_primary_in_unExpr198);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:48:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:49:5:
			// (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:49:9:
			// lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
				pushFollow(FOLLOW_unExpr_in_mulExpr230);
				lhs = unExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:49:45:
				// (op= ( '*' | '/' ) rhs= unExpr )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == 16 || LA3_0 == 19)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:49:47:
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
						pushFollow(FOLLOW_unExpr_in_mulExpr250);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:61:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:62:5:
			// (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:62:9:
			// lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
				pushFollow(FOLLOW_mulExpr_in_addExpr291);
				lhs = mulExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:62:46:
				// (op= ( '+' | '-' ) rhs= mulExpr )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if (((LA4_0 >= 17 && LA4_0 <= 18))) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:62:48:
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
						pushFollow(FOLLOW_mulExpr_in_addExpr309);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:73:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:74:5:
			// (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs=
			// addExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:74:9:
			// lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs=
			// addExpr )*
			{
				pushFollow(FOLLOW_addExpr_in_relExpr344);
				lhs = addExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:74:46:
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:74:48:
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
						pushFollow(FOLLOW_addExpr_in_relExpr368);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:97:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:5:
			// (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:9:
			// lhs= relExpr ( '&&' rhs= relExpr )*
			{
				pushFollow(FOLLOW_relExpr_in_andExpr406);
				lhs = relExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:46:
				// ( '&&' rhs= relExpr )*
				loop6: while (true) {
					int alt6 = 2;
					int LA6_0 = input.LA(1);
					if ((LA6_0 == 13)) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:98:48:
					// '&&' rhs= relExpr
					{
						match(input, 13, FOLLOW_13_in_andExpr412);
						if (state.failed)
							return result;
						pushFollow(FOLLOW_relExpr_in_andExpr416);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:102:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:103:5:
			// (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:103:9:
			// lhs= andExpr ( '||' rhs= andExpr )*
			{
				pushFollow(FOLLOW_andExpr_in_orExpr451);
				lhs = andExpr();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = lhs;
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:103:48:
				// ( '||' rhs= andExpr )*
				loop7: while (true) {
					int alt7 = 2;
					int LA7_0 = input.LA(1);
					if ((LA7_0 == 33)) {
						alt7 = 1;
					}

					switch (alt7) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:103:50:
					// '||' rhs= andExpr
					{
						match(input, 33, FOLLOW_33_in_orExpr457);
						if (state.failed)
							return result;
						pushFollow(FOLLOW_andExpr_in_orExpr461);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:107:1:
	// form returns [QuestionForm result] : 'form' id= identExpr s=
	// blockStatement ;
	public final QuestionForm form() throws RecognitionException {
		QuestionForm result = null;

		int form_StartIndex = input.index();

		IdentExprType id = null;
		Block s = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 11)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:108:2:
			// ( 'form' id= identExpr s= blockStatement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:108:4:
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:111:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:6:
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:112:8:
			// x= blockStatement
			{
				pushFollow(FOLLOW_blockStatement_in_statement516);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:113:8:
			// x= ifStatement
			{
				pushFollow(FOLLOW_ifStatement_in_statement529);
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:114:8:
			// x= declStatement
			{
				pushFollow(FOLLOW_declStatement_in_statement542);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:117:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:126:2:
			// ( '{' (s= statement )* '}' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:126:4:
			// '{' (s= statement )* '}'
			{
				match(input, 32, FOLLOW_32_in_blockStatement577);
				if (state.failed)
					return result;
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:126:8:
				// (s= statement )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == IDENT || LA9_0 == 28 || LA9_0 == 32)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:126:9:
					// s= statement
					{
						pushFollow(FOLLOW_statement_in_blockStatement582);
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

				match(input, 34, FOLLOW_34_in_blockStatement588);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:129:1:
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

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:6:
			// ( 'if' condition= expr truePath= statement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:130:8:
			// 'if' condition= expr truePath= statement
			{
				match(input, 28, FOLLOW_28_in_ifStatement607);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_expr_in_ifStatement611);
				condition = expr();
				state._fsp--;
				if (state.failed)
					return result;
				pushFollow(FOLLOW_statement_in_ifStatement615);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:134:1:
	// declStatement returns [AbstractStatement result] : q= questionStatement ;
	public final AbstractStatement declStatement() throws RecognitionException {
		AbstractStatement result = null;

		int declStatement_StartIndex = input.index();

		AbstractStatement q = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 15)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:135:2:
			// (q= questionStatement )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:135:4:
			// q= questionStatement
			{
				pushFollow(FOLLOW_questionStatement_in_declStatement640);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:138:1:
	// questionStatement returns [AbstractStatement result] : id= identExpr ':'
	// descr= stringExpr at= answerTypedef (ex= expr )? ;
	public final AbstractStatement questionStatement()
			throws RecognitionException {
		AbstractStatement result = null;

		int questionStatement_StartIndex = input.index();

		IdentExprType id = null;
		StringExprType descr = null;
		AbstractAnswerType at = null;
		AbstractExpr ex = null;

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 16)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:139:2:
			// (id= identExpr ':' descr= stringExpr at= answerTypedef (ex= expr
			// )? )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:139:4:
			// id= identExpr ':' descr= stringExpr at= answerTypedef (ex= expr
			// )?
			{
				pushFollow(FOLLOW_identExpr_in_questionStatement659);
				id = identExpr();
				state._fsp--;
				if (state.failed)
					return result;
				match(input, 20, FOLLOW_20_in_questionStatement661);
				if (state.failed)
					return result;
				pushFollow(FOLLOW_stringExpr_in_questionStatement665);
				descr = stringExpr();
				state._fsp--;
				if (state.failed)
					return result;
				pushFollow(FOLLOW_answerTypedef_in_questionStatement669);
				at = answerTypedef();
				state._fsp--;
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new Question(id, descr, at);
				}
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:143:3:
				// (ex= expr )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == 14)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:143:4:
				// ex= expr
				{
					pushFollow(FOLLOW_expr_in_questionStatement680);
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
	// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:149:1:
	// answerTypedef returns [AbstractAnswerType result] : ( 'boolean' |
	// 'integer' | 'money' | 'string' );
	public final AbstractAnswerType answerTypedef() throws RecognitionException {
		AbstractAnswerType result = null;

		int answerTypedef_StartIndex = input.index();

		try {
			if (state.backtracking > 0 && alreadyParsedRule(input, 17)) {
				return result;
			}

			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:150:2:
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:150:4:
			// 'boolean'
			{
				match(input, 26, FOLLOW_26_in_answerTypedef701);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new BoolAnswerType();
				}
			}
				break;
			case 2:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:151:4:
			// 'integer'
			{
				match(input, 29, FOLLOW_29_in_answerTypedef708);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new IntAnswerType();
				}
			}
				break;
			case 3:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:152:4:
			// 'money'
			{
				match(input, 30, FOLLOW_30_in_answerTypedef715);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new MoneyAnswerType();
				}
			}
				break;
			case 4:
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:153:4:
			// 'string'
			{
				match(input, 31, FOLLOW_31_in_answerTypedef723);
				if (state.failed)
					return result;
				if (state.backtracking == 0) {
					result = new StringAnswerType();
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

	public static final BitSet FOLLOW_INT_in_primary45 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_BOOLEAN_in_primary53 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MONEY_in_primary61 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identExpr_in_primary71 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_stringExpr_in_primary80 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expr_in_primary89 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENT_in_identExpr106 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_STRING_in_stringExpr123 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_14_in_expr140 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_orExpr_in_expr144 = new BitSet(
			new long[] { 0x0000000000008000L });
	public static final BitSet FOLLOW_15_in_expr146 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_17_in_unExpr163 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr167 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_18_in_unExpr174 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr178 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_11_in_unExpr185 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_unExpr189 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_primary_in_unExpr198 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_unExpr_in_mulExpr230 = new BitSet(
			new long[] { 0x0000000000090002L });
	public static final BitSet FOLLOW_set_in_mulExpr238 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_unExpr_in_mulExpr250 = new BitSet(
			new long[] { 0x0000000000090002L });
	public static final BitSet FOLLOW_mulExpr_in_addExpr291 = new BitSet(
			new long[] { 0x0000000000060002L });
	public static final BitSet FOLLOW_set_in_addExpr299 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_mulExpr_in_addExpr309 = new BitSet(
			new long[] { 0x0000000000060002L });
	public static final BitSet FOLLOW_addExpr_in_relExpr344 = new BitSet(
			new long[] { 0x0000000003E01002L });
	public static final BitSet FOLLOW_set_in_relExpr352 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_addExpr_in_relExpr368 = new BitSet(
			new long[] { 0x0000000003E01002L });
	public static final BitSet FOLLOW_relExpr_in_andExpr406 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_13_in_andExpr412 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_relExpr_in_andExpr416 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_andExpr_in_orExpr451 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_33_in_orExpr457 = new BitSet(
			new long[] { 0x0000000000064BD0L });
	public static final BitSet FOLLOW_andExpr_in_orExpr461 = new BitSet(
			new long[] { 0x0000000200000002L });
	public static final BitSet FOLLOW_27_in_form485 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_identExpr_in_form489 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_blockStatement_in_form493 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_blockStatement_in_statement516 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_ifStatement_in_statement529 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_declStatement_in_statement542 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_32_in_blockStatement577 = new BitSet(
			new long[] { 0x0000000510000040L });
	public static final BitSet FOLLOW_statement_in_blockStatement582 = new BitSet(
			new long[] { 0x0000000510000040L });
	public static final BitSet FOLLOW_34_in_blockStatement588 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_28_in_ifStatement607 = new BitSet(
			new long[] { 0x0000000000004000L });
	public static final BitSet FOLLOW_expr_in_ifStatement611 = new BitSet(
			new long[] { 0x0000000110000040L });
	public static final BitSet FOLLOW_statement_in_ifStatement615 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_questionStatement_in_declStatement640 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_identExpr_in_questionStatement659 = new BitSet(
			new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_20_in_questionStatement661 = new BitSet(
			new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_stringExpr_in_questionStatement665 = new BitSet(
			new long[] { 0x00000000E4000000L });
	public static final BitSet FOLLOW_answerTypedef_in_questionStatement669 = new BitSet(
			new long[] { 0x0000000000004002L });
	public static final BitSet FOLLOW_expr_in_questionStatement680 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_26_in_answerTypedef701 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_29_in_answerTypedef708 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_30_in_answerTypedef715 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_31_in_answerTypedef723 = new BitSet(
			new long[] { 0x0000000000000002L });
}
