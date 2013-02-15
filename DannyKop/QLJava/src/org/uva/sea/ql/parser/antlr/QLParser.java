// $ANTLR 3.5 /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-14 22:00:59

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.binary.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.parser.test.*;
import java.util.LinkedList;


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
		"Ident", "If", "Int", "SpecialChars", "Str", "WS", "'!'", "'!='", "'&&'", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", 
		"'>'", "'>='", "'boolean'", "'int'", "'string'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__34=34;
	public static final int Bool=4;
	public static final int Comment=5;
	public static final int Else=6;
	public static final int Form=7;
	public static final int Ident=8;
	public static final int If=9;
	public static final int Int=10;
	public static final int SpecialChars=11;
	public static final int Str=12;
	public static final int WS=13;

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
	@Override public String getGrammarFileName() { return "/Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }


		private List<String> errors = new LinkedList<String>();
		
		public void displayRecognitionError(String[] tokenNames, RecognitionException e) { 
	        String hdr = getErrorHeader(e);        
	        String msg = getErrorMessage(e, tokenNames);	      
		    
		    errors.add(hdr + " -- " + msg);
		       
		}
		public boolean isErrorFound(){
			return this.errors.size() != 0;
		}
		public List<String> getErrors(){
			return this.errors;
		}



	// $ANTLR start "primary"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: primary returns [Expr result] : ( Int | Ident | Bool | Str | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Ident2=null;
		Token Bool3=null;
		Token Str4=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:3: ( Int | Ident | Bool | Str | '(' x= orExpr ')' )
			int alt1=5;
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
			case 17:
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary67); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: Ident
					{
					Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_primary77); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident2!=null?Ident2.getText():null)); }
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: Bool
					{
					Bool3=(Token)match(input,Bool,FOLLOW_Bool_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral((Bool3!=null?Bool3.getText():null));}
					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: Str
					{
					Str4=(Token)match(input,Str,FOLLOW_Str_in_primary93); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrLiteral((Str4!=null?Str4.getText():null));}
					}
					break;
				case 5 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: '(' x= orExpr ')'
					{
					match(input,17,FOLLOW_17_in_primary101); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary105);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_primary107); if (state.failed) return result;
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt2=1;
				}
				break;
			case 21:
				{
				alt2=2;
				}
				break;
			case 14:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Str:
			case 17:
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr132); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr136);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr147); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr151);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:8: '!' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr162); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr166);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr179);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr217);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==19||LA3_0==22) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==19||input.LA(1)==22 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr237);
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
			if ( state.backtracking>0 ) { memoize(input, 3, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr275);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 20 && LA4_0 <= 21)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 20 && input.LA(1) <= 21) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr293);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr328);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==15||(LA5_0 >= 24 && LA5_0 <= 28)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||(input.LA(1) >= 24 && input.LA(1) <= 28) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr352);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr390);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==16) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:48: '&&' rhs= relExpr
					{
					match(input,16,FOLLOW_16_in_andExpr396); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr400);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr434);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==33) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr440); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr444);
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: form returns [Form result] : Form Ident '{' formElements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident5=null;
		ArrayList<FormElement> formElements6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: ( Form Ident '{' formElements '}' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:7: Form Ident '{' formElements '}'
			{
			match(input,Form,FOLLOW_Form_in_form470); if (state.failed) return result;
			Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_form472); if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form474); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_form476);
			formElements6=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,34,FOLLOW_34_in_form478); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(new Ident((Ident5!=null?Ident5.getText():null)), formElements6); }
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:1: formElement returns [FormElement result] : ( question | condition | computation );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Question question7 =null;
		Condition condition8 =null;
		Computation computation9 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:5: ( question | condition | computation )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Ident) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==23) ) {
					int LA8_3 = input.LA(3);
					if ( (LA8_3==Str) ) {
						switch ( input.LA(4) ) {
						case 29:
							{
							int LA8_5 = input.LA(5);
							if ( (LA8_5==EOF||(LA8_5 >= Ident && LA8_5 <= If)||LA8_5==34) ) {
								alt8=1;
							}
							else if ( (LA8_5==17) ) {
								alt8=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 31:
							{
							int LA8_6 = input.LA(5);
							if ( (LA8_6==EOF||(LA8_6 >= Ident && LA8_6 <= If)||LA8_6==34) ) {
								alt8=1;
							}
							else if ( (LA8_6==17) ) {
								alt8=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 30:
							{
							int LA8_7 = input.LA(5);
							if ( (LA8_7==EOF||(LA8_7 >= Ident && LA8_7 <= If)||LA8_7==34) ) {
								alt8=1;
							}
							else if ( (LA8_7==17) ) {
								alt8=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 7, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:7: question
					{
					pushFollow(FOLLOW_question_in_formElement497);
					question7=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question7;}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:7: condition
					{
					pushFollow(FOLLOW_condition_in_formElement507);
					condition8=condition();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = condition8;}
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:7: computation
					{
					pushFollow(FOLLOW_computation_in_formElement517);
					computation9=computation();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = computation9;}
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:1: formElements returns [ArrayList<FormElement> result] : (element= formElement )* ;
	public final ArrayList<FormElement> formElements() throws RecognitionException {
		ArrayList<FormElement> result = null;

		int formElements_StartIndex = input.index();

		FormElement element =null;

		 result = new ArrayList<FormElement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:5: ( (element= formElement )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:7: (element= formElement )*
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:7: (element= formElement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= Ident && LA9_0 <= If)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:8: element= formElement
					{
					pushFollow(FOLLOW_formElement_in_formElements554);
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



	// $ANTLR start "computation"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: computation returns [Computation result] : Ident ':' Str type '(' orExpr ')' ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token Ident10=null;
		Token Str11=null;
		Expr orExpr12 =null;
		Type type13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: ( Ident ':' Str type '(' orExpr ')' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:7: Ident ':' Str type '(' orExpr ')'
			{
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_computation578); if (state.failed) return result;
			match(input,23,FOLLOW_23_in_computation580); if (state.failed) return result;
			Str11=(Token)match(input,Str,FOLLOW_Str_in_computation582); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_computation584);
			type13=type();
			state._fsp--;
			if (state.failed) return result;
			match(input,17,FOLLOW_17_in_computation586); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation588);
			orExpr12=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_computation590); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computation(new Ident((Ident10!=null?Ident10.getText():null)), new StrLiteral((Str11!=null?Str11.getText():null)), orExpr12, type13); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"



	// $ANTLR start "question"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:1: question returns [Question result] : Ident ':' Str type ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident14=null;
		Token Str15=null;
		Type type16 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:5: ( Ident ':' Str type )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:7: Ident ':' Str type
			{
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_question613); if (state.failed) return result;
			match(input,23,FOLLOW_23_in_question615); if (state.failed) return result;
			Str15=(Token)match(input,Str,FOLLOW_Str_in_question617); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question619);
			type16=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident14!=null?Ident14.getText():null)), new StrLiteral((Str15!=null?Str15.getText():null)), type16); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "condition"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:1: condition returns [Condition result] : ( If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}' | If '(' orExpr ')' '{' formElements '}' );
	public final Condition condition() throws RecognitionException {
		Condition result = null;

		int condition_StartIndex = input.index();

		ArrayList<FormElement> ifElems =null;
		ArrayList<FormElement> elseElems =null;
		Expr orExpr17 =null;
		Expr orExpr18 =null;
		ArrayList<FormElement> formElements19 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:5: ( If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}' | If '(' orExpr ')' '{' formElements '}' )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==If) ) {
				int LA10_1 = input.LA(2);
				if ( (synpred23_QL()) ) {
					alt10=1;
				}
				else if ( (true) ) {
					alt10=2;
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:7: If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}'
					{
					match(input,If,FOLLOW_If_in_condition641); if (state.failed) return result;
					match(input,17,FOLLOW_17_in_condition643); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_condition645);
					orExpr17=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_condition647); if (state.failed) return result;
					match(input,32,FOLLOW_32_in_condition649); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_condition655);
					ifElems=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,34,FOLLOW_34_in_condition657); if (state.failed) return result;
					match(input,Else,FOLLOW_Else_in_condition659); if (state.failed) return result;
					match(input,32,FOLLOW_32_in_condition661); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_condition667);
					elseElems=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,34,FOLLOW_34_in_condition669); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Condition(orExpr17, ifElems, elseElems);}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:135:7: If '(' orExpr ')' '{' formElements '}'
					{
					match(input,If,FOLLOW_If_in_condition679); if (state.failed) return result;
					match(input,17,FOLLOW_17_in_condition681); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_condition683);
					orExpr18=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_condition685); if (state.failed) return result;
					match(input,32,FOLLOW_32_in_condition687); if (state.failed) return result;
					pushFollow(FOLLOW_formElements_in_condition689);
					formElements19=formElements();
					state._fsp--;
					if (state.failed) return result;
					match(input,34,FOLLOW_34_in_condition691); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Condition(orExpr18, formElements19); }
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
			if ( state.backtracking>0 ) { memoize(input, 13, condition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "condition"



	// $ANTLR start "type"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:138:1: type returns [Type result] : ( 'boolean' | 'string' | 'int' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:139:5: ( 'boolean' | 'string' | 'int' )
			int alt11=3;
			switch ( input.LA(1) ) {
			case 29:
				{
				alt11=1;
				}
				break;
			case 31:
				{
				alt11=2;
				}
				break;
			case 30:
				{
				alt11=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:139:7: 'boolean'
					{
					match(input,29,FOLLOW_29_in_type714); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BoolType();}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:7: 'string'
					{
					match(input,31,FOLLOW_31_in_type724); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new StrType();}
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:7: 'int'
					{
					match(input,30,FOLLOW_30_in_type735); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new IntType();}
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
			if ( state.backtracking>0 ) { memoize(input, 14, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"

	// $ANTLR start synpred23_QL
	public final void synpred23_QL_fragment() throws RecognitionException {
		ArrayList<FormElement> ifElems =null;
		ArrayList<FormElement> elseElems =null;

		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:7: ( If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}' )
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:7: If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}'
		{
		match(input,If,FOLLOW_If_in_synpred23_QL641); if (state.failed) return;
		match(input,17,FOLLOW_17_in_synpred23_QL643); if (state.failed) return;
		pushFollow(FOLLOW_orExpr_in_synpred23_QL645);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		match(input,18,FOLLOW_18_in_synpred23_QL647); if (state.failed) return;
		match(input,32,FOLLOW_32_in_synpred23_QL649); if (state.failed) return;
		pushFollow(FOLLOW_formElements_in_synpred23_QL655);
		ifElems=formElements();
		state._fsp--;
		if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred23_QL657); if (state.failed) return;
		match(input,Else,FOLLOW_Else_in_synpred23_QL659); if (state.failed) return;
		match(input,32,FOLLOW_32_in_synpred23_QL661); if (state.failed) return;
		pushFollow(FOLLOW_formElements_in_synpred23_QL667);
		elseElems=formElements();
		state._fsp--;
		if (state.failed) return;
		match(input,34,FOLLOW_34_in_synpred23_QL669); if (state.failed) return;
		}

	}
	// $ANTLR end synpred23_QL

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



	public static final BitSet FOLLOW_Int_in_primary67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_primary93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primary101 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_primary105 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primary107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr132 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr147 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr162 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_unExpr_in_unExpr166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr217 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr225 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr237 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr275 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr283 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr293 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr328 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_set_in_relExpr336 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_addExpr_in_relExpr352 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr390 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_andExpr396 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_relExpr_in_andExpr400 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr434 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr440 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_andExpr_in_orExpr444 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_Form_in_form470 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form472 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form474 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_form476 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_form478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_formElement507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_formElement517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formElements554 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_Ident_in_computation578 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_computation580 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Str_in_computation582 = new BitSet(new long[]{0x00000000E0000000L});
	public static final BitSet FOLLOW_type_in_computation584 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_computation586 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_computation588 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_computation590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question613 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_question615 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Str_in_question617 = new BitSet(new long[]{0x00000000E0000000L});
	public static final BitSet FOLLOW_type_in_question619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_condition641 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_condition643 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_condition645 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_condition647 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_condition649 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_condition655 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_condition657 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Else_in_condition659 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_condition661 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_condition667 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_condition669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_condition679 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_condition681 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_condition683 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_condition685 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_condition687 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_condition689 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_condition691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_type714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_type735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_synpred23_QL641 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_synpred23_QL643 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_synpred23_QL645 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_synpred23_QL647 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_synpred23_QL649 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_synpred23_QL655 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred23_QL657 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Else_in_synpred23_QL659 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_synpred23_QL661 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_synpred23_QL667 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_synpred23_QL669 = new BitSet(new long[]{0x0000000000000002L});
}
