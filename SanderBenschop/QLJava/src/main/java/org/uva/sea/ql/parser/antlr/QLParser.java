// $ANTLR 3.5 /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-01-14 18:46:35

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
		"COMMENT", "Datatype", "EscapedCharacterSequence", "FORM", "Ident", "Int", 
		"PAREN_CLOSE", "PAREN_OPEN", "Str", "WS", "'!'", "'!='", "'&&'", "'*'", 
		"'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'\\n'", 
		"'else'", "'if'", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int BRACE_CLOSE=4;
	public static final int BRACE_OPEN=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int Datatype=8;
	public static final int EscapedCharacterSequence=9;
	public static final int FORM=10;
	public static final int Ident=11;
	public static final int Int=12;
	public static final int PAREN_CLOSE=13;
	public static final int PAREN_OPEN=14;
	public static final int Str=15;
	public static final int WS=16;

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
	@Override public String getGrammarFileName() { return "/Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }


	  private String removeOuterQuotes(String original) {
	    return original.substring(1, original.length()-1);
	  }



	// $ANTLR start "form"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:27:1: form[Form result] : FORM Ident BRACE_OPEN statementList BRACE_CLOSE ;
	public final void form(Form result) throws RecognitionException {
		int form_StartIndex = input.index();

		List<QLStatement> statementList1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:28:3: ( FORM Ident BRACE_OPEN statementList BRACE_CLOSE )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:28:5: FORM Ident BRACE_OPEN statementList BRACE_CLOSE
			{
			match(input,FORM,FOLLOW_FORM_in_form54); if (state.failed) return;
			match(input,Ident,FOLLOW_Ident_in_form56); if (state.failed) return;
			match(input,BRACE_OPEN,FOLLOW_BRACE_OPEN_in_form58); if (state.failed) return;
			pushFollow(FOLLOW_statementList_in_form60);
			statementList1=statementList();
			state._fsp--;
			if (state.failed) return;
			match(input,BRACE_CLOSE,FOLLOW_BRACE_CLOSE_in_form62); if (state.failed) return;
			if ( state.backtracking==0 ) {
				    result = new Form(statementList1);
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



	// $ANTLR start "block"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:34:1: block returns [List<QLStatement> result] : BRACE_OPEN statementList BRACE_CLOSE ;
	public final List<QLStatement> block() throws RecognitionException {
		List<QLStatement> result = null;

		int block_StartIndex = input.index();

		List<QLStatement> statementList2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:35:3: ( BRACE_OPEN statementList BRACE_CLOSE )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:35:5: BRACE_OPEN statementList BRACE_CLOSE
			{
			match(input,BRACE_OPEN,FOLLOW_BRACE_OPEN_in_block88); if (state.failed) return result;
			pushFollow(FOLLOW_statementList_in_block90);
			statementList2=statementList();
			state._fsp--;
			if (state.failed) return result;
			match(input,BRACE_CLOSE,FOLLOW_BRACE_CLOSE_in_block92); if (state.failed) return result;
			if ( state.backtracking==0 ) {
				    result = statementList2;
				  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, block_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "block"



	// $ANTLR start "statementList"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:41:1: statementList returns [List<QLStatement> result] : (stmnt= statement '\\n' )* ;
	public final List<QLStatement> statementList() throws RecognitionException {
		List<QLStatement> result = null;

		int statementList_StartIndex = input.index();

		QLStatement stmnt =null;


		    result = new ArrayList<QLStatement>();
		  
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:46:3: ( (stmnt= statement '\\n' )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:46:5: (stmnt= statement '\\n' )*
			{
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:46:5: (stmnt= statement '\\n' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==32) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:46:6: stmnt= statement '\\n'
					{
					pushFollow(FOLLOW_statement_in_statementList130);
					stmnt=statement();
					state._fsp--;
					if (state.failed) return result;
					match(input,30,FOLLOW_30_in_statementList132); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 3, statementList_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statementList"



	// $ANTLR start "statement"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:49:1: statement returns [QLStatement result] : ( question | computation | conditional );
	public final QLStatement statement() throws RecognitionException {
		QLStatement result = null;

		int statement_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:3: ( question | computation | conditional )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==24) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==Str) ) {
						int LA2_4 = input.LA(4);
						if ( (LA2_4==Datatype) ) {
							alt2=1;
						}
						else if ( (LA2_4==PAREN_OPEN) ) {
							alt2=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 2, 4, input);
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
								new NoViableAltException("", 2, 3, input);
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
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA2_0==32) ) {
				alt2=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:50:5: question
					{
					pushFollow(FOLLOW_question_in_statement153);
					question();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:51:5: computation
					{
					pushFollow(FOLLOW_computation_in_statement159);
					computation();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:52:5: conditional
					{
					pushFollow(FOLLOW_conditional_in_statement165);
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
			if ( state.backtracking>0 ) { memoize(input, 4, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "question"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:55:1: question returns [Question result] : Ident ':' Str Datatype ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident3=null;
		Token Str4=null;
		Token Datatype5=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:3: ( Ident ':' Str Datatype )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:56:5: Ident ':' Str Datatype
			{
			Ident3=(Token)match(input,Ident,FOLLOW_Ident_in_question182); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_question184); if (state.failed) return result;
			Str4=(Token)match(input,Str,FOLLOW_Str_in_question186); if (state.failed) return result;
			Datatype5=(Token)match(input,Datatype,FOLLOW_Datatype_in_question188); if (state.failed) return result;
			if ( state.backtracking==0 ) {
				    Ident ident = new Ident((Ident3!=null?Ident3.getText():null));
				    Str label = new Str(removeOuterQuotes((Str4!=null?Str4.getText():null)));
				    Str datatype = new Str((Datatype5!=null?Datatype5.getText():null));
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
			if ( state.backtracking>0 ) { memoize(input, 5, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "computation"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:65:1: computation returns [Computation result] : Ident ':' Str PAREN_OPEN orExpr PAREN_CLOSE ;
	public final Computation computation() throws RecognitionException {
		Computation result = null;

		int computation_StartIndex = input.index();

		Token Ident6=null;
		Token Str7=null;
		QLExpression orExpr8 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:66:3: ( Ident ':' Str PAREN_OPEN orExpr PAREN_CLOSE )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:66:5: Ident ':' Str PAREN_OPEN orExpr PAREN_CLOSE
			{
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_computation214); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_computation216); if (state.failed) return result;
			Str7=(Token)match(input,Str,FOLLOW_Str_in_computation218); if (state.failed) return result;
			match(input,PAREN_OPEN,FOLLOW_PAREN_OPEN_in_computation220); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computation222);
			orExpr8=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,PAREN_CLOSE,FOLLOW_PAREN_CLOSE_in_computation224); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      Ident ident = new Ident((Ident6!=null?Ident6.getText():null));
			      Str label = new Str(removeOuterQuotes((Str7!=null?Str7.getText():null)));
			      result = new Computation(ident, label, orExpr8);
			    }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, computation_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computation"



	// $ANTLR start "conditional"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:74:1: conditional returns [Conditional result] : 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () ) ;
	public final Conditional conditional() throws RecognitionException {
		Conditional result = null;

		int conditional_StartIndex = input.index();

		QLExpression condition =null;
		List<QLStatement> success =null;
		List<QLStatement> failure =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:75:3: ( 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () ) )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:75:5: 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () )
			{
			match(input,32,FOLLOW_32_in_conditional249); if (state.failed) return result;
			match(input,PAREN_OPEN,FOLLOW_PAREN_OPEN_in_conditional251); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_conditional255);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,PAREN_CLOSE,FOLLOW_PAREN_CLOSE_in_conditional257); if (state.failed) return result;
			pushFollow(FOLLOW_block_in_conditional261);
			success=block();
			state._fsp--;
			if (state.failed) return result;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:76:5: ( ( 'else' )=> 'else' failure= block | () )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==31) && (synpred4_QL())) {
				alt3=1;
			}
			else if ( (LA3_0==30) ) {
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:76:7: ( 'else' )=> 'else' failure= block
					{
					match(input,31,FOLLOW_31_in_conditional275); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_conditional279);
					failure=block();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:77:7: ()
					{
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:77:7: ()
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:77:9: 
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
			if ( state.backtracking>0 ) { memoize(input, 7, conditional_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "conditional"



	// $ANTLR start "primary"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:88:1: primary returns [QLExpression result] : ( Int | Bool | Ident | Str | '(' x= orExpr ')' );
	public final QLExpression primary() throws RecognitionException {
		QLExpression result = null;

		int primary_StartIndex = input.index();

		Token Int9=null;
		Token Bool10=null;
		Token Ident11=null;
		Token Str12=null;
		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:3: ( Int | Bool | Ident | Str | '(' x= orExpr ')' )
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
			case PAREN_OPEN:
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:89:5: Int
					{
					Int9=(Token)match(input,Int,FOLLOW_Int_in_primary322); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int9!=null?Int9.getText():null))); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:90:5: Bool
					{
					Bool10=(Token)match(input,Bool,FOLLOW_Bool_in_primary332); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(Boolean.parseBoolean((Bool10!=null?Bool10.getText():null))); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:91:5: Ident
					{
					Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_primary341); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident11!=null?Ident11.getText():null)); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:92:5: Str
					{
					Str12=(Token)match(input,Str,FOLLOW_Str_in_primary349); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str(removeOuterQuotes((Str12!=null?Str12.getText():null))); }
					}
					break;
				case 5 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:93:5: '(' x= orExpr ')'
					{
					match(input,PAREN_OPEN,FOLLOW_PAREN_OPEN_in_primary359); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary363);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,PAREN_CLOSE,FOLLOW_PAREN_CLOSE_in_primary365); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:96:1: unExpr returns [QLExpression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final QLExpression unExpr() throws RecognitionException {
		QLExpression result = null;

		int unExpr_StartIndex = input.index();

		QLExpression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:97:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 21:
				{
				alt5=1;
				}
				break;
			case 22:
				{
				alt5=2;
				}
				break;
			case 17:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case PAREN_OPEN:
			case Str:
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:97:8: '+' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr386); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr390);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:98:8: '-' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr401); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr405);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:99:8: '!' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr416); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr420);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:100:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr433);
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
			if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:103:1: mulExpr returns [QLExpression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final QLExpression mulExpr() throws RecognitionException {
		QLExpression result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:104:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:104:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr471);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:104:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==20||LA6_0==23) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:104:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==20||input.LA(1)==23 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr491);
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
			if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:116:1: addExpr returns [QLExpression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final QLExpression addExpr() throws RecognitionException {
		QLExpression result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:117:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:117:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr533);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:117:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 21 && LA7_0 <= 22)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:117:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 21 && input.LA(1) <= 22) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr551);
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
			if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:128:1: relExpr returns [QLExpression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final QLExpression relExpr() throws RecognitionException {
		QLExpression result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:129:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:129:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr587);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:129:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==18||(LA8_0 >= 25 && LA8_0 <= 29)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:129:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==18||(input.LA(1) >= 25 && input.LA(1) <= 29) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr611);
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
			if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:152:1: andExpr returns [QLExpression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final QLExpression andExpr() throws RecognitionException {
		QLExpression result = null;

		int andExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr650);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==19) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:48: '&&' rhs= relExpr
					{
					match(input,19,FOLLOW_19_in_andExpr656); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr660);
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
			if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:157:1: orExpr returns [QLExpression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final QLExpression orExpr() throws RecognitionException {
		QLExpression result = null;

		int orExpr_StartIndex = input.index();

		QLExpression lhs =null;
		QLExpression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr695);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==33) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr701); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr705);
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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:76:7: ( 'else' )
		// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:76:8: 'else'
		{
		match(input,31,FOLLOW_31_in_synpred4_QL270); if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_QL

	// Delegated rules

	public final boolean synpred4_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_FORM_in_form54 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Ident_in_form56 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_BRACE_OPEN_in_form58 = new BitSet(new long[]{0x0000000100000810L});
	public static final BitSet FOLLOW_statementList_in_form60 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BRACE_CLOSE_in_form62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BRACE_OPEN_in_block88 = new BitSet(new long[]{0x0000000100000810L});
	public static final BitSet FOLLOW_statementList_in_block90 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_BRACE_CLOSE_in_block92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statementList130 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_statementList132 = new BitSet(new long[]{0x0000000100000802L});
	public static final BitSet FOLLOW_question_in_statement153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computation_in_statement159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question182 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question184 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Str_in_question186 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Datatype_in_question188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computation214 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_computation216 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Str_in_computation218 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_PAREN_OPEN_in_computation220 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_orExpr_in_computation222 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_PAREN_CLOSE_in_computation224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_conditional249 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_PAREN_OPEN_in_conditional251 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_orExpr_in_conditional255 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_PAREN_CLOSE_in_conditional257 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_block_in_conditional261 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_conditional275 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_block_in_conditional279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_primary349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PAREN_OPEN_in_primary359 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_orExpr_in_primary363 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_PAREN_CLOSE_in_primary365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr386 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_unExpr_in_unExpr390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr401 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_unExpr_in_unExpr405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr416 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_unExpr_in_unExpr420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr471 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_set_in_mulExpr479 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr491 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr533 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_set_in_addExpr541 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr551 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr587 = new BitSet(new long[]{0x000000003E040002L});
	public static final BitSet FOLLOW_set_in_relExpr595 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_addExpr_in_relExpr611 = new BitSet(new long[]{0x000000003E040002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr650 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19_in_andExpr656 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_relExpr_in_andExpr660 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr695 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr701 = new BitSet(new long[]{0x000000000062D840L});
	public static final BitSet FOLLOW_andExpr_in_orExpr705 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_31_in_synpred4_QL270 = new BitSet(new long[]{0x0000000000000002L});
}
