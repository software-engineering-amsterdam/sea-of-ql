// $ANTLR 3.5 src/main/org/uva/sea/ql/parser/antlr/QL.g 2013-02-11 20:52:29

package eu.karuza.ql.parser.antlr;


import org.antlr.runtime.*;

import eu.karuza.ql.ast.*;
import eu.karuza.ql.ast.expr.*;
import eu.karuza.ql.ast.expr.grouping.*;
import eu.karuza.ql.ast.expr.type.*;
import eu.karuza.ql.ast.expr.value.*;
import eu.karuza.ql.error.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN_VALUE", "COMMENT", "IF", 
		"INT_VALUE", "Ident", "MONEY_VALUE", "NL", "STRING_VALUE", "TYPE", "WS", 
		"'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'{'", "'||'", "'}'"
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
	public static final int BOOLEAN_VALUE=4;
	public static final int COMMENT=5;
	public static final int IF=6;
	public static final int INT_VALUE=7;
	public static final int Ident=8;
	public static final int MONEY_VALUE=9;
	public static final int NL=10;
	public static final int STRING_VALUE=11;
	public static final int TYPE=12;
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
		this.state.ruleMemo = new HashMap[36+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/org/uva/sea/ql/parser/antlr/QL.g"; }


	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e); 
	  }



	// $ANTLR start "form"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:35:1: form returns [Form result] : 'form' lbl= Ident '{' stmts= statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token lbl=null;
		List<Statement> stmts =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( 'form' lbl= Ident '{' stmts= statements '}' )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:36:7: 'form' lbl= Ident '{' stmts= statements '}'
			{
			match(input,29,FOLLOW_29_in_form67); if (state.failed) return result;
			lbl=(Token)match(input,Ident,FOLLOW_Ident_in_form71); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form73); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form77);
			stmts=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form79); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form((lbl!=null?lbl.getText():null), stmts ); }
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



	// $ANTLR start "statements"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:39:1: statements returns [List<Statement> result] : (stmt= statement )* ;
	public final List<Statement> statements() throws RecognitionException {
		List<Statement> result = null;

		int statements_StartIndex = input.index();

		Statement stmt =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:40:5: ( (stmt= statement )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:40:8: (stmt= statement )*
			{
			if ( state.backtracking==0 ) { result = new ArrayList<Statement>(); }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:40:50: (stmt= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IF||LA1_0==Ident) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:40:51: stmt= statement
					{
					pushFollow(FOLLOW_statement_in_statements108);
					stmt=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result.add(stmt); }
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
			if ( state.backtracking>0 ) { memoize(input, 2, statements_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:43:1: statement returns [Statement result] : (firstToken= IF (x= expr ) '{' stmts= statements '}' | question );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Token firstToken=null;
		Expr x =null;
		List<Statement> stmts =null;
		Question question1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:44:5: (firstToken= IF (x= expr ) '{' stmts= statements '}' | question )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IF) ) {
				alt2=1;
			}
			else if ( (LA2_0==Ident) ) {
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
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:44:7: firstToken= IF (x= expr ) '{' stmts= statements '}'
					{
					firstToken=(Token)match(input,IF,FOLLOW_IF_in_statement138); if (state.failed) return result;
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:44:21: (x= expr )
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:44:22: x= expr
					{
					pushFollow(FOLLOW_expr_in_statement143);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					}

					match(input,30,FOLLOW_30_in_statement146); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement150);
					stmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_statement152); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ConditionalStatement(x, stmts, (firstToken!=null?firstToken.getLine():0)); }
					}
					break;
				case 2 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:45:7: question
					{
					pushFollow(FOLLOW_question_in_statement162);
					question1=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = question1; }
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
			if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "question"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:48:1: question returns [Question result] : (name= Ident ':' label= STRING_VALUE qt= type |name= Ident ':' label= STRING_VALUE ex= expr );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token name=null;
		Token label=null;
		Type qt =null;
		Expr ex =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:49:5: (name= Ident ':' label= STRING_VALUE qt= type |name= Ident ':' label= STRING_VALUE ex= expr )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Ident) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==23) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==STRING_VALUE) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==TYPE) ) {
							alt3=1;
						}
						else if ( (LA3_3==BOOLEAN_VALUE||(LA3_3 >= INT_VALUE && LA3_3 <= MONEY_VALUE)||LA3_3==STRING_VALUE||LA3_3==14||LA3_3==17||(LA3_3 >= 20 && LA3_3 <= 21)) ) {
							alt3=2;
						}

						else {
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
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:49:7: name= Ident ':' label= STRING_VALUE qt= type
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question187); if (state.failed) return result;
					match(input,23,FOLLOW_23_in_question188); if (state.failed) return result;
					label=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_question192); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question196);
					qt=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new AnswerableQuestion((name!=null?name.getText():null), (label!=null?label.getText():null), qt, (name!=null?name.getLine():0) ); }
					}
					break;
				case 2 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:51:7: name= Ident ':' label= STRING_VALUE ex= expr
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question215); if (state.failed) return result;
					match(input,23,FOLLOW_23_in_question216); if (state.failed) return result;
					label=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_question220); if (state.failed) return result;
					pushFollow(FOLLOW_expr_in_question224);
					ex=expr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ComputedQuestion((name!=null?name.getText():null), (label!=null?label.getText():null), ex, (name!=null?name.getLine():0) ); }
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
			if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "type"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:55:1: type returns [Type result] : TYPE ;
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token TYPE2=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:56:5: ( TYPE )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:56:7: TYPE
			{
			TYPE2=(Token)match(input,TYPE,FOLLOW_TYPE_in_type257); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      if ((TYPE2!=null?TYPE2.getText():null).equals("boolean")) {
			        result = new BoolType();
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("integer")) {
			        result = new IntType();
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("string")) {
			        result = new TextType();
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("money")) {
			        result = new MoneyType();
			      }}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "primary"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:71:1: primary returns [Expr result] : ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token INT_VALUE3=null;
		Token STRING_VALUE4=null;
		Token BOOLEAN_VALUE5=null;
		Token MONEY_VALUE6=null;
		Token Ident7=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:72:4: ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' )
			int alt4=6;
			switch ( input.LA(1) ) {
			case INT_VALUE:
				{
				alt4=1;
				}
				break;
			case STRING_VALUE:
				{
				alt4=2;
				}
				break;
			case BOOLEAN_VALUE:
				{
				alt4=3;
				}
				break;
			case MONEY_VALUE:
				{
				alt4=4;
				}
				break;
			case Ident:
				{
				alt4=5;
				}
				break;
			case 17:
				{
				alt4=6;
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
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:72:6: INT_VALUE
					{
					INT_VALUE3=(Token)match(input,INT_VALUE,FOLLOW_INT_VALUE_in_primary279); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int((INT_VALUE3!=null?INT_VALUE3.getLine():0), (INT_VALUE3!=null?INT_VALUE3.getText():null)); }
					}
					break;
				case 2 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:73:6: STRING_VALUE
					{
					STRING_VALUE4=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_primary290); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Text((STRING_VALUE4!=null?STRING_VALUE4.getLine():0), (STRING_VALUE4!=null?STRING_VALUE4.getText():null).substring(1, (STRING_VALUE4!=null?STRING_VALUE4.getText():null).length() - 1)); }
					}
					break;
				case 3 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:74:6: BOOLEAN_VALUE
					{
					BOOLEAN_VALUE5=(Token)match(input,BOOLEAN_VALUE,FOLLOW_BOOLEAN_VALUE_in_primary299); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((BOOLEAN_VALUE5!=null?BOOLEAN_VALUE5.getLine():0), (BOOLEAN_VALUE5!=null?BOOLEAN_VALUE5.getText():null)); }
					}
					break;
				case 4 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:75:6: MONEY_VALUE
					{
					MONEY_VALUE6=(Token)match(input,MONEY_VALUE,FOLLOW_MONEY_VALUE_in_primary308); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((MONEY_VALUE6!=null?MONEY_VALUE6.getLine():0), (MONEY_VALUE6!=null?MONEY_VALUE6.getText():null)); }
					}
					break;
				case 5 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:76:6: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary317); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getLine():0), (Ident7!=null?Ident7.getText():null)); }
					}
					break;
				case 6 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:77:6: '(' x= orExpr ')'
					{
					match(input,17,FOLLOW_17_in_primary326); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary330);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,18,FOLLOW_18_in_primary332); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 6, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:80:1: unExpr returns [Expr result] : (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Token op=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:81:5: (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary )
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
			case BOOLEAN_VALUE:
			case INT_VALUE:
			case Ident:
			case MONEY_VALUE:
			case STRING_VALUE:
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
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:81:8: op= '+' x= unExpr
					{
					op=(Token)match(input,20,FOLLOW_20_in_unExpr360); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr364);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos((op!=null?op.getLine():0), x); }
					}
					break;
				case 2 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:82:8: op= '-' x= unExpr
					{
					op=(Token)match(input,21,FOLLOW_21_in_unExpr377); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr381);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg((op!=null?op.getLine():0), x); }
					}
					break;
				case 3 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:83:8: op= '!' x= unExpr
					{
					op=(Token)match(input,14,FOLLOW_14_in_unExpr394); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr398);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not((op!=null?op.getLine():0), x); }
					}
					break;
				case 4 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:84:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr411);
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
			if ( state.backtracking>0 ) { memoize(input, 7, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:87:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:88:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:88:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr449);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:88:47: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==19||LA6_0==22) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:88:49: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr469);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul((op!=null?op.getLine():0), result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div((op!=null?op.getLine():0), result, rhs);      
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
			if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:99:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:100:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:100:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr505);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:100:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 20 && LA7_0 <= 21)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:100:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr523);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add((op!=null?op.getLine():0), result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub((op!=null?op.getLine():0), result, rhs);      
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
			if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:111:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:112:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:112:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr558);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:112:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==15||(LA8_0 >= 24 && LA8_0 <= 28)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:112:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr582);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        result = new LT((op!=null?op.getLine():0), result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        result = new LEq((op!=null?op.getLine():0), result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        result = new GT((op!=null?op.getLine():0), result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        result = new GEq((op!=null?op.getLine():0), result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        result = new Eq((op!=null?op.getLine():0), result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        result = new NEq((op!=null?op.getLine():0), result, rhs);
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
			if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:135:1: andExpr returns [Expr result] : lhs= relExpr (op= '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:136:5: (lhs= relExpr (op= '&&' rhs= relExpr )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:136:9: lhs= relExpr (op= '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr620);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:136:48: (op= '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==16) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:136:50: op= '&&' rhs= relExpr
					{
					op=(Token)match(input,16,FOLLOW_16_in_andExpr628); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr632);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And((op!=null?op.getLine():0), result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:139:1: orExpr returns [Expr result] : lhs= andExpr (op= '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:140:5: (lhs= andExpr (op= '||' rhs= andExpr )* )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:140:9: lhs= andExpr (op= '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr662);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:140:48: (op= '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==31) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/main/org/uva/sea/ql/parser/antlr/QL.g:140:50: op= '||' rhs= andExpr
					{
					op=(Token)match(input,31,FOLLOW_31_in_orExpr670); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr674);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or((op!=null?op.getLine():0), result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "expr"
	// src/main/org/uva/sea/ql/parser/antlr/QL.g:143:1: expr returns [Expr result] : e= orExpr ;
	public final Expr expr() throws RecognitionException {
		Expr result = null;

		int expr_StartIndex = input.index();

		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// src/main/org/uva/sea/ql/parser/antlr/QL.g:144:5: (e= orExpr )
			// src/main/org/uva/sea/ql/parser/antlr/QL.g:144:7: e= orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expr706);
			e=orExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = e; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, expr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_29_in_form67 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form71 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form73 = new BitSet(new long[]{0x0000000100000140L});
	public static final BitSet FOLLOW_statements_in_form77 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements108 = new BitSet(new long[]{0x0000000000000142L});
	public static final BitSet FOLLOW_IF_in_statement138 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_expr_in_statement143 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_statement146 = new BitSet(new long[]{0x0000000100000140L});
	public static final BitSet FOLLOW_statements_in_statement150 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_statement152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question187 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_question188 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_STRING_VALUE_in_question192 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_type_in_question196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question215 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_question216 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_STRING_VALUE_in_question220 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_expr_in_question224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_type257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_VALUE_in_primary279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_VALUE_in_primary290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_VALUE_in_primary299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_VALUE_in_primary308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_primary326 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_orExpr_in_primary330 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_primary332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr360 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr377 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_unExpr394 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_unExpr_in_unExpr398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr449 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_set_in_mulExpr457 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr469 = new BitSet(new long[]{0x0000000000480002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr505 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_set_in_addExpr513 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr523 = new BitSet(new long[]{0x0000000000300002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr558 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_set_in_relExpr566 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_addExpr_in_relExpr582 = new BitSet(new long[]{0x000000001F008002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr620 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_andExpr628 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_relExpr_in_andExpr632 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr662 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr670 = new BitSet(new long[]{0x0000000000324B90L});
	public static final BitSet FOLLOW_andExpr_in_orExpr674 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_orExpr_in_expr706 = new BitSet(new long[]{0x0000000000000002L});
}
