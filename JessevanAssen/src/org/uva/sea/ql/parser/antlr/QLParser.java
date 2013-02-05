// $ANTLR 3.5 C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-04 16:40:21

package org.uva.sea.ql.parser.antlr;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.value.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Identifier", 
		"Int", "NewLine", "Str", "Type", "WS", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", 
		"'>='", "'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
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
	public static final int Identifier=6;
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


	  private ErrorReporter errorReporter = null;
	  public void setErrorReporter(ErrorReporter errorReporter) {
	    this.errorReporter = errorReporter;
	  }

	  @Override
	  public void reportError(RecognitionException e) {
	    if(errorReporter != null)
	      errorReporter.reportError(e.toString());
	    else
	      throw new RuntimeException(e);
	  }



	// $ANTLR start "primary"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:1: primary returns [Expression result] : ( Bool | Int | strExpression | Identifier | '(' x= orExpression ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token Bool1=null;
		Token Int2=null;
		Token Identifier4=null;
		Expression x =null;
		org.uva.sea.ql.ast.expression.value.Str strExpression3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:5: ( Bool | Int | strExpression | Identifier | '(' x= orExpression ')' )
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
			case Identifier:
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:7: Bool
					{
					Bool1=(Token)match(input,Bool,FOLLOW_Bool_in_primary66); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Bool(Boolean.parseBoolean((Bool1!=null?Bool1.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:7: Int
					{
					Int2=(Token)match(input,Int,FOLLOW_Int_in_primary85); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Int(Integer.parseInt((Int2!=null?Int2.getText():null))); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:7: strExpression
					{
					pushFollow(FOLLOW_strExpression_in_primary105);
					strExpression3=strExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = strExpression3; }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:7: Identifier
					{
					Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_primary115); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Identifier((Identifier4!=null?Identifier4.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:7: '(' x= orExpression ')'
					{
					match(input,15,FOLLOW_15_in_primary128); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_primary132);
					x=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_primary134); if (state.failed) return result;
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



	// $ANTLR start "strExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:1: strExpression returns [org.uva.sea.ql.ast.expression.value.Str result] : Str ;
	public final org.uva.sea.ql.ast.expression.value.Str strExpression() throws RecognitionException {
		org.uva.sea.ql.ast.expression.value.Str result = null;

		int strExpression_StartIndex = input.index();

		Token Str5=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:5: ( Str )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:7: Str
			{
			Str5=(Token)match(input,Str,FOLLOW_Str_in_strExpression160); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expression.value.Str((Str5!=null?Str5.getText():null).substring(1, (Str5!=null?Str5.getText():null).length() - 1)); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, strExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "strExpression"



	// $ANTLR start "unaryExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: unaryExpression returns [Expression result] : ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression | primary );
	public final Expression unaryExpression() throws RecognitionException {
		Expression result = null;

		int unaryExpression_StartIndex = input.index();

		Expression x =null;
		Expression primary6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:5: ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression | primary )
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
			case Identifier:
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:8: '+' x= unaryExpression
					{
					match(input,18,FOLLOW_18_in_unaryExpression194); if (state.failed) return result;
					pushFollow(FOLLOW_unaryExpression_in_unaryExpression198);
					x=unaryExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Positive(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:8: '-' x= unaryExpression
					{
					match(input,19,FOLLOW_19_in_unaryExpression209); if (state.failed) return result;
					pushFollow(FOLLOW_unaryExpression_in_unaryExpression213);
					x=unaryExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Negative(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:8: '!' x= unaryExpression
					{
					match(input,12,FOLLOW_12_in_unaryExpression224); if (state.failed) return result;
					pushFollow(FOLLOW_unaryExpression_in_unaryExpression228);
					x=unaryExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:8: primary
					{
					pushFollow(FOLLOW_primary_in_unaryExpression239);
					primary6=primary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = primary6; }
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
			if ( state.backtracking>0 ) { memoize(input, 3, unaryExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unaryExpression"



	// $ANTLR start "multiplyExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:1: multiplyExpression returns [Expression result] : lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* ;
	public final Expression multiplyExpression() throws RecognitionException {
		Expression result = null;

		int multiplyExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:5: (lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:9: lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )*
			{
			pushFollow(FOLLOW_unaryExpression_in_multiplyExpression288);
			lhs=unaryExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:54: (op= ( '*' | '/' ) rhs= unaryExpression )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==17||LA3_0==20) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:71:56: op= ( '*' | '/' ) rhs= unaryExpression
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
					pushFollow(FOLLOW_unaryExpression_in_multiplyExpression308);
					rhs=unaryExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Multiply(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Divide(result, rhs);      
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
			if ( state.backtracking>0 ) { memoize(input, 4, multiplyExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "multiplyExpression"



	// $ANTLR start "addExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:1: addExpression returns [Expression result] : lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression )* ;
	public final Expression addExpression() throws RecognitionException {
		Expression result = null;

		int addExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:5: (lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:9: lhs= multiplyExpression (op= ( '+' | '-' ) rhs= multiplyExpression )*
			{
			pushFollow(FOLLOW_multiplyExpression_in_addExpression349);
			lhs=multiplyExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:57: (op= ( '+' | '-' ) rhs= multiplyExpression )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= 18 && LA4_0 <= 19)) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:59: op= ( '+' | '-' ) rhs= multiplyExpression
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
					pushFollow(FOLLOW_multiplyExpression_in_addExpression367);
					rhs=multiplyExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Subtract(result, rhs);      
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
			if ( state.backtracking>0 ) { memoize(input, 5, addExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpression"



	// $ANTLR start "relationExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: relationExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
	public final Expression relationExpression() throws RecognitionException {
		Expression result = null;

		int relationExpression_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			{
			pushFollow(FOLLOW_addExpression_in_relationExpression402);
			lhs=addExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==13||(LA5_0 >= 22 && LA5_0 <= 23)||(LA5_0 >= 25 && LA5_0 <= 27)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
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
					pushFollow(FOLLOW_addExpression_in_relationExpression426);
					rhs=addExpression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LesserThan(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LesserThanOrEqualTo(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GreaterThan(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GreaterThanOrEqualTo(result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new EqualTo(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NotEqualTo(result, rhs);
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
			if ( state.backtracking>0 ) { memoize(input, 6, relationExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relationExpression"



	// $ANTLR start "andExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:1: andExpression returns [Expression result] : lhs= relationExpression ( '&&' rhs= relationExpression )* ;
	public final Expression andExpression() throws RecognitionException {
		Expression result = null;

		int andExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:5: (lhs= relationExpression ( '&&' rhs= relationExpression )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:9: lhs= relationExpression ( '&&' rhs= relationExpression )*
			{
			pushFollow(FOLLOW_relationExpression_in_andExpression464);
			lhs=relationExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:57: ( '&&' rhs= relationExpression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:59: '&&' rhs= relationExpression
					{
					match(input,14,FOLLOW_14_in_andExpression470); if (state.failed) return result;
					pushFollow(FOLLOW_relationExpression_in_andExpression474);
					rhs=relationExpression();
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
			if ( state.backtracking>0 ) { memoize(input, 7, andExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpression"



	// $ANTLR start "orExpression"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
	public final Expression orExpression() throws RecognitionException {
		Expression result = null;

		int orExpression_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:5: (lhs= andExpression ( '||' rhs= andExpression )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:9: lhs= andExpression ( '||' rhs= andExpression )*
			{
			pushFollow(FOLLOW_andExpression_in_orExpression509);
			lhs=andExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:54: ( '||' rhs= andExpression )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==32) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:56: '||' rhs= andExpression
					{
					match(input,32,FOLLOW_32_in_orExpression515); if (state.failed) return result;
					pushFollow(FOLLOW_andExpression_in_orExpression519);
					rhs=andExpression();
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
			if ( state.backtracking>0 ) { memoize(input, 8, orExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpression"



	// $ANTLR start "form"
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:1: form returns [Form result] : 'form' Identifier '{' statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Identifier7=null;
		Statement statements8 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:5: ( 'form' Identifier '{' statements '}' )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:7: 'form' Identifier '{' statements '}'
			{
			match(input,29,FOLLOW_29_in_form545); if (state.failed) return result;
			Identifier7=(Token)match(input,Identifier,FOLLOW_Identifier_in_form547); if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form549); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form551);
			statements8=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,33,FOLLOW_33_in_form553); if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Form(new Identifier((Identifier7!=null?Identifier7.getText():null)), statements8); 
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:1: statements returns [Statement result] : ( statement )* ;
	public final Statement statements() throws RecognitionException {
		Statement result = null;

		int statements_StartIndex = input.index();

		Statement statement9 =null;


		        ArrayList<Statement> statements = new ArrayList<Statement>();
		    
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:5: ( ( statement )* )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:7: ( statement )*
			{
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:7: ( statement )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==Identifier||LA8_0==Str||LA8_0==30) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:8: statement
					{
					pushFollow(FOLLOW_statement_in_statements599);
					statement9=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { statements.add(statement9); }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:1: statement returns [Statement result] : ( ifStatement | questionStatement | computedStatement | storedExpressionStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Statement ifStatement10 =null;
		Question questionStatement11 =null;
		Computed computedStatement12 =null;
		StoredExpression storedExpressionStatement13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:5: ( ifStatement | questionStatement | computedStatement | storedExpressionStatement )
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
				if ( (LA9_2==Identifier) ) {
					int LA9_4 = input.LA(3);
					if ( (LA9_4==21) ) {
						alt9=2;
					}
					else if ( (LA9_4==EOF||LA9_4==Identifier||LA9_4==Str||(LA9_4 >= 13 && LA9_4 <= 14)||(LA9_4 >= 17 && LA9_4 <= 20)||(LA9_4 >= 22 && LA9_4 <= 23)||(LA9_4 >= 25 && LA9_4 <= 27)||LA9_4==30||(LA9_4 >= 32 && LA9_4 <= 33)) ) {
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
			case Identifier:
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:7: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement628);
					ifStatement10=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement10; }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:151:7: questionStatement
					{
					pushFollow(FOLLOW_questionStatement_in_statement638);
					questionStatement11=questionStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = questionStatement11; }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:7: computedStatement
					{
					pushFollow(FOLLOW_computedStatement_in_statement648);
					computedStatement12=computedStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedStatement12; }
					}
					break;
				case 4 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:7: storedExpressionStatement
					{
					pushFollow(FOLLOW_storedExpressionStatement_in_statement658);
					storedExpressionStatement13=storedExpressionStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = storedExpressionStatement13; }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:1: storedExpressionStatement returns [StoredExpression result] : Identifier '=' orExpression ;
	public final StoredExpression storedExpressionStatement() throws RecognitionException {
		StoredExpression result = null;

		int storedExpressionStatement_StartIndex = input.index();

		Token Identifier14=null;
		Expression orExpression15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:5: ( Identifier '=' orExpression )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:7: Identifier '=' orExpression
			{
			Identifier14=(Token)match(input,Identifier,FOLLOW_Identifier_in_storedExpressionStatement685); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_storedExpressionStatement687); if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_storedExpressionStatement689);
			orExpression15=orExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new StoredExpression(new Identifier((Identifier14!=null?Identifier14.getText():null)), orExpression15); }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:1: questionStatement returns [Question result] : strExpression Identifier ':' typeDeclaration ;
	public final Question questionStatement() throws RecognitionException {
		Question result = null;

		int questionStatement_StartIndex = input.index();

		Token Identifier17=null;
		org.uva.sea.ql.ast.expression.value.Str strExpression16 =null;
		Type typeDeclaration18 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:5: ( strExpression Identifier ':' typeDeclaration )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:7: strExpression Identifier ':' typeDeclaration
			{
			pushFollow(FOLLOW_strExpression_in_questionStatement716);
			strExpression16=strExpression();
			state._fsp--;
			if (state.failed) return result;
			Identifier17=(Token)match(input,Identifier,FOLLOW_Identifier_in_questionStatement718); if (state.failed) return result;
			match(input,21,FOLLOW_21_in_questionStatement720); if (state.failed) return result;
			pushFollow(FOLLOW_typeDeclaration_in_questionStatement722);
			typeDeclaration18=typeDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { 
			        result = new Question(strExpression16.getValue(), new Identifier((Identifier17!=null?Identifier17.getText():null)), typeDeclaration18); }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:166:1: typeDeclaration returns [Type result] : Type ;
	public final Type typeDeclaration() throws RecognitionException {
		Type result = null;

		int typeDeclaration_StartIndex = input.index();

		Token Type19=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:167:5: ( Type )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:167:7: Type
			{
			Type19=(Token)match(input,Type,FOLLOW_Type_in_typeDeclaration756); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			        if((Type19!=null?Type19.getText():null).equals("boolean"))
			          result = new org.uva.sea.ql.ast.type.Boolean();
			        else if((Type19!=null?Type19.getText():null).equals("integer"))
			          result = new org.uva.sea.ql.ast.type.Integer();
			        else if((Type19!=null?Type19.getText():null).equals("string"))
			          result = new org.uva.sea.ql.ast.type.String();
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:177:1: computedStatement returns [Computed result] : strExpression orExpression ;
	public final Computed computedStatement() throws RecognitionException {
		Computed result = null;

		int computedStatement_StartIndex = input.index();

		org.uva.sea.ql.ast.expression.value.Str strExpression20 =null;
		Expression orExpression21 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:178:5: ( strExpression orExpression )
			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:178:7: strExpression orExpression
			{
			pushFollow(FOLLOW_strExpression_in_computedStatement779);
			strExpression20=strExpression();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_orExpression_in_computedStatement781);
			orExpression21=orExpression();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Computed(strExpression20.getValue(), orExpression21); }
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
	// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:181:1: ifStatement returns [Statement result] : ( 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement | 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' | 'if' '(' orExpression ')' '{' statements '}' );
	public final Statement ifStatement() throws RecognitionException {
		Statement result = null;

		int ifStatement_StartIndex = input.index();

		Statement ifElements =null;
		Statement elseElement =null;
		Statement elseElements =null;
		Expression orExpression22 =null;
		Expression orExpression23 =null;
		Expression orExpression24 =null;
		Statement statements25 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:182:5: ( 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement | 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' | 'if' '(' orExpression ')' '{' statements '}' )
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
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:182:7: 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement
					{
					match(input,30,FOLLOW_30_in_ifStatement807); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement809); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement811);
					orExpression22=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement813); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement815); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement821);
					ifElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement823); if (state.failed) return result;
					match(input,28,FOLLOW_28_in_ifStatement825); if (state.failed) return result;
					pushFollow(FOLLOW_ifStatement_in_ifStatement831);
					elseElement=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfElse(orExpression22, ifElements, elseElement); }
					}
					break;
				case 2 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:184:7: 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}'
					{
					match(input,30,FOLLOW_30_in_ifStatement849); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement851); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement853);
					orExpression23=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement855); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement857); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement863);
					ifElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement865); if (state.failed) return result;
					match(input,28,FOLLOW_28_in_ifStatement867); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement869); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement875);
					elseElements=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement876); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfElse(orExpression23, ifElements, elseElements); }
					}
					break;
				case 3 :
					// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:186:7: 'if' '(' orExpression ')' '{' statements '}'
					{
					match(input,30,FOLLOW_30_in_ifStatement895); if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement897); if (state.failed) return result;
					pushFollow(FOLLOW_orExpression_in_ifStatement899);
					orExpression24=orExpression();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_ifStatement901); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_ifStatement903); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_ifStatement905);
					statements25=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_ifStatement907); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new If(orExpression24, statements25); }
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

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:182:7: ( 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:182:7: 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' elseElement= ifStatement
		{
		match(input,30,FOLLOW_30_in_synpred24_QL807); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred24_QL809); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred24_QL811);
		orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred24_QL813); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred24_QL815); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred24_QL821);
		ifElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred24_QL823); if (state.failed) return;
		match(input,28,FOLLOW_28_in_synpred24_QL825); if (state.failed) return;
		pushFollow(FOLLOW_ifStatement_in_synpred24_QL831);
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

		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:184:7: ( 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}' )
		// C:\\Users\\Jesse\\Documents\\Software Construction\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:184:7: 'if' '(' orExpression ')' '{' ifElements= statements '}' 'else' '{' elseElements= statements '}'
		{
		match(input,30,FOLLOW_30_in_synpred25_QL849); if (state.failed) return;
		match(input,15,FOLLOW_15_in_synpred25_QL851); if (state.failed) return;
		pushFollow(FOLLOW_orExpression_in_synpred25_QL853);
		orExpression();
		state._fsp--;
		if (state.failed) return;
		match(input,16,FOLLOW_16_in_synpred25_QL855); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred25_QL857); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred25_QL863);
		ifElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred25_QL865); if (state.failed) return;
		match(input,28,FOLLOW_28_in_synpred25_QL867); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred25_QL869); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred25_QL875);
		elseElements=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred25_QL876); if (state.failed) return;
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



	public static final BitSet FOLLOW_Bool_in_primary66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpression_in_primary105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primary115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_primary128 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_primary132 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_primary134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_strExpression160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unaryExpression194 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unaryExpression_in_unaryExpression198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unaryExpression209 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unaryExpression_in_unaryExpression213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unaryExpression224 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unaryExpression_in_unaryExpression228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unaryExpression239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unaryExpression_in_multiplyExpression288 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_set_in_multiplyExpression296 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_unaryExpression_in_multiplyExpression308 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_multiplyExpression_in_addExpression349 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_addExpression357 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_multiplyExpression_in_addExpression367 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_addExpression_in_relationExpression402 = new BitSet(new long[]{0x000000000EC02002L});
	public static final BitSet FOLLOW_set_in_relationExpression410 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_addExpression_in_relationExpression426 = new BitSet(new long[]{0x000000000EC02002L});
	public static final BitSet FOLLOW_relationExpression_in_andExpression464 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpression470 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_relationExpression_in_andExpression474 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpression_in_orExpression509 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpression515 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_andExpression_in_orExpression519 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_29_in_form545 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_form547 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form549 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_form551 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements599 = new BitSet(new long[]{0x0000000040000242L});
	public static final BitSet FOLLOW_ifStatement_in_statement628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionStatement_in_statement638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedStatement_in_statement648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_storedExpressionStatement_in_statement658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_storedExpressionStatement685 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_storedExpressionStatement687 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_storedExpressionStatement689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpression_in_questionStatement716 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Identifier_in_questionStatement718 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_questionStatement720 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_typeDeclaration_in_questionStatement722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Type_in_typeDeclaration756 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strExpression_in_computedStatement779 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_computedStatement781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement807 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement809 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement811 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement813 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement815 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement821 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement823 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifStatement825 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatement_in_ifStatement831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement849 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement851 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement853 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement855 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement857 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement863 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement865 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_ifStatement867 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement869 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement875 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_ifStatement895 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement897 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_ifStatement899 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement901 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement903 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_ifStatement905 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred24_QL807 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred24_QL809 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_synpred24_QL811 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred24_QL813 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred24_QL815 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred24_QL821 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred24_QL823 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_synpred24_QL825 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatement_in_synpred24_QL831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred25_QL849 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_synpred25_QL851 = new BitSet(new long[]{0x00000000000C92D0L});
	public static final BitSet FOLLOW_orExpression_in_synpred25_QL853 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_synpred25_QL855 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred25_QL857 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred25_QL863 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred25_QL865 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_synpred25_QL867 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred25_QL869 = new BitSet(new long[]{0x0000000240000240L});
	public static final BitSet FOLLOW_statements_in_synpred25_QL875 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred25_QL876 = new BitSet(new long[]{0x0000000000000002L});
}
