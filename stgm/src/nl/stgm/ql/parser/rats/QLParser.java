// ===========================================================================
// This file has been generated by
// Rats! Parser Generator, version 2.3.1,
// (C) 2004-2012 Robert Grimm,
// on woensdag 16 januari 2013 at 12:50:47.
// Edit at your own risk.
// ===========================================================================

package nl.stgm.ql.parser.rats;

import java.io.Reader;
import java.io.IOException;

import xtc.util.Pair;

import xtc.parser.ParserBase;
import xtc.parser.Column;
import xtc.parser.Result;
import xtc.parser.SemanticValue;
import xtc.parser.ParseError;

import java.util.List;
import java.util.ArrayList;
import xtc.util.Action;
import nl.stgm.ql.ast.*;

/**
 * Packrat parser for grammar <code>nl.stgm.ql.parser.rats.QLParser</code>.
 *
 * <p />This class has been generated by the <i>Rats!</i> parser
 * generator, version 2.3.1, (C) 2004-2012 Robert Grimm.
 */
public final class QLParser extends ParserBase {

  // =========================================================================

  /** Memoization table column. */
  static final class QLParserColumn extends Column {
    Result fExpr;
    Result fRelExpr;
    Result fAddExpr;
    Result fAddExpr$$Star1;
    Result fMulExpr;
    Result fMulExpr$$Star1;
    Result fUnary;
  }

  // =========================================================================

  /**
   * Create a new packrat parser.
   *
   * @param reader The reader.
   * @param file The file name.
   */
  public QLParser(final Reader reader, final String file) {
    super(reader, file);
  }

  /**
   * Create a new packrat parser.
   *
   * @param reader The file reader.
   * @param file The file name.
   * @param size The file size.
   */
  public QLParser(final Reader reader, final String file, final int size) {
    super(reader, file, size);
  }

  // =========================================================================

