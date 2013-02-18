// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-18 23:53:40

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
		"FormStart", "GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", 
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
	public static final int FormStart=19;
	public static final int GT=20;
	public static final int GTEqu=21;
	public static final int IDENT=22;
	public static final int IF_BLOCK_FALSE=23;
	public static final int IF_BLOCK_TRUE=24;
	public static final int IF_CONDITION=25;
	public static final int IF_STATEMENT=26;
	public static final int Ident=27;
	public static final int If=28;
	public static final int Int=29;
	public static final int IntegerType=30;
	public static final int LT=31;
	public static final int LTEqu=32;
	public static final int Lbr=33;
	public static final int MoneyType=34;
	public static final int Mul=35;
	public static final int Not=36;
	public static final int NotEqu=37;
	public static final int Or=38;
	public static final int QUESTION_LABEL=39;
	public static final int Rbr=40;
	public static final int RoundLbr=41;
	public static final int RoundRbr=42;
	public static final int Str=43;
	public static final int StringType=44;
	public static final int Sub=45;
	public static final int UNARY_MINUS=46;
	public static final int UNARY_NEGATE=47;
	public static final int WS=48;

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:35:1: walk returns [Questionnaire root] : ^(formName= Ident ^( BLOCK ( blockItem )* ) ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		CommonTree formName=null;
		Stat blockItem1 =null;


		Block statBlock = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:2: ( ^(formName= Ident ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:42:5: ^(formName= Ident ^( BLOCK ( blockItem )* ) )
			{
			formName=(CommonTree)match(input,Ident,FOLLOW_Ident_in_walk62); 
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

			System.out.println("finished with walking");
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:69:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		Stat ifBlockItems =null;
		Stat elseBlockItems =null;
		Expr expression12 =null;


		Block ifBl = new Block();
		Block elseBl = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? )
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:2: ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IF_BLOCK_FALSE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:3: ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock282); 
					match(input, Token.DOWN, null); 
					match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock285); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:28: (elseBlockItems= blockItem )*
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
								break loop5;
							}
						}

						match(input, Token.UP, null); 
					}

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:1: identType returns [Type type] : ( BooleanType | MoneyType | IntegerType | StringType | DoubleType );
	public final Type identType() throws RecognitionException {
		Type type = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:80:2: ( BooleanType | MoneyType | IntegerType | StringType | DoubleType )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:80:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType322); 
					type = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:81:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType331); 
					type = new MoneyType();
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:82:4: IntegerType
					{
					match(input,IntegerType,FOLLOW_IntegerType_in_identType339); 
					type = new IntType();
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:4: StringType
					{
					match(input,StringType,FOLLOW_StringType_in_identType347); 
					type = new StringType();
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:84:4: DoubleType
					{
					match(input,DoubleType,FOLLOW_DoubleType_in_identType355); 
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:1: expression returns [Expr result] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool ) ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		CommonTree Ident13=null;
		CommonTree Int14=null;
		CommonTree Doub15=null;
		CommonTree Str16=null;
		CommonTree Bool17=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:88:3: ( ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:89:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:89:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool )
			int alt8=19;
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
			case Ident:
				{
				alt8=15;
				}
				break;
			case Int:
				{
				alt8=16;
				}
				break;
			case Doub:
				{
				alt8=17;
				}
				break;
			case Str:
				{
				alt8=18;
				}
				break;
			case Bool:
				{
				alt8=19;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:89:7: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression382); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression386);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression392);
					rhs=expression();
					state._fsp--;

					result = new Or(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:90:8: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression406); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression410);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression416);
					rhs=expression();
					state._fsp--;

					result = new And(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:8: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression430); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression434);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression440);
					rhs=expression();
					state._fsp--;

					result = new Eq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:92:8: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression454); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression458);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression464);
					rhs=expression();
					state._fsp--;

					result = new NEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:93:8: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression478); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression482);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression488);
					rhs=expression();
					state._fsp--;

					result = new GEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:94:8: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression502); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression506);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression512);
					rhs=expression();
					state._fsp--;

					result = new LEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:95:8: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression526); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression530);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression536);
					rhs=expression();
					state._fsp--;

					result = new GT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:8: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression550); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression554);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression560);
					rhs=expression();
					state._fsp--;

					result = new LT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:8: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression574); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression578);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression584);
					rhs=expression();
					state._fsp--;

					result = new Add(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:98:8: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression598); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression602);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression608);
					rhs=expression();
					state._fsp--;

					result = new Sub(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:99:8: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression622); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression626);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression632);
					rhs=expression();
					state._fsp--;

					result = new Mul(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:100:8: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression646); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression650);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression656);
					rhs=expression();
					state._fsp--;

					result = new Div(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:101:8: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression670); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression674);
					ex=expression();
					state._fsp--;

					result = new Neg(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:102:8: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression689); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression693);
					ex=expression();
					state._fsp--;

					result = new Not(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:103:8: Ident
					{
					Ident13=(CommonTree)match(input,Ident,FOLLOW_Ident_in_expression706); 
					result = new Ident((Ident13!=null?Ident13.getText():null));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:104:8: Int
					{
					Int14=(CommonTree)match(input,Int,FOLLOW_Int_in_expression717); 
					result = new Int(Integer.parseInt((Int14!=null?Int14.getText():null)));
					}
					break;
				case 17 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:8: Doub
					{
					Doub15=(CommonTree)match(input,Doub,FOLLOW_Doub_in_expression730); 
					result = new Doub(Double.parseDouble((Doub15!=null?Doub15.getText():null)));
					}
					break;
				case 18 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:106:8: Str
					{
					Str16=(CommonTree)match(input,Str,FOLLOW_Str_in_expression743); 
					result = new Str((Str16!=null?Str16.getText():null));
					}
					break;
				case 19 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:107:8: Bool
					{
					Bool17=(CommonTree)match(input,Bool,FOLLOW_Bool_in_expression755); 
					result = new Bool(Boolean.valueOf((Bool17!=null?Bool17.getText():null)));
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



	public static final BitSet FOLLOW_Ident_in_walk62 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_walk68 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_walk71 = new BitSet(new long[]{0x0000000004000018L});
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
	public static final BitSet FOLLOW_blockItem_in_ifBlock269 = new BitSet(new long[]{0x0000000004000018L});
	public static final BitSet FOLLOW_IF_BLOCK_FALSE_in_ifBlock282 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock285 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock290 = new BitSet(new long[]{0x0000000004000018L});
	public static final BitSet FOLLOW_BooleanType_in_identType322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerType_in_identType339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringType_in_identType347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DoubleType_in_identType355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Or_in_expression382 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression386 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression392 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression406 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression410 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression416 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression430 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression434 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression440 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression454 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression458 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression464 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression478 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression482 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression488 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression502 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression506 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression512 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression526 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression530 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression536 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression550 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression554 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression560 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression574 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression578 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression584 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression598 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression602 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression608 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression622 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression626 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression632 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression646 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression650 = new BitSet(new long[]{0x0000E869A834C980L});
	public static final BitSet FOLLOW_expression_in_expression656 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression670 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression674 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression689 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression693 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Ident_in_expression706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_expression717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Doub_in_expression730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_expression743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_expression755 = new BitSet(new long[]{0x0000000000000002L});
}
