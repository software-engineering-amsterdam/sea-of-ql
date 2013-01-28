// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QLTreeWalker.g 2013-01-28 14:59:06

	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.ast.Node;
	import org.uva.sea.ql.ast.IfNode;
	import org.uva.sea.ql.ast.BlockNode;
	import org.uva.sea.ql.ast.AssignmentNode;
	import org.uva.sea.ql.ast.VariableScope;
	import org.uva.sea.ql.ast.expression.ExprNode;
	import org.uva.sea.ql.ast.expression.impl.AddNode;
	import org.uva.sea.ql.ast.expression.impl.AndNode;
	import org.uva.sea.ql.ast.expression.impl.OrNode;
	import org.uva.sea.ql.ast.expression.impl.EqualNode;
	import org.uva.sea.ql.ast.expression.impl.NotEqualNode;
	import org.uva.sea.ql.ast.expression.impl.LessThanNode;
	import org.uva.sea.ql.ast.expression.impl.LessEqualNode;
	import org.uva.sea.ql.ast.expression.impl.GreaterThanNode;
	import org.uva.sea.ql.ast.expression.impl.GreaterEqualNode;
	import org.uva.sea.ql.ast.expression.impl.MultiplyNode;
	import org.uva.sea.ql.ast.expression.impl.DivideNode;
	import org.uva.sea.ql.ast.expression.impl.SubtractNode;
	import org.uva.sea.ql.ast.expression.impl.NotNode;
	import org.uva.sea.ql.ast.expression.impl.NegateNode;
	import org.uva.sea.ql.ast.expression.impl.IdentifierNode;
	import org.uva.sea.ql.ast.value.ValueNode;
	import org.uva.sea.ql.ast.value.impl.IntegerNode;
	import org.uva.sea.ql.ast.value.impl.BooleanNode;
	import org.uva.sea.ql.ast.value.impl.MoneyNode;
	import org.uva.sea.ql.ast.value.impl.StringNode;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "BLOCK", "Boolean", "Comment", "Digit", "EXPRESSION", "FORM", "IF", "Identifier", "Integer", "Letter", "Money", "MultilineComment", "NEGATION", "NOT", "STATEMENT", "StringLiteral", "Whitespace", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
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
    public static final int ASSIGNMENT=4;
    public static final int BLOCK=5;
    public static final int Boolean=6;
    public static final int Comment=7;
    public static final int Digit=8;
    public static final int EXPRESSION=9;
    public static final int FORM=10;
    public static final int IF=11;
    public static final int Identifier=12;
    public static final int Integer=13;
    public static final int Letter=14;
    public static final int Money=15;
    public static final int MultilineComment=16;
    public static final int NEGATION=17;
    public static final int NOT=18;
    public static final int STATEMENT=19;
    public static final int StringLiteral=20;
    public static final int Whitespace=21;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public QLTreeWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return QLTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "src/main/org/uva/sea/ql/parser/QLTreeWalker.g"; }


        VariableScope currentScope = new VariableScope();


    public static class walk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "walk"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:1: walk : form ;
    public final QLTreeWalker.walk_return walk() throws RecognitionException {
        QLTreeWalker.walk_return retval = new QLTreeWalker.walk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.form_return form1 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:47:5: ( form )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:47:9: form
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_form_in_walk64);
            form1=form();

            state._fsp--;

            adaptor.addChild(root_0, form1.getTree());


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "walk"


    public static class form_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "form"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:50:1: form : ^( FORM Identifier ^( BLOCK block ) ) ;
    public final QLTreeWalker.form_return form() throws RecognitionException {
        QLTreeWalker.form_return retval = new QLTreeWalker.form_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORM2=null;
        CommonTree Identifier3=null;
        CommonTree BLOCK4=null;
        QLTreeWalker.block_return block5 =null;


        CommonTree FORM2_tree=null;
        CommonTree Identifier3_tree=null;
        CommonTree BLOCK4_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:51:2: ( ^( FORM Identifier ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:51:4: ^( FORM Identifier ^( BLOCK block ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FORM2=(CommonTree)match(input,FORM,FOLLOW_FORM_in_form85); 
            FORM2_tree = (CommonTree)adaptor.dupNode(FORM2);


            root_1 = (CommonTree)adaptor.becomeRoot(FORM2_tree, root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            Identifier3=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_form87); 
            Identifier3_tree = (CommonTree)adaptor.dupNode(Identifier3);


            adaptor.addChild(root_1, Identifier3_tree);


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BLOCK4=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_form90); 
            BLOCK4_tree = (CommonTree)adaptor.dupNode(BLOCK4);


            root_2 = (CommonTree)adaptor.becomeRoot(BLOCK4_tree, root_2);


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                _last = (CommonTree)input.LT(1);
                pushFollow(FOLLOW_block_in_form92);
                block5=block();

                state._fsp--;

                adaptor.addChild(root_2, block5.getTree());


                match(input, Token.UP, null); 
            }
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "form"


    public static class block_return extends TreeRuleReturnScope {
        public Node node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:54:1: block returns [Node node] : ( statement )* ;
    public final QLTreeWalker.block_return block() throws RecognitionException {
        QLTreeWalker.block_return retval = new QLTreeWalker.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.statement_return statement6 =null;




            final BlockNode blockNode = new BlockNode();
            retval.node = blockNode;
            final VariableScope scope = new VariableScope(this.currentScope);
            currentScope = scope;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:66:5: ( ( statement )* )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:66:9: ( statement )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:66:9: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ASSIGNMENT||LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:66:10: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block125);
            	    statement6=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement6.getTree());


            	     blockNode.addStatement((statement6!=null?statement6.node:null)); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


                currentScope = currentScope.getParent();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"


    public static class statement_return extends TreeRuleReturnScope {
        public Node node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:69:1: statement returns [Node node] : ( ifStatement | assignmentStatement );
    public final QLTreeWalker.statement_return statement() throws RecognitionException {
        QLTreeWalker.statement_return retval = new QLTreeWalker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.ifStatement_return ifStatement7 =null;

        QLTreeWalker.assignmentStatement_return assignmentStatement8 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:70:2: ( ifStatement | assignmentStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IF) ) {
                alt2=1;
            }
            else if ( (LA2_0==ASSIGNMENT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:70:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement147);
                    ifStatement7=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement7.getTree());


                     retval.node = (ifStatement7!=null?ifStatement7.node:null); 

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:71:5: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assignmentStatement_in_statement155);
                    assignmentStatement8=assignmentStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentStatement8.getTree());


                     retval.node = (assignmentStatement8!=null?assignmentStatement8.node:null); 

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class ifStatement_return extends TreeRuleReturnScope {
        public Node node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:74:1: ifStatement returns [Node node] : ^( IF ( ^( EXPRESSION expression ^( BLOCK b1= block ) ) )+ ( ^( EXPRESSION ^( BLOCK b2= block ) ) )? ) ;
    public final QLTreeWalker.ifStatement_return ifStatement() throws RecognitionException {
        QLTreeWalker.ifStatement_return retval = new QLTreeWalker.ifStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF9=null;
        CommonTree EXPRESSION10=null;
        CommonTree BLOCK12=null;
        CommonTree EXPRESSION13=null;
        CommonTree BLOCK14=null;
        QLTreeWalker.block_return b1 =null;

        QLTreeWalker.block_return b2 =null;

        QLTreeWalker.expression_return expression11 =null;


        CommonTree IF9_tree=null;
        CommonTree EXPRESSION10_tree=null;
        CommonTree BLOCK12_tree=null;
        CommonTree EXPRESSION13_tree=null;
        CommonTree BLOCK14_tree=null;


            final IfNode ifNode = new IfNode();
            retval.node = ifNode;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:80:2: ( ^( IF ( ^( EXPRESSION expression ^( BLOCK b1= block ) ) )+ ( ^( EXPRESSION ^( BLOCK b2= block ) ) )? ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:80:6: ^( IF ( ^( EXPRESSION expression ^( BLOCK b1= block ) ) )+ ( ^( EXPRESSION ^( BLOCK b2= block ) ) )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IF9=(CommonTree)match(input,IF,FOLLOW_IF_in_ifStatement180); 
            IF9_tree = (CommonTree)adaptor.dupNode(IF9);


            root_1 = (CommonTree)adaptor.becomeRoot(IF9_tree, root_1);


            match(input, Token.DOWN, null); 
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:81:10: ( ^( EXPRESSION expression ^( BLOCK b1= block ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==EXPRESSION) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==DOWN) ) {
                        int LA3_3 = input.LA(3);

                        if ( (LA3_3==Boolean||(LA3_3 >= Identifier && LA3_3 <= Integer)||LA3_3==Money||(LA3_3 >= NEGATION && LA3_3 <= NOT)||LA3_3==StringLiteral||(LA3_3 >= 23 && LA3_3 <= 24)||(LA3_3 >= 27 && LA3_3 <= 30)||(LA3_3 >= 32 && LA3_3 <= 36)||LA3_3==45) ) {
                            alt3=1;
                        }


                    }


                }


                switch (alt3) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:81:11: ^( EXPRESSION expression ^( BLOCK b1= block ) )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    EXPRESSION10=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement193); 
            	    EXPRESSION10_tree = (CommonTree)adaptor.dupNode(EXPRESSION10);


            	    root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION10_tree, root_2);


            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_ifStatement195);
            	    expression11=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_2, expression11.getTree());


            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_3 = _last;
            	    CommonTree _first_3 = null;
            	    CommonTree root_3 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    BLOCK12=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_ifStatement198); 
            	    BLOCK12_tree = (CommonTree)adaptor.dupNode(BLOCK12);


            	    root_3 = (CommonTree)adaptor.becomeRoot(BLOCK12_tree, root_3);


            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); 
            	        _last = (CommonTree)input.LT(1);
            	        pushFollow(FOLLOW_block_in_ifStatement202);
            	        b1=block();

            	        state._fsp--;

            	        adaptor.addChild(root_3, b1.getTree());


            	        match(input, Token.UP, null); 
            	    }
            	    adaptor.addChild(root_2, root_3);
            	    _last = _save_last_3;
            	    }


            	    match(input, Token.UP, null); 
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	     ifNode.addBranch((expression11!=null?expression11.node:null), (b1!=null?b1.node:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:82:10: ( ^( EXPRESSION ^( BLOCK b2= block ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==EXPRESSION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:82:11: ^( EXPRESSION ^( BLOCK b2= block ) )
                    {
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_2 = _last;
                    CommonTree _first_2 = null;
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPRESSION13=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement221); 
                    EXPRESSION13_tree = (CommonTree)adaptor.dupNode(EXPRESSION13);


                    root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION13_tree, root_2);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_3 = _last;
                    CommonTree _first_3 = null;
                    CommonTree root_3 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BLOCK14=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_ifStatement224); 
                    BLOCK14_tree = (CommonTree)adaptor.dupNode(BLOCK14);


                    root_3 = (CommonTree)adaptor.becomeRoot(BLOCK14_tree, root_3);


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_block_in_ifStatement228);
                        b2=block();

                        state._fsp--;

                        adaptor.addChild(root_3, b2.getTree());


                        match(input, Token.UP, null); 
                    }
                    adaptor.addChild(root_2, root_3);
                    _last = _save_last_3;
                    }


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_1, root_2);
                    _last = _save_last_2;
                    }


                     ifNode.addBranch(new BooleanNode("true"), (b2!=null?b2.node:null)); 

                    }
                    break;

            }


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class assignmentStatement_return extends TreeRuleReturnScope {
        public Node node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentStatement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:86:1: assignmentStatement returns [Node node] : ^( ASSIGNMENT Identifier type ) ;
    public final QLTreeWalker.assignmentStatement_return assignmentStatement() throws RecognitionException {
        QLTreeWalker.assignmentStatement_return retval = new QLTreeWalker.assignmentStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSIGNMENT15=null;
        CommonTree Identifier16=null;
        QLTreeWalker.type_return type17 =null;


        CommonTree ASSIGNMENT15_tree=null;
        CommonTree Identifier16_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:87:2: ( ^( ASSIGNMENT Identifier type ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:87:4: ^( ASSIGNMENT Identifier type )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSIGNMENT15=(CommonTree)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignmentStatement258); 
            ASSIGNMENT15_tree = (CommonTree)adaptor.dupNode(ASSIGNMENT15);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSIGNMENT15_tree, root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            Identifier16=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignmentStatement260); 
            Identifier16_tree = (CommonTree)adaptor.dupNode(Identifier16);


            adaptor.addChild(root_1, Identifier16_tree);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_type_in_assignmentStatement262);
            type17=type();

            state._fsp--;

            adaptor.addChild(root_1, type17.getTree());


            match(input, Token.UP, null); 
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


             retval.node = new AssignmentNode((Identifier16!=null?Identifier16.getText():null), (type17!=null?type17.node:null), currentScope); 

            }

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignmentStatement"


    public static class type_return extends TreeRuleReturnScope {
        public Node node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:90:1: type returns [Node node] : ( 'boolean' | 'integer' | 'string' | 'money' );
    public final QLTreeWalker.type_return type() throws RecognitionException {
        QLTreeWalker.type_return retval = new QLTreeWalker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal18=null;
        CommonTree string_literal19=null;
        CommonTree string_literal20=null;
        CommonTree string_literal21=null;

        CommonTree string_literal18_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree string_literal21_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:92:2: ( 'boolean' | 'integer' | 'string' | 'money' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt5=1;
                }
                break;
            case 41:
                {
                alt5=2;
                }
                break;
            case 43:
                {
                alt5=3;
                }
                break;
            case 42:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:92:4: 'boolean'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    string_literal18=(CommonTree)match(input,37,FOLLOW_37_in_type281); 
                    string_literal18_tree = (CommonTree)adaptor.dupNode(string_literal18);


                    adaptor.addChild(root_0, string_literal18_tree);


                    retval.node = new BooleanNode("false"); 

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:93:5: 'integer'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    string_literal19=(CommonTree)match(input,41,FOLLOW_41_in_type289); 
                    string_literal19_tree = (CommonTree)adaptor.dupNode(string_literal19);


                    adaptor.addChild(root_0, string_literal19_tree);


                    retval.node = new IntegerNode(0); 

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:94:5: 'string'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    string_literal20=(CommonTree)match(input,43,FOLLOW_43_in_type297); 
                    string_literal20_tree = (CommonTree)adaptor.dupNode(string_literal20);


                    adaptor.addChild(root_0, string_literal20_tree);


                    retval.node = new StringNode("");

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:95:5: 'money'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    string_literal21=(CommonTree)match(input,42,FOLLOW_42_in_type305); 
                    string_literal21_tree = (CommonTree)adaptor.dupNode(string_literal21);


                    adaptor.addChild(root_0, string_literal21_tree);


                    retval.node = new MoneyNode("0");

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class expression_return extends TreeRuleReturnScope {
        public ExprNode node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:98:1: expression returns [ExprNode node] : ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier );
    public final QLTreeWalker.expression_return expression() throws RecognitionException {
        QLTreeWalker.expression_return retval = new QLTreeWalker.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal22=null;
        CommonTree string_literal23=null;
        CommonTree string_literal24=null;
        CommonTree string_literal25=null;
        CommonTree char_literal26=null;
        CommonTree string_literal27=null;
        CommonTree string_literal28=null;
        CommonTree char_literal29=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree char_literal32=null;
        CommonTree char_literal33=null;
        CommonTree NOT34=null;
        CommonTree NEGATION35=null;
        CommonTree Boolean36=null;
        CommonTree Integer37=null;
        CommonTree Money38=null;
        CommonTree StringLiteral39=null;
        CommonTree Identifier40=null;
        QLTreeWalker.expression_return lhs =null;

        QLTreeWalker.expression_return rhs =null;

        QLTreeWalker.expression_return op =null;


        CommonTree string_literal22_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree string_literal25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree NOT34_tree=null;
        CommonTree NEGATION35_tree=null;
        CommonTree Boolean36_tree=null;
        CommonTree Integer37_tree=null;
        CommonTree Money38_tree=null;
        CommonTree StringLiteral39_tree=null;
        CommonTree Identifier40_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:99:5: ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier )
            int alt6=19;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt6=1;
                }
                break;
            case 45:
                {
                alt6=2;
                }
                break;
            case 34:
                {
                alt6=3;
                }
                break;
            case 23:
                {
                alt6=4;
                }
                break;
            case 32:
                {
                alt6=5;
                }
                break;
            case 33:
                {
                alt6=6;
                }
                break;
            case 36:
                {
                alt6=7;
                }
                break;
            case 35:
                {
                alt6=8;
                }
                break;
            case 28:
                {
                alt6=9;
                }
                break;
            case 29:
                {
                alt6=10;
                }
                break;
            case 27:
                {
                alt6=11;
                }
                break;
            case 30:
                {
                alt6=12;
                }
                break;
            case NOT:
                {
                alt6=13;
                }
                break;
            case NEGATION:
                {
                alt6=14;
                }
                break;
            case Boolean:
                {
                alt6=15;
                }
                break;
            case Integer:
                {
                alt6=16;
                }
                break;
            case Money:
                {
                alt6=17;
                }
                break;
            case StringLiteral:
                {
                alt6=18;
                }
                break;
            case Identifier:
                {
                alt6=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:99:9: ^( '&&' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal22=(CommonTree)match(input,24,FOLLOW_24_in_expression328); 
                    string_literal22_tree = (CommonTree)adaptor.dupNode(string_literal22);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression332);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression336);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new AndNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:100:9: ^( '||' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal23=(CommonTree)match(input,45,FOLLOW_45_in_expression350); 
                    string_literal23_tree = (CommonTree)adaptor.dupNode(string_literal23);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal23_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression354);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression358);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new OrNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:101:9: ^( '==' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal24=(CommonTree)match(input,34,FOLLOW_34_in_expression372); 
                    string_literal24_tree = (CommonTree)adaptor.dupNode(string_literal24);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal24_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression376);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression380);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new EqualNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:102:9: ^( '!=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal25=(CommonTree)match(input,23,FOLLOW_23_in_expression394); 
                    string_literal25_tree = (CommonTree)adaptor.dupNode(string_literal25);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal25_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression398);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression402);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new NotEqualNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 5 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:103:9: ^( '<' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal26=(CommonTree)match(input,32,FOLLOW_32_in_expression416); 
                    char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal26_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression420);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression424);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new LessThanNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 6 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:104:9: ^( '<=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal27=(CommonTree)match(input,33,FOLLOW_33_in_expression438); 
                    string_literal27_tree = (CommonTree)adaptor.dupNode(string_literal27);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression442);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression446);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new LessEqualNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 7 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:105:9: ^( '>=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal28=(CommonTree)match(input,36,FOLLOW_36_in_expression460); 
                    string_literal28_tree = (CommonTree)adaptor.dupNode(string_literal28);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal28_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression464);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression468);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new GreaterEqualNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 8 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:106:9: ^( '>' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,35,FOLLOW_35_in_expression482); 
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal29_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression486);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression490);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new GreaterThanNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 9 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:107:9: ^( '+' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,28,FOLLOW_28_in_expression504); 
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal30_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression508);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression512);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new AddNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 10 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:108:9: ^( '-' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,29,FOLLOW_29_in_expression526); 
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal31_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression530);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression534);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new SubtractNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 11 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:109:9: ^( '*' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,27,FOLLOW_27_in_expression548); 
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal32_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression552);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression556);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new MultiplyNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 12 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:110:9: ^( '/' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal33=(CommonTree)match(input,30,FOLLOW_30_in_expression570); 
                    char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal33_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression574);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression578);
                    rhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, rhs.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new DivideNode((lhs!=null?lhs.node:null), (rhs!=null?rhs.node:null));

                    }
                    break;
                case 13 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:111:9: ^( NOT op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT34=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression592); 
                    NOT34_tree = (CommonTree)adaptor.dupNode(NOT34);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT34_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression596);
                    op=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, op.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new NotNode((op!=null?op.node:null));

                    }
                    break;
                case 14 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:112:9: ^( NEGATION op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEGATION35=(CommonTree)match(input,NEGATION,FOLLOW_NEGATION_in_expression610); 
                    NEGATION35_tree = (CommonTree)adaptor.dupNode(NEGATION35);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEGATION35_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression614);
                    op=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, op.getTree());


                    match(input, Token.UP, null); 
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    retval.node = new NegateNode((op!=null?op.node:null));

                    }
                    break;
                case 15 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:113:9: Boolean
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Boolean36=(CommonTree)match(input,Boolean,FOLLOW_Boolean_in_expression627); 
                    Boolean36_tree = (CommonTree)adaptor.dupNode(Boolean36);


                    adaptor.addChild(root_0, Boolean36_tree);


                    retval.node = new BooleanNode((Boolean36!=null?Boolean36.getText():null));

                    }
                    break;
                case 16 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:114:9: Integer
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Integer37=(CommonTree)match(input,Integer,FOLLOW_Integer_in_expression640); 
                    Integer37_tree = (CommonTree)adaptor.dupNode(Integer37);


                    adaptor.addChild(root_0, Integer37_tree);


                    retval.node = new IntegerNode((Integer37!=null?Integer37.getText():null));

                    }
                    break;
                case 17 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:115:9: Money
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Money38=(CommonTree)match(input,Money,FOLLOW_Money_in_expression652); 
                    Money38_tree = (CommonTree)adaptor.dupNode(Money38);


                    adaptor.addChild(root_0, Money38_tree);


                    retval.node = new MoneyNode((Money38!=null?Money38.getText():null));

                    }
                    break;
                case 18 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:116:9: StringLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    StringLiteral39=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_expression664); 
                    StringLiteral39_tree = (CommonTree)adaptor.dupNode(StringLiteral39);


                    adaptor.addChild(root_0, StringLiteral39_tree);


                    retval.node = new StringNode((StringLiteral39!=null?StringLiteral39.getText():null));

                    }
                    break;
                case 19 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:117:9: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Identifier40=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_expression676); 
                    Identifier40_tree = (CommonTree)adaptor.dupNode(Identifier40);


                    adaptor.addChild(root_0, Identifier40_tree);


                    retval.node = new IdentifierNode((Identifier40!=null?Identifier40.getText():null));

                    }
                    break;

            }
            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_form_in_walk64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORM_in_form85 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_form87 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BLOCK_in_form90 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_form92 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_block125 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ifStatement_in_statement147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement195 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BLOCK_in_ifStatement198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ifStatement202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCK_in_ifStatement224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ifStatement228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_assignmentStatement258 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_assignmentStatement260 = new BitSet(new long[]{0x00000E2000000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement262 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_37_in_type281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_type289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_type297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_type305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_expression328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression332 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expression350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression354 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression358 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_expression372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression376 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression380 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_23_in_expression394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression398 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression402 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_expression416 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression420 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_expression438 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression442 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_36_in_expression460 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression464 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression468 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_expression482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression486 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_expression504 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression508 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression512 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_expression526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression530 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression534 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_expression548 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression552 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression556 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_expression570 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression574 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATION_in_expression610 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression614 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Boolean_in_expression627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_expression640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_expression652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_expression664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_expression676 = new BitSet(new long[]{0x0000000000000002L});

}