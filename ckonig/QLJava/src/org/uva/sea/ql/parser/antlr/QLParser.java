// $ANTLR 3.5 C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-25 14:15:57

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.bool.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.math.*;
import org.uva.sea.ql.ast.literals.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.elements.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Assign", "COMMENT", "Form", "FormIdent", 
		"Ident", "Int", "LEFTBR", "LEFTCBR", "RIGHTBR", "RIGHTCBR", "String", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'boolean'", "'if'", "'integer'", "'money'", "'string'", 
		"'||'"
	};
	public static final int EOF=-1;
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
	public static final int Assign=4;
	public static final int COMMENT=5;
	public static final int Form=6;
	public static final int FormIdent=7;
	public static final int Ident=8;
	public static final int Int=9;
	public static final int LEFTBR=10;
	public static final int LEFTCBR=11;
	public static final int RIGHTBR=12;
	public static final int RIGHTCBR=13;
	public static final int String=14;
	public static final int WS=15;

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
		this.state.ruleMemo = new HashMap[44+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "parse"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:1: parse returns [Form result] : formDefinition EOF ;
	public final Form parse() throws RecognitionException  {
		Form result = null;

		int parse_StartIndex = input.index();

		Form formDefinition1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:4: ( formDefinition EOF )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:4: formDefinition EOF
			{
			pushFollow(FOLLOW_formDefinition_in_parse45);
			formDefinition1=formDefinition();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_parse47); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDefinition1;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "parse"



	// $ANTLR start "formDefinition"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:1: formDefinition returns [Form result] : Form formDeclaration ;
	public final Form formDefinition() throws RecognitionException  {
		Form result = null;

		int formDefinition_StartIndex = input.index();

		Form formDeclaration2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:2: ( Form formDeclaration )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:5: Form formDeclaration
			{
			match(input,Form,FOLLOW_Form_in_formDefinition63); if (state.failed) return result;
			pushFollow(FOLLOW_formDeclaration_in_formDefinition65);
			formDeclaration2=formDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = formDeclaration2;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, formDefinition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDefinition"



	// $ANTLR start "formDeclaration"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:1: formDeclaration returns [Form result] : FormIdent LEFTCBR blockContent RIGHTCBR ;
	public final Form formDeclaration() throws RecognitionException  {
		Form result = null;

		int formDeclaration_StartIndex = input.index();

		Token FormIdent3=null;
		Block blockContent4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: ( FormIdent LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: FormIdent LEFTCBR blockContent RIGHTCBR
			{
			FormIdent3=(Token)match(input,FormIdent,FOLLOW_FormIdent_in_formDeclaration81); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_formDeclaration83); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_formDeclaration85);
			blockContent4=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_formDeclaration87); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Form((FormIdent3!=null?FormIdent3.getText():null), blockContent4);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, formDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDeclaration"



	// $ANTLR start "blockContent"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:1: blockContent returns [Block result] : ( blockLine )* ;
	public final Block blockContent() throws RecognitionException  {
		Block result = null;

		int blockContent_StartIndex = input.index();

		AbstractBlockElement blockLine5 =null;


			List l = new ArrayList();
			result = new Block(l);	

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( ( blockLine )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( blockLine )*
			{
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:3: ( blockLine )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:4: blockLine
					{
					pushFollow(FOLLOW_blockLine_in_blockContent108);
					blockLine5=blockLine();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {if(blockLine5 != null) {result.addLine(blockLine5);}}
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
			if ( state.backtracking>0 ) { memoize(input, 4, blockContent_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockContent"



	// $ANTLR start "blockLine"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: blockLine returns [AbstractBlockElement result] : ( question | ifStatement );
	public final AbstractBlockElement blockLine() throws RecognitionException  {
		AbstractBlockElement result = null;

		int blockLine_StartIndex = input.index();

		Question question6 =null;
		IfStatement ifStatement7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:4: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==29) ) {
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:4: question
					{
					pushFollow(FOLLOW_question_in_blockLine129);
					question6=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question6;}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:41:3: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_blockLine135);
					ifStatement7=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = ifStatement7;}
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
			if ( state.backtracking>0 ) { memoize(input, 5, blockLine_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockLine"



	// $ANTLR start "question"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:1: question returns [Question result] : ( ident Assign String type | ident Assign String type '(' e= orExpr ')' );
	public final Question question() throws RecognitionException  {
		Question result = null;

		int question_StartIndex = input.index();

		Token String9=null;
		Token String12=null;
		Expr e =null;
		Ident ident8 =null;
		AbstractType type10 =null;
		Ident ident11 =null;
		AbstractType type13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:2: ( ident Assign String type | ident Assign String type '(' e= orExpr ')' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Ident) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==Assign) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==String) ) {
						switch ( input.LA(4) ) {
						case 28:
							{
							int LA3_4 = input.LA(5);
							if ( (LA3_4==EOF||LA3_4==Ident||LA3_4==RIGHTCBR||LA3_4==29) ) {
								alt3=1;
							}
							else if ( (LA3_4==LEFTBR) ) {
								alt3=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 3, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 31:
							{
							int LA3_5 = input.LA(5);
							if ( (LA3_5==EOF||LA3_5==Ident||LA3_5==RIGHTCBR||LA3_5==29) ) {
								alt3=1;
							}
							else if ( (LA3_5==LEFTBR) ) {
								alt3=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 3, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 30:
							{
							int LA3_6 = input.LA(5);
							if ( (LA3_6==EOF||LA3_6==Ident||LA3_6==RIGHTCBR||LA3_6==29) ) {
								alt3=1;
							}
							else if ( (LA3_6==LEFTBR) ) {
								alt3=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 3, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 32:
							{
							int LA3_7 = input.LA(5);
							if ( (LA3_7==EOF||LA3_7==Ident||LA3_7==RIGHTCBR||LA3_7==29) ) {
								alt3=1;
							}
							else if ( (LA3_7==LEFTBR) ) {
								alt3=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 3, 7, input);
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
									new NoViableAltException("", 3, 3, input);
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
								new NoViableAltException("", 3, 2, input);
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
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:4: ident Assign String type
					{
					pushFollow(FOLLOW_ident_in_question151);
					ident8=ident();
					state._fsp--;
					if (state.failed) return result;
					match(input,Assign,FOLLOW_Assign_in_question153); if (state.failed) return result;
					String9=(Token)match(input,String,FOLLOW_String_in_question155); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question157);
					type10=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Question(ident8, new StringLiteral((String9!=null?String9.getText():null)), type10);}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:4: ident Assign String type '(' e= orExpr ')'
					{
					pushFollow(FOLLOW_ident_in_question164);
					ident11=ident();
					state._fsp--;
					if (state.failed) return result;
					match(input,Assign,FOLLOW_Assign_in_question166); if (state.failed) return result;
					String12=(Token)match(input,String,FOLLOW_String_in_question168); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question170);
					type13=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,LEFTBR,FOLLOW_LEFTBR_in_question172); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_question176);
					e=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_question178); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Question(ident11, new StringLiteral((String12!=null?String12.getText():null)), type13, e);}
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
			if ( state.backtracking>0 ) { memoize(input, 6, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "ifStatement"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:1: ifStatement returns [IfStatement result] : 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR ;
	public final IfStatement ifStatement() throws RecognitionException  {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr orExpr14 =null;
		Block blockContent15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:3: ( 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:3: 'if' LEFTBR orExpr RIGHTBR LEFTCBR blockContent RIGHTCBR
			{
			match(input,29,FOLLOW_29_in_ifStatement193); if (state.failed) return result;
			match(input,LEFTBR,FOLLOW_LEFTBR_in_ifStatement195); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement197);
			orExpr14=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTBR,FOLLOW_RIGHTBR_in_ifStatement199); if (state.failed) return result;
			match(input,LEFTCBR,FOLLOW_LEFTCBR_in_ifStatement201); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_ifStatement203);
			blockContent15=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RIGHTCBR,FOLLOW_RIGHTCBR_in_ifStatement205); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new IfStatement(orExpr14, blockContent15);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "ident"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:1: ident returns [Ident result] : Ident ;
	public final Ident ident() throws RecognitionException  {
		Ident result = null;

		int ident_StartIndex = input.index();

		Token Ident16=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:3: ( Ident )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:3: Ident
			{
			Ident16=(Token)match(input,Ident,FOLLOW_Ident_in_ident220); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Ident(new StringLiteral((Ident16!=null?Ident16.getText():null))); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, ident_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ident"



	// $ANTLR start "type"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:1: type returns [AbstractType result] : ( boolType | money | intType | strType );
	public final AbstractType type() throws RecognitionException  {
		AbstractType result = null;

		int type_StartIndex = input.index();

		BooleanType boolType17 =null;
		Money money18 =null;
		IntType intType19 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:2: ( boolType | money | intType | strType )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt4=1;
				}
				break;
			case 31:
				{
				alt4=2;
				}
				break;
			case 30:
				{
				alt4=3;
				}
				break;
			case 32:
				{
				alt4=4;
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:5: boolType
					{
					pushFollow(FOLLOW_boolType_in_type237);
					boolType17=boolType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = boolType17;}
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:5: money
					{
					pushFollow(FOLLOW_money_in_type245);
					money18=money();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = money18;}
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:5: intType
					{
					pushFollow(FOLLOW_intType_in_type256);
					intType19=intType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = intType19;}
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:5: strType
					{
					pushFollow(FOLLOW_strType_in_type264);
					strType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrType();}
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
			if ( state.backtracking>0 ) { memoize(input, 9, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "intType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: intType returns [IntType result] : 'integer' ;
	public final IntType intType() throws RecognitionException  {
		IntType result = null;

		int intType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:2: ( 'integer' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:4: 'integer'
			{
			match(input,30,FOLLOW_30_in_intType280); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new IntType(); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, intType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "intType"



	// $ANTLR start "money"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:1: money returns [Money result] : 'money' ;
	public final Money money() throws RecognitionException  {
		Money result = null;

		int money_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:2: ( 'money' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:5: 'money'
			{
			match(input,31,FOLLOW_31_in_money296); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Money(); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, money_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "money"



	// $ANTLR start "boolType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:1: boolType returns [BooleanType result] : 'boolean' ;
	public final BooleanType boolType() throws RecognitionException  {
		BooleanType result = null;

		int boolType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:2: ( 'boolean' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:70:4: 'boolean'
			{
			match(input,28,FOLLOW_28_in_boolType311); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new BooleanType(); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, boolType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "boolType"



	// $ANTLR start "strType"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: strType returns [StrType result] : 'string' ;
	public final StrType strType() throws RecognitionException  {
		StrType result = null;

		int strType_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:2: ( 'string' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: 'string'
			{
			match(input,32,FOLLOW_32_in_strType326); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new StrType(); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, strType_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "strType"



	// $ANTLR start "primary"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:1: primary returns [Expr result] : ( Int | ident | String | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException  {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int20=null;
		Token String22=null;
		Expr x =null;
		Ident ident21 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:3: ( Int | ident | String | '(' x= orExpr ')' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt5=1;
				}
				break;
			case Ident:
				{
				alt5=2;
				}
				break;
			case String:
				{
				alt5=3;
				}
				break;
			case LEFTBR:
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:5: Int
					{
					Int20=(Token)match(input,Int,FOLLOW_Int_in_primary344); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int20!=null?Int20.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:5: ident
					{
					pushFollow(FOLLOW_ident_in_primary354);
					ident21=ident();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ident21; }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: String
					{
					String22=(Token)match(input,String,FOLLOW_String_in_primary362); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StringLiteral((String22!=null?String22.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:5: '(' x= orExpr ')'
					{
					match(input,LEFTBR,FOLLOW_LEFTBR_in_primary370); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary374);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RIGHTBR,FOLLOW_RIGHTBR_in_primary376); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 14, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException  {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt6=4;
			switch ( input.LA(1) ) {
			case 20:
				{
				alt6=1;
				}
				break;
			case 21:
				{
				alt6=2;
				}
				break;
			case 16:
				{
				alt6=3;
				}
				break;
			case Ident:
			case Int:
			case LEFTBR:
			case String:
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:8: '+' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr406); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr410);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:8: '-' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr421); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr425);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:8: '!' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr436); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr440);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr453);
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
			if ( state.backtracking>0 ) { memoize(input, 15, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException  {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr491);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==19||LA7_0==22) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr511);
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
			if ( state.backtracking>0 ) { memoize(input, 16, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:105:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException  {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr552);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 20 && LA8_0 <= 21)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr570);
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
			if ( state.backtracking>0 ) { memoize(input, 17, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException  {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr605);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==17||(LA9_0 >= 23 && LA9_0 <= 27)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==17||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr629);
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
			if ( state.backtracking>0 ) { memoize(input, 18, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException  {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr667);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:46: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==18) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:48: '&&' rhs= relExpr
					{
					match(input,18,FOLLOW_18_in_andExpr673); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr677);
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
			if ( state.backtracking>0 ) { memoize(input, 19, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException  {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return result; }

			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr712);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:48: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==33) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr718); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr722);
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
			if ( state.backtracking>0 ) { memoize(input, 20, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_formDefinition_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Form_in_formDefinition63 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_formDeclaration_in_formDefinition65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormIdent_in_formDeclaration81 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_formDeclaration83 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_formDeclaration85 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_formDeclaration87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_blockLine_in_blockContent108 = new BitSet(new long[]{0x0000000020000102L});
	public static final BitSet FOLLOW_question_in_blockLine129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_blockLine135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_question151 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assign_in_question153 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_String_in_question155 = new BitSet(new long[]{0x00000001D0000000L});
	public static final BitSet FOLLOW_type_in_question157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_question164 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assign_in_question166 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_String_in_question168 = new BitSet(new long[]{0x00000001D0000000L});
	public static final BitSet FOLLOW_type_in_question170 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_question172 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_orExpr_in_question176 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_question178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifStatement193 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_LEFTBR_in_ifStatement195 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement197 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_ifStatement199 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_LEFTCBR_in_ifStatement201 = new BitSet(new long[]{0x0000000020002100L});
	public static final BitSet FOLLOW_blockContent_in_ifStatement203 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_RIGHTCBR_in_ifStatement205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_ident220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolType_in_type237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_money_in_type245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intType_in_type256 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_strType_in_type264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_intType280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_money296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_boolType311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_strType326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primary354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFTBR_in_primary370 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_orExpr_in_primary374 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RIGHTBR_in_primary376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr406 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr421 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr436 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_unExpr_in_unExpr440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr491 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr499 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr511 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr552 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr560 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr570 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr605 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_set_in_relExpr613 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_addExpr_in_relExpr629 = new BitSet(new long[]{0x000000000F820002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr667 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_andExpr673 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_relExpr_in_andExpr677 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr712 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr718 = new BitSet(new long[]{0x0000000000314700L});
	public static final BitSet FOLLOW_andExpr_in_orExpr722 = new BitSet(new long[]{0x0000000200000002L});
}
