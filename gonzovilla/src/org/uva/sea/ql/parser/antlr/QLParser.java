// $ANTLR 3.5 /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-25 13:34:56

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.types.*;
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
		"'Bool'", "'Int'", "'String'", "'['", "']'", "'else'", "'endif'", "'form'", 
		"'if'", "'then'", "'{'", "'||'", "'}'"
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:20:1: form returns [Form result] : 'form' Ident body= block ;
	public final Form form() throws RecognitionException {
		Form result = null;


		Token Ident1=null;
		Block body =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:21:2: ( 'form' Ident body= block )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:21:4: 'form' Ident body= block
			{
			match(input,33,FOLLOW_33_in_form34); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:23:1: block returns [Block result] : '{' ( formUnit )* '}' ;
	public final Block block() throws RecognitionException {
		Block result = null;


		FormUnit formUnit2 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:2: ( '{' ( formUnit )* '}' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:4: '{' ( formUnit )* '}'
			{
			match(input,36,FOLLOW_36_in_block62); 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:8: ( formUnit )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident||LA1_0==34) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: formUnit
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

			match(input,38,FOLLOW_38_in_block71); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: formUnit returns [FormUnit result] : ( question | computedQuestion | ifStatement );
	public final FormUnit formUnit() throws RecognitionException {
		FormUnit result = null;


		Question question3 =null;
		ComputedQuestion computedQuestion4 =null;
		IfStatement ifStatement5 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:2: ( question | computedQuestion | ifStatement )
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
			else if ( (LA2_0==34) ) {
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:29:4: question
					{
					pushFollow(FOLLOW_question_in_formUnit90);
					question3=question();
					state._fsp--;

					 result = question3; 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:30:5: computedQuestion
					{
					pushFollow(FOLLOW_computedQuestion_in_formUnit106);
					computedQuestion4=computedQuestion();
					state._fsp--;

					 result = computedQuestion4; 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:31:4: ifStatement
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:34:1: question returns [Question result] : Ident ':' String '[' type ']' ;
	public final Question question() throws RecognitionException {
		Question result = null;


		Token Ident6=null;
		Token String7=null;
		Type type8 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:35:2: ( Ident ':' String '[' type ']' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:35:4: Ident ':' String '[' type ']'
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:38:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String '(' orExpr ')' '[' type ']' ;
	public final ComputedQuestion computedQuestion() throws RecognitionException {
		ComputedQuestion result = null;


		Token Ident9=null;
		Token String10=null;
		Expr orExpr11 =null;
		Type type12 =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:2: ( Ident ':' String '(' orExpr ')' '[' type ']' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:39:4: Ident ':' String '(' orExpr ')' '[' type ']'
			{
			Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion163); 
			match(input,20,FOLLOW_20_in_computedQuestion165); 
			String10=(Token)match(input,String,FOLLOW_String_in_computedQuestion167); 
			match(input,14,FOLLOW_14_in_computedQuestion169); 
			pushFollow(FOLLOW_orExpr_in_computedQuestion171);
			orExpr11=orExpr();
			state._fsp--;

			match(input,15,FOLLOW_15_in_computedQuestion173); 
			match(input,29,FOLLOW_29_in_computedQuestion175); 
			pushFollow(FOLLOW_type_in_computedQuestion177);
			type12=type();
			state._fsp--;

			match(input,30,FOLLOW_30_in_computedQuestion179); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: ifStatement returns [IfStatement result] : 'if' '(' orExpr ')' 'then' ifBody= block 'endif' ;
	public final IfStatement ifStatement() throws RecognitionException {
		IfStatement result = null;


		Block ifBody =null;
		Expr orExpr13 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:44:2: ( 'if' '(' orExpr ')' 'then' ifBody= block 'endif' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: 'if' '(' orExpr ')' 'then' ifBody= block 'endif'
			{
			match(input,34,FOLLOW_34_in_ifStatement203); 
			match(input,14,FOLLOW_14_in_ifStatement205); 
			pushFollow(FOLLOW_orExpr_in_ifStatement207);
			orExpr13=orExpr();
			state._fsp--;

			match(input,15,FOLLOW_15_in_ifStatement209); 
			match(input,35,FOLLOW_35_in_ifStatement211); 
			pushFollow(FOLLOW_block_in_ifStatement215);
			ifBody=block();
			state._fsp--;

			match(input,32,FOLLOW_32_in_ifStatement217); 
			 result = new IfStatement(orExpr13, ifBody); 
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



	// $ANTLR start "ifElseStatement"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: ifElseStatement returns [IfElseStatement result] : 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif' ;
	public final IfElseStatement ifElseStatement() throws RecognitionException {
		IfElseStatement result = null;


		Block ifBody =null;
		Block elseBody =null;
		Expr orExpr14 =null;

		 List<FormUnit> formUnits = new ArrayList<FormUnit>();
		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:2: ( 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif' )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:49:4: 'if' '(' orExpr ')' 'then' ifBody= block 'else' elseBody= block 'endif'
			{
			match(input,34,FOLLOW_34_in_ifElseStatement242); 
			match(input,14,FOLLOW_14_in_ifElseStatement244); 
			pushFollow(FOLLOW_orExpr_in_ifElseStatement246);
			orExpr14=orExpr();
			state._fsp--;

			match(input,15,FOLLOW_15_in_ifElseStatement248); 
			match(input,35,FOLLOW_35_in_ifElseStatement250); 
			pushFollow(FOLLOW_block_in_ifElseStatement254);
			ifBody=block();
			state._fsp--;

			match(input,31,FOLLOW_31_in_ifElseStatement256); 
			pushFollow(FOLLOW_block_in_ifElseStatement260);
			elseBody=block();
			state._fsp--;

			match(input,32,FOLLOW_32_in_ifElseStatement262); 
			 result = new IfElseStatement(orExpr14, ifBody, elseBody); 
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
	// $ANTLR end "ifElseStatement"



	// $ANTLR start "type"
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: type returns [Type result] : ( 'Bool' | 'Int' | 'String' );
	public final Type type() throws RecognitionException {
		Type result = null;


		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:53:3: ( 'Bool' | 'Int' | 'String' )
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
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: 'Bool'
					{
					match(input,26,FOLLOW_26_in_type284); 
					result = new TypeBool();
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:54:5: 'Int'
					{
					match(input,27,FOLLOW_27_in_type292); 
					result = new TypeInt();
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:55:5: 'String'
					{
					match(input,28,FOLLOW_28_in_type300); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
	public final Expr primary() throws RecognitionException {
		Expr result = null;


		Token Int15=null;
		Token Bool16=null;
		Token String17=null;
		Token Ident18=null;
		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:59:3: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
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
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: Int
					{
					Int15=(Token)match(input,Int,FOLLOW_Int_in_primary320); 
					 result = new Int(Integer.parseInt((Int15!=null?Int15.getText():null))); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Bool
					{
					Bool16=(Token)match(input,Bool,FOLLOW_Bool_in_primary330); 
					result = new BoolValue(Boolean.parseBoolean((Bool16!=null?Bool16.getText():null))); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: String
					{
					String17=(Token)match(input,String,FOLLOW_String_in_primary338); 
					 result = new StringValue((String17!=null?String17.getText():null)); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: Ident
					{
					Ident18=(Token)match(input,Ident,FOLLOW_Ident_in_primary346); 
					 result = new Ident((Ident18!=null?Ident18.getText():null)); 
					}
					break;
				case 5 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: '(' x= orExpr ')'
					{
					match(input,14,FOLLOW_14_in_primary354); 
					pushFollow(FOLLOW_orExpr_in_primary358);
					x=orExpr();
					state._fsp--;

					match(input,15,FOLLOW_15_in_primary360); 
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;


		Expr x =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
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
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:67:8: '+' x= unExpr
					{
					match(input,17,FOLLOW_17_in_unExpr386); 
					pushFollow(FOLLOW_unExpr_in_unExpr390);
					x=unExpr();
					state._fsp--;

					 result = new Pos(x); 
					}
					break;
				case 2 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:68:8: '-' x= unExpr
					{
					match(input,18,FOLLOW_18_in_unExpr401); 
					pushFollow(FOLLOW_unExpr_in_unExpr405);
					x=unExpr();
					state._fsp--;

					 result = new Neg(x); 
					}
					break;
				case 3 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:69:8: '!' x= unExpr
					{
					match(input,11,FOLLOW_11_in_unExpr416); 
					pushFollow(FOLLOW_unExpr_in_unExpr420);
					x=unExpr();
					state._fsp--;

					 result = new Not(x); 
					}
					break;
				case 4 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:70:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr433);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr471);
			lhs=unExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==16||LA6_0==19) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:74:47: op= ( '*' | '/' ) rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr491);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr530);
			lhs=mulExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 17 && LA7_0 <= 18)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:87:48: op= ( '+' | '-' ) rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr548);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:98:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;


		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:99:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:99:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr581);
			lhs=addExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:99:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==12||(LA8_0 >= 21 && LA8_0 <= 25)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:99:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr605);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:122:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:123:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:123:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr643);
			lhs=relExpr();
			state._fsp--;

			 result =lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:123:46: ( '&&' rhs= relExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==13) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:123:48: '&&' rhs= relExpr
					{
					match(input,13,FOLLOW_13_in_andExpr649); 
					pushFollow(FOLLOW_relExpr_in_andExpr653);
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
	// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;


		Expr lhs =null;
		Expr rhs =null;

		try {
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr688);
			lhs=andExpr();
			state._fsp--;

			 result = lhs; 
			// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:128:48: ( '||' rhs= andExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==37) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/gonzovilla89/Documents/workspace/sea-of-ql/gonzovilla/src/org/uva/sea/ql/parser/antlr/QL.g:128:50: '||' rhs= andExpr
					{
					match(input,37,FOLLOW_37_in_orExpr694); 
					pushFollow(FOLLOW_andExpr_in_orExpr698);
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



	public static final BitSet FOLLOW_33_in_form34 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_Ident_in_form36 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_block_in_form40 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_block62 = new BitSet(new long[]{0x0000004400000040L});
	public static final BitSet FOLLOW_formUnit_in_block65 = new BitSet(new long[]{0x0000004400000040L});
	public static final BitSet FOLLOW_38_in_block71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_question_in_formUnit90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_computedQuestion_in_formUnit106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_formUnit113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_question135 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_question137 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_question139 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_question141 = new BitSet(new long[]{0x000000001C000000L});
	public static final BitSet FOLLOW_type_in_question143 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_question145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_computedQuestion163 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_computedQuestion165 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_String_in_computedQuestion167 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_computedQuestion169 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_computedQuestion171 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_computedQuestion173 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_computedQuestion175 = new BitSet(new long[]{0x000000001C000000L});
	public static final BitSet FOLLOW_type_in_computedQuestion177 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_computedQuestion179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_ifStatement203 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifStatement205 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement207 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifStatement209 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifStatement211 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_block_in_ifStatement215 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifStatement217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_ifElseStatement242 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_ifElseStatement244 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_ifElseStatement246 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_ifElseStatement248 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_ifElseStatement250 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_block_in_ifElseStatement254 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifElseStatement256 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_block_in_ifElseStatement260 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifElseStatement262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_type284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_primary330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_in_primary338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_primary354 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_orExpr_in_primary358 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_primary360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr386 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr401 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_unExpr416 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_unExpr420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr471 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_set_in_mulExpr479 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr491 = new BitSet(new long[]{0x0000000000090002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr530 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_set_in_addExpr538 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr548 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr581 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_set_in_relExpr589 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_addExpr_in_relExpr605 = new BitSet(new long[]{0x0000000003E01002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr643 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_andExpr649 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_relExpr_in_andExpr653 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr688 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_orExpr694 = new BitSet(new long[]{0x0000000000064AD0L});
	public static final BitSet FOLLOW_andExpr_in_orExpr698 = new BitSet(new long[]{0x0000002000000002L});
}
