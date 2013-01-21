// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 23:44:16

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "CONST_NAME", 
		"CONST_TYPE", "CONST_TYPE_INT", "CONST_VALUE", "CONST_VAR", "FormId", 
		"FormStart", "IF", "IF_BLOCK", "IF_CONDITION", "IF_CONDITION_FALSE", "IF_CONDITION_TRUE", 
		"Ident", "Int", "Lbr", "Money", "NEG_EXPR", "QUESTION_BLOCK", "QUESTION_LABEL", 
		"QUESTION_VAR", "QuestionLabel", "QuestionVariable", "Rbr", "UNARY_EXPR", 
		"VALUE_CALC", "VAR_NAME", "VAR_TYPE", "WS", "'!'", "'!='", "'&&'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", 
		"'>='", "'else'", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int CONST_NAME=6;
	public static final int CONST_TYPE=7;
	public static final int CONST_TYPE_INT=8;
	public static final int CONST_VALUE=9;
	public static final int CONST_VAR=10;
	public static final int FormId=11;
	public static final int FormStart=12;
	public static final int IF=13;
	public static final int IF_BLOCK=14;
	public static final int IF_CONDITION=15;
	public static final int IF_CONDITION_FALSE=16;
	public static final int IF_CONDITION_TRUE=17;
	public static final int Ident=18;
	public static final int Int=19;
	public static final int Lbr=20;
	public static final int Money=21;
	public static final int NEG_EXPR=22;
	public static final int QUESTION_BLOCK=23;
	public static final int QUESTION_LABEL=24;
	public static final int QUESTION_VAR=25;
	public static final int QuestionLabel=26;
	public static final int QuestionVariable=27;
	public static final int Rbr=28;
	public static final int UNARY_EXPR=29;
	public static final int VALUE_CALC=30;
	public static final int VAR_NAME=31;
	public static final int VAR_TYPE=32;
	public static final int WS=33;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred7_QL", "synpred26_QL", "synpred2_QL", "synpred9_QL", 
		"synpred6_QL", "synpred3_QL", "ifStatementExpr", "synpred1_QL", "synpred5_QL", 
		"constantDeclarationExpr", "synpred15_QL", "synpred11_QL", "synpred22_QL", 
		"orExpr", "qType", "synpred8_QL", "relExpr", "unExpr", "synpred18_QL", 
		"elseStatementExpr", "synpred25_QL", "primary", "synpred4_QL", "mulExpr", 
		"qStartExp", "qBodyItemExpr", "synpred13_QL", "synpred14_QL", "synpred20_QL", 
		"synpred10_QL", "synpred16_QL", "synpred19_QL", "synpred23_QL", "parse", 
		"synpred24_QL", "addExpr", "synpred21_QL", "synpred12_QL", "qDeclaration", 
		"andExpr", "synpred17_QL"
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
		this.state.ruleMemo = new HashMap[41+1];


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
		this.state.ruleMemo = new HashMap[41+1];


		 
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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: parse : FormStart qStartExp EOF -> ^( FormStart qStartExp ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

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
		dbg.location(49, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:2: ( FormStart qStartExp EOF -> ^( FormStart qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:4: FormStart qStartExp EOF
			{
			dbg.location(50,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse122); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(50,14);
			pushFollow(FOLLOW_qStartExp_in_parse124);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartExp.add(qStartExp2.getTree());dbg.location(50,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse126); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: FormStart, qStartExp
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 50:28: -> ^( FormStart qStartExp )
			{
				dbg.location(50,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:31: ^( FormStart qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(50,33);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(50,43);
				adaptor.addChild(root_1, stream_qStartExp.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		dbg.location(50, 52);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: qStartExp : FormId Lbr qBodyItemExpr Rbr -> ^( FormId qBodyItemExpr ) ;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);
		int qStartExp_StartIndex = input.index();

		CommonTree root_0 = null;

		Token FormId4=null;
		Token Lbr5=null;
		Token Rbr7=null;
		ParserRuleReturnScope qBodyItemExpr6 =null;

		CommonTree FormId4_tree=null;
		CommonTree Lbr5_tree=null;
		CommonTree Rbr7_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qBodyItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qBodyItemExpr");

		try { dbg.enterRule(getGrammarFileName(), "qStartExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:2: ( FormId Lbr qBodyItemExpr Rbr -> ^( FormId qBodyItemExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: FormId Lbr qBodyItemExpr Rbr
			{
			dbg.location(56,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp150); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId4);
			dbg.location(56,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp152); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(56,15);
			pushFollow(FOLLOW_qBodyItemExpr_in_qStartExp154);
			qBodyItemExpr6=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr6.getTree());dbg.location(56,29);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp156); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: FormId, qBodyItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 56:33: -> ^( FormId qBodyItemExpr )
			{
				dbg.location(56,35);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:35: ^( FormId qBodyItemExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(56,37);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(56,44);
				adaptor.addChild(root_1, stream_qBodyItemExpr.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, qStartExp_StartIndex); }

		}
		dbg.location(56, 57);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qStartExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qStartExp"


	public static class qDeclaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: qDeclaration : ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) );
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		CommonTree root_0 = null;

		Token QuestionVariable8=null;
		Token char_literal9=null;
		Token QuestionLabel10=null;
		Token QuestionVariable12=null;
		Token char_literal13=null;
		Token QuestionLabel14=null;
		Token char_literal16=null;
		Token char_literal18=null;
		ParserRuleReturnScope qType11 =null;
		ParserRuleReturnScope qType15 =null;
		ParserRuleReturnScope orExpr17 =null;

		CommonTree QuestionVariable8_tree=null;
		CommonTree char_literal9_tree=null;
		CommonTree QuestionLabel10_tree=null;
		CommonTree QuestionVariable12_tree=null;
		CommonTree char_literal13_tree=null;
		CommonTree QuestionLabel14_tree=null;
		CommonTree char_literal16_tree=null;
		CommonTree char_literal18_tree=null;
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(60, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:2: ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) )
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==QuestionVariable) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==43) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==QuestionLabel) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==Boolean||LA1_3==Money) ) {
							int LA1_4 = input.LA(5);
							if ( (LA1_4==EOF||LA1_4==IF||(LA1_4 >= QuestionVariable && LA1_4 <= Rbr)) ) {
								alt1=1;
							}
							else if ( (LA1_4==37) ) {
								alt1=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 1, 4, input);
									dbg.recognitionException(nvae);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 3, input);
								dbg.recognitionException(nvae);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							dbg.recognitionException(nvae);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:4: QuestionVariable ':' QuestionLabel qType
					{
					dbg.location(61,4);
					QuestionVariable8=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration176); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable8);
					dbg.location(61,22);
					char_literal9=(Token)match(input,43,FOLLOW_43_in_qDeclaration179); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_43.add(char_literal9);
					dbg.location(61,26);
					QuestionLabel10=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration181); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel10);
					dbg.location(61,40);
					pushFollow(FOLLOW_qType_in_qDeclaration183);
					qType11=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType11.getTree());
					// AST REWRITE
					// elements: qType, QuestionLabel, QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 61:46: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(61,48);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:48: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(61,50);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(61,65);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:65: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(61,67);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(61,80);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:80: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(61,82);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(61,91);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(61,109);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:109: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(61,111);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(61,120);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(61,129);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:129: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(61,131);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(61,146);
						adaptor.addChild(root_2, stream_QuestionLabel.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: QuestionVariable ':' QuestionLabel qType '(' orExpr ')'
					{
					dbg.location(62,4);
					QuestionVariable12=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration217); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable12);
					dbg.location(62,22);
					char_literal13=(Token)match(input,43,FOLLOW_43_in_qDeclaration220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_43.add(char_literal13);
					dbg.location(62,26);
					QuestionLabel14=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration222); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel14);
					dbg.location(62,40);
					pushFollow(FOLLOW_qType_in_qDeclaration224);
					qType15=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType15.getTree());dbg.location(62,46);
					char_literal16=(Token)match(input,37,FOLLOW_37_in_qDeclaration226); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_37.add(char_literal16);
					dbg.location(62,50);
					pushFollow(FOLLOW_orExpr_in_qDeclaration228);
					orExpr17=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr17.getTree());dbg.location(62,57);
					char_literal18=(Token)match(input,38,FOLLOW_38_in_qDeclaration230); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal18);

					// AST REWRITE
					// elements: QuestionLabel, qType, QuestionVariable, orExpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 62:62: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(62,64);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:64: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(62,66);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(62,81);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:81: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(62,83);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(62,96);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:96: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(62,98);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(62,107);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(62,125);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:125: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(62,127);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(62,136);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(62,143);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:143: ^( VALUE_CALC orExpr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(62,145);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(62,156);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(62,166);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:166: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(62,168);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(62,183);
						adaptor.addChild(root_2, stream_QuestionLabel.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, qDeclaration_StartIndex); }

		}
		dbg.location(62, 198);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: ifStatementExpr : IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qBodyItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? ) ;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);
		int ifStatementExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token IF19=null;
		Token char_literal20=null;
		Token char_literal22=null;
		Token Lbr23=null;
		Token Rbr25=null;
		ParserRuleReturnScope orExpr21 =null;
		ParserRuleReturnScope qBodyItemExpr24 =null;
		ParserRuleReturnScope elseStatementExpr26 =null;

		CommonTree IF19_tree=null;
		CommonTree char_literal20_tree=null;
		CommonTree char_literal22_tree=null;
		CommonTree Lbr23_tree=null;
		CommonTree Rbr25_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_qBodyItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qBodyItemExpr");
		RewriteRuleSubtreeStream stream_elseStatementExpr=new RewriteRuleSubtreeStream(adaptor,"rule elseStatementExpr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: ( IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qBodyItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )?
			{
			dbg.location(67,5);
			IF19=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr279); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF19);
			dbg.location(67,9);
			char_literal20=(Token)match(input,37,FOLLOW_37_in_ifStatementExpr282); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_37.add(char_literal20);
			dbg.location(67,13);
			pushFollow(FOLLOW_orExpr_in_ifStatementExpr284);
			orExpr21=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr21.getTree());dbg.location(67,20);
			char_literal22=(Token)match(input,38,FOLLOW_38_in_ifStatementExpr286); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_38.add(char_literal22);
			dbg.location(67,26);
			Lbr23=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr290); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr23);
			dbg.location(67,30);
			pushFollow(FOLLOW_qBodyItemExpr_in_ifStatementExpr292);
			qBodyItemExpr24=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr24.getTree());dbg.location(67,44);
			Rbr25=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr294); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr25);
			dbg.location(67,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:48: ( elseStatementExpr )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==49) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:48: elseStatementExpr
					{
					dbg.location(67,48);
					pushFollow(FOLLOW_elseStatementExpr_in_ifStatementExpr296);
					elseStatementExpr26=elseStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseStatementExpr.add(elseStatementExpr26.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: elseStatementExpr, orExpr, qBodyItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 67:67: -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qBodyItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? )
			{
				dbg.location(67,69);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:69: ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qBodyItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(67,71);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(67,80);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:80: ^( IF_CONDITION orExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(67,82);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(67,95);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(67,103);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:103: ^( IF_CONDITION_TRUE qBodyItemExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(67,105);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_TRUE, "IF_CONDITION_TRUE"), root_2);
				dbg.location(67,123);
				adaptor.addChild(root_2, stream_qBodyItemExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(67,139);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:139: ( ^( IF_CONDITION_FALSE elseStatementExpr ) )?
				if ( stream_elseStatementExpr.hasNext() ) {
					dbg.location(67,139);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:139: ^( IF_CONDITION_FALSE elseStatementExpr )
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					dbg.location(67,141);
					root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_FALSE, "IF_CONDITION_FALSE"), root_2);
					dbg.location(67,160);
					adaptor.addChild(root_2, stream_elseStatementExpr.nextTree());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_elseStatementExpr.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, ifStatementExpr_StartIndex); }

		}
		dbg.location(67, 179);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatementExpr"


	public static class elseStatementExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elseStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: elseStatementExpr : 'else' Lbr qBodyItemExpr Rbr -> qBodyItemExpr ;
	public final QLParser.elseStatementExpr_return elseStatementExpr() throws RecognitionException {
		QLParser.elseStatementExpr_return retval = new QLParser.elseStatementExpr_return();
		retval.start = input.LT(1);
		int elseStatementExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal27=null;
		Token Lbr28=null;
		Token Rbr30=null;
		ParserRuleReturnScope qBodyItemExpr29 =null;

		CommonTree string_literal27_tree=null;
		CommonTree Lbr28_tree=null;
		CommonTree Rbr30_tree=null;
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qBodyItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qBodyItemExpr");

		try { dbg.enterRule(getGrammarFileName(), "elseStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(69, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:2: ( 'else' Lbr qBodyItemExpr Rbr -> qBodyItemExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:4: 'else' Lbr qBodyItemExpr Rbr
			{
			dbg.location(70,4);
			string_literal27=(Token)match(input,49,FOLLOW_49_in_elseStatementExpr331); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_49.add(string_literal27);
			dbg.location(70,11);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseStatementExpr333); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr28);
			dbg.location(70,15);
			pushFollow(FOLLOW_qBodyItemExpr_in_elseStatementExpr335);
			qBodyItemExpr29=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr29.getTree());dbg.location(70,29);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseStatementExpr337); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr30);

			// AST REWRITE
			// elements: qBodyItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 70:33: -> qBodyItemExpr
			{
				dbg.location(70,36);
				adaptor.addChild(root_0, stream_qBodyItemExpr.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, elseStatementExpr_StartIndex); }

		}
		dbg.location(70, 48);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "elseStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "elseStatementExpr"


	public static class qBodyItemExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qBodyItemExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: qBodyItemExpr : ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+ ;
	public final QLParser.qBodyItemExpr_return qBodyItemExpr() throws RecognitionException {
		QLParser.qBodyItemExpr_return retval = new QLParser.qBodyItemExpr_return();
		retval.start = input.LT(1);
		int qBodyItemExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration31 =null;
		ParserRuleReturnScope ifStatementExpr32 =null;
		ParserRuleReturnScope constantDeclarationExpr33 =null;


		try { dbg.enterRule(getGrammarFileName(), "qBodyItemExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(73,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=4;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==QuestionVariable) ) {
					int LA3_2 = input.LA(2);
					if ( (LA3_2==43) ) {
						int LA3_4 = input.LA(3);
						if ( (LA3_4==QuestionLabel) ) {
							alt3=1;
						}
						else if ( (LA3_4==Int) ) {
							alt3=3;
						}

					}

				}
				else if ( (LA3_0==IF) ) {
					alt3=2;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:6: qDeclaration
					{
					dbg.location(73,6);
					pushFollow(FOLLOW_qDeclaration_in_qBodyItemExpr353);
					qDeclaration31=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration31.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:22: ifStatementExpr
					{
					dbg.location(73,22);
					pushFollow(FOLLOW_ifStatementExpr_in_qBodyItemExpr358);
					ifStatementExpr32=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr32.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:40: constantDeclarationExpr
					{
					dbg.location(73,40);
					pushFollow(FOLLOW_constantDeclarationExpr_in_qBodyItemExpr362);
					constantDeclarationExpr33=constantDeclarationExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constantDeclarationExpr33.getTree());

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(3, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt3++;
			}
			} finally {dbg.exitSubRule(3);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, qBodyItemExpr_StartIndex); }

		}
		dbg.location(73, 65);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qBodyItemExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qBodyItemExpr"


	public static class constantDeclarationExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constantDeclarationExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: constantDeclarationExpr : QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) ;
	public final QLParser.constantDeclarationExpr_return constantDeclarationExpr() throws RecognitionException {
		QLParser.constantDeclarationExpr_return retval = new QLParser.constantDeclarationExpr_return();
		retval.start = input.LT(1);
		int constantDeclarationExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token QuestionVariable34=null;
		Token char_literal35=null;
		Token Int36=null;

		CommonTree QuestionVariable34_tree=null;
		CommonTree char_literal35_tree=null;
		CommonTree Int36_tree=null;
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_Int=new RewriteRuleTokenStream(adaptor,"token Int");

		try { dbg.enterRule(getGrammarFileName(), "constantDeclarationExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:2: ( QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: QuestionVariable ':' Int
			{
			dbg.location(76,4);
			QuestionVariable34=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_constantDeclarationExpr375); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable34);
			dbg.location(76,22);
			char_literal35=(Token)match(input,43,FOLLOW_43_in_constantDeclarationExpr378); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_43.add(char_literal35);
			dbg.location(76,26);
			Int36=(Token)match(input,Int,FOLLOW_Int_in_constantDeclarationExpr380); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Int.add(Int36);

			// AST REWRITE
			// elements: Int, QuestionVariable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 76:30: -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
			{
				dbg.location(76,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:33: ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(76,35);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(76,45);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:45: ^( CONST_NAME QuestionVariable )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(76,47);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_NAME, "CONST_NAME"), root_2);
				dbg.location(76,58);
				adaptor.addChild(root_2, stream_QuestionVariable.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(76,76);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:76: ^( CONST_TYPE CONST_TYPE_INT )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(76,78);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(76,89);
				adaptor.addChild(root_2, (CommonTree)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(76,105);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:105: ^( CONST_VALUE Int )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(76,107);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(76,119);
				adaptor.addChild(root_2, stream_Int.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, constantDeclarationExpr_StartIndex); }

		}
		dbg.location(76, 123);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constantDeclarationExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "constantDeclarationExpr"


	public static class qType_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set37=null;

		CommonTree set37_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(80,2);
			set37=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set37));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, qType_StartIndex); }

		}
		dbg.location(80, 19);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !);
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Int38=null;
		Token Ident39=null;
		Token Boolean40=null;
		Token QuestionVariable41=null;
		Token Money42=null;
		Token char_literal43=null;
		Token char_literal44=null;
		ParserRuleReturnScope x =null;

		CommonTree Int38_tree=null;
		CommonTree Ident39_tree=null;
		CommonTree Boolean40_tree=null;
		CommonTree QuestionVariable41_tree=null;
		CommonTree Money42_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal44_tree=null;
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(83, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:3: ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !)
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
			case 37:
				{
				alt4=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(84,5);
					Int38=(Token)match(input,Int,FOLLOW_Int_in_primary436); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int38_tree = (CommonTree)adaptor.create(Int38);
					adaptor.addChild(root_0, Int38_tree);
					}
					dbg.location(84,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int38!=null?Int38.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(85,5);
					Ident39=(Token)match(input,Ident,FOLLOW_Ident_in_primary446); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident39_tree = (CommonTree)adaptor.create(Ident39);
					adaptor.addChild(root_0, Ident39_tree);
					}
					dbg.location(85,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident39!=null?Ident39.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(86,5);
					Boolean40=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary454); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean40_tree = (CommonTree)adaptor.create(Boolean40);
					adaptor.addChild(root_0, Boolean40_tree);
					}
					dbg.location(86,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean40!=null?Boolean40.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: QuestionVariable
					{
					dbg.location(87,5);
					QuestionVariable41=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_primary462); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable41);
					dbg.location(87,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable41!=null?QuestionVariable41.getText():null)); }
					// AST REWRITE
					// elements: QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 87:72: -> ^( VAR_NAME QuestionVariable )
					{
						dbg.location(87,75);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:75: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(87,77);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_1);
						dbg.location(87,86);
						adaptor.addChild(root_1, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(88,5);
					Money42=(Token)match(input,Money,FOLLOW_Money_in_primary480); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money42_tree = (CommonTree)adaptor.create(Money42);
					adaptor.addChild(root_0, Money42_tree);
					}
					dbg.location(88,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money42!=null?Money42.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:6: '(' !x= orExpr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(89,9);
					char_literal43=(Token)match(input,37,FOLLOW_37_in_primary489); if (state.failed) return retval;dbg.location(89,13);
					pushFollow(FOLLOW_orExpr_in_primary495);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(89,24);
					char_literal44=(Token)match(input,38,FOLLOW_38_in_primary497); if (state.failed) return retval;dbg.location(89,26);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

		}
		dbg.location(90, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal45=null;
		Token char_literal46=null;
		Token char_literal47=null;
		ParserRuleReturnScope x =null;

		CommonTree char_literal45_tree=null;
		CommonTree char_literal46_tree=null;
		CommonTree char_literal47_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(93, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 40:
				{
				alt5=1;
				}
				break;
			case 41:
				{
				alt5=2;
				}
				break;
			case 34:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 37:
				{
				alt5=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(94,11);
					char_literal45=(Token)match(input,40,FOLLOW_40_in_unExpr527); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal45_tree = (CommonTree)adaptor.create(char_literal45);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal45_tree, root_0);
					}
					dbg.location(94,14);
					pushFollow(FOLLOW_unExpr_in_unExpr532);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(94,22);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(95,11);
					char_literal46=(Token)match(input,41,FOLLOW_41_in_unExpr543); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal46_tree = (CommonTree)adaptor.create(char_literal46);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal46_tree, root_0);
					}
					dbg.location(95,14);
					pushFollow(FOLLOW_unExpr_in_unExpr548);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(95,22);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(96,11);
					char_literal47=(Token)match(input,34,FOLLOW_34_in_unExpr559); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal47_tree = (CommonTree)adaptor.create(char_literal47);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal47_tree, root_0);
					}
					dbg.location(96,14);
					pushFollow(FOLLOW_unExpr_in_unExpr564);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(96,22);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(97,9);
					pushFollow(FOLLOW_primary_in_unExpr577);
					x=primary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(97,21);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.primary_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

		}
		dbg.location(98, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);
		int mulExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "mulExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(100, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(101,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr615);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(101,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(101,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==39||LA7_0==42) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(101,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:50: ( '*' ^| '/' ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==39) ) {
						alt6=1;
					}
					else if ( (LA6_0==42) ) {
						alt6=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(6);}

					switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:52: '*' ^
							{
							dbg.location(101,55);
							op=(Token)match(input,39,FOLLOW_39_in_mulExpr625); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:59: '/' ^
							{
							dbg.location(101,62);
							op=(Token)match(input,42,FOLLOW_42_in_mulExpr630); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(101,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr637);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(102,5);
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        retval.result = new Mul(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new Div(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));      
					      }
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

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

		}
		dbg.location(110, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);
		int addExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(113, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(114,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr678);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(114,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(114,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 40 && LA9_0 <= 41)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(114,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==40) ) {
						alt8=1;
					}
					else if ( (LA8_0==41) ) {
						alt8=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(8);}

					switch (alt8) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:52: '+' ^
							{
							dbg.location(114,55);
							op=(Token)match(input,40,FOLLOW_40_in_addExpr687); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:59: '-' ^
							{
							dbg.location(114,62);
							op=(Token)match(input,41,FOLLOW_41_in_addExpr692); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(114,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr698);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(115,5);
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        retval.result = new Add(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        retval.result = new Sub(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));      
					      }
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

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

		}
		dbg.location(123, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);
		int relExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "relExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(125, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(126,12);
			pushFollow(FOLLOW_addExpr_in_relExpr733);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(126,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(126,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==35||(LA11_0 >= 44 && LA11_0 <= 48)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(126,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 44:
						{
						alt10=1;
						}
						break;
					case 45:
						{
						alt10=2;
						}
						break;
					case 47:
						{
						alt10=3;
						}
						break;
					case 48:
						{
						alt10=4;
						}
						break;
					case 46:
						{
						alt10=5;
						}
						break;
					case 35:
						{
						alt10=6;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:52: '<' ^
							{
							dbg.location(126,55);
							op=(Token)match(input,44,FOLLOW_44_in_relExpr742); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:57: '<=' ^
							{
							dbg.location(126,61);
							op=(Token)match(input,45,FOLLOW_45_in_relExpr745); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:63: '>' ^
							{
							dbg.location(126,66);
							op=(Token)match(input,47,FOLLOW_47_in_relExpr748); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:68: '>=' ^
							{
							dbg.location(126,72);
							op=(Token)match(input,48,FOLLOW_48_in_relExpr751); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:75: '==' ^
							{
							dbg.location(126,79);
							op=(Token)match(input,46,FOLLOW_46_in_relExpr755); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:82: '!=' ^
							{
							dbg.location(126,86);
							op=(Token)match(input,35,FOLLOW_35_in_relExpr759); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(126,92);
					pushFollow(FOLLOW_addExpr_in_relExpr765);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(127,5);
					if ( state.backtracking==0 ) { 
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
					}
					break;

				default :
					break loop11;
				}
			}
			} finally {dbg.exitSubRule(11);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

		}
		dbg.location(147, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal48=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal48_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(149, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(150,12);
			pushFollow(FOLLOW_relExpr_in_andExpr803);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(150,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(150,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==36) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:48: '&&' ^rhs= relExpr
					{
					dbg.location(150,52);
					string_literal48=(Token)match(input,36,FOLLOW_36_in_andExpr809); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal48_tree = (CommonTree)adaptor.create(string_literal48);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_0);
					}
					dbg.location(150,57);
					pushFollow(FOLLOW_relExpr_in_andExpr814);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(150,66);
					if ( state.backtracking==0 ) { retval.result = new And(retval.result, (rhs!=null?((QLParser.relExpr_return)rhs).result:null)); }
					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

		}
		dbg.location(151, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:154:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal49=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal49_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(154, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(155,12);
			pushFollow(FOLLOW_andExpr_in_orExpr849);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(155,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(155,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==50) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:50: '||' ^rhs= andExpr
					{
					dbg.location(155,54);
					string_literal49=(Token)match(input,50,FOLLOW_50_in_orExpr855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal49_tree = (CommonTree)adaptor.create(string_literal49);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_0);
					}
					dbg.location(155,59);
					pushFollow(FOLLOW_andExpr_in_orExpr860);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(155,68);
					if ( state.backtracking==0 ) { retval.result = new Or(retval.result, (rhs!=null?((QLParser.andExpr_return)rhs).result:null)); }
					}
					break;

				default :
					break loop13;
				}
			}
			} finally {dbg.exitSubRule(13);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

		}
		dbg.location(156, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse122 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_qStartExp_in_parse124 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp150 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp152 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_qStartExp154 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration176 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_qDeclaration179 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration181 = new BitSet(new long[]{0x0000000000200010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration217 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_qDeclaration220 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration222 = new BitSet(new long[]{0x0000000000200010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration224 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_qDeclaration226 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration228 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_qDeclaration230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr279 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_ifStatementExpr282 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatementExpr284 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_ifStatementExpr286 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr290 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_ifStatementExpr292 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr294 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_elseStatementExpr_in_ifStatementExpr296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_elseStatementExpr331 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_elseStatementExpr333 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_elseStatementExpr335 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_elseStatementExpr337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qBodyItemExpr353 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qBodyItemExpr358 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_constantDeclarationExpr_in_qBodyItemExpr362 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_QuestionVariable_in_constantDeclarationExpr375 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_constantDeclarationExpr378 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_Int_in_constantDeclarationExpr380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_primary462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_primary489 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_primary495 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_primary497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_unExpr527 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_unExpr543 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_unExpr559 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr615 = new BitSet(new long[]{0x0000048000000002L});
	public static final BitSet FOLLOW_39_in_mulExpr625 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_42_in_mulExpr630 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr637 = new BitSet(new long[]{0x0000048000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr678 = new BitSet(new long[]{0x0000030000000002L});
	public static final BitSet FOLLOW_40_in_addExpr687 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_41_in_addExpr692 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr698 = new BitSet(new long[]{0x0000030000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr733 = new BitSet(new long[]{0x0001F00800000002L});
	public static final BitSet FOLLOW_44_in_relExpr742 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_45_in_relExpr745 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_47_in_relExpr748 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_48_in_relExpr751 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_46_in_relExpr755 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_35_in_relExpr759 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr765 = new BitSet(new long[]{0x0001F00800000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr803 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_andExpr809 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr814 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr849 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_50_in_orExpr855 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr860 = new BitSet(new long[]{0x0004000000000002L});
}
