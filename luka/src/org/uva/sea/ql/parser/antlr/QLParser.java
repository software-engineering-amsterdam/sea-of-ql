// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 20:03:01

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
		"FormStart", "IF", "Ident", "Int", "Lbr", "Money", "Question", "QuestionId", 
		"Rbr", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", 
		"'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int Ident=9;
	public static final int Int=10;
	public static final int Lbr=11;
	public static final int Money=12;
	public static final int Question=13;
	public static final int QuestionId=14;
	public static final int Rbr=15;
	public static final int WS=16;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "qIdentifier", "synpred25_QL", "qValueCalcExpr", "synpred19_QL", 
		"andExpr", "synpred4_QL", "synpred24_QL", "synpred17_QL", "qStartExp", 
		"synpred12_QL", "mulExpr", "synpred3_QL", "synpred11_QL", "synpred5_QL", 
		"synpred8_QL", "synpred10_QL", "primary", "synpred15_QL", "synpred13_QL", 
		"questionnaireExpr", "synpred16_QL", "addExpr", "synpred9_QL", "qLabel", 
		"qType", "ifStatementExpr", "qStartQExpr", "synpred7_QL", "synpred26_QL", 
		"synpred20_QL", "synpred18_QL", "synpred14_QL", "synpred6_QL", "synpred21_QL", 
		"synpred1_QL", "synpred23_QL", "relExpr", "synpred2_QL", "orExpr", "synpred22_QL", 
		"unExpr", "parse", "qDeclaration"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false
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
		this.state.ruleMemo = new HashMap[43+1];


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
		this.state.ruleMemo = new HashMap[43+1];


		 
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
		public QuestionnaireForm root;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: parse returns [QuestionnaireForm root] : questionnaireExpr EOF !;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		CommonTree root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope questionnaireExpr1 =null;

		CommonTree EOF2_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(36, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:37:2: ( questionnaireExpr EOF !)
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:37:4: questionnaireExpr EOF !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(37,4);
			pushFollow(FOLLOW_questionnaireExpr_in_parse84);
			questionnaireExpr1=questionnaireExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, questionnaireExpr1.getTree());
			dbg.location(37,22);
			if ( state.backtracking==0 ) {retval.root = (questionnaireExpr1!=null?((QLParser.questionnaireExpr_return)questionnaireExpr1).root:null);}dbg.location(37,60);
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse88); if (state.failed) return retval;
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
		dbg.location(37, 61);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class questionnaireExpr_return extends ParserRuleReturnScope {
		public QuestionnaireForm root;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "questionnaireExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: questionnaireExpr returns [QuestionnaireForm root] : FormStart qStartExp ;
	public final QLParser.questionnaireExpr_return questionnaireExpr() throws RecognitionException {
		QLParser.questionnaireExpr_return retval = new QLParser.questionnaireExpr_return();
		retval.start = input.LT(1);
		int questionnaireExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token FormStart3=null;
		ParserRuleReturnScope qStartExp4 =null;

		CommonTree FormStart3_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "questionnaireExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(39, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:40:2: ( FormStart qStartExp )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:40:4: FormStart qStartExp
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(40,4);
			FormStart3=(Token)match(input,FormStart,FOLLOW_FormStart_in_questionnaireExpr104); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FormStart3_tree = (CommonTree)adaptor.create(FormStart3);
			adaptor.addChild(root_0, FormStart3_tree);
			}
			dbg.location(40,14);
			pushFollow(FOLLOW_qStartExp_in_questionnaireExpr106);
			qStartExp4=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qStartExp4.getTree());
			dbg.location(40,24);
			if ( state.backtracking==0 ) {retval.root = (qStartExp4!=null?((QLParser.qStartExp_return)qStartExp4).root:null);}
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
			if ( state.backtracking>0 ) { memoize(input, 2, questionnaireExpr_StartIndex); }

		}
		dbg.location(40, 50);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "questionnaireExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "questionnaireExpr"


	public static class qStartExp_return extends ParserRuleReturnScope {
		public QuestionnaireForm root;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qStartExp"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: qStartExp returns [QuestionnaireForm root] : FormId Lbr ! qStartQExpr Rbr !;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);
		int qStartExp_StartIndex = input.index();

		CommonTree root_0 = null;

		Token FormId5=null;
		Token Lbr6=null;
		Token Rbr8=null;
		ParserRuleReturnScope qStartQExpr7 =null;

		CommonTree FormId5_tree=null;
		CommonTree Lbr6_tree=null;
		CommonTree Rbr8_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qStartExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(43, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:45:2: ( FormId Lbr ! qStartQExpr Rbr !)
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:45:4: FormId Lbr ! qStartQExpr Rbr !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(45,4);
			FormId5=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp125); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FormId5_tree = (CommonTree)adaptor.create(FormId5);
			adaptor.addChild(root_0, FormId5_tree);
			}
			dbg.location(45,14);
			Lbr6=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp127); if (state.failed) return retval;dbg.location(45,16);
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp130);
			qStartQExpr7=qStartQExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qStartQExpr7.getTree());
			dbg.location(45,28);
			if ( state.backtracking==0 ) { retval.root = new QuestionnaireForm((FormId5!=null?FormId5.getText():null), new QuestionnaireContent((qStartQExpr7!=null?((QLParser.qStartQExpr_return)qStartQExpr7).result:null)));}dbg.location(45,126);
			Rbr8=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp134); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 3, qStartExp_StartIndex); }

		}
		dbg.location(45, 126);

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
		public List<QuestionnaireItemInterface> result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qStartQExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:1: qStartQExpr returns [List<QuestionnaireItemInterface> result] : ( qDeclaration | ifStatementExpr )* ;
	public final QLParser.qStartQExpr_return qStartQExpr() throws RecognitionException {
		QLParser.qStartQExpr_return retval = new QLParser.qStartQExpr_return();
		retval.start = input.LT(1);
		int qStartQExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qDeclaration9 =null;
		ParserRuleReturnScope ifStatementExpr10 =null;



			retval.result = new ArrayList<QuestionnaireItemInterface>();

		try { dbg.enterRule(getGrammarFileName(), "qStartQExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(48, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:2: ( ( qDeclaration | ifStatementExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:4: ( qDeclaration | ifStatementExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(52,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:4: ( qDeclaration | ifStatementExpr )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=3;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==QuestionId) ) {
					alt1=1;
				}
				else if ( (LA1_0==IF) ) {
					alt1=2;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: qDeclaration
					{
					dbg.location(52,5);
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr154);
					qDeclaration9=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration9.getTree());
					dbg.location(52,18);
					if ( state.backtracking==0 ) {retval.result.add((qDeclaration9!=null?((QLParser.qDeclaration_return)qDeclaration9).result:null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:57: ifStatementExpr
					{
					dbg.location(52,57);
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr160);
					ifStatementExpr10=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr10.getTree());
					dbg.location(52,73);
					if ( state.backtracking==0 ) {retval.result.add((ifStatementExpr10!=null?((QLParser.ifStatementExpr_return)ifStatementExpr10).result:null));}
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
			if ( state.backtracking>0 ) { memoize(input, 4, qStartQExpr_StartIndex); }

		}
		dbg.location(52, 113);

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
		public Question result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:1: qDeclaration returns [Question result] : i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr ) ;
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal11=null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope l =null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope e =null;

		CommonTree char_literal11_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:2: (i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:4: i= qIdentifier ':' l= qLabel (t= qType |t= qType e= qValueCalcExpr )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(55,5);
			pushFollow(FOLLOW_qIdentifier_in_qDeclaration180);
			i=qIdentifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());
			dbg.location(55,18);
			char_literal11=(Token)match(input,26,FOLLOW_26_in_qDeclaration182); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
			adaptor.addChild(root_0, char_literal11_tree);
			}
			dbg.location(55,24);
			pushFollow(FOLLOW_qLabel_in_qDeclaration187);
			l=qLabel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, l.getTree());
			dbg.location(55,32);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:32: (t= qType |t= qType e= qValueCalcExpr )
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Boolean) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==EOF||LA2_1==IF||(LA2_1 >= QuestionId && LA2_1 <= Rbr)) ) {
					alt2=1;
				}
				else if ( (LA2_1==20) ) {
					alt2=2;
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
			else if ( (LA2_0==Money) ) {
				int LA2_2 = input.LA(2);
				if ( (LA2_2==EOF||LA2_2==IF||(LA2_2 >= QuestionId && LA2_2 <= Rbr)) ) {
					alt2=1;
				}
				else if ( (LA2_2==20) ) {
					alt2=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
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
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:33: t= qType
					{
					dbg.location(55,35);
					pushFollow(FOLLOW_qType_in_qDeclaration193);
					t=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
					dbg.location(55,42);
					if ( state.backtracking==0 ) {retval.result = new Question((i!=null?input.toString(i.start,i.stop):null),(l!=null?input.toString(l.start,l.stop):null),(t!=null?((QLParser.qType_return)t).result:null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:96: t= qType e= qValueCalcExpr
					{
					dbg.location(55,97);
					pushFollow(FOLLOW_qType_in_qDeclaration201);
					t=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
					dbg.location(55,107);
					pushFollow(FOLLOW_qValueCalcExpr_in_qDeclaration206);
					e=qValueCalcExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
					dbg.location(55,123);
					if ( state.backtracking==0 ) {retval.result = new Question((i!=null?input.toString(i.start,i.stop):null),(l!=null?input.toString(l.start,l.stop):null),(t!=null?((QLParser.qType_return)t).result:null),(e!=null?((QLParser.qValueCalcExpr_return)e).result:null));}
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

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
			if ( state.backtracking>0 ) { memoize(input, 5, qDeclaration_StartIndex); }

		}
		dbg.location(55, 185);

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
		public IfBlock result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ifStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: ifStatementExpr returns [IfBlock result] : IF ! '(' !qId= qIdentifier ')' ! Lbr ! (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr !;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);
		int ifStatementExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token IF12=null;
		Token char_literal13=null;
		Token char_literal14=null;
		Token Lbr15=null;
		Token Rbr16=null;
		ParserRuleReturnScope qId =null;
		ParserRuleReturnScope qDecl =null;
		ParserRuleReturnScope ifStatem =null;

		CommonTree IF12_tree=null;
		CommonTree char_literal13_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree Lbr15_tree=null;
		CommonTree Rbr16_tree=null;


			List<QuestionnaireItemInterface> blockContent = new ArrayList<QuestionnaireItemInterface>();

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:2: ( IF ! '(' !qId= qIdentifier ')' ! Lbr ! (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr !)
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: IF ! '(' !qId= qIdentifier ')' ! Lbr ! (qDecl= qDeclaration |ifStatem= ifStatementExpr )+ Rbr !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(62,7);
			IF12=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr228); if (state.failed) return retval;dbg.location(62,12);
			char_literal13=(Token)match(input,20,FOLLOW_20_in_ifStatementExpr231); if (state.failed) return retval;dbg.location(62,17);
			pushFollow(FOLLOW_qIdentifier_in_ifStatementExpr236);
			qId=qIdentifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qId.getTree());
			dbg.location(62,33);
			char_literal14=(Token)match(input,21,FOLLOW_21_in_ifStatementExpr238); if (state.failed) return retval;dbg.location(62,38);
			Lbr15=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr241); if (state.failed) return retval;dbg.location(62,40);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:40: (qDecl= qDeclaration |ifStatem= ifStatementExpr )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=3;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==QuestionId) ) {
					alt3=1;
				}
				else if ( (LA3_0==IF) ) {
					alt3=2;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:42: qDecl= qDeclaration
					{
					dbg.location(62,48);
					pushFollow(FOLLOW_qDeclaration_in_ifStatementExpr249);
					qDecl=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDecl.getTree());
					dbg.location(62,62);
					if ( state.backtracking==0 ) {blockContent.add((qDecl!=null?((QLParser.qDeclaration_return)qDecl).result:null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:99: ifStatem= ifStatementExpr
					{
					dbg.location(62,108);
					pushFollow(FOLLOW_ifStatementExpr_in_ifStatementExpr259);
					ifStatem=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatem.getTree());
					dbg.location(62,126);
					if ( state.backtracking==0 ) {blockContent.add((ifStatem!=null?((QLParser.ifStatementExpr_return)ifStatem).result:null));}
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
			dbg.location(62,166);
			if ( state.backtracking==0 ) {retval.result = new IfBlock((qId!=null?input.toString(qId.start,qId.stop):null),blockContent);}dbg.location(62,218);
			Rbr16=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr267); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 6, ifStatementExpr_StartIndex); }

		}
		dbg.location(62, 219);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatementExpr"


	public static class qValueCalcExpr_return extends ParserRuleReturnScope {
		public Expr result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qValueCalcExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: qValueCalcExpr returns [Expr result] : '(' ! orExpr ')' !;
	public final QLParser.qValueCalcExpr_return qValueCalcExpr() throws RecognitionException {
		QLParser.qValueCalcExpr_return retval = new QLParser.qValueCalcExpr_return();
		retval.start = input.LT(1);
		int qValueCalcExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal17=null;
		Token char_literal19=null;
		ParserRuleReturnScope orExpr18 =null;

		CommonTree char_literal17_tree=null;
		CommonTree char_literal19_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qValueCalcExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(65, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:2: ( '(' ! orExpr ')' !)
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: '(' ! orExpr ')' !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(66,8);
			char_literal17=(Token)match(input,20,FOLLOW_20_in_qValueCalcExpr285); if (state.failed) return retval;dbg.location(66,10);
			pushFollow(FOLLOW_orExpr_in_qValueCalcExpr288);
			orExpr18=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpr18.getTree());
			dbg.location(66,20);
			char_literal19=(Token)match(input,21,FOLLOW_21_in_qValueCalcExpr290); if (state.failed) return retval;dbg.location(66,22);
			if ( state.backtracking==0 ) {retval.result = new ValueExpr((orExpr18!=null?((QLParser.orExpr_return)orExpr18).result:null));}
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
			if ( state.backtracking>0 ) { memoize(input, 7, qValueCalcExpr_StartIndex); }

		}
		dbg.location(66, 63);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qValueCalcExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qValueCalcExpr"


	public static class qIdentifier_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qIdentifier"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: qIdentifier : QuestionId ;
	public final QLParser.qIdentifier_return qIdentifier() throws RecognitionException {
		QLParser.qIdentifier_return retval = new QLParser.qIdentifier_return();
		retval.start = input.LT(1);
		int qIdentifier_StartIndex = input.index();

		CommonTree root_0 = null;

		Token QuestionId20=null;

		CommonTree QuestionId20_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qIdentifier");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(69, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:13: ( QuestionId )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:15: QuestionId
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(69,15);
			QuestionId20=(Token)match(input,QuestionId,FOLLOW_QuestionId_in_qIdentifier304); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QuestionId20_tree = (CommonTree)adaptor.create(QuestionId20);
			adaptor.addChild(root_0, QuestionId20_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 8, qIdentifier_StartIndex); }

		}
		dbg.location(69, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qIdentifier");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qIdentifier"


	public static class qLabel_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qLabel"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: qLabel : Question ;
	public final QLParser.qLabel_return qLabel() throws RecognitionException {
		QLParser.qLabel_return retval = new QLParser.qLabel_return();
		retval.start = input.LT(1);
		int qLabel_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Question21=null;

		CommonTree Question21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qLabel");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:8: ( Question )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:10: Question
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(71,10);
			Question21=(Token)match(input,Question,FOLLOW_Question_in_qLabel314); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Question21_tree = (CommonTree)adaptor.create(Question21);
			adaptor.addChild(root_0, Question21_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 9, qLabel_StartIndex); }

		}
		dbg.location(71, 17);

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
		public QuestionType result;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: qType returns [QuestionType result] : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Boolean22=null;
		Token Money23=null;

		CommonTree Boolean22_tree=null;
		CommonTree Money23_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(73, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:2: ( Boolean | Money )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==Boolean) ) {
				alt4=1;
			}
			else if ( (LA4_0==Money) ) {
				alt4=2;
			}

			else {
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:4: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(74,4);
					Boolean22=(Token)match(input,Boolean,FOLLOW_Boolean_in_qType327); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean22_tree = (CommonTree)adaptor.create(Boolean22);
					adaptor.addChild(root_0, Boolean22_tree);
					}
					dbg.location(74,12);
					if ( state.backtracking==0 ) {retval.result = QuestionType.BOOL;}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:45: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(74,45);
					Money23=(Token)match(input,Money,FOLLOW_Money_in_qType333); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money23_tree = (CommonTree)adaptor.create(Money23);
					adaptor.addChild(root_0, Money23_tree);
					}
					dbg.location(74,51);
					if ( state.backtracking==0 ) {retval.result = QuestionType.MONEY;}
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
			if ( state.backtracking>0 ) { memoize(input, 10, qType_StartIndex); }

		}
		dbg.location(74, 81);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionId | Money | '(' x= orExpr ')' );
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Int24=null;
		Token Ident25=null;
		Token Boolean26=null;
		Token QuestionId27=null;
		Token Money28=null;
		Token char_literal29=null;
		Token char_literal30=null;
		ParserRuleReturnScope x =null;

		CommonTree Int24_tree=null;
		CommonTree Ident25_tree=null;
		CommonTree Boolean26_tree=null;
		CommonTree QuestionId27_tree=null;
		CommonTree Money28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree char_literal30_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(77, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:3: ( Int | Ident | Boolean | QuestionId | Money | '(' x= orExpr ')' )
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
			case QuestionId:
				{
				alt5=4;
				}
				break;
			case Money:
				{
				alt5=5;
				}
				break;
			case 20:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(78,5);
					Int24=(Token)match(input,Int,FOLLOW_Int_in_primary351); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int24_tree = (CommonTree)adaptor.create(Int24);
					adaptor.addChild(root_0, Int24_tree);
					}
					dbg.location(78,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int24!=null?Int24.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(79,5);
					Ident25=(Token)match(input,Ident,FOLLOW_Ident_in_primary361); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident25_tree = (CommonTree)adaptor.create(Ident25);
					adaptor.addChild(root_0, Ident25_tree);
					}
					dbg.location(79,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident25!=null?Ident25.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(81,5);
					Boolean26=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary372); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean26_tree = (CommonTree)adaptor.create(Boolean26);
					adaptor.addChild(root_0, Boolean26_tree);
					}
					dbg.location(81,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean26!=null?Boolean26.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: QuestionId
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(82,5);
					QuestionId27=(Token)match(input,QuestionId,FOLLOW_QuestionId_in_primary380); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QuestionId27_tree = (CommonTree)adaptor.create(QuestionId27);
					adaptor.addChild(root_0, QuestionId27_tree);
					}
					dbg.location(82,16);
					if ( state.backtracking==0 ) {retval.result = null;}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(83,5);
					Money28=(Token)match(input,Money,FOLLOW_Money_in_primary388); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money28_tree = (CommonTree)adaptor.create(Money28);
					adaptor.addChild(root_0, Money28_tree);
					}
					dbg.location(83,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money28!=null?Money28.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: '(' x= orExpr ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(85,5);
					char_literal29=(Token)match(input,20,FOLLOW_20_in_primary399); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal29_tree = (CommonTree)adaptor.create(char_literal29);
					adaptor.addChild(root_0, char_literal29_tree);
					}
					dbg.location(85,10);
					pushFollow(FOLLOW_orExpr_in_primary403);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(85,18);
					char_literal30=(Token)match(input,21,FOLLOW_21_in_primary405); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
					adaptor.addChild(root_0, char_literal30_tree);
					}
					dbg.location(85,21);
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
			if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

		}
		dbg.location(86, 2);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal31=null;
		Token char_literal32=null;
		Token char_literal33=null;
		ParserRuleReturnScope x =null;

		CommonTree char_literal31_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree char_literal33_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt6=4;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			switch ( input.LA(1) ) {
			case 23:
				{
				alt6=1;
				}
				break;
			case 24:
				{
				alt6=2;
				}
				break;
			case 17:
				{
				alt6=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionId:
			case 20:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(90,11);
					char_literal31=(Token)match(input,23,FOLLOW_23_in_unExpr431); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal31_tree = (CommonTree)adaptor.create(char_literal31);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal31_tree, root_0);
					}
					dbg.location(90,14);
					pushFollow(FOLLOW_unExpr_in_unExpr436);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(90,22);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(91,11);
					char_literal32=(Token)match(input,24,FOLLOW_24_in_unExpr447); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal32_tree, root_0);
					}
					dbg.location(91,14);
					pushFollow(FOLLOW_unExpr_in_unExpr452);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(91,22);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(92,11);
					char_literal33=(Token)match(input,17,FOLLOW_17_in_unExpr463); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal33_tree, root_0);
					}
					dbg.location(92,14);
					pushFollow(FOLLOW_unExpr_in_unExpr468);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(92,22);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(93,9);
					pushFollow(FOLLOW_primary_in_unExpr481);
					x=primary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(93,21);
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
			if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

		}
		dbg.location(94, 4);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )* ;
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
		dbg.location(96, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: (lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:9: lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(97,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr519);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(97,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(97,45);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:45: (op= ( '*' ^| '/' ) rhs= unExpr )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==22||LA8_0==25) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:47: op= ( '*' ^| '/' ) rhs= unExpr
					{
					dbg.location(97,49);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:50: ( '*' ^| '/' )
					int alt7=2;
					try { dbg.enterSubRule(7);
					try { dbg.enterDecision(7, decisionCanBacktrack[7]);

					int LA7_0 = input.LA(1);
					if ( (LA7_0==22) ) {
						alt7=1;
					}
					else if ( (LA7_0==25) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:52: '*' ^
							{
							dbg.location(97,55);
							op=(Token)match(input,22,FOLLOW_22_in_mulExpr529); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:59: '/'
							{
							dbg.location(97,59);
							op=(Token)match(input,25,FOLLOW_25_in_mulExpr534); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							adaptor.addChild(root_0, op_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(7);}
					dbg.location(97,68);
					pushFollow(FOLLOW_unExpr_in_mulExpr540);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(98,5);
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
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		dbg.location(106, 4);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(109, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(110,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr581);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(110,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(110,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 23 && LA10_0 <= 24)) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(110,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:51: ( '+' ^| '-' ^)
					int alt9=2;
					try { dbg.enterSubRule(9);
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( (LA9_0==23) ) {
						alt9=1;
					}
					else if ( (LA9_0==24) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:52: '+' ^
							{
							dbg.location(110,55);
							op=(Token)match(input,23,FOLLOW_23_in_addExpr590); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:59: '-' ^
							{
							dbg.location(110,62);
							op=(Token)match(input,24,FOLLOW_24_in_addExpr595); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(9);}
					dbg.location(110,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr601);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(111,5);
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
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		dbg.location(119, 4);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(121, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(122,12);
			pushFollow(FOLLOW_addExpr_in_relExpr636);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(122,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(122,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==18||(LA12_0 >= 27 && LA12_0 <= 31)) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(122,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt11=6;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					switch ( input.LA(1) ) {
					case 27:
						{
						alt11=1;
						}
						break;
					case 28:
						{
						alt11=2;
						}
						break;
					case 30:
						{
						alt11=3;
						}
						break;
					case 31:
						{
						alt11=4;
						}
						break;
					case 29:
						{
						alt11=5;
						}
						break;
					case 18:
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:52: '<' ^
							{
							dbg.location(122,55);
							op=(Token)match(input,27,FOLLOW_27_in_relExpr645); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:57: '<=' ^
							{
							dbg.location(122,61);
							op=(Token)match(input,28,FOLLOW_28_in_relExpr648); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:63: '>' ^
							{
							dbg.location(122,66);
							op=(Token)match(input,30,FOLLOW_30_in_relExpr651); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:68: '>=' ^
							{
							dbg.location(122,72);
							op=(Token)match(input,31,FOLLOW_31_in_relExpr654); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:75: '==' ^
							{
							dbg.location(122,79);
							op=(Token)match(input,29,FOLLOW_29_in_relExpr658); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:82: '!=' ^
							{
							dbg.location(122,86);
							op=(Token)match(input,18,FOLLOW_18_in_relExpr662); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(11);}
					dbg.location(122,92);
					pushFollow(FOLLOW_addExpr_in_relExpr668);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(123,5);
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
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		dbg.location(143, 4);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:145:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal34=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal34_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(145, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:146:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:146:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(146,12);
			pushFollow(FOLLOW_relExpr_in_andExpr706);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(146,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(146,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:146:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==19) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:146:48: '&&' ^rhs= relExpr
					{
					dbg.location(146,52);
					string_literal34=(Token)match(input,19,FOLLOW_19_in_andExpr712); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);
					}
					dbg.location(146,57);
					pushFollow(FOLLOW_relExpr_in_andExpr717);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(146,66);
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
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		dbg.location(147, 4);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal35=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal35_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(150, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:151:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:151:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(151,12);
			pushFollow(FOLLOW_andExpr_in_orExpr752);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(151,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(151,48);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:151:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==32) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:151:50: '||' ^rhs= andExpr
					{
					dbg.location(151,54);
					string_literal35=(Token)match(input,32,FOLLOW_32_in_orExpr758); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal35_tree = (CommonTree)adaptor.create(string_literal35);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal35_tree, root_0);
					}
					dbg.location(151,59);
					pushFollow(FOLLOW_andExpr_in_orExpr763);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(151,68);
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
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		dbg.location(152, 4);

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



	public static final BitSet FOLLOW_questionnaireExpr_in_parse84 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormStart_in_questionnaireExpr104 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_questionnaireExpr106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp125 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp127 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp130 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr154 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr160 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_qIdentifier_in_qDeclaration180 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_qDeclaration182 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_qLabel_in_qDeclaration187 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qType_in_qDeclaration201 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_qValueCalcExpr_in_qDeclaration206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr228 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_ifStatementExpr231 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_qIdentifier_in_ifStatementExpr236 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_ifStatementExpr238 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr241 = new BitSet(new long[]{0x0000000000004100L});
	public static final BitSet FOLLOW_qDeclaration_in_ifStatementExpr249 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifStatementExpr259 = new BitSet(new long[]{0x000000000000C100L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_qValueCalcExpr285 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_orExpr_in_qValueCalcExpr288 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_qValueCalcExpr290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_qIdentifier304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Question_in_qLabel314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_qType327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_qType333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_primary380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_primary399 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_orExpr_in_primary403 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_primary405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_unExpr431 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpr447 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_unExpr463 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_unExpr_in_unExpr468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr519 = new BitSet(new long[]{0x0000000002400002L});
	public static final BitSet FOLLOW_22_in_mulExpr529 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_25_in_mulExpr534 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr540 = new BitSet(new long[]{0x0000000002400002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr581 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_23_in_addExpr590 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_24_in_addExpr595 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr601 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr636 = new BitSet(new long[]{0x00000000F8040002L});
	public static final BitSet FOLLOW_27_in_relExpr645 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_28_in_relExpr648 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_30_in_relExpr651 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_31_in_relExpr654 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_29_in_relExpr658 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_18_in_relExpr662 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_addExpr_in_relExpr668 = new BitSet(new long[]{0x00000000F8040002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr706 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19_in_andExpr712 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_relExpr_in_andExpr717 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr752 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr758 = new BitSet(new long[]{0x0000000001925610L});
	public static final BitSet FOLLOW_andExpr_in_orExpr763 = new BitSet(new long[]{0x0000000100000002L});
}
