// $ANTLR 3.5 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-15 22:47:19

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.value.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN_VALUE", "COMMENT", "IF", 
		"INT_VALUE", "Ident", "MONEY_VALUE", "STRING_VALUE", "TYPE", "WS", "'!'", 
		"'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", 
		"'<='", "'=='", "'>'", "'>='", "'\\\"'", "'form'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int BOOLEAN_VALUE=4;
	public static final int COMMENT=5;
	public static final int IF=6;
	public static final int INT_VALUE=7;
	public static final int Ident=8;
	public static final int MONEY_VALUE=9;
	public static final int STRING_VALUE=10;
	public static final int TYPE=11;
	public static final int WS=12;

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
	@Override public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// src/org/uva/sea/ql/parser/antlr/QL.g:17:1: form returns [Form result] : 'form' lbl= Ident '{' stmts= statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token lbl=null;
		List<Statement> stmts =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:18:5: ( 'form' lbl= Ident '{' stmts= statements '}' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:18:7: 'form' lbl= Ident '{' stmts= statements '}'
			{
			match(input,29,FOLLOW_29_in_form49); if (state.failed) return result;
			lbl=(Token)match(input,Ident,FOLLOW_Ident_in_form53); if (state.failed) return result;
			match(input,30,FOLLOW_30_in_form55); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form59);
			stmts=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,32,FOLLOW_32_in_form61); if (state.failed) return result;
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:21:1: statements returns [List<Statement> result] : (stmt= statement )* ;
	public final List<Statement> statements() throws RecognitionException {
		List<Statement> result = null;

		int statements_StartIndex = input.index();

		Statement stmt =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:22:5: ( (stmt= statement )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:22:8: (stmt= statement )*
			{
			if ( state.backtracking==0 ) { result = new ArrayList<Statement>(); }
			// src/org/uva/sea/ql/parser/antlr/QL.g:22:50: (stmt= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IF||LA1_0==Ident) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:22:51: stmt= statement
					{
					pushFollow(FOLLOW_statement_in_statements90);
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:25:1: statement returns [Statement result] : (firstToken= IF (x= expr ) '{' stmts= statements '}' | question );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Token firstToken=null;
		Expr x =null;
		List<Statement> stmts =null;
		Question question1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:26:5: (firstToken= IF (x= expr ) '{' stmts= statements '}' | question )
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:26:7: firstToken= IF (x= expr ) '{' stmts= statements '}'
					{
					firstToken=(Token)match(input,IF,FOLLOW_IF_in_statement120); if (state.failed) return result;
					// src/org/uva/sea/ql/parser/antlr/QL.g:26:21: (x= expr )
					// src/org/uva/sea/ql/parser/antlr/QL.g:26:22: x= expr
					{
					pushFollow(FOLLOW_expr_in_statement125);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					}

					match(input,30,FOLLOW_30_in_statement128); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement132);
					stmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,32,FOLLOW_32_in_statement134); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ConditionalStatement(x, stmts, (firstToken!=null?firstToken.getLine():0)); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:27:7: question
					{
					pushFollow(FOLLOW_question_in_statement144);
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:30:1: question returns [Question result] : (name= Ident ':' label= STRING_VALUE qt= questionType |name= Ident ':' '\\\"' (label= Ident )* );
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token name=null;
		Token label=null;
		Expr qt =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:31:5: (name= Ident ':' label= STRING_VALUE qt= questionType |name= Ident ':' '\\\"' (label= Ident )* )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Ident) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==22) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==STRING_VALUE) ) {
						alt4=1;
					}
					else if ( (LA4_2==28) ) {
						alt4=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
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
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:31:7: name= Ident ':' label= STRING_VALUE qt= questionType
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question169); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_question170); if (state.failed) return result;
					label=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_question174); if (state.failed) return result;
					pushFollow(FOLLOW_questionType_in_question178);
					qt=questionType();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      result = new Question((name!=null?name.getText():null), (label!=null?label.getText():null), qt, (name!=null?name.getLine():0)); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:33:7: name= Ident ':' '\\\"' (label= Ident )*
					{
					name=(Token)match(input,Ident,FOLLOW_Ident_in_question191); if (state.failed) return result;
					match(input,22,FOLLOW_22_in_question192); if (state.failed) return result;
					match(input,28,FOLLOW_28_in_question194); if (state.failed) return result;
					// src/org/uva/sea/ql/parser/antlr/QL.g:33:31: (label= Ident )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==Ident) ) {
							int LA3_2 = input.LA(2);
							if ( (LA3_2==EOF||LA3_2==IF||LA3_2==Ident||LA3_2==32) ) {
								alt3=1;
							}

						}

						switch (alt3) {
						case 1 :
							// src/org/uva/sea/ql/parser/antlr/QL.g:33:31: label= Ident
							{
							label=(Token)match(input,Ident,FOLLOW_Ident_in_question198); if (state.failed) return result;
							}
							break;

						default :
							break loop3;
						}
					}

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



	// $ANTLR start "questionType"
	// src/org/uva/sea/ql/parser/antlr/QL.g:36:1: questionType returns [Expr result] : (x= expr | TYPE );
	public final Expr questionType() throws RecognitionException {
		Expr result = null;

		int questionType_StartIndex = input.index();

		Token TYPE2=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:37:5: (x= expr | TYPE )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==BOOLEAN_VALUE||(LA5_0 >= INT_VALUE && LA5_0 <= STRING_VALUE)||LA5_0==13||LA5_0==16||(LA5_0 >= 19 && LA5_0 <= 20)) ) {
				alt5=1;
			}
			else if ( (LA5_0==TYPE) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:37:7: x= expr
					{
					pushFollow(FOLLOW_expr_in_questionType226);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = x; }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:38:7: TYPE
					{
					TYPE2=(Token)match(input,TYPE,FOLLOW_TYPE_in_questionType236); if (state.failed) return result;
					if ( state.backtracking==0 ) {
					      if ((TYPE2!=null?TYPE2.getText():null).equals("boolean")) {
					        result = new Bool();
					      }
					      if ((TYPE2!=null?TYPE2.getText():null).equals("integer")) {
					        result = new Int();
					      }
					      if ((TYPE2!=null?TYPE2.getText():null).equals("string")) {
					        result = new TextString();
					      }
					      if ((TYPE2!=null?TYPE2.getText():null).equals("money")) {
					        result = new Money();
					      }}
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



	// $ANTLR start "primary"
	// src/org/uva/sea/ql/parser/antlr/QL.g:53:1: primary returns [Expr result] : ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' );
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

			// src/org/uva/sea/ql/parser/antlr/QL.g:54:4: ( INT_VALUE | STRING_VALUE | BOOLEAN_VALUE | MONEY_VALUE | Ident | '(' x= orExpr ')' )
			int alt6=6;
			switch ( input.LA(1) ) {
			case INT_VALUE:
				{
				alt6=1;
				}
				break;
			case STRING_VALUE:
				{
				alt6=2;
				}
				break;
			case BOOLEAN_VALUE:
				{
				alt6=3;
				}
				break;
			case MONEY_VALUE:
				{
				alt6=4;
				}
				break;
			case Ident:
				{
				alt6=5;
				}
				break;
			case 16:
				{
				alt6=6;
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:54:6: INT_VALUE
					{
					INT_VALUE3=(Token)match(input,INT_VALUE,FOLLOW_INT_VALUE_in_primary258); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int((INT_VALUE3!=null?INT_VALUE3.getText():null)); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:55:6: STRING_VALUE
					{
					STRING_VALUE4=(Token)match(input,STRING_VALUE,FOLLOW_STRING_VALUE_in_primary269); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new TextString((STRING_VALUE4!=null?STRING_VALUE4.getText():null).substring(1, (STRING_VALUE4!=null?STRING_VALUE4.getText():null).length() - 1)); }
					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:56:6: BOOLEAN_VALUE
					{
					BOOLEAN_VALUE5=(Token)match(input,BOOLEAN_VALUE,FOLLOW_BOOLEAN_VALUE_in_primary278); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((BOOLEAN_VALUE5!=null?BOOLEAN_VALUE5.getText():null)); }
					}
					break;
				case 4 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:57:6: MONEY_VALUE
					{
					MONEY_VALUE6=(Token)match(input,MONEY_VALUE,FOLLOW_MONEY_VALUE_in_primary287); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((MONEY_VALUE6!=null?MONEY_VALUE6.getText():null)); }
					}
					break;
				case 5 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:58:6: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary296); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getText():null), (Ident7!=null?Ident7.getLine():0)); }
					}
					break;
				case 6 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:59:6: '(' x= orExpr ')'
					{
					match(input,16,FOLLOW_16_in_primary305); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary309);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,17,FOLLOW_17_in_primary311); if (state.failed) return result;
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:62:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:63:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 19:
				{
				alt7=1;
				}
				break;
			case 20:
				{
				alt7=2;
				}
				break;
			case 13:
				{
				alt7=3;
				}
				break;
			case BOOLEAN_VALUE:
			case INT_VALUE:
			case Ident:
			case MONEY_VALUE:
			case STRING_VALUE:
			case 16:
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:63:8: '+' x= unExpr
					{
					match(input,19,FOLLOW_19_in_unExpr337); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr341);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:64:8: '-' x= unExpr
					{
					match(input,20,FOLLOW_20_in_unExpr352); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr356);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:65:8: '!' x= unExpr
					{
					match(input,13,FOLLOW_13_in_unExpr367); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr371);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:66:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr384);
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:69:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:70:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:70:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr422);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:70:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==18||LA8_0==21) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:70:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==18||input.LA(1)==21 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr442);
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
			if ( state.backtracking>0 ) { memoize(input, 8, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:81:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:82:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:82:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr478);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:82:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 19 && LA9_0 <= 20)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:82:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr496);
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
			if ( state.backtracking>0 ) { memoize(input, 9, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:93:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:94:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:94:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr531);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:94:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==14||(LA10_0 >= 23 && LA10_0 <= 27)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:94:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==14||(input.LA(1) >= 23 && input.LA(1) <= 27) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr555);
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
			if ( state.backtracking>0 ) { memoize(input, 10, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:117:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:118:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:118:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr593);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:118:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==15) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:118:48: '&&' rhs= relExpr
					{
					match(input,15,FOLLOW_15_in_andExpr599); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr603);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 11, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:121:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr633);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:122:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==31) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:122:50: '||' rhs= andExpr
					{
					match(input,31,FOLLOW_31_in_orExpr639); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr643);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "expr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:125:1: expr returns [Expr result] : e= orExpr ;
	public final Expr expr() throws RecognitionException {
		Expr result = null;

		int expr_StartIndex = input.index();

		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (e= orExpr )
			// src/org/uva/sea/ql/parser/antlr/QL.g:126:7: e= orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expr675);
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



	public static final BitSet FOLLOW_29_in_form49 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Ident_in_form53 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_form55 = new BitSet(new long[]{0x0000000100000140L});
	public static final BitSet FOLLOW_statements_in_form59 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_form61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements90 = new BitSet(new long[]{0x0000000000000142L});
	public static final BitSet FOLLOW_IF_in_statement120 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_expr_in_statement125 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_statement128 = new BitSet(new long[]{0x0000000100000140L});
	public static final BitSet FOLLOW_statements_in_statement132 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question169 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_question170 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_STRING_VALUE_in_question174 = new BitSet(new long[]{0x0000000000192F90L});
	public static final BitSet FOLLOW_questionType_in_question178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question191 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_question192 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_question194 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_Ident_in_question198 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_expr_in_questionType226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_in_questionType236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_VALUE_in_primary258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_VALUE_in_primary269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_VALUE_in_primary278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_VALUE_in_primary287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_primary305 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_orExpr_in_primary309 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_primary311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_unExpr337 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpr_in_unExpr341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_unExpr352 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpr_in_unExpr356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_unExpr367 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpr_in_unExpr371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr422 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_set_in_mulExpr430 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr442 = new BitSet(new long[]{0x0000000000240002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr478 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_addExpr486 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr496 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr531 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_set_in_relExpr539 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_addExpr_in_relExpr555 = new BitSet(new long[]{0x000000000F804002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr593 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_15_in_andExpr599 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_relExpr_in_andExpr603 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr633 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_orExpr639 = new BitSet(new long[]{0x0000000000192790L});
	public static final BitSet FOLLOW_andExpr_in_orExpr643 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_orExpr_in_expr675 = new BitSet(new long[]{0x0000000000000002L});
}
