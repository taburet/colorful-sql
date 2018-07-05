// This is a generated file. Not intended for manual editing.
package prjx.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SqlVisitor extends PsiElementVisitor {

  public void visitExpression(@NotNull SqlExpression o) {
    visitPsiElement(o);
  }

  public void visitSimpleExpr(@NotNull SqlSimpleExpr o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
