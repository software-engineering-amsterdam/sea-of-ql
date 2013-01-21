// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 01:03:40

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "FormId", 
		"FormStart", "IF", "IF_BLOCK", "IF_CONDITION", "IF_CONDITION_TRUE", "Ident", 
		"Int", "Lbr", "Money", "QUESTIONNAIRE", "QUESTION_BLOCK", "QUESTION_LABEL", 
		"QUESTION_VAR", "Question", "QuestionVariable", "Rbr", "VALUE_CALC", "VAR_NAME", 
		"VAR_TYPE", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", 
		"'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int IF_BLOCK=9;
	public static final int IF_CONDITION=10;
	public static final int IF_CONDITION_TRUE=11;
	public static final int Ident=12;
	public static final int Int=13;
	public static final int Lbr=14;
	public static final int Money=15;
	public static final int QUESTIONNAIRE=16;
	public static final int QUESTION_BLOCK=17;
	public static final int QUESTION_LABEL=18;
	public static final int QUESTION_VAR=19;
	public static final int Question=20;
	public static final int QuestionVariable=21;
	public static final int Rbr=22;
	public static final int VALUE_CALC=23;
	public static final int VAR_NAME=24;
	public static final int VAR_TYPE=25;
	public static final int WS=26;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "orExpr", "qType", "qStartExp", "ifBlockContentExpr", "qStartQExpr", 
		"andExpr", "relExpr", "unExpr", "parse", "addExpr", "ifStatementExpr", 
		"primary", "qLabel", "mulExpr", "qDeclaration"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public QLParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public QLParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public QLParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return QLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: parse : FormStart qStartExp EOF -> ^( QUESTIONNAIRE qStartExp ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FormStart1=null;
		Token EOF3=null;
		ParserRuleReturnScope qStartExp2 =null;

		CommonTree FormStart1_tree=null;
		CommonTree EOF3_tree=null;
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_qStartExp=new RewriteRuleSubtreeStream(adaptor,"rule qStartExp");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(48, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:2: ( FormStart qStartExp EOF -> ^( QUESTIONNAIRE qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:4: FormStart qStartExp EOF
			{
			dbg.location(49,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse100);  
			stream_FormStart.add(FormStart1);
			dbg.location(49,14);
			pushFollow(FOLLOW_qStartExp_in_parse102);
			qStartExp2=qStartExp();
			state._fsp--;

			stream_qStartExp.add(qStartExp2.getTree());dbg.location(49,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse104);  
			stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: qStartExp
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 49:28: -> ^( QUESTIONNAIRE qStartExp )
			{
				dbg.location(49,31);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:31: ^( QUESTIONNAIRE qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(49,33);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTIONNAIRE, "QUESTIONNAIRE"), root_1);
				dbg.location(49,47);
				adaptor.addChild(root_1, stream_qStartExp.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(49, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class qStartExp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qStartExp"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: qStartExp : FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) ;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FormId4=null;
		Token Lbr5=null;
		Token Rbr7=null;
		ParserRuleReturnScope qStartQExpr6 =null;

		CommonTree FormId4_tree=null;
		CommonTree Lbr5_tree=null;
		CommonTree Rbr7_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qStartQExpr=new RewriteRuleSubtreeStream(adaptor,"rule qStartQExpr");

		try { dbg.enterRule(getGrammarFileName(), "qStartExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(53, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:2: ( FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:4: FormId Lbr qStartQExpr Rbr
			{
			dbg.location(55,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp128);  
			stream_FormId.add(FormId4);
			dbg.location(55,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp130);  
			stream_Lbr.add(Lbr5);
			dbg.location(55,15);
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp132);
			qStartQExpr6=qStartQExpr();
			state._fsp--;

			stream_qStartQExpr.add(qStartQExpr6.getTree());dbg.location(55,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp134);  
			stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: FormId, qStartQExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 55:31: -> ^( FormId qStartQExpr )
			{
				dbg.location(55,33);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:33: ^( FormId qStartQExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(55,35);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(55,42);
				adaptor.addChild(root_1, stream_qStartQExpr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(55, 53);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qStartExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qStartExp"


	public static class qStartQExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qStartQExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: qStartQExpr : ( qDeclaration | ifStatementExpr )* ;
	public final QLParser.qStartQExpr_return qStartQExpr() throws RecognitionException {
		QLParser.qStartQExpr_return retval = new QLParser.qStartQExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration8 =null;
		ParserRuleReturnScope ifStatementExpr9 =null;


		try { dbg.enterRule(getGrammarFileName(), "qStartQExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:2: ( ( qDeclaration | ifStatementExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:4: ( qDeclaration | ifStatementExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(59,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:4: ( qDeclaration | ifStatementExpr )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=3;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==QuestionVariable) ) {
					alt1=1;
				}
				else if ( (LA1_0==IF) ) {
					alt1=2;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: qDeclaration
					{
					dbg.location(59,5);
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr153);
					qDeclaration8=qDeclaration();
					state._fsp--;

					adaptor.addChild(root_0, qDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:20: ifStatementExpr
					{
					dbg.location(59,20);
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr157);
					ifStatementExpr9=ifStatementExpr();
					state._fsp--;

					adaptor.addChild(root_0, ifStatementExpr9.getTree());

					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(59, 36);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qStartQExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qStartQExpr"


	public static class qDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: qDeclaration : ( QuestionVariable ':' qLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL qLabel ) ) | QuestionVariable ':' qLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL qLabel ) ) );
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token QuestionVariable10=null;
		Token char_literal11=null;
		Token QuestionVariable14=null;
		Token char_literal15=null;
		Token char_literal18=null;
		Token char_literal20=null;
		ParserRuleReturnScope qLabel12 =null;
		ParserRuleReturnScope qType13 =null;
		ParserRuleReturnScope qLabel16 =null;
		ParserRuleReturnScope qType17 =null;
		ParserRuleReturnScope orExpr19 =null;

		CommonTree QuestionVariable10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree QuestionVariable14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal20_tree=null;
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleSubtreeStream stream_qLabel=new RewriteRuleSubtreeStream(adaptor,"rule qLabel");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:2: ( QuestionVariable ':' qLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL qLabel ) ) | QuestionVariable ':' qLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL qLabel ) ) )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==QuestionVariable) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==36) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==Question) ) {
						int LA2_3 = input.LA(4);
						if ( (LA2_3==Boolean||LA2_3==Money) ) {
							int LA2_4 = input.LA(5);
							if ( (LA2_4==IF||(LA2_4 >= QuestionVariable && LA2_4 <= Rbr)) ) {
								alt2=1;
							}
							else if ( (LA2_4==30) ) {
								alt2=2;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 2, 4, input);
									dbg.recognitionException(nvae);
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
									new NoViableAltException("", 2, 3, input);
								dbg.recognitionException(nvae);
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
								new NoViableAltException("", 2, 2, input);
							dbg.recognitionException(nvae);
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
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:4: QuestionVariable ':' qLabel qType
					{
					dbg.location(63,4);
					QuestionVariable10=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration170);  
					stream_QuestionVariable.add(QuestionVariable10);
					dbg.location(63,22);
					char_literal11=(Token)match(input,36,FOLLOW_36_in_qDeclaration173);  
					stream_36.add(char_literal11);
					dbg.location(63,26);
					pushFollow(FOLLOW_qLabel_in_qDeclaration175);
					qLabel12=qLabel();
					state._fsp--;

					stream_qLabel.add(qLabel12.getTree());dbg.location(63,33);
					pushFollow(FOLLOW_qType_in_qDeclaration177);
					qType13=qType();
					state._fsp--;

					stream_qType.add(qType13.getTree());
					// AST REWRITE
					// elements: qLabel, QuestionVariable, qType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 63:39: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL qLabel ) )
					{
						dbg.location(63,41);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:41: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL qLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(63,43);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(63,58);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:58: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(63,60);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(63,73);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:73: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(63,75);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(63,84);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(63,102);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:102: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(63,104);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(63,113);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(63,122);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:122: ^( QUESTION_LABEL qLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(63,124);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(63,139);
						adaptor.addChild(root_2, stream_qLabel.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:4: QuestionVariable ':' qLabel qType '(' orExpr ')'
					{
					dbg.location(64,4);
					QuestionVariable14=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration211);  
					stream_QuestionVariable.add(QuestionVariable14);
					dbg.location(64,22);
					char_literal15=(Token)match(input,36,FOLLOW_36_in_qDeclaration214);  
					stream_36.add(char_literal15);
					dbg.location(64,26);
					pushFollow(FOLLOW_qLabel_in_qDeclaration216);
					qLabel16=qLabel();
					state._fsp--;

					stream_qLabel.add(qLabel16.getTree());dbg.location(64,33);
					pushFollow(FOLLOW_qType_in_qDeclaration218);
					qType17=qType();
					state._fsp--;

					stream_qType.add(qType17.getTree());dbg.location(64,39);
					char_literal18=(Token)match(input,30,FOLLOW_30_in_qDeclaration220);  
					stream_30.add(char_literal18);
					dbg.location(64,43);
					pushFollow(FOLLOW_orExpr_in_qDeclaration222);
					orExpr19=orExpr();
					state._fsp--;

					stream_orExpr.add(orExpr19.getTree());dbg.location(64,50);
					char_literal20=(Token)match(input,31,FOLLOW_31_in_qDeclaration224);  
					stream_31.add(char_literal20);

					// AST REWRITE
					// elements: qType, QuestionVariable, orExpr, qLabel
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 64:55: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL qLabel ) )
					{
						dbg.location(64,57);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:57: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL qLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(64,59);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(64,74);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:74: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(64,76);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(64,89);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:89: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(64,91);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(64,100);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(64,118);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:118: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(64,120);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(64,129);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(64,136);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:136: ^( VALUE_CALC orExpr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(64,138);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(64,149);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(64,159);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:159: ^( QUESTION_LABEL qLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(64,161);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(64,176);
						adaptor.addChild(root_2, stream_qLabel.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(64, 184);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qDeclaration"


	public static class ifStatementExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ifStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: ifStatementExpr : IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) ) ;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF21=null;
		Token char_literal22=null;
		Token char_literal24=null;
		Token Lbr25=null;
		Token Rbr27=null;
		ParserRuleReturnScope orExpr23 =null;
		ParserRuleReturnScope ifBlockContentExpr26 =null;

		CommonTree IF21_tree=null;
		CommonTree char_literal22_tree=null;
		CommonTree char_literal24_tree=null;
		CommonTree Lbr25_tree=null;
		CommonTree Rbr27_tree=null;
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_ifBlockContentExpr=new RewriteRuleSubtreeStream(adaptor,"rule ifBlockContentExpr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:2: ( IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr
			{
			dbg.location(72,5);
			IF21=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr277);  
			stream_IF.add(IF21);
			dbg.location(72,9);
			char_literal22=(Token)match(input,30,FOLLOW_30_in_ifStatementExpr280);  
			stream_30.add(char_literal22);
			dbg.location(72,13);
			pushFollow(FOLLOW_orExpr_in_ifStatementExpr282);
			orExpr23=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr23.getTree());dbg.location(72,20);
			char_literal24=(Token)match(input,31,FOLLOW_31_in_ifStatementExpr284);  
			stream_31.add(char_literal24);
			dbg.location(72,26);
			Lbr25=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr288);  
			stream_Lbr.add(Lbr25);
			dbg.location(72,30);
			pushFollow(FOLLOW_ifBlockContentExpr_in_ifStatementExpr290);
			ifBlockContentExpr26=ifBlockContentExpr();
			state._fsp--;

			stream_ifBlockContentExpr.add(ifBlockContentExpr26.getTree());dbg.location(72,49);
			Rbr27=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr292);  
			stream_Rbr.add(Rbr27);

			// AST REWRITE
			// elements: orExpr, ifBlockContentExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 72:53: -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) )
			{
				dbg.location(72,55);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:55: ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(72,57);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(72,66);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:66: ^( IF_CONDITION orExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(72,68);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(72,81);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(72,89);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:89: ^( IF_CONDITION_TRUE ifBlockContentExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(72,91);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_TRUE, "IF_CONDITION_TRUE"), root_2);
				dbg.location(72,109);
				adaptor.addChild(root_2, stream_ifBlockContentExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(72, 128);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatementExpr"


	public static class ifBlockContentExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ifBlockContentExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: ifBlockContentExpr : ( qDeclaration | ifStatementExpr )+ ;
	public final QLParser.ifBlockContentExpr_return ifBlockContentExpr() throws RecognitionException {
		QLParser.ifBlockContentExpr_return retval = new QLParser.ifBlockContentExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration28 =null;
		ParserRuleReturnScope ifStatementExpr29 =null;


		try { dbg.enterRule(getGrammarFileName(), "ifBlockContentExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(78, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:2: ( ( qDeclaration | ifStatementExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:4: ( qDeclaration | ifStatementExpr )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(79,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:4: ( qDeclaration | ifStatementExpr )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=3;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==QuestionVariable) ) {
					alt3=1;
				}
				else if ( (LA3_0==IF) ) {
					alt3=2;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:6: qDeclaration
					{
					dbg.location(79,6);
					pushFollow(FOLLOW_qDeclaration_in_ifBlockContentExpr325);
					qDeclaration28=qDeclaration();
					state._fsp--;

					adaptor.addChild(root_0, qDeclaration28.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:22: ifStatementExpr
					{
					dbg.location(79,22);
					pushFollow(FOLLOW_ifStatementExpr_in_ifBlockContentExpr330);
					ifStatementExpr29=ifStatementExpr();
					state._fsp--;

					adaptor.addChild(root_0, ifStatementExpr29.getTree());

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt3++;
			}
			} finally {dbg.exitSubRule(3);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(79, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifBlockContentExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifBlockContentExpr"


	public static class qLabel_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qLabel"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: qLabel : Question ;
	public final QLParser.qLabel_return qLabel() throws RecognitionException {
		QLParser.qLabel_return retval = new QLParser.qLabel_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Question30=null;

		CommonTree Question30_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qLabel");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(83, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:8: ( Question )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:10: Question
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(83,10);
			Question30=(Token)match(input,Question,FOLLOW_Question_in_qLabel345); 
			Question30_tree = (CommonTree)adaptor.create(Question30);
			adaptor.addChild(root_0, Question30_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(83, 17);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qLabel");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qLabel"


	public static class qType_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set31=null;

		CommonTree set31_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(85, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(86,2);
			set31=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set31));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(86, 19);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qType"


	public static class primary_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "primary"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !);
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Int32=null;
		Token Ident33=null;
		Token Boolean34=null;
		Token QuestionVariable35=null;
		Token Money36=null;
		Token char_literal37=null;
		Token char_literal38=null;
		ParserRuleReturnScope x =null;

		CommonTree Int32_tree=null;
		CommonTree Ident33_tree=null;
		CommonTree Boolean34_tree=null;
		CommonTree QuestionVariable35_tree=null;
		CommonTree Money36_tree=null;
		CommonTree char_literal37_tree=null;
		CommonTree char_literal38_tree=null;
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:3: ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !)
			int alt4=6;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			switch ( input.LA(1) ) {
			case Int:
				{
				alt4=1;
				}
				break;
			case Ident:
				{
				alt4=2;
				}
				break;
			case Boolean:
				{
				alt4=3;
				}
				break;
			case QuestionVariable:
				{
				alt4=4;
				}
				break;
			case Money:
				{
				alt4=5;
				}
				break;
			case 30:
				{
				alt4=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(90,5);
					Int32=(Token)match(input,Int,FOLLOW_Int_in_primary376); 
					Int32_tree = (CommonTree)adaptor.create(Int32);
					adaptor.addChild(root_0, Int32_tree);
					dbg.location(90,11);
					 retval.result = new Int(Integer.parseInt((Int32!=null?Int32.getText():null))); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(91,5);
					Ident33=(Token)match(input,Ident,FOLLOW_Ident_in_primary386); 
					Ident33_tree = (CommonTree)adaptor.create(Ident33);
					adaptor.addChild(root_0, Ident33_tree);
					dbg.location(91,11);
					 retval.result = new Ident((Ident33!=null?Ident33.getText():null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(93,5);
					Boolean34=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary397); 
					Boolean34_tree = (CommonTree)adaptor.create(Boolean34);
					adaptor.addChild(root_0, Boolean34_tree);
					dbg.location(93,13);
					retval.result = new Bool((Boolean34!=null?Boolean34.getText():null));
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: QuestionVariable
					{
					dbg.location(94,5);
					QuestionVariable35=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_primary404);  
					stream_QuestionVariable.add(QuestionVariable35);
					dbg.location(94,23);
					 retval.result = new Ident((QuestionVariable35!=null?QuestionVariable35.getText():null)); 
					// AST REWRITE
					// elements: QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 94:72: -> ^( VAR_NAME QuestionVariable )
					{
						dbg.location(94,75);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:75: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(94,77);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_1);
						dbg.location(94,86);
						adaptor.addChild(root_1, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(95,5);
					Money36=(Token)match(input,Money,FOLLOW_Money_in_primary422); 
					Money36_tree = (CommonTree)adaptor.create(Money36);
					adaptor.addChild(root_0, Money36_tree);
					dbg.location(95,11);
					 retval.result = new Int(Integer.parseInt((Money36!=null?Money36.getText():null)));
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:6: '(' !x= orExpr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(97,9);
					char_literal37=(Token)match(input,30,FOLLOW_30_in_primary434); dbg.location(97,13);
					pushFollow(FOLLOW_orExpr_in_primary440);
					x=orExpr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(97,24);
					char_literal38=(Token)match(input,31,FOLLOW_31_in_primary442); dbg.location(97,26);
					 retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(98, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "primary");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "primary"


	public static class unExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal39=null;
		Token char_literal40=null;
		Token char_literal41=null;
		ParserRuleReturnScope x =null;

		CommonTree char_literal39_tree=null;
		CommonTree char_literal40_tree=null;
		CommonTree char_literal41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(101, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 33:
				{
				alt5=1;
				}
				break;
			case 34:
				{
				alt5=2;
				}
				break;
			case 27:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 30:
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(102,11);
					char_literal39=(Token)match(input,33,FOLLOW_33_in_unExpr471); 
					char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal39_tree, root_0);
					dbg.location(102,14);
					pushFollow(FOLLOW_unExpr_in_unExpr476);
					x=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(102,22);
					 retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(103,11);
					char_literal40=(Token)match(input,34,FOLLOW_34_in_unExpr487); 
					char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal40_tree, root_0);
					dbg.location(103,14);
					pushFollow(FOLLOW_unExpr_in_unExpr492);
					x=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(103,22);
					 retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(104,11);
					char_literal41=(Token)match(input,27,FOLLOW_27_in_unExpr503); 
					char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal41_tree, root_0);
					dbg.location(104,14);
					pushFollow(FOLLOW_unExpr_in_unExpr508);
					x=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(104,22);
					 retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(105,9);
					pushFollow(FOLLOW_primary_in_unExpr521);
					x=primary();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(105,21);
					 retval.result = (x!=null?((QLParser.primary_return)x).result:null); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(106, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "unExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "unExpr"


	public static class mulExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "mulExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(108, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(109,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr559);
			lhs=unExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(109,20);
			 retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); dbg.location(109,45);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==32||LA7_0==35) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(109,49);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:50: ( '*' ^| '/' ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==32) ) {
						alt6=1;
					}
					else if ( (LA6_0==35) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(6);}

					switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:52: '*' ^
							{
							dbg.location(109,55);
							op=(Token)match(input,32,FOLLOW_32_in_mulExpr569); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:59: '/' ^
							{
							dbg.location(109,62);
							op=(Token)match(input,35,FOLLOW_35_in_mulExpr574); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(109,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr581);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(110,5);
					 
					      if ((op!=null?op.getText():null).equals("*")) {
					        retval.result = new Mul(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new Div(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));      
					      }
					    
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(118, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "mulExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "mulExpr"


	public static class addExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(121, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(122,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr622);
			lhs=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(122,21);
			 retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); dbg.location(122,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 33 && LA9_0 <= 34)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(122,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==33) ) {
						alt8=1;
					}
					else if ( (LA8_0==34) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(8);}

					switch (alt8) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:52: '+' ^
							{
							dbg.location(122,55);
							op=(Token)match(input,33,FOLLOW_33_in_addExpr631); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:59: '-' ^
							{
							dbg.location(122,62);
							op=(Token)match(input,34,FOLLOW_34_in_addExpr636); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(122,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr642);
					rhs=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(123,5);
					 
					      if ((op!=null?op.getText():null).equals("+")) {
					        retval.result = new Add(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        retval.result = new Sub(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));      
					      }
					    
					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(131, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "addExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "addExpr"


	public static class relExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "relExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(133, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(134,12);
			pushFollow(FOLLOW_addExpr_in_relExpr677);
			lhs=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(134,21);
			 retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); dbg.location(134,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==28||(LA11_0 >= 37 && LA11_0 <= 41)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(134,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 37:
						{
						alt10=1;
						}
						break;
					case 38:
						{
						alt10=2;
						}
						break;
					case 40:
						{
						alt10=3;
						}
						break;
					case 41:
						{
						alt10=4;
						}
						break;
					case 39:
						{
						alt10=5;
						}
						break;
					case 28:
						{
						alt10=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:52: '<' ^
							{
							dbg.location(134,55);
							op=(Token)match(input,37,FOLLOW_37_in_relExpr686); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:57: '<=' ^
							{
							dbg.location(134,61);
							op=(Token)match(input,38,FOLLOW_38_in_relExpr689); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:63: '>' ^
							{
							dbg.location(134,66);
							op=(Token)match(input,40,FOLLOW_40_in_relExpr692); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:68: '>=' ^
							{
							dbg.location(134,72);
							op=(Token)match(input,41,FOLLOW_41_in_relExpr695); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:75: '==' ^
							{
							dbg.location(134,79);
							op=(Token)match(input,39,FOLLOW_39_in_relExpr699); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:82: '!=' ^
							{
							dbg.location(134,86);
							op=(Token)match(input,28,FOLLOW_28_in_relExpr703); 
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(134,92);
					pushFollow(FOLLOW_addExpr_in_relExpr709);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(135,5);
					 
					      if ((op!=null?op.getText():null).equals("<")) {
					        retval.result = new LT(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new LEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        retval.result = new GT(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        retval.result = new GEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        retval.result = new Eq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        retval.result = new NEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					    
					}
					break;

				default :
					break loop11;
				}
			}
			} finally {dbg.exitSubRule(11);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(155, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "relExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "relExpr"


	public static class andExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal42=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal42_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(157, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(158,12);
			pushFollow(FOLLOW_relExpr_in_andExpr747);
			lhs=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(158,21);
			 retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); dbg.location(158,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==29) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:48: '&&' ^rhs= relExpr
					{
					dbg.location(158,52);
					string_literal42=(Token)match(input,29,FOLLOW_29_in_andExpr753); 
					string_literal42_tree = (CommonTree)adaptor.create(string_literal42);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal42_tree, root_0);
					dbg.location(158,57);
					pushFollow(FOLLOW_relExpr_in_andExpr758);
					rhs=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(158,66);
					 retval.result = new And(retval.result, (rhs!=null?((QLParser.relExpr_return)rhs).result:null)); 
					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(159, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "andExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "andExpr"


	public static class orExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:162:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal43=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(162, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(163,12);
			pushFollow(FOLLOW_andExpr_in_orExpr793);
			lhs=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(163,21);
			 retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); dbg.location(163,48);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==42) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:50: '||' ^rhs= andExpr
					{
					dbg.location(163,54);
					string_literal43=(Token)match(input,42,FOLLOW_42_in_orExpr799); 
					string_literal43_tree = (CommonTree)adaptor.create(string_literal43);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal43_tree, root_0);
					dbg.location(163,59);
					pushFollow(FOLLOW_andExpr_in_orExpr804);
					rhs=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(163,68);
					 retval.result = new Or(retval.result, (rhs!=null?((QLParser.andExpr_return)rhs).result:null)); 
					}
					break;

				default :
					break loop13;
				}
			}
			} finally {dbg.exitSubRule(13);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(164, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "orExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_FormStart_in_parse100 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_parse102 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp128 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp130 = new BitSet(new long[]{0x0000000000600100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp132 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr153 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr157 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration170 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_qDeclaration173 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_qLabel_in_qDeclaration175 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration211 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_qDeclaration214 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_qLabel_in_qDeclaration216 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration218 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_qDeclaration220 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration222 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_qDeclaration224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr277 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_ifStatementExpr280 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatementExpr282 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatementExpr284 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr288 = new BitSet(new long[]{0x0000000000200100L});
	public static final BitSet FOLLOW_ifBlockContentExpr_in_ifStatementExpr290 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_ifBlockContentExpr325 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifBlockContentExpr330 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_Question_in_qLabel345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_primary404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_primary434 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_orExpr_in_primary440 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_primary442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_unExpr471 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_unExpr487 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_unExpr503 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr559 = new BitSet(new long[]{0x0000000900000002L});
	public static final BitSet FOLLOW_32_in_mulExpr569 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_35_in_mulExpr574 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr581 = new BitSet(new long[]{0x0000000900000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr622 = new BitSet(new long[]{0x0000000600000002L});
	public static final BitSet FOLLOW_33_in_addExpr631 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_34_in_addExpr636 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr642 = new BitSet(new long[]{0x0000000600000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr677 = new BitSet(new long[]{0x000003E010000002L});
	public static final BitSet FOLLOW_37_in_relExpr686 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_38_in_relExpr689 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_40_in_relExpr692 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_41_in_relExpr695 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_39_in_relExpr699 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_28_in_relExpr703 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr709 = new BitSet(new long[]{0x000003E010000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr747 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_andExpr753 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr758 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr793 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_orExpr799 = new BitSet(new long[]{0x000000064820B010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr804 = new BitSet(new long[]{0x0000040000000002L});
}
