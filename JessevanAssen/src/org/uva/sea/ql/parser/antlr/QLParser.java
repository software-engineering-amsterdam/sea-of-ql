// $ANTLR 3.5 C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-14 15:42:12

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;


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
		"'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'else'", 
		"'form'", "'if'", "'{'", "'||'", "'}'"
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
		this.state.ruleMemo = new HashMap[39+1];


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
				if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 26)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
				if ( (LA7_0==31) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:50: '||' rhs= andExpr
					{
					match(input,31,FOLLOW_31_in_orExpr475); if (state.failed) return result;
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: form returns [Form result] : 'form' Ident '{' formElements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident6=null;
		FormElement formElements7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: ( 'form' Ident '{' formElements '}' )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:7: 'form' Ident '{' formElements '}'
			{
			match(input,28,FOLLOW_28_in_form505); if (state.failed) return result;
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_form507); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form509); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_form511);
			formElements7=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form513); if (state.failed) return result;
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: formElements returns [FormElement result] : ( formElement )* ;
	public final FormElement formElements() throws RecognitionException {
		FormElement result = null;

		int formElements_StartIndex = input.index();

		FormElement formElement8 =null;


		        ArrayList<FormElement> formElements = new ArrayList<FormElement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:5: ( ( formElement )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( formElement )*
			{
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:7: ( formElement )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==Str||LA8_0==29) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:8: formElement
					{
					pushFollow(FOLLOW_formElement_in_formElements559);
					formElement8=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { formElements.add(formElement8); }
					}
					break;

				default :
					break loop8;
				}
			}

			}

			if ( state.backtracking==0 ) {
			        if(formElements.isEmpty())
			            result = new NullFormElement();
			        else if(formElements.size() == 1)
			            result = formElements.get(0);
			        else
			            result = new CompositeFormElement(formElements);
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



	// $ANTLR start "formElement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:1: formElement returns [FormElement result] : ( ifFormElement | questionFormElement | computedFormElement );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		If ifFormElement9 =null;
		Question questionFormElement10 =null;
		Computed computedFormElement11 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:5: ( ifFormElement | questionFormElement | computedFormElement )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==29) ) {
				alt9=1;
			}
			else if ( (LA9_0==Str) ) {
				int LA9_2 = input.LA(2);
				if ( (LA9_2==Ident) ) {
					int LA9_3 = input.LA(3);
					if ( (LA9_3==21) ) {
						alt9=2;
					}
					else if ( (LA9_3==EOF||LA9_3==Str||(LA9_3 >= 13 && LA9_3 <= 14)||(LA9_3 >= 17 && LA9_3 <= 20)||(LA9_3 >= 22 && LA9_3 <= 26)||LA9_3==29||(LA9_3 >= 31 && LA9_3 <= 32)) ) {
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
								new NoViableAltException("", 9, 3, input);
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

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:7: ifFormElement
					{
					pushFollow(FOLLOW_ifFormElement_in_formElement588);
					ifFormElement9=ifFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifFormElement9; }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:7: questionFormElement
					{
					pushFollow(FOLLOW_questionFormElement_in_formElement598);
					questionFormElement10=questionFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = questionFormElement10; }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:7: computedFormElement
					{
					pushFollow(FOLLOW_computedFormElement_in_formElement608);
					computedFormElement11=computedFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedFormElement11; }
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
			if ( state.backtracking>0 ) { memoize(input, 11, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "questionFormElement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:1: questionFormElement returns [Question result] : strExpr Ident ':' typeDeclaration ;
	public final Question questionFormElement() throws RecognitionException {
		Question result = null;

		int questionFormElement_StartIndex = input.index();

		Token Ident13=null;
		org.uva.sea.ql.ast.expr.value.Str strExpr12 =null;
		Type typeDeclaration14 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:5: ( strExpr Ident ':' typeDeclaration )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:123:7: strExpr Ident ':' typeDeclaration
			{
			pushFollow(FOLLOW_strExpr_in_questionFormElement635);
			strExpr12=strExpr();
			state._fsp--;
			if (state.failed) return result;
			Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_questionFormElement637); if (state.failed) return result;
			match(input,21,FOLLOW_21_in_questionFormElement639); if (state.failed) return result;
			pushFollow(FOLLOW_typeDeclaration_in_questionFormElement641);
			typeDeclaration14=typeDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Question(strExpr12.getValue(), new Declaration(new Ident((Ident13!=null?Ident13.getText():null)), typeDeclaration14)); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, questionFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionFormElement"



	// $ANTLR start "typeDeclaration"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:1: typeDeclaration returns [Type result] : Type ;
	public final Type typeDeclaration() throws RecognitionException {
		Type result = null;

		int typeDeclaration_StartIndex = input.index();

		Token Type15=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:5: ( Type )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:7: Type
			{
			Type15=(Token)match(input,Type,FOLLOW_Type_in_typeDeclaration675); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			        if((Type15!=null?Type15.getText():null).equals("boolean"))
			          result = new org.uva.sea.ql.ast.type.Bool();
			        else if((Type15!=null?Type15.getText():null).equals("integer"))
			          result = new org.uva.sea.ql.ast.type.Int();
			        else if((Type15!=null?Type15.getText():null).equals("string"))
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
			if ( state.backtracking>0 ) { memoize(input, 13, typeDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "typeDeclaration"



	// $ANTLR start "computedFormElement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:139:1: computedFormElement returns [Computed result] : strExpr orExpr ;
	public final Computed computedFormElement() throws RecognitionException {
		Computed result = null;

		int computedFormElement_StartIndex = input.index();

		org.uva.sea.ql.ast.expr.value.Str strExpr16 =null;
		Expr orExpr17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:5: ( strExpr orExpr )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:140:7: strExpr orExpr
			{
			pushFollow(FOLLOW_strExpr_in_computedFormElement698);
			strExpr16=strExpr();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedFormElement700);
			orExpr17=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computed(strExpr16.getValue(), orExpr17); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, computedFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedFormElement"



	// $ANTLR start "ifFormElement"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:1: ifFormElement returns [If result] : ( 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' elseElement= ifFormElement | 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' '{' elseElements= formElements '}' | 'if' '(' orExpr ')' '{' formElements '}' );
	public final If ifFormElement() throws RecognitionException {
		If result = null;

		int ifFormElement_StartIndex = input.index();

		FormElement ifElements =null;
		If elseElement =null;
		FormElement elseElements =null;
		Expr orExpr18 =null;
		Expr orExpr19 =null;
		Expr orExpr20 =null;
		FormElement formElements21 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:5: ( 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' elseElement= ifFormElement | 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' '{' elseElements= formElements '}' | 'if' '(' orExpr ')' '{' formElements '}' )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==29) ) {
				int LA10_1 = input.LA(2);
				if ( (synpred23_QL()) ) {
					alt10=1;
				}
				else if ( (synpred24_QL()) ) {
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:7: 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' elseElement= ifFormElement
					{
					match(input,29,FOLLOW_29_in_ifFormElement726); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifFormElement728); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifFormElement730);
					orExpr18=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifFormElement732); if (state.failed) return result;
					match(input,30,FOLLOW_30_in_ifFormElement734); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_ifFormElement740);
					ifElements=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_ifFormElement742); if (state.failed) return result;
					match(input,27,FOLLOW_27_in_ifFormElement744); if (state.failed) return result;
					pushFollow(FOLLOW_ifFormElement_in_ifFormElement750);
					elseElement=ifFormElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new If(orExpr18, ifElements, elseElement); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:7: 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' '{' elseElements= formElements '}'
					{
					match(input,29,FOLLOW_29_in_ifFormElement769); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifFormElement771); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifFormElement773);
					orExpr19=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifFormElement775); if (state.failed) return result;
					match(input,30,FOLLOW_30_in_ifFormElement777); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_ifFormElement783);
					ifElements=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_ifFormElement785); if (state.failed) return result;
					match(input,27,FOLLOW_27_in_ifFormElement787); if (state.failed) return result;
					match(input,30,FOLLOW_30_in_ifFormElement789); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_ifFormElement795);
					elseElements=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_ifFormElement796); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new If(orExpr19, ifElements, elseElements); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:7: 'if' '(' orExpr ')' '{' formElements '}'
					{
					match(input,29,FOLLOW_29_in_ifFormElement815); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifFormElement817); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_ifFormElement819);
					orExpr20=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifFormElement821); if (state.failed) return result;
					match(input,30,FOLLOW_30_in_ifFormElement823); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_ifFormElement825);
					formElements21=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_ifFormElement827); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new If(orExpr20, formElements21, new NullFormElement()); }
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
			if ( state.backtracking>0 ) { memoize(input, 15, ifFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifFormElement"

	// $ANTLR start synpred23_QL
	public final void synpred23_QL_fragment() throws RecognitionException {
		FormElement ifElements =null;
		If elseElement =null;

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:7: ( 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' elseElement= ifFormElement )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:7: 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' elseElement= ifFormElement
		{
		match(input,29,FOLLOW_29_in_synpred23_QL726); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred23_QL728); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred23_QL730);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred23_QL732); if (state.failed) return;
		match(input,30,FOLLOW_30_in_synpred23_QL734); if (state.failed) return;
		pushFollow(FOLLOW_formElements_in_synpred23_QL740);
		ifElements=formElements();
		state._fsp--;
		if (state.failed) return;
		match(input,32,FOLLOW_32_in_synpred23_QL742); if (state.failed) return;
		match(input,27,FOLLOW_27_in_synpred23_QL744); if (state.failed) return;
		pushFollow(FOLLOW_ifFormElement_in_synpred23_QL750);
		elseElement=ifFormElement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred23_QL

	// $ANTLR start synpred24_QL
	public final void synpred24_QL_fragment() throws RecognitionException {
		FormElement ifElements =null;
		FormElement elseElements =null;

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:7: ( 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' '{' elseElements= formElements '}' )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:7: 'if' '(' orExpr ')' '{' ifElements= formElements '}' 'else' '{' elseElements= formElements '}'
		{
		match(input,29,FOLLOW_29_in_synpred24_QL769); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred24_QL771); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred24_QL773);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred24_QL775); if (state.failed) return;
		match(input,30,FOLLOW_30_in_synpred24_QL777); if (state.failed) return;
		pushFollow(FOLLOW_formElements_in_synpred24_QL783);
		ifElements=formElements();
		state._fsp--;
		if (state.failed) return;
		match(input,32,FOLLOW_32_in_synpred24_QL785); if (state.failed) return;
		match(input,27,FOLLOW_27_in_synpred24_QL787); if (state.failed) return;
		match(input,30,FOLLOW_30_in_synpred24_QL789); if (state.failed) return;
		pushFollow(FOLLOW_formElements_in_synpred24_QL795);
		elseElements=formElements();
		state._fsp--;
		if (state.failed) return;
		match(input,32,FOLLOW_32_in_synpred24_QL796); if (state.failed) return;
		}

	}
	// $ANTLR end synpred24_QL

	// Delegated rules

	public final boolean synpred23_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred23_QL_fragment(); // can never throw exception
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
	public static final BitSet FOLLOW_addExpr_in_relExpr362 = new BitSet(new long[]{0x0000000007C02002L});
	public static final BitSet FOLLOW_set_in_relExpr370 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr386 = new BitSet(new long[]{0x0000000007C02002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr424 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr430 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr434 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr469 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr475 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr479 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_28_in_form505 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form507 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form509 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_form511 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formElements559 = new BitSet(new long[]{0x0000000020000202L});
	public static final BitSet FOLLOW_ifFormElement_in_formElement588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionFormElement_in_formElement598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedFormElement_in_formElement608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_questionFormElement635 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_questionFormElement637 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_questionFormElement639 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_typeDeclaration_in_questionFormElement641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_typeDeclaration675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpr_in_computedFormElement698 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_computedFormElement700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifFormElement726 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifFormElement728 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifFormElement730 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifFormElement732 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifFormElement734 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_ifFormElement740 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifFormElement742 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifFormElement744 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_ifFormElement_in_ifFormElement750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifFormElement769 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifFormElement771 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifFormElement773 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifFormElement775 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifFormElement777 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_ifFormElement783 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifFormElement785 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_ifFormElement787 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifFormElement789 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_ifFormElement795 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifFormElement796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifFormElement815 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifFormElement817 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_ifFormElement819 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifFormElement821 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifFormElement823 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_ifFormElement825 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifFormElement827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_synpred23_QL726 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred23_QL728 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_synpred23_QL730 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred23_QL732 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_synpred23_QL734 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_synpred23_QL740 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_synpred23_QL742 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_synpred23_QL744 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_ifFormElement_in_synpred23_QL750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_synpred24_QL769 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred24_QL771 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpr_in_synpred24_QL773 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred24_QL775 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_synpred24_QL777 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_synpred24_QL783 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_synpred24_QL785 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_synpred24_QL787 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_synpred24_QL789 = new BitSet(new long[]{0x0000000120000200L});
	public static final BitSet FOLLOW_formElements_in_synpred24_QL795 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_synpred24_QL796 = new BitSet(new long[]{0x0000000000000002L});
}
