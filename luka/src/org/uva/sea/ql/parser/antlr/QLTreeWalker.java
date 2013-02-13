// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-13 05:17:52

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
		"BooleanType", "COMMENT", "Div", "Else", "Equ", "FormId", "FormStart", 
		"GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", "IF_CONDITION", 
		"IF_STATEMENT", "Ident", "If", "Int", "LT", "LTEqu", "Lbr", "MoneyType", 
		"Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", "Rbr", "RoundLbr", "RoundRbr", 
		"String", "Sub", "UNARY_MINUS", "UNARY_NEGATE", "WS"
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
	public static final int Else=15;
	public static final int Equ=16;
	public static final int FormId=17;
	public static final int FormStart=18;
	public static final int GT=19;
	public static final int GTEqu=20;
	public static final int IDENT=21;
	public static final int IF_BLOCK_FALSE=22;
	public static final int IF_BLOCK_TRUE=23;
	public static final int IF_CONDITION=24;
	public static final int IF_STATEMENT=25;
	public static final int Ident=26;
	public static final int If=27;
	public static final int Int=28;
	public static final int LT=29;
	public static final int LTEqu=30;
	public static final int Lbr=31;
	public static final int MoneyType=32;
	public static final int Mul=33;
	public static final int Not=34;
	public static final int NotEqu=35;
	public static final int Or=36;
	public static final int QUESTION_LABEL=37;
	public static final int Rbr=38;
	public static final int RoundLbr=39;
	public static final int RoundRbr=40;
	public static final int String=41;
	public static final int Sub=42;
	public static final int UNARY_MINUS=43;
	public static final int UNARY_NEGATE=44;
	public static final int WS=45;

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
		 super(nodes,new RecognizerSharedState()); 
		  this.typeEnv = typeEnv;
		  } 
		 



	// $ANTLR start "walk"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:37:1: walk returns [Questionnaire root] : ^(formName= FormId ^( BLOCK ( blockItem )* ) ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		CommonTree formName=null;
		Stat blockItem1 =null;


		Block statBlock = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:44:2: ( ^(formName= FormId ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:44:5: ^(formName= FormId ^( BLOCK ( blockItem )* ) )
			{
			formName=(CommonTree)match(input,FormId,FOLLOW_FormId_in_walk62); 
			System.out.println("Start walking");
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_walk68); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:45:10: ( blockItem )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==IF_STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:45:11: blockItem
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:49:1: blockItem returns [Stat stat] : ( questionDeclaration | variableDeclaration | ifBlock ) ;
	public final Stat blockItem() throws RecognitionException {
		Stat stat = null;


		Stat questionDeclaration2 =null;
		Stat variableDeclaration3 =null;
		Stat ifBlock4 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:50:2: ( ( questionDeclaration | variableDeclaration | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:50:3: ( questionDeclaration | variableDeclaration | ifBlock )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:50:3: ( questionDeclaration | variableDeclaration | ifBlock )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:50:4: questionDeclaration
					{
					pushFollow(FOLLOW_questionDeclaration_in_blockItem97);
					questionDeclaration2=questionDeclaration();
					state._fsp--;

					stat = questionDeclaration2; 
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:51:4: variableDeclaration
					{
					pushFollow(FOLLOW_variableDeclaration_in_blockItem104);
					variableDeclaration3=variableDeclaration();
					state._fsp--;

					stat = variableDeclaration3; 
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:52:4: ifBlock
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:55:1: questionDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) ;
	public final Stat questionDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident5=null;
		CommonTree String6=null;
		Type identType7 =null;
		Expr expression8 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:56:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:56:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? )
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
			String6=(CommonTree)match(input,String,FOLLOW_String_in_questionDeclaration153); 
			match(input, Token.UP, null); 

			stat = new AnswerableStat(new Ident((Ident5!=null?Ident5.getText():null)),(String6!=null?String6.getText():null),identType7);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:59:4: ( ^( ASSIGNMENT_EXPRESSION expression ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ASSIGNMENT_EXPRESSION) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:59:5: ^( ASSIGNMENT_EXPRESSION expression )
					{
					match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration167); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_questionDeclaration169);
					expression8=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					stat = new VisibleComputetStat(new Ident((Ident5!=null?Ident5.getText():null)),(String6!=null?String6.getText():null),expression8,identType7);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:65:1: variableDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) ;
	public final Stat variableDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident9=null;
		Expr expression10 =null;
		Type identType11 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:66:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:66:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_variableDeclaration201); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration204); 
			match(input, Token.DOWN, null); 
			Ident9=(CommonTree)match(input,Ident,FOLLOW_Ident_in_variableDeclaration206); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration211); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_variableDeclaration213);
			identType11=identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration217); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_variableDeclaration220);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:71:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		Stat ifBlockItems =null;
		Stat elseBlockItems =null;
		Expr expression12 =null;


		Block ifBl = new Block();
		Block elseBl = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )? )
			{
			match(input,IF_STATEMENT,FOLLOW_IF_STATEMENT_in_ifBlock248); 
			match(input, Token.DOWN, null); 
			match(input,IF_CONDITION,FOLLOW_IF_CONDITION_in_ifBlock252); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifBlock254);
			expression12=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,IF_BLOCK_TRUE,FOLLOW_IF_BLOCK_TRUE_in_ifBlock259); 
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock262); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:72: (ifBlockItems= blockItem )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ASSIGNMENT||LA4_0==IF_STATEMENT) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:73: ifBlockItems= blockItem
						{
						pushFollow(FOLLOW_blockItem_in_ifBlock267);
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:77:2: ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IF_BLOCK_FALSE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:77:3: ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )+ ) )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock280); 
					match(input, Token.DOWN, null); 
					match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock283); 
					match(input, Token.DOWN, null); 
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:77:28: (elseBlockItems= blockItem )+
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
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:77:29: elseBlockItems= blockItem
							{
							pushFollow(FOLLOW_blockItem_in_ifBlock288);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:89:1: identType returns [Type type] : ( BooleanType | MoneyType );
	public final Type identType() throws RecognitionException {
		Type type = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:90:2: ( BooleanType | MoneyType )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==BooleanType) ) {
				alt7=1;
			}
			else if ( (LA7_0==MoneyType) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:90:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType329); 
					type = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType338); 
					type = new MoneyType();
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:94:1: expression returns [Expr result] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident ) ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		CommonTree Int13=null;
		CommonTree Ident14=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:95:3: ( ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident )
			int alt8=16;
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
			case Ident:
				{
				alt8=16;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:7: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression366); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression370);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression376);
					rhs=expression();
					state._fsp--;

					result = new Or(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:103: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression384); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression388);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression394);
					rhs=expression();
					state._fsp--;

					result = new And(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:201: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression402); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression406);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression412);
					rhs=expression();
					state._fsp--;

					result = new Eq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:298: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression420); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression424);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression430);
					rhs=expression();
					state._fsp--;

					result = new NEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:399: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression438); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression442);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression448);
					rhs=expression();
					state._fsp--;

					result = new GEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:499: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression456); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression460);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression466);
					rhs=expression();
					state._fsp--;

					result = new LEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:599: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression474); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression478);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression484);
					rhs=expression();
					state._fsp--;

					result = new GT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:695: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression492); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression496);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression502);
					rhs=expression();
					state._fsp--;

					result = new LT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:791: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression514);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression520);
					rhs=expression();
					state._fsp--;

					result = new Add(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:889: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression528); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression532);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression538);
					rhs=expression();
					state._fsp--;

					result = new Sub(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:987: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression546); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression550);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression556);
					rhs=expression();
					state._fsp--;

					result = new Mul(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:1085: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression564); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression568);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression574);
					rhs=expression();
					state._fsp--;

					result = new Div(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:1183: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression582); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression586);
					ex=expression();
					state._fsp--;

					result = new Neg(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:1248: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression595); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression599);
					ex=expression();
					state._fsp--;

					result = new Not(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:1313: Int
					{
					Int13=(CommonTree)match(input,Int,FOLLOW_Int_in_expression606); 
					result = new Int(Integer.parseInt((Int13!=null?Int13.getText():null)));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:1370: Ident
					{
					Ident14=(CommonTree)match(input,Ident,FOLLOW_Ident_in_expression613); 
					result = new Ident((Ident14!=null?Ident14.getText():null));
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
	public static final BitSet FOLLOW_blockItem_in_walk71 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_questionDeclaration_in_blockItem97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variableDeclaration_in_blockItem104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_questionDeclaration135 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_questionDeclaration138 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_questionDeclaration140 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration144 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_questionDeclaration146 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUESTION_LABEL_in_questionDeclaration150 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_String_in_questionDeclaration153 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration167 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_questionDeclaration169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_variableDeclaration201 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_variableDeclaration204 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_variableDeclaration206 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration211 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_variableDeclaration213 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_variableDeclaration220 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_STATEMENT_in_ifBlock248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IF_CONDITION_in_ifBlock252 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifBlock254 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_BLOCK_TRUE_in_ifBlock259 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock262 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock267 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_IF_BLOCK_FALSE_in_ifBlock280 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock283 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock288 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_BooleanType_in_identType329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Or_in_expression366 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression370 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression384 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression388 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression402 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression406 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression412 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression420 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression424 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression430 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression438 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression442 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression448 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression456 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression460 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression466 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression474 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression478 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression484 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression492 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression496 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression502 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression514 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression520 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression528 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression532 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression538 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression546 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression550 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression556 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression564 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression568 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression574 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression582 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression586 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression595 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression599 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Int_in_expression606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_expression613 = new BitSet(new long[]{0x0000000000000002L});
}
