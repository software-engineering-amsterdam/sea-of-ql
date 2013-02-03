// $ANTLR 3.5 C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-21 16:07:23

package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
import java.util.HashSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BACKSLASH", "BOOLEAN", "CL", 
		"COLON", "COMMA", "COMMENT", "CURRENCY_DOLLAR", "CURRENCY_EURO", "DOUBLE_QUOTES", 
		"DQ", "FORM", "FORMIDENT", "IDENT", "IF", "INT", "INT_DIGIT", "KEYWORD_BOOLEAN", 
		"KEYWORD_FALSE", "KEYWORD_FORM", "KEYWORD_IF", "KEYWORD_MONEY", "KEYWORD_TRUE", 
		"LB", "LCB", "LEFT_BRACKED", "LEFT_CURLY_BRACKED", "LINE_COMMENT", "LOWERCASE_LETTER", 
		"MONEY", "MONEY_COMMA", "POINT", "QUESTION_MARK", "RB", "RCB", "RIGHT_BRACKED", 
		"RIGHT_CURLY_BRACKED", "SINGLE_SPACE", "STRING", "UNDERSCORE", "UPPERCASE_LETTER", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'<'", "'<='", "'=='", 
		"'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int BACKSLASH=4;
	public static final int BOOLEAN=5;
	public static final int CL=6;
	public static final int COLON=7;
	public static final int COMMA=8;
	public static final int COMMENT=9;
	public static final int CURRENCY_DOLLAR=10;
	public static final int CURRENCY_EURO=11;
	public static final int DOUBLE_QUOTES=12;
	public static final int DQ=13;
	public static final int FORM=14;
	public static final int FORMIDENT=15;
	public static final int IDENT=16;
	public static final int IF=17;
	public static final int INT=18;
	public static final int INT_DIGIT=19;
	public static final int KEYWORD_BOOLEAN=20;
	public static final int KEYWORD_FALSE=21;
	public static final int KEYWORD_FORM=22;
	public static final int KEYWORD_IF=23;
	public static final int KEYWORD_MONEY=24;
	public static final int KEYWORD_TRUE=25;
	public static final int LB=26;
	public static final int LCB=27;
	public static final int LEFT_BRACKED=28;
	public static final int LEFT_CURLY_BRACKED=29;
	public static final int LINE_COMMENT=30;
	public static final int LOWERCASE_LETTER=31;
	public static final int MONEY=32;
	public static final int MONEY_COMMA=33;
	public static final int POINT=34;
	public static final int QUESTION_MARK=35;
	public static final int RB=36;
	public static final int RCB=37;
	public static final int RIGHT_BRACKED=38;
	public static final int RIGHT_CURLY_BRACKED=39;
	public static final int SINGLE_SPACE=40;
	public static final int STRING=41;
	public static final int UNDERSCORE=42;
	public static final int UPPERCASE_LETTER=43;
	public static final int WS=44;

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
		this.state.ruleMemo = new HashMap[42+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "start"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:1: start returns [Expr result] : fD= formDeclaration ;
	public final Expr start() throws RecognitionException{
		Expr result = null;

		int start_StartIndex = input.index();

		Expr fD =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:2: (fD= formDeclaration )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:4: fD= formDeclaration
			{
			pushFollow(FOLLOW_formDeclaration_in_start49);
			fD=formDeclaration();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = fD; }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "start"



	// $ANTLR start "formDeclaration"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:1: formDeclaration returns [Expr result] : ( FORM i= FORMIDENT x= block |x= orExpr );
	public final Expr formDeclaration() throws RecognitionException{
		Expr result = null;

		int formDeclaration_StartIndex = input.index();

		Token i=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:2: ( FORM i= FORMIDENT x= block |x= orExpr )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==FORM) ) {
				alt1=1;
			}
			else if ( (LA1_0==BOOLEAN||LA1_0==IDENT||LA1_0==INT||LA1_0==LB||LA1_0==MONEY||LA1_0==STRING||LA1_0==45||(LA1_0 >= 49 && LA1_0 <= 50)) ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:4: FORM i= FORMIDENT x= block
					{
					match(input,FORM,FOLLOW_FORM_in_formDeclaration66); if (state.failed) return result;
					i=(Token)match(input,FORMIDENT,FOLLOW_FORMIDENT_in_formDeclaration70); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_formDeclaration74);
					x=block();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Form(new Ident((i!=null?i.getText():null)), x);}
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: x= orExpr
					{
					pushFollow(FOLLOW_orExpr_in_formDeclaration83);
					x=orExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 2, formDeclaration_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "formDeclaration"



	// $ANTLR start "blockContent"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:1: blockContent returns [HashSet<Expr> result] : (v= statement )* ;
	public final HashSet<Expr> blockContent() throws RecognitionException{
		HashSet<Expr> result = null;

		int blockContent_StartIndex = input.index();

		Expr v =null;


			    	result = new HashSet<Expr>();
			
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:6: ( (v= statement )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:8: (v= statement )*
			{
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:8: (v= statement )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= IDENT && LA2_0 <= IF)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:36:9: v= statement
					{
					pushFollow(FOLLOW_statement_in_blockContent115);
					v=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result.add(v); }
					}
					break;

				default :
					break loop2;
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
			if ( state.backtracking>0 ) { memoize(input, 3, blockContent_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "blockContent"



	// $ANTLR start "block"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:39:1: block returns [Expr result] : LCB b= blockContent RCB ;
	public final Expr block() throws RecognitionException{
		Expr result = null;

		int block_StartIndex = input.index();

		HashSet<Expr> b =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:2: ( LCB b= blockContent RCB )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:40:4: LCB b= blockContent RCB
			{
			match(input,LCB,FOLLOW_LCB_in_block136); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_block140);
			b=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RCB,FOLLOW_RCB_in_block142); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Block(b); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, block_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "block"



	// $ANTLR start "conditionalStatement"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:43:1: conditionalStatement returns [Expr result] : c= condition b= block ;
	public final Expr conditionalStatement() throws RecognitionException{
		Expr result = null;

		int conditionalStatement_StartIndex = input.index();

		Expr c =null;
		Expr b =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:2: (c= condition b= block )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:44:4: c= condition b= block
			{
			pushFollow(FOLLOW_condition_in_conditionalStatement161);
			c=condition();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_block_in_conditionalStatement165);
			b=block();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new ConditionalStatement(c, b);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, conditionalStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "conditionalStatement"



	// $ANTLR start "statement"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:47:1: statement returns [Expr result] : (a= assDeclStatement |c= conditionalStatement );
	public final Expr statement() throws RecognitionException{
		Expr result = null;

		int statement_StartIndex = input.index();

		Expr a =null;
		Expr c =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:2: (a= assDeclStatement |c= conditionalStatement )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				alt3=1;
			}
			else if ( (LA3_0==IF) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:48:4: a= assDeclStatement
					{
					pushFollow(FOLLOW_assDeclStatement_in_statement185);
					a=assDeclStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = a; }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:4: c= conditionalStatement
					{
					pushFollow(FOLLOW_conditionalStatement_in_statement194);
					c=conditionalStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = c; }
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
			if ( state.backtracking>0 ) { memoize(input, 6, statement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "statement"



	// $ANTLR start "condition"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:52:1: condition returns [Expr result] : IF LB x= orExpr RB ;
	public final Expr condition() throws RecognitionException{
		Expr result = null;

		int condition_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:2: ( IF LB x= orExpr RB )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:4: IF LB x= orExpr RB
			{
			match(input,IF,FOLLOW_IF_in_condition212); if (state.failed) return result;
			match(input,LB,FOLLOW_LB_in_condition214); if (state.failed) return result;
			pushFollow(FOLLOW_orExpr_in_condition218);
			x=orExpr();
			state._fsp--;
			if (state.failed) return result;
			match(input,RB,FOLLOW_RB_in_condition220); if (state.failed) return result;
			if ( state.backtracking==0 ) { result = new Condition(x); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, condition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "condition"



	// $ANTLR start "tMoney"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:56:1: tMoney returns [Expr result] : (m= MONEY | MONEY LB x= addExpr RB );
	public final Expr tMoney() throws RecognitionException{
		Expr result = null;

		int tMoney_StartIndex = input.index();

		Token m=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:2: (m= MONEY | MONEY LB x= addExpr RB )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==MONEY) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==LB) ) {
					alt4=2;
				}
				else if ( (LA4_1==EOF||(LA4_1 >= IDENT && LA4_1 <= IF)||LA4_1==RCB) ) {
					alt4=1;
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:57:4: m= MONEY
					{
					m=(Token)match(input,MONEY,FOLLOW_MONEY_in_tMoney239); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Money((m!=null?m.getText():null));}
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:4: MONEY LB x= addExpr RB
					{
					match(input,MONEY,FOLLOW_MONEY_in_tMoney246); if (state.failed) return result;
					match(input,LB,FOLLOW_LB_in_tMoney248); if (state.failed) return result;
					pushFollow(FOLLOW_addExpr_in_tMoney252);
					x=addExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_tMoney254); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money(x); }
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
			if ( state.backtracking>0 ) { memoize(input, 8, tMoney_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "tMoney"



	// $ANTLR start "tBoolean"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:61:1: tBoolean returns [Expr result] : b= BOOLEAN ;
	public final Expr tBoolean() throws RecognitionException{
		Expr result = null;

		int tBoolean_StartIndex = input.index();

		Token b=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:2: (b= BOOLEAN )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:62:4: b= BOOLEAN
			{
			b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_tBoolean274); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Bool((b!=null?b.getText():null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, tBoolean_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "tBoolean"



	// $ANTLR start "assDeclStatement"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:1: assDeclStatement returns [Expr result] : (i= IDENT CL s= STRING b= tBoolean |i= IDENT CL s= STRING x= tMoney );
	public final Expr assDeclStatement() throws RecognitionException{
		Expr result = null;

		int assDeclStatement_StartIndex = input.index();

		Token i=null;
		Token s=null;
		Expr b =null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:2: (i= IDENT CL s= STRING b= tBoolean |i= IDENT CL s= STRING x= tMoney )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENT) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==CL) ) {
					int LA5_2 = input.LA(3);
					if ( (LA5_2==STRING) ) {
						int LA5_3 = input.LA(4);
						if ( (LA5_3==BOOLEAN) ) {
							alt5=1;
						}
						else if ( (LA5_3==MONEY) ) {
							alt5=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 3, input);
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
								new NoViableAltException("", 5, 2, input);
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
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:66:4: i= IDENT CL s= STRING b= tBoolean
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_assDeclStatement293); if (state.failed) return result;
					match(input,CL,FOLLOW_CL_in_assDeclStatement295); if (state.failed) return result;
					s=(Token)match(input,STRING,FOLLOW_STRING_in_assDeclStatement299); if (state.failed) return result;
					pushFollow(FOLLOW_tBoolean_in_assDeclStatement303);
					b=tBoolean();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question( new Ident((i!=null?i.getText():null)), new Str((s!=null?s.getText():null)), b ); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:67:4: i= IDENT CL s= STRING x= tMoney
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_assDeclStatement312); if (state.failed) return result;
					match(input,CL,FOLLOW_CL_in_assDeclStatement314); if (state.failed) return result;
					s=(Token)match(input,STRING,FOLLOW_STRING_in_assDeclStatement318); if (state.failed) return result;
					pushFollow(FOLLOW_tMoney_in_assDeclStatement322);
					x=tMoney();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question( new Ident((i!=null?i.getText():null)), new Str((s!=null?s.getText():null)), x ); }
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
			if ( state.backtracking>0 ) { memoize(input, 10, assDeclStatement_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "assDeclStatement"



	// $ANTLR start "primary"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: primary returns [Expr result] : (i= INT |s= STRING |m= MONEY |b= BOOLEAN |i= IDENT | LB x= orExpr RB );
	public final Expr primary() throws RecognitionException{
		Expr result = null;

		int primary_StartIndex = input.index();

		Token i=null;
		Token s=null;
		Token m=null;
		Token b=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:3: (i= INT |s= STRING |m= MONEY |b= BOOLEAN |i= IDENT | LB x= orExpr RB )
			int alt6=6;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt6=1;
				}
				break;
			case STRING:
				{
				alt6=2;
				}
				break;
			case MONEY:
				{
				alt6=3;
				}
				break;
			case BOOLEAN:
				{
				alt6=4;
				}
				break;
			case IDENT:
				{
				alt6=5;
				}
				break;
			case LB:
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:5: i= INT
					{
					i=(Token)match(input,INT,FOLLOW_INT_in_primary345); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((i!=null?i.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:5: s= STRING
					{
					s=(Token)match(input,STRING,FOLLOW_STRING_in_primary357); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((s!=null?s.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:75:5: m= MONEY
					{
					m=(Token)match(input,MONEY,FOLLOW_MONEY_in_primary369); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((m!=null?m.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:76:5: b= BOOLEAN
					{
					b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primary379); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool((b!=null?b.getText():null)); }
					}
					break;
				case 5 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:77:5: i= IDENT
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary390); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((i!=null?i.getText():null)); }
					}
					break;
				case 6 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:78:5: LB x= orExpr RB
					{
					match(input,LB,FOLLOW_LB_in_primary398); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary402);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_primary404); if (state.failed) return result;
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
			if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "primary"



	// $ANTLR start "unExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException{
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 49:
				{
				alt7=1;
				}
				break;
			case 50:
				{
				alt7=2;
				}
				break;
			case 45:
				{
				alt7=3;
				}
				break;
			case BOOLEAN:
			case IDENT:
			case INT:
			case LB:
			case MONEY:
			case STRING:
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:8: '+' x= unExpr
					{
					match(input,49,FOLLOW_49_in_unExpr431); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr435);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:8: '-' x= unExpr
					{
					match(input,50,FOLLOW_50_in_unExpr446); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr450);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:8: '!' x= unExpr
					{
					match(input,45,FOLLOW_45_in_unExpr461); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr465);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr478);
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
			if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "mulExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException{
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr516);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==BACKSLASH||LA8_0==48) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==BACKSLASH||input.LA(1)==48 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr536);
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
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:101:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException{
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr577);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 49 && LA9_0 <= 50)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 49 && input.LA(1) <= 50) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr595);
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
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException{
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr630);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==46||(LA10_0 >= 51 && LA10_0 <= 55)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:114:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==46||(input.LA(1) >= 51 && input.LA(1) <= 55) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr654);
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
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException{
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr692);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:46: ( '&&' rhs= relExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==47) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:48: '&&' rhs= relExpr
					{
					match(input,47,FOLLOW_47_in_andExpr698); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr702);
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
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:142:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException{
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr738);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:48: ( '||' rhs= andExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==56) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:143:50: '||' rhs= andExpr
					{
					match(input,56,FOLLOW_56_in_orExpr744); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr748);
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
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_formDeclaration_in_start49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORM_in_formDeclaration66 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_FORMIDENT_in_formDeclaration70 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_block_in_formDeclaration74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orExpr_in_formDeclaration83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_blockContent115 = new BitSet(new long[]{0x0000000000030002L});
	public static final BitSet FOLLOW_LCB_in_block136 = new BitSet(new long[]{0x0000002000030000L});
	public static final BitSet FOLLOW_blockContent_in_block140 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_RCB_in_block142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_conditionalStatement161 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_block_in_conditionalStatement165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assDeclStatement_in_statement185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionalStatement_in_statement194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_condition212 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LB_in_condition214 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_orExpr_in_condition218 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RB_in_condition220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_tMoney239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_tMoney246 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LB_in_tMoney248 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_addExpr_in_tMoney252 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RB_in_tMoney254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_tBoolean274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assDeclStatement293 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CL_in_assDeclStatement295 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_STRING_in_assDeclStatement299 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tBoolean_in_assDeclStatement303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assDeclStatement312 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CL_in_assDeclStatement314 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_STRING_in_assDeclStatement318 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_tMoney_in_assDeclStatement322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_primary357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_primary369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_primary379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LB_in_primary398 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_orExpr_in_primary402 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_RB_in_primary404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unExpr431 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_unExpr446 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unExpr461 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr516 = new BitSet(new long[]{0x0001000000000012L});
	public static final BitSet FOLLOW_set_in_mulExpr524 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr536 = new BitSet(new long[]{0x0001000000000012L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr577 = new BitSet(new long[]{0x0006000000000002L});
	public static final BitSet FOLLOW_set_in_addExpr585 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr595 = new BitSet(new long[]{0x0006000000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr630 = new BitSet(new long[]{0x00F8400000000002L});
	public static final BitSet FOLLOW_set_in_relExpr638 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_addExpr_in_relExpr654 = new BitSet(new long[]{0x00F8400000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr692 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_andExpr698 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_relExpr_in_andExpr702 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr738 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_56_in_orExpr744 = new BitSet(new long[]{0x0006220104050020L});
	public static final BitSet FOLLOW_andExpr_in_orExpr748 = new BitSet(new long[]{0x0100000000000002L});
}
