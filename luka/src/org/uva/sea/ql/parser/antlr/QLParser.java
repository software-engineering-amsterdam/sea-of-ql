// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 08:40:50

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.literals.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;


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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Boolean", "COMMENT", "COMPUTED_STATEMENT", 
		"CONST_NAME", "CONST_TYPE", "CONST_TYPE_INT", "CONST_VALUE", "CONST_VAR", 
		"Else", "FormId", "FormStart", "IF_BLOCK", "IF_EXPRESSION", "IF_FALSE", 
		"IF_TRUE", "Ident", "If", "Int", "Lbr", "Money", "NEG_EXPR", "QUESTION_BLOCK", 
		"QUESTION_LABEL", "QUESTION_VAR", "QuestionLabel", "QuestionVariable", 
		"Rbr", "SINGLE_STATEMENT", "UNARY_EXPR", "VALUE_CALC", "VAR_NAME", "VAR_TYPE", 
		"VAR_VALUE", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", 
		"'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int COMPUTED_STATEMENT=6;
	public static final int CONST_NAME=7;
	public static final int CONST_TYPE=8;
	public static final int CONST_TYPE_INT=9;
	public static final int CONST_VALUE=10;
	public static final int CONST_VAR=11;
	public static final int Else=12;
	public static final int FormId=13;
	public static final int FormStart=14;
	public static final int IF_BLOCK=15;
	public static final int IF_EXPRESSION=16;
	public static final int IF_FALSE=17;
	public static final int IF_TRUE=18;
	public static final int Ident=19;
	public static final int If=20;
	public static final int Int=21;
	public static final int Lbr=22;
	public static final int Money=23;
	public static final int NEG_EXPR=24;
	public static final int QUESTION_BLOCK=25;
	public static final int QUESTION_LABEL=26;
	public static final int QUESTION_VAR=27;
	public static final int QuestionLabel=28;
	public static final int QuestionVariable=29;
	public static final int Rbr=30;
	public static final int SINGLE_STATEMENT=31;
	public static final int UNARY_EXPR=32;
	public static final int VALUE_CALC=33;
	public static final int VAR_NAME=34;
	public static final int VAR_TYPE=35;
	public static final int VAR_VALUE=36;
	public static final int WS=37;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "andExpr", "synpred12_QL", "synpred20_QL", "synpred23_QL", 
		"synpred21_QL", "constantValueDeclaration", "qContentBlock", "synpred10_QL", 
		"relExpr", "orExpr", "synpred8_QL", "elseBlock", "synpred6_QL", "qContentBlockItem", 
		"parse", "ifStatement", "synpred25_QL", "synpred4_QL", "synpred18_QL", 
		"synpred7_QL", "synpred22_QL", "synpred13_QL", "atom", "synpred14_QL", 
		"questionDeclaration", "synpred17_QL", "synpred24_QL", "synpred19_QL", 
		"unExpr", "qType", "synpred5_QL", "synpred11_QL", "synpred26_QL", "synpred2_QL", 
		"synpred16_QL", "synpred1_QL", "mulExpr", "synpred3_QL", "synpred15_QL", 
		"addExpr", "synpred9_QL"
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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: parse : FormStart FormId qContentBlock EOF -> ^( FormStart qContentBlock ) ;
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
		dbg.location(59, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:2: ( FormStart FormId qContentBlock EOF -> ^( FormStart qContentBlock ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:4: FormStart FormId qContentBlock EOF
			{
			dbg.location(60,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse131); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(60,14);
			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse133); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormId.add(FormId2);
			dbg.location(60,21);
			pushFollow(FOLLOW_qContentBlock_in_parse135);
			qContentBlock3=qContentBlock();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlock.add(qContentBlock3.getTree());dbg.location(60,35);
			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_parse137); if (state.failed) return retval; 
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
			// 60:39: -> ^( FormStart qContentBlock )
			{
				dbg.location(60,42);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:42: ^( FormStart qContentBlock )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(60,44);
				root_1 = (Object)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(60,54);
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
		dbg.location(60, 67);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: qContentBlock : Lbr qContentBlockItem Rbr -> ^( FormId qContentBlockItem ) ;
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
		dbg.location(64, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:2: ( Lbr qContentBlockItem Rbr -> ^( FormId qContentBlockItem ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: Lbr qContentBlockItem Rbr
			{
			dbg.location(66,5);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qContentBlock162); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(66,9);
			pushFollow(FOLLOW_qContentBlockItem_in_qContentBlock164);
			qContentBlockItem6=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem6.getTree());dbg.location(66,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qContentBlock166); if (state.failed) return retval; 
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
			// 66:31: -> ^( FormId qContentBlockItem )
			{
				dbg.location(66,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:33: ^( FormId qContentBlockItem )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(66,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FormId, "FormId"), root_1);
				dbg.location(66,42);
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
		dbg.location(66, 59);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: qContentBlockItem : ( constantValueDeclaration | questionDeclaration | ifStatement )* ;
	public final QLParser.qContentBlockItem_return qContentBlockItem() throws RecognitionException {
		QLParser.qContentBlockItem_return retval = new QLParser.qContentBlockItem_return();
		retval.start = input.LT(1);
		int qContentBlockItem_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope constantValueDeclaration8 =null;
		ParserRuleReturnScope questionDeclaration9 =null;
		ParserRuleReturnScope ifStatement10 =null;


		try { dbg.enterRule(getGrammarFileName(), "qContentBlockItem");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(68, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:2: ( ( constantValueDeclaration | questionDeclaration | ifStatement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:4: ( constantValueDeclaration | questionDeclaration | ifStatement )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(69,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:4: ( constantValueDeclaration | questionDeclaration | ifStatement )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=4;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==QuestionVariable) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==47) ) {
						int LA1_4 = input.LA(3);
						if ( (LA1_4==QuestionLabel) ) {
							alt1=2;
						}
						else if ( (LA1_4==Boolean||LA1_4==Ident||LA1_4==Int||LA1_4==Money||LA1_4==QuestionVariable||LA1_4==41) ) {
							alt1=1;
						}

					}

				}
				else if ( (LA1_0==If) ) {
					alt1=3;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:5: constantValueDeclaration
					{
					dbg.location(69,5);
					pushFollow(FOLLOW_constantValueDeclaration_in_qContentBlockItem184);
					constantValueDeclaration8=constantValueDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constantValueDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:32: questionDeclaration
					{
					dbg.location(69,32);
					pushFollow(FOLLOW_questionDeclaration_in_qContentBlockItem188);
					questionDeclaration9=questionDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, questionDeclaration9.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:55: ifStatement
					{
					dbg.location(69,55);
					pushFollow(FOLLOW_ifStatement_in_qContentBlockItem193);
					ifStatement10=ifStatement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement10.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 3, qContentBlockItem_StartIndex); }

		}
		dbg.location(69, 68);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "qContentBlockItem");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "qContentBlockItem"


	public static class questionDeclaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "questionDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: questionDeclaration : QuestionVariable ':' QuestionLabel qType ( '(' orExpr ')' )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL QuestionLabel ) ) ;
	public final QLParser.questionDeclaration_return questionDeclaration() throws RecognitionException {
		QLParser.questionDeclaration_return retval = new QLParser.questionDeclaration_return();
		retval.start = input.LT(1);
		int questionDeclaration_StartIndex = input.index();

		Object root_0 = null;

		Token QuestionVariable11=null;
		Token char_literal12=null;
		Token QuestionLabel13=null;
		Token char_literal15=null;
		Token char_literal17=null;
		ParserRuleReturnScope qType14 =null;
		ParserRuleReturnScope orExpr16 =null;

		Object QuestionVariable11_tree=null;
		Object char_literal12_tree=null;
		Object QuestionLabel13_tree=null;
		Object char_literal15_tree=null;
		Object char_literal17_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "questionDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( QuestionVariable ':' QuestionLabel qType ( '(' orExpr ')' )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL QuestionLabel ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: QuestionVariable ':' QuestionLabel qType ( '(' orExpr ')' )?
			{
			dbg.location(73,4);
			QuestionVariable11=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_questionDeclaration208); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable11);
			dbg.location(73,22);
			char_literal12=(Token)match(input,47,FOLLOW_47_in_questionDeclaration211); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_47.add(char_literal12);
			dbg.location(73,26);
			QuestionLabel13=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_questionDeclaration213); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionLabel.add(QuestionLabel13);
			dbg.location(73,40);
			pushFollow(FOLLOW_qType_in_questionDeclaration215);
			qType14=qType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qType.add(qType14.getTree());dbg.location(73,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:46: ( '(' orExpr ')' )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==41) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:47: '(' orExpr ')'
					{
					dbg.location(73,47);
					char_literal15=(Token)match(input,41,FOLLOW_41_in_questionDeclaration218); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_41.add(char_literal15);
					dbg.location(73,51);
					pushFollow(FOLLOW_orExpr_in_questionDeclaration220);
					orExpr16=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr16.getTree());dbg.location(73,58);
					char_literal17=(Token)match(input,42,FOLLOW_42_in_questionDeclaration222); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_42.add(char_literal17);

					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: orExpr, QuestionLabel, QuestionVariable, qType
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 73:65: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL QuestionLabel ) )
			{
				dbg.location(73,67);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:67: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL QuestionLabel ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(73,69);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
				dbg.location(73,84);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:84: ^( QUESTION_VAR ^( VAR_NAME QuestionVariable ) ^( VAR_TYPE qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(73,86);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
				dbg.location(73,99);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:99: ^( VAR_NAME QuestionVariable )
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(73,101);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_NAME, "VAR_NAME"), root_3);
				dbg.location(73,110);
				adaptor.addChild(root_3, stream_QuestionVariable.nextNode());
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(73,128);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:128: ^( VAR_TYPE qType )
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(73,130);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_TYPE, "VAR_TYPE"), root_3);
				dbg.location(73,139);
				adaptor.addChild(root_3, stream_qType.nextTree());
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(73,146);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:146: ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )?
				if ( stream_orExpr.hasNext() ) {
					dbg.location(73,146);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:146: ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) )
					{
					Object root_3 = (Object)adaptor.nil();
					dbg.location(73,148);
					root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_VALUE, "VAR_VALUE"), root_3);
					dbg.location(73,158);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:158: ^( COMPUTED_STATEMENT orExpr )
					{
					Object root_4 = (Object)adaptor.nil();
					dbg.location(73,160);
					root_4 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPUTED_STATEMENT, "COMPUTED_STATEMENT"), root_4);
					dbg.location(73,179);
					adaptor.addChild(root_4, stream_orExpr.nextTree());
					adaptor.addChild(root_3, root_4);
					}

					adaptor.addChild(root_2, root_3);
					}

				}
				stream_orExpr.reset();

				adaptor.addChild(root_1, root_2);
				}
				dbg.location(73,191);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:191: ^( QUESTION_LABEL QuestionLabel )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(73,193);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(73,208);
				adaptor.addChild(root_2, stream_QuestionLabel.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 4, questionDeclaration_StartIndex); }

		}
		dbg.location(74, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "questionDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "questionDeclaration"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: ifStatement : If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? ) ;
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);
		int ifStatement_StartIndex = input.index();

		Object root_0 = null;

		Token If18=null;
		Token char_literal19=null;
		Token char_literal21=null;
		Token Lbr22=null;
		Token Rbr24=null;
		ParserRuleReturnScope orExpr20 =null;
		ParserRuleReturnScope qContentBlockItem23 =null;
		ParserRuleReturnScope elseBlock25 =null;

		Object If18_tree=null;
		Object char_literal19_tree=null;
		Object char_literal21_tree=null;
		Object Lbr22_tree=null;
		Object Rbr24_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:2: ( If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:3: If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )?
			{
			dbg.location(80,3);
			If18=(Token)match(input,If,FOLLOW_If_in_ifStatement281); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If18);
			dbg.location(80,7);
			char_literal19=(Token)match(input,41,FOLLOW_41_in_ifStatement284); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_41.add(char_literal19);
			dbg.location(80,11);
			pushFollow(FOLLOW_orExpr_in_ifStatement286);
			orExpr20=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr20.getTree());dbg.location(80,19);
			char_literal21=(Token)match(input,42,FOLLOW_42_in_ifStatement289); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_42.add(char_literal21);
			dbg.location(80,23);
			Lbr22=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatement291); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr22);
			dbg.location(80,27);
			pushFollow(FOLLOW_qContentBlockItem_in_ifStatement293);
			qContentBlockItem23=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem23.getTree());dbg.location(80,45);
			Rbr24=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatement295); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr24);
			dbg.location(80,50);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:50: ( elseBlock )?
			int alt3=2;
			try { dbg.enterSubRule(3);
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==Else) ) {
				alt3=1;
			}
			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:50: elseBlock
					{
					dbg.location(80,50);
					pushFollow(FOLLOW_elseBlock_in_ifStatement298);
					elseBlock25=elseBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock25.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: qContentBlockItem, elseBlock, orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 80:62: -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? )
			{
				dbg.location(80,64);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:64: ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(80,66);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(80,75);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:75: ^( IF_EXPRESSION orExpr )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(80,77);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_EXPRESSION, "IF_EXPRESSION"), root_2);
				dbg.location(80,92);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(80,100);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:100: ^( IF_TRUE qContentBlockItem )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(80,102);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
				dbg.location(80,110);
				adaptor.addChild(root_2, stream_qContentBlockItem.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(80,129);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:129: ( ^( IF_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(80,129);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:129: ^( IF_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(80,131);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_FALSE, "IF_FALSE"), root_2);
					dbg.location(80,140);
					adaptor.addChild(root_2, stream_elseBlock.nextTree());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_elseBlock.reset();

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
			if ( state.backtracking>0 ) { memoize(input, 5, ifStatement_StartIndex); }

		}
		dbg.location(81, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class elseBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "elseBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: elseBlock : Else Lbr qContentBlockItem Rbr -> qContentBlockItem ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);
		int elseBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Else26=null;
		Token Lbr27=null;
		Token Rbr29=null;
		ParserRuleReturnScope qContentBlockItem28 =null;

		Object Else26_tree=null;
		Object Lbr27_tree=null;
		Object Rbr29_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(83, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:2: ( Else Lbr qContentBlockItem Rbr -> qContentBlockItem )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:3: Else Lbr qContentBlockItem Rbr
			{
			dbg.location(84,3);
			Else26=(Token)match(input,Else,FOLLOW_Else_in_elseBlock336); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else26);
			dbg.location(84,8);
			Lbr27=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock338); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr27);
			dbg.location(84,12);
			pushFollow(FOLLOW_qContentBlockItem_in_elseBlock340);
			qContentBlockItem28=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem28.getTree());dbg.location(84,30);
			Rbr29=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock342); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr29);

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
			// 84:34: -> qContentBlockItem
			{
				dbg.location(84,37);
				adaptor.addChild(root_0, stream_qContentBlockItem.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 6, elseBlock_StartIndex); }

		}
		dbg.location(85, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "elseBlock");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "elseBlock"


	public static class constantValueDeclaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constantValueDeclaration"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: constantValueDeclaration : QuestionVariable ':' atom -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) ;
	public final QLParser.constantValueDeclaration_return constantValueDeclaration() throws RecognitionException {
		QLParser.constantValueDeclaration_return retval = new QLParser.constantValueDeclaration_return();
		retval.start = input.LT(1);
		int constantValueDeclaration_StartIndex = input.index();

		Object root_0 = null;

		Token QuestionVariable30=null;
		Token char_literal31=null;
		ParserRuleReturnScope atom32 =null;

		Object QuestionVariable30_tree=null;
		Object char_literal31_tree=null;
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try { dbg.enterRule(getGrammarFileName(), "constantValueDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:2: ( QuestionVariable ':' atom -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:4: QuestionVariable ':' atom
			{
			dbg.location(89,4);
			QuestionVariable30=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_constantValueDeclaration362); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable30);
			dbg.location(89,22);
			char_literal31=(Token)match(input,47,FOLLOW_47_in_constantValueDeclaration365); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_47.add(char_literal31);
			dbg.location(89,26);
			pushFollow(FOLLOW_atom_in_constantValueDeclaration367);
			atom32=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(atom32.getTree());
			// AST REWRITE
			// elements: QuestionVariable, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 89:31: -> ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
			{
				dbg.location(89,34);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:34: ^( CONST_VAR ^( CONST_NAME QuestionVariable ) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(89,36);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(89,46);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:46: ^( CONST_NAME QuestionVariable )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(89,48);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_NAME, "CONST_NAME"), root_2);
				dbg.location(89,59);
				adaptor.addChild(root_2, stream_QuestionVariable.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(89,77);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:77: ^( CONST_TYPE CONST_TYPE_INT )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(89,79);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(89,90);
				adaptor.addChild(root_2, (Object)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(89,106);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:106: ^( CONST_VALUE atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(89,108);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(89,121);
				adaptor.addChild(root_2, stream_atom.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 7, constantValueDeclaration_StartIndex); }

		}
		dbg.location(90, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constantValueDeclaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "constantValueDeclaration"


	public static class qType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "qType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: qType : ( Boolean | Money );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		Object root_0 = null;

		Token set33=null;

		Object set33_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(93, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:2: ( Boolean | Money )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(94,2);
			set33=input.LT(1);
			if ( input.LA(1)==Boolean||input.LA(1)==Money ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set33));
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
			if ( state.backtracking>0 ) { memoize(input, 8, qType_StartIndex); }

		}
		dbg.location(94, 19);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:1: atom returns [Expr result] : ( Int -> ^( SINGLE_STATEMENT Int ) | Ident -> ^( SINGLE_STATEMENT Ident ) | Boolean -> ^( SINGLE_STATEMENT Boolean ) | QuestionVariable -> ^( SINGLE_STATEMENT QuestionVariable ) | Money -> ^( SINGLE_STATEMENT Money ) | '(' x= orExpr ')' -> ^( COMPUTED_STATEMENT orExpr ) );
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		Object root_0 = null;

		Token Int34=null;
		Token Ident35=null;
		Token Boolean36=null;
		Token QuestionVariable37=null;
		Token Money38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		ParserRuleReturnScope x =null;

		Object Int34_tree=null;
		Object Ident35_tree=null;
		Object Boolean36_tree=null;
		Object QuestionVariable37_tree=null;
		Object Money38_tree=null;
		Object char_literal39_tree=null;
		Object char_literal40_tree=null;
		RewriteRuleTokenStream stream_Money=new RewriteRuleTokenStream(adaptor,"token Money");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_QuestionVariable=new RewriteRuleTokenStream(adaptor,"token QuestionVariable");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");
		RewriteRuleTokenStream stream_Int=new RewriteRuleTokenStream(adaptor,"token Int");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(96, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:3: ( Int -> ^( SINGLE_STATEMENT Int ) | Ident -> ^( SINGLE_STATEMENT Ident ) | Boolean -> ^( SINGLE_STATEMENT Boolean ) | QuestionVariable -> ^( SINGLE_STATEMENT QuestionVariable ) | Money -> ^( SINGLE_STATEMENT Money ) | '(' x= orExpr ')' -> ^( COMPUTED_STATEMENT orExpr ) )
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
			case 41:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: Int
					{
					dbg.location(97,5);
					Int34=(Token)match(input,Int,FOLLOW_Int_in_atom425); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Int.add(Int34);
					dbg.location(97,11);
					if ( state.backtracking==0 ) { retval.result = new IntNode(Integer.parseInt((Int34!=null?Int34.getText():null))); }
					// AST REWRITE
					// elements: Int
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 97:67: -> ^( SINGLE_STATEMENT Int )
					{
						dbg.location(97,70);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:70: ^( SINGLE_STATEMENT Int )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(97,72);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(97,89);
						adaptor.addChild(root_1, stream_Int.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: Ident
					{
					dbg.location(98,5);
					Ident35=(Token)match(input,Ident,FOLLOW_Ident_in_atom443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Ident.add(Ident35);
					dbg.location(98,11);
					if ( state.backtracking==0 ) { retval.result = new Ident((Ident35!=null?Ident35.getText():null)); }
					// AST REWRITE
					// elements: Ident
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 98:49: -> ^( SINGLE_STATEMENT Ident )
					{
						dbg.location(98,52);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:52: ^( SINGLE_STATEMENT Ident )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(98,54);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(98,71);
						adaptor.addChild(root_1, stream_Ident.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:5: Boolean
					{
					dbg.location(99,5);
					Boolean36=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom459); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Boolean.add(Boolean36);
					dbg.location(99,13);
					if ( state.backtracking==0 ) {retval.result = new BoolNode((Boolean36!=null?Boolean36.getText():null));}
					// AST REWRITE
					// elements: Boolean
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 99:54: -> ^( SINGLE_STATEMENT Boolean )
					{
						dbg.location(99,57);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:57: ^( SINGLE_STATEMENT Boolean )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(99,59);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(99,76);
						adaptor.addChild(root_1, stream_Boolean.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: QuestionVariable
					{
					dbg.location(100,5);
					QuestionVariable37=(Token)match(input,QuestionVariable,FOLLOW_QuestionVariable_in_atom475); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_QuestionVariable.add(QuestionVariable37);
					dbg.location(100,23);
					if ( state.backtracking==0 ) { retval.result = new Ident((QuestionVariable37!=null?QuestionVariable37.getText():null));}
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

					root_0 = (Object)adaptor.nil();
					// 100:71: -> ^( SINGLE_STATEMENT QuestionVariable )
					{
						dbg.location(100,74);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:74: ^( SINGLE_STATEMENT QuestionVariable )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(100,76);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(100,93);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: Money
					{
					dbg.location(101,5);
					Money38=(Token)match(input,Money,FOLLOW_Money_in_atom492); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Money.add(Money38);
					dbg.location(101,11);
					if ( state.backtracking==0 ) { retval.result = new MoneyNode(Integer.parseInt((Money38!=null?Money38.getText():null)));}
					// AST REWRITE
					// elements: Money
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 101:70: -> ^( SINGLE_STATEMENT Money )
					{
						dbg.location(101,73);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:73: ^( SINGLE_STATEMENT Money )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(101,75);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(101,92);
						adaptor.addChild(root_1, stream_Money.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:6: '(' x= orExpr ')'
					{
					dbg.location(102,6);
					char_literal39=(Token)match(input,41,FOLLOW_41_in_atom509); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_41.add(char_literal39);
					dbg.location(102,12);
					pushFollow(FOLLOW_orExpr_in_atom514);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(x.getTree());dbg.location(102,20);
					char_literal40=(Token)match(input,42,FOLLOW_42_in_atom516); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_42.add(char_literal40);
					dbg.location(102,24);
					if ( state.backtracking==0 ) { retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); }
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

					root_0 = (Object)adaptor.nil();
					// 102:49: -> ^( COMPUTED_STATEMENT orExpr )
					{
						dbg.location(102,52);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:52: ^( COMPUTED_STATEMENT orExpr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(102,54);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPUTED_STATEMENT, "COMPUTED_STATEMENT"), root_1);
						dbg.location(102,73);
						adaptor.addChild(root_1, stream_orExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 9, atom_StartIndex); }

		}
		dbg.location(103, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: unExpr returns [Expr result] : ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal41=null;
		Token char_literal42=null;
		Token char_literal43=null;
		ParserRuleReturnScope x =null;

		Object char_literal41_tree=null;
		Object char_literal42_tree=null;
		Object char_literal43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(106, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom )
			int alt5=4;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			switch ( input.LA(1) ) {
			case 44:
				{
				alt5=1;
				}
				break;
			case 45:
				{
				alt5=2;
				}
				break;
			case 38:
				{
				alt5=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case QuestionVariable:
			case 41:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:8: '+' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(107,11);
					char_literal41=(Token)match(input,44,FOLLOW_44_in_unExpr552); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal41_tree = (Object)adaptor.create(char_literal41);
					root_0 = (Object)adaptor.becomeRoot(char_literal41_tree, root_0);
					}
					dbg.location(107,14);
					pushFollow(FOLLOW_atom_in_unExpr557);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(107,20);
					if ( state.backtracking==0 ) { retval.result = new Pos((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:8: '-' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(108,11);
					char_literal42=(Token)match(input,45,FOLLOW_45_in_unExpr569); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal42_tree = (Object)adaptor.create(char_literal42);
					root_0 = (Object)adaptor.becomeRoot(char_literal42_tree, root_0);
					}
					dbg.location(108,14);
					pushFollow(FOLLOW_atom_in_unExpr574);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(108,20);
					if ( state.backtracking==0 ) { retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:8: '!' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(109,11);
					char_literal43=(Token)match(input,38,FOLLOW_38_in_unExpr585); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal43_tree = (Object)adaptor.create(char_literal43);
					root_0 = (Object)adaptor.becomeRoot(char_literal43_tree, root_0);
					}
					dbg.location(109,14);
					pushFollow(FOLLOW_atom_in_unExpr590);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(109,20);
					if ( state.backtracking==0 ) { retval.result = new Not((x!=null?((QLParser.atom_return)x).result:null)); }
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:8: x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(110,9);
					pushFollow(FOLLOW_atom_in_unExpr603);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());
					dbg.location(110,18);
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
			if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

		}
		dbg.location(111, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(113, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(114,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr639);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(114,20);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); }dbg.location(114,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==43||LA7_0==46) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(114,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:50: ( '*' ^| '/' ^)
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==43) ) {
						alt6=1;
					}
					else if ( (LA6_0==46) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:52: '*' ^
							{
							dbg.location(114,55);
							op=(Token)match(input,43,FOLLOW_43_in_mulExpr649); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:59: '/' ^
							{
							dbg.location(114,62);
							op=(Token)match(input,46,FOLLOW_46_in_mulExpr654); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(114,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr661);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(115,5);
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
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

		}
		dbg.location(123, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(126, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(127,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr702);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(127,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); }dbg.location(127,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 44 && LA9_0 <= 45)) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(127,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:51: ( '+' ^| '-' ^)
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==44) ) {
						alt8=1;
					}
					else if ( (LA8_0==45) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:52: '+' ^
							{
							dbg.location(127,55);
							op=(Token)match(input,44,FOLLOW_44_in_addExpr711); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:59: '-' ^
							{
							dbg.location(127,62);
							op=(Token)match(input,45,FOLLOW_45_in_addExpr716); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(127,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr722);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(128,5);
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
			if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

		}
		dbg.location(136, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:138:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(138, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(139,12);
			pushFollow(FOLLOW_addExpr_in_relExpr757);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(139,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); }dbg.location(139,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==39||(LA11_0 >= 48 && LA11_0 <= 52)) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(139,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt10=6;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					switch ( input.LA(1) ) {
					case 48:
						{
						alt10=1;
						}
						break;
					case 49:
						{
						alt10=2;
						}
						break;
					case 51:
						{
						alt10=3;
						}
						break;
					case 52:
						{
						alt10=4;
						}
						break;
					case 50:
						{
						alt10=5;
						}
						break;
					case 39:
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:52: '<' ^
							{
							dbg.location(139,55);
							op=(Token)match(input,48,FOLLOW_48_in_relExpr766); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:57: '<=' ^
							{
							dbg.location(139,61);
							op=(Token)match(input,49,FOLLOW_49_in_relExpr769); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:63: '>' ^
							{
							dbg.location(139,66);
							op=(Token)match(input,51,FOLLOW_51_in_relExpr772); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:68: '>=' ^
							{
							dbg.location(139,72);
							op=(Token)match(input,52,FOLLOW_52_in_relExpr775); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:75: '==' ^
							{
							dbg.location(139,79);
							op=(Token)match(input,50,FOLLOW_50_in_relExpr779); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:82: '!=' ^
							{
							dbg.location(139,86);
							op=(Token)match(input,39,FOLLOW_39_in_relExpr783); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(139,92);
					pushFollow(FOLLOW_addExpr_in_relExpr789);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(140,5);
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
			if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

		}
		dbg.location(160, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:162:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal44=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal44_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(162, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(163,12);
			pushFollow(FOLLOW_relExpr_in_andExpr828);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(163,21);
			if ( state.backtracking==0 ) { retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); }dbg.location(163,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==40) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:163:48: '&&' ^rhs= relExpr
					{
					dbg.location(163,52);
					string_literal44=(Token)match(input,40,FOLLOW_40_in_andExpr834); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal44_tree = (Object)adaptor.create(string_literal44);
					root_0 = (Object)adaptor.becomeRoot(string_literal44_tree, root_0);
					}
					dbg.location(163,57);
					pushFollow(FOLLOW_relExpr_in_andExpr839);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(163,66);
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
			if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

		}
		dbg.location(164, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:167:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal45=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal45_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(167, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:168:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:168:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(168,12);
			pushFollow(FOLLOW_andExpr_in_orExpr874);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(168,21);
			if ( state.backtracking==0 ) { retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); }dbg.location(168,48);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:168:48: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==53) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:168:50: '||' ^rhs= andExpr
					{
					dbg.location(168,54);
					string_literal45=(Token)match(input,53,FOLLOW_53_in_orExpr880); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal45_tree = (Object)adaptor.create(string_literal45);
					root_0 = (Object)adaptor.becomeRoot(string_literal45_tree, root_0);
					}
					dbg.location(168,59);
					pushFollow(FOLLOW_andExpr_in_orExpr885);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());
					dbg.location(168,68);
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
			if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

		}
		dbg.location(169, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse131 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_FormId_in_parse133 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_qContentBlock_in_parse135 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_qContentBlock162 = new BitSet(new long[]{0x0000000060100000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_qContentBlock164 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Rbr_in_qContentBlock166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantValueDeclaration_in_qContentBlockItem184 = new BitSet(new long[]{0x0000000020100002L});
	public static final BitSet FOLLOW_questionDeclaration_in_qContentBlockItem188 = new BitSet(new long[]{0x0000000020100002L});
	public static final BitSet FOLLOW_ifStatement_in_qContentBlockItem193 = new BitSet(new long[]{0x0000000020100002L});
	public static final BitSet FOLLOW_QuestionVariable_in_questionDeclaration208 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_questionDeclaration211 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_questionDeclaration213 = new BitSet(new long[]{0x0000000000800010L});
	public static final BitSet FOLLOW_qType_in_questionDeclaration215 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_41_in_questionDeclaration218 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_orExpr_in_questionDeclaration220 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_questionDeclaration222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement281 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_ifStatement284 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement286 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_ifStatement289 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatement291 = new BitSet(new long[]{0x0000000060100000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_ifStatement293 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatement295 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_elseBlock_in_ifStatement298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock336 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock338 = new BitSet(new long[]{0x0000000060100000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_elseBlock340 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_constantValueDeclaration362 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_constantValueDeclaration365 = new BitSet(new long[]{0x0000020020A80010L});
	public static final BitSet FOLLOW_atom_in_constantValueDeclaration367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QuestionVariable_in_atom475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_atom509 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_orExpr_in_atom514 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_atom516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_unExpr552 = new BitSet(new long[]{0x0000020020A80010L});
	public static final BitSet FOLLOW_atom_in_unExpr557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unExpr569 = new BitSet(new long[]{0x0000020020A80010L});
	public static final BitSet FOLLOW_atom_in_unExpr574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_unExpr585 = new BitSet(new long[]{0x0000020020A80010L});
	public static final BitSet FOLLOW_atom_in_unExpr590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr639 = new BitSet(new long[]{0x0000480000000002L});
	public static final BitSet FOLLOW_43_in_mulExpr649 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_46_in_mulExpr654 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr661 = new BitSet(new long[]{0x0000480000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr702 = new BitSet(new long[]{0x0000300000000002L});
	public static final BitSet FOLLOW_44_in_addExpr711 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_45_in_addExpr716 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr722 = new BitSet(new long[]{0x0000300000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr757 = new BitSet(new long[]{0x001F008000000002L});
	public static final BitSet FOLLOW_48_in_relExpr766 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_49_in_relExpr769 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_51_in_relExpr772 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_52_in_relExpr775 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_50_in_relExpr779 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_39_in_relExpr783 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_addExpr_in_relExpr789 = new BitSet(new long[]{0x001F008000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr828 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_40_in_andExpr834 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_relExpr_in_andExpr839 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr874 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_53_in_orExpr880 = new BitSet(new long[]{0x0000324020A80010L});
	public static final BitSet FOLLOW_andExpr_in_orExpr885 = new BitSet(new long[]{0x0020000000000002L});
}
