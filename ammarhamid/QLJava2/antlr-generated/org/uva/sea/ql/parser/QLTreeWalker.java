// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QLTreeWalker.g 2013-01-21 02:02:11

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT", "Boolean", "Comment", "Digit", "EXPRESSION", "FORM", "IF", "Identifier", "Integer", "Letter", "Money", "MultilineComment", "NEGATION", "NOT", "STATEMENTS", "StringLiteral", "Whitespace", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__21=21;
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
    public static final int ASSIGNMENT=4;
    public static final int Boolean=5;
    public static final int Comment=6;
    public static final int Digit=7;
    public static final int EXPRESSION=8;
    public static final int FORM=9;
    public static final int IF=10;
    public static final int Identifier=11;
    public static final int Integer=12;
    public static final int Letter=13;
    public static final int Money=14;
    public static final int MultilineComment=15;
    public static final int NEGATION=16;
    public static final int NOT=17;
    public static final int STATEMENTS=18;
    public static final int StringLiteral=19;
    public static final int Whitespace=20;

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
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:41:1: form : ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) ) ;
    public final QLTreeWalker.form_return form() throws RecognitionException {
        QLTreeWalker.form_return retval = new QLTreeWalker.form_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FORM2=null;
        CommonTree Identifier3=null;
        CommonTree STATEMENTS4=null;
        QLTreeWalker.statementBlock_return statementBlock5 =null;


        CommonTree FORM2_tree=null;
        CommonTree Identifier3_tree=null;
        CommonTree STATEMENTS4_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:2: ( ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:4: ^( FORM Identifier ^( STATEMENTS ( statementBlock )* ) )
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
            STATEMENTS4=(CommonTree)match(input,STATEMENTS,FOLLOW_STATEMENTS_in_form84); 
            STATEMENTS4_tree = (CommonTree)adaptor.dupNode(STATEMENTS4);


            root_2 = (CommonTree)adaptor.becomeRoot(STATEMENTS4_tree, root_2);


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:35: ( statementBlock )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSIGNMENT||LA1_0==IF) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:42:35: statementBlock
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statementBlock_in_form86);
                	    statementBlock5=statementBlock();

                	    state._fsp--;

                	    adaptor.addChild(root_2, statementBlock5.getTree());


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


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


    public static class statementBlock_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statementBlock"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:45:1: statementBlock : ( ifStatement | assignmentStatement );
    public final QLTreeWalker.statementBlock_return statementBlock() throws RecognitionException {
        QLTreeWalker.statementBlock_return retval = new QLTreeWalker.statementBlock_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        QLTreeWalker.ifStatement_return ifStatement6 =null;

        QLTreeWalker.assignmentStatement_return assignmentStatement7 =null;



        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:2: ( ifStatement | assignmentStatement )
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:46:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_ifStatement_in_statementBlock100);
                    ifStatement6=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement6.getTree());


                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:47:5: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assignmentStatement_in_statementBlock106);
                    assignmentStatement7=assignmentStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentStatement7.getTree());


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
    // $ANTLR end "statementBlock"


    public static class ifStatement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:50:1: ifStatement : ^( IF ( ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )+ ( ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) ) ) ;
    public final QLTreeWalker.ifStatement_return ifStatement() throws RecognitionException {
        QLTreeWalker.ifStatement_return retval = new QLTreeWalker.ifStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IF8=null;
        CommonTree EXPRESSION9=null;
        CommonTree STATEMENTS11=null;
        CommonTree EXPRESSION13=null;
        CommonTree STATEMENTS14=null;
        QLTreeWalker.expression_return expression10 =null;

        QLTreeWalker.statementBlock_return statementBlock12 =null;

        QLTreeWalker.statementBlock_return statementBlock15 =null;


        CommonTree IF8_tree=null;
        CommonTree EXPRESSION9_tree=null;
        CommonTree STATEMENTS11_tree=null;
        CommonTree EXPRESSION13_tree=null;
        CommonTree STATEMENTS14_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:51:2: ( ^( IF ( ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )+ ( ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:51:6: ^( IF ( ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )+ ( ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IF8=(CommonTree)match(input,IF,FOLLOW_IF_in_ifStatement120); 
            IF8_tree = (CommonTree)adaptor.dupNode(IF8);


            root_1 = (CommonTree)adaptor.becomeRoot(IF8_tree, root_1);


            match(input, Token.DOWN, null); 
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:52:10: ( ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==EXPRESSION) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==DOWN) ) {
                        int LA4_2 = input.LA(3);

                        if ( (LA4_2==Boolean||(LA4_2 >= Identifier && LA4_2 <= Integer)||LA4_2==Money||(LA4_2 >= NEGATION && LA4_2 <= NOT)||LA4_2==StringLiteral||(LA4_2 >= 22 && LA4_2 <= 23)||(LA4_2 >= 26 && LA4_2 <= 29)||(LA4_2 >= 31 && LA4_2 <= 35)||LA4_2==44) ) {
                            alt4=1;
                        }


                    }


                }


                switch (alt4) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:52:11: ^( EXPRESSION expression ^( STATEMENTS ( statementBlock )+ ) )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    EXPRESSION9=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement133); 
            	    EXPRESSION9_tree = (CommonTree)adaptor.dupNode(EXPRESSION9);


            	    root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION9_tree, root_2);


            	    match(input, Token.DOWN, null); 
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expression_in_ifStatement135);
            	    expression10=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_2, expression10.getTree());


            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_3 = _last;
            	    CommonTree _first_3 = null;
            	    CommonTree root_3 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    STATEMENTS11=(CommonTree)match(input,STATEMENTS,FOLLOW_STATEMENTS_in_ifStatement138); 
            	    STATEMENTS11_tree = (CommonTree)adaptor.dupNode(STATEMENTS11);


            	    root_3 = (CommonTree)adaptor.becomeRoot(STATEMENTS11_tree, root_3);


            	    match(input, Token.DOWN, null); 
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:52:48: ( statementBlock )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==ASSIGNMENT||LA3_0==IF) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:52:48: statementBlock
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_statementBlock_in_ifStatement140);
            	    	    statementBlock12=statementBlock();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_3, statementBlock12.getTree());


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


            	    match(input, Token.UP, null); 
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:53:10: ( ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:53:11: ^( EXPRESSION ^( STATEMENTS ( statementBlock )+ ) )
            {
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXPRESSION13=(CommonTree)match(input,EXPRESSION,FOLLOW_EXPRESSION_in_ifStatement158); 
            EXPRESSION13_tree = (CommonTree)adaptor.dupNode(EXPRESSION13);


            root_2 = (CommonTree)adaptor.becomeRoot(EXPRESSION13_tree, root_2);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_3 = _last;
            CommonTree _first_3 = null;
            CommonTree root_3 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENTS14=(CommonTree)match(input,STATEMENTS,FOLLOW_STATEMENTS_in_ifStatement161); 
            STATEMENTS14_tree = (CommonTree)adaptor.dupNode(STATEMENTS14);


            root_3 = (CommonTree)adaptor.becomeRoot(STATEMENTS14_tree, root_3);


            match(input, Token.DOWN, null); 
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:53:37: ( statementBlock )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ASSIGNMENT||LA5_0==IF) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:53:37: statementBlock
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_statementBlock_in_ifStatement163);
            	    statementBlock15=statementBlock();

            	    state._fsp--;

            	    adaptor.addChild(root_3, statementBlock15.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input, Token.UP, null); 
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
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:57:1: assignmentStatement : ^( ASSIGNMENT Identifier type ) ;
    public final QLTreeWalker.assignmentStatement_return assignmentStatement() throws RecognitionException {
        QLTreeWalker.assignmentStatement_return retval = new QLTreeWalker.assignmentStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSIGNMENT16=null;
        CommonTree Identifier17=null;
        QLTreeWalker.type_return type18 =null;


        CommonTree ASSIGNMENT16_tree=null;
        CommonTree Identifier17_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:58:2: ( ^( ASSIGNMENT Identifier type ) )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:58:4: ^( ASSIGNMENT Identifier type )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSIGNMENT16=(CommonTree)match(input,ASSIGNMENT,FOLLOW_ASSIGNMENT_in_assignmentStatement187); 
            ASSIGNMENT16_tree = (CommonTree)adaptor.dupNode(ASSIGNMENT16);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSIGNMENT16_tree, root_1);


            match(input, Token.DOWN, null); 
            _last = (CommonTree)input.LT(1);
            Identifier17=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_assignmentStatement189); 
            Identifier17_tree = (CommonTree)adaptor.dupNode(Identifier17);


            adaptor.addChild(root_1, Identifier17_tree);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_type_in_assignmentStatement191);
            type18=type();

            state._fsp--;

            adaptor.addChild(root_1, type18.getTree());


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
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:61:1: type : ( 'boolean' | 'integer' | 'string' | 'money' );
    public final QLTreeWalker.type_return type() throws RecognitionException {
        QLTreeWalker.type_return retval = new QLTreeWalker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set19=null;

        CommonTree set19_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:62:2: ( 'boolean' | 'integer' | 'string' | 'money' )
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set19=(CommonTree)input.LT(1);

            if ( input.LA(1)==36||(input.LA(1) >= 40 && input.LA(1) <= 42) ) {
                input.consume();
                set19_tree = (CommonTree)adaptor.dupNode(set19);


                adaptor.addChild(root_0, set19_tree);

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
    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:68:1: expression returns [ExprNode node] : ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier );
    public final QLTreeWalker.expression_return expression() throws RecognitionException {
        QLTreeWalker.expression_return retval = new QLTreeWalker.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree string_literal20=null;
        CommonTree string_literal21=null;
        CommonTree string_literal22=null;
        CommonTree string_literal23=null;
        CommonTree char_literal24=null;
        CommonTree string_literal25=null;
        CommonTree string_literal26=null;
        CommonTree char_literal27=null;
        CommonTree char_literal28=null;
        CommonTree char_literal29=null;
        CommonTree char_literal30=null;
        CommonTree char_literal31=null;
        CommonTree NOT32=null;
        CommonTree NEGATION33=null;
        CommonTree Boolean34=null;
        CommonTree Integer35=null;
        CommonTree Money36=null;
        CommonTree StringLiteral37=null;
        CommonTree Identifier38=null;
        QLTreeWalker.expression_return lhs =null;

        QLTreeWalker.expression_return rhs =null;

        QLTreeWalker.expression_return op =null;


        CommonTree string_literal20_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree string_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree string_literal25_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree NOT32_tree=null;
        CommonTree NEGATION33_tree=null;
        CommonTree Boolean34_tree=null;
        CommonTree Integer35_tree=null;
        CommonTree Money36_tree=null;
        CommonTree StringLiteral37_tree=null;
        CommonTree Identifier38_tree=null;

        try {
            // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:69:5: ( ^( '&&' lhs= expression rhs= expression ) | ^( '||' lhs= expression rhs= expression ) | ^( '==' lhs= expression rhs= expression ) | ^( '!=' lhs= expression rhs= expression ) | ^( '<' lhs= expression rhs= expression ) | ^( '<=' lhs= expression rhs= expression ) | ^( '>=' lhs= expression rhs= expression ) | ^( '>' lhs= expression rhs= expression ) | ^( '+' lhs= expression rhs= expression ) | ^( '-' lhs= expression rhs= expression ) | ^( '*' lhs= expression rhs= expression ) | ^( '/' lhs= expression rhs= expression ) | ^( NOT op= expression ) | ^( NEGATION op= expression ) | Boolean | Integer | Money | StringLiteral | Identifier )
            int alt6=19;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt6=1;
                }
                break;
            case 44:
                {
                alt6=2;
                }
                break;
            case 33:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            case 31:
                {
                alt6=5;
                }
                break;
            case 32:
                {
                alt6=6;
                }
                break;
            case 35:
                {
                alt6=7;
                }
                break;
            case 34:
                {
                alt6=8;
                }
                break;
            case 27:
                {
                alt6=9;
                }
                break;
            case 28:
                {
                alt6=10;
                }
                break;
            case 26:
                {
                alt6=11;
                }
                break;
            case 29:
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:69:9: ^( '&&' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal20=(CommonTree)match(input,23,FOLLOW_23_in_expression242); 
                    string_literal20_tree = (CommonTree)adaptor.dupNode(string_literal20);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal20_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression246);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression250);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:70:9: ^( '||' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal21=(CommonTree)match(input,44,FOLLOW_44_in_expression264); 
                    string_literal21_tree = (CommonTree)adaptor.dupNode(string_literal21);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal21_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression268);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression272);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:71:9: ^( '==' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal22=(CommonTree)match(input,33,FOLLOW_33_in_expression286); 
                    string_literal22_tree = (CommonTree)adaptor.dupNode(string_literal22);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression290);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression294);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:72:9: ^( '!=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal23=(CommonTree)match(input,22,FOLLOW_22_in_expression308); 
                    string_literal23_tree = (CommonTree)adaptor.dupNode(string_literal23);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal23_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression312);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression316);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:73:9: ^( '<' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal24=(CommonTree)match(input,31,FOLLOW_31_in_expression330); 
                    char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal24_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression334);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression338);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:74:9: ^( '<=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal25=(CommonTree)match(input,32,FOLLOW_32_in_expression352); 
                    string_literal25_tree = (CommonTree)adaptor.dupNode(string_literal25);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal25_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression356);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression360);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:75:9: ^( '>=' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    string_literal26=(CommonTree)match(input,35,FOLLOW_35_in_expression374); 
                    string_literal26_tree = (CommonTree)adaptor.dupNode(string_literal26);


                    root_1 = (CommonTree)adaptor.becomeRoot(string_literal26_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression378);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression382);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:76:9: ^( '>' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal27=(CommonTree)match(input,34,FOLLOW_34_in_expression396); 
                    char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal27_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression400);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression404);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:77:9: ^( '+' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal28=(CommonTree)match(input,27,FOLLOW_27_in_expression418); 
                    char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal28_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression422);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression426);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:78:9: ^( '-' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal29=(CommonTree)match(input,28,FOLLOW_28_in_expression440); 
                    char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal29_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression444);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression448);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:79:9: ^( '*' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal30=(CommonTree)match(input,26,FOLLOW_26_in_expression462); 
                    char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal30_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression466);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression470);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:80:9: ^( '/' lhs= expression rhs= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    char_literal31=(CommonTree)match(input,29,FOLLOW_29_in_expression484); 
                    char_literal31_tree = (CommonTree)adaptor.dupNode(char_literal31);


                    root_1 = (CommonTree)adaptor.becomeRoot(char_literal31_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression488);
                    lhs=expression();

                    state._fsp--;

                    adaptor.addChild(root_1, lhs.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression492);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:81:9: ^( NOT op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT32=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression506); 
                    NOT32_tree = (CommonTree)adaptor.dupNode(NOT32);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT32_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression510);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:82:9: ^( NEGATION op= expression )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEGATION33=(CommonTree)match(input,NEGATION,FOLLOW_NEGATION_in_expression524); 
                    NEGATION33_tree = (CommonTree)adaptor.dupNode(NEGATION33);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEGATION33_tree, root_1);


                    match(input, Token.DOWN, null); 
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expression_in_expression528);
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
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:83:9: Boolean
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Boolean34=(CommonTree)match(input,Boolean,FOLLOW_Boolean_in_expression541); 
                    Boolean34_tree = (CommonTree)adaptor.dupNode(Boolean34);


                    adaptor.addChild(root_0, Boolean34_tree);


                    retval.node = new BooleanNode((Boolean34!=null?Boolean34.getText():null));

                    }
                    break;
                case 16 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:84:9: Integer
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Integer35=(CommonTree)match(input,Integer,FOLLOW_Integer_in_expression554); 
                    Integer35_tree = (CommonTree)adaptor.dupNode(Integer35);


                    adaptor.addChild(root_0, Integer35_tree);


                    retval.node = new IntegerNode((Integer35!=null?Integer35.getText():null));

                    }
                    break;
                case 17 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:85:9: Money
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Money36=(CommonTree)match(input,Money,FOLLOW_Money_in_expression566); 
                    Money36_tree = (CommonTree)adaptor.dupNode(Money36);


                    adaptor.addChild(root_0, Money36_tree);


                    retval.node = new MoneyNode((Money36!=null?Money36.getText():null));

                    }
                    break;
                case 18 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:86:9: StringLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    StringLiteral37=(CommonTree)match(input,StringLiteral,FOLLOW_StringLiteral_in_expression578); 
                    StringLiteral37_tree = (CommonTree)adaptor.dupNode(StringLiteral37);


                    adaptor.addChild(root_0, StringLiteral37_tree);


                    retval.node = new StringNode((StringLiteral37!=null?StringLiteral37.getText():null));

                    }
                    break;
                case 19 :
                    // src/main/org/uva/sea/ql/parser/QLTreeWalker.g:87:9: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    Identifier38=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_expression590); 
                    Identifier38_tree = (CommonTree)adaptor.dupNode(Identifier38);


                    adaptor.addChild(root_0, Identifier38_tree);


                    retval.node = new IdentifierNode((Identifier38!=null?Identifier38.getText():null));

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
    public static final BitSet FOLLOW_Identifier_in_form81 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_STATEMENTS_in_form84 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statementBlock_in_form86 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_ifStatement_in_statementBlock100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statementBlock106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_ifStatement135 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_STATEMENTS_in_ifStatement138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statementBlock_in_ifStatement140 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_EXPRESSION_in_ifStatement158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STATEMENTS_in_ifStatement161 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statementBlock_in_ifStatement163 = new BitSet(new long[]{0x0000000000000418L});
    public static final BitSet FOLLOW_ASSIGNMENT_in_assignmentStatement187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_assignmentStatement189 = new BitSet(new long[]{0x0000071000000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_23_in_expression242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression246 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_44_in_expression264 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression268 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_33_in_expression286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression290 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression294 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_22_in_expression308 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression312 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_31_in_expression330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression334 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_32_in_expression352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression356 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression360 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_expression374 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression378 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression382 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_expression396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression400 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression404 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_27_in_expression418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression422 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression426 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_28_in_expression440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression444 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression448 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_26_in_expression462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression466 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_29_in_expression484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression488 = new BitSet(new long[]{0x0000100FBCCB5820L});
    public static final BitSet FOLLOW_expression_in_expression492 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_expression506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression510 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATION_in_expression524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_Boolean_in_expression541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_expression554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_expression566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_expression578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_expression590 = new BitSet(new long[]{0x0000000000000002L});

}