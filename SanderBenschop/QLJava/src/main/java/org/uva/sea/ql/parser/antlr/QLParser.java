// $ANTLR 3.5 /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-01-12 14:54:15

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.primary.*;
import org.uva.sea.ql.ast.unary.*;
import org.uva.sea.ql.ast.binary.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "EscapedCharacterSequence", 
		"Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
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
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int EscapedCharacterSequence=6;
	public static final int Ident=7;
	public static final int Int=8;
	public static final int Str=9;
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
		this.state.ruleMemo = new HashMap[26+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "primary"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:18:1: primary returns [QLExpression result] : ( Int | Bool | Ident | Str | '(' x= orExpr ')' );
	public final QLExpression primary() throws RecognitionException {
		QLExpression result = null;

		int primary_StartIndex = input.index();

		Token Int1=null;
		Token Bool2=null;
		Token Ident3=null;
		Token Str4=null;
		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:3: ( Int | Bool | Ident | Str | '(' x= orExpr ')' )
			int alt1=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt1=1;
				}
				break;
			case Bool:
				{
				alt1=2;
				}
				break;
			case Ident:
				{
				alt1=3;
				}
				break;
			case Str:
				{
				alt1=4;
				}
				break;
			case 14:
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:5: Int
					{
					Int1=(Token)match(input,Int,FOLLOW_Int_in_primary46); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int1!=null?Int1.getText():null))); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:20:5: Bool
					{
					Bool2=(Token)match(input,Bool,FOLLOW_Bool_in_primary56); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool2!=null?Bool2.getText():null))); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:21:5: Ident
					{
					Ident3=(Token)match(input,Ident,FOLLOW_Ident_in_primary65); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident3!=null?Ident3.getText():null)); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:22:5: Str
					{
					Str4=(Token)match(input,Str,FOLLOW_Str_in_primary73); if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					            String temp = (Str4!=null?Str4.getText():null);
					            result = new Str(temp.substring(1, temp.length()-1));
					          }
					}
					break;
				case 5 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:26:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary83); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary87);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary89); if (state.failed) return result;
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:29:1: unExpr returns [QLExpression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final QLExpression unExpr() throws RecognitionException {
		QLExpression result = null;

		int unExpr_StartIndex = input.index();

		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:30:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt2=1;
				}
				break;
			case 18:
				{
				alt2=2;
				}
				break;
			case 11:
				{
				alt2=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Str:
			case 14:
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:30:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr114); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr118);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:31:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr129); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr133);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:32:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr144); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr148);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:33:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr161);
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:36:1: mulExpr returns [QLExpression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final QLExpression mulExpr() throws RecognitionException {
		QLExpression result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr199);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==16||LA3_0==19) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr219);
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:49:1: addExpr returns [QLExpression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final QLExpression addExpr() throws RecognitionException {
		QLExpression result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr260);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 17 && LA4_0 <= 18)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr278);
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:61:1: relExpr returns [QLExpression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final QLExpression relExpr() throws RecognitionException {
		QLExpression result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:62:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:62:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr313);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:62:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==12||(LA5_0 >= 20 && LA5_0 <= 24)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:62:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr337);
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:85:1: andExpr returns [QLExpression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final QLExpression andExpr() throws RecognitionException {
		QLExpression result = null;

		int andExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr375);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:46: ( '&&' rhs= relExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==13) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:86:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr381); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr385);
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
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:90:1: orExpr returns [QLExpression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final QLExpression orExpr() throws RecognitionException {
		QLExpression result = null;

		int orExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr420);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:48: ( '||' rhs= andExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==25) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:50: '||' rhs= andExpr
					{
					match(input,25,FOLLOW_25_in_orExpr426); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr430);
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
	public static final BitSet FOLLOW_Bool_in_primary56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_primary73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary83 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_orExpr_in_primary87 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr114 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr129 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr144 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr199 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr207 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr219 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr260 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr268 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr278 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr313 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_set_in_relExpr321 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_addExpr_in_relExpr337 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr375 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr381 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_relExpr_in_andExpr385 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr420 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_25_in_orExpr426 = new BitSet(new long[]{0x0000000000064B90L});
	public static final BitSet FOLLOW_andExpr_in_orExpr430 = new BitSet(new long[]{0x0000000002000002L});
}
