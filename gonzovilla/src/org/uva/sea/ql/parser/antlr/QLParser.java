// $ANTLR 3.5 /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-17 17:32:05

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "WS", 
		"'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'.'", "'/'", 
		"':'", "':='", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'?'", "'Float'", 
		"'Integer'", "'String'", "'end'", "'question'", "'start'", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
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
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int COMMENT=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int WS=7;

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
	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "program"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:15:1: program : 'start' Ident '=' ( question )* 'end' Ident '.' ;
	public final void program() throws RecognitionException {
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:16:3: ( 'start' Ident '=' ( question )* 'end' Ident '.' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:16:5: 'start' Ident '=' ( question )* 'end' Ident '.'
			{
			match(input,32,FOLLOW_32_in_program39); 
			match(input,Ident,FOLLOW_Ident_in_program41); 
			match(input,22,FOLLOW_22_in_program43); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:17:5: ( question )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==31) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:17:5: question
					{
					pushFollow(FOLLOW_question_in_program49);
					question();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,30,FOLLOW_30_in_program57); 
			match(input,Ident,FOLLOW_Ident_in_program59); 
			match(input,16,FOLLOW_16_in_program61); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "question"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:21:1: question : 'question' Ident ':' returnType ':=' expression '?' ;
	public final void question() throws RecognitionException {
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:22:3: ( 'question' Ident ':' returnType ':=' expression '?' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:22:5: 'question' Ident ':' returnType ':=' expression '?'
			{
			match(input,31,FOLLOW_31_in_question74); 
			match(input,Ident,FOLLOW_Ident_in_question76); 
			match(input,18,FOLLOW_18_in_question78); 
			pushFollow(FOLLOW_returnType_in_question80);
			returnType();
			state._fsp--;

			match(input,19,FOLLOW_19_in_question82); 
			pushFollow(FOLLOW_expression_in_question84);
			expression();
			state._fsp--;

			match(input,26,FOLLOW_26_in_question86); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "question"



	// $ANTLR start "returnType"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:1: returnType : ( 'Integer' | 'Float' | 'String' );
	public final void returnType() throws RecognitionException {
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:26:3: ( 'Integer' | 'Float' | 'String' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			if ( (input.LA(1) >= 27 && input.LA(1) <= 29) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "returnType"



	// $ANTLR start "expression"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:31:1: expression : ( Ident | WS )+ ;
	public final void expression() throws RecognitionException {
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:32:3: ( ( Ident | WS )+ )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:32:5: ( Ident | WS )+
			{
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:32:5: ( Ident | WS )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==Ident||LA2_0==WS) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:
					{
					if ( input.LA(1)==Ident||input.LA(1)==WS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:35:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int1=null;
		Token Ident2=null;
		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:36:3: ( Int | Ident | '(' x= orExpr ')' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt3=1;
				}
				break;
			case Ident:
				{
				alt3=2;
				}
				break;
			case 11:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary148); 
					 result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary158); 
					 result = new Ident((Ident2!=null?Ident2.getText():null)); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: '(' x= orExpr ')'
					{
					match(input,11,FOLLOW_11_in_primary166); 
					pushFollow(FOLLOW_orExpr_in_primary170);
					x=orExpr();
					state._fsp--;

					match(input,12,FOLLOW_12_in_primary172); 
					 result = x; 
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
		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 14:
				{
				alt4=1;
				}
				break;
			case 15:
				{
				alt4=2;
				}
				break;
			case 8:
				{
				alt4=3;
				}
				break;
			case Ident:
			case Int:
			case 11:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:8: '+' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr197); 
					pushFollow(FOLLOW_unExpr_in_unExpr201);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:43:8: '-' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr212); 
					pushFollow(FOLLOW_unExpr_in_unExpr216);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:44:8: '!' x= unExpr
					{
					match(input,8,FOLLOW_8_in_unExpr227); 
					pushFollow(FOLLOW_unExpr_in_unExpr231);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr244);
					x=primary();
					state._fsp--;

					 result = x; 
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
		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr282);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==13||LA5_0==17) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||input.LA(1)==17 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr302);
					rhs=unExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new Div(result, rhs);      
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
		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr343);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= 14 && LA6_0 <= 15)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 14 && input.LA(1) <= 15) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr361);
					rhs=mulExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
					      }
					    
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
		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr396);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==9||(LA7_0 >= 20 && LA7_0 <= 21)||(LA7_0 >= 23 && LA7_0 <= 25)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==9||(input.LA(1) >= 20 && input.LA(1) <= 21)||(input.LA(1) >= 23 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr420);
					rhs=addExpr();
					state._fsp--;

					 
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
		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:98:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr458);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:98:46: ( '&&' rhs= relExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==10) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:98:48: '&&' rhs= relExpr
					{
					match(input,10,FOLLOW_10_in_andExpr464); 
					pushFollow(FOLLOW_relExpr_in_andExpr468);
					rhs=relExpr();
					state._fsp--;

					 result = new And(result, rhs); 
					}
					break;

				default :
					break loop8;
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:102:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr503);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:103:48: ( '||' rhs= andExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==33) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:103:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr509); 
					pushFollow(FOLLOW_andExpr_in_orExpr513);
					rhs=andExpr();
					state._fsp--;

					 result = new Or(result, rhs); 
					}
					break;

				default :
					break loop9;
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
		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_32_in_program39 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_program41 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_program43 = new BitSet(new long[]{0x00000000C0000000L});
	public static final BitSet FOLLOW_question_in_program49 = new BitSet(new long[]{0x00000000C0000000L});
	public static final BitSet FOLLOW_30_in_program57 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_program59 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_program61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_question74 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_question76 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_question78 = new BitSet(new long[]{0x0000000038000000L});
	public static final BitSet FOLLOW_returnType_in_question80 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_question82 = new BitSet(new long[]{0x00000000000000A0L});
	public static final BitSet FOLLOW_expression_in_question84 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_question86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_primary166 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_orExpr_in_primary170 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_primary172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr197 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr212 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_unExpr227 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr282 = new BitSet(new long[]{0x0000000000022002L});
	public static final BitSet FOLLOW_set_in_mulExpr290 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr302 = new BitSet(new long[]{0x0000000000022002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr343 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_set_in_addExpr351 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr361 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr396 = new BitSet(new long[]{0x0000000003B00202L});
	public static final BitSet FOLLOW_set_in_relExpr404 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_addExpr_in_relExpr420 = new BitSet(new long[]{0x0000000003B00202L});
	public static final BitSet FOLLOW_relExpr_in_andExpr458 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_andExpr464 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_relExpr_in_andExpr468 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_andExpr_in_orExpr503 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr509 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_andExpr_in_orExpr513 = new BitSet(new long[]{0x0000000200000002L});
}
