// $ANTLR 3.5 /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 01:01:20

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Ident", "Int", "MLINE_COMMENT", 
		"SLINE_COMMENT", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'bool'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int Bool=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int MLINE_COMMENT=7;
	public static final int SLINE_COMMENT=8;
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
		this.state.ruleMemo = new HashMap[39+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "ifStatement"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:1: ifStatement returns [IfStatement result] : 'if' '(' condition= orExpr ')' '{' body '}' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr condition =null;
		Body body1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:2: ( 'if' '(' condition= orExpr ')' '{' body '}' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:4: 'if' '(' condition= orExpr ')' '{' body '}'
			{
			match(input,28,FOLLOW_28_in_ifStatement45); if (state.failed) return result;
			match(input,14,FOLLOW_14_in_ifStatement47); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement51);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement53); if (state.failed) return result;
			match(input,31,FOLLOW_31_in_ifStatement55); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStatement57);
			body1=body();
			state._fsp--;
			if (state.failed) return result;
			match(input,33,FOLLOW_33_in_ifStatement59); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new IfStatement(condition, body1); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "question"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:1: question returns [Question result] : ( normalQuestion | computedQuestion ) ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Question normalQuestion2 =null;
		computedQuestion computedQuestion3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:2: ( ( normalQuestion | computedQuestion ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:4: ( normalQuestion | computedQuestion )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:4: ( normalQuestion | computedQuestion )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==Ident) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==20) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==String) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==26||(LA1_3 >= 29 && LA1_3 <= 30)) ) {
							int LA1_4 = input.LA(5);
							if ( (LA1_4==EOF||LA1_4==Ident||LA1_4==28||LA1_4==33) ) {
								alt1=1;
							}
							else if ( (LA1_4==14) ) {
								alt1=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 1, 4, input);
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
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 3, input);
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
								new NoViableAltException("", 1, 2, input);
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
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:6: normalQuestion
					{
					pushFollow(FOLLOW_normalQuestion_in_question78);
					normalQuestion2=normalQuestion();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = normalQuestion2; }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:60: computedQuestion
					{
					pushFollow(FOLLOW_computedQuestion_in_question84);
					computedQuestion3=computedQuestion();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedQuestion3; }
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "normalQuestion"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: normalQuestion returns [Question result] : Ident ':' String questionType ;
	public final Question normalQuestion() throws RecognitionException {
		Question result = null;

		int normalQuestion_StartIndex = input.index();

		Token Ident4=null;
		Token String5=null;
		QuestionType questionType6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:2: ( Ident ':' String questionType )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: Ident ':' String questionType
			{
			Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_normalQuestion106); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_normalQuestion108); if (state.failed) return result;
			String5=(Token)match(input,String,FOLLOW_String_in_normalQuestion110); if (state.failed) return result;
			pushFollow(FOLLOW_questionType_in_normalQuestion112);
			questionType6=questionType();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident4!=null?Ident4.getText():null)), new StringLiteral((String5!=null?String5.getText():null)), questionType6); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, normalQuestion_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "normalQuestion"



	// $ANTLR start "computedQuestion"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: computedQuestion returns [computedQuestion result] : Ident ':' String questionType '(' orExpr ')' ;
	public final computedQuestion computedQuestion() throws RecognitionException {
		computedQuestion result = null;

		int computedQuestion_StartIndex = input.index();

		Token Ident7=null;
		Token String8=null;
		QuestionType questionType9 =null;
		Expr orExpr10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:2: ( Ident ':' String questionType '(' orExpr ')' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: Ident ':' String questionType '(' orExpr ')'
			{
			Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion131); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_computedQuestion133); if (state.failed) return result;
			String8=(Token)match(input,String,FOLLOW_String_in_computedQuestion135); if (state.failed) return result;
			pushFollow(FOLLOW_questionType_in_computedQuestion137);
			questionType9=questionType();
			state._fsp--;
			if (state.failed) return result;
			match(input,14,FOLLOW_14_in_computedQuestion139); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedQuestion141);
			orExpr10=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_computedQuestion143); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new computedQuestion(new Ident((Ident7!=null?Ident7.getText():null)), new StringLiteral((String8!=null?String8.getText():null)), questionType9, orExpr10); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, computedQuestion_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedQuestion"



	// $ANTLR start "questionType"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: questionType returns [QuestionType result] : ( 'int' | 'bool' | 'string' );
	public final QuestionType questionType() throws RecognitionException {
		QuestionType result = null;

		int questionType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:2: ( 'int' | 'bool' | 'string' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			if ( input.LA(1)==26||(input.LA(1) >= 29 && input.LA(1) <= 30) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, questionType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionType"



	// $ANTLR start "statement"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: statement returns [Statement result] : ( question | ifStatement ) ;
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Question question11 =null;
		IfStatement ifStatement12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:2: ( ( question | ifStatement ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:4: ( question | ifStatement )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:4: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==28) ) {
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: question
					{
					pushFollow(FOLLOW_question_in_statement189);
					question11=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question11; }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:47: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement195);
					ifStatement12=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifStatement12;}
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "body"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: body returns [Body result] : '{' ( statement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		Statement statement13 =null;

		 List<Statement> statements = new ArrayList<Statement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:2: ( '{' ( statement )* '}' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: '{' ( statement )* '}'
			{
			match(input,31,FOLLOW_31_in_body219); if (state.failed) return result;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:8: ( statement )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==Ident||LA3_0==28) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:10: statement
					{
					pushFollow(FOLLOW_statement_in_body223);
					statement13=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { statements.add(statement13); }
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,33,FOLLOW_33_in_body230); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Body(statements); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, body_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "body"



	// $ANTLR start "form"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:1: form returns [Form result] : 'form' Ident body ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident14=null;
		Body body15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: ( 'form' Ident body )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:7: 'form' Ident body
			{
			match(input,27,FOLLOW_27_in_form251); if (state.failed) return result;
			Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_form253); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form255);
			body15=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form (new Ident((Ident14!=null?Ident14.getText():null)), body15); }
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



	// $ANTLR start "primary"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int16=null;
		Token Bool17=null;
		Token String18=null;
		Token Ident19=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:3: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
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
			case String:
				{
				alt4=3;
				}
				break;
			case Ident:
				{
				alt4=4;
				}
				break;
			case 14:
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: Int
					{
					Int16=(Token)match(input,Int,FOLLOW_Int_in_primary277); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int16!=null?Int16.getText():null))); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: Bool
					{
					Bool17=(Token)match(input,Bool,FOLLOW_Bool_in_primary287); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral ((Bool17!=null?Bool17.getText():null)); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: String
					{
					String18=(Token)match(input,String,FOLLOW_String_in_primary295); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new StringLiteral ((String18!=null?String18.getText():null)); }
					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: Ident
					{
					Ident19=(Token)match(input,Ident,FOLLOW_Ident_in_primary303); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident19!=null?Ident19.getText():null)); }
					}
					break;
				case 5 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary311); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary315);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary317); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt5=1;
				}
				break;
			case 18:
				{
				alt5=2;
				}
				break;
			case 11:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String:
			case 14:
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr342); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr346);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr357); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr361);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr372); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr376);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr389);
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
			if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr427);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==16||LA6_0==19) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr447);
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
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:77:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr485);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 17 && LA7_0 <= 18)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:78:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr503);
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
			if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr538);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==12||(LA8_0 >= 21 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr562);
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
			if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr600);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==13) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr606); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr610);
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
			if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr645);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==32) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr651); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr655);
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
			if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_28_in_ifStatement45 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement47 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement51 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement53 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatement55 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_ifStatement57 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatement59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_normalQuestion_in_question78 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedQuestion_in_question84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_normalQuestion106 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_normalQuestion108 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_normalQuestion110 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_questionType_in_normalQuestion112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion131 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_computedQuestion133 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_computedQuestion135 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_questionType_in_computedQuestion137 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_computedQuestion139 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion141 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_computedQuestion143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_body219 = new BitSet(new long[]{0x0000000210000020L});
	public static final BitSet FOLLOW_statement_in_body223 = new BitSet(new long[]{0x0000000210000020L});
	public static final BitSet FOLLOW_33_in_body230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_form251 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_form253 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_form255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary311 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_orExpr_in_primary315 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr342 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr357 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr372 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr427 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr435 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr447 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr485 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr493 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr503 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr538 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr546 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_addExpr_in_relExpr562 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr600 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr606 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_relExpr_in_andExpr610 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr645 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr651 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_andExpr_in_orExpr655 = new BitSet(new long[]{0x0000000100000002L});
}
