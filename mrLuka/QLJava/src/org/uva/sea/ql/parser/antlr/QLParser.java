// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-18 19:26:06

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
		"ROOT", "Rbr", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int ROOT=15;
	public static final int Rbr=16;
	public static final int WS=17;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred26_QL", "synpred5_QL", "synpred4_QL", "synpred8_QL", 
		"synpred17_QL", "synpred12_QL", "synpred27_QL", "andExpr", "synpred16_QL", 
		"synpred19_QL", "unExpr", "addExpr", "synpred7_QL", "qType", "synpred1_QL", 
		"synpred22_QL", "questionnaireExpr", "qStartExp", "synpred10_QL", "synpred2_QL", 
		"qStartQExpr", "synpred9_QL", "parse", "qVarExpr", "synpred23_QL", "relExpr", 
		"uQExpr", "qCalcExpr", "synpred20_QL", "ifStatementExpr", "synpred21_QL", 
		"synpred15_QL", "synpred3_QL", "qDeclaration", "orExpr", "synpred25_QL", 
		"mulExpr", "synpred24_QL", "synpred13_QL", "synpred18_QL", "primary", 
		"synpred14_QL", "synpred11_QL", "synpred6_QL"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false
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
		this.state.ruleMemo = new HashMap[44+1];


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
		this.state.ruleMemo = new HashMap[44+1];


		 
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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: parse : questionnaireExpr EOF ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope questionnaireExpr1 =null;

		Object EOF2_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:2: ( questionnaireExpr EOF )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:4: questionnaireExpr EOF
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(38,4);
			pushFollow(FOLLOW_questionnaireExpr_in_parse80);
			questionnaireExpr1=questionnaireExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, questionnaireExpr1.getTree());
			dbg.location(38,22);
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_parse82); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF2_tree = (Object)adaptor.create(EOF2);
			adaptor.addChild(root_0, EOF2_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

		}
		dbg.location(38, 25);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "questionnaireExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:1: questionnaireExpr : FormStart qStartExp ;
	public final QLParser.questionnaireExpr_return questionnaireExpr() throws RecognitionException {
		QLParser.questionnaireExpr_return retval = new QLParser.questionnaireExpr_return();
		retval.start = input.LT(1);
		int questionnaireExpr_StartIndex = input.index();

		Object root_0 = null;

		Token FormStart3=null;
		ParserRuleReturnScope qStartExp4 =null;

		Object FormStart3_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "questionnaireExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(40, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:2: ( FormStart qStartExp )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:41:4: FormStart qStartExp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(41,4);
			FormStart3=(Token)match(input,FormStart,FOLLOW_FormStart_in_questionnaireExpr93); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FormStart3_tree = (Object)adaptor.create(FormStart3);
			adaptor.addChild(root_0, FormStart3_tree);
			}
			dbg.location(41,14);
			pushFollow(FOLLOW_qStartExp_in_questionnaireExpr95);
			qStartExp4=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qStartExp4.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, questionnaireExpr_StartIndex); }

		}
		dbg.location(41, 22);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qStartExp"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:1: qStartExp : FormId Lbr qStartQExpr Rbr ;
	public final QLParser.qStartExp_return qStartExp() throws RecognitionException {
		QLParser.qStartExp_return retval = new QLParser.qStartExp_return();
		retval.start = input.LT(1);
		int qStartExp_StartIndex = input.index();

		Object root_0 = null;

		Token FormId5=null;
		Token Lbr6=null;
		Token Rbr8=null;
		ParserRuleReturnScope qStartQExpr7 =null;

		Object FormId5_tree=null;
		Object Lbr6_tree=null;
		Object Rbr8_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qStartExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(43, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:2: ( FormId Lbr qStartQExpr Rbr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: FormId Lbr qStartQExpr Rbr
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(44,4);
			FormId5=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp106); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FormId5_tree = (Object)adaptor.create(FormId5);
			adaptor.addChild(root_0, FormId5_tree);
			}
			dbg.location(44,11);
			Lbr6=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp108); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Lbr6_tree = (Object)adaptor.create(Lbr6);
			adaptor.addChild(root_0, Lbr6_tree);
			}
			dbg.location(44,15);
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp110);
			qStartQExpr7=qStartQExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qStartQExpr7.getTree());
			dbg.location(44,27);
			Rbr8=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp112); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Rbr8_tree = (Object)adaptor.create(Rbr8);
			adaptor.addChild(root_0, Rbr8_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, qStartExp_StartIndex); }

		}
		dbg.location(44, 29);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qStartQExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: qStartQExpr : ( qDeclaration | ifStatementExpr )* ;
	public final QLParser.qStartQExpr_return qStartQExpr() throws RecognitionException {
		QLParser.qStartQExpr_return retval = new QLParser.qStartQExpr_return();
		retval.start = input.LT(1);
		int qStartQExpr_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope qDeclaration9 =null;
		ParserRuleReturnScope ifStatementExpr10 =null;


		try { dbg.enterRule(getGrammarFileName(), "qStartQExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(47, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:12: ( ( qDeclaration | ifStatementExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:14: ( qDeclaration | ifStatementExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(47,14);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:14: ( qDeclaration | ifStatementExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:15: qDeclaration
					{
					dbg.location(47,15);
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr121);
					qDeclaration9=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration9.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:30: ifStatementExpr
					{
					dbg.location(47,30);
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr125);
					ifStatementExpr10=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr10.getTree());

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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, qStartQExpr_StartIndex); }

		}
		dbg.location(47, 46);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qStartQExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qStartQExpr"


	public static class ifStatementExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: ifStatementExpr : IF '(' Ident ')' Lbr ( qDeclaration | ifStatementExpr )+ Rbr ;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);
		int ifStatementExpr_StartIndex = input.index();

		Object root_0 = null;

		Token IF11=null;
		Token char_literal12=null;
		Token Ident13=null;
		Token char_literal14=null;
		Token Lbr15=null;
		Token Rbr18=null;
		ParserRuleReturnScope qDeclaration16 =null;
		ParserRuleReturnScope ifStatementExpr17 =null;

		Object IF11_tree=null;
		Object char_literal12_tree=null;
		Object Ident13_tree=null;
		Object char_literal14_tree=null;
		Object Lbr15_tree=null;
		Object Rbr18_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(49, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:2: ( IF '(' Ident ')' Lbr ( qDeclaration | ifStatementExpr )+ Rbr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:5: IF '(' Ident ')' Lbr ( qDeclaration | ifStatementExpr )+ Rbr
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(50,5);
			IF11=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr137); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IF11_tree = (Object)adaptor.create(IF11);
			adaptor.addChild(root_0, IF11_tree);
			}
			dbg.location(50,8);
			char_literal12=(Token)match(input,21,FOLLOW_21_in_ifStatementExpr139); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal12_tree = (Object)adaptor.create(char_literal12);
			adaptor.addChild(root_0, char_literal12_tree);
			}
			dbg.location(50,12);
			Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_ifStatementExpr141); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Ident13_tree = (Object)adaptor.create(Ident13);
			adaptor.addChild(root_0, Ident13_tree);
			}
			dbg.location(50,18);
			char_literal14=(Token)match(input,22,FOLLOW_22_in_ifStatementExpr143); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal14_tree = (Object)adaptor.create(char_literal14);
			adaptor.addChild(root_0, char_literal14_tree);
			}
			dbg.location(50,22);
			Lbr15=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr145); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Lbr15_tree = (Object)adaptor.create(Lbr15);
			adaptor.addChild(root_0, Lbr15_tree);
			}
			dbg.location(50,26);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:26: ( qDeclaration | ifStatementExpr )+
			int cnt2=0;
			try { dbg.enterSubRule(2);

			loop2:
			while (true) {
				int alt2=3;
				try { dbg.enterDecision(2, decisionCanBacktrack[2]);

				int LA2_0 = input.LA(1);
				if ( (LA2_0==QuestionId) ) {
					alt2=1;
				}
				else if ( (LA2_0==IF) ) {
					alt2=2;
				}

				} finally {dbg.exitDecision(2);}

				switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:27: qDeclaration
					{
					dbg.location(50,27);
					pushFollow(FOLLOW_qDeclaration_in_ifStatementExpr148);
					qDeclaration16=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration16.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:50:42: ifStatementExpr
					{
					dbg.location(50,42);
					pushFollow(FOLLOW_ifStatementExpr_in_ifStatementExpr152);
					ifStatementExpr17=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr17.getTree());

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(2, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt2++;
			}
			} finally {dbg.exitSubRule(2);}
			dbg.location(50,60);
			Rbr18=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr156); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Rbr18_tree = (Object)adaptor.create(Rbr18);
			adaptor.addChild(root_0, Rbr18_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, ifStatementExpr_StartIndex); }

		}
		dbg.location(50, 63);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatementExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatementExpr"


	public static class qDeclaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: qDeclaration : qVarExpr uQExpr ( qType | qCalcExpr )+ ;
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope qVarExpr19 =null;
		ParserRuleReturnScope uQExpr20 =null;
		ParserRuleReturnScope qType21 =null;
		ParserRuleReturnScope qCalcExpr22 =null;


		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(52, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:2: ( qVarExpr uQExpr ( qType | qCalcExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: qVarExpr uQExpr ( qType | qCalcExpr )+
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(53,4);
			pushFollow(FOLLOW_qVarExpr_in_qDeclaration168);
			qVarExpr19=qVarExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qVarExpr19.getTree());
			dbg.location(53,13);
			pushFollow(FOLLOW_uQExpr_in_qDeclaration170);
			uQExpr20=uQExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, uQExpr20.getTree());
			dbg.location(53,20);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:20: ( qType | qCalcExpr )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=3;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==Boolean||LA3_0==Money) ) {
					int LA3_2 = input.LA(2);
					if ( (LA3_2==EOF||LA3_2==Boolean||LA3_2==IF||LA3_2==Money||LA3_2==QuestionId||LA3_2==Rbr) ) {
						alt3=1;
					}
					else if ( (LA3_2==21) ) {
						alt3=2;
					}

				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:21: qType
					{
					dbg.location(53,21);
					pushFollow(FOLLOW_qType_in_qDeclaration173);
					qType21=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qType21.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:29: qCalcExpr
					{
					dbg.location(53,29);
					pushFollow(FOLLOW_qCalcExpr_in_qDeclaration177);
					qCalcExpr22=qCalcExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qCalcExpr22.getTree());

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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, qDeclaration_StartIndex); }

		}
		dbg.location(53, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qDeclaration"


	public static class qCalcExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qCalcExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: qCalcExpr : qType '(' Ident ( '-' | '+' | '*' ) Ident ')' ;
	public final QLParser.qCalcExpr_return qCalcExpr() throws RecognitionException {
		QLParser.qCalcExpr_return retval = new QLParser.qCalcExpr_return();
		retval.start = input.LT(1);
		int qCalcExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal24=null;
		Token Ident25=null;
		Token set26=null;
		Token Ident27=null;
		Token char_literal28=null;
		ParserRuleReturnScope qType23 =null;

		Object char_literal24_tree=null;
		Object Ident25_tree=null;
		Object set26_tree=null;
		Object Ident27_tree=null;
		Object char_literal28_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qCalcExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(55, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:2: ( qType '(' Ident ( '-' | '+' | '*' ) Ident ')' )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: qType '(' Ident ( '-' | '+' | '*' ) Ident ')'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(56,4);
			pushFollow(FOLLOW_qType_in_qCalcExpr189);
			qType23=qType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, qType23.getTree());
			dbg.location(56,10);
			char_literal24=(Token)match(input,21,FOLLOW_21_in_qCalcExpr191); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal24_tree = (Object)adaptor.create(char_literal24);
			adaptor.addChild(root_0, char_literal24_tree);
			}
			dbg.location(56,13);
			Ident25=(Token)match(input,Ident,FOLLOW_Ident_in_qCalcExpr192); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Ident25_tree = (Object)adaptor.create(Ident25);
			adaptor.addChild(root_0, Ident25_tree);
			}
			dbg.location(56,19);
			set26=input.LT(1);
			if ( (input.LA(1) >= 23 && input.LA(1) <= 25) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set26));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(56,36);
			Ident27=(Token)match(input,Ident,FOLLOW_Ident_in_qCalcExpr205); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Ident27_tree = (Object)adaptor.create(Ident27);
			adaptor.addChild(root_0, Ident27_tree);
			}
			dbg.location(56,42);
			char_literal28=(Token)match(input,22,FOLLOW_22_in_qCalcExpr207); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal28_tree = (Object)adaptor.create(char_literal28);
			adaptor.addChild(root_0, char_literal28_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, qCalcExpr_StartIndex); }

		}
		dbg.location(56, 44);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qCalcExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qCalcExpr"


	public static class qVarExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qVarExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: qVarExpr : QuestionId ;
	public final QLParser.qVarExpr_return qVarExpr() throws RecognitionException {
		QLParser.qVarExpr_return retval = new QLParser.qVarExpr_return();
		retval.start = input.LT(1);
		int qVarExpr_StartIndex = input.index();

		Object root_0 = null;

		Token QuestionId29=null;

		Object QuestionId29_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qVarExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:10: ( QuestionId )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:12: QuestionId
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(58,12);
			QuestionId29=(Token)match(input,QuestionId,FOLLOW_QuestionId_in_qVarExpr215); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QuestionId29_tree = (Object)adaptor.create(QuestionId29);
			adaptor.addChild(root_0, QuestionId29_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, qVarExpr_StartIndex); }

		}
		dbg.location(58, 21);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qVarExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qVarExpr"


	public static class uQExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "uQExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:1: uQExpr : Question ;
	public final QLParser.uQExpr_return uQExpr() throws RecognitionException {
		QLParser.uQExpr_return retval = new QLParser.uQExpr_return();
		retval.start = input.LT(1);
		int uQExpr_StartIndex = input.index();

		Object root_0 = null;

		Token Question30=null;

		Object Question30_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "uQExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(60, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:8: ( Question )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:10: Question
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(60,10);
			Question30=(Token)match(input,Question,FOLLOW_Question_in_uQExpr224); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Question30_tree = (Object)adaptor.create(Question30);
			adaptor.addChild(root_0, Question30_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, uQExpr_StartIndex); }

		}
		dbg.location(60, 17);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "uQExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "uQExpr"


	public static class qType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		Object root_0 = null;

		Token set31=null;

		Object set31_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:7: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(62,7);
			set31=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set31));
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, qType_StartIndex); }

		}
		dbg.location(62, 23);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "primary"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: primary returns [Expr result] : ( Int | Ident | Question | '(' x= orExpr ')' );
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		Object root_0 = null;

		Token Int32=null;
		Token Ident33=null;
		Token Question34=null;
		Token char_literal35=null;
		Token char_literal36=null;
		ParserRuleReturnScope x =null;

		Object Int32_tree=null;
		Object Ident33_tree=null;
		Object Question34_tree=null;
		Object char_literal35_tree=null;
		Object char_literal36_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(65, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:3: ( Int | Ident | Question | '(' x= orExpr ')' )
			int alt4=4;
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
			case Question:
				{
				alt4=3;
				}
				break;
			case 21:
				{
				alt4=4;
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

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: Int
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(66,5);
					Int32=(Token)match(input,Int,FOLLOW_Int_in_primary252); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int32_tree = (Object)adaptor.create(Int32);
					adaptor.addChild(root_0, Int32_tree);
					}
					dbg.location(66,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int32!=null?Int32.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(67,5);
					Ident33=(Token)match(input,Ident,FOLLOW_Ident_in_primary262); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident33_tree = (Object)adaptor.create(Ident33);
					adaptor.addChild(root_0, Ident33_tree);
					}
					dbg.location(67,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident33!=null?Ident33.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:5: Question
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(68,5);
					Question34=(Token)match(input,Question,FOLLOW_Question_in_primary270); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Question34_tree = (Object)adaptor.create(Question34);
					adaptor.addChild(root_0, Question34_tree);
					}
					dbg.location(68,14);
					if ( state.backtracking==0 ) {retval.result = new Question((Question34!=null?Question34.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: '(' x= orExpr ')'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(69,5);
					char_literal35=(Token)match(input,21,FOLLOW_21_in_primary278); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal35_tree = (Object)adaptor.create(char_literal35);
					adaptor.addChild(root_0, char_literal35_tree);
					}
					dbg.location(69,10);
					pushFollow(FOLLOW_orExpr_in_primary282);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(69,18);
					char_literal36=(Token)match(input,22,FOLLOW_22_in_primary284); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal36_tree = (Object)adaptor.create(char_literal36);
					adaptor.addChild(root_0, char_literal36_tree);
					}
					dbg.location(69,21);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, primary_StartIndex); }

		}
		dbg.location(70, 2);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal37=null;
		Token char_literal38=null;
		Token char_literal39=null;
		ParserRuleReturnScope x =null;

		Object char_literal37_tree=null;
		Object char_literal38_tree=null;
		Object char_literal39_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 24:
				{
				alt5=1;
				}
				break;
			case 25:
				{
				alt5=2;
				}
				break;
			case 18:
				{
				alt5=3;
				}
				break;
			case Ident:
			case Int:
			case Question:
			case 21:
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

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:8: '+' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(73,8);
					char_literal37=(Token)match(input,24,FOLLOW_24_in_unExpr307); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal37_tree = (Object)adaptor.create(char_literal37);
					adaptor.addChild(root_0, char_literal37_tree);
					}
					dbg.location(73,13);
					pushFollow(FOLLOW_unExpr_in_unExpr311);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(73,21);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:74:8: '-' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(74,8);
					char_literal38=(Token)match(input,25,FOLLOW_25_in_unExpr322); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal38_tree = (Object)adaptor.create(char_literal38);
					adaptor.addChild(root_0, char_literal38_tree);
					}
					dbg.location(74,13);
					pushFollow(FOLLOW_unExpr_in_unExpr326);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(74,21);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:75:8: '!' x= unExpr
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(75,8);
					char_literal39=(Token)match(input,18,FOLLOW_18_in_unExpr337); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal39_tree = (Object)adaptor.create(char_literal39);
					adaptor.addChild(root_0, char_literal39_tree);
					}
					dbg.location(75,13);
					pushFollow(FOLLOW_unExpr_in_unExpr341);
					x=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(75,21);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.primary_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:76:8: x= primary
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(76,9);
					pushFollow(FOLLOW_primary_in_unExpr354);
					x=primary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(76,21);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.primary_return)x).result:null); }
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, unExpr_StartIndex); }

		}
		dbg.location(77, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);
		int mulExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "mulExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(80,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr392);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(80,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(80,45);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:45: (op= ( '*' | '/' ) rhs= unExpr )*
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( (LA6_0==23||LA6_0==26) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:47: op= ( '*' | '/' ) rhs= unExpr
					{
					dbg.location(80,49);
					op=input.LT(1);
					if ( input.LA(1)==23||input.LA(1)==26 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(80,67);
					pushFollow(FOLLOW_unExpr_in_mulExpr412);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(81,5);
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("*")) {
					        retval.result = new Mul(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new Div(retval.result, rhs);      
					      }
					    }
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

		}
		dbg.location(89, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);
		int addExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(92, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(93,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr453);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(93,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(93,46);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:46: (op= ( '+' | '-' ) rhs= mulExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= 24 && LA7_0 <= 25)) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:93:48: op= ( '+' | '-' ) rhs= mulExpr
					{
					dbg.location(93,50);
					op=input.LT(1);
					if ( (input.LA(1) >= 24 && input.LA(1) <= 25) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(93,66);
					pushFollow(FOLLOW_mulExpr_in_addExpr471);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(94,5);
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("+")) {
					        retval.result = new Add(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
					        retval.result = new Sub(retval.result, rhs);      
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

		}
		dbg.location(102, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);
		int relExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "relExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(104, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(105,12);
			pushFollow(FOLLOW_addExpr_in_relExpr506);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(105,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(105,46);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==19||(LA8_0 >= 27 && LA8_0 <= 31)) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
					{
					dbg.location(105,50);
					op=input.LT(1);
					if ( input.LA(1)==19||(input.LA(1) >= 27 && input.LA(1) <= 31) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(op));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(105,84);
					pushFollow(FOLLOW_addExpr_in_relExpr530);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(106,5);
					if ( state.backtracking==0 ) { 
					      if ((op!=null?op.getText():null).equals("<")) {
					        retval.result = new LT(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
					        retval.result = new LEq(retval.result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals(">")) {
					        retval.result = new GT(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals(">=")) {
					        retval.result = new GEq(retval.result, rhs);      
					      }
					      if ((op!=null?op.getText():null).equals("==")) {
					        retval.result = new Eq(retval.result, rhs);
					      }
					      if ((op!=null?op.getText():null).equals("!=")) {
					        retval.result = new NEq(retval.result, rhs);
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

		}
		dbg.location(126, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:128:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal40=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(128, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:9: lhs= relExpr ( '&&' rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(129,12);
			pushFollow(FOLLOW_relExpr_in_andExpr568);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(129,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(129,46);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:46: ( '&&' rhs= relExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==20) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:129:48: '&&' rhs= relExpr
					{
					dbg.location(129,48);
					string_literal40=(Token)match(input,20,FOLLOW_20_in_andExpr574); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal40_tree = (Object)adaptor.create(string_literal40);
					adaptor.addChild(root_0, string_literal40_tree);
					}
					dbg.location(129,56);
					pushFollow(FOLLOW_relExpr_in_andExpr578);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(129,65);
					if ( state.backtracking==0 ) { retval.result = new And(retval.result, rhs); }
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

		}
		dbg.location(130, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:133:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal41=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(133, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:5: (lhs= andExpr ( '||' rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:9: lhs= andExpr ( '||' rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(134,12);
			pushFollow(FOLLOW_andExpr_in_orExpr613);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(134,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(134,48);
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:48: ( '||' rhs= andExpr )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( (LA10_0==32) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:50: '||' rhs= andExpr
					{
					dbg.location(134,50);
					string_literal41=(Token)match(input,32,FOLLOW_32_in_orExpr619); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal41_tree = (Object)adaptor.create(string_literal41);
					adaptor.addChild(root_0, string_literal41_tree);
					}
					dbg.location(134,58);
					pushFollow(FOLLOW_andExpr_in_orExpr623);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(134,67);
					if ( state.backtracking==0 ) { retval.result = new Or(retval.result, rhs); }
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
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		dbg.location(135, 4);

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



	public static final BitSet FOLLOW_questionnaireExpr_in_parse80 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormStart_in_questionnaireExpr93 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_questionnaireExpr95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp106 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp108 = new BitSet(new long[]{0x0000000000014100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp110 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr121 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr125 = new BitSet(new long[]{0x0000000000004102L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr137 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_ifStatementExpr139 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Ident_in_ifStatementExpr141 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_ifStatementExpr143 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr145 = new BitSet(new long[]{0x0000000000004100L});
	public static final BitSet FOLLOW_qDeclaration_in_ifStatementExpr148 = new BitSet(new long[]{0x0000000000014100L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifStatementExpr152 = new BitSet(new long[]{0x0000000000014100L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qVarExpr_in_qDeclaration168 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_uQExpr_in_qDeclaration170 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration173 = new BitSet(new long[]{0x0000000000001012L});
	public static final BitSet FOLLOW_qCalcExpr_in_qDeclaration177 = new BitSet(new long[]{0x0000000000001012L});
	public static final BitSet FOLLOW_qType_in_qCalcExpr189 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_qCalcExpr191 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Ident_in_qCalcExpr192 = new BitSet(new long[]{0x0000000003800000L});
	public static final BitSet FOLLOW_set_in_qCalcExpr194 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Ident_in_qCalcExpr205 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_qCalcExpr207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_qVarExpr215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Question_in_uQExpr224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Question_in_primary270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_primary278 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_orExpr_in_primary282 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_primary284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_unExpr307 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_unExpr_in_unExpr311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_unExpr322 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_unExpr_in_unExpr326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_unExpr337 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_unExpr_in_unExpr341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr392 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_set_in_mulExpr400 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr412 = new BitSet(new long[]{0x0000000004800002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr453 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_set_in_addExpr461 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr471 = new BitSet(new long[]{0x0000000003000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr506 = new BitSet(new long[]{0x00000000F8080002L});
	public static final BitSet FOLLOW_set_in_relExpr514 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_addExpr_in_relExpr530 = new BitSet(new long[]{0x00000000F8080002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr568 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_20_in_andExpr574 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_relExpr_in_andExpr578 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr613 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_orExpr619 = new BitSet(new long[]{0x0000000003242600L});
	public static final BitSet FOLLOW_andExpr_in_orExpr623 = new BitSet(new long[]{0x0000000100000002L});
}
