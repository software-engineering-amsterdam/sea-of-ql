// $ANTLR 3.5 C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-02 22:01:55

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
	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "primary"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int1=null;
		Token Ident2=null;
		Expr x =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:3: ( Int | Ident | '(' x= orExpr ')' )
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary44); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary54); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:5: '(' x= orExpr ')'
					{
					match(input,11,FOLLOW_11_in_primary62); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary66);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,12,FOLLOW_12_in_primary68); if (state.failed) return result;
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
		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:8: '+' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr93); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr97);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:8: '-' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr108); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr112);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:8: '!' x= unExpr
					{
					match(input,8,FOLLOW_8_in_unExpr123); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr127);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr140);
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
		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr178);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==13||LA3_0==16) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr198);
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
		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr239);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 14 && LA4_0 <= 15)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr257);
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
		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr292);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==9||(LA5_0 >= 17 && LA5_0 <= 21)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr316);
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
		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr354);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==10) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:48: '&&' rhs= relExpr
					{
					match(input,10,FOLLOW_10_in_andExpr360); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr364);
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr399);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==22) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:50: '||' rhs= andExpr
					{
					match(input,22,FOLLOW_22_in_orExpr405); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr409);
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
		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_primary62 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_orExpr_in_primary66 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_primary68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr93 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr108 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_unExpr123 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_unExpr127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr178 = new BitSet(new long[]{0x0000000000012002L});
	public static final BitSet FOLLOW_set_in_mulExpr186 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr198 = new BitSet(new long[]{0x0000000000012002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr239 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_set_in_addExpr247 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr257 = new BitSet(new long[]{0x000000000000C002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr292 = new BitSet(new long[]{0x00000000003E0202L});
	public static final BitSet FOLLOW_set_in_relExpr300 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_addExpr_in_relExpr316 = new BitSet(new long[]{0x00000000003E0202L});
	public static final BitSet FOLLOW_relExpr_in_andExpr354 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_andExpr360 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_relExpr_in_andExpr364 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_andExpr_in_orExpr399 = new BitSet(new long[]{0x0000000000400002L});
	public static final BitSet FOLLOW_22_in_orExpr405 = new BitSet(new long[]{0x000000000000C960L});
	public static final BitSet FOLLOW_andExpr_in_orExpr409 = new BitSet(new long[]{0x0000000000400002L});
}
