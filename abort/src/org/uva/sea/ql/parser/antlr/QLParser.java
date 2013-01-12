// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-12 17:28:15

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.types.*;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "EscapedCharacterSequence", 
		"Ident", "Int", "Money", "String", "Type", "WS", "'!'", "'!='", "'&&'", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", 
		"'>='", "'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int EscapedCharacterSequence=6;
	public static final int Ident=7;
	public static final int Int=8;
	public static final int Money=9;
	public static final int String=10;
	public static final int Type=11;
	public static final int WS=12;

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
		this.state.ruleMemo = new HashMap[29+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e.getMessage()); 
	  }



	// $ANTLR start "primary"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: primary returns [Expression result] : ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' | ifExpression );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Money2=null;
		Token Bool3=null;
		Token Ident4=null;
		Token String5=null;
		Expression x =null;
		If ifExpression6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:3: ( Int | Money | Bool | Ident | String | '(' x= orExpression ')' | ifExpression )
			int alt1=7;
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
			case 16:
				{
				alt1=6;
				}
				break;
			case 27:
				{
				alt1=7;
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:35:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary67); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: Money
					{
					Money2=(Token)match(input,Money,FOLLOW_Money_in_primary77); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money2!=null?Money2.getText():null)); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: Bool
					{
					Bool3=(Token)match(input,Bool,FOLLOW_Bool_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool3!=null?Bool3.getText():null))); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary93); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }
					}
					break;
				case 5 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:39:5: String
					{
					String5=(Token)match(input,String,FOLLOW_String_in_primary101); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String5!=null?String5.getText():null).substring(1, (String5!=null?String5.getText():null).length() - 1)); }
					}
					break;
				case 6 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: '(' x= orExpression ')'
					{
					match(input,16,FOLLOW_16_in_primary109); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary113);
					x=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary115); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 7 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: ifExpression
					{
					pushFollow(FOLLOW_ifExpression_in_primary122);
					ifExpression6=ifExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifExpression6; }
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



	// $ANTLR start "ifExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:46:1: ifExpression returns [If result] : 'if' '(' statement= orExpression ')' '{' successStatements= orExpression '}' ;
	public final If ifExpression() throws RecognitionException {
		If result = null;

		int ifExpression_StartIndex = input.index();

		Expression statement =null;
		Expression successStatements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: ( 'if' '(' statement= orExpression ')' '{' successStatements= orExpression '}' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:47:7: 'if' '(' statement= orExpression ')' '{' successStatements= orExpression '}'
			{
			match(input,27,FOLLOW_27_in_ifExpression153); if (state.failed) return result;
			match(input,16,FOLLOW_16_in_ifExpression155); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_ifExpression159);
			statement=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,17,FOLLOW_17_in_ifExpression161); if (state.failed) return result;
			match(input,28,FOLLOW_28_in_ifExpression163); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_ifExpression167);
			successStatements=orExpression();
			state._fsp--;
			if (state.failed) return result;
			match(input,30,FOLLOW_30_in_ifExpression169); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      result = new If(statement, successStatements);
			    }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, ifExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifExpression"



	// $ANTLR start "unExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
	public final Expression unExpression() throws RecognitionException {
		Expression result = null;

		int unExpression_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 19:
				{
				alt2=1;
				}
				break;
			case 20:
				{
				alt2=2;
				}
				break;
			case 13:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case String:
			case 16:
			case 27:
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:54:8: '+' x= unExpression
					{
					match(input,19,FOLLOW_19_in_unExpression203); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression207);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:55:8: '-' x= unExpression
					{
					match(input,20,FOLLOW_20_in_unExpression218); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression222);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:56:8: '!' x= unExpression
					{
					match(input,13,FOLLOW_13_in_unExpression233); if (state.failed) return result;
					pushFollow(FOLLOW_unExpression_in_unExpression237);
					x=unExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:57:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpression250);
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
			if ( state.backtracking>0 ) { memoize(input, 3, unExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpression"



	// $ANTLR start "mulExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
	public final Expression mulExpression() throws RecognitionException {
		Expression result = null;

		int mulExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
			{
			pushFollow(FOLLOW_unExpression_in_mulExpression288);
			lhs=unExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:51: (op= ( '*' | '/' ) rhs= unExpression )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==18||LA3_0==21) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:61:53: op= ( '*' | '/' ) rhs= unExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==18||input.LA(1)==21 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpression_in_mulExpression308);
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
			if ( state.backtracking>0 ) { memoize(input, 4, mulExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpression"



	// $ANTLR start "addExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:74:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:74:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
			{
			pushFollow(FOLLOW_mulExpression_in_addExpression349);
			lhs=mulExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:74:52: (op= ( '+' | '-' ) rhs= mulExpression )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 19 && LA4_0 <= 20)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:74:54: op= ( '+' | '-' ) rhs= mulExpression
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpression_in_addExpression367);
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
			if ( state.backtracking>0 ) { memoize(input, 5, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relExpression() throws RecognitionException {
		Expression result = null;

		int relExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relExpression402);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==14||(LA5_0 >= 22 && LA5_0 <= 26)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:86:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
					{
					op=input.LT(1);
					if ( input.LA(1)==14||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpression_in_relExpression426);
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
			if ( state.backtracking>0 ) { memoize(input, 6, relExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpression"



	// $ANTLR start "andExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: lhs= relExpression ( '&&' rhs= relExpression )*
			{
			pushFollow(FOLLOW_relExpression_in_andExpression464);
			lhs=relExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:110:52: ( '&&' rhs= relExpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==15) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:110:54: '&&' rhs= relExpression
					{
					match(input,15,FOLLOW_15_in_andExpression470); if (state.failed) return result;
					pushFollow(FOLLOW_relExpression_in_andExpression474);
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
			if ( state.backtracking>0 ) { memoize(input, 7, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression509);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:115:54: ( '||' rhs= andExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==29) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:115:56: '||' rhs= andExpression
					{
					match(input,29,FOLLOW_29_in_orExpression515); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression519);
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
			if ( state.backtracking>0 ) { memoize(input, 8, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary109 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_orExpression_in_primary113 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifExpression_in_primary122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_ifExpression153 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifExpression155 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression159 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifExpression161 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifExpression163 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_orExpression_in_ifExpression167 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifExpression169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpression203 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpression218 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpression233 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_unExpression_in_unExpression237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpression250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression288 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpression296 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_unExpression_in_mulExpression308 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression349 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpression357 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_mulExpression_in_addExpression367 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpression_in_relExpression402 = new BitSet(new long[]{0x0000000007C04002L});
	public static final BitSet FOLLOW_set_in_relExpression410 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_addExpression_in_relExpression426 = new BitSet(new long[]{0x0000000007C04002L});
	public static final BitSet FOLLOW_relExpression_in_andExpression464 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpression470 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_relExpression_in_andExpression474 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression509 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_orExpression515 = new BitSet(new long[]{0x0000000008192790L});
	public static final BitSet FOLLOW_andExpression_in_orExpression519 = new BitSet(new long[]{0x0000000020000002L});
}
