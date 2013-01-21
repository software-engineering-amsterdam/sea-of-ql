// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 21:06:06

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
		"FormStart", "IF", "IF_BLOCK", "IF_CONDITION", "IF_CONDITION_TRUE", "Ident", 
		"Int", "Lbr", "Money", "NEG_EXPR", "QUESTION_BLOCK", "QUESTION_LABEL", 
		"QUESTION_VAR", "QuestionLabel", "QuestionVariable", "Rbr", "UNARY_EXPR", 
		"VALUE_CALC", "VAR_NAME", "VAR_TYPE", "WS", "'!'", "'!='", "'&&'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", 
		"'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__43=43;
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
	public static final int NEG_EXPR=16;
	public static final int QUESTION_BLOCK=17;
	public static final int QUESTION_LABEL=18;
	public static final int QUESTION_VAR=19;
	public static final int QuestionLabel=20;
	public static final int QuestionVariable=21;
	public static final int Rbr=22;
	public static final int UNARY_EXPR=23;
	public static final int VALUE_CALC=24;
	public static final int VAR_NAME=25;
	public static final int VAR_TYPE=26;
	public static final int WS=27;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred26_QL", "andExpr", "qStartExp", "synpred10_QL", 
		"ifBlockContentExpr", "ifStatementExpr", "synpred6_QL", "synpred7_QL", 
		"synpred25_QL", "unExpr", "synpred15_QL", "synpred2_QL", "synpred20_QL", 
		"synpred9_QL", "qDeclaration", "synpred8_QL", "synpred21_QL", "synpred1_QL", 
		"synpred13_QL", "qType", "orExpr", "synpred11_QL", "synpred14_QL", "primary", 
		"synpred16_QL", "relExpr", "synpred24_QL", "qStartQExpr", "synpred4_QL", 
		"addExpr", "synpred23_QL", "synpred3_QL", "synpred5_QL", "synpred22_QL", 
		"parse", "synpred17_QL", "synpred12_QL", "mulExpr", "synpred19_QL", "synpred18_QL"
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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: parse : FormStart qStartExp EOF -> ^( FormStart qStartExp ) ;
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
		dbg.location(42, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:43:2: ( FormStart qStartExp EOF -> ^( FormStart qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: FormStart qStartExp EOF
			{
			dbg.location(43,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse103); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(43,14);
			pushFollow(FOLLOW_qStartExp_in_parse105);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartExp.add(qStartExp2.getTree());dbg.location(43,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse107); if (state.failed) return retval; 
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
			// 43:28: -> ^( FormStart qStartExp )
			{
				dbg.location(43,31);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:43:31: ^( FormStart qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(43,33);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(43,43);
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
		dbg.location(43, 52);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: qStartExp : FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) ;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);
		int qStartExp_StartIndex = input.index();

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
		dbg.location(47, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:2: ( FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:4: FormId Lbr qStartQExpr Rbr
			{
			dbg.location(49,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp131); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId4);
			dbg.location(49,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp133); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(49,15);
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp135);
			qStartQExpr6=qStartQExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartQExpr.add(qStartQExpr6.getTree());dbg.location(49,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp137); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: FormId, qStartQExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 49:31: -> ^( FormId qStartQExpr )
			{
				dbg.location(49,33);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:49:33: ^( FormId qStartQExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(49,35);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(49,42);
				adaptor.addChild(root_1, stream_qStartQExpr.nextTree());
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
		dbg.location(49, 53);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: qStartQExpr : ( qDeclaration | ifStatementExpr )* ;
	public final QLParser.qStartQExpr_return qStartQExpr() throws RecognitionException {
		QLParser.qStartQExpr_return retval = new QLParser.qStartQExpr_return();
		retval.start = input.LT(1);
		int qStartQExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration8 =null;
		ParserRuleReturnScope ifStatementExpr9 =null;


		try { dbg.enterRule(getGrammarFileName(), "qStartQExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(52, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:2: ( ( qDeclaration | ifStatementExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: ( qDeclaration | ifStatementExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(53,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: ( qDeclaration | ifStatementExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: qDeclaration
					{
					dbg.location(53,5);
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr157);
					qDeclaration8=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:20: ifStatementExpr
					{
					dbg.location(53,20);
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr161);
					ifStatementExpr9=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr9.getTree());

					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}

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
			if ( state.backtracking>0 ) { memoize(input, 3, qStartQExpr_StartIndex); }

		}
		dbg.location(53, 36);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: qDeclaration : ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) );
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		CommonTree root_0 = null;

		Token QuestionVariable10=null;
		Token char_literal11=null;
		Token QuestionLabel12=null;
		Token QuestionVariable14=null;
		Token char_literal15=null;
		Token QuestionLabel16=null;
		Token char_literal18=null;
		Token char_literal20=null;
		ParserRuleReturnScope qType13 =null;
		ParserRuleReturnScope qType17 =null;
		ParserRuleReturnScope orExpr19 =null;

		CommonTree QuestionVariable10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree QuestionLabel12_tree=null;
		CommonTree QuestionVariable14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree QuestionLabel16_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal20_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(56, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:2: ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==QuestionVariable) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==37) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==QuestionLabel) ) {
						int LA2_3 = input.LA(4);
						if ( (LA2_3==Boolean||LA2_3==Money) ) {
							int LA2_4 = input.LA(5);
							if ( (LA2_4==EOF||LA2_4==IF||(LA2_4 >= QuestionVariable && LA2_4 <= Rbr)) ) {
								alt2=1;
							}
							else if ( (LA2_4==31) ) {
								alt2=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
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
							if (state.backtracking>0) {state.failed=true; return retval;}
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
						if (state.backtracking>0) {state.failed=true; return retval;}
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
					if (state.backtracking>0) {state.failed=true; return retval;}
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
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:4: QuestionVariable ':' QuestionLabel qType
					{
					dbg.location(57,4);
					QuestionVariable10=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration174); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable10);
					dbg.location(57,22);
					char_literal11=(Token)match(input,37,FOLLOW_37_in_qDeclaration177); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_37.add(char_literal11);
					dbg.location(57,26);
					QuestionLabel12=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration179); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel12);
					dbg.location(57,40);
					pushFollow(FOLLOW_qType_in_qDeclaration181);
					qType13=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType13.getTree());
					// AST REWRITE
					// elements: QuestionLabel, qType, QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 57:46: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(57,48);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:48: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(57,50);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(57,65);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:65: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(57,67);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(57,80);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:80: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(57,82);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(57,91);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(57,109);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:109: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(57,111);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(57,120);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(57,129);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:57:129: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(57,131);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(57,146);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:4: QuestionVariable ':' QuestionLabel qType '(' orExpr ')'
					{
					dbg.location(58,4);
					QuestionVariable14=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration215); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable14);
					dbg.location(58,22);
					char_literal15=(Token)match(input,37,FOLLOW_37_in_qDeclaration218); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_37.add(char_literal15);
					dbg.location(58,26);
					QuestionLabel16=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel16);
					dbg.location(58,40);
					pushFollow(FOLLOW_qType_in_qDeclaration222);
					qType17=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType17.getTree());dbg.location(58,46);
					char_literal18=(Token)match(input,31,FOLLOW_31_in_qDeclaration224); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_31.add(char_literal18);
					dbg.location(58,50);
					pushFollow(FOLLOW_orExpr_in_qDeclaration226);
					orExpr19=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr19.getTree());dbg.location(58,57);
					char_literal20=(Token)match(input,32,FOLLOW_32_in_qDeclaration228); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_32.add(char_literal20);

					// AST REWRITE
					// elements: QuestionLabel, qType, orExpr, QuestionVariable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 58:62: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(58,64);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:64: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(58,66);
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(58,81);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:81: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(58,83);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(58,96);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:96: ^( VAR_NAME QuestionVariable )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(58,98);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(58,107);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(58,125);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:125: ^( VAR_TYPE qType )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(58,127);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(58,136);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(58,143);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:143: ^( VALUE_CALC orExpr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(58,145);
						root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(58,156);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(58,166);
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:166: ^( QUESTION_LABEL QuestionLabel )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(58,168);
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(58,183);
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
			if ( state.backtracking>0 ) { memoize(input, 4, qDeclaration_StartIndex); }

		}
		dbg.location(58, 198);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: ifStatementExpr : IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) ) ;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);
		int ifStatementExpr_StartIndex = input.index();

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
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_ifBlockContentExpr=new RewriteRuleSubtreeStream(adaptor,"rule ifBlockContentExpr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:2: ( IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:5: IF '(' orExpr ')' Lbr ifBlockContentExpr Rbr
			{
			dbg.location(63,5);
			IF21=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr277); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF21);
			dbg.location(63,9);
			char_literal22=(Token)match(input,31,FOLLOW_31_in_ifStatementExpr280); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_31.add(char_literal22);
			dbg.location(63,13);
			pushFollow(FOLLOW_orExpr_in_ifStatementExpr282);
			orExpr23=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr23.getTree());dbg.location(63,20);
			char_literal24=(Token)match(input,32,FOLLOW_32_in_ifStatementExpr284); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_32.add(char_literal24);
			dbg.location(63,26);
			Lbr25=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr288); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr25);
			dbg.location(63,30);
			pushFollow(FOLLOW_ifBlockContentExpr_in_ifStatementExpr290);
			ifBlockContentExpr26=ifBlockContentExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifBlockContentExpr.add(ifBlockContentExpr26.getTree());dbg.location(63,49);
			Rbr27=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr292); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr27);

			// AST REWRITE
			// elements: ifBlockContentExpr, orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 63:53: -> ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) )
			{
				dbg.location(63,55);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:55: ^( IF_BLOCK ^( IF_CONDITION orExpr ) ^( IF_CONDITION_TRUE ifBlockContentExpr ) )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(63,57);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(63,66);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:66: ^( IF_CONDITION orExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(63,68);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(63,81);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(63,89);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:89: ^( IF_CONDITION_TRUE ifBlockContentExpr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(63,91);
				root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_CONDITION_TRUE, "IF_CONDITION_TRUE"), root_2);
				dbg.location(63,109);
				adaptor.addChild(root_2, stream_ifBlockContentExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 5, ifStatementExpr_StartIndex); }

		}
		dbg.location(63, 128);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: ifBlockContentExpr : ( qDeclaration | ifStatementExpr )+ ;
	public final QLParser.ifBlockContentExpr_return ifBlockContentExpr() throws RecognitionException {
		QLParser.ifBlockContentExpr_return retval = new QLParser.ifBlockContentExpr_return();
		retval.start = input.LT(1);
		int ifBlockContentExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration28 =null;
		ParserRuleReturnScope ifStatementExpr29 =null;


		try { dbg.enterRule(getGrammarFileName(), "ifBlockContentExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: ( ( qDeclaration | ifStatementExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: ( qDeclaration | ifStatementExpr )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(67,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: ( qDeclaration | ifStatementExpr )+
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: qDeclaration
					{
					dbg.location(67,6);
					pushFollow(FOLLOW_qDeclaration_in_ifBlockContentExpr321);
					qDeclaration28=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration28.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:22: ifStatementExpr
					{
					dbg.location(67,22);
					pushFollow(FOLLOW_ifStatementExpr_in_ifBlockContentExpr326);
					ifStatementExpr29=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr29.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 6, ifBlockContentExpr_StartIndex); }

		}
		dbg.location(67, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifBlockContentExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifBlockContentExpr"


	public static class qType_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set30=null;

		CommonTree set30_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(73,2);
			set30=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set30));
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !);
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Int31=null;
		Token Ident32=null;
		Token Boolean33=null;
		Token QuestionVariable34=null;
		Token Money35=null;
		Token char_literal36=null;
		Token char_literal37=null;
		ParserRuleReturnScope x =null;

		CommonTree Int31_tree=null;
		CommonTree Ident32_tree=null;
		CommonTree Boolean33_tree=null;
		CommonTree QuestionVariable34_tree=null;
		CommonTree Money35_tree=null;
		CommonTree char_literal36_tree=null;
		CommonTree char_literal37_tree=null;
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:3: ( Int | Ident | Boolean | QuestionVariable -> ^( VAR_NAME QuestionVariable ) | Money | '(' !x= orExpr ')' !)
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
			case 31:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(77,5);
					Int31=(Token)match(input,Int,FOLLOW_Int_in_primary365); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int31_tree = (CommonTree)adaptor.create(Int31);
					adaptor.addChild(root_0, Int31_tree);
					}
					dbg.location(77,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int31!=null?Int31.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(78,5);
					Ident32=(Token)match(input,Ident,FOLLOW_Ident_in_primary375); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident32_tree = (CommonTree)adaptor.create(Ident32);
					adaptor.addChild(root_0, Ident32_tree);
					}
					dbg.location(78,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident32!=null?Ident32.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(79,5);
					Boolean33=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean33_tree = (CommonTree)adaptor.create(Boolean33);
					adaptor.addChild(root_0, Boolean33_tree);
					}
					dbg.location(79,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean33!=null?Boolean33.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: QuestionVariable
					{
					dbg.location(80,5);
					QuestionVariable34=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_primary391); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable34);
					dbg.location(80,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable34!=null?QuestionVariable34.getText():null)); }
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
						// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:75: ^( VAR_NAME QuestionVariable )
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(81,5);
					Money35=(Token)match(input,Money,FOLLOW_Money_in_primary409); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money35_tree = (CommonTree)adaptor.create(Money35);
					adaptor.addChild(root_0, Money35_tree);
					}
					dbg.location(81,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money35!=null?Money35.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:6: '(' !x= orExpr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(82,9);
					char_literal36=(Token)match(input,31,FOLLOW_31_in_primary418); if (state.failed) return retval;dbg.location(82,13);
					pushFollow(FOLLOW_orExpr_in_primary424);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(82,24);
					char_literal37=(Token)match(input,32,FOLLOW_32_in_primary426); if (state.failed) return retval;dbg.location(82,26);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		ParserRuleReturnScope x =null;

		CommonTree char_literal38_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree char_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 34:
				{
				alt5=1;
				}
				break;
			case 35:
				{
				alt5=2;
				}
				break;
			case 28:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 31:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(87,11);
					char_literal38=(Token)match(input,34,FOLLOW_34_in_unExpr456); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal38_tree = (CommonTree)adaptor.create(char_literal38);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal38_tree, root_0);
					}
					dbg.location(87,14);
					pushFollow(FOLLOW_unExpr_in_unExpr461);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(88,11);
					char_literal39=(Token)match(input,35,FOLLOW_35_in_unExpr472); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal39_tree, root_0);
					}
					dbg.location(88,14);
					pushFollow(FOLLOW_unExpr_in_unExpr477);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(89,11);
					char_literal40=(Token)match(input,28,FOLLOW_28_in_unExpr488); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal40_tree, root_0);
					}
					dbg.location(89,14);
					pushFollow(FOLLOW_unExpr_in_unExpr493);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(90,9);
					pushFollow(FOLLOW_primary_in_unExpr506);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(94,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr544);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(94,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(94,45);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==33||LA7_0==36) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(94,49);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:50: ( '*' ^| '/' ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==33) ) {
						alt6=1;
					}
					else if ( (LA6_0==36) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:52: '*' ^
							{
							dbg.location(94,55);
							op=(Token)match(input,33,FOLLOW_33_in_mulExpr554); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:59: '/' ^
							{
							dbg.location(94,62);
							op=(Token)match(input,36,FOLLOW_36_in_mulExpr559); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(94,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr566);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(107,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr607);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(107,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(107,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 34 && LA9_0 <= 35)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(107,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==34) ) {
						alt8=1;
					}
					else if ( (LA8_0==35) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:52: '+' ^
							{
							dbg.location(107,55);
							op=(Token)match(input,34,FOLLOW_34_in_addExpr616); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:59: '-' ^
							{
							dbg.location(107,62);
							op=(Token)match(input,35,FOLLOW_35_in_addExpr621); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(107,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr627);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(119,12);
			pushFollow(FOLLOW_addExpr_in_relExpr662);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(119,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(119,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==29||(LA11_0 >= 38 && LA11_0 <= 42)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(119,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 38:
						{
						alt10=1;
						}
						break;
					case 39:
						{
						alt10=2;
						}
						break;
					case 41:
						{
						alt10=3;
						}
						break;
					case 42:
						{
						alt10=4;
						}
						break;
					case 40:
						{
						alt10=5;
						}
						break;
					case 29:
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:52: '<' ^
							{
							dbg.location(119,55);
							op=(Token)match(input,38,FOLLOW_38_in_relExpr671); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:57: '<=' ^
							{
							dbg.location(119,61);
							op=(Token)match(input,39,FOLLOW_39_in_relExpr674); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:63: '>' ^
							{
							dbg.location(119,66);
							op=(Token)match(input,41,FOLLOW_41_in_relExpr677); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:68: '>=' ^
							{
							dbg.location(119,72);
							op=(Token)match(input,42,FOLLOW_42_in_relExpr680); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:75: '==' ^
							{
							dbg.location(119,79);
							op=(Token)match(input,40,FOLLOW_40_in_relExpr684); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:82: '!=' ^
							{
							dbg.location(119,86);
							op=(Token)match(input,29,FOLLOW_29_in_relExpr688); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(119,92);
					pushFollow(FOLLOW_addExpr_in_relExpr694);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal41=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(142, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(143,12);
			pushFollow(FOLLOW_relExpr_in_andExpr732);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(143,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(143,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==30) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:143:48: '&&' ^rhs= relExpr
					{
					dbg.location(143,52);
					string_literal41=(Token)match(input,30,FOLLOW_30_in_andExpr738); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal41_tree, root_0);
					}
					dbg.location(143,57);
					pushFollow(FOLLOW_relExpr_in_andExpr743);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(143,66);
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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal42=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal42_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(147, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(148,12);
			pushFollow(FOLLOW_andExpr_in_orExpr778);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(148,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(148,48);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==43) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:50: '||' ^rhs= andExpr
					{
					dbg.location(148,54);
					string_literal42=(Token)match(input,43,FOLLOW_43_in_orExpr784); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal42_tree = (CommonTree)adaptor.create(string_literal42);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal42_tree, root_0);
					}
					dbg.location(148,59);
					pushFollow(FOLLOW_andExpr_in_orExpr789);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(148,68);
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

	// Delegated rules



	public static final BitSet FOLLOW_FormStart_in_parse103 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_parse105 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp131 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp133 = new BitSet(new long[]{0x0000000000600100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp135 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr157 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr161 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration174 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_qDeclaration177 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration179 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration215 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_qDeclaration218 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration220 = new BitSet(new long[]{0x0000000000008010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration222 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_qDeclaration224 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration226 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_qDeclaration228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr277 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_ifStatementExpr280 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatementExpr282 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifStatementExpr284 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr288 = new BitSet(new long[]{0x0000000000200100L});
	public static final BitSet FOLLOW_ifBlockContentExpr_in_ifStatementExpr290 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_ifBlockContentExpr321 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifBlockContentExpr326 = new BitSet(new long[]{0x0000000000200102L});
	public static final BitSet FOLLOW_Int_in_primary365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_primary391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_primary418 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_orExpr_in_primary424 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_primary426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_unExpr456 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_unExpr472 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_unExpr488 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_unExpr_in_unExpr493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr544 = new BitSet(new long[]{0x0000001200000002L});
	public static final BitSet FOLLOW_33_in_mulExpr554 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_36_in_mulExpr559 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr566 = new BitSet(new long[]{0x0000001200000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr607 = new BitSet(new long[]{0x0000000C00000002L});
	public static final BitSet FOLLOW_34_in_addExpr616 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_35_in_addExpr621 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr627 = new BitSet(new long[]{0x0000000C00000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr662 = new BitSet(new long[]{0x000007C020000002L});
	public static final BitSet FOLLOW_38_in_relExpr671 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_39_in_relExpr674 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_41_in_relExpr677 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_42_in_relExpr680 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_40_in_relExpr684 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_29_in_relExpr688 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr694 = new BitSet(new long[]{0x000007C020000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr732 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_30_in_andExpr738 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr743 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr778 = new BitSet(new long[]{0x0000080000000002L});
	public static final BitSet FOLLOW_43_in_orExpr784 = new BitSet(new long[]{0x0000000C9020B010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr789 = new BitSet(new long[]{0x0000080000000002L});
}
