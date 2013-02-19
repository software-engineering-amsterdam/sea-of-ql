// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-19 03:11:29

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
		"IF_CONDITION", "IF_STATEMENT", "Ident", "If", "Int", "IntegerType", "LSquBr", 
		"LT", "LTEqu", "Lbr", "MoneyType", "Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", 
		"RSquBr", "Rbr", "RoundLbr", "RoundRbr", "Str", "StringType", "Sub", "UNARY_MINUS", 
		"UNARY_NEGATE", "WS", "','"
	};
	public static final int EOF=-1;
	public static final int T__51=51;
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
	public static final int LSquBr=31;
	public static final int LT=32;
	public static final int LTEqu=33;
	public static final int Lbr=34;
	public static final int MoneyType=35;
	public static final int Mul=36;
	public static final int Not=37;
	public static final int NotEqu=38;
	public static final int Or=39;
	public static final int QUESTION_LABEL=40;
	public static final int RSquBr=41;
	public static final int Rbr=42;
	public static final int RoundLbr=43;
	public static final int RoundRbr=44;
	public static final int Str=45;
	public static final int StringType=46;
	public static final int Sub=47;
	public static final int UNARY_MINUS=48;
	public static final int UNARY_NEGATE=49;
	public static final int WS=50;

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
		this.state.ruleMemo = new HashMap[49+1];


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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:59:1: questionAssignment : Ident Assignment_Indicator Str identArrayType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
	public final QLParser.questionAssignment_return questionAssignment() throws RecognitionException {
		QLParser.questionAssignment_return retval = new QLParser.questionAssignment_return();
		retval.start = input.LT(1);
		int questionAssignment_StartIndex = input.index();

		Object root_0 = null;

		Token Ident10=null;
		Token Assignment_Indicator11=null;
		Token Str12=null;
		ParserRuleReturnScope identArrayType13 =null;
		ParserRuleReturnScope atom14 =null;

		Object Ident10_tree=null;
		Object Assignment_Indicator11_tree=null;
		Object Str12_tree=null;
		RewriteRuleTokenStream stream_Ident=new RewriteRuleTokenStream(adaptor,"token Ident");
		RewriteRuleTokenStream stream_Str=new RewriteRuleTokenStream(adaptor,"token Str");
		RewriteRuleTokenStream stream_Assignment_Indicator=new RewriteRuleTokenStream(adaptor,"token Assignment_Indicator");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
		RewriteRuleSubtreeStream stream_identArrayType=new RewriteRuleSubtreeStream(adaptor,"rule identArrayType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:2: ( Ident Assignment_Indicator Str identArrayType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:4: Ident Assignment_Indicator Str identArrayType ( atom )?
			{
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_questionAssignment170); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident10);

			Assignment_Indicator11=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_questionAssignment173); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assignment_Indicator.add(Assignment_Indicator11);

			Str12=(Token)match(input,Str,FOLLOW_Str_in_questionAssignment176); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Str.add(Str12);

			pushFollow(FOLLOW_identArrayType_in_questionAssignment178);
			identArrayType13=identArrayType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identArrayType.add(identArrayType13.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:52: ( atom )?
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:53: atom
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
			// elements: Ident, Str, identArrayType, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 60:62: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:64: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identArrayType ) ^( QUESTION_LABEL Str ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:77: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:92: ^( ASSIGNMENT_TYPE identArrayType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identArrayType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:126: ^( QUESTION_LABEL Str )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				adaptor.addChild(root_2, stream_Str.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:150: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:60:150: ^( ASSIGNMENT_EXPRESSION atom )
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: constantAssignment : Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
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

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:2: ( Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:4: Ident Assignment_Indicator identType atom
			{
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_constantAssignment232); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Ident.add(Ident15);

			Assignment_Indicator16=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_constantAssignment235); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Assignment_Indicator.add(Assignment_Indicator16);

			pushFollow(FOLLOW_identType_in_constantAssignment237);
			identType17=identType();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identType.add(identType17.getTree());
			pushFollow(FOLLOW_atom_in_constantAssignment239);
			atom18=atom();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_atom.add(atom18.getTree());
			// AST REWRITE
			// elements: atom, Ident, identType
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 65:48: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:51: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:64: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:80: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:65:109: ^( ASSIGNMENT_EXPRESSION atom )
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


	public static class identArrayType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identArrayType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:68:1: identArrayType : ( identType LSquBr Str ( ',' Str )* RSquBr | identType );
	public final QLParser.identArrayType_return identArrayType() throws RecognitionException {
		QLParser.identArrayType_return retval = new QLParser.identArrayType_return();
		retval.start = input.LT(1);
		int identArrayType_StartIndex = input.index();

		Object root_0 = null;

		Token LSquBr20=null;
		Token Str21=null;
		Token char_literal22=null;
		Token Str23=null;
		Token RSquBr24=null;
		ParserRuleReturnScope identType19 =null;
		ParserRuleReturnScope identType25 =null;

		Object LSquBr20_tree=null;
		Object Str21_tree=null;
		Object char_literal22_tree=null;
		Object Str23_tree=null;
		Object RSquBr24_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:2: ( identType LSquBr Str ( ',' Str )* RSquBr | identType )
			int alt5=2;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1==LSquBr) ) {
					alt5=1;
				}
				else if ( (LA5_1==EOF||LA5_1==Bool||LA5_1==Doub||(LA5_1 >= Ident && LA5_1 <= Int)||(LA5_1 >= Rbr && LA5_1 <= RoundLbr)||LA5_1==Str) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case MoneyType:
				{
				int LA5_2 = input.LA(2);
				if ( (LA5_2==LSquBr) ) {
					alt5=1;
				}
				else if ( (LA5_2==EOF||LA5_2==Bool||LA5_2==Doub||(LA5_2 >= Ident && LA5_2 <= Int)||(LA5_2 >= Rbr && LA5_2 <= RoundLbr)||LA5_2==Str) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IntegerType:
				{
				int LA5_3 = input.LA(2);
				if ( (LA5_3==LSquBr) ) {
					alt5=1;
				}
				else if ( (LA5_3==EOF||LA5_3==Bool||LA5_3==Doub||(LA5_3 >= Ident && LA5_3 <= Int)||(LA5_3 >= Rbr && LA5_3 <= RoundLbr)||LA5_3==Str) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case StringType:
				{
				int LA5_4 = input.LA(2);
				if ( (LA5_4==LSquBr) ) {
					alt5=1;
				}
				else if ( (LA5_4==EOF||LA5_4==Bool||LA5_4==Doub||(LA5_4 >= Ident && LA5_4 <= Int)||(LA5_4 >= Rbr && LA5_4 <= RoundLbr)||LA5_4==Str) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DoubleType:
				{
				int LA5_5 = input.LA(2);
				if ( (LA5_5==LSquBr) ) {
					alt5=1;
				}
				else if ( (LA5_5==EOF||LA5_5==Bool||LA5_5==Doub||(LA5_5 >= Ident && LA5_5 <= Int)||(LA5_5 >= Rbr && LA5_5 <= RoundLbr)||LA5_5==Str) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:4: identType LSquBr Str ( ',' Str )* RSquBr
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identType_in_identArrayType277);
					identType19=identType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identType19.getTree());

					LSquBr20=(Token)match(input,LSquBr,FOLLOW_LSquBr_in_identArrayType279); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LSquBr20_tree = (Object)adaptor.create(LSquBr20);
					adaptor.addChild(root_0, LSquBr20_tree);
					}

					Str21=(Token)match(input,Str,FOLLOW_Str_in_identArrayType281); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Str21_tree = (Object)adaptor.create(Str21);
					adaptor.addChild(root_0, Str21_tree);
					}

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:25: ( ',' Str )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==51) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:69:26: ',' Str
							{
							char_literal22=(Token)match(input,51,FOLLOW_51_in_identArrayType284); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal22_tree = (Object)adaptor.create(char_literal22);
							adaptor.addChild(root_0, char_literal22_tree);
							}

							Str23=(Token)match(input,Str,FOLLOW_Str_in_identArrayType286); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							Str23_tree = (Object)adaptor.create(Str23);
							adaptor.addChild(root_0, Str23_tree);
							}

							}
							break;

						default :
							break loop4;
						}
					}

					RSquBr24=(Token)match(input,RSquBr,FOLLOW_RSquBr_in_identArrayType290); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RSquBr24_tree = (Object)adaptor.create(RSquBr24);
					adaptor.addChild(root_0, RSquBr24_tree);
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:70:4: identType
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_identType_in_identArrayType295);
					identType25=identType();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identType25.getTree());

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
			if ( state.backtracking>0 ) { memoize(input, 5, identArrayType_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "identArrayType"


	public static class identType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identType"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: identType : ( BooleanType -> BooleanType | MoneyType -> MoneyType | IntegerType -> IntegerType | StringType -> StringType | DoubleType -> DoubleType );
	public final QLParser.identType_return identType() throws RecognitionException {
		QLParser.identType_return retval = new QLParser.identType_return();
		retval.start = input.LT(1);
		int identType_StartIndex = input.index();

		Object root_0 = null;

		Token BooleanType26=null;
		Token MoneyType27=null;
		Token IntegerType28=null;
		Token StringType29=null;
		Token DoubleType30=null;

		Object BooleanType26_tree=null;
		Object MoneyType27_tree=null;
		Object IntegerType28_tree=null;
		Object StringType29_tree=null;
		Object DoubleType30_tree=null;
		RewriteRuleTokenStream stream_IntegerType=new RewriteRuleTokenStream(adaptor,"token IntegerType");
		RewriteRuleTokenStream stream_DoubleType=new RewriteRuleTokenStream(adaptor,"token DoubleType");
		RewriteRuleTokenStream stream_StringType=new RewriteRuleTokenStream(adaptor,"token StringType");
		RewriteRuleTokenStream stream_MoneyType=new RewriteRuleTokenStream(adaptor,"token MoneyType");
		RewriteRuleTokenStream stream_BooleanType=new RewriteRuleTokenStream(adaptor,"token BooleanType");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:2: ( BooleanType -> BooleanType | MoneyType -> MoneyType | IntegerType -> IntegerType | StringType -> StringType | DoubleType -> DoubleType )
			int alt6=5;
			switch ( input.LA(1) ) {
			case BooleanType:
				{
				alt6=1;
				}
				break;
			case MoneyType:
				{
				alt6=2;
				}
				break;
			case IntegerType:
				{
				alt6=3;
				}
				break;
			case StringType:
				{
				alt6=4;
				}
				break;
			case DoubleType:
				{
				alt6=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: BooleanType
					{
					BooleanType26=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_identType308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_BooleanType.add(BooleanType26);

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
					// 73:19: -> BooleanType
					{
						adaptor.addChild(root_0, stream_BooleanType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:4: MoneyType
					{
					MoneyType27=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_identType320); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MoneyType.add(MoneyType27);

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
					// 74:16: -> MoneyType
					{
						adaptor.addChild(root_0, stream_MoneyType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: IntegerType
					{
					IntegerType28=(Token)match(input,IntegerType,FOLLOW_IntegerType_in_identType333); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IntegerType.add(IntegerType28);

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
					// 75:18: -> IntegerType
					{
						adaptor.addChild(root_0, stream_IntegerType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:76:4: StringType
					{
					StringType29=(Token)match(input,StringType,FOLLOW_StringType_in_identType345); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_StringType.add(StringType29);

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
					// 76:17: -> StringType
					{
						adaptor.addChild(root_0, stream_StringType.nextNode());
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:77:4: DoubleType
					{
					DoubleType30=(Token)match(input,DoubleType,FOLLOW_DoubleType_in_identType357); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DoubleType.add(DoubleType30);

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
					// 77:16: -> DoubleType
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
			if ( state.backtracking>0 ) { memoize(input, 6, identType_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: ifBlock : ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
	public final QLParser.ifBlock_return ifBlock() throws RecognitionException {
		QLParser.ifBlock_return retval = new QLParser.ifBlock_return();
		retval.start = input.LT(1);
		int ifBlock_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope ifCondition31 =null;
		ParserRuleReturnScope ifStatementBlock32 =null;
		ParserRuleReturnScope elseBlock33 =null;

		RewriteRuleSubtreeStream stream_ifCondition=new RewriteRuleSubtreeStream(adaptor,"rule ifCondition");
		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:2: ( ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:4: ifCondition ifStatementBlock ( elseBlock )?
			{
			pushFollow(FOLLOW_ifCondition_in_ifBlock377);
			ifCondition31=ifCondition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifCondition.add(ifCondition31.getTree());
			pushFollow(FOLLOW_ifStatementBlock_in_ifBlock380);
			ifStatementBlock32=ifStatementBlock();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ifStatementBlock.add(ifStatementBlock32.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:35: ( elseBlock )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Else) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:36: elseBlock
					{
					pushFollow(FOLLOW_elseBlock_in_ifBlock384);
					elseBlock33=elseBlock();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_elseBlock.add(elseBlock33.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: ifCondition, elseBlock, ifStatementBlock
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 82:49: -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:51: ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:67: ^( IF_CONDITION ifCondition )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				adaptor.addChild(root_2, stream_ifCondition.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:97: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:131: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:82:131: ^( IF_BLOCK_FALSE elseBlock )
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
			if ( state.backtracking>0 ) { memoize(input, 7, ifBlock_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:1: ifCondition : If RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifCondition_return ifCondition() throws RecognitionException {
		QLParser.ifCondition_return retval = new QLParser.ifCondition_return();
		retval.start = input.LT(1);
		int ifCondition_StartIndex = input.index();

		Object root_0 = null;

		Token If34=null;
		Token RoundLbr35=null;
		Token RoundRbr37=null;
		ParserRuleReturnScope orExpr36 =null;

		Object If34_tree=null;
		Object RoundLbr35_tree=null;
		Object RoundRbr37_tree=null;
		RewriteRuleTokenStream stream_RoundLbr=new RewriteRuleTokenStream(adaptor,"token RoundLbr");
		RewriteRuleTokenStream stream_RoundRbr=new RewriteRuleTokenStream(adaptor,"token RoundRbr");
		RewriteRuleTokenStream stream_If=new RewriteRuleTokenStream(adaptor,"token If");
		RewriteRuleSubtreeStream stream_orExpr=new RewriteRuleSubtreeStream(adaptor,"rule orExpr");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:2: ( If RoundLbr orExpr RoundRbr -> orExpr )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:86:5: If RoundLbr orExpr RoundRbr
			{
			If34=(Token)match(input,If,FOLLOW_If_in_ifCondition428); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_If.add(If34);

			RoundLbr35=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifCondition430); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RoundLbr.add(RoundLbr35);

			pushFollow(FOLLOW_orExpr_in_ifCondition432);
			orExpr36=orExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_orExpr.add(orExpr36.getTree());
			RoundRbr37=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifCondition435); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RoundRbr.add(RoundRbr37);

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
			// 86:34: -> orExpr
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
			if ( state.backtracking>0 ) { memoize(input, 8, ifCondition_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: ifStatementBlock : Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
	public final QLParser.ifStatementBlock_return ifStatementBlock() throws RecognitionException {
		QLParser.ifStatementBlock_return retval = new QLParser.ifStatementBlock_return();
		retval.start = input.LT(1);
		int ifStatementBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Lbr38=null;
		Token Rbr40=null;
		ParserRuleReturnScope blockItem39 =null;

		Object Lbr38_tree=null;
		Object Rbr40_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:2: ( Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: Lbr ( blockItem )* Rbr
			{
			Lbr38=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock454); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr38);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: ( blockItem )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= Ident && LA8_0 <= If)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:10: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock457);
					blockItem39=blockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_blockItem.add(blockItem39.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			Rbr40=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock460); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr40);

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
			// 90:25: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:28: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:36: ( blockItem )*
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
			if ( state.backtracking>0 ) { memoize(input, 9, ifStatementBlock_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:92:1: elseBlock : Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
	public final QLParser.elseBlock_return elseBlock() throws RecognitionException {
		QLParser.elseBlock_return retval = new QLParser.elseBlock_return();
		retval.start = input.LT(1);
		int elseBlock_StartIndex = input.index();

		Object root_0 = null;

		Token Else41=null;
		Token Lbr42=null;
		Token Rbr44=null;
		ParserRuleReturnScope blockItem43 =null;

		Object Else41_tree=null;
		Object Lbr42_tree=null;
		Object Rbr44_tree=null;
		RewriteRuleTokenStream stream_Lbr=new RewriteRuleTokenStream(adaptor,"token Lbr");
		RewriteRuleTokenStream stream_Rbr=new RewriteRuleTokenStream(adaptor,"token Rbr");
		RewriteRuleTokenStream stream_Else=new RewriteRuleTokenStream(adaptor,"token Else");
		RewriteRuleSubtreeStream stream_blockItem=new RewriteRuleSubtreeStream(adaptor,"rule blockItem");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:2: ( Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:4: Else Lbr ( blockItem )* Rbr
			{
			Else41=(Token)match(input,Else,FOLLOW_Else_in_elseBlock478); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Else.add(Else41);

			Lbr42=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock480); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Lbr.add(Lbr42);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: ( blockItem )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= Ident && LA9_0 <= If)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:13: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_elseBlock482);
					blockItem43=blockItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_blockItem.add(blockItem43.getTree());
					}
					break;

				default :
					break loop9;
				}
			}

			Rbr44=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock485); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Rbr.add(Rbr44);

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
			// 93:28: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:31: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:93:39: ( blockItem )*
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
			if ( state.backtracking>0 ) { memoize(input, 10, elseBlock_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: atom : ( Int | Ident | Doub | Str | Bool | RoundLbr !x= orExpr ^ RoundRbr !);
	public final QLParser.atom_return atom() throws RecognitionException {
		QLParser.atom_return retval = new QLParser.atom_return();
		retval.start = input.LT(1);
		int atom_StartIndex = input.index();

		Object root_0 = null;

		Token Int45=null;
		Token Ident46=null;
		Token Doub47=null;
		Token Str48=null;
		Token Bool49=null;
		Token RoundLbr50=null;
		Token RoundRbr51=null;
		ParserRuleReturnScope x =null;

		Object Int45_tree=null;
		Object Ident46_tree=null;
		Object Doub47_tree=null;
		Object Str48_tree=null;
		Object Bool49_tree=null;
		Object RoundLbr50_tree=null;
		Object RoundRbr51_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:3: ( Int | Ident | Doub | Str | Bool | RoundLbr !x= orExpr ^ RoundRbr !)
			int alt10=6;
			switch ( input.LA(1) ) {
			case Int:
				{
				alt10=1;
				}
				break;
			case Ident:
				{
				alt10=2;
				}
				break;
			case Doub:
				{
				alt10=3;
				}
				break;
			case Str:
				{
				alt10=4;
				}
				break;
			case Bool:
				{
				alt10=5;
				}
				break;
			case RoundLbr:
				{
				alt10=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: Int
					{
					root_0 = (Object)adaptor.nil();


					Int45=(Token)match(input,Int,FOLLOW_Int_in_atom514); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Int45_tree = (Object)adaptor.create(Int45);
					adaptor.addChild(root_0, Int45_tree);
					}

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					Ident46=(Token)match(input,Ident,FOLLOW_Ident_in_atom522); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Ident46_tree = (Object)adaptor.create(Ident46);
					adaptor.addChild(root_0, Ident46_tree);
					}

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:102:5: Doub
					{
					root_0 = (Object)adaptor.nil();


					Doub47=(Token)match(input,Doub,FOLLOW_Doub_in_atom529); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Doub47_tree = (Object)adaptor.create(Doub47);
					adaptor.addChild(root_0, Doub47_tree);
					}

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:5: Str
					{
					root_0 = (Object)adaptor.nil();


					Str48=(Token)match(input,Str,FOLLOW_Str_in_atom535); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Str48_tree = (Object)adaptor.create(Str48);
					adaptor.addChild(root_0, Str48_tree);
					}

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: Bool
					{
					root_0 = (Object)adaptor.nil();


					Bool49=(Token)match(input,Bool,FOLLOW_Bool_in_atom541); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Bool49_tree = (Object)adaptor.create(Bool49);
					adaptor.addChild(root_0, Bool49_tree);
					}

					}
					break;
				case 6 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:105:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					RoundLbr50=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom548); if (state.failed) return retval;
					pushFollow(FOLLOW_orExpr_in_atom554);
					x=orExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);
					RoundRbr51=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom557); if (state.failed) return retval;
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
			if ( state.backtracking>0 ) { memoize(input, 11, atom_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:108:1: unExpr : ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom );
	public final QLParser.unExpr_return unExpr() throws RecognitionException {
		QLParser.unExpr_return retval = new QLParser.unExpr_return();
		retval.start = input.LT(1);
		int unExpr_StartIndex = input.index();

		Object root_0 = null;

		Token Sub52=null;
		Token Not54=null;
		ParserRuleReturnScope atom53 =null;
		ParserRuleReturnScope atom55 =null;
		ParserRuleReturnScope atom56 =null;

		Object Sub52_tree=null;
		Object Not54_tree=null;
		RewriteRuleTokenStream stream_Sub=new RewriteRuleTokenStream(adaptor,"token Sub");
		RewriteRuleTokenStream stream_Not=new RewriteRuleTokenStream(adaptor,"token Not");
		RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:5: ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom )
			int alt11=3;
			switch ( input.LA(1) ) {
			case Sub:
				{
				alt11=1;
				}
				break;
			case Not:
				{
				alt11=2;
				}
				break;
			case Bool:
			case Doub:
			case Ident:
			case Int:
			case RoundLbr:
			case Str:
				{
				alt11=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:8: Sub atom
					{
					Sub52=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Sub.add(Sub52);

					pushFollow(FOLLOW_atom_in_unExpr580);
					atom53=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom53.getTree());
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
					// 109:17: -> ^( UNARY_MINUS atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:109:20: ^( UNARY_MINUS atom )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:8: Not atom
					{
					Not54=(Token)match(input,Not,FOLLOW_Not_in_unExpr598); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Not.add(Not54);

					pushFollow(FOLLOW_atom_in_unExpr600);
					atom55=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_atom.add(atom55.getTree());
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
					// 110:17: -> ^( UNARY_NEGATE atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:110:20: ^( UNARY_NEGATE atom )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:111:8: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unExpr617);
					atom56=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom56.getTree());

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
		return retval;
	}
	// $ANTLR end "unExpr"


	public static class mulExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: mulExpr : lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: (lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unExpr_in_mulExpr651);
			lhs=unExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:21: (op= ( Mul | Div ) ^rhs= unExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Div||LA12_0==Mul) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:23: op= ( Mul | Div ) ^rhs= unExpr
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
					pushFollow(FOLLOW_unExpr_in_mulExpr671);
					rhs=unExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 13, mulExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:1: addExpr : lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:9: lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mulExpr_in_addExpr703);
			lhs=mulExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:21: (op= ( Add | Sub ) ^rhs= mulExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==Add||LA13_0==Sub) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:120:23: op= ( Add | Sub ) ^rhs= mulExpr
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
					pushFollow(FOLLOW_mulExpr_in_addExpr721);
					rhs=mulExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 14, addExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:1: relExpr : lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* ;
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
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:5: (lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:9: lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_relExpr748);
			lhs=addExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:22: (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==Equ||(LA14_0 >= GT && LA14_0 <= GTEqu)||(LA14_0 >= LT && LA14_0 <= LTEqu)||LA14_0==NotEqu) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:24: op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr
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
					pushFollow(FOLLOW_addExpr_in_relExpr777);
					rhs=addExpr();
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
			if ( state.backtracking>0 ) { memoize(input, 15, relExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:127:1: andExpr : lhs= relExpr ( And ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);
		int andExpr_StartIndex = input.index();

		Object root_0 = null;

		Token And57=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And57_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:5: (lhs= relExpr ( And ^rhs= relExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:9: lhs= relExpr ( And ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relExpr_in_andExpr806);
			lhs=relExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:21: ( And ^rhs= relExpr )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==And) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:23: And ^rhs= relExpr
					{
					And57=(Token)match(input,And,FOLLOW_And_in_andExpr810); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					And57_tree = (Object)adaptor.create(And57);
					root_0 = (Object)adaptor.becomeRoot(And57_tree, root_0);
					}

					pushFollow(FOLLOW_relExpr_in_andExpr815);
					rhs=relExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop15;
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
			if ( state.backtracking>0 ) { memoize(input, 16, andExpr_StartIndex); }

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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:132:1: orExpr : lhs= andExpr ( Or ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);
		int orExpr_StartIndex = input.index();

		Object root_0 = null;

		Token Or58=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or58_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:5: (lhs= andExpr ( Or ^rhs= andExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:8: lhs= andExpr ( Or ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andExpr_in_orExpr846);
			lhs=andExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:20: ( Or ^rhs= andExpr )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==Or) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:22: Or ^rhs= andExpr
					{
					Or58=(Token)match(input,Or,FOLLOW_Or_in_orExpr850); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					Or58_tree = (Object)adaptor.create(Or58);
					root_0 = (Object)adaptor.becomeRoot(Or58_tree, root_0);
					}

					pushFollow(FOLLOW_andExpr_in_orExpr855);
					rhs=andExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop16;
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
			if ( state.backtracking>0 ) { memoize(input, 17, orExpr_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_FormStart_in_parse107 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Ident_in_parse109 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_Lbr_in_parse111 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_blockItem_in_parse113 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_Rbr_in_parse116 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionAssignment_in_blockItem145 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_blockItem149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment170 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_questionAssignment173 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_Str_in_questionAssignment176 = new BitSet(new long[]{0x0000400840011000L});
	public static final BitSet FOLLOW_identArrayType_in_questionAssignment178 = new BitSet(new long[]{0x0000280028008802L});
	public static final BitSet FOLLOW_atom_in_questionAssignment181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment232 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_constantAssignment235 = new BitSet(new long[]{0x0000400840011000L});
	public static final BitSet FOLLOW_identType_in_constantAssignment237 = new BitSet(new long[]{0x0000280028008800L});
	public static final BitSet FOLLOW_atom_in_constantAssignment239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identType_in_identArrayType277 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LSquBr_in_identArrayType279 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_Str_in_identArrayType281 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_51_in_identArrayType284 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_Str_in_identArrayType286 = new BitSet(new long[]{0x0008020000000000L});
	public static final BitSet FOLLOW_RSquBr_in_identArrayType290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identType_in_identArrayType295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IntegerType_in_identType333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_StringType_in_identType345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DoubleType_in_identType357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifCondition_in_ifBlock377 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifBlock380 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_elseBlock_in_ifBlock384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifCondition428 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RoundLbr_in_ifCondition430 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_orExpr_in_ifCondition432 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifCondition435 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock454 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock457 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock478 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock480 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock482 = new BitSet(new long[]{0x0000040018000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Doub_in_atom529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Str_in_atom535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Bool_in_atom541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom548 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_orExpr_in_atom554 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr578 = new BitSet(new long[]{0x0000280028008800L});
	public static final BitSet FOLLOW_atom_in_unExpr580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unExpr598 = new BitSet(new long[]{0x0000280028008800L});
	public static final BitSet FOLLOW_atom_in_unExpr600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr651 = new BitSet(new long[]{0x0000001000004002L});
	public static final BitSet FOLLOW_set_in_mulExpr658 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr671 = new BitSet(new long[]{0x0000001000004002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr703 = new BitSet(new long[]{0x0000800000000082L});
	public static final BitSet FOLLOW_set_in_addExpr709 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr721 = new BitSet(new long[]{0x0000800000000082L});
	public static final BitSet FOLLOW_addExpr_in_relExpr748 = new BitSet(new long[]{0x0000004300340002L});
	public static final BitSet FOLLOW_set_in_relExpr755 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_addExpr_in_relExpr777 = new BitSet(new long[]{0x0000004300340002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr806 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_And_in_andExpr810 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_relExpr_in_andExpr815 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_andExpr_in_orExpr846 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_Or_in_orExpr850 = new BitSet(new long[]{0x0000A82028008800L});
	public static final BitSet FOLLOW_andExpr_in_orExpr855 = new BitSet(new long[]{0x0000008000000002L});
}
