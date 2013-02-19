// $ANTLR 3.5 C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-18 01:12:40

package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.ast.nodes.types.*;
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
		"DQ", "ELSE", "FORM", "FORMIDENT", "IDENT", "IF", "INT", "INT_DIGIT", 
		"KEYWORD_BOOLEAN", "KEYWORD_ELSE", "KEYWORD_FALSE", "KEYWORD_FORM", "KEYWORD_IF", 
		"KEYWORD_MONEY", "KEYWORD_TRUE", "LB", "LCB", "LEFT_BRACKED", "LEFT_CURLY_BRACKED", 
		"LINE_COMMENT", "LOWERCASE_LETTER", "MONEY", "MONEY_COMMA", "POINT", "QUESTION_MARK", 
		"RB", "RCB", "RIGHT_BRACKED", "RIGHT_CURLY_BRACKED", "SINGLE_SPACE", "STRING", 
		"UNDERSCORE", "UPPERCASE_LETTER", "WS", "'!'", "'!='", "'&&'", "'*'", 
		"'+'", "'-'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__57=57;
	public static final int T__58=58;
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
	public static final int ELSE=14;
	public static final int FORM=15;
	public static final int FORMIDENT=16;
	public static final int IDENT=17;
	public static final int IF=18;
	public static final int INT=19;
	public static final int INT_DIGIT=20;
	public static final int KEYWORD_BOOLEAN=21;
	public static final int KEYWORD_ELSE=22;
	public static final int KEYWORD_FALSE=23;
	public static final int KEYWORD_FORM=24;
	public static final int KEYWORD_IF=25;
	public static final int KEYWORD_MONEY=26;
	public static final int KEYWORD_TRUE=27;
	public static final int LB=28;
	public static final int LCB=29;
	public static final int LEFT_BRACKED=30;
	public static final int LEFT_CURLY_BRACKED=31;
	public static final int LINE_COMMENT=32;
	public static final int LOWERCASE_LETTER=33;
	public static final int MONEY=34;
	public static final int MONEY_COMMA=35;
	public static final int POINT=36;
	public static final int QUESTION_MARK=37;
	public static final int RB=38;
	public static final int RCB=39;
	public static final int RIGHT_BRACKED=40;
	public static final int RIGHT_CURLY_BRACKED=41;
	public static final int SINGLE_SPACE=42;
	public static final int STRING=43;
	public static final int UNDERSCORE=44;
	public static final int UPPERCASE_LETTER=45;
	public static final int WS=46;

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
		this.state.ruleMemo = new HashMap[47+1];


	}

	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }



	// $ANTLR start "start"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:1: start returns [Expr result] : fD= formDeclaration ;
	public final Expr start() throws RecognitionException {
		Expr result = null;

		int start_StartIndex = input.index();

		Expr fD =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:2: (fD= formDeclaration )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:4: fD= formDeclaration
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:1: formDeclaration returns [Expr result] : ( FORM i= FORMIDENT b= block |x= block |x= statement |x= condition |x= conditionalStatement |x= unExpr );
	public final Expr formDeclaration() throws RecognitionException {
		Expr result = null;

		int formDeclaration_StartIndex = input.index();

		Token i=null;
		Statement b =null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:2: ( FORM i= FORMIDENT b= block |x= block |x= statement |x= condition |x= conditionalStatement |x= unExpr )
			int alt1=6;
			switch ( input.LA(1) ) {
			case FORM:
				{
				alt1=1;
				}
				break;
			case LCB:
				{
				alt1=2;
				}
				break;
			case IDENT:
				{
				int LA1_3 = input.LA(2);
				if ( (synpred3_QL()) ) {
					alt1=3;
				}
				else if ( (true) ) {
					alt1=6;
				}

				}
				break;
			case IF:
				{
				int LA1_4 = input.LA(2);
				if ( (synpred3_QL()) ) {
					alt1=3;
				}
				else if ( (synpred4_QL()) ) {
					alt1=4;
				}
				else if ( (synpred5_QL()) ) {
					alt1=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BOOLEAN:
			case INT:
			case LB:
			case MONEY:
			case STRING:
			case 47:
			case 51:
			case 52:
				{
				alt1=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:4: FORM i= FORMIDENT b= block
					{
					match(input,FORM,FOLLOW_FORM_in_formDeclaration66); if (state.failed) return result;
					i=(Token)match(input,FORMIDENT,FOLLOW_FORMIDENT_in_formDeclaration70); if (state.failed) return result;
					pushFollow(FOLLOW_block_in_formDeclaration74);
					b=block();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Form(new Ident((i!=null?i.getText():null)), b);}
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:4: x= block
					{
					pushFollow(FOLLOW_block_in_formDeclaration85);
					x=block();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 3 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:4: x= statement
					{
					pushFollow(FOLLOW_statement_in_formDeclaration94);
					x=statement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 4 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:4: x= condition
					{
					pushFollow(FOLLOW_condition_in_formDeclaration103);
					x=condition();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 5 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:4: x= conditionalStatement
					{
					pushFollow(FOLLOW_conditionalStatement_in_formDeclaration112);
					x=conditionalStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 6 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:34:4: x= unExpr
					{
					pushFollow(FOLLOW_unExpr_in_formDeclaration121);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result = x; }
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:37:1: blockContent returns [ArrayList<Statement> result] : (v= statement )* ;
	public final ArrayList<Statement> blockContent() throws RecognitionException {
		ArrayList<Statement> result = null;

		int blockContent_StartIndex = input.index();

		Statement v =null;


			    	result = new ArrayList<Statement>();
			
		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:6: ( (v= statement )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: (v= statement )*
			{
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:8: (v= statement )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= IDENT && LA2_0 <= IF)) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:42:9: v= statement
					{
					pushFollow(FOLLOW_statement_in_blockContent153);
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:45:1: block returns [Statement result] : LCB b= blockContent RCB ;
	public final Statement block() throws RecognitionException {
		Statement result = null;

		int block_StartIndex = input.index();

		ArrayList<Statement> b =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:2: ( LCB b= blockContent RCB )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:46:4: LCB b= blockContent RCB
			{
			match(input,LCB,FOLLOW_LCB_in_block174); if (state.failed) return result;
			pushFollow(FOLLOW_blockContent_in_block178);
			b=blockContent();
			state._fsp--;
			if (state.failed) return result;
			match(input,RCB,FOLLOW_RCB_in_block180); if (state.failed) return result;
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:49:1: conditionalStatement returns [Statement result] : c= condition b= block ;
	public final Statement conditionalStatement() throws RecognitionException {
		Statement result = null;

		int conditionalStatement_StartIndex = input.index();

		Statement c =null;
		Statement b =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:2: (c= condition b= block )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:50:4: c= condition b= block
			{
			pushFollow(FOLLOW_condition_in_conditionalStatement199);
			c=condition();
			state._fsp--;
			if (state.failed) return result;
			pushFollow(FOLLOW_block_in_conditionalStatement203);
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:53:1: statement returns [Statement result] : (a= assDeclStatement |c= conditionalStatement );
	public final Statement statement() throws RecognitionException {
		Statement result = null;

		int statement_StartIndex = input.index();

		Statement a =null;
		Statement c =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:2: (a= assDeclStatement |c= conditionalStatement )
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:54:4: a= assDeclStatement
					{
					pushFollow(FOLLOW_assDeclStatement_in_statement223);
					a=assDeclStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = a; }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:55:4: c= conditionalStatement
					{
					pushFollow(FOLLOW_conditionalStatement_in_statement232);
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:58:1: condition returns [Statement result] : ( IF LB x= IDENT RB | IF LB e= unExpr RB );
	public final Statement condition() throws RecognitionException {
		Statement result = null;

		int condition_StartIndex = input.index();

		Token x=null;
		Expr e =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:2: ( IF LB x= IDENT RB | IF LB e= unExpr RB )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IF) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==LB) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==IDENT) ) {
						int LA4_3 = input.LA(4);
						if ( (LA4_3==RB) ) {
							int LA4_5 = input.LA(5);
							if ( (synpred8_QL()) ) {
								alt4=1;
							}
							else if ( (true) ) {
								alt4=2;
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA4_2==BOOLEAN||LA4_2==INT||LA4_2==LB||LA4_2==MONEY||LA4_2==STRING||LA4_2==47||(LA4_2 >= 51 && LA4_2 <= 52)) ) {
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:4: IF LB x= IDENT RB
					{
					match(input,IF,FOLLOW_IF_in_condition250); if (state.failed) return result;
					match(input,LB,FOLLOW_LB_in_condition252); if (state.failed) return result;
					x=(Token)match(input,IDENT,FOLLOW_IDENT_in_condition256); if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_condition258); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Condition(new Ident((x!=null?x.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:60:4: IF LB e= unExpr RB
					{
					match(input,IF,FOLLOW_IF_in_condition265); if (state.failed) return result;
					match(input,LB,FOLLOW_LB_in_condition267); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_condition271);
					e=unExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_condition273); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Condition(e); }
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
			if ( state.backtracking>0 ) { memoize(input, 7, condition_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "condition"



	// $ANTLR start "tMoney"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:63:1: tMoney returns [Expr result] : (m= MONEY | MONEY LB x= addExpr RB );
	public final Expr tMoney() throws RecognitionException {
		Expr result = null;

		int tMoney_StartIndex = input.index();

		Token m=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:2: (m= MONEY | MONEY LB x= addExpr RB )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==MONEY) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==LB) ) {
					alt5=2;
				}
				else if ( (LA5_1==EOF||(LA5_1 >= IDENT && LA5_1 <= IF)||LA5_1==RCB) ) {
					alt5=1;
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:64:4: m= MONEY
					{
					m=(Token)match(input,MONEY,FOLLOW_MONEY_in_tMoney292); if (state.failed) return result;
					if ( state.backtracking==0 ) {result = new Money((m!=null?m.getText():null));}
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:65:4: MONEY LB x= addExpr RB
					{
					match(input,MONEY,FOLLOW_MONEY_in_tMoney299); if (state.failed) return result;
					match(input,LB,FOLLOW_LB_in_tMoney301); if (state.failed) return result;
					pushFollow(FOLLOW_addExpr_in_tMoney305);
					x=addExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_tMoney307); if (state.failed) return result;
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:68:1: tBoolean returns [Expr result] : b= BOOLEAN ;
	public final Expr tBoolean() throws RecognitionException {
		Expr result = null;

		int tBoolean_StartIndex = input.index();

		Token b=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:2: (b= BOOLEAN )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:69:4: b= BOOLEAN
			{
			b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_tBoolean327); if (state.failed) return result;
			if ( state.backtracking==0 ) {result = new Bool(new Boolean(false));}
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:72:1: assDeclStatement returns [Statement result] : (i= IDENT CL s= STRING b= tBoolean |i= IDENT CL s= STRING x= tMoney );
	public final Statement assDeclStatement() throws RecognitionException {
		Statement result = null;

		int assDeclStatement_StartIndex = input.index();

		Token i=null;
		Token s=null;
		Expr b =null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:2: (i= IDENT CL s= STRING b= tBoolean |i= IDENT CL s= STRING x= tMoney )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IDENT) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==CL) ) {
					int LA6_2 = input.LA(3);
					if ( (LA6_2==STRING) ) {
						int LA6_3 = input.LA(4);
						if ( (LA6_3==BOOLEAN) ) {
							alt6=1;
						}
						else if ( (LA6_3==MONEY) ) {
							alt6=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 3, input);
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
								new NoViableAltException("", 6, 2, input);
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
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:73:4: i= IDENT CL s= STRING b= tBoolean
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_assDeclStatement346); if (state.failed) return result;
					match(input,CL,FOLLOW_CL_in_assDeclStatement348); if (state.failed) return result;
					s=(Token)match(input,STRING,FOLLOW_STRING_in_assDeclStatement352); if (state.failed) return result;
					pushFollow(FOLLOW_tBoolean_in_assDeclStatement356);
					b=tBoolean();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question( new Ident((i!=null?i.getText():null)), new QuestionBody(new Str((s!=null?s.getText():null)), b )); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:74:4: i= IDENT CL s= STRING x= tMoney
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_assDeclStatement365); if (state.failed) return result;
					match(input,CL,FOLLOW_CL_in_assDeclStatement367); if (state.failed) return result;
					s=(Token)match(input,STRING,FOLLOW_STRING_in_assDeclStatement371); if (state.failed) return result;
					pushFollow(FOLLOW_tMoney_in_assDeclStatement375);
					x=tMoney();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Question( new Ident((i!=null?i.getText():null)),  new QuestionBody(new Str((s!=null?s.getText():null)), x )); }
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:79:1: primary returns [Expr result] : (i= INT |s= STRING |m= MONEY |b= BOOLEAN | LB x= orExpr RB |i= IDENT );
	public final Expr primary() throws RecognitionException {
		Expr result = null;

		int primary_StartIndex = input.index();

		Token i=null;
		Token s=null;
		Token m=null;
		Token b=null;
		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:3: (i= INT |s= STRING |m= MONEY |b= BOOLEAN | LB x= orExpr RB |i= IDENT )
			int alt7=6;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt7=1;
				}
				break;
			case STRING:
				{
				alt7=2;
				}
				break;
			case MONEY:
				{
				alt7=3;
				}
				break;
			case BOOLEAN:
				{
				alt7=4;
				}
				break;
			case LB:
				{
				alt7=5;
				}
				break;
			case IDENT:
				{
				alt7=6;
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
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:80:5: i= INT
					{
					i=(Token)match(input,INT,FOLLOW_INT_in_primary398); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Int(Integer.parseInt((i!=null?i.getText():null))); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:81:5: s= STRING
					{
					s=(Token)match(input,STRING,FOLLOW_STRING_in_primary410); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Str((s!=null?s.getText():null)); }
					}
					break;
				case 3 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:82:5: m= MONEY
					{
					m=(Token)match(input,MONEY,FOLLOW_MONEY_in_primary422); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Money((m!=null?m.getText():null)); }
					}
					break;
				case 4 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:83:5: b= BOOLEAN
					{
					b=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primary432); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Bool(new Boolean(false)); }
					}
					break;
				case 5 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:84:5: LB x= orExpr RB
					{
					match(input,LB,FOLLOW_LB_in_primary441); if (state.failed) return result;
					pushFollow(FOLLOW_orExpr_in_primary445);
					x=orExpr();
					state._fsp--;
					if (state.failed) return result;
					match(input,RB,FOLLOW_RB_in_primary447); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = x; }
					}
					break;
				case 6 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:85:5: i= IDENT
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_primary457); if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Ident((i!=null?i.getText():null)); }
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:88:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final Expr unExpr() throws RecognitionException {
		Expr result = null;

		int unExpr_StartIndex = input.index();

		Expr x =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt8=4;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt8=1;
				}
				break;
			case 52:
				{
				alt8=2;
				}
				break;
			case 47:
				{
				alt8=3;
				}
				break;
			case BOOLEAN:
			case IDENT:
			case INT:
			case LB:
			case MONEY:
			case STRING:
				{
				alt8=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:89:8: '+' x= unExpr
					{
					match(input,51,FOLLOW_51_in_unExpr484); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr488);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Pos(x); }
					}
					break;
				case 2 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:8: '-' x= unExpr
					{
					match(input,52,FOLLOW_52_in_unExpr499); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr503);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Neg(x); }
					}
					break;
				case 3 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:8: '!' x= unExpr
					{
					match(input,47,FOLLOW_47_in_unExpr514); if (state.failed) return result;
					pushFollow(FOLLOW_unExpr_in_unExpr518);
					x=unExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Not(x); }
					}
					break;
				case 4 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:92:8: x= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr531);
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
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final Expr mulExpr() throws RecognitionException {
		Expr result = null;

		int mulExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_mulExpr569);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:45: (op= ( '*' | '/' ) rhs= unExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==BACKSLASH||LA9_0==50) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:96:47: op= ( '*' | '/' ) rhs= unExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==BACKSLASH||input.LA(1)==50 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr589);
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
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "mulExpr"



	// $ANTLR start "addExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:108:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final Expr addExpr() throws RecognitionException {
		Expr result = null;

		int addExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			pushFollow(FOLLOW_mulExpr_in_addExpr630);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 51 && LA10_0 <= 52)) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					op=input.LT(1);
					if ( (input.LA(1) >= 51 && input.LA(1) <= 52) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr648);
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
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "relExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:120:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final Expr relExpr() throws RecognitionException {
		Expr result = null;

		int relExpr_StartIndex = input.index();

		Token op=null;
		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			pushFollow(FOLLOW_addExpr_in_relExpr683);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==48||(LA11_0 >= 53 && LA11_0 <= 57)) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					op=input.LT(1);
					if ( input.LA(1)==48||(input.LA(1) >= 53 && input.LA(1) <= 57) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr707);
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
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "andExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final Expr andExpr() throws RecognitionException {
		Expr result = null;

		int andExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr745);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result =lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:46: ( '&&' rhs= relExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==49) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:145:48: '&&' rhs= relExpr
					{
					match(input,49,FOLLOW_49_in_andExpr751); if (state.failed) return result;
					pushFollow(FOLLOW_relExpr_in_andExpr755);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new And(result, rhs); }
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
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		return result;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "orExpr"
	// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final Expr orExpr() throws RecognitionException {
		Expr result = null;

		int orExpr_StartIndex = input.index();

		Expr lhs =null;
		Expr rhs =null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return result; }

			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_orExpr791);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) { result = lhs; }
			// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:48: ( '||' rhs= andExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==58) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:50: '||' rhs= andExpr
					{
					match(input,58,FOLLOW_58_in_orExpr797); if (state.failed) return result;
					pushFollow(FOLLOW_andExpr_in_orExpr801);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) { result = new Or(result, rhs); }
					}
					break;

				default :
					break loop13;
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

	// $ANTLR start synpred3_QL
	public final void synpred3_QL_fragment() throws RecognitionException {
		Statement x =null;

		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:4: (x= statement )
		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:31:4: x= statement
		{
		pushFollow(FOLLOW_statement_in_synpred3_QL94);
		x=statement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred3_QL

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		Statement x =null;

		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:4: (x= condition )
		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:32:4: x= condition
		{
		pushFollow(FOLLOW_condition_in_synpred4_QL103);
		x=condition();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred4_QL

	// $ANTLR start synpred5_QL
	public final void synpred5_QL_fragment() throws RecognitionException {
		Statement x =null;

		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:4: (x= conditionalStatement )
		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:33:4: x= conditionalStatement
		{
		pushFollow(FOLLOW_conditionalStatement_in_synpred5_QL112);
		x=conditionalStatement();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred5_QL

	// $ANTLR start synpred8_QL
	public final void synpred8_QL_fragment() throws RecognitionException {
		Token x=null;

		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:4: ( IF LB x= IDENT RB )
		// C:\\Users\\Turambar\\eclipse-workspace\\sea-of-ql\\sroh10378782\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:59:4: IF LB x= IDENT RB
		{
		match(input,IF,FOLLOW_IF_in_synpred8_QL250); if (state.failed) return;
		match(input,LB,FOLLOW_LB_in_synpred8_QL252); if (state.failed) return;
		x=(Token)match(input,IDENT,FOLLOW_IDENT_in_synpred8_QL256); if (state.failed) return;
		match(input,RB,FOLLOW_RB_in_synpred8_QL258); if (state.failed) return;
		}

	}
	// $ANTLR end synpred8_QL

	// Delegated rules

	public final boolean synpred5_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_QL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_QL_fragment(); // can never throw exception
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



	public static final BitSet FOLLOW_formDeclaration_in_start49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FORM_in_formDeclaration66 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FORMIDENT_in_formDeclaration70 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_block_in_formDeclaration74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_formDeclaration85 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_formDeclaration94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_formDeclaration103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionalStatement_in_formDeclaration112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_formDeclaration121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_blockContent153 = new BitSet(new long[]{0x0000000000060002L});
	public static final BitSet FOLLOW_LCB_in_block174 = new BitSet(new long[]{0x0000008000060000L});
	public static final BitSet FOLLOW_blockContent_in_block178 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RCB_in_block180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_conditionalStatement199 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_block_in_conditionalStatement203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assDeclStatement_in_statement223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionalStatement_in_statement232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_condition250 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LB_in_condition252 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_IDENT_in_condition256 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RB_in_condition258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_condition265 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LB_in_condition267 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_unExpr_in_condition271 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RB_in_condition273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_tMoney292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_tMoney299 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LB_in_tMoney301 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_addExpr_in_tMoney305 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RB_in_tMoney307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_tBoolean327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assDeclStatement346 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CL_in_assDeclStatement348 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_STRING_in_assDeclStatement352 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tBoolean_in_assDeclStatement356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assDeclStatement365 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CL_in_assDeclStatement367 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_STRING_in_assDeclStatement371 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_tMoney_in_assDeclStatement375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_primary410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONEY_in_primary422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOLEAN_in_primary432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LB_in_primary441 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_orExpr_in_primary445 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RB_in_primary447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_unExpr484 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_unExpr499 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_unExpr514 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_unExpr_in_unExpr518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr569 = new BitSet(new long[]{0x0004000000000012L});
	public static final BitSet FOLLOW_set_in_mulExpr577 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr589 = new BitSet(new long[]{0x0004000000000012L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr630 = new BitSet(new long[]{0x0018000000000002L});
	public static final BitSet FOLLOW_set_in_addExpr638 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr648 = new BitSet(new long[]{0x0018000000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr683 = new BitSet(new long[]{0x03E1000000000002L});
	public static final BitSet FOLLOW_set_in_relExpr691 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_addExpr_in_relExpr707 = new BitSet(new long[]{0x03E1000000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr745 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_49_in_andExpr751 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_relExpr_in_andExpr755 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr791 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_58_in_orExpr797 = new BitSet(new long[]{0x00188804100A0020L});
	public static final BitSet FOLLOW_andExpr_in_orExpr801 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_statement_in_synpred3_QL94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condition_in_synpred4_QL103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionalStatement_in_synpred5_QL112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred8_QL250 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_LB_in_synpred8_QL252 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_IDENT_in_synpred8_QL256 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RB_in_synpred8_QL258 = new BitSet(new long[]{0x0000000000000002L});
}
