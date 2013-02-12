// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-12 08:24:47

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.nodes.values.*;
import org.uva.sea.ql.ast.nodes.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.questionnaire.*;


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
		"Add", "And", "Assignment_Indicator", "Boolean", "COMMENT", "Div", "Else", 
		"Equ", "FormId", "FormStart", "GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", 
		"IF_BLOCK_TRUE", "IF_CONDITION", "IF_STATEMENT", "Ident", "If", "Int", 
		"LT", "LTEqu", "Lbr", "Money", "Mul", "NotEqu", "Or", "QUESTION_ASSIGNMENT", 
		"QUESTION_LABEL", "QuestionLabel", "Rbr", "RoundLbr", "RoundRbr", "Sub", 
		"VAR_ASSIGNMENT", "WS", "'!'"
	};
	public static final int EOF=-1;
	public static final int T__42=42;
	public static final int ASSIGNMENT_EXPRESSION=4;
	public static final int ASSIGNMENT_TYPE=5;
	public static final int Add=6;
	public static final int And=7;
	public static final int Assignment_Indicator=8;
	public static final int Boolean=9;
	public static final int COMMENT=10;
	public static final int Div=11;
	public static final int Else=12;
	public static final int Equ=13;
	public static final int FormId=14;
	public static final int FormStart=15;
	public static final int GT=16;
	public static final int GTEqu=17;
	public static final int IDENT=18;
	public static final int IF_BLOCK_FALSE=19;
	public static final int IF_BLOCK_TRUE=20;
	public static final int IF_CONDITION=21;
	public static final int IF_STATEMENT=22;
	public static final int Ident=23;
	public static final int If=24;
	public static final int Int=25;
	public static final int LT=26;
	public static final int LTEqu=27;
	public static final int Lbr=28;
	public static final int Money=29;
	public static final int Mul=30;
	public static final int NotEqu=31;
	public static final int Or=32;
	public static final int QUESTION_ASSIGNMENT=33;
	public static final int QUESTION_LABEL=34;
	public static final int QuestionLabel=35;
	public static final int Rbr=36;
	public static final int RoundLbr=37;
	public static final int RoundRbr=38;
	public static final int Sub=39;
	public static final int VAR_ASSIGNMENT=40;
	public static final int WS=41;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "elseBlock", "ifStatement", "relExpr", "assignmentStatement", 
		"ifStatementBlock", "mulExpr", "atom", "answerableStatement", "ifConditionalExpression", 
		"orExpr", "addExpr", "identType", "unExpr", "parse", "andExpr", "statement"
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:58:1: parse : FormStart FormId Lbr ( statement )+ Rbr EOF -> ^( FormId ( statement )+ ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FormStart1=null;
		Token FormId2=null;
		Token Lbr3=null;
		Token Rbr5=null;
		Token EOF6=null;
		ParserRuleReturnScope statement4 =null;

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
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:2: ( FormStart FormId Lbr ( statement )+ Rbr EOF -> ^( FormId ( statement )+ ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:4: FormStart FormId Lbr ( statement )+ Rbr EOF
			{
			dbg.location(59,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse96);  
			stream_FormStart.add(FormStart1);
			dbg.location(59,14);
			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse98);  
			stream_FormId.add(FormId2);
			dbg.location(59,21);
			Lbr3=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse100);  
			stream_Lbr.add(Lbr3);
			dbg.location(59,25);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:25: ( statement )+
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:25: statement
					{
					dbg.location(59,25);
					pushFollow(FOLLOW_statement_in_parse102);
					statement4=statement();
					state._fsp--;

					stream_statement.add(statement4.getTree());
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
			dbg.location(59,36);
			Rbr5=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse105);  
			stream_Rbr.add(Rbr5);
			dbg.location(59,40);
			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_parse107);  
			stream_EOF.add(EOF6);

			// AST REWRITE
			// elements: FormId, statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 59:44: -> ^( FormId ( statement )+ )
			{
				dbg.location(59,47);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:47: ^( FormId ( statement )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(59,49);
				root_1 = (Object)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(59,56);
				if ( !(stream_statement.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_statement.hasNext() ) {
					dbg.location(59,56);
					adaptor.addChild(root_1, stream_statement.nextTree());
				}
				stream_statement.reset();

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
		dbg.location(59, 66);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "parse");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "parse"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:61:1: statement : ( answerableStatement | assignmentStatement | ifStatement ) ;
	public final QLParser.statement_return statement() throws RecognitionException {
		QLParser.statement_return retval = new QLParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope answerableStatement7 =null;
		ParserRuleReturnScope assignmentStatement8 =null;
		ParserRuleReturnScope ifStatement9 =null;


		try { dbg.enterRule(getGrammarFileName(), "statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(61, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:2: ( ( answerableStatement | assignmentStatement | ifStatement ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: ( answerableStatement | assignmentStatement | ifStatement )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(62,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:4: ( answerableStatement | assignmentStatement | ifStatement )
			int alt2=3;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==Assignment_Indicator) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==QuestionLabel) ) {
						alt2=1;
					}
					else if ( (LA2_3==Boolean||LA2_3==Money) ) {
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:5: answerableStatement
					{
					dbg.location(62,5);
					pushFollow(FOLLOW_answerableStatement_in_statement127);
					answerableStatement7=answerableStatement();
					state._fsp--;

					adaptor.addChild(root_0, answerableStatement7.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:27: assignmentStatement
					{
					dbg.location(62,27);
					pushFollow(FOLLOW_assignmentStatement_in_statement131);
					assignmentStatement8=assignmentStatement();
					state._fsp--;

					adaptor.addChild(root_0, assignmentStatement8.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:62:49: ifStatement
					{
					dbg.location(62,49);
					pushFollow(FOLLOW_ifStatement_in_statement135);
					ifStatement9=ifStatement();
					state._fsp--;

					adaptor.addChild(root_0, ifStatement9.getTree());

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
		dbg.location(62, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "statement"


	public static class answerableStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "answerableStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:1: answerableStatement : varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )? -> ^( QUESTION_ASSIGNMENT ^( IDENT $varName) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL $label) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
	public final QLParser.answerableStatement_return answerableStatement() throws RecognitionException {
		QLParser.answerableStatement_return retval = new QLParser.answerableStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token varName=null;
		Token label=null;
		Token Assignment_Indicator10=null;
		ParserRuleReturnScope identType11 =null;
		ParserRuleReturnScope atom12 =null;

		Object varName_tree=null;
		Object label_tree=null;
		Object Assignment_Indicator10_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "answerableStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:2: (varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )? -> ^( QUESTION_ASSIGNMENT ^( IDENT $varName) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL $label) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:4: varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )?
			{
			dbg.location(67,11);
			varName=(Token)match(input,Ident,FOLLOW_Ident_in_answerableStatement154);  
			stream_Ident.add(varName);
			dbg.location(67,19);
			Assignment_Indicator10=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_answerableStatement157);  
			stream_Assignment_Indicator.add(Assignment_Indicator10);
			dbg.location(67,46);
			label=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_answerableStatement162);  
			stream_QuestionLabel.add(label);
			dbg.location(67,61);
			pushFollow(FOLLOW_identType_in_answerableStatement164);
			identType11=identType();
			state._fsp--;

			stream_identType.add(identType11.getTree());dbg.location(67,71);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:71: ( atom )?
			int alt3=2;
			try { dbg.enterSubRule(3);
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==Boolean||LA3_0==Int||LA3_0==Money||LA3_0==RoundLbr) ) {
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:72: atom
					{
					dbg.location(67,72);
					pushFollow(FOLLOW_atom_in_answerableStatement167);
					atom12=atom();
					state._fsp--;

					stream_atom.add(atom12.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: varName, label, atom, identType
			// token labels: varName, label
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_varName=new RewriteRuleTokenStream(adaptor,"token varName",varName);
			RewriteRuleTokenStream stream_label=new RewriteRuleTokenStream(adaptor,"token label",label);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 67:80: -> ^( QUESTION_ASSIGNMENT ^( IDENT $varName) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL $label) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				dbg.location(67,82);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:82: ^( QUESTION_ASSIGNMENT ^( IDENT $varName) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL $label) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(67,84);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_ASSIGNMENT, "QUESTION_ASSIGNMENT"), root_1);
				dbg.location(67,104);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:104: ^( IDENT $varName)
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(67,106);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(67,113);
				adaptor.addChild(root_2, stream_varName.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(67,122);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:122: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(67,124);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(67,140);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(67,151);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:151: ^( QUESTION_LABEL $label)
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(67,153);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(67,170);
				adaptor.addChild(root_2, stream_label.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(67,178);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:178: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					dbg.location(67,178);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:67:178: ^( ASSIGNMENT_EXPRESSION atom )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(67,180);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
					dbg.location(67,202);
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
		dbg.location(68, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "answerableStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "answerableStatement"


	public static class assignmentStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignmentStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: assignmentStatement : constName= Ident Assignment_Indicator identType atom -> ^( VAR_ASSIGNMENT ^( IDENT $constName) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
	public final QLParser.assignmentStatement_return assignmentStatement() throws RecognitionException {
		QLParser.assignmentStatement_return retval = new QLParser.assignmentStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token constName=null;
		Token Assignment_Indicator13=null;
		ParserRuleReturnScope identType14 =null;
		ParserRuleReturnScope atom15 =null;

		Object constName_tree=null;
		Object Assignment_Indicator13_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "assignmentStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:2: (constName= Ident Assignment_Indicator identType atom -> ^( VAR_ASSIGNMENT ^( IDENT $constName) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:4: constName= Ident Assignment_Indicator identType atom
			{
			dbg.location(72,13);
			constName=(Token)match(input,Ident,FOLLOW_Ident_in_assignmentStatement219);  
			stream_Ident.add(constName);
			dbg.location(72,21);
			Assignment_Indicator13=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_assignmentStatement222);  
			stream_Assignment_Indicator.add(Assignment_Indicator13);
			dbg.location(72,42);
			pushFollow(FOLLOW_identType_in_assignmentStatement224);
			identType14=identType();
			state._fsp--;

			stream_identType.add(identType14.getTree());dbg.location(72,52);
			pushFollow(FOLLOW_atom_in_assignmentStatement226);
			atom15=atom();
			state._fsp--;

			stream_atom.add(atom15.getTree());
			// AST REWRITE
			// elements: atom, constName, identType
			// token labels: constName
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_constName=new RewriteRuleTokenStream(adaptor,"token constName",constName);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 72:57: -> ^( VAR_ASSIGNMENT ^( IDENT $constName) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				dbg.location(72,60);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:60: ^( VAR_ASSIGNMENT ^( IDENT $constName) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(72,62);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_ASSIGNMENT, "VAR_ASSIGNMENT"), root_1);
				dbg.location(72,77);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:77: ^( IDENT $constName)
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(72,79);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				dbg.location(72,86);
				adaptor.addChild(root_2, stream_constName.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(72,98);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:98: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(72,100);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				dbg.location(72,116);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(72,127);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:127: ^( ASSIGNMENT_EXPRESSION atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(72,129);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
				dbg.location(72,152);
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
		dbg.location(73, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assignmentStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "assignmentStatement"


	public static class identType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:1: identType : ( Boolean -> Boolean | Money -> Money );
	public final QLParser.identType_return identType() throws RecognitionException {
		QLParser.identType_return retval = new QLParser.identType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Boolean16=null;
		Token Money17=null;

		Object Boolean16_tree=null;
		Object Money17_tree=null;
		RewriteRuleTokenStream stream_Money=new RewriteRuleTokenStream(adaptor,"token Money");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");

		try { dbg.enterRule(getGrammarFileName(), "identType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:2: ( Boolean -> Boolean | Money -> Money )
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
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:4: Boolean
					{
					dbg.location(77,4);
					Boolean16=(Token)match(input,Boolean,FOLLOW_Boolean_in_identType267);  
					stream_Boolean.add(Boolean16);

					// AST REWRITE
					// elements: Boolean
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 77:12: -> Boolean
					{
						dbg.location(77,15);
						adaptor.addChild(root_0, stream_Boolean.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:4: Money
					{
					dbg.location(78,4);
					Money17=(Token)match(input,Money,FOLLOW_Money_in_identType277);  
					stream_Money.add(Money17);

					// AST REWRITE
					// elements: Money
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 78:10: -> Money
					{
						dbg.location(78,13);
						adaptor.addChild(root_0, stream_Money.nextNode());
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
		dbg.location(79, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "identType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "identType"


	public static class ifStatement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatement"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: ifStatement : If ifConditionalExpression ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifConditionalExpression ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token If18=null;
		ParserRuleReturnScope ifConditionalExpression19 =null;
		ParserRuleReturnScope ifStatementBlock20 =null;
		ParserRuleReturnScope elseBlock21 =null;

		Object If18_tree=null;
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
		RewriteRuleSubtreeStream stream_ifConditionalExpression=new RewriteRuleSubtreeStream(adaptor,"rule ifConditionalExpression");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:2: ( If ifConditionalExpression ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifConditionalExpression ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:3: If ifConditionalExpression ifStatementBlock ( elseBlock )?
			{
			dbg.location(83,3);
			If18=(Token)match(input,If,FOLLOW_If_in_ifStatement295);  
			stream_If.add(If18);
			dbg.location(83,6);
			pushFollow(FOLLOW_ifConditionalExpression_in_ifStatement297);
			ifConditionalExpression19=ifConditionalExpression();
			state._fsp--;

			stream_ifConditionalExpression.add(ifConditionalExpression19.getTree());dbg.location(83,31);
			pushFollow(FOLLOW_ifStatementBlock_in_ifStatement300);
			ifStatementBlock20=ifStatementBlock();
			state._fsp--;

			stream_ifStatementBlock.add(ifStatementBlock20.getTree());dbg.location(83,49);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:49: ( elseBlock )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:50: elseBlock
					{
					dbg.location(83,50);
					pushFollow(FOLLOW_elseBlock_in_ifStatement304);
					elseBlock21=elseBlock();
					state._fsp--;

					stream_elseBlock.add(elseBlock21.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: elseBlock, ifStatementBlock, ifConditionalExpression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 83:63: -> ^( IF_STATEMENT ^( IF_CONDITION ifConditionalExpression ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				dbg.location(83,65);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:65: ^( IF_STATEMENT ^( IF_CONDITION ifConditionalExpression ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(83,67);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				dbg.location(83,81);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:81: ^( IF_CONDITION ifConditionalExpression )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,83);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				dbg.location(83,96);
				adaptor.addChild(root_2, stream_ifConditionalExpression.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,123);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:123: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,125);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				dbg.location(83,139);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,157);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:157: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(83,157);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:157: ^( IF_BLOCK_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(83,159);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_FALSE, "IF_BLOCK_FALSE"), root_2);
					dbg.location(83,174);
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
		dbg.location(84, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifStatement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifStatement"


	public static class ifConditionalExpression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifConditionalExpression"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:1: ifConditionalExpression : RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifConditionalExpression_return ifConditionalExpression() throws RecognitionException {
		QLParser.ifConditionalExpression_return retval = new QLParser.ifConditionalExpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RoundLbr22=null;
		Token RoundRbr24=null;
		ParserRuleReturnScope orExpr23 =null;

		Object RoundLbr22_tree=null;
		Object RoundRbr24_tree=null;
		RewriteRuleTokenStream stream_RoundLbr=new RewriteRuleTokenStream(adaptor,"token RoundLbr");
		RewriteRuleTokenStream stream_RoundRbr=new RewriteRuleTokenStream(adaptor,"token RoundRbr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifConditionalExpression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:2: ( RoundLbr orExpr RoundRbr -> orExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:5: RoundLbr orExpr RoundRbr
			{
			dbg.location(87,5);
			RoundLbr22=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifConditionalExpression348);  
			stream_RoundLbr.add(RoundLbr22);
			dbg.location(87,14);
			pushFollow(FOLLOW_orExpr_in_ifConditionalExpression350);
			orExpr23=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr23.getTree());dbg.location(87,22);
			RoundRbr24=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifConditionalExpression353);  
			stream_RoundRbr.add(RoundRbr24);

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
			// 87:31: -> orExpr
			{
				dbg.location(87,34);
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
		dbg.location(87, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifConditionalExpression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifConditionalExpression"


	public static class ifStatementBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: ifStatementBlock : Lbr ( statement )* Rbr -> ( statement )* ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Lbr25=null;
		Token Rbr27=null;
		ParserRuleReturnScope statement26 =null;

		Object Lbr25_tree=null;
		Object Rbr27_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:2: ( Lbr ( statement )* Rbr -> ( statement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Lbr ( statement )* Rbr
			{
			dbg.location(90,5);
			Lbr25=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock370);  
			stream_Lbr.add(Lbr25);
			dbg.location(90,10);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: ( statement )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: statement
					{
					dbg.location(90,10);
					pushFollow(FOLLOW_statement_in_ifStatementBlock373);
					statement26=statement();
					state._fsp--;

					stream_statement.add(statement26.getTree());
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(90,21);
			Rbr27=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock376);  
			stream_Rbr.add(Rbr27);

			// AST REWRITE
			// elements: statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 90:25: -> ( statement )*
			{
				dbg.location(90,28);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:28: ( statement )*
				while ( stream_statement.hasNext() ) {
					dbg.location(90,28);
					adaptor.addChild(root_0, stream_statement.nextTree());
				}
				stream_statement.reset();

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
		dbg.location(90, 37);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: elseBlock : Else Lbr ( statement )* Rbr -> ( statement )* ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else28=null;
		Token Lbr29=null;
		Token Rbr31=null;
		ParserRuleReturnScope statement30 =null;

		Object Else28_tree=null;
		Object Lbr29_tree=null;
		Object Rbr31_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(92, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:2: ( Else Lbr ( statement )* Rbr -> ( statement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:4: Else Lbr ( statement )* Rbr
			{
			dbg.location(93,4);
			Else28=(Token)match(input,Else,FOLLOW_Else_in_elseBlock390);  
			stream_Else.add(Else28);
			dbg.location(93,9);
			Lbr29=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock392);  
			stream_Lbr.add(Lbr29);
			dbg.location(93,13);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: ( statement )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: statement
					{
					dbg.location(93,13);
					pushFollow(FOLLOW_statement_in_elseBlock394);
					statement30=statement();
					state._fsp--;

					stream_statement.add(statement30.getTree());
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(93,24);
			Rbr31=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock397);  
			stream_Rbr.add(Rbr31);

			// AST REWRITE
			// elements: statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 93:28: -> ( statement )*
			{
				dbg.location(93,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:31: ( statement )*
				while ( stream_statement.hasNext() ) {
					dbg.location(93,31);
					adaptor.addChild(root_0, stream_statement.nextTree());
				}
				stream_statement.reset();

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: atom returns [Expr result] : ( Int | Ident | Boolean | Money | RoundLbr !x= orExpr ^ RoundRbr !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Int32=null;
		Token Ident33=null;
		Token Boolean34=null;
		Token Money35=null;
		Token RoundLbr36=null;
		Token RoundRbr37=null;
		ParserRuleReturnScope x =null;

		Object Int32_tree=null;
		Object Ident33_tree=null;
		Object Boolean34_tree=null;
		Object Money35_tree=null;
		Object RoundLbr36_tree=null;
		Object RoundRbr37_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(99, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:3: ( Int | Ident | Boolean | Money | RoundLbr !x= orExpr ^ RoundRbr !)
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
			case Boolean:
				{
				alt8=3;
				}
				break;
			case Money:
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
					Int32=(Token)match(input,Int,FOLLOW_Int_in_atom425); 
					Int32_tree = (Object)adaptor.create(Int32);
					adaptor.addChild(root_0, Int32_tree);
					dbg.location(100,11);
					 retval.result = new Int(Integer.parseInt((Int32!=null?Int32.getText():null))); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(101,5);
					Ident33=(Token)match(input,Ident,FOLLOW_Ident_in_atom435); 
					Ident33_tree = (Object)adaptor.create(Ident33);
					adaptor.addChild(root_0, Ident33_tree);
					dbg.location(101,11);
					 retval.result = new Ident((Ident33!=null?Ident33.getText():null), new Bool(false)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: Boolean
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(102,5);
					Boolean34=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom444); 
					Boolean34_tree = (Object)adaptor.create(Boolean34);
					adaptor.addChild(root_0, Boolean34_tree);
					dbg.location(102,13);
					retval.result = new Bool(false);
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: Money
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(103,5);
					Money35=(Token)match(input,Money,FOLLOW_Money_in_atom452); 
					Money35_tree = (Object)adaptor.create(Money35);
					adaptor.addChild(root_0, Money35_tree);
					dbg.location(103,11);
					 retval.result = new Int(Integer.parseInt((Money35!=null?Money35.getText():null)));
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(105,14);
					RoundLbr36=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom463); dbg.location(105,18);
					pushFollow(FOLLOW_orExpr_in_atom469);
					x=orExpr();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);dbg.location(105,35);
					RoundRbr37=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom472); dbg.location(105,37);
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:1: unExpr returns [Expr result] : ( Add x= atom | Sub x= atom | '!' x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Add38=null;
		Token Sub39=null;
		Token char_literal40=null;
		ParserRuleReturnScope x =null;

		Object Add38_tree=null;
		Object Sub39_tree=null;
		Object char_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "unExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(108, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:5: ( Add x= atom | Sub x= atom | '!' x= atom |x= atom )
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
			case 42:
				{
				alt9=3;
				}
				break;
			case Boolean:
			case Ident:
			case Int:
			case Money:
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
					Add38=(Token)match(input,Add,FOLLOW_Add_in_unExpr498); 
					Add38_tree = (Object)adaptor.create(Add38);
					adaptor.addChild(root_0, Add38_tree);
					dbg.location(109,13);
					pushFollow(FOLLOW_atom_in_unExpr502);
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
					Sub39=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr513); 
					Sub39_tree = (Object)adaptor.create(Sub39);
					adaptor.addChild(root_0, Sub39_tree);
					dbg.location(110,13);
					pushFollow(FOLLOW_atom_in_unExpr517);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(110,19);
					 retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:8: '!' x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(111,8);
					char_literal40=(Token)match(input,42,FOLLOW_42_in_unExpr528); 
					char_literal40_tree = (Object)adaptor.create(char_literal40);
					adaptor.addChild(root_0, char_literal40_tree);
					dbg.location(111,13);
					pushFollow(FOLLOW_atom_in_unExpr532);
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
					pushFollow(FOLLOW_atom_in_unExpr545);
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
			pushFollow(FOLLOW_unExpr_in_mulExpr583);
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
							op=(Token)match(input,Mul,FOLLOW_Mul_in_mulExpr593); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:59: Div ^
							{
							dbg.location(116,62);
							op=(Token)match(input,Div,FOLLOW_Div_in_mulExpr598); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(116,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr605);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(117,5);
					 
					      if ((op!=null?op.getText():null).equals("*")) {
					        retval.result = new Mul(retval.result, (rhs!=null?((QLParser.unExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("<=")) {
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
			pushFollow(FOLLOW_mulExpr_in_addExpr646);
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
							op=(Token)match(input,Add,FOLLOW_Add_in_addExpr655); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:59: Sub ^
							{
							dbg.location(129,62);
							op=(Token)match(input,Sub,FOLLOW_Sub_in_addExpr660); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(129,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr666);
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
			pushFollow(FOLLOW_addExpr_in_relExpr701);
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
							op=(Token)match(input,LT,FOLLOW_LT_in_relExpr710); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:56: LTEqu ^
							{
							dbg.location(141,61);
							op=(Token)match(input,LTEqu,FOLLOW_LTEqu_in_relExpr713); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:63: GT ^
							{
							dbg.location(141,65);
							op=(Token)match(input,GT,FOLLOW_GT_in_relExpr716); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:67: GTEqu ^
							{
							dbg.location(141,72);
							op=(Token)match(input,GTEqu,FOLLOW_GTEqu_in_relExpr719); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:74: Equ ^
							{
							dbg.location(141,77);
							op=(Token)match(input,Equ,FOLLOW_Equ_in_relExpr722); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:79: NotEqu ^
							{
							dbg.location(141,85);
							op=(Token)match(input,NotEqu,FOLLOW_NotEqu_in_relExpr725); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(14);}
					dbg.location(141,91);
					pushFollow(FOLLOW_addExpr_in_relExpr731);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(142,5);
					 
					      if ((op!=null?op.getText():null).equals(op)) {
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

		Token And41=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And41_tree=null;

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
			pushFollow(FOLLOW_relExpr_in_andExpr769);
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
					And41=(Token)match(input,And,FOLLOW_And_in_andExpr775); 
					And41_tree = (Object)adaptor.create(And41);
					root_0 = (Object)adaptor.becomeRoot(And41_tree, root_0);
					dbg.location(165,56);
					pushFollow(FOLLOW_relExpr_in_andExpr780);
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

		Token Or42=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or42_tree=null;

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
			pushFollow(FOLLOW_andExpr_in_orExpr815);
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
					Or42=(Token)match(input,Or,FOLLOW_Or_in_orExpr821); 
					Or42_tree = (Object)adaptor.create(Or42);
					root_0 = (Object)adaptor.becomeRoot(Or42_tree, root_0);
					dbg.location(170,56);
					pushFollow(FOLLOW_andExpr_in_orExpr826);
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



	public static final BitSet FOLLOW_FormStart_in_parse96 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_FormId_in_parse98 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Lbr_in_parse100 = new BitSet(new long[]{0x0000000001800000L});
	public static final BitSet FOLLOW_statement_in_parse102 = new BitSet(new long[]{0x0000001001800000L});
	public static final BitSet FOLLOW_Rbr_in_parse105 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_answerableStatement_in_statement127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignmentStatement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_answerableStatement154 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_answerableStatement157 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_answerableStatement162 = new BitSet(new long[]{0x0000000020000200L});
	public static final BitSet FOLLOW_identType_in_answerableStatement164 = new BitSet(new long[]{0x0000002022800202L});
	public static final BitSet FOLLOW_atom_in_answerableStatement167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_assignmentStatement219 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_assignmentStatement222 = new BitSet(new long[]{0x0000000020000200L});
	public static final BitSet FOLLOW_identType_in_assignmentStatement224 = new BitSet(new long[]{0x0000002022800200L});
	public static final BitSet FOLLOW_atom_in_assignmentStatement226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_identType267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_identType277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement295 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ifConditionalExpression_in_ifStatement297 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifStatement300 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_elseBlock_in_ifStatement304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_ifConditionalExpression348 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_orExpr_in_ifConditionalExpression350 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifConditionalExpression353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock370 = new BitSet(new long[]{0x0000001001800000L});
	public static final BitSet FOLLOW_statement_in_ifStatementBlock373 = new BitSet(new long[]{0x0000001001800000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock390 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock392 = new BitSet(new long[]{0x0000001001800000L});
	public static final BitSet FOLLOW_statement_in_elseBlock394 = new BitSet(new long[]{0x0000001001800000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom463 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_orExpr_in_atom469 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Add_in_unExpr498 = new BitSet(new long[]{0x0000002022800200L});
	public static final BitSet FOLLOW_atom_in_unExpr502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr513 = new BitSet(new long[]{0x0000002022800200L});
	public static final BitSet FOLLOW_atom_in_unExpr517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_unExpr528 = new BitSet(new long[]{0x0000002022800200L});
	public static final BitSet FOLLOW_atom_in_unExpr532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr583 = new BitSet(new long[]{0x0000000040000802L});
	public static final BitSet FOLLOW_Mul_in_mulExpr593 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_Div_in_mulExpr598 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr605 = new BitSet(new long[]{0x0000000040000802L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr646 = new BitSet(new long[]{0x0000008000000042L});
	public static final BitSet FOLLOW_Add_in_addExpr655 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_Sub_in_addExpr660 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr666 = new BitSet(new long[]{0x0000008000000042L});
	public static final BitSet FOLLOW_addExpr_in_relExpr701 = new BitSet(new long[]{0x000000008C032002L});
	public static final BitSet FOLLOW_LT_in_relExpr710 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_LTEqu_in_relExpr713 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_GT_in_relExpr716 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_GTEqu_in_relExpr719 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_Equ_in_relExpr722 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_NotEqu_in_relExpr725 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_addExpr_in_relExpr731 = new BitSet(new long[]{0x000000008C032002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr769 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_And_in_andExpr775 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_relExpr_in_andExpr780 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_andExpr_in_orExpr815 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_Or_in_orExpr821 = new BitSet(new long[]{0x000004A022800240L});
	public static final BitSet FOLLOW_andExpr_in_orExpr826 = new BitSet(new long[]{0x0000000100000002L});
}
