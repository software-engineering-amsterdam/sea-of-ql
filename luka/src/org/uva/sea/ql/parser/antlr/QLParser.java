// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 04:49:17

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
		"CONST_TYPE", "CONST_TYPE_INT", "CONST_VALUE", "CONST_VAR", "Else", "FormId", 
		"FormStart", "IF_BLOCK", "IF_FALSE", "IF_STATEMENT", "IF_TRUE", "Ident", 
		"If", "Int", "Lbr", "Money", "NEG_EXPR", "QUESTION_BLOCK", "QUESTION_LABEL", 
		"QUESTION_VAR", "QuestionLabel", "QuestionVariable", "Rbr", "UNARY_EXPR", 
		"VALUE_CALC", "VAR_NAME", "VAR_TYPE", "WS", "'!'", "'!='", "'&&'", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", 
		"'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int Else=11;
	public static final int FormId=12;
	public static final int FormStart=13;
	public static final int IF_BLOCK=14;
	public static final int IF_FALSE=15;
	public static final int IF_STATEMENT=16;
	public static final int IF_TRUE=17;
	public static final int Ident=18;
	public static final int If=19;
	public static final int Int=20;
	public static final int Lbr=21;
	public static final int Money=22;
	public static final int NEG_EXPR=23;
	public static final int QUESTION_BLOCK=24;
	public static final int QUESTION_LABEL=25;
	public static final int QUESTION_VAR=26;
	public static final int QuestionLabel=27;
	public static final int QuestionVariable=28;
	public static final int Rbr=29;
	public static final int UNARY_EXPR=30;
	public static final int VALUE_CALC=31;
	public static final int VAR_NAME=32;
	public static final int VAR_TYPE=33;
	public static final int WS=34;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "synpred9_QL", "synpred25_QL", "qDeclaration", "synpred15_QL", 
		"constantDeclarationExpr", "qContentBlock", "atom", "relExpr", "synpred2_QL", 
		"synpred24_QL", "ifStatement", "synpred4_QL", "orExpr", "synpred6_QL", 
		"synpred22_QL", "synpred19_QL", "synpred18_QL", "synpred14_QL", "synpred12_QL", 
		"synpred21_QL", "qType", "synpred3_QL", "synpred26_QL", "synpred10_QL", 
		"synpred8_QL", "synpred23_QL", "synpred16_QL", "synpred13_QL", "mulExpr", 
		"synpred1_QL", "parse", "synpred5_QL", "synpred11_QL", "unExpr", "andExpr", 
		"synpred20_QL", "synpred7_QL", "addExpr", "qContentBlockItem", "synpred17_QL"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, true, false, false, false, false, false, false, false, false, 
		    false, false
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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:1: parse : FormStart FormId qContentBlock EOF -> ^( FormStart qContentBlock ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		Object root_0 = null;

		Token FormStart1=null;
		Token FormId2=null;
		Token EOF4=null;
		ParserRuleReturnScope qContentBlock3 =null;

		Object FormStart1_tree=null;
		Object FormId2_tree=null;
		Object EOF4_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_qContentBlock=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlock");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(53, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:2: ( FormStart FormId qContentBlock EOF -> ^( FormStart qContentBlock ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:4: FormStart FormId qContentBlock EOF
			{
			dbg.location(54,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse122); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(54,14);
			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse124); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId2);
			dbg.location(54,21);
			pushFollow(FOLLOW_qContentBlock_in_parse126);
			qContentBlock3=qContentBlock();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlock.add(qContentBlock3.getTree());dbg.location(54,35);
			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_parse128); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF4);

			// AST REWRITE
			// elements: qContentBlock, FormStart
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 54:39: -> ^( FormStart qContentBlock )
			{
				dbg.location(54,42);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:54:42: ^( FormStart qContentBlock )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(54,44);
				root_1 = (Object)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(54,54);
				adaptor.addChild(root_1, stream_qContentBlock.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
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
		dbg.location(54, 67);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class qContentBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qContentBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: qContentBlock : Lbr qContentBlockItem Rbr -> ^( FormId qContentBlockItem ) ;
	public final QLParser.qContentBlock_return qContentBlock() throws RecognitionException {
		QLParser.qContentBlock_return retval = new QLParser.qContentBlock_return();
		retval.start = input.LT(1);
		int qContentBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Lbr5=null;
		Token Rbr7=null;
		ParserRuleReturnScope qContentBlockItem6 =null;

		Object Lbr5_tree=null;
		Object Rbr7_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");

		try { dbg.enterRule(getGrammarFileName(), "qContentBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:2: ( Lbr qContentBlockItem Rbr -> ^( FormId qContentBlockItem ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Lbr qContentBlockItem Rbr
			{
			dbg.location(60,5);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qContentBlock153); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(60,9);
			pushFollow(FOLLOW_qContentBlockItem_in_qContentBlock155);
			qContentBlockItem6=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem6.getTree());dbg.location(60,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qContentBlock157); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr7);

			// AST REWRITE
			// elements: qContentBlockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 60:31: -> ^( FormId qContentBlockItem )
			{
				dbg.location(60,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:33: ^( FormId qContentBlockItem )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(60,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FormId, "FormId"), root_1);
				dbg.location(60,42);
				adaptor.addChild(root_1, stream_qContentBlockItem.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
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
			if ( state.backtracking>0 ) { memoize(input, 2, qContentBlock_StartIndex); }

		}
		dbg.location(60, 59);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qContentBlock");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qContentBlock"


	public static class qContentBlockItem_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qContentBlockItem"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:1: qContentBlockItem : ( qDeclaration | ifStatement | constantDeclarationExpr )+ ;
	public final QLParser.qContentBlockItem_return qContentBlockItem() throws RecognitionException {
		QLParser.qContentBlockItem_return retval = new QLParser.qContentBlockItem_return();
		retval.start = input.LT(1);
		int qContentBlockItem_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope qDeclaration8 =null;
		ParserRuleReturnScope ifStatement9 =null;
		ParserRuleReturnScope constantDeclarationExpr10 =null;


		try { dbg.enterRule(getGrammarFileName(), "qContentBlockItem");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:2: ( ( qDeclaration | ifStatement | constantDeclarationExpr )+ )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:4: ( qDeclaration | ifStatement | constantDeclarationExpr )+
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(63,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:4: ( qDeclaration | ifStatement | constantDeclarationExpr )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=4;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==QuestionVariable) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==44) ) {
						int LA1_4 = input.LA(3);
						if ( (LA1_4==QuestionLabel) ) {
							alt1=1;
						}
						else if ( (LA1_4==Int) ) {
							alt1=3;
						}

					}

				}
				else if ( (LA1_0==If) ) {
					alt1=2;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:6: qDeclaration
					{
					dbg.location(63,6);
					pushFollow(FOLLOW_qDeclaration_in_qContentBlockItem176);
					qDeclaration8=qDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, qDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:22: ifStatement
					{
					dbg.location(63,22);
					pushFollow(FOLLOW_ifStatement_in_qContentBlockItem181);
					ifStatement9=ifStatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement9.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:63:36: constantDeclarationExpr
					{
					dbg.location(63,36);
					pushFollow(FOLLOW_constantDeclarationExpr_in_qContentBlockItem185);
					constantDeclarationExpr10=constantDeclarationExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constantDeclarationExpr10.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt1++;
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
			if ( state.backtracking>0 ) { memoize(input, 3, qContentBlockItem_StartIndex); }

		}
		dbg.location(63, 61);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qContentBlockItem");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qContentBlockItem"


	public static class qDeclaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: qDeclaration : ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) );
	public final QLParser.qDeclaration_return qDeclaration() throws RecognitionException {
		QLParser.qDeclaration_return retval = new QLParser.qDeclaration_return();
		retval.start = input.LT(1);
		int qDeclaration_StartIndex = input.index();

		Object root_0 = null;

		Token QuestionVariable11=null;
		Token char_literal12=null;
		Token QuestionLabel13=null;
		Token QuestionVariable15=null;
		Token char_literal16=null;
		Token QuestionLabel17=null;
		Token char_literal19=null;
		Token char_literal21=null;
		ParserRuleReturnScope qType14 =null;
		ParserRuleReturnScope qType18 =null;
		ParserRuleReturnScope orExpr20 =null;

		Object QuestionVariable11_tree=null;
		Object char_literal12_tree=null;
		Object QuestionLabel13_tree=null;
		Object QuestionVariable15_tree=null;
		Object char_literal16_tree=null;
		Object QuestionLabel17_tree=null;
		Object char_literal19_tree=null;
		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "qDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: ( QuestionVariable ':' QuestionLabel qType -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) ) | QuestionVariable ':' QuestionLabel qType '(' orExpr ')' -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) ) )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==QuestionVariable) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==44) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==QuestionLabel) ) {
						int LA2_3 = input.LA(4);
						if ( (LA2_3==Boolean||LA2_3==Money) ) {
							int LA2_4 = input.LA(5);
							if ( (LA2_4==EOF||LA2_4==If||(LA2_4 >= QuestionVariable && LA2_4 <= Rbr)) ) {
								alt2=1;
							}
							else if ( (LA2_4==38) ) {
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: QuestionVariable ':' QuestionLabel qType
					{
					dbg.location(67,4);
					QuestionVariable11=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration200); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable11);
					dbg.location(67,22);
					char_literal12=(Token)match(input,44,FOLLOW_44_in_qDeclaration203); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_44.add(char_literal12);
					dbg.location(67,26);
					QuestionLabel13=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration205); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel13);
					dbg.location(67,40);
					pushFollow(FOLLOW_qType_in_qDeclaration207);
					qType14=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType14.getTree());
					// AST REWRITE
					// elements: QuestionVariable, qType, QuestionLabel
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 67:46: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(67,48);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:48: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(67,50);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(67,65);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:65: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(67,67);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(67,80);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:80: ^( VAR_NAME QuestionVariable )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(67,82);
						root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(67,91);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(67,109);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:109: ^( VAR_TYPE qType )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(67,111);
						root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(67,120);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(67,129);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:129: ^( QUESTION_LABEL QuestionLabel )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(67,131);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(67,146);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:4: QuestionVariable ':' QuestionLabel qType '(' orExpr ')'
					{
					dbg.location(68,4);
					QuestionVariable15=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_qDeclaration241); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable15);
					dbg.location(68,22);
					char_literal16=(Token)match(input,44,FOLLOW_44_in_qDeclaration244); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_44.add(char_literal16);
					dbg.location(68,26);
					QuestionLabel17=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_qDeclaration246); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel17);
					dbg.location(68,40);
					pushFollow(FOLLOW_qType_in_qDeclaration248);
					qType18=qType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qType.add(qType18.getTree());dbg.location(68,46);
					char_literal19=(Token)match(input,38,FOLLOW_38_in_qDeclaration250); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal19);
					dbg.location(68,50);
					pushFollow(FOLLOW_orExpr_in_qDeclaration252);
					orExpr20=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr20.getTree());dbg.location(68,57);
					char_literal21=(Token)match(input,39,FOLLOW_39_in_qDeclaration254); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_39.add(char_literal21);

					// AST REWRITE
					// elements: QuestionVariable, QuestionLabel, orExpr, qType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 68:62: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
					{
						dbg.location(68,64);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:64: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) ) ^( QUESTION_LABEL QuestionLabel ) )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(68,66);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
						dbg.location(68,81);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:81: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ^( VALUE_CALC orExpr ) )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(68,83);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
						dbg.location(68,96);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:96: ^( VAR_NAME QuestionVariable )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(68,98);
						root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
						dbg.location(68,107);
						adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(68,125);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:125: ^( VAR_TYPE qType )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(68,127);
						root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
						dbg.location(68,136);
						adaptor.addChild(root_3, stream_qType.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(68,143);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:143: ^( VALUE_CALC orExpr )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(68,145);
						root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VALUE_CALC, "VALUE_CALC"), root_3);
						dbg.location(68,156);
						adaptor.addChild(root_3, stream_orExpr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}
						dbg.location(68,166);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:166: ^( QUESTION_LABEL QuestionLabel )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(68,168);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
						dbg.location(68,183);
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
			if ( state.backtracking>0 ) { memoize(input, 4, qDeclaration_StartIndex); }

		}
		dbg.location(68, 198);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qDeclaration"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: ifStatement : ( If '(' orExpr ')' Lbr ifTrue= qContentBlockItem Rbr Else Lbr ifFalse= qContentBlockItem Rbr -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE $ifTrue) ^( IF_FALSE $ifFalse) ) | If '(' orExpr ')' Lbr qContentBlockItem Rbr -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qContentBlockItem ) ) );
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);
		int ifStatement_StartIndex = input.index();

		Object root_0 = null;

		Token If22=null;
		Token char_literal23=null;
		Token char_literal25=null;
		Token Lbr26=null;
		Token Rbr27=null;
		Token Else28=null;
		Token Lbr29=null;
		Token Rbr30=null;
		Token If31=null;
		Token char_literal32=null;
		Token char_literal34=null;
		Token Lbr35=null;
		Token Rbr37=null;
		ParserRuleReturnScope ifTrue =null;
		ParserRuleReturnScope ifFalse =null;
		ParserRuleReturnScope orExpr24 =null;
		ParserRuleReturnScope orExpr33 =null;
		ParserRuleReturnScope qContentBlockItem36 =null;

		Object If22_tree=null;
		Object char_literal23_tree=null;
		Object char_literal25_tree=null;
		Object Lbr26_tree=null;
		Object Rbr27_tree=null;
		Object Else28_tree=null;
		Object Lbr29_tree=null;
		Object Rbr30_tree=null;
		Object If31_tree=null;
		Object char_literal32_tree=null;
		Object char_literal34_tree=null;
		Object Lbr35_tree=null;
		Object Rbr37_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( If '(' orExpr ')' Lbr ifTrue= qContentBlockItem Rbr Else Lbr ifFalse= qContentBlockItem Rbr -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE $ifTrue) ^( IF_FALSE $ifFalse) ) | If '(' orExpr ')' Lbr qContentBlockItem Rbr -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qContentBlockItem ) ) )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==If) ) {
				int LA3_1 = input.LA(2);
				if ( (synpred5_QL()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: If '(' orExpr ')' Lbr ifTrue= qContentBlockItem Rbr Else Lbr ifFalse= qContentBlockItem Rbr
					{
					dbg.location(73,4);
					If22=(Token)match(input,If,FOLLOW_If_in_ifStatement302); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_If.add(If22);
					dbg.location(73,8);
					char_literal23=(Token)match(input,38,FOLLOW_38_in_ifStatement305); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal23);
					dbg.location(73,12);
					pushFollow(FOLLOW_orExpr_in_ifStatement307);
					orExpr24=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr24.getTree());dbg.location(73,19);
					char_literal25=(Token)match(input,39,FOLLOW_39_in_ifStatement309); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_39.add(char_literal25);
					dbg.location(73,25);
					Lbr26=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatement313); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Lbr.add(Lbr26);
					dbg.location(73,35);
					pushFollow(FOLLOW_qContentBlockItem_in_ifStatement317);
					ifTrue=qContentBlockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qContentBlockItem.add(ifTrue.getTree());dbg.location(73,54);
					Rbr27=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatement319); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Rbr.add(Rbr27);
					dbg.location(73,58);
					Else28=(Token)match(input,Else,FOLLOW_Else_in_ifStatement321); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Else.add(Else28);
					dbg.location(73,63);
					Lbr29=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatement323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Lbr.add(Lbr29);
					dbg.location(73,74);
					pushFollow(FOLLOW_qContentBlockItem_in_ifStatement327);
					ifFalse=qContentBlockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qContentBlockItem.add(ifFalse.getTree());dbg.location(73,93);
					Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatement329); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Rbr.add(Rbr30);

					// AST REWRITE
					// elements: ifFalse, ifTrue, orExpr
					// token labels: 
					// rule labels: ifTrue, retval, ifFalse
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_ifTrue=new RewriteRuleSubtreeStream(adaptor,"rule ifTrue",ifTrue!=null?ifTrue.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_ifFalse=new RewriteRuleSubtreeStream(adaptor,"rule ifFalse",ifFalse!=null?ifFalse.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 73:98: -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE $ifTrue) ^( IF_FALSE $ifFalse) )
					{
						dbg.location(73,100);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:100: ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE $ifTrue) ^( IF_FALSE $ifFalse) )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(73,102);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
						dbg.location(73,111);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:111: ^( IF_STATEMENT orExpr )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(73,113);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_2);
						dbg.location(73,126);
						adaptor.addChild(root_2, stream_orExpr.nextTree());
						adaptor.addChild(root_1, root_2);
						}
						dbg.location(73,134);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:134: ^( IF_TRUE $ifTrue)
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(73,136);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
						dbg.location(73,145);
						adaptor.addChild(root_2, stream_ifTrue.nextTree());
						adaptor.addChild(root_1, root_2);
						}
						dbg.location(73,153);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:153: ^( IF_FALSE $ifFalse)
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(73,155);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_FALSE, "IF_FALSE"), root_2);
						dbg.location(73,165);
						adaptor.addChild(root_2, stream_ifFalse.nextTree());
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:4: If '(' orExpr ')' Lbr qContentBlockItem Rbr
					{
					dbg.location(74,4);
					If31=(Token)match(input,If,FOLLOW_If_in_ifStatement361); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_If.add(If31);
					dbg.location(74,8);
					char_literal32=(Token)match(input,38,FOLLOW_38_in_ifStatement364); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_38.add(char_literal32);
					dbg.location(74,12);
					pushFollow(FOLLOW_orExpr_in_ifStatement366);
					orExpr33=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr33.getTree());dbg.location(74,19);
					char_literal34=(Token)match(input,39,FOLLOW_39_in_ifStatement368); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_39.add(char_literal34);
					dbg.location(74,25);
					Lbr35=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatement372); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Lbr.add(Lbr35);
					dbg.location(74,29);
					pushFollow(FOLLOW_qContentBlockItem_in_ifStatement374);
					qContentBlockItem36=qContentBlockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem36.getTree());dbg.location(74,47);
					Rbr37=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatement376); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Rbr.add(Rbr37);

					// AST REWRITE
					// elements: orExpr, qContentBlockItem
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 74:52: -> ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qContentBlockItem ) )
					{
						dbg.location(74,54);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:54: ^( IF_BLOCK ^( IF_STATEMENT orExpr ) ^( IF_TRUE qContentBlockItem ) )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(74,56);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
						dbg.location(74,65);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:65: ^( IF_STATEMENT orExpr )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(74,67);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_2);
						dbg.location(74,80);
						adaptor.addChild(root_2, stream_orExpr.nextTree());
						adaptor.addChild(root_1, root_2);
						}
						dbg.location(74,88);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:88: ^( IF_TRUE qContentBlockItem )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(74,90);
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
						dbg.location(74,98);
						adaptor.addChild(root_2, stream_qContentBlockItem.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 5, ifStatement_StartIndex); }

		}
		dbg.location(75, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class constantDeclarationExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constantDeclarationExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: constantDeclarationExpr : QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) ;
	public final QLParser.constantDeclarationExpr_return constantDeclarationExpr() throws RecognitionException {
		QLParser.constantDeclarationExpr_return retval = new QLParser.constantDeclarationExpr_return();
		retval.start = input.LT(1);
		int constantDeclarationExpr_StartIndex = input.index();

		Object root_0 = null;

		Token QuestionVariable38=null;
		Token char_literal39=null;
		Token Int40=null;

		Object QuestionVariable38_tree=null;
		Object char_literal39_tree=null;
		Object Int40_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_Int=new RewriteRuleTokenStream(adaptor,"token Int");

		try { dbg.enterRule(getGrammarFileName(), "constantDeclarationExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:2: ( QuestionVariable ':' Int -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:4: QuestionVariable ':' Int
			{
			dbg.location(83,4);
			QuestionVariable38=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_constantDeclarationExpr412); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable38);
			dbg.location(83,22);
			char_literal39=(Token)match(input,44,FOLLOW_44_in_constantDeclarationExpr415); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_44.add(char_literal39);
			dbg.location(83,26);
			Int40=(Token)match(input,Int,FOLLOW_Int_in_constantDeclarationExpr417); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Int.add(Int40);

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

			root_0 = (Object)adaptor.nil();
			// 83:30: -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
			{
				dbg.location(83,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:33: ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE Int ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(83,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(83,45);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:45: ^( CONST_NAME QuestionVariable )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,47);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_NAME, "CONST_NAME"), root_2);
				dbg.location(83,58);
				adaptor.addChild(root_2, stream_QuestionVariable.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,76);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:76: ^( CONST_TYPE CONST_TYPE_INT )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,78);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(83,89);
				adaptor.addChild(root_2, (Object)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,105);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:105: ^( CONST_VALUE Int )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,107);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(83,119);
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
			if ( state.backtracking>0 ) { memoize(input, 6, constantDeclarationExpr_StartIndex); }

		}
		dbg.location(83, 123);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		Object root_0 = null;

		Token set41=null;

		Object set41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(87,2);
			set41=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set41));
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
			if ( state.backtracking>0 ) { memoize(input, 7, qType_StartIndex); }

		}
		dbg.location(87, 19);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: atom returns [Expr result] : ( Int | Ident | Boolean | QuestionVariable | Money | '(' !x= orExpr ')' !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		Object root_0 = null;

		Token Int42=null;
		Token Ident43=null;
		Token Boolean44=null;
		Token QuestionVariable45=null;
		Token Money46=null;
		Token char_literal47=null;
		Token char_literal48=null;
		ParserRuleReturnScope x =null;

		Object Int42_tree=null;
		Object Ident43_tree=null;
		Object Boolean44_tree=null;
		Object QuestionVariable45_tree=null;
		Object Money46_tree=null;
		Object char_literal47_tree=null;
		Object char_literal48_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:3: ( Int | Ident | Boolean | QuestionVariable | Money | '(' !x= orExpr ')' !)
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
			case 38:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Int
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(90,5);
					Int42=(Token)match(input,Int,FOLLOW_Int_in_atom472); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int42_tree = (Object)adaptor.create(Int42);
					adaptor.addChild(root_0, Int42_tree);
					}
					dbg.location(90,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Int42!=null?Int42.getText():null))); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(91,5);
					Ident43=(Token)match(input,Ident,FOLLOW_Ident_in_atom482); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident43_tree = (Object)adaptor.create(Ident43);
					adaptor.addChild(root_0, Ident43_tree);
					}
					dbg.location(91,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident43!=null?Ident43.getText():null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:5: Boolean
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(92,5);
					Boolean44=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom491); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Boolean44_tree = (Object)adaptor.create(Boolean44);
					adaptor.addChild(root_0, Boolean44_tree);
					}
					dbg.location(92,13);
					if ( state.backtracking==0 ) {retval.result = new Bool((Boolean44!=null?Boolean44.getText():null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:5: QuestionVariable
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(93,5);
					QuestionVariable45=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_atom499); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					QuestionVariable45_tree = (Object)adaptor.create(QuestionVariable45);
					adaptor.addChild(root_0, QuestionVariable45_tree);
					}
					dbg.location(93,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable45!=null?QuestionVariable45.getText():null));}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: Money
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(94,5);
					Money46=(Token)match(input,Money,FOLLOW_Money_in_atom508); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Money46_tree = (Object)adaptor.create(Money46);
					adaptor.addChild(root_0, Money46_tree);
					}
					dbg.location(94,11);
					if ( state.backtracking==0 ) { retval.result = new Int(Integer.parseInt((Money46!=null?Money46.getText():null)));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:6: '(' !x= orExpr ')' !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(95,9);
					char_literal47=(Token)match(input,38,FOLLOW_38_in_atom517); if (state.failed) return retval;dbg.location(95,13);
					pushFollow(FOLLOW_orExpr_in_atom523);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(95,24);
					char_literal48=(Token)match(input,39,FOLLOW_39_in_atom525); if (state.failed) return retval;dbg.location(95,26);
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
			if ( state.backtracking>0 ) { memoize(input, 8, atom_StartIndex); }

		}
		dbg.location(96, 2);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: unExpr returns [Expr result] : ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal49=null;
		Token char_literal50=null;
		Token char_literal51=null;
		ParserRuleReturnScope x =null;

		Object char_literal49_tree=null;
		Object char_literal50_tree=null;
		Object char_literal51_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(99, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 41:
				{
				alt5=1;
				}
				break;
			case 42:
				{
				alt5=2;
				}
				break;
			case 35:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 38:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:8: '+' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(100,11);
					char_literal49=(Token)match(input,41,FOLLOW_41_in_unExpr554); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal49_tree = (Object)adaptor.create(char_literal49);
					root_0 = (Object)adaptor.becomeRoot(char_literal49_tree, root_0);
					}
					dbg.location(100,14);
					pushFollow(FOLLOW_atom_in_unExpr559);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(100,20);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:8: '-' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(101,11);
					char_literal50=(Token)match(input,42,FOLLOW_42_in_unExpr571); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal50_tree = (Object)adaptor.create(char_literal50);
					root_0 = (Object)adaptor.becomeRoot(char_literal50_tree, root_0);
					}
					dbg.location(101,14);
					pushFollow(FOLLOW_atom_in_unExpr576);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(101,20);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:8: '!' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(102,11);
					char_literal51=(Token)match(input,35,FOLLOW_35_in_unExpr587); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal51_tree = (Object)adaptor.create(char_literal51);
					root_0 = (Object)adaptor.becomeRoot(char_literal51_tree, root_0);
					}
					dbg.location(102,14);
					pushFollow(FOLLOW_atom_in_unExpr592);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(102,20);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:8: x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(103,9);
					pushFollow(FOLLOW_atom_in_unExpr605);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(103,18);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.atom_return)x).result:null); }
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
			if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

		}
		dbg.location(104, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(106, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(107,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr641);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(107,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(107,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==40||LA7_0==43) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(107,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:50: ( '*' ^| '/' ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==40) ) {
						alt6=1;
					}
					else if ( (LA6_0==43) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:52: '*' ^
							{
							dbg.location(107,55);
							op=(Token)match(input,40,FOLLOW_40_in_mulExpr651); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:59: '/' ^
							{
							dbg.location(107,62);
							op=(Token)match(input,43,FOLLOW_43_in_mulExpr656); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(107,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr663);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(108,5);
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
			if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

		}
		dbg.location(116, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(119, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(120,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr704);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(120,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(120,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 41 && LA9_0 <= 42)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(120,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==41) ) {
						alt8=1;
					}
					else if ( (LA8_0==42) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:52: '+' ^
							{
							dbg.location(120,55);
							op=(Token)match(input,41,FOLLOW_41_in_addExpr713); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:59: '-' ^
							{
							dbg.location(120,62);
							op=(Token)match(input,42,FOLLOW_42_in_addExpr718); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(120,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr724);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(121,5);
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
			if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

		}
		dbg.location(129, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(131, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(132,12);
			pushFollow(FOLLOW_addExpr_in_relExpr759);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(132,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(132,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==36||(LA11_0 >= 45 && LA11_0 <= 49)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(132,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 45:
						{
						alt10=1;
						}
						break;
					case 46:
						{
						alt10=2;
						}
						break;
					case 48:
						{
						alt10=3;
						}
						break;
					case 49:
						{
						alt10=4;
						}
						break;
					case 47:
						{
						alt10=5;
						}
						break;
					case 36:
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:52: '<' ^
							{
							dbg.location(132,55);
							op=(Token)match(input,45,FOLLOW_45_in_relExpr768); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:57: '<=' ^
							{
							dbg.location(132,61);
							op=(Token)match(input,46,FOLLOW_46_in_relExpr771); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:63: '>' ^
							{
							dbg.location(132,66);
							op=(Token)match(input,48,FOLLOW_48_in_relExpr774); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:68: '>=' ^
							{
							dbg.location(132,72);
							op=(Token)match(input,49,FOLLOW_49_in_relExpr777); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:75: '==' ^
							{
							dbg.location(132,79);
							op=(Token)match(input,47,FOLLOW_47_in_relExpr781); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:82: '!=' ^
							{
							dbg.location(132,86);
							op=(Token)match(input,36,FOLLOW_36_in_relExpr785); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(132,92);
					pushFollow(FOLLOW_addExpr_in_relExpr791);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(133,5);
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
			if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

		}
		dbg.location(153, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:155:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal52=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal52_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(155, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(156,12);
			pushFollow(FOLLOW_relExpr_in_andExpr829);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(156,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(156,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==37) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:48: '&&' ^rhs= relExpr
					{
					dbg.location(156,52);
					string_literal52=(Token)match(input,37,FOLLOW_37_in_andExpr835); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal52_tree = (Object)adaptor.create(string_literal52);
					root_0 = (Object)adaptor.becomeRoot(string_literal52_tree, root_0);
					}
					dbg.location(156,57);
					pushFollow(FOLLOW_relExpr_in_andExpr840);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(156,66);
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
			if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

		}
		dbg.location(157, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:160:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal53=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal53_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(160, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(161,12);
			pushFollow(FOLLOW_andExpr_in_orExpr875);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(161,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(161,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:48: ( '||' ^rhs= andExpr )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:50: '||' ^rhs= andExpr
					{
					dbg.location(161,54);
					string_literal53=(Token)match(input,50,FOLLOW_50_in_orExpr881); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal53_tree = (Object)adaptor.create(string_literal53);
					root_0 = (Object)adaptor.becomeRoot(string_literal53_tree, root_0);
					}
					dbg.location(161,59);
					pushFollow(FOLLOW_andExpr_in_orExpr886);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(161,68);
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
			if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

		}
		dbg.location(162, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "orExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "orExpr"

	// $ANTLR start synpred5_QL
	public final void synpred5_QL_fragment() throws RecognitionException {
		ParserRuleReturnScope ifTrue =null;
		ParserRuleReturnScope ifFalse =null;


		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: ( If '(' orExpr ')' Lbr ifTrue= qContentBlockItem Rbr Else Lbr ifFalse= qContentBlockItem Rbr )
		dbg.enterAlt(1);

		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: If '(' orExpr ')' Lbr ifTrue= qContentBlockItem Rbr Else Lbr ifFalse= qContentBlockItem Rbr
		{
		dbg.location(73,4);
		match(input,If,FOLLOW_If_in_synpred5_QL302); if (state.failed) return;
		dbg.location(73,8);
		match(input,38,FOLLOW_38_in_synpred5_QL305); if (state.failed) return;
		dbg.location(73,12);
		pushFollow(FOLLOW_orExpr_in_synpred5_QL307);
		orExpr();
		state._fsp--;
		if (state.failed) return;
		dbg.location(73,19);
		match(input,39,FOLLOW_39_in_synpred5_QL309); if (state.failed) return;
		dbg.location(73,25);
		match(input,Lbr,FOLLOW_Lbr_in_synpred5_QL313); if (state.failed) return;
		dbg.location(73,35);
		pushFollow(FOLLOW_qContentBlockItem_in_synpred5_QL317);
		ifTrue=qContentBlockItem();
		state._fsp--;
		if (state.failed) return;
		dbg.location(73,54);
		match(input,Rbr,FOLLOW_Rbr_in_synpred5_QL319); if (state.failed) return;
		dbg.location(73,58);
		match(input,Else,FOLLOW_Else_in_synpred5_QL321); if (state.failed) return;
		dbg.location(73,63);
		match(input,Lbr,FOLLOW_Lbr_in_synpred5_QL323); if (state.failed) return;
		dbg.location(73,74);
		pushFollow(FOLLOW_qContentBlockItem_in_synpred5_QL327);
		ifFalse=qContentBlockItem();
		state._fsp--;
		if (state.failed) return;
		dbg.location(73,93);
		match(input,Rbr,FOLLOW_Rbr_in_synpred5_QL329); if (state.failed) return;

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



	public static final BitSet FOLLOW_FormStart_in_parse122 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_FormId_in_parse124 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_qContentBlock_in_parse126 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_qContentBlock153 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_qContentBlock155 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_qContentBlock157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_qDeclaration_in_qContentBlockItem176 = new BitSet(new long[]{0x0000000010080002L});
	public static final BitSet FOLLOW_ifStatement_in_qContentBlockItem181 = new BitSet(new long[]{0x0000000010080002L});
	public static final BitSet FOLLOW_constantDeclarationExpr_in_qContentBlockItem185 = new BitSet(new long[]{0x0000000010080002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration200 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_qDeclaration203 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration205 = new BitSet(new long[]{0x0000000000400010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_qDeclaration241 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_qDeclaration244 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_qDeclaration246 = new BitSet(new long[]{0x0000000000400010L});
	public static final BitSet FOLLOW_qType_in_qDeclaration248 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_qDeclaration250 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_orExpr_in_qDeclaration252 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_qDeclaration254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement302 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_ifStatement305 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement307 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_ifStatement309 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatement313 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_ifStatement317 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatement319 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Else_in_ifStatement321 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatement323 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_ifStatement327 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatement329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement361 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_ifStatement364 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement366 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_ifStatement368 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatement372 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_ifStatement374 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatement376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_constantDeclarationExpr412 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_constantDeclarationExpr415 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Int_in_constantDeclarationExpr417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_atom499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_atom517 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_orExpr_in_atom523 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_atom525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_unExpr554 = new BitSet(new long[]{0x0000004010540010L});
	public static final BitSet FOLLOW_atom_in_unExpr559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_unExpr571 = new BitSet(new long[]{0x0000004010540010L});
	public static final BitSet FOLLOW_atom_in_unExpr576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_unExpr587 = new BitSet(new long[]{0x0000004010540010L});
	public static final BitSet FOLLOW_atom_in_unExpr592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr641 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_40_in_mulExpr651 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_43_in_mulExpr656 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr663 = new BitSet(new long[]{0x0000090000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr704 = new BitSet(new long[]{0x0000060000000002L});
	public static final BitSet FOLLOW_41_in_addExpr713 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_42_in_addExpr718 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr724 = new BitSet(new long[]{0x0000060000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr759 = new BitSet(new long[]{0x0003E01000000002L});
	public static final BitSet FOLLOW_45_in_relExpr768 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_46_in_relExpr771 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_48_in_relExpr774 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_49_in_relExpr777 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_47_in_relExpr781 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_36_in_relExpr785 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr791 = new BitSet(new long[]{0x0003E01000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr829 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_andExpr835 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr840 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr875 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_50_in_orExpr881 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr886 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_If_in_synpred5_QL302 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_synpred5_QL305 = new BitSet(new long[]{0x0000064810540010L});
	public static final BitSet FOLLOW_orExpr_in_synpred5_QL307 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_synpred5_QL309 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Lbr_in_synpred5_QL313 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_synpred5_QL317 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_synpred5_QL319 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Else_in_synpred5_QL321 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Lbr_in_synpred5_QL323 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_synpred5_QL327 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Rbr_in_synpred5_QL329 = new BitSet(new long[]{0x0000000000000002L});
}
