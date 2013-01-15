// $ANTLR 3.5 C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-15 11:24:19

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean_Type", "COMMENT", "Else_RW", 
		"False_RW", "Ident", "If_RW", "Int", "Integer_Type", "SINGLE_LINE_COMMENT", 
		"String_Literal", "String_Type", "Then_RW", "True_RW", "WS", "'!'", "'!='", 
		"'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", 
		"'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int Boolean_Type=4;
	public static final int COMMENT=5;
	public static final int Else_RW=6;
	public static final int False_RW=7;
	public static final int Ident=8;
	public static final int If_RW=9;
	public static final int Int=10;
	public static final int Integer_Type=11;
	public static final int SINGLE_LINE_COMMENT=12;
	public static final int String_Literal=13;
	public static final int String_Type=14;
	public static final int Then_RW=15;
	public static final int True_RW=16;
	public static final int WS=17;

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
		this.state.ruleMemo = new HashMap[33+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:1: primary returns [Expr result] : ( Int | Ident | String_Literal | Boolean_Type | Integer_Type | String_Type | True_RW | False_RW | If_RW | Then_RW | Else_RW | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Token String_Literal3=null;
		Token Boolean_Type4=null;
		Token Integer_Type5=null;
		Token String_Type6=null;
		Token True_RW7=null;
		Token False_RW8=null;
		Token If_RW9=null;
		Token Then_RW10=null;
		Token Else_RW11=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:3: ( Int | Ident | String_Literal | Boolean_Type | Integer_Type | String_Type | True_RW | False_RW | If_RW | Then_RW | Else_RW | '(' x= orExpr ')' )
			int alt1=12;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt1=1;
				}
				break;
			case Ident:
				{
				alt1=2;
				}
				break;
			case String_Literal:
				{
				alt1=3;
				}
				break;
			case Boolean_Type:
				{
				alt1=4;
				}
				break;
			case Integer_Type:
				{
				alt1=5;
				}
				break;
			case String_Type:
				{
				alt1=6;
				}
				break;
			case True_RW:
				{
				alt1=7;
				}
				break;
			case False_RW:
				{
				alt1=8;
				}
				break;
			case If_RW:
				{
				alt1=9;
				}
				break;
			case Then_RW:
				{
				alt1=10;
				}
				break;
			case Else_RW:
				{
				alt1=11;
				}
				break;
			case 21:
				{
				alt1=12;
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
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary46); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary56); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: String_Literal
					{
					String_Literal3=(Token)match(input,String_Literal,FOLLOW_String_Literal_in_primary64); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new String_Literal((String_Literal3!=null?String_Literal3.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:5: Boolean_Type
					{
					Boolean_Type4=(Token)match(input,Boolean_Type,FOLLOW_Boolean_Type_in_primary72); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Boolean_Type((Boolean_Type4!=null?Boolean_Type4.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: Integer_Type
					{
					Integer_Type5=(Token)match(input,Integer_Type,FOLLOW_Integer_Type_in_primary80); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Integer_Type((Integer_Type5!=null?Integer_Type5.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: String_Type
					{
					String_Type6=(Token)match(input,String_Type,FOLLOW_String_Type_in_primary88); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new String_Type((String_Type6!=null?String_Type6.getText():null)); }
					}
					break;
				case 7 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: True_RW
					{
					True_RW7=(Token)match(input,True_RW,FOLLOW_True_RW_in_primary97); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new True_RW((True_RW7!=null?True_RW7.getText():null)); }
					}
					break;
				case 8 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:5: False_RW
					{
					False_RW8=(Token)match(input,False_RW,FOLLOW_False_RW_in_primary105); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new False_RW((False_RW8!=null?False_RW8.getText():null)); }
					}
					break;
				case 9 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: If_RW
					{
					If_RW9=(Token)match(input,If_RW,FOLLOW_If_RW_in_primary115); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new If_RW((If_RW9!=null?If_RW9.getText():null)); }
					}
					break;
				case 10 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:5: Then_RW
					{
					Then_RW10=(Token)match(input,Then_RW,FOLLOW_Then_RW_in_primary125); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Then_RW((Then_RW10!=null?Then_RW10.getText():null)); }
					}
					break;
				case 11 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: Else_RW
					{
					Else_RW11=(Token)match(input,Else_RW,FOLLOW_Else_RW_in_primary135); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Else_RW((Else_RW11!=null?Else_RW11.getText():null)); }
					}
					break;
				case 12 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:5: '(' x= orExpr ')'
					{
					match(input,21,FOLLOW_21_in_primary148); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary152);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,22,FOLLOW_22_in_primary154); if (state.failed) return result;
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



	// $ANTLR start "unExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt2=1;
				}
				break;
			case 25:
				{
				alt2=2;
				}
				break;
			case 18:
				{
				alt2=3;
				}
				break;
			case Boolean_Type:
			case Else_RW:
			case False_RW:
			case Ident:
			case If_RW:
			case Int:
			case Integer_Type:
			case String_Literal:
			case String_Type:
			case Then_RW:
			case True_RW:
			case 21:
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
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:8: '+' x= unExpr
					{
					match(input,24,FOLLOW_24_in_unExpr179); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr183);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:8: '-' x= unExpr
					{
					match(input,25,FOLLOW_25_in_unExpr194); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr198);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:8: '!' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr209); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr213);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr226);
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
			if ( state.backtracking>0 ) { memoize(input, 2, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr264);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==23||LA3_0==26) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==23||input.LA(1)==26 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr284);
					rhs=unExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws  RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr325);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 24 && LA4_0 <= 25)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr343);
					rhs=mulExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 4, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException  {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr378);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==19||(LA5_0 >= 27 && LA5_0 <= 31)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==19||(input.LA(1) >= 27 && input.LA(1) <= 31) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr402);
					rhs=addExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 5, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException  {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr440);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==20) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:48: '&&' rhs= relExpr
					{
					match(input,20,FOLLOW_20_in_andExpr446); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr450);
					rhs=relExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 6, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException  {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr485);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==32) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr491); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr495);
					rhs=andExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 7, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_Literal_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_Type_in_primary72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_Type_in_primary80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_Type_in_primary88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_True_RW_in_primary97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_False_RW_in_primary105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_RW_in_primary115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Then_RW_in_primary125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_RW_in_primary135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_primary148 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_orExpr_in_primary152 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_primary154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpr179 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpr194 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr209 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr264 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpr272 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr284 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr325 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpr333 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr343 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr378 = new BitSet(new long[]{0x00000000F8080002L});
	public static final BitSet FOLLOW_set_in_relExpr386 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr402 = new BitSet(new long[]{0x00000000F8080002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr440 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_20_in_andExpr446 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr450 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr485 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr491 = new BitSet(new long[]{0x000000000325EFD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr495 = new BitSet(new long[]{0x0000000100000002L});
}
