// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-12 23:14:25

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import java.util.Map; 
import java.util.HashMap; 


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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_EXPRESSION", 
		"ASSIGNMENT_TYPE", "Add", "And", "Assignment_Indicator", "Bool", "BooleanType", 
		"COMMENT", "Div", "Else", "Equ", "FormId", "FormStart", "GT", "GTEqu", 
		"IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", "IF_CONDITION", "IF_STATEMENT", 
		"Ident", "If", "Int", "LT", "LTEqu", "Lbr", "MoneyType", "Mul", "Not", 
		"NotEqu", "Or", "QUESTION_LABEL", "Rbr", "RoundLbr", "RoundRbr", "String", 
		"Sub", "UNARY_MINUS", "UNARY_NEGATE", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_EXPRESSION=5;
	public static final int ASSIGNMENT_TYPE=6;
	public static final int Add=7;
	public static final int And=8;
	public static final int Assignment_Indicator=9;
	public static final int Bool=10;
	public static final int BooleanType=11;
	public static final int COMMENT=12;
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
	public static final int QUESTION_LABEL=36;
	public static final int Rbr=37;
	public static final int RoundLbr=38;
	public static final int RoundRbr=39;
	public static final int String=40;
	public static final int Sub=41;
	public static final int UNARY_MINUS=42;
	public static final int UNARY_NEGATE=43;
	public static final int WS=44;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "ifBlock", "questionAssignment", "atom", "ifStatement", 
		"addExpr", "constantAssignment", "ifStatementBlock", "unExpr", "identType", 
		"elseBlock", "orExpr", "parse", "blockItem", "relExpr", "andExpr", "mulExpr"
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


		public Map<Ident,Type> typeEnv = new HashMap<Ident,Type>();
		private void mapIdentToType(String identName,Type type){
		System.out.println(identName+type.toString());
			typeEnv.put(new Ident(identName),type);
		}


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:1: parse : FormStart FormId Lbr ( blockItem )* Rbr EOF -> ^( FormId ( blockItem )* ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FormStart1=null;
		Token FormId2=null;
		Token Lbr3=null;
		Token Rbr5=null;
		Token EOF6=null;
		ParserRuleReturnScope blockItem4 =null;

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
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(69, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:2: ( FormStart FormId Lbr ( blockItem )* Rbr EOF -> ^( FormId ( blockItem )* ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:4: FormStart FormId Lbr ( blockItem )* Rbr EOF
			{
			dbg.location(70,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse109);  
			stream_FormStart.add(FormStart1);
			dbg.location(70,14);
			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse111);  
			stream_FormId.add(FormId2);
			dbg.location(70,21);
			Lbr3=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse113);  
			stream_Lbr.add(Lbr3);
			dbg.location(70,25);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:25: ( blockItem )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:25: blockItem
					{
					dbg.location(70,25);
					pushFollow(FOLLOW_blockItem_in_parse115);
					blockItem4=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem4.getTree());
					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(70,36);
			Rbr5=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse118);  
			stream_Rbr.add(Rbr5);
			dbg.location(70,40);
			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_parse120);  
			stream_EOF.add(EOF6);

			// AST REWRITE
			// elements: FormId, blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 70:44: -> ^( FormId ( blockItem )* )
			{
				dbg.location(70,47);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:47: ^( FormId ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(70,49);
				root_1 = (Object)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(70,56);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:56: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					dbg.location(70,56);
					adaptor.addChild(root_1, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
		dbg.location(70, 66);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class blockItem_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "blockItem"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: blockItem : ( questionAssignment | constantAssignment | ifBlock ) ;
	public final QLParser.blockItem_return blockItem() throws RecognitionException {
		QLParser.blockItem_return retval = new QLParser.blockItem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope questionAssignment7 =null;
		ParserRuleReturnScope constantAssignment8 =null;
		ParserRuleReturnScope ifBlock9 =null;


		try { dbg.enterRule(getGrammarFileName(), "blockItem");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( ( questionAssignment | constantAssignment | ifBlock ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: ( questionAssignment | constantAssignment | ifBlock )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(73,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: ( questionAssignment | constantAssignment | ifBlock )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: questionAssignment
					{
					dbg.location(73,5);
					pushFollow(FOLLOW_questionAssignment_in_blockItem140);
					questionAssignment7=questionAssignment();
					state._fsp--;

					adaptor.addChild(root_0, questionAssignment7.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:26: constantAssignment
					{
					dbg.location(73,26);
					pushFollow(FOLLOW_constantAssignment_in_blockItem144);
					constantAssignment8=constantAssignment();
					state._fsp--;

					adaptor.addChild(root_0, constantAssignment8.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:47: ifBlock
					{
					dbg.location(73,47);
					pushFollow(FOLLOW_ifBlock_in_blockItem148);
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
		dbg.location(73, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "blockItem");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "blockItem"


	public static class questionAssignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "questionAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: questionAssignment : Ident Assignment_Indicator String identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
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
		dbg.location(76, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:2: ( Ident Assignment_Indicator String identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:4: Ident Assignment_Indicator String identType ( atom )?
			{
			dbg.location(77,4);
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_questionAssignment164);  
			stream_Ident.add(Ident10);
			dbg.location(77,11);
			Assignment_Indicator11=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_questionAssignment167);  
			stream_Assignment_Indicator.add(Assignment_Indicator11);
			dbg.location(77,33);
			String12=(Token)match(input,String,FOLLOW_String_in_questionAssignment170);  
			stream_String.add(String12);
			dbg.location(77,40);
			pushFollow(FOLLOW_identType_in_questionAssignment172);
			identType13=identType();
			state._fsp--;

			stream_identType.add(identType13.getTree());dbg.location(77,50);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:50: ( atom )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:51: atom
					{
					dbg.location(77,51);
					pushFollow(FOLLOW_atom_in_questionAssignment175);
					atom14=atom();
					state._fsp--;

					stream_atom.add(atom14.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(77,58);
			mapIdentToType((Ident10!=null?Ident10.getText():null),(identType13!=null?((QLParser.identType_return)identType13).t:null));
			// AST REWRITE
			// elements: identType, Ident, atom, String
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 77:103: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				dbg.location(77,105);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:105: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(77,107);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				dbg.location(77,118);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:118: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(77,120);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(77,126);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(77,133);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:133: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(77,135);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(77,151);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(77,162);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:162: ^( QUESTION_LABEL String )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(77,164);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(77,180);
				adaptor.addChild(root_2, stream_String.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(77,189);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:189: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					dbg.location(77,189);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:189: ^( ASSIGNMENT_EXPRESSION atom )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(77,191);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
					dbg.location(77,213);
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
		dbg.location(79, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: constantAssignment : Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
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
		dbg.location(82, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:2: ( Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:4: Ident Assignment_Indicator identType atom
			{
			dbg.location(83,4);
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_constantAssignment228);  
			stream_Ident.add(Ident15);
			dbg.location(83,11);
			Assignment_Indicator16=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_constantAssignment231);  
			stream_Assignment_Indicator.add(Assignment_Indicator16);
			dbg.location(83,32);
			pushFollow(FOLLOW_identType_in_constantAssignment233);
			identType17=identType();
			state._fsp--;

			stream_identType.add(identType17.getTree());dbg.location(83,42);
			pushFollow(FOLLOW_atom_in_constantAssignment235);
			atom18=atom();
			state._fsp--;

			stream_atom.add(atom18.getTree());dbg.location(83,47);
			mapIdentToType((Ident15!=null?Ident15.getText():null),(identType17!=null?((QLParser.identType_return)identType17).t:null));
			// AST REWRITE
			// elements: Ident, atom, identType
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 83:91: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				dbg.location(83,94);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:94: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(83,96);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				dbg.location(83,107);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:107: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,109);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(83,115);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,123);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:123: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,125);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(83,141);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,152);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:152: ^( ASSIGNMENT_EXPRESSION atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,154);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
				dbg.location(83,177);
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
		dbg.location(84, 1);

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
		public Type t;
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:1: identType returns [Type t] : ( BooleanType -> BooleanType | MoneyType -> MoneyType );
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
		dbg.location(87, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:2: ( BooleanType -> BooleanType | MoneyType -> MoneyType )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:4: BooleanType
					{
					dbg.location(88,4);
					BooleanType19=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_identType282);  
					stream_BooleanType.add(BooleanType19);
					dbg.location(88,16);
					retval.t = new BoolType();
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
					// 88:40: -> BooleanType
					{
						dbg.location(88,43);
						adaptor.addChild(root_0, stream_BooleanType.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:4: MoneyType
					{
					dbg.location(89,4);
					MoneyType20=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_identType295);  
					stream_MoneyType.add(MoneyType20);
					dbg.location(89,14);
					retval.t = new MoneyType();
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
					// 89:39: -> MoneyType
					{
						dbg.location(89,42);
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
		dbg.location(90, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:1: ifBlock : ifStatement ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
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
		dbg.location(93, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:2: ( ifStatement ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:4: ifStatement ifStatementBlock ( elseBlock )?
			{
			dbg.location(94,4);
			pushFollow(FOLLOW_ifStatement_in_ifBlock317);
			ifStatement21=ifStatement();
			state._fsp--;

			stream_ifStatement.add(ifStatement21.getTree());dbg.location(94,17);
			pushFollow(FOLLOW_ifStatementBlock_in_ifBlock320);
			ifStatementBlock22=ifStatementBlock();
			state._fsp--;

			stream_ifStatementBlock.add(ifStatementBlock22.getTree());dbg.location(94,35);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:35: ( elseBlock )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:36: elseBlock
					{
					dbg.location(94,36);
					pushFollow(FOLLOW_elseBlock_in_ifBlock324);
					elseBlock23=elseBlock();
					state._fsp--;

					stream_elseBlock.add(elseBlock23.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: ifStatement, ifStatementBlock, elseBlock
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 94:49: -> ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				dbg.location(94,51);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:51: ^( IF_STATEMENT ^( IF_CONDITION ifStatement ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(94,53);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				dbg.location(94,67);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:67: ^( IF_CONDITION ifStatement )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(94,69);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(94,82);
				adaptor.addChild(root_2, stream_ifStatement.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(94,97);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:97: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(94,99);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				dbg.location(94,113);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(94,131);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:131: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(94,131);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:131: ^( IF_BLOCK_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(94,133);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_FALSE, "IF_BLOCK_FALSE"), root_2);
					dbg.location(94,148);
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
		dbg.location(95, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: ifStatement : If RoundLbr orExpr RoundRbr -> orExpr ;
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
		dbg.location(97, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:2: ( If RoundLbr orExpr RoundRbr -> orExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: If RoundLbr orExpr RoundRbr
			{
			dbg.location(98,5);
			If24=(Token)match(input,If,FOLLOW_If_in_ifStatement368);  
			stream_If.add(If24);
			dbg.location(98,8);
			RoundLbr25=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifStatement370);  
			stream_RoundLbr.add(RoundLbr25);
			dbg.location(98,17);
			pushFollow(FOLLOW_orExpr_in_ifStatement372);
			orExpr26=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr26.getTree());dbg.location(98,25);
			RoundRbr27=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifStatement375);  
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
			// 98:34: -> orExpr
			{
				dbg.location(98,37);
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
		dbg.location(98, 42);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:1: ifStatementBlock : Lbr ( blockItem )* Rbr -> ( blockItem )* ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Lbr28=null;
		Token Rbr30=null;
		ParserRuleReturnScope blockItem29 =null;

		Object Lbr28_tree=null;
		Object Rbr30_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(101, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:2: ( Lbr ( blockItem )* Rbr -> ( blockItem )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: Lbr ( blockItem )* Rbr
			{
			dbg.location(102,5);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock393);  
			stream_Lbr.add(Lbr28);
			dbg.location(102,10);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:10: ( blockItem )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:10: blockItem
					{
					dbg.location(102,10);
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock396);
					blockItem29=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem29.getTree());
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(102,21);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock399);  
			stream_Rbr.add(Rbr30);

			// AST REWRITE
			// elements: blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 102:25: -> ( blockItem )*
			{
				dbg.location(102,28);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:28: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					dbg.location(102,28);
					adaptor.addChild(root_0, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
		dbg.location(102, 37);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:1: elseBlock : Else Lbr ( blockItem )* Rbr -> ( blockItem )* ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else31=null;
		Token Lbr32=null;
		Token Rbr34=null;
		ParserRuleReturnScope blockItem33 =null;

		Object Else31_tree=null;
		Object Lbr32_tree=null;
		Object Rbr34_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(104, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:2: ( Else Lbr ( blockItem )* Rbr -> ( blockItem )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:4: Else Lbr ( blockItem )* Rbr
			{
			dbg.location(105,4);
			Else31=(Token)match(input,Else,FOLLOW_Else_in_elseBlock413);  
			stream_Else.add(Else31);
			dbg.location(105,9);
			Lbr32=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock415);  
			stream_Lbr.add(Lbr32);
			dbg.location(105,13);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:13: ( blockItem )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:13: blockItem
					{
					dbg.location(105,13);
					pushFollow(FOLLOW_blockItem_in_elseBlock417);
					blockItem33=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem33.getTree());
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(105,24);
			Rbr34=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock420);  
			stream_Rbr.add(Rbr34);

			// AST REWRITE
			// elements: blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 105:28: -> ( blockItem )*
			{
				dbg.location(105,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:31: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					dbg.location(105,31);
					adaptor.addChild(root_0, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
		dbg.location(106, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:1: atom : ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !);
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
		dbg.location(111, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:112:3: ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !)
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:112:5: Int
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(112,5);
					Int35=(Token)match(input,Int,FOLLOW_Int_in_atom445); 
					Int35_tree = (Object)adaptor.create(Int35);
					adaptor.addChild(root_0, Int35_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(113,5);
					Ident36=(Token)match(input,Ident,FOLLOW_Ident_in_atom453); 
					Ident36_tree = (Object)adaptor.create(Ident36);
					adaptor.addChild(root_0, Ident36_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: BooleanType
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(114,5);
					BooleanType37=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_atom460); 
					BooleanType37_tree = (Object)adaptor.create(BooleanType37);
					adaptor.addChild(root_0, BooleanType37_tree);

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: MoneyType
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(115,5);
					MoneyType38=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_atom466); 
					MoneyType38_tree = (Object)adaptor.create(MoneyType38);
					adaptor.addChild(root_0, MoneyType38_tree);

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(117,14);
					RoundLbr39=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom476); dbg.location(117,18);
					pushFollow(FOLLOW_orExpr_in_atom482);
					x=orExpr();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);dbg.location(117,35);
					RoundRbr40=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom485); 
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
		dbg.location(118, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:1: unExpr : ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Sub41=null;
		Token Not43=null;
		ParserRuleReturnScope atom42 =null;
		ParserRuleReturnScope atom44 =null;
		ParserRuleReturnScope atom45 =null;

		Object Sub41_tree=null;
		Object Not43_tree=null;
		RewriteRuleTokenStream stream_Sub=new RewriteRuleTokenStream(adaptor,"token Sub");
		RewriteRuleTokenStream stream_Not=new RewriteRuleTokenStream(adaptor,"token Not");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(120, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:5: ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom )
			int alt9=3;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			switch ( input.LA(1) ) {
			case Sub:
				{
				alt9=1;
				}
				break;
			case Not:
				{
				alt9=2;
				}
				break;
			case BooleanType:
			case Ident:
			case Int:
			case MoneyType:
			case RoundLbr:
				{
				alt9=3;
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:8: Sub atom
					{
					dbg.location(121,8);
					Sub41=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr506);  
					stream_Sub.add(Sub41);
					dbg.location(121,12);
					pushFollow(FOLLOW_atom_in_unExpr508);
					atom42=atom();
					state._fsp--;

					stream_atom.add(atom42.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 121:17: -> ^( UNARY_MINUS atom )
					{
						dbg.location(121,20);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:20: ^( UNARY_MINUS atom )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(121,22);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						dbg.location(121,34);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:8: Not atom
					{
					dbg.location(122,8);
					Not43=(Token)match(input,Not,FOLLOW_Not_in_unExpr526);  
					stream_Not.add(Not43);
					dbg.location(122,12);
					pushFollow(FOLLOW_atom_in_unExpr528);
					atom44=atom();
					state._fsp--;

					stream_atom.add(atom44.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 122:17: -> ^( UNARY_NEGATE atom )
					{
						dbg.location(122,20);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:20: ^( UNARY_NEGATE atom )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(122,22);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_NEGATE, "UNARY_NEGATE"), root_1);
						dbg.location(122,35);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:8: atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(123,8);
					pushFollow(FOLLOW_atom_in_unExpr545);
					atom45=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom45.getTree());

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
		dbg.location(124, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:1: mulExpr : lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* ;
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
		dbg.location(126, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: (lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:9: lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(127,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr579);
			lhs=unExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(127,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:21: (op= ( Mul | Div ) ^rhs= unExpr )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( (LA10_0==Div||LA10_0==Mul) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:23: op= ( Mul | Div ) ^rhs= unExpr
					{
					dbg.location(127,25);
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Div||input.LA(1)==Mul ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(127,44);
					pushFollow(FOLLOW_unExpr_in_mulExpr599);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop10;
				}
			}
			} finally {dbg.exitSubRule(10);}

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
		dbg.location(128, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:1: addExpr : lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* ;
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
		dbg.location(131, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: (lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:9: lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(132,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr631);
			lhs=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(132,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:21: (op= ( Add | Sub ) ^rhs= mulExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==Add||LA11_0==Sub) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:23: op= ( Add | Sub ) ^rhs= mulExpr
					{
					dbg.location(132,25);
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Sub ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(132,43);
					pushFollow(FOLLOW_mulExpr_in_addExpr649);
					rhs=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

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
		dbg.location(133, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:135:1: relExpr : lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* ;
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
		dbg.location(135, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:5: (lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:9: lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(136,12);
			pushFollow(FOLLOW_addExpr_in_relExpr676);
			lhs=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(136,22);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:22: (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==Equ||(LA12_0 >= GT && LA12_0 <= GTEqu)||(LA12_0 >= LT && LA12_0 <= LTEqu)||LA12_0==NotEqu) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:24: op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr
					{
					dbg.location(136,26);
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Equ||(input.LA(1) >= GT && input.LA(1) <= GTEqu)||(input.LA(1) >= LT && input.LA(1) <= LTEqu)||input.LA(1)==NotEqu ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(136,67);
					pushFollow(FOLLOW_addExpr_in_relExpr705);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

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
		dbg.location(137, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:1: andExpr : lhs= relExpr ( And ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token And46=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And46_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(139, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:5: (lhs= relExpr ( And ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:9: lhs= relExpr ( And ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(140,12);
			pushFollow(FOLLOW_relExpr_in_andExpr734);
			lhs=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(140,21);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:21: ( And ^rhs= relExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( (LA13_0==And) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:23: And ^rhs= relExpr
					{
					dbg.location(140,26);
					And46=(Token)match(input,And,FOLLOW_And_in_andExpr738); 
					And46_tree = (Object)adaptor.create(And46);
					root_0 = (Object)adaptor.becomeRoot(And46_tree, root_0);
					dbg.location(140,31);
					pushFollow(FOLLOW_relExpr_in_andExpr743);
					rhs=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

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
		dbg.location(141, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:144:1: orExpr : lhs= andExpr ( Or ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Or47=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or47_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(144, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:145:5: (lhs= andExpr ( Or ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:145:8: lhs= andExpr ( Or ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(145,11);
			pushFollow(FOLLOW_andExpr_in_orExpr774);
			lhs=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(145,20);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:145:20: ( Or ^rhs= andExpr )*
			try { dbg.enterSubRule(14);

			loop14:
			while (true) {
				int alt14=2;
				try { dbg.enterDecision(14, decisionCanBacktrack[14]);

				int LA14_0 = input.LA(1);
				if ( (LA14_0==Or) ) {
					alt14=1;
				}

				} finally {dbg.exitDecision(14);}

				switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:145:22: Or ^rhs= andExpr
					{
					dbg.location(145,24);
					Or47=(Token)match(input,Or,FOLLOW_Or_in_orExpr778); 
					Or47_tree = (Object)adaptor.create(Or47);
					root_0 = (Object)adaptor.becomeRoot(Or47_tree, root_0);
					dbg.location(145,29);
					pushFollow(FOLLOW_andExpr_in_orExpr783);
					rhs=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop14;
				}
			}
			} finally {dbg.exitSubRule(14);}

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
		dbg.location(146, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse109 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_FormId_in_parse111 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Lbr_in_parse113 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_blockItem_in_parse115 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_Rbr_in_parse118 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionAssignment_in_blockItem140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_blockItem144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment164 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_questionAssignment167 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_String_in_questionAssignment170 = new BitSet(new long[]{0x0000000080000800L});
	public static final BitSet FOLLOW_identType_in_questionAssignment172 = new BitSet(new long[]{0x000000408A000802L});
	public static final BitSet FOLLOW_atom_in_questionAssignment175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment228 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_constantAssignment231 = new BitSet(new long[]{0x0000000080000800L});
	public static final BitSet FOLLOW_identType_in_constantAssignment233 = new BitSet(new long[]{0x000000408A000800L});
	public static final BitSet FOLLOW_atom_in_constantAssignment235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_ifBlock317 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifBlock320 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_elseBlock_in_ifBlock324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement368 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RoundLbr_in_ifStatement370 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_orExpr_in_ifStatement372 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifStatement375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock393 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock396 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock413 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock415 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock417 = new BitSet(new long[]{0x0000002006000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_atom460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_atom466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom476 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_orExpr_in_atom482 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr506 = new BitSet(new long[]{0x000000408A000800L});
	public static final BitSet FOLLOW_atom_in_unExpr508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unExpr526 = new BitSet(new long[]{0x000000408A000800L});
	public static final BitSet FOLLOW_atom_in_unExpr528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr579 = new BitSet(new long[]{0x0000000100002002L});
	public static final BitSet FOLLOW_set_in_mulExpr586 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr599 = new BitSet(new long[]{0x0000000100002002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr631 = new BitSet(new long[]{0x0000020000000082L});
	public static final BitSet FOLLOW_set_in_addExpr637 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr649 = new BitSet(new long[]{0x0000020000000082L});
	public static final BitSet FOLLOW_addExpr_in_relExpr676 = new BitSet(new long[]{0x00000004300C8002L});
	public static final BitSet FOLLOW_set_in_relExpr683 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_addExpr_in_relExpr705 = new BitSet(new long[]{0x00000004300C8002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr734 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_And_in_andExpr738 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_relExpr_in_andExpr743 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_andExpr_in_orExpr774 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_Or_in_orExpr778 = new BitSet(new long[]{0x000002428A000800L});
	public static final BitSet FOLLOW_andExpr_in_orExpr783 = new BitSet(new long[]{0x0000000800000002L});
}
