// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 22:55:05

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "FormId", 
		"FormStart", "IF", "IF_BLOCK", "IF_CONDITION", "IF_CONDITION_FALSE", "IF_CONDITION_TRUE", 
		"Ident", "Int", "Lbr", "Money", "NEG_EXPR", "QUESTION_BLOCK", "QUESTION_LABEL", 
		"QUESTION_VAR", "QuestionLabel", "QuestionVariable", "Rbr", "UNARY_EXPR", 
		"VALUE_CALC", "VAR_NAME", "VAR_TYPE", "WS", "'!'", "'!='", "'&&'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", 
		"'>='", "'else'", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int IF_BLOCK=9;
	public static final int IF_CONDITION=10;
	public static final int IF_CONDITION_FALSE=11;
	public static final int IF_CONDITION_TRUE=12;
	public static final int Ident=13;
	public static final int Int=14;
	public static final int Lbr=15;
	public static final int Money=16;
	public static final int NEG_EXPR=17;
	public static final int QUESTION_BLOCK=18;
	public static final int QUESTION_LABEL=19;
	public static final int QUESTION_VAR=20;
	public static final int QuestionLabel=21;
	public static final int QuestionVariable=22;
	public static final int Rbr=23;
	public static final int UNARY_EXPR=24;
	public static final int VALUE_CALC=25;
	public static final int VAR_NAME=26;
	public static final int VAR_TYPE=27;
	public static final int WS=28;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred13_QL", "primary", "synpred14_QL", "synpred5_QL", 
		"synpred15_QL", "synpred6_QL", "synpred24_QL", "synpred23_QL", "synpred16_QL", 
		"synpred18_QL", "synpred26_QL", "synpred25_QL", "qStartExp", "synpred9_QL", 
		"ifStatementExpr", "synpred3_QL", "qContentItemExpr", "synpred2_QL", "synpred10_QL", 
		"synpred1_QL", "addExpr", "andExpr", "parse", "orExpr", "synpred21_QL", 
		"synpred11_QL", "synpred8_QL", "synpred12_QL", "synpred17_QL", "relExpr", 
		"synpred19_QL", "synpred7_QL", "unExpr", "mulExpr", "elseStatementExpr", 
		"qDeclaration", "synpred20_QL", "synpred22_QL", "synpred4_QL", "qType"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, true, false, false, false, false, false, false, false, 
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
		this.state.ruleMemo = new HashMap[40+1];


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
		this.state.ruleMemo = new HashMap[40+1];


		 
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: parse : FormStart qStartExp EOF -> ^( FormStart qStartExp ) ;
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
		dbg.location(43, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:44:2: ( FormStart qStartExp EOF -> ^( FormStart qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: FormStart qStartExp EOF
			{
			dbg.location(44,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse106); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(44,14);
			pushFollow(FOLLOW_qStartExp_in_parse108);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartExp.add(qStartExp2.getTree());dbg.location(44,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse110); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: qStartExp, FormStart
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 44:28: -> ^( FormStart qStartExp )
			{
				dbg.location(44,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:44:31: ^( FormStart qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(44,33);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(44,43);
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
		dbg.location(44, 52);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: qStartExp : FormId Lbr qContentItemExpr Rbr -> ^( FormId qContentItemExpr ) ;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);
		int qStartExp_StartIndex = input.index();

		CommonTree root_0 = null;

		Token FormId4=null;
		Token Lbr5=null;
		Token Rbr7=null;
		ParserRuleReturnScope qContentItemExpr6 =null;

		CommonTree FormId4_tree=null;
		CommonTree Lbr5_tree=null;
		CommonTree Rbr7_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qContentItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qContentItemExpr");

		try { dbg.enterRule(getGrammarFileName(), "qStartExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(48, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:2: ( FormId Lbr qContentItemExpr Rbr -> ^( FormId qContentItemExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:4: FormId Lbr qContentItemExpr Rbr
			{
			dbg.location(50,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp134); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId4);
			dbg.location(50,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp136); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(50,15);
			pushFollow(FOLLOW_qContentItemExpr_in_qStartExp138);
			qContentItemExpr6=qContentItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentItemExpr.add(qContentItemExpr6.getTree());dbg.location(50,32);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: FormId, qContentItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 50:36: -> ^( FormId qContentItemExpr )
			{
				dbg.location(50,38);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:50:38: ^( FormId qContentItemExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(50,40);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(50,47);
				adaptor.addChild(root_1, stream_qContentItemExpr.nextTree());
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
		dbg.location(50, 63);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: qDeclaration : ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) );
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
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:2: ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) )
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==QuestionVariable) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==38) ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2==QuestionLabel) ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3==Boolean||LA1_3==Money) ) {
							int LA1_4 = input.LA(5);
							if ( (LA1_4==EOF||LA1_4==IF||(LA1_4 >= QuestionVariable && LA1_4 <= Rbr)) ) {
								alt1=1;
							}
							else if ( (LA1_4==32) ) {
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:4: QuestionVariable ':' QuestionLabel qType
					{
					dbg.location(55,4);
					QuestionVariable8=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration160); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable8);
					dbg.location(55,22);
					char_literal9=(Token)match(input,38,FOLLOW_38_in_qDeclaration163); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal9);
					dbg.location(55,26);
					QuestionLabel10=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration165); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel10);
					dbg.location(55,40);
					pushFollow(FOLLOW_qType_in_qDeclaration167);
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
					// 55:46: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(55,48);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:48: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(55,50);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(55,65);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:65: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(55,67);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(55,80);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:80: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(55,82);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(55,91);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(55,109);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:109: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(55,111);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(55,120);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(55,129);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:129: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(55,131);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(55,146);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: QuestionVariable ':' QuestionLabel qType '(' orExpr ')'
					{
					dbg.location(56,4);
					QuestionVariable12=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration201); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable12);
					dbg.location(56,22);
					char_literal13=(Token)match(input,38,FOLLOW_38_in_qDeclaration204); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal13);
					dbg.location(56,26);
					QuestionLabel14=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration206); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel14);
					dbg.location(56,40);
					pushFollow(FOLLOW_qType_in_qDeclaration208);
					qType15=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType15.getTree());dbg.location(56,46);
					char_literal16=(Token)match(input,32,FOLLOW_32_in_qDeclaration210); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_32.add(char_literal16);
					dbg.location(56,50);
					pushFollow(FOLLOW_orExpr_in_qDeclaration212);
					orExpr17=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr17.getTree());dbg.location(56,57);
					char_literal18=(Token)match(input,33,FOLLOW_33_in_qDeclaration214); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_33.add(char_literal18);

					// AST REWRITE
					// elements: qType, orExpr, QuestionLabel, QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 56:62: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(56,64);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:64: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(56,66);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(56,81);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:81: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(56,83);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(56,96);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:96: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(56,98);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(56,107);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(56,125);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:125: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(56,127);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(56,136);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(56,143);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:143: ^( VALUE_CALC orExpr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(56,145);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(56,156);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(56,166);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:166: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(56,168);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(56,183);
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
		dbg.location(56, 198);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: ifStatementExpr : IF '(' orExpr ')' Lbr qContentItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qContentItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? ) ;
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
		ParserRuleReturnScope qContentItemExpr24 =null;
		ParserRuleReturnScope elseStatementExpr26 =null;

		CommonTree IF19_tree=null;
		CommonTree char_literal20_tree=null;
		CommonTree char_literal22_tree=null;
		CommonTree Lbr23_tree=null;
		CommonTree Rbr25_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_qContentItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qContentItemExpr");
		RewriteRuleSubtreeStream stream_elseStatementExpr=new RewriteRuleSubtreeStream(adaptor,"rule elseStatementExpr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(60, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:2: ( IF '(' orExpr ')' Lbr qContentItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qContentItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: IF '(' orExpr ')' Lbr qContentItemExpr Rbr ( elseStatementExpr )?
			{
			dbg.location(61,5);
			IF19=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr263); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF19);
			dbg.location(61,9);
			char_literal20=(Token)match(input,32,FOLLOW_32_in_ifStatementExpr266); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_32.add(char_literal20);
			dbg.location(61,13);
			pushFollow(FOLLOW_orExpr_in_ifStatementExpr268);
			orExpr21=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr21.getTree());dbg.location(61,20);
			char_literal22=(Token)match(input,33,FOLLOW_33_in_ifStatementExpr270); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_33.add(char_literal22);
			dbg.location(61,26);
			Lbr23=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr274); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr23);
			dbg.location(61,30);
			pushFollow(FOLLOW_qContentItemExpr_in_ifStatementExpr276);
			qContentItemExpr24=qContentItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentItemExpr.add(qContentItemExpr24.getTree());dbg.location(61,47);
			Rbr25=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr278); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr25);
			dbg.location(61,51);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:51: ( elseStatementExpr )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==44) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:51: elseStatementExpr
					{
					dbg.location(61,51);
					pushFollow(FOLLOW_elseStatementExpr_in_ifStatementExpr280);
					elseStatementExpr26=elseStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseStatementExpr.add(elseStatementExpr26.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: elseStatementExpr, orExpr, qContentItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 61:70: -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qContentItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? )
			{
				dbg.location(61,72);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:72: ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE qContentItemExpr ) ( ^( IF_CONDITION_FALSE elseStatementExpr ) )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(61,74);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(61,83);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:83: ^( IF_CONDITION orExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(61,85);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(61,98);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(61,106);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:106: ^( IF_CONDITION_TRUE qContentItemExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(61,108);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_TRUE, "IF_CONDITION_TRUE"), root_2);
				dbg.location(61,126);
				adaptor.addChild(root_2, stream_qContentItemExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(61,145);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:145: ( ^( IF_CONDITION_FALSE elseStatementExpr ) )?
				if ( stream_elseStatementExpr.hasNext() ) {
					dbg.location(61,145);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:145: ^( IF_CONDITION_FALSE elseStatementExpr )
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					dbg.location(61,147);
					root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_FALSE, "IF_CONDITION_FALSE"), root_2);
					dbg.location(61,166);
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
		dbg.location(61, 185);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: elseStatementExpr : 'else' Lbr ( qContentItemExpr )* Rbr -> qContentItemExpr ;
	public final QLParser.elseStatementExpr_return elseStatementExpr() throws RecognitionException {
		QLParser.elseStatementExpr_return retval = new QLParser.elseStatementExpr_return();
		retval.start = input.LT(1);
		int elseStatementExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal27=null;
		Token Lbr28=null;
		Token Rbr30=null;
		ParserRuleReturnScope qContentItemExpr29 =null;

		CommonTree string_literal27_tree=null;
		CommonTree Lbr28_tree=null;
		CommonTree Rbr30_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qContentItemExpr=new RewriteRuleSubtreeStream(adaptor,"rule qContentItemExpr");

		try { dbg.enterRule(getGrammarFileName(), "elseStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(63, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:2: ( 'else' Lbr ( qContentItemExpr )* Rbr -> qContentItemExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:4: 'else' Lbr ( qContentItemExpr )* Rbr
			{
			dbg.location(64,4);
			string_literal27=(Token)match(input,44,FOLLOW_44_in_elseStatementExpr315); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_44.add(string_literal27);
			dbg.location(64,11);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseStatementExpr317); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr28);
			dbg.location(64,15);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:15: ( qContentItemExpr )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==IF||LA3_0==QuestionVariable) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:15: qContentItemExpr
					{
					dbg.location(64,15);
					pushFollow(FOLLOW_qContentItemExpr_in_elseStatementExpr319);
					qContentItemExpr29=qContentItemExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qContentItemExpr.add(qContentItemExpr29.getTree());
					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(64,33);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseStatementExpr322); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr30);

			// AST REWRITE
			// elements: qContentItemExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 64:37: -> qContentItemExpr
			{
				dbg.location(64,40);
				adaptor.addChild(root_0, stream_qContentItemExpr.nextTree());
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
		dbg.location(64, 55);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "elseStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "elseStatementExpr"


	public static class qContentItemExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qContentItemExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: qContentItemExpr : ( qDeclaration | ifStatementExpr )+ ;
	public final QLParser.qContentItemExpr_return qContentItemExpr() throws RecognitionException {
		QLParser.qContentItemExpr_return retval = new QLParser.qContentItemExpr_return();
		retval.start = input.LT(1);
		int qContentItemExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration31 =null;
		ParserRuleReturnScope ifStatementExpr32 =null;


		try { dbg.enterRule(getGrammarFileName(), "qContentItemExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: ( ( qDeclaration | ifStatementExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: ( qDeclaration | ifStatementExpr )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(67,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: ( qDeclaration | ifStatementExpr )+
			int cnt4=0;
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=3;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==QuestionVariable) ) {
					int LA4_2 = input.LA(2);
					if ( (synpred4_QL()) ) {
						alt4=1;
					}

				}
				else if ( (LA4_0==IF) ) {
					int LA4_3 = input.LA(2);
					if ( (synpred5_QL()) ) {
						alt4=2;
					}

				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: qDeclaration
					{
					dbg.location(67,6);
					pushFollow(FOLLOW_qDeclaration_in_qContentItemExpr338);
					qDeclaration31=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration31.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:22: ifStatementExpr
					{
					dbg.location(67,22);
					pushFollow(FOLLOW_ifStatementExpr_in_qContentItemExpr343);
					ifStatementExpr32=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr32.getTree());

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(4, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt4++;
			}
			} finally {dbg.exitSubRule(4);}

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
			if ( state.backtracking>0 ) { memoize(input, 6, qContentItemExpr_StartIndex); }

		}
		dbg.location(67, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qContentItemExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qContentItemExpr"


	public static class qType_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set33=null;

		CommonTree set33_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(73,2);
			set33=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set33));
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
			if ( state.backtracking>0 ) { memoize(input, 7, qType_StartIndex); }

		}
		dbg.location(73, 19);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !);
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Int34=null;
		Token Ident35=null;
		Token Boolean36=null;
		Token QuestionVariable37=null;
		Token Money38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		ParserRuleReturnScope x =null;

		CommonTree Int34_tree=null;
		CommonTree Ident35_tree=null;
		CommonTree Boolean36_tree=null;
		CommonTree QuestionVariable37_tree=null;
		CommonTree Money38_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree char_literal40_tree=null;
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:3: ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !)
			int alt5=6;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case Int:
				{
				alt5=1;
				}
				break;
			case Ident:
				{
				alt5=2;
				}
				break;
			case Boolean:
				{
				alt5=3;
				}
				break;
			case QuestionVariable:
				{
				alt5=4;
				}
				break;
			case Money:
				{
				alt5=5;
				}
				break;
			case 32:
				{
				alt5=6;
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(77,5);
					Int34=(Token)match(input,Int,FOLLOW_Int_in_primary382); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int34_tree = (CommonTree)adaptor.create(Int34);
					adaptor.addChild(root_0, Int34_tree);
					}
					dbg.location(77,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int34!=null?Int34.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(78,5);
					Ident35=(Token)match(input,Ident,FOLLOW_Ident_in_primary392); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident35_tree = (CommonTree)adaptor.create(Ident35);
					adaptor.addChild(root_0, Ident35_tree);
					}
					dbg.location(78,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident35!=null?Ident35.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(79,5);
					Boolean36=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary400); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean36_tree = (CommonTree)adaptor.create(Boolean36);
					adaptor.addChild(root_0, Boolean36_tree);
					}
					dbg.location(79,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean36!=null?Boolean36.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: QuestionVariable
					{
					dbg.location(80,5);
					QuestionVariable37=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_primary408); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable37);
					dbg.location(80,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable37!=null?QuestionVariable37.getText():null)); }
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
					// 80:72: -> ^( VAR_NAME QuestionVariable )
					{
						dbg.location(80,75);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:75: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(80,77);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_1);
						dbg.location(80,86);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(81,5);
					Money38=(Token)match(input,Money,FOLLOW_Money_in_primary426); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money38_tree = (CommonTree)adaptor.create(Money38);
					adaptor.addChild(root_0, Money38_tree);
					}
					dbg.location(81,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money38!=null?Money38.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:6: '(' !x= orExpr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(82,9);
					char_literal39=(Token)match(input,32,FOLLOW_32_in_primary435); if (state.failed) return retval;dbg.location(82,13);
					pushFollow(FOLLOW_orExpr_in_primary441);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(82,24);
					char_literal40=(Token)match(input,33,FOLLOW_33_in_primary443); if (state.failed) return retval;dbg.location(82,26);
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
			if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

		}
		dbg.location(83, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal41=null;
		Token char_literal42=null;
		Token char_literal43=null;
		ParserRuleReturnScope x =null;

		CommonTree char_literal41_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree char_literal43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt6=4;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			switch ( input.LA(1) ) {
			case 35:
				{
				alt6=1;
				}
				break;
			case 36:
				{
				alt6=2;
				}
				break;
			case 29:
				{
				alt6=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 32:
				{
				alt6=4;
				}
				break;
			default:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(87,11);
					char_literal41=(Token)match(input,35,FOLLOW_35_in_unExpr473); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal41_tree, root_0);
					}
					dbg.location(87,14);
					pushFollow(FOLLOW_unExpr_in_unExpr478);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(87,22);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(88,11);
					char_literal42=(Token)match(input,36,FOLLOW_36_in_unExpr489); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal42_tree = (CommonTree)adaptor.create(char_literal42);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal42_tree, root_0);
					}
					dbg.location(88,14);
					pushFollow(FOLLOW_unExpr_in_unExpr494);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(88,22);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(89,11);
					char_literal43=(Token)match(input,29,FOLLOW_29_in_unExpr505); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal43_tree = (CommonTree)adaptor.create(char_literal43);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal43_tree, root_0);
					}
					dbg.location(89,14);
					pushFollow(FOLLOW_unExpr_in_unExpr510);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(89,22);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(90,9);
					pushFollow(FOLLOW_primary_in_unExpr523);
					x=primary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(90,21);
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
			if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

		}
		dbg.location(91, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(93, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(94,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr561);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(94,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(94,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==34||LA8_0==37) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(94,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:50: ( '*' ^| '/' ^)
					int alt7=2;
					try { dbg.enterSubRule(7);
					try { dbg.enterDecision(7, decisionCanBacktrack[7]);

					int LA7_0 = input.LA(1);
					if ( (LA7_0==34) ) {
						alt7=1;
					}
					else if ( (LA7_0==37) ) {
						alt7=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(7);}

					switch (alt7) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:52: '*' ^
							{
							dbg.location(94,55);
							op=(Token)match(input,34,FOLLOW_34_in_mulExpr571); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:59: '/' ^
							{
							dbg.location(94,62);
							op=(Token)match(input,37,FOLLOW_37_in_mulExpr576); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(7);}
					dbg.location(94,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr583);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(95,5);
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
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

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
			if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

		}
		dbg.location(103, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(106, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(107,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr624);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(107,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(107,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 35 && LA10_0 <= 36)) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(107,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:51: ( '+' ^| '-' ^)
					int alt9=2;
					try { dbg.enterSubRule(9);
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( (LA9_0==35) ) {
						alt9=1;
					}
					else if ( (LA9_0==36) ) {
						alt9=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(9);}

					switch (alt9) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:52: '+' ^
							{
							dbg.location(107,55);
							op=(Token)match(input,35,FOLLOW_35_in_addExpr633); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:59: '-' ^
							{
							dbg.location(107,62);
							op=(Token)match(input,36,FOLLOW_36_in_addExpr638); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(9);}
					dbg.location(107,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr644);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(108,5);
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
					break loop10;
				}
			}
			} finally {dbg.exitSubRule(10);}

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
			if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

		}
		dbg.location(116, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(118, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(119,12);
			pushFollow(FOLLOW_addExpr_in_relExpr679);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(119,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(119,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==30||(LA12_0 >= 39 && LA12_0 <= 43)) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(119,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt11=6;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					switch ( input.LA(1) ) {
					case 39:
						{
						alt11=1;
						}
						break;
					case 40:
						{
						alt11=2;
						}
						break;
					case 42:
						{
						alt11=3;
						}
						break;
					case 43:
						{
						alt11=4;
						}
						break;
					case 41:
						{
						alt11=5;
						}
						break;
					case 30:
						{
						alt11=6;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(11);}

					switch (alt11) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:52: '<' ^
							{
							dbg.location(119,55);
							op=(Token)match(input,39,FOLLOW_39_in_relExpr688); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:57: '<=' ^
							{
							dbg.location(119,61);
							op=(Token)match(input,40,FOLLOW_40_in_relExpr691); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:63: '>' ^
							{
							dbg.location(119,66);
							op=(Token)match(input,42,FOLLOW_42_in_relExpr694); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:68: '>=' ^
							{
							dbg.location(119,72);
							op=(Token)match(input,43,FOLLOW_43_in_relExpr697); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:75: '==' ^
							{
							dbg.location(119,79);
							op=(Token)match(input,41,FOLLOW_41_in_relExpr701); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:82: '!=' ^
							{
							dbg.location(119,86);
							op=(Token)match(input,30,FOLLOW_30_in_relExpr705); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(11);}
					dbg.location(119,92);
					pushFollow(FOLLOW_addExpr_in_relExpr711);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(120,5);
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
			if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

		}
		dbg.location(140, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal44=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal44_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(142, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(143,12);
			pushFollow(FOLLOW_relExpr_in_andExpr749);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(143,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(143,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==31) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:48: '&&' ^rhs= relExpr
					{
					dbg.location(143,52);
					string_literal44=(Token)match(input,31,FOLLOW_31_in_andExpr755); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal44_tree = (CommonTree)adaptor.create(string_literal44);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal44_tree, root_0);
					}
					dbg.location(143,57);
					pushFollow(FOLLOW_relExpr_in_andExpr760);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(143,66);
					if ( state.backtracking==0 ) { retval.result = new And(retval.result, (rhs!=null?((QLParser.relExpr_return)rhs).result:null)); }
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
			if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

		}
		dbg.location(144, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal45=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal45_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(147, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(148,12);
			pushFollow(FOLLOW_andExpr_in_orExpr795);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(148,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(148,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==45) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:50: '||' ^rhs= andExpr
					{
					dbg.location(148,54);
					string_literal45=(Token)match(input,45,FOLLOW_45_in_orExpr801); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal45_tree = (CommonTree)adaptor.create(string_literal45);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal45_tree, root_0);
					}
					dbg.location(148,59);
					pushFollow(FOLLOW_andExpr_in_orExpr806);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(148,68);
					if ( state.backtracking==0 ) { retval.result = new Or(retval.result, (rhs!=null?((QLParser.andExpr_return)rhs).result:null)); }
					}
					break;

				default :
					break loop14;
				}
			}
			} finally {dbg.exitSubRule(14);}

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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

		}
		dbg.location(149, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "orExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred4_QL
	public final void synpred4_QL_fragment() throws RecognitionException {
		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: ( qDeclaration )
		dbg.enterAlt(1);

		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: qDeclaration
		{
		dbg.location(67,6);
		pushFollow(FOLLOW_qDeclaration_in_synpred4_QL338);
		qDeclaration();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_QL

	// $ANTLR start synpred5_QL
	public final void synpred5_QL_fragment() throws RecognitionException {
		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:22: ( ifStatementExpr )
		dbg.enterAlt(1);

		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:22: ifStatementExpr
		{
		dbg.location(67,22);
		pushFollow(FOLLOW_ifStatementExpr_in_synpred5_QL343);
		ifStatementExpr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_QL

	// Delegated rules

	public final boolean synpred5_QL() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred5_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_QL() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred4_QL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_FormStart_in_parse106 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_parse108 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp134 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp136 = new BitSet(new long[]{0x0000000000400100L});
	public static final BitSet FOLLOW_qContentItemExpr_in_qStartExp138 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration160 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_qDeclaration163 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration165 = new BitSet(new long[]{0x0000000000010010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration201 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_qDeclaration204 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration206 = new BitSet(new long[]{0x0000000000010010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration208 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_qDeclaration210 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration212 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_qDeclaration214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr263 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifStatementExpr266 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatementExpr268 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_ifStatementExpr270 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr274 = new BitSet(new long[]{0x0000000000400100L});
	public static final BitSet FOLLOW_qContentItemExpr_in_ifStatementExpr276 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr278 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_elseStatementExpr_in_ifStatementExpr280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_elseStatementExpr315 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Lbr_in_elseStatementExpr317 = new BitSet(new long[]{0x0000000000C00100L});
	public static final BitSet FOLLOW_qContentItemExpr_in_elseStatementExpr319 = new BitSet(new long[]{0x0000000000C00100L});
	public static final BitSet FOLLOW_Rbr_in_elseStatementExpr322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qContentItemExpr338 = new BitSet(new long[]{0x0000000000400102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qContentItemExpr343 = new BitSet(new long[]{0x0000000000400102L});
	public static final BitSet FOLLOW_Int_in_primary382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_primary408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_primary435 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_orExpr_in_primary441 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_primary443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_unExpr473 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_unExpr489 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_unExpr505 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr561 = new BitSet(new long[]{0x0000002400000002L});
	public static final BitSet FOLLOW_34_in_mulExpr571 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_37_in_mulExpr576 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr583 = new BitSet(new long[]{0x0000002400000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr624 = new BitSet(new long[]{0x0000001800000002L});
	public static final BitSet FOLLOW_35_in_addExpr633 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_36_in_addExpr638 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr644 = new BitSet(new long[]{0x0000001800000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr679 = new BitSet(new long[]{0x00000F8040000002L});
	public static final BitSet FOLLOW_39_in_relExpr688 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_40_in_relExpr691 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_42_in_relExpr694 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_43_in_relExpr697 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_41_in_relExpr701 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_30_in_relExpr705 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr711 = new BitSet(new long[]{0x00000F8040000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr749 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_andExpr755 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr760 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr795 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_45_in_orExpr801 = new BitSet(new long[]{0x0000001920416010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr806 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_synpred4_QL338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatementExpr_in_synpred5_QL343 = new BitSet(new long[]{0x0000000000000002L});
}
