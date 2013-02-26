// $ANTLR 3.5 src/main/java/eu/karuza/ql/parser/antlr/QL.g 2013-02-25 15:05:49

package eu.karuza.ql.parser.antlr;
import eu.karuza.ql.ast.*;
import eu.karuza.ql.ast.expr.*;
import eu.karuza.ql.ast.value.*;
import eu.karuza.ql.ast.type.*;
import eu.karuza.ql.ast.statement.*;
import eu.karuza.ql.error.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN_VALUE", "COMMENT", "ELSE", 
		"IF", "INT_VALUE", "Ident", "MONEY_VALUE", "NL", "STRING_VALUE", "TYPE", 
		"WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", "'{'", "'||'", 
		"'}'"
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
	public static final int BOOLEAN_VALUE=4;
	public static final int COMMENT=5;
	public static final int ELSE=6;
	public static final int IF=7;
	public static final int INT_VALUE=8;
	public static final int Ident=9;
	public static final int MONEY_VALUE=10;
	public static final int NL=11;
	public static final int STRING_VALUE=12;
	public static final int TYPE=13;
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
		this.state.ruleMemo = new HashMap[37+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/java/eu/karuza/ql/parser/antlr/QL.g"; }


	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e); 
	  }



	// $ANTLR start "form"
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:35:1: form returns [Form result] : 'form' lbl= Ident '{' stmts= statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token lbl=null;
		List<Statement> stmts =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:36:5: ( 'form' lbl= Ident '{' stmts= statements '}' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:36:7: 'form' lbl= Ident '{' stmts= statements '}'
			{
			match(input,30,FOLLOW_30_in_form67); if (state.failed) return result;
			lbl=(Token)match(input,Ident,FOLLOW_Ident_in_form71); if (state.failed) return result;
			match(input,31,FOLLOW_31_in_form73); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form77);
			stmts=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,33,FOLLOW_33_in_form79); if (state.failed) return result;
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:39:1: statements returns [List<Statement> result] : (stmt= statement )* ;
	public final List<Statement> statements() throws RecognitionException {
		List<Statement> result = null;

		int statements_StartIndex = input.index();

		Statement stmt =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:40:5: ( (stmt= statement )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:40:8: (stmt= statement )*
			{
			if ( state.backtracking==0 ) { result = new ArrayList<Statement>(); }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:40:50: (stmt= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IF||LA1_0==Ident) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:40:51: stmt= statement
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:43:1: statement returns [Statement result] : (firstToken= IF (x= expr ) '{' ifstmts= statements '}' ELSE '{' elsestmts= statements '}' |firstToken= IF (x= expr ) '{' stmts= statements '}' | question );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Token firstToken=null;
		Expr x =null;
		List<Statement> ifstmts =null;
		List<Statement> elsestmts =null;
		List<Statement> stmts =null;
		Question question1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:5: (firstToken= IF (x= expr ) '{' ifstmts= statements '}' ELSE '{' elsestmts= statements '}' |firstToken= IF (x= expr ) '{' stmts= statements '}' | question )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==IF) ) {
				int LA2_1 = input.LA(2);
				if ( (synpred2_QL()) ) {
					alt2=1;
				}
				else if ( (synpred3_QL()) ) {
					alt2=2;
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
			else if ( (LA2_0==Ident) ) {
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:7: firstToken= IF (x= expr ) '{' ifstmts= statements '}' ELSE '{' elsestmts= statements '}'
					{
					firstToken=(Token)match(input,IF,FOLLOW_IF_in_statement138); if (state.failed) return result;
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:21: (x= expr )
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:22: x= expr
					{
					pushFollow(FOLLOW_expr_in_statement143);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					}

					match(input,31,FOLLOW_31_in_statement146); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement150);
					ifstmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_statement152); if (state.failed) return result;
					match(input,ELSE,FOLLOW_ELSE_in_statement154); if (state.failed) return result;
					match(input,31,FOLLOW_31_in_statement156); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement160);
					elsestmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_statement162); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new IfElseConditionalStatement(x, ifstmts, elsestmts, (firstToken!=null?firstToken.getLine():0)); }
					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:7: firstToken= IF (x= expr ) '{' stmts= statements '}'
					{
					firstToken=(Token)match(input,IF,FOLLOW_IF_in_statement174); if (state.failed) return result;
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:21: (x= expr )
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:22: x= expr
					{
					pushFollow(FOLLOW_expr_in_statement179);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					}

					match(input,31,FOLLOW_31_in_statement182); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement186);
					stmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,33,FOLLOW_33_in_statement188); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IfConditionalStatement(x, stmts, (firstToken!=null?firstToken.getLine():0)); }
					}
					break;
				case 3 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:46:7: question
					{
					pushFollow(FOLLOW_question_in_statement198);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:49:1: question returns [Question result] : (name= Ident ':' label= STRING_VALUE qt= type |name= Ident ':' label= STRING_VALUE ex= expr );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token name=null;
		Token label=null;
		Type qt =null;
		Expr ex =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:50:5: (name= Ident ':' label= STRING_VALUE qt= type |name= Ident ':' label= STRING_VALUE ex= expr )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Ident) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==24) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==STRING_VALUE) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==TYPE) ) {
							alt3=1;
						}
						else if ( (LA3_3==BOOLEAN_VALUE||(LA3_3 >= INT_VALUE && LA3_3 <= MONEY_VALUE)||LA3_3==STRING_VALUE||LA3_3==15||LA3_3==18||(LA3_3 >= 21 && LA3_3 <= 22)) ) {
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:50:7: name= Ident ':' label= STRING_VALUE qt= type
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question223); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question224); if (state.failed) return result;
					label=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_question228); if (state.failed) return result;
					pushFollow(FOLLOW_type_in_question232);
					qt=type();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new AnswerableQuestion((name!=null?name.getText():null), (label!=null?label.getText():null).substring(1, (label!=null?label.getText():null).length() - 1), qt, (name!=null?name.getLine():0) ); }
					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:52:7: name= Ident ':' label= STRING_VALUE ex= expr
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question251); if (state.failed) return result;
					match(input,24,FOLLOW_24_in_question252); if (state.failed) return result;
					label=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_question256); if (state.failed) return result;
					pushFollow(FOLLOW_expr_in_question260);
					ex=expr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ComputedQuestion((name!=null?name.getText():null), (label!=null?label.getText():null).substring(1, (label!=null?label.getText():null).length() - 1), ex, (name!=null?name.getLine():0) ); }
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:56:1: type returns [Type result] : TYPE ;
	public final Type type() throws RecognitionException {
		Type result = null;

		int type_StartIndex = input.index();

		Token TYPE2=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:57:5: ( TYPE )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:57:7: TYPE
			{
			TYPE2=(Token)match(input,TYPE,FOLLOW_TYPE_in_type293); if (state.failed) return result;
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:72:1: primary returns [Expr result] : ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' );
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

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:73:4: ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' )
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
			case 18:
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:73:6: INT_VALUE
					{
					INT_VALUE3=(Token)match(input,INT_VALUE,FOLLOW_INT_VALUE_in_primary315); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int((INT_VALUE3!=null?INT_VALUE3.getLine():0), (INT_VALUE3!=null?INT_VALUE3.getText():null)); }
					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:74:6: STRING_VALUE
					{
					STRING_VALUE4=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_primary326); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Text((STRING_VALUE4!=null?STRING_VALUE4.getLine():0), (STRING_VALUE4!=null?STRING_VALUE4.getText():null).substring(1, (STRING_VALUE4!=null?STRING_VALUE4.getText():null).length() - 1)); }
					}
					break;
				case 3 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:75:6: BOOLEAN_VALUE
					{
					BOOLEAN_VALUE5=(Token)match(input,BOOLEAN_VALUE,FOLLOW_BOOLEAN_VALUE_in_primary335); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((BOOLEAN_VALUE5!=null?BOOLEAN_VALUE5.getLine():0), (BOOLEAN_VALUE5!=null?BOOLEAN_VALUE5.getText():null)); }
					}
					break;
				case 4 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:76:6: MONEY_VALUE
					{
					MONEY_VALUE6=(Token)match(input,MONEY_VALUE,FOLLOW_MONEY_VALUE_in_primary344); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((MONEY_VALUE6!=null?MONEY_VALUE6.getLine():0), (MONEY_VALUE6!=null?MONEY_VALUE6.getText():null)); }
					}
					break;
				case 5 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:77:6: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary353); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getLine():0), (Ident7!=null?Ident7.getText():null)); }
					}
					break;
				case 6 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:78:6: '(' x= orExpr ')'
					{
					match(input,18,FOLLOW_18_in_primary362); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary366);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,19,FOLLOW_19_in_primary368); if (state.failed) return result;
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:81:1: unExpr returns [Expr result] : (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Token op=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:82:5: (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary )
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
			case BOOLEAN_VALUE:
			case INT_VALUE:
			case Ident:
			case MONEY_VALUE:
			case STRING_VALUE:
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:82:8: op= '+' x= unExpr
					{
					op=(Token)match(input,21,FOLLOW_21_in_unExpr396); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr400);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos((op!=null?op.getLine():0), x); }
					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:83:8: op= '-' x= unExpr
					{
					op=(Token)match(input,22,FOLLOW_22_in_unExpr413); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr417);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg((op!=null?op.getLine():0), x); }
					}
					break;
				case 3 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:84:8: op= '!' x= unExpr
					{
					op=(Token)match(input,15,FOLLOW_15_in_unExpr430); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr434);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not((op!=null?op.getLine():0), x); }
					}
					break;
				case 4 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:85:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr447);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:88:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:89:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:89:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr485);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:89:47: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==20||LA6_0==23) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:89:49: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr505);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:100:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:101:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:101:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr541);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:101:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 21 && LA7_0 <= 22)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:101:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr559);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:112:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:113:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:113:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr594);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:113:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==16||(LA8_0 >= 25 && LA8_0 <= 29)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:113:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr618);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:136:1: andExpr returns [Expr result] : lhs= relExpr (op= '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:137:5: (lhs= relExpr (op= '&&' rhs= relExpr )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:137:9: lhs= relExpr (op= '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr656);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:137:48: (op= '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==17) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:137:50: op= '&&' rhs= relExpr
					{
					op=(Token)match(input,17,FOLLOW_17_in_andExpr664); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr668);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:140:1: orExpr returns [Expr result] : lhs= andExpr (op= '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:141:5: (lhs= andExpr (op= '||' rhs= andExpr )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:141:9: lhs= andExpr (op= '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr698);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:141:48: (op= '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==32) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:141:50: op= '||' rhs= andExpr
					{
					op=(Token)match(input,32,FOLLOW_32_in_orExpr706); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr710);
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
	// src/main/java/eu/karuza/ql/parser/antlr/QL.g:144:1: expr returns [Expr result] : e= orExpr ;
	public final Expr expr() throws RecognitionException {
		Expr result = null;

		int expr_StartIndex = input.index();

		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:145:5: (e= orExpr )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:145:7: e= orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expr742);
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

	// $ANTLR start synpred2_QL
	public final void synpred2_QL_fragment() throws RecognitionException {
		Token firstToken=null;
		Expr x =null;
		List<Statement> ifstmts =null;
		List<Statement> elsestmts =null;

		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:7: (firstToken= IF (x= expr ) '{' ifstmts= statements '}' ELSE '{' elsestmts= statements '}' )
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:7: firstToken= IF (x= expr ) '{' ifstmts= statements '}' ELSE '{' elsestmts= statements '}'
		{
		firstToken=(Token)match(input,IF,FOLLOW_IF_in_synpred2_QL138); if (state.failed) return;
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:21: (x= expr )
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:44:22: x= expr
		{
		pushFollow(FOLLOW_expr_in_synpred2_QL143);
		x=expr();
		state._fsp--;
		if (state.failed) return;
		}

		match(input,31,FOLLOW_31_in_synpred2_QL146); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred2_QL150);
		ifstmts=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred2_QL152); if (state.failed) return;
		match(input,ELSE,FOLLOW_ELSE_in_synpred2_QL154); if (state.failed) return;
		match(input,31,FOLLOW_31_in_synpred2_QL156); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred2_QL160);
		elsestmts=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred2_QL162); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_QL

	// $ANTLR start synpred3_QL
	public final void synpred3_QL_fragment() throws RecognitionException {
		Token firstToken=null;
		Expr x =null;
		List<Statement> stmts =null;

		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:7: (firstToken= IF (x= expr ) '{' stmts= statements '}' )
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:7: firstToken= IF (x= expr ) '{' stmts= statements '}'
		{
		firstToken=(Token)match(input,IF,FOLLOW_IF_in_synpred3_QL174); if (state.failed) return;
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:21: (x= expr )
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:45:22: x= expr
		{
		pushFollow(FOLLOW_expr_in_synpred3_QL179);
		x=expr();
		state._fsp--;
		if (state.failed) return;
		}

		match(input,31,FOLLOW_31_in_synpred3_QL182); if (state.failed) return;
		pushFollow(FOLLOW_statements_in_synpred3_QL186);
		stmts=statements();
		state._fsp--;
		if (state.failed) return;
		match(input,33,FOLLOW_33_in_synpred3_QL188); if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_QL

	// Delegated rules

	public final boolean synpred2_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
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



	public static final BitSet FOLLOW_30_in_form67 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Ident_in_form71 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_form73 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_form77 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_form79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements108 = new BitSet(new long[]{0x0000000000000282L});
	public static final BitSet FOLLOW_IF_in_statement138 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_expr_in_statement143 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_statement146 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_statement150 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement152 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ELSE_in_statement154 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_statement156 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_statement160 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_statement174 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_expr_in_statement179 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_statement182 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_statement186 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_statement188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question223 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question224 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_STRING_VALUE_in_question228 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_type_in_question232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question251 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_question252 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_STRING_VALUE_in_question256 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_expr_in_question260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_type293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_VALUE_in_primary315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_VALUE_in_primary326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_VALUE_in_primary335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_VALUE_in_primary344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_primary362 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_orExpr_in_primary366 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_primary368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr396 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_unExpr413 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr430 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_unExpr_in_unExpr434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr485 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_set_in_mulExpr493 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr505 = new BitSet(new long[]{0x0000000000900002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr541 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_set_in_addExpr549 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr559 = new BitSet(new long[]{0x0000000000600002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr594 = new BitSet(new long[]{0x000000003E010002L});
	public static final BitSet FOLLOW_set_in_relExpr602 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_addExpr_in_relExpr618 = new BitSet(new long[]{0x000000003E010002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr656 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_andExpr664 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_relExpr_in_andExpr668 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr698 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr706 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_andExpr_in_orExpr710 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_orExpr_in_expr742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred2_QL138 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_expr_in_synpred2_QL143 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred2_QL146 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_synpred2_QL150 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred2_QL152 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ELSE_in_synpred2_QL154 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred2_QL156 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_synpred2_QL160 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred2_QL162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred3_QL174 = new BitSet(new long[]{0x0000000000649710L});
	public static final BitSet FOLLOW_expr_in_synpred3_QL179 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred3_QL182 = new BitSet(new long[]{0x0000000200000280L});
	public static final BitSet FOLLOW_statements_in_synpred3_QL186 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_synpred3_QL188 = new BitSet(new long[]{0x0000000000000002L});
}
