// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 22:08:49

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
		"FormStart", "IF", "IF_BLOCK", "Ident", "Int", "Lbr", "Money", "QUESTIONNAIRE", 
		"QUESTION_BLOCK", "Question", "QuestionId", "Rbr", "VALUE_CALC", "WS", 
		"'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", 
		"'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int IF_BLOCK=9;
	public static final int Ident=10;
	public static final int Int=11;
	public static final int Lbr=12;
	public static final int Money=13;
	public static final int QUESTIONNAIRE=14;
	public static final int QUESTION_BLOCK=15;
	public static final int Question=16;
	public static final int QuestionId=17;
	public static final int Rbr=18;
	public static final int VALUE_CALC=19;
	public static final int WS=20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred4_QL", "synpred23_QL", "synpred8_QL", "questionTypeDefExpr", 
		"qLabel", "orExpr", "synpred18_QL", "unExpr", "addExpr", "synpred22_QL", 
		"qType", "synpred21_QL", "synpred25_QL", "synpred9_QL", "mulExpr", "parse", 
		"synpred19_QL", "synpred6_QL", "qStartExp", "andExpr", "ifStatementExpr", 
		"synpred17_QL", "synpred15_QL", "synpred16_QL", "synpred20_QL", "synpred2_QL", 
		"synpred12_QL", "synpred5_QL", "synpred24_QL", "synpred11_QL", "qStartQExpr", 
		"relExpr", "qValueCalcExpr", "qIdentifier", "synpred26_QL", "synpred14_QL", 
		"synpred10_QL", "qDeclaration", "synpred13_QL", "primary", "synpred1_QL", 
		"synpred3_QL", "synpred7_QL", "ifBlockContentExpr"
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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }


	public static class parse_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:41:1: parse : FormStart qStartExp EOF -> ^( QUESTIONNAIRE qStartExp ) ;
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
		dbg.location(41, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:42:2: ( FormStart qStartExp EOF -> ^( QUESTIONNAIRE qStartExp ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:42:4: FormStart qStartExp EOF
			{
			dbg.location(42,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse93); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(42,14);
			pushFollow(FOLLOW_qStartExp_in_parse95);
			qStartExp2=qStartExp();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartExp.add(qStartExp2.getTree());dbg.location(42,24);
			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_parse97); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF3);

			// AST REWRITE
			// elements: qStartExp
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 42:28: -> ^( QUESTIONNAIRE qStartExp )
			{
				dbg.location(42,31);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:42:31: ^( QUESTIONNAIRE qStartExp )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(42,33);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTIONNAIRE, "QUESTIONNAIRE"), root_1);
				dbg.location(42,47);
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
		dbg.location(42, 56);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:46:1: qStartExp : FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) ;
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
		dbg.location(46, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:2: ( FormId Lbr qStartQExpr Rbr -> ^( FormId qStartQExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:4: FormId Lbr qStartQExpr Rbr
			{
			dbg.location(48,4);
			FormId4=(Token)match(input,FormId,FOLLOW_FormId_in_qStartExp121); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId4);
			dbg.location(48,11);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qStartExp123); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(48,15);
			pushFollow(FOLLOW_qStartQExpr_in_qStartExp125);
			qStartQExpr6=qStartQExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qStartQExpr.add(qStartQExpr6.getTree());dbg.location(48,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qStartExp127); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: qStartQExpr, FormId
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 48:31: -> ^( FormId qStartQExpr )
			{
				dbg.location(48,33);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:48:33: ^( FormId qStartQExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(48,35);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(48,42);
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
		dbg.location(48, 53);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:51:1: qStartQExpr : ( qDeclaration | ifStatementExpr )* ;
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
		dbg.location(51, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

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
					pushFollow(FOLLOW_qDeclaration_in_qStartQExpr146);
					qDeclaration8=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:20: ifStatementExpr
					{
					dbg.location(52,20);
					pushFollow(FOLLOW_ifStatementExpr_in_qStartQExpr150);
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
		dbg.location(52, 36);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: qDeclaration : qIdentifier ':' qLabel questionTypeDefExpr -> ^( QUESTION_BLOCK qIdentifier qLabel questionTypeDefExpr ) ;
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal11=null;
		ParserRuleReturnScope qIdentifier10 =null;
		ParserRuleReturnScope qLabel12 =null;
		ParserRuleReturnScope questionTypeDefExpr13 =null;

		CommonTree char_literal11_tree=null;
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleSubtreeStream stream_qLabel=new RewriteRuleSubtreeStream(adaptor,"rule qLabel");
		RewriteRuleSubtreeStream stream_qIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule qIdentifier");
		RewriteRuleSubtreeStream stream_questionTypeDefExpr=new RewriteRuleSubtreeStream(adaptor,"rule questionTypeDefExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(55, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:2: ( qIdentifier ':' qLabel questionTypeDefExpr -> ^( QUESTION_BLOCK qIdentifier qLabel questionTypeDefExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: qIdentifier ':' qLabel questionTypeDefExpr
			{
			dbg.location(56,4);
			pushFollow(FOLLOW_qIdentifier_in_qDeclaration163);
			qIdentifier10=qIdentifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qIdentifier.add(qIdentifier10.getTree());dbg.location(56,17);
			char_literal11=(Token)match(input,30,FOLLOW_30_in_qDeclaration166); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_30.add(char_literal11);
			dbg.location(56,21);
			pushFollow(FOLLOW_qLabel_in_qDeclaration168);
			qLabel12=qLabel();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qLabel.add(qLabel12.getTree());dbg.location(56,28);
			pushFollow(FOLLOW_questionTypeDefExpr_in_qDeclaration170);
			questionTypeDefExpr13=questionTypeDefExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_questionTypeDefExpr.add(questionTypeDefExpr13.getTree());
			// AST REWRITE
			// elements: questionTypeDefExpr, qLabel, qIdentifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 56:48: -> ^( QUESTION_BLOCK qIdentifier qLabel questionTypeDefExpr )
			{
				dbg.location(56,50);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:50: ^( QUESTION_BLOCK qIdentifier qLabel questionTypeDefExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(56,52);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
				dbg.location(56,67);
				adaptor.addChild(root_1, stream_qIdentifier.nextTree());dbg.location(56,79);
				adaptor.addChild(root_1, stream_qLabel.nextTree());dbg.location(56,86);
				adaptor.addChild(root_1, stream_questionTypeDefExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 4, qDeclaration_StartIndex); }

		}
		dbg.location(56, 105);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qDeclaration"


	public static class questionTypeDefExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "questionTypeDefExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: questionTypeDefExpr : ( qType | qType qValueCalcExpr ) ;
	public final QLParser.questionTypeDefExpr_return questionTypeDefExpr() throws RecognitionException {
		QLParser.questionTypeDefExpr_return retval = new QLParser.questionTypeDefExpr_return();
		retval.start = input.LT(1);
		int questionTypeDefExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		ParserRuleReturnScope qType14 =null;
		ParserRuleReturnScope qType15 =null;
		ParserRuleReturnScope qValueCalcExpr16 =null;


		try { dbg.enterRule(getGrammarFileName(), "questionTypeDefExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(59, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:2: ( ( qType | qType qValueCalcExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:4: ( qType | qType qValueCalcExpr )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(60,4);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:4: ( qType | qType qValueCalcExpr )
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Boolean||LA2_0==Money) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==EOF||LA2_1==IF||(LA2_1 >= QuestionId && LA2_1 <= Rbr)) ) {
					alt2=1;
				}
				else if ( (LA2_1==24) ) {
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: qType
					{
					dbg.location(60,5);
					pushFollow(FOLLOW_qType_in_questionTypeDefExpr192);
					qType14=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qType14.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:13: qType qValueCalcExpr
					{
					dbg.location(60,13);
					pushFollow(FOLLOW_qType_in_questionTypeDefExpr196);
					qType15=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qType15.getTree());
					dbg.location(60,19);
					pushFollow(FOLLOW_qValueCalcExpr_in_questionTypeDefExpr198);
					qValueCalcExpr16=qValueCalcExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qValueCalcExpr16.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 5, questionTypeDefExpr_StartIndex); }

		}
		dbg.location(60, 34);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "questionTypeDefExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "questionTypeDefExpr"


	public static class ifStatementExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ifStatementExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:1: ifStatementExpr : IF '(' qIdentifier ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK qIdentifier ifBlockContentExpr ) ;
	public final QLParser.ifStatementExpr_return ifStatementExpr() throws RecognitionException {
		QLParser.ifStatementExpr_return retval = new QLParser.ifStatementExpr_return();
		retval.start = input.LT(1);
		int ifStatementExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token IF17=null;
		Token char_literal18=null;
		Token char_literal20=null;
		Token Lbr21=null;
		Token Rbr23=null;
		ParserRuleReturnScope qIdentifier19 =null;
		ParserRuleReturnScope ifBlockContentExpr22 =null;

		CommonTree IF17_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal20_tree=null;
		CommonTree Lbr21_tree=null;
		CommonTree Rbr23_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
		RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
		RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
		RewriteRuleSubtreeStream stream_ifBlockContentExpr=new RewriteRuleSubtreeStream(adaptor,"rule ifBlockContentExpr");
		RewriteRuleSubtreeStream stream_qIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule qIdentifier");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(63, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:2: ( IF '(' qIdentifier ')' Lbr ifBlockContentExpr Rbr -> ^( IF_BLOCK qIdentifier ifBlockContentExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:5: IF '(' qIdentifier ')' Lbr ifBlockContentExpr Rbr
			{
			dbg.location(64,5);
			IF17=(Token)match(input,IF,FOLLOW_IF_in_ifStatementExpr213); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF.add(IF17);
			dbg.location(64,8);
			char_literal18=(Token)match(input,24,FOLLOW_24_in_ifStatementExpr215); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_24.add(char_literal18);
			dbg.location(64,12);
			pushFollow(FOLLOW_qIdentifier_in_ifStatementExpr217);
			qIdentifier19=qIdentifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qIdentifier.add(qIdentifier19.getTree());dbg.location(64,24);
			char_literal20=(Token)match(input,25,FOLLOW_25_in_ifStatementExpr219); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_25.add(char_literal20);
			dbg.location(64,28);
			Lbr21=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementExpr221); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr21);
			dbg.location(64,32);
			pushFollow(FOLLOW_ifBlockContentExpr_in_ifStatementExpr223);
			ifBlockContentExpr22=ifBlockContentExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifBlockContentExpr.add(ifBlockContentExpr22.getTree());dbg.location(64,51);
			Rbr23=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementExpr225); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr23);

			// AST REWRITE
			// elements: qIdentifier, ifBlockContentExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 64:55: -> ^( IF_BLOCK qIdentifier ifBlockContentExpr )
			{
				dbg.location(64,57);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:57: ^( IF_BLOCK qIdentifier ifBlockContentExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(64,59);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(64,68);
				adaptor.addChild(root_1, stream_qIdentifier.nextTree());dbg.location(64,80);
				adaptor.addChild(root_1, stream_ifBlockContentExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 6, ifStatementExpr_StartIndex); }

		}
		dbg.location(64, 98);

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

		ParserRuleReturnScope qDeclaration24 =null;
		ParserRuleReturnScope ifStatementExpr25 =null;


		try { dbg.enterRule(getGrammarFileName(), "ifBlockContentExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:6: qDeclaration
					{
					dbg.location(67,6);
					pushFollow(FOLLOW_qDeclaration_in_ifBlockContentExpr245);
					qDeclaration24=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration24.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:22: ifStatementExpr
					{
					dbg.location(67,22);
					pushFollow(FOLLOW_ifStatementExpr_in_ifBlockContentExpr250);
					ifStatementExpr25=ifStatementExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatementExpr25.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 7, ifBlockContentExpr_StartIndex); }

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


	public static class qValueCalcExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "qValueCalcExpr"
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: qValueCalcExpr : '(' orExpr ')' -> ^( VALUE_CALC orExpr ) ;
	public final QLParser.qValueCalcExpr_return qValueCalcExpr() throws RecognitionException {
		QLParser.qValueCalcExpr_return retval = new QLParser.qValueCalcExpr_return();
		retval.start = input.LT(1);
		int qValueCalcExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token char_literal26=null;
		Token char_literal28=null;
		ParserRuleReturnScope orExpr27 =null;

		CommonTree char_literal26_tree=null;
		CommonTree char_literal28_tree=null;
		RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");
		RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qValueCalcExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(69, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:2: ( '(' orExpr ')' -> ^( VALUE_CALC orExpr ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:5: '(' orExpr ')'
			{
			dbg.location(70,5);
			char_literal26=(Token)match(input,24,FOLLOW_24_in_qValueCalcExpr264); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_24.add(char_literal26);
			dbg.location(70,9);
			pushFollow(FOLLOW_orExpr_in_qValueCalcExpr266);
			orExpr27=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr27.getTree());dbg.location(70,16);
			char_literal28=(Token)match(input,25,FOLLOW_25_in_qValueCalcExpr268); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_25.add(char_literal28);

			// AST REWRITE
			// elements: orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 70:20: -> ^( VALUE_CALC orExpr )
			{
				dbg.location(70,22);
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:22: ^( VALUE_CALC orExpr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(70,24);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_1);
				dbg.location(70,35);
				adaptor.addChild(root_1, stream_orExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 8, qValueCalcExpr_StartIndex); }

		}
		dbg.location(70, 41);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:1: qIdentifier : QuestionId ;
	public final QLParser.qIdentifier_return qIdentifier() throws RecognitionException {
		QLParser.qIdentifier_return retval = new QLParser.qIdentifier_return();
		retval.start = input.LT(1);
		int qIdentifier_StartIndex = input.index();

		CommonTree root_0 = null;

		Token QuestionId29=null;

		CommonTree QuestionId29_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qIdentifier");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(73, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:13: ( QuestionId )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:15: QuestionId
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(73,15);
			QuestionId29=(Token)match(input,QuestionId,FOLLOW_QuestionId_in_qIdentifier286); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QuestionId29_tree = (CommonTree)adaptor.create(QuestionId29);
			adaptor.addChild(root_0, QuestionId29_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 9, qIdentifier_StartIndex); }

		}
		dbg.location(73, 25);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: qLabel : Question ;
	public final QLParser.qLabel_return qLabel() throws RecognitionException {
		QLParser.qLabel_return retval = new QLParser.qLabel_return();
		retval.start = input.LT(1);
		int qLabel_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Question30=null;

		CommonTree Question30_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qLabel");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:8: ( Question )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:10: Question
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(75,10);
			Question30=(Token)match(input,Question,FOLLOW_Question_in_qLabel296); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Question30_tree = (CommonTree)adaptor.create(Question30);
			adaptor.addChild(root_0, Question30_tree);
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
			if ( state.backtracking>0 ) { memoize(input, 10, qLabel_StartIndex); }

		}
		dbg.location(75, 17);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		CommonTree root_0 = null;

		Token set31=null;

		CommonTree set31_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(77, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(78,2);
			set31=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set31));
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
			if ( state.backtracking>0 ) { memoize(input, 11, qType_StartIndex); }

		}
		dbg.location(78, 19);

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: primary returns [Expr result] : ( Int | Ident | Boolean | QuestionId | Money | '(' x= orExpr ')' );
	public final QLParser.primary_return primary() throws RecognitionException {
		QLParser.primary_return retval = new QLParser.primary_return();
		retval.start = input.LT(1);
		int primary_StartIndex = input.index();

		CommonTree root_0 = null;

		Token Int32=null;
		Token Ident33=null;
		Token Boolean34=null;
		Token QuestionId35=null;
		Token Money36=null;
		Token char_literal37=null;
		Token char_literal38=null;
		ParserRuleReturnScope x =null;

		CommonTree Int32_tree=null;
		CommonTree Ident33_tree=null;
		CommonTree Boolean34_tree=null;
		CommonTree QuestionId35_tree=null;
		CommonTree Money36_tree=null;
		CommonTree char_literal37_tree=null;
		CommonTree char_literal38_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "primary");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(81, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:3: ( Int | Ident | Boolean | QuestionId | Money | '(' x= orExpr ')' )
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
			case QuestionId:
				{
				alt4=4;
				}
				break;
			case Money:
				{
				alt4=5;
				}
				break;
			case 24:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: Int
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(82,5);
					Int32=(Token)match(input,Int,FOLLOW_Int_in_primary327); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int32_tree = (CommonTree)adaptor.create(Int32);
					adaptor.addChild(root_0, Int32_tree);
					}
					dbg.location(82,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int32!=null?Int32.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:5: Ident
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(83,5);
					Ident33=(Token)match(input,Ident,FOLLOW_Ident_in_primary337); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident33_tree = (CommonTree)adaptor.create(Ident33);
					adaptor.addChild(root_0, Ident33_tree);
					}
					dbg.location(83,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident33!=null?Ident33.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:5: Boolean
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(85,5);
					Boolean34=(Token)match(input,Boolean,FOLLOW_Boolean_in_primary348); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean34_tree = (CommonTree)adaptor.create(Boolean34);
					adaptor.addChild(root_0, Boolean34_tree);
					}
					dbg.location(85,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean34!=null?Boolean34.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: QuestionId
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(86,5);
					QuestionId35=(Token)match(input,QuestionId,FOLLOW_QuestionId_in_primary356); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QuestionId35_tree = (CommonTree)adaptor.create(QuestionId35);
					adaptor.addChild(root_0, QuestionId35_tree);
					}
					dbg.location(86,16);
					if ( state.backtracking==0 ) {retval.result = null;}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: Money
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(87,5);
					Money36=(Token)match(input,Money,FOLLOW_Money_in_primary364); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money36_tree = (CommonTree)adaptor.create(Money36);
					adaptor.addChild(root_0, Money36_tree);
					}
					dbg.location(87,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money36!=null?Money36.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: '(' x= orExpr ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(89,5);
					char_literal37=(Token)match(input,24,FOLLOW_24_in_primary375); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal37_tree = (CommonTree)adaptor.create(char_literal37);
					adaptor.addChild(root_0, char_literal37_tree);
					}
					dbg.location(89,10);
					pushFollow(FOLLOW_orExpr_in_primary379);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(89,18);
					char_literal38=(Token)match(input,25,FOLLOW_25_in_primary381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal38_tree = (CommonTree)adaptor.create(char_literal38);
					adaptor.addChild(root_0, char_literal38_tree);
					}
					dbg.location(89,21);
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
			if ( state.backtracking>0 ) { memoize(input, 12, primary_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: unExpr returns [Expr result] : ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

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
		dbg.location(93, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: ( '+' ^x= unExpr | '-' ^x= unExpr | '!' ^x= unExpr |x= primary )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 27:
				{
				alt5=1;
				}
				break;
			case 28:
				{
				alt5=2;
				}
				break;
			case 21:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionId:
			case 24:
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:8: '+' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(94,11);
					char_literal39=(Token)match(input,27,FOLLOW_27_in_unExpr407); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal39_tree, root_0);
					}
					dbg.location(94,14);
					pushFollow(FOLLOW_unExpr_in_unExpr412);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:8: '-' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(95,11);
					char_literal40=(Token)match(input,28,FOLLOW_28_in_unExpr423); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal40_tree = (CommonTree)adaptor.create(char_literal40);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal40_tree, root_0);
					}
					dbg.location(95,14);
					pushFollow(FOLLOW_unExpr_in_unExpr428);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:8: '!' ^x= unExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(96,11);
					char_literal41=(Token)match(input,21,FOLLOW_21_in_unExpr439); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal41_tree, root_0);
					}
					dbg.location(96,14);
					pushFollow(FOLLOW_unExpr_in_unExpr444);
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

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:8: x= primary
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(97,9);
					pushFollow(FOLLOW_primary_in_unExpr457);
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
			if ( state.backtracking>0 ) { memoize(input, 13, unExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: (lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: lhs= unExpr (op= ( '*' ^| '/' ) rhs= unExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(101,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr495);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(101,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(101,45);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:45: (op= ( '*' ^| '/' ) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==26||LA7_0==29) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:47: op= ( '*' ^| '/' ) rhs= unExpr
					{
					dbg.location(101,49);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:50: ( '*' ^| '/' )
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==26) ) {
						alt6=1;
					}
					else if ( (LA6_0==29) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:52: '*' ^
							{
							dbg.location(101,55);
							op=(Token)match(input,26,FOLLOW_26_in_mulExpr505); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:59: '/'
							{
							dbg.location(101,59);
							op=(Token)match(input,29,FOLLOW_29_in_mulExpr510); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							adaptor.addChild(root_0, op_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(101,68);
					pushFollow(FOLLOW_unExpr_in_mulExpr516);
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
			if ( state.backtracking>0 ) { memoize(input, 14, mulExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(114,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr557);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(114,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(114,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 27 && LA9_0 <= 28)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(114,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==27) ) {
						alt8=1;
					}
					else if ( (LA8_0==28) ) {
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:52: '+' ^
							{
							dbg.location(114,55);
							op=(Token)match(input,27,FOLLOW_27_in_addExpr566); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:59: '-' ^
							{
							dbg.location(114,62);
							op=(Token)match(input,28,FOLLOW_28_in_addExpr571); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(114,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr577);
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
			if ( state.backtracking>0 ) { memoize(input, 15, addExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(126,12);
			pushFollow(FOLLOW_addExpr_in_relExpr612);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(126,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(126,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==22||(LA11_0 >= 31 && LA11_0 <= 35)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(126,50);
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 31:
						{
						alt10=1;
						}
						break;
					case 32:
						{
						alt10=2;
						}
						break;
					case 34:
						{
						alt10=3;
						}
						break;
					case 35:
						{
						alt10=4;
						}
						break;
					case 33:
						{
						alt10=5;
						}
						break;
					case 22:
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

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:52: '<' ^
							{
							dbg.location(126,55);
							op=(Token)match(input,31,FOLLOW_31_in_relExpr621); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:57: '<=' ^
							{
							dbg.location(126,61);
							op=(Token)match(input,32,FOLLOW_32_in_relExpr624); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:63: '>' ^
							{
							dbg.location(126,66);
							op=(Token)match(input,34,FOLLOW_34_in_relExpr627); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:68: '>=' ^
							{
							dbg.location(126,72);
							op=(Token)match(input,35,FOLLOW_35_in_relExpr630); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:75: '==' ^
							{
							dbg.location(126,79);
							op=(Token)match(input,33,FOLLOW_33_in_relExpr634); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:82: '!=' ^
							{
							dbg.location(126,86);
							op=(Token)match(input,22,FOLLOW_22_in_relExpr638); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (CommonTree)adaptor.create(op);
							root_0 = (CommonTree)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(126,92);
					pushFollow(FOLLOW_addExpr_in_relExpr644);
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
			if ( state.backtracking>0 ) { memoize(input, 16, relExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal42=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal42_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(149, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(150,12);
			pushFollow(FOLLOW_relExpr_in_andExpr682);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(150,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(150,46);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==23) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:48: '&&' ^rhs= relExpr
					{
					dbg.location(150,52);
					string_literal42=(Token)match(input,23,FOLLOW_23_in_andExpr688); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal42_tree = (CommonTree)adaptor.create(string_literal42);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal42_tree, root_0);
					}
					dbg.location(150,57);
					pushFollow(FOLLOW_relExpr_in_andExpr693);
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
			if ( state.backtracking>0 ) { memoize(input, 17, andExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:154:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		CommonTree root_0 = null;

		Token string_literal43=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		CommonTree string_literal43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(154, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(155,12);
			pushFollow(FOLLOW_andExpr_in_orExpr728);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(155,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(155,48);
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==36) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:50: '||' ^rhs= andExpr
					{
					dbg.location(155,54);
					string_literal43=(Token)match(input,36,FOLLOW_36_in_orExpr734); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal43_tree = (CommonTree)adaptor.create(string_literal43);
					root_0 = (CommonTree)adaptor.becomeRoot(string_literal43_tree, root_0);
					}
					dbg.location(155,59);
					pushFollow(FOLLOW_andExpr_in_orExpr739);
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
			if ( state.backtracking>0 ) { memoize(input, 18, orExpr_StartIndex); }

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



	public static final BitSet FOLLOW_FormStart_in_parse93 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_qStartExp_in_parse95 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FormId_in_qStartExp121 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Lbr_in_qStartExp123 = new BitSet(new long[]{0x0000000000060100L});
	public static final BitSet FOLLOW_qStartQExpr_in_qStartExp125 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Rbr_in_qStartExp127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qStartQExpr146 = new BitSet(new long[]{0x0000000000020102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_qStartQExpr150 = new BitSet(new long[]{0x0000000000020102L});
	public static final BitSet FOLLOW_qIdentifier_in_qDeclaration163 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_qDeclaration166 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_qLabel_in_qDeclaration168 = new BitSet(new long[]{0x0000000000002010L});
	public static final BitSet FOLLOW_questionTypeDefExpr_in_qDeclaration170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qType_in_questionTypeDefExpr192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qType_in_questionTypeDefExpr196 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_qValueCalcExpr_in_questionTypeDefExpr198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_ifStatementExpr213 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_ifStatementExpr215 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_qIdentifier_in_ifStatementExpr217 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_ifStatementExpr219 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementExpr221 = new BitSet(new long[]{0x0000000000020100L});
	public static final BitSet FOLLOW_ifBlockContentExpr_in_ifStatementExpr223 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementExpr225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_ifBlockContentExpr245 = new BitSet(new long[]{0x0000000000020102L});
	public static final BitSet FOLLOW_ifStatementExpr_in_ifBlockContentExpr250 = new BitSet(new long[]{0x0000000000020102L});
	public static final BitSet FOLLOW_24_in_qValueCalcExpr264 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_orExpr_in_qValueCalcExpr266 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_qValueCalcExpr268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_qIdentifier286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Question_in_qLabel296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_primary327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_primary337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_primary348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionId_in_primary356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_primary364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_primary375 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_orExpr_in_primary379 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_primary381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_unExpr407 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_unExpr_in_unExpr412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_unExpr423 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_unExpr_in_unExpr428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_unExpr439 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_unExpr_in_unExpr444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr495 = new BitSet(new long[]{0x0000000024000002L});
	public static final BitSet FOLLOW_26_in_mulExpr505 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_29_in_mulExpr510 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr516 = new BitSet(new long[]{0x0000000024000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr557 = new BitSet(new long[]{0x0000000018000002L});
	public static final BitSet FOLLOW_27_in_addExpr566 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_28_in_addExpr571 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr577 = new BitSet(new long[]{0x0000000018000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr612 = new BitSet(new long[]{0x0000000F80400002L});
	public static final BitSet FOLLOW_31_in_relExpr621 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_32_in_relExpr624 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_34_in_relExpr627 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_35_in_relExpr630 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_33_in_relExpr634 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_22_in_relExpr638 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_addExpr_in_relExpr644 = new BitSet(new long[]{0x0000000F80400002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr682 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_andExpr688 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_relExpr_in_andExpr693 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr728 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_orExpr734 = new BitSet(new long[]{0x0000000019222C10L});
	public static final BitSet FOLLOW_andExpr_in_orExpr739 = new BitSet(new long[]{0x0000001000000002L});
}
