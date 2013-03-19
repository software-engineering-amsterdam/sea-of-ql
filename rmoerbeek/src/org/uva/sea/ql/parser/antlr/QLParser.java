// $ANTLR 3.5 C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-19 09:45:38

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.types.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Boolean", "Ident", "Int", 
		"Inttype", "Money", "MultiLineComment", "SingleLineComment", "String", 
		"StringLit", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'else if'", 
		"'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int Bool=4;
	public static final int Boolean=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Inttype=8;
	public static final int Money=9;
	public static final int MultiLineComment=10;
	public static final int SingleLineComment=11;
	public static final int String=12;
	public static final int StringLit=13;
	public static final int WS=14;

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
		this.state.ruleMemo = new HashMap[50+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }


	  @Override
	  public void reportError(RecognitionException e) {
	  throw new RuntimeException(e);
	  }



	// $ANTLR start "form"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:1: form returns [Form result] : f= 'form' Ident body EOF ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token f=null;
		Token Ident1=null;
		Body body2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:3: (f= 'form' Ident body EOF )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:5: f= 'form' Ident body EOF
			{
			f=(Token)match(input,32,FOLLOW_32_in_form57); if (state.failed) return result;
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form59); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form61);
			body2=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      result = new Form( new Ident((Ident1!=null?Ident1.getText():null)), body2);
			    }
			match(input,EOF,FOLLOW_EOF_in_form65); if (state.failed) return result;
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



	// $ANTLR start "topBody"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: topBody returns [Body result] : body EOF ;
	public final Body topBody() throws RecognitionException {
		Body result = null;

		int topBody_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:3: ( body EOF )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:5: body EOF
			{
			pushFollow(FOLLOW_body_in_topBody84);
			body();
			state._fsp--;
			if (state.failed) return result;
			match(input,EOF,FOLLOW_EOF_in_topBody86); if (state.failed) return result;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, topBody_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topBody"



	// $ANTLR start "body"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:35:2: body returns [Body result] : '{' (s= statement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		Statement s =null;


		    List<Statement> stats = new ArrayList<Statement>();
		  
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:3: ( '{' (s= statement )* '}' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:5: '{' (s= statement )* '}'
			{
			match(input,34,FOLLOW_34_in_body115); if (state.failed) return result;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:9: (s= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||(LA1_0 >= 33 && LA1_0 <= 34)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:10: s= statement
					{
					pushFollow(FOLLOW_statement_in_body120);
					s=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {stats.add(s);}
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,36,FOLLOW_36_in_body126); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Body(stats); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, body_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "body"



	// $ANTLR start "statement"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:2: statement returns [Statement result] : (i= ifStat |q= question |b= body );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		IfStat i =null;
		Question q =null;
		Body b =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:5: (i= ifStat |q= question |b= body )
			int alt2=3;
			switch ( input.LA(1) ) {
			case 33:
				{
				alt2=1;
				}
				break;
			case Ident:
				{
				alt2=2;
				}
				break;
			case 34:
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:7: i= ifStat
					{
					pushFollow(FOLLOW_ifStat_in_statement150);
					i=ifStat();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = i;}
					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:7: q= question
					{
					pushFollow(FOLLOW_question_in_statement162);
					q=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = q;}
					}
					break;
				case 3 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:7: b= body
					{
					pushFollow(FOLLOW_body_in_statement175);
					b=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = b;}
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



	// $ANTLR start "topQuestion"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:1: topQuestion returns [Question result] : question EOF ;
	public final Question topQuestion() throws RecognitionException {
		Question result = null;

		int topQuestion_StartIndex = input.index();

		Question question3 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:3: ( question EOF )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:51:5: question EOF
			{
			pushFollow(FOLLOW_question_in_topQuestion200);
			question3=question();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = question3 ; }
			match(input,EOF,FOLLOW_EOF_in_topQuestion204); if (state.failed) return result;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, topQuestion_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topQuestion"



	// $ANTLR start "question"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:1: question returns [Question result] : (id= Ident ':' label= StringLit t= type '(' expr= orExpr ')' |id= Ident ':' label= StringLit t= type );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token id=null;
		Token label=null;
		Type t =null;
		Expr expr =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:5: (id= Ident ':' label= StringLit t= type '(' expr= orExpr ')' |id= Ident ':' label= StringLit t= type )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Ident) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==24) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==StringLit) ) {
						switch ( input.LA(4) ) {
						case Boolean:
							{
							int LA3_4 = input.LA(5);
							if ( (LA3_4==18) ) {
								alt3=1;
							}
							else if ( (LA3_4==EOF||LA3_4==Ident||(LA3_4 >= 33 && LA3_4 <= 34)||LA3_4==36) ) {
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
						case Money:
							{
							int LA3_5 = input.LA(5);
							if ( (LA3_5==18) ) {
								alt3=1;
							}
							else if ( (LA3_5==EOF||LA3_5==Ident||(LA3_5 >= 33 && LA3_5 <= 34)||LA3_5==36) ) {
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
						case Inttype:
							{
							int LA3_6 = input.LA(5);
							if ( (LA3_6==18) ) {
								alt3=1;
							}
							else if ( (LA3_6==EOF||LA3_6==Ident||(LA3_6 >= 33 && LA3_6 <= 34)||LA3_6==36) ) {
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
						case String:
							{
							int LA3_7 = input.LA(5);
							if ( (LA3_7==18) ) {
								alt3=1;
							}
							else if ( (LA3_7==EOF||LA3_7==Ident||(LA3_7 >= 33 && LA3_7 <= 34)||LA3_7==36) ) {
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:7: id= Ident ':' label= StringLit t= type '(' expr= orExpr ')'
					{
					id=(Token)match(input,Ident,FOLLOW_Ident_in_question227); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question229); if (state.failed) return result;
					label=(Token)match(input,StringLit,FOLLOW_StringLit_in_question235); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question241);
					t=type();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_question243); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_question249);
					expr=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_question251); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ComputedQuestion( new Ident((id!=null?id.getText():null)), (label!=null?label.getText():null), t, expr); }
					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:7: id= Ident ':' label= StringLit t= type
					{
					id=(Token)match(input,Ident,FOLLOW_Ident_in_question269); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question271); if (state.failed) return result;
					label=(Token)match(input,StringLit,FOLLOW_StringLit_in_question277); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question283);
					t=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new NonComputedQuestion(new Ident((id!=null?id.getText():null)), (label!=null?label.getText():null), t) ; }
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



	// $ANTLR start "nonComputedQuestion"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:1: nonComputedQuestion returns [NonComputedQuestion result] : id= Ident ':' label= StringLit t= type ;
	public final NonComputedQuestion nonComputedQuestion() throws RecognitionException {
		NonComputedQuestion result = null;

		int nonComputedQuestion_StartIndex = input.index();

		Token id=null;
		Token label=null;
		Type t =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:5: (id= Ident ':' label= StringLit t= type )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:7: id= Ident ':' label= StringLit t= type
			{
			id=(Token)match(input,Ident,FOLLOW_Ident_in_nonComputedQuestion314); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_nonComputedQuestion316); if (state.failed) return result;
			label=(Token)match(input,StringLit,FOLLOW_StringLit_in_nonComputedQuestion322); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_nonComputedQuestion328);
			t=type();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new NonComputedQuestion(new Ident((id!=null?id.getText():null)), (label!=null?label.getText():null), t) ; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, nonComputedQuestion_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "nonComputedQuestion"



	// $ANTLR start "computedQuestion"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:1: computedQuestion returns [ComputedQuestion result] : id= Ident ':' label= StringLit t= type '(' expr= orExpr ')' ;
	public final ComputedQuestion computedQuestion() throws RecognitionException {
		ComputedQuestion result = null;

		int computedQuestion_StartIndex = input.index();

		Token id=null;
		Token label=null;
		Type t =null;
		Expr expr =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:5: (id= Ident ':' label= StringLit t= type '(' expr= orExpr ')' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:7: id= Ident ':' label= StringLit t= type '(' expr= orExpr ')'
			{
			id=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion359); if (state.failed) return result;
			match(input,24,FOLLOW_24_in_computedQuestion361); if (state.failed) return result;
			label=(Token)match(input,StringLit,FOLLOW_StringLit_in_computedQuestion367); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_computedQuestion373);
			t=type();
			state._fsp--;
			if (state.failed) return result;
			match(input,18,FOLLOW_18_in_computedQuestion375); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_computedQuestion381);
			expr=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_computedQuestion383); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new ComputedQuestion( new Ident((id!=null?id.getText():null)), (label!=null?label.getText():null), t, expr); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, computedQuestion_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "computedQuestion"



	// $ANTLR start "expression"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:1: expression returns [Expr result] : orExpr ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;

		int expression_StartIndex = input.index();

		Expr orExpr4 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:3: ( orExpr )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expression411);
			orExpr4=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = orExpr4; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, expression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:1: primary returns [Expr result] : (i= Int |b= Bool |str= StringLit |id= Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token i=null;
		Token b=null;
		Token str=null;
		Token id=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:5: (i= Int |b= Bool |str= StringLit |id= Ident | '(' x= orExpr ')' )
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
			case StringLit:
				{
				alt4=3;
				}
				break;
			case Ident:
				{
				alt4=4;
				}
				break;
			case 18:
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:7: i= Int
					{
					i=(Token)match(input,Int,FOLLOW_Int_in_primary438); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((i!=null?i.getText():null))) ; }
					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:7: b= Bool
					{
					b=(Token)match(input,Bool,FOLLOW_Bool_in_primary454); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((b!=null?b.getText():null)) ; }
					}
					break;
				case 3 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:7: str= StringLit
					{
					str=(Token)match(input,StringLit,FOLLOW_StringLit_in_primary468); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((str!=null?str.getText():null)) ; }
					}
					break;
				case 4 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:7: id= Ident
					{
					id=(Token)match(input,Ident,FOLLOW_Ident_in_primary482); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((id!=null?id.getText():null)) ; }
					}
					break;
				case 5 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:7: '(' x= orExpr ')'
					{
					match(input,18,FOLLOW_18_in_primary492); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary496);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_primary498); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 10, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:86:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
			case 15:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case StringLit:
			case 18:
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:87:8: '+' x= unExpr
					{
					match(input,21,FOLLOW_21_in_unExpr528); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr532);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:8: '-' x= unExpr
					{
					match(input,22,FOLLOW_22_in_unExpr543); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr547);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:8: '!' x= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr558); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr562);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr575);
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
			if ( state.backtracking>0 ) { memoize(input, 11, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:93:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr613);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==20||LA6_0==23) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr633);
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
			if ( state.backtracking>0 ) { memoize(input, 12, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr674);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 21 && LA7_0 <= 22)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr692);
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
			if ( state.backtracking>0 ) { memoize(input, 13, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:118:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr727);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==16||(LA8_0 >= 25 && LA8_0 <= 29)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:119:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==16||(input.LA(1) >= 25 && input.LA(1) <= 29) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr751);
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
			if ( state.backtracking>0 ) { memoize(input, 14, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr789);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==17) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:48: '&&' rhs= relExpr
					{
					match(input,17,FOLLOW_17_in_andExpr795); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr799);
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
			if ( state.backtracking>0 ) { memoize(input, 15, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:147:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr834);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==35) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr840); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr844);
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
			if ( state.backtracking>0 ) { memoize(input, 16, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "topIfStat"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:1: topIfStat returns [IfStat result] : ifStat ;
	public final IfStat topIfStat() throws RecognitionException {
		IfStat result = null;

		int topIfStat_StartIndex = input.index();

		IfStat ifStat5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:3: ( ifStat )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:5: ifStat
			{
			pushFollow(FOLLOW_ifStat_in_topIfStat872);
			ifStat5=ifStat();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result = ifStat5 ; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, topIfStat_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "topIfStat"



	// $ANTLR start "ifStat"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:159:1: ifStat returns [IfStat result] : 'if' '(' cond= expression ')' iB= body ( 'else if' '(' eCond= expression ')' eiB= body )* ( 'else' eB= body )? ;
	public final IfStat ifStat() throws RecognitionException {
		IfStat result = null;

		int ifStat_StartIndex = input.index();

		Expr cond =null;
		Body iB =null;
		Expr eCond =null;
		Body eiB =null;
		Body eB =null;

		 List<ElseIfStat> elseIfStats = new ArrayList<>() ; 
		  ElseStat elseStat = null ; 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:162:3: ( 'if' '(' cond= expression ')' iB= body ( 'else if' '(' eCond= expression ')' eiB= body )* ( 'else' eB= body )? )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:162:5: 'if' '(' cond= expression ')' iB= body ( 'else if' '(' eCond= expression ')' eiB= body )* ( 'else' eB= body )?
			{
			match(input,33,FOLLOW_33_in_ifStat899); if (state.failed) return result;
			match(input,18,FOLLOW_18_in_ifStat901); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_ifStat907);
			cond=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,19,FOLLOW_19_in_ifStat909); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStat915);
			iB=body();
			state._fsp--;
			if (state.failed) return result;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:163:3: ( 'else if' '(' eCond= expression ')' eiB= body )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==30) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:164:5: 'else if' '(' eCond= expression ')' eiB= body
					{
					match(input,30,FOLLOW_30_in_ifStat925); if (state.failed) return result;
					match(input,18,FOLLOW_18_in_ifStat927); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_ifStat933);
					eCond=expression();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_ifStat935); if (state.failed) return result;
					pushFollow(FOLLOW_body_in_ifStat941);
					eiB=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { elseIfStats.add( new ElseIfStat(eCond, eiB) ) ; }
					}
					break;

				default :
					break loop11;
				}
			}

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:167:3: ( 'else' eB= body )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==31) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:168:5: 'else' eB= body
					{
					match(input,31,FOLLOW_31_in_ifStat962); if (state.failed) return result;
					pushFollow(FOLLOW_body_in_ifStat968);
					eB=body();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { elseStat = new ElseStat(eB) ; }
					}
					break;

			}

			if ( state.backtracking==0 ) { result = new IfStat(cond, iB, elseIfStats, elseStat) ; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, ifStat_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStat"



	// $ANTLR start "type"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:177:1: type returns [Type result] : (b= Boolean |m= Money |i= Inttype |s= String );
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token b=null;
		Token m=null;
		Token i=null;
		Token s=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return result; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:178:5: (b= Boolean |m= Money |i= Inttype |s= String )
			int alt13=4;
			switch ( input.LA(1) ) {
			case Boolean:
				{
				alt13=1;
				}
				break;
			case Money:
				{
				alt13=2;
				}
				break;
			case Inttype:
				{
				alt13=3;
				}
				break;
			case String:
				{
				alt13=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:178:7: b= Boolean
					{
					b=(Token)match(input,Boolean,FOLLOW_Boolean_in_type1009); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BooleanType(); }
					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:179:7: m= Money
					{
					m=(Token)match(input,Money,FOLLOW_Money_in_type1023); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new MoneyType(); }
					}
					break;
				case 3 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:180:7: i= Inttype
					{
					i=(Token)match(input,Inttype,FOLLOW_Inttype_in_type1037); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType(); }
					}
					break;
				case 4 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:181:7: s= String
					{
					s=(Token)match(input,String,FOLLOW_String_in_type1051); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 19, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "comment"
	// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:207:1: comment : ( MultiLineComment | SingleLineComment )+ ;
	public final void comment() throws RecognitionException {
		int comment_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return; }

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:208:5: ( ( MultiLineComment | SingleLineComment )+ )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:208:7: ( MultiLineComment | SingleLineComment )+
			{
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:208:7: ( MultiLineComment | SingleLineComment )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= MultiLineComment && LA14_0 <= SingleLineComment)) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
					{
					if ( (input.LA(1) >= MultiLineComment && input.LA(1) <= SingleLineComment) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 20, comment_StartIndex); }

		}
	}
	// $ANTLR end "comment"

	// Delegated rules



	public static final BitSet FOLLOW_32_in_form57 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form59 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_body_in_form61 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_form65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_topBody84 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topBody86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_body115 = new BitSet(new long[]{0x0000001600000040L});
	public static final BitSet FOLLOW_statement_in_body120 = new BitSet(new long[]{0x0000001600000040L});
	public static final BitSet FOLLOW_36_in_body126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStat_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_body_in_statement175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_topQuestion200 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_topQuestion204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question227 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question229 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_StringLit_in_question235 = new BitSet(new long[]{0x0000000000001320L});
	public static final BitSet FOLLOW_type_in_question241 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_question243 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_orExpr_in_question249 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_question251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question269 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question271 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_StringLit_in_question277 = new BitSet(new long[]{0x0000000000001320L});
	public static final BitSet FOLLOW_type_in_question283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_nonComputedQuestion314 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_nonComputedQuestion316 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_StringLit_in_nonComputedQuestion322 = new BitSet(new long[]{0x0000000000001320L});
	public static final BitSet FOLLOW_type_in_nonComputedQuestion328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion359 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_computedQuestion361 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_StringLit_in_computedQuestion367 = new BitSet(new long[]{0x0000000000001320L});
	public static final BitSet FOLLOW_type_in_computedQuestion373 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_computedQuestion375 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion381 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_computedQuestion383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_expression411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringLit_in_primary468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_primary492 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_orExpr_in_primary496 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_primary498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr528 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr543 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr558 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr613 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_set_in_mulExpr621 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr633 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr674 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_set_in_addExpr682 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr692 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr727 = new BitSet(new long[]{0x000000003E010002L});
	public static final BitSet FOLLOW_set_in_relExpr735 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr751 = new BitSet(new long[]{0x000000003E010002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr789 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_andExpr795 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr799 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr834 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr840 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr844 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_ifStat_in_topIfStat872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ifStat899 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifStat901 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_expression_in_ifStat907 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_ifStat909 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_body_in_ifStat915 = new BitSet(new long[]{0x00000000C0000002L});
	public static final BitSet FOLLOW_30_in_ifStat925 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_ifStat927 = new BitSet(new long[]{0x000000000064A0D0L});
	public static final BitSet FOLLOW_expression_in_ifStat933 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_ifStat935 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_body_in_ifStat941 = new BitSet(new long[]{0x00000000C0000002L});
	public static final BitSet FOLLOW_31_in_ifStat962 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_body_in_ifStat968 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_type1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_type1023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Inttype_in_type1037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_type1051 = new BitSet(new long[]{0x0000000000000002L});
}
