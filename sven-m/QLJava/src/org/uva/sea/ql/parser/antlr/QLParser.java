// $ANTLR 3.5 /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-12 16:49:02

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "DIGIT", "IDENT", "INT", 
		"LETTER", "STRING_LITERAL", "WS", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'boolean'", "'else'", "'form'", "'if'", "'integer'", "'string'", "'{'", 
		"'||'", "'}'"
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
	public static final int T__34=34;
	public static final int COMMENT=4;
	public static final int DIGIT=5;
	public static final int IDENT=6;
	public static final int INT=7;
	public static final int LETTER=8;
	public static final int STRING_LITERAL=9;
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
		this.state.ruleMemo = new HashMap[42+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:1: form returns [Form result] : frm= 'form' IDENT body EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token frm=null;
		Token IDENT1=null;
		Body body2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:3: (frm= 'form' IDENT body EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:5: frm= 'form' IDENT body EOF
			{
			frm=(Token)match(input,28,FOLLOW_28_in_form54); if (state.failed) return result;
			IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_form56); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form58);
			body2=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      result = new Form((IDENT1!=null?IDENT1.getText():null), body2, new Location((frm!=null?frm.getLine():0),
			        0, (frm!=null?frm.getCharPositionInLine():0), 0));
			    }
			match(input,EOF,FOLLOW_EOF_in_form62); if (state.failed) return result;
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "topLevelBody"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: topLevelBody returns [Body result] : body EOF ;
	public final Body topLevelBody() throws RecognitionException {
		Body result = null;

		int topLevelBody_StartIndex = input.index();

		Body body3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:3: ( body EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: body EOF
			{
			pushFollow(FOLLOW_body_in_topLevelBody81);
			body3=body();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelBody83); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = body3; }
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, topLevelBody_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topLevelBody"



	// $ANTLR start "body"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: body returns [Body result] : open= '{' ( formElement )* close= '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		Token open=null;
		Token close=null;
		FormElement formElement4 =null;

		 List<FormElement> tempList = new ArrayList<>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:3: (open= '{' ( formElement )* close= '}' )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: open= '{' ( formElement )* close= '}'
			{
			open=(Token)match(input,32,FOLLOW_32_in_body125); if (state.failed) return result;
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:14: ( formElement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT||LA1_0==29) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:15: formElement
					{
					pushFollow(FOLLOW_formElement_in_body128);
					formElement4=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { tempList.add(formElement4); }
					}
					break;

				default :
					break loop1;
				}
			}

			close=(Token)match(input,34,FOLLOW_34_in_body136); if (state.failed) return result;
			}

			if ( state.backtracking==0 ) {
			      result = new Body(tempList, new Location((open!=null?open.getLine():0), (close!=null?close.getLine():0),
			        (open!=null?open.getCharPositionInLine():0), (close!=null?close.getCharPositionInLine():0) + (close!=null?close.getText():null).length()));
			    }
		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, body_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "body"



	// $ANTLR start "formElement"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: formElement returns [FormElement result] : ( question | ifStatement );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Question question5 =null;
		IfStatement ifStatement6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:3: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IDENT) ) {
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: question
					{
					pushFollow(FOLLOW_question_in_formElement155);
					question5=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question5; }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formElement163);
					ifStatement6=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement6; }
					}
					break;

			}
		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "topLevelFormElement"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: topLevelFormElement returns [FormElement result] : formElement EOF ;
	public final FormElement topLevelFormElement() throws RecognitionException {
		FormElement result = null;

		int topLevelFormElement_StartIndex = input.index();

		FormElement formElement7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:3: ( formElement EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: formElement EOF
			{
			pushFollow(FOLLOW_formElement_in_topLevelFormElement184);
			formElement7=formElement();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelFormElement186); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = formElement7; }
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, topLevelFormElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topLevelFormElement"



	// $ANTLR start "question"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: question returns [Question result] : (id= IDENT ':' lbl= STRING_LITERAL type |id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression close= ')' );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token id=null;
		Token lbl=null;
		Token close=null;
		Expr cond =null;
		Type type8 =null;
		Type type9 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:3: (id= IDENT ':' lbl= STRING_LITERAL type |id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression close= ')' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==20) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==STRING_LITERAL) ) {
						switch ( input.LA(4) ) {
						case 26:
							{
							int LA3_4 = input.LA(5);
							if ( (LA3_4==EOF||LA3_4==IDENT||LA3_4==29||LA3_4==34) ) {
								alt3=1;
							}
							else if ( (LA3_4==14) ) {
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
							if ( (LA3_5==EOF||LA3_5==IDENT||LA3_5==29||LA3_5==34) ) {
								alt3=1;
							}
							else if ( (LA3_5==14) ) {
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
							if ( (LA3_6==EOF||LA3_6==IDENT||LA3_6==29||LA3_6==34) ) {
								alt3=1;
							}
							else if ( (LA3_6==14) ) {
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:5: id= IDENT ':' lbl= STRING_LITERAL type
					{
					id=(Token)match(input,IDENT,FOLLOW_IDENT_in_question209); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_question211); if (state.failed) return result;
					lbl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question215); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question217);
					type8=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Question(
					        new Ident((id!=null?id.getText():null), new Location((id!=null?id.getLine():0), (id!=null?id.getLine():0), (id!=null?id.getCharPositionInLine():0),
					          (id!=null?id.getText():null).length())),
					        (lbl!=null?lbl.getText():null), type8);
					    }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression close= ')'
					{
					id=(Token)match(input,IDENT,FOLLOW_IDENT_in_question231); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_question233); if (state.failed) return result;
					lbl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question237); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question239);
					type9=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,14,FOLLOW_14_in_question241); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_question245);
					cond=expression();
					state._fsp--;
					if (state.failed) return result;
					close=(Token)match(input,15,FOLLOW_15_in_question249); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Computed(
					        new Ident((id!=null?id.getText():null), new Location((id!=null?id.getLine():0), (id!=null?id.getLine():0), (id!=null?id.getCharPositionInLine():0),
					          (id!=null?id.getText():null).length())),
					        (lbl!=null?lbl.getText():null), type9, cond, new Location(0, (close!=null?close.getLine():0), 0,
					          (close!=null?close.getCharPositionInLine():0) + (close!=null?close.getText():null).length()));
					    }
					}
					break;

			}
		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "type"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:1: type returns [Type result] : (boolTok= 'boolean' |strTok= 'string' |intTok= 'integer' );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token boolTok=null;
		Token strTok=null;
		Token intTok=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:3: (boolTok= 'boolean' |strTok= 'string' |intTok= 'integer' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case 26:
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
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:5: boolTok= 'boolean'
					{
					boolTok=(Token)match(input,26,FOLLOW_26_in_type276); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new BoolType(new Location((boolTok!=null?boolTok.getLine():0), (boolTok!=null?boolTok.getLine():0),
					        (boolTok!=null?boolTok.getCharPositionInLine():0), (boolTok!=null?boolTok.getCharPositionInLine():0) + (boolTok!=null?boolTok.getText():null).length()));
					    }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: strTok= 'string'
					{
					strTok=(Token)match(input,31,FOLLOW_31_in_type290); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new StrType(new Location((strTok!=null?strTok.getLine():0), (strTok!=null?strTok.getLine():0),
					        (strTok!=null?strTok.getCharPositionInLine():0), (strTok!=null?strTok.getCharPositionInLine():0) + (strTok!=null?strTok.getText():null).length()));
					    }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: intTok= 'integer'
					{
					intTok=(Token)match(input,30,FOLLOW_30_in_type304); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new IntType(new Location((intTok!=null?intTok.getLine():0), (intTok!=null?intTok.getLine():0),
					        (intTok!=null?intTok.getCharPositionInLine():0), (intTok!=null?intTok.getCharPositionInLine():0) + (intTok!=null?intTok.getText():null).length()));
					    }
					}
					break;

			}
		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "ifStatement"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: ifStatement returns [IfStatement result] : ifTok= 'if' '(' ic= expression ')' ib= body (elseIfTok= 'else' 'if' '(' eic= expression ')' eib= body )* (elseTok= 'else' eb= body )? ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Token ifTok=null;
		Token elseIfTok=null;
		Token elseTok=null;
		Expr ic =null;
		Body ib =null;
		Expr eic =null;
		Body eib =null;
		Body eb =null;


		    List<ElseIfStatement> elseIfs = new ArrayList<>();
		    ElseStatement elseStmt = null;
		  
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:3: (ifTok= 'if' '(' ic= expression ')' ib= body (elseIfTok= 'else' 'if' '(' eic= expression ')' eib= body )* (elseTok= 'else' eb= body )? )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: ifTok= 'if' '(' ic= expression ')' ib= body (elseIfTok= 'else' 'if' '(' eic= expression ')' eib= body )* (elseTok= 'else' eb= body )?
			{
			ifTok=(Token)match(input,29,FOLLOW_29_in_ifStatement336); if (state.failed) return result;
			match(input,14,FOLLOW_14_in_ifStatement338); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_ifStatement342);
			ic=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement344); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStatement348);
			ib=body();
			state._fsp--;
			if (state.failed) return result;
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: (elseIfTok= 'else' 'if' '(' eic= expression ')' eib= body )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==27) ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1==29) ) {
						alt5=1;
					}

				}

				switch (alt5) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:7: elseIfTok= 'else' 'if' '(' eic= expression ')' eib= body
					{
					elseIfTok=(Token)match(input,27,FOLLOW_27_in_ifStatement364); if (state.failed) return result;
					match(input,29,FOLLOW_29_in_ifStatement366); if (state.failed) return result;
					match(input,14,FOLLOW_14_in_ifStatement368); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_ifStatement372);
					eic=expression();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_ifStatement374); if (state.failed) return result;
					pushFollow(FOLLOW_body_in_ifStatement378);
					eib=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					        elseIfs.add(new ElseIfStatement(eic, eib,
					          new Location((elseIfTok!=null?elseIfTok.getLine():0), 0, (elseIfTok!=null?elseIfTok.getCharPositionInLine():0), 0)));
					      }
					}
					break;

				default :
					break loop5;
				}
			}

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (elseTok= 'else' eb= body )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==27) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:7: elseTok= 'else' eb= body
					{
					elseTok=(Token)match(input,27,FOLLOW_27_in_ifStatement409); if (state.failed) return result;
					pushFollow(FOLLOW_body_in_ifStatement413);
					eb=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					        elseStmt = new ElseStatement(eb, new Location((elseTok!=null?elseTok.getLine():0),
					          0, (elseTok!=null?elseTok.getCharPositionInLine():0), 0));
					      }
					}
					break;

			}

			if ( state.backtracking==0 ) {
			      result = new IfStatement(ic, ib, elseIfs, elseStmt,
			        new Location((ifTok!=null?ifTok.getLine():0), 0, (ifTok!=null?ifTok.getCharPositionInLine():0), 0)); 
			    }
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "topLevelExpression"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: topLevelExpression returns [Expr result] : expression EOF ;
	public final Expr topLevelExpression() throws RecognitionException {
		Expr result = null;

		int topLevelExpression_StartIndex = input.index();

		Expr expression10 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:3: ( expression EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: expression EOF
			{
			pushFollow(FOLLOW_expression_in_topLevelExpression451);
			expression10=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelExpression453); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = expression10; }
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, topLevelExpression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topLevelExpression"



	// $ANTLR start "expression"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:1: expression returns [Expr result] : orExpr ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;

		int expression_StartIndex = input.index();

		Expr orExpr11 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:3: ( orExpr )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:5: orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expression472);
			orExpr11=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = orExpr11; }
			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, expression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:1: primary returns [Expr result] : ( INT | IDENT | STRING_LITERAL | '(' orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token INT12=null;
		Token IDENT13=null;
		Token STRING_LITERAL14=null;
		Expr orExpr15 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:3: ( INT | IDENT | STRING_LITERAL | '(' orExpr ')' )
			int alt7=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt7=1;
				}
				break;
			case IDENT:
				{
				alt7=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt7=3;
				}
				break;
			case 14:
				{
				alt7=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: INT
					{
					INT12=(Token)match(input,INT,FOLLOW_INT_in_primary491); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Int(Integer.parseInt((INT12!=null?INT12.getText():null)), new Location((INT12!=null?INT12.getLine():0),
					        (INT12!=null?INT12.getLine():0), (INT12!=null?INT12.getCharPositionInLine():0), (INT12!=null?INT12.getText():null).length()));
					    }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: IDENT
					{
					IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary503); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Ident((IDENT13!=null?IDENT13.getText():null), new Location((IDENT13!=null?IDENT13.getLine():0), (IDENT13!=null?IDENT13.getLine():0),
					          (IDENT13!=null?IDENT13.getCharPositionInLine():0), (IDENT13!=null?IDENT13.getCharPositionInLine():0) + (IDENT13!=null?IDENT13.getText():null).length()));
					    }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:137:5: STRING_LITERAL
					{
					STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_primary515); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Str((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null),
					        new Location((STRING_LITERAL14!=null?STRING_LITERAL14.getLine():0), (STRING_LITERAL14!=null?STRING_LITERAL14.getLine():0),
					        (STRING_LITERAL14!=null?STRING_LITERAL14.getCharPositionInLine():0), (STRING_LITERAL14!=null?STRING_LITERAL14.getText():null).length()));
					    }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:143:5: '(' orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary527); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary529);
					orExpr15=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary531); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = orExpr15; }
					}
					break;

			}
		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:146:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt8=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt8=1;
				}
				break;
			case 18:
				{
				alt8=2;
				}
				break;
			case 11:
				{
				alt8=3;
				}
				break;
			case IDENT:
			case INT:
			case STRING_LITERAL:
			case 14:
				{
				alt8=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:5: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr554); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr558);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:148:5: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr566); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr570);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:5: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr578); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr582);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:5: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr592);
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
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:153:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:5: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr624);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:41: (op= ( '*' | '/' ) rhs= unExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==16||LA9_0==19) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:43: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr644);
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
					break loop9;
				}
			}

			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:167:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:167:5: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr678);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:167:42: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:167:44: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr696);
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
					break loop10;
				}
			}

			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:178:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:5: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr724);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:5: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 25)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:7: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr762);
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
					break loop11;
				}
			}

			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:203:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:204:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:204:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr794);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:205:5: ( '&&' rhs= relExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==13) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:205:7: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr804); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr808);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
					}
					break;

				default :
					break loop12;
				}
			}

			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:209:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:210:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:210:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr837);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:211:5: ( '||' rhs= andExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==33) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:211:7: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr847); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr851);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop13;
				}
			}

			}

		}

		  catch (RecognitionException re) {
		    reportError(re);
		    recover(input,re);
		    throw re;
		  }

		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_28_in_form54 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_IDENT_in_form56 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_body_in_form58 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_topLevelBody81 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelBody83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_body125 = new BitSet(new long[]{0x0000000420000040L});
	public static final BitSet FOLLOW_formElement_in_body128 = new BitSet(new long[]{0x0000000420000040L});
	public static final BitSet FOLLOW_34_in_body136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formElement163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_topLevelFormElement184 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelFormElement186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question209 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question211 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_question215 = new BitSet(new long[]{0x00000000C4000000L});
	public static final BitSet FOLLOW_type_in_question217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question231 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question233 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_question237 = new BitSet(new long[]{0x00000000C4000000L});
	public static final BitSet FOLLOW_type_in_question239 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_question241 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_expression_in_question245 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_question249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_type290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_type304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_ifStatement336 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement338 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_expression_in_ifStatement342 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement344 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_body_in_ifStatement348 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_ifStatement364 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_ifStatement366 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement368 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_expression_in_ifStatement372 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement374 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_body_in_ifStatement378 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_ifStatement409 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_body_in_ifStatement413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_topLevelExpression451 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelExpression453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_expression472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_primary515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary527 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_orExpr_in_primary529 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr554 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr566 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr578 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr624 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr632 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr644 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr678 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr686 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr696 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr724 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr736 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr762 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr794 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr804 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr808 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr837 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr847 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr851 = new BitSet(new long[]{0x0000000200000002L});
}
