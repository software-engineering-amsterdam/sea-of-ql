// $ANTLR 3.5 C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-04 12:59:08

package org.uva.sea.ql.parser.antlr;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.type.Type;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", 
		"NewLine", "Str", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", 
		"'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
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
	public static final int T__32=32;
	public static final int T__33=33;
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
		this.state.ruleMemo = new HashMap[41+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:1: primary returns [Expr result] : ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Bool1=null;
		Token Int2=null;
		Token Ident4=null;
		Expr x =null;
		org.uva.sea.ql.ast.expr.value.Str strExpr3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:5: ( Bool | Int | strExpr | Ident | '(' x= orExpr ')' )
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: Bool
					{
					Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary48); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expr.value.Bool(Boolean.parseBoolean((Bool1!=null?Bool1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: Int
					{
					Int2=(Token)match(input,Int,FOLLOW_Int_in_primary61); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expr.value.Int(Integer.parseInt((Int2!=null?Int2.getText():null))); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: strExpr
					{
					pushFollow(FOLLOW_strExpr_in_primary75);
					strExpr3=strExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = strExpr3; }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: '(' x= orExpr ')'
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:1: strExpr returns [org.uva.sea.ql.ast.expr.value.Str result] : Str ;
	public final org.uva.sea.ql.ast.expr.value.Str strExpr() throws RecognitionException {
		org.uva.sea.ql.ast.expr.value.Str result = null;

		int strExpr_StartIndex = input.index();

		Token Str5=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:5: ( Str )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:7: Str
			{
			Str5=(Token)match(input,Str,FOLLOW_Str_in_strExpr129); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expr.value.Str((Str5!=null?Str5.getText():null).substring(1, (Str5!=null?Str5.getText():null).length() - 1)); }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:8: '+' x= unExpr
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:8: '-' x= unExpr
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:8: '!' x= unExpr
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:8: x= primary
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr248);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==17||LA3_0==20) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:38:47: op= ( '*' | '/' ) rhs= unExpr
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
					      if ((op!=null?op.getText():null).equals("/")) {
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr309);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 18 && LA4_0 <= 19)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:48: op= ( '+' | '-' ) rhs= mulExpr
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr362);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 23)||(LA5_0 >= 25 && LA5_0 <= 27)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||(input.LA(1) >= 22 && input.LA(1) <= 23)||(input.LA(1) >= 25 && input.LA(1) <= 27) ) {
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr424);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:48: '&&' rhs= relExpr
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr469);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==32) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr475); if (state.failed) return result;
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: form returns [Form result] : 'form' Ident '{' statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident6=null;
		Statement statements7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: ( 'form' Ident '{' statements '}' )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:7: 'form' Ident '{' statements '}'
			{
			match(input,29,FOLLOW_29_in_form505); if (state.failed) return result;
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_form507); if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form509); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form511);
			statements7=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,33,FOLLOW_33_in_form513); if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Form(new Ident((Ident6!=null?Ident6.getText():null)), statements7); 
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



	// $ANTLR start "statements"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: statements returns [Statement result] : ( statement )* ;
	public final Statement statements() throws RecognitionException {
		Statement result = null;

		int statements_StartIndex = input.index();

		Statement statement8 =null;


		        ArrayList<Statement> statements = new ArrayList<Statement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:5: ( ( statement )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( statement )*
			{
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( statement )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==Ident||LA8_0==Str||LA8_0==30) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:8: statement
					{
					pushFollow(FOLLOW_statement_in_statements559);
					statement8=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { statements.add(statement8); }
					}
					break;

				default :
					break loop8;
				}
			}

			}

			if ( state.backtracking==0 ) {
			        if(statements.isEmpty())
			            result = new NullStatement();
			        else if(statements.size() == 1)
			            result = statements.get(0);
			        else
			            result = new CompositeStatement(statements);
			    }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, statements_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:1: statement returns [Statement result] : ( ifStatement | questionStatement | computedStatement | storedExpressionStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Statement ifStatement9 =null;
		Question questionStatement10 =null;
		Computed computedStatement11 =null;
		StoredExpression storedExpressionStatement12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: ( ifStatement | questionStatement | computedStatement | storedExpressionStatement )
			int alt9=4;
			switch ( input.LA(1) ) {
			case 30:
				{
				alt9=1;
				}
				break;
			case Str:
				{
				int LA9_2 = input.LA(2);
				if ( (LA9_2==Ident) ) {
					int LA9_4 = input.LA(3);
					if ( (LA9_4==21) ) {
						alt9=2;
					}
					else if ( (LA9_4==EOF||LA9_4==Ident||LA9_4==Str||(LA9_4 >= 13 && LA9_4 <= 14)||(LA9_4 >= 17 && LA9_4 <= 20)||(LA9_4 >= 22 && LA9_4 <= 23)||(LA9_4 >= 25 && LA9_4 <= 27)||LA9_4==30||(LA9_4 >= 32 && LA9_4 <= 33)) ) {
						alt9=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA9_2==Bool||LA9_2==Int||LA9_2==Str||LA9_2==12||LA9_2==15||(LA9_2 >= 18 && LA9_2 <= 19)) ) {
					alt9=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case Ident:
				{
				alt9=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:7: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement588);
					ifStatement9=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement9; }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:7: questionStatement
					{
					pushFollow(FOLLOW_questionStatement_in_statement598);
					questionStatement10=questionStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = questionStatement10; }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:7: computedStatement
					{
					pushFollow(FOLLOW_computedStatement_in_statement608);
					computedStatement11=computedStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedStatement11; }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:7: storedExpressionStatement
					{
					pushFollow(FOLLOW_storedExpressionStatement_in_statement618);
					storedExpressionStatement12=storedExpressionStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = storedExpressionStatement12; }
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
			if ( state.backtracking>0 ) { memoize(input, 11, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "storedExpressionStatement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:1: storedExpressionStatement returns [StoredExpression result] : Ident '=' orExpr ;
	public final StoredExpression storedExpressionStatement() throws RecognitionException {
		StoredExpression result = null;

		int storedExpressionStatement_StartIndex = input.index();

		Token Ident13=null;
		Expr orExpr14 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:5: ( Ident '=' orExpr )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:7: Ident '=' orExpr
			{
			Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_storedExpressionStatement645); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_storedExpressionStatement647); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_storedExpressionStatement649);
			orExpr14=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new StoredExpression(new Ident((Ident13!=null?Ident13.getText():null)), orExpr14); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, storedExpressionStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "storedExpressionStatement"



	// $ANTLR start "questionStatement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:127:1: questionStatement returns [Question result] : strExpr Ident ':' typeDeclaration ;
	public final Question questionStatement() throws RecognitionException {
		Question result = null;

		int questionStatement_StartIndex = input.index();

		Token Ident16=null;
		org.uva.sea.ql.ast.expr.value.Str strExpr15 =null;
		Type typeDeclaration17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:5: ( strExpr Ident ':' typeDeclaration )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:7: strExpr Ident ':' typeDeclaration
			{
			pushFollow(FOLLOW_strExpr_in_questionStatement676);
			strExpr15=strExpr();
			state._fsp--;
			if (state.failed) return result;
			Ident16=(Token)match(input,Ident,FOLLOW_Ident_in_questionStatement678); if (state.failed) return result;
			match(input,21,FOLLOW_21_in_questionStatement680); if (state.failed) return result;
			pushFollow(FOLLOW_typeDeclaration_in_questionStatement682);
			typeDeclaration17=typeDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Question(strExpr15.getValue(), new Ident((Ident16!=null?Ident16.getText():null)), typeDeclaration17); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, questionStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionStatement"



	// $ANTLR start "typeDeclaration"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:1: typeDeclaration returns [Type result] : Type ;
	public final Type typeDeclaration() throws RecognitionException {
		Type result = null;

		int typeDeclaration_StartIndex = input.index();

		Token Type18=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:5: ( Type )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:7: Type
			{
			Type18=(Token)match(input,Type,FOLLOW_Type_in_typeDeclaration716); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			        if((Type18!=null?Type18.getText():null).equals("boolean"))
			          result = new org.uva.sea.ql.ast.type.Bool();
			        else if((Type18!=null?Type18.getText():null).equals("integer"))
			          result = new org.uva.sea.ql.ast.type.Int();
			        else if((Type18!=null?Type18.getText():null).equals("string"))
			          result = new org.uva.sea.ql.ast.type.Str();
			      }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, typeDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "typeDeclaration"



	// $ANTLR start "computedStatement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:1: computedStatement returns [Computed result] : strExpr orExpr ;
	public final Computed computedStatement() throws RecognitionException {
		Computed result = null;

		int computedStatement_StartIndex = input.index();

		org.uva.sea.ql.ast.expr.value.Str strExpr19 =null;
		Expr orExpr20 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:5: ( strExpr orExpr )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:7: strExpr orExpr
			{
			pushFollow(FOLLOW_strExpr_in_computedStatement739);
			strExpr19=strExpr();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedStatement741);
			orExpr20=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computed(strExpr19.getValue(), orExpr20); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, computedStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedStatement"



	// $ANTLR start "ifStatement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:1: ifStatement returns [Statement result] : ( 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement | 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' | 'if' '(' orExpr ')' '{' statements '}' );
	public final Statement ifStatement() throws RecognitionException {
		Statement result = null;

		int ifStatement_StartIndex = input.index();

		Statement ifElements =null;
		Statement elseElement =null;
		Statement elseElements =null;
		Expr orExpr21 =null;
		Expr orExpr22 =null;
		Expr orExpr23 =null;
		Statement statements24 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:5: ( 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement | 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' | 'if' '(' orExpr ')' '{' statements '}' )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==30) ) {
				int LA10_1 = input.LA(2);
				if ( (synpred24_QL()) ) {
					alt10=1;
				}
				else if ( (synpred25_QL()) ) {
					alt10=2;
				}
				else if ( (true) ) {
					alt10=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:7: 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement
					{
					match(input,30,FOLLOW_30_in_ifStatement767); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement769); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifStatement771);
					orExpr21=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement773); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement775); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement781);
					ifElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement783); if (state.failed) return result;
					match(input,28,FOLLOW_28_in_ifStatement785); if (state.failed) return result;
					pushFollow(FOLLOW_ifStatement_in_ifStatement791);
					elseElement=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfElse(orExpr21, ifElements, elseElement); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}'
					{
					match(input,30,FOLLOW_30_in_ifStatement809); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement811); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifStatement813);
					orExpr22=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement815); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement817); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement823);
					ifElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement825); if (state.failed) return result;
					match(input,28,FOLLOW_28_in_ifStatement827); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement829); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement835);
					elseElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement836); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfElse(orExpr22, ifElements, elseElements); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:7: 'if' '(' orExpr ')' '{' statements '}'
					{
					match(input,30,FOLLOW_30_in_ifStatement855); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement857); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifStatement859);
					orExpr23=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement861); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement863); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement865);
					statements24=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement867); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new If(orExpr23, statements24); }
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
			if ( state.backtracking>0 ) { memoize(input, 16, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"

	// $ANTLR start synpred24_QL
	public final void synpred24_QL_fragment() throws RecognitionException {
		Statement ifElements =null;
		Statement elseElement =null;

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:7: ( 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:7: 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement
		{
		match(input,30,FOLLOW_30_in_synpred24_QL767); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred24_QL769); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred24_QL771);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred24_QL773); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred24_QL775); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred24_QL781);
		ifElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred24_QL783); if (state.failed) return;
		match(input,28,FOLLOW_28_in_synpred24_QL785); if (state.failed) return;
		pushFollow(FOLLOW_ifStatement_in_synpred24_QL791);
		elseElement=ifStatement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred24_QL

	// $ANTLR start synpred25_QL
	public final void synpred25_QL_fragment() throws RecognitionException {
		Statement ifElements =null;
		Statement elseElements =null;

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: ( 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: 'if' '(' orExpr ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}'
		{
		match(input,30,FOLLOW_30_in_synpred25_QL809); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred25_QL811); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred25_QL813);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred25_QL815); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred25_QL817); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred25_QL823);
		ifElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred25_QL825); if (state.failed) return;
		match(input,28,FOLLOW_28_in_synpred25_QL827); if (state.failed) return;
		match(input, 31, FOLLOW_31_in_synpred25_QL829); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred25_QL835);
		elseElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred25_QL836); if (state.failed) return;
		}

	}
	// $ANTLR end synpred25_QL

	// Delegated rules

	public final boolean synpred25_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred25_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred24_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred24_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



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
	public static final BitSet FOLLOW_addExpr_in_relExpr362 = new BitSet(new long[]{0x000000000EC02002L});
	public static final BitSet FOLLOW_set_in_relExpr370 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr386 = new BitSet(new long[]{0x000000000EC02002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr424 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr430 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr434 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr469 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr475 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr479 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_29_in_form505 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form507 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form509 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_form511 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements559 = new BitSet(new long[]{0x0000000040000242L});
	public static final BitSet FOLLOW_ifStatement_in_statement588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionStatement_in_statement598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedStatement_in_statement608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_storedExpressionStatement_in_statement618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_storedExpressionStatement645 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_storedExpressionStatement647 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_storedExpressionStatement649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_questionStatement676 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_questionStatement678 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_questionStatement680 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_typeDeclaration_in_questionStatement682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_typeDeclaration716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_computedStatement739 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_computedStatement741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement767 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement769 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement771 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement773 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement775 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement781 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement783 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifStatement785 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatement_in_ifStatement791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement809 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement811 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement813 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement815 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement817 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement823 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement825 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifStatement827 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement829 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement835 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement836 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement855 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement857 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement859 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement861 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement863 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement865 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred24_QL767 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred24_QL769 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_synpred24_QL771 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred24_QL773 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred24_QL775 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred24_QL781 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred24_QL783 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_synpred24_QL785 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatement_in_synpred24_QL791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred25_QL809 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred25_QL811 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_synpred25_QL813 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred25_QL815 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred25_QL817 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred25_QL823 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred25_QL825 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_synpred25_QL827 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred25_QL829 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred25_QL835 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred25_QL836 = new BitSet(new long[]{0x0000000000000002L});
}
