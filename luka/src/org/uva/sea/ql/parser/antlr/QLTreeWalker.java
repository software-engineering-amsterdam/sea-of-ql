// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-13 02:36:42

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
		  super(nodes); 
		  this.typeEnv = typeEnv;
		    
		  } 



	// $ANTLR start "walk"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:36:1: walk returns [Questionnaire root] : ^(formName= FormId ^( BLOCK ( blockItem )* ) ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		CommonTree formName=null;
		Stat blockItem1 =null;


		Block statBlock = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:2: ( ^(formName= FormId ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:5: ^(formName= FormId ^( BLOCK ( blockItem )* ) )
			{
			formName=(CommonTree)match(input,FormId,FOLLOW_FormId_in_walk62); 
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_walk65); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:31: ( blockItem )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==IF_STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:43:32: blockItem
						{
						pushFollow(FOLLOW_blockItem_in_walk68);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:46:1: blockItem returns [Stat stat] : ( questionDeclaration | variableDeclaration | ifBlock ) ;
	public final Stat blockItem() throws RecognitionException {
		Stat stat = null;


		Stat questionDeclaration2 =null;
		Stat variableDeclaration3 =null;
		Stat ifBlock4 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:2: ( ( questionDeclaration | variableDeclaration | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:3: ( questionDeclaration | variableDeclaration | ifBlock )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:3: ( questionDeclaration | variableDeclaration | ifBlock )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:4: questionDeclaration
					{
					pushFollow(FOLLOW_questionDeclaration_in_blockItem91);
					questionDeclaration2=questionDeclaration();
					state._fsp--;

					stat = questionDeclaration2; 
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:4: variableDeclaration
					{
					pushFollow(FOLLOW_variableDeclaration_in_blockItem98);
					variableDeclaration3=variableDeclaration();
					state._fsp--;

					stat = variableDeclaration3; 
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:49:4: ifBlock
					{
					pushFollow(FOLLOW_ifBlock_in_blockItem106);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:52:1: questionDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) ;
	public final Stat questionDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident5=null;
		CommonTree String6=null;
		Type identType7 =null;
		Expr expression8 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:53:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:53:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_questionDeclaration129); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_questionDeclaration132); 
			match(input, Token.DOWN, null); 
			Ident5=(CommonTree)match(input,Ident,FOLLOW_Ident_in_questionDeclaration134); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration138); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_questionDeclaration140);
			identType7=identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,QUESTION_LABEL,FOLLOW_QUESTION_LABEL_in_questionDeclaration144); 
			match(input, Token.DOWN, null); 
			String6=(CommonTree)match(input,String,FOLLOW_String_in_questionDeclaration147); 
			match(input, Token.UP, null); 

			stat = new AnswerableStat(new Ident((Ident5!=null?Ident5.getText():null)),(String6!=null?String6.getText():null),identType7);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:56:4: ( ^( ASSIGNMENT_EXPRESSION expression ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ASSIGNMENT_EXPRESSION) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:56:5: ^( ASSIGNMENT_EXPRESSION expression )
					{
					match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration161); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_questionDeclaration163);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:62:1: variableDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) ;
	public final Stat variableDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident9=null;
		Expr expression10 =null;
		Type identType11 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:63:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_variableDeclaration195); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration198); 
			match(input, Token.DOWN, null); 
			Ident9=(CommonTree)match(input,Ident,FOLLOW_Ident_in_variableDeclaration200); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration205); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identType_in_variableDeclaration207);
			identType11=identType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration211); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_variableDeclaration214);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:68:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK ( (ifBlockItems= blockItem )* ) ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK ( (elseBlockItems= blockItem )+ ) ) ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		Stat ifBlockItems =null;
		Stat elseBlockItems =null;
		Expr expression12 =null;


		Block ifBl = new Block();
		Block elseBl = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK ( (ifBlockItems= blockItem )* ) ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK ( (elseBlockItems= blockItem )+ ) ) ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK ( (ifBlockItems= blockItem )* ) ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK ( (elseBlockItems= blockItem )+ ) ) ) )? )
			{
			match(input,IF_STATEMENT,FOLLOW_IF_STATEMENT_in_ifBlock242); 
			match(input, Token.DOWN, null); 
			match(input,IF_CONDITION,FOLLOW_IF_CONDITION_in_ifBlock246); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifBlock248);
			expression12=expression();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,IF_BLOCK_TRUE,FOLLOW_IF_BLOCK_TRUE_in_ifBlock253); 
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock256); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:72: ( (ifBlockItems= blockItem )* )
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:73: (ifBlockItems= blockItem )*
				{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:85: (ifBlockItems= blockItem )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ASSIGNMENT||LA4_0==IF_STATEMENT) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:73:85: ifBlockItems= blockItem
						{
						pushFollow(FOLLOW_blockItem_in_ifBlock261);
						ifBlockItems=blockItem();
						state._fsp--;

						}
						break;

					default :
						break loop4;
					}
				}

				ifBl.addStatement(ifBlockItems);
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			stat = new IfThenStat(expression12,ifBl);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:2: ( ^( IF_BLOCK_FALSE ^( BLOCK ( (elseBlockItems= blockItem )+ ) ) ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IF_BLOCK_FALSE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:3: ^( IF_BLOCK_FALSE ^( BLOCK ( (elseBlockItems= blockItem )+ ) ) )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock274); 
					match(input, Token.DOWN, null); 
					match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock277); 
					match(input, Token.DOWN, null); 
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:28: ( (elseBlockItems= blockItem )+ )
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:29: (elseBlockItems= blockItem )+
					{
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:43: (elseBlockItems= blockItem )+
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
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:74:43: elseBlockItems= blockItem
							{
							pushFollow(FOLLOW_blockItem_in_ifBlock282);
							elseBlockItems=blockItem();
							state._fsp--;

							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					elseBl.addStatement(elseBlockItems);
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



	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:78:1: ifStatementBlock returns [Stat\tblock] : ( blockItem )* ;
	public final Stat ifStatementBlock() throws RecognitionException {
		Stat block = null;


		Stat blockItem13 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:2: ( ( blockItem )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:6: ( blockItem )*
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:6: ( blockItem )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ASSIGNMENT||LA7_0==IF_STATEMENT) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:79:6: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock315);
					blockItem13=blockItem();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}

			block = blockItem13;
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:82:1: elseBlock returns [Stat block] : ( blockItem )* ;
	public final Stat elseBlock() throws RecognitionException {
		Stat block = null;


		Stat blockItem14 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:2: ( ( blockItem )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:5: ( blockItem )*
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:5: ( blockItem )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ASSIGNMENT||LA8_0==IF_STATEMENT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:83:5: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_elseBlock334);
					blockItem14=blockItem();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			block = blockItem14;
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



	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:1: identType returns [Type type] : ( BooleanType | MoneyType );
	public final Type identType() throws RecognitionException {
		Type type = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:2: ( BooleanType | MoneyType )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BooleanType) ) {
				alt9=1;
			}
			else if ( (LA9_0==MoneyType) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType354); 
					type = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:88:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType363); 
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:1: expression returns [Expr node] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident );
	public final Expr expression() throws RecognitionException {
		Expr node = null;


		CommonTree Int15=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:92:3: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Int | Ident )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:93:6: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression390); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression394);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression398);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Or(lhs,rhs);
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:94:6: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression409); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression413);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression417);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new And(lhs,rhs);
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:95:6: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression429); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression433);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression437);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Eq(lhs,rhs);
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:6: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression448); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression452);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression456);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new NEq(lhs,rhs);
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:6: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression467); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression471);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression475);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GEq(lhs,rhs);
					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:98:6: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression486); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression490);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression494);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LEq(lhs,rhs);
					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:99:6: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression505); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression509);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression513);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new GT(lhs,rhs);
					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:100:6: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression524); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression528);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression532);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new LT(lhs,rhs);
					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:101:6: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression543); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression547);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression551);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Add(lhs,rhs);
					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:102:6: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression562); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression566);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression570);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Sub(lhs,rhs);
					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:103:6: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression581); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression585);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression589);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Mul(lhs,rhs);
					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:104:6: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression600); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression604);
					lhs=expression();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression608);
					rhs=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Div(lhs,rhs);
					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:6: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression619); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression623);
					ex=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Neg(ex);
					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:106:6: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression634); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression638);
					ex=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					node = new Not(ex);
					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:107:6: Int
					{
					Int15=(CommonTree)match(input,Int,FOLLOW_Int_in_expression648); 
					node = new Int(Integer.parseInt((Int15!=null?Int15.getText():null)));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:108:6: Ident
					{
					match(input,Ident,FOLLOW_Ident_in_expression658); 
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



	public static final BitSet FOLLOW_FormId_in_walk62 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_walk65 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_walk68 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_questionDeclaration_in_blockItem91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variableDeclaration_in_blockItem98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_questionDeclaration129 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_questionDeclaration132 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_questionDeclaration134 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration138 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_questionDeclaration140 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_QUESTION_LABEL_in_questionDeclaration144 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_String_in_questionDeclaration147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration161 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_questionDeclaration163 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_in_variableDeclaration195 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_variableDeclaration198 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Ident_in_variableDeclaration200 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_TYPE_in_variableDeclaration205 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_identType_in_variableDeclaration207 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGNMENT_EXPRESSION_in_variableDeclaration211 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_variableDeclaration214 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_STATEMENT_in_ifBlock242 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IF_CONDITION_in_ifBlock246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifBlock248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_BLOCK_TRUE_in_ifBlock253 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock256 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock261 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_IF_BLOCK_FALSE_in_ifBlock274 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_BLOCK_in_ifBlock277 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_blockItem_in_ifBlock282 = new BitSet(new long[]{0x0000000002000018L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock315 = new BitSet(new long[]{0x0000000002000012L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock334 = new BitSet(new long[]{0x0000000002000012L});
	public static final BitSet FOLLOW_BooleanType_in_identType354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Or_in_expression390 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression394 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression398 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression409 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression413 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression429 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression433 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression437 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression448 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression452 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression456 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression467 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression471 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression475 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression486 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression490 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression494 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression505 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression509 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression513 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression524 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression528 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression532 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression543 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression547 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression562 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression566 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression570 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression581 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression585 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression589 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression600 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression604 = new BitSet(new long[]{0x00001C1A74194180L});
	public static final BitSet FOLLOW_expression_in_expression608 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression619 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression623 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression634 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression638 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Int_in_expression648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_expression658 = new BitSet(new long[]{0x0000000000000002L});
}
