// $ANTLR 3.5 /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 10:05:35

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.expr.*;


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
		"'Money'", "'String'", "'endform'", "'endif'", "'form'", "'if'", "'||'"
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:17:1: form returns [Form result] : 'form' Ident ':' ( formUnit )* 'endform' ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Token Ident2=null;
		FormUnit formUnit1 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:2: ( 'form' Ident ':' ( formUnit )* 'endform' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:4: 'form' Ident ':' ( formUnit )* 'endform'
			{
			match(input,31,FOLLOW_31_in_form48); 
			Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_form50); 
			match(input,19,FOLLOW_19_in_form52); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:21: ( formUnit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==32) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:22: formUnit
					{
					pushFollow(FOLLOW_formUnit_in_form55);
					formUnit1=formUnit();
					state._fsp--;

					formUnits.add(formUnit1);
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,29,FOLLOW_29_in_form61); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: formUnit returns [FormUnit result] : ( question | ifStatement );
	public final FormUnit formUnit() throws RecognitionException {
		FormUnit result = null;


		Question question3 =null;
		IfStatement ifStatement4 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:24:2: ( question | ifStatement )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				alt2=1;
			}
			else if ( (LA2_0==32) ) {
				alt2=2;
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
					pushFollow(FOLLOW_question_in_formUnit81);
					question3=question();
					state._fsp--;

					 result = question3; 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:4: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formUnit91);
					ifStatement4=ifStatement();
					state._fsp--;

					 result = ifStatement4; 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: question returns [Question result] : Ident ':' sentence '(' returnType ')' ;
	public final Question question() throws RecognitionException {
		Question result = null;


		Token Ident5=null;
		ParserRuleReturnScope sentence6 =null;
		ReturnType returnType7 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:2: ( Ident ':' sentence '(' returnType ')' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: Ident ':' sentence '(' returnType ')'
			{
			Ident5=(Token)match(input,Ident,FOLLOW_Ident_in_question108); 
			match(input,19,FOLLOW_19_in_question110); 
			pushFollow(FOLLOW_sentence_in_question112);
			sentence6=sentence();
			state._fsp--;

			match(input,13,FOLLOW_13_in_question114); 
			pushFollow(FOLLOW_returnType_in_question116);
			returnType7=returnType();
			state._fsp--;

			match(input,14,FOLLOW_14_in_question118); 
			 result = new Question((Ident5!=null?Ident5.getText():null), (sentence6!=null?input.toString(sentence6.start,sentence6.stop):null), returnType7); 
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



	// $ANTLR start "ifStatement"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' ( formUnit )* 'endif' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;


		FormUnit formUnit8 =null;
		Expr orExpr9 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:2: ( 'if' '(' orExpr ')' ( formUnit )* 'endif' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:4: 'if' '(' orExpr ')' ( formUnit )* 'endif'
			{
			match(input,32,FOLLOW_32_in_ifStatement144); 
			match(input,13,FOLLOW_13_in_ifStatement146); 
			pushFollow(FOLLOW_orExpr_in_ifStatement148);
			orExpr9=orExpr();
			state._fsp--;

			match(input,14,FOLLOW_14_in_ifStatement150); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:24: ( formUnit )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==Ident||LA3_0==32) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:25: formUnit
					{
					pushFollow(FOLLOW_formUnit_in_ifStatement153);
					formUnit8=formUnit();
					state._fsp--;

					formUnits.add(formUnit8);
					}
					break;

				default :
					break loop3;
				}
			}

			match(input,30,FOLLOW_30_in_ifStatement159); 
			 result = new IfStatement(orExpr9, formUnits); 
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



	// $ANTLR start "returnType"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: returnType returns [ReturnType result] : ( 'Boolean' | 'Integer' | 'String' | 'Money' );
	public final ReturnType returnType() throws RecognitionException {
		ReturnType result = null;


		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:38:3: ( 'Boolean' | 'Integer' | 'String' | 'Money' )
			int alt4=4;
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
			case 28:
				{
				alt4=3;
				}
				break;
			case 27:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: 'Boolean'
					{
					match(input,25,FOLLOW_25_in_returnType178); 
					result = new TypeBool(1);
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:5: 'Integer'
					{
					match(input,26,FOLLOW_26_in_returnType186); 
					result = new TypeInt(2);
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: 'String'
					{
					match(input,28,FOLLOW_28_in_returnType194); 
					result = new TypeString(3);
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:41:5: 'Money'
					{
					match(input,27,FOLLOW_27_in_returnType203); 
					result = new TypeMoney(4);
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
	// $ANTLR end "returnType"


	public static class sentence_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "sentence"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:44:1: sentence : '\"' ( . )* '\"' ;
	public final QLParser.sentence_return sentence() throws RecognitionException {
		QLParser.sentence_return retval = new QLParser.sentence_return();
		retval.start = input.LT(1);

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:3: ( '\"' ( . )* '\"' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:5: '\"' ( . )* '\"'
			{
			match(input,11,FOLLOW_11_in_sentence219); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:9: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==11) ) {
					alt5=2;
				}
				else if ( ((LA5_0 >= COMMENT && LA5_0 <= 10)||(LA5_0 >= 12 && LA5_0 <= 33)) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:9: .
					{
					matchAny(input); 
					}
					break;

				default :
					break loop5;
				}
			}

			match(input,11,FOLLOW_11_in_sentence224); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: primary returns [Expr result] : ( Int | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int10=null;
		Token Ident11=null;
		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( Int | Ident | '(' x= orExpr ')' )
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
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:5: Int
					{
					Int10=(Token)match(input,Int,FOLLOW_Int_in_primary242); 
					 result = new Int(Integer.parseInt((Int10!=null?Int10.getText():null))); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: Ident
					{
					Ident11=(Token)match(input,Ident,FOLLOW_Ident_in_primary252); 
					 result = new Ident((Ident11!=null?Ident11.getText():null)); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:51:5: '(' x= orExpr ')'
					{
					match(input,13,FOLLOW_13_in_primary260); 
					pushFollow(FOLLOW_orExpr_in_primary264);
					x=orExpr();
					state._fsp--;

					match(input,14,FOLLOW_14_in_primary266); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:55:8: '+' x= unExpr
					{
					match(input,16,FOLLOW_16_in_unExpr291); 
					pushFollow(FOLLOW_unExpr_in_unExpr295);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:56:8: '-' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr306); 
					pushFollow(FOLLOW_unExpr_in_unExpr310);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:57:8: '!' x= unExpr
					{
					match(input,9,FOLLOW_9_in_unExpr321); 
					pushFollow(FOLLOW_unExpr_in_unExpr325);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:58:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr338);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr376);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==15||LA8_0==18) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr396);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:75:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:75:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr435);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:75:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 16 && LA9_0 <= 17)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:75:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr453);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr488);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==10||(LA10_0 >= 20 && LA10_0 <= 24)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr512);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr550);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:111:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==12) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:111:48: '&&' rhs= relExpr
					{
					match(input,12,FOLLOW_12_in_andExpr556); 
					pushFollow(FOLLOW_relExpr_in_andExpr560);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr595);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==33) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:50: '||' rhs= andExpr
					{
					match(input,33,FOLLOW_33_in_orExpr601); 
					pushFollow(FOLLOW_andExpr_in_orExpr605);
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



	public static final BitSet FOLLOW_31_in_form48 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Ident_in_form50 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_form52 = new BitSet(new long[]{0x0000000120000020L});
	public static final BitSet FOLLOW_formUnit_in_form55 = new BitSet(new long[]{0x0000000120000020L});
	public static final BitSet FOLLOW_29_in_form61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formUnit81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formUnit91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question108 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_question110 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_sentence_in_question112 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_question114 = new BitSet(new long[]{0x000000001E000000L});
	public static final BitSet FOLLOW_returnType_in_question116 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_question118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_ifStatement144 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_ifStatement146 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement148 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement150 = new BitSet(new long[]{0x0000000140000020L});
	public static final BitSet FOLLOW_formUnit_in_ifStatement153 = new BitSet(new long[]{0x0000000140000020L});
	public static final BitSet FOLLOW_30_in_ifStatement159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_returnType178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_returnType186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_returnType194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_returnType203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_sentence219 = new BitSet(new long[]{0x00000003FFFFFFF0L});
	public static final BitSet FOLLOW_11_in_sentence224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_primary260 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_orExpr_in_primary264 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_primary266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_unExpr291 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr306 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_unExpr321 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_unExpr325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr376 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_set_in_mulExpr384 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr396 = new BitSet(new long[]{0x0000000000048002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr435 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_set_in_addExpr443 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr453 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr488 = new BitSet(new long[]{0x0000000001F00402L});
	public static final BitSet FOLLOW_set_in_relExpr496 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_addExpr_in_relExpr512 = new BitSet(new long[]{0x0000000001F00402L});
	public static final BitSet FOLLOW_relExpr_in_andExpr550 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_andExpr556 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_relExpr_in_andExpr560 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr595 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_orExpr601 = new BitSet(new long[]{0x0000000000032260L});
	public static final BitSet FOLLOW_andExpr_in_orExpr605 = new BitSet(new long[]{0x0000000200000002L});
}
