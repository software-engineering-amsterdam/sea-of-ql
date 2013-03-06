// $ANTLR 3.5 /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-16 16:00:48

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
		this.state.ruleMemo = new HashMap[40+1];


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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:1: formElement returns [FormElement result] : ( ifThenElse | ifThen | computation | question );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		IfThenElse ifThenElse7 =null;
		IfThen ifThen8 =null;
		Computation computation9 =null;
		Question question10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:5: ( ifThenElse | ifThen | computation | question )
			int alt8=4;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==If) ) {
				int LA8_1 = input.LA(2);
				if ( (synpred20_QL()) ) {
					alt8=1;
				}
				else if ( (synpred21_QL()) ) {
					alt8=2;
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
			else if ( (LA8_0==Ident) ) {
				int LA8_2 = input.LA(2);
				if ( (synpred22_QL()) ) {
					alt8=3;
				}
				else if ( (true) ) {
					alt8=4;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:7: ifThenElse
					{
					pushFollow(FOLLOW_ifThenElse_in_formElement497);
					ifThenElse7=ifThenElse();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifThenElse7;}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:7: ifThen
					{
					pushFollow(FOLLOW_ifThen_in_formElement507);
					ifThen8=ifThen();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifThen8;}
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
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:7: question
					{
					pushFollow(FOLLOW_question_in_formElement527);
					question10=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question10;}
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
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:1: formElements returns [ArrayList<FormElement> result] : (element= formElement )* ;
	public final ArrayList<FormElement> formElements() throws RecognitionException {
		ArrayList<FormElement> result = null;

		int formElements_StartIndex = input.index();

		FormElement element =null;

		 result = new ArrayList<FormElement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: ( (element= formElement )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:7: (element= formElement )*
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:7: (element= formElement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= Ident && LA9_0 <= If)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:8: element= formElement
					{
					pushFollow(FOLLOW_formElement_in_formElements564);
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



	// $ANTLR start "ifThen"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:1: ifThen returns [IfThen result] : If '(' orExpr ')' '{' formElements '}' ;
	public final IfThen ifThen() throws RecognitionException {
		IfThen result = null;

		int ifThen_StartIndex = input.index();

		Expr orExpr11 =null;
		ArrayList<FormElement> formElements12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:5: ( If '(' orExpr ')' '{' formElements '}' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:8: If '(' orExpr ')' '{' formElements '}'
			{
			match(input,If,FOLLOW_If_in_ifThen589); if (state.failed) return result;
			match(input,17,FOLLOW_17_in_ifThen591); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifThen593);
			orExpr11=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_ifThen595); if (state.failed) return result;
			match(input,32,FOLLOW_32_in_ifThen597); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_ifThen599);
			formElements12=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,34,FOLLOW_34_in_ifThen601); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new IfThen(orExpr11, formElements12); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, ifThen_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifThen"



	// $ANTLR start "ifThenElse"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:1: ifThenElse returns [IfThenElse result] : If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}' ;
	public final IfThenElse ifThenElse() throws RecognitionException {
		IfThenElse result = null;

		int ifThenElse_StartIndex = input.index();

		ArrayList<FormElement> ifElems =null;
		ArrayList<FormElement> elseElems =null;
		Expr orExpr13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: ( If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:7: If '(' orExpr ')' '{' ifElems= formElements '}' Else '{' elseElems= formElements '}'
			{
			match(input,If,FOLLOW_If_in_ifThenElse623); if (state.failed) return result;
			match(input,17,FOLLOW_17_in_ifThenElse625); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifThenElse627);
			orExpr13=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_ifThenElse629); if (state.failed) return result;
			match(input,32,FOLLOW_32_in_ifThenElse631); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_ifThenElse637);
			ifElems=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,34,FOLLOW_34_in_ifThenElse639); if (state.failed) return result;
			match(input,Else,FOLLOW_Else_in_ifThenElse641); if (state.failed) return result;
			match(input,32,FOLLOW_32_in_ifThenElse643); if (state.failed) return result;
			pushFollow(FOLLOW_formElements_in_ifThenElse649);
			elseElems=formElements();
			state._fsp--;
			if (state.failed) return result;
			match(input,34,FOLLOW_34_in_ifThenElse651); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new IfThenElse(orExpr13, ifElems, elseElems);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, ifThenElse_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifThenElse"



	// $ANTLR start "computation"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:1: computation returns [Computation result] : Ident ':' Str type '(' orExpr ')' ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token Ident14=null;
		Token Str15=null;
		Expr orExpr16 =null;
		Type type17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:135:5: ( Ident ':' Str type '(' orExpr ')' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:135:7: Ident ':' Str type '(' orExpr ')'
			{
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_computation673); if (state.failed) return result;
			match(input,23,FOLLOW_23_in_computation675); if (state.failed) return result;
			Str15=(Token)match(input,Str,FOLLOW_Str_in_computation677); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_computation679);
			type17=type();
			state._fsp--;
			if (state.failed) return result;
			match(input,17,FOLLOW_17_in_computation681); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation683);
			orExpr16=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_computation685); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computation(new Ident((Ident14!=null?Ident14.getText():null)), new StrLiteral((Str15!=null?Str15.getText():null)), orExpr16, type17); }
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



	// $ANTLR start "question"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:137:1: question returns [Question result] : Ident ':' Str type ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident18=null;
		Token Str19=null;
		Type type20 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:138:5: ( Ident ':' Str type )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:138:7: Ident ':' Str type
			{
			Ident18=(Token)match(input,Ident,FOLLOW_Ident_in_question708); if (state.failed) return result;
			match(input,23,FOLLOW_23_in_question710); if (state.failed) return result;
			Str19=(Token)match(input,Str,FOLLOW_Str_in_question712); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question714);
			type20=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident18!=null?Ident18.getText():null)), new StrLiteral((Str19!=null?Str19.getText():null)), type20); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "type"
	// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:1: type returns [Type result] : ( 'boolean' | 'string' | 'int' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:5: ( 'boolean' | 'string' | 'int' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case 29:
				{
				alt10=1;
				}
				break;
			case 31:
				{
				alt10=2;
				}
				break;
			case 30:
				{
				alt10=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:141:7: 'boolean'
					{
					match(input,29,FOLLOW_29_in_type736); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BoolType();}
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:142:7: 'string'
					{
					match(input,31,FOLLOW_31_in_type746); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new StrType();}
					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:143:7: 'int'
					{
					match(input,30,FOLLOW_30_in_type757); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 15, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"

	// $ANTLR start synpred20_QL
	public final void synpred20_QL_fragment() throws RecognitionException {
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:7: ( ifThenElse )
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:7: ifThenElse
		{
		pushFollow(FOLLOW_ifThenElse_in_synpred20_QL497);
		ifThenElse();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred20_QL

	// $ANTLR start synpred21_QL
	public final void synpred21_QL_fragment() throws RecognitionException {
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:7: ( ifThen )
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:7: ifThen
		{
		pushFollow(FOLLOW_ifThen_in_synpred21_QL507);
		ifThen();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred21_QL

	// $ANTLR start synpred22_QL
	public final void synpred22_QL_fragment() throws RecognitionException {
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:7: ( computation )
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:7: computation
		{
		pushFollow(FOLLOW_computation_in_synpred22_QL517);
		computation();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred22_QL

	// Delegated rules

	public final boolean synpred21_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred22_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred22_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred20_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_QL_fragment(); // can never throw exception
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
	public static final BitSet FOLLOW_ifThenElse_in_formElement497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifThen_in_formElement507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_formElement517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_formElements564 = new BitSet(new long[]{0x0000000000000302L});
	public static final BitSet FOLLOW_If_in_ifThen589 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifThen591 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_ifThen593 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifThen595 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifThen597 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_ifThen599 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_ifThen601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifThenElse623 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_ifThenElse625 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_ifThenElse627 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifThenElse629 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifThenElse631 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_ifThenElse637 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_ifThenElse639 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Else_in_ifThenElse641 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifThenElse643 = new BitSet(new long[]{0x0000000400000300L});
	public static final BitSet FOLLOW_formElements_in_ifThenElse649 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_ifThenElse651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computation673 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_computation675 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Str_in_computation677 = new BitSet(new long[]{0x00000000E0000000L});
	public static final BitSet FOLLOW_type_in_computation679 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_computation681 = new BitSet(new long[]{0x0000000000325510L});
	public static final BitSet FOLLOW_orExpr_in_computation683 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_computation685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question708 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_question710 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Str_in_question712 = new BitSet(new long[]{0x00000000E0000000L});
	public static final BitSet FOLLOW_type_in_question714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_type736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_type757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifThenElse_in_synpred20_QL497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifThen_in_synpred21_QL507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_synpred22_QL517 = new BitSet(new long[]{0x0000000000000002L});
}
