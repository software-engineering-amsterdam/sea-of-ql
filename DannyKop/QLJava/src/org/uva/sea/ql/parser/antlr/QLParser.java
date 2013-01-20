// $ANTLR 3.5 /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 19:15:29

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.form.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Comment", "Else", "Form", 
		"Ident", "If", "Int", "LeftBrace", "Money", "Newline", "RightBrace", "SpecialChars", 
		"Str", "Vars", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__34=34;
	public static final int Bool=4;
	public static final int Comment=5;
	public static final int Else=6;
	public static final int Form=7;
	public static final int Ident=8;
	public static final int If=9;
	public static final int Int=10;
	public static final int LeftBrace=11;
	public static final int Money=12;
	public static final int Newline=13;
	public static final int RightBrace=14;
	public static final int SpecialChars=15;
	public static final int Str=16;
	public static final int Vars=17;
	public static final int WS=18;

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
		this.state.ruleMemo = new HashMap[37+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "primary"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: primary returns [Expr result] : ( Int | Ident | Bool | Str | Money | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Token Bool3=null;
		Token Str4=null;
		Token Money5=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:3: ( Int | Ident | Bool | Str | Money | '(' x= orExpr ')' )
			int alt1=6;
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
			case Bool:
				{
				alt1=3;
				}
				break;
			case Str:
				{
				alt1=4;
				}
				break;
			case Money:
				{
				alt1=5;
				}
				break;
			case 22:
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary62); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary72); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: Bool
					{
					Bool3=(Token)match(input,Bool,FOLLOW_Bool_in_primary80); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((Bool3!=null?Bool3.getText():null));}
					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:5: Str
					{
					Str4=(Token)match(input,Str,FOLLOW_Str_in_primary88); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((Str4!=null?Str4.getText():null));}
					}
					break;
				case 5 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:5: Money
					{
					Money5=(Token)match(input,Money,FOLLOW_Money_in_primary96); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((Money5!=null?Money5.getText():null)); }
					}
					break;
				case 6 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: '(' x= orExpr ')'
					{
					match(input,22,FOLLOW_22_in_primary104); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary108);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,23,FOLLOW_23_in_primary110); if (state.failed) return result;
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 25:
				{
				alt2=1;
				}
				break;
			case 26:
				{
				alt2=2;
				}
				break;
			case 19:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Money:
			case Str:
			case 22:
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:8: '+' x= unExpr
					{
					match(input,25,FOLLOW_25_in_unExpr135); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr139);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:8: '-' x= unExpr
					{
					match(input,26,FOLLOW_26_in_unExpr150); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr154);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:8: '!' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr165); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr169);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr182);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr220);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==24||LA3_0==27) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==24||input.LA(1)==27 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr240);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr281);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 25 && LA4_0 <= 26)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 25 && input.LA(1) <= 26) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr299);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr334);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==20||(LA5_0 >= 29 && LA5_0 <= 33)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==20||(input.LA(1) >= 29 && input.LA(1) <= 33) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr358);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr396);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==21) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:48: '&&' rhs= relExpr
					{
					match(input,21,FOLLOW_21_in_andExpr402); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr406);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr441);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==34) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:50: '||' rhs= andExpr
					{
					match(input,34,FOLLOW_34_in_orExpr447); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr451);
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



	// $ANTLR start "form"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: form returns [Form result] : Form Ident LeftBrace formElements RightBrace ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident6=null;
		ArrayList<FormElement> formElements7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: ( Form Ident LeftBrace formElements RightBrace )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:7: Form Ident LeftBrace formElements RightBrace
			{
			match(input,Form,FOLLOW_Form_in_form477); if (state.failed) return result;
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_form479); if (state.failed) return result;
			match(input,LeftBrace,FOLLOW_LeftBrace_in_form481); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_form483);
			formElements7=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,RightBrace,FOLLOW_RightBrace_in_form485); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(new Ident((Ident6!=null?Ident6.getText():null)), formElements7); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "formElement"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: formElement returns [FormElement result] : ( question | condition );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Question question8 =null;
		Condition condition9 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: ( question | condition )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Ident) ) {
				alt8=1;
			}
			else if ( (LA8_0==If) ) {
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:7: question
					{
					pushFollow(FOLLOW_question_in_formElement504);
					question8=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question8;}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:7: condition
					{
					pushFollow(FOLLOW_condition_in_formElement514);
					condition9=condition();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = condition9;}
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
			if ( state.backtracking>0 ) { memoize(input, 9, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "formElements"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:1: formElements returns [ArrayList<FormElement> result] : (element= formElement )* ;
	public final ArrayList<FormElement> formElements() throws RecognitionException {
		ArrayList<FormElement> result = null;

		int formElements_StartIndex = input.index();

		FormElement element =null;

		 result = new ArrayList<FormElement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: ( (element= formElement )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:7: (element= formElement )*
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:7: (element= formElement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= Ident && LA9_0 <= If)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:8: element= formElement
					{
					pushFollow(FOLLOW_formElement_in_formElements551);
					element=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(element);}
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
			if ( state.backtracking>0 ) { memoize(input, 10, formElements_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElements"



	// $ANTLR start "question"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: question returns [Question result] : Ident ':' Str Vars ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident10=null;
		Token Str11=null;
		Token Vars12=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: ( Ident ':' Str Vars )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:7: Ident ':' Str Vars
			{
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_question577); if (state.failed) return result;
			match(input,28,FOLLOW_28_in_question579); if (state.failed) return result;
			Str11=(Token)match(input,Str,FOLLOW_Str_in_question581); if (state.failed) return result;
			Vars12=(Token)match(input,Vars,FOLLOW_Vars_in_question583); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident10!=null?Ident10.getText():null)), (Str11!=null?Str11.getText():null), (Vars12!=null?Vars12.getText():null)); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "condition"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: condition returns [Condition result] : If '(' orExpr ')' LeftBrace ( question | condition )* RightBrace ;
	public final Condition condition() throws RecognitionException {
		Condition result = null;

		int condition_StartIndex = input.index();

		Expr orExpr13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: ( If '(' orExpr ')' LeftBrace ( question | condition )* RightBrace )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:7: If '(' orExpr ')' LeftBrace ( question | condition )* RightBrace
			{
			match(input,If,FOLLOW_If_in_condition606); if (state.failed) return result;
			match(input,22,FOLLOW_22_in_condition608); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_condition610);
			orExpr13=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,23,FOLLOW_23_in_condition612); if (state.failed) return result;
			match(input,LeftBrace,FOLLOW_LeftBrace_in_condition614); if (state.failed) return result;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:35: ( question | condition )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Ident) ) {
					alt10=1;
				}
				else if ( (LA10_0==If) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:36: question
					{
					pushFollow(FOLLOW_question_in_condition617);
					question();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:47: condition
					{
					pushFollow(FOLLOW_condition_in_condition621);
					condition();
					state._fsp--;
					if (state.failed) return result;
					}
					break;

				default :
					break loop10;
				}
			}

			match(input,RightBrace,FOLLOW_RightBrace_in_condition625); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Condition(orExpr13); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, condition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "condition"



	// $ANTLR start "computation"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: computation returns [Computation result] : Ident ':' Str '(' orExpr ')' ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token Ident14=null;
		Token Str15=null;
		Expr orExpr16 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: ( Ident ':' Str '(' orExpr ')' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:7: Ident ':' Str '(' orExpr ')'
			{
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_computation652); if (state.failed) return result;
			match(input,28,FOLLOW_28_in_computation655); if (state.failed) return result;
			Str15=(Token)match(input,Str,FOLLOW_Str_in_computation657); if (state.failed) return result;
			match(input,22,FOLLOW_22_in_computation659); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation661);
			orExpr16=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,23,FOLLOW_23_in_computation663); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computation(new Ident((Ident14!=null?Ident14.getText():null)), (Str15!=null?Str15.getText():null), orExpr16 ); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"

	// Delegated rules



	public static final BitSet FOLLOW_Int_in_primary62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_primary88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_primary104 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_orExpr_in_primary108 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_primary110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpr135 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_unExpr150 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr165 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr220 = new BitSet(new long[]{0x0000000009000002L});
	public static final BitSet FOLLOW_set_in_mulExpr228 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr240 = new BitSet(new long[]{0x0000000009000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr281 = new BitSet(new long[]{0x0000000006000002L});
	public static final BitSet FOLLOW_set_in_addExpr289 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr299 = new BitSet(new long[]{0x0000000006000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr334 = new BitSet(new long[]{0x00000003E0100002L});
	public static final BitSet FOLLOW_set_in_relExpr342 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_addExpr_in_relExpr358 = new BitSet(new long[]{0x00000003E0100002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr396 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_21_in_andExpr402 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_relExpr_in_andExpr406 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr441 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_orExpr447 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_andExpr_in_orExpr451 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_Form_in_form477 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form479 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LeftBrace_in_form481 = new BitSet(new long[]{0x0000000000004300L});
	public static final BitSet FOLLOW_formElements_in_form483 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_RightBrace_in_form485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_formElement514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formElements551 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_Ident_in_question577 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_question579 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_Str_in_question581 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_Vars_in_question583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_condition606 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_condition608 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_orExpr_in_condition610 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_condition612 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LeftBrace_in_condition614 = new BitSet(new long[]{0x0000000000004300L});
	public static final BitSet FOLLOW_question_in_condition617 = new BitSet(new long[]{0x0000000000004300L});
	public static final BitSet FOLLOW_condition_in_condition621 = new BitSet(new long[]{0x0000000000004300L});
	public static final BitSet FOLLOW_RightBrace_in_condition625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computation652 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_computation655 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_Str_in_computation657 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_computation659 = new BitSet(new long[]{0x0000000006491510L});
	public static final BitSet FOLLOW_orExpr_in_computation661 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_computation663 = new BitSet(new long[]{0x0000000000000002L});
}
