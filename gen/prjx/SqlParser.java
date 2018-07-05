// This is a generated file. Not intended for manual editing.
package prjx;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static prjx.psi.SqlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SqlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == SIMPLE_EXPR) {
      r = simpleExpr(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return sqlFile(b, l + 1);
  }

  /* ********************************************************** */
  // simpleExpr (LOGICAL simpleExpr)*
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    if (!nextTokenIs(b, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleExpr(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, m, EXPRESSION, r);
    return r;
  }

  // (LOGICAL simpleExpr)*
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expression_1", c)) break;
    }
    return true;
  }

  // LOGICAL simpleExpr
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL);
    r = r && simpleExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROPERTY OPERATOR LITERAL
  public static boolean simpleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpr")) return false;
    if (!nextTokenIs(b, PROPERTY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTY, OPERATOR, LITERAL);
    exit_section_(b, m, SIMPLE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  static boolean sqlFile(PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

}
