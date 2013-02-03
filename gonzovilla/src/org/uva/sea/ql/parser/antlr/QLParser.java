// $ANTLR 3.5 /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-24 09:35:56

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.values.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "Ident", "Int", "SINGLECOMMENT", 
		"WS", "'!'", "'!='", "'\"'", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", 
		"'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'Boolean'", "'Integer'", 
		"'String'", "'['", "']'", "'endform'", "'endif'", "'form'", "'if'", "'then'", 
		"'||'"
	};
	public static final int EOF=-1;
	public static final int T__9=9;
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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int COMMENT=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int SINGLECOMMENT=7;
	public static final int WS=8;

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
	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: form returns [Form result] : 'form' Ident ':' ( formUnit )* 'endform' ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Token Ident2=null;
		FormUnit formUnit1 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:20:2: ( 'form' Ident ':' ( formUnit )* 'endform' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:20:4: 'form' Ident ':' ( formUnit )* 'endform'
			{
			match(input,32,FOLLOW_32_in_form40); 
			Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form42); 
			match(input,19,FOLLOW_19_in_form44); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:20:21: ( formUnit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==33) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:20:22: formUnit
					{
					pushFollow(FOLLOW_formUnit_in_form47);
					formUnit1=formUnit();
					state._fsp--;

					formUnits.add(formUnit1);
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,30,FOLLOW_30_in_form53); 
			 result = new Form((Ident2!=null?Ident2.getText():null), formUnits); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "form"



	// $ANTLR start "formUnit"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: formUnit returns [FormUnit result] : ( question | computedQuestion | ifStatement );
	public final FormUnit formUnit() throws RecognitionException {
		FormUnit result = null;


		Question question3 =null;
		ComputedQuestion computedQuestion4 =null;
		IfStatement ifStatement5 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:24:2: ( question | computedQuestion | ifStatement )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==19) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==28) ) {
						alt2=2;
					}
					else if ( (LA2_3==11) ) {
						alt2=1;
					}

					else {
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
			else if ( (LA2_0==33) ) {
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:24:4: question
					{
					pushFollow(FOLLOW_question_in_formUnit71);
					question3=question();
					state._fsp--;

					 result = question3; 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:5: computedQuestion
					{
					pushFollow(FOLLOW_computedQuestion_in_formUnit87);
					computedQuestion4=computedQuestion();
					state._fsp--;

					 result = computedQuestion4; 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:26:4: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formUnit94);
					ifStatement5=ifStatement();
					state._fsp--;

					 result = ifStatement5; 
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
		}
		return result;
	}
	// $ANTLR end "formUnit"



	// $ANTLR start "question"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:1: question returns [Question result] : Ident ':' sentence '(' type ')' ;
	public final Question question() throws RecognitionException {
		Question result = null;


		Token Ident6=null;
		ParserRuleReturnScope sentence7 =null;
		Type type8 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:30:2: ( Ident ':' sentence '(' type ')' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:30:4: Ident ':' sentence '(' type ')'
			{
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question116); 
			match(input,19,FOLLOW_19_in_question118); 
			pushFollow(FOLLOW_sentence_in_question120);
			sentence7=sentence();
			state._fsp--;

			match(input,13,FOLLOW_13_in_question122); 
			pushFollow(FOLLOW_type_in_question124);
			type8=type();
			state._fsp--;

			match(input,14,FOLLOW_14_in_question126); 
			 result = new Question((Ident6!=null?Ident6.getText():null), (sentence7!=null?input.toString(sentence7.start,sentence7.stop):null), type8); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "question"



	// $ANTLR start "computedQuestion"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:33:1: computedQuestion returns [ComputedQuestion result] : Ident ':' '[' orExpr ']' sentence '(' type ')' ;
	public final ComputedQuestion computedQuestion() throws RecognitionException {
		ComputedQuestion result = null;


		Token Ident9=null;
		ParserRuleReturnScope sentence10 =null;
		Expr orExpr11 =null;
		Type type12 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:2: ( Ident ':' '[' orExpr ']' sentence '(' type ')' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:4: Ident ':' '[' orExpr ']' sentence '(' type ')'
			{
			Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion146); 
			match(input,19,FOLLOW_19_in_computedQuestion148); 
			match(input,28,FOLLOW_28_in_computedQuestion150); 
			pushFollow(FOLLOW_orExpr_in_computedQuestion152);
			orExpr11=orExpr();
			state._fsp--;

			match(input,29,FOLLOW_29_in_computedQuestion154); 
			pushFollow(FOLLOW_sentence_in_computedQuestion156);
			sentence10=sentence();
			state._fsp--;

			match(input,13,FOLLOW_13_in_computedQuestion158); 
			pushFollow(FOLLOW_type_in_computedQuestion160);
			type12=type();
			state._fsp--;

			match(input,14,FOLLOW_14_in_computedQuestion162); 
			 result = new ComputedQuestion((Ident9!=null?Ident9.getText():null), (sentence10!=null?input.toString(sentence10.start,sentence10.stop):null), orExpr11, type12); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "computedQuestion"



	// $ANTLR start "ifStatement"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' 'then' ( formUnit )* 'endif' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;


		FormUnit formUnit13 =null;
		Expr orExpr14 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:2: ( 'if' '(' orExpr ')' 'then' ( formUnit )* 'endif' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:4: 'if' '(' orExpr ')' 'then' ( formUnit )* 'endif'
			{
			match(input,33,FOLLOW_33_in_ifStatement185); 
			match(input,13,FOLLOW_13_in_ifStatement187); 
			pushFollow(FOLLOW_orExpr_in_ifStatement189);
			orExpr14=orExpr();
			state._fsp--;

			match(input,14,FOLLOW_14_in_ifStatement191); 
			match(input,34,FOLLOW_34_in_ifStatement193); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:31: ( formUnit )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==Ident||LA3_0==33) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:32: formUnit
					{
					pushFollow(FOLLOW_formUnit_in_ifStatement196);
					formUnit13=formUnit();
					state._fsp--;

					formUnits.add(formUnit13);
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,31,FOLLOW_31_in_ifStatement202); 
			 result = new IfStatement(orExpr14, formUnits); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "type"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: type returns [Type result] : ( 'Boolean' | 'Integer' | 'String' );
	public final Type type() throws RecognitionException {
		Type result = null;


		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( 'Boolean' | 'Integer' | 'String' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case 25:
				{
				alt4=1;
				}
				break;
			case 26:
				{
				alt4=2;
				}
				break;
			case 27:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: 'Boolean'
					{
					match(input,25,FOLLOW_25_in_type222); 
					result = new TypeBool();
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:44:5: 'Integer'
					{
					match(input,26,FOLLOW_26_in_type230); 
					result = new TypeInt();
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: 'String'
					{
					match(input,27,FOLLOW_27_in_type238); 
					result = new TypeString();
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
		}
		return result;
	}
	// $ANTLR end "type"


	public static class sentence_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "sentence"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: sentence : '\"' ( . )* '\"' ;
	public final QLParser.sentence_return sentence() throws RecognitionException {
		QLParser.sentence_return retval = new QLParser.sentence_return();
		retval.start = input.LT(1);

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( '\"' ( . )* '\"' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: '\"' ( . )* '\"'
			{
			match(input,11,FOLLOW_11_in_sentence255); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==11) ) {
					alt5=2;
				}
				else if ( ((LA5_0 >= COMMENT && LA5_0 <= 10)||(LA5_0 >= 12 && LA5_0 <= 35)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: .
					{
					matchAny(input); 
					}
					break;

				default :
					break loop5;
				}
			}

			match(input,11,FOLLOW_11_in_sentence260); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sentence"



	// $ANTLR start "primary"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int15=null;
		Token Ident16=null;
		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:53:3: ( Int | Ident | '(' x= orExpr ')' )
			int alt6=3;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt6=1;
				}
				break;
			case Ident:
				{
				alt6=2;
				}
				break;
			case 13:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: Int
					{
					Int15=(Token)match(input,Int,FOLLOW_Int_in_primary278); 
					 result = new Int(Integer.parseInt((Int15!=null?Int15.getText():null))); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: Ident
					{
					Ident16=(Token)match(input,Ident,FOLLOW_Ident_in_primary288); 
					 result = new Ident((Ident16!=null?Ident16.getText():null)); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: '(' x= orExpr ')'
					{
					match(input,13,FOLLOW_13_in_primary296); 
					pushFollow(FOLLOW_orExpr_in_primary300);
					x=orExpr();
					state._fsp--;

					match(input,14,FOLLOW_14_in_primary302); 
					 result = x; 
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
		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 16:
				{
				alt7=1;
				}
				break;
			case 17:
				{
				alt7=2;
				}
				break;
			case 9:
				{
				alt7=3;
				}
				break;
			case Ident:
			case Int:
			case 13:
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:59:8: '+' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr327); 
					pushFollow(FOLLOW_unExpr_in_unExpr331);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:60:8: '-' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr342); 
					pushFollow(FOLLOW_unExpr_in_unExpr346);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:61:8: '!' x= unExpr
					{
					match(input,9,FOLLOW_9_in_unExpr357); 
					pushFollow(FOLLOW_unExpr_in_unExpr361);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr374);
					x=primary();
					state._fsp--;

					 result = x; 
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
		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr412);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==15||LA8_0==18) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==15||input.LA(1)==18 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr432);
					rhs=unExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("*")) {
					        result = new Mul(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("/")) {
					        result = new Div(result, rhs);      
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
		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:79:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr471);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:79:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 16 && LA9_0 <= 17)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:79:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 16 && input.LA(1) <= 17) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr489);
					rhs=mulExpr();
					state._fsp--;

					 
					      if ((op!=null?op.getText():null).equals("+")) {
					        result = new Add(result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        result = new Sub(result, rhs);      
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
		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:91:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr522);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:91:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==10||(LA10_0 >= 20 && LA10_0 <= 24)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:91:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==10||(input.LA(1) >= 20 && input.LA(1) <= 24) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr546);
					rhs=addExpr();
					state._fsp--;

					 
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
		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr584);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==12) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:48: '&&' rhs= relExpr
					{
					match(input,12,FOLLOW_12_in_andExpr590); 
					pushFollow(FOLLOW_relExpr_in_andExpr594);
					rhs=relExpr();
					state._fsp--;

					 result = new And(result, rhs); 
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
		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:119:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:120:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr629);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:120:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==35) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:120:50: '||' rhs= andExpr
					{
					match(input,35,FOLLOW_35_in_orExpr635); 
					pushFollow(FOLLOW_andExpr_in_orExpr639);
					rhs=andExpr();
					state._fsp--;

					 result = new Or(result, rhs); 
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
		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_32_in_form40 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_form42 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_form44 = new BitSet(new long[]{0x0000000240000020L});
	public static final BitSet FOLLOW_formUnit_in_form47 = new BitSet(new long[]{0x0000000240000020L});
	public static final BitSet FOLLOW_30_in_form53 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formUnit71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedQuestion_in_formUnit87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formUnit94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question116 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_question118 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_sentence_in_question120 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_question122 = new BitSet(new long[]{0x000000000E000000L});
	public static final BitSet FOLLOW_type_in_question124 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_question126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion146 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_computedQuestion148 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_computedQuestion150 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion152 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_computedQuestion154 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_sentence_in_computedQuestion156 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_computedQuestion158 = new BitSet(new long[]{0x000000000E000000L});
	public static final BitSet FOLLOW_type_in_computedQuestion160 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_computedQuestion162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ifStatement185 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ifStatement187 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement189 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement191 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_ifStatement193 = new BitSet(new long[]{0x0000000280000020L});
	public static final BitSet FOLLOW_formUnit_in_ifStatement196 = new BitSet(new long[]{0x0000000280000020L});
	public static final BitSet FOLLOW_31_in_ifStatement202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_type222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_sentence255 = new BitSet(new long[]{0x0000000FFFFFFFF0L});
	public static final BitSet FOLLOW_11_in_sentence260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_primary296 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_orExpr_in_primary300 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primary302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr327 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr342 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_unExpr357 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr412 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_set_in_mulExpr420 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr432 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr471 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_set_in_addExpr479 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr489 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr522 = new BitSet(new long[]{0x0000000001F00402L});
	public static final BitSet FOLLOW_set_in_relExpr530 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_addExpr_in_relExpr546 = new BitSet(new long[]{0x0000000001F00402L});
	public static final BitSet FOLLOW_relExpr_in_andExpr584 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_andExpr590 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_relExpr_in_andExpr594 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr629 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_orExpr635 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_andExpr_in_orExpr639 = new BitSet(new long[]{0x0000000800000002L});
}
