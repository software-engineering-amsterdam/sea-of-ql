// $ANTLR 3.5 /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-24 17:47:34

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
		this.state.ruleMemo = new HashMap[36+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: form returns [QLForm result] : 'form' IDENT body ;
	public final QLForm form() throws RecognitionException {
		QLForm result = null;

		int form_StartIndex = input.index();

		Token IDENT1=null;
		Body body2 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:3: ( 'form' IDENT body )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:5: 'form' IDENT body
			{
			match(input,27,FOLLOW_27_in_form46); if (state.failed) return result;
			IDENT1=(Token)match(input,IDENT,FOLLOW_IDENT_in_form48); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_form50);
			body2=body();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new QLForm((IDENT1!=null?IDENT1.getText():null), body2); }
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



	// $ANTLR start "body"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:1: body returns [Body result] : '{' ( formElement )* '}' ;
	public final Body body() throws RecognitionException {
		Body result = null;

		int body_StartIndex = input.index();

		FormElement formElement3 =null;

		 ArrayList<FormElement> tempList = new ArrayList<FormElement>(); 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:3: ( '{' ( formElement )* '}' )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:5: '{' ( formElement )* '}'
			{
			match(input,31,FOLLOW_31_in_body85); if (state.failed) return result;
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: ( formElement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENT||LA1_0==28) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:10: formElement
					{
					pushFollow(FOLLOW_formElement_in_body88);
					formElement3=formElement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { tempList.add(formElement3); }
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,33,FOLLOW_33_in_body94); if (state.failed) return result;
			}

			if ( state.backtracking==0 ) { result = new Body(tempList); }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, body_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "body"



	// $ANTLR start "formElement"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: formElement returns [FormElement result] : ( question | ifStatement );
	public final FormElement formElement() throws RecognitionException {
		FormElement result = null;

		int formElement_StartIndex = input.index();

		Question question4 =null;
		IfStatement ifStatement5 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:3: ( question | ifStatement )
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: question
					{
					pushFollow(FOLLOW_question_in_formElement113);
					question4=question();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = question4; }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:5: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formElement121);
					ifStatement5=ifStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = ifStatement5; }
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
			if ( state.backtracking>0 ) { memoize(input, 3, formElement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formElement"



	// $ANTLR start "question"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: question returns [Question result] : IDENT ':' STRING_LITERAL type ( '(' expression ')' )? ;
	public final Question question() throws RecognitionException {
		Question result = null;

		int question_StartIndex = input.index();

		Token IDENT6=null;
		Token STRING_LITERAL7=null;
		ExprType type8 =null;
		Expr expression9 =null;

		 boolean computed = false; 
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:3: ( IDENT ':' STRING_LITERAL type ( '(' expression ')' )? )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:35:5: IDENT ':' STRING_LITERAL type ( '(' expression ')' )?
			{
			IDENT6=(Token)match(input,IDENT,FOLLOW_IDENT_in_question149); if (state.failed) return result;
			match(input,20,FOLLOW_20_in_question151); if (state.failed) return result;
			STRING_LITERAL7=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_question153); if (state.failed) return result;
			pushFollow(FOLLOW_type_in_question155);
			type8=type();
			state._fsp--;
			if (state.failed) return result;
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:5: ( '(' expression ')' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==14) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:7: '(' expression ')'
					{
					match(input,14,FOLLOW_14_in_question163); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_question165);
					expression9=expression();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_question167); if (state.failed) return result;
					if ( state.backtracking==0 ) { computed = true; }
					}
					break;

			}

			if ( state.backtracking==0 ) {
			      if (computed) {
			        result = new ComputedQuestion(new Ident((IDENT6!=null?IDENT6.getText():null)),
			          (STRING_LITERAL7!=null?STRING_LITERAL7.getText():null), type8, expression9);
			      } else {
			        result = new Question(new Ident((IDENT6!=null?IDENT6.getText():null)),
			          (STRING_LITERAL7!=null?STRING_LITERAL7.getText():null), type8);
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



	// $ANTLR start "type"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: type returns [ExprType result] : ( 'boolean' | 'string' | 'integer' );
	public final ExprType type() throws RecognitionException {
		ExprType result = null;

		int type_StartIndex = input.index();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( 'boolean' | 'string' | 'integer' )
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: 'boolean'
					{
					match(input,26,FOLLOW_26_in_type197); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new BoolType(); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: 'string'
					{
					match(input,30,FOLLOW_30_in_type205); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new StrType(); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: 'integer'
					{
					match(input,29,FOLLOW_29_in_type213); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new IntType(); }
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
			if ( state.backtracking>0 ) { memoize(input, 5, type_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "type"



	// $ANTLR start "ifStatement"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: ifStatement returns [IfStatement result] : 'if' '(' expression ')' body ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;

		int ifStatement_StartIndex = input.index();

		Expr expression10 =null;
		Body body11 =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:3: ( 'if' '(' expression ')' body )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: 'if' '(' expression ')' body
			{
			match(input,28,FOLLOW_28_in_ifStatement232); if (state.failed) return result;
			match(input,14,FOLLOW_14_in_ifStatement234); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_ifStatement236);
			expression10=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,15,FOLLOW_15_in_ifStatement238); if (state.failed) return result;
			pushFollow(FOLLOW_body_in_ifStatement240);
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
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, ifStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "expression"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: expression returns [Expr result] : ( INT | IDENT | STRING_LITERAL | '(' x= orExpr ')' );
	public final Expr expression() throws RecognitionException {
		Expr result = null;

		int expression_StartIndex = input.index();

		Token INT12=null;
		Token IDENT13=null;
		Token STRING_LITERAL14=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:3: ( INT | IDENT | STRING_LITERAL | '(' x= orExpr ')' )
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: INT
					{
					INT12=(Token)match(input,INT,FOLLOW_INT_in_expression263); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((INT12!=null?INT12.getText():null))); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: IDENT
					{
					IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression273); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((IDENT13!=null?IDENT13.getText():null)); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: STRING_LITERAL
					{
					STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_expression281); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null)); }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_expression289); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_expression293);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,15,FOLLOW_15_in_expression295); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 7, expression_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "expression"



	// $ANTLR start "unExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= expression );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:3: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= expression )
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
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr318); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr322);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr330); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr334);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:5: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr342); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr346);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: x= expression
					{
					pushFollow(FOLLOW_expression_in_unExpr356);
					x=expression();
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
			if ( state.backtracking>0 ) { memoize(input, 8, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:3: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr388);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:41: (op= ( '*' | '/' ) rhs= unExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==16||LA7_0==19) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:43: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr408);
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
			if ( state.backtracking>0 ) { memoize(input, 9, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:3: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr442);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:42: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 17 && LA8_0 <= 18)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:44: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr460);
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
			if ( state.backtracking>0 ) { memoize(input, 10, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:3: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr488);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==12||(LA9_0 >= 21 && LA9_0 <= 25)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:7: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr526);
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
			if ( state.backtracking>0 ) { memoize(input, 11, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:3: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr558);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: ( '&&' rhs= relExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==13) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:127:7: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr568); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr572);
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
			if ( state.backtracking>0 ) { memoize(input, 12, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:3: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr601);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:5: ( '||' rhs= andExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==32) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/sven/Documents/sc2013/sea-of-ql/sven-m/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:7: '||' rhs= andExpr
					{
					match(input,32,FOLLOW_32_in_orExpr611); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr615);
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
			if ( state.backtracking>0 ) { memoize(input, 13, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_27_in_form46 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_IDENT_in_form48 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_form50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_body85 = new BitSet(new long[]{0x0000000210000040L});
	public static final BitSet FOLLOW_formElement_in_body88 = new BitSet(new long[]{0x0000000210000040L});
	public static final BitSet FOLLOW_33_in_body94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formElement113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formElement121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_question149 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question151 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_question153 = new BitSet(new long[]{0x0000000064000000L});
	public static final BitSet FOLLOW_type_in_question155 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_question163 = new BitSet(new long[]{0x00000000000042C0L});
	public static final BitSet FOLLOW_expression_in_question165 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_question167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_type205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_type213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_ifStatement232 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement234 = new BitSet(new long[]{0x00000000000042C0L});
	public static final BitSet FOLLOW_expression_in_ifStatement236 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement238 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_body_in_ifStatement240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_expression263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_expression273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_expression281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_expression289 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_orExpr_in_expression293 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_expression295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr318 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr330 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr342 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_unExpr356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr388 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr396 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr408 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr442 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr450 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr460 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr488 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr500 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr526 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr558 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr568 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr572 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr601 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr611 = new BitSet(new long[]{0x0000000000064AC0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr615 = new BitSet(new long[]{0x0000000100000002L});
}
