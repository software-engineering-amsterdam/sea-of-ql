// $ANTLR 3.4 src/main/org/uva/sea/ql/parser/QL.g 2013-01-28 13:45:26

	package org.uva.sea.ql.parser;
	import org.uva.sea.ql.parser.exception.ParserException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[42+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "src/main/org/uva/sea/ql/parser/QL.g"; }


    	@Override
    	public void reportError(RecognitionException e)
    	{
    		super.reportError(e);
    		throw new ParserException(e.getMessage());
    	}


    public static class form_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "form"
    // src/main/org/uva/sea/ql/parser/QL.g:45:1: form : 'form' Identifier '{' block '}' -> ^( FORM Identifier ^( BLOCK block ) ) ;
    public final QLParser.form_return form() throws RecognitionException {
        QLParser.form_return retval = new QLParser.form_return();
        retval.start = input.LT(1);

        int form_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal1=null;
        Token Identifier2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        QLParser.block_return block4 =null;


        CommonTree string_literal1_tree=null;
        CommonTree Identifier2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:46:2: ( 'form' Identifier '{' block '}' -> ^( FORM Identifier ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:46:4: 'form' Identifier '{' block '}'
            {
            string_literal1=(Token)match(input,39,FOLLOW_39_in_form147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_39.add(string_literal1);


            Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_form149); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(Identifier2);


            char_literal3=(Token)match(input,44,FOLLOW_44_in_form151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal3);


            pushFollow(FOLLOW_block_in_form153);
            block4=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block4.getTree());

            char_literal5=(Token)match(input,46,FOLLOW_46_in_form155); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal5);


            // AST REWRITE
            // elements: Identifier, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 46:36: -> ^( FORM Identifier ^( BLOCK block ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:46:39: ^( FORM Identifier ^( BLOCK block ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FORM, "FORM")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                // src/main/org/uva/sea/ql/parser/QL.g:46:57: ^( BLOCK block )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_2);

                adaptor.addChild(root_2, stream_block.nextTree());

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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "form"


    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // src/main/org/uva/sea/ql/parser/QL.g:49:1: block : ( statement )* ;
    public final QLParser.block_return block() throws RecognitionException {
        QLParser.block_return retval = new QLParser.block_return();
        retval.start = input.LT(1);

        int block_StartIndex = input.index();

        CommonTree root_0 = null;

        QLParser.statement_return statement6 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:50:5: ( ( statement )* )
            // src/main/org/uva/sea/ql/parser/QL.g:50:9: ( statement )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // src/main/org/uva/sea/ql/parser/QL.g:50:9: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Identifier||LA1_0==40) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:50:9: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block185);
            	    statement6=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement6.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, block_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "block"


    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // src/main/org/uva/sea/ql/parser/QL.g:53:1: statement : ( ifStatement | assignmentStatement );
    public final QLParser.statement_return statement() throws RecognitionException {
        QLParser.statement_return retval = new QLParser.statement_return();
        retval.start = input.LT(1);

        int statement_StartIndex = input.index();

        CommonTree root_0 = null;

        QLParser.ifStatement_return ifStatement7 =null;

        QLParser.assignmentStatement_return assignmentStatement8 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:54:2: ( ifStatement | assignmentStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==40) ) {
                alt2=1;
            }
            else if ( (LA2_0==Identifier) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:54:4: ifStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_statement200);
                    ifStatement7=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement7.getTree());

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:55:5: assignmentStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assignmentStatement_in_statement206);
                    assignmentStatement8=assignmentStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentStatement8.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class ifStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // src/main/org/uva/sea/ql/parser/QL.g:58:1: ifStatement : ifStat ( elseIfStat )* ( elseStat )? -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) ;
    public final QLParser.ifStatement_return ifStatement() throws RecognitionException {
        QLParser.ifStatement_return retval = new QLParser.ifStatement_return();
        retval.start = input.LT(1);

        int ifStatement_StartIndex = input.index();

        CommonTree root_0 = null;

        QLParser.ifStat_return ifStat9 =null;

        QLParser.elseIfStat_return elseIfStat10 =null;

        QLParser.elseStat_return elseStat11 =null;


        RewriteRuleSubtreeStream stream_elseIfStat=new RewriteRuleSubtreeStream(adaptor,"rule elseIfStat");
        RewriteRuleSubtreeStream stream_ifStat=new RewriteRuleSubtreeStream(adaptor,"rule ifStat");
        RewriteRuleSubtreeStream stream_elseStat=new RewriteRuleSubtreeStream(adaptor,"rule elseStat");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:59:2: ( ifStat ( elseIfStat )* ( elseStat )? -> ^( IF ifStat ( elseIfStat )* ( elseStat )? ) )
            // src/main/org/uva/sea/ql/parser/QL.g:59:6: ifStat ( elseIfStat )* ( elseStat )?
            {
            pushFollow(FOLLOW_ifStat_in_ifStatement219);
            ifStat9=ifStat();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifStat.add(ifStat9.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:59:13: ( elseIfStat )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==38) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==40) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:59:13: elseIfStat
            	    {
            	    pushFollow(FOLLOW_elseIfStat_in_ifStatement221);
            	    elseIfStat10=elseIfStat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elseIfStat.add(elseIfStat10.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // src/main/org/uva/sea/ql/parser/QL.g:59:25: ( elseStat )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==38) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // src/main/org/uva/sea/ql/parser/QL.g:59:25: elseStat
                    {
                    pushFollow(FOLLOW_elseStat_in_ifStatement224);
                    elseStat11=elseStat();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseStat.add(elseStat11.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: ifStat, elseIfStat, elseStat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 59:35: -> ^( IF ifStat ( elseIfStat )* ( elseStat )? )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:59:38: ^( IF ifStat ( elseIfStat )* ( elseStat )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IF, "IF")
                , root_1);

                adaptor.addChild(root_1, stream_ifStat.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:59:50: ( elseIfStat )*
                while ( stream_elseIfStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseIfStat.nextTree());

                }
                stream_elseIfStat.reset();

                // src/main/org/uva/sea/ql/parser/QL.g:59:62: ( elseStat )?
                if ( stream_elseStat.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseStat.nextTree());

                }
                stream_elseStat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, ifStatement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class ifStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStat"
    // src/main/org/uva/sea/ql/parser/QL.g:62:1: ifStat : 'if' expression '{' block '}' -> ^( EXPRESSION expression ^( BLOCK block ) ) ;
    public final QLParser.ifStat_return ifStat() throws RecognitionException {
        QLParser.ifStat_return retval = new QLParser.ifStat_return();
        retval.start = input.LT(1);

        int ifStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal12=null;
        Token char_literal14=null;
        Token char_literal16=null;
        QLParser.expression_return expression13 =null;

        QLParser.block_return block15 =null;


        CommonTree string_literal12_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal16_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:63:5: ( 'if' expression '{' block '}' -> ^( EXPRESSION expression ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:63:9: 'if' expression '{' block '}'
            {
            string_literal12=(Token)match(input,40,FOLLOW_40_in_ifStat255); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(string_literal12);


            pushFollow(FOLLOW_expression_in_ifStat257);
            expression13=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression13.getTree());

            char_literal14=(Token)match(input,44,FOLLOW_44_in_ifStat259); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal14);


            pushFollow(FOLLOW_block_in_ifStat261);
            block15=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block15.getTree());

            char_literal16=(Token)match(input,46,FOLLOW_46_in_ifStat263); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal16);


            // AST REWRITE
            // elements: block, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 63:39: -> ^( EXPRESSION expression ^( BLOCK block ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:63:42: ^( EXPRESSION expression ^( BLOCK block ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:63:66: ^( BLOCK block )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_2);

                adaptor.addChild(root_2, stream_block.nextTree());

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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, ifStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStat"


    public static class elseIfStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseIfStat"
    // src/main/org/uva/sea/ql/parser/QL.g:66:1: elseIfStat : 'else' 'if' expression '{' block '}' -> ^( EXPRESSION expression ^( BLOCK block ) ) ;
    public final QLParser.elseIfStat_return elseIfStat() throws RecognitionException {
        QLParser.elseIfStat_return retval = new QLParser.elseIfStat_return();
        retval.start = input.LT(1);

        int elseIfStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal17=null;
        Token string_literal18=null;
        Token char_literal20=null;
        Token char_literal22=null;
        QLParser.expression_return expression19 =null;

        QLParser.block_return block21 =null;


        CommonTree string_literal17_tree=null;
        CommonTree string_literal18_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal22_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:67:5: ( 'else' 'if' expression '{' block '}' -> ^( EXPRESSION expression ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:67:9: 'else' 'if' expression '{' block '}'
            {
            string_literal17=(Token)match(input,38,FOLLOW_38_in_elseIfStat296); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(string_literal17);


            string_literal18=(Token)match(input,40,FOLLOW_40_in_elseIfStat298); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(string_literal18);


            pushFollow(FOLLOW_expression_in_elseIfStat300);
            expression19=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expression.add(expression19.getTree());

            char_literal20=(Token)match(input,44,FOLLOW_44_in_elseIfStat302); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal20);


            pushFollow(FOLLOW_block_in_elseIfStat304);
            block21=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block21.getTree());

            char_literal22=(Token)match(input,46,FOLLOW_46_in_elseIfStat306); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal22);


            // AST REWRITE
            // elements: block, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 67:46: -> ^( EXPRESSION expression ^( BLOCK block ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:67:49: ^( EXPRESSION expression ^( BLOCK block ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());

                // src/main/org/uva/sea/ql/parser/QL.g:67:73: ^( BLOCK block )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_2);

                adaptor.addChild(root_2, stream_block.nextTree());

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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, elseIfStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elseIfStat"


    public static class elseStat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseStat"
    // src/main/org/uva/sea/ql/parser/QL.g:70:1: elseStat : 'else' '{' block '}' -> ^( EXPRESSION ^( BLOCK block ) ) ;
    public final QLParser.elseStat_return elseStat() throws RecognitionException {
        QLParser.elseStat_return retval = new QLParser.elseStat_return();
        retval.start = input.LT(1);

        int elseStat_StartIndex = input.index();

        CommonTree root_0 = null;

        Token string_literal23=null;
        Token char_literal24=null;
        Token char_literal26=null;
        QLParser.block_return block25 =null;


        CommonTree string_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal26_tree=null;
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:71:5: ( 'else' '{' block '}' -> ^( EXPRESSION ^( BLOCK block ) ) )
            // src/main/org/uva/sea/ql/parser/QL.g:71:9: 'else' '{' block '}'
            {
            string_literal23=(Token)match(input,38,FOLLOW_38_in_elseStat339); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_38.add(string_literal23);


            char_literal24=(Token)match(input,44,FOLLOW_44_in_elseStat341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_44.add(char_literal24);


            pushFollow(FOLLOW_block_in_elseStat343);
            block25=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block25.getTree());

            char_literal26=(Token)match(input,46,FOLLOW_46_in_elseStat345); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_46.add(char_literal26);


            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 71:30: -> ^( EXPRESSION ^( BLOCK block ) )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:71:33: ^( EXPRESSION ^( BLOCK block ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(EXPRESSION, "EXPRESSION")
                , root_1);

                // src/main/org/uva/sea/ql/parser/QL.g:71:46: ^( BLOCK block )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_2);

                adaptor.addChild(root_2, stream_block.nextTree());

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

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, elseStat_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "elseStat"


    public static class assignmentStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentStatement"
    // src/main/org/uva/sea/ql/parser/QL.g:74:1: assignmentStatement : Identifier ':' StringLiteral type -> ^( ASSIGNMENT Identifier type ) ;
    public final QLParser.assignmentStatement_return assignmentStatement() throws RecognitionException {
        QLParser.assignmentStatement_return retval = new QLParser.assignmentStatement_return();
        retval.start = input.LT(1);

        int assignmentStatement_StartIndex = input.index();

        CommonTree root_0 = null;

        Token Identifier27=null;
        Token char_literal28=null;
        Token StringLiteral29=null;
        QLParser.type_return type30 =null;


        CommonTree Identifier27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree StringLiteral29_tree=null;
        RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:75:2: ( Identifier ':' StringLiteral type -> ^( ASSIGNMENT Identifier type ) )
            // src/main/org/uva/sea/ql/parser/QL.g:75:4: Identifier ':' StringLiteral type
            {
            Identifier27=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignmentStatement371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(Identifier27);


            char_literal28=(Token)match(input,31,FOLLOW_31_in_assignmentStatement373); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_31.add(char_literal28);


            StringLiteral29=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_assignmentStatement375); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_StringLiteral.add(StringLiteral29);


            pushFollow(FOLLOW_type_in_assignmentStatement377);
            type30=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_type.add(type30.getTree());

            // AST REWRITE
            // elements: Identifier, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 75:38: -> ^( ASSIGNMENT Identifier type )
            {
                // src/main/org/uva/sea/ql/parser/QL.g:75:41: ^( ASSIGNMENT Identifier type )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNMENT, "ASSIGNMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, assignmentStatement_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assignmentStatement"


    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // src/main/org/uva/sea/ql/parser/QL.g:78:1: type : ( 'boolean' | 'integer' | 'string' | 'money' );
    public final QLParser.type_return type() throws RecognitionException {
        QLParser.type_return retval = new QLParser.type_return();
        retval.start = input.LT(1);

        int type_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set31=null;

        CommonTree set31_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:79:2: ( 'boolean' | 'integer' | 'string' | 'money' )
            // src/main/org/uva/sea/ql/parser/QL.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set31=(Token)input.LT(1);

            if ( input.LA(1)==37||(input.LA(1) >= 41 && input.LA(1) <= 43) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set31)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, type_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "type"


    public static class terminal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "terminal"
    // src/main/org/uva/sea/ql/parser/QL.g:85:1: terminal : ( Boolean | Integer | StringLiteral | Money | Identifier | '(' ! expression ')' !);
    public final QLParser.terminal_return terminal() throws RecognitionException {
        QLParser.terminal_return retval = new QLParser.terminal_return();
        retval.start = input.LT(1);

        int terminal_StartIndex = input.index();

        CommonTree root_0 = null;

        Token Boolean32=null;
        Token Integer33=null;
        Token StringLiteral34=null;
        Token Money35=null;
        Token Identifier36=null;
        Token char_literal37=null;
        Token char_literal39=null;
        QLParser.expression_return expression38 =null;


        CommonTree Boolean32_tree=null;
        CommonTree Integer33_tree=null;
        CommonTree StringLiteral34_tree=null;
        CommonTree Money35_tree=null;
        CommonTree Identifier36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:86:2: ( Boolean | Integer | StringLiteral | Money | Identifier | '(' ! expression ')' !)
            int alt5=6;
            switch ( input.LA(1) ) {
            case Boolean:
                {
                alt5=1;
                }
                break;
            case Integer:
                {
                alt5=2;
                }
                break;
            case StringLiteral:
                {
                alt5=3;
                }
                break;
            case Money:
                {
                alt5=4;
                }
                break;
            case Identifier:
                {
                alt5=5;
                }
                break;
            case 25:
                {
                alt5=6;
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
                    // src/main/org/uva/sea/ql/parser/QL.g:86:6: Boolean
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Boolean32=(Token)match(input,Boolean,FOLLOW_Boolean_in_terminal429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Boolean32_tree = 
                    (CommonTree)adaptor.create(Boolean32)
                    ;
                    adaptor.addChild(root_0, Boolean32_tree);
                    }

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:87:4: Integer
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Integer33=(Token)match(input,Integer,FOLLOW_Integer_in_terminal434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Integer33_tree = 
                    (CommonTree)adaptor.create(Integer33)
                    ;
                    adaptor.addChild(root_0, Integer33_tree);
                    }

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QL.g:88:6: StringLiteral
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    StringLiteral34=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_terminal441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral34_tree = 
                    (CommonTree)adaptor.create(StringLiteral34)
                    ;
                    adaptor.addChild(root_0, StringLiteral34_tree);
                    }

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QL.g:89:6: Money
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Money35=(Token)match(input,Money,FOLLOW_Money_in_terminal448); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Money35_tree = 
                    (CommonTree)adaptor.create(Money35)
                    ;
                    adaptor.addChild(root_0, Money35_tree);
                    }

                    }
                    break;
                case 5 :
                    // src/main/org/uva/sea/ql/parser/QL.g:90:4: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Identifier36=(Token)match(input,Identifier,FOLLOW_Identifier_in_terminal453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier36_tree = 
                    (CommonTree)adaptor.create(Identifier36)
                    ;
                    adaptor.addChild(root_0, Identifier36_tree);
                    }

                    }
                    break;
                case 6 :
                    // src/main/org/uva/sea/ql/parser/QL.g:91:4: '(' ! expression ')' !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal37=(Token)match(input,25,FOLLOW_25_in_terminal458); if (state.failed) return retval;

                    pushFollow(FOLLOW_expression_in_terminal461);
                    expression38=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression38.getTree());

                    char_literal39=(Token)match(input,26,FOLLOW_26_in_terminal463); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, terminal_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "terminal"


    public static class unary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary"
    // src/main/org/uva/sea/ql/parser/QL.g:94:1: unary : ( '!' terminal -> ^( NOT terminal ) | '-' terminal -> ^( NEGATION terminal ) | '+' ! terminal | terminal );
    public final QLParser.unary_return unary() throws RecognitionException {
        QLParser.unary_return retval = new QLParser.unary_return();
        retval.start = input.LT(1);

        int unary_StartIndex = input.index();

        CommonTree root_0 = null;

        Token char_literal40=null;
        Token char_literal42=null;
        Token char_literal44=null;
        QLParser.terminal_return terminal41 =null;

        QLParser.terminal_return terminal43 =null;

        QLParser.terminal_return terminal45 =null;

        QLParser.terminal_return terminal46 =null;


        CommonTree char_literal40_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal44_tree=null;
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
        RewriteRuleSubtreeStream stream_terminal=new RewriteRuleSubtreeStream(adaptor,"rule terminal");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:95:2: ( '!' terminal -> ^( NOT terminal ) | '-' terminal -> ^( NEGATION terminal ) | '+' ! terminal | terminal )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt6=1;
                }
                break;
            case 29:
                {
                alt6=2;
                }
                break;
            case 28:
                {
                alt6=3;
                }
                break;
            case Boolean:
            case Identifier:
            case Integer:
            case Money:
            case StringLiteral:
            case 25:
                {
                alt6=4;
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
                    // src/main/org/uva/sea/ql/parser/QL.g:95:6: '!' terminal
                    {
                    char_literal40=(Token)match(input,22,FOLLOW_22_in_unary477); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_22.add(char_literal40);


                    pushFollow(FOLLOW_terminal_in_unary479);
                    terminal41=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_terminal.add(terminal41.getTree());

                    // AST REWRITE
                    // elements: terminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 95:19: -> ^( NOT terminal )
                    {
                        // src/main/org/uva/sea/ql/parser/QL.g:95:22: ^( NOT terminal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NOT, "NOT")
                        , root_1);

                        adaptor.addChild(root_1, stream_terminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // src/main/org/uva/sea/ql/parser/QL.g:96:6: '-' terminal
                    {
                    char_literal42=(Token)match(input,29,FOLLOW_29_in_unary494); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_29.add(char_literal42);


                    pushFollow(FOLLOW_terminal_in_unary496);
                    terminal43=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_terminal.add(terminal43.getTree());

                    // AST REWRITE
                    // elements: terminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 96:19: -> ^( NEGATION terminal )
                    {
                        // src/main/org/uva/sea/ql/parser/QL.g:96:22: ^( NEGATION terminal )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NEGATION, "NEGATION")
                        , root_1);

                        adaptor.addChild(root_1, stream_terminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // src/main/org/uva/sea/ql/parser/QL.g:97:6: '+' ! terminal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal44=(Token)match(input,28,FOLLOW_28_in_unary511); if (state.failed) return retval;

                    pushFollow(FOLLOW_terminal_in_unary514);
                    terminal45=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal45.getTree());

                    }
                    break;
                case 4 :
                    // src/main/org/uva/sea/ql/parser/QL.g:98:6: terminal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_terminal_in_unary521);
                    terminal46=terminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, terminal46.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, unary_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "unary"


    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // src/main/org/uva/sea/ql/parser/QL.g:101:1: mult : unary ( ( '*' | '/' ) ^ unary )* ;
    public final QLParser.mult_return mult() throws RecognitionException {
        QLParser.mult_return retval = new QLParser.mult_return();
        retval.start = input.LT(1);

        int mult_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set48=null;
        QLParser.unary_return unary47 =null;

        QLParser.unary_return unary49 =null;


        CommonTree set48_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:102:2: ( unary ( ( '*' | '/' ) ^ unary )* )
            // src/main/org/uva/sea/ql/parser/QL.g:102:4: unary ( ( '*' | '/' ) ^ unary )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_in_mult532);
            unary47=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary47.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:102:10: ( ( '*' | '/' ) ^ unary )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==27||LA7_0==30) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:102:11: ( '*' | '/' ) ^ unary
            	    {
            	    set48=(Token)input.LT(1);

            	    set48=(Token)input.LT(1);

            	    if ( input.LA(1)==27||input.LA(1)==30 ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set48)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unary_in_mult544);
            	    unary49=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary49.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, mult_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "mult"


    public static class add_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // src/main/org/uva/sea/ql/parser/QL.g:105:1: add : mult ( ( '+' | '-' ) ^ mult )* ;
    public final QLParser.add_return add() throws RecognitionException {
        QLParser.add_return retval = new QLParser.add_return();
        retval.start = input.LT(1);

        int add_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set51=null;
        QLParser.mult_return mult50 =null;

        QLParser.mult_return mult52 =null;


        CommonTree set51_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:106:2: ( mult ( ( '+' | '-' ) ^ mult )* )
            // src/main/org/uva/sea/ql/parser/QL.g:106:4: mult ( ( '+' | '-' ) ^ mult )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_in_add557);
            mult50=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult50.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:106:9: ( ( '+' | '-' ) ^ mult )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 28 && LA8_0 <= 29)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:106:10: ( '+' | '-' ) ^ mult
            	    {
            	    set51=(Token)input.LT(1);

            	    set51=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 28 && input.LA(1) <= 29) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set51)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mult_in_add569);
            	    mult52=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult52.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, add_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "add"


    public static class relation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relation"
    // src/main/org/uva/sea/ql/parser/QL.g:109:1: relation : add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )* ;
    public final QLParser.relation_return relation() throws RecognitionException {
        QLParser.relation_return retval = new QLParser.relation_return();
        retval.start = input.LT(1);

        int relation_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set54=null;
        QLParser.add_return add53 =null;

        QLParser.add_return add55 =null;


        CommonTree set54_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:110:2: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )* )
            // src/main/org/uva/sea/ql/parser/QL.g:110:4: add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_add_in_relation582);
            add53=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add53.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:110:8: ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==23||(LA9_0 >= 32 && LA9_0 <= 36)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:110:9: ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) ^ add
            	    {
            	    set54=(Token)input.LT(1);

            	    set54=(Token)input.LT(1);

            	    if ( input.LA(1)==23||(input.LA(1) >= 32 && input.LA(1) <= 36) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set54)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_add_in_relation610);
            	    add55=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add55.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, relation_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "relation"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // src/main/org/uva/sea/ql/parser/QL.g:113:1: expression : relation ( ( '&&' | '||' ) ^ relation )* ;
    public final QLParser.expression_return expression() throws RecognitionException {
        QLParser.expression_return retval = new QLParser.expression_return();
        retval.start = input.LT(1);

        int expression_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set57=null;
        QLParser.relation_return relation56 =null;

        QLParser.relation_return relation58 =null;


        CommonTree set57_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // src/main/org/uva/sea/ql/parser/QL.g:114:2: ( relation ( ( '&&' | '||' ) ^ relation )* )
            // src/main/org/uva/sea/ql/parser/QL.g:114:4: relation ( ( '&&' | '||' ) ^ relation )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_relation_in_expression623);
            relation56=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relation56.getTree());

            // src/main/org/uva/sea/ql/parser/QL.g:114:13: ( ( '&&' | '||' ) ^ relation )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==24||LA10_0==45) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/main/org/uva/sea/ql/parser/QL.g:114:14: ( '&&' | '||' ) ^ relation
            	    {
            	    set57=(Token)input.LT(1);

            	    set57=(Token)input.LT(1);

            	    if ( input.LA(1)==24||input.LA(1)==45 ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set57)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_relation_in_expression635);
            	    relation58=relation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relation58.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, expression_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_39_in_form147 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_Identifier_in_form149 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_form151 = new BitSet(new long[]{0x0000410000001000L});
    public static final BitSet FOLLOW_block_in_form153 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_form155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block185 = new BitSet(new long[]{0x0000010000001002L});
    public static final BitSet FOLLOW_ifStatement_in_statement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_statement206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStat_in_ifStatement219 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_elseIfStat_in_ifStatement221 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_elseStat_in_ifStatement224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ifStat255 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_expression_in_ifStat257 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ifStat259 = new BitSet(new long[]{0x0000410000001000L});
    public static final BitSet FOLLOW_block_in_ifStat261 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ifStat263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_elseIfStat296 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_elseIfStat298 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_expression_in_elseIfStat300 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_elseIfStat302 = new BitSet(new long[]{0x0000410000001000L});
    public static final BitSet FOLLOW_block_in_elseIfStat304 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_elseIfStat306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_elseStat339 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_elseStat341 = new BitSet(new long[]{0x0000410000001000L});
    public static final BitSet FOLLOW_block_in_elseStat343 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_elseStat345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignmentStatement371 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assignmentStatement373 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_StringLiteral_in_assignmentStatement375 = new BitSet(new long[]{0x00000E2000000000L});
    public static final BitSet FOLLOW_type_in_assignmentStatement377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_in_terminal429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_terminal434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_terminal441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_terminal448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_terminal453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_terminal458 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_expression_in_terminal461 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_terminal463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_unary477 = new BitSet(new long[]{0x000000000210B040L});
    public static final BitSet FOLLOW_terminal_in_unary479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_unary494 = new BitSet(new long[]{0x000000000210B040L});
    public static final BitSet FOLLOW_terminal_in_unary496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_unary511 = new BitSet(new long[]{0x000000000210B040L});
    public static final BitSet FOLLOW_terminal_in_unary514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_unary521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult532 = new BitSet(new long[]{0x0000000048000002L});
    public static final BitSet FOLLOW_set_in_mult535 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_unary_in_mult544 = new BitSet(new long[]{0x0000000048000002L});
    public static final BitSet FOLLOW_mult_in_add557 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_set_in_add560 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_mult_in_add569 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_add_in_relation582 = new BitSet(new long[]{0x0000001F00800002L});
    public static final BitSet FOLLOW_set_in_relation585 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_add_in_relation610 = new BitSet(new long[]{0x0000001F00800002L});
    public static final BitSet FOLLOW_relation_in_expression623 = new BitSet(new long[]{0x0000200001000002L});
    public static final BitSet FOLLOW_set_in_expression626 = new BitSet(new long[]{0x000000003250B040L});
    public static final BitSet FOLLOW_relation_in_expression635 = new BitSet(new long[]{0x0000200001000002L});

}