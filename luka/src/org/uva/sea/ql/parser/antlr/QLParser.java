// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-23 13:47:21

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOL_LITERAL", "BOOL_TYPE", "Boolean", 
		"COMMENT", "COMPUTED_STATEMENT", "CONST_NAME", "CONST_TYPE", "CONST_TYPE_INT", 
		"CONST_VALUE", "CONST_VAR", "Else", "FormStart", "IDENT_LITERAL", "IF_BLOCK", 
		"IF_EXPRESSION", "IF_FALSE", "IF_TRUE", "INT_LITERAL", "INT_TYPE", "Ident", 
		"If", "Int", "Lbr", "MONEY_TYPE", "Money", "NEG_EXPR", "QUESTION_BLOCK", 
		"QUESTION_LABEL", "QUESTION_VAR", "QuestionLabel", "Rbr", "SINGLE_STATEMENT", 
		"STR_TYPE", "UNARY_EXPR", "VALUE_CALC", "VAR_NAME", "VAR_TYPE", "VAR_VALUE", 
		"WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", 
		"':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int BOOL_LITERAL=4;
	public static final int BOOL_TYPE=5;
	public static final int Boolean=6;
	public static final int COMMENT=7;
	public static final int COMPUTED_STATEMENT=8;
	public static final int CONST_NAME=9;
	public static final int CONST_TYPE=10;
	public static final int CONST_TYPE_INT=11;
	public static final int CONST_VALUE=12;
	public static final int CONST_VAR=13;
	public static final int Else=14;
	public static final int FormStart=15;
	public static final int IDENT_LITERAL=16;
	public static final int IF_BLOCK=17;
	public static final int IF_EXPRESSION=18;
	public static final int IF_FALSE=19;
	public static final int IF_TRUE=20;
	public static final int INT_LITERAL=21;
	public static final int INT_TYPE=22;
	public static final int Ident=23;
	public static final int If=24;
	public static final int Int=25;
	public static final int Lbr=26;
	public static final int MONEY_TYPE=27;
	public static final int Money=28;
	public static final int NEG_EXPR=29;
	public static final int QUESTION_BLOCK=30;
	public static final int QUESTION_LABEL=31;
	public static final int QUESTION_VAR=32;
	public static final int QuestionLabel=33;
	public static final int Rbr=34;
	public static final int SINGLE_STATEMENT=35;
	public static final int STR_TYPE=36;
	public static final int UNARY_EXPR=37;
	public static final int VALUE_CALC=38;
	public static final int VAR_NAME=39;
	public static final int VAR_TYPE=40;
	public static final int VAR_VALUE=41;
	public static final int WS=42;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "relExpr", "synpred21_QL", "orExpr", "synpred15_QL", "constantValueDeclaration", 
		"synpred11_QL", "synpred19_QL", "qType", "synpred7_QL", "unExpr", "synpred6_QL", 
		"synpred23_QL", "synpred22_QL", "mulExpr", "andExpr", "synpred16_QL", 
		"synpred20_QL", "synpred1_QL", "synpred13_QL", "synpred14_QL", "synpred24_QL", 
		"elseBlock", "synpred17_QL", "parse", "ifStatement", "synpred2_QL", "synpred12_QL", 
		"synpred4_QL", "questionDeclaration", "synpred18_QL", "synpred3_QL", "qContentBlock", 
		"addExpr", "synpred8_QL", "synpred25_QL", "atom", "synpred5_QL", "qContentBlockItem", 
		"synpred9_QL", "synpred10_QL"
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: parse : FormStart Ident qContentBlock EOF -> ^( FormStart qContentBlock ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		Object root_0 = null;

		Token FormStart1=null;
		Token Ident2=null;
		Token EOF4=null;
		ParserRuleReturnScope qContentBlock3 =null;

		Object FormStart1_tree=null;
		Object Ident2_tree=null;
		Object EOF4_tree=null;
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_qContentBlock=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlock");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: ( FormStart Ident qContentBlock EOF -> ^( FormStart qContentBlock ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: FormStart Ident qContentBlock EOF
			{
			dbg.location(67,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse152); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);
			dbg.location(67,14);
			Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_parse154); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident2);
			dbg.location(67,20);
			pushFollow(FOLLOW_qContentBlock_in_parse156);
			qContentBlock3=qContentBlock();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlock.add(qContentBlock3.getTree());dbg.location(67,34);
			EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_parse158); if (state.failed) return retval; 
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
			// 67:38: -> ^( FormStart qContentBlock )
			{
				dbg.location(67,41);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:41: ^( FormStart qContentBlock )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(67,43);
				root_1 = (Object)adaptor.becomeRoot(stream_FormStart.nextNode(), root_1);
				dbg.location(67,53);
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
		dbg.location(67, 66);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: qContentBlock : Lbr qContentBlockItem Rbr -> ^( Ident qContentBlockItem ) ;
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
		dbg.location(71, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( Lbr qContentBlockItem Rbr -> ^( Ident qContentBlockItem ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: Lbr qContentBlockItem Rbr
			{
			dbg.location(73,5);
			Lbr5=(Token)match(input,Lbr,FOLLOW_Lbr_in_qContentBlock183); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr5);
			dbg.location(73,9);
			pushFollow(FOLLOW_qContentBlockItem_in_qContentBlock185);
			qContentBlockItem6=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem6.getTree());dbg.location(73,27);
			Rbr7=(Token)match(input,Rbr,FOLLOW_Rbr_in_qContentBlock187); if (state.failed) return retval; 
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
			// 73:31: -> ^( Ident qContentBlockItem )
			{
				dbg.location(73,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:33: ^( Ident qContentBlockItem )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(73,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(Ident, "Ident"), root_1);
				dbg.location(73,41);
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
		dbg.location(73, 58);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: qContentBlockItem : ( constantValueDeclaration | questionDeclaration | ifStatement )* ;
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
		dbg.location(75, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:2: ( ( constantValueDeclaration | questionDeclaration | ifStatement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: ( constantValueDeclaration | questionDeclaration | ifStatement )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(76,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: ( constantValueDeclaration | questionDeclaration | ifStatement )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=4;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==Ident) ) {
					int LA1_2 = input.LA(2);
					if ( (LA1_2==52) ) {
						int LA1_4 = input.LA(3);
						if ( (LA1_4==QuestionLabel) ) {
							alt1=2;
						}
						else if ( (LA1_4==Boolean||LA1_4==Ident||LA1_4==Int||LA1_4==Money||LA1_4==46) ) {
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:5: constantValueDeclaration
					{
					dbg.location(76,5);
					pushFollow(FOLLOW_constantValueDeclaration_in_qContentBlockItem205);
					constantValueDeclaration8=constantValueDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constantValueDeclaration8.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:32: questionDeclaration
					{
					dbg.location(76,32);
					pushFollow(FOLLOW_questionDeclaration_in_qContentBlockItem209);
					questionDeclaration9=questionDeclaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, questionDeclaration9.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:55: ifStatement
					{
					dbg.location(76,55);
					pushFollow(FOLLOW_ifStatement_in_qContentBlockItem214);
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
		dbg.location(76, 69);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: questionDeclaration : varName= Ident ':' label= QuestionLabel qType ( '(' orExpr ')' )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName) ^( qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL ^( STR_TYPE $label) ) ) ;
	public final QLParser.questionDeclaration_return questionDeclaration() throws RecognitionException {
		QLParser.questionDeclaration_return retval = new QLParser.questionDeclaration_return();
		retval.start = input.LT(1);
		int questionDeclaration_StartIndex = input.index();

		Object root_0 = null;

		Token varName=null;
		Token label=null;
		Token char_literal11=null;
		Token char_literal13=null;
		Token char_literal15=null;
		ParserRuleReturnScope qType12 =null;
		ParserRuleReturnScope orExpr14 =null;

		Object varName_tree=null;
		Object label_tree=null;
		Object char_literal11_tree=null;
		Object char_literal13_tree=null;
		Object char_literal15_tree=null;
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleSubtreeStream stream_qType=new RewriteRuleSubtreeStream(adaptor,"rule qType");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "questionDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:2: (varName= Ident ':' label= QuestionLabel qType ( '(' orExpr ')' )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName) ^( qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL ^( STR_TYPE $label) ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:4: varName= Ident ':' label= QuestionLabel qType ( '(' orExpr ')' )?
			{
			dbg.location(80,11);
			varName=(Token)match(input,Ident,FOLLOW_Ident_in_questionDeclaration232); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(varName);
			dbg.location(80,19);
			char_literal11=(Token)match(input,52,FOLLOW_52_in_questionDeclaration235); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_52.add(char_literal11);
			dbg.location(80,29);
			label=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_questionDeclaration240); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_QuestionLabel.add(label);
			dbg.location(80,44);
			pushFollow(FOLLOW_qType_in_questionDeclaration242);
			qType12=qType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qType.add(qType12.getTree());dbg.location(80,50);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:50: ( '(' orExpr ')' )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==46) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:51: '(' orExpr ')'
					{
					dbg.location(80,51);
					char_literal13=(Token)match(input,46,FOLLOW_46_in_questionDeclaration245); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_46.add(char_literal13);
					dbg.location(80,55);
					pushFollow(FOLLOW_orExpr_in_questionDeclaration247);
					orExpr14=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(orExpr14.getTree());dbg.location(80,62);
					char_literal15=(Token)match(input,47,FOLLOW_47_in_questionDeclaration249); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_47.add(char_literal15);

					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: label, qType, varName, orExpr
			// token labels: varName, label
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_varName=new RewriteRuleTokenStream(adaptor,"token varName",varName);
			RewriteRuleTokenStream stream_label=new RewriteRuleTokenStream(adaptor,"token label",label);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 80:69: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName) ^( qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL ^( STR_TYPE $label) ) )
			{
				dbg.location(80,71);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:71: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName) ^( qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? ) ^( QUESTION_LABEL ^( STR_TYPE $label) ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(80,73);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
				dbg.location(80,88);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:88: ^( QUESTION_VAR ^( IDENT_LITERAL $varName) ^( qType ) ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )? )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(80,90);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
				dbg.location(80,103);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:103: ^( IDENT_LITERAL $varName)
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(80,105);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT_LITERAL, "IDENT_LITERAL"), root_3);
				dbg.location(80,120);
				adaptor.addChild(root_3, stream_varName.nextNode());
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(80,129);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:129: ^( qType )
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(80,131);
				root_3 = (Object)adaptor.becomeRoot(stream_qType.nextNode(), root_3);
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(80,138);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:138: ( ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) ) )?
				if ( stream_orExpr.hasNext() ) {
					dbg.location(80,138);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:138: ^( VAR_VALUE ^( COMPUTED_STATEMENT orExpr ) )
					{
					Object root_3 = (Object)adaptor.nil();
					dbg.location(80,140);
					root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_VALUE, "VAR_VALUE"), root_3);
					dbg.location(80,150);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:150: ^( COMPUTED_STATEMENT orExpr )
					{
					Object root_4 = (Object)adaptor.nil();
					dbg.location(80,152);
					root_4 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPUTED_STATEMENT, "COMPUTED_STATEMENT"), root_4);
					dbg.location(80,171);
					adaptor.addChild(root_4, stream_orExpr.nextTree());
					adaptor.addChild(root_3, root_4);
					}

					adaptor.addChild(root_2, root_3);
					}

				}
				stream_orExpr.reset();

				adaptor.addChild(root_1, root_2);
				}
				dbg.location(80,183);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:183: ^( QUESTION_LABEL ^( STR_TYPE $label) )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(80,185);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(80,200);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:200: ^( STR_TYPE $label)
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(80,202);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(STR_TYPE, "STR_TYPE"), root_3);
				dbg.location(80,212);
				adaptor.addChild(root_3, stream_label.nextNode());
				adaptor.addChild(root_2, root_3);
				}

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
		dbg.location(81, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: ifStatement : If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? ) ;
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);
		int ifStatement_StartIndex = input.index();

		Object root_0 = null;

		Token If16=null;
		Token char_literal17=null;
		Token char_literal19=null;
		Token Lbr20=null;
		Token Rbr22=null;
		ParserRuleReturnScope orExpr18 =null;
		ParserRuleReturnScope qContentBlockItem21 =null;
		ParserRuleReturnScope elseBlock23 =null;

		Object If16_tree=null;
		Object char_literal17_tree=null;
		Object char_literal19_tree=null;
		Object Lbr20_tree=null;
		Object Rbr22_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:2: ( If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:3: If '(' orExpr ')' Lbr qContentBlockItem Rbr ( elseBlock )?
			{
			dbg.location(89,3);
			If16=(Token)match(input,If,FOLLOW_If_in_ifStatement314); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If16);
			dbg.location(89,7);
			char_literal17=(Token)match(input,46,FOLLOW_46_in_ifStatement317); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_46.add(char_literal17);
			dbg.location(89,11);
			pushFollow(FOLLOW_orExpr_in_ifStatement319);
			orExpr18=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr18.getTree());dbg.location(89,19);
			char_literal19=(Token)match(input,47,FOLLOW_47_in_ifStatement322); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_47.add(char_literal19);
			dbg.location(89,23);
			Lbr20=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatement324); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr20);
			dbg.location(89,27);
			pushFollow(FOLLOW_qContentBlockItem_in_ifStatement326);
			qContentBlockItem21=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem21.getTree());dbg.location(89,45);
			Rbr22=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatement328); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr22);
			dbg.location(89,50);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:50: ( elseBlock )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:50: elseBlock
					{
					dbg.location(89,50);
					pushFollow(FOLLOW_elseBlock_in_ifStatement331);
					elseBlock23=elseBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock23.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: qContentBlockItem, orExpr, elseBlock
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 89:62: -> ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? )
			{
				dbg.location(89,64);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:64: ^( IF_BLOCK ^( IF_EXPRESSION orExpr ) ^( IF_TRUE qContentBlockItem ) ( ^( IF_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(89,66);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(89,76);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:76: ^( IF_EXPRESSION orExpr )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(89,78);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_EXPRESSION, "IF_EXPRESSION"), root_2);
				dbg.location(89,92);
				adaptor.addChild(root_2, stream_orExpr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(89,100);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:100: ^( IF_TRUE qContentBlockItem )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(89,102);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
				dbg.location(89,110);
				adaptor.addChild(root_2, stream_qContentBlockItem.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(89,129);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:129: ( ^( IF_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(89,129);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:129: ^( IF_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(89,131);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_FALSE, "IF_FALSE"), root_2);
					dbg.location(89,140);
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
		dbg.location(90, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: elseBlock : Else Lbr qContentBlockItem Rbr -> qContentBlockItem ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);
		int elseBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Else24=null;
		Token Lbr25=null;
		Token Rbr27=null;
		ParserRuleReturnScope qContentBlockItem26 =null;

		Object Else24_tree=null;
		Object Lbr25_tree=null;
		Object Rbr27_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_qContentBlockItem=new RewriteRuleSubtreeStream(adaptor,"rule qContentBlockItem");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(92, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:2: ( Else Lbr qContentBlockItem Rbr -> qContentBlockItem )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:3: Else Lbr qContentBlockItem Rbr
			{
			dbg.location(93,3);
			Else24=(Token)match(input,Else,FOLLOW_Else_in_elseBlock369); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else24);
			dbg.location(93,8);
			Lbr25=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock371); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr25);
			dbg.location(93,12);
			pushFollow(FOLLOW_qContentBlockItem_in_elseBlock373);
			qContentBlockItem26=qContentBlockItem();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_qContentBlockItem.add(qContentBlockItem26.getTree());dbg.location(93,30);
			Rbr27=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock375); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr27);

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
			// 93:34: -> qContentBlockItem
			{
				dbg.location(93,37);
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
		dbg.location(94, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: constantValueDeclaration : constName= Ident ':' atom -> ^( CONST_VAR ^( CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) ;
	public final QLParser.constantValueDeclaration_return constantValueDeclaration() throws RecognitionException {
		QLParser.constantValueDeclaration_return retval = new QLParser.constantValueDeclaration_return();
		retval.start = input.LT(1);
		int constantValueDeclaration_StartIndex = input.index();

		Object root_0 = null;

		Token constName=null;
		Token char_literal28=null;
		ParserRuleReturnScope atom29 =null;

		Object constName_tree=null;
		Object char_literal28_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try { dbg.enterRule(getGrammarFileName(), "constantValueDeclaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(97, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:2: (constName= Ident ':' atom -> ^( CONST_VAR ^( CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:4: constName= Ident ':' atom
			{
			dbg.location(98,13);
			constName=(Token)match(input,Ident,FOLLOW_Ident_in_constantValueDeclaration397); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(constName);
			dbg.location(98,21);
			char_literal28=(Token)match(input,52,FOLLOW_52_in_constantValueDeclaration400); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_52.add(char_literal28);
			dbg.location(98,25);
			pushFollow(FOLLOW_atom_in_constantValueDeclaration402);
			atom29=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(atom29.getTree());
			// AST REWRITE
			// elements: constName, atom
			// token labels: constName
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_constName=new RewriteRuleTokenStream(adaptor,"token constName",constName);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 98:30: -> ^( CONST_VAR ^( CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
			{
				dbg.location(98,33);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:33: ^( CONST_VAR ^( CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(98,35);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(98,45);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:45: ^( CONST_NAME $constName)
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(98,47);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_NAME, "CONST_NAME"), root_2);
				dbg.location(98,59);
				adaptor.addChild(root_2, stream_constName.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(98,70);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:70: ^( CONST_TYPE CONST_TYPE_INT )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(98,72);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(98,83);
				adaptor.addChild(root_2, (Object)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(98,99);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:99: ^( CONST_VALUE atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(98,101);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(98,114);
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
		dbg.location(99, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:1: qType : ( Boolean -> ^( BOOL_TYPE ) | Money -> ^( MONEY_TYPE ) );
	public final QLParser.qType_return qType() throws RecognitionException {
		QLParser.qType_return retval = new QLParser.qType_return();
		retval.start = input.LT(1);
		int qType_StartIndex = input.index();

		Object root_0 = null;

		Token Boolean30=null;
		Token Money31=null;

		Object Boolean30_tree=null;
		Object Money31_tree=null;
		RewriteRuleTokenStream stream_Money=new RewriteRuleTokenStream(adaptor,"token Money");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");

		try { dbg.enterRule(getGrammarFileName(), "qType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(102, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:2: ( Boolean -> ^( BOOL_TYPE ) | Money -> ^( MONEY_TYPE ) )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:4: Boolean
					{
					dbg.location(103,4);
					Boolean30=(Token)match(input,Boolean,FOLLOW_Boolean_in_qType441); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Boolean.add(Boolean30);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 103:12: -> ^( BOOL_TYPE )
					{
						dbg.location(103,15);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:15: ^( BOOL_TYPE )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(103,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL_TYPE, "BOOL_TYPE"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:30: Money
					{
					dbg.location(103,30);
					Money31=(Token)match(input,Money,FOLLOW_Money_in_qType451); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Money.add(Money31);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 103:36: -> ^( MONEY_TYPE )
					{
						dbg.location(103,39);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:39: ^( MONEY_TYPE )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(103,41);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MONEY_TYPE, "MONEY_TYPE"), root_1);
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
			if ( state.backtracking>0 ) { memoize(input, 8, qType_StartIndex); }

		}
		dbg.location(103, 52);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:1: atom : ( Int -> ^( INT_LITERAL Int ) | Ident -> ^( IDENT_LITERAL Ident ) | Boolean -> ^( BOOL_LITERAL Boolean ) | Money -> ^( SINGLE_STATEMENT Money ) | '(' x= orExpr ')' -> ^( COMPUTED_STATEMENT orExpr ) );
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		Object root_0 = null;

		Token Int32=null;
		Token Ident33=null;
		Token Boolean34=null;
		Token Money35=null;
		Token char_literal36=null;
		Token char_literal37=null;
		ParserRuleReturnScope x =null;

		Object Int32_tree=null;
		Object Ident33_tree=null;
		Object Boolean34_tree=null;
		Object Money35_tree=null;
		Object char_literal36_tree=null;
		Object char_literal37_tree=null;
		RewriteRuleTokenStream stream_Money=new RewriteRuleTokenStream(adaptor,"token Money");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");
		RewriteRuleTokenStream stream_Int=new RewriteRuleTokenStream(adaptor,"token Int");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(105, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:3: ( Int -> ^( INT_LITERAL Int ) | Ident -> ^( IDENT_LITERAL Ident ) | Boolean -> ^( BOOL_LITERAL Boolean ) | Money -> ^( SINGLE_STATEMENT Money ) | '(' x= orExpr ')' -> ^( COMPUTED_STATEMENT orExpr ) )
			int alt5=5;
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
			case Money:
				{
				alt5=4;
				}
				break;
			case 46:
				{
				alt5=5;
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:5: Int
					{
					dbg.location(106,5);
					Int32=(Token)match(input,Int,FOLLOW_Int_in_atom470); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Int.add(Int32);

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
					// 106:12: -> ^( INT_LITERAL Int )
					{
						dbg.location(106,15);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:15: ^( INT_LITERAL Int )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(106,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INT_LITERAL, "INT_LITERAL"), root_1);
						dbg.location(106,29);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: Ident
					{
					dbg.location(107,5);
					Ident33=(Token)match(input,Ident,FOLLOW_Ident_in_atom488); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Ident.add(Ident33);

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
					// 107:12: -> ^( IDENT_LITERAL Ident )
					{
						dbg.location(107,15);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:15: ^( IDENT_LITERAL Ident )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(107,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT_LITERAL, "IDENT_LITERAL"), root_1);
						dbg.location(107,31);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:5: Boolean
					{
					dbg.location(108,5);
					Boolean34=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom504); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Boolean.add(Boolean34);

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
					// 108:14: -> ^( BOOL_LITERAL Boolean )
					{
						dbg.location(108,17);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:17: ^( BOOL_LITERAL Boolean )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(108,19);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL_LITERAL, "BOOL_LITERAL"), root_1);
						dbg.location(108,32);
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: Money
					{
					dbg.location(110,5);
					Money35=(Token)match(input,Money,FOLLOW_Money_in_atom522); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Money.add(Money35);

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
					// 110:11: -> ^( SINGLE_STATEMENT Money )
					{
						dbg.location(110,14);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:14: ^( SINGLE_STATEMENT Money )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(110,16);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SINGLE_STATEMENT, "SINGLE_STATEMENT"), root_1);
						dbg.location(110,33);
						adaptor.addChild(root_1, stream_Money.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:6: '(' x= orExpr ')'
					{
					dbg.location(111,6);
					char_literal36=(Token)match(input,46,FOLLOW_46_in_atom538); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_46.add(char_literal36);
					dbg.location(111,12);
					pushFollow(FOLLOW_orExpr_in_atom543);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orExpr.add(x.getTree());dbg.location(111,20);
					char_literal37=(Token)match(input,47,FOLLOW_47_in_atom545); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_47.add(char_literal37);

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
					// 111:23: -> ^( COMPUTED_STATEMENT orExpr )
					{
						dbg.location(111,26);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:26: ^( COMPUTED_STATEMENT orExpr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(111,28);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMPUTED_STATEMENT, "COMPUTED_STATEMENT"), root_1);
						dbg.location(111,47);
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
		dbg.location(112, 2);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: unExpr : ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal38=null;
		Token char_literal39=null;
		Token char_literal40=null;
		ParserRuleReturnScope x =null;

		Object char_literal38_tree=null;
		Object char_literal39_tree=null;
		Object char_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: ( '+' ^x= atom | '-' ^x= atom | '!' ^x= atom |x= atom )
			int alt6=4;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			switch ( input.LA(1) ) {
			case 49:
				{
				alt6=1;
				}
				break;
			case 50:
				{
				alt6=2;
				}
				break;
			case 43:
				{
				alt6=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
			case 46:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:8: '+' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(116,11);
					char_literal38=(Token)match(input,49,FOLLOW_49_in_unExpr576); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal38_tree = (Object)adaptor.create(char_literal38);
					root_0 = (Object)adaptor.becomeRoot(char_literal38_tree, root_0);
					}
					dbg.location(116,14);
					pushFollow(FOLLOW_atom_in_unExpr581);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:8: '-' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(117,11);
					char_literal39=(Token)match(input,50,FOLLOW_50_in_unExpr591); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal39_tree = (Object)adaptor.create(char_literal39);
					root_0 = (Object)adaptor.becomeRoot(char_literal39_tree, root_0);
					}
					dbg.location(117,14);
					pushFollow(FOLLOW_atom_in_unExpr596);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:8: '!' ^x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(118,11);
					char_literal40=(Token)match(input,43,FOLLOW_43_in_unExpr606); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal40_tree = (Object)adaptor.create(char_literal40);
					root_0 = (Object)adaptor.becomeRoot(char_literal40_tree, root_0);
					}
					dbg.location(118,14);
					pushFollow(FOLLOW_atom_in_unExpr611);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:8: x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(119,9);
					pushFollow(FOLLOW_atom_in_unExpr623);
					x=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, x.getTree());

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
		dbg.location(120, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:1: mulExpr : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(122, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(123,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr655);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(123,20);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:20: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==48||LA8_0==51) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:22: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(123,24);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:25: ( '*' ^| '/' ^)
					int alt7=2;
					try { dbg.enterSubRule(7);
					try { dbg.enterDecision(7, decisionCanBacktrack[7]);

					int LA7_0 = input.LA(1);
					if ( (LA7_0==48) ) {
						alt7=1;
					}
					else if ( (LA7_0==51) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:27: '*' ^
							{
							dbg.location(123,30);
							op=(Token)match(input,48,FOLLOW_48_in_mulExpr663); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:34: '/' ^
							{
							dbg.location(123,37);
							op=(Token)match(input,51,FOLLOW_51_in_mulExpr668); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(7);}
					dbg.location(123,44);
					pushFollow(FOLLOW_unExpr_in_mulExpr675);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

		}
		dbg.location(133, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:1: addExpr : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(136, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(137,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr737);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(137,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:21: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 49 && LA10_0 <= 50)) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:23: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(137,25);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:26: ( '+' ^| '-' ^)
					int alt9=2;
					try { dbg.enterSubRule(9);
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( (LA9_0==49) ) {
						alt9=1;
					}
					else if ( (LA9_0==50) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:27: '+' ^
							{
							dbg.location(137,30);
							op=(Token)match(input,49,FOLLOW_49_in_addExpr744); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:34: '-' ^
							{
							dbg.location(137,37);
							op=(Token)match(input,50,FOLLOW_50_in_addExpr749); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(9);}
					dbg.location(137,44);
					pushFollow(FOLLOW_mulExpr_in_addExpr756);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

		}
		dbg.location(146, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:148:1: relExpr : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(148, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(149,12);
			pushFollow(FOLLOW_addExpr_in_relExpr815);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(149,22);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:22: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==44||(LA12_0 >= 53 && LA12_0 <= 57)) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:24: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(149,26);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:27: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt11=6;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					switch ( input.LA(1) ) {
					case 53:
						{
						alt11=1;
						}
						break;
					case 54:
						{
						alt11=2;
						}
						break;
					case 56:
						{
						alt11=3;
						}
						break;
					case 57:
						{
						alt11=4;
						}
						break;
					case 55:
						{
						alt11=5;
						}
						break;
					case 44:
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:28: '<' ^
							{
							dbg.location(149,31);
							op=(Token)match(input,53,FOLLOW_53_in_relExpr823); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:33: '<=' ^
							{
							dbg.location(149,37);
							op=(Token)match(input,54,FOLLOW_54_in_relExpr826); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:39: '>' ^
							{
							dbg.location(149,42);
							op=(Token)match(input,56,FOLLOW_56_in_relExpr829); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:44: '>=' ^
							{
							dbg.location(149,48);
							op=(Token)match(input,57,FOLLOW_57_in_relExpr832); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:51: '==' ^
							{
							dbg.location(149,55);
							op=(Token)match(input,55,FOLLOW_55_in_relExpr836); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:58: '!=' ^
							{
							dbg.location(149,62);
							op=(Token)match(input,44,FOLLOW_44_in_relExpr840); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(11);}
					dbg.location(149,68);
					pushFollow(FOLLOW_addExpr_in_relExpr846);
					rhs=addExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

		}
		dbg.location(171, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:1: andExpr : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal41=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(173, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(174,12);
			pushFollow(FOLLOW_relExpr_in_andExpr903);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(174,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:21: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==45) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:23: '&&' ^rhs= relExpr
					{
					dbg.location(174,27);
					string_literal41=(Token)match(input,45,FOLLOW_45_in_andExpr907); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal41_tree = (Object)adaptor.create(string_literal41);
					root_0 = (Object)adaptor.becomeRoot(string_literal41_tree, root_0);
					}
					dbg.location(174,32);
					pushFollow(FOLLOW_relExpr_in_andExpr912);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

		}
		dbg.location(175, 4);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:178:1: orExpr : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal42=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal42_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(178, 0);

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:9: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(179,12);
			pushFollow(FOLLOW_andExpr_in_orExpr944);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());
			dbg.location(179,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:21: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==58) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:23: '||' ^rhs= andExpr
					{
					dbg.location(179,27);
					string_literal42=(Token)match(input,58,FOLLOW_58_in_orExpr948); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal42_tree = (Object)adaptor.create(string_literal42);
					root_0 = (Object)adaptor.becomeRoot(string_literal42_tree, root_0);
					}
					dbg.location(179,32);
					pushFollow(FOLLOW_andExpr_in_orExpr953);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

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
		dbg.location(180, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse152 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Ident_in_parse154 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_qContentBlock_in_parse156 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_qContentBlock183 = new BitSet(new long[]{0x0000000401800000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_qContentBlock185 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_Rbr_in_qContentBlock187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantValueDeclaration_in_qContentBlockItem205 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_questionDeclaration_in_qContentBlockItem209 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_ifStatement_in_qContentBlockItem214 = new BitSet(new long[]{0x0000000001800002L});
	public static final BitSet FOLLOW_Ident_in_questionDeclaration232 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_questionDeclaration235 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_questionDeclaration240 = new BitSet(new long[]{0x0000000010000040L});
	public static final BitSet FOLLOW_qType_in_questionDeclaration242 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_questionDeclaration245 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_orExpr_in_questionDeclaration247 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_questionDeclaration249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement314 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_ifStatement317 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement319 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_ifStatement322 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Lbr_in_ifStatement324 = new BitSet(new long[]{0x0000000401800000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_ifStatement326 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatement328 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_elseBlock_in_ifStatement331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock369 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock371 = new BitSet(new long[]{0x0000000401800000L});
	public static final BitSet FOLLOW_qContentBlockItem_in_elseBlock373 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantValueDeclaration397 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_constantValueDeclaration400 = new BitSet(new long[]{0x0000400012800040L});
	public static final BitSet FOLLOW_atom_in_constantValueDeclaration402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_qType441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_qType451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_atom538 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_orExpr_in_atom543 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_atom545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unExpr576 = new BitSet(new long[]{0x0000400012800040L});
	public static final BitSet FOLLOW_atom_in_unExpr581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_unExpr591 = new BitSet(new long[]{0x0000400012800040L});
	public static final BitSet FOLLOW_atom_in_unExpr596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_unExpr606 = new BitSet(new long[]{0x0000400012800040L});
	public static final BitSet FOLLOW_atom_in_unExpr611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr655 = new BitSet(new long[]{0x0009000000000002L});
	public static final BitSet FOLLOW_48_in_mulExpr663 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_51_in_mulExpr668 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr675 = new BitSet(new long[]{0x0009000000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr737 = new BitSet(new long[]{0x0006000000000002L});
	public static final BitSet FOLLOW_49_in_addExpr744 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_50_in_addExpr749 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr756 = new BitSet(new long[]{0x0006000000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr815 = new BitSet(new long[]{0x03E0100000000002L});
	public static final BitSet FOLLOW_53_in_relExpr823 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_54_in_relExpr826 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_56_in_relExpr829 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_57_in_relExpr832 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_55_in_relExpr836 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_44_in_relExpr840 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_addExpr_in_relExpr846 = new BitSet(new long[]{0x03E0100000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr903 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_45_in_andExpr907 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_relExpr_in_andExpr912 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr944 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_58_in_orExpr948 = new BitSet(new long[]{0x0006480012800040L});
	public static final BitSet FOLLOW_andExpr_in_orExpr953 = new BitSet(new long[]{0x0400000000000002L});
}
