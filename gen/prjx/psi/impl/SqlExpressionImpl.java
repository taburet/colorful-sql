// This is a generated file. Not intended for manual editing.
package prjx.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static prjx.psi.SqlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import prjx.psi.*;

public class SqlExpressionImpl extends ASTWrapperPsiElement implements SqlExpression {

  public SqlExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SqlVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SqlVisitor) accept((SqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SqlSimpleExpr> getSimpleExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SqlSimpleExpr.class);
  }

}
