// $ANTLR 3.5 C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-14 17:18:33

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "Ident", 
		"Int", "SINGLE_COMMENT", "String", "WS", "'!'", "'!='", "'&&'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'||'"
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
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int SINGLE_COMMENT=8;
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
		this.state.ruleMemo = new HashMap[28+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "form"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:1: form : ( primary )+ ;
	public final void form() throws RecognitionException  {
		int form_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:5: ( ( primary )+ )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( primary )+
			{
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( primary )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Boolean||(LA1_0 >= Ident && LA1_0 <= Int)||LA1_0==String||LA1_0==14) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: primary
					{
					pushFollow(FOLLOW_primary_in_form39);
					primary();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

		}
	}
	// $ANTLR end "form"



	// $ANTLR start "primary"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:1: primary returns [Expr result] : ( Int | Ident | Boolean | String | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Token Boolean3=null;
		Token String4=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:3: ( Int | Ident | Boolean | String | '(' x= orExpr ')' )
			int alt2=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt2=1;
				}
				break;
			case Ident:
				{
				alt2=2;
				}
				break;
			case Boolean:
				{
				alt2=3;
				}
				break;
			case String:
				{
				alt2=4;
				}
				break;
			case 14:
				{
				alt2=5;
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
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary54); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary64); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: Boolean
					{
					Boolean3=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary72); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((Boolean3!=null?Boolean3.getText():null)); }
					}
					break;
				case 4 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: String
					{
					String4=(Token)match(input,String,FOLLOW_String_in_primary80); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((String4!=null?String4.getText():null)); }
					}
					break;
				case 5 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary88); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary92);
					x=orExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 2, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException  {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt3=1;
				}
				break;
			case 18:
				{
				alt3=2;
				}
				break;
			case 11:
				{
				alt3=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case String:
			case 14:
				{
				alt3=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr119); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr123);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr134); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr138);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr149); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr153);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr166);
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
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException  {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr204);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==16||LA4_0==19) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr224);
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
			if ( state.backtracking>0 ) { memoize(input, 4, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException  {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr265);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= 17 && LA5_0 <= 18)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr283);
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
			if ( state.backtracking>0 ) { memoize(input, 5, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException  {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr318);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==12||(LA6_0 >= 20 && LA6_0 <= 24)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr342);
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
			if ( state.backtracking>0 ) { memoize(input, 6, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException  {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr380);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:46: ( '&&' rhs= relExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr386); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr390);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 7, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException  {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr425);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:48: ( '||' rhs= andExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==25) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\WINNT\\profiles\\6188583\\My Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:50: '||' rhs= andExpr
					{
					match(input,25,FOLLOW_25_in_orExpr431); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr435);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 8, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_primary_in_form39 = new BitSet(new long[]{0x00000000000042D2L});
	public static final BitSet FOLLOW_Int_in_primary54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary88 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_primary92 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr119 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr134 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr149 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr204 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr212 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr224 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr265 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr273 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr283 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr318 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_set_in_relExpr326 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr342 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr380 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr386 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr390 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr425 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_orExpr431 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr435 = new BitSet(new long[]{0x0000000002000002L});
}
