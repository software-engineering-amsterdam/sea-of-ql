// $ANTLR 3.5 /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-01-14 13:57:13

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodetypes.primary.*;
import org.uva.sea.ql.ast.nodetypes.unary.*;
import org.uva.sea.ql.ast.nodetypes.binary.*;
import org.uva.sea.ql.ast.nodetypes.conditional.*;
import org.uva.sea.ql.ast.nodetypes.formelements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BRACE_CLOSE", "BRACE_OPEN", "Bool", 
		"COMMENT", "Datatype", "EscapedCharacterSequence", "Ident", "Int", "Str", 
		"WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'\\n'", "'else'", "'if'", 
		"'||'"
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
	public static final int BRACE_CLOSE=4;
	public static final int BRACE_OPEN=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int Datatype=8;
	public static final int EscapedCharacterSequence=9;
	public static final int Ident=10;
	public static final int Int=11;
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
		this.state.ruleMemo = new HashMap[33+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }


	  private String removeOuterQuotes(String original) {
	    return original.substring(1, original.length()-1);
	  }



	// $ANTLR start "statementList"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:27:1: statementList returns [List<QLStatement> result] : (stmnt= statement '\\n' )* ;
	public final List<QLStatement> statementList() throws RecognitionException {
		List<QLStatement> result = null;

		int statementList_StartIndex = input.index();

		QLStatement stmnt =null;


		    result = new ArrayList<QLStatement>();
		  
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:32:3: ( (stmnt= statement '\\n' )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:32:5: (stmnt= statement '\\n' )*
			{
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:32:5: (stmnt= statement '\\n' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==31) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:32:6: stmnt= statement '\\n'
					{
					pushFollow(FOLLOW_statement_in_statementList72);
					stmnt=statement();
					state._fsp--;
					if (state.failed) return result;
					match(input,29,FOLLOW_29_in_statementList74); if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(stmnt);}
					}
					break;

				default :
					break loop1;
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
			if ( state.backtracking>0 ) { memoize(input, 1, statementList_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statementList"



	// $ANTLR start "statement"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:35:1: statement returns [QLStatement result] : ( question | conditional );
	public final QLStatement statement() throws RecognitionException {
		QLStatement result = null;

		int statement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:36:3: ( question | conditional )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==31) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:36:5: question
					{
					pushFollow(FOLLOW_question_in_statement95);
					question();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:37:5: conditional
					{
					pushFollow(FOLLOW_conditional_in_statement101);
					conditional();
					state._fsp--;
					if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 2, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "question"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:40:1: question returns [Question result] : Ident ':' Str Datatype ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident1=null;
		Token Str2=null;
		Token Datatype3=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:41:3: ( Ident ':' Str Datatype )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:41:5: Ident ':' Str Datatype
			{
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_question118); if (state.failed) return result;
			match(input,23,FOLLOW_23_in_question120); if (state.failed) return result;
			Str2=(Token)match(input,Str,FOLLOW_Str_in_question122); if (state.failed) return result;
			Datatype3=(Token)match(input,Datatype,FOLLOW_Datatype_in_question124); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			                              Ident ident = new Ident((Ident1!=null?Ident1.getText():null));
			                              Str label = new Str(removeOuterQuotes((Str2!=null?Str2.getText():null)));
			                              Str datatype = new Str((Datatype3!=null?Datatype3.getText():null));
			                              result = new Question(ident, label, datatype);
			                           }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "conditional"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:49:1: conditional returns [Conditional result] : 'if' '(' condition= orExpr ')' BRACE_OPEN success= statementList BRACE_CLOSE ( ( 'else' )=> 'else' BRACE_OPEN failure= statementList BRACE_CLOSE | () ) ;
	public final Conditional conditional() throws RecognitionException {
		Conditional result = null;

		int conditional_StartIndex = input.index();

		QLExpression condition =null;
		List<QLStatement> success =null;
		List<QLStatement> failure =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:3: ( 'if' '(' condition= orExpr ')' BRACE_OPEN success= statementList BRACE_CLOSE ( ( 'else' )=> 'else' BRACE_OPEN failure= statementList BRACE_CLOSE | () ) )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:5: 'if' '(' condition= orExpr ')' BRACE_OPEN success= statementList BRACE_CLOSE ( ( 'else' )=> 'else' BRACE_OPEN failure= statementList BRACE_CLOSE | () )
			{
			match(input,31,FOLLOW_31_in_conditional145); if (state.failed) return result;
			match(input,17,FOLLOW_17_in_conditional147); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_conditional151);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_conditional153); if (state.failed) return result;
			match(input,BRACE_OPEN,FOLLOW_BRACE_OPEN_in_conditional155); if (state.failed) return result;
			pushFollow(FOLLOW_statementList_in_conditional159);
			success=statementList();
			state._fsp--;
			if (state.failed) return result;
			match(input,BRACE_CLOSE,FOLLOW_BRACE_CLOSE_in_conditional161); if (state.failed) return result;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:51:5: ( ( 'else' )=> 'else' BRACE_OPEN failure= statementList BRACE_CLOSE | () )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==30) && (synpred3_QL())) {
				alt3=1;
			}
			else if ( (LA3_0==29) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:51:7: ( 'else' )=> 'else' BRACE_OPEN failure= statementList BRACE_CLOSE
					{
					match(input,30,FOLLOW_30_in_conditional175); if (state.failed) return result;
					match(input,BRACE_OPEN,FOLLOW_BRACE_OPEN_in_conditional177); if (state.failed) return result;
					pushFollow(FOLLOW_statementList_in_conditional181);
					failure=statementList();
					state._fsp--;
					if (state.failed) return result;
					match(input,BRACE_CLOSE,FOLLOW_BRACE_CLOSE_in_conditional183); if (state.failed) return result;
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:52:7: ()
					{
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:52:7: ()
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:52:9: 
					{
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			      if (failure != null) {
			        result = new Conditional(condition, success, failure);
			      } else {
			        result = new Conditional(condition, success);
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
			if ( state.backtracking>0 ) { memoize(input, 4, conditional_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "conditional"



	// $ANTLR start "primary"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:62:1: primary returns [QLExpression result] : ( Int | Bool | Ident | Str | '(' x= orExpr ')' );
	public final QLExpression primary() throws RecognitionException {
		QLExpression result = null;

		int primary_StartIndex = input.index();

		Token Int4=null;
		Token Bool5=null;
		Token Ident6=null;
		Token Str7=null;
		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:63:3: ( Int | Bool | Ident | Str | '(' x= orExpr ')' )
			int alt4=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt4=1;
				}
				break;
			case Bool:
				{
				alt4=2;
				}
				break;
			case Ident:
				{
				alt4=3;
				}
				break;
			case Str:
				{
				alt4=4;
				}
				break;
			case 17:
				{
				alt4=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:63:5: Int
					{
					Int4=(Token)match(input,Int,FOLLOW_Int_in_primary219); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int4!=null?Int4.getText():null))); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:64:5: Bool
					{
					Bool5=(Token)match(input,Bool,FOLLOW_Bool_in_primary229); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool5!=null?Bool5.getText():null))); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:65:5: Ident
					{
					Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_primary238); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident6!=null?Ident6.getText():null)); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:66:5: Str
					{
					Str7=(Token)match(input,Str,FOLLOW_Str_in_primary246); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str(removeOuterQuotes((Str7!=null?Str7.getText():null))); }
					}
					break;
				case 5 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:67:5: '(' x= orExpr ')'
					{
					match(input,17,FOLLOW_17_in_primary256); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary260);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_primary262); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:70:1: unExpr returns [QLExpression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final QLExpression unExpr() throws RecognitionException {
		QLExpression result = null;

		int unExpr_StartIndex = input.index();

		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:71:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt5=1;
				}
				break;
			case 21:
				{
				alt5=2;
				}
				break;
			case 14:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case Str:
			case 17:
				{
				alt5=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:71:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr283); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr287);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:72:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr298); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr302);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:73:8: '!' x= unExpr
					{
					match(input,14,FOLLOW_14_in_unExpr313); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr317);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:74:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr330);
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
			if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:77:1: mulExpr returns [QLExpression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final QLExpression mulExpr() throws RecognitionException {
		QLExpression result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr368);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==19||LA6_0==22) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:78:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr388);
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
			if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:90:1: addExpr returns [QLExpression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final QLExpression addExpr() throws RecognitionException {
		QLExpression result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr429);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 20 && LA7_0 <= 21)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr447);
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
			if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:102:1: relExpr returns [QLExpression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final QLExpression relExpr() throws RecognitionException {
		QLExpression result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr482);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==15||(LA8_0 >= 24 && LA8_0 <= 28)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr506);
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
			if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:126:1: andExpr returns [QLExpression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final QLExpression andExpr() throws RecognitionException {
		QLExpression result = null;

		int andExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr544);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==16) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:127:48: '&&' rhs= relExpr
					{
					match(input,16,FOLLOW_16_in_andExpr550); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr554);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:131:1: orExpr returns [QLExpression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final QLExpression orExpr() throws RecognitionException {
		QLExpression result = null;

		int orExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:132:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:132:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr589);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:132:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==32) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:132:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr595); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr599);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop10;
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
			if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred3_QL
	public final void synpred3_QL_fragment() throws RecognitionException {
		// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:51:7: ( 'else' )
		// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:51:8: 'else'
		{
		match(input,30,FOLLOW_30_in_synpred3_QL170); if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_QL

	// Delegated rules

	public final boolean synpred3_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_statement_in_statementList72 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_statementList74 = new BitSet(new long[]{0x0000000080000402L});
	public static final BitSet FOLLOW_question_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question118 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_question120 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Str_in_question122 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Datatype_in_question124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_conditional145 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_conditional147 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_orExpr_in_conditional151 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_conditional153 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BRACE_OPEN_in_conditional155 = new BitSet(new long[]{0x0000000080000410L});
	public static final BitSet FOLLOW_statementList_in_conditional159 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BRACE_CLOSE_in_conditional161 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_30_in_conditional175 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BRACE_OPEN_in_conditional177 = new BitSet(new long[]{0x0000000080000410L});
	public static final BitSet FOLLOW_statementList_in_conditional181 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BRACE_CLOSE_in_conditional183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_primary246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primary256 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_orExpr_in_primary260 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primary262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr283 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_unExpr_in_unExpr287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr298 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_unExpr_in_unExpr302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr313 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_unExpr_in_unExpr317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr368 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr376 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr388 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr429 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr437 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr447 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr482 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_set_in_relExpr490 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_addExpr_in_relExpr506 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr544 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_andExpr550 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_relExpr_in_andExpr554 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr589 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr595 = new BitSet(new long[]{0x0000000000325C40L});
	public static final BitSet FOLLOW_andExpr_in_orExpr599 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_30_in_synpred3_QL170 = new BitSet(new long[]{0x0000000000000002L});
}
