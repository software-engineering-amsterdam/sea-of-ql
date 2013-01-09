// $ANTLR 3.5 C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-09 12:28:31

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", 
		"NewLine", "Str", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", 
		"'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int NewLine=8;
	public static final int Str=9;
	public static final int Type=10;
	public static final int WS=11;

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
		this.state.ruleMemo = new HashMap[32+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:1: primary returns [Expr result] : ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Bool1=null;
		Token Int2=null;
		Token Ident4=null;
		Expr x =null;
		Str strExpr3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:5: ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' )
			int alt1=5;
			switch ( input.LA(1) ) {
			case Bool:
				{
				alt1=1;
				}
				break;
			case Int:
				{
				alt1=2;
				}
				break;
			case Str:
				{
				alt1=3;
				}
				break;
			case Ident:
				{
				alt1=4;
				}
				break;
			case 15:
				{
				alt1=5;
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
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: Bool
					{
					Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary48); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool1!=null?Bool1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: Int
					{
					Int2=(Token)match(input,Int,FOLLOW_Int_in_primary61); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int2!=null?Int2.getText():null))); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: strExpr
					{
					pushFollow(FOLLOW_strExpr_in_primary75);
					strExpr3=strExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = strExpr3; }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: '(' x= orExpr ')'
					{
					match(input,15,FOLLOW_15_in_primary97); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary101);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_primary103); if (state.failed) return result;
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



	// $ANTLR start "strExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: strExpr returns [Str result] : Str ;
	public final Str strExpr() throws RecognitionException {
		Str result = null;

		int strExpr_StartIndex = input.index();

		Token Str5=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:5: ( Str )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:7: Str
			{
			Str5=(Token)match(input,Str,FOLLOW_Str_in_strExpr129); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Str((Str5!=null?Str5.getText():null).substring(1, (Str5!=null?Str5.getText():null).length() - 1)); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, strExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "strExpr"



	// $ANTLR start "unExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 18:
				{
				alt2=1;
				}
				break;
			case 19:
				{
				alt2=2;
				}
				break;
			case 12:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Str:
			case 15:
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
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:8: '+' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr163); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr167);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:8: '-' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr178); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr182);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:8: '!' x= unExpr
					{
					match(input,12,FOLLOW_12_in_unExpr193); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr197);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr210);
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
			if ( state.backtracking>0 ) { memoize(input, 3, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr248);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==17||LA3_0==20) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||input.LA(1)==20 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr268);
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
			if ( state.backtracking>0 ) { memoize(input, 4, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr309);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 18 && LA4_0 <= 19)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 18 && input.LA(1) <= 19) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr327);
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
			if ( state.backtracking>0 ) { memoize(input, 5, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr362);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 26)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 26) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr386);
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
			if ( state.backtracking>0 ) { memoize(input, 6, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr424);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:48: '&&' rhs= relExpr
					{
					match(input,14,FOLLOW_14_in_andExpr430); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr434);
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
			if ( state.backtracking>0 ) { memoize(input, 7, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr469);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==30) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:50: '||' rhs= andExpr
					{
					match(input,30,FOLLOW_30_in_orExpr475); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr479);
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
			if ( state.backtracking>0 ) { memoize(input, 8, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "form"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:1: form returns [Form result] : 'form' Ident '{' formElements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident6=null;
		List<FormElement> formElements7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:5: ( 'form' Ident '{' formElements '}' )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:7: 'form' Ident '{' formElements '}'
			{
			match(input,27,FOLLOW_27_in_form505); if (state.failed) return result;
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_form507); if (state.failed) return result;
			match(input,29,FOLLOW_29_in_form509); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_form511);
			formElements7=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form513); if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Form(new Ident((Ident6!=null?Ident6.getText():null)), formElements7); 
			      }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "formElements"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:1: formElements returns [List<FormElement> result] : (q= questionFormElement |i= ifFormElement );
	public final List<FormElement> formElements() throws RecognitionException {
		List<FormElement> result = null;

		int formElements_StartIndex = input.index();

		Question q =null;
		If i =null;


		        result = new ArrayList<FormElement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:5: (q= questionFormElement |i= ifFormElement )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Str) ) {
				alt8=1;
			}
			else if ( (LA8_0==28) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:7: q= questionFormElement
					{
					pushFollow(FOLLOW_questionFormElement_in_formElements553);
					q=questionFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(q); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:103:7: i= ifFormElement
					{
					pushFollow(FOLLOW_ifFormElement_in_formElements567);
					i=ifFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(i); }
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
			if ( state.backtracking>0 ) { memoize(input, 10, formElements_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElements"



	// $ANTLR start "questionFormElement"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:1: questionFormElement returns [Question result] : strExpr Ident ':' Type ;
	public final Question questionFormElement() throws RecognitionException {
		Question result = null;

		int questionFormElement_StartIndex = input.index();

		Token Ident9=null;
		Token Type10=null;
		Str strExpr8 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:5: ( strExpr Ident ':' Type )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:7: strExpr Ident ':' Type
			{
			pushFollow(FOLLOW_strExpr_in_questionFormElement594);
			strExpr8=strExpr();
			state._fsp--;
			if (state.failed) return result;
			Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_questionFormElement596); if (state.failed) return result;
			match(input,21,FOLLOW_21_in_questionFormElement598); if (state.failed) return result;
			Type10=(Token)match(input,Type,FOLLOW_Type_in_questionFormElement600); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(strExpr8.getValue(), new Ident((Ident9!=null?Ident9.getText():null)), (Type10!=null?Type10.getText():null)); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, questionFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionFormElement"



	// $ANTLR start "ifFormElement"
	// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:110:1: ifFormElement returns [If result] : 'if' '(' orExpr ')' '{' formElements '}' ;
	public final If ifFormElement() throws RecognitionException {
		If result = null;

		int ifFormElement_StartIndex = input.index();

		Expr orExpr11 =null;
		List<FormElement> formElements12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:5: ( 'if' '(' orExpr ')' '{' formElements '}' )
			// C:\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:7: 'if' '(' orExpr ')' '{' formElements '}'
			{
			match(input,28,FOLLOW_28_in_ifFormElement627); if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifFormElement629); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifFormElement631);
			orExpr11=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,16,FOLLOW_16_in_ifFormElement633); if (state.failed) return result;
			match(input,29,FOLLOW_29_in_ifFormElement635); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_ifFormElement637);
			formElements12=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,31,FOLLOW_31_in_ifFormElement639); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new If(orExpr11, formElements12, null); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, ifFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifFormElement"

	// Delegated rules



	public static final BitSet FOLLOW_Bool_in_primary48 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_primary75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_primary97 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_primary101 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_primary103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_strExpr129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr163 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr178 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unExpr193 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr248 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_set_in_mulExpr256 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr268 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr309 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_addExpr317 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr327 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr362 = new BitSet(new long[]{0x0000000007C02002L});
	public static final BitSet FOLLOW_set_in_relExpr370 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr386 = new BitSet(new long[]{0x0000000007C02002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr424 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr430 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr434 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr469 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_30_in_orExpr475 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr479 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_27_in_form505 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form507 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_form509 = new BitSet(new long[]{0x0000000010000200L});
	public static final BitSet FOLLOW_formElements_in_form511 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionFormElement_in_formElements553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifFormElement_in_formElements567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_questionFormElement594 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_questionFormElement596 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_questionFormElement598 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_Type_in_questionFormElement600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_ifFormElement627 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifFormElement629 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifFormElement631 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifFormElement633 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_ifFormElement635 = new BitSet(new long[]{0x0000000010000200L});
	public static final BitSet FOLLOW_formElements_in_ifFormElement637 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifFormElement639 = new BitSet(new long[]{0x0000000000000002L});
}
