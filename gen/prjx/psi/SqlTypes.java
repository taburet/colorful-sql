// This is a generated file. Not intended for manual editing.
package prjx.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import prjx.psi.impl.*;

public interface SqlTypes {

  IElementType EXPRESSION = new SqlElementType("EXPRESSION");
  IElementType SIMPLE_EXPR = new SqlElementType("SIMPLE_EXPR");

  IElementType LITERAL = new SqlTokenType("LITERAL");
  IElementType LOGICAL = new SqlTokenType("LOGICAL");
  IElementType OPERATOR = new SqlTokenType("OPERATOR");
  IElementType PROPERTY = new SqlTokenType("PROPERTY");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == EXPRESSION) {
        return new SqlExpressionImpl(node);
      }
      else if (type == SIMPLE_EXPR) {
        return new SqlSimpleExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
