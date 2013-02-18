// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-18 05:03:16

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
import org.antlr.runtime.debug.DebugEventListener;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLTreeWalker extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_EXPRESSION", 
		"ASSIGNMENT_TYPE", "Add", "And", "Assignment_Indicator", "BLOCK", "Bool", 
		"BooleanType", "COMMENT", "Div", "Doub", "DoubleType", "Else", "Equ", 
		"FormId", "FormStart", "GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", 
		"IF_CONDITION", "IF_STATEMENT", "Ident", "If", "Int", "IntegerType", "LT", 
		"LTEqu", "Lbr", "MoneyType", "Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", 
		"Rbr", "RoundLbr", "RoundRbr", "Str", "StringType", "Sub", "UNARY_MINUS", 
		"UNARY_NEGATE", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_EXPRESSION=5;
	public static final int ASSIGNMENT_TYPE=6;
	public static final int Add=7;
	public static final int And=8;
	public static final int Assignment_Indicator=9;
	public static final int BLOCK=10;
	public static final int Bool=11;
	public static final int BooleanType=12;
	public static final int COMMENT=13;
	public static final int Div=14;
	public static final int Doub=15;
	public static final int DoubleType=16;
	public static final int Else=17;
	public static final int Equ=18;
	public static final int FormId=19;
	public static final int FormStart=20;
	public static final int GT=21;
	public static final int GTEqu=22;
	public static final int IDENT=23;
	public static final int IF_BLOCK_FALSE=24;
	public static final int IF_BLOCK_TRUE=25;
	public static final int IF_CONDITION=26;
	public static final int IF_STATEMENT=27;
	public static final int Ident=28;
	public static final int If=29;
	public static final int Int=30;
	public static final int IntegerType=31;
	public static final int LT=32;
	public static final int LTEqu=33;
	public static final int Lbr=34;
	public static final int MoneyType=35;
	public static final int Mul=36;
	public static final int Not=37;
	public static final int NotEqu=38;
	public static final int Or=39;
	public static final int QUESTION_LABEL=40;
	public static final int Rbr=41;
	public static final int RoundLbr=42;
	public static final int RoundRbr=43;
	public static final int Str=44;
	public static final int StringType=45;
	public static final int Sub=46;
	public static final int UNARY_MINUS=47;
	public static final int UNARY_NEGATE=48;
	public static final int WS=49;

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


	 
		 public QLTreeWalker(CommonTreeNodeStream nodes) { 
		 super(nodes,new RecognizerSharedState()); 
		  } 
		 



	// $ANTLR start "walk"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:35:1: walk returns [Questionnaire root] : ^(formName= FormId ^( BLOCK ( blockItem )* ) ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		CommonTree formName=null;
		Stat blockItem1 =null;


		Block statBlock = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:2: ( ^(formName= FormId ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:5: ^(formName= FormId ^( BLOCK ( blockItem )* ) )
			{
			formName=(CommonTree)match(input,FormId,FOLLOW_FormId_in_walk62); 
			System.out.println("Start walking");
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_walk68); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:10: ( blockItem )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==IF_STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:11: blockItem
						{
						pushFollow(FOLLOW_blockItem_in_walk71);
						blockItem1=blockItem();
						state._fsp--;

						statBlock.addStatement(blockItem1);
						}
						break;

					default :
						break loop1;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			System.out.println("End walking");
			}


			root = new Questionnaire((formName!=null?formName.getText():null),statBlock);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:1: blockItem returns [Stat stat] : ( questionDeclaration | variableDeclaration | ifBlock ) ;
	public final Stat blockItem() throws RecognitionException {
		Stat stat = null;


		Stat questionDeclaration2 =null;
		Stat variableDeclaration3 =null;
		Stat ifBlock4 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:2: ( ( questionDeclaration | variableDeclaration | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:3: ( questionDeclaration | variableDeclaration | ifBlock )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:3: ( questionDeclaration | variableDeclaration | ifBlock )
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
											switch ( input.LA(9) ) {
											case BooleanType:
												{
												int LA2_10 = input.LA(10);
												if ( (LA2_10==UP) ) {
													int LA2_15 = input.LA(11);
													if ( (LA2_15==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_15==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 15, input);
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
												break;
											case MoneyType:
												{
												int LA2_11 = input.LA(10);
												if ( (LA2_11==UP) ) {
													int LA2_15 = input.LA(11);
													if ( (LA2_15==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_15==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 15, input);
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
												break;
											case IntegerType:
												{
												int LA2_12 = input.LA(10);
												if ( (LA2_12==UP) ) {
													int LA2_15 = input.LA(11);
													if ( (LA2_15==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_15==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 15, input);
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
															new NoViableAltException("", 2, 12, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

												}
												break;
											case StringType:
												{
												int LA2_13 = input.LA(10);
												if ( (LA2_13==UP) ) {
													int LA2_15 = input.LA(11);
													if ( (LA2_15==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_15==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 15, input);
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
															new NoViableAltException("", 2, 13, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

												}
												break;
											case DoubleType:
												{
												int LA2_14 = input.LA(10);
												if ( (LA2_14==UP) ) {
													int LA2_15 = input.LA(11);
													if ( (LA2_15==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_15==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 15, input);
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
															new NoViableAltException("", 2, 14, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

												}
												break;
											default:
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:4: questionDeclaration
					{
					pushFollow(FOLLOW_questionDeclaration_in_blockItem97);
					questionDeclaration2=questionDeclaration();
					state._fsp--;

					stat = questionDeclaration2; 
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:49:4: variableDeclaration
					{
					pushFollow(FOLLOW_variableDeclaration_in_blockItem104);
					variableDeclaration3=variableDeclaration();
					state._fsp--;

					stat = variableDeclaration3; 
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:50:4: ifBlock
					{
					pushFollow(FOLLOW_ifBlock_in_blockItem112);
					ifBlock4=ifBlock();
					state._fsp--;

					stat = ifBlock4; 
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



	// $ANTLR start "questionDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:53:1: questionDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) ;
	public final Stat questionDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident5=null;
		CommonTree Str6=null;
		Type identType7 =null;
		Expr expression8 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:54:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:54:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_questionDeclaration135); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_questionDeclaration138); 
			match(input, Token.DOWN, null); 
			Ident5=(CommonTree)match(input,Ident,FOLLOW_Ident_in_questionDeclaration140); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration144); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_questionDeclaration146);
			identType7=identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,QUESTION_LABEL,FOLLOW_QUESTION_LABEL_in_questionDeclaration150); 
			match(input, Token.DOWN, null); 
			Str6=(CommonTree)match(input,Str,FOLLOW_Str_in_questionDeclaration153); 
			match(input, Token.UP, null); 

			stat = new AnswerableStat(new Ident((Ident5!=null?Ident5.getText():null)),(Str6!=null?Str6.getText():null),identType7);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:57:4: ( ^( ASSIGNMENT_EXPRESSION expression ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ASSIGNMENT_EXPRESSION) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:57:5: ^( ASSIGNMENT_EXPRESSION expression )
					{
					match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration167); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_questionDeclaration169);
					expression8=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					stat = new VisibleComputetStat(new Ident((Ident5!=null?Ident5.getText():null)),(Str6!=null?Str6.getText():null),expression8,identType7);
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
	// $ANTLR end "questionDeclaration"



	// $ANTLR start "variableDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:1: variableDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) ;
	public final Stat variableDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident9=null;
		Expr expression10 =null;
		Type identType11 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:64:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:64:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_variableDeclaration202); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration205); 
			match(input, Token.DOWN, null); 
			Ident9=(CommonTree)match(input,Ident,FOLLOW_Ident_in_variableDeclaration207); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration212); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_variableDeclaration214);
			identType11=identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration218); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_variableDeclaration221);
			expression10=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 

			stat = new HiddenComputetStat(new Ident((Ident9!=null?Ident9.getText():null)),expression10,identType11);
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
	// $ANTLR end "variableDeclaration"



	// $ANTLR start "ifBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:69:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		Stat ifBlockItems =null;
		Stat elseBlockItems =null;
		Expr expression12 =null;


		Block ifBl = new Block();
		Block elseBl = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? )
			{
			match(input,IF_STATEMENT,FOLLOW_IF_STATEMENT_in_ifBlock250); 
			match(input, Token.DOWN, null); 
			match(input,IF_CONDITION,FOLLOW_IF_CONDITION_in_ifBlock254); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifBlock256);
			expression12=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,IF_BLOCK_TRUE,FOLLOW_IF_BLOCK_TRUE_in_ifBlock261); 
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock264); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:72: (ifBlockItems= blockItem )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ASSIGNMENT||LA4_0==IF_STATEMENT) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:73: ifBlockItems= blockItem
						{
						pushFollow(FOLLOW_blockItem_in_ifBlock269);
						ifBlockItems=blockItem();
						state._fsp--;

						ifBl. addStatement(ifBlockItems);
						}
						break;

					default :
						break loop4;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			stat = new IfThenStat(expression12,ifBl);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:2: ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IF_BLOCK_FALSE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:3: ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock282); 
					match(input, Token.DOWN, null); 
					match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock285); 
					match(input, Token.DOWN, null); 
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:28: (elseBlockItems= blockItem )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==ASSIGNMENT||LA5_0==IF_STATEMENT) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:29: elseBlockItems= blockItem
							{
							pushFollow(FOLLOW_blockItem_in_ifBlock290);
							elseBlockItems=blockItem();
							state._fsp--;

							elseBl.addStatement(elseBlockItems);
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					match(input, Token.UP, null); 

					match(input, Token.UP, null); 

					stat = new IfThenElseStat(expression12,ifBl,elseBl);
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



	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:1: identType returns [Type type] : ( BooleanType | MoneyType | IntegerType | StringType | DoubleType );
	public final Type identType() throws RecognitionException {
		Type type = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:88:2: ( BooleanType | MoneyType | IntegerType | StringType | DoubleType )
			int alt7=5;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				alt7=1;
				}
				break;
			case MoneyType:
				{
				alt7=2;
				}
				break;
			case IntegerType:
				{
				alt7=3;
				}
				break;
			case StringType:
				{
				alt7=4;
				}
				break;
			case DoubleType:
				{
				alt7=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:88:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType331); 
					type = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:89:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType340); 
					type = new MoneyType();
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:90:4: IntegerType
					{
					match(input,IntegerType,FOLLOW_IntegerType_in_identType348); 
					type = new IntType();
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:4: StringType
					{
					match(input,StringType,FOLLOW_StringType_in_identType356); 
					type = new StringType();
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:92:4: DoubleType
					{
					match(input,DoubleType,FOLLOW_DoubleType_in_identType364); 
					type = new DoubleType();
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
		return type;
	}
	// $ANTLR end "identType"



	// $ANTLR start "expression"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:95:1: expression returns [Expr result] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Doub | Str | Ident ) ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		CommonTree Int13=null;
		CommonTree Doub14=null;
		CommonTree Str15=null;
		CommonTree Ident16=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:3: ( ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Doub | Str | Ident ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Doub | Str | Ident )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Doub | Str | Ident )
			int alt8=18;
			switch ( input.LA(1) ) {
			case Or:
				{
				alt8=1;
				}
				break;
			case And:
				{
				alt8=2;
				}
				break;
			case Equ:
				{
				alt8=3;
				}
				break;
			case NotEqu:
				{
				alt8=4;
				}
				break;
			case GTEqu:
				{
				alt8=5;
				}
				break;
			case LTEqu:
				{
				alt8=6;
				}
				break;
			case GT:
				{
				alt8=7;
				}
				break;
			case LT:
				{
				alt8=8;
				}
				break;
			case Add:
				{
				alt8=9;
				}
				break;
			case Sub:
				{
				alt8=10;
				}
				break;
			case Mul:
				{
				alt8=11;
				}
				break;
			case Div:
				{
				alt8=12;
				}
				break;
			case UNARY_MINUS:
				{
				alt8=13;
				}
				break;
			case UNARY_NEGATE:
				{
				alt8=14;
				}
				break;
			case Int:
				{
				alt8=15;
				}
				break;
			case Doub:
				{
				alt8=16;
				}
				break;
			case Str:
				{
				alt8=17;
				}
				break;
			case Ident:
				{
				alt8=18;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:7: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression391); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression395);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression401);
					rhs=expression();
					state._fsp--;

					result = new Or(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:98:8: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression415); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression419);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression425);
					rhs=expression();
					state._fsp--;

					result = new And(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:99:8: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression439); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression443);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression449);
					rhs=expression();
					state._fsp--;

					result = new Eq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:100:8: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression463); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression467);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression473);
					rhs=expression();
					state._fsp--;

					result = new NEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:101:8: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression487); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression491);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression497);
					rhs=expression();
					state._fsp--;

					result = new GEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:102:8: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression511); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression515);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression521);
					rhs=expression();
					state._fsp--;

					result = new LEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:103:8: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression535); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression539);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression545);
					rhs=expression();
					state._fsp--;

					result = new GT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:104:8: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression559); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression563);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression569);
					rhs=expression();
					state._fsp--;

					result = new LT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:8: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression583); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression587);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression593);
					rhs=expression();
					state._fsp--;

					result = new Add(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:106:8: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression607); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression611);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression617);
					rhs=expression();
					state._fsp--;

					result = new Sub(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:107:8: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression631); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression635);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression641);
					rhs=expression();
					state._fsp--;

					result = new Mul(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:108:8: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression655); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression659);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression665);
					rhs=expression();
					state._fsp--;

					result = new Div(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:109:8: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression679); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression683);
					ex=expression();
					state._fsp--;

					result = new Neg(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:110:8: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression698); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression702);
					ex=expression();
					state._fsp--;

					result = new Not(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:111:8: Int
					{
					Int13=(CommonTree)match(input,Int,FOLLOW_Int_in_expression715); 
					result = new Int(Integer.parseInt((Int13!=null?Int13.getText():null)));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:112:8: Doub
					{
					Doub14=(CommonTree)match(input,Doub,FOLLOW_Doub_in_expression728); 
					result = new Doub(Double.parseDouble((Doub14!=null?Doub14.getText():null)));
					}
					break;
				case 17 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:113:8: Str
					{
					Str15=(CommonTree)match(input,Str,FOLLOW_Str_in_expression741); 
					result = new Str((Str15!=null?Str15.getText():null));
					}
					break;
				case 18 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:114:8: Ident
					{
					Ident16=(CommonTree)match(input,Ident,FOLLOW_Ident_in_expression753); 
					result = new Ident((Ident16!=null?Ident16.getText():null));
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
		return result;
	}
	// $ANTLR end "expression"

	// Delegated rules



	public static final BitSet FOLLOW_FormId_in_walk62 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_walk68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_walk71 = new BitSet(new long[]{0x0000000008000018L});
	public static final BitSet FOLLOW_questionDeclaration_in_blockItem97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variableDeclaration_in_blockItem104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_questionDeclaration135 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_questionDeclaration138 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_questionDeclaration140 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration144 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_questionDeclaration146 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUESTION_LABEL_in_questionDeclaration150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Str_in_questionDeclaration153 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration167 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_questionDeclaration169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_variableDeclaration202 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_variableDeclaration205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_variableDeclaration207 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration212 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_variableDeclaration214 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration218 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_variableDeclaration221 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_STATEMENT_in_ifBlock250 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IF_CONDITION_in_ifBlock254 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifBlock256 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_BLOCK_TRUE_in_ifBlock261 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock264 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock269 = new BitSet(new long[]{0x0000000008000018L});
	public static final BitSet FOLLOW_IF_BLOCK_FALSE_in_ifBlock282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock285 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock290 = new BitSet(new long[]{0x0000000008000018L});
	public static final BitSet FOLLOW_BooleanType_in_identType331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerType_in_identType348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringType_in_identType356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DoubleType_in_identType364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Or_in_expression391 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression395 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression401 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression415 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression419 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression425 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression439 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression443 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression449 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression463 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression467 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression473 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression487 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression491 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression497 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression511 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression515 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression521 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression535 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression539 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression545 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression559 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression563 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression569 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression583 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression587 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression593 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression607 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression611 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression617 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression631 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression635 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression641 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression655 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression659 = new BitSet(new long[]{0x0001D0D35064C180L});
	public static final BitSet FOLLOW_expression_in_expression665 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression679 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression683 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression698 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression702 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Int_in_expression715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Doub_in_expression728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_expression741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_expression753 = new BitSet(new long[]{0x0000000000000002L});
}