  protected Column newColumn() {
    return new QLParserColumn();
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLParser.RunParse.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  public Result pRunParse(final int yyStart) throws IOException {
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      yyValue = yyResult.semanticValue();

      return yyResult.createValue(yyValue, yyError);
    }

    // Done.
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.Expr.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pExpr(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fExpr) yyColumn.fExpr = pExpr$1(yyStart);
    return yyColumn.fExpr;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLExpr.Expr. */
  private Result pExpr$1(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pRelExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Expr l = yyResult.semanticValue();

      final int yyChoice1 = yyResult.index;

      // Nested alternative 1.

      yyC = character(yyChoice1);
      if (-1 != yyC) {
        yyIndex = yyChoice1 + 1;

        switch (yyC) {
        case '&':
          {
            yyC = character(yyIndex);
            if (-1 != yyC) {
              yyIndex = yyIndex + 1;
              if ('&' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pRelExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new And(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }
          }
          break;

        case '|':
          {
            yyC = character(yyIndex);
            if (-1 != yyC) {
              yyIndex = yyIndex + 1;
              if ('|' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pRelExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new Or(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }
          }
          break;

        default:
          /* No match. */
        }
      }
    }

    // Alternative 2.

    yyResult = pRelExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      yyValue = yyResult.semanticValue();

      return yyResult.createValue(yyValue, yyError);
    }

    // Done.
    yyError = yyError.select("expr expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.RelExpr.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pRelExpr(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fRelExpr) yyColumn.fRelExpr = pRelExpr$1(yyStart);
    return yyColumn.fRelExpr;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLExpr.RelExpr. */
  private Result pRelExpr$1(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pAddExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Expr l = yyResult.semanticValue();

      final int yyChoice1 = yyResult.index;

      // Nested alternative 1.

      yyC = character(yyChoice1);
      if (-1 != yyC) {
        yyIndex = yyChoice1 + 1;

        switch (yyC) {
        case '<':
          {
            final int yyChoice2 = yyIndex;

            // Nested alternative 1.

            yyC = character(yyChoice2);
            if (-1 != yyC) {
              yyIndex = yyChoice2 + 1;
              if ('=' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pAddExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new LEq(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }

            // Nested alternative 2.

            yyResult = pSpacing(yyChoice2);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {

              yyResult = pAddExpr(yyResult.index);
              yyError  = yyResult.select(yyError);
              if (yyResult.hasValue()) {
                Expr r = yyResult.semanticValue();

                yyValue = new LT(l, r);

                return yyResult.createValue(yyValue, yyError);
              }
            }
          }
          break;

        case '>':
          {
            final int yyChoice2 = yyIndex;

            // Nested alternative 1.

            yyC = character(yyChoice2);
            if (-1 != yyC) {
              yyIndex = yyChoice2 + 1;
              if ('=' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pAddExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new GEq(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }

            // Nested alternative 2.

            yyResult = pSpacing(yyChoice2);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {

              yyResult = pAddExpr(yyResult.index);
              yyError  = yyResult.select(yyError);
              if (yyResult.hasValue()) {
                Expr r = yyResult.semanticValue();

                yyValue = new GT(l, r);

                return yyResult.createValue(yyValue, yyError);
              }
            }
          }
          break;

        case '=':
          {
            yyC = character(yyIndex);
            if (-1 != yyC) {
              yyIndex = yyIndex + 1;
              if ('=' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pAddExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new Eq(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }
          }
          break;

        case '!':
          {
            yyC = character(yyIndex);
            if (-1 != yyC) {
              yyIndex = yyIndex + 1;
              if ('=' == yyC) {

                yyResult = pSpacing(yyIndex);
                yyError  = yyResult.select(yyError);
                if (yyResult.hasValue()) {

                  yyResult = pAddExpr(yyResult.index);
                  yyError  = yyResult.select(yyError);
                  if (yyResult.hasValue()) {
                    Expr r = yyResult.semanticValue();

                    yyValue = new NEq(l, r);

                    return yyResult.createValue(yyValue, yyError);
                  }
                }
              }
            }
          }
          break;

        default:
          /* No match. */
        }
      }
    }

    // Alternative 2.

    yyResult = pAddExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      yyValue = yyResult.semanticValue();

      return yyResult.createValue(yyValue, yyError);
    }

    // Done.
    yyError = yyError.select("rel expr expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.AddExpr.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pAddExpr(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fAddExpr) yyColumn.fAddExpr = pAddExpr$1(yyStart);
    return yyColumn.fAddExpr;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLExpr.AddExpr. */
  private Result pAddExpr$1(final int yyStart) throws IOException {
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pMulExpr(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Expr seed = yyResult.semanticValue();

      yyResult = pAddExpr$$Star1(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {
        Pair<Action<Expr>> actions = yyResult.semanticValue();

        yyValue = apply(actions, seed);

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Done.
    return yyError;
  }

  // =========================================================================

  /**
   * Parse synthetic nonterminal 
   * nl.stgm.ql.parser.rats.QLParser.AddExpr$$Star1.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pAddExpr$$Star1(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fAddExpr$$Star1) 
      yyColumn.fAddExpr$$Star1 = pAddExpr$$Star1$1(yyStart);
    return yyColumn.fAddExpr$$Star1;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLParser.AddExpr$$Star1. */
  private Result pAddExpr$$Star1$1(final int yyStart) throws IOException {
    Result             yyResult;
    Pair<Action<Expr>> yyValue;
    ParseError         yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pAddTail(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Action<Expr> v$el$1 = yyResult.semanticValue();

      yyResult = pAddExpr$$Star1(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {
        Pair<Action<Expr>> v$2 = yyResult.semanticValue();

        yyValue = new Pair<Action<Expr>>(v$el$1, v$2);

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Alternative 2.

    yyValue = Pair.empty();

    return new SemanticValue(yyValue, yyStart, yyError);
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.AddTail.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pAddTail(final int yyStart) throws IOException {
    int          yyC;
    int          yyIndex;
    Result       yyResult;
    Action<Expr> yyValue;
    ParseError   yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if (-1 != yyC) {
      yyIndex = yyStart + 1;

      switch (yyC) {
      case '+':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pMulExpr(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              final Expr right = yyResult.semanticValue();

              yyValue = new Action<Expr>() {
                public Expr run(Expr left) {
                  return new Add(left, right);
                }
              };

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      case '-':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pMulExpr(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              final Expr right = yyResult.semanticValue();

              yyValue = new Action<Expr>() {
                public Expr run(Expr left) {
                  return new Sub(left, right);
                }
              };

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      default:
        /* No match. */
      }
    }

    // Done.
    yyError = yyError.select("add tail expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.MulExpr.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pMulExpr(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fMulExpr) yyColumn.fMulExpr = pMulExpr$1(yyStart);
    return yyColumn.fMulExpr;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLExpr.MulExpr. */
  private Result pMulExpr$1(final int yyStart) throws IOException {
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pUnary(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Expr seed = yyResult.semanticValue();

      yyResult = pMulExpr$$Star1(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {
        Pair<Action<Expr>> actions = yyResult.semanticValue();

        yyValue = apply(actions, seed);

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Done.
    return yyError;
  }

  // =========================================================================

  /**
   * Parse synthetic nonterminal 
   * nl.stgm.ql.parser.rats.QLParser.MulExpr$$Star1.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pMulExpr$$Star1(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fMulExpr$$Star1) 
      yyColumn.fMulExpr$$Star1 = pMulExpr$$Star1$1(yyStart);
    return yyColumn.fMulExpr$$Star1;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLParser.MulExpr$$Star1. */
  private Result pMulExpr$$Star1$1(final int yyStart) throws IOException {
    Result             yyResult;
    Pair<Action<Expr>> yyValue;
    ParseError         yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pMulTail(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      Action<Expr> v$el$1 = yyResult.semanticValue();

      yyResult = pMulExpr$$Star1(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {
        Pair<Action<Expr>> v$2 = yyResult.semanticValue();

        yyValue = new Pair<Action<Expr>>(v$el$1, v$2);

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Alternative 2.

    yyValue = Pair.empty();

    return new SemanticValue(yyValue, yyStart, yyError);
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.MulTail.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pMulTail(final int yyStart) throws IOException {
    int          yyC;
    int          yyIndex;
    Result       yyResult;
    Action<Expr> yyValue;
    ParseError   yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if (-1 != yyC) {
      yyIndex = yyStart + 1;

      switch (yyC) {
      case '*':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pUnary(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              final Expr right = yyResult.semanticValue();

              yyValue = new Action<Expr>() {
                public Expr run(Expr left) {
                  return new Mul(left, right);
                }
              };

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      case '/':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pUnary(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              final Expr right = yyResult.semanticValue();

              yyValue = new Action<Expr>() {
                public Expr run(Expr left) {
                  return new Div(left, right);
                }
              };

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      default:
        /* No match. */
      }
    }

    // Done.
    yyError = yyError.select("mul tail expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.Unary.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pUnary(final int yyStart) throws IOException {
    QLParserColumn yyColumn = (QLParserColumn)column(yyStart);
    if (null == yyColumn.fUnary) yyColumn.fUnary = pUnary$1(yyStart);
    return yyColumn.fUnary;
  }

  /** Actually parse nl.stgm.ql.parser.rats.QLExpr.Unary. */
  private Result pUnary$1(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if (-1 != yyC) {
      yyIndex = yyStart + 1;

      switch (yyC) {
      case '+':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pUnary(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              Expr un = yyResult.semanticValue();

              yyValue = new Pos(un);

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      case '-':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pUnary(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              Expr un = yyResult.semanticValue();

              yyValue = new Neg(un);

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      case '!':
        {
          yyResult = pSpacing(yyIndex);
          yyError  = yyResult.select(yyError);
          if (yyResult.hasValue()) {

            yyResult = pUnary(yyResult.index);
            yyError  = yyResult.select(yyError);
            if (yyResult.hasValue()) {
              Expr un = yyResult.semanticValue();

              yyValue = new Not(un);

              return yyResult.createValue(yyValue, yyError);
            }
          }
        }
        break;

      default:
        /* No match. */
      }
    }

    // Alternative 2.

    yyResult = pPrimary(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      yyValue = yyResult.semanticValue();

      return yyResult.createValue(yyValue, yyError);
    }

    // Done.
    yyError = yyError.select("unary expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLExpr.Primary.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pPrimary(final int yyStart) throws IOException {
    Result     yyResult;
    Expr       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyResult = pInt(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      String n = yyResult.semanticValue();

      yyResult = pSpacing(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {

        yyValue = new Int(Integer.parseInt(n));

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Alternative 2.

    yyResult = pIdent(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {
      String x = yyResult.semanticValue();

      yyResult = pSpacing(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {

        yyValue = new Ident(x);

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Alternative 3.

    yyResult = pLParen(yyStart);
    yyError  = yyResult.select(yyError);
    if (yyResult.hasValue()) {

      yyResult = pExpr(yyResult.index);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {
        yyValue = yyResult.semanticValue();

        yyResult = pRParen(yyResult.index);
        yyError  = yyResult.select(yyError);
        if (yyResult.hasValue()) {

          return yyResult.createValue(yyValue, yyError);
        }
      }
    }

    // Done.
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLUtil.Int.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pInt(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    int        yyRepetition1;
    boolean    yyRepeated1;
    String     yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyRepetition1 = yyStart;
    yyRepeated1   = false;
    while (true) {

      yyC = character(yyRepetition1);
      if (-1 != yyC) {
        yyIndex = yyRepetition1 + 1;

        switch (yyC) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
          {
            yyRepetition1 = yyIndex;
            yyRepeated1   = true;
            continue;
          }

        default:
          /* No match. */
        }
      }
      break;
    }

    if (yyRepeated1) {

      yyValue = difference(yyStart, yyRepetition1);

      return new SemanticValue(yyValue, yyRepetition1, yyError);
    }

    // Done.
    yyError = yyError.select("int expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLUtil.Ident.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pIdent(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    int        yyRepetition1;
    String     yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if (-1 != yyC) {
      yyIndex = yyStart + 1;
      if ((('A' <= yyC) && (yyC <= 'Z')) ||
          ('_' == yyC) ||
          (('a' <= yyC) && (yyC <= 'z'))) {

        yyRepetition1 = yyIndex;
        while (true) {

          yyC = character(yyRepetition1);
          if (-1 != yyC) {
            yyIndex = yyRepetition1 + 1;
            if ((('0' <= yyC) && (yyC <= '9')) ||
                (('A' <= yyC) && (yyC <= 'Z')) ||
                ('_' == yyC) ||
                (('a' <= yyC) && (yyC <= 'z'))) {

              yyRepetition1 = yyIndex;
              continue;
            }
          }
          break;
        }

        yyValue = difference(yyStart, yyRepetition1);

        return new SemanticValue(yyValue, yyRepetition1, yyError);
      }
    }

    // Done.
    yyError = yyError.select("ident expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLUtil.LParen.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pLParen(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    Result     yyResult;
    Void       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if ('(' == yyC) {
      yyIndex = yyStart + 1;

      yyResult = pSpacing(yyIndex);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {

        yyValue = null;

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Done.
    yyError = yyError.select("l paren expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLUtil.RParen.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pRParen(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    Result     yyResult;
    Void       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyC = character(yyStart);
    if (')' == yyC) {
      yyIndex = yyStart + 1;

      yyResult = pSpacing(yyIndex);
      yyError  = yyResult.select(yyError);
      if (yyResult.hasValue()) {

        yyValue = null;

        return yyResult.createValue(yyValue, yyError);
      }
    }

    // Done.
    yyError = yyError.select("r paren expected", yyStart);
    return yyError;
  }

  // =========================================================================

  /**
   * Parse nonterminal nl.stgm.ql.parser.rats.QLUtil.Spacing.
   *
   * @param yyStart The index.
   * @return The result.
   * @throws IOException Signals an I/O error.
   */
  private Result pSpacing(final int yyStart) throws IOException {
    int        yyC;
    int        yyIndex;
    boolean    yyPredMatched;
    int        yyBase;
    int        yyRepetition1;
    int        yyRepetition2;
    Void       yyValue;
    ParseError yyError = ParseError.DUMMY;

    // Alternative 1.

    yyRepetition1 = yyStart;
    while (true) {

      final int yyChoice1 = yyRepetition1;

      // Nested alternative 1.

      yyC = character(yyChoice1);
      if (-1 != yyC) {
        yyIndex = yyChoice1 + 1;

        switch (yyC) {
        case ' ':
          {
            yyRepetition1 = yyIndex;
            continue;
          }

        case '\t':
          {
            yyRepetition1 = yyIndex;
            continue;
          }

        case '\f':
          {
            yyRepetition1 = yyIndex;
            continue;
          }

        case '\r':
          {
            final int yyChoice2 = yyIndex;

            // Nested alternative 1.

            yyC = character(yyChoice2);
            if ('\n' == yyC) {
              yyIndex = yyChoice2 + 1;

              yyRepetition1 = yyIndex;
              continue;
            }

            // Nested alternative 2.

            yyRepetition1 = yyChoice2;
            continue;
          }

        case '\n':
          {
            yyRepetition1 = yyIndex;
            continue;
          }

        case '/':
          {
            yyC = character(yyIndex);
            if (-1 != yyC) {
              yyIndex = yyIndex + 1;
              if ('*' == yyC) {

                yyRepetition2 = yyIndex;
                while (true) {

                  final int yyChoice2 = yyRepetition2;

                  // Nested alternative 1.

                  yyC = character(yyChoice2);
                  if (-1 != yyC) {
                    yyIndex = yyChoice2 + 1;

                    switch (yyC) {
                    case '*':
                      {
                        yyPredMatched = false;

                        yyC = character(yyIndex);
                        if ('/' == yyC) {

                          yyPredMatched = true;
                        }

                        if (! yyPredMatched) {

                          yyRepetition2 = yyIndex;
                          continue;
                        } else {
                          yyError = yyError.select("spacing expected", yyStart);
                        }
                      }
                      break;

                    default:
                      {
                        yyRepetition2 = yyIndex;
                        continue;
                      }
                    }
                  }
                  break;
                }

                yyBase = yyRepetition2;
                yyC    = character(yyBase);
                if ('*' == yyC) {
                  yyIndex = yyRepetition2 + 1;

                  yyC = character(yyIndex);
                  if ('/' == yyC) {
                    yyIndex = yyIndex + 1;

                    yyRepetition1 = yyIndex;
                    continue;
                  } else {
                    yyError = yyError.select("'*/' expected", yyBase);
                  }
                } else {
                  yyError = yyError.select("'*/' expected", yyBase);
                }
              }
            }
          }
          break;

        default:
          /* No match. */
        }
      }
      break;
    }

    yyValue = null;

    return new SemanticValue(yyValue, yyRepetition1, yyError);
  }

}
