// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-19 00:11:25

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
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_EXPRESSION", 
		"ASSIGNMENT_TYPE", "Add", "And", "Assignment_Indicator", "BLOCK", "Bool", 
		"BooleanType", "COMMENT", "Div", "Doub", "DoubleType", "Else", "Equ", 
		"FormStart", "GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", 
		"IF_CONDITION", "IF_STATEMENT", "Ident", "If", "Int", "IntegerType", "LT", 
		"LTEqu", "Lbr", "MoneyType", "Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", 
		"Rbr", "RoundLbr", "RoundRbr", "Str", "StringType", "Sub", "UNARY_MINUS", 
		"UNARY_NEGATE", "WS"
	};
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_EXPRESSION=5;
	public static final int ASSIGNMENT_TYPE=6;
	public static final int Add=7;
	public static final int And=8;
	public static final int Assignment_Indicator=9;
	public static final int BLOCK=10;
	public static final int Bool=11;
	public static final int BooleanType=12;
	public static final int COMMENT=13;
	public static final int Div=14;
	public static final int Doub=15;
	public static final int DoubleType=16;
	public static final int Else=17;
	public static final int Equ=18;
	public static final int FormStart=19;
	public static final int GT=20;
	public static final int GTEqu=21;
	public static final int IDENT=22;
	public static final int IF_BLOCK_FALSE=23;
	public static final int IF_BLOCK_TRUE=24;
	public static final int IF_CONDITION=25;
	public static final int IF_STATEMENT=26;
	public static final int Ident=27;
	public static final int If=28;
	public static final int Int=29;
	public static final int IntegerType=30;
	public static final int LT=31;
	public static final int LTEqu=32;
	public static final int Lbr=33;
	public static final int MoneyType=34;
	public static final int Mul=35;
	public static final int Not=36;
	public static final int NotEqu=37;
	public static final int Or=38;
	public static final int QUESTION_LABEL=39;
	public static final int Rbr=40;
	public static final int RoundLbr=41;
	public static final int RoundRbr=42;
	public static final int Str=43;
	public static final int StringType=44;
	public static final int Sub=45;
	public static final int UNARY_MINUS=46;
	public static final int UNARY_NEGATE=47;
	public static final int WS=48;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public QLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[46+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: parse : FormStart Ident Lbr ( blockItem )* Rbr EOF -> ^( Ident ^( BLOCK ( blockItem )* ) ) ;
	public final QLParser.parse_return parse() throws RecognitionException {
		QLParser.parse_return retval = new QLParser.parse_return();
		retval.start = input.LT(1);
		int parse_StartIndex = input.index();

		Object root_0 = null;

		Token FormStart1=null;
		Token Ident2=null;
		Token Lbr3=null;
		Token Rbr5=null;
		Token EOF6=null;
		ParserRuleReturnScope blockItem4 =null;

		Object FormStart1_tree=null;
		Object Ident2_tree=null;
		Object Lbr3_tree=null;
		Object Rbr5_tree=null;
		Object EOF6_tree=null;
		RewriteRuleTokenStream stream_FormStart=new RewriteRuleTokenStream(adaptor,"token FormStart");
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:2: ( FormStart Ident Lbr ( blockItem )* Rbr EOF -> ^( Ident ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:4: FormStart Ident Lbr ( blockItem )* Rbr EOF
			{
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse107); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FormStart.add(FormStart1);

			Ident2=(Token)match(input,Ident,FOLLOW_Ident_in_parse109); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident2);

			Lbr3=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse111); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr3);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:24: ( blockItem )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= Ident && LA1_0 <= If)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:24: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_parse113);
					blockItem4=blockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_blockItem.add(blockItem4.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			Rbr5=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse116); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr5);

			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_parse118); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EOF.add(EOF6);

			if ( state.backtracking==0 ) {System.out.println("finished with grammar");}
			// AST REWRITE
			// elements: Ident, blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 53:89: -> ^( Ident ^( BLOCK ( blockItem )* ) )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:92: ^( Ident ^( BLOCK ( blockItem )* ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_Ident.nextNode(), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:100: ^( BLOCK ( blockItem )* )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_2);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:53:108: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					adaptor.addChild(root_2, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
			if ( state.backtracking>0 ) { memoize(input, 1, parse_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: blockItem : ( questionAssignment | constantAssignment | ifBlock ) ^;
	public final QLParser.blockItem_return blockItem() throws RecognitionException {
		QLParser.blockItem_return retval = new QLParser.blockItem_return();
		retval.start = input.LT(1);
		int blockItem_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope questionAssignment7 =null;
		ParserRuleReturnScope constantAssignment8 =null;
		ParserRuleReturnScope ifBlock9 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:2: ( ( questionAssignment | constantAssignment | ifBlock ) ^)
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: ( questionAssignment | constantAssignment | ifBlock ) ^
			{
			root_0 = (Object)adaptor.nil();


			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:4: ( questionAssignment | constantAssignment | ifBlock )
			int alt2=3;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Ident) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==Assignment_Indicator) ) {
					int LA2_3 = input.LA(3);
					if ( (LA2_3==Str) ) {
						alt2=1;
					}
					else if ( (LA2_3==BooleanType||LA2_3==DoubleType||LA2_3==IntegerType||LA2_3==MoneyType||LA2_3==StringType) ) {
						alt2=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 3, input);
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
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: questionAssignment
					{
					pushFollow(FOLLOW_questionAssignment_in_blockItem145);
					questionAssignment7=questionAssignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, questionAssignment7.getTree());

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:26: constantAssignment
					{
					pushFollow(FOLLOW_constantAssignment_in_blockItem149);
					constantAssignment8=constantAssignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constantAssignment8.getTree());

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:56:47: ifBlock
					{
					pushFollow(FOLLOW_ifBlock_in_blockItem153);
					ifBlock9=ifBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifBlock9.getTree());

					}
					break;

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
			if ( state.backtracking>0 ) { memoize(input, 2, blockItem_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: questionAssignment : Ident Assignment_Indicator Str identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
	public final QLParser.questionAssignment_return questionAssignment() throws RecognitionException {
		QLParser.questionAssignment_return retval = new QLParser.questionAssignment_return();
		retval.start = input.LT(1);
		int questionAssignment_StartIndex = input.index();

		Object root_0 = null;

		Token Ident10=null;
		Token Assignment_Indicator11=null;
		Token Str12=null;
		ParserRuleReturnScope identType13 =null;
		ParserRuleReturnScope atom14 =null;

		Object Ident10_tree=null;
		Object Assignment_Indicator11_tree=null;
		Object Str12_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Str=new RewriteRuleTokenStream(adaptor,"token Str");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identType=new RewriteRuleSubtreeStream(adaptor,"rule identType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:2: ( Ident Assignment_Indicator Str identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:4: Ident Assignment_Indicator Str identType ( atom )?
			{
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_questionAssignment170); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident10);

			Assignment_Indicator11=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_questionAssignment173); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assignment_Indicator.add(Assignment_Indicator11);

			Str12=(Token)match(input,Str,FOLLOW_Str_in_questionAssignment176); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Str.add(Str12);

			pushFollow(FOLLOW_identType_in_questionAssignment178);
			identType13=identType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identType.add(identType13.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:47: ( atom )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==Bool||LA3_0==Doub||LA3_0==Int||LA3_0==RoundLbr||LA3_0==Str) ) {
				alt3=1;
			}
			else if ( (LA3_0==Ident) ) {
				int LA3_2 = input.LA(2);
				if ( (LA3_2==EOF||(LA3_2 >= Ident && LA3_2 <= If)||LA3_2==Rbr) ) {
					alt3=1;
				}
			}
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:48: atom
					{
					pushFollow(FOLLOW_atom_in_questionAssignment181);
					atom14=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom14.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: atom, Str, Ident, identType
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 60:57: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:59: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:72: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:87: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:116: ^( QUESTION_LABEL Str )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				adaptor.addChild(root_2, stream_Str.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:140: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:140: ^( ASSIGNMENT_EXPRESSION atom )
					{
					Object root_2 = (Object)adaptor.nil();
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
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
			if ( state.backtracking>0 ) { memoize(input, 3, questionAssignment_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: constantAssignment : Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
	public final QLParser.constantAssignment_return constantAssignment() throws RecognitionException {
		QLParser.constantAssignment_return retval = new QLParser.constantAssignment_return();
		retval.start = input.LT(1);
		int constantAssignment_StartIndex = input.index();

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

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:2: ( Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:4: Ident Assignment_Indicator identType atom
			{
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_constantAssignment233); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident15);

			Assignment_Indicator16=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_constantAssignment236); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assignment_Indicator.add(Assignment_Indicator16);

			pushFollow(FOLLOW_identType_in_constantAssignment238);
			identType17=identType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identType.add(identType17.getTree());
			pushFollow(FOLLOW_atom_in_constantAssignment240);
			atom18=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(atom18.getTree());
			// AST REWRITE
			// elements: identType, Ident, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 66:48: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:51: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:64: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:80: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:66:109: ^( ASSIGNMENT_EXPRESSION atom )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_EXPRESSION, "ASSIGNMENT_EXPRESSION"), root_2);
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
			if ( state.backtracking>0 ) { memoize(input, 4, constantAssignment_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:1: identType returns [Type t] : ( BooleanType -> BooleanType | MoneyType -> MoneyType | IntegerType -> IntegerType | StringType -> StringType | DoubleType -> DoubleType );
	public final QLParser.identType_return identType() throws RecognitionException {
		QLParser.identType_return retval = new QLParser.identType_return();
		retval.start = input.LT(1);
		int identType_StartIndex = input.index();

		Object root_0 = null;

		Token BooleanType19=null;
		Token MoneyType20=null;
		Token IntegerType21=null;
		Token StringType22=null;
		Token DoubleType23=null;

		Object BooleanType19_tree=null;
		Object MoneyType20_tree=null;
		Object IntegerType21_tree=null;
		Object StringType22_tree=null;
		Object DoubleType23_tree=null;
		RewriteRuleTokenStream stream_IntegerType=new RewriteRuleTokenStream(adaptor,"token IntegerType");
		RewriteRuleTokenStream stream_DoubleType=new RewriteRuleTokenStream(adaptor,"token DoubleType");
		RewriteRuleTokenStream stream_StringType=new RewriteRuleTokenStream(adaptor,"token StringType");
		RewriteRuleTokenStream stream_MoneyType=new RewriteRuleTokenStream(adaptor,"token MoneyType");
		RewriteRuleTokenStream stream_BooleanType=new RewriteRuleTokenStream(adaptor,"token BooleanType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:2: ( BooleanType -> BooleanType | MoneyType -> MoneyType | IntegerType -> IntegerType | StringType -> StringType | DoubleType -> DoubleType )
			int alt4=5;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				alt4=1;
				}
				break;
			case MoneyType:
				{
				alt4=2;
				}
				break;
			case IntegerType:
				{
				alt4=3;
				}
				break;
			case StringType:
				{
				alt4=4;
				}
				break;
			case DoubleType:
				{
				alt4=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:4: BooleanType
					{
					BooleanType19=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_identType286); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BooleanType.add(BooleanType19);

					if ( state.backtracking==0 ) {retval.t = new BoolType();}
					// AST REWRITE
					// elements: BooleanType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 71:40: -> BooleanType
					{
						adaptor.addChild(root_0, stream_BooleanType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:4: MoneyType
					{
					MoneyType20=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_identType300); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MoneyType.add(MoneyType20);

					if ( state.backtracking==0 ) {retval.t = new MoneyType();}
					// AST REWRITE
					// elements: MoneyType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 72:39: -> MoneyType
					{
						adaptor.addChild(root_0, stream_MoneyType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:4: IntegerType
					{
					IntegerType21=(Token)match(input,IntegerType,FOLLOW_IntegerType_in_identType314); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IntegerType.add(IntegerType21);

					if ( state.backtracking==0 ) {retval.t = new IntType();}
					// AST REWRITE
					// elements: IntegerType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 73:39: -> IntegerType
					{
						adaptor.addChild(root_0, stream_IntegerType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:4: StringType
					{
					StringType22=(Token)match(input,StringType,FOLLOW_StringType_in_identType327); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_StringType.add(StringType22);

					if ( state.backtracking==0 ) {retval.t = new StringType();}
					// AST REWRITE
					// elements: StringType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 74:41: -> StringType
					{
						adaptor.addChild(root_0, stream_StringType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: DoubleType
					{
					DoubleType23=(Token)match(input,DoubleType,FOLLOW_DoubleType_in_identType339); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DoubleType.add(DoubleType23);

					if ( state.backtracking==0 ) {retval.t = new DoubleType();}
					// AST REWRITE
					// elements: DoubleType
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 75:41: -> DoubleType
					{
						adaptor.addChild(root_0, stream_DoubleType.nextNode());
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
			if ( state.backtracking>0 ) { memoize(input, 5, identType_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:1: ifBlock : ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
	public final QLParser.ifBlock_return ifBlock() throws RecognitionException {
		QLParser.ifBlock_return retval = new QLParser.ifBlock_return();
		retval.start = input.LT(1);
		int ifBlock_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope ifCondition24 =null;
		ParserRuleReturnScope ifStatementBlock25 =null;
		ParserRuleReturnScope elseBlock26 =null;

		RewriteRuleSubtreeStream stream_ifCondition=new RewriteRuleSubtreeStream(adaptor,"rule ifCondition");
		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:2: ( ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:4: ifCondition ifStatementBlock ( elseBlock )?
			{
			pushFollow(FOLLOW_ifCondition_in_ifBlock360);
			ifCondition24=ifCondition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifCondition.add(ifCondition24.getTree());
			pushFollow(FOLLOW_ifStatementBlock_in_ifBlock363);
			ifStatementBlock25=ifStatementBlock();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifStatementBlock.add(ifStatementBlock25.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:35: ( elseBlock )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==Else) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:36: elseBlock
					{
					pushFollow(FOLLOW_elseBlock_in_ifBlock367);
					elseBlock26=elseBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock26.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: ifStatementBlock, ifCondition, elseBlock
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 80:49: -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:51: ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:67: ^( IF_CONDITION ifCondition )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				adaptor.addChild(root_2, stream_ifCondition.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:97: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:131: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:80:131: ^( IF_BLOCK_FALSE elseBlock )
					{
					Object root_2 = (Object)adaptor.nil();
					root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_FALSE, "IF_BLOCK_FALSE"), root_2);
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
			if ( state.backtracking>0 ) { memoize(input, 6, ifBlock_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "ifBlock"


	public static class ifCondition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifCondition"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: ifCondition : If RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifCondition_return ifCondition() throws RecognitionException {
		QLParser.ifCondition_return retval = new QLParser.ifCondition_return();
		retval.start = input.LT(1);
		int ifCondition_StartIndex = input.index();

		Object root_0 = null;

		Token If27=null;
		Token RoundLbr28=null;
		Token RoundRbr30=null;
		ParserRuleReturnScope orExpr29 =null;

		Object If27_tree=null;
		Object RoundLbr28_tree=null;
		Object RoundRbr30_tree=null;
		RewriteRuleTokenStream stream_RoundLbr=new RewriteRuleTokenStream(adaptor,"token RoundLbr");
		RewriteRuleTokenStream stream_RoundRbr=new RewriteRuleTokenStream(adaptor,"token RoundRbr");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:2: ( If RoundLbr orExpr RoundRbr -> orExpr )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: If RoundLbr orExpr RoundRbr
			{
			If27=(Token)match(input,If,FOLLOW_If_in_ifCondition411); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If27);

			RoundLbr28=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifCondition413); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RoundLbr.add(RoundLbr28);

			pushFollow(FOLLOW_orExpr_in_ifCondition415);
			orExpr29=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr29.getTree());
			RoundRbr30=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifCondition418); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RoundRbr.add(RoundRbr30);

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
			// 84:34: -> orExpr
			{
				adaptor.addChild(root_0, stream_orExpr.nextTree());
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
			if ( state.backtracking>0 ) { memoize(input, 7, ifCondition_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "ifCondition"


	public static class ifStatementBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:87:1: ifStatementBlock : Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);
		int ifStatementBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Lbr31=null;
		Token Rbr33=null;
		ParserRuleReturnScope blockItem32 =null;

		Object Lbr31_tree=null;
		Object Rbr33_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:2: ( Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:5: Lbr ( blockItem )* Rbr
			{
			Lbr31=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock437); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr31);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:10: ( blockItem )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= Ident && LA6_0 <= If)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:10: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock440);
					blockItem32=blockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_blockItem.add(blockItem32.getTree());
					}
					break;

				default :
					break loop6;
				}
			}

			Rbr33=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock443); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr33);

			// AST REWRITE
			// elements: blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 88:25: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:28: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:88:36: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					adaptor.addChild(root_1, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
			if ( state.backtracking>0 ) { memoize(input, 8, ifStatementBlock_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: elseBlock : Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);
		int elseBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Else34=null;
		Token Lbr35=null;
		Token Rbr37=null;
		ParserRuleReturnScope blockItem36 =null;

		Object Else34_tree=null;
		Object Lbr35_tree=null;
		Object Rbr37_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:2: ( Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:4: Else Lbr ( blockItem )* Rbr
			{
			Else34=(Token)match(input,Else,FOLLOW_Else_in_elseBlock461); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else34);

			Lbr35=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock463); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr35);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:13: ( blockItem )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= Ident && LA7_0 <= If)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:13: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_elseBlock465);
					blockItem36=blockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_blockItem.add(blockItem36.getTree());
					}
					break;

				default :
					break loop7;
				}
			}

			Rbr37=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock468); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr37);

			// AST REWRITE
			// elements: blockItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 91:28: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:31: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:39: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
					adaptor.addChild(root_1, stream_blockItem.nextTree());
				}
				stream_blockItem.reset();

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
			if ( state.backtracking>0 ) { memoize(input, 9, elseBlock_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:97:1: atom : ( Int | Ident | Doub | Str | Bool | RoundLbr !x= orExpr ^ RoundRbr !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		Object root_0 = null;

		Token Int38=null;
		Token Ident39=null;
		Token Doub40=null;
		Token Str41=null;
		Token Bool42=null;
		Token RoundLbr43=null;
		Token RoundRbr44=null;
		ParserRuleReturnScope x =null;

		Object Int38_tree=null;
		Object Ident39_tree=null;
		Object Doub40_tree=null;
		Object Str41_tree=null;
		Object Bool42_tree=null;
		Object RoundLbr43_tree=null;
		Object RoundRbr44_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:3: ( Int | Ident | Doub | Str | Bool | RoundLbr !x= orExpr ^ RoundRbr !)
			int alt8=6;
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
			case Doub:
				{
				alt8=3;
				}
				break;
			case Str:
				{
				alt8=4;
				}
				break;
			case Bool:
				{
				alt8=5;
				}
				break;
			case RoundLbr:
				{
				alt8=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: Int
					{
					root_0 = (Object)adaptor.nil();


					Int38=(Token)match(input,Int,FOLLOW_Int_in_atom497); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int38_tree = (Object)adaptor.create(Int38);
					adaptor.addChild(root_0, Int38_tree);
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					Ident39=(Token)match(input,Ident,FOLLOW_Ident_in_atom505); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident39_tree = (Object)adaptor.create(Ident39);
					adaptor.addChild(root_0, Ident39_tree);
					}

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: Doub
					{
					root_0 = (Object)adaptor.nil();


					Doub40=(Token)match(input,Doub,FOLLOW_Doub_in_atom512); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Doub40_tree = (Object)adaptor.create(Doub40);
					adaptor.addChild(root_0, Doub40_tree);
					}

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: Str
					{
					root_0 = (Object)adaptor.nil();


					Str41=(Token)match(input,Str,FOLLOW_Str_in_atom518); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Str41_tree = (Object)adaptor.create(Str41);
					adaptor.addChild(root_0, Str41_tree);
					}

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: Bool
					{
					root_0 = (Object)adaptor.nil();


					Bool42=(Token)match(input,Bool,FOLLOW_Bool_in_atom524); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Bool42_tree = (Object)adaptor.create(Bool42);
					adaptor.addChild(root_0, Bool42_tree);
					}

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					RoundLbr43=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom531); if (state.failed) return retval;
					pushFollow(FOLLOW_orExpr_in_atom537);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);
					RoundRbr44=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom540); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 10, atom_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: unExpr : ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token Sub45=null;
		Token Not47=null;
		ParserRuleReturnScope atom46 =null;
		ParserRuleReturnScope atom48 =null;
		ParserRuleReturnScope atom49 =null;

		Object Sub45_tree=null;
		Object Not47_tree=null;
		RewriteRuleTokenStream stream_Sub=new RewriteRuleTokenStream(adaptor,"token Sub");
		RewriteRuleTokenStream stream_Not=new RewriteRuleTokenStream(adaptor,"token Not");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom )
			int alt9=3;
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
			case Bool:
			case Doub:
			case Ident:
			case Int:
			case RoundLbr:
			case Str:
				{
				alt9=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:8: Sub atom
					{
					Sub45=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr561); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Sub.add(Sub45);

					pushFollow(FOLLOW_atom_in_unExpr563);
					atom46=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom46.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 107:17: -> ^( UNARY_MINUS atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:20: ^( UNARY_MINUS atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:8: Not atom
					{
					Not47=(Token)match(input,Not,FOLLOW_Not_in_unExpr581); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Not.add(Not47);

					pushFollow(FOLLOW_atom_in_unExpr583);
					atom48=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom48.getTree());
					// AST REWRITE
					// elements: atom
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 108:17: -> ^( UNARY_NEGATE atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:20: ^( UNARY_NEGATE atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_NEGATE, "UNARY_NEGATE"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:8: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unExpr600);
					atom49=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom49.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 11, unExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:112:1: mulExpr : lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);
		int mulExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:5: (lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:9: lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unExpr_in_mulExpr634);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:21: (op= ( Mul | Div ) ^rhs= unExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Div||LA10_0==Mul) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:23: op= ( Mul | Div ) ^rhs= unExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Div||input.LA(1)==Mul ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr654);
					rhs=unExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop10;
				}
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
			if ( state.backtracking>0 ) { memoize(input, 12, mulExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:1: addExpr : lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);
		int addExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:5: (lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:9: lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mulExpr_in_addExpr686);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:21: (op= ( Add | Sub ) ^rhs= mulExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==Add||LA11_0==Sub) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:118:23: op= ( Add | Sub ) ^rhs= mulExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Sub ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr704);
					rhs=mulExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop11;
				}
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
			if ( state.backtracking>0 ) { memoize(input, 13, addExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:121:1: relExpr : lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);
		int relExpr_StartIndex = input.index();

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:5: (lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_relExpr731);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:22: (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Equ||(LA12_0 >= GT && LA12_0 <= GTEqu)||(LA12_0 >= LT && LA12_0 <= LTEqu)||LA12_0==NotEqu) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:24: op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Equ||(input.LA(1) >= GT && input.LA(1) <= GTEqu)||(input.LA(1) >= LT && input.LA(1) <= LTEqu)||input.LA(1)==NotEqu ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr760);
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
			if ( state.backtracking>0 ) { memoize(input, 14, relExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:125:1: andExpr : lhs= relExpr ( And ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token And50=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And50_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:5: (lhs= relExpr ( And ^rhs= relExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:9: lhs= relExpr ( And ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relExpr_in_andExpr789);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:21: ( And ^rhs= relExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==And) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:126:23: And ^rhs= relExpr
					{
					And50=(Token)match(input,And,FOLLOW_And_in_andExpr793); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					And50_tree = (Object)adaptor.create(And50);
					root_0 = (Object)adaptor.becomeRoot(And50_tree, root_0);
					}

					pushFollow(FOLLOW_relExpr_in_andExpr798);
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
			if ( state.backtracking>0 ) { memoize(input, 15, andExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:130:1: orExpr : lhs= andExpr ( Or ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token Or51=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or51_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:5: (lhs= andExpr ( Or ^rhs= andExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:8: lhs= andExpr ( Or ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andExpr_in_orExpr829);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:20: ( Or ^rhs= andExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==Or) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:131:22: Or ^rhs= andExpr
					{
					Or51=(Token)match(input,Or,FOLLOW_Or_in_orExpr833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Or51_tree = (Object)adaptor.create(Or51);
					root_0 = (Object)adaptor.becomeRoot(Or51_tree, root_0);
					}

					pushFollow(FOLLOW_andExpr_in_orExpr838);
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
			if ( state.backtracking>0 ) { memoize(input, 16, orExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_FormStart_in_parse107 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Ident_in_parse109 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_Lbr_in_parse111 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_blockItem_in_parse113 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_Rbr_in_parse116 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionAssignment_in_blockItem145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_blockItem149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment170 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_questionAssignment173 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Str_in_questionAssignment176 = new BitSet(new long[]{0x0000100440011000L});
	public static final BitSet FOLLOW_identType_in_questionAssignment178 = new BitSet(new long[]{0x00000A0028008802L});
	public static final BitSet FOLLOW_atom_in_questionAssignment181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment233 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_constantAssignment236 = new BitSet(new long[]{0x0000100440011000L});
	public static final BitSet FOLLOW_identType_in_constantAssignment238 = new BitSet(new long[]{0x00000A0028008800L});
	public static final BitSet FOLLOW_atom_in_constantAssignment240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerType_in_identType314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringType_in_identType327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DoubleType_in_identType339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifCondition_in_ifBlock360 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifBlock363 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_elseBlock_in_ifBlock367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifCondition411 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RoundLbr_in_ifCondition413 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_orExpr_in_ifCondition415 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifCondition418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock437 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock440 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock461 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock463 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock465 = new BitSet(new long[]{0x0000010018000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Doub_in_atom512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_atom518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_atom524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom531 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_orExpr_in_atom537 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr561 = new BitSet(new long[]{0x00000A0028008800L});
	public static final BitSet FOLLOW_atom_in_unExpr563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unExpr581 = new BitSet(new long[]{0x00000A0028008800L});
	public static final BitSet FOLLOW_atom_in_unExpr583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr634 = new BitSet(new long[]{0x0000000800004002L});
	public static final BitSet FOLLOW_set_in_mulExpr641 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr654 = new BitSet(new long[]{0x0000000800004002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr686 = new BitSet(new long[]{0x0000200000000082L});
	public static final BitSet FOLLOW_set_in_addExpr692 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr704 = new BitSet(new long[]{0x0000200000000082L});
	public static final BitSet FOLLOW_addExpr_in_relExpr731 = new BitSet(new long[]{0x0000002180340002L});
	public static final BitSet FOLLOW_set_in_relExpr738 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_addExpr_in_relExpr760 = new BitSet(new long[]{0x0000002180340002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr789 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_And_in_andExpr793 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_relExpr_in_andExpr798 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_andExpr_in_orExpr829 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_Or_in_orExpr833 = new BitSet(new long[]{0x00002A1028008800L});
	public static final BitSet FOLLOW_andExpr_in_orExpr838 = new BitSet(new long[]{0x0000004000000002L});
}
