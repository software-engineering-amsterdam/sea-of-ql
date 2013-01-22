// $ANTLR 3.5 /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 17:07:20

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stmnt.*;
import org.uva.sea.ql.ast.qtype.*;


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
		this.state.ruleMemo = new HashMap[40+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "ifStatement"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: ifStatement returns [IfStatement result] : 'if' '(' condition= orExpr ')' body ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr condition =null;
		Body body1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:2: ( 'if' '(' condition= orExpr ')' body )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:4: 'if' '(' condition= orExpr ')' body
			{
			match(input,28,FOLLOW_28_in_ifStatement45); if (state.failed) return result;
			match(input,14,FOLLOW_14_in_ifStatement47); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement51);
			condition=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement53); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStatement55);
			body1=body();
			state._fsp--;
			if (state.failed) return result;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:1: question returns [Question result] : ( normalQuestion | computedQuestion ) ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Question normalQuestion2 =null;
		computedQuestion computedQuestion3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:2: ( ( normalQuestion | computedQuestion ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: ( normalQuestion | computedQuestion )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: ( normalQuestion | computedQuestion )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==Ident) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==20) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==String) ) {
						switch ( input.LA(4) ) {
						case 29:
							{
							int LA1_4 = input.LA(5);
							if ( (LA1_4==EOF||LA1_4==Ident||LA1_4==28||LA1_4==31||LA1_4==33) ) {
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
							break;
						case 26:
							{
							int LA1_5 = input.LA(5);
							if ( (LA1_5==EOF||LA1_5==Ident||LA1_5==28||LA1_5==31||LA1_5==33) ) {
								alt1=1;
							}
							else if ( (LA1_5==14) ) {
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
										new NoViableAltException("", 1, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 30:
							{
							int LA1_6 = input.LA(5);
							if ( (LA1_6==EOF||LA1_6==Ident||LA1_6==28||LA1_6==31||LA1_6==33) ) {
								alt1=1;
							}
							else if ( (LA1_6==14) ) {
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
										new NoViableAltException("", 1, 6, input);
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:6: normalQuestion
					{
					pushFollow(FOLLOW_normalQuestion_in_question74);
					normalQuestion2=normalQuestion();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = normalQuestion2; }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:60: computedQuestion
					{
					pushFollow(FOLLOW_computedQuestion_in_question80);
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:1: normalQuestion returns [Question result] : Ident ':' String questionType ;
	public final Question normalQuestion() throws RecognitionException {
		Question result = null;

		int normalQuestion_StartIndex = input.index();

		Token Ident4=null;
		Token String5=null;
		QuestionType questionType6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:2: ( Ident ':' String questionType )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:4: Ident ':' String questionType
			{
			Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_normalQuestion102); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_normalQuestion104); if (state.failed) return result;
			String5=(Token)match(input,String,FOLLOW_String_in_normalQuestion106); if (state.failed) return result;
			pushFollow(FOLLOW_questionType_in_normalQuestion108);
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:1: computedQuestion returns [computedQuestion result] : Ident ':' String questionType '(' orExpr ')' ;
	public final computedQuestion computedQuestion() throws RecognitionException {
		computedQuestion result = null;

		int computedQuestion_StartIndex = input.index();

		Token Ident7=null;
		Token String8=null;
		QuestionType questionType9 =null;
		Expr orExpr10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:2: ( Ident ':' String questionType '(' orExpr ')' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:4: Ident ':' String questionType '(' orExpr ')'
			{
			Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion127); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_computedQuestion129); if (state.failed) return result;
			String8=(Token)match(input,String,FOLLOW_String_in_computedQuestion131); if (state.failed) return result;
			pushFollow(FOLLOW_questionType_in_computedQuestion133);
			questionType9=questionType();
			state._fsp--;
			if (state.failed) return result;
			match(input,14,FOLLOW_14_in_computedQuestion135); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedQuestion137);
			orExpr10=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_computedQuestion139); if (state.failed) return result;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: questionType returns [QuestionType result] : ( 'int' | 'bool' | 'string' );
	public final QuestionType questionType() throws RecognitionException {
		QuestionType result = null;

		int questionType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:2: ( 'int' | 'bool' | 'string' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case 29:
				{
				alt2=1;
				}
				break;
			case 26:
				{
				alt2=2;
				}
				break;
			case 30:
				{
				alt2=3;
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:4: 'int'
					{
					match(input,29,FOLLOW_29_in_questionType159); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType(); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:4: 'bool'
					{
					match(input,26,FOLLOW_26_in_questionType166); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolType(); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:4: 'string'
					{
					match(input,30,FOLLOW_30_in_questionType173); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringType(); }
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
			if ( state.backtracking>0 ) { memoize(input, 5, questionType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "questionType"



	// $ANTLR start "statement"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: statement returns [Statement result] : ( question | ifStatement | body ) ;
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Question question11 =null;
		IfStatement ifStatement12 =null;
		Body body13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:2: ( ( question | ifStatement | body ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: ( question | ifStatement | body )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: ( question | ifStatement | body )
			int alt3=3;
			switch ( input.LA(1) ) {
			case Ident:
				{
				alt3=1;
				}
				break;
			case 28:
				{
				alt3=2;
				}
				break;
			case 31:
				{
				alt3=3;
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: question
					{
					pushFollow(FOLLOW_question_in_statement193);
					question11=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question11; }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement201);
					ifStatement12=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement12; }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:4: body
					{
					pushFollow(FOLLOW_body_in_statement208);
					body13=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = body13; }
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: body returns [Body result] : '{' ( statement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		Statement statement14 =null;

		 List<Statement> statements = new ArrayList<Statement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:2: ( '{' ( statement )* '}' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:4: '{' ( statement )* '}'
			{
			match(input,31,FOLLOW_31_in_body233); if (state.failed) return result;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:8: ( statement )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==Ident||LA4_0==28||LA4_0==31) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:10: statement
					{
					pushFollow(FOLLOW_statement_in_body237);
					statement14=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { statements.add(statement14); }
					}
					break;

				default :
					break loop4;
				}
			}

			match(input,33,FOLLOW_33_in_body244); if (state.failed) return result;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: form returns [Form result] : 'form' Ident body ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident15=null;
		Body body16 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: ( 'form' Ident body )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:7: 'form' Ident body
			{
			match(input,27,FOLLOW_27_in_form265); if (state.failed) return result;
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_form267); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form269);
			body16=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form (new Ident((Ident15!=null?Ident15.getText():null)), body16); }
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int17=null;
		Token Bool18=null;
		Token String19=null;
		Token Ident20=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:4: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
			int alt5=5;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt5=1;
				}
				break;
			case Bool:
				{
				alt5=2;
				}
				break;
			case String:
				{
				alt5=3;
				}
				break;
			case Ident:
				{
				alt5=4;
				}
				break;
			case 14:
				{
				alt5=5;
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:6: Int
					{
					Int17=(Token)match(input,Int,FOLLOW_Int_in_primary292); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int17!=null?Int17.getText():null))); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:6: Bool
					{
					Bool18=(Token)match(input,Bool,FOLLOW_Bool_in_primary303); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolLiteral ((Bool18!=null?Bool18.getText():null)); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:6: String
					{
					String19=(Token)match(input,String,FOLLOW_String_in_primary312); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral ((String19!=null?String19.getText():null)); }
					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:6: Ident
					{
					Ident20=(Token)match(input,Ident,FOLLOW_Ident_in_primary321); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident20!=null?Ident20.getText():null)); }
					}
					break;
				case 5 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:6: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary330); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary334);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary336); if (state.failed) return result;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt6=1;
				}
				break;
			case 18:
				{
				alt6=2;
				}
				break;
			case 11:
				{
				alt6=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String:
			case 14:
				{
				alt6=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr362); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr366);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr377); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr381);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr392); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr396);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr409);
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr447);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==16||LA7_0==19) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr467);
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
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr505);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 17 && LA8_0 <= 18)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr523);
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
			if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr558);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==12||(LA9_0 >= 21 && LA9_0 <= 25)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr582);
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
			if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr620);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:46: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==13) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr626); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr630);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr665);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:48: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==32) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:50: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr671); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr675);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop11;
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
	public static final BitSet FOLLOW_body_in_ifStatement55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_normalQuestion_in_question74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedQuestion_in_question80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_normalQuestion102 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_normalQuestion104 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_normalQuestion106 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_questionType_in_normalQuestion108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion127 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_computedQuestion129 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_computedQuestion131 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_questionType_in_computedQuestion133 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_computedQuestion135 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion137 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_computedQuestion139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_questionType159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_questionType166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_questionType173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_statement208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_body233 = new BitSet(new long[]{0x0000000290000020L});
	public static final BitSet FOLLOW_statement_in_body237 = new BitSet(new long[]{0x0000000290000020L});
	public static final BitSet FOLLOW_33_in_body244 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_form265 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_form267 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_form269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary330 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_orExpr_in_primary334 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr362 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr377 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr392 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_unExpr396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr447 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr455 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr467 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr505 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr513 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr523 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr558 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr566 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_addExpr_in_relExpr582 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr620 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr626 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_relExpr_in_andExpr630 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr665 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr671 = new BitSet(new long[]{0x0000000000064A70L});
	public static final BitSet FOLLOW_andExpr_in_orExpr675 = new BitSet(new long[]{0x0000000100000002L});
}
