// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g 2013-02-19 04:08:27

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
		"IF_CONDITION", "IF_STATEMENT", "Ident", "If", "Int", "IntegerType", "LSquBr", 
		"LT", "LTEqu", "Lbr", "MoneyType", "Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", 
		"RSquBr", "Rbr", "RoundLbr", "RoundRbr", "Str", "StringType", "Sub", "UNARY_MINUS", 
		"UNARY_NEGATE", "WS", "','"
	};
	public static final int EOF=-1;
	public static final int T__51=51;
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
	public static final int LSquBr=31;
	public static final int LT=32;
	public static final int LTEqu=33;
	public static final int Lbr=34;
	public static final int MoneyType=35;
	public static final int Mul=36;
	public static final int Not=37;
	public static final int NotEqu=38;
	public static final int Or=39;
	public static final int QUESTION_LABEL=40;
	public static final int RSquBr=41;
	public static final int Rbr=42;
	public static final int RoundLbr=43;
	public static final int RoundRbr=44;
	public static final int Str=45;
	public static final int StringType=46;
	public static final int Sub=47;
	public static final int UNARY_MINUS=48;
	public static final int UNARY_NEGATE=49;
	public static final int WS=50;

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:33:1: walk returns [Questionnaire root] : ^(formName= Ident ^( BLOCK ( blockItem )* ) ) ;
	public final Questionnaire walk() throws RecognitionException {
		Questionnaire root = null;


		CommonTree formName=null;
		Stat blockItem1 =null;


		Block statBlock = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:40:2: ( ^(formName= Ident ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:40:5: ^(formName= Ident ^( BLOCK ( blockItem )* ) )
			{
			formName=(CommonTree)match(input,Ident,FOLLOW_Ident_in_walk62); 
			System.out.println("Start walking");
			match(input, Token.DOWN, null); 
			match(input,BLOCK,FOLLOW_BLOCK_in_walk68); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:41:10: ( blockItem )*
				loop1:
				while (true) {
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ASSIGNMENT||LA1_0==IF_STATEMENT) ) {
						alt1=1;
					}

					switch (alt1) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:41:11: blockItem
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:45:1: blockItem returns [Stat stat] : ( questionDeclaration | variableDeclaration | ifBlock ) ;
	public final Stat blockItem() throws RecognitionException {
		Stat stat = null;


		Stat questionDeclaration2 =null;
		Stat variableDeclaration3 =null;
		Stat ifBlock4 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:46:2: ( ( questionDeclaration | variableDeclaration | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:46:3: ( questionDeclaration | variableDeclaration | ifBlock )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:46:3: ( questionDeclaration | variableDeclaration | ifBlock )
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
												if ( (LA2_10==LSquBr) ) {
													alt2=1;
												}
												else if ( (LA2_10==UP) ) {
													int LA2_16 = input.LA(11);
													if ( (LA2_16==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_16==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 16, input);
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
												if ( (LA2_11==LSquBr) ) {
													alt2=1;
												}
												else if ( (LA2_11==UP) ) {
													int LA2_16 = input.LA(11);
													if ( (LA2_16==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_16==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 16, input);
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
												if ( (LA2_12==LSquBr) ) {
													alt2=1;
												}
												else if ( (LA2_12==UP) ) {
													int LA2_16 = input.LA(11);
													if ( (LA2_16==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_16==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 16, input);
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
												if ( (LA2_13==LSquBr) ) {
													alt2=1;
												}
												else if ( (LA2_13==UP) ) {
													int LA2_16 = input.LA(11);
													if ( (LA2_16==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_16==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 16, input);
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
												if ( (LA2_14==LSquBr) ) {
													alt2=1;
												}
												else if ( (LA2_14==UP) ) {
													int LA2_16 = input.LA(11);
													if ( (LA2_16==QUESTION_LABEL) ) {
														alt2=1;
													}
													else if ( (LA2_16==ASSIGNMENT_EXPRESSION) ) {
														alt2=2;
													}

													else {
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 2, 16, input);
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:46:4: questionDeclaration
					{
					pushFollow(FOLLOW_questionDeclaration_in_blockItem97);
					questionDeclaration2=questionDeclaration();
					state._fsp--;

					stat = questionDeclaration2; 
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:47:4: variableDeclaration
					{
					pushFollow(FOLLOW_variableDeclaration_in_blockItem104);
					variableDeclaration3=variableDeclaration();
					state._fsp--;

					stat = variableDeclaration3; 
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:48:4: ifBlock
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:51:1: questionDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) ;
	public final Stat questionDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident6=null;
		CommonTree Str7=null;
		TreeRuleReturnScope identArrayType5 =null;
		Expr expression8 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:52:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:52:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION expression ) )? )
			{
			match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_questionDeclaration135); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_questionDeclaration138); 
			match(input, Token.DOWN, null); 
			Ident6=(CommonTree)match(input,Ident,FOLLOW_Ident_in_questionDeclaration140); 
			match(input, Token.UP, null); 

			match(input,ASSIGNMENT_TYPE,FOLLOW_ASSIGNMENT_TYPE_in_questionDeclaration144); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_identArrayType_in_questionDeclaration146);
			identArrayType5=identArrayType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input,QUESTION_LABEL,FOLLOW_QUESTION_LABEL_in_questionDeclaration150); 
			match(input, Token.DOWN, null); 
			Str7=(CommonTree)match(input,Str,FOLLOW_Str_in_questionDeclaration153); 
			match(input, Token.UP, null); 


				if((identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).list:null) != null && !(identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).list:null).isEmpty()){
				List<Value> values = new ArrayList<Value>();
				values.add(new UndefinedValue());
				for(Object o : (identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).list:null)){
				String st = (String)((CommonTree) o).getText().replaceAll("^\"|\"$", "");
					values.add((identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).type:null).getValueForString(st));
				}
				Arr a = new Arr(values,(identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).type:null));
				stat = new SelectableStat(new Ident((Ident6!=null?Ident6.getText():null)),(Str7!=null?Str7.getText():null),(identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).type:null),a);
					
				}else{
				stat = new AnswerableStat(new Ident((Ident6!=null?Ident6.getText():null)),(Str7!=null?Str7.getText():null),(identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).type:null));
				}
				
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:69:4: ( ^( ASSIGNMENT_EXPRESSION expression ) )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ASSIGNMENT_EXPRESSION) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:69:5: ^( ASSIGNMENT_EXPRESSION expression )
					{
					match(input,ASSIGNMENT_EXPRESSION,FOLLOW_ASSIGNMENT_EXPRESSION_in_questionDeclaration167); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_questionDeclaration169);
					expression8=expression();
					state._fsp--;

					match(input, Token.UP, null); 

					stat = new VisibleComputetStat(new Ident((Ident6!=null?Ident6.getText():null)),(Str7!=null?Str7.getText():null),expression8,(identArrayType5!=null?((QLTreeWalker.identArrayType_return)identArrayType5).type:null));
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:75:1: variableDeclaration returns [Stat stat] : ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) ;
	public final Stat variableDeclaration() throws RecognitionException {
		Stat stat = null;


		CommonTree Ident9=null;
		Expr expression10 =null;
		Type identType11 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:2: ( ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:76:4: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION expression ) )
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:81:1: ifBlock returns [Stat stat] : ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? ) ;
	public final Stat ifBlock() throws RecognitionException {
		Stat stat = null;


		Stat ifBlockItems =null;
		Stat elseBlockItems =null;
		Expr expression12 =null;


		Block ifBl = new Block();
		Block elseBl = new Block();

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:2: ( ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:4: ^( IF_STATEMENT ^( IF_CONDITION expression ) ^( IF_BLOCK_TRUE ^( BLOCK (ifBlockItems= blockItem )* ) ) ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )? )
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
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:72: (ifBlockItems= blockItem )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ASSIGNMENT||LA4_0==IF_STATEMENT) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:86:73: ifBlockItems= blockItem
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:2: ( ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) ) )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IF_BLOCK_FALSE) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:3: ^( IF_BLOCK_FALSE ^( BLOCK (elseBlockItems= blockItem )* ) )
					{
					match(input,IF_BLOCK_FALSE,FOLLOW_IF_BLOCK_FALSE_in_ifBlock282); 
					match(input, Token.DOWN, null); 
					match(input,BLOCK,FOLLOW_BLOCK_in_ifBlock285); 
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:28: (elseBlockItems= blockItem )*
						loop5:
						while (true) {
							int alt5=2;
							int LA5_0 = input.LA(1);
							if ( (LA5_0==ASSIGNMENT||LA5_0==IF_STATEMENT) ) {
								alt5=1;
							}

							switch (alt5) {
							case 1 :
								// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:87:29: elseBlockItems= blockItem
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


	public static class identArrayType_return extends TreeRuleReturnScope {
		public Type type;
		public List list;
	};


	// $ANTLR start "identArrayType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:90:1: identArrayType returns [Type type, List list] : ( identType LSquBr arr+= Str ( ',' arr+= Str )* RSquBr |t= identType );
	public final QLTreeWalker.identArrayType_return identArrayType() throws RecognitionException {
		QLTreeWalker.identArrayType_return retval = new QLTreeWalker.identArrayType_return();
		retval.start = input.LT(1);

		CommonTree arr=null;
		List<Object> list_arr=null;
		Type t =null;
		Type identType13 =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:2: ( identType LSquBr arr+= Str ( ',' arr+= Str )* RSquBr |t= identType )
			int alt8=2;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				int LA8_1 = input.LA(2);
				if ( (LA8_1==LSquBr) ) {
					alt8=1;
				}
				else if ( (LA8_1==UP) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case MoneyType:
				{
				int LA8_2 = input.LA(2);
				if ( (LA8_2==LSquBr) ) {
					alt8=1;
				}
				else if ( (LA8_2==UP) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IntegerType:
				{
				int LA8_3 = input.LA(2);
				if ( (LA8_3==LSquBr) ) {
					alt8=1;
				}
				else if ( (LA8_3==UP) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case StringType:
				{
				int LA8_4 = input.LA(2);
				if ( (LA8_4==LSquBr) ) {
					alt8=1;
				}
				else if ( (LA8_4==UP) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DoubleType:
				{
				int LA8_5 = input.LA(2);
				if ( (LA8_5==LSquBr) ) {
					alt8=1;
				}
				else if ( (LA8_5==UP) ) {
					alt8=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:4: identType LSquBr arr+= Str ( ',' arr+= Str )* RSquBr
					{
					pushFollow(FOLLOW_identType_in_identArrayType318);
					identType13=identType();
					state._fsp--;

					match(input,LSquBr,FOLLOW_LSquBr_in_identArrayType320); 
					arr=(CommonTree)match(input,Str,FOLLOW_Str_in_identArrayType324); 
					if (list_arr==null) list_arr=new ArrayList<Object>();
					list_arr.add(arr);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:30: ( ',' arr+= Str )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==51) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:91:31: ',' arr+= Str
							{
							match(input,51,FOLLOW_51_in_identArrayType327); 
							arr=(CommonTree)match(input,Str,FOLLOW_Str_in_identArrayType331); 
							if (list_arr==null) list_arr=new ArrayList<Object>();
							list_arr.add(arr);
							}
							break;

						default :
							break loop7;
						}
					}

					match(input,RSquBr,FOLLOW_RSquBr_in_identArrayType335); 
					retval.type = identType13; retval.list = list_arr;
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:92:4: t= identType
					{
					pushFollow(FOLLOW_identType_in_identArrayType346);
					t=identType();
					state._fsp--;

					retval.type = t;
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
		return retval;
	}
	// $ANTLR end "identArrayType"



	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:95:1: identType returns [Type type] : ( BooleanType | MoneyType | IntegerType | StringType | DoubleType );
	public final Type identType() throws RecognitionException {
		Type type = null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:2: ( BooleanType | MoneyType | IntegerType | StringType | DoubleType )
			int alt9=5;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				alt9=1;
				}
				break;
			case MoneyType:
				{
				alt9=2;
				}
				break;
			case IntegerType:
				{
				alt9=3;
				}
				break;
			case StringType:
				{
				alt9=4;
				}
				break;
			case DoubleType:
				{
				alt9=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:96:5: BooleanType
					{
					match(input,BooleanType,FOLLOW_BooleanType_in_identType367); 
					type = new BoolType();
					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:97:5: MoneyType
					{
					match(input,MoneyType,FOLLOW_MoneyType_in_identType376); 
					type = new MoneyType();
					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:98:4: IntegerType
					{
					match(input,IntegerType,FOLLOW_IntegerType_in_identType384); 
					type = new IntType();
					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:99:4: StringType
					{
					match(input,StringType,FOLLOW_StringType_in_identType392); 
					type = new StringType();
					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:100:4: DoubleType
					{
					match(input,DoubleType,FOLLOW_DoubleType_in_identType400); 
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:103:1: expression returns [Expr result] : ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool ) ;
	public final Expr expression() throws RecognitionException {
		Expr result = null;


		CommonTree Ident14=null;
		CommonTree Int15=null;
		CommonTree Doub16=null;
		CommonTree Str17=null;
		CommonTree Bool18=null;
		Expr lhs =null;
		Expr rhs =null;
		Expr ex =null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:104:3: ( ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:6: ( ^( Or lhs= expression rhs= expression ) | ^( And lhs= expression rhs= expression ) | ^( Equ lhs= expression rhs= expression ) | ^( NotEqu lhs= expression rhs= expression ) | ^( GTEqu lhs= expression rhs= expression ) | ^( LTEqu lhs= expression rhs= expression ) | ^( GT lhs= expression rhs= expression ) | ^( LT lhs= expression rhs= expression ) | ^( Add lhs= expression rhs= expression ) | ^( Sub lhs= expression rhs= expression ) | ^( Mul lhs= expression rhs= expression ) | ^( Div lhs= expression rhs= expression ) | ^( UNARY_MINUS ex= expression ) | ^( UNARY_NEGATE ex= expression ) | Ident | Int | Doub | Str | Bool )
			int alt10=19;
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
			case Ident:
				{
				alt10=15;
				}
				break;
			case Int:
				{
				alt10=16;
				}
				break;
			case Doub:
				{
				alt10=17;
				}
				break;
			case Str:
				{
				alt10=18;
				}
				break;
			case Bool:
				{
				alt10=19;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:105:7: ^( Or lhs= expression rhs= expression )
					{
					match(input,Or,FOLLOW_Or_in_expression427); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression431);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression437);
					rhs=expression();
					state._fsp--;

					result = new Or(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:106:8: ^( And lhs= expression rhs= expression )
					{
					match(input,And,FOLLOW_And_in_expression451); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression455);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression461);
					rhs=expression();
					state._fsp--;

					result = new And(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:107:8: ^( Equ lhs= expression rhs= expression )
					{
					match(input,Equ,FOLLOW_Equ_in_expression475); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression479);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression485);
					rhs=expression();
					state._fsp--;

					result = new Eq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:108:8: ^( NotEqu lhs= expression rhs= expression )
					{
					match(input,NotEqu,FOLLOW_NotEqu_in_expression499); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression503);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression509);
					rhs=expression();
					state._fsp--;

					result = new NEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:109:8: ^( GTEqu lhs= expression rhs= expression )
					{
					match(input,GTEqu,FOLLOW_GTEqu_in_expression523); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression527);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression533);
					rhs=expression();
					state._fsp--;

					result = new GEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:110:8: ^( LTEqu lhs= expression rhs= expression )
					{
					match(input,LTEqu,FOLLOW_LTEqu_in_expression547); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression551);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression557);
					rhs=expression();
					state._fsp--;

					result = new LEq(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 7 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:111:8: ^( GT lhs= expression rhs= expression )
					{
					match(input,GT,FOLLOW_GT_in_expression571); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression575);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression581);
					rhs=expression();
					state._fsp--;

					result = new GT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 8 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:112:8: ^( LT lhs= expression rhs= expression )
					{
					match(input,LT,FOLLOW_LT_in_expression595); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression599);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression605);
					rhs=expression();
					state._fsp--;

					result = new LT(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 9 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:113:8: ^( Add lhs= expression rhs= expression )
					{
					match(input,Add,FOLLOW_Add_in_expression619); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression623);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression629);
					rhs=expression();
					state._fsp--;

					result = new Add(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 10 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:114:8: ^( Sub lhs= expression rhs= expression )
					{
					match(input,Sub,FOLLOW_Sub_in_expression643); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression647);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression653);
					rhs=expression();
					state._fsp--;

					result = new Sub(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 11 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:115:8: ^( Mul lhs= expression rhs= expression )
					{
					match(input,Mul,FOLLOW_Mul_in_expression667); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression671);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression677);
					rhs=expression();
					state._fsp--;

					result = new Mul(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 12 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:116:8: ^( Div lhs= expression rhs= expression )
					{
					match(input,Div,FOLLOW_Div_in_expression691); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression695);
					lhs=expression();
					state._fsp--;

					result = lhs;
					pushFollow(FOLLOW_expression_in_expression701);
					rhs=expression();
					state._fsp--;

					result = new Div(result,rhs);
					match(input, Token.UP, null); 

					}
					break;
				case 13 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:117:8: ^( UNARY_MINUS ex= expression )
					{
					match(input,UNARY_MINUS,FOLLOW_UNARY_MINUS_in_expression715); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression719);
					ex=expression();
					state._fsp--;

					result = new Neg(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 14 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:118:8: ^( UNARY_NEGATE ex= expression )
					{
					match(input,UNARY_NEGATE,FOLLOW_UNARY_NEGATE_in_expression734); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression738);
					ex=expression();
					state._fsp--;

					result = new Not(ex);
					match(input, Token.UP, null); 

					}
					break;
				case 15 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:119:8: Ident
					{
					Ident14=(CommonTree)match(input,Ident,FOLLOW_Ident_in_expression751); 
					result = new Ident((Ident14!=null?Ident14.getText():null));
					}
					break;
				case 16 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:120:8: Int
					{
					Int15=(CommonTree)match(input,Int,FOLLOW_Int_in_expression762); 
					result = new Int(Integer.parseInt((Int15!=null?Int15.getText():null)));
					}
					break;
				case 17 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:121:8: Doub
					{
					Doub16=(CommonTree)match(input,Doub,FOLLOW_Doub_in_expression775); 
					result = new Doub(Double.parseDouble((Doub16!=null?Doub16.getText():null)));
					}
					break;
				case 18 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:122:8: Str
					{
					Str17=(CommonTree)match(input,Str,FOLLOW_Str_in_expression788); 
					result = new Str((Str17!=null?Str17.getText():null));
					}
					break;
				case 19 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QLTreeWalker.g:123:8: Bool
					{
					Bool18=(CommonTree)match(input,Bool,FOLLOW_Bool_in_expression800); 
					result = new Bool(Boolean.valueOf((Bool18!=null?Bool18.getText():null)));
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
	public static final BitSet FOLLOW_identArrayType_in_questionDeclaration146 = new BitSet(new long[]{0x0000000000000008L});
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
	public static final BitSet FOLLOW_identType_in_identArrayType318 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LSquBr_in_identArrayType320 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_Str_in_identArrayType324 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_identArrayType327 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_Str_in_identArrayType331 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_RSquBr_in_identArrayType335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identType_in_identArrayType346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerType_in_identType384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringType_in_identType392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DoubleType_in_identType400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Or_in_expression427 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression431 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression437 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_And_in_expression451 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression455 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression461 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Equ_in_expression475 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression479 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression485 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NotEqu_in_expression499 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression503 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression509 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GTEqu_in_expression523 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression527 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression533 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LTEqu_in_expression547 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression551 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression557 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression571 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression575 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression581 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression595 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression599 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression605 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Add_in_expression619 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression623 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression629 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sub_in_expression643 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression647 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression653 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Mul_in_expression667 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression671 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression677 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Div_in_expression691 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression695 = new BitSet(new long[]{0x0003A0D32834C980L});
	public static final BitSet FOLLOW_expression_in_expression701 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_MINUS_in_expression715 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression719 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_NEGATE_in_expression734 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression738 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Ident_in_expression751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_expression762 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Doub_in_expression775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_expression788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_expression800 = new BitSet(new long[]{0x0000000000000002L});
}
