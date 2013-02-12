// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-12 08:51:38

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT_EXPRESSION", "ASSIGNMENT_TYPE", 
		"Add", "And", "Assignment_Indicator", "Bool", "BooleanType", "COMMENT", 
		"CONST_ASSIGNMENT", "Div", "Else", "Equ", "FormId", "FormStart", "GT", 
		"GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", "IF_CONDITION", "IF_STATEMENT", 
		"Ident", "If", "Int", "LT", "LTEqu", "Lbr", "MoneyType", "Mul", "Not", 
		"NotEqu", "Or", "QUESTION_ASSIGNMENT", "QUESTION_LABEL", "Rbr", "RoundLbr", 
		"RoundRbr", "String", "Sub", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT_EXPRESSION=4;
	public static final int ASSIGNMENT_TYPE=5;
	public static final int Add=6;
	public static final int And=7;
	public static final int Assignment_Indicator=8;
	public static final int Bool=9;
	public static final int BooleanType=10;
	public static final int COMMENT=11;
	public static final int CONST_ASSIGNMENT=12;
	public static final int Div=13;
	public static final int Else=14;
	public static final int Equ=15;
	public static final int FormId=16;
	public static final int FormStart=17;
	public static final int GT=18;
	public static final int GTEqu=19;
	public static final int IDENT=20;
	public static final int IF_BLOCK_FALSE=21;
	public static final int IF_BLOCK_TRUE=22;
	public static final int IF_CONDITION=23;
	public static final int IF_STATEMENT=24;
	public static final int Ident=25;
	public static final int If=26;
	public static final int Int=27;
	public static final int LT=28;
	public static final int LTEqu=29;
	public static final int Lbr=30;
	public static final int MoneyType=31;
	public static final int Mul=32;
	public static final int Not=33;
	public static final int NotEqu=34;
	public static final int Or=35;
	public static final int QUESTION_ASSIGNMENT=36;
	public static final int QUESTION_LABEL=37;
	public static final int Rbr=38;
	public static final int RoundLbr=39;
	public static final int RoundRbr=40;
	public static final int String=41;
	public static final int Sub=42;
	public static final int WS=43;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "addExpr", "ifStatement", "orExpr", "andExpr", "unExpr", 
		"identType", "ifStatementBlock", "ifBlock", "mulExpr", "block", "questionAssignment", 
		"relExpr", "elseBlock", "atom", "parse", "constantAssignment"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: parse : FormStart FormId Lbr ( block )+ Rbr EOF -> ^( FormId ( block )+ ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FormStart1=null;
		Token FormId2=null;
		Token Lbr3=null;
		Token Rbr5=null;
		Token EOF6=null;
		ParserRuleReturnScope block4 =null;

		Object FormStart1_tree=null;
		Object FormId2_tree=null;
		Object Lbr3_tree=null;
		Object Rbr5_tree=null;
		Object EOF6_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:2: ( FormStart FormId Lbr ( block )+ Rbr EOF -> ^( FormId ( block )+ ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:4: FormStart FormId Lbr ( block )+ Rbr EOF
			{
			dbg.location(59,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse97);  
			stream_FormStart.add(FormStart1);
			dbg.location(59,14);
			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse99);  
			stream_FormId.add(FormId2);
			dbg.location(59,21);
			Lbr3=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse101);  
			stream_Lbr.add(Lbr3);
			dbg.location(59,25);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:25: ( block )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= Ident && LA1_0 <= If)) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:25: block
					{
					dbg.location(59,25);
					pushFollow(FOLLOW_block_in_parse103);
					block4=block();
					state._fsp--;

					stream_block.add(block4.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt1++;
			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(59,32);
			Rbr5=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse106);  
			stream_Rbr.add(Rbr5);
			dbg.location(59,36);
			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_parse108);  
			stream_EOF.add(EOF6);

			// AST REWRITE
			// elements: block, FormId
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 59:40: -> ^( FormId ( block )+ )
			{
				dbg.location(59,43);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:43: ^( FormId ( block )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(59,45);
				root_1 = (Object)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(59,52);
				if ( !(stream_block.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_block.hasNext() ) {
					dbg.location(59,52);
					adaptor.addChild(root_1, stream_block.nextTree());
				}
				stream_block.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(59, 58);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class block_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: block : ( questionAssignment | constantAssignment | ifBlock ) ;
	public final QLParser.block_return block() throws RecognitionException {
		QLParser.block_return retval = new QLParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope questionAssignment7 =null;
		ParserRuleReturnScope constantAssignment8 =null;
		ParserRuleReturnScope ifBlock9 =null;


		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:2: ( ( questionAssignment | constantAssignment | ifBlock ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: ( questionAssignment | constantAssignment | ifBlock )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(62,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: ( questionAssignment | constantAssignment | ifBlock )
			int alt2=3;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==Assignment_Indicator) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==String) ) {
						alt2=1;
					}
					else if ( (LA2_3==BooleanType||LA2_3==MoneyType) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
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
			else if ( (LA2_0==If) ) {
				alt2=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: questionAssignment
					{
					dbg.location(62,5);
					pushFollow(FOLLOW_questionAssignment_in_block128);
					questionAssignment7=questionAssignment();
					state._fsp--;

					adaptor.addChild(root_0, questionAssignment7.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:26: constantAssignment
					{
					dbg.location(62,26);
					pushFollow(FOLLOW_constantAssignment_in_block132);
					constantAssignment8=constantAssignment();
					state._fsp--;

					adaptor.addChild(root_0, constantAssignment8.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:47: ifBlock
					{
					dbg.location(62,47);
					pushFollow(FOLLOW_ifBlock_in_block136);
					ifBlock9=ifBlock();
					state._fsp--;

					adaptor.addChild(root_0, ifBlock9.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(62, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block"


	public static class questionAssignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "questionAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: questionAssignment : Ident Assignment_Indicator String identType ( atom )? -> ^( QUESTION_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
	public final QLParser.questionAssignment_return questionAssignment() throws RecognitionException {
		QLParser.questionAssignment_return retval = new QLParser.questionAssignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Ident10=null;
		Token Assignment_Indicator11=null;
		Token String12=null;
		ParserRuleReturnScope identType13 =null;
		ParserRuleReturnScope atom14 =null;

		Object Ident10_tree=null;
		Object Assignment_Indicator11_tree=null;
		Object String12_tree=null;
		RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "questionAssignment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(65, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:2: ( Ident Assignment_Indicator String identType ( atom )? -> ^( QUESTION_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:4: Ident Assignment_Indicator String identType ( atom )?
			{
			dbg.location(66,4);
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_questionAssignment152);  
			stream_Ident.add(Ident10);
			dbg.location(66,11);
			Assignment_Indicator11=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_questionAssignment155);  
			stream_Assignment_Indicator.add(Assignment_Indicator11);
			dbg.location(66,33);
			String12=(Token)match(input,String,FOLLOW_String_in_questionAssignment158);  
			stream_String.add(String12);
			dbg.location(66,40);
			pushFollow(FOLLOW_identType_in_questionAssignment160);
			identType13=identType();
			state._fsp--;

			stream_identType.add(identType13.getTree());dbg.location(66,50);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:50: ( atom )?
			int alt3=2;
			try { dbg.enterSubRule(3);
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==BooleanType||LA3_0==Int||LA3_0==MoneyType||LA3_0==RoundLbr) ) {
				alt3=1;
			}
			else if ( (LA3_0==Ident) ) {
				int LA3_2 = input.LA(2);
				if ( ((LA3_2 >= Ident && LA3_2 <= If)||LA3_2==Rbr) ) {
					alt3=1;
				}
			}
			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:51: atom
					{
					dbg.location(66,51);
					pushFollow(FOLLOW_atom_in_questionAssignment163);
					atom14=atom();
					state._fsp--;

					stream_atom.add(atom14.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: identType, Ident, String, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 66:59: -> ^( QUESTION_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				dbg.location(66,61);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:61: ^( QUESTION_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(66,63);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_ASSIGNMENT, "QUESTION_ASSIGNMENT"), root_1);
				dbg.location(66,83);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:83: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(66,85);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(66,91);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(66,98);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:98: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(66,100);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(66,116);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(66,127);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:127: ^( QUESTION_LABEL String )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(66,129);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(66,145);
				adaptor.addChild(root_2, stream_String.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(66,154);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:154: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					dbg.location(66,154);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:154: ^( ASSIGNMENT_EXPRESSION atom )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(66,156);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
					dbg.location(66,178);
					adaptor.addChild(root_2, stream_atom.nextTree());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_atom.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(67, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "questionAssignment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "questionAssignment"


	public static class constantAssignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constantAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: constantAssignment : Ident Assignment_Indicator identType atom -> ^( CONST_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
	public final QLParser.constantAssignment_return constantAssignment() throws RecognitionException {
		QLParser.constantAssignment_return retval = new QLParser.constantAssignment_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Ident15=null;
		Token Assignment_Indicator16=null;
		ParserRuleReturnScope identType17 =null;
		ParserRuleReturnScope atom18 =null;

		Object Ident15_tree=null;
		Object Assignment_Indicator16_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "constantAssignment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(70, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:2: ( Ident Assignment_Indicator identType atom -> ^( CONST_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:4: Ident Assignment_Indicator identType atom
			{
			dbg.location(71,4);
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_constantAssignment211);  
			stream_Ident.add(Ident15);
			dbg.location(71,11);
			Assignment_Indicator16=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_constantAssignment214);  
			stream_Assignment_Indicator.add(Assignment_Indicator16);
			dbg.location(71,32);
			pushFollow(FOLLOW_identType_in_constantAssignment216);
			identType17=identType();
			state._fsp--;

			stream_identType.add(identType17.getTree());dbg.location(71,42);
			pushFollow(FOLLOW_atom_in_constantAssignment218);
			atom18=atom();
			state._fsp--;

			stream_atom.add(atom18.getTree());
			// AST REWRITE
			// elements: identType, atom, Ident
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 71:47: -> ^( CONST_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				dbg.location(71,50);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:50: ^( CONST_ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(71,52);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_ASSIGNMENT, "CONST_ASSIGNMENT"), root_1);
				dbg.location(71,69);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:69: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(71,71);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(71,77);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(71,85);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:85: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(71,87);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(71,103);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(71,114);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:114: ^( ASSIGNMENT_EXPRESSION atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(71,116);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
				dbg.location(71,139);
				adaptor.addChild(root_2, stream_atom.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(72, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constantAssignment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "constantAssignment"


	public static class identType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:1: identType : ( BooleanType -> BooleanType | MoneyType -> MoneyType );
	public final QLParser.identType_return identType() throws RecognitionException {
		QLParser.identType_return retval = new QLParser.identType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BooleanType19=null;
		Token MoneyType20=null;

		Object BooleanType19_tree=null;
		Object MoneyType20_tree=null;
		RewriteRuleTokenStream stream_MoneyType=new RewriteRuleTokenStream(adaptor,"token MoneyType");
		RewriteRuleTokenStream stream_BooleanType=new RewriteRuleTokenStream(adaptor,"token BooleanType");

		try { dbg.enterRule(getGrammarFileName(), "identType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:2: ( BooleanType -> BooleanType | MoneyType -> MoneyType )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==BooleanType) ) {
				alt4=1;
			}
			else if ( (LA4_0==MoneyType) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: BooleanType
					{
					dbg.location(76,4);
					BooleanType19=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_identType258);  
					stream_BooleanType.add(BooleanType19);

					// AST REWRITE
					// elements: BooleanType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 76:16: -> BooleanType
					{
						dbg.location(76,19);
						adaptor.addChild(root_0, stream_BooleanType.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:4: MoneyType
					{
					dbg.location(77,4);
					MoneyType20=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_identType268);  
					stream_MoneyType.add(MoneyType20);

					// AST REWRITE
					// elements: MoneyType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 77:14: -> MoneyType
					{
						dbg.location(77,17);
						adaptor.addChild(root_0, stream_MoneyType.nextNode());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(78, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "identType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "identType"


	public static class ifBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: ifBlock : ifStatement ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
	public final QLParser.ifBlock_return ifBlock() throws RecognitionException {
		QLParser.ifBlock_return retval = new QLParser.ifBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope ifStatement21 =null;
		ParserRuleReturnScope ifStatementBlock22 =null;
		ParserRuleReturnScope elseBlock23 =null;

		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
		RewriteRuleSubtreeStream stream_ifStatement=new RewriteRuleSubtreeStream(adaptor,"rule ifStatement");

		try { dbg.enterRule(getGrammarFileName(), "ifBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(81, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:2: ( ifStatement ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:4: ifStatement ifStatementBlock ( elseBlock )?
			{
			dbg.location(82,4);
			pushFollow(FOLLOW_ifStatement_in_ifBlock287);
			ifStatement21=ifStatement();
			state._fsp--;

			stream_ifStatement.add(ifStatement21.getTree());dbg.location(82,17);
			pushFollow(FOLLOW_ifStatementBlock_in_ifBlock290);
			ifStatementBlock22=ifStatementBlock();
			state._fsp--;

			stream_ifStatementBlock.add(ifStatementBlock22.getTree());dbg.location(82,35);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:35: ( elseBlock )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==Else) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:36: elseBlock
					{
					dbg.location(82,36);
					pushFollow(FOLLOW_elseBlock_in_ifBlock294);
					elseBlock23=elseBlock();
					state._fsp--;

					stream_elseBlock.add(elseBlock23.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: ifStatementBlock, elseBlock, ifStatement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 82:49: -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				dbg.location(82,51);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:51: ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(82,53);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				dbg.location(82,67);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:67: ^( IF_CONDITION ifStatement )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(82,69);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(82,82);
				adaptor.addChild(root_2, stream_ifStatement.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(82,97);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:97: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(82,99);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				dbg.location(82,113);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(82,131);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:131: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(82,131);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:131: ^( IF_BLOCK_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(82,133);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_FALSE, "IF_BLOCK_FALSE"), root_2);
					dbg.location(82,148);
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

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(83, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifBlock");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifBlock"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: ifStatement : If RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token If24=null;
		Token RoundLbr25=null;
		Token RoundRbr27=null;
		ParserRuleReturnScope orExpr26 =null;

		Object If24_tree=null;
		Object RoundLbr25_tree=null;
		Object RoundRbr27_tree=null;
		RewriteRuleTokenStream stream_RoundLbr=new RewriteRuleTokenStream(adaptor,"token RoundLbr");
		RewriteRuleTokenStream stream_RoundRbr=new RewriteRuleTokenStream(adaptor,"token RoundRbr");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(85, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:2: ( If RoundLbr orExpr RoundRbr -> orExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: If RoundLbr orExpr RoundRbr
			{
			dbg.location(86,5);
			If24=(Token)match(input,If,FOLLOW_If_in_ifStatement338);  
			stream_If.add(If24);
			dbg.location(86,8);
			RoundLbr25=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifStatement340);  
			stream_RoundLbr.add(RoundLbr25);
			dbg.location(86,17);
			pushFollow(FOLLOW_orExpr_in_ifStatement342);
			orExpr26=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr26.getTree());dbg.location(86,25);
			RoundRbr27=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifStatement345);  
			stream_RoundRbr.add(RoundRbr27);

			// AST REWRITE
			// elements: orExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 86:34: -> orExpr
			{
				dbg.location(86,37);
				adaptor.addChild(root_0, stream_orExpr.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(86, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class ifStatementBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: ifStatementBlock : Lbr ( block )* Rbr -> ( block )* ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Lbr28=null;
		Token Rbr30=null;
		ParserRuleReturnScope block29 =null;

		Object Lbr28_tree=null;
		Object Rbr30_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:2: ( Lbr ( block )* Rbr -> ( block )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Lbr ( block )* Rbr
			{
			dbg.location(90,5);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock363);  
			stream_Lbr.add(Lbr28);
			dbg.location(90,10);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: ( block )*
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= Ident && LA6_0 <= If)) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: block
					{
					dbg.location(90,10);
					pushFollow(FOLLOW_block_in_ifStatementBlock366);
					block29=block();
					state._fsp--;

					stream_block.add(block29.getTree());
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(90,17);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock369);  
			stream_Rbr.add(Rbr30);

			// AST REWRITE
			// elements: block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 90:21: -> ( block )*
			{
				dbg.location(90,24);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:24: ( block )*
				while ( stream_block.hasNext() ) {
					dbg.location(90,24);
					adaptor.addChild(root_0, stream_block.nextTree());
				}
				stream_block.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(90, 29);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatementBlock");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatementBlock"


	public static class elseBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "elseBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: elseBlock : Else Lbr ( block )* Rbr -> ( block )* ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else31=null;
		Token Lbr32=null;
		Token Rbr34=null;
		ParserRuleReturnScope block33 =null;

		Object Else31_tree=null;
		Object Lbr32_tree=null;
		Object Rbr34_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(92, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:2: ( Else Lbr ( block )* Rbr -> ( block )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:4: Else Lbr ( block )* Rbr
			{
			dbg.location(93,4);
			Else31=(Token)match(input,Else,FOLLOW_Else_in_elseBlock383);  
			stream_Else.add(Else31);
			dbg.location(93,9);
			Lbr32=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock385);  
			stream_Lbr.add(Lbr32);
			dbg.location(93,13);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: ( block )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= Ident && LA7_0 <= If)) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: block
					{
					dbg.location(93,13);
					pushFollow(FOLLOW_block_in_elseBlock387);
					block33=block();
					state._fsp--;

					stream_block.add(block33.getTree());
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(93,20);
			Rbr34=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock390);  
			stream_Rbr.add(Rbr34);

			// AST REWRITE
			// elements: block
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 93:24: -> ( block )*
			{
				dbg.location(93,27);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:27: ( block )*
				while ( stream_block.hasNext() ) {
					dbg.location(93,27);
					adaptor.addChild(root_0, stream_block.nextTree());
				}
				stream_block.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
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


	public static class atom_return extends ParserRuleReturnScope {
		public Expr result;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: atom returns [Expr result] : ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Int35=null;
		Token Ident36=null;
		Token BooleanType37=null;
		Token MoneyType38=null;
		Token RoundLbr39=null;
		Token RoundRbr40=null;
		ParserRuleReturnScope x =null;

		Object Int35_tree=null;
		Object Ident36_tree=null;
		Object BooleanType37_tree=null;
		Object MoneyType38_tree=null;
		Object RoundLbr39_tree=null;
		Object RoundRbr40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(99, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:3: ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !)
			int alt8=5;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			switch ( input.LA(1) ) {
			case Int:
				{
				alt8=1;
				}
				break;
			case Ident:
				{
				alt8=2;
				}
				break;
			case BooleanType:
				{
				alt8=3;
				}
				break;
			case MoneyType:
				{
				alt8=4;
				}
				break;
			case RoundLbr:
				{
				alt8=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: Int
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(100,5);
					Int35=(Token)match(input,Int,FOLLOW_Int_in_atom418); 
					Int35_tree = (Object)adaptor.create(Int35);
					adaptor.addChild(root_0, Int35_tree);
					dbg.location(100,11);
					 retval.result = new Int(Integer.parseInt((Int35!=null?Int35.getText():null))); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(101,5);
					Ident36=(Token)match(input,Ident,FOLLOW_Ident_in_atom428); 
					Ident36_tree = (Object)adaptor.create(Ident36);
					adaptor.addChild(root_0, Ident36_tree);
					dbg.location(101,11);
					 retval.result = new Ident((Ident36!=null?Ident36.getText():null), new Bool(false)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: BooleanType
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(102,5);
					BooleanType37=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_atom437); 
					BooleanType37_tree = (Object)adaptor.create(BooleanType37);
					adaptor.addChild(root_0, BooleanType37_tree);
					dbg.location(102,17);
					retval.result = new Bool(false);
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: MoneyType
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(103,5);
					MoneyType38=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_atom445); 
					MoneyType38_tree = (Object)adaptor.create(MoneyType38);
					adaptor.addChild(root_0, MoneyType38_tree);
					dbg.location(103,15);
					 retval.result = new Int(Integer.parseInt((MoneyType38!=null?MoneyType38.getText():null)));
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(105,14);
					RoundLbr39=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom456); dbg.location(105,18);
					pushFollow(FOLLOW_orExpr_in_atom462);
					x=orExpr();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);dbg.location(105,35);
					RoundRbr40=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom465); dbg.location(105,37);
					 retval.result = (x!=null?((QLParser.orExpr_return)x).result:null); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(106, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:1: unExpr returns [Expr result] : ( Add x= atom | Sub x= atom | Not x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Add41=null;
		Token Sub42=null;
		Token Not43=null;
		ParserRuleReturnScope x =null;

		Object Add41_tree=null;
		Object Sub42_tree=null;
		Object Not43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(108, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:5: ( Add x= atom | Sub x= atom | Not x= atom |x= atom )
			int alt9=4;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			switch ( input.LA(1) ) {
			case Add:
				{
				alt9=1;
				}
				break;
			case Sub:
				{
				alt9=2;
				}
				break;
			case Not:
				{
				alt9=3;
				}
				break;
			case BooleanType:
			case Ident:
			case Int:
			case MoneyType:
			case RoundLbr:
				{
				alt9=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:8: Add x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(109,8);
					Add41=(Token)match(input,Add,FOLLOW_Add_in_unExpr491); 
					Add41_tree = (Object)adaptor.create(Add41);
					adaptor.addChild(root_0, Add41_tree);
					dbg.location(109,13);
					pushFollow(FOLLOW_atom_in_unExpr495);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(109,19);
					 retval.result = new Pos((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:8: Sub x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(110,8);
					Sub42=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr506); 
					Sub42_tree = (Object)adaptor.create(Sub42);
					adaptor.addChild(root_0, Sub42_tree);
					dbg.location(110,13);
					pushFollow(FOLLOW_atom_in_unExpr510);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(110,19);
					 retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:8: Not x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(111,8);
					Not43=(Token)match(input,Not,FOLLOW_Not_in_unExpr521); 
					Not43_tree = (Object)adaptor.create(Not43);
					adaptor.addChild(root_0, Not43_tree);
					dbg.location(111,13);
					pushFollow(FOLLOW_atom_in_unExpr525);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(111,19);
					 retval.result = new Not((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:112:8: x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(112,9);
					pushFollow(FOLLOW_atom_in_unExpr538);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(112,18);
					 retval.result = (x!=null?((QLParser.atom_return)x).result:null); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(113, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( Mul ^| Div ^) rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "mulExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: (lhs= unExpr (op= ( Mul ^| Div ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: lhs= unExpr (op= ( Mul ^| Div ^) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(116,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr576);
			lhs=unExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(116,20);
			 retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); dbg.location(116,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:45: (op= ( Mul ^| Div ^) rhs= unExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==Div||LA11_0==Mul) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:47: op= ( Mul ^| Div ^) rhs= unExpr
					{
					dbg.location(116,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:50: ( Mul ^| Div ^)
					int alt10=2;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					int LA10_0 = input.LA(1);
					if ( (LA10_0==Mul) ) {
						alt10=1;
					}
					else if ( (LA10_0==Div) ) {
						alt10=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:52: Mul ^
							{
							dbg.location(116,55);
							op=(Token)match(input,Mul,FOLLOW_Mul_in_mulExpr586); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:59: Div ^
							{
							dbg.location(116,62);
							op=(Token)match(input,Div,FOLLOW_Div_in_mulExpr591); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(116,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr598);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(117,5);
					 
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new Mul(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new Div(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));      
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

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(125, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( Add ^| Sub ^) rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "addExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(128, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:5: (lhs= mulExpr (op= ( Add ^| Sub ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:9: lhs= mulExpr (op= ( Add ^| Sub ^) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(129,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr639);
			lhs=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(129,21);
			 retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); dbg.location(129,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:46: (op= ( Add ^| Sub ^) rhs= mulExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==Add||LA13_0==Sub) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:48: op= ( Add ^| Sub ^) rhs= mulExpr
					{
					dbg.location(129,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:51: ( Add ^| Sub ^)
					int alt12=2;
					try { dbg.enterSubRule(12);
					try { dbg.enterDecision(12, decisionCanBacktrack[12]);

					int LA12_0 = input.LA(1);
					if ( (LA12_0==Add) ) {
						alt12=1;
					}
					else if ( (LA12_0==Sub) ) {
						alt12=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 12, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(12);}

					switch (alt12) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:52: Add ^
							{
							dbg.location(129,55);
							op=(Token)match(input,Add,FOLLOW_Add_in_addExpr648); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:59: Sub ^
							{
							dbg.location(129,62);
							op=(Token)match(input,Sub,FOLLOW_Sub_in_addExpr653); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(129,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr659);
					rhs=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(130,5);
					 
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new Add(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new Sub(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));      
					      }
					    
					}
					break;

				default :
					break loop13;
				}
			}
			} finally {dbg.exitSubRule(13);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(138, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:1: relExpr returns [Expr result] : lhs= addExpr (op= ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^) rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "relExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(140, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:5: (lhs= addExpr (op= ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:9: lhs= addExpr (op= ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(141,12);
			pushFollow(FOLLOW_addExpr_in_relExpr694);
			lhs=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(141,21);
			 retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); dbg.location(141,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:46: (op= ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^) rhs= addExpr )*
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==Equ||(LA15_0 >= GT && LA15_0 <= GTEqu)||(LA15_0 >= LT && LA15_0 <= LTEqu)||LA15_0==NotEqu) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:48: op= ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^) rhs= addExpr
					{
					dbg.location(141,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:51: ( LT ^| LTEqu ^| GT ^| GTEqu ^| Equ ^| NotEqu ^)
					int alt14=6;
					try { dbg.enterSubRule(14);
					try { dbg.enterDecision(14, decisionCanBacktrack[14]);

					switch ( input.LA(1) ) {
					case LT:
						{
						alt14=1;
						}
						break;
					case LTEqu:
						{
						alt14=2;
						}
						break;
					case GT:
						{
						alt14=3;
						}
						break;
					case GTEqu:
						{
						alt14=4;
						}
						break;
					case Equ:
						{
						alt14=5;
						}
						break;
					case NotEqu:
						{
						alt14=6;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}
					} finally {dbg.exitDecision(14);}

					switch (alt14) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:52: LT ^
							{
							dbg.location(141,54);
							op=(Token)match(input,LT,FOLLOW_LT_in_relExpr703); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:56: LTEqu ^
							{
							dbg.location(141,61);
							op=(Token)match(input,LTEqu,FOLLOW_LTEqu_in_relExpr706); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:63: GT ^
							{
							dbg.location(141,65);
							op=(Token)match(input,GT,FOLLOW_GT_in_relExpr709); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:67: GTEqu ^
							{
							dbg.location(141,72);
							op=(Token)match(input,GTEqu,FOLLOW_GTEqu_in_relExpr712); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:74: Equ ^
							{
							dbg.location(141,77);
							op=(Token)match(input,Equ,FOLLOW_Equ_in_relExpr715); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:79: NotEqu ^
							{
							dbg.location(141,85);
							op=(Token)match(input,NotEqu,FOLLOW_NotEqu_in_relExpr718); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(14);}
					dbg.location(141,91);
					pushFollow(FOLLOW_addExpr_in_relExpr724);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(142,5);
					 
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new LT(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new LEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));      
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new GT(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new GEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));      
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new Eq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals(op)) {
					        retval.result = new NEq(retval.result, (rhs!=null?((QLParser.addExpr_return)rhs).result:null));
					      }
					    
					}
					break;

				default :
					break loop15;
				}
			}
			} finally {dbg.exitSubRule(15);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(162, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:164:1: andExpr returns [Expr result] : lhs= relExpr ( And ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token And44=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And44_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(164, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:5: (lhs= relExpr ( And ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:9: lhs= relExpr ( And ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(165,12);
			pushFollow(FOLLOW_relExpr_in_andExpr762);
			lhs=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(165,21);
			 retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); dbg.location(165,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:46: ( And ^rhs= relExpr )*
			try { dbg.enterSubRule(16);

			loop16:
			while (true) {
				int alt16=2;
				try { dbg.enterDecision(16, decisionCanBacktrack[16]);

				int LA16_0 = input.LA(1);
				if ( (LA16_0==And) ) {
					alt16=1;
				}

				} finally {dbg.exitDecision(16);}

				switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:48: And ^rhs= relExpr
					{
					dbg.location(165,51);
					And44=(Token)match(input,And,FOLLOW_And_in_andExpr768); 
					And44_tree = (Object)adaptor.create(And44);
					root_0 = (Object)adaptor.becomeRoot(And44_tree, root_0);
					dbg.location(165,56);
					pushFollow(FOLLOW_relExpr_in_andExpr773);
					rhs=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(165,65);
					 retval.result = new And(retval.result, (rhs!=null?((QLParser.relExpr_return)rhs).result:null)); 
					}
					break;

				default :
					break loop16;
				}
			}
			} finally {dbg.exitSubRule(16);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(166, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:169:1: orExpr returns [Expr result] : lhs= andExpr ( Or ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Or45=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or45_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(169, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:170:5: (lhs= andExpr ( Or ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:170:8: lhs= andExpr ( Or ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(170,11);
			pushFollow(FOLLOW_andExpr_in_orExpr808);
			lhs=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(170,20);
			 retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); dbg.location(170,47);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:170:47: ( Or ^rhs= andExpr )*
			try { dbg.enterSubRule(17);

			loop17:
			while (true) {
				int alt17=2;
				try { dbg.enterDecision(17, decisionCanBacktrack[17]);

				int LA17_0 = input.LA(1);
				if ( (LA17_0==Or) ) {
					alt17=1;
				}

				} finally {dbg.exitDecision(17);}

				switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:170:49: Or ^rhs= andExpr
					{
					dbg.location(170,51);
					Or45=(Token)match(input,Or,FOLLOW_Or_in_orExpr814); 
					Or45_tree = (Object)adaptor.create(Or45);
					root_0 = (Object)adaptor.becomeRoot(Or45_tree, root_0);
					dbg.location(170,56);
					pushFollow(FOLLOW_andExpr_in_orExpr819);
					rhs=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(170,65);
					 retval.result = new Or(retval.result, (rhs!=null?((QLParser.andExpr_return)rhs).result:null)); 
					}
					break;

				default :
					break loop17;
				}
			}
			} finally {dbg.exitSubRule(17);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(171, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse97 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FormId_in_parse99 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Lbr_in_parse101 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_block_in_parse103 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_parse106 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionAssignment_in_block128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_block132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_block136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment152 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_questionAssignment155 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_String_in_questionAssignment158 = new BitSet(new long[]{0x0000000080000400L});
	public static final BitSet FOLLOW_identType_in_questionAssignment160 = new BitSet(new long[]{0x000000808A000402L});
	public static final BitSet FOLLOW_atom_in_questionAssignment163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment211 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_constantAssignment214 = new BitSet(new long[]{0x0000000080000400L});
	public static final BitSet FOLLOW_identType_in_constantAssignment216 = new BitSet(new long[]{0x000000808A000400L});
	public static final BitSet FOLLOW_atom_in_constantAssignment218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_ifBlock287 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifBlock290 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_elseBlock_in_ifBlock294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement338 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RoundLbr_in_ifStatement340 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement342 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifStatement345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock363 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_block_in_ifStatementBlock366 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock383 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock385 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_block_in_elseBlock387 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_atom437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_atom445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom456 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_orExpr_in_atom462 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Add_in_unExpr491 = new BitSet(new long[]{0x000000808A000400L});
	public static final BitSet FOLLOW_atom_in_unExpr495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr506 = new BitSet(new long[]{0x000000808A000400L});
	public static final BitSet FOLLOW_atom_in_unExpr510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unExpr521 = new BitSet(new long[]{0x000000808A000400L});
	public static final BitSet FOLLOW_atom_in_unExpr525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr576 = new BitSet(new long[]{0x0000000100002002L});
	public static final BitSet FOLLOW_Mul_in_mulExpr586 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_Div_in_mulExpr591 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr598 = new BitSet(new long[]{0x0000000100002002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr639 = new BitSet(new long[]{0x0000040000000042L});
	public static final BitSet FOLLOW_Add_in_addExpr648 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_Sub_in_addExpr653 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr659 = new BitSet(new long[]{0x0000040000000042L});
	public static final BitSet FOLLOW_addExpr_in_relExpr694 = new BitSet(new long[]{0x00000004300C8002L});
	public static final BitSet FOLLOW_LT_in_relExpr703 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_LTEqu_in_relExpr706 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_GT_in_relExpr709 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_GTEqu_in_relExpr712 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_Equ_in_relExpr715 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_NotEqu_in_relExpr718 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_addExpr_in_relExpr724 = new BitSet(new long[]{0x00000004300C8002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr762 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_And_in_andExpr768 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_relExpr_in_andExpr773 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_andExpr_in_orExpr808 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_Or_in_orExpr814 = new BitSet(new long[]{0x000004828A000440L});
	public static final BitSet FOLLOW_andExpr_in_orExpr819 = new BitSet(new long[]{0x0000000800000002L});
}
