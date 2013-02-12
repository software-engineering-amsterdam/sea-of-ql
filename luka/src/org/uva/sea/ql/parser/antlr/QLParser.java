// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-12 07:41:45

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Assignment_Indicator", "BOOL_LITERAL", 
		"BOOL_TYPE", "Boolean", "COMMENT", "CONST_NAME", "CONST_TYPE", "CONST_TYPE_INT", 
		"CONST_VALUE", "CONST_VAR", "Else", "FormId", "FormStart", "IDENT_LITERAL", 
		"IF_BLOCK", "IF_EXPRESSION", "IF_FALSE", "IF_TRUE", "INTEGER_TYPE", "INT_LITERAL", 
		"INT_TYPE", "Ident", "If", "Int", "Lbr", "MONEY_LITERAL", "MONEY_TYPE", 
		"Money", "NEG_EXPR", "QUESTION_BLOCK", "QUESTION_LABEL", "QUESTION_VAR", 
		"QuestionLabel", "ROOT", "Rbr", "RoundLbr", "RoundRbr", "STR_LITERAL", 
		"STR_TYPE", "UNARY_EXPR", "VALUE_CALC", "VAR_NAME", "VAR_TYPE", "VAR_VALUE", 
		"WS", "'!'", "'!='", "'&&'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", 
		"'=='", "'>'", "'>='", "'||'"
	};
	public static final int EOF=-1;
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
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int Assignment_Indicator=4;
	public static final int BOOL_LITERAL=5;
	public static final int BOOL_TYPE=6;
	public static final int Boolean=7;
	public static final int COMMENT=8;
	public static final int CONST_NAME=9;
	public static final int CONST_TYPE=10;
	public static final int CONST_TYPE_INT=11;
	public static final int CONST_VALUE=12;
	public static final int CONST_VAR=13;
	public static final int Else=14;
	public static final int FormId=15;
	public static final int FormStart=16;
	public static final int IDENT_LITERAL=17;
	public static final int IF_BLOCK=18;
	public static final int IF_EXPRESSION=19;
	public static final int IF_FALSE=20;
	public static final int IF_TRUE=21;
	public static final int INTEGER_TYPE=22;
	public static final int INT_LITERAL=23;
	public static final int INT_TYPE=24;
	public static final int Ident=25;
	public static final int If=26;
	public static final int Int=27;
	public static final int Lbr=28;
	public static final int MONEY_LITERAL=29;
	public static final int MONEY_TYPE=30;
	public static final int Money=31;
	public static final int NEG_EXPR=32;
	public static final int QUESTION_BLOCK=33;
	public static final int QUESTION_LABEL=34;
	public static final int QUESTION_VAR=35;
	public static final int QuestionLabel=36;
	public static final int ROOT=37;
	public static final int Rbr=38;
	public static final int RoundLbr=39;
	public static final int RoundRbr=40;
	public static final int STR_LITERAL=41;
	public static final int STR_TYPE=42;
	public static final int UNARY_EXPR=43;
	public static final int VALUE_CALC=44;
	public static final int VAR_NAME=45;
	public static final int VAR_TYPE=46;
	public static final int VAR_VALUE=47;
	public static final int WS=48;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "elseBlock", "mulExpr", "ifConditionalExpression", "andExpr", 
		"addExpr", "orExpr", "statement", "ifStatementBlock", "unExpr", "assignmentStatement", 
		"identType", "atom", "relExpr", "parse", "answerableStatement", "ifStatement"
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:1: parse : FormStart formName= FormId Lbr ( statement )+ Rbr EOF -> ^( FormId ( statement )+ ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token formName=null;
		Token FormStart1=null;
		Token Lbr2=null;
		Token Rbr4=null;
		Token EOF5=null;
		ParserRuleReturnScope statement3 =null;

		Object formName_tree=null;
		Object FormStart1_tree=null;
		Object Lbr2_tree=null;
		Object Rbr4_tree=null;
		Object EOF5_tree=null;
		RewriteRuleTokenStream stream_FormId=new RewriteRuleTokenStream(adaptor,"token FormId");
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "parse");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(74, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:2: ( FormStart formName= FormId Lbr ( statement )+ Rbr EOF -> ^( FormId ( statement )+ ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: FormStart formName= FormId Lbr ( statement )+ Rbr EOF
			{
			dbg.location(75,4);
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse150);  
			stream_FormStart.add(FormStart1);
			dbg.location(75,22);
			formName=(Token)match(input,FormId,FOLLOW_FormId_in_parse154);  
			stream_FormId.add(formName);
			dbg.location(75,30);
			Lbr2=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse156);  
			stream_Lbr.add(Lbr2);
			dbg.location(75,34);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:34: ( statement )+
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:34: statement
					{
					dbg.location(75,34);
					pushFollow(FOLLOW_statement_in_parse158);
					statement3=statement();
					state._fsp--;

					stream_statement.add(statement3.getTree());
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
			dbg.location(75,45);
			Rbr4=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse161);  
			stream_Rbr.add(Rbr4);
			dbg.location(75,49);
			EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_parse163);  
			stream_EOF.add(EOF5);

			// AST REWRITE
			// elements: statement, FormId
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 75:53: -> ^( FormId ( statement )+ )
			{
				dbg.location(75,56);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:56: ^( FormId ( statement )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(75,58);
				root_1 = (Object)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				dbg.location(75,65);
				if ( !(stream_statement.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_statement.hasNext() ) {
					dbg.location(75,65);
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
		dbg.location(75, 75);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:1: statement : ( answerableStatement | assignmentStatement | ifStatement ) ;
	public final QLParser.statement_return statement() throws RecognitionException {
		QLParser.statement_return retval = new QLParser.statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope answerableStatement6 =null;
		ParserRuleReturnScope assignmentStatement7 =null;
		ParserRuleReturnScope ifStatement8 =null;


		try { dbg.enterRule(getGrammarFileName(), "statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(77, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:2: ( ( answerableStatement | assignmentStatement | ifStatement ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:4: ( answerableStatement | assignmentStatement | ifStatement )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(78,4);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:4: ( answerableStatement | assignmentStatement | ifStatement )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:5: answerableStatement
					{
					dbg.location(78,5);
					pushFollow(FOLLOW_answerableStatement_in_statement183);
					answerableStatement6=answerableStatement();
					state._fsp--;

					adaptor.addChild(root_0, answerableStatement6.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:27: assignmentStatement
					{
					dbg.location(78,27);
					pushFollow(FOLLOW_assignmentStatement_in_statement187);
					assignmentStatement7=assignmentStatement();
					state._fsp--;

					adaptor.addChild(root_0, assignmentStatement7.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:49: ifStatement
					{
					dbg.location(78,49);
					pushFollow(FOLLOW_ifStatement_in_statement191);
					ifStatement8=ifStatement();
					state._fsp--;

					adaptor.addChild(root_0, ifStatement8.getTree());

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
		dbg.location(78, 62);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:1: answerableStatement : varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName identType ) ( ^( VAR_VALUE atom ) )? ) ^( QUESTION_LABEL ^( STR_LITERAL $label) ) ) ;
	public final QLParser.answerableStatement_return answerableStatement() throws RecognitionException {
		QLParser.answerableStatement_return retval = new QLParser.answerableStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token varName=null;
		Token label=null;
		Token Assignment_Indicator9=null;
		ParserRuleReturnScope identType10 =null;
		ParserRuleReturnScope atom11 =null;

		Object varName_tree=null;
		Object label_tree=null;
		Object Assignment_Indicator9_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleTokenStream stream_QuestionLabel=new RewriteRuleTokenStream(adaptor,"token QuestionLabel");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "answerableStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:2: (varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )? -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName identType ) ( ^( VAR_VALUE atom ) )? ) ^( QUESTION_LABEL ^( STR_LITERAL $label) ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:4: varName= Ident Assignment_Indicator label= QuestionLabel identType ( atom )?
			{
			dbg.location(83,11);
			varName=(Token)match(input,Ident,FOLLOW_Ident_in_answerableStatement210);  
			stream_Ident.add(varName);
			dbg.location(83,19);
			Assignment_Indicator9=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_answerableStatement213);  
			stream_Assignment_Indicator.add(Assignment_Indicator9);
			dbg.location(83,46);
			label=(Token)match(input,QuestionLabel,FOLLOW_QuestionLabel_in_answerableStatement218);  
			stream_QuestionLabel.add(label);
			dbg.location(83,61);
			pushFollow(FOLLOW_identType_in_answerableStatement220);
			identType10=identType();
			state._fsp--;

			stream_identType.add(identType10.getTree());dbg.location(83,71);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:71: ( atom )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:72: atom
					{
					dbg.location(83,72);
					pushFollow(FOLLOW_atom_in_answerableStatement223);
					atom11=atom();
					state._fsp--;

					stream_atom.add(atom11.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: label, identType, varName, atom
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
			// 83:80: -> ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName identType ) ( ^( VAR_VALUE atom ) )? ) ^( QUESTION_LABEL ^( STR_LITERAL $label) ) )
			{
				dbg.location(83,82);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:82: ^( QUESTION_BLOCK ^( QUESTION_VAR ^( IDENT_LITERAL $varName identType ) ( ^( VAR_VALUE atom ) )? ) ^( QUESTION_LABEL ^( STR_LITERAL $label) ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(83,84);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_BLOCK, "QUESTION_BLOCK"), root_1);
				dbg.location(83,99);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:99: ^( QUESTION_VAR ^( IDENT_LITERAL $varName identType ) ( ^( VAR_VALUE atom ) )? )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,101);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_VAR, "QUESTION_VAR"), root_2);
				dbg.location(83,114);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:114: ^( IDENT_LITERAL $varName identType )
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(83,116);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT_LITERAL, "IDENT_LITERAL"), root_3);
				dbg.location(83,131);
				adaptor.addChild(root_3, stream_varName.nextNode());dbg.location(83,139);
				adaptor.addChild(root_3, stream_identType.nextTree());
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(83,151);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:151: ( ^( VAR_VALUE atom ) )?
				if ( stream_atom.hasNext() ) {
					dbg.location(83,151);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:151: ^( VAR_VALUE atom )
					{
					Object root_3 = (Object)adaptor.nil();
					dbg.location(83,153);
					root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_VALUE, "VAR_VALUE"), root_3);
					dbg.location(83,163);
					adaptor.addChild(root_3, stream_atom.nextTree());
					adaptor.addChild(root_2, root_3);
					}

				}
				stream_atom.reset();

				adaptor.addChild(root_1, root_2);
				}
				dbg.location(83,172);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:172: ^( QUESTION_LABEL ^( STR_LITERAL $label) )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(83,174);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				dbg.location(83,189);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:189: ^( STR_LITERAL $label)
				{
				Object root_3 = (Object)adaptor.nil();
				dbg.location(83,191);
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(STR_LITERAL, "STR_LITERAL"), root_3);
				dbg.location(83,204);
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
		dbg.location(84, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:1: assignmentStatement : constName= Ident Assignment_Indicator identType atom -> ^( CONST_VAR ^( IDENT_LITERAL CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) ;
	public final QLParser.assignmentStatement_return assignmentStatement() throws RecognitionException {
		QLParser.assignmentStatement_return retval = new QLParser.assignmentStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token constName=null;
		Token Assignment_Indicator12=null;
		ParserRuleReturnScope identType13 =null;
		ParserRuleReturnScope atom14 =null;

		Object constName_tree=null;
		Object Assignment_Indicator12_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try { dbg.enterRule(getGrammarFileName(), "assignmentStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(87, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:2: (constName= Ident Assignment_Indicator identType atom -> ^( CONST_VAR ^( IDENT_LITERAL CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:4: constName= Ident Assignment_Indicator identType atom
			{
			dbg.location(88,13);
			constName=(Token)match(input,Ident,FOLLOW_Ident_in_assignmentStatement279);  
			stream_Ident.add(constName);
			dbg.location(88,21);
			Assignment_Indicator12=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_assignmentStatement282);  
			stream_Assignment_Indicator.add(Assignment_Indicator12);
			dbg.location(88,42);
			pushFollow(FOLLOW_identType_in_assignmentStatement284);
			identType13=identType();
			state._fsp--;

			stream_identType.add(identType13.getTree());dbg.location(88,52);
			pushFollow(FOLLOW_atom_in_assignmentStatement286);
			atom14=atom();
			state._fsp--;

			stream_atom.add(atom14.getTree());
			// AST REWRITE
			// elements: atom, constName
			// token labels: constName
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_constName=new RewriteRuleTokenStream(adaptor,"token constName",constName);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 88:57: -> ^( CONST_VAR ^( IDENT_LITERAL CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
			{
				dbg.location(88,60);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:60: ^( CONST_VAR ^( IDENT_LITERAL CONST_NAME $constName) ^( CONST_TYPE CONST_TYPE_INT ) ^( CONST_VALUE atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(88,62);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VAR, "CONST_VAR"), root_1);
				dbg.location(88,72);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:72: ^( IDENT_LITERAL CONST_NAME $constName)
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(88,74);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT_LITERAL, "IDENT_LITERAL"), root_2);
				dbg.location(88,88);
				adaptor.addChild(root_2, (Object)adaptor.create(CONST_NAME, "CONST_NAME"));dbg.location(88,100);
				adaptor.addChild(root_2, stream_constName.nextNode());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(88,111);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:111: ^( CONST_TYPE CONST_TYPE_INT )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(88,113);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_TYPE, "CONST_TYPE"), root_2);
				dbg.location(88,124);
				adaptor.addChild(root_2, (Object)adaptor.create(CONST_TYPE_INT, "CONST_TYPE_INT"));
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(88,140);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:140: ^( CONST_VALUE atom )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(88,142);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONST_VALUE, "CONST_VALUE"), root_2);
				dbg.location(88,155);
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
		dbg.location(89, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: identType : ( Boolean -> ^( BOOL_TYPE ) | Money -> ^( MONEY_TYPE ) );
	public final QLParser.identType_return identType() throws RecognitionException {
		QLParser.identType_return retval = new QLParser.identType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Boolean15=null;
		Token Money16=null;

		Object Boolean15_tree=null;
		Object Money16_tree=null;
		RewriteRuleTokenStream stream_Money=new RewriteRuleTokenStream(adaptor,"token Money");
		RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");

		try { dbg.enterRule(getGrammarFileName(), "identType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(92, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:2: ( Boolean -> ^( BOOL_TYPE ) | Money -> ^( MONEY_TYPE ) )
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:4: Boolean
					{
					dbg.location(93,4);
					Boolean15=(Token)match(input,Boolean,FOLLOW_Boolean_in_identType328);  
					stream_Boolean.add(Boolean15);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 93:12: -> ^( BOOL_TYPE )
					{
						dbg.location(93,15);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:15: ^( BOOL_TYPE )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(93,17);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL_TYPE, "BOOL_TYPE"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:4: Money
					{
					dbg.location(94,4);
					Money16=(Token)match(input,Money,FOLLOW_Money_in_identType340);  
					stream_Money.add(Money16);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 94:10: -> ^( MONEY_TYPE )
					{
						dbg.location(94,13);
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:94:13: ^( MONEY_TYPE )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(94,15);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MONEY_TYPE, "MONEY_TYPE"), root_1);
						adaptor.addChild(root_0, root_1);
						}

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
		dbg.location(96, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: ifStatement : If ifConditionalExpression ifStatementBlock ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION ifConditionalExpression ) ^( IF_TRUE ifStatementBlock ) ( ^( IF_FALSE elseBlock ) )? ) ;
	public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
		QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token If17=null;
		ParserRuleReturnScope ifConditionalExpression18 =null;
		ParserRuleReturnScope ifStatementBlock19 =null;
		ParserRuleReturnScope elseBlock20 =null;

		Object If17_tree=null;
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");
		RewriteRuleSubtreeStream stream_ifConditionalExpression=new RewriteRuleSubtreeStream(adaptor,"rule ifConditionalExpression");

		try { dbg.enterRule(getGrammarFileName(), "ifStatement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(106, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:2: ( If ifConditionalExpression ifStatementBlock ( elseBlock )? -> ^( IF_BLOCK ^( IF_EXPRESSION ifConditionalExpression ) ^( IF_TRUE ifStatementBlock ) ( ^( IF_FALSE elseBlock ) )? ) )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:3: If ifConditionalExpression ifStatementBlock ( elseBlock )?
			{
			dbg.location(107,3);
			If17=(Token)match(input,If,FOLLOW_If_in_ifStatement369);  
			stream_If.add(If17);
			dbg.location(107,6);
			pushFollow(FOLLOW_ifConditionalExpression_in_ifStatement371);
			ifConditionalExpression18=ifConditionalExpression();
			state._fsp--;

			stream_ifConditionalExpression.add(ifConditionalExpression18.getTree());dbg.location(107,31);
			pushFollow(FOLLOW_ifStatementBlock_in_ifStatement374);
			ifStatementBlock19=ifStatementBlock();
			state._fsp--;

			stream_ifStatementBlock.add(ifStatementBlock19.getTree());dbg.location(107,49);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:49: ( elseBlock )?
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:50: elseBlock
					{
					dbg.location(107,50);
					pushFollow(FOLLOW_elseBlock_in_ifStatement378);
					elseBlock20=elseBlock();
					state._fsp--;

					stream_elseBlock.add(elseBlock20.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: ifStatementBlock, elseBlock, ifConditionalExpression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 107:63: -> ^( IF_BLOCK ^( IF_EXPRESSION ifConditionalExpression ) ^( IF_TRUE ifStatementBlock ) ( ^( IF_FALSE elseBlock ) )? )
			{
				dbg.location(107,65);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:65: ^( IF_BLOCK ^( IF_EXPRESSION ifConditionalExpression ) ^( IF_TRUE ifStatementBlock ) ( ^( IF_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(107,67);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK, "IF_BLOCK"), root_1);
				dbg.location(107,77);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:77: ^( IF_EXPRESSION ifConditionalExpression )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(107,79);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_EXPRESSION, "IF_EXPRESSION"), root_2);
				dbg.location(107,93);
				adaptor.addChild(root_2, stream_ifConditionalExpression.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(107,120);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:120: ^( IF_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				dbg.location(107,122);
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_TRUE, "IF_TRUE"), root_2);
				dbg.location(107,130);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(107,148);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:148: ( ^( IF_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					dbg.location(107,148);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:148: ^( IF_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					dbg.location(107,150);
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_FALSE, "IF_FALSE"), root_2);
					dbg.location(107,159);
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
		dbg.location(108, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:1: ifConditionalExpression : RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifConditionalExpression_return ifConditionalExpression() throws RecognitionException {
		QLParser.ifConditionalExpression_return retval = new QLParser.ifConditionalExpression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token RoundLbr21=null;
		Token RoundRbr23=null;
		ParserRuleReturnScope orExpr22 =null;

		Object RoundLbr21_tree=null;
		Object RoundRbr23_tree=null;
		RewriteRuleTokenStream stream_RoundLbr=new RewriteRuleTokenStream(adaptor,"token RoundLbr");
		RewriteRuleTokenStream stream_RoundRbr=new RewriteRuleTokenStream(adaptor,"token RoundRbr");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try { dbg.enterRule(getGrammarFileName(), "ifConditionalExpression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(110, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:2: ( RoundLbr orExpr RoundRbr -> orExpr )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:5: RoundLbr orExpr RoundRbr
			{
			dbg.location(111,5);
			RoundLbr21=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifConditionalExpression422);  
			stream_RoundLbr.add(RoundLbr21);
			dbg.location(111,14);
			pushFollow(FOLLOW_orExpr_in_ifConditionalExpression424);
			orExpr22=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr22.getTree());dbg.location(111,22);
			RoundRbr23=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifConditionalExpression427);  
			stream_RoundRbr.add(RoundRbr23);

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
			// 111:31: -> orExpr
			{
				dbg.location(111,34);
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
		dbg.location(111, 39);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: ifStatementBlock : Lbr ( statement )* Rbr -> ( statement )* ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Lbr24=null;
		Token Rbr26=null;
		ParserRuleReturnScope statement25 =null;

		Object Lbr24_tree=null;
		Object Rbr26_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "ifStatementBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(113, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:2: ( Lbr ( statement )* Rbr -> ( statement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: Lbr ( statement )* Rbr
			{
			dbg.location(114,5);
			Lbr24=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock444);  
			stream_Lbr.add(Lbr24);
			dbg.location(114,10);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:10: ( statement )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:10: statement
					{
					dbg.location(114,10);
					pushFollow(FOLLOW_statement_in_ifStatementBlock447);
					statement25=statement();
					state._fsp--;

					stream_statement.add(statement25.getTree());
					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(114,21);
			Rbr26=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock450);  
			stream_Rbr.add(Rbr26);

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
			// 114:25: -> ( statement )*
			{
				dbg.location(114,28);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:28: ( statement )*
				while ( stream_statement.hasNext() ) {
					dbg.location(114,28);
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
		dbg.location(114, 37);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:1: elseBlock : Else Lbr ( statement )* Rbr -> ( statement )* ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Else27=null;
		Token Lbr28=null;
		Token Rbr30=null;
		ParserRuleReturnScope statement29 =null;

		Object Else27_tree=null;
		Object Lbr28_tree=null;
		Object Rbr30_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");

		try { dbg.enterRule(getGrammarFileName(), "elseBlock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(116, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:2: ( Else Lbr ( statement )* Rbr -> ( statement )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:4: Else Lbr ( statement )* Rbr
			{
			dbg.location(117,4);
			Else27=(Token)match(input,Else,FOLLOW_Else_in_elseBlock464);  
			stream_Else.add(Else27);
			dbg.location(117,9);
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock466);  
			stream_Lbr.add(Lbr28);
			dbg.location(117,13);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:13: ( statement )*
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:13: statement
					{
					dbg.location(117,13);
					pushFollow(FOLLOW_statement_in_elseBlock468);
					statement29=statement();
					state._fsp--;

					stream_statement.add(statement29.getTree());
					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(117,24);
			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock471);  
			stream_Rbr.add(Rbr30);

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
			// 117:28: -> ( statement )*
			{
				dbg.location(117,31);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:31: ( statement )*
				while ( stream_statement.hasNext() ) {
					dbg.location(117,31);
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
		dbg.location(118, 1);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:1: atom returns [Expr result] : ( Int | Ident | Boolean | Money | RoundLbr !x= orExpr ^ RoundRbr !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Int31=null;
		Token Ident32=null;
		Token Boolean33=null;
		Token Money34=null;
		Token RoundLbr35=null;
		Token RoundRbr36=null;
		ParserRuleReturnScope x =null;

		Object Int31_tree=null;
		Object Ident32_tree=null;
		Object Boolean33_tree=null;
		Object Money34_tree=null;
		Object RoundLbr35_tree=null;
		Object RoundRbr36_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(123, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:3: ( Int | Ident | Boolean | Money | RoundLbr !x= orExpr ^ RoundRbr !)
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:5: Int
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(124,5);
					Int31=(Token)match(input,Int,FOLLOW_Int_in_atom499); 
					Int31_tree = (Object)adaptor.create(Int31);
					adaptor.addChild(root_0, Int31_tree);
					dbg.location(124,11);
					 retval.result = new Int(Integer.parseInt((Int31!=null?Int31.getText():null))); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:125:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(125,5);
					Ident32=(Token)match(input,Ident,FOLLOW_Ident_in_atom509); 
					Ident32_tree = (Object)adaptor.create(Ident32);
					adaptor.addChild(root_0, Ident32_tree);
					dbg.location(125,11);
					 retval.result = new Ident((Ident32!=null?Ident32.getText():null), new Bool(false)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: Boolean
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(126,5);
					Boolean33=(Token)match(input,Boolean,FOLLOW_Boolean_in_atom518); 
					Boolean33_tree = (Object)adaptor.create(Boolean33);
					adaptor.addChild(root_0, Boolean33_tree);
					dbg.location(126,13);
					retval.result = new Bool(false);
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:5: Money
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(127,5);
					Money34=(Token)match(input,Money,FOLLOW_Money_in_atom526); 
					Money34_tree = (Object)adaptor.create(Money34);
					adaptor.addChild(root_0, Money34_tree);
					dbg.location(127,11);
					 retval.result = new Int(Integer.parseInt((Money34!=null?Money34.getText():null)));
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(129,14);
					RoundLbr35=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom537); dbg.location(129,18);
					pushFollow(FOLLOW_orExpr_in_atom543);
					x=orExpr();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);dbg.location(129,35);
					RoundRbr36=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom546); dbg.location(129,37);
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
		dbg.location(130, 2);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:1: unExpr returns [Expr result] : ( '+' x= atom | '-' x= atom | '!' x= atom |x= atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);

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
		dbg.location(132, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:5: ( '+' x= atom | '-' x= atom | '!' x= atom |x= atom )
			int alt9=4;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			switch ( input.LA(1) ) {
			case 53:
				{
				alt9=1;
				}
				break;
			case 54:
				{
				alt9=2;
				}
				break;
			case 49:
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

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:8: '+' x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(133,8);
					char_literal37=(Token)match(input,53,FOLLOW_53_in_unExpr572); 
					char_literal37_tree = (Object)adaptor.create(char_literal37);
					adaptor.addChild(root_0, char_literal37_tree);
					dbg.location(133,13);
					pushFollow(FOLLOW_atom_in_unExpr576);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(133,19);
					 retval.result = new Pos((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:8: '-' x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(134,8);
					char_literal38=(Token)match(input,54,FOLLOW_54_in_unExpr587); 
					char_literal38_tree = (Object)adaptor.create(char_literal38);
					adaptor.addChild(root_0, char_literal38_tree);
					dbg.location(134,13);
					pushFollow(FOLLOW_atom_in_unExpr591);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(134,19);
					 retval.result = new Neg((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:135:8: '!' x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(135,8);
					char_literal39=(Token)match(input,49,FOLLOW_49_in_unExpr602); 
					char_literal39_tree = (Object)adaptor.create(char_literal39);
					adaptor.addChild(root_0, char_literal39_tree);
					dbg.location(135,13);
					pushFollow(FOLLOW_atom_in_unExpr606);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(135,19);
					 retval.result = new Not((x!=null?((QLParser.atom_return)x).result:null)); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:136:8: x= atom
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(136,9);
					pushFollow(FOLLOW_atom_in_unExpr619);
					x=atom();
					state._fsp--;

					adaptor.addChild(root_0, x.getTree());
					dbg.location(136,18);
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
		dbg.location(137, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:139:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* ;
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
		dbg.location(139, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:5: (lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:9: lhs= unExpr (op= ( '*' ^| '/' ^) rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(140,12);
			pushFollow(FOLLOW_unExpr_in_mulExpr657);
			lhs=unExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(140,20);
			 retval.result =(lhs!=null?((QLParser.unExpr_return)lhs).result:null); dbg.location(140,45);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:45: (op= ( '*' ^| '/' ^) rhs= unExpr )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==52||LA11_0==55) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:47: op= ( '*' ^| '/' ^) rhs= unExpr
					{
					dbg.location(140,49);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:50: ( '*' ^| '/' ^)
					int alt10=2;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					int LA10_0 = input.LA(1);
					if ( (LA10_0==52) ) {
						alt10=1;
					}
					else if ( (LA10_0==55) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:52: '*' ^
							{
							dbg.location(140,55);
							op=(Token)match(input,52,FOLLOW_52_in_mulExpr667); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:140:59: '/' ^
							{
							dbg.location(140,62);
							op=(Token)match(input,55,FOLLOW_55_in_mulExpr672); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(140,69);
					pushFollow(FOLLOW_unExpr_in_mulExpr679);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(141,5);
					 
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
		dbg.location(149, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* ;
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
		dbg.location(152, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:5: (lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:9: lhs= mulExpr (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(153,12);
			pushFollow(FOLLOW_mulExpr_in_addExpr720);
			lhs=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(153,21);
			 retval.result =(lhs!=null?((QLParser.mulExpr_return)lhs).result:null); dbg.location(153,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:46: (op= ( '+' ^| '-' ^) rhs= mulExpr )*
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= 53 && LA13_0 <= 54)) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:48: op= ( '+' ^| '-' ^) rhs= mulExpr
					{
					dbg.location(153,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:51: ( '+' ^| '-' ^)
					int alt12=2;
					try { dbg.enterSubRule(12);
					try { dbg.enterDecision(12, decisionCanBacktrack[12]);

					int LA12_0 = input.LA(1);
					if ( (LA12_0==53) ) {
						alt12=1;
					}
					else if ( (LA12_0==54) ) {
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:52: '+' ^
							{
							dbg.location(153,55);
							op=(Token)match(input,53,FOLLOW_53_in_addExpr729); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:59: '-' ^
							{
							dbg.location(153,62);
							op=(Token)match(input,54,FOLLOW_54_in_addExpr734); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(12);}
					dbg.location(153,68);
					pushFollow(FOLLOW_mulExpr_in_addExpr740);
					rhs=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(154,5);
					 
					      if ((op!=null?op.getText():null).equals("+")) {
					        retval.result = new Add(retval.result, (rhs!=null?((QLParser.mulExpr_return)rhs).result:null));
					      }
					      if ((op!=null?op.getText():null).equals("-")) {
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
		dbg.location(162, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:164:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* ;
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
		dbg.location(164, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:5: (lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:9: lhs= addExpr (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(165,12);
			pushFollow(FOLLOW_addExpr_in_relExpr775);
			lhs=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(165,21);
			 retval.result =(lhs!=null?((QLParser.addExpr_return)lhs).result:null); dbg.location(165,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:46: (op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr )*
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==50||(LA15_0 >= 56 && LA15_0 <= 60)) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:48: op= ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^) rhs= addExpr
					{
					dbg.location(165,50);
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:51: ( '<' ^| '<=' ^| '>' ^| '>=' ^| '==' ^| '!=' ^)
					int alt14=6;
					try { dbg.enterSubRule(14);
					try { dbg.enterDecision(14, decisionCanBacktrack[14]);

					switch ( input.LA(1) ) {
					case 56:
						{
						alt14=1;
						}
						break;
					case 57:
						{
						alt14=2;
						}
						break;
					case 59:
						{
						alt14=3;
						}
						break;
					case 60:
						{
						alt14=4;
						}
						break;
					case 58:
						{
						alt14=5;
						}
						break;
					case 50:
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

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:52: '<' ^
							{
							dbg.location(165,55);
							op=(Token)match(input,56,FOLLOW_56_in_relExpr784); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:57: '<=' ^
							{
							dbg.location(165,61);
							op=(Token)match(input,57,FOLLOW_57_in_relExpr787); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:63: '>' ^
							{
							dbg.location(165,66);
							op=(Token)match(input,59,FOLLOW_59_in_relExpr790); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 4 :
							dbg.enterAlt(4);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:68: '>=' ^
							{
							dbg.location(165,72);
							op=(Token)match(input,60,FOLLOW_60_in_relExpr793); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 5 :
							dbg.enterAlt(5);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:74: '==' ^
							{
							dbg.location(165,78);
							op=(Token)match(input,58,FOLLOW_58_in_relExpr796); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;
						case 6 :
							dbg.enterAlt(6);

							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:80: '!=' ^
							{
							dbg.location(165,84);
							op=(Token)match(input,50,FOLLOW_50_in_relExpr799); 
							op_tree = (Object)adaptor.create(op);
							root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);

							}
							break;

					}
					} finally {dbg.exitSubRule(14);}
					dbg.location(165,90);
					pushFollow(FOLLOW_addExpr_in_relExpr805);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(166,5);
					 
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
		dbg.location(186, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal40=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "andExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(188, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:189:5: (lhs= relExpr ( '&&' ^rhs= relExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:189:9: lhs= relExpr ( '&&' ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(189,12);
			pushFollow(FOLLOW_relExpr_in_andExpr843);
			lhs=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(189,21);
			 retval.result =(lhs!=null?((QLParser.relExpr_return)lhs).result:null); dbg.location(189,46);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:189:46: ( '&&' ^rhs= relExpr )*
			try { dbg.enterSubRule(16);

			loop16:
			while (true) {
				int alt16=2;
				try { dbg.enterDecision(16, decisionCanBacktrack[16]);

				int LA16_0 = input.LA(1);
				if ( (LA16_0==51) ) {
					alt16=1;
				}

				} finally {dbg.exitDecision(16);}

				switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:189:48: '&&' ^rhs= relExpr
					{
					dbg.location(189,52);
					string_literal40=(Token)match(input,51,FOLLOW_51_in_andExpr849); 
					string_literal40_tree = (Object)adaptor.create(string_literal40);
					root_0 = (Object)adaptor.becomeRoot(string_literal40_tree, root_0);
					dbg.location(189,57);
					pushFollow(FOLLOW_relExpr_in_andExpr854);
					rhs=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(189,66);
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
		dbg.location(190, 4);

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:193:1: orExpr returns [Expr result] : lhs= andExpr ( '||' ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal41=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object string_literal41_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "orExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(193, 0);

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:5: (lhs= andExpr ( '||' ^rhs= andExpr )* )
			dbg.enterAlt(1);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:8: lhs= andExpr ( '||' ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(194,11);
			pushFollow(FOLLOW_andExpr_in_orExpr889);
			lhs=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());
			dbg.location(194,20);
			 retval.result = (lhs!=null?((QLParser.andExpr_return)lhs).result:null); dbg.location(194,47);
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:47: ( '||' ^rhs= andExpr )*
			try { dbg.enterSubRule(17);

			loop17:
			while (true) {
				int alt17=2;
				try { dbg.enterDecision(17, decisionCanBacktrack[17]);

				int LA17_0 = input.LA(1);
				if ( (LA17_0==61) ) {
					alt17=1;
				}

				} finally {dbg.exitDecision(17);}

				switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:49: '||' ^rhs= andExpr
					{
					dbg.location(194,53);
					string_literal41=(Token)match(input,61,FOLLOW_61_in_orExpr895); 
					string_literal41_tree = (Object)adaptor.create(string_literal41);
					root_0 = (Object)adaptor.becomeRoot(string_literal41_tree, root_0);
					dbg.location(194,58);
					pushFollow(FOLLOW_andExpr_in_orExpr900);
					rhs=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());
					dbg.location(194,67);
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
		dbg.location(195, 4);

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



	public static final BitSet FOLLOW_FormStart_in_parse150 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_FormId_in_parse154 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Lbr_in_parse156 = new BitSet(new long[]{0x0000000006000000L});
	public static final BitSet FOLLOW_statement_in_parse158 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_parse161 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_answerableStatement_in_statement183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignmentStatement_in_statement187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_answerableStatement210 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_answerableStatement213 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_QuestionLabel_in_answerableStatement218 = new BitSet(new long[]{0x0000000080000080L});
	public static final BitSet FOLLOW_identType_in_answerableStatement220 = new BitSet(new long[]{0x000000808A000082L});
	public static final BitSet FOLLOW_atom_in_answerableStatement223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_assignmentStatement279 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_assignmentStatement282 = new BitSet(new long[]{0x0000000080000080L});
	public static final BitSet FOLLOW_identType_in_assignmentStatement284 = new BitSet(new long[]{0x000000808A000080L});
	public static final BitSet FOLLOW_atom_in_assignmentStatement286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_identType328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_identType340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifStatement369 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_ifConditionalExpression_in_ifStatement371 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifStatement374 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_elseBlock_in_ifStatement378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_ifConditionalExpression422 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_orExpr_in_ifConditionalExpression424 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifConditionalExpression427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock444 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_statement_in_ifStatementBlock447 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock464 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock466 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_statement_in_elseBlock468 = new BitSet(new long[]{0x0000004006000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Boolean_in_atom518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Money_in_atom526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom537 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_orExpr_in_atom543 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_unExpr572 = new BitSet(new long[]{0x000000808A000080L});
	public static final BitSet FOLLOW_atom_in_unExpr576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_unExpr587 = new BitSet(new long[]{0x000000808A000080L});
	public static final BitSet FOLLOW_atom_in_unExpr591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unExpr602 = new BitSet(new long[]{0x000000808A000080L});
	public static final BitSet FOLLOW_atom_in_unExpr606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr657 = new BitSet(new long[]{0x0090000000000002L});
	public static final BitSet FOLLOW_52_in_mulExpr667 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_55_in_mulExpr672 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr679 = new BitSet(new long[]{0x0090000000000002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr720 = new BitSet(new long[]{0x0060000000000002L});
	public static final BitSet FOLLOW_53_in_addExpr729 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_54_in_addExpr734 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr740 = new BitSet(new long[]{0x0060000000000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr775 = new BitSet(new long[]{0x1F04000000000002L});
	public static final BitSet FOLLOW_56_in_relExpr784 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_57_in_relExpr787 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_59_in_relExpr790 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_60_in_relExpr793 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_58_in_relExpr796 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_50_in_relExpr799 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_addExpr_in_relExpr805 = new BitSet(new long[]{0x1F04000000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr843 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_51_in_andExpr849 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_relExpr_in_andExpr854 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_andExpr_in_orExpr889 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_61_in_orExpr895 = new BitSet(new long[]{0x006200808A000080L});
	public static final BitSet FOLLOW_andExpr_in_orExpr900 = new BitSet(new long[]{0x2000000000000002L});
}
