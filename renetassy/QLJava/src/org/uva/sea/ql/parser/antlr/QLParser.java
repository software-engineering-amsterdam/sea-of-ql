// $ANTLR 3.5 /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 14:36:45

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


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
		"'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'form'", 
		"'{'", "'||'", "'}'"
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
		this.state.ruleMemo = new HashMap[29+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "question"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:1: question returns [Question result] : Ident ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token Ident1=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:2: ( Ident )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:4: Ident
			{
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_question51); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Question(new Ident((Ident1!=null?Ident1.getText():null)));  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, question_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "statement"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: statement returns [Statement result] : ( question ) ;
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Question question2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:2: ( ( question ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: ( question )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: ( question )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:5: question
			{
			pushFollow(FOLLOW_question_in_statement71);
			question2=question();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = question2; }
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "body"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:1: body returns [Body result] : '{' ( statement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		Statement statement3 =null;

		 List<Statement> statements = new ArrayList<Statement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:2: ( '{' ( statement )* '}' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: '{' ( statement )* '}'
			{
			match(input,26,FOLLOW_26_in_body95); if (state.failed) return result;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:8: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:10: statement
					{
					pushFollow(FOLLOW_statement_in_body99);
					statement3=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { statements.add(statement3); }
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,28,FOLLOW_28_in_body106); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Body(statements); }
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



	// $ANTLR start "form"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: form returns [Form result] : 'form' Ident body ;
	public final Form form() throws RecognitionException {
		Form result = null;

		int form_StartIndex = input.index();

		Token Ident4=null;
		Body body5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: ( 'form' Ident body )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:7: 'form' Ident body
			{
			match(input,25,FOLLOW_25_in_form127); if (state.failed) return result;
			Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_form129); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form131);
			body5=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Form (new Ident((Ident4!=null?Ident4.getText():null)), body5); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, form_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "primary"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token Int6=null;
		Token Ident7=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:3: ( Int | Ident | '(' x= orExpr ')' )
			int alt2=3;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt2=1;
				}
				break;
			case Ident:
				{
				alt2=2;
				}
				break;
			case 14:
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:5: Int
					{
					Int6=(Token)match(input,Int,FOLLOW_Int_in_primary153); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((Int6!=null?Int6.getText():null))); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: Ident
					{
					Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_primary163); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((Ident7!=null?Ident7.getText():null)); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary171); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary175);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_primary177); if (state.failed) return result;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt3=1;
				}
				break;
			case 18:
				{
				alt3=2;
				}
				break;
			case 11:
				{
				alt3=3;
				}
				break;
			case Ident:
			case Int:
			case 14:
				{
				alt3=4;
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr202); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr206);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr217); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr221);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr232); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr236);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:46:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr249);
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr287);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==16||LA4_0==19) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr307);
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
					break loop4;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr345);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= 17 && LA5_0 <= 18)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr363);
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
					break loop5;
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
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr398);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==12||(LA6_0 >= 20 && LA6_0 <= 24)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr422);
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
			if ( state.backtracking>0 ) { memoize(input, 9, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr460);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:46: ( '&&' rhs= relExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==13) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr466); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr470);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 10, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr505);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:48: ( '||' rhs= andExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==27) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:50: '||' rhs= andExpr
					{
					match(input,27,FOLLOW_27_in_orExpr511); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr515);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 11, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_Ident_in_question51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_statement71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_body95 = new BitSet(new long[]{0x0000000010000020L});
	public static final BitSet FOLLOW_statement_in_body99 = new BitSet(new long[]{0x0000000010000020L});
	public static final BitSet FOLLOW_28_in_body106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_form127 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_form129 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_body_in_form131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary171 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_orExpr_in_primary175 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr202 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_unExpr_in_unExpr206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr217 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_unExpr_in_unExpr221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr232 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_unExpr_in_unExpr236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr287 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr295 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr307 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr345 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr353 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr363 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr398 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_set_in_relExpr406 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_addExpr_in_relExpr422 = new BitSet(new long[]{0x0000000001F01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr460 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr466 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_relExpr_in_andExpr470 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr505 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_orExpr511 = new BitSet(new long[]{0x0000000000064860L});
	public static final BitSet FOLLOW_andExpr_in_orExpr515 = new BitSet(new long[]{0x0000000008000002L});
}
