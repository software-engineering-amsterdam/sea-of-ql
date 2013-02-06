// $ANTLR 3.5 /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-05 13:25:50

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.type.*;
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
		"'boolean'", "'form'", "'if'", "'integer'", "'string'", "'{'", "'||'", 
		"'}'"
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
		this.state.ruleMemo = new HashMap[40+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	    @Override
	    public void reportError(RecognitionException e) {
	      throw new RuntimeException(e);
	    }



	// $ANTLR start "form"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: form returns [QLForm result] : 'form' IDENT body EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token IDENT1=null;
		Body body2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:3: ( 'form' IDENT body EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:5: 'form' IDENT body EOF
			{
			match(input,27,FOLLOW_27_in_form61); if (state.failed) return result;
			IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_form63); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form65);
			body2=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form((IDENT1!=null?IDENT1.getText():null), body2); }
			match(input,EOF,FOLLOW_EOF_in_form69); if (state.failed) return result;
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: topLevelBody returns [Body result] : body EOF ;
	public final Body topLevelBody() throws RecognitionException {
		Body result = null;

		int topLevelBody_StartIndex = input.index();

		Body body3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:3: ( body EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: body EOF
			{
			pushFollow(FOLLOW_body_in_topLevelBody88);
			body3=body();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelBody90); if (state.failed) return result;
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: body returns [Body result] : '{' ( formElement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		FormElement formElement4 =null;

		 List<FormElement> tempList = new ArrayList<FormElement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:3: ( '{' ( formElement )* '}' )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: '{' ( formElement )* '}'
			{
			match(input,31,FOLLOW_31_in_body126); if (state.failed) return result;
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:9: ( formElement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT||LA1_0==28) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:10: formElement
					{
					pushFollow(FOLLOW_formElement_in_body129);
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

			match(input,33,FOLLOW_33_in_body135); if (state.failed) return result;
			}

			if ( state.backtracking==0 ) { result = new Body(tempList); }
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: formElement returns [FormElement result] : ( question | ifStatement );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Question question5 =null;
		IfStatement ifStatement6 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IDENT) ) {
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: question
					{
					pushFollow(FOLLOW_question_in_formElement154);
					question5=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question5; }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formElement162);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: topLevelFormElement returns [FormElement result] : formElement EOF ;
	public final FormElement topLevelFormElement() throws RecognitionException {
		FormElement result = null;

		int topLevelFormElement_StartIndex = input.index();

		FormElement formElement7 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:3: ( formElement EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: formElement EOF
			{
			pushFollow(FOLLOW_formElement_in_topLevelFormElement183);
			formElement7=formElement();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelFormElement185); if (state.failed) return result;
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: question returns [Question result] : (id= IDENT ':' lbl= STRING_LITERAL type |id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression ')' );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token id=null;
		Token lbl=null;
		Expr cond =null;
		ExprType type8 =null;
		ExprType type9 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:3: (id= IDENT ':' lbl= STRING_LITERAL type |id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression ')' )
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
							if ( (LA3_4==EOF||LA3_4==IDENT||LA3_4==28||LA3_4==33) ) {
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
						case 30:
							{
							int LA3_5 = input.LA(5);
							if ( (LA3_5==EOF||LA3_5==IDENT||LA3_5==28||LA3_5==33) ) {
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
						case 29:
							{
							int LA3_6 = input.LA(5);
							if ( (LA3_6==EOF||LA3_6==IDENT||LA3_6==28||LA3_6==33) ) {
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: id= IDENT ':' lbl= STRING_LITERAL type
					{
					id=(Token)match(input,IDENT,FOLLOW_IDENT_in_question208); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_question210); if (state.failed) return result;
					lbl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question214); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question216);
					type8=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Question(new Ident((id!=null?id.getText():null)), (lbl!=null?lbl.getText():null), type8);
					    }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: id= IDENT ':' lbl= STRING_LITERAL type '(' cond= expression ')'
					{
					id=(Token)match(input,IDENT,FOLLOW_IDENT_in_question230); if (state.failed) return result;
					match(input,20,FOLLOW_20_in_question232); if (state.failed) return result;
					lbl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question236); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question238);
					type9=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,14,FOLLOW_14_in_question240); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_question244);
					cond=expression();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_question246); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Computed(new Ident((id!=null?id.getText():null)), (lbl!=null?lbl.getText():null),
					        type9, cond);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: type returns [ExprType result] : ( 'boolean' | 'string' | 'integer' );
	public final ExprType type() throws RecognitionException {
		ExprType result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:3: ( 'boolean' | 'string' | 'integer' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt4=1;
				}
				break;
			case 30:
				{
				alt4=2;
				}
				break;
			case 29:
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: 'boolean'
					{
					match(input,26,FOLLOW_26_in_type271); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolType(); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: 'string'
					{
					match(input,30,FOLLOW_30_in_type279); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrType(); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: 'integer'
					{
					match(input,29,FOLLOW_29_in_type287); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType(); }
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: ifStatement returns [IfStatement result] : 'if' '(' expression ')' body ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr expression10 =null;
		Body body11 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:3: ( 'if' '(' expression ')' body )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: 'if' '(' expression ')' body
			{
			match(input,28,FOLLOW_28_in_ifStatement306); if (state.failed) return result;
			match(input,14,FOLLOW_14_in_ifStatement308); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_ifStatement310);
			expression10=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement312); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStatement314);
			body11=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      result = new IfStatement(expression10, body11);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: topLevelExpression returns [Expr result] : expression EOF ;
	public final Expr topLevelExpression() throws RecognitionException {
		Expr result = null;

		int topLevelExpression_StartIndex = input.index();

		Expr expression12 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:3: ( expression EOF )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:5: expression EOF
			{
			pushFollow(FOLLOW_expression_in_topLevelExpression337);
			expression12=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topLevelExpression339); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = expression12; }
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: expression returns [Expr result] : orExpr ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;

		int expression_StartIndex = input.index();

		Expr orExpr13 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:3: ( orExpr )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expression358);
			orExpr13=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = orExpr13; }
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: primary returns [Expr result] : ( INT | IDENT | STRING_LITERAL | '(' orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token INT14=null;
		Token IDENT15=null;
		Token STRING_LITERAL16=null;
		Expr orExpr17 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:3: ( INT | IDENT | STRING_LITERAL | '(' orExpr ')' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt5=1;
				}
				break;
			case IDENT:
				{
				alt5=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt5=3;
				}
				break;
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: INT
					{
					INT14=(Token)match(input,INT,FOLLOW_INT_in_primary377); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INT14!=null?INT14.getText():null))); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: IDENT
					{
					IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary387); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((IDENT15!=null?IDENT15.getText():null)); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:5: STRING_LITERAL
					{
					STRING_LITERAL16=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_primary395); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((STRING_LITERAL16!=null?STRING_LITERAL16.getText():null)); }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: '(' orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary403); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary405);
					orExpr17=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary407); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = orExpr17; }
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
			case IDENT:
			case INT:
			case STRING_LITERAL:
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr430); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr434);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:5: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr442); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr446);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr454); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr458);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr468);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr500);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:41: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==16||LA7_0==19) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:43: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr520);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:5: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr554);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:42: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 17 && LA8_0 <= 18)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:44: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr572);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:5: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr600);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:5: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==12||(LA9_0 >= 21 && LA9_0 <= 25)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:7: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr638);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:155:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:155:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr670);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:5: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==13) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:7: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr680); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr684);
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
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:161:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:161:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr713);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:5: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==32) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:7: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr723); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr727);
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



	public static final BitSet FOLLOW_27_in_form61 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_IDENT_in_form63 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_form65 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_topLevelBody88 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelBody90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_body126 = new BitSet(new long[]{0x0000000210000040L});
	public static final BitSet FOLLOW_formElement_in_body129 = new BitSet(new long[]{0x0000000210000040L});
	public static final BitSet FOLLOW_33_in_body135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formElement162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_formElement_in_topLevelFormElement183 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelFormElement185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question208 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question210 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_question214 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_type_in_question216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question230 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question232 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_question236 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_type_in_question238 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_question240 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_expression_in_question244 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_question246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_type279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_type287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_ifStatement306 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement308 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_expression_in_ifStatement310 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement312 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_ifStatement314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_topLevelExpression337 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topLevelExpression339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_expression358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_primary395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary403 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_orExpr_in_primary405 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr430 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr442 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr454 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr500 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr508 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr520 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr554 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr562 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr572 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr600 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr612 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr638 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr670 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr680 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr684 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr713 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr723 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr727 = new BitSet(new long[]{0x0000000100000002L});
}
