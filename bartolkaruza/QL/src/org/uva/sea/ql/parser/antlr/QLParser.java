// $ANTLR 3.5 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-14 21:16:58

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.value.Number;
import org.uva.sea.ql.ast.value.*;
import org.uva.sea.ql.ast.expr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "IF", "Ident", "Int", 
		"TYPE", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", 
		"'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'\\\"'", "'form'", 
		"'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
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
	public static final int COMMENT=4;
	public static final int IF=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int TYPE=8;
	public static final int WS=9;

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
		this.state.ruleMemo = new HashMap[32+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// src/org/uva/sea/ql/parser/antlr/QL.g:18:1: form returns [Form result] : 'form' lbl= Ident '{' stmts= statements '}' ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token lbl=null;
		List<Statement> stmts =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:19:5: ( 'form' lbl= Ident '{' stmts= statements '}' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:19:7: 'form' lbl= Ident '{' stmts= statements '}'
			{
			match(input,26,FOLLOW_26_in_form49); if (state.failed) return result;
			lbl=(Token)match(input,Ident,FOLLOW_Ident_in_form53); if (state.failed) return result;
			match(input,27,FOLLOW_27_in_form55); if (state.failed) return result;
			pushFollow(FOLLOW_statements_in_form59);
			stmts=statements();
			state._fsp--;
			if (state.failed) return result;
			match(input,29,FOLLOW_29_in_form61); if (state.failed) return result;
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:22:1: statements returns [List<Statement> result] : (stmt= statement )* ;
	public final List<Statement> statements() throws RecognitionException {
		List<Statement> result = null;

		int statements_StartIndex = input.index();

		Statement stmt =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:23:5: ( (stmt= statement )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:23:8: (stmt= statement )*
			{
			if ( state.backtracking==0 ) { result = new ArrayList<Statement>(); }
			// src/org/uva/sea/ql/parser/antlr/QL.g:23:50: (stmt= statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= IF && LA1_0 <= Ident)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:23:51: stmt= statement
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:26:1: statement returns [Statement result] : (firstToken= IF (x= expr ) '{' stmts= statements '}' | question );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Token firstToken=null;
		Expr x =null;
		List<Statement> stmts =null;
		Question question1 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:27:5: (firstToken= IF (x= expr ) '{' stmts= statements '}' | question )
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:27:7: firstToken= IF (x= expr ) '{' stmts= statements '}'
					{
					firstToken=(Token)match(input,IF,FOLLOW_IF_in_statement120); if (state.failed) return result;
					// src/org/uva/sea/ql/parser/antlr/QL.g:27:21: (x= expr )
					// src/org/uva/sea/ql/parser/antlr/QL.g:27:22: x= expr
					{
					pushFollow(FOLLOW_expr_in_statement125);
					x=expr();
					state._fsp--;
					if (state.failed) return result;
					}

					match(input,27,FOLLOW_27_in_statement128); if (state.failed) return result;
					pushFollow(FOLLOW_statements_in_statement132);
					stmts=statements();
					state._fsp--;
					if (state.failed) return result;
					match(input,29,FOLLOW_29_in_statement134); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new ConditionalStatement(x, stmts, (firstToken!=null?firstToken.getLine():0)); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:28:7: question
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
	// src/org/uva/sea/ql/parser/antlr/QL.g:31:1: question returns [Question result] : name= Ident ':' '\\\"' (label= Ident )* '\\\"' TYPE ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token name=null;
		Token label=null;
		Token TYPE2=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:32:5: (name= Ident ':' '\\\"' (label= Ident )* '\\\"' TYPE )
			// src/org/uva/sea/ql/parser/antlr/QL.g:32:7: name= Ident ':' '\\\"' (label= Ident )* '\\\"' TYPE
			{
			name=(Token)match(input,Ident,FOLLOW_Ident_in_question169); if (state.failed) return result;
			match(input,19,FOLLOW_19_in_question170); if (state.failed) return result;
			match(input,25,FOLLOW_25_in_question172); if (state.failed) return result;
			// src/org/uva/sea/ql/parser/antlr/QL.g:32:31: (label= Ident )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==Ident) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:32:31: label= Ident
					{
					label=(Token)match(input,Ident,FOLLOW_Ident_in_question176); if (state.failed) return result;
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,25,FOLLOW_25_in_question179); if (state.failed) return result;
			TYPE2=(Token)match(input,TYPE,FOLLOW_TYPE_in_question181); if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      result = new Question((name!=null?name.getText():null), (label!=null?label.getText():null), (name!=null?name.getLine():0));
			      if ((TYPE2!=null?TYPE2.getText():null).equals("boolean")) {
			        result.setValue(new Bool());
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("integer")) {
			        result.setValue(new Number());
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("string")) {
			        result.setValue(new TextString());
			      }
			      if ((TYPE2!=null?TYPE2.getText():null).equals("money")) {
			        result.setValue(new Money());
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
			if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "primary"
	// src/org/uva/sea/ql/parser/antlr/QL.g:50:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int3=null;
		Token Ident4=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:51:4: ( Int | Ident | '(' x= orExpr ')' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt4=1;
				}
				break;
			case Ident:
				{
				alt4=2;
				}
				break;
			case 13:
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:51:6: Int
					{
					Int3=(Token)match(input,Int,FOLLOW_Int_in_primary208); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int3!=null?Int3.getText():null)), (Int3!=null?Int3.getLine():0)); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:52:6: Ident
					{
					Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_primary219); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident4!=null?Ident4.getText():null), (Ident4!=null?Ident4.getLine():0)); }
					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:53:6: '(' x= orExpr ')'
					{
					match(input,13,FOLLOW_13_in_primary228); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary232);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,14,FOLLOW_14_in_primary234); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 5, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:56:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:57:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 16:
				{
				alt5=1;
				}
				break;
			case 17:
				{
				alt5=2;
				}
				break;
			case 10:
				{
				alt5=3;
				}
				break;
			case Ident:
			case Int:
			case 13:
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:57:8: '+' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr260); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr264);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:58:8: '-' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr275); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr279);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:59:8: '!' x= unExpr
					{
					match(input,10,FOLLOW_10_in_unExpr290); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr294);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:60:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr307);
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
			if ( state.backtracking>0 ) { memoize(input, 6, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:63:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:64:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:64:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr345);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:64:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==15||LA6_0==18) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:64:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||input.LA(1)==18 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr365);
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
			if ( state.backtracking>0 ) { memoize(input, 7, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:75:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:76:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:76:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr401);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:76:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 16 && LA7_0 <= 17)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:76:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr419);
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
			if ( state.backtracking>0 ) { memoize(input, 8, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:87:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:88:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:88:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr454);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:88:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==11||(LA8_0 >= 20 && LA8_0 <= 24)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:88:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==11||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr478);
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
			if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:111:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:112:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:112:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr516);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:112:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==12) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:112:48: '&&' rhs= relExpr
					{
					match(input,12,FOLLOW_12_in_andExpr522); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr526);
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
			if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:115:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:116:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr556);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// src/org/uva/sea/ql/parser/antlr/QL.g:116:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==28) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:116:50: '||' rhs= andExpr
					{
					match(input,28,FOLLOW_28_in_orExpr562); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr566);
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
			if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"



	// $ANTLR start "expr"
	// src/org/uva/sea/ql/parser/antlr/QL.g:119:1: expr returns [Expr result] : e= orExpr ;
	public final Expr expr() throws RecognitionException {
		Expr result = null;

		int expr_StartIndex = input.index();

		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (e= orExpr )
			// src/org/uva/sea/ql/parser/antlr/QL.g:120:7: e= orExpr
			{
			pushFollow(FOLLOW_orExpr_in_expr598);
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
			if ( state.backtracking>0 ) { memoize(input, 12, expr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_26_in_form49 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form53 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_form55 = new BitSet(new long[]{0x0000000020000060L});
	public static final BitSet FOLLOW_statements_in_form59 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_form61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements90 = new BitSet(new long[]{0x0000000000000062L});
	public static final BitSet FOLLOW_IF_in_statement120 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_expr_in_statement125 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_statement128 = new BitSet(new long[]{0x0000000020000060L});
	public static final BitSet FOLLOW_statements_in_statement132 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_statement134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question169 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_question170 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_question172 = new BitSet(new long[]{0x0000000002000040L});
	public static final BitSet FOLLOW_Ident_in_question176 = new BitSet(new long[]{0x0000000002000040L});
	public static final BitSet FOLLOW_25_in_question179 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_TYPE_in_question181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_primary228 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_orExpr_in_primary232 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primary234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr260 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr275 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_unExpr290 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr345 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_set_in_mulExpr353 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr365 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr401 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_set_in_addExpr409 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr419 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr454 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_set_in_relExpr462 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr478 = new BitSet(new long[]{0x0000000001F00802L});
	public static final BitSet FOLLOW_relExpr_in_andExpr516 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_andExpr522 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr526 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr556 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_orExpr562 = new BitSet(new long[]{0x00000000000324C0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr566 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_orExpr_in_expr598 = new BitSet(new long[]{0x0000000000000002L});
}
