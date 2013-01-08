// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-08 17:43:22

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.operators.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", 
		"Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Money=8;
	public static final int String=9;
	public static final int WS=10;

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
		this.state.ruleMemo = new HashMap[27+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "primary"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:16:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Money2=null;
		Token Bool3=null;
		Token Ident4=null;
		Token String5=null;
		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:17:3: ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' )
			int alt1=6;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt1=1;
				}
				break;
			case Money:
				{
				alt1=2;
				}
				break;
			case Bool:
				{
				alt1=3;
				}
				break;
			case Ident:
				{
				alt1=4;
				}
				break;
			case String:
				{
				alt1=5;
				}
				break;
			case 14:
				{
				alt1=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:17:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary46); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:18:5: Money
					{
					Money2=(Token)match(input,Money,FOLLOW_Money_in_primary56); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money2!=null?Money2.getText():null)); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:19:5: Bool
					{
					Bool3=(Token)match(input,Bool,FOLLOW_Bool_in_primary64); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool3!=null?Bool3.getText():null))); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:20:5: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary72); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }
					}
					break;
				case 5 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:21:5: String
					{
					String5=(Token)match(input,String,FOLLOW_String_in_primary80); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String5!=null?String5.getText():null).substring(1)); }
					}
					break;
				case 6 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:22:5: '(' x= orExpression ')'
					{
					match(input,14,FOLLOW_14_in_primary88); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary92);
					x=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary94); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:25:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt2=1;
				}
				break;
			case 18:
				{
				alt2=2;
				}
				break;
			case 11:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case String:
			case 14:
				{
				alt2=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:26:8: '+' x= unExpression
					{
					match(input,17,FOLLOW_17_in_unExpression119); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression123);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:27:8: '-' x= unExpression
					{
					match(input,18,FOLLOW_18_in_unExpression134); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression138);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:28:8: '!' x= unExpression
					{
					match(input,11,FOLLOW_11_in_unExpression149); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression153);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:29:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression166);
					x=primary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, unExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpression"



	// $ANTLR start "mulExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:33:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression204);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:33:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==16||LA3_0==19) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:33:53: op= ( '*' | '/' ) rhs= unExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==16||input.LA(1)==19 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpression_in_mulExpression224);
					rhs=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new Div(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, mulExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpression"



	// $ANTLR start "addExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression265);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:54: op= ( '+' | '-' ) rhs= mulExpression
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpression_in_addExpression283);
					rhs=mulExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression318);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==12||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:58:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpression_in_relExpression342);
					rhs=addExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GT(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GEq(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new Eq(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NEq(result, rhs);
					      }
					    }
					}
					break;

				default :
					break loop5;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, relExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpression"



	// $ANTLR start "andExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:82:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression380);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:82:52: ( '&&' rhs= relExpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==13) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:82:54: '&&' rhs= relExpression
					{
					match(input,13,FOLLOW_13_in_andExpression386); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression390);
					rhs=relExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression425);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:54: ( '||' rhs= andExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==25) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:87:56: '||' rhs= andExpression
					{
					match(input,25,FOLLOW_25_in_orExpression431); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression435);
					rhs=andExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary88 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_orExpression_in_primary92 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpression119 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpression_in_unExpression123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpression134 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpression_in_unExpression138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpression149 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpression_in_unExpression153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression204 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpression212 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression224 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression265 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpression273 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression283 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression318 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_set_in_relExpression326 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_addExpression_in_relExpression342 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression380 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpression386 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_relExpression_in_andExpression390 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression425 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_orExpression431 = new BitSet(new long[]{0x0000000000064BD0L});
	public static final BitSet FOLLOW_andExpression_in_orExpression435 = new BitSet(new long[]{0x0000000002000002L});
}
