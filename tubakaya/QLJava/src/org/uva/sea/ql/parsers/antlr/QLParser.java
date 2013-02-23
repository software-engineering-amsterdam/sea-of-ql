// $ANTLR 3.5 C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g 2013-02-23 14:40:09

package org.uva.sea.ql.parsers.antlr;
import org.uva.sea.ql.core.dom.*; 
import org.uva.sea.ql.core.dom.operators.*;
import org.uva.sea.ql.core.dom.operators.arithmetic.*;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.core.dom.operators.relational.*;
import org.uva.sea.ql.core.dom.operators.unary.*;
import org.uva.sea.ql.core.dom.statements.*;
import org.uva.sea.ql.core.dom.types.declarations.*;
import org.uva.sea.ql.core.dom.types.primitive.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL", "COLON", "COMMENT", "FORM", 
		"IDENT", "INT", "STRING", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", 
		"'if'", "'integer'", "'string'", "'{'", "'||'", "'}'"
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
	public static final int BOOL=4;
	public static final int COLON=5;
	public static final int COMMENT=6;
	public static final int FORM=7;
	public static final int IDENT=8;
	public static final int INT=9;
	public static final int STRING=10;
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
		this.state.ruleMemo = new HashMap[38+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g"; }



	// $ANTLR start "form"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:24:1: form returns [Form result] : FORM IDENT '{' elements= statementList '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		List<Statement> elements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:25:3: ( FORM IDENT '{' elements= statementList '}' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:25:5: FORM IDENT '{' elements= statementList '}'
			{
			match(input,FORM,FOLLOW_FORM_in_form48); if (state.failed) return result;
			match(input,IDENT,FOLLOW_IDENT_in_form50); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form52); if (state.failed) return result;
			pushFollow(FOLLOW_statementList_in_form56);
			elements=statementList();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form58); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form(elements); }
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
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "statementList"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:28:1: statementList returns [List<Statement> result] : (element= statement )* ;
	public final List<Statement> statementList() throws RecognitionException {
		List<Statement> result = null;

		int statementList_StartIndex = input.index();

		Statement element =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:29:3: ( (element= statement )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:29:5: (element= statement )*
			{
			if ( state.backtracking==0 ) {result = new ArrayList<Statement>();}
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:29:45: (element= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT||LA1_0==27) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:29:46: element= statement
					{
					pushFollow(FOLLOW_statement_in_statementList82);
					element=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(element);}
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
			if ( state.backtracking>0 ) { memoize(input, 2, statementList_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statementList"



	// $ANTLR start "ifStatement"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:32:1: ifStatement returns [IfStatement result] : 'if' '(' x= orExpr ')' '{' statements= statementList '}' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expression x =null;
		List<Statement> statements =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:33:3: ( 'if' '(' x= orExpr ')' '{' statements= statementList '}' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:33:4: 'if' '(' x= orExpr ')' '{' statements= statementList '}'
			{
			match(input,27,FOLLOW_27_in_ifStatement104); if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement106); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_ifStatement110);
			x=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,16,FOLLOW_16_in_ifStatement112); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_ifStatement114); if (state.failed) return result;
			pushFollow(FOLLOW_statementList_in_ifStatement120);
			statements=statementList();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_ifStatement122); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new IfStatement(x,statements);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "statement"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:36:1: statement returns [Statement result] : ( question | computedValue | ifStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Question question1 =null;
		ComputedValue computedValue2 =null;
		IfStatement ifStatement3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:37:3: ( question | computedValue | ifStatement )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IDENT) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==COLON) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==STRING) ) {
						switch ( input.LA(4) ) {
						case 26:
							{
							int LA2_5 = input.LA(5);
							if ( (LA2_5==EOF||LA2_5==IDENT||LA2_5==27||LA2_5==32) ) {
								alt2=1;
							}
							else if ( (LA2_5==15) ) {
								alt2=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 28:
							{
							int LA2_6 = input.LA(5);
							if ( (LA2_6==EOF||LA2_6==IDENT||LA2_6==27||LA2_6==32) ) {
								alt2=1;
							}
							else if ( (LA2_6==15) ) {
								alt2=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

							}
							break;
						case 29:
							{
							int LA2_7 = input.LA(5);
							if ( (LA2_7==EOF||LA2_7==IDENT||LA2_7==27||LA2_7==32) ) {
								alt2=1;
							}
							else if ( (LA2_7==15) ) {
								alt2=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 7, input);
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
			else if ( (LA2_0==27) ) {
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:37:5: question
					{
					pushFollow(FOLLOW_question_in_statement146);
					question1=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question1; }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:38:5: computedValue
					{
					pushFollow(FOLLOW_computedValue_in_statement154);
					computedValue2=computedValue();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = computedValue2; }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:39:5: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_statement163);
					ifStatement3=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement3; }
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



	// $ANTLR start "computedValue"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:42:1: computedValue returns [ComputedValue result] : IDENT COLON STRING type '(' x= orExpr ')' ;
	public final ComputedValue computedValue() throws RecognitionException {
		ComputedValue result = null;

		int computedValue_StartIndex = input.index();

		Token IDENT4=null;
		Token STRING6=null;
		Expression x =null;
		TypeDeclaration type5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:43:3: ( IDENT COLON STRING type '(' x= orExpr ')' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:43:5: IDENT COLON STRING type '(' x= orExpr ')'
			{
			IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_computedValue182); if (state.failed) return result;
			match(input,COLON,FOLLOW_COLON_in_computedValue184); if (state.failed) return result;
			STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_computedValue186); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_computedValue188);
			type5=type();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_computedValue190); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedValue194);
			x=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,16,FOLLOW_16_in_computedValue196); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new ComputedValue(new Variable(new Identifier((IDENT4!=null?IDENT4.getText():null)),type5), new StringLiteral((STRING6!=null?STRING6.getText():null)), x);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, computedValue_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedValue"



	// $ANTLR start "question"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:46:1: question returns [Question result] : IDENT COLON STRING type ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token IDENT7=null;
		Token STRING9=null;
		TypeDeclaration type8 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:47:3: ( IDENT COLON STRING type )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:47:5: IDENT COLON STRING type
			{
			IDENT7=(Token)match(input,IDENT,FOLLOW_IDENT_in_question215); if (state.failed) return result;
			match(input,COLON,FOLLOW_COLON_in_question217); if (state.failed) return result;
			STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_question219); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question221);
			type8=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Variable(new Identifier((IDENT7!=null?IDENT7.getText():null)),type8), new StringLiteral((STRING9!=null?STRING9.getText():null)));}
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



	// $ANTLR start "type"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:50:1: type returns [TypeDeclaration result] : (x= 'boolean' |x= 'integer' |x= 'string' );
	public final TypeDeclaration type() throws RecognitionException {
		TypeDeclaration result = null;

		int type_StartIndex = input.index();

		Token x=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:51:3: (x= 'boolean' |x= 'integer' |x= 'string' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt3=1;
				}
				break;
			case 28:
				{
				alt3=2;
				}
				break;
			case 29:
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:51:5: x= 'boolean'
					{
					x=(Token)match(input,26,FOLLOW_26_in_type242); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new BooleanDeclaration(); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:52:5: x= 'integer'
					{
					x=(Token)match(input,28,FOLLOW_28_in_type252); if (state.failed) return result;
					if ( state.backtracking==0 ) {result =new IntDeclaration();}
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:53:5: x= 'string'
					{
					x=(Token)match(input,29,FOLLOW_29_in_type262); if (state.failed) return result;
					if ( state.backtracking==0 ) {result =new StringDeclaration();}
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
			if ( state.backtracking>0 ) { memoize(input, 7, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "primary"
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:56:1: primary returns [Expression result] : ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' );
	public final Expression primary() throws RecognitionException {
		Expression result = null;

		int primary_StartIndex = input.index();

		Token INT10=null;
		Token BOOL11=null;
		Token STRING12=null;
		Token IDENT13=null;
		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:57:3: ( INT | BOOL | STRING | IDENT | '(' x= orExpr ')' )
			int alt4=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt4=1;
				}
				break;
			case BOOL:
				{
				alt4=2;
				}
				break;
			case STRING:
				{
				alt4=3;
				}
				break;
			case IDENT:
				{
				alt4=4;
				}
				break;
			case 15:
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:57:5: INT
					{
					INT10=(Token)match(input,INT,FOLLOW_INT_in_primary283); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntLiteral((INT10!=null?INT10.getText():null)); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:58:5: BOOL
					{
					BOOL11=(Token)match(input,BOOL,FOLLOW_BOOL_in_primary293); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanLiteral((BOOL11!=null?BOOL11.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:59:5: STRING
					{
					STRING12=(Token)match(input,STRING,FOLLOW_STRING_in_primary303); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new StringLiteral((STRING12!=null?STRING12.getText():null));}
					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:60:5: IDENT
					{
					IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary311); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Identifier((IDENT13!=null?IDENT13.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:61:5: '(' x= orExpr ')'
					{
					match(input,15,FOLLOW_15_in_primary319); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary323);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,16,FOLLOW_16_in_primary325); if (state.failed) return result;
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:64:1: unExpr returns [Expression result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expression unExpr() throws RecognitionException {
		Expression result = null;

		int unExpr_StartIndex = input.index();

		Expression x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:65:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 18:
				{
				alt5=1;
				}
				break;
			case 19:
				{
				alt5=2;
				}
				break;
			case 12:
				{
				alt5=3;
				}
				break;
			case BOOL:
			case IDENT:
			case INT:
			case STRING:
			case 15:
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
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:65:8: '+' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr350); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr354);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:66:8: '-' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr365); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr369);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:67:8: '!' x= unExpr
					{
					match(input,12,FOLLOW_12_in_unExpr380); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr384);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:68:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr398);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:71:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expression mulExpr() throws RecognitionException {
		Expression result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr436);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==17||LA6_0==20) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:72:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr456);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:84:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expression addExpr() throws RecognitionException {
		Expression result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:85:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:85:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr498);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:85:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 18 && LA7_0 <= 19)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:85:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr516);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:96:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expression relExpr() throws RecognitionException {
		Expression result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:97:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:97:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr551);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:97:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==13||(LA8_0 >= 21 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:97:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==13||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr575);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:120:1: andExpr returns [Expression result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expression andExpr() throws RecognitionException {
		Expression result = null;

		int andExpr_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:121:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:121:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr613);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:121:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==14) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:121:48: '&&' rhs= relExpr
					{
					match(input,14,FOLLOW_14_in_andExpr619); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr623);
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
	// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:125:1: orExpr returns [Expression result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expression orExpr() throws RecognitionException {
		Expression result = null;

		int orExpr_StartIndex = input.index();

		Expression lhs =null;
		Expression rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:126:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:126:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr658);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:126:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==31) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:126:50: '||' rhs= andExpr
					{
					match(input,31,FOLLOW_31_in_orExpr664); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr668);
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

	// Delegated rules



	public static final BitSet FOLLOW_FORM_in_form48 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_IDENT_in_form50 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form52 = new BitSet(new long[]{0x0000000108000100L});
	public static final BitSet FOLLOW_statementList_in_form56 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form58 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statementList82 = new BitSet(new long[]{0x0000000008000102L});
	public static final BitSet FOLLOW_27_in_ifStatement104 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement106 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement110 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_ifStatement112 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifStatement114 = new BitSet(new long[]{0x0000000108000100L});
	public static final BitSet FOLLOW_statementList_in_ifStatement120 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifStatement122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedValue_in_statement154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_computedValue182 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_computedValue184 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_STRING_in_computedValue186 = new BitSet(new long[]{0x0000000034000000L});
	public static final BitSet FOLLOW_type_in_computedValue188 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_computedValue190 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_orExpr_in_computedValue194 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_computedValue196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question215 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_COLON_in_question217 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_STRING_in_question219 = new BitSet(new long[]{0x0000000034000000L});
	public static final BitSet FOLLOW_type_in_question221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_type262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_primary293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_primary303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_primary319 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_orExpr_in_primary323 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_primary325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr350 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr365 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_unExpr380 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr436 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_set_in_mulExpr444 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr456 = new BitSet(new long[]{0x0000000000120002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr498 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_set_in_addExpr506 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr516 = new BitSet(new long[]{0x00000000000C0002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr551 = new BitSet(new long[]{0x0000000003E02002L});
	public static final BitSet FOLLOW_set_in_relExpr559 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_addExpr_in_relExpr575 = new BitSet(new long[]{0x0000000003E02002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr613 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_andExpr619 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_relExpr_in_andExpr623 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr658 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr664 = new BitSet(new long[]{0x00000000000C9710L});
	public static final BitSet FOLLOW_andExpr_in_orExpr668 = new BitSet(new long[]{0x0000000080000002L});
}
