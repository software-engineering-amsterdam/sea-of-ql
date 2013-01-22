// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 03:09:02

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
		"FormStart", "IF", "IF_BLOCK", "IF_FALSE", "IF_STATEMENT", "IF_TRUE", 
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
	public static final int IF_FALSE=15;
	public static final int IF_STATEMENT=16;
	public static final int IF_TRUE=17;
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
		"invalidRule", "synpred23_QL", "ifStatementExpr", "synpred20_QL", "mulExpr", 
		"constantDeclarationExpr", "synpred6_QL", "synpred26_QL", "synpred24_QL", 
		"addExpr", "parse", "synpred13_QL", "synpred22_QL", "qStartExp", "synpred21_QL", 
		"elseStatementExpr", "relExpr", "qBodyItemExpr", "unExpr", "synpred7_QL", 
		"atom", "qType", "synpred1_QL", "synpred14_QL", "orExpr", "qDeclaration", 
		"synpred17_QL", "synpred4_QL", "synpred25_QL", "synpred5_QL", "synpred8_QL", 
		"synpred2_QL", "synpred10_QL", "synpred11_QL", "synpred19_QL", "synpred18_QL", 
		"synpred3_QL", "synpred9_QL", "synpred16_QL", "synpred15_QL", "andExpr", 
		"synpred12_QL"
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: parse : FormStart qStartExp EOF -> ^( FormStart qStartExp ) ;
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
		dbg.location(52, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:2: ( FormStart qStartExp EOF -> ^( FormStart qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: FormStart qStartExp EOF
			{
			dbg.location(53,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse125); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(53,14);
			pushFollow(FOLLOW_qStartExp_in_parse127);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartExp.add(qStartExp2.getTree());dbg.location(53,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse129); if (state.failed) return retval; 
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
			// 53:28: -> ^( FormStart qStartExp )
			{
				dbg.location(53,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:31: ^( FormStart qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(53,33);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(53,43);
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
		dbg.location(53, 52);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:1: qStartExp : FormId Lbr qBodyItemExpr Rbr -> ^( FormId qBodyItemExpr ) ;
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
		dbg.location(57, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:2: ( FormId Lbr qBodyItemExpr Rbr -> ^( FormId qBodyItemExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:4: FormId Lbr qBodyItemExpr Rbr
			{
			dbg.location(59,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp153); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId4);
			dbg.location(59,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp155); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(59,15);
			pushFollow(FOLLOW_qBodyItemExpr_in_qStartExp157);
			qBodyItemExpr6=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr6.getTree());dbg.location(59,29);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp159); if (state.failed) return retval; 
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
			// 59:33: -> ^( FormId qBodyItemExpr )
			{
				dbg.location(59,35);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:35: ^( FormId qBodyItemExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(59,37);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(59,44);
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
		dbg.location(59, 57);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: qDeclaration : ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) );
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
		dbg.location(63, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:2: ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:4: QuestionVariable ':' QuestionLabel qType
					{
					dbg.location(64,4);
					QuestionVariable8=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration179); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable8);
					dbg.location(64,22);
					char_literal9=(Token)match(input,43,FOLLOW_43_in_qDeclaration182); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_43.add(char_literal9);
					dbg.location(64,26);
					QuestionLabel10=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration184); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel10);
					dbg.location(64,40);
					pushFollow(FOLLOW_qType_in_qDeclaration186);
					qType11=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType11.getTree());
					// AST REWRITE
					// elements: qType, QuestionVariable, QuestionLabel
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 64:46: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(64,48);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:48: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(64,50);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(64,65);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:65: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(64,67);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(64,80);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:80: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(64,82);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(64,91);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(64,109);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:109: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(64,111);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(64,120);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(64,129);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:129: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(64,131);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(64,146);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:4: QuestionVariable ':' QuestionLabel qType '(' orExpr ')'
					{
					dbg.location(65,4);
					QuestionVariable12=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable12);
					dbg.location(65,22);
					char_literal13=(Token)match(input,43,FOLLOW_43_in_qDeclaration223); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_43.add(char_literal13);
					dbg.location(65,26);
					QuestionLabel14=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration225); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel14);
					dbg.location(65,40);
					pushFollow(FOLLOW_qType_in_qDeclaration227);
					qType15=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType15.getTree());dbg.location(65,46);
					char_literal16=(Token)match(input,37,FOLLOW_37_in_qDeclaration229); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_37.add(char_literal16);
					dbg.location(65,50);
					pushFollow(FOLLOW_orExpr_in_qDeclaration231);
					orExpr17=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr17.getTree());dbg.location(65,57);
					char_literal18=(Token)match(input,38,FOLLOW_38_in_qDeclaration233); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal18);

					// AST REWRITE
					// elements: orExpr, QuestionLabel, qType, QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 65:62: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(65,64);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:64: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(65,66);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(65,81);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:81: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(65,83);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(65,96);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:96: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(65,98);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(65,107);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(65,125);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:125: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(65,127);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(65,136);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(65,143);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:143: ^( VALUE_CALC orExpr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(65,145);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(65,156);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(65,166);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:166: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(65,168);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(65,183);
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
		dbg.location(65, 198);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: ifStatementExpr : IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qBodyItemExpr ) ( ^( IF_FALSE elseStatementExpr ) )? ) ;
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
		dbg.location(69, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:2: ( IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )? -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qBodyItemExpr ) ( ^( IF_FALSE elseStatementExpr ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: IF '(' orExpr ')' Lbr qBodyItemExpr Rbr ( elseStatementExpr )?
			{
			dbg.location(70,5);
			IF19=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr282); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF19);
			dbg.location(70,9);
			char_literal20=(Token)match(input,37,FOLLOW_37_in_ifStatementExpr285); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_37.add(char_literal20);
			dbg.location(70,13);
			pushFollow(FOLLOW_orExpr_in_ifStatementExpr287);
			orExpr21=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr21.getTree());dbg.location(70,20);
			char_literal22=(Token)match(input,38,FOLLOW_38_in_ifStatementExpr289); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_38.add(char_literal22);
			dbg.location(70,26);
			Lbr23=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr293); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr23);
			dbg.location(70,30);
			pushFollow(FOLLOW_qBodyItemExpr_in_ifStatementExpr295);
			qBodyItemExpr24=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr24.getTree());dbg.location(70,44);
			Rbr25=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr297); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr25);
			dbg.location(70,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:48: ( elseStatementExpr )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:48: elseStatementExpr
					{
					dbg.location(70,48);
					pushFollow(FOLLOW_elseStatementExpr_in_ifStatementExpr299);
					elseStatementExpr26=elseStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseStatementExpr.add(elseStatementExpr26.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: elseStatementExpr, qBodyItemExpr, orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 70:67: -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qBodyItemExpr ) ( ^( IF_FALSE elseStatementExpr ) )? )
			{
				dbg.location(70,69);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:69: ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qBodyItemExpr ) ( ^( IF_FALSE elseStatementExpr ) )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(70,71);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(70,80);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:80: ^( IF_STATEMENT orExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(70,82);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_2);
				dbg.location(70,95);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(70,103);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:103: ^( IF_TRUE qBodyItemExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(70,105);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
				dbg.location(70,113);
				adaptor.addChild(root_2, stream_qBodyItemExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(70,129);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:129: ( ^( IF_FALSE elseStatementExpr ) )?
				if ( stream_elseStatementExpr.hasNext() ) {
					dbg.location(70,129);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:129: ^( IF_FALSE elseStatementExpr )
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					dbg.location(70,131);
					root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_FALSE, "IF_FALSE"), root_2);
					dbg.location(70,140);
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
		dbg.location(70, 159);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: elseStatementExpr : 'else' Lbr qBodyItemExpr Rbr -> qBodyItemExpr ;
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
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( 'else' Lbr qBodyItemExpr Rbr -> qBodyItemExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: 'else' Lbr qBodyItemExpr Rbr
			{
			dbg.location(73,4);
			string_literal27=(Token)match(input,49,FOLLOW_49_in_elseStatementExpr334); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_49.add(string_literal27);
			dbg.location(73,11);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseStatementExpr336); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr28);
			dbg.location(73,15);
			pushFollow(FOLLOW_qBodyItemExpr_in_elseStatementExpr338);
			qBodyItemExpr29=qBodyItemExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qBodyItemExpr.add(qBodyItemExpr29.getTree());dbg.location(73,29);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseStatementExpr340); if (state.failed) return retval; 
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
			// 73:33: -> qBodyItemExpr
			{
				dbg.location(73,36);
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
		dbg.location(73, 48);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: qBodyItemExpr : ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+ ;
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
		dbg.location(75, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:2: ( ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(76,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: ( qDeclaration | ifStatementExpr | constantDeclarationExpr )+
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:6: qDeclaration
					{
					dbg.location(76,6);
					pushFollow(FOLLOW_qDeclaration_in_qBodyItemExpr356);
					qDeclaration31=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration31.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:22: ifStatementExpr
					{
					dbg.location(76,22);
					pushFollow(FOLLOW_ifStatementExpr_in_qBodyItemExpr361);
					ifStatementExpr32=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr32.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:40: constantDeclarationExpr
					{
					dbg.location(76,40);
					pushFollow(FOLLOW_constantDeclarationExpr_in_qBodyItemExpr365);
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
		dbg.location(76, 65);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: constantDeclarationExpr : QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) ;
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
		dbg.location(78, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:2: ( QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:4: QuestionVariable ':' Int
			{
			dbg.location(79,4);
			QuestionVariable34=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_constantDeclarationExpr378); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable34);
			dbg.location(79,22);
			char_literal35=(Token)match(input,43,FOLLOW_43_in_constantDeclarationExpr381); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_43.add(char_literal35);
			dbg.location(79,26);
			Int36=(Token)match(input,Int,FOLLOW_Int_in_constantDeclarationExpr383); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Int.add(Int36);

			// AST REWRITE
			// elements: QuestionVariable, Int
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 79:30: -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
			{
				dbg.location(79,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:33: ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(79,35);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(79,45);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:45: ^( CONST_NAME QuestionVariable )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(79,47);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_NAME, "CONST_NAME"), root_2);
				dbg.location(79,58);
				adaptor.addChild(root_2, stream_QuestionVariable.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(79,76);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:76: ^( CONST_TYPE CONST_TYPE_INT )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(79,78);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(79,89);
				adaptor.addChild(root_2, (CommonTree)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(79,105);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:105: ^( CONST_VALUE Int )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(79,107);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(79,119);
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
		dbg.location(79, 123);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: qType : ( Boolean | Money );
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
		dbg.location(82, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(83,2);
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
		dbg.location(83, 19);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qType"


	public static class atom_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: atom returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable | Money | '(' !x= orExpr ')' !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

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

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(85, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:3: ( Int | Ident | Boolean | QuestionVariable | Money | '(' !x= orExpr ')' !)
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(86,5);
					Int38=(Token)match(input,Int,FOLLOW_Int_in_atom438); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int38_tree = (CommonTree)adaptor.create(Int38);
					adaptor.addChild(root_0, Int38_tree);
					}
					dbg.location(86,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int38!=null?Int38.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(87,5);
					Ident39=(Token)match(input,Ident,FOLLOW_Ident_in_atom448); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident39_tree = (CommonTree)adaptor.create(Ident39);
					adaptor.addChild(root_0, Ident39_tree);
					}
					dbg.location(87,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident39!=null?Ident39.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(88,5);
					Boolean40=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom457); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean40_tree = (CommonTree)adaptor.create(Boolean40);
					adaptor.addChild(root_0, Boolean40_tree);
					}
					dbg.location(88,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean40!=null?Boolean40.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: QuestionVariable
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(89,5);
					QuestionVariable41=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_atom465); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QuestionVariable41_tree = (CommonTree)adaptor.create(QuestionVariable41);
					adaptor.addChild(root_0, QuestionVariable41_tree);
					}
					dbg.location(89,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable41!=null?QuestionVariable41.getText():null));}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(90,5);
					Money42=(Token)match(input,Money,FOLLOW_Money_in_atom474); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money42_tree = (CommonTree)adaptor.create(Money42);
					adaptor.addChild(root_0, Money42_tree);
					}
					dbg.location(90,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money42!=null?Money42.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:6: '(' !x= orExpr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(91,9);
					char_literal43=(Token)match(input,37,FOLLOW_37_in_atom483); if (state.failed) return retval;dbg.location(91,13);
					pushFollow(FOLLOW_orExpr_in_atom489);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(91,24);
					char_literal44=(Token)match(input,38,FOLLOW_38_in_atom491); if (state.failed) return retval;dbg.location(91,26);
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
			if ( state.backtracking>0 ) { memoize(input, 9, atom_StartIndex); }

		}
		dbg.location(92, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atom");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "atom"


	public static class unExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: unExpr returns [Expr result] : ( '+' x= atom | '-' x= atom | '!' x= atom |x= atom );
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
		dbg.location(95, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:5: ( '+' x= atom | '-' x= atom | '!' x= atom |x= atom )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:8: '+' x= atom
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(96,8);
					char_literal45=(Token)match(input,40,FOLLOW_40_in_unExpr520); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal45_tree = (CommonTree)adaptor.create(char_literal45);
					adaptor.addChild(root_0, char_literal45_tree);
					}
					dbg.location(96,13);
					pushFollow(FOLLOW_atom_in_unExpr524);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(96,19);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:8: '-' x= atom
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(97,8);
					char_literal46=(Token)match(input,41,FOLLOW_41_in_unExpr535); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal46_tree = (CommonTree)adaptor.create(char_literal46);
					adaptor.addChild(root_0, char_literal46_tree);
					}
					dbg.location(97,13);
					pushFollow(FOLLOW_atom_in_unExpr539);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(97,19);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:8: '!' x= atom
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(98,8);
					char_literal47=(Token)match(input,34,FOLLOW_34_in_unExpr550); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal47_tree = (CommonTree)adaptor.create(char_literal47);
					adaptor.addChild(root_0, char_literal47_tree);
					}
					dbg.location(98,13);
					pushFollow(FOLLOW_atom_in_unExpr554);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(98,19);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:8: x= atom
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(99,9);
					pushFollow(FOLLOW_atom_in_unExpr567);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(99,18);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.atom_return)x).result:null); }
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
		dbg.location(100, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(102, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(103,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr603);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(103,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(103,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(103,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:50: ( '*' ^| '/' ^)
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:52: '*' ^
							{
							dbg.location(103,55);
							op=(Token)match(input,39,FOLLOW_39_in_mulExpr613); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:59: '/' ^
							{
							dbg.location(103,62);
							op=(Token)match(input,42,FOLLOW_42_in_mulExpr618); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(103,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr625);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(104,5);
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
		dbg.location(112, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(115, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(116,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr666);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(116,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(116,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(116,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:51: ( '+' ^| '-' ^)
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:52: '+' ^
							{
							dbg.location(116,55);
							op=(Token)match(input,40,FOLLOW_40_in_addExpr675); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:59: '-' ^
							{
							dbg.location(116,62);
							op=(Token)match(input,41,FOLLOW_41_in_addExpr680); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(116,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr686);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(117,5);
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
		dbg.location(125, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(127, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(128,12);
			pushFollow(FOLLOW_addExpr_in_relExpr721);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(128,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(128,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(128,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:52: '<' ^
							{
							dbg.location(128,55);
							op=(Token)match(input,44,FOLLOW_44_in_relExpr730); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:57: '<=' ^
							{
							dbg.location(128,61);
							op=(Token)match(input,45,FOLLOW_45_in_relExpr733); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:63: '>' ^
							{
							dbg.location(128,66);
							op=(Token)match(input,47,FOLLOW_47_in_relExpr736); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:68: '>=' ^
							{
							dbg.location(128,72);
							op=(Token)match(input,48,FOLLOW_48_in_relExpr739); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:75: '==' ^
							{
							dbg.location(128,79);
							op=(Token)match(input,46,FOLLOW_46_in_relExpr743); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:82: '!=' ^
							{
							dbg.location(128,86);
							op=(Token)match(input,35,FOLLOW_35_in_relExpr747); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(128,92);
					pushFollow(FOLLOW_addExpr_in_relExpr753);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(129,5);
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
		dbg.location(149, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:151:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
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
		dbg.location(151, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(152,12);
			pushFollow(FOLLOW_relExpr_in_andExpr791);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(152,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(152,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:46: ( '&&' ^rhs= relExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:48: '&&' ^rhs= relExpr
					{
					dbg.location(152,52);
					string_literal48=(Token)match(input,36,FOLLOW_36_in_andExpr797); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal48_tree = (CommonTree)adaptor.create(string_literal48);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_0);
					}
					dbg.location(152,57);
					pushFollow(FOLLOW_relExpr_in_andExpr802);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(152,66);
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
		dbg.location(153, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
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
		dbg.location(156, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(157,12);
			pushFollow(FOLLOW_andExpr_in_orExpr837);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(157,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(157,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:48: ( '||' ^rhs= andExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:50: '||' ^rhs= andExpr
					{
					dbg.location(157,54);
					string_literal49=(Token)match(input,50,FOLLOW_50_in_orExpr843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal49_tree = (CommonTree)adaptor.create(string_literal49);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal49_tree, root_0);
					}
					dbg.location(157,59);
					pushFollow(FOLLOW_andExpr_in_orExpr848);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(157,68);
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
		dbg.location(158, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse125 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_qStartExp_in_parse127 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp153 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp155 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_qStartExp157 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration179 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_qDeclaration182 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration184 = new BitSet(new long[]{0x0000000000200010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration220 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_qDeclaration223 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration225 = new BitSet(new long[]{0x0000000000200010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration227 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_qDeclaration229 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration231 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_qDeclaration233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr282 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_ifStatementExpr285 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatementExpr287 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_ifStatementExpr289 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr293 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_ifStatementExpr295 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr297 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_elseStatementExpr_in_ifStatementExpr299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_elseStatementExpr334 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Lbr_in_elseStatementExpr336 = new BitSet(new long[]{0x0000000008002000L});
	public static final BitSet FOLLOW_qBodyItemExpr_in_elseStatementExpr338 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Rbr_in_elseStatementExpr340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qBodyItemExpr356 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qBodyItemExpr361 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_constantDeclarationExpr_in_qBodyItemExpr365 = new BitSet(new long[]{0x0000000008002002L});
	public static final BitSet FOLLOW_QuestionVariable_in_constantDeclarationExpr378 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_constantDeclarationExpr381 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_Int_in_constantDeclarationExpr383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_atom465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_atom483 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_orExpr_in_atom489 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_atom491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_unExpr520 = new BitSet(new long[]{0x00000020082C0010L});
	public static final BitSet FOLLOW_atom_in_unExpr524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_unExpr535 = new BitSet(new long[]{0x00000020082C0010L});
	public static final BitSet FOLLOW_atom_in_unExpr539 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_unExpr550 = new BitSet(new long[]{0x00000020082C0010L});
	public static final BitSet FOLLOW_atom_in_unExpr554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr603 = new BitSet(new long[]{0x0000048000000002L});
	public static final BitSet FOLLOW_39_in_mulExpr613 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_42_in_mulExpr618 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr625 = new BitSet(new long[]{0x0000048000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr666 = new BitSet(new long[]{0x0000030000000002L});
	public static final BitSet FOLLOW_40_in_addExpr675 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_41_in_addExpr680 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr686 = new BitSet(new long[]{0x0000030000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr721 = new BitSet(new long[]{0x0001F00800000002L});
	public static final BitSet FOLLOW_44_in_relExpr730 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_45_in_relExpr733 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_47_in_relExpr736 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_48_in_relExpr739 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_46_in_relExpr743 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_35_in_relExpr747 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr753 = new BitSet(new long[]{0x0001F00800000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr791 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_andExpr797 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr802 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr837 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_50_in_orExpr843 = new BitSet(new long[]{0x00000324082C0010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr848 = new BitSet(new long[]{0x0004000000000002L});
}
