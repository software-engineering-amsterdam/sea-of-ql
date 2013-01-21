// $ANTLR 3.5 D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 14:16:03

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.types.*; 
import org.uva.sea.ql.ast.operations.*; 
import org.uva.sea.ql.ast.conditions.*; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "WS", 
		"'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'<'", 
		"'<='", "'=='", "'>'", "'>='", "'||'"
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
		this.state.ruleMemo = new HashMap[24+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:3: ( Int | Ident | '(' x= orExpr ')' )
			int alt1=3;
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
			case 11:
				{
				alt1=3;
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
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary46); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary56); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: '(' x= orExpr ')'
					{
					match(input,11,FOLLOW_11_in_primary64); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary68);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,12,FOLLOW_12_in_primary70); if (state.failed) return result;
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 14:
				{
				alt2=1;
				}
				break;
			case 15:
				{
				alt2=2;
				}
				break;
			case 8:
				{
				alt2=3;
				}
				break;
			case Ident:
			case Int:
			case 11:
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
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:8: '+' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr95); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr99);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:8: '-' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr110); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr114);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:8: '!' x= unExpr
					{
					match(input,8,FOLLOW_8_in_unExpr125); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr129);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr142);
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr180);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==13||LA3_0==16) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||input.LA(1)==16 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr200);
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr241);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 14 && LA4_0 <= 15)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 14 && input.LA(1) <= 15) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr259);
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr294);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==9||(LA5_0 >= 17 && LA5_0 <= 21)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==9||(input.LA(1) >= 17 && input.LA(1) <= 21) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr318);
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr356);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==10) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:48: '&&' rhs= relExpr
					{
					match(input,10,FOLLOW_10_in_andExpr362); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr366);
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
	// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr401);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==22) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// D:\\School\\Software Construction\\Workspace\\sea-of-ql\\TubaKaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:50: '||' rhs= andExpr
					{
					match(input,22,FOLLOW_22_in_orExpr407); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr411);
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
	public static final BitSet FOLLOW_11_in_primary64 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_orExpr_in_primary68 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_primary70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr95 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr110 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr114 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_unExpr125 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr180 = new BitSet(new long[]{0x0000000000012002L});
	public static final BitSet FOLLOW_set_in_mulExpr188 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr200 = new BitSet(new long[]{0x0000000000012002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr241 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_set_in_addExpr249 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr259 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr294 = new BitSet(new long[]{0x00000000003E0202L});
	public static final BitSet FOLLOW_set_in_relExpr302 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_addExpr_in_relExpr318 = new BitSet(new long[]{0x00000000003E0202L});
	public static final BitSet FOLLOW_relExpr_in_andExpr356 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_andExpr362 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_relExpr_in_andExpr366 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_andExpr_in_orExpr401 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_orExpr407 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_andExpr_in_orExpr411 = new BitSet(new long[]{0x0000000000400002L});
}
