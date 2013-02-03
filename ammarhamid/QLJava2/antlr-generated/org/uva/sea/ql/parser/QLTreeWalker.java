// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QLTreeWalker.g 2013-01-28 12:18:16

	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.ast.Node;
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


    public static class walk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "walk"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:37:1: walk : form ;
    public final QLTreeWalker.walk_return walk() throws RecognitionException {
        QLTreeWalker.walk_return retval = new QLTreeWalker.walk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.form_return form1 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:38:5: ( form )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:38:9: form
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_form_in_walk58);
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
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:41:1: form : ^( FORM Identifier ^( BLOCK block ) ) ;
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
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:2: ( ^( FORM Identifier ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:4: ^( FORM Identifier ^( BLOCK block ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FORM2=(CommonTree)match(input,FORM,FOLLOW_FORM_in_form79); 
            FORM2_tree = (CommonTree)adaptor.dupNode(FORM2);


            root_1 = (CommonTree)adaptor.becomeRoot(FORM2_tree, root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            Identifier3=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_form81); 
            Identifier3_tree = (CommonTree)adaptor.dupNode(Identifier3);


            adaptor.addChild(root_1, Identifier3_tree);


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BLOCK4=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_form84); 
            BLOCK4_tree = (CommonTree)adaptor.dupNode(BLOCK4);


            root_2 = (CommonTree)adaptor.becomeRoot(BLOCK4_tree, root_2);


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                _last = (CommonTree)input.LT(1);
                pushFollow(FOLLOW_block_in_form86);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:45:1: block : ( statement )* ;
    public final QLTreeWalker.block_return block() throws RecognitionException {
        QLTreeWalker.block_return retval = new QLTreeWalker.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.statement_return statement6 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:5: ( ( statement )* )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:9: ( statement )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:9: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ASSIGNMENT||LA1_0==IF) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:9: statement
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statement_in_block104);
            	    statement6=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement6.getTree());


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "block"


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:49:1: statement : ( ifStatement | assignmentStatement );
    public final QLTreeWalker.statement_return statement() throws RecognitionException {
        QLTreeWalker.statement_return retval = new QLTreeWalker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.ifStatement_return ifStatement7 =null;

        QLTreeWalker.assignmentStatement_return assignmentStatement8 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:50:2: ( ifStatement | assignmentStatement )
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:50:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statement119);
                    ifStatement7=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement7.getTree());


                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:51:5: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assignmentStatement_in_statement125);
                    assignmentStatement8=assignmentStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentStatement8.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:54:1: ifStatement : ^( IF ( ^( EXPRESSION expression ^( BLOCK block ) ) )+ ( ^( EXPRESSION ^( BLOCK block ) ) ) ) ;
    public final QLTreeWalker.ifStatement_return ifStatement() throws RecognitionException {
        QLTreeWalker.ifStatement_return retval = new QLTreeWalker.ifStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF9=null;
        CommonTree EXPRESSION10=null;
        CommonTree BLOCK12=null;
        CommonTree EXPRESSION14=null;
        CommonTree BLOCK15=null;
        QLTreeWalker.expression_return expression11 =null;

        QLTreeWalker.block_return block13 =null;

        QLTreeWalker.block_return block16 =null;


        CommonTree IF9_tree=null;
        CommonTree EXPRESSION10_tree=null;
        CommonTree BLOCK12_tree=null;
        CommonTree EXPRESSION14_tree=null;
        CommonTree BLOCK15_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:55:2: ( ^( IF ( ^( EXPRESSION expression ^( BLOCK block ) ) )+ ( ^( EXPRESSION ^( BLOCK block ) ) ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:55:6: ^( IF ( ^( EXPRESSION expression ^( BLOCK block ) ) )+ ( ^( EXPRESSION ^( BLOCK block ) ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IF9=(CommonTree)match(input,IF,FOLLOW_IF_in_ifStatement139); 
            IF9_tree = (CommonTree)adaptor.dupNode(IF9);


            root_1 = (CommonTree)adaptor.becomeRoot(IF9_tree, root_1);


            match(input, Token.DOWN, null); 
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:56:10: ( ^( EXPRESSION expression ^( BLOCK block ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==EXPRESSION) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==DOWN) ) {
                        int LA3_2 = input.LA(3);

                        if ( (LA3_2==Boolean||(LA3_2 >= Identifier && LA3_2 <= Integer)||LA3_2==Money||(LA3_2 >= NEGATION && LA3_2 <= NOT)||LA3_2==StringLiteral||(LA3_2 >= 23 && LA3_2 <= 24)||(LA3_2 >= 27 && LA3_2 <= 30)||(LA3_2 >= 32 && LA3_2 <= 36)||LA3_2==45) ) {
                            alt3=1;
                        }


                    }


                }


                switch (alt3) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:56:11: ^( EXPRESSION expression ^( BLOCK block ) )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    EXPRESSION10=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement152); 
            	    EXPRESSION10_tree = (CommonTree)adaptor.dupNode(EXPRESSION10);


            	    root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION10_tree, root_2);


            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_ifStatement154);
            	    expression11=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_2, expression11.getTree());


            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_3 = _last;
            	    CommonTree _first_3 = null;
            	    CommonTree root_3 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    BLOCK12=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_ifStatement157); 
            	    BLOCK12_tree = (CommonTree)adaptor.dupNode(BLOCK12);


            	    root_3 = (CommonTree)adaptor.becomeRoot(BLOCK12_tree, root_3);


            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); 
            	        _last = (CommonTree)input.LT(1);
            	        pushFollow(FOLLOW_block_in_ifStatement159);
            	        block13=block();

            	        state._fsp--;

            	        adaptor.addChild(root_3, block13.getTree());


            	        match(input, Token.UP, null); 
            	    }
            	    adaptor.addChild(root_2, root_3);
            	    _last = _save_last_3;
            	    }


            	    match(input, Token.UP, null); 
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


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


            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:57:10: ( ^( EXPRESSION ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:57:11: ^( EXPRESSION ^( BLOCK block ) )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXPRESSION14=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement176); 
            EXPRESSION14_tree = (CommonTree)adaptor.dupNode(EXPRESSION14);


            root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION14_tree, root_2);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BLOCK15=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_ifStatement179); 
            BLOCK15_tree = (CommonTree)adaptor.dupNode(BLOCK15);


            root_3 = (CommonTree)adaptor.becomeRoot(BLOCK15_tree, root_3);


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                _last = (CommonTree)input.LT(1);
                pushFollow(FOLLOW_block_in_ifStatement181);
                block16=block();

                state._fsp--;

                adaptor.addChild(root_3, block16.getTree());


                match(input, Token.UP, null); 
            }
            adaptor.addChild(root_2, root_3);
            _last = _save_last_3;
            }


            match(input, Token.UP, null); 
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentStatement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:61:1: assignmentStatement : ^( ASSIGNMENT Identifier type ) ;
    public final QLTreeWalker.assignmentStatement_return assignmentStatement() throws RecognitionException {
        QLTreeWalker.assignmentStatement_return retval = new QLTreeWalker.assignmentStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSIGNMENT17=null;
        CommonTree Identifier18=null;
        QLTreeWalker.type_return type19 =null;


        CommonTree ASSIGNMENT17_tree=null;
        CommonTree Identifier18_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:62:2: ( ^( ASSIGNMENT Identifier type ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:62:4: ^( ASSIGNMENT Identifier type )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSIGNMENT17=(CommonTree)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignmentStatement204); 
            ASSIGNMENT17_tree = (CommonTree)adaptor.dupNode(ASSIGNMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSIGNMENT17_tree, root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            Identifier18=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignmentStatement206); 
            Identifier18_tree = (CommonTree)adaptor.dupNode(Identifier18);


            adaptor.addChild(root_1, Identifier18_tree);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_type_in_assignmentStatement208);
            type19=type();

            state._fsp--;

            adaptor.addChild(root_1, type19.getTree());


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
    // $ANTLR end "assignmentStatement"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:65:1: type : ( 'boolean' | 'integer' | 'string' | 'money' );
    public final QLTreeWalker.type_return type() throws RecognitionException {
        QLTreeWalker.type_return retval = new QLTreeWalker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set20=null;

        CommonTree set20_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:66:2: ( 'boolean' | 'integer' | 'string' | 'money' )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set20=(CommonTree)input.LT(1);

            if ( input.LA(1)==37||(input.LA(1) >= 41 && input.LA(1) <= 43) ) {
                input.consume();
                set20_tree = (CommonTree)adaptor.dupNode(set20);


                adaptor.addChild(root_0, set20_tree);

                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "type"


    public static class expression_return extends TreeRuleReturnScope {
        public ExprNode node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:72:1: expression returns [ExprNode node] : ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier );
    public final QLTreeWalker.expression_return expression() throws RecognitionException {
        QLTreeWalker.expression_return retval = new QLTreeWalker.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal21=null;
        CommonTree string_literal22=null;
        CommonTree string_literal23=null;
        CommonTree string_literal24=null;
        CommonTree char_literal25=null;
        CommonTree string_literal26=null;
        CommonTree string_literal27=null;
        CommonTree char_literal28=null;
        CommonTree char_literal29=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree char_literal32=null;
        CommonTree NOT33=null;
        CommonTree NEGATION34=null;
        CommonTree Boolean35=null;
        CommonTree Integer36=null;
        CommonTree Money37=null;
        CommonTree StringLiteral38=null;
        CommonTree Identifier39=null;
        QLTreeWalker.expression_return lhs =null;

        QLTreeWalker.expression_return rhs =null;

        QLTreeWalker.expression_return op =null;


        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree NOT33_tree=null;
        CommonTree NEGATION34_tree=null;
        CommonTree Boolean35_tree=null;
        CommonTree Integer36_tree=null;
        CommonTree Money37_tree=null;
        CommonTree StringLiteral38_tree=null;
        CommonTree Identifier39_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:73:5: ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier )
            int alt4=19;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt4=1;
                }
                break;
            case 45:
                {
                alt4=2;
                }
                break;
            case 34:
                {
                alt4=3;
                }
                break;
            case 23:
                {
                alt4=4;
                }
                break;
            case 32:
                {
                alt4=5;
                }
                break;
            case 33:
                {
                alt4=6;
                }
                break;
            case 36:
                {
                alt4=7;
                }
                break;
            case 35:
                {
                alt4=8;
                }
                break;
            case 28:
                {
                alt4=9;
                }
                break;
            case 29:
                {
                alt4=10;
                }
                break;
            case 27:
                {
                alt4=11;
                }
                break;
            case 30:
                {
                alt4=12;
                }
                break;
            case NOT:
                {
                alt4=13;
                }
                break;
            case NEGATION:
                {
                alt4=14;
                }
                break;
            case Boolean:
                {
                alt4=15;
                }
                break;
            case Integer:
                {
                alt4=16;
                }
                break;
            case Money:
                {
                alt4=17;
                }
                break;
            case StringLiteral:
                {
                alt4=18;
                }
                break;
            case Identifier:
                {
                alt4=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:73:9: ^( '&&' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal21=(CommonTree)match(input,24,FOLLOW_24_in_expression259); 
                    string_literal21_tree = (CommonTree)adaptor.dupNode(string_literal21);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal21_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression263);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression267);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:74:9: ^( '||' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal22=(CommonTree)match(input,45,FOLLOW_45_in_expression281); 
                    string_literal22_tree = (CommonTree)adaptor.dupNode(string_literal22);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression285);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression289);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:75:9: ^( '==' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal23=(CommonTree)match(input,34,FOLLOW_34_in_expression303); 
                    string_literal23_tree = (CommonTree)adaptor.dupNode(string_literal23);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal23_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression307);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression311);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:76:9: ^( '!=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal24=(CommonTree)match(input,23,FOLLOW_23_in_expression325); 
                    string_literal24_tree = (CommonTree)adaptor.dupNode(string_literal24);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal24_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression329);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression333);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:77:9: ^( '<' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal25=(CommonTree)match(input,32,FOLLOW_32_in_expression347); 
                    char_literal25_tree = (CommonTree)adaptor.dupNode(char_literal25);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal25_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression351);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression355);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:78:9: ^( '<=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal26=(CommonTree)match(input,33,FOLLOW_33_in_expression369); 
                    string_literal26_tree = (CommonTree)adaptor.dupNode(string_literal26);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal26_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression373);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression377);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:79:9: ^( '>=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal27=(CommonTree)match(input,36,FOLLOW_36_in_expression391); 
                    string_literal27_tree = (CommonTree)adaptor.dupNode(string_literal27);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal27_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression395);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression399);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:80:9: ^( '>' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal28=(CommonTree)match(input,35,FOLLOW_35_in_expression413); 
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal28_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression417);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression421);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:81:9: ^( '+' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,28,FOLLOW_28_in_expression435); 
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal29_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression439);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression443);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:82:9: ^( '-' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,29,FOLLOW_29_in_expression457); 
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal30_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression461);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression465);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:83:9: ^( '*' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,27,FOLLOW_27_in_expression479); 
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal31_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression483);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression487);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:84:9: ^( '/' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal32=(CommonTree)match(input,30,FOLLOW_30_in_expression501); 
                    char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal32_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression505);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression509);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:85:9: ^( NOT op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT33=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression523); 
                    NOT33_tree = (CommonTree)adaptor.dupNode(NOT33);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT33_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression527);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:86:9: ^( NEGATION op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEGATION34=(CommonTree)match(input,NEGATION,FOLLOW_NEGATION_in_expression541); 
                    NEGATION34_tree = (CommonTree)adaptor.dupNode(NEGATION34);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEGATION34_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression545);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:87:9: Boolean
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Boolean35=(CommonTree)match(input,Boolean,FOLLOW_Boolean_in_expression558); 
                    Boolean35_tree = (CommonTree)adaptor.dupNode(Boolean35);


                    adaptor.addChild(root_0, Boolean35_tree);


                    retval.node = new BooleanNode((Boolean35!=null?Boolean35.getText():null));

                    }
                    break;
                case 16 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:88:9: Integer
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Integer36=(CommonTree)match(input,Integer,FOLLOW_Integer_in_expression571); 
                    Integer36_tree = (CommonTree)adaptor.dupNode(Integer36);


                    adaptor.addChild(root_0, Integer36_tree);


                    retval.node = new IntegerNode((Integer36!=null?Integer36.getText():null));

                    }
                    break;
                case 17 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:89:9: Money
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Money37=(CommonTree)match(input,Money,FOLLOW_Money_in_expression583); 
                    Money37_tree = (CommonTree)adaptor.dupNode(Money37);


                    adaptor.addChild(root_0, Money37_tree);


                    retval.node = new MoneyNode((Money37!=null?Money37.getText():null));

                    }
                    break;
                case 18 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:90:9: StringLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    StringLiteral38=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_expression595); 
                    StringLiteral38_tree = (CommonTree)adaptor.dupNode(StringLiteral38);


                    adaptor.addChild(root_0, StringLiteral38_tree);


                    retval.node = new StringNode((StringLiteral38!=null?StringLiteral38.getText():null));

                    }
                    break;
                case 19 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:91:9: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Identifier39=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_expression607); 
                    Identifier39_tree = (CommonTree)adaptor.dupNode(Identifier39);


                    adaptor.addChild(root_0, Identifier39_tree);


                    retval.node = new IdentifierNode((Identifier39!=null?Identifier39.getText():null));

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


 

    public static final BitSet FOLLOW_form_in_walk58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORM_in_form79 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_form81 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BLOCK_in_form84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_form86 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_statement_in_block104 = new BitSet(new long[]{0x0000000000000812L});
    public static final BitSet FOLLOW_ifStatement_in_statement119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statement125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement139 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_BLOCK_in_ifStatement157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ifStatement159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCK_in_ifStatement179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ifStatement181 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_assignmentStatement204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_assignmentStatement206 = new BitSet(new long[]{0x00000E2000000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_24_in_expression259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression263 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expression281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression285 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_expression303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression307 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_23_in_expression325 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression329 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression333 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_expression347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression351 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_expression369 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression373 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression377 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_36_in_expression391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression395 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_expression413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression417 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression421 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_expression435 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression439 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_expression457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression461 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression465 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_expression479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression483 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression487 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_30_in_expression501 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression505 = new BitSet(new long[]{0x0000201F7996B040L});
    public static final BitSet FOLLOW_expression_in_expression509 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression527 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATION_in_expression541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Boolean_in_expression558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_expression571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_expression583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_expression595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_expression607 = new BitSet(new long[]{0x0000000000000002L});

}