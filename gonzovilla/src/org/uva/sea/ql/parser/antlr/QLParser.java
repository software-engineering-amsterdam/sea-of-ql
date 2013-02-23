// $ANTLR 3.5 /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-23 02:27:13

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.ComputedQuestion;
import org.uva.sea.ql.ast.stat.Form;
import org.uva.sea.ql.ast.stat.FormUnit;
import org.uva.sea.ql.ast.stat.IfStatement;
import org.uva.sea.ql.ast.stat.Question;
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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", 
		"SINGLECOMMENT", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", 
		"'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", 
		"'Bool'", "'Int'", "'String'", "'['", "']'", "'block'", "'else'", "'endblock'", 
		"'endif'", "'form'", "'if'", "'then'", "'||'"
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
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int SINGLECOMMENT=8;
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
	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g"; }



	// $ANTLR start "form"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: form returns [Form result] : 'form' Ident body= block ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Token Ident1=null;
		Block body =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:2: ( 'form' Ident body= block )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:19:4: 'form' Ident body= block
			{
			match(input,35,FOLLOW_35_in_form34); 
			Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form36); 
			pushFollow(FOLLOW_block_in_form40);
			body=block();
			state._fsp--;

			result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), body);
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



	// $ANTLR start "block"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:21:1: block returns [Block result] : 'block' ( formUnit )* 'endblock' ;
	public final Block block() throws RecognitionException {
		Block result = null;


		FormUnit formUnit2 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:2: ( 'block' ( formUnit )* 'endblock' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:4: 'block' ( formUnit )* 'endblock'
			{
			match(input,31,FOLLOW_31_in_block62); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:12: ( formUnit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==36) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:13: formUnit
					{
					pushFollow(FOLLOW_formUnit_in_block65);
					formUnit2=formUnit();
					state._fsp--;

					formUnits.add(formUnit2);
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,33,FOLLOW_33_in_block71); 
			 result = new Block(formUnits); 
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
	// $ANTLR end "block"



	// $ANTLR start "formUnit"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:26:1: formUnit returns [FormUnit result] : ( question | computedQuestion | ifStatement );
	public final FormUnit formUnit() throws RecognitionException {
		FormUnit result = null;


		Question question3 =null;
		ComputedQuestion computedQuestion4 =null;
		IfStatement ifStatement5 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:27:2: ( question | computedQuestion | ifStatement )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==20) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==String) ) {
						int LA2_4 = input.LA(4);
						if ( (LA2_4==29) ) {
							alt2=1;
						}
						else if ( (LA2_4==14) ) {
							alt2=2;
						}

						else {
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
			else if ( (LA2_0==36) ) {
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:27:4: question
					{
					pushFollow(FOLLOW_question_in_formUnit90);
					question3=question();
					state._fsp--;

					 result = question3; 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:28:5: computedQuestion
					{
					pushFollow(FOLLOW_computedQuestion_in_formUnit106);
					computedQuestion4=computedQuestion();
					state._fsp--;

					 result = computedQuestion4; 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: ifStatement
					{
					pushFollow(FOLLOW_ifStatement_in_formUnit113);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: question returns [Question result] : Ident ':' String '[' type ']' ;
	public final Question question() throws RecognitionException {
		Question result = null;


		Token Ident6=null;
		Token String7=null;
		Type type8 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:33:2: ( Ident ':' String '[' type ']' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:33:4: Ident ':' String '[' type ']'
			{
			Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question135); 
			match(input,20,FOLLOW_20_in_question137); 
			String7=(Token)match(input,String,FOLLOW_String_in_question139); 
			match(input,29,FOLLOW_29_in_question141); 
			pushFollow(FOLLOW_type_in_question143);
			type8=type();
			state._fsp--;

			match(input,30,FOLLOW_30_in_question145); 
			 result = new Question(new Ident((Ident6!=null?Ident6.getText():null)), (String7!=null?String7.getText():null), type8); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String '(' orExpr ')' '[' type ']' ;
	public final ComputedQuestion computedQuestion() throws RecognitionException {
		ComputedQuestion result = null;


		Token Ident9=null;
		Token String10=null;
		Expr orExpr11 =null;
		Type type12 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:37:2: ( Ident ':' String '(' orExpr ')' '[' type ']' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:37:4: Ident ':' String '(' orExpr ')' '[' type ']'
			{
			Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion165); 
			match(input,20,FOLLOW_20_in_computedQuestion167); 
			String10=(Token)match(input,String,FOLLOW_String_in_computedQuestion169); 
			match(input,14,FOLLOW_14_in_computedQuestion171); 
			pushFollow(FOLLOW_orExpr_in_computedQuestion173);
			orExpr11=orExpr();
			state._fsp--;

			match(input,15,FOLLOW_15_in_computedQuestion175); 
			match(input,29,FOLLOW_29_in_computedQuestion177); 
			pushFollow(FOLLOW_type_in_computedQuestion179);
			type12=type();
			state._fsp--;

			match(input,30,FOLLOW_30_in_computedQuestion181); 
			 result = new ComputedQuestion(new Ident((Ident9!=null?Ident9.getText():null)), (String10!=null?String10.getText():null), orExpr11, type12); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;


		Block ifBody =null;
		Block elseBody =null;
		Expr orExpr13 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:2: ( 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:4: 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif'
			{
			match(input,36,FOLLOW_36_in_ifStatement205); 
			match(input,14,FOLLOW_14_in_ifStatement207); 
			pushFollow(FOLLOW_orExpr_in_ifStatement209);
			orExpr13=orExpr();
			state._fsp--;

			match(input,15,FOLLOW_15_in_ifStatement211); 
			match(input,37,FOLLOW_37_in_ifStatement213); 
			pushFollow(FOLLOW_block_in_ifStatement217);
			ifBody=block();
			state._fsp--;

			match(input,32,FOLLOW_32_in_ifStatement219); 
			pushFollow(FOLLOW_block_in_ifStatement223);
			elseBody=block();
			state._fsp--;

			match(input,34,FOLLOW_34_in_ifStatement225); 
			 result = new IfStatement(orExpr13, ifBody, elseBody); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:45:1: type returns [Type result] : ( 'Bool' | 'Int' | 'String' );
	public final Type type() throws RecognitionException {
		Type result = null;


		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:46:3: ( 'Bool' | 'Int' | 'String' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case 26:
				{
				alt3=1;
				}
				break;
			case 27:
				{
				alt3=2;
				}
				break;
			case 28:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:46:5: 'Bool'
					{
					match(input,26,FOLLOW_26_in_type247); 
					result = new TypeBool();
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:47:5: 'Int'
					{
					match(input,27,FOLLOW_27_in_type255); 
					result = new TypeInt();
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:48:5: 'String'
					{
					match(input,28,FOLLOW_28_in_type263); 
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



	// $ANTLR start "primary"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:51:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int14=null;
		Token Bool15=null;
		Token String16=null;
		Token Ident17=null;
		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:52:3: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
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
			case String:
				{
				alt4=3;
				}
				break;
			case Ident:
				{
				alt4=4;
				}
				break;
			case 14:
				{
				alt4=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: Int
					{
					Int14=(Token)match(input,Int,FOLLOW_Int_in_primary283); 
					 result = new Int(Integer.parseInt((Int14!=null?Int14.getText():null))); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: Bool
					{
					Bool15=(Token)match(input,Bool,FOLLOW_Bool_in_primary293); 
					result = new BoolValue(Boolean.parseBoolean((Bool15!=null?Bool15.getText():null))); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: String
					{
					String16=(Token)match(input,String,FOLLOW_String_in_primary301); 
					 result = new StringValue((String16!=null?String16.getText():null)); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: Ident
					{
					Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_primary309); 
					 result = new Ident((Ident17!=null?Ident17.getText():null)); 
					}
					break;
				case 5 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary317); 
					pushFollow(FOLLOW_orExpr_in_primary321);
					x=orExpr();
					state._fsp--;

					match(input,15,FOLLOW_15_in_primary323); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 17:
				{
				alt5=1;
				}
				break;
			case 18:
				{
				alt5=2;
				}
				break;
			case 11:
				{
				alt5=3;
				}
				break;
			case Bool:
			case Ident:
			case Int:
			case String:
			case 14:
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:60:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr349); 
					pushFollow(FOLLOW_unExpr_in_unExpr353);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:61:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr364); 
					pushFollow(FOLLOW_unExpr_in_unExpr368);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr379); 
					pushFollow(FOLLOW_unExpr_in_unExpr383);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:63:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr396);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr434);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==16||LA6_0==19) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==16||input.LA(1)==19 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr454);
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
		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:80:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr493);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:80:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 17 && LA7_0 <= 18)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:80:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr511);
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
		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:91:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:92:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr544);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:92:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==12||(LA8_0 >= 21 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:92:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr568);
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
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr606);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==13) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:116:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr612); 
					pushFollow(FOLLOW_relExpr_in_andExpr616);
					rhs=relExpr();
					state._fsp--;

					 result = new And(result, rhs); 
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
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:120:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:121:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr651);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:121:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==38) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:121:50: '||' rhs= andExpr
					{
					match(input,38,FOLLOW_38_in_orExpr657); 
					pushFollow(FOLLOW_andExpr_in_orExpr661);
					rhs=andExpr();
					state._fsp--;

					 result = new Or(result, rhs); 
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
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_35_in_form34 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form36 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_block_in_form40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_block62 = new BitSet(new long[]{0x0000001200000040L});
	public static final BitSet FOLLOW_formUnit_in_block65 = new BitSet(new long[]{0x0000001200000040L});
	public static final BitSet FOLLOW_33_in_block71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formUnit90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedQuestion_in_formUnit106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formUnit113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question135 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question137 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_question139 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_question141 = new BitSet(new long[]{0x000000001C000000L});
	public static final BitSet FOLLOW_type_in_question143 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_question145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion165 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_computedQuestion167 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_computedQuestion169 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_computedQuestion171 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion173 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_computedQuestion175 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_computedQuestion177 = new BitSet(new long[]{0x000000001C000000L});
	public static final BitSet FOLLOW_type_in_computedQuestion179 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_computedQuestion181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_ifStatement205 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement207 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement209 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement211 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_ifStatement213 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_block_in_ifStatement217 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifStatement219 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_block_in_ifStatement223 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_ifStatement225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary317 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_primary321 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr349 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr364 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr379 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr434 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr442 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr454 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr493 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr501 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr511 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr544 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr552 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr568 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr606 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr612 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr616 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr651 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_orExpr657 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr661 = new BitSet(new long[]{0x0000004000000002L});
}
