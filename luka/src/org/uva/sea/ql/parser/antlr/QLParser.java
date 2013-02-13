// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-13 02:13:22

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

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class QLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "ASSIGNMENT_EXPRESSION", 
		"ASSIGNMENT_TYPE", "Add", "And", "Assignment_Indicator", "BLOCK", "Bool", 
		"BooleanType", "COMMENT", "Div", "Else", "Equ", "FormId", "FormStart", 
		"GT", "GTEqu", "IDENT", "IF_BLOCK_FALSE", "IF_BLOCK_TRUE", "IF_CONDITION", 
		"IF_STATEMENT", "Ident", "If", "Int", "LT", "LTEqu", "Lbr", "MoneyType", 
		"Mul", "Not", "NotEqu", "Or", "QUESTION_LABEL", "Rbr", "RoundLbr", "RoundRbr", 
		"String", "Sub", "UNARY_MINUS", "UNARY_NEGATE", "WS"
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
	public static final int Else=15;
	public static final int Equ=16;
	public static final int FormId=17;
	public static final int FormStart=18;
	public static final int GT=19;
	public static final int GTEqu=20;
	public static final int IDENT=21;
	public static final int IF_BLOCK_FALSE=22;
	public static final int IF_BLOCK_TRUE=23;
	public static final int IF_CONDITION=24;
	public static final int IF_STATEMENT=25;
	public static final int Ident=26;
	public static final int If=27;
	public static final int Int=28;
	public static final int LT=29;
	public static final int LTEqu=30;
	public static final int Lbr=31;
	public static final int MoneyType=32;
	public static final int Mul=33;
	public static final int Not=34;
	public static final int NotEqu=35;
	public static final int Or=36;
	public static final int QUESTION_LABEL=37;
	public static final int Rbr=38;
	public static final int RoundLbr=39;
	public static final int RoundRbr=40;
	public static final int String=41;
	public static final int Sub=42;
	public static final int UNARY_MINUS=43;
	public static final int UNARY_NEGATE=44;
	public static final int WS=45;

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


		public Map<Ident,Type> typeEnv = new HashMap<Ident,Type>();
		private void mapIdentToType(String identName,Type type){
		//System.out.println(identName+type.toString());
			typeEnv.put(new Ident(identName),type);
		}


	public static class parse_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parse"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: parse : FormStart FormId Lbr ( blockItem )* Rbr EOF -> ^( FormId ^( BLOCK ( blockItem )* ) ) ;
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:2: ( FormStart FormId Lbr ( blockItem )* Rbr EOF -> ^( FormId ^( BLOCK ( blockItem )* ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:4: FormStart FormId Lbr ( blockItem )* Rbr EOF
			{
			FormStart1=(Token)match(input,FormStart,FOLLOW_FormStart_in_parse113);  
			stream_FormStart.add(FormStart1);

			FormId2=(Token)match(input,FormId,FOLLOW_FormId_in_parse115);  
			stream_FormId.add(FormId2);

			Lbr3=(Token)match(input,Lbr,FOLLOW_Lbr_in_parse117);  
			stream_Lbr.add(Lbr3);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:25: ( blockItem )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= Ident && LA1_0 <= If)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:25: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_parse119);
					blockItem4=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem4.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			Rbr5=(Token)match(input,Rbr,FOLLOW_Rbr_in_parse122);  
			stream_Rbr.add(Rbr5);

			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_parse124);  
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
			// 72:44: -> ^( FormId ^( BLOCK ( blockItem )* ) )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:47: ^( FormId ^( BLOCK ( blockItem )* ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_FormId.nextNode(), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:56: ^( BLOCK ( blockItem )* )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_2);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:72:64: ( blockItem )*
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
		return retval;
	}
	// $ANTLR end "parse"


	public static class blockItem_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "blockItem"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:74:1: blockItem : ( questionAssignment | constantAssignment | ifBlock ) ;
	public final QLParser.blockItem_return blockItem() throws RecognitionException {
		QLParser.blockItem_return retval = new QLParser.blockItem_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope questionAssignment7 =null;
		ParserRuleReturnScope constantAssignment8 =null;
		ParserRuleReturnScope ifBlock9 =null;


		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:2: ( ( questionAssignment | constantAssignment | ifBlock ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: ( questionAssignment | constantAssignment | ifBlock )
			{
			root_0 = (Object)adaptor.nil();


			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:4: ( questionAssignment | constantAssignment | ifBlock )
			int alt2=3;
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
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:5: questionAssignment
					{
					pushFollow(FOLLOW_questionAssignment_in_blockItem148);
					questionAssignment7=questionAssignment();
					state._fsp--;

					adaptor.addChild(root_0, questionAssignment7.getTree());

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:26: constantAssignment
					{
					pushFollow(FOLLOW_constantAssignment_in_blockItem152);
					constantAssignment8=constantAssignment();
					state._fsp--;

					adaptor.addChild(root_0, constantAssignment8.getTree());

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:75:47: ifBlock
					{
					pushFollow(FOLLOW_ifBlock_in_blockItem156);
					ifBlock9=ifBlock();
					state._fsp--;

					adaptor.addChild(root_0, ifBlock9.getTree());

					}
					break;

			}

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
		return retval;
	}
	// $ANTLR end "blockItem"


	public static class questionAssignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "questionAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:78:1: questionAssignment : Ident Assignment_Indicator String identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) ;
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:2: ( Ident Assignment_Indicator String identType ( atom )? -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:4: Ident Assignment_Indicator String identType ( atom )?
			{
			Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_questionAssignment172);  
			stream_Ident.add(Ident10);

			Assignment_Indicator11=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_questionAssignment175);  
			stream_Assignment_Indicator.add(Assignment_Indicator11);

			String12=(Token)match(input,String,FOLLOW_String_in_questionAssignment178);  
			stream_String.add(String12);

			pushFollow(FOLLOW_identType_in_questionAssignment180);
			identType13=identType();
			state._fsp--;

			stream_identType.add(identType13.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:50: ( atom )?
			int alt3=2;
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
			switch (alt3) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:51: atom
					{
					pushFollow(FOLLOW_atom_in_questionAssignment183);
					atom14=atom();
					state._fsp--;

					stream_atom.add(atom14.getTree());
					}
					break;

			}

			mapIdentToType((Ident10!=null?Ident10.getText():null),(identType13!=null?((QLParser.identType_return)identType13).t:null));
			// AST REWRITE
			// elements: String, Ident, identType, atom
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 79:103: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:105: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( QUESTION_LABEL String ) ( ^( ASSIGNMENT_EXPRESSION atom ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:118: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:133: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:162: ^( QUESTION_LABEL String )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(QUESTION_LABEL, "QUESTION_LABEL"), root_2);
				adaptor.addChild(root_2, stream_String.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:189: ( ^( ASSIGNMENT_EXPRESSION atom ) )?
				if ( stream_atom.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:79:189: ^( ASSIGNMENT_EXPRESSION atom )
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
		return retval;
	}
	// $ANTLR end "questionAssignment"


	public static class constantAssignment_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constantAssignment"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:84:1: constantAssignment : Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) ;
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:2: ( Ident Assignment_Indicator identType atom -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:4: Ident Assignment_Indicator identType atom
			{
			Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_constantAssignment236);  
			stream_Ident.add(Ident15);

			Assignment_Indicator16=(Token)match(input,Assignment_Indicator,FOLLOW_Assignment_Indicator_in_constantAssignment239);  
			stream_Assignment_Indicator.add(Assignment_Indicator16);

			pushFollow(FOLLOW_identType_in_constantAssignment241);
			identType17=identType();
			state._fsp--;

			stream_identType.add(identType17.getTree());
			pushFollow(FOLLOW_atom_in_constantAssignment243);
			atom18=atom();
			state._fsp--;

			stream_atom.add(atom18.getTree());
			mapIdentToType((Ident15!=null?Ident15.getText():null),(identType17!=null?((QLParser.identType_return)identType17).t:null));
			// AST REWRITE
			// elements: atom, identType, Ident
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 85:91: -> ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:94: ^( ASSIGNMENT ^( IDENT Ident ) ^( ASSIGNMENT_TYPE identType ) ^( ASSIGNMENT_EXPRESSION atom ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT, "ASSIGNMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:107: ^( IDENT Ident )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IDENT, "IDENT"), root_2);
				adaptor.addChild(root_2, stream_Ident.nextNode());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:123: ^( ASSIGNMENT_TYPE identType )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGNMENT_TYPE, "ASSIGNMENT_TYPE"), root_2);
				adaptor.addChild(root_2, stream_identType.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:85:152: ^( ASSIGNMENT_EXPRESSION atom )
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
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:89:1: identType returns [Type t] : ( BooleanType -> BooleanType | MoneyType -> MoneyType );
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:2: ( BooleanType -> BooleanType | MoneyType -> MoneyType )
			int alt4=2;
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
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:90:4: BooleanType
					{
					BooleanType19=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_identType290);  
					stream_BooleanType.add(BooleanType19);

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
					// 90:40: -> BooleanType
					{
						adaptor.addChild(root_0, stream_BooleanType.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:91:4: MoneyType
					{
					MoneyType20=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_identType303);  
					stream_MoneyType.add(MoneyType20);

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
					// 91:39: -> MoneyType
					{
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
		return retval;
	}
	// $ANTLR end "identType"


	public static class ifBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: ifBlock : ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) ;
	public final QLParser.ifBlock_return ifBlock() throws RecognitionException {
		QLParser.ifBlock_return retval = new QLParser.ifBlock_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope ifCondition21 =null;
		ParserRuleReturnScope ifStatementBlock22 =null;
		ParserRuleReturnScope elseBlock23 =null;

		RewriteRuleSubtreeStream stream_ifCondition=new RewriteRuleSubtreeStream(adaptor,"rule ifCondition");
		RewriteRuleSubtreeStream stream_ifStatementBlock=new RewriteRuleSubtreeStream(adaptor,"rule ifStatementBlock");
		RewriteRuleSubtreeStream stream_elseBlock=new RewriteRuleSubtreeStream(adaptor,"rule elseBlock");

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:2: ( ifCondition ifStatementBlock ( elseBlock )? -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:4: ifCondition ifStatementBlock ( elseBlock )?
			{
			pushFollow(FOLLOW_ifCondition_in_ifBlock325);
			ifCondition21=ifCondition();
			state._fsp--;

			stream_ifCondition.add(ifCondition21.getTree());
			pushFollow(FOLLOW_ifStatementBlock_in_ifBlock328);
			ifStatementBlock22=ifStatementBlock();
			state._fsp--;

			stream_ifStatementBlock.add(ifStatementBlock22.getTree());
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:35: ( elseBlock )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==Else) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:36: elseBlock
					{
					pushFollow(FOLLOW_elseBlock_in_ifBlock332);
					elseBlock23=elseBlock();
					state._fsp--;

					stream_elseBlock.add(elseBlock23.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: elseBlock, ifCondition, ifStatementBlock
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 96:49: -> ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:51: ^( IF_STATEMENT ^( IF_CONDITION ifCondition ) ^( IF_BLOCK_TRUE ifStatementBlock ) ( ^( IF_BLOCK_FALSE elseBlock ) )? )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_STATEMENT, "IF_STATEMENT"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:67: ^( IF_CONDITION ifCondition )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_CONDITION, "IF_CONDITION"), root_2);
				adaptor.addChild(root_2, stream_ifCondition.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:97: ^( IF_BLOCK_TRUE ifStatementBlock )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF_BLOCK_TRUE, "IF_BLOCK_TRUE"), root_2);
				adaptor.addChild(root_2, stream_ifStatementBlock.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:131: ( ^( IF_BLOCK_FALSE elseBlock ) )?
				if ( stream_elseBlock.hasNext() ) {
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:96:131: ^( IF_BLOCK_FALSE elseBlock )
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
		return retval;
	}
	// $ANTLR end "ifBlock"


	public static class ifCondition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifCondition"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:99:1: ifCondition : If RoundLbr orExpr RoundRbr -> orExpr ;
	public final QLParser.ifCondition_return ifCondition() throws RecognitionException {
		QLParser.ifCondition_return retval = new QLParser.ifCondition_return();
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:2: ( If RoundLbr orExpr RoundRbr -> orExpr )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:100:5: If RoundLbr orExpr RoundRbr
			{
			If24=(Token)match(input,If,FOLLOW_If_in_ifCondition376);  
			stream_If.add(If24);

			RoundLbr25=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_ifCondition378);  
			stream_RoundLbr.add(RoundLbr25);

			pushFollow(FOLLOW_orExpr_in_ifCondition380);
			orExpr26=orExpr();
			state._fsp--;

			stream_orExpr.add(orExpr26.getTree());
			RoundRbr27=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_ifCondition383);  
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
			// 100:34: -> orExpr
			{
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
		return retval;
	}
	// $ANTLR end "ifCondition"


	public static class ifStatementBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifStatementBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:103:1: ifStatementBlock : Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:2: ( Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: Lbr ( blockItem )* Rbr
			{
			Lbr28=(Token)match(input,Lbr,FOLLOW_Lbr_in_ifStatementBlock401);  
			stream_Lbr.add(Lbr28);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:10: ( blockItem )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= Ident && LA6_0 <= If)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:10: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_ifStatementBlock404);
					blockItem29=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem29.getTree());
					}
					break;

				default :
					break loop6;
				}
			}

			Rbr30=(Token)match(input,Rbr,FOLLOW_Rbr_in_ifStatementBlock407);  
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
			// 104:25: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:28: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:104:36: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "ifStatementBlock"


	public static class elseBlock_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "elseBlock"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:106:1: elseBlock : Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) ;
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:2: ( Else Lbr ( blockItem )* Rbr -> ^( BLOCK ( blockItem )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:4: Else Lbr ( blockItem )* Rbr
			{
			Else31=(Token)match(input,Else,FOLLOW_Else_in_elseBlock425);  
			stream_Else.add(Else31);

			Lbr32=(Token)match(input,Lbr,FOLLOW_Lbr_in_elseBlock427);  
			stream_Lbr.add(Lbr32);

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:13: ( blockItem )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= Ident && LA7_0 <= If)) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:13: blockItem
					{
					pushFollow(FOLLOW_blockItem_in_elseBlock429);
					blockItem33=blockItem();
					state._fsp--;

					stream_blockItem.add(blockItem33.getTree());
					}
					break;

				default :
					break loop7;
				}
			}

			Rbr34=(Token)match(input,Rbr,FOLLOW_Rbr_in_elseBlock432);  
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
			// 107:28: -> ^( BLOCK ( blockItem )* )
			{
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:31: ^( BLOCK ( blockItem )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:107:39: ( blockItem )*
				while ( stream_blockItem.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "elseBlock"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: atom : ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !);
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:3: ( Int | Ident | BooleanType | MoneyType | RoundLbr !x= orExpr ^ RoundRbr !)
			int alt8=5;
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
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: Int
					{
					root_0 = (Object)adaptor.nil();


					Int35=(Token)match(input,Int,FOLLOW_Int_in_atom461); 
					Int35_tree = (Object)adaptor.create(Int35);
					adaptor.addChild(root_0, Int35_tree);

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: Ident
					{
					root_0 = (Object)adaptor.nil();


					Ident36=(Token)match(input,Ident,FOLLOW_Ident_in_atom469); 
					Ident36_tree = (Object)adaptor.create(Ident36);
					adaptor.addChild(root_0, Ident36_tree);

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:116:5: BooleanType
					{
					root_0 = (Object)adaptor.nil();


					BooleanType37=(Token)match(input,BooleanType,FOLLOW_BooleanType_in_atom476); 
					BooleanType37_tree = (Object)adaptor.create(BooleanType37);
					adaptor.addChild(root_0, BooleanType37_tree);

					}
					break;
				case 4 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:117:5: MoneyType
					{
					root_0 = (Object)adaptor.nil();


					MoneyType38=(Token)match(input,MoneyType,FOLLOW_MoneyType_in_atom482); 
					MoneyType38_tree = (Object)adaptor.create(MoneyType38);
					adaptor.addChild(root_0, MoneyType38_tree);

					}
					break;
				case 5 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:119:6: RoundLbr !x= orExpr ^ RoundRbr !
					{
					root_0 = (Object)adaptor.nil();


					RoundLbr39=(Token)match(input,RoundLbr,FOLLOW_RoundLbr_in_atom492); 
					pushFollow(FOLLOW_orExpr_in_atom498);
					x=orExpr();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(x.getTree(), root_0);
					RoundRbr40=(Token)match(input,RoundRbr,FOLLOW_RoundRbr_in_atom501); 
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
		return retval;
	}
	// $ANTLR end "atom"


	public static class unExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:122:1: unExpr : ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom );
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

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:5: ( Sub atom -> ^( UNARY_MINUS atom ) | Not atom -> ^( UNARY_NEGATE atom ) | atom )
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
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:8: Sub atom
					{
					Sub41=(Token)match(input,Sub,FOLLOW_Sub_in_unExpr522);  
					stream_Sub.add(Sub41);

					pushFollow(FOLLOW_atom_in_unExpr524);
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
					// 123:17: -> ^( UNARY_MINUS atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:123:20: ^( UNARY_MINUS atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:8: Not atom
					{
					Not43=(Token)match(input,Not,FOLLOW_Not_in_unExpr542);  
					stream_Not.add(Not43);

					pushFollow(FOLLOW_atom_in_unExpr544);
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
					// 124:17: -> ^( UNARY_NEGATE atom )
					{
						// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:124:20: ^( UNARY_NEGATE atom )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_NEGATE, "UNARY_NEGATE"), root_1);
						adaptor.addChild(root_1, stream_atom.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:125:8: atom
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_atom_in_unExpr561);
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
		return retval;
	}
	// $ANTLR end "unExpr"


	public static class mulExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "mulExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:128:1: mulExpr : lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* ;
	public final QLParser.mulExpr_return mulExpr() throws RecognitionException {
		QLParser.mulExpr_return retval = new QLParser.mulExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:5: (lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:9: lhs= unExpr (op= ( Mul | Div ) ^rhs= unExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unExpr_in_mulExpr595);
			lhs=unExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:21: (op= ( Mul | Div ) ^rhs= unExpr )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==Div||LA10_0==Mul) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:129:23: op= ( Mul | Div ) ^rhs= unExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Div||input.LA(1)==Mul ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unExpr_in_mulExpr615);
					rhs=unExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop10;
				}
			}

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
		return retval;
	}
	// $ANTLR end "mulExpr"


	public static class addExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "addExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:133:1: addExpr : lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* ;
	public final QLParser.addExpr_return addExpr() throws RecognitionException {
		QLParser.addExpr_return retval = new QLParser.addExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:5: (lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:9: lhs= mulExpr (op= ( Add | Sub ) ^rhs= mulExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_mulExpr_in_addExpr647);
			lhs=mulExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:21: (op= ( Add | Sub ) ^rhs= mulExpr )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==Add||LA11_0==Sub) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:134:23: op= ( Add | Sub ) ^rhs= mulExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Add||input.LA(1)==Sub ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mulExpr_in_addExpr665);
					rhs=mulExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop11;
				}
			}

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
		return retval;
	}
	// $ANTLR end "addExpr"


	public static class relExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:137:1: relExpr : lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* ;
	public final QLParser.relExpr_return relExpr() throws RecognitionException {
		QLParser.relExpr_return retval = new QLParser.relExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token op=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object op_tree=null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:138:5: (lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:138:9: lhs= addExpr (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_addExpr_in_relExpr692);
			lhs=addExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:138:22: (op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Equ||(LA12_0 >= GT && LA12_0 <= GTEqu)||(LA12_0 >= LT && LA12_0 <= LTEqu)||LA12_0==NotEqu) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:138:24: op= ( LT | LTEqu | GT | GTEqu | Equ | NotEqu ) ^rhs= addExpr
					{
					op=input.LT(1);
					op=input.LT(1);
					if ( input.LA(1)==Equ||(input.LA(1) >= GT && input.LA(1) <= GTEqu)||(input.LA(1) >= LT && input.LA(1) <= LTEqu)||input.LA(1)==NotEqu ) {
						input.consume();
						root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(op), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_addExpr_in_relExpr721);
					rhs=addExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

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
		return retval;
	}
	// $ANTLR end "relExpr"


	public static class andExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "andExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:141:1: andExpr : lhs= relExpr ( And ^rhs= relExpr )* ;
	public final QLParser.andExpr_return andExpr() throws RecognitionException {
		QLParser.andExpr_return retval = new QLParser.andExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token And46=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object And46_tree=null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:5: (lhs= relExpr ( And ^rhs= relExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:9: lhs= relExpr ( And ^rhs= relExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relExpr_in_andExpr750);
			lhs=relExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:21: ( And ^rhs= relExpr )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==And) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:142:23: And ^rhs= relExpr
					{
					And46=(Token)match(input,And,FOLLOW_And_in_andExpr754); 
					And46_tree = (Object)adaptor.create(And46);
					root_0 = (Object)adaptor.becomeRoot(And46_tree, root_0);

					pushFollow(FOLLOW_relExpr_in_andExpr759);
					rhs=relExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop13;
				}
			}

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
		return retval;
	}
	// $ANTLR end "andExpr"


	public static class orExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "orExpr"
	// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:146:1: orExpr : lhs= andExpr ( Or ^rhs= andExpr )* ;
	public final QLParser.orExpr_return orExpr() throws RecognitionException {
		QLParser.orExpr_return retval = new QLParser.orExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Or47=null;
		ParserRuleReturnScope lhs =null;
		ParserRuleReturnScope rhs =null;

		Object Or47_tree=null;

		try {
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:5: (lhs= andExpr ( Or ^rhs= andExpr )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:8: lhs= andExpr ( Or ^rhs= andExpr )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_andExpr_in_orExpr790);
			lhs=andExpr();
			state._fsp--;

			adaptor.addChild(root_0, lhs.getTree());

			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:20: ( Or ^rhs= andExpr )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==Or) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:147:22: Or ^rhs= andExpr
					{
					Or47=(Token)match(input,Or,FOLLOW_Or_in_orExpr794); 
					Or47_tree = (Object)adaptor.create(Or47);
					root_0 = (Object)adaptor.becomeRoot(Or47_tree, root_0);

					pushFollow(FOLLOW_andExpr_in_orExpr799);
					rhs=andExpr();
					state._fsp--;

					adaptor.addChild(root_0, rhs.getTree());

					}
					break;

				default :
					break loop14;
				}
			}

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
		return retval;
	}
	// $ANTLR end "orExpr"

	// Delegated rules



	public static final BitSet FOLLOW_FormStart_in_parse113 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_FormId_in_parse115 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Lbr_in_parse117 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_blockItem_in_parse119 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_Rbr_in_parse122 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_parse124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_questionAssignment_in_blockItem148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantAssignment_in_blockItem152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifBlock_in_blockItem156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_questionAssignment172 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_questionAssignment175 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_String_in_questionAssignment178 = new BitSet(new long[]{0x0000000100001000L});
	public static final BitSet FOLLOW_identType_in_questionAssignment180 = new BitSet(new long[]{0x0000008114001002L});
	public static final BitSet FOLLOW_atom_in_questionAssignment183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_constantAssignment236 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_Indicator_in_constantAssignment239 = new BitSet(new long[]{0x0000000100001000L});
	public static final BitSet FOLLOW_identType_in_constantAssignment241 = new BitSet(new long[]{0x0000008114001000L});
	public static final BitSet FOLLOW_atom_in_constantAssignment243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_identType290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_identType303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifCondition_in_ifBlock325 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_ifStatementBlock_in_ifBlock328 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_elseBlock_in_ifBlock332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_ifCondition376 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_RoundLbr_in_ifCondition378 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_orExpr_in_ifCondition380 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_ifCondition383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Lbr_in_ifStatementBlock401 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_blockItem_in_ifStatementBlock404 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_Rbr_in_ifStatementBlock407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_elseBlock425 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Lbr_in_elseBlock427 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_blockItem_in_elseBlock429 = new BitSet(new long[]{0x000000400C000000L});
	public static final BitSet FOLLOW_Rbr_in_elseBlock432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Int_in_atom461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Ident_in_atom469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BooleanType_in_atom476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MoneyType_in_atom482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RoundLbr_in_atom492 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_orExpr_in_atom498 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RoundRbr_in_atom501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Sub_in_unExpr522 = new BitSet(new long[]{0x0000008114001000L});
	public static final BitSet FOLLOW_atom_in_unExpr524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Not_in_unExpr542 = new BitSet(new long[]{0x0000008114001000L});
	public static final BitSet FOLLOW_atom_in_unExpr544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_unExpr561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr595 = new BitSet(new long[]{0x0000000200004002L});
	public static final BitSet FOLLOW_set_in_mulExpr602 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_unExpr_in_mulExpr615 = new BitSet(new long[]{0x0000000200004002L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr647 = new BitSet(new long[]{0x0000040000000082L});
	public static final BitSet FOLLOW_set_in_addExpr653 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_mulExpr_in_addExpr665 = new BitSet(new long[]{0x0000040000000082L});
	public static final BitSet FOLLOW_addExpr_in_relExpr692 = new BitSet(new long[]{0x0000000860190002L});
	public static final BitSet FOLLOW_set_in_relExpr699 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_addExpr_in_relExpr721 = new BitSet(new long[]{0x0000000860190002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr750 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_And_in_andExpr754 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_relExpr_in_andExpr759 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_andExpr_in_orExpr790 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_Or_in_orExpr794 = new BitSet(new long[]{0x0000048514001000L});
	public static final BitSet FOLLOW_andExpr_in_orExpr799 = new BitSet(new long[]{0x0000001000000002L});
}
