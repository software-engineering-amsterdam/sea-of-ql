// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-12 23:15:02

package org.uva.sea.ql.parser.antlr;
import java.util.Map; 
import java.util.HashMap; 
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.questionnaire.Questionnaire;
import org.uva.sea.ql.ast.expr.ASTNode;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLTreeWalker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_EXPRESSION", 
		"ASSIGNMENT_TYPE", "Add", "And", "Assignment_Indicator", "Bool", "BooleanType", 
		"COMMENT", "Div", "Else", "Equ", "FormId", "FormStart", "GT", "GTEqu", 
		"IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", "IF_CONDITION", "IF_STATEMENT", 
		"Ident", "If", "Int", "LT", "LTEqu", "Lbr", "MoneyType", "Mul", "Not", 
		"NotEqu", "Or", "QUESTION_LABEL", "Rbr", "RoundLbr", "RoundRbr", "String", 
		"Sub", "UNARY_MINUS", "UNARY_NEGATE", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_EXPRESSION=5;
	public static final int ASSIGNMENT_TYPE=6;
	public static final int Add=7;
	public static final int And=8;
	public static final int Assignment_Indicator=9;
	public static final int Bool=10;
	public static final int BooleanType=11;
	public static final int COMMENT=12;
	public static final int Div=13;
	public static final int Else=14;
	public static final int Equ=15;
	public static final int FormId=16;
	public static final int FormStart=17;
	public static final int GT=18;
	public static final int GTEqu=19;
	public static final int IDENT=20;
	public static final int IF_BLOCK_FALSE=21;
	public static final int IF_BLOCK_TRUE=22;
	public static final int IF_CONDITION=23;
	public static final int IF_STATEMENT=24;
	public static final int Ident=25;
	public static final int If=26;
	public static final int Int=27;
	public static final int LT=28;
	public static final int LTEqu=29;
	public static final int Lbr=30;
	public static final int MoneyType=31;
	public static final int Mul=32;
	public static final int Not=33;
	public static final int NotEqu=34;
	public static final int Or=35;
	public static final int QUESTION_LABEL=36;
	public static final int Rbr=37;
	public static final int RoundLbr=38;
	public static final int RoundRbr=39;
	public static final int String=40;
	public static final int Sub=41;
	public static final int UNARY_MINUS=42;
	public static final int UNARY_NEGATE=43;
	public static final int WS=44;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public QLTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return QLTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g"; }


	  public Map<Ident,Type> typeEnv = null; 
		  
		  public QLTreeWalker(CommonTreeNodeStream nodes, Map<Ident,Type> typeEnv) { 
		  super(nodes); 
		  this.typeEnv = typeEnv;
		    
		  } 



	// $ANTLR start "walk"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:32:1: walk returns [Questionnaire root] : ^( FormId ( blockItem )* ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:33:2: ( ^( FormId ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:33:5: ^( FormId ( blockItem )* )
			{
			match(input,FormId,FOLLOW_FormId_in_walk48); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:33:14: ( blockItem )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==IF_STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:33:14: blockItem
						{
						pushFollow(FOLLOW_blockItem_in_walk50);
						blockItem();
						state._fsp--;

						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			root = new Questionnaire("KOMM SCHON") ;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return root;
	}
	// $ANTLR end "walk"



	// $ANTLR start "blockItem"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:35:1: blockItem returns [Stat stat] : ( questionAssignment | constantAssignment | ifBlock ) ;
	public final Stat blockItem() throws RecognitionException {
		Stat stat = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:36:2: ( ( questionAssignment | constantAssignment | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:36:3: ( questionAssignment | constantAssignment | ifBlock )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:36:3: ( questionAssignment | constantAssignment | ifBlock )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ASSIGNMENT) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==IDENT) ) {
						int LA2_4 = input.LA(4);
						if ( (LA2_4==DOWN) ) {
							int LA2_5 = input.LA(5);
							if ( (LA2_5==Ident) ) {
								int LA2_6 = input.LA(6);
								if ( (LA2_6==UP) ) {
									int LA2_7 = input.LA(7);
									if ( (LA2_7==ASSIGNMENT_TYPE) ) {
										int LA2_8 = input.LA(8);
										if ( (LA2_8==DOWN) ) {
											int LA2_9 = input.LA(9);
											if ( (LA2_9==BooleanType) ) {
												int LA2_10 = input.LA(10);
												if ( (LA2_10==UP) ) {
													int LA2_12 = input.LA(11);
													if ( (LA2_12==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_12==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 12, input);
															throw nvae;
														} finally {
															input.rewind(nvaeMark);
														}
													}

												}

												else {
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 2, 10, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}
											else if ( (LA2_9==MoneyType) ) {
												int LA2_11 = input.LA(10);
												if ( (LA2_11==UP) ) {
													int LA2_12 = input.LA(11);
													if ( (LA2_12==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_12==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 12, input);
															throw nvae;
														} finally {
															input.rewind(nvaeMark);
														}
													}

												}

												else {
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 2, 11, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}

											else {
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 2, 9, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 2, 8, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 2, 7, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 2, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

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
			else if ( (LA2_0==IF_STATEMENT) ) {
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:36:4: questionAssignment
					{
					pushFollow(FOLLOW_questionAssignment_in_blockItem68);
					questionAssignment();
					state._fsp--;

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:37:4: constantAssignment
					{
					pushFollow(FOLLOW_constantAssignment_in_blockItem74);
					constantAssignment();
					state._fsp--;

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:38:4: ifBlock
					{
					pushFollow(FOLLOW_ifBlock_in_blockItem80);
					ifBlock();
					state._fsp--;

					}
					break;

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
		return stat;
	}
	// $ANTLR end "blockItem"



	// $ANTLR start "questionAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:41:1: questionAssignment returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) ;
	public final Stat questionAssignment() throws RecognitionException {
		Stat stat = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_questionAssignment100); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_questionAssignment103); 
			match(input, Token.DOWN, null); 
			match(input,Ident,FOLLOW_Ident_in_questionAssignment105); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_questionAssignment109); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_questionAssignment111);
			identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,QUESTION_LABEL,FOLLOW_QUESTION_LABEL_in_questionAssignment115); 
			match(input, Token.DOWN, null); 
			match(input,String,FOLLOW_String_in_questionAssignment118); 
			match(input, Token.UP, null); 

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:88: ( ^( ASSIGNMENT_EXPRESSION expression ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ASSIGNMENT_EXPRESSION) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:89: ^( ASSIGNMENT_EXPRESSION expression )
					{
					match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_questionAssignment124); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_questionAssignment126);
					expression();
					state._fsp--;

					match(input, Token.UP, null); 

					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return stat;
	}
	// $ANTLR end "questionAssignment"



	// $ANTLR start "constantAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:1: constantAssignment returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) ;
	public final Stat constantAssignment() throws RecognitionException {
		Stat stat = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_constantAssignment151); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_constantAssignment154); 
			match(input, Token.DOWN, null); 
			match(input,Ident,FOLLOW_Ident_in_constantAssignment156); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_constantAssignment161); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_constantAssignment163);
			identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_constantAssignment167); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_constantAssignment170);
			expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return stat;
	}
	// $ANTLR end "constantAssignment"



	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:52:1: identType returns [Type t] : ( BooleanType | MoneyType );
	public final Type identType() throws RecognitionException {
		Type t = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:53:2: ( BooleanType | MoneyType )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==BooleanType) ) {
				alt4=1;
			}
			else if ( (LA4_0==MoneyType) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:53:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType191); 
					t = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:54:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType200); 
					t = new MoneyType();
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
		return t;
	}
	// $ANTLR end "identType"



	// $ANTLR start "ifBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:57:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ( blockItem )* ) ( ^( IF_BLOCK_FALSE ( blockItem )+ ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ( blockItem )* ) ( ^( IF_BLOCK_FALSE ( blockItem )+ ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ( blockItem )* ) ( ^( IF_BLOCK_FALSE ( blockItem )+ ) )? )
			{
			match(input,IF_STATEMENT,FOLLOW_IF_STATEMENT_in_ifBlock220); 
			match(input, Token.DOWN, null); 
			match(input,IF_CONDITION,FOLLOW_IF_CONDITION_in_ifBlock224); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifBlock226);
			expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,IF_BLOCK_TRUE,FOLLOW_IF_BLOCK_TRUE_in_ifBlock232); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:65: ( blockItem )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==ASSIGNMENT||LA5_0==IF_STATEMENT) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:65: blockItem
						{
						pushFollow(FOLLOW_blockItem_in_ifBlock234);
						blockItem();
						state._fsp--;

						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:77: ( ^( IF_BLOCK_FALSE ( blockItem )+ ) )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==IF_BLOCK_FALSE) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:78: ^( IF_BLOCK_FALSE ( blockItem )+ )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock240); 
					match(input, Token.DOWN, null); 
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:95: ( blockItem )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==ASSIGNMENT||LA6_0==IF_STATEMENT) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:58:95: blockItem
							{
							pushFollow(FOLLOW_blockItem_in_ifBlock242);
							blockItem();
							state._fsp--;

							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					match(input, Token.UP, null); 

					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return stat;
	}
	// $ANTLR end "ifBlock"



	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:62:1: ifStatementBlock returns [Stat\tblock] : ( blockItem )* ;
	public final Stat ifStatementBlock() throws RecognitionException {
		Stat block = null;


		Stat blockItem1 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:2: ( ( blockItem )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:6: ( blockItem )*
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:6: ( blockItem )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ASSIGNMENT||LA8_0==IF_STATEMENT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:6: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock267);
					blockItem1=blockItem();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			block = blockItem1;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return block;
	}
	// $ANTLR end "ifStatementBlock"



	// $ANTLR start "elseBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:66:1: elseBlock returns [Stat block] : ( blockItem )* ;
	public final Stat elseBlock() throws RecognitionException {
		Stat block = null;


		Stat blockItem2 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:67:2: ( ( blockItem )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:67:5: ( blockItem )*
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:67:5: ( blockItem )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==ASSIGNMENT||LA9_0==IF_STATEMENT) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:67:5: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_elseBlock286);
					blockItem2=blockItem();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}

			block = blockItem2;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return block;
	}
	// $ANTLR end "elseBlock"



	// $ANTLR start "expression"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:70:1: expression returns [Expr node] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident );
	public final Expr expression() throws RecognitionException {
		Expr node = null;


		CommonTree Int3=null;
		CommonTree Ident4=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:71:3: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident )
			int alt10=16;
			switch ( input.LA(1) ) {
			case Or:
				{
				alt10=1;
				}
				break;
			case And:
				{
				alt10=2;
				}
				break;
			case Equ:
				{
				alt10=3;
				}
				break;
			case NotEqu:
				{
				alt10=4;
				}
				break;
			case GTEqu:
				{
				alt10=5;
				}
				break;
			case LTEqu:
				{
				alt10=6;
				}
				break;
			case GT:
				{
				alt10=7;
				}
				break;
			case LT:
				{
				alt10=8;
				}
				break;
			case Add:
				{
				alt10=9;
				}
				break;
			case Sub:
				{
				alt10=10;
				}
				break;
			case Mul:
				{
				alt10=11;
				}
				break;
			case Div:
				{
				alt10=12;
				}
				break;
			case UNARY_MINUS:
				{
				alt10=13;
				}
				break;
			case UNARY_NEGATE:
				{
				alt10=14;
				}
				break;
			case Int:
				{
				alt10=15;
				}
				break;
			case Ident:
				{
				alt10=16;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:72:6: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression313); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression317);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression321);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Or(lhs,rhs);
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:6: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression332); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression336);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression340);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new And(lhs,rhs);
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:6: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression352); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression356);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression360);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Eq(lhs,rhs);
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:6: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression371); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression375);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression379);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new NEq(lhs,rhs);
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:6: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression390); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression394);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression398);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GEq(lhs,rhs);
					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:77:6: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression409); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression413);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression417);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LEq(lhs,rhs);
					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:78:6: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression428); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression432);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression436);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GT(lhs,rhs);
					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:6: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression447); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression451);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression455);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LT(lhs,rhs);
					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:80:6: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression466); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression470);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression474);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Add(lhs,rhs);
					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:81:6: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression485); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression489);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression493);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Sub(lhs,rhs);
					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:82:6: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression504); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression508);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression512);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Mul(lhs,rhs);
					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:6: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression523); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression527);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression531);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Div(lhs,rhs);
					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:84:6: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression542); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression546);
					ex=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Neg(ex);
					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:85:6: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression557); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression561);
					ex=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Not(ex);
					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:6: Int
					{
					Int3=(CommonTree)match(input,Int,FOLLOW_Int_in_expression571); 
					node = new Int(Integer.parseInt((Int3!=null?Int3.getText():null)));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:6: Ident
					{
					Ident4=(CommonTree)match(input,Ident,FOLLOW_Ident_in_expression581); 
					node = new Ident((Ident4!=null?Ident4.getText():null));
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
		return node;
	}
	// $ANTLR end "expression"

	// Delegated rules



	public static final BitSet FOLLOW_FormId_in_walk48 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_walk50 = new BitSet(new long[]{0x0000000001000018L});
	public static final BitSet FOLLOW_questionAssignment_in_blockItem68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_blockItem74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_questionAssignment100 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_questionAssignment103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment105 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_questionAssignment109 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_questionAssignment111 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUESTION_LABEL_in_questionAssignment115 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_String_in_questionAssignment118 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_questionAssignment124 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_questionAssignment126 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_constantAssignment151 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_constantAssignment154 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment156 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_constantAssignment161 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_constantAssignment163 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_constantAssignment167 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_constantAssignment170 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BooleanType_in_identType191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_STATEMENT_in_ifBlock220 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IF_CONDITION_in_ifBlock224 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifBlock226 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_BLOCK_TRUE_in_ifBlock232 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock234 = new BitSet(new long[]{0x0000000001000018L});
	public static final BitSet FOLLOW_IF_BLOCK_FALSE_in_ifBlock240 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock242 = new BitSet(new long[]{0x0000000001000018L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock267 = new BitSet(new long[]{0x0000000001000012L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock286 = new BitSet(new long[]{0x0000000001000012L});
	public static final BitSet FOLLOW_Or_in_expression313 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression317 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression321 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression332 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression336 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression340 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression352 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression356 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression360 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression371 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression375 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression379 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression394 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression409 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression413 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression428 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression432 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression436 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression447 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression451 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression455 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression466 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression470 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression474 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression485 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression489 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression493 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression504 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression508 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression512 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression523 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression527 = new BitSet(new long[]{0x00000E0D3A0CA180L});
	public static final BitSet FOLLOW_expression_in_expression531 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression542 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression546 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression557 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression561 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Int_in_expression571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_expression581 = new BitSet(new long[]{0x0000000000000002L});
}
