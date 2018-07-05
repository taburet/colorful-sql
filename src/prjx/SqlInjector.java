package prjx;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiExpressionList;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.PsiNewExpression;
import org.jetbrains.annotations.NotNull;

public class SqlInjector implements LanguageInjector {

    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces places) {
        if (!(host instanceof PsiLiteralExpression)) {
            return;
        }

        if (!(host.getParent() instanceof PsiExpressionList)) {
            return;
        }

        if (!(host.getParent().getParent() instanceof PsiNewExpression)) {
            return;
        }

        PsiNewExpression newExpression = (PsiNewExpression) host.getParent().getParent();
        if (newExpression.getType() == null) {
            return;
        }
        if (!"com.hazelcast.query.SqlPredicate".equals(newExpression.getType().getCanonicalText())) {
            return;
        }

        PsiLiteralExpression literalExpression = (PsiLiteralExpression) host;
        if (literalExpression.getType() == null) {
            return;
        }
        if (!"java.lang.String".equals(literalExpression.getType().getCanonicalText())) {
            return;
        }

        String text = (String) literalExpression.getValue();
        places.addPlace(SqlLanguage.INSTANCE, new TextRange(1, host.getTextLength() - 1), null, null);
    }

}
